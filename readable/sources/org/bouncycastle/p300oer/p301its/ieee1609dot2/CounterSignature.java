package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;

/* loaded from: classes2.dex */
public class CounterSignature extends Ieee1609Dot2Data {
    public CounterSignature(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public static Ieee1609Dot2Data getInstance(Object obj) {
        if (obj instanceof Ieee1609Dot2Data) {
            return (Ieee1609Dot2Data) obj;
        }
        if (obj != null) {
            return new CounterSignature(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CounterSignature(C5976UINT8 c5976uint8, Ieee1609Dot2Content ieee1609Dot2Content) {
        super(c5976uint8, ieee1609Dot2Content);
    }
}
