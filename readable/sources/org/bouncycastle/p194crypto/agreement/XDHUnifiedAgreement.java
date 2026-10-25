package org.bouncycastle.p194crypto.agreement;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.RawAgreement;
import org.bouncycastle.p194crypto.p213params.XDHUPrivateParameters;
import org.bouncycastle.p194crypto.p213params.XDHUPublicParameters;

/* loaded from: classes2.dex */
public class XDHUnifiedAgreement implements RawAgreement {
    private XDHUPrivateParameters privParams;
    private final RawAgreement xAgreement;

    public XDHUnifiedAgreement(RawAgreement rawAgreement) {
        this.xAgreement = rawAgreement;
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    public void calculateAgreement(CipherParameters cipherParameters, byte[] bArr, int i) {
        XDHUPublicParameters xDHUPublicParameters = (XDHUPublicParameters) cipherParameters;
        this.xAgreement.mo14986init(this.privParams.getEphemeralPrivateKey());
        this.xAgreement.calculateAgreement(xDHUPublicParameters.getEphemeralPublicKey(), bArr, i);
        this.xAgreement.mo14986init(this.privParams.getStaticPrivateKey());
        this.xAgreement.calculateAgreement(xDHUPublicParameters.getStaticPublicKey(), bArr, i + this.xAgreement.getAgreementSize());
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    public int getAgreementSize() {
        return this.xAgreement.getAgreementSize() * 2;
    }

    @Override // org.bouncycastle.p194crypto.RawAgreement
    /* renamed from: init */
    public void mo14986init(CipherParameters cipherParameters) {
        XDHUPrivateParameters xDHUPrivateParameters = (XDHUPrivateParameters) cipherParameters;
        this.privParams = xDHUPrivateParameters;
        this.xAgreement.mo14986init(xDHUPrivateParameters.getStaticPrivateKey());
    }
}
