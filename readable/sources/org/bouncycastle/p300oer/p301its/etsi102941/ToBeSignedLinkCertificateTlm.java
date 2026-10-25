package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.HashedData;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;

/* loaded from: classes2.dex */
public class ToBeSignedLinkCertificateTlm extends ToBeSignedLinkCertificate {
    public ToBeSignedLinkCertificateTlm(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public static ToBeSignedLinkCertificateTlm getInstance(Object obj) {
        if (obj instanceof ToBeSignedLinkCertificateTlm) {
            return (ToBeSignedLinkCertificateTlm) obj;
        }
        if (obj instanceof ToBeSignedLinkCertificate) {
            return new ToBeSignedLinkCertificateTlm((ToBeSignedLinkCertificate) obj);
        }
        if (obj != null) {
            return new ToBeSignedLinkCertificateTlm(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private ToBeSignedLinkCertificateTlm(ToBeSignedLinkCertificate toBeSignedLinkCertificate) {
        super(toBeSignedLinkCertificate.getExpiryTime(), toBeSignedLinkCertificate.getCertificateHash());
    }

    public ToBeSignedLinkCertificateTlm(C5969Time32 c5969Time32, HashedData hashedData) {
        super(c5969Time32, hashedData);
    }
}
