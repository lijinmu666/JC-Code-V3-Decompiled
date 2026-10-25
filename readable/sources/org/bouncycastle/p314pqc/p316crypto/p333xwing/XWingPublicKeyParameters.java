package org.bouncycastle.p314pqc.p316crypto.p333xwing;

import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class XWingPublicKeyParameters extends XWingKeyParameters {

    /* renamed from: kybPub */
    private final MLKEMPublicKeyParameters f23679kybPub;

    /* renamed from: xdhPub */
    private final X25519PublicKeyParameters f23680xdhPub;

    public XWingPublicKeyParameters(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricKeyParameter asymmetricKeyParameter2) {
        super(false);
        this.f23679kybPub = (MLKEMPublicKeyParameters) asymmetricKeyParameter;
        this.f23680xdhPub = (X25519PublicKeyParameters) asymmetricKeyParameter2;
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(this.f23679kybPub.getEncoded(), this.f23680xdhPub.getEncoded());
    }

    public MLKEMPublicKeyParameters getKyberPublicKey() {
        return this.f23679kybPub;
    }

    public X25519PublicKeyParameters getXDHPublicKey() {
        return this.f23680xdhPub;
    }

    public XWingPublicKeyParameters(byte[] bArr) {
        super(false);
        this.f23679kybPub = new MLKEMPublicKeyParameters(MLKEMParameters.ml_kem_768, C6238Arrays.copyOfRange(bArr, 0, bArr.length - 32));
        this.f23680xdhPub = new X25519PublicKeyParameters(bArr, bArr.length - 32);
    }
}
