package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.generators.MGF1BytesGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.MGFParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.Memoable;

@Deprecated
/* loaded from: classes2.dex */
public abstract class SLHDSAEngine {

    /* renamed from: A */
    final int f23493A;

    /* renamed from: D */
    final int f23494D;

    /* renamed from: H */
    final int f23495H;

    /* renamed from: H_PRIME */
    final int f23496H_PRIME;

    /* renamed from: K */
    final int f23497K;

    /* renamed from: N */
    final int f23498N;
    final int WOTS_LEN;
    final int WOTS_LEN1;
    final int WOTS_LEN2;
    final int WOTS_LOGW;

    /* renamed from: WOTS_W */
    final int f23499WOTS_W;

    public static class Sha2Engine extends SLHDSAEngine {

        /* renamed from: bl */
        private final int f23500bl;

        /* renamed from: hmacBuf */
        private final byte[] f23501hmacBuf;

        /* renamed from: mgf1 */
        private final MGF1BytesGenerator f23502mgf1;
        private final InterfaceC5277Digest msgDigest;
        private final byte[] msgDigestBuf;

        /* renamed from: msgMemo */
        private Memoable f23503msgMemo;

        /* renamed from: sha256 */
        private final InterfaceC5277Digest f23504sha256;
        private final byte[] sha256Buf;
        private Memoable sha256Memo;
        private final C5360HMac treeHMac;

        public Sha2Engine(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7;
            super(i, i2, i3, i4, i5, i6);
            SHA256Digest sHA256Digest = new SHA256Digest();
            this.f23504sha256 = sHA256Digest;
            this.sha256Buf = new byte[sHA256Digest.getDigestSize()];
            if (i == 16) {
                this.msgDigest = new SHA256Digest();
                this.treeHMac = new C5360HMac(new SHA256Digest());
                this.f23502mgf1 = new MGF1BytesGenerator(new SHA256Digest());
                i7 = 64;
            } else {
                this.msgDigest = new SHA512Digest();
                this.treeHMac = new C5360HMac(new SHA512Digest());
                this.f23502mgf1 = new MGF1BytesGenerator(new SHA512Digest());
                i7 = 128;
            }
            this.f23500bl = i7;
            this.f23501hmacBuf = new byte[this.treeHMac.getMacSize()];
            this.msgDigestBuf = new byte[this.msgDigest.getDigestSize()];
        }

        private byte[] compressedADRS(C6093ADRS c6093adrs) {
            byte[] bArr = new byte[22];
            System.arraycopy(c6093adrs.f23472value, 3, bArr, 0, 1);
            System.arraycopy(c6093adrs.f23472value, 8, bArr, 1, 8);
            System.arraycopy(c6093adrs.f23472value, 19, bArr, 9, 1);
            System.arraycopy(c6093adrs.f23472value, 20, bArr, 10, 12);
            return bArr;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: F */
        public byte[] mo17825F(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2) {
            byte[] bArrCompressedADRS = compressedADRS(c6093adrs);
            ((Memoable) this.f23504sha256).mo14824reset(this.sha256Memo);
            this.f23504sha256.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.f23504sha256.mo14970update(bArr2, 0, bArr2.length);
            this.f23504sha256.mo14967doFinal(this.sha256Buf, 0);
            return C6238Arrays.copyOfRange(this.sha256Buf, 0, this.f23498N);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: H */
        public byte[] mo17826H(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2, byte[] bArr3) {
            byte[] bArrCompressedADRS = compressedADRS(c6093adrs);
            ((Memoable) this.msgDigest).mo14824reset(this.f23503msgMemo);
            this.msgDigest.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.msgDigest.mo14970update(bArr2, 0, bArr2.length);
            this.msgDigest.mo14970update(bArr3, 0, bArr3.length);
            this.msgDigest.mo14967doFinal(this.msgDigestBuf, 0);
            return C6238Arrays.copyOfRange(this.msgDigestBuf, 0, this.f23498N);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: H_msg */
        public IndexedDigest mo17827H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
            int i = ((this.f23493A * this.f23497K) + 7) / 8;
            int i2 = this.f23495H;
            int i3 = i2 / this.f23494D;
            int i4 = i2 - i3;
            int i5 = (i3 + 7) / 8;
            int i6 = (i4 + 7) / 8;
            byte[] bArr6 = new byte[i + i5 + i6];
            byte[] bArr7 = new byte[this.msgDigest.getDigestSize()];
            this.msgDigest.mo14970update(bArr, 0, bArr.length);
            this.msgDigest.mo14970update(bArr2, 0, bArr2.length);
            this.msgDigest.mo14970update(bArr3, 0, bArr3.length);
            if (bArr4 != null) {
                this.msgDigest.mo14970update(bArr4, 0, bArr4.length);
            }
            this.msgDigest.mo14970update(bArr5, 0, bArr5.length);
            this.msgDigest.mo14967doFinal(bArr7, 0);
            byte[] bArrM17832bitmask = m17832bitmask(C6238Arrays.concatenate(bArr, bArr2, bArr7), bArr6);
            byte[] bArr8 = new byte[8];
            System.arraycopy(bArrM17832bitmask, i, bArr8, 8 - i6, i6);
            long jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr8, 0) & ((-1) >>> (64 - i4));
            byte[] bArr9 = new byte[4];
            System.arraycopy(bArrM17832bitmask, i6 + i, bArr9, 4 - i5, i5);
            return new IndexedDigest(jBigEndianToLong, AbstractC6245Pack.bigEndianToInt(bArr9, 0) & ((-1) >>> (32 - i3)), C6238Arrays.copyOfRange(bArrM17832bitmask, 0, i));
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: PRF */
        public byte[] mo17828PRF(byte[] bArr, byte[] bArr2, C6093ADRS c6093adrs) {
            int length = bArr2.length;
            ((Memoable) this.f23504sha256).mo14824reset(this.sha256Memo);
            byte[] bArrCompressedADRS = compressedADRS(c6093adrs);
            this.f23504sha256.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.f23504sha256.mo14970update(bArr2, 0, bArr2.length);
            this.f23504sha256.mo14967doFinal(this.sha256Buf, 0);
            return C6238Arrays.copyOfRange(this.sha256Buf, 0, length);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: PRF_msg */
        public byte[] mo17829PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            this.treeHMac.mo14976init(new KeyParameter(bArr));
            this.treeHMac.mo14979update(bArr2, 0, bArr2.length);
            if (bArr3 != null) {
                this.treeHMac.mo14979update(bArr3, 0, bArr3.length);
            }
            this.treeHMac.mo14979update(bArr4, 0, bArr4.length);
            this.treeHMac.mo14975doFinal(this.f23501hmacBuf, 0);
            return C6238Arrays.copyOfRange(this.f23501hmacBuf, 0, this.f23498N);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: T_l */
        public byte[] mo17830T_l(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2) {
            byte[] bArrCompressedADRS = compressedADRS(c6093adrs);
            ((Memoable) this.msgDigest).mo14824reset(this.f23503msgMemo);
            this.msgDigest.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.msgDigest.mo14970update(bArr2, 0, bArr2.length);
            this.msgDigest.mo14967doFinal(this.msgDigestBuf, 0);
            return C6238Arrays.copyOfRange(this.msgDigestBuf, 0, this.f23498N);
        }

        /* renamed from: bitmask */
        public byte[] m17832bitmask(byte[] bArr, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.f23502mgf1.mo14966init(new MGFParameters(bArr));
            this.f23502mgf1.generateBytes(bArr3, 0, length);
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

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: init */
        public void mo17831init(byte[] bArr) {
            byte[] bArr2 = new byte[this.f23500bl];
            this.msgDigest.mo14970update(bArr, 0, bArr.length);
            this.msgDigest.mo14970update(bArr2, 0, this.f23500bl - this.f23498N);
            this.f23503msgMemo = ((Memoable) this.msgDigest).mo14823copy();
            this.msgDigest.mo14968reset();
            this.f23504sha256.mo14970update(bArr, 0, bArr.length);
            this.f23504sha256.mo14970update(bArr2, 0, 64 - bArr.length);
            this.sha256Memo = ((Memoable) this.f23504sha256).mo14823copy();
            this.f23504sha256.mo14968reset();
        }

        /* renamed from: bitmask */
        public byte[] m17833bitmask(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            int length = bArr2.length + bArr3.length;
            byte[] bArr4 = new byte[length];
            this.f23502mgf1.mo14966init(new MGFParameters(bArr));
            this.f23502mgf1.generateBytes(bArr4, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr4);
            C6240Bytes.m18280xorTo(bArr3.length, bArr3, 0, bArr4, bArr2.length);
            return bArr4;
        }
    }

    public static class Shake256Engine extends SLHDSAEngine {
        private final InterfaceC5284Xof maskDigest;
        private final InterfaceC5284Xof treeDigest;

        public Shake256Engine(int i, int i2, int i3, int i4, int i5, int i6) {
            super(i, i2, i3, i4, i5, i6);
            this.treeDigest = new SHAKEDigest(256);
            this.maskDigest = new SHAKEDigest(256);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: F */
        public byte[] mo17825F(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2) {
            int i = this.f23498N;
            byte[] bArr3 = new byte[i];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr4 = c6093adrs.f23472value;
            interfaceC5284Xof.mo14970update(bArr4, 0, bArr4.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14998doFinal(bArr3, 0, i);
            return bArr3;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: H */
        public byte[] mo17826H(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2, byte[] bArr3) {
            int i = this.f23498N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr5 = c6093adrs.f23472value;
            interfaceC5284Xof.mo14970update(bArr5, 0, bArr5.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14970update(bArr3, 0, bArr3.length);
            this.treeDigest.mo14998doFinal(bArr4, 0, i);
            return bArr4;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: H_msg */
        public IndexedDigest mo17827H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
            int i = ((this.f23493A * this.f23497K) + 7) / 8;
            int i2 = this.f23495H;
            int i3 = i2 / this.f23494D;
            int i4 = i2 - i3;
            int i5 = (i3 + 7) / 8;
            int i6 = (i4 + 7) / 8;
            int i7 = i + i5 + i6;
            byte[] bArr6 = new byte[i7];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14970update(bArr3, 0, bArr3.length);
            if (bArr4 != null) {
                this.treeDigest.mo14970update(bArr4, 0, bArr4.length);
            }
            this.treeDigest.mo14970update(bArr5, 0, bArr5.length);
            this.treeDigest.mo14998doFinal(bArr6, 0, i7);
            byte[] bArr7 = new byte[8];
            System.arraycopy(bArr6, i, bArr7, 8 - i6, i6);
            long jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr7, 0) & ((-1) >>> (64 - i4));
            byte[] bArr8 = new byte[4];
            System.arraycopy(bArr6, i6 + i, bArr8, 4 - i5, i5);
            return new IndexedDigest(jBigEndianToLong, AbstractC6245Pack.bigEndianToInt(bArr8, 0) & ((-1) >>> (32 - i3)), C6238Arrays.copyOfRange(bArr6, 0, i));
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: PRF */
        public byte[] mo17828PRF(byte[] bArr, byte[] bArr2, C6093ADRS c6093adrs) {
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr3 = c6093adrs.f23472value;
            interfaceC5284Xof.mo14970update(bArr3, 0, bArr3.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            int i = this.f23498N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.mo14998doFinal(bArr4, 0, i);
            return bArr4;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: PRF_msg */
        public byte[] mo17829PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            if (bArr3 != null) {
                this.treeDigest.mo14970update(bArr3, 0, bArr3.length);
            }
            this.treeDigest.mo14970update(bArr4, 0, bArr4.length);
            int i = this.f23498N;
            byte[] bArr5 = new byte[i];
            this.treeDigest.mo14998doFinal(bArr5, 0, i);
            return bArr5;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: T_l */
        public byte[] mo17830T_l(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2) {
            int i = this.f23498N;
            byte[] bArr3 = new byte[i];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr4 = c6093adrs.f23472value;
            interfaceC5284Xof.mo14970update(bArr4, 0, bArr4.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14998doFinal(bArr3, 0, i);
            return bArr3;
        }

        /* renamed from: bitmask */
        public byte[] m17834bitmask(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.maskDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.maskDigest;
            byte[] bArr4 = c6093adrs.f23472value;
            interfaceC5284Xof.mo14970update(bArr4, 0, bArr4.length);
            this.maskDigest.mo14998doFinal(bArr3, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr3);
            return bArr3;
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p328slhdsa.SLHDSAEngine
        /* renamed from: init */
        public void mo17831init(byte[] bArr) {
        }

        /* renamed from: bitmask */
        public byte[] m17835bitmask(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2, byte[] bArr3) {
            int length = bArr2.length + bArr3.length;
            byte[] bArr4 = new byte[length];
            this.maskDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.maskDigest;
            byte[] bArr5 = c6093adrs.f23472value;
            interfaceC5284Xof.mo14970update(bArr5, 0, bArr5.length);
            this.maskDigest.mo14998doFinal(bArr4, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr4);
            C6240Bytes.m18280xorTo(bArr3.length, bArr3, 0, bArr4, bArr2.length);
            return bArr4;
        }
    }

    public SLHDSAEngine(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        this.f23498N = i;
        if (i2 == 16) {
            i7 = 4;
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
                this.WOTS_LEN2 = i7;
            }
        } else {
            if (i2 != 256) {
                throw new IllegalArgumentException("wots_w assumed 16 or 256");
            }
            this.WOTS_LOGW = 8;
            this.WOTS_LEN1 = (i * 8) / 8;
            i7 = 1;
            if (i > 1) {
                if (i > 256) {
                    throw new IllegalArgumentException("cannot precompute SPX_WOTS_LEN2 for n outside {2, .., 256}");
                }
                this.WOTS_LEN2 = 2;
            }
            this.WOTS_LEN2 = i7;
        }
        this.f23499WOTS_W = i2;
        this.WOTS_LEN = this.WOTS_LEN1 + this.WOTS_LEN2;
        this.f23494D = i3;
        this.f23493A = i4;
        this.f23497K = i5;
        this.f23495H = i6;
        this.f23496H_PRIME = i6 / i3;
    }

    public static AsymmetricCipherKeyPair implGenerateKeyPair(SLHDSAParameters sLHDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SLHDSAEngine engine = sLHDSAParameters.getEngine();
        C6098SK c6098sk = new C6098SK(bArr, bArr2);
        engine.mo17831init(bArr3);
        C6096PK c6096pk = new C6096PK(bArr3, new C6095HT(engine, c6098sk.f23492seed, bArr3).htPubKey);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new SLHDSAPublicKeyParameters(sLHDSAParameters, c6096pk), (AsymmetricKeyParameter) new SLHDSAPrivateKeyParameters(sLHDSAParameters, c6098sk, c6096pk));
    }

    public static byte[] internalGenerateSignature(SLHDSAPrivateKeyParameters sLHDSAPrivateKeyParameters, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SLHDSAEngine engine = sLHDSAPrivateKeyParameters.getParameters().getEngine();
        engine.mo17831init(sLHDSAPrivateKeyParameters.f23519pk.f23485seed);
        C6094Fors c6094Fors = new C6094Fors(engine);
        byte[] bArrMo17829PRF_msg = engine.mo17829PRF_msg(sLHDSAPrivateKeyParameters.f23520sk.f23491prf, bArr3, bArr, bArr2);
        C6096PK c6096pk = sLHDSAPrivateKeyParameters.f23519pk;
        IndexedDigest indexedDigestMo17827H_msg = engine.mo17827H_msg(bArrMo17829PRF_msg, c6096pk.f23485seed, c6096pk.f23484root, bArr, bArr2);
        byte[] bArr4 = indexedDigestMo17827H_msg.f23483digest;
        long j = indexedDigestMo17827H_msg.idx_tree;
        int i = indexedDigestMo17827H_msg.idx_leaf;
        C6093ADRS c6093adrs = new C6093ADRS();
        c6093adrs.setTypeAndClear(3);
        c6093adrs.setTreeAddress(j);
        c6093adrs.setKeyPairAddress(i);
        SIG_FORS[] sig_forsArrM17820sign = c6094Fors.m17820sign(bArr4, sLHDSAPrivateKeyParameters.f23520sk.f23492seed, sLHDSAPrivateKeyParameters.f23519pk.f23485seed, c6093adrs);
        C6093ADRS c6093adrs2 = new C6093ADRS();
        c6093adrs2.setTypeAndClear(3);
        c6093adrs2.setTreeAddress(j);
        c6093adrs2.setKeyPairAddress(i);
        byte[] bArrPkFromSig = c6094Fors.pkFromSig(sig_forsArrM17820sign, bArr4, sLHDSAPrivateKeyParameters.f23519pk.f23485seed, c6093adrs2);
        new C6093ADRS().setTypeAndClear(2);
        byte[] bArrM17821sign = new C6095HT(engine, sLHDSAPrivateKeyParameters.m17843getSeed(), sLHDSAPrivateKeyParameters.getPublicSeed()).m17821sign(bArrPkFromSig, j, i);
        int length = sig_forsArrM17820sign.length;
        byte[][] bArr5 = new byte[length + 2][];
        int i2 = 0;
        bArr5[0] = bArrMo17829PRF_msg;
        while (i2 != sig_forsArrM17820sign.length) {
            int i3 = i2 + 1;
            SIG_FORS sig_fors = sig_forsArrM17820sign[i2];
            bArr5[i3] = C6238Arrays.concatenate(sig_fors.f23488sk, C6238Arrays.concatenate(sig_fors.authPath));
            i2 = i3;
        }
        bArr5[length + 1] = bArrM17821sign;
        return C6238Arrays.concatenate(bArr5);
    }

    public static boolean internalVerifySignature(SLHDSAPublicKeyParameters sLHDSAPublicKeyParameters, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SLHDSAEngine engine = sLHDSAPublicKeyParameters.getParameters().getEngine();
        engine.mo17831init(sLHDSAPublicKeyParameters.m17845getSeed());
        C6093ADRS c6093adrs = new C6093ADRS();
        int i = engine.f23497K;
        int i2 = engine.f23493A;
        int i3 = ((i2 + 1) * i) + 1 + engine.f23495H;
        int i4 = engine.f23494D;
        int i5 = engine.WOTS_LEN;
        int i6 = engine.f23498N;
        if ((i3 + (i4 * i5)) * i6 != bArr3.length) {
            return false;
        }
        C6097SIG c6097sig = new C6097SIG(i6, i, i2, i4, engine.f23496H_PRIME, i5, bArr3);
        byte[] bArrM17823getR = c6097sig.m17823getR();
        SIG_FORS[] sig_fors = c6097sig.getSIG_FORS();
        SIG_XMSS[] sig_ht = c6097sig.getSIG_HT();
        IndexedDigest indexedDigestMo17827H_msg = engine.mo17827H_msg(bArrM17823getR, sLHDSAPublicKeyParameters.m17845getSeed(), sLHDSAPublicKeyParameters.m17844getRoot(), bArr, bArr2);
        byte[] bArr4 = indexedDigestMo17827H_msg.f23483digest;
        long j = indexedDigestMo17827H_msg.idx_tree;
        int i7 = indexedDigestMo17827H_msg.idx_leaf;
        c6093adrs.setTypeAndClear(3);
        c6093adrs.setLayerAddress(0);
        c6093adrs.setTreeAddress(j);
        c6093adrs.setKeyPairAddress(i7);
        byte[] bArrPkFromSig = new C6094Fors(engine).pkFromSig(sig_fors, bArr4, sLHDSAPublicKeyParameters.m17845getSeed(), c6093adrs);
        c6093adrs.setTypeAndClear(2);
        c6093adrs.setLayerAddress(0);
        c6093adrs.setTreeAddress(j);
        c6093adrs.setKeyPairAddress(i7);
        return new C6095HT(engine, null, sLHDSAPublicKeyParameters.m17845getSeed()).m17822verify(bArrPkFromSig, sig_ht, sLHDSAPublicKeyParameters.m17845getSeed(), j, i7, sLHDSAPublicKeyParameters.m17844getRoot());
    }

    /* renamed from: F */
    public abstract byte[] mo17825F(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2);

    /* renamed from: H */
    public abstract byte[] mo17826H(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2, byte[] bArr3);

    /* renamed from: H_msg */
    public abstract IndexedDigest mo17827H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    /* renamed from: PRF */
    public abstract byte[] mo17828PRF(byte[] bArr, byte[] bArr2, C6093ADRS c6093adrs);

    /* renamed from: PRF_msg */
    public abstract byte[] mo17829PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    /* renamed from: T_l */
    public abstract byte[] mo17830T_l(byte[] bArr, C6093ADRS c6093adrs, byte[] bArr2);

    /* renamed from: init */
    public abstract void mo17831init(byte[] bArr);
}
