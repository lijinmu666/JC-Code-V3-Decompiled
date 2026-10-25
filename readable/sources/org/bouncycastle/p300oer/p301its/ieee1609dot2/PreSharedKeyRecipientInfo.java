package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.HashedId8;

/* loaded from: classes2.dex */
public class PreSharedKeyRecipientInfo extends HashedId8 {
    public PreSharedKeyRecipientInfo(byte[] bArr) {
        super(bArr);
    }

    public static PreSharedKeyRecipientInfo getInstance(Object obj) {
        if (obj instanceof PreSharedKeyRecipientInfo) {
            return (PreSharedKeyRecipientInfo) obj;
        }
        if (obj != null) {
            return obj instanceof HashedId ? new PreSharedKeyRecipientInfo(((HashedId) obj).getHashBytes()) : new PreSharedKeyRecipientInfo(ASN1OctetString.getInstance(obj).getOctets());
        }
        return null;
    }
}
