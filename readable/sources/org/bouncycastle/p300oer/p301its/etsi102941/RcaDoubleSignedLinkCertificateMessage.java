package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataSigned;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.Ieee1609Dot2Content;

/* loaded from: classes2.dex */
public class RcaDoubleSignedLinkCertificateMessage extends EtsiTs103097DataSigned {
    public RcaDoubleSignedLinkCertificateMessage(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public static RcaDoubleSignedLinkCertificateMessage getInstance(Object obj) {
        if (obj instanceof RcaDoubleSignedLinkCertificateMessage) {
            return (RcaDoubleSignedLinkCertificateMessage) obj;
        }
        if (obj != null) {
            return new RcaDoubleSignedLinkCertificateMessage(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public RcaDoubleSignedLinkCertificateMessage(Ieee1609Dot2Content ieee1609Dot2Content) {
        super(ieee1609Dot2Content);
    }
}
