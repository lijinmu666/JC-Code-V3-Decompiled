package org.bouncycastle.p314pqc.p316crypto.p333xwing;

import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class XWingPrivateKeyParameters extends XWingKeyParameters {
    private final transient MLKEMPrivateKeyParameters kyberPrivateKey;
    private final transient MLKEMPublicKeyParameters kyberPublicKey;

    /* renamed from: seed */
    private final transient byte[] f23678seed;
    private final transient X25519PrivateKeyParameters xdhPrivateKey;
    private final transient X25519PublicKeyParameters xdhPublicKey;

    public XWingPrivateKeyParameters(byte[] bArr) {
        super(true);
        XWingPrivateKeyParameters xWingPrivateKeyParameters = (XWingPrivateKeyParameters) XWingKeyPairGenerator.genKeyPair(bArr).getPrivate();
        this.f23678seed = xWingPrivateKeyParameters.f23678seed;
        this.kyberPrivateKey = xWingPrivateKeyParameters.kyberPrivateKey;
        this.xdhPrivateKey = xWingPrivateKeyParameters.xdhPrivateKey;
        this.kyberPublicKey = xWingPrivateKeyParameters.kyberPublicKey;
        this.xdhPublicKey = xWingPrivateKeyParameters.xdhPublicKey;
    }

    public byte[] getEncoded() {
        return C6238Arrays.m18231clone(this.f23678seed);
    }

    public MLKEMPrivateKeyParameters getKyberPrivateKey() {
        return this.kyberPrivateKey;
    }

    public MLKEMPublicKeyParameters getKyberPublicKey() {
        return this.kyberPublicKey;
    }

    /* renamed from: getSeed */
    public byte[] m17932getSeed() {
        return C6238Arrays.m18231clone(this.f23678seed);
    }

    public X25519PrivateKeyParameters getXDHPrivateKey() {
        return this.xdhPrivateKey;
    }

    public X25519PublicKeyParameters getXDHPublicKey() {
        return this.xdhPublicKey;
    }

    public XWingPrivateKeyParameters(byte[] bArr, MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters, X25519PrivateKeyParameters x25519PrivateKeyParameters, MLKEMPublicKeyParameters mLKEMPublicKeyParameters, X25519PublicKeyParameters x25519PublicKeyParameters) {
        super(true);
        this.f23678seed = C6238Arrays.m18231clone(bArr);
        this.kyberPrivateKey = mLKEMPrivateKeyParameters;
        this.xdhPrivateKey = x25519PrivateKeyParameters;
        this.kyberPublicKey = mLKEMPublicKeyParameters;
        this.xdhPublicKey = x25519PublicKeyParameters;
    }

    @Deprecated
    public XWingPrivateKeyParameters(byte[] bArr, org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters, X25519PrivateKeyParameters x25519PrivateKeyParameters, org.bouncycastle.p314pqc.p316crypto.p324mlkem.MLKEMPublicKeyParameters mLKEMPublicKeyParameters, X25519PublicKeyParameters x25519PublicKeyParameters) {
        super(true);
        MLKEMParameters mLKEMParameters = mLKEMPublicKeyParameters.getParameters().m17711getName().equals("ML-KEM-512") ? MLKEMParameters.ml_kem_512 : mLKEMPublicKeyParameters.getParameters().m17711getName().equals("ML-KEM-768") ? MLKEMParameters.ml_kem_768 : MLKEMParameters.ml_kem_1024;
        MLKEMPublicKeyParameters mLKEMPublicKeyParameters2 = new MLKEMPublicKeyParameters(mLKEMParameters, mLKEMPublicKeyParameters.getEncoded());
        this.f23678seed = C6238Arrays.m18231clone(bArr);
        this.kyberPrivateKey = new MLKEMPrivateKeyParameters(mLKEMParameters, mLKEMPrivateKeyParameters.getEncoded(), mLKEMPublicKeyParameters2);
        this.xdhPrivateKey = x25519PrivateKeyParameters;
        this.kyberPublicKey = mLKEMPublicKeyParameters2;
        this.xdhPublicKey = x25519PublicKeyParameters;
    }
}
