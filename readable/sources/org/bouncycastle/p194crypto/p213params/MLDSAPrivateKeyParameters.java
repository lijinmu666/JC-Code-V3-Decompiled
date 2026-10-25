package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.p217signers.p218mldsa.MLDSAEngine;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLDSAPrivateKeyParameters extends MLDSAKeyParameters {

    /* renamed from: BOTH */
    public static final int f20783BOTH = 0;
    public static final int EXPANDED_KEY = 2;
    public static final int SEED_ONLY = 1;

    /* renamed from: k */
    final byte[] f20784k;
    private final int prefFormat;

    /* renamed from: rho */
    final byte[] f20785rho;

    /* renamed from: s1 */
    final byte[] f20786s1;

    /* renamed from: s2 */
    final byte[] f20787s2;

    /* renamed from: seed */
    private final byte[] f20788seed;

    /* renamed from: t0 */
    final byte[] f20789t0;

    /* renamed from: t1 */
    private final byte[] f20790t1;

    /* renamed from: tr */
    final byte[] f20791tr;

    public MLDSAPrivateKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr) {
        this(mLDSAParameters, bArr, null);
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(new byte[][]{this.f20785rho, this.f20784k, this.f20791tr, this.f20786s1, this.f20787s2, this.f20789t0});
    }

    /* renamed from: getK */
    public byte[] m15779getK() {
        return C6238Arrays.m18231clone(this.f20784k);
    }

    public MLDSAPrivateKeyParameters getParametersWithFormat(int i) {
        if (this.prefFormat == i) {
            return this;
        }
        if (i == 0 || i == 1) {
            if (this.f20788seed == null) {
                throw new IllegalStateException("no seed available");
            }
        } else if (i != 2) {
            throw new IllegalArgumentException("unknown format");
        }
        return new MLDSAPrivateKeyParameters(this, i);
    }

    public int getPreferredFormat() {
        return this.prefFormat;
    }

    @Deprecated
    public byte[] getPrivateKey() {
        return getEncoded();
    }

    public byte[] getPublicKey() {
        return MLDSAPublicKeyParameters.getEncoded(this.f20785rho, this.f20790t1);
    }

    public MLDSAPublicKeyParameters getPublicKeyParameters() {
        if (this.f20790t1 == null) {
            return null;
        }
        return new MLDSAPublicKeyParameters(getParameters(), this.f20785rho, this.f20790t1);
    }

    /* renamed from: getRho */
    public byte[] m15780getRho() {
        return C6238Arrays.m18231clone(this.f20785rho);
    }

    /* renamed from: getS1 */
    public byte[] m15781getS1() {
        return C6238Arrays.m18231clone(this.f20786s1);
    }

    /* renamed from: getS2 */
    public byte[] m15782getS2() {
        return C6238Arrays.m18231clone(this.f20787s2);
    }

    /* renamed from: getSeed */
    public byte[] m15783getSeed() {
        return C6238Arrays.m18231clone(this.f20788seed);
    }

    /* renamed from: getT0 */
    public byte[] m15784getT0() {
        return C6238Arrays.m18231clone(this.f20789t0);
    }

    /* renamed from: getT1 */
    public byte[] m15785getT1() {
        return C6238Arrays.m18231clone(this.f20790t1);
    }

    /* renamed from: getTr */
    public byte[] m15786getTr() {
        return C6238Arrays.m18231clone(this.f20791tr);
    }

    public MLDSAPrivateKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr, MLDSAPublicKeyParameters mLDSAPublicKeyParameters) {
        super(true, mLDSAParameters);
        MLDSAEngine mLDSAEngine = MLDSAEngine.getInstance(mLDSAParameters, null);
        if (bArr.length == 32) {
            byte[][] bArrGenerateKeyPairInternal = mLDSAEngine.generateKeyPairInternal(bArr);
            this.f20785rho = bArrGenerateKeyPairInternal[0];
            this.f20784k = bArrGenerateKeyPairInternal[1];
            this.f20791tr = bArrGenerateKeyPairInternal[2];
            this.f20786s1 = bArrGenerateKeyPairInternal[3];
            this.f20787s2 = bArrGenerateKeyPairInternal[4];
            this.f20789t0 = bArrGenerateKeyPairInternal[5];
            this.f20790t1 = bArrGenerateKeyPairInternal[6];
            this.f20788seed = bArrGenerateKeyPairInternal[7];
        } else {
            byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, 32);
            this.f20785rho = bArrCopyOfRange;
            byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr, 32, 64);
            this.f20784k = bArrCopyOfRange2;
            byte[] bArrCopyOfRange3 = C6238Arrays.copyOfRange(bArr, 64, 128);
            this.f20791tr = bArrCopyOfRange3;
            int dilithiumL = (mLDSAEngine.getDilithiumL() * mLDSAEngine.getDilithiumPolyEtaPackedBytes()) + 128;
            byte[] bArrCopyOfRange4 = C6238Arrays.copyOfRange(bArr, 128, dilithiumL);
            this.f20786s1 = bArrCopyOfRange4;
            int dilithiumK = (mLDSAEngine.getDilithiumK() * mLDSAEngine.getDilithiumPolyEtaPackedBytes()) + dilithiumL;
            byte[] bArrCopyOfRange5 = C6238Arrays.copyOfRange(bArr, dilithiumL, dilithiumK);
            this.f20787s2 = bArrCopyOfRange5;
            byte[] bArrCopyOfRange6 = C6238Arrays.copyOfRange(bArr, dilithiumK, (mLDSAEngine.getDilithiumK() * 416) + dilithiumK);
            this.f20789t0 = bArrCopyOfRange6;
            this.f20790t1 = mLDSAEngine.deriveT1(bArrCopyOfRange, bArrCopyOfRange2, bArrCopyOfRange3, bArrCopyOfRange4, bArrCopyOfRange5, bArrCopyOfRange6);
            this.f20788seed = null;
        }
        if (mLDSAPublicKeyParameters != null && !C6238Arrays.constantTimeAreEqual(this.f20790t1, mLDSAPublicKeyParameters.m15788getT1())) {
            throw new IllegalArgumentException("passed in public key does not match private values");
        }
        this.prefFormat = this.f20788seed != null ? 0 : 2;
    }

    public MLDSAPrivateKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        this(mLDSAParameters, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, null);
    }

    public MLDSAPrivateKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8) {
        super(true, mLDSAParameters);
        this.f20785rho = C6238Arrays.m18231clone(bArr);
        this.f20784k = C6238Arrays.m18231clone(bArr2);
        this.f20791tr = C6238Arrays.m18231clone(bArr3);
        this.f20786s1 = C6238Arrays.m18231clone(bArr4);
        this.f20787s2 = C6238Arrays.m18231clone(bArr5);
        this.f20789t0 = C6238Arrays.m18231clone(bArr6);
        this.f20790t1 = C6238Arrays.m18231clone(bArr7);
        this.f20788seed = C6238Arrays.m18231clone(bArr8);
        this.prefFormat = bArr8 != null ? 0 : 2;
    }

    private MLDSAPrivateKeyParameters(MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters, int i) {
        super(true, mLDSAPrivateKeyParameters.getParameters());
        this.f20785rho = mLDSAPrivateKeyParameters.f20785rho;
        this.f20784k = mLDSAPrivateKeyParameters.f20784k;
        this.f20791tr = mLDSAPrivateKeyParameters.f20791tr;
        this.f20786s1 = mLDSAPrivateKeyParameters.f20786s1;
        this.f20787s2 = mLDSAPrivateKeyParameters.f20787s2;
        this.f20789t0 = mLDSAPrivateKeyParameters.f20789t0;
        this.f20790t1 = mLDSAPrivateKeyParameters.f20790t1;
        this.f20788seed = mLDSAPrivateKeyParameters.f20788seed;
        this.prefFormat = i;
    }
}
