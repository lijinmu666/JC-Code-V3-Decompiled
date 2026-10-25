package org.bouncycastle.p314pqc.p316crypto.p324mlkem;

import org.bouncycastle.p361util.C6238Arrays;

@Deprecated
/* loaded from: classes2.dex */
public class MLKEMPrivateKeyParameters extends MLKEMKeyParameters {

    /* renamed from: BOTH */
    public static final int f23346BOTH = 0;
    public static final int EXPANDED_KEY = 2;
    public static final int SEED_ONLY = 1;

    /* renamed from: hpk */
    final byte[] f23347hpk;

    /* renamed from: nonce */
    final byte[] f23348nonce;
    private final int prefFormat;

    /* renamed from: rho */
    final byte[] f23349rho;

    /* renamed from: s */
    final byte[] f23350s;

    /* renamed from: seed */
    final byte[] f23351seed;

    /* renamed from: t */
    final byte[] f23352t;

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr) {
        this(mLKEMParameters, bArr, null);
    }

    private void validate() {
        if (!getParameters().getEngine().checkPrivateKey(getEncoded())) {
            throw new IllegalArgumentException("'encoding' fails hash check");
        }
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(new byte[][]{this.f23350s, this.f23352t, this.f23349rho, this.f23347hpk, this.f23348nonce});
    }

    /* renamed from: getHPK */
    public byte[] m17712getHPK() {
        return C6238Arrays.m18231clone(this.f23347hpk);
    }

    public byte[] getNonce() {
        return C6238Arrays.m18231clone(this.f23348nonce);
    }

    public MLKEMPrivateKeyParameters getParametersWithFormat(int i) {
        return withPreferredFormat(i);
    }

    public int getPreferredFormat() {
        return this.prefFormat;
    }

    public byte[] getPublicKey() {
        return MLKEMPublicKeyParameters.getEncoded(this.f23352t, this.f23349rho);
    }

    public MLKEMPublicKeyParameters getPublicKeyParameters() {
        return new MLKEMPublicKeyParameters(getParameters(), this.f23352t, this.f23349rho);
    }

    /* renamed from: getRho */
    public byte[] m17713getRho() {
        return C6238Arrays.m18231clone(this.f23349rho);
    }

    /* renamed from: getS */
    public byte[] m17714getS() {
        return C6238Arrays.m18231clone(this.f23350s);
    }

    /* renamed from: getSeed */
    public byte[] m17715getSeed() {
        return C6238Arrays.m18231clone(this.f23351seed);
    }

    /* renamed from: getT */
    public byte[] m17716getT() {
        return C6238Arrays.m18231clone(this.f23352t);
    }

    public MLKEMPrivateKeyParameters withPreferredFormat(int i) {
        if (this.prefFormat == i) {
            return this;
        }
        if (i == 0 || i == 1) {
            if (this.f23351seed == null) {
                throw new IllegalStateException("no seed available");
            }
        } else if (i != 2) {
            throw new IllegalArgumentException("unknown format");
        }
        return new MLKEMPrivateKeyParameters(this, i);
    }

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, MLKEMPublicKeyParameters mLKEMPublicKeyParameters) {
        super(true, mLKEMParameters);
        MLKEMEngine engine = mLKEMParameters.getEngine();
        if (bArr.length == 64) {
            byte[][] bArrGenerateKemKeyPairInternal = engine.generateKemKeyPairInternal(C6238Arrays.copyOfRange(bArr, 0, 32), C6238Arrays.copyOfRange(bArr, 32, bArr.length));
            this.f23350s = bArrGenerateKemKeyPairInternal[2];
            this.f23347hpk = bArrGenerateKemKeyPairInternal[3];
            this.f23348nonce = bArrGenerateKemKeyPairInternal[4];
            this.f23352t = bArrGenerateKemKeyPairInternal[0];
            this.f23349rho = bArrGenerateKemKeyPairInternal[1];
            this.f23351seed = bArrGenerateKemKeyPairInternal[5];
        } else {
            this.f23350s = C6238Arrays.copyOfRange(bArr, 0, engine.getIndCpaSecretKeyBytes());
            int indCpaSecretKeyBytes = engine.getIndCpaSecretKeyBytes();
            this.f23352t = C6238Arrays.copyOfRange(bArr, indCpaSecretKeyBytes, (engine.getIndCpaPublicKeyBytes() + indCpaSecretKeyBytes) - 32);
            int indCpaPublicKeyBytes = indCpaSecretKeyBytes + (engine.getIndCpaPublicKeyBytes() - 32);
            int i = indCpaPublicKeyBytes + 32;
            this.f23349rho = C6238Arrays.copyOfRange(bArr, indCpaPublicKeyBytes, i);
            int i2 = indCpaPublicKeyBytes + 64;
            this.f23347hpk = C6238Arrays.copyOfRange(bArr, i, i2);
            this.f23348nonce = C6238Arrays.copyOfRange(bArr, i2, indCpaPublicKeyBytes + 96);
            this.f23351seed = null;
        }
        validate();
        if (mLKEMPublicKeyParameters != null && (!C6238Arrays.constantTimeAreEqual(this.f23352t, mLKEMPublicKeyParameters.f23354t) || !C6238Arrays.constantTimeAreEqual(this.f23349rho, mLKEMPublicKeyParameters.f23353rho))) {
            throw new IllegalArgumentException("passed in public key does not match private values");
        }
        this.prefFormat = this.f23351seed != null ? 0 : 2;
    }

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        this(mLKEMParameters, bArr, bArr2, bArr3, bArr4, bArr5, null);
    }

    public MLKEMPrivateKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6) {
        super(true, mLKEMParameters);
        this.f23350s = C6238Arrays.m18231clone(bArr);
        this.f23347hpk = C6238Arrays.m18231clone(bArr2);
        this.f23348nonce = C6238Arrays.m18231clone(bArr3);
        this.f23352t = C6238Arrays.m18231clone(bArr4);
        this.f23349rho = C6238Arrays.m18231clone(bArr5);
        this.f23351seed = C6238Arrays.m18231clone(bArr6);
        this.prefFormat = 0;
        validate();
    }

    private MLKEMPrivateKeyParameters(MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters, int i) {
        super(true, mLKEMPrivateKeyParameters.getParameters());
        this.f23350s = mLKEMPrivateKeyParameters.f23350s;
        this.f23352t = mLKEMPrivateKeyParameters.f23352t;
        this.f23349rho = mLKEMPrivateKeyParameters.f23349rho;
        this.f23347hpk = mLKEMPrivateKeyParameters.f23347hpk;
        this.f23348nonce = mLKEMPrivateKeyParameters.f23348nonce;
        this.f23351seed = mLKEMPrivateKeyParameters.f23351seed;
        this.prefFormat = i;
        validate();
    }
}
