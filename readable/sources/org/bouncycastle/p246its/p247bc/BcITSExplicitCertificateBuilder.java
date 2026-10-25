package org.bouncycastle.p246its.p247bc;

import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p246its.ITSCertificate;
import org.bouncycastle.p246its.ITSExplicitCertificateBuilder;
import org.bouncycastle.p246its.operator.ITSContentSigner;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.CertificateId;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;

/* loaded from: classes2.dex */
public class BcITSExplicitCertificateBuilder extends ITSExplicitCertificateBuilder {
    public BcITSExplicitCertificateBuilder(ITSContentSigner iTSContentSigner, ToBeSignedCertificate.C5938Builder c5938Builder) {
        super(iTSContentSigner, c5938Builder);
    }

    /* renamed from: build */
    public ITSCertificate m16016build(CertificateId certificateId, ECPublicKeyParameters eCPublicKeyParameters) {
        return m16017build(certificateId, eCPublicKeyParameters, (ECPublicKeyParameters) null);
    }

    /* renamed from: build */
    public ITSCertificate m16017build(CertificateId certificateId, ECPublicKeyParameters eCPublicKeyParameters, ECPublicKeyParameters eCPublicKeyParameters2) {
        return super.m16004build(certificateId, new BcITSPublicVerificationKey(eCPublicKeyParameters), eCPublicKeyParameters2 != null ? new BcITSPublicEncryptionKey(eCPublicKeyParameters2) : null);
    }
}
