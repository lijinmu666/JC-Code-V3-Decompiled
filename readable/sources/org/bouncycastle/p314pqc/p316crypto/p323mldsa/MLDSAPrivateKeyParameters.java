package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import org.bouncycastle.p361util.C6238Arrays;

@Deprecated
/* loaded from: classes2.dex */
public class MLDSAPrivateKeyParameters extends MLDSAKeyParameters {

    /* renamed from: BOTH */
    public static final int f23311BOTH = 0;
    public static final int EXPANDED_KEY = 2;
    public static final int SEED_ONLY = 1;

    /* renamed from: k */
    final byte[] f23312k;
    private final int prefFormat;

    /* renamed from: rho */
    final byte[] f23313rho;

    /* renamed from: s1 */
    final byte[] f23314s1;

    /* renamed from: s2 */
    final byte[] f23315s2;

    /* renamed from: seed */
    private final byte[] f23316seed;

    /* renamed from: t0 */
    final byte[] f23317t0;

    /* renamed from: t1 */
    private final byte[] f23318t1;

    /* renamed from: tr */
    final byte[] f23319tr;

    public MLDSAPrivateKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr) {
        this(mLDSAParameters, bArr, null);
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(new byte[][]{this.f23313rho, this.f23312k, this.f23319tr, this.f23314s1, this.f23315s2, this.f23317t0});
    }

    /* renamed from: getK */
    public byte[] m17677getK() {
        return C6238Arrays.m18231clone(this.f23312k);
    }

    public MLDSAPrivateKeyParameters getParametersWithFormat(int i) {
        if (this.prefFormat == i) {
            return this;
        }
        if (i == 0 || i == 1) {
            if (this.f23316seed == null) {
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
        return MLDSAPublicKeyParameters.getEncoded(this.f23313rho, this.f23318t1);
    }

    public MLDSAPublicKeyParameters getPublicKeyParameters() {
        if (this.f23318t1 == null) {
            return null;
        }
        return new MLDSAPublicKeyParameters(getParameters(), this.f23313rho, this.f23318t1);
    }

    /* renamed from: getRho */
    public byte[] m17678getRho() {
        return C6238Arrays.m18231clone(this.f23313rho);
    }

    /* renamed from: getS1 */
    public byte[] m17679getS1() {
        return C6238Arrays.m18231clone(this.f23314s1);
    }

    /* renamed from: getS2 */
    public byte[] m17680getS2() {
        return C6238Arrays.m18231clone(this.f23315s2);
    }

    /* renamed from: getSeed */
    public byte[] m17681getSeed() {
        return C6238Arrays.m18231clone(this.f23316seed);
    }

    /* renamed from: getT0 */
    public byte[] m17682getT0() {
        return C6238Arrays.m18231clone(this.f23317t0);
    }

    /* renamed from: getT1 */
    public byte[] m17683getT1() {
        return C6238Arrays.m18231clone(this.f23318t1);
    }

    /* renamed from: getTr */
    public byte[] m17684getTr() {
        return C6238Arrays.m18231clone(this.f23319tr);
    }

    public MLDSAPrivateKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr, MLDSAPublicKeyParameters mLDSAPublicKeyParameters) {
        super(true, mLDSAParameters);
        MLDSAEngine engine = mLDSAParameters.getEngine(null);
        if (bArr.length == 32) {
            byte[][] bArrGenerateKeyPairInternal = engine.generateKeyPairInternal(bArr);
            this.f23313rho = bArrGenerateKeyPairInternal[0];
            this.f23312k = bArrGenerateKeyPairInternal[1];
            this.f23319tr = bArrGenerateKeyPairInternal[2];
            this.f23314s1 = bArrGenerateKeyPairInternal[3];
            this.f23315s2 = bArrGenerateKeyPairInternal[4];
            this.f23317t0 = bArrGenerateKeyPairInternal[5];
            this.f23318t1 = bArrGenerateKeyPairInternal[6];
            this.f23316seed = bArrGenerateKeyPairInternal[7];
        } else {
            byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, 32);
            this.f23313rho = bArrCopyOfRange;
            byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr, 32, 64);
            this.f23312k = bArrCopyOfRange2;
            byte[] bArrCopyOfRange3 = C6238Arrays.copyOfRange(bArr, 64, 128);
            this.f23319tr = bArrCopyOfRange3;
            int dilithiumL = (engine.getDilithiumL() * engine.getDilithiumPolyEtaPackedBytes()) + 128;
            byte[] bArrCopyOfRange4 = C6238Arrays.copyOfRange(bArr, 128, dilithiumL);
            this.f23314s1 = bArrCopyOfRange4;
            int dilithiumK = (engine.getDilithiumK() * engine.getDilithiumPolyEtaPackedBytes()) + dilithiumL;
            byte[] bArrCopyOfRange5 = C6238Arrays.copyOfRange(bArr, dilithiumL, dilithiumK);
            this.f23315s2 = bArrCopyOfRange5;
            byte[] bArrCopyOfRange6 = C6238Arrays.copyOfRange(bArr, dilithiumK, (engine.getDilithiumK() * 416) + dilithiumK);
            this.f23317t0 = bArrCopyOfRange6;
            this.f23318t1 = engine.deriveT1(bArrCopyOfRange, bArrCopyOfRange2, bArrCopyOfRange3, bArrCopyOfRange4, bArrCopyOfRange5, bArrCopyOfRange6);
            this.f23316seed = null;
        }
        if (mLDSAPublicKeyParameters != null && !C6238Arrays.constantTimeAreEqual(this.f23318t1, mLDSAPublicKeyParameters.m17686getT1())) {
            throw new IllegalArgumentException("passed in public key does not match private values");
        }
        this.prefFormat = this.f23316seed != null ? 0 : 2;
    }

    public MLDSAPrivateKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7) {
        this(mLDSAParameters, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, null);
    }

    public MLDSAPrivateKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8) {
        super(true, mLDSAParameters);
        this.f23313rho = C6238Arrays.m18231clone(bArr);
        this.f23312k = C6238Arrays.m18231clone(bArr2);
        this.f23319tr = C6238Arrays.m18231clone(bArr3);
        this.f23314s1 = C6238Arrays.m18231clone(bArr4);
        this.f23315s2 = C6238Arrays.m18231clone(bArr5);
        this.f23317t0 = C6238Arrays.m18231clone(bArr6);
        this.f23318t1 = C6238Arrays.m18231clone(bArr7);
        this.f23316seed = C6238Arrays.m18231clone(bArr8);
        this.prefFormat = bArr8 != null ? 0 : 2;
    }

    private MLDSAPrivateKeyParameters(MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters, int i) {
        super(true, mLDSAPrivateKeyParameters.getParameters());
        this.f23313rho = mLDSAPrivateKeyParameters.f23313rho;
        this.f23312k = mLDSAPrivateKeyParameters.f23312k;
        this.f23319tr = mLDSAPrivateKeyParameters.f23319tr;
        this.f23314s1 = mLDSAPrivateKeyParameters.f23314s1;
        this.f23315s2 = mLDSAPrivateKeyParameters.f23315s2;
        this.f23317t0 = mLDSAPrivateKeyParameters.f23317t0;
        this.f23318t1 = mLDSAPrivateKeyParameters.f23318t1;
        this.f23316seed = mLDSAPrivateKeyParameters.f23316seed;
        this.prefFormat = i;
    }
}
