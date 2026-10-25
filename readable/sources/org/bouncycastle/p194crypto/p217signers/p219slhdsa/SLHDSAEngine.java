package org.bouncycastle.p194crypto.p217signers.p219slhdsa;

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
import org.bouncycastle.p194crypto.p213params.SLHDSAParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPublicKeyParameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public abstract class SLHDSAEngine {

    /* renamed from: A */
    final int f21077A;

    /* renamed from: D */
    final int f21078D;

    /* renamed from: H */
    final int f21079H;

    /* renamed from: H_PRIME */
    final int f21080H_PRIME;

    /* renamed from: K */
    final int f21081K;

    /* renamed from: N */
    final int f21082N;
    final int WOTS_LEN;
    final int WOTS_LEN1;
    final int WOTS_LEN2;
    final int WOTS_LOGW;

    /* renamed from: WOTS_W */
    final int f21083WOTS_W;

    public static class Sha2Engine extends SLHDSAEngine {

        /* renamed from: bl */
        private final int f21084bl;

        /* renamed from: hmacBuf */
        private final byte[] f21085hmacBuf;

        /* renamed from: mgf1 */
        private final MGF1BytesGenerator f21086mgf1;
        private final InterfaceC5277Digest msgDigest;
        private final byte[] msgDigestBuf;

        /* renamed from: msgMemo */
        private Memoable f21087msgMemo;

        /* renamed from: sha256 */
        private final InterfaceC5277Digest f21088sha256;
        private final byte[] sha256Buf;
        private Memoable sha256Memo;
        private final C5360HMac treeHMac;

        public Sha2Engine(int i, int i2, int i3, int i4, int i5, int i6) {
            int i7;
            super(i, i2, i3, i4, i5, i6);
            SHA256Digest sHA256Digest = new SHA256Digest();
            this.f21088sha256 = sHA256Digest;
            this.sha256Buf = new byte[sHA256Digest.getDigestSize()];
            if (i == 16) {
                this.msgDigest = new SHA256Digest();
                this.treeHMac = new C5360HMac(new SHA256Digest());
                this.f21086mgf1 = new MGF1BytesGenerator(new SHA256Digest());
                i7 = 64;
            } else {
                this.msgDigest = new SHA512Digest();
                this.treeHMac = new C5360HMac(new SHA512Digest());
                this.f21086mgf1 = new MGF1BytesGenerator(new SHA512Digest());
                i7 = 128;
            }
            this.f21084bl = i7;
            this.f21085hmacBuf = new byte[this.treeHMac.getMacSize()];
            this.msgDigestBuf = new byte[this.msgDigest.getDigestSize()];
        }

        private byte[] compressedADRS(C5392ADRS c5392adrs) {
            byte[] bArr = new byte[22];
            System.arraycopy(c5392adrs.f21065value, 3, bArr, 0, 1);
            System.arraycopy(c5392adrs.f21065value, 8, bArr, 1, 8);
            System.arraycopy(c5392adrs.f21065value, 19, bArr, 9, 1);
            System.arraycopy(c5392adrs.f21065value, 20, bArr, 10, 12);
            return bArr;
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: F */
        public byte[] mo15887F(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2) {
            byte[] bArrCompressedADRS = compressedADRS(c5392adrs);
            ((Memoable) this.f21088sha256).mo14824reset(this.sha256Memo);
            this.f21088sha256.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.f21088sha256.mo14970update(bArr2, 0, bArr2.length);
            this.f21088sha256.mo14967doFinal(this.sha256Buf, 0);
            return C6238Arrays.copyOfRange(this.sha256Buf, 0, this.f21082N);
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: H */
        public byte[] mo15888H(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2, byte[] bArr3) {
            byte[] bArrCompressedADRS = compressedADRS(c5392adrs);
            ((Memoable) this.msgDigest).mo14824reset(this.f21087msgMemo);
            this.msgDigest.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.msgDigest.mo14970update(bArr2, 0, bArr2.length);
            this.msgDigest.mo14970update(bArr3, 0, bArr3.length);
            this.msgDigest.mo14967doFinal(this.msgDigestBuf, 0);
            return C6238Arrays.copyOfRange(this.msgDigestBuf, 0, this.f21082N);
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: H_msg */
        public IndexedDigest mo15889H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
            int i = ((this.f21077A * this.f21081K) + 7) / 8;
            int i2 = this.f21079H;
            int i3 = i2 / this.f21078D;
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
            byte[] bArrM15894bitmask = m15894bitmask(C6238Arrays.concatenate(bArr, bArr2, bArr7), bArr6);
            byte[] bArr8 = new byte[8];
            System.arraycopy(bArrM15894bitmask, i, bArr8, 8 - i6, i6);
            long jBigEndianToLong = AbstractC6245Pack.bigEndianToLong(bArr8, 0) & ((-1) >>> (64 - i4));
            byte[] bArr9 = new byte[4];
            System.arraycopy(bArrM15894bitmask, i6 + i, bArr9, 4 - i5, i5);
            return new IndexedDigest(jBigEndianToLong, AbstractC6245Pack.bigEndianToInt(bArr9, 0) & ((-1) >>> (32 - i3)), C6238Arrays.copyOfRange(bArrM15894bitmask, 0, i));
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: PRF */
        public byte[] mo15890PRF(byte[] bArr, byte[] bArr2, C5392ADRS c5392adrs) {
            int length = bArr2.length;
            ((Memoable) this.f21088sha256).mo14824reset(this.sha256Memo);
            byte[] bArrCompressedADRS = compressedADRS(c5392adrs);
            this.f21088sha256.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.f21088sha256.mo14970update(bArr2, 0, bArr2.length);
            this.f21088sha256.mo14967doFinal(this.sha256Buf, 0);
            return C6238Arrays.copyOfRange(this.sha256Buf, 0, length);
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: PRF_msg */
        public byte[] mo15891PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            this.treeHMac.mo14976init(new KeyParameter(bArr));
            this.treeHMac.mo14979update(bArr2, 0, bArr2.length);
            if (bArr3 != null) {
                this.treeHMac.mo14979update(bArr3, 0, bArr3.length);
            }
            this.treeHMac.mo14979update(bArr4, 0, bArr4.length);
            this.treeHMac.mo14975doFinal(this.f21085hmacBuf, 0);
            return C6238Arrays.copyOfRange(this.f21085hmacBuf, 0, this.f21082N);
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: T_l */
        public byte[] mo15892T_l(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2) {
            byte[] bArrCompressedADRS = compressedADRS(c5392adrs);
            ((Memoable) this.msgDigest).mo14824reset(this.f21087msgMemo);
            this.msgDigest.mo14970update(bArrCompressedADRS, 0, bArrCompressedADRS.length);
            this.msgDigest.mo14970update(bArr2, 0, bArr2.length);
            this.msgDigest.mo14967doFinal(this.msgDigestBuf, 0);
            return C6238Arrays.copyOfRange(this.msgDigestBuf, 0, this.f21082N);
        }

        /* renamed from: bitmask */
        public byte[] m15894bitmask(byte[] bArr, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.f21086mgf1.mo14966init(new MGFParameters(bArr));
            this.f21086mgf1.generateBytes(bArr3, 0, length);
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

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: init */
        public void mo15893init(byte[] bArr) {
            byte[] bArr2 = new byte[this.f21084bl];
            this.msgDigest.mo14970update(bArr, 0, bArr.length);
            this.msgDigest.mo14970update(bArr2, 0, this.f21084bl - this.f21082N);
            this.f21087msgMemo = ((Memoable) this.msgDigest).mo14823copy();
            this.msgDigest.mo14968reset();
            this.f21088sha256.mo14970update(bArr, 0, bArr.length);
            this.f21088sha256.mo14970update(bArr2, 0, 64 - bArr.length);
            this.sha256Memo = ((Memoable) this.f21088sha256).mo14823copy();
            this.f21088sha256.mo14968reset();
        }

        /* renamed from: bitmask */
        public byte[] m15895bitmask(byte[] bArr, byte[] bArr2, byte[] bArr3) {
            int length = bArr2.length + bArr3.length;
            byte[] bArr4 = new byte[length];
            this.f21086mgf1.mo14966init(new MGFParameters(bArr));
            this.f21086mgf1.generateBytes(bArr4, 0, length);
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

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: F */
        public byte[] mo15887F(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2) {
            int i = this.f21082N;
            byte[] bArr3 = new byte[i];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr4 = c5392adrs.f21065value;
            interfaceC5284Xof.mo14970update(bArr4, 0, bArr4.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14998doFinal(bArr3, 0, i);
            return bArr3;
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: H */
        public byte[] mo15888H(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2, byte[] bArr3) {
            int i = this.f21082N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr5 = c5392adrs.f21065value;
            interfaceC5284Xof.mo14970update(bArr5, 0, bArr5.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14970update(bArr3, 0, bArr3.length);
            this.treeDigest.mo14998doFinal(bArr4, 0, i);
            return bArr4;
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: H_msg */
        public IndexedDigest mo15889H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
            int i = ((this.f21077A * this.f21081K) + 7) / 8;
            int i2 = this.f21079H;
            int i3 = i2 / this.f21078D;
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

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: PRF */
        public byte[] mo15890PRF(byte[] bArr, byte[] bArr2, C5392ADRS c5392adrs) {
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr3 = c5392adrs.f21065value;
            interfaceC5284Xof.mo14970update(bArr3, 0, bArr3.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            int i = this.f21082N;
            byte[] bArr4 = new byte[i];
            this.treeDigest.mo14998doFinal(bArr4, 0, i);
            return bArr4;
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: PRF_msg */
        public byte[] mo15891PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            if (bArr3 != null) {
                this.treeDigest.mo14970update(bArr3, 0, bArr3.length);
            }
            this.treeDigest.mo14970update(bArr4, 0, bArr4.length);
            int i = this.f21082N;
            byte[] bArr5 = new byte[i];
            this.treeDigest.mo14998doFinal(bArr5, 0, i);
            return bArr5;
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: T_l */
        public byte[] mo15892T_l(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2) {
            int i = this.f21082N;
            byte[] bArr3 = new byte[i];
            this.treeDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.treeDigest;
            byte[] bArr4 = c5392adrs.f21065value;
            interfaceC5284Xof.mo14970update(bArr4, 0, bArr4.length);
            this.treeDigest.mo14970update(bArr2, 0, bArr2.length);
            this.treeDigest.mo14998doFinal(bArr3, 0, i);
            return bArr3;
        }

        /* renamed from: bitmask */
        public byte[] m15896bitmask(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2) {
            int length = bArr2.length;
            byte[] bArr3 = new byte[length];
            this.maskDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.maskDigest;
            byte[] bArr4 = c5392adrs.f21065value;
            interfaceC5284Xof.mo14970update(bArr4, 0, bArr4.length);
            this.maskDigest.mo14998doFinal(bArr3, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr3);
            return bArr3;
        }

        @Override // org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine
        /* renamed from: init */
        public void mo15893init(byte[] bArr) {
        }

        /* renamed from: bitmask */
        public byte[] m15897bitmask(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2, byte[] bArr3) {
            int length = bArr2.length + bArr3.length;
            byte[] bArr4 = new byte[length];
            this.maskDigest.mo14970update(bArr, 0, bArr.length);
            InterfaceC5284Xof interfaceC5284Xof = this.maskDigest;
            byte[] bArr5 = c5392adrs.f21065value;
            interfaceC5284Xof.mo14970update(bArr5, 0, bArr5.length);
            this.maskDigest.mo14998doFinal(bArr4, 0, length);
            C6240Bytes.m18281xorTo(bArr2.length, bArr2, bArr4);
            C6240Bytes.m18280xorTo(bArr3.length, bArr3, 0, bArr4, bArr2.length);
            return bArr4;
        }
    }

    public SLHDSAEngine(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7;
        this.f21082N = i;
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
        this.f21083WOTS_W = i2;
        this.WOTS_LEN = this.WOTS_LEN1 + this.WOTS_LEN2;
        this.f21078D = i3;
        this.f21077A = i4;
        this.f21081K = i5;
        this.f21079H = i6;
        this.f21080H_PRIME = i6 / i3;
    }

    public static AsymmetricCipherKeyPair implGenerateKeyPair(SLHDSAParameters sLHDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        SLHDSAEngine engine = sLHDSAParameters.getEngine();
        engine.mo15893init(bArr3);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new SLHDSAPublicKeyParameters(sLHDSAParameters, C6238Arrays.concatenate(bArr3, new C5394HT(engine, bArr, bArr3).htPubKey)), (AsymmetricKeyParameter) new SLHDSAPrivateKeyParameters(sLHDSAParameters, bArr, bArr2, bArr3, new C5394HT(engine, bArr, bArr3).htPubKey));
    }

    public static byte[] internalGenerateSignature(SLHDSAParameters sLHDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        SLHDSAEngine engine = sLHDSAParameters.getEngine();
        engine.mo15893init(bArr3);
        C5393Fors c5393Fors = new C5393Fors(engine);
        byte[] bArrMo15891PRF_msg = engine.mo15891PRF_msg(bArr2, bArr7, bArr5, bArr6);
        IndexedDigest indexedDigestMo15889H_msg = engine.mo15889H_msg(bArrMo15891PRF_msg, bArr3, bArr4, bArr5, bArr6);
        byte[] bArr8 = indexedDigestMo15889H_msg.f21071digest;
        long j = indexedDigestMo15889H_msg.idx_tree;
        int i = indexedDigestMo15889H_msg.idx_leaf;
        C5392ADRS c5392adrs = new C5392ADRS();
        c5392adrs.setTypeAndClear(3);
        c5392adrs.setTreeAddress(j);
        c5392adrs.setKeyPairAddress(i);
        SIG_FORS[] sig_forsArrM15882sign = c5393Fors.m15882sign(bArr8, bArr, bArr3, c5392adrs);
        C5392ADRS c5392adrs2 = new C5392ADRS();
        c5392adrs2.setTypeAndClear(3);
        c5392adrs2.setTreeAddress(j);
        c5392adrs2.setKeyPairAddress(i);
        byte[] bArrPkFromSig = c5393Fors.pkFromSig(sig_forsArrM15882sign, bArr8, bArr3, c5392adrs2);
        new C5392ADRS().setTypeAndClear(2);
        byte[] bArrM15883sign = new C5394HT(engine, bArr, bArr3).m15883sign(bArrPkFromSig, j, i);
        int length = sig_forsArrM15882sign.length;
        byte[][] bArr9 = new byte[length + 2][];
        int i2 = 0;
        bArr9[0] = bArrMo15891PRF_msg;
        while (i2 != sig_forsArrM15882sign.length) {
            int i3 = i2 + 1;
            SIG_FORS sig_fors = sig_forsArrM15882sign[i2];
            bArr9[i3] = C6238Arrays.concatenate(sig_fors.f21074sk, C6238Arrays.concatenate(sig_fors.authPath));
            i2 = i3;
        }
        bArr9[length + 1] = bArrM15883sign;
        return C6238Arrays.concatenate(bArr9);
    }

    public static boolean internalVerifySignature(SLHDSAParameters sLHDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        SLHDSAEngine engine = sLHDSAParameters.getEngine();
        engine.mo15893init(bArr);
        C5392ADRS c5392adrs = new C5392ADRS();
        int i = engine.f21081K;
        int i2 = engine.f21077A;
        int i3 = ((i2 + 1) * i) + 1 + engine.f21079H;
        int i4 = engine.f21078D;
        int i5 = engine.WOTS_LEN;
        int i6 = engine.f21082N;
        if ((i3 + (i4 * i5)) * i6 != bArr5.length) {
            return false;
        }
        C5395SIG c5395sig = new C5395SIG(i6, i, i2, i4, engine.f21080H_PRIME, i5, bArr5);
        byte[] bArrM15885getR = c5395sig.m15885getR();
        SIG_FORS[] sig_fors = c5395sig.getSIG_FORS();
        SIG_XMSS[] sig_ht = c5395sig.getSIG_HT();
        IndexedDigest indexedDigestMo15889H_msg = engine.mo15889H_msg(bArrM15885getR, bArr, bArr2, bArr3, bArr4);
        byte[] bArr6 = indexedDigestMo15889H_msg.f21071digest;
        long j = indexedDigestMo15889H_msg.idx_tree;
        int i7 = indexedDigestMo15889H_msg.idx_leaf;
        c5392adrs.setTypeAndClear(3);
        c5392adrs.setLayerAddress(0);
        c5392adrs.setTreeAddress(j);
        c5392adrs.setKeyPairAddress(i7);
        byte[] bArrPkFromSig = new C5393Fors(engine).pkFromSig(sig_fors, bArr6, bArr, c5392adrs);
        c5392adrs.setTypeAndClear(2);
        c5392adrs.setLayerAddress(0);
        c5392adrs.setTreeAddress(j);
        c5392adrs.setKeyPairAddress(i7);
        return new C5394HT(engine, null, bArr).m15884verify(bArrPkFromSig, sig_ht, bArr, j, i7, bArr2);
    }

    /* renamed from: F */
    public abstract byte[] mo15887F(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2);

    /* renamed from: H */
    public abstract byte[] mo15888H(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2, byte[] bArr3);

    /* renamed from: H_msg */
    public abstract IndexedDigest mo15889H_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5);

    /* renamed from: PRF */
    public abstract byte[] mo15890PRF(byte[] bArr, byte[] bArr2, C5392ADRS c5392adrs);

    /* renamed from: PRF_msg */
    public abstract byte[] mo15891PRF_msg(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4);

    /* renamed from: T_l */
    public abstract byte[] mo15892T_l(byte[] bArr, C5392ADRS c5392adrs, byte[] bArr2);

    /* renamed from: init */
    public abstract void mo15893init(byte[] bArr);
}
