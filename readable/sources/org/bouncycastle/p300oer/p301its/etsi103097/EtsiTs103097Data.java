package org.bouncycastle.p300oer.p301its.etsi103097;

import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.Ieee1609Dot2Content;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.Ieee1609Dot2Data;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;

/* loaded from: classes2.dex */
public class EtsiTs103097Data extends Ieee1609Dot2Data {
    public EtsiTs103097Data(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public static EtsiTs103097Data getInstance(Object obj) {
        if (obj instanceof EtsiTs103097Data) {
            return (EtsiTs103097Data) obj;
        }
        if (obj != null) {
            return new EtsiTs103097Data(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EtsiTs103097Data(Ieee1609Dot2Content ieee1609Dot2Content) {
        super(new C5976UINT8(3), ieee1609Dot2Content);
    }

    public EtsiTs103097Data(C5976UINT8 c5976uint8, Ieee1609Dot2Content ieee1609Dot2Content) {
        super(c5976uint8, ieee1609Dot2Content);
    }
}
