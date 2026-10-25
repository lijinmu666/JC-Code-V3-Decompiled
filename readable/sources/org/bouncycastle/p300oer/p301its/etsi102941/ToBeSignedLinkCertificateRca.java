package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.HashedData;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;

/* loaded from: classes2.dex */
public class ToBeSignedLinkCertificateRca extends ToBeSignedLinkCertificate {
    public ToBeSignedLinkCertificateRca(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public static ToBeSignedLinkCertificateRca getInstance(Object obj) {
        if (obj instanceof ToBeSignedLinkCertificateRca) {
            return (ToBeSignedLinkCertificateRca) obj;
        }
        if (obj instanceof ToBeSignedLinkCertificate) {
            return new ToBeSignedLinkCertificateRca((ToBeSignedLinkCertificate) obj);
        }
        if (obj != null) {
            return new ToBeSignedLinkCertificateRca(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private ToBeSignedLinkCertificateRca(ToBeSignedLinkCertificate toBeSignedLinkCertificate) {
        super(toBeSignedLinkCertificate.getExpiryTime(), toBeSignedLinkCertificate.getCertificateHash());
    }

    public ToBeSignedLinkCertificateRca(C5969Time32 c5969Time32, HashedData hashedData) {
        super(c5969Time32, hashedData);
    }
}
