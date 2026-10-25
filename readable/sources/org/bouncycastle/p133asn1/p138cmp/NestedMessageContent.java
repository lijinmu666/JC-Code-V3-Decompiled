package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Sequence;

/* loaded from: classes.dex */
public class NestedMessageContent extends PKIMessages {
    public NestedMessageContent(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public static NestedMessageContent getInstance(Object obj) {
        if (obj instanceof NestedMessageContent) {
            return (NestedMessageContent) obj;
        }
        if (obj != null) {
            return new NestedMessageContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public NestedMessageContent(PKIMessage pKIMessage) {
        super(pKIMessage);
    }

    public NestedMessageContent(PKIMessage[] pKIMessageArr) {
        super(pKIMessageArr);
    }
}
