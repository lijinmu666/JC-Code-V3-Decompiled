package org.bouncycastle.p194crypto.p210modes;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p201engines.ChaCha7539Engine;
import org.bouncycastle.p194crypto.p209macs.Poly1305;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6243Longs;

/* loaded from: classes2.dex */
public class ChaCha20Poly1305 implements AEADCipher {
    private static final long AAD_LIMIT = -1;
    private static final int BUF_SIZE = 64;
    private static final long DATA_LIMIT = 274877906880L;
    private static final int KEY_SIZE = 32;
    private static final int MAC_SIZE = 16;
    private static final int NONCE_SIZE = 12;

    /* renamed from: ZEROES */
    private static final byte[] f20526ZEROES = new byte[15];
    private long aadCount;

    /* renamed from: buf */
    private final byte[] f20527buf;

    /* renamed from: bufPos */
    private int f20528bufPos;
    private final ChaCha7539Engine chacha20;
    private long dataCount;
    private byte[] initialAAD;

    /* renamed from: key */
    private final byte[] f20529key;

    /* renamed from: mac */
    private final byte[] f20530mac;

    /* renamed from: nonce */
    private final byte[] f20531nonce;
    private final InterfaceC5278Mac poly1305;

    /* renamed from: state */
    private int f20532state;

    /* renamed from: org.bouncycastle.crypto.modes.ChaCha20Poly1305$State */
    public static final class C5367State {

        /* renamed from: DEC_AAD */
        static final int f20533DEC_AAD = 6;
        static final int DEC_DATA = 7;
        static final int DEC_FINAL = 8;
        static final int DEC_INIT = 5;

        /* renamed from: ENC_AAD */
        static final int f20534ENC_AAD = 2;
        static final int ENC_DATA = 3;
        static final int ENC_FINAL = 4;
        static final int ENC_INIT = 1;
        static final int UNINITIALIZED = 0;

        private C5367State() {
        }
    }

    public ChaCha20Poly1305() {
        this(new Poly1305());
    }

    private void checkAAD() {
        int i = this.f20532state;
        int i2 = 2;
        if (i != 1) {
            if (i == 2) {
                return;
            }
            if (i == 4) {
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            }
            i2 = 6;
            if (i != 5) {
                if (i != 6) {
                    throw new IllegalStateException();
                }
                return;
            }
        }
        this.f20532state = i2;
    }

    private void checkData() {
        int i;
        switch (this.f20532state) {
            case 1:
            case 2:
                i = 3;
                break;
            case 3:
            case 7:
                return;
            case 4:
                throw new IllegalStateException("ChaCha20Poly1305 cannot be reused for encryption");
            case 5:
            case 6:
                i = 7;
                break;
            default:
                throw new IllegalStateException();
        }
        finishAAD(i);
    }

    private void finishAAD(int i) {
        m15595padMAC(this.aadCount);
        this.f20532state = i;
    }

    private void finishData(int i) {
        m15595padMAC(this.dataCount);
        byte[] bArr = new byte[16];
        AbstractC6245Pack.longToLittleEndian(this.aadCount, bArr, 0);
        AbstractC6245Pack.longToLittleEndian(this.dataCount, bArr, 8);
        this.poly1305.mo14979update(bArr, 0, 16);
        this.poly1305.mo14975doFinal(this.f20530mac, 0);
        this.f20532state = i;
    }

    private long incrementCount(long j, int i, long j2) {
        long j3 = i;
        if (C6243Longs.compareUnsigned(j, j2 - j3) <= 0) {
            return j + j3;
        }
        throw new IllegalStateException("Limit exceeded");
    }

    /* renamed from: initMAC */
    private void m15594initMAC() {
        byte[] bArr = new byte[64];
        try {
            this.chacha20.processBytes(bArr, 0, 64, bArr, 0);
            this.poly1305.mo14976init(new KeyParameter(bArr, 0, 32));
        } finally {
            C6238Arrays.m18227clear(bArr);
        }
    }

    /* renamed from: padMAC */
    private void m15595padMAC(long j) {
        int i = ((int) j) & 15;
        if (i != 0) {
            this.poly1305.mo14979update(f20526ZEROES, 0, 16 - i);
        }
    }

    private void processData(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i3 > bArr2.length - i2) {
            throw new OutputLengthException("Output buffer too short");
        }
        this.chacha20.processBytes(bArr, i, i2, bArr2, i3);
        this.dataCount = incrementCount(this.dataCount, i2, DATA_LIMIT);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public int mo15224doFinal(byte[] bArr, int i) throws InvalidCipherTextException {
        int i2;
        if (bArr == null) {
            throw new NullPointerException("'out' cannot be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("'outOff' cannot be negative");
        }
        checkData();
        C6238Arrays.m18227clear(this.f20530mac);
        int i3 = this.f20532state;
        if (i3 == 3) {
            int i4 = this.f20528bufPos;
            i2 = i4 + 16;
            if (i > bArr.length - i2) {
                throw new OutputLengthException("Output buffer too short");
            }
            if (i4 > 0) {
                processData(this.f20527buf, 0, i4, bArr, i);
                this.poly1305.mo14979update(bArr, i, this.f20528bufPos);
            }
            finishData(4);
            System.arraycopy(this.f20530mac, 0, bArr, i + this.f20528bufPos, 16);
        } else {
            if (i3 != 7) {
                throw new IllegalStateException();
            }
            int i5 = this.f20528bufPos;
            if (i5 < 16) {
                throw new InvalidCipherTextException("data too short");
            }
            i2 = i5 - 16;
            if (i > bArr.length - i2) {
                throw new OutputLengthException("Output buffer too short");
            }
            if (i2 > 0) {
                this.poly1305.mo14979update(this.f20527buf, 0, i2);
                processData(this.f20527buf, 0, i2, bArr, i);
            }
            finishData(8);
            if (!C6238Arrays.constantTimeAreEqual(16, this.f20530mac, 0, this.f20527buf, i2)) {
                throw new InvalidCipherTextException("mac check in ChaCha20Poly1305 failed");
            }
        }
        m15596reset(false, true);
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public String getAlgorithmName() {
        return "ChaCha20Poly1305";
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public byte[] mo15225getMac() {
        return C6238Arrays.m18231clone(this.f20530mac);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        int iMax = Math.max(0, i) + this.f20528bufPos;
        int i2 = this.f20532state;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return iMax + 16;
        }
        if (i2 == 5 || i2 == 6 || i2 == 7) {
            return Math.max(0, iMax - 16);
        }
        throw new IllegalStateException();
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        int iMax = Math.max(0, i) + this.f20528bufPos;
        int i2 = this.f20532state;
        if (i2 != 1 && i2 != 2 && i2 != 3) {
            if (i2 != 5 && i2 != 6 && i2 != 7) {
                throw new IllegalStateException();
            }
            iMax = Math.max(0, iMax - 16);
        }
        return iMax - (iMax % 64);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public void mo15226init(boolean z, CipherParameters cipherParameters) {
        ParametersWithIV parametersWithIV;
        KeyParameter keyParameterM15664getKey;
        byte[] bArrM15801getIV;
        if (cipherParameters instanceof AEADParameters) {
            AEADParameters aEADParameters = (AEADParameters) cipherParameters;
            int macSize = aEADParameters.getMacSize();
            if (128 != macSize) {
                throw new IllegalArgumentException("Invalid value for MAC size: " + macSize);
            }
            keyParameterM15664getKey = aEADParameters.m15664getKey();
            bArrM15801getIV = aEADParameters.getNonce();
            parametersWithIV = new ParametersWithIV(keyParameterM15664getKey, bArrM15801getIV);
            this.initialAAD = aEADParameters.getAssociatedText();
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameters passed to ChaCha20Poly1305");
            }
            parametersWithIV = (ParametersWithIV) cipherParameters;
            keyParameterM15664getKey = (KeyParameter) parametersWithIV.getParameters();
            bArrM15801getIV = parametersWithIV.m15801getIV();
            this.initialAAD = null;
        }
        if (keyParameterM15664getKey == null) {
            if (this.f20532state == 0) {
                throw new IllegalArgumentException("Key must be specified in initial init");
            }
        } else if (32 != keyParameterM15664getKey.getKeyLength()) {
            throw new IllegalArgumentException("Key must be 256 bits");
        }
        if (bArrM15801getIV == null || 12 != bArrM15801getIV.length) {
            throw new IllegalArgumentException("Nonce must be 96 bits");
        }
        if (this.f20532state != 0 && z && C6238Arrays.areEqual(this.f20531nonce, bArrM15801getIV) && (keyParameterM15664getKey == null || C6238Arrays.areEqual(this.f20529key, keyParameterM15664getKey.m15773getKey()))) {
            throw new IllegalArgumentException("cannot reuse nonce for ChaCha20Poly1305 encryption");
        }
        if (keyParameterM15664getKey != null) {
            keyParameterM15664getKey.m15772copyTo(this.f20529key, 0, 32);
        }
        System.arraycopy(bArrM15801getIV, 0, this.f20531nonce, 0, 12);
        this.chacha20.mo14993init(true, parametersWithIV);
        this.f20532state = z ? 1 : 5;
        m15596reset(true, false);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADByte(byte b) {
        checkAAD();
        this.aadCount = incrementCount(this.aadCount, 1, -1L);
        this.poly1305.mo14978update(b);
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public void processAADBytes(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new NullPointerException("'in' cannot be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("'inOff' cannot be negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        }
        if (i > bArr.length - i2) {
            throw new DataLengthException("Input buffer too short");
        }
        checkAAD();
        if (i2 > 0) {
            this.aadCount = incrementCount(this.aadCount, i2, -1L);
            this.poly1305.mo14979update(bArr, i, i2);
        }
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int processByte(byte b, byte[] bArr, int i) {
        checkData();
        int i2 = this.f20532state;
        if (i2 == 3) {
            byte[] bArr2 = this.f20527buf;
            int i3 = this.f20528bufPos;
            bArr2[i3] = b;
            int i4 = i3 + 1;
            this.f20528bufPos = i4;
            if (i4 != 64) {
                return 0;
            }
            processData(bArr2, 0, 64, bArr, i);
            this.poly1305.mo14979update(bArr, i, 64);
            this.f20528bufPos = 0;
            return 64;
        }
        if (i2 != 7) {
            throw new IllegalStateException();
        }
        byte[] bArr3 = this.f20527buf;
        int i5 = this.f20528bufPos;
        bArr3[i5] = b;
        int i6 = i5 + 1;
        this.f20528bufPos = i6;
        if (i6 != bArr3.length) {
            return 0;
        }
        this.poly1305.mo14979update(bArr3, 0, 64);
        processData(this.f20527buf, 0, 64, bArr, i);
        byte[] bArr4 = this.f20527buf;
        System.arraycopy(bArr4, 64, bArr4, 0, 16);
        this.f20528bufPos = 16;
        return 64;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00ab A[LOOP:2: B:35:0x00a9->B:36:0x00ab, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7  */
    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        byte[] bArr3;
        int i4;
        int i5;
        int i6 = i2;
        if (bArr == null) {
            throw new NullPointerException("'in' cannot be null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("'inOff' cannot be negative");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("'len' cannot be negative");
        }
        if (i > bArr.length - i6) {
            throw new DataLengthException("Input buffer too short");
        }
        if (i3 < 0) {
            throw new IllegalArgumentException("'outOff' cannot be negative");
        }
        if (bArr == bArr2 && C6238Arrays.segmentsOverlap(i, i6, i3, getUpdateOutputSize(i6))) {
            byte[] bArr4 = new byte[i6];
            System.arraycopy(bArr2, i, bArr4, 0, i6);
            bArr3 = bArr4;
            i4 = 0;
        } else {
            bArr3 = bArr;
            i4 = i;
        }
        checkData();
        int i7 = this.f20532state;
        if (i7 != 3) {
            if (i7 != 7) {
                throw new IllegalStateException();
            }
            i5 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                byte[] bArr5 = this.f20527buf;
                int i9 = this.f20528bufPos;
                bArr5[i9] = bArr3[i4 + i8];
                int i10 = i9 + 1;
                this.f20528bufPos = i10;
                if (i10 == bArr5.length) {
                    this.poly1305.mo14979update(bArr5, 0, 64);
                    processData(this.f20527buf, 0, 64, bArr2, i3 + i5);
                    byte[] bArr6 = this.f20527buf;
                    System.arraycopy(bArr6, 64, bArr6, 0, 16);
                    this.f20528bufPos = 16;
                    i5 += 64;
                }
            }
        } else if (this.f20528bufPos != 0) {
            while (i6 > 0) {
                i6--;
                byte[] bArr7 = this.f20527buf;
                int i11 = this.f20528bufPos;
                int i12 = i4 + 1;
                bArr7[i11] = bArr3[i4];
                int i13 = i11 + 1;
                this.f20528bufPos = i13;
                if (i13 == 64) {
                    processData(bArr7, 0, 64, bArr2, i3);
                    this.poly1305.mo14979update(bArr2, i3, 64);
                    this.f20528bufPos = 0;
                    i5 = 64;
                    i4 = i12;
                    break;
                }
                i4 = i12;
            }
            i5 = 0;
            while (i6 >= 64) {
                int i14 = i3 + i5;
                processData(bArr3, i4, 64, bArr2, i14);
                this.poly1305.mo14979update(bArr2, i14, 64);
                i4 += 64;
                i6 -= 64;
                i5 += 64;
            }
            if (i6 > 0) {
                System.arraycopy(bArr3, i4, this.f20527buf, 0, i6);
                this.f20528bufPos = i6;
            }
        } else {
            i5 = 0;
            while (i6 >= 64) {
            }
            if (i6 > 0) {
            }
        }
        return i5;
    }

    @Override // org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public void mo15228reset() {
        m15596reset(true, true);
    }

    public ChaCha20Poly1305(InterfaceC5278Mac interfaceC5278Mac) {
        this.f20529key = new byte[32];
        this.f20531nonce = new byte[12];
        this.f20527buf = new byte[80];
        this.f20530mac = new byte[16];
        this.f20532state = 0;
        if (interfaceC5278Mac == null) {
            throw new NullPointerException("'poly1305' cannot be null");
        }
        if (16 != interfaceC5278Mac.getMacSize()) {
            throw new IllegalArgumentException("'poly1305' must be a 128-bit MAC");
        }
        this.chacha20 = new ChaCha7539Engine();
        this.poly1305 = interfaceC5278Mac;
    }

    /* renamed from: reset */
    private void m15596reset(boolean z, boolean z2) {
        C6238Arrays.m18227clear(this.f20527buf);
        if (z) {
            C6238Arrays.m18227clear(this.f20530mac);
        }
        this.aadCount = 0L;
        this.dataCount = 0L;
        this.f20528bufPos = 0;
        switch (this.f20532state) {
            case 1:
            case 5:
                break;
            case 2:
            case 3:
            case 4:
                this.f20532state = 4;
                return;
            case 6:
            case 7:
            case 8:
                this.f20532state = 5;
                break;
            default:
                throw new IllegalStateException();
        }
        if (z2) {
            this.chacha20.mo14994reset();
        }
        m15594initMAC();
        byte[] bArr = this.initialAAD;
        if (bArr != null) {
            processAADBytes(bArr, 0, bArr.length);
        }
    }
}
