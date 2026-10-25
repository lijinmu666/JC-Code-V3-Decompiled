package org.bouncycastle.p194crypto.agreement;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.RawAgreement;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.XDHParameterSpec;

/* loaded from: classes2.dex */
public final class X25519Agreement implements RawAgreement {
    private X25519PrivateKeyParameters privateKey;

    @Override // org.bouncycastle.p194crypto.RawAgreement
    public void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i) {
        this.privateKey.generateSecret((X25519PublicKeyParameters) cipherParameters, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    public int getAgreementSize() {
        return 32;
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    /* renamed from: init */
    public void mo14986init(CipherParameters cipherParameters) {
        X25519PrivateKeyParameters x25519PrivateKeyParameters = (X25519PrivateKeyParameters) cipherParameters;
        this.privateKey = x25519PrivateKeyParameters;
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties(XDHParameterSpec.f21951X25519, x25519PrivateKeyParameters));
    }
}
