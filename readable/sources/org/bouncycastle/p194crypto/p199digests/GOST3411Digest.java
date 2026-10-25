package org.bouncycastle.p194crypto.p199digests;

import java.lang.reflect.Array;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.p201engines.GOST28147Engine;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithSBox;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Memoable;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class GOST3411Digest implements ExtendedDigest, Memoable {

    /* renamed from: C2 */
    private static final byte[] f19356C2 = {0, -1, 0, -1, 0, -1, 0, -1, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 0, -1};
    private static final int DIGEST_LENGTH = 32;

    /* renamed from: C */
    private byte[][] f19357C;

    /* renamed from: H */
    private byte[] f19358H;

    /* renamed from: K */
    private byte[] f19359K;

    /* renamed from: L */
    private byte[] f19360L;

    /* renamed from: M */
    private byte[] f19361M;

    /* renamed from: S */
    byte[] f19362S;

    /* renamed from: Sum */
    private byte[] f19363Sum;

    /* renamed from: U */
    byte[] f19364U;

    /* renamed from: V */
    byte[] f19365V;

    /* renamed from: W */
    byte[] f19366W;

    /* renamed from: a */
    byte[] f19367a;
    private long byteCount;

    /* renamed from: cipher */
    private BlockCipher f19368cipher;

    /* renamed from: purpose */
    private final CryptoServicePurpose f19369purpose;

    /* renamed from: sBox */
    private byte[] f19370sBox;

    /* renamed from: wS */
    short[] f19371wS;

    /* renamed from: w_S */
    short[] f19372w_S;

    /* renamed from: xBuf */
    private byte[] f19373xBuf;

    /* renamed from: xBufOff */
    private int f19374xBufOff;

    public GOST3411Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: A */
    private byte[] m15065A(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            this.f19367a[i] = (byte) (bArr[i] ^ bArr[i + 8]);
        }
        System.arraycopy(bArr, 8, bArr, 0, 24);
        System.arraycopy(this.f19367a, 0, bArr, 24, 8);
        return bArr;
    }

    /* renamed from: E */
    private void m15066E(byte[] bArr, byte[] bArr2, int i, byte[] bArr3, int i2) {
        this.f19368cipher.mo14946init(true, new KeyParameter(bArr));
        this.f19368cipher.processBlock(bArr3, i2, bArr2, i);
    }

    /* renamed from: P */
    private byte[] m15067P(byte[] bArr) {
        for (int i = 0; i < 8; i++) {
            byte[] bArr2 = this.f19359K;
            int i2 = i * 4;
            bArr2[i2] = bArr[i];
            bArr2[i2 + 1] = bArr[i + 8];
            bArr2[i2 + 2] = bArr[i + 16];
            bArr2[i2 + 3] = bArr[i + 24];
        }
        return this.f19359K;
    }

    private void cpyBytesToShort(byte[] bArr, short[] sArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            int i2 = i * 2;
            sArr[i] = (short) ((bArr[i2] & C1126UByte.MAX_VALUE) | ((bArr[i2 + 1] << 8) & 65280));
        }
    }

    private void cpyShortToBytes(short[] sArr, byte[] bArr) {
        for (int i = 0; i < bArr.length / 2; i++) {
            int i2 = i * 2;
            short s = sArr[i];
            bArr[i2 + 1] = (byte) (s >> 8);
            bArr[i2] = (byte) s;
        }
    }

    /* renamed from: finish */
    private void m15068finish() {
        AbstractC6245Pack.longToLittleEndian(this.byteCount * 8, this.f19360L, 0);
        while (this.f19374xBufOff != 0) {
            mo14969update((byte) 0);
        }
        processBlock(this.f19360L, 0);
        processBlock(this.f19363Sum, 0);
    }

    /* renamed from: fw */
    private void m15069fw(byte[] bArr) {
        cpyBytesToShort(bArr, this.f19371wS);
        short[] sArr = this.f19372w_S;
        short[] sArr2 = this.f19371wS;
        sArr[15] = (short) (((((sArr2[0] ^ sArr2[1]) ^ sArr2[2]) ^ sArr2[3]) ^ sArr2[12]) ^ sArr2[15]);
        System.arraycopy(sArr2, 1, sArr, 0, 15);
        cpyShortToBytes(this.f19372w_S, bArr);
    }

    private void sumByteArray(byte[] bArr) {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f19363Sum;
            if (i == bArr2.length) {
                return;
            }
            int i3 = (bArr2[i] & C1126UByte.MAX_VALUE) + (bArr[i] & C1126UByte.MAX_VALUE) + i2;
            bArr2[i] = (byte) i3;
            i2 = i3 >>> 8;
            i++;
        }
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new GOST3411Digest(this);
    }

    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, 256, this.f19369purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15068finish();
        byte[] bArr2 = this.f19358H;
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        mo14968reset();
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "GOST3411";
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 32;
    }

    public void processBlock(byte[] bArr, int i) {
        System.arraycopy(bArr, i, this.f19361M, 0, 32);
        System.arraycopy(this.f19358H, 0, this.f19364U, 0, 32);
        System.arraycopy(this.f19361M, 0, this.f19365V, 0, 32);
        for (int i2 = 0; i2 < 32; i2++) {
            this.f19366W[i2] = (byte) (this.f19364U[i2] ^ this.f19365V[i2]);
        }
        m15066E(m15067P(this.f19366W), this.f19362S, 0, this.f19358H, 0);
        for (int i3 = 1; i3 < 4; i3++) {
            byte[] bArrM15065A = m15065A(this.f19364U);
            for (int i4 = 0; i4 < 32; i4++) {
                this.f19364U[i4] = (byte) (bArrM15065A[i4] ^ this.f19357C[i3][i4]);
            }
            this.f19365V = m15065A(m15065A(this.f19365V));
            for (int i5 = 0; i5 < 32; i5++) {
                this.f19366W[i5] = (byte) (this.f19364U[i5] ^ this.f19365V[i5]);
            }
            int i6 = i3 * 8;
            m15066E(m15067P(this.f19366W), this.f19362S, i6, this.f19358H, i6);
        }
        for (int i7 = 0; i7 < 12; i7++) {
            m15069fw(this.f19362S);
        }
        for (int i8 = 0; i8 < 32; i8++) {
            byte[] bArr2 = this.f19362S;
            bArr2[i8] = (byte) (bArr2[i8] ^ this.f19361M[i8]);
        }
        m15069fw(this.f19362S);
        for (int i9 = 0; i9 < 32; i9++) {
            byte[] bArr3 = this.f19362S;
            bArr3[i9] = (byte) (this.f19358H[i9] ^ bArr3[i9]);
        }
        for (int i10 = 0; i10 < 61; i10++) {
            m15069fw(this.f19362S);
        }
        byte[] bArr4 = this.f19362S;
        byte[] bArr5 = this.f19358H;
        System.arraycopy(bArr4, 0, bArr5, 0, bArr5.length);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.byteCount = 0L;
        this.f19374xBufOff = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f19358H;
            if (i >= bArr.length) {
                break;
            }
            bArr[i] = 0;
            i++;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f19360L;
            if (i2 >= bArr2.length) {
                break;
            }
            bArr2[i2] = 0;
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.f19361M;
            if (i3 >= bArr3.length) {
                break;
            }
            bArr3[i3] = 0;
            i3++;
        }
        int i4 = 0;
        while (true) {
            byte[] bArr4 = this.f19357C[1];
            if (i4 >= bArr4.length) {
                break;
            }
            bArr4[i4] = 0;
            i4++;
        }
        int i5 = 0;
        while (true) {
            byte[] bArr5 = this.f19357C[3];
            if (i5 >= bArr5.length) {
                break;
            }
            bArr5[i5] = 0;
            i5++;
        }
        int i6 = 0;
        while (true) {
            byte[] bArr6 = this.f19363Sum;
            if (i6 >= bArr6.length) {
                break;
            }
            bArr6[i6] = 0;
            i6++;
        }
        int i7 = 0;
        while (true) {
            byte[] bArr7 = this.f19373xBuf;
            if (i7 >= bArr7.length) {
                byte[] bArr8 = f19356C2;
                System.arraycopy(bArr8, 0, this.f19357C[2], 0, bArr8.length);
                return;
            } else {
                bArr7[i7] = 0;
                i7++;
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        byte[] bArr = this.f19373xBuf;
        int i = this.f19374xBufOff;
        int i2 = i + 1;
        this.f19374xBufOff = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            sumByteArray(bArr);
            processBlock(this.f19373xBuf, 0);
            this.f19374xBufOff = 0;
        }
        this.byteCount++;
    }

    public GOST3411Digest(CryptoServicePurpose cryptoServicePurpose) {
        this.f19358H = new byte[32];
        this.f19360L = new byte[32];
        this.f19361M = new byte[32];
        this.f19363Sum = new byte[32];
        this.f19357C = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 32);
        this.f19373xBuf = new byte[32];
        this.f19368cipher = new GOST28147Engine();
        this.f19359K = new byte[32];
        this.f19367a = new byte[8];
        this.f19371wS = new short[16];
        this.f19372w_S = new short[16];
        this.f19362S = new byte[32];
        this.f19364U = new byte[32];
        this.f19365V = new byte[32];
        this.f19366W = new byte[32];
        this.f19369purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        byte[] bArrM15311getSBox = GOST28147Engine.m15311getSBox("D-A");
        this.f19370sBox = bArrM15311getSBox;
        this.f19368cipher.mo14946init(true, new ParametersWithSBox(null, bArrM15311getSBox));
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        GOST3411Digest gOST3411Digest = (GOST3411Digest) memoable;
        byte[] bArr = gOST3411Digest.f19370sBox;
        this.f19370sBox = bArr;
        this.f19368cipher.mo14946init(true, new ParametersWithSBox(null, bArr));
        mo14968reset();
        byte[] bArr2 = gOST3411Digest.f19358H;
        System.arraycopy(bArr2, 0, this.f19358H, 0, bArr2.length);
        byte[] bArr3 = gOST3411Digest.f19360L;
        System.arraycopy(bArr3, 0, this.f19360L, 0, bArr3.length);
        byte[] bArr4 = gOST3411Digest.f19361M;
        System.arraycopy(bArr4, 0, this.f19361M, 0, bArr4.length);
        byte[] bArr5 = gOST3411Digest.f19363Sum;
        System.arraycopy(bArr5, 0, this.f19363Sum, 0, bArr5.length);
        byte[] bArr6 = gOST3411Digest.f19357C[1];
        System.arraycopy(bArr6, 0, this.f19357C[1], 0, bArr6.length);
        byte[] bArr7 = gOST3411Digest.f19357C[2];
        System.arraycopy(bArr7, 0, this.f19357C[2], 0, bArr7.length);
        byte[] bArr8 = gOST3411Digest.f19357C[3];
        System.arraycopy(bArr8, 0, this.f19357C[3], 0, bArr8.length);
        byte[] bArr9 = gOST3411Digest.f19373xBuf;
        System.arraycopy(bArr9, 0, this.f19373xBuf, 0, bArr9.length);
        this.f19374xBufOff = gOST3411Digest.f19374xBufOff;
        this.byteCount = gOST3411Digest.byteCount;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        while (this.f19374xBufOff != 0 && i2 > 0) {
            mo14969update(bArr[i]);
            i++;
            i2--;
        }
        while (true) {
            byte[] bArr2 = this.f19373xBuf;
            if (i2 < bArr2.length) {
                break;
            }
            System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
            sumByteArray(this.f19373xBuf);
            processBlock(this.f19373xBuf, 0);
            byte[] bArr3 = this.f19373xBuf;
            i += bArr3.length;
            i2 -= bArr3.length;
            this.byteCount += bArr3.length;
        }
        while (i2 > 0) {
            mo14969update(bArr[i]);
            i++;
            i2--;
        }
    }

    public GOST3411Digest(GOST3411Digest gOST3411Digest) {
        this.f19358H = new byte[32];
        this.f19360L = new byte[32];
        this.f19361M = new byte[32];
        this.f19363Sum = new byte[32];
        this.f19357C = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 32);
        this.f19373xBuf = new byte[32];
        this.f19368cipher = new GOST28147Engine();
        this.f19359K = new byte[32];
        this.f19367a = new byte[8];
        this.f19371wS = new short[16];
        this.f19372w_S = new short[16];
        this.f19362S = new byte[32];
        this.f19364U = new byte[32];
        this.f19365V = new byte[32];
        this.f19366W = new byte[32];
        this.f19369purpose = gOST3411Digest.f19369purpose;
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        mo14824reset(gOST3411Digest);
    }

    public GOST3411Digest(byte[] bArr) {
        this(bArr, CryptoServicePurpose.ANY);
    }

    public GOST3411Digest(byte[] bArr, CryptoServicePurpose cryptoServicePurpose) {
        this.f19358H = new byte[32];
        this.f19360L = new byte[32];
        this.f19361M = new byte[32];
        this.f19363Sum = new byte[32];
        this.f19357C = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, 4, 32);
        this.f19373xBuf = new byte[32];
        this.f19368cipher = new GOST28147Engine();
        this.f19359K = new byte[32];
        this.f19367a = new byte[8];
        this.f19371wS = new short[16];
        this.f19372w_S = new short[16];
        this.f19362S = new byte[32];
        this.f19364U = new byte[32];
        this.f19365V = new byte[32];
        this.f19366W = new byte[32];
        this.f19369purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        byte[] bArrM18231clone = C6238Arrays.m18231clone(bArr);
        this.f19370sBox = bArrM18231clone;
        this.f19368cipher.mo14946init(true, new ParametersWithSBox(null, bArrM18231clone));
        mo14968reset();
    }
}
