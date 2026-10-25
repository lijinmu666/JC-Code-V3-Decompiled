package org.bouncycastle.p133asn1.p168smime;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class SMIMECapabilityVector {
    private ASN1EncodableVector capabilities = new ASN1EncodableVector();

    public void addCapability(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.capabilities.m14420add(new DERSequence(aSN1ObjectIdentifier));
    }

    public ASN1EncodableVector toASN1EncodableVector() {
        return this.capabilities;
    }

    public void addCapability(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        this.capabilities.m14420add(new DERSequence(aSN1ObjectIdentifier, ASN1Integer.m14429valueOf(i)));
    }

    public void addCapability(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.capabilities.m14420add(new DERSequence(aSN1ObjectIdentifier, aSN1Encodable));
    }
}
