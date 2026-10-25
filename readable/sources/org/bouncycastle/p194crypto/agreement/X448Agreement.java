package org.bouncycastle.p194crypto.agreement;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.RawAgreement;
import org.bouncycastle.p194crypto.p213params.X448PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.XDHParameterSpec;

/* loaded from: classes2.dex */
public final class X448Agreement implements RawAgreement {
    private X448PrivateKeyParameters privateKey;

    @Override // org.bouncycastle.p194crypto.RawAgreement
    public void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i) {
        this.privateKey.generateSecret((X448PublicKeyParameters) cipherParameters, bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    public int getAgreementSize() {
        return 56;
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    /* renamed from: init */
    public void mo14986init(CipherParameters cipherParameters) {
        X448PrivateKeyParameters x448PrivateKeyParameters = (X448PrivateKeyParameters) cipherParameters;
        this.privateKey = x448PrivateKeyParameters;
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties(XDHParameterSpec.f21952X448, x448PrivateKeyParameters));
    }
}
