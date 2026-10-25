package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Signature;

/* loaded from: classes2.dex */
public class ImplicitCertificate extends CertificateBase {
    private ImplicitCertificate(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
        if (!m17217getType().m14446equals((ASN1Primitive) CertificateType.implicit)) {
            throw new IllegalArgumentException("object was certificate base but the type was not implicit");
        }
    }

    public static ImplicitCertificate getInstance(Object obj) {
        if (obj instanceof ImplicitCertificate) {
            return (ImplicitCertificate) obj;
        }
        if (obj != null) {
            return new ImplicitCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ImplicitCertificate(CertificateBase certificateBase) {
        this(certificateBase.getVersion(), certificateBase.getIssuer(), certificateBase.getToBeSigned(), certificateBase.getSignature());
    }

    public ImplicitCertificate(C5976UINT8 c5976uint8, IssuerIdentifier issuerIdentifier, ToBeSignedCertificate toBeSignedCertificate, Signature signature) {
        super(c5976uint8, CertificateType.implicit, issuerIdentifier, toBeSignedCertificate, signature);
    }
}
