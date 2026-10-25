package org.bouncycastle.p246its;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.p246its.operator.ECDSAEncoder;
import org.bouncycastle.p246its.operator.ITSContentVerifierProvider;
import org.bouncycastle.p300oer.OEREncoder;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateBase;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.IssuerIdentifier;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.PublicEncryptionKey;
import org.bouncycastle.p300oer.p301its.template.ieee1609dot2.IEEE1609dot2;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class ITSCertificate implements Encodable {
    private final CertificateBase certificate;

    public ITSCertificate(CertificateBase certificateBase) {
        this.certificate = certificateBase;
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return OEREncoder.toByteArray(this.certificate, IEEE1609dot2.CertificateBase.m17146build());
    }

    public IssuerIdentifier getIssuer() {
        return this.certificate.getIssuer();
    }

    public ITSPublicEncryptionKey getPublicEncryptionKey() {
        PublicEncryptionKey encryptionKey = this.certificate.getToBeSigned().getEncryptionKey();
        if (encryptionKey != null) {
            return new ITSPublicEncryptionKey(encryptionKey);
        }
        return null;
    }

    public ITSValidityPeriod getValidityPeriod() {
        return new ITSValidityPeriod(this.certificate.getToBeSigned().getValidityPeriod());
    }

    public boolean isSignatureValid(ITSContentVerifierProvider iTSContentVerifierProvider) throws IOException {
        ContentVerifier contentVerifierMo16014get = iTSContentVerifierProvider.mo16014get(this.certificate.getSignature().getChoice());
        OutputStream outputStream = contentVerifierMo16014get.getOutputStream();
        outputStream.write(OEREncoder.toByteArray(this.certificate.getToBeSigned(), IEEE1609dot2.ToBeSignedCertificate.m17146build()));
        outputStream.close();
        return contentVerifierMo16014get.mo16015verify(ECDSAEncoder.m16042toX962(this.certificate.getSignature()));
    }

    public CertificateBase toASN1Structure() {
        return this.certificate;
    }
}
