package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.C5916Version;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5969Time32;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.C5976UINT8;

/* loaded from: classes2.dex */
public class ToBeSignedRcaCtl extends CtlFormat {
    public ToBeSignedRcaCtl(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public static ToBeSignedRcaCtl getInstance(Object obj) {
        if (obj instanceof ToBeSignedRcaCtl) {
            return (ToBeSignedRcaCtl) obj;
        }
        if (obj != null) {
            return new ToBeSignedRcaCtl(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ToBeSignedRcaCtl(C5916Version c5916Version, C5969Time32 c5969Time32, ASN1Boolean aSN1Boolean, C5976UINT8 c5976uint8, SequenceOfCtlCommand sequenceOfCtlCommand) {
        super(c5916Version, c5969Time32, aSN1Boolean, c5976uint8, sequenceOfCtlCommand);
    }
}
