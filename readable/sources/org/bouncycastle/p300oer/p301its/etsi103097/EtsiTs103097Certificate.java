package org.bouncycastle.p300oer.p301its.etsi103097;

import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ExplicitCertificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.IssuerIdentifier;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.Signature;

/* loaded from: classes2.dex */
public class EtsiTs103097Certificate extends ExplicitCertificate {
    public EtsiTs103097Certificate(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public static EtsiTs103097Certificate getInstance(Object obj) {
        if (obj instanceof EtsiTs103097Certificate) {
            return (EtsiTs103097Certificate) obj;
        }
        if (obj != null) {
            return new EtsiTs103097Certificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EtsiTs103097Certificate(C5976UINT8 c5976uint8, IssuerIdentifier issuerIdentifier, ToBeSignedCertificate toBeSignedCertificate, Signature signature) {
        super(c5976uint8, issuerIdentifier, toBeSignedCertificate, signature);
    }
}
