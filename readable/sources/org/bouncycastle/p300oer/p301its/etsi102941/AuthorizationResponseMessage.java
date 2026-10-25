package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097DataEncryptedUnicast;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.Ieee1609Dot2Content;

/* loaded from: classes2.dex */
public class AuthorizationResponseMessage extends EtsiTs103097DataEncryptedUnicast {
    public AuthorizationResponseMessage(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public static AuthorizationResponseMessage getInstance(Object obj) {
        if (obj instanceof AuthorizationResponseMessage) {
            return (AuthorizationResponseMessage) obj;
        }
        if (obj != null) {
            return new AuthorizationResponseMessage(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AuthorizationResponseMessage(Ieee1609Dot2Content ieee1609Dot2Content) {
        super(ieee1609Dot2Content);
    }
}
