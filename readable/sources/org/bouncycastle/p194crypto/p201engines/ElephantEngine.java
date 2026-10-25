package org.bouncycastle.p194crypto.p201engines;

import java.util.Arrays;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p201engines.AEADBaseEngine;
import org.bouncycastle.p194crypto.p217signers.PSSSigner;
import org.bouncycastle.p361util.C6240Bytes;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class ElephantEngine extends AEADBaseEngine {

    /* renamed from: ad */
    private byte[] f19842ad;

    /* renamed from: adOff */
    private int f19843adOff;

    /* renamed from: adlen */
    private int f19844adlen;

    /* renamed from: buffer */
    private final byte[] f19845buffer;
    private byte[] current_mask;
    private byte[] expanded_key;
    private final Permutation instance;

    /* renamed from: nb_its */
    private int f19846nb_its;
    private byte[] next_mask;

    /* renamed from: npub */
    private byte[] f19847npub;
    private byte[] previous_mask;
    private final byte[] previous_outputMessage;
    private final byte[] tag_buffer;

    public class Delirium implements Permutation {

        /* renamed from: nRounds */
        private static final int f19848nRounds = 18;
        private final int[] KeccakRhoOffsets;
        private final byte[] KeccakRoundConstants;

        private Delirium() {
            this.KeccakRoundConstants = new byte[]{1, -126, -118, 0, -117, 1, -127, 9, -118, -120, 9, 10, -117, -117, -119, 3, 2, ByteCompanionObject.MIN_VALUE};
            this.KeccakRhoOffsets = new int[]{0, 1, 6, 4, 3, 4, 4, 6, 7, 4, 3, 2, 3, 1, 7, 1, 5, 7, 5, 0, 2, 2, 5, 0, 6};
        }

        private void KeccakP200Round(byte[] bArr, int i) {
            byte[] bArr2 = new byte[25];
            for (int i2 = 0; i2 < 5; i2++) {
                for (int i3 = 0; i3 < 5; i3++) {
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[m15302index(i2, i3)]);
                }
            }
            int i4 = 0;
            while (i4 < 5) {
                int i5 = i4 + 1;
                bArr2[i4 + 5] = (byte) (bArr2[(i4 + 4) % 5] ^ m15301ROL8(bArr2[i5 % 5], 1));
                i4 = i5;
            }
            for (int i6 = 0; i6 < 5; i6++) {
                for (int i7 = 0; i7 < 5; i7++) {
                    int iM15302index = m15302index(i6, i7);
                    bArr[iM15302index] = (byte) (bArr[iM15302index] ^ bArr2[i6 + 5]);
                }
            }
            for (int i8 = 0; i8 < 5; i8++) {
                for (int i9 = 0; i9 < 5; i9++) {
                    bArr2[m15302index(i8, i9)] = m15301ROL8(bArr[m15302index(i8, i9)], this.KeccakRhoOffsets[m15302index(i8, i9)]);
                }
            }
            for (int i10 = 0; i10 < 5; i10++) {
                for (int i11 = 0; i11 < 5; i11++) {
                    bArr[m15302index(i11, ((i10 * 2) + (i11 * 3)) % 5)] = bArr2[m15302index(i10, i11)];
                }
            }
            for (int i12 = 0; i12 < 5; i12++) {
                int i13 = 0;
                while (i13 < 5) {
                    int i14 = i13 + 1;
                    bArr2[i13] = (byte) (bArr[m15302index(i13, i12)] ^ ((~bArr[m15302index(i14 % 5, i12)]) & bArr[m15302index((i13 + 2) % 5, i12)]));
                    i13 = i14;
                }
                for (int i15 = 0; i15 < 5; i15++) {
                    bArr[m15302index(i15, i12)] = bArr2[i15];
                }
            }
            bArr[0] = (byte) (this.KeccakRoundConstants[i] ^ bArr[0]);
        }

        /* renamed from: ROL8 */
        private byte m15301ROL8(byte b, int i) {
            return (byte) ((b << i) | ((b & 255) >>> (8 - i)));
        }

        /* renamed from: index */
        private int m15302index(int i, int i2) {
            return i + (i2 * 5);
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void lfsr_step() {
            byte[] bArr = ElephantEngine.this.next_mask;
            ElephantEngine elephantEngine = ElephantEngine.this;
            int i = elephantEngine.BlockSize - 1;
            byte bM15299rotl = elephantEngine.m15299rotl(elephantEngine.current_mask[0]);
            ElephantEngine elephantEngine2 = ElephantEngine.this;
            bArr[i] = (byte) ((ElephantEngine.this.current_mask[13] << 1) ^ (bM15299rotl ^ elephantEngine2.m15299rotl(elephantEngine2.current_mask[2])));
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void permutation(byte[] bArr) {
            for (int i = 0; i < 18; i++) {
                KeccakP200Round(bArr, i);
            }
        }
    }

    /* renamed from: org.bouncycastle.crypto.engines.ElephantEngine$Dumbo */
    public class C5338Dumbo extends Spongent {
        public C5338Dumbo() {
            super(160, 20, 80, (byte) 117);
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void lfsr_step() {
            ElephantEngine.this.next_mask[r1.BlockSize - 1] = (byte) (((ElephantEngine.this.current_mask[13] & C1126UByte.MAX_VALUE) >>> 7) ^ ((((ElephantEngine.this.current_mask[0] & C1126UByte.MAX_VALUE) << 3) | ((ElephantEngine.this.current_mask[0] & C1126UByte.MAX_VALUE) >>> 5)) ^ ((ElephantEngine.this.current_mask[3] & C1126UByte.MAX_VALUE) << 7)));
        }
    }

    public enum ElephantParameters {
        elephant160,
        elephant176,
        elephant200
    }

    /* renamed from: org.bouncycastle.crypto.engines.ElephantEngine$Jumbo */
    public class C5339Jumbo extends Spongent {
        public C5339Jumbo() {
            super(176, 22, 90, (byte) 69);
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void lfsr_step() {
            byte[] bArr = ElephantEngine.this.next_mask;
            ElephantEngine elephantEngine = ElephantEngine.this;
            bArr[elephantEngine.BlockSize - 1] = (byte) (((ElephantEngine.this.current_mask[19] & C1126UByte.MAX_VALUE) >>> 7) ^ (elephantEngine.m15299rotl(elephantEngine.current_mask[0]) ^ ((ElephantEngine.this.current_mask[3] & C1126UByte.MAX_VALUE) << 7)));
        }
    }

    public interface Permutation {
        void lfsr_step();

        void permutation(byte[] bArr);
    }

    public static abstract class Spongent implements Permutation {

        /* renamed from: lfsrIV */
        private final byte f19853lfsrIV;

        /* renamed from: nBits */
        private final int f19854nBits;

        /* renamed from: nRounds */
        private final int f19855nRounds;

        /* renamed from: nSBox */
        private final int f19856nSBox;
        private final byte[] sBoxLayer = {-18, -19, -21, -32, -30, -31, -28, -17, -25, -22, -24, -27, -23, -20, -29, -26, -34, -35, -37, -48, -46, -47, -44, -33, -41, -38, -40, -43, -39, -36, -45, -42, -66, -67, -69, -80, -78, -79, -76, -65, -73, -70, -72, -75, -71, PSSSigner.TRAILER_IMPLICIT, -77, -74, 14, 13, 11, 0, 2, 1, 4, 15, 7, 10, 8, 5, 9, 12, 3, 6, 46, 45, 43, 32, 34, 33, 36, 47, 39, 42, 40, 37, 41, 44, 35, 38, 30, 29, 27, 16, 18, 17, 20, 31, 23, 26, 24, 21, 25, 28, 19, 22, 78, 77, 75, 64, 66, 65, 68, 79, 71, 74, 72, 69, 73, 76, 67, 70, -2, -3, -5, -16, -14, -15, -12, -1, -9, -6, -8, -11, -7, -4, -13, -10, 126, 125, 123, 112, 114, 113, 116, ByteCompanionObject.MAX_VALUE, 119, 122, 120, 117, 121, 124, 115, 118, -82, -83, -85, -96, -94, -95, -92, -81, -89, -86, -88, -91, -87, -84, -93, -90, -114, -115, -117, ByteCompanionObject.MIN_VALUE, -126, -127, -124, -113, -121, -118, -120, -123, -119, -116, -125, -122, 94, 93, 91, 80, 82, 81, 84, 95, 87, 90, 88, 85, 89, 92, 83, 86, -98, -99, -101, -112, -110, -111, -108, -97, -105, -102, -104, -107, -103, -100, -109, -106, -50, -51, -53, -64, -62, -63, -60, -49, -57, -54, -56, -59, -55, -52, -61, -58, 62, C1217Base64.padSymbol, 59, 48, 50, 49, 52, C5066Utf8.REPLACEMENT_BYTE, 55, 58, 56, 53, 57, 60, 51, 54, 110, 109, 107, 96, 98, 97, 100, 111, 103, 106, 104, 101, 105, 108, 99, 102};

        public Spongent(int i, int i2, int i3, byte b) {
            this.f19855nRounds = i3;
            this.f19856nSBox = i2;
            this.f19853lfsrIV = b;
            this.f19854nBits = i;
        }

        @Override // org.bouncycastle.crypto.engines.ElephantEngine.Permutation
        public void permutation(byte[] bArr) {
            int i;
            byte b = this.f19853lfsrIV;
            byte[] bArr2 = new byte[this.f19856nSBox];
            for (int i2 = 0; i2 < this.f19855nRounds; i2++) {
                bArr[0] = (byte) (bArr[0] ^ b);
                int i3 = this.f19856nSBox - 1;
                int i4 = b & 32;
                int i5 = b & 64;
                bArr[i3] = (byte) (bArr[i3] ^ ((byte) (((((((((b & 1) << 7) | ((b & 2) << 5)) | ((b & 4) << 3)) | ((b & 8) << 1)) | ((b & 16) >>> 1)) | (i4 >>> 3)) | (i5 >>> 5)) | ((b & ByteCompanionObject.MIN_VALUE) >>> 7))));
                b = (byte) (((b << 1) | ((i5 >>> 6) ^ (i4 >>> 5))) & 127);
                for (int i6 = 0; i6 < this.f19856nSBox; i6++) {
                    bArr[i6] = this.sBoxLayer[bArr[i6] & C1126UByte.MAX_VALUE];
                }
                Arrays.fill(bArr2, (byte) 0);
                int i7 = 0;
                while (true) {
                    i = this.f19856nSBox;
                    if (i7 < i) {
                        for (int i8 = 0; i8 < 8; i8++) {
                            int i9 = (i7 << 3) + i8;
                            int i10 = this.f19854nBits;
                            if (i9 != i10 - 1) {
                                i9 = ((i9 * i10) >> 2) % (i10 - 1);
                            }
                            int i11 = i9 >>> 3;
                            bArr2[i11] = (byte) (((((bArr[i7] & C1126UByte.MAX_VALUE) >>> i8) & 1) << (i9 & 7)) ^ bArr2[i11]);
                        }
                        i7++;
                    }
                }
                System.arraycopy(bArr2, 0, bArr, 0, i);
            }
        }
    }

    public ElephantEngine(ElephantParameters elephantParameters) {
        this.KEY_SIZE = 16;
        this.f19650IV_SIZE = 12;
        int iOrdinal = elephantParameters.ordinal();
        if (iOrdinal == 0) {
            this.BlockSize = 20;
            this.instance = new C5338Dumbo();
            this.MAC_SIZE = 8;
            this.algorithmName = "Elephant 160 AEAD";
        } else if (iOrdinal == 1) {
            this.BlockSize = 22;
            this.instance = new C5339Jumbo();
            this.algorithmName = "Elephant 176 AEAD";
            this.MAC_SIZE = 8;
        } else {
            if (iOrdinal != 2) {
                throw new IllegalArgumentException("Invalid parameter settings for Elephant");
            }
            this.BlockSize = 25;
            this.instance = new Delirium();
            this.algorithmName = "Elephant 200 AEAD";
            this.MAC_SIZE = 16;
        }
        int i = this.BlockSize;
        this.tag_buffer = new byte[i];
        this.previous_mask = new byte[i];
        this.current_mask = new byte[i];
        this.next_mask = new byte[i];
        this.f19845buffer = new byte[i];
        this.previous_outputMessage = new byte[i];
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.f19660Stream, AEADBaseEngine.DataOperatorType.f19672Counter);
    }

    private void absorbAAD() {
        processAADBytes(this.f19845buffer);
        C6240Bytes.m18281xorTo(this.BlockSize, this.next_mask, this.f19845buffer);
        this.instance.permutation(this.f19845buffer);
        C6240Bytes.m18281xorTo(this.BlockSize, this.next_mask, this.f19845buffer);
        C6240Bytes.m18281xorTo(this.BlockSize, this.f19845buffer, this.tag_buffer);
    }

    private void absorbCiphertext() {
        m15300xorTo(this.BlockSize, this.previous_mask, this.next_mask, this.f19845buffer);
        this.instance.permutation(this.f19845buffer);
        m15300xorTo(this.BlockSize, this.previous_mask, this.next_mask, this.f19845buffer);
        C6240Bytes.m18281xorTo(this.BlockSize, this.f19845buffer, this.tag_buffer);
    }

    private void computeCipherBlock(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        System.arraycopy(this.f19847npub, 0, this.f19845buffer, 0, this.f19650IV_SIZE);
        Arrays.fill(this.f19845buffer, this.f19650IV_SIZE, this.BlockSize, (byte) 0);
        m15300xorTo(this.BlockSize, this.current_mask, this.next_mask, this.f19845buffer);
        this.instance.permutation(this.f19845buffer);
        m15300xorTo(this.BlockSize, this.current_mask, this.next_mask, this.f19845buffer);
        C6240Bytes.m18279xorTo(i2, bArr, i, this.f19845buffer);
        System.arraycopy(this.f19845buffer, 0, bArr2, i3, i2);
    }

    private void lfsr_step() {
        this.instance.lfsr_step();
        System.arraycopy(this.current_mask, 1, this.next_mask, 0, this.BlockSize - 1);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void processAADBytes(byte[] bArr) {
        int i;
        AEADBaseEngine.C5335State c5335State;
        int i2;
        int i3;
        AEADBaseEngine.C5335State c5335State2;
        int i4 = this.f19653m_state.f19692ord;
        if (i4 != 1) {
            if (i4 == 2) {
                if (this.f19843adOff == this.f19844adlen) {
                    Arrays.fill(bArr, 0, this.BlockSize, (byte) 0);
                    bArr[0] = 1;
                    return;
                }
                i = 0;
            } else if (i4 != 5) {
                if (i4 == 6) {
                }
                i = 0;
            } else {
                System.arraycopy(this.expanded_key, 0, this.current_mask, 0, this.BlockSize);
                System.arraycopy(this.f19847npub, 0, bArr, 0, this.f19650IV_SIZE);
                i = this.f19650IV_SIZE;
                c5335State = AEADBaseEngine.C5335State.f19685DecAad;
            }
            i2 = this.BlockSize - i;
            int i5 = this.f19844adlen;
            int i6 = this.f19843adOff;
            i3 = i5 - i6;
            if (i2 > i3) {
                System.arraycopy(this.f19842ad, i6, bArr, i, i2);
                this.f19843adOff += i2;
                return;
            }
            if (i3 > 0) {
                System.arraycopy(this.f19842ad, i6, bArr, i, i3);
                this.f19843adOff += i3;
            }
            int i7 = i3 + i;
            Arrays.fill(bArr, i7, i + i2, (byte) 0);
            bArr[i7] = 1;
            int i8 = this.f19653m_state.f19692ord;
            if (i8 == 2) {
                c5335State2 = AEADBaseEngine.C5335State.f19690EncData;
            } else if (i8 != 6) {
                return;
            } else {
                c5335State2 = AEADBaseEngine.C5335State.f19686DecData;
            }
            this.f19653m_state = c5335State2;
            return;
        }
        System.arraycopy(this.expanded_key, 0, this.current_mask, 0, this.BlockSize);
        System.arraycopy(this.f19847npub, 0, bArr, 0, this.f19650IV_SIZE);
        i = this.f19650IV_SIZE;
        c5335State = AEADBaseEngine.C5335State.f19689EncAad;
        this.f19653m_state = c5335State;
        i2 = this.BlockSize - i;
        int i52 = this.f19844adlen;
        int i62 = this.f19843adOff;
        i3 = i52 - i62;
        if (i2 > i3) {
        }
    }

    private void processBuffer(byte[] bArr, int i, byte[] bArr2, int i2, AEADBaseEngine.C5335State c5335State) {
        AEADBaseEngine.C5335State c5335State2 = this.f19653m_state;
        if (c5335State2 == AEADBaseEngine.C5335State.f19687DecInit || c5335State2 == AEADBaseEngine.C5335State.f19691EncInit) {
            processFinalAAD();
        }
        lfsr_step();
        computeCipherBlock(bArr, i, this.BlockSize, bArr2, i2);
        if (this.f19846nb_its > 0) {
            System.arraycopy(this.previous_outputMessage, 0, this.f19845buffer, 0, this.BlockSize);
            absorbCiphertext();
        }
        if (this.f19653m_state != c5335State) {
            absorbAAD();
        }
        swapMasks();
        this.f19846nb_its++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: rotl */
    public byte m15299rotl(byte b) {
        return (byte) ((b << 1) | ((b & C1126UByte.MAX_VALUE) >>> 7));
    }

    private void swapMasks() {
        byte[] bArr = this.previous_mask;
        this.previous_mask = this.current_mask;
        this.current_mask = this.next_mask;
        this.next_mask = bArr;
    }

    /* renamed from: xorTo */
    public static void m15300xorTo(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr3[i2] = (byte) (bArr3[i2] ^ (bArr[i2] ^ bArr2[i2]));
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void checkAAD() {
        int i = this.f19653m_state.f19692ord;
        if (i == 3) {
            throw new IllegalArgumentException(this.algorithmName + " cannot process AAD when the length of the ciphertext to be processed exceeds the a block size");
        }
        if (i == 4) {
            throw new IllegalArgumentException(this.algorithmName + " cannot be reused for encryption");
        }
        if (i != 7) {
            return;
        }
        throw new IllegalArgumentException(this.algorithmName + " cannot process AAD when the length of the plaintext to be processed exceeds the a block size");
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public boolean checkData(boolean z) {
        switch (this.f19653m_state.f19692ord) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
                throw new IllegalStateException(getAlgorithmName() + " cannot be reused for encryption");
            case 5:
            case 6:
            case 7:
                return false;
            default:
                throw new IllegalStateException(getAlgorithmName() + " needs to be initialized");
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo15224doFinal(byte[] bArr, int i) {
        return super.mo15224doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.C5335State c5335State, boolean z) {
        finishAAD2(c5335State);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getIVBytesSize() {
        return super.getIVBytesSize();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public /* bridge */ /* synthetic */ int getKeyBytesSize() {
        return super.getKeyBytesSize();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: getMac */
    public /* bridge */ /* synthetic */ byte[] mo15225getMac() {
        return super.mo15225getMac();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getOutputSize(int i) {
        int i2 = this.f19653m_state.f19692ord;
        if (i2 == 0) {
            throw new IllegalArgumentException(this.algorithmName + " needs call init function before getUpdateOutputSize");
        }
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return i + this.m_bufPos + this.MAC_SIZE;
        }
        if (i2 == 4 || i2 == 8) {
            return 0;
        }
        return Math.max(0, (i + this.m_bufPos) - this.MAC_SIZE);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public int getUpdateOutputSize(int i) {
        switch (this.f19653m_state.f19692ord) {
            case 0:
                throw new IllegalArgumentException(this.algorithmName + " needs call init function before getUpdateOutputSize");
            case 1:
            case 2:
            case 3:
                int i2 = this.m_bufPos + i;
                return i2 - (i2 % this.BlockSize);
            case 4:
            case 8:
                return 0;
            case 5:
            case 6:
            case 7:
                int iMax = Math.max(0, (this.m_bufPos + i) - this.MAC_SIZE);
                return iMax - (iMax % this.BlockSize);
            default:
                return Math.max(0, (i + this.m_bufPos) - this.MAC_SIZE);
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: init */
    public /* bridge */ /* synthetic */ void mo15226init(boolean z, CipherParameters cipherParameters) {
        super.mo15226init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADByte(byte b) {
        super.processAADByte(b);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i) {
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBuffer(bArr, i, bArr2, i2, AEADBaseEngine.C5335State.f19686DecData);
        System.arraycopy(bArr, i, this.previous_outputMessage, 0, this.BlockSize);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBuffer(bArr, i, bArr2, i2, AEADBaseEngine.C5335State.f19690EncData);
        System.arraycopy(bArr2, i2, this.previous_outputMessage, 0, this.BlockSize);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int processByte(byte b, byte[] bArr, int i) {
        return super.processByte(b, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        return super.processBytes(bArr, i, i2, bArr2, i3);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalAAD() {
        if (this.f19843adOff == -1) {
            this.f19842ad = ((AEADBaseEngine.StreamAADOperator) this.aadOperator).getBytes();
            this.f19843adOff = 0;
            this.f19844adlen = this.aadOperator.mo15230getLen();
            this.aadOperator.mo15231reset();
        }
        int i = this.f19653m_state.f19692ord;
        if (i == 1 || i == 5) {
            processAADBytes(this.tag_buffer);
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i) {
        int iMo15232getLen = this.dataOperator.mo15232getLen() - (this.forEncryption ? 0 : this.MAC_SIZE);
        processFinalAAD();
        int i2 = this.BlockSize;
        int i3 = iMo15232getLen / i2;
        int i4 = i3 + 1;
        int i5 = iMo15232getLen % i2 != 0 ? i4 : i3;
        int i6 = (this.f19650IV_SIZE + this.f19844adlen) / i2;
        processBytes(this.f19652m_buf, bArr, i, Math.max(i3 + 2, i6), i5, i4, iMo15232getLen, i6 + 1);
        C6240Bytes.m18281xorTo(this.BlockSize, this.expanded_key, this.tag_buffer);
        this.instance.permutation(this.tag_buffer);
        C6240Bytes.m18281xorTo(this.BlockSize, this.expanded_key, this.tag_buffer);
        System.arraycopy(this.tag_buffer, 0, this.f19654mac, 0, this.MAC_SIZE);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public /* bridge */ /* synthetic */ void mo15228reset() {
        super.mo15228reset();
    }

    private void processBytes(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, int i5, int i6) {
        byte[] bArr3 = new byte[this.BlockSize];
        int i7 = i;
        int i8 = this.f19846nb_its;
        int i9 = 0;
        while (i8 < i2) {
            int i10 = i8 == i3 + (-1) ? i5 - (this.BlockSize * i8) : this.BlockSize;
            lfsr_step();
            if (i8 < i3) {
                computeCipherBlock(bArr, i9, i10, bArr2, i7);
                if (this.forEncryption) {
                    System.arraycopy(this.f19845buffer, 0, bArr3, 0, i10);
                } else {
                    System.arraycopy(bArr, i9, bArr3, 0, i10);
                }
                i7 += i10;
                i9 += i10;
            }
            if (i8 > 0 && i8 <= i4) {
                int i11 = this.BlockSize;
                int i12 = (i8 - 1) * i11;
                if (i12 == i5) {
                    Arrays.fill(this.f19845buffer, 1, i11, (byte) 0);
                    this.f19845buffer[0] = 1;
                } else {
                    int i13 = i5 - i12;
                    if (i11 <= i13) {
                        System.arraycopy(this.previous_outputMessage, 0, this.f19845buffer, 0, i11);
                    } else if (i13 > 0) {
                        System.arraycopy(this.previous_outputMessage, 0, this.f19845buffer, 0, i13);
                        Arrays.fill(this.f19845buffer, i13, this.BlockSize, (byte) 0);
                        this.f19845buffer[i13] = 1;
                    }
                }
                absorbCiphertext();
            }
            i8++;
            if (i8 < i6) {
                absorbAAD();
            }
            swapMasks();
            System.arraycopy(bArr3, 0, this.previous_outputMessage, 0, this.BlockSize);
        }
        this.f19846nb_its = i8;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: init */
    public void mo15227init(byte[] bArr, byte[] bArr2) {
        this.f19847npub = bArr2;
        byte[] bArr3 = new byte[this.BlockSize];
        this.expanded_key = bArr3;
        System.arraycopy(bArr, 0, bArr3, 0, this.KEY_SIZE);
        this.instance.permutation(this.expanded_key);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i, int i2) {
        super.processAADBytes(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: reset */
    public void mo15229reset(boolean z) {
        super.mo15229reset(z);
        Arrays.fill(this.tag_buffer, (byte) 0);
        Arrays.fill(this.previous_outputMessage, (byte) 0);
        this.f19846nb_its = 0;
        this.f19843adOff = -1;
    }
}
