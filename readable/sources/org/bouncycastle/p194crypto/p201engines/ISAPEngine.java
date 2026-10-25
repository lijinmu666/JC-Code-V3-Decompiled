package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p201engines.AEADBaseEngine;
import org.bouncycastle.p194crypto.p201engines.AsconPermutationFriend;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class ISAPEngine extends AEADBaseEngine {
    private static final int ISAP_STATE_SZ = 40;
    private final ISAP_AEAD ISAPAEAD;

    /* renamed from: ISAP_rH */
    private int f19931ISAP_rH;

    /* renamed from: k */
    private byte[] f19932k;

    /* renamed from: npub */
    private byte[] f19933npub;

    public abstract class ISAPAEAD_A implements ISAP_AEAD {
        protected long ISAP_IV1_64;
        protected long ISAP_IV2_64;
        protected long ISAP_IV3_64;

        /* renamed from: k64 */
        protected long[] f19934k64;

        /* renamed from: mac */
        AsconPermutationFriend.AsconPermutation f19935mac;

        /* renamed from: npub64 */
        protected long[] f19936npub64;

        /* renamed from: p */
        AsconPermutationFriend.AsconPermutation f19937p;

        public ISAPAEAD_A() {
            ISAPEngine.this.f19931ISAP_rH = 64;
            ISAPEngine.this.BlockSize = (ISAPEngine.this.f19931ISAP_rH + 7) >> 3;
            this.f19937p = new AsconPermutationFriend.AsconPermutation();
            this.f19935mac = new AsconPermutationFriend.AsconPermutation();
        }

        private int getLongSize(int i) {
            return (i + 7) >>> 3;
        }

        /* renamed from: isap_rk */
        private void m15354isap_rk(AsconPermutationFriend.AsconPermutation asconPermutation, long j, byte[] bArr, int i) {
            long[] jArr = this.f19934k64;
            asconPermutation.m15268set(jArr[0], jArr[1], j, 0L, 0L);
            asconPermutation.m15266p(12);
            for (int i2 = 0; i2 < (i << 3) - 1; i2++) {
                asconPermutation.f19740x0 ^= ((((bArr[i2 >>> 3] >>> (7 - (i2 & 7))) & 1) << 7) & 255) << 56;
                mo15356PX2(asconPermutation);
            }
            asconPermutation.f19740x0 ^= (bArr[i - 1] & 1) << 63;
            asconPermutation.m15266p(12);
        }

        /* renamed from: PX1 */
        public abstract void mo15355PX1(AsconPermutationFriend.AsconPermutation asconPermutation);

        /* renamed from: PX2 */
        public abstract void mo15356PX2(AsconPermutationFriend.AsconPermutation asconPermutation);

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void absorbFinalAADBlock() {
            int i = 0;
            while (true) {
                int i2 = ISAPEngine.this.m_aadPos;
                if (i >= i2) {
                    AsconPermutationFriend.AsconPermutation asconPermutation = this.f19935mac;
                    asconPermutation.f19740x0 = (128 << ((7 - i2) << 3)) ^ asconPermutation.f19740x0;
                    asconPermutation.m15266p(12);
                    this.f19935mac.f19744x4 ^= 1;
                    return;
                }
                this.f19935mac.f19740x0 ^= (r1.f19651m_aad[i] & 255) << ((7 - i) << 3);
                i++;
            }
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void absorbMacBlock(byte[] bArr, int i) {
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f19935mac;
            asconPermutation.f19740x0 = AbstractC6245Pack.bigEndianToLong(bArr, i) ^ asconPermutation.f19740x0;
            this.f19935mac.m15266p(12);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        /* renamed from: init */
        public void mo15357init() {
            this.f19936npub64 = new long[getLongSize(ISAPEngine.this.f19933npub.length)];
            this.f19934k64 = new long[getLongSize(ISAPEngine.this.f19932k.length)];
            AbstractC6245Pack.bigEndianToLong(ISAPEngine.this.f19933npub, 0, this.f19936npub64);
            AbstractC6245Pack.bigEndianToLong(ISAPEngine.this.f19932k, 0, this.f19934k64);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processEncBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
            AbstractC6245Pack.longToBigEndian(AbstractC6245Pack.bigEndianToLong(bArr, i) ^ this.f19937p.f19740x0, bArr2, i2);
            mo15355PX1(this.f19937p);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processEncFinalBlock(byte[] bArr, int i) {
            byte[] bArrLongToLittleEndian = AbstractC6245Pack.longToLittleEndian(this.f19937p.f19740x0);
            ISAPEngine iSAPEngine = ISAPEngine.this;
            int i2 = iSAPEngine.m_bufPos;
            C6240Bytes.m18274xor(i2, bArrLongToLittleEndian, iSAPEngine.BlockSize - i2, iSAPEngine.f19652m_buf, 0, bArr, i);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processMACFinal(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3 = i;
            int i4 = 0;
            while (i4 < i2) {
                this.f19935mac.f19740x0 ^= (bArr[i3] & 255) << ((7 - i4) << 3);
                i4++;
                i3++;
            }
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f19935mac;
            asconPermutation.f19740x0 ^= 128 << ((7 - i2) << 3);
            asconPermutation.m15266p(12);
            AbstractC6245Pack.longToBigEndian(this.f19935mac.f19740x0, bArr2, 0);
            AbstractC6245Pack.longToBigEndian(this.f19935mac.f19741x1, bArr2, 8);
            AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f19935mac;
            long j = asconPermutation2.f19742x2;
            long j2 = asconPermutation2.f19743x3;
            long j3 = asconPermutation2.f19744x4;
            m15354isap_rk(asconPermutation2, this.ISAP_IV2_64, bArr2, ISAPEngine.this.KEY_SIZE);
            AsconPermutationFriend.AsconPermutation asconPermutation3 = this.f19935mac;
            asconPermutation3.f19742x2 = j;
            asconPermutation3.f19743x3 = j2;
            asconPermutation3.f19744x4 = j3;
            asconPermutation3.m15266p(12);
            AbstractC6245Pack.longToBigEndian(this.f19935mac.f19740x0, bArr2, 0);
            AbstractC6245Pack.longToBigEndian(this.f19935mac.f19741x1, bArr2, 8);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        /* renamed from: reset */
        public void mo15358reset() {
            m15354isap_rk(this.f19937p, this.ISAP_IV3_64, ISAPEngine.this.f19933npub, ISAPEngine.this.f19650IV_SIZE);
            AsconPermutationFriend.AsconPermutation asconPermutation = this.f19937p;
            long[] jArr = this.f19936npub64;
            asconPermutation.f19743x3 = jArr[0];
            asconPermutation.f19744x4 = jArr[1];
            mo15355PX1(asconPermutation);
            AsconPermutationFriend.AsconPermutation asconPermutation2 = this.f19935mac;
            long[] jArr2 = this.f19936npub64;
            asconPermutation2.m15268set(jArr2[0], jArr2[1], this.ISAP_IV1_64, 0L, 0L);
            this.f19935mac.m15266p(12);
        }
    }

    public class ISAPAEAD_A_128 extends ISAPAEAD_A {
        public ISAPAEAD_A_128() {
            super();
            this.ISAP_IV1_64 = 108156764298152972L;
            this.ISAP_IV2_64 = 180214358336080908L;
            this.ISAP_IV3_64 = 252271952374008844L;
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_A
        /* renamed from: PX1 */
        public void mo15355PX1(AsconPermutationFriend.AsconPermutation asconPermutation) {
            asconPermutation.m15266p(12);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_A
        /* renamed from: PX2 */
        public void mo15356PX2(AsconPermutationFriend.AsconPermutation asconPermutation) {
            asconPermutation.m15266p(12);
        }
    }

    public class ISAPAEAD_A_128A extends ISAPAEAD_A {
        public ISAPAEAD_A_128A() {
            super();
            this.ISAP_IV1_64 = 108156764297430540L;
            this.ISAP_IV2_64 = 180214358335358476L;
            this.ISAP_IV3_64 = 252271952373286412L;
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_A
        /* renamed from: PX1 */
        public void mo15355PX1(AsconPermutationFriend.AsconPermutation asconPermutation) {
            asconPermutation.m15266p(6);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_A
        /* renamed from: PX2 */
        public void mo15356PX2(AsconPermutationFriend.AsconPermutation asconPermutation) {
            asconPermutation.m15267round(75L);
        }
    }

    public abstract class ISAPAEAD_K implements ISAP_AEAD {
        protected short[] ISAP_IV1_16;
        protected short[] ISAP_IV2_16;
        protected short[] ISAP_IV3_16;
        final int ISAP_STATE_SZ_CRYPTO_NPUBBYTES;

        /* renamed from: iv16 */
        protected short[] f19944iv16;

        /* renamed from: k16 */
        protected short[] f19945k16;
        private final int[] KeccakF400RoundConstants = {1, 32898, 32906, 32768, 32907, 1, 32897, 32777, 138, 136, 32777, 10, 32907, 139, 32905, 32771, 32770, 128, 32778, 10};

        /* renamed from: SX */
        protected short[] f19943SX = new short[25];

        /* renamed from: macSX */
        protected short[] f19948macSX = new short[25];

        /* renamed from: E */
        protected short[] f19942E = new short[25];

        /* renamed from: C */
        protected short[] f19941C = new short[5];

        /* renamed from: macE */
        protected short[] f19947macE = new short[25];

        /* renamed from: macC */
        protected short[] f19946macC = new short[5];

        public ISAPAEAD_K() {
            this.ISAP_STATE_SZ_CRYPTO_NPUBBYTES = 40 - ISAPEngine.this.f19650IV_SIZE;
            ISAPEngine.this.f19931ISAP_rH = 144;
            ISAPEngine.this.BlockSize = (ISAPEngine.this.f19931ISAP_rH + 7) >> 3;
        }

        /* renamed from: ROL16 */
        private short m15359ROL16(short s, int i) {
            int i2 = 65535 & s;
            return (short) ((i2 >>> (16 - i)) ^ (i2 << i));
        }

        private void byteToShortXor(byte[] bArr, int i, short[] sArr, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                sArr[i3] = (short) (sArr[i3] ^ AbstractC6245Pack.littleEndianToShort(bArr, (i3 << 1) + i));
            }
        }

        public abstract void PermuteRoundsBX(short[] sArr, short[] sArr2, short[] sArr3);

        public abstract void PermuteRoundsHX(short[] sArr, short[] sArr2, short[] sArr3);

        public abstract void PermuteRoundsKX(short[] sArr, short[] sArr2, short[] sArr3);

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void absorbFinalAADBlock() {
            int i = 0;
            while (true) {
                ISAPEngine iSAPEngine = ISAPEngine.this;
                int i2 = iSAPEngine.m_aadPos;
                if (i >= i2) {
                    short[] sArr = this.f19948macSX;
                    int i3 = i2 >> 1;
                    sArr[i3] = (short) ((128 << ((i2 & 1) << 3)) ^ sArr[i3]);
                    PermuteRoundsHX(sArr, this.f19947macE, this.f19946macC);
                    short[] sArr2 = this.f19948macSX;
                    sArr2[24] = (short) (sArr2[24] ^ 256);
                    return;
                }
                short[] sArr3 = this.f19948macSX;
                int i4 = i >> 1;
                sArr3[i4] = (short) (((iSAPEngine.f19651m_aad[i] & C1126UByte.MAX_VALUE) << ((i & 1) << 3)) ^ sArr3[i4]);
                i++;
            }
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void absorbMacBlock(byte[] bArr, int i) {
            byteToShortXor(bArr, i, this.f19948macSX, ISAPEngine.this.BlockSize >> 1);
            PermuteRoundsHX(this.f19948macSX, this.f19947macE, this.f19946macC);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        /* renamed from: init */
        public void mo15357init() {
            this.f19945k16 = new short[ISAPEngine.this.f19932k.length >> 1];
            byte[] bArr = ISAPEngine.this.f19932k;
            short[] sArr = this.f19945k16;
            AbstractC6245Pack.littleEndianToShort(bArr, 0, sArr, 0, sArr.length);
            this.f19944iv16 = new short[ISAPEngine.this.f19933npub.length >> 1];
            byte[] bArr2 = ISAPEngine.this.f19933npub;
            short[] sArr2 = this.f19944iv16;
            AbstractC6245Pack.littleEndianToShort(bArr2, 0, sArr2, 0, sArr2.length);
        }

        /* renamed from: isap_rk */
        public void m15360isap_rk(short[] sArr, byte[] bArr, int i, short[] sArr2, int i2, short[] sArr3) {
            short[] sArr4 = new short[25];
            short[] sArr5 = new short[25];
            System.arraycopy(this.f19945k16, 0, sArr4, 0, 8);
            System.arraycopy(sArr, 0, sArr4, 8, 4);
            PermuteRoundsKX(sArr4, sArr5, sArr3);
            for (int i3 = 0; i3 < (i << 3) - 1; i3++) {
                sArr4[0] = (short) (sArr4[0] ^ (((bArr[i3 >> 3] >>> (7 - (i3 & 7))) & 1) << 7));
                PermuteRoundsBX(sArr4, sArr5, sArr3);
            }
            sArr4[0] = (short) (sArr4[0] ^ ((bArr[i - 1] & 1) << 7));
            PermuteRoundsKX(sArr4, sArr5, sArr3);
            System.arraycopy(sArr4, 0, sArr2, 0, i2 == this.ISAP_STATE_SZ_CRYPTO_NPUBBYTES ? 17 : 8);
        }

        public void prepareThetaX(short[] sArr, short[] sArr2) {
            sArr2[0] = (short) ((((sArr[0] ^ sArr[5]) ^ sArr[10]) ^ sArr[15]) ^ sArr[20]);
            sArr2[1] = (short) ((((sArr[1] ^ sArr[6]) ^ sArr[11]) ^ sArr[16]) ^ sArr[21]);
            sArr2[2] = (short) ((((sArr[2] ^ sArr[7]) ^ sArr[12]) ^ sArr[17]) ^ sArr[22]);
            sArr2[3] = (short) ((((sArr[3] ^ sArr[8]) ^ sArr[13]) ^ sArr[18]) ^ sArr[23]);
            sArr2[4] = (short) (sArr[24] ^ (((sArr[4] ^ sArr[9]) ^ sArr[14]) ^ sArr[19]));
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processEncBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
            int i3 = 0;
            while (i3 < ISAPEngine.this.BlockSize) {
                bArr2[i2] = (byte) (bArr[i] ^ (this.f19943SX[i3 >> 1] >>> ((i3 & 1) << 3)));
                i3++;
                i2++;
                i++;
            }
            PermuteRoundsKX(this.f19943SX, this.f19942E, this.f19941C);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processEncFinalBlock(byte[] bArr, int i) {
            int i2 = 0;
            while (true) {
                ISAPEngine iSAPEngine = ISAPEngine.this;
                if (i2 >= iSAPEngine.m_bufPos) {
                    return;
                }
                bArr[i] = (byte) (iSAPEngine.f19652m_buf[i2] ^ (this.f19943SX[i2 >> 1] >>> ((i2 & 1) << 3)));
                i2++;
                i++;
            }
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        public void processMACFinal(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3 = 0;
            while (i3 < i2) {
                short[] sArr = this.f19948macSX;
                int i4 = i3 >> 1;
                sArr[i4] = (short) (((bArr[i] & 255) << ((i3 & 1) << 3)) ^ sArr[i4]);
                i3++;
                i++;
            }
            short[] sArr2 = this.f19948macSX;
            int i5 = i2 >> 1;
            sArr2[i5] = (short) ((128 << ((i2 & 1) << 3)) ^ sArr2[i5]);
            PermuteRoundsHX(sArr2, this.f19947macE, this.f19946macC);
            AbstractC6245Pack.shortToLittleEndian(this.f19948macSX, 0, 8, bArr2, 0);
            short[] sArr3 = this.ISAP_IV2_16;
            int i6 = ISAPEngine.this.KEY_SIZE;
            m15360isap_rk(sArr3, bArr2, i6, this.f19948macSX, i6, this.f19946macC);
            PermuteRoundsHX(this.f19948macSX, this.f19947macE, this.f19946macC);
            AbstractC6245Pack.shortToLittleEndian(this.f19948macSX, 0, 8, bArr2, 0);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAP_AEAD
        /* renamed from: reset */
        public void mo15358reset() {
            C6238Arrays.m18260fill(this.f19943SX, (short) 0);
            m15360isap_rk(this.ISAP_IV3_16, ISAPEngine.this.f19933npub, ISAPEngine.this.f19650IV_SIZE, this.f19943SX, this.ISAP_STATE_SZ_CRYPTO_NPUBBYTES, this.f19941C);
            System.arraycopy(this.f19944iv16, 0, this.f19943SX, 17, 8);
            PermuteRoundsKX(this.f19943SX, this.f19942E, this.f19941C);
            C6238Arrays.m18259fill(this.f19948macSX, 12, 25, (short) 0);
            System.arraycopy(this.f19944iv16, 0, this.f19948macSX, 0, 8);
            System.arraycopy(this.ISAP_IV1_16, 0, this.f19948macSX, 8, 4);
            PermuteRoundsHX(this.f19948macSX, this.f19947macE, this.f19946macC);
        }

        public void rounds12X(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            rounds_8_18(sArr, sArr2, sArr3);
        }

        public void rounds_12_18(short[] sArr, short[] sArr2, short[] sArr3) {
            thetaRhoPiChiIotaPrepareTheta(12, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(13, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(14, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(15, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(16, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(17, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(18, sArr, sArr2, sArr3);
            thetaRhoPiChiIota(sArr2, sArr, sArr3);
        }

        public void rounds_4_18(short[] sArr, short[] sArr2, short[] sArr3) {
            thetaRhoPiChiIotaPrepareTheta(4, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(5, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(6, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(7, sArr2, sArr, sArr3);
            rounds_8_18(sArr, sArr2, sArr3);
        }

        public void rounds_8_18(short[] sArr, short[] sArr2, short[] sArr3) {
            thetaRhoPiChiIotaPrepareTheta(8, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(9, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(10, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(11, sArr2, sArr, sArr3);
            rounds_12_18(sArr, sArr2, sArr3);
        }

        public void thetaRhoPiChiIota(short[] sArr, short[] sArr2, short[] sArr3) {
            short sM15359ROL16 = (short) (sArr3[4] ^ m15359ROL16(sArr3[1], 1));
            short sM15359ROL162 = (short) (sArr3[0] ^ m15359ROL16(sArr3[2], 1));
            short sM15359ROL163 = (short) (sArr3[1] ^ m15359ROL16(sArr3[3], 1));
            short sM15359ROL164 = (short) (sArr3[2] ^ m15359ROL16(sArr3[4], 1));
            short sM15359ROL165 = (short) (sArr3[3] ^ m15359ROL16(sArr3[0], 1));
            short s = (short) (sArr[0] ^ sM15359ROL16);
            sArr[0] = s;
            short s2 = (short) (sArr[6] ^ sM15359ROL162);
            sArr[6] = s2;
            short sM15359ROL166 = m15359ROL16(s2, 12);
            short s3 = (short) (sArr[12] ^ sM15359ROL163);
            sArr[12] = s3;
            short sM15359ROL167 = m15359ROL16(s3, 11);
            short s4 = (short) (sArr[18] ^ sM15359ROL164);
            sArr[18] = s4;
            short sM15359ROL168 = m15359ROL16(s4, 5);
            short s5 = (short) (sArr[24] ^ sM15359ROL165);
            sArr[24] = s5;
            short sM15359ROL169 = m15359ROL16(s5, 14);
            sArr2[0] = (short) ((((~sM15359ROL166) & sM15359ROL167) ^ s) ^ this.KeccakF400RoundConstants[19]);
            sArr2[1] = (short) (((~sM15359ROL167) & sM15359ROL168) ^ sM15359ROL166);
            sArr2[2] = (short) (((~sM15359ROL168) & sM15359ROL169) ^ sM15359ROL167);
            sArr2[3] = (short) (((~sM15359ROL169) & s) ^ sM15359ROL168);
            sArr2[4] = (short) (((~s) & sM15359ROL166) ^ sM15359ROL169);
            short s6 = (short) (sArr[3] ^ sM15359ROL164);
            sArr[3] = s6;
            short sM15359ROL1610 = m15359ROL16(s6, 12);
            short s7 = (short) (sArr[9] ^ sM15359ROL165);
            sArr[9] = s7;
            short sM15359ROL1611 = m15359ROL16(s7, 4);
            short s8 = (short) (sArr[10] ^ sM15359ROL16);
            sArr[10] = s8;
            short sM15359ROL1612 = m15359ROL16(s8, 3);
            short s9 = (short) (sArr[16] ^ sM15359ROL162);
            sArr[16] = s9;
            short sM15359ROL1613 = m15359ROL16(s9, 13);
            short s10 = (short) (sArr[22] ^ sM15359ROL163);
            sArr[22] = s10;
            short sM15359ROL1614 = m15359ROL16(s10, 13);
            sArr2[5] = (short) (((~sM15359ROL1611) & sM15359ROL1612) ^ sM15359ROL1610);
            sArr2[6] = (short) (((~sM15359ROL1612) & sM15359ROL1613) ^ sM15359ROL1611);
            sArr2[7] = (short) (((~sM15359ROL1613) & sM15359ROL1614) ^ sM15359ROL1612);
            sArr2[8] = (short) (((~sM15359ROL1614) & sM15359ROL1610) ^ sM15359ROL1613);
            sArr2[9] = (short) (((~sM15359ROL1610) & sM15359ROL1611) ^ sM15359ROL1614);
            short s11 = (short) (sArr[1] ^ sM15359ROL162);
            sArr[1] = s11;
            short sM15359ROL1615 = m15359ROL16(s11, 1);
            short s12 = (short) (sArr[7] ^ sM15359ROL163);
            sArr[7] = s12;
            short sM15359ROL1616 = m15359ROL16(s12, 6);
            short s13 = (short) (sArr[13] ^ sM15359ROL164);
            sArr[13] = s13;
            short sM15359ROL1617 = m15359ROL16(s13, 9);
            short s14 = (short) (sArr[19] ^ sM15359ROL165);
            sArr[19] = s14;
            short sM15359ROL1618 = m15359ROL16(s14, 8);
            short s15 = (short) (sArr[20] ^ sM15359ROL16);
            sArr[20] = s15;
            short sM15359ROL1619 = m15359ROL16(s15, 2);
            sArr2[10] = (short) (((~sM15359ROL1616) & sM15359ROL1617) ^ sM15359ROL1615);
            sArr2[11] = (short) (((~sM15359ROL1617) & sM15359ROL1618) ^ sM15359ROL1616);
            sArr2[12] = (short) (sM15359ROL1617 ^ ((~sM15359ROL1618) & sM15359ROL1619));
            sArr2[13] = (short) (((~sM15359ROL1619) & sM15359ROL1615) ^ sM15359ROL1618);
            sArr2[14] = (short) (((~sM15359ROL1615) & sM15359ROL1616) ^ sM15359ROL1619);
            short s16 = (short) (sArr[4] ^ sM15359ROL165);
            sArr[4] = s16;
            short sM15359ROL1620 = m15359ROL16(s16, 11);
            short s17 = (short) (sArr[5] ^ sM15359ROL16);
            sArr[5] = s17;
            short sM15359ROL1621 = m15359ROL16(s17, 4);
            short s18 = (short) (sArr[11] ^ sM15359ROL162);
            sArr[11] = s18;
            short sM15359ROL1622 = m15359ROL16(s18, 10);
            short s19 = (short) (sArr[17] ^ sM15359ROL163);
            sArr[17] = s19;
            short sM15359ROL1623 = m15359ROL16(s19, 15);
            short s20 = (short) (sArr[23] ^ sM15359ROL164);
            sArr[23] = s20;
            short sM15359ROL1624 = m15359ROL16(s20, 8);
            sArr2[15] = (short) (((~sM15359ROL1621) & sM15359ROL1622) ^ sM15359ROL1620);
            sArr2[16] = (short) (((~sM15359ROL1622) & sM15359ROL1623) ^ sM15359ROL1621);
            sArr2[17] = (short) (sM15359ROL1622 ^ ((~sM15359ROL1623) & sM15359ROL1624));
            sArr2[18] = (short) (((~sM15359ROL1624) & sM15359ROL1620) ^ sM15359ROL1623);
            sArr2[19] = (short) ((sM15359ROL1621 & (~sM15359ROL1620)) ^ sM15359ROL1624);
            short s21 = (short) (sArr[2] ^ sM15359ROL163);
            sArr[2] = s21;
            short sM15359ROL1625 = m15359ROL16(s21, 14);
            short s22 = (short) (sArr[8] ^ sM15359ROL164);
            sArr[8] = s22;
            short sM15359ROL1626 = m15359ROL16(s22, 7);
            short s23 = (short) (sArr[14] ^ sM15359ROL165);
            sArr[14] = s23;
            short sM15359ROL1627 = m15359ROL16(s23, 7);
            short s24 = (short) (sM15359ROL16 ^ sArr[15]);
            sArr[15] = s24;
            short sM15359ROL1628 = m15359ROL16(s24, 9);
            short s25 = (short) (sM15359ROL162 ^ sArr[21]);
            sArr[21] = s25;
            short sM15359ROL1629 = m15359ROL16(s25, 2);
            sArr2[20] = (short) (((~sM15359ROL1626) & sM15359ROL1627) ^ sM15359ROL1625);
            sArr2[21] = (short) (((~sM15359ROL1627) & sM15359ROL1628) ^ sM15359ROL1626);
            sArr2[22] = (short) (sM15359ROL1627 ^ ((~sM15359ROL1628) & sM15359ROL1629));
            sArr2[23] = (short) (sM15359ROL1628 ^ ((~sM15359ROL1629) & sM15359ROL1625));
            sArr2[24] = (short) (sM15359ROL1629 ^ ((~sM15359ROL1625) & sM15359ROL1626));
        }

        public void thetaRhoPiChiIotaPrepareTheta(int i, short[] sArr, short[] sArr2, short[] sArr3) {
            short sM15359ROL16 = (short) (sArr3[4] ^ m15359ROL16(sArr3[1], 1));
            short sM15359ROL162 = (short) (sArr3[0] ^ m15359ROL16(sArr3[2], 1));
            short sM15359ROL163 = (short) (sArr3[1] ^ m15359ROL16(sArr3[3], 1));
            short sM15359ROL164 = (short) (sArr3[2] ^ m15359ROL16(sArr3[4], 1));
            short sM15359ROL165 = (short) (sArr3[3] ^ m15359ROL16(sArr3[0], 1));
            short s = (short) (sArr[0] ^ sM15359ROL16);
            sArr[0] = s;
            short s2 = (short) (sArr[6] ^ sM15359ROL162);
            sArr[6] = s2;
            short sM15359ROL166 = m15359ROL16(s2, 12);
            short s3 = (short) (sArr[12] ^ sM15359ROL163);
            sArr[12] = s3;
            short sM15359ROL167 = m15359ROL16(s3, 11);
            short s4 = (short) (sArr[18] ^ sM15359ROL164);
            sArr[18] = s4;
            short sM15359ROL168 = m15359ROL16(s4, 5);
            short s5 = (short) (sArr[24] ^ sM15359ROL165);
            sArr[24] = s5;
            short sM15359ROL169 = m15359ROL16(s5, 14);
            short s6 = (short) ((((~sM15359ROL166) & sM15359ROL167) ^ s) ^ this.KeccakF400RoundConstants[i]);
            sArr2[0] = s6;
            sArr3[0] = s6;
            short s7 = (short) (((~sM15359ROL167) & sM15359ROL168) ^ sM15359ROL166);
            sArr2[1] = s7;
            sArr3[1] = s7;
            short s8 = (short) (((~sM15359ROL168) & sM15359ROL169) ^ sM15359ROL167);
            sArr2[2] = s8;
            sArr3[2] = s8;
            short s9 = (short) (((~sM15359ROL169) & s) ^ sM15359ROL168);
            sArr2[3] = s9;
            sArr3[3] = s9;
            short s10 = (short) (((~s) & sM15359ROL166) ^ sM15359ROL169);
            sArr2[4] = s10;
            sArr3[4] = s10;
            short s11 = (short) (sArr[3] ^ sM15359ROL164);
            sArr[3] = s11;
            short sM15359ROL1610 = m15359ROL16(s11, 12);
            short s12 = (short) (sArr[9] ^ sM15359ROL165);
            sArr[9] = s12;
            short sM15359ROL1611 = m15359ROL16(s12, 4);
            short s13 = (short) (sArr[10] ^ sM15359ROL16);
            sArr[10] = s13;
            short sM15359ROL1612 = m15359ROL16(s13, 3);
            short s14 = (short) (sArr[16] ^ sM15359ROL162);
            sArr[16] = s14;
            short sM15359ROL1613 = m15359ROL16(s14, 13);
            short s15 = (short) (sArr[22] ^ sM15359ROL163);
            sArr[22] = s15;
            short sM15359ROL1614 = m15359ROL16(s15, 13);
            short s16 = (short) (((~sM15359ROL1611) & sM15359ROL1612) ^ sM15359ROL1610);
            sArr2[5] = s16;
            sArr3[0] = (short) (sArr3[0] ^ s16);
            short s17 = (short) (((~sM15359ROL1612) & sM15359ROL1613) ^ sM15359ROL1611);
            sArr2[6] = s17;
            sArr3[1] = (short) (sArr3[1] ^ s17);
            short s18 = (short) (sM15359ROL1612 ^ ((~sM15359ROL1613) & sM15359ROL1614));
            sArr2[7] = s18;
            sArr3[2] = (short) (sArr3[2] ^ s18);
            short s19 = (short) (((~sM15359ROL1614) & sM15359ROL1610) ^ sM15359ROL1613);
            sArr2[8] = s19;
            sArr3[3] = (short) (sArr3[3] ^ s19);
            short s20 = (short) (((~sM15359ROL1610) & sM15359ROL1611) ^ sM15359ROL1614);
            sArr2[9] = s20;
            sArr3[4] = (short) (s20 ^ sArr3[4]);
            short s21 = (short) (sArr[1] ^ sM15359ROL162);
            sArr[1] = s21;
            short sM15359ROL1615 = m15359ROL16(s21, 1);
            short s22 = (short) (sArr[7] ^ sM15359ROL163);
            sArr[7] = s22;
            short sM15359ROL1616 = m15359ROL16(s22, 6);
            short s23 = (short) (sArr[13] ^ sM15359ROL164);
            sArr[13] = s23;
            short sM15359ROL1617 = m15359ROL16(s23, 9);
            short s24 = (short) (sArr[19] ^ sM15359ROL165);
            sArr[19] = s24;
            short sM15359ROL1618 = m15359ROL16(s24, 8);
            short s25 = (short) (sArr[20] ^ sM15359ROL16);
            sArr[20] = s25;
            short sM15359ROL1619 = m15359ROL16(s25, 2);
            short s26 = (short) (((~sM15359ROL1616) & sM15359ROL1617) ^ sM15359ROL1615);
            sArr2[10] = s26;
            sArr3[0] = (short) (sArr3[0] ^ s26);
            short s27 = (short) (((~sM15359ROL1617) & sM15359ROL1618) ^ sM15359ROL1616);
            sArr2[11] = s27;
            sArr3[1] = (short) (sArr3[1] ^ s27);
            short s28 = (short) (sM15359ROL1617 ^ ((~sM15359ROL1618) & sM15359ROL1619));
            sArr2[12] = s28;
            sArr3[2] = (short) (s28 ^ sArr3[2]);
            short s29 = (short) (sM15359ROL1618 ^ ((~sM15359ROL1619) & sM15359ROL1615));
            sArr2[13] = s29;
            sArr3[3] = (short) (s29 ^ sArr3[3]);
            short s30 = (short) (((~sM15359ROL1615) & sM15359ROL1616) ^ sM15359ROL1619);
            sArr2[14] = s30;
            sArr3[4] = (short) (s30 ^ sArr3[4]);
            short s31 = (short) (sArr[4] ^ sM15359ROL165);
            sArr[4] = s31;
            short sM15359ROL1620 = m15359ROL16(s31, 11);
            short s32 = (short) (sArr[5] ^ sM15359ROL16);
            sArr[5] = s32;
            short sM15359ROL1621 = m15359ROL16(s32, 4);
            short s33 = (short) (sArr[11] ^ sM15359ROL162);
            sArr[11] = s33;
            short sM15359ROL1622 = m15359ROL16(s33, 10);
            short s34 = (short) (sArr[17] ^ sM15359ROL163);
            sArr[17] = s34;
            short sM15359ROL1623 = m15359ROL16(s34, 15);
            short s35 = (short) (sArr[23] ^ sM15359ROL164);
            sArr[23] = s35;
            short sM15359ROL1624 = m15359ROL16(s35, 8);
            short s36 = (short) (((~sM15359ROL1621) & sM15359ROL1622) ^ sM15359ROL1620);
            sArr2[15] = s36;
            sArr3[0] = (short) (sArr3[0] ^ s36);
            short s37 = (short) (((~sM15359ROL1622) & sM15359ROL1623) ^ sM15359ROL1621);
            sArr2[16] = s37;
            sArr3[1] = (short) (sArr3[1] ^ s37);
            short s38 = (short) (sM15359ROL1622 ^ ((~sM15359ROL1623) & sM15359ROL1624));
            sArr2[17] = s38;
            sArr3[2] = (short) (sArr3[2] ^ s38);
            short s39 = (short) (((~sM15359ROL1624) & sM15359ROL1620) ^ sM15359ROL1623);
            sArr2[18] = s39;
            sArr3[3] = (short) (s39 ^ sArr3[3]);
            short s40 = (short) (((~sM15359ROL1620) & sM15359ROL1621) ^ sM15359ROL1624);
            sArr2[19] = s40;
            sArr3[4] = (short) (s40 ^ sArr3[4]);
            short s41 = (short) (sArr[2] ^ sM15359ROL163);
            sArr[2] = s41;
            short sM15359ROL1625 = m15359ROL16(s41, 14);
            short s42 = (short) (sArr[8] ^ sM15359ROL164);
            sArr[8] = s42;
            short sM15359ROL1626 = m15359ROL16(s42, 7);
            short s43 = (short) (sArr[14] ^ sM15359ROL165);
            sArr[14] = s43;
            short sM15359ROL1627 = m15359ROL16(s43, 7);
            short s44 = (short) (sM15359ROL16 ^ sArr[15]);
            sArr[15] = s44;
            short sM15359ROL1628 = m15359ROL16(s44, 9);
            short s45 = (short) (sM15359ROL162 ^ sArr[21]);
            sArr[21] = s45;
            short sM15359ROL1629 = m15359ROL16(s45, 2);
            short s46 = (short) (((~sM15359ROL1626) & sM15359ROL1627) ^ sM15359ROL1625);
            sArr2[20] = s46;
            sArr3[0] = (short) (s46 ^ sArr3[0]);
            short s47 = (short) (((~sM15359ROL1627) & sM15359ROL1628) ^ sM15359ROL1626);
            sArr2[21] = s47;
            sArr3[1] = (short) (s47 ^ sArr3[1]);
            short s48 = (short) (sM15359ROL1627 ^ ((~sM15359ROL1628) & sM15359ROL1629));
            sArr2[22] = s48;
            sArr3[2] = (short) (s48 ^ sArr3[2]);
            short s49 = (short) (((~sM15359ROL1629) & sM15359ROL1625) ^ sM15359ROL1628);
            sArr2[23] = s49;
            sArr3[3] = (short) (s49 ^ sArr3[3]);
            short s50 = (short) (sM15359ROL1629 ^ ((~sM15359ROL1625) & sM15359ROL1626));
            sArr2[24] = s50;
            sArr3[4] = (short) (s50 ^ sArr3[4]);
        }
    }

    public class ISAPAEAD_K_128 extends ISAPAEAD_K {
        public ISAPAEAD_K_128() {
            super();
            this.ISAP_IV1_16 = new short[]{-32767, 400, 3092, 3084};
            this.ISAP_IV2_16 = new short[]{-32766, 400, 3092, 3084};
            this.ISAP_IV3_16 = new short[]{-32765, 400, 3092, 3084};
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsBX(short[] sArr, short[] sArr2, short[] sArr3) {
            rounds12X(sArr, sArr2, sArr3);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsHX(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(0, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(1, sArr2, sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(2, sArr, sArr2, sArr3);
            thetaRhoPiChiIotaPrepareTheta(3, sArr2, sArr, sArr3);
            rounds_4_18(sArr, sArr2, sArr3);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsKX(short[] sArr, short[] sArr2, short[] sArr3) {
            rounds12X(sArr, sArr2, sArr3);
        }
    }

    public class ISAPAEAD_K_128A extends ISAPAEAD_K {
        public ISAPAEAD_K_128A() {
            super();
            this.ISAP_IV1_16 = new short[]{-32767, 400, 272, 2056};
            this.ISAP_IV2_16 = new short[]{-32766, 400, 272, 2056};
            this.ISAP_IV3_16 = new short[]{-32765, 400, 272, 2056};
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsBX(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            thetaRhoPiChiIotaPrepareTheta(19, sArr, sArr2, sArr3);
            System.arraycopy(sArr2, 0, sArr, 0, sArr2.length);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsHX(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            rounds_4_18(sArr, sArr2, sArr3);
        }

        @Override // org.bouncycastle.crypto.engines.ISAPEngine.ISAPAEAD_K
        public void PermuteRoundsKX(short[] sArr, short[] sArr2, short[] sArr3) {
            prepareThetaX(sArr, sArr3);
            rounds_12_18(sArr, sArr2, sArr3);
        }
    }

    public interface ISAP_AEAD {
        void absorbFinalAADBlock();

        void absorbMacBlock(byte[] bArr, int i);

        /* renamed from: init */
        void mo15357init();

        void processEncBlock(byte[] bArr, int i, byte[] bArr2, int i2);

        void processEncFinalBlock(byte[] bArr, int i);

        void processMACFinal(byte[] bArr, int i, int i2, byte[] bArr2);

        /* renamed from: reset */
        void mo15358reset();
    }

    public enum IsapType {
        ISAP_A_128A,
        ISAP_K_128A,
        ISAP_A_128,
        ISAP_K_128
    }

    public ISAPEngine(IsapType isapType) {
        String str;
        this.MAC_SIZE = 16;
        this.f19650IV_SIZE = 16;
        this.KEY_SIZE = 16;
        int iOrdinal = isapType.ordinal();
        if (iOrdinal == 0) {
            this.ISAPAEAD = new ISAPAEAD_A_128A();
            str = "ISAP-A-128A AEAD";
        } else if (iOrdinal == 1) {
            this.ISAPAEAD = new ISAPAEAD_K_128A();
            str = "ISAP-K-128A AEAD";
        } else if (iOrdinal == 2) {
            this.ISAPAEAD = new ISAPAEAD_A_128();
            str = "ISAP-A-128 AEAD";
        } else {
            if (iOrdinal != 3) {
                throw new IllegalArgumentException("Incorrect ISAP parameter");
            }
            this.ISAPAEAD = new ISAPAEAD_K_128();
            str = "ISAP-K-128 AEAD";
        }
        this.algorithmName = str;
        this.AADBufferSize = this.BlockSize;
        setInnerMembers(AEADBaseEngine.ProcessingBufferType.Immediate, AEADBaseEngine.AADOperatorType.f19658Default, AEADBaseEngine.DataOperatorType.f19672Counter);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo15224doFinal(byte[] bArr, int i) {
        return super.mo15224doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void finishAAD(AEADBaseEngine.C5335State c5335State, boolean z) {
        finishAAD3(c5335State, z);
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
    public /* bridge */ /* synthetic */ int getOutputSize(int i) {
        return super.getOutputSize(i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ int getUpdateOutputSize(int i) {
        return super.getUpdateOutputSize(i);
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

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    public /* bridge */ /* synthetic */ void processAADBytes(byte[] bArr, int i, int i2) {
        super.processAADBytes(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferAAD(byte[] bArr, int i) {
        this.ISAPAEAD.absorbMacBlock(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferDecrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.ISAPAEAD.processEncBlock(bArr, i, bArr2, i2);
        this.ISAPAEAD.absorbMacBlock(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processBufferEncrypt(byte[] bArr, int i, byte[] bArr2, int i2) {
        this.ISAPAEAD.processEncBlock(bArr, i, bArr2, i2);
        this.ISAPAEAD.absorbMacBlock(bArr2, i2);
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
        this.ISAPAEAD.absorbFinalAADBlock();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    public void processFinalBlock(byte[] bArr, int i) {
        this.ISAPAEAD.processEncFinalBlock(bArr, i);
        if (this.forEncryption) {
            this.ISAPAEAD.processMACFinal(bArr, i, this.m_bufPos, this.f19654mac);
        } else {
            this.ISAPAEAD.processMACFinal(this.f19652m_buf, 0, this.m_bufPos, this.f19654mac);
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine, org.bouncycastle.p194crypto.p210modes.AEADCipher
    /* renamed from: reset */
    public /* bridge */ /* synthetic */ void mo15228reset() {
        super.mo15228reset();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: init */
    public void mo15227init(byte[] bArr, byte[] bArr2) {
        this.f19933npub = bArr2;
        this.f19932k = bArr;
        this.ISAPAEAD.mo15357init();
    }

    @Override // org.bouncycastle.p194crypto.p201engines.AEADBaseEngine
    /* renamed from: reset */
    public void mo15229reset(boolean z) {
        super.mo15229reset(z);
        this.ISAPAEAD.mo15358reset();
    }
}
