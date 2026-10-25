package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.generators.MGF1BytesGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.MGFParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
abstract class SPHINCSPlusEngine {

    /* renamed from: A */
    final int f24095A;

    /* renamed from: D */
    final int f24096D;

    /* renamed from: H */
    final int f24097H;

    /* renamed from: H_PRIME */
    final int f24098H_PRIME;

    /* renamed from: K */
    final int f24099K;

    /* renamed from: N */
    final int f24100N;

    /* renamed from: T */
    final int f24101T;
    final int WOTS_LEN;
    final int WOTS_LEN1;
    final int WOTS_LEN2;
    final int WOTS_LOGW;

    /* renamed from: WOTS_W */
    final int f24102WOTS_W;

    /* renamed from: robust */
    @Deprecated
    final boolean f24103robust;

    public static class HarakaSEngine extends SPHINCSPlusEngine {
        private HarakaS256Digest harakaS256Digest;
        private HarakaS512Digest harakaS512Digest;
        private HarakaSXof harakaSXof;

        public HarakaSEngine(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
            super(z, i, i2, i3, i4, i5, i6);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: F */
        public byte[] mo18157F(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2) {
            byte[] bArr3 = new byte[32];
            HarakaS512Digest harakaS512Digest = this.harakaS512Digest;
            byte[] bArr4 = c6224adrs.f24077value;
            harakaS512Digest.mo14970update(bArr4, 0, bArr4.length);
            if (this.f24103robust) {
                HarakaS256Digest harakaS256Digest = this.harakaS256Digest;
                byte[] bArr5 = c6224adrs.f24077value;
                harakaS256Digest.mo14970update(bArr5, 0, bArr5.length);
                this.harakaS256Digest.mo14967doFinal(bArr3, 0);
                C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr3);
                this.harakaS512Digest.mo14970update(bArr3, 0, bArr2.length);
            } else {
                this.harakaS512Digest.mo14970update(bArr2, 0, bArr2.length);
            }
            this.harakaS512Digest.mo14967doFinal(bArr3, 0);
            return C6238Arrays.m18242copyOf(bArr3, this.f24100N);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: H */
        public byte[] mo18158H(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2, byte[] bArr3) {
            int i = this.f24100N;
            byte[] bArr4 = new byte[i];
            byte[] bArr5 = new byte[bArr2.length + bArr3.length];
            System.arraycopy(bArr2, 0, bArr5, 0, bArr2.length);
            System.arraycopy(bArr3, 0, bArr5, bArr2.length, bArr3.length);
            byte[] bArrM18164bitmask = m18164bitmask(c6224adrs, bArr5);
            HarakaSXof harakaSXof = this.harakaSXof;
            byte[] bArr6 = c6224adrs.f24077value;
            harakaSXof.m18154update(bArr6, 0, bArr6.length);
            this.harakaSXof.m18154update(bArrM18164bitmask, 0, bArrM18164bitmask.length);
            this.harakaSXof.m18152doFinal(bArr4, 0, i);
            return bArr4;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: H_msg */
        public IndexedDigest mo18159H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            int i = ((this.f24095A * this.f24099K) + 7) >> 3;
            int i2 = this.f24097H;
            int i3 = i2 / this.f24096D;
            int i4 = i2 - i3;
            int i5 = (i3 + 7) >> 3;
            int i6 = (i4 + 7) >> 3;
            int i7 = i + i5 + i6;
            byte[] bArr5 = new byte[i7];
            this.harakaSXof.m18154update(bArr, 0, bArr.length);
            this.harakaSXof.m18154update(bArr3, 0, bArr3.length);
            this.harakaSXof.m18154update(bArr4, 0, bArr4.length);
            this.harakaSXof.m18152doFinal(bArr5, 0, i7);
            byte[] bArr6 = new byte[8];
            System.arraycopy(bArr5, i, bArr6, 8 - i6, i6);
            long jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr6, 0) & ((-1) >>> (64 - i4));
            byte[] bArr7 = new byte[4];
            System.arraycopy(bArr5, i6 + i, bArr7, 4 - i5, i5);
            return new IndexedDigest(jBigEndianToLong, AbstractC6245Pack.bigEndianToInt(bArr7, 0) & ((-1) >>> (32 - i3)), C6238Arrays.copyOfRange(bArr5, 0, i));
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: PRF */
        public byte[] mo18160PRF(byte[] bArr, byte[] bArr2, C6224ADRS c6224adrs) {
            byte[] bArr3 = new byte[32];
            HarakaS512Digest harakaS512Digest = this.harakaS512Digest;
            byte[] bArr4 = c6224adrs.f24077value;
            harakaS512Digest.mo14970update(bArr4, 0, bArr4.length);
            this.harakaS512Digest.mo14970update(bArr2, 0, bArr2.length);
            this.harakaS512Digest.mo14967doFinal(bArr3, 0);
            return C6238Arrays.m18242copyOf(bArr3, this.f24100N);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: PRF_msg */
        public byte[] mo18161PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            int i = this.f24100N;
            byte[] bArr4 = new byte[i];
            this.harakaSXof.m18154update(bArr, 0, bArr.length);
            this.harakaSXof.m18154update(bArr2, 0, bArr2.length);
            this.harakaSXof.m18154update(bArr3, 0, bArr3.length);
            this.harakaSXof.m18152doFinal(bArr4, 0, i);
            return bArr4;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: T_l */
        public byte[] mo18162T_l(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2) {
            int i = this.f24100N;
            byte[] bArr3 = new byte[i];
            byte[] bArrM18164bitmask = m18164bitmask(c6224adrs, bArr2);
            HarakaSXof harakaSXof = this.harakaSXof;
            byte[] bArr4 = c6224adrs.f24077value;
            harakaSXof.m18154update(bArr4, 0, bArr4.length);
            this.harakaSXof.m18154update(bArrM18164bitmask, 0, bArrM18164bitmask.length);
            this.harakaSXof.m18152doFinal(bArr3, 0, i);
            return bArr3;
        }

        /* renamed from: bitmask */
        public byte[] m18164bitmask(C6224ADRS c6224adrs, byte[] bArr) {
            if (this.f24103robust) {
                int length = bArr.length;
                byte[] bArr2 = new byte[length];
                HarakaSXof harakaSXof = this.harakaSXof;
                byte[] bArr3 = c6224adrs.f24077value;
                harakaSXof.m18154update(bArr3, 0, bArr3.length);
                this.harakaSXof.m18152doFinal(bArr2, 0, length);
                C6240Bytes.m18281xorTo(bArr.length, bArr2, bArr);
            }
            return bArr;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: init */
        public void mo18163init(byte[] bArr) {
            HarakaSXof harakaSXof = new HarakaSXof(bArr);
            this.harakaSXof = harakaSXof;
            this.harakaS256Digest = new HarakaS256Digest(harakaSXof);
            this.harakaS512Digest = new HarakaS512Digest(this.harakaSXof);
        }
    }

    public static class Sha2Engine extends SPHINCSPlusEngine {

        /* renamed from: bl */
        private final int f24104bl;

        /* renamed from: hmacBuf */
        private final byte[] f24105hmacBuf;

        /* renamed from: mgf1 */
        private final MGF1BytesGenerator f24106mgf1;
        private final InterfaceC5277Digest msgDigest;
        private final byte[] msgDigestBuf;

        /* renamed from: msgMemo */
        private Memoable f24107msgMemo;

        /* renamed from: sha256 */
        private final InterfaceC5277Digest f24108sha256;
        private final byte[] sha256Buf;
        private Memoable sha256Memo;
        private final C5360HMac treeHMac;

        public Sha2Engine(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
            int i7;
            super(z, i, i2, i3, i4, i5, i6);
            SHA256Digest sHA256Digest = new SHA256Digest();
            this.f24108sha256 = sHA256Digest;
            this.sha256Buf = new byte[sHA256Digest.getDigestSize()];
            if (i == 16) {
                this.msgDigest = new SHA256Digest();
                this.treeHMac = new C5360HMac(new SHA256Digest());
                this.f24106mgf1 = new MGF1BytesGenerator(new SHA256Digest());
                i7 = 64;
            } else {
                this.msgDigest = new SHA512Digest();
                this.treeHMac = new C5360HMac(new SHA512Digest());
                this.f24106mgf1 = new MGF1BytesGenerator(new SHA512Digest());
                i7 = 128;
            }
            this.f24104bl = i7;
            this.f24105hmacBuf = new byte[this.treeHMac.getMacSize()];
            this.msgDigestBuf = new byte[this.msgDigest.getDigestSize()];
        }

        private byte[] compressedADRS(C6224ADRS c6224adrs) {
            byte[] bArr = new byte[22];
            System.arraycopy(c6224adrs.f24077value, 3, bArr, 0, 1);
            System.arraycopy(c6224adrs.f24077value, 8, bArr, 1, 8);
            System.arraycopy(c6224adrs.f24077value, 19, bArr, 9, 1);
            System.arraycopy(c6224adrs.f24077value, 20, bArr, 10, 12);
            return bArr;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: F */
        public byte[] mo18157F(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2) {
            byte[] bArrCompressedADRS = compressedADRS(c6224adrs);
            if (this.f24103robust) {
                bArr2 = bitmask256(C6238Arrays.concatenate(bArr, bArrCompressedADRS), bArr2);
            }
            ((Memoable) this.f24108sha256).mo14824reset(this.sha256Memo);
            this.f24108sha256.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.f24108sha256.mo14970update(bArr2, 0, bArr2.length);
            this.f24108sha256.mo14967doFinal(this.sha256Buf, 0);
            return C6238Arrays.copyOfRange(this.sha256Buf, 0, this.f24100N);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: H */
        public byte[] mo18158H(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2, byte[] bArr3) {
            byte[] bArrCompressedADRS = compressedADRS(c6224adrs);
            ((Memoable) this.msgDigest).mo14824reset(this.f24107msgMemo);
            this.msgDigest.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            if (this.f24103robust) {
                byte[] bArrM18166bitmask = m18166bitmask(C6238Arrays.concatenate(bArr, bArrCompressedADRS), bArr2, bArr3);
                this.msgDigest.mo14970update(bArrM18166bitmask, 0, bArrM18166bitmask.length);
            } else {
                this.msgDigest.mo14970update(bArr2, 0, bArr2.length);
                this.msgDigest.mo14970update(bArr3, 0, bArr3.length);
            }
            this.msgDigest.mo14967doFinal(this.msgDigestBuf, 0);
            return C6238Arrays.copyOfRange(this.msgDigestBuf, 0, this.f24100N);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: H_msg */
        public IndexedDigest mo18159H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            int i = ((this.f24095A * this.f24099K) + 7) / 8;
            int i2 = this.f24097H;
            int i3 = i2 / this.f24096D;
            int i4 = i2 - i3;
            int i5 = (i3 + 7) / 8;
            int i6 = (i4 + 7) / 8;
            byte[] bArr5 = new byte[this.msgDigest.getDigestSize()];
            this.msgDigest.mo14970update(bArr, 0, bArr.length);
            this.msgDigest.mo14970update(bArr2, 0, bArr2.length);
            this.msgDigest.mo14970update(bArr3, 0, bArr3.length);
            this.msgDigest.mo14970update(bArr4, 0, bArr4.length);
            this.msgDigest.mo14967doFinal(bArr5, 0);
            byte[] bArrM18165bitmask = m18165bitmask(C6238Arrays.concatenate(bArr, bArr2, bArr5), new byte[i + i5 + i6]);
            byte[] bArr6 = new byte[8];
            System.arraycopy(bArrM18165bitmask, i, bArr6, 8 - i6, i6);
            long jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr6, 0) & ((-1) >>> (64 - i4));
            byte[] bArr7 = new byte[4];
            System.arraycopy(bArrM18165bitmask, i6 + i, bArr7, 4 - i5, i5);
            return new IndexedDigest(jBigEndianToLong, AbstractC6245Pack.bigEndianToInt(bArr7, 0) & ((-1) >>> (32 - i3)), C6238Arrays.copyOfRange(bArrM18165bitmask, 0, i));
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: PRF */
        public byte[] mo18160PRF(byte[] bArr, byte[] bArr2, C6224ADRS c6224adrs) {
            int length = bArr2.length;
            ((Memoable) this.f24108sha256).mo14824reset(this.sha256Memo);
            byte[] bArrCompressedADRS = compressedADRS(c6224adrs);
            this.f24108sha256.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.f24108sha256.mo14970update(bArr2, 0, bArr2.length);
            this.f24108sha256.mo14967doFinal(this.sha256Buf, 0);
            return C6238Arrays.copyOfRange(this.sha256Buf, 0, length);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: PRF_msg */
        public byte[] mo18161PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.treeHMac.mo14976init(new KeyParameter(bArr));
            this.treeHMac.mo14979update(bArr2, 0, bArr2.length);
            this.treeHMac.mo14979update(bArr3, 0, bArr3.length);
            this.treeHMac.mo14975doFinal(this.f24105hmacBuf, 0);
            return C6238Arrays.copyOfRange(this.f24105hmacBuf, 0, this.f24100N);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: T_l */
        public byte[] mo18162T_l(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2) {
            byte[] bArrCompressedADRS = compressedADRS(c6224adrs);
            if (this.f24103robust) {
                bArr2 = m18165bitmask(C6238Arrays.concatenate(bArr, bArrCompressedADRS), bArr2);
            }
            ((Memoable) this.msgDigest).mo14824reset(this.f24107msgMemo);
            this.msgDigest.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.msgDigest.mo14970update(bArr2, 0, bArr2.length);
            this.msgDigest.mo14967doFinal(this.msgDigestBuf, 0);
            return C6238Arrays.copyOfRange(this.msgDigestBuf, 0, this.f24100N);
        }

        /* renamed from: bitmask */
        public byte[] m18165bitmask(byte[] bArr, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.f24106mgf1.mo14966init(new MGFParameters(bArr));
            this.f24106mgf1.generateBytes(bArr3, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr3);
            return bArr3;
        }

        public byte[] bitmask256(byte[] bArr, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            MGF1BytesGenerator mGF1BytesGenerator = new MGF1BytesGenerator(new SHA256Digest());
            mGF1BytesGenerator.mo14966init(new MGFParameters(bArr));
            mGF1BytesGenerator.generateBytes(bArr3, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr3);
            return bArr3;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: init */
        public void mo18163init(byte[] bArr) {
            byte[] bArr2 = new byte[this.f24104bl];
            this.msgDigest.mo14970update(bArr, 0, bArr.length);
            this.msgDigest.mo14970update(bArr2, 0, this.f24104bl - this.f24100N);
            this.f24107msgMemo = ((Memoable) this.msgDigest).mo14823copy();
            this.msgDigest.mo14968reset();
            this.f24108sha256.mo14970update(bArr, 0, bArr.length);
            this.f24108sha256.mo14970update(bArr2, 0, 64 - bArr.length);
            this.sha256Memo = ((Memoable) this.f24108sha256).mo14823copy();
            this.f24108sha256.mo14968reset();
        }

        /* renamed from: bitmask */
        public byte[] m18166bitmask(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            int length = bArr2.length + bArr3.length;
            byte[] bArr4 = new byte[length];
            this.f24106mgf1.mo14966init(new MGFParameters(bArr));
            this.f24106mgf1.generateBytes(bArr4, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr4);
            C6240Bytes.m18280xorTo(bArr3.length, bArr3, 0, bArr4, bArr2.length);
            return bArr4;
        }
    }

    public static class Shake256Engine extends SPHINCSPlusEngine {
        private final InterfaceC5284Xof maskDigest;
        private final InterfaceC5284Xof treeDigest;

        public Shake256Engine(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
            super(z, i, i2, i3, i4, i5, i6);
            this.treeDigest = new SHAKEDigest(256);
            this.maskDigest = new SHAKEDigest(256);
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: F */
        public byte[] mo18157F(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2) {
            if (this.f24103robust) {
                bArr2 = m18167bitmask(bArr, c6224adrs, bArr2);
            }
            int i = this.f24100N;
            byte[] bArr3 = new byte[i];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr4 = c6224adrs.f24077value;
            interfaceC5284Xof.mo14970update(bArr4, 0, bArr4.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14998doFinal(bArr3, 0, i);
            return bArr3;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: H */
        public byte[] mo18158H(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2, byte[] bArr3) {
            int i = this.f24100N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr5 = c6224adrs.f24077value;
            interfaceC5284Xof.mo14970update(bArr5, 0, bArr5.length);
            if (this.f24103robust) {
                byte[] bArrM18168bitmask = m18168bitmask(bArr, c6224adrs, bArr2, bArr3);
                this.treeDigest.mo14970update(bArrM18168bitmask, 0, bArrM18168bitmask.length);
            } else {
                this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
                this.treeDigest.mo14970update(bArr3, 0, bArr3.length);
            }
            this.treeDigest.mo14998doFinal(bArr4, 0, i);
            return bArr4;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: H_msg */
        public IndexedDigest mo18159H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            int i = ((this.f24095A * this.f24099K) + 7) / 8;
            int i2 = this.f24097H;
            int i3 = i2 / this.f24096D;
            int i4 = i2 - i3;
            int i5 = (i3 + 7) / 8;
            int i6 = (i4 + 7) / 8;
            int i7 = i + i5 + i6;
            byte[] bArr5 = new byte[i7];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14970update(bArr3, 0, bArr3.length);
            this.treeDigest.mo14970update(bArr4, 0, bArr4.length);
            this.treeDigest.mo14998doFinal(bArr5, 0, i7);
            byte[] bArr6 = new byte[8];
            System.arraycopy(bArr5, i, bArr6, 8 - i6, i6);
            long jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr6, 0) & ((-1) >>> (64 - i4));
            byte[] bArr7 = new byte[4];
            System.arraycopy(bArr5, i6 + i, bArr7, 4 - i5, i5);
            return new IndexedDigest(jBigEndianToLong, AbstractC6245Pack.bigEndianToInt(bArr7, 0) & ((-1) >>> (32 - i3)), C6238Arrays.copyOfRange(bArr5, 0, i));
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: PRF */
        public byte[] mo18160PRF(byte[] bArr, byte[] bArr2, C6224ADRS c6224adrs) {
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr3 = c6224adrs.f24077value;
            interfaceC5284Xof.mo14970update(bArr3, 0, bArr3.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            int i = this.f24100N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.mo14998doFinal(bArr4, 0, i);
            return bArr4;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: PRF_msg */
        public byte[] mo18161PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14970update(bArr3, 0, bArr3.length);
            int i = this.f24100N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.mo14998doFinal(bArr4, 0, i);
            return bArr4;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: T_l */
        public byte[] mo18162T_l(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2) {
            if (this.f24103robust) {
                bArr2 = m18167bitmask(bArr, c6224adrs, bArr2);
            }
            int i = this.f24100N;
            byte[] bArr3 = new byte[i];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr4 = c6224adrs.f24077value;
            interfaceC5284Xof.mo14970update(bArr4, 0, bArr4.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14998doFinal(bArr3, 0, i);
            return bArr3;
        }

        /* renamed from: bitmask */
        public byte[] m18167bitmask(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.maskDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.maskDigest;
            byte[] bArr4 = c6224adrs.f24077value;
            interfaceC5284Xof.mo14970update(bArr4, 0, bArr4.length);
            this.maskDigest.mo14998doFinal(bArr3, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr3);
            return bArr3;
        }

        @Override // org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine
        /* renamed from: init */
        public void mo18163init(byte[] bArr) {
        }

        /* renamed from: bitmask */
        public byte[] m18168bitmask(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2, byte[] bArr3) {
            int length = bArr2.length + bArr3.length;
            byte[] bArr4 = new byte[length];
            this.maskDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.maskDigest;
            byte[] bArr5 = c6224adrs.f24077value;
            interfaceC5284Xof.mo14970update(bArr5, 0, bArr5.length);
            this.maskDigest.mo14998doFinal(bArr4, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr4);
            C6240Bytes.m18280xorTo(bArr3.length, bArr3, 0, bArr4, bArr2.length);
            return bArr4;
        }
    }

    public SPHINCSPlusEngine(boolean z, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f24100N = i;
        if (i2 == 16) {
            this.WOTS_LOGW = 4;
            this.WOTS_LEN1 = (i * 8) / 4;
            if (i <= 8) {
                this.WOTS_LEN2 = 2;
            } else if (i <= 136) {
                this.WOTS_LEN2 = 3;
            } else {
                if (i > 256) {
                    throw new IllegalArgumentException("cannot precompute SPX_WOTS_LEN2 for n outside {2, .., 256}");
                }
                this.WOTS_LEN2 = 4;
            }
        } else {
            if (i2 != 256) {
                throw new IllegalArgumentException("wots_w assumed 16 or 256");
            }
            this.WOTS_LOGW = 8;
            this.WOTS_LEN1 = (i * 8) / 8;
            if (i <= 1) {
                this.WOTS_LEN2 = 1;
            } else {
                if (i > 256) {
                    throw new IllegalArgumentException("cannot precompute SPX_WOTS_LEN2 for n outside {2, .., 256}");
                }
                this.WOTS_LEN2 = 2;
            }
        }
        this.f24102WOTS_W = i2;
        this.WOTS_LEN = this.WOTS_LEN1 + this.WOTS_LEN2;
        this.f24103robust = z;
        this.f24096D = i3;
        this.f24095A = i4;
        this.f24099K = i5;
        this.f24097H = i6;
        this.f24098H_PRIME = i6 / i3;
        this.f24101T = 1 << i4;
    }

    /* renamed from: F */
    public abstract byte[] mo18157F(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2);

    /* renamed from: H */
    public abstract byte[] mo18158H(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2, byte[] bArr3);

    /* renamed from: H_msg */
    public abstract IndexedDigest mo18159H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    /* renamed from: PRF */
    public abstract byte[] mo18160PRF(byte[] bArr, byte[] bArr2, C6224ADRS c6224adrs);

    /* renamed from: PRF_msg */
    public abstract byte[] mo18161PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3);

    /* renamed from: T_l */
    public abstract byte[] mo18162T_l(byte[] bArr, C6224ADRS c6224adrs, byte[] bArr2);

    /* renamed from: init */
    public abstract void mo18163init(byte[] bArr);
}
