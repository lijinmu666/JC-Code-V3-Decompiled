package org.bouncycastle.p133asn1.p168smime;

import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p139cms.Attribute;

/* loaded from: classes2.dex */
public class SMIMECapabilitiesAttribute extends Attribute {
    public SMIMECapabilitiesAttribute(SMIMECapabilityVector sMIMECapabilityVector) {
        super(SMIMEAttributes.smimeCapabilities, new C5104DERSet(new DERSequence(sMIMECapabilityVector.toASN1EncodableVector())));
    }
}
