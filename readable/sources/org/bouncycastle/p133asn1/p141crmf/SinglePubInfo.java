package org.bouncycastle.p133asn1.p141crmf;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.GeneralName;

/* loaded from: classes2.dex */
public class SinglePubInfo extends ASN1Object {
    private GeneralName pubLocation;
    private ASN1Integer pubMethod;
    public static final ASN1Integer dontCare = ASN1Integer.m14429valueOf(0);

    /* renamed from: x500 */
    public static final ASN1Integer f18273x500 = ASN1Integer.m14429valueOf(1);

    /* renamed from: web */
    public static final ASN1Integer f18272web = ASN1Integer.m14429valueOf(2);

    /* renamed from: ldap */
    public static final ASN1Integer f18271ldap = ASN1Integer.m14429valueOf(3);

    public SinglePubInfo(ASN1Integer aSN1Integer, GeneralName generalName) {
        this.pubMethod = aSN1Integer;
        this.pubLocation = generalName;
    }

    public static SinglePubInfo getInstance(Object obj) {
        if (obj instanceof SinglePubInfo) {
            return (SinglePubInfo) obj;
        }
        if (obj != null) {
            return new SinglePubInfo(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GeneralName getPubLocation() {
        return this.pubLocation;
    }

    public ASN1Integer getPubMethod() {
        return this.pubMethod;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.pubMethod);
        GeneralName generalName = this.pubLocation;
        if (generalName != null) {
            aSN1EncodableVector.m14420add(generalName);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private SinglePubInfo(ASN1Sequence aSN1Sequence) {
        this.pubMethod = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() == 2) {
            this.pubLocation = GeneralName.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }
}
