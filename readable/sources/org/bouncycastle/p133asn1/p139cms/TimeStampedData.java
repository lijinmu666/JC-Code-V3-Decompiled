package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.BERSequence;
import org.bouncycastle.p133asn1.DERIA5String;

/* loaded from: classes.dex */
public class TimeStampedData extends ASN1Object {

    /* renamed from: content */
    private ASN1OctetString f18233content;

    /* renamed from: dataUri */
    private ASN1IA5String f18234dataUri;
    private MetaData metaData;
    private Evidence temporalEvidence;

    /* renamed from: version */
    private ASN1Integer f18235version;

    public TimeStampedData(ASN1IA5String aSN1IA5String, MetaData metaData, ASN1OctetString aSN1OctetString, Evidence evidence) {
        this.f18235version = ASN1Integer.f17918ONE;
        this.f18234dataUri = aSN1IA5String;
        this.metaData = metaData;
        this.f18233content = aSN1OctetString;
        this.temporalEvidence = evidence;
    }

    public static TimeStampedData getInstance(Object obj) {
        return (obj == null || (obj instanceof TimeStampedData)) ? (TimeStampedData) obj : new TimeStampedData(ASN1Sequence.getInstance(obj));
    }

    public ASN1OctetString getContent() {
        return this.f18233content;
    }

    public DERIA5String getDataUri() {
        ASN1IA5String aSN1IA5String = this.f18234dataUri;
        return (aSN1IA5String == null || (aSN1IA5String instanceof DERIA5String)) ? (DERIA5String) aSN1IA5String : new DERIA5String(this.f18234dataUri.getString(), false);
    }

    public ASN1IA5String getDataUriIA5() {
        return this.f18234dataUri;
    }

    public MetaData getMetaData() {
        return this.metaData;
    }

    public Evidence getTemporalEvidence() {
        return this.temporalEvidence;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.m14420add(this.f18235version);
        ASN1IA5String aSN1IA5String = this.f18234dataUri;
        if (aSN1IA5String != null) {
            aSN1EncodableVector.m14420add(aSN1IA5String);
        }
        MetaData metaData = this.metaData;
        if (metaData != null) {
            aSN1EncodableVector.m14420add(metaData);
        }
        ASN1OctetString aSN1OctetString = this.f18233content;
        if (aSN1OctetString != null) {
            aSN1EncodableVector.m14420add(aSN1OctetString);
        }
        aSN1EncodableVector.m14420add(this.temporalEvidence);
        return new BERSequence(aSN1EncodableVector);
    }

    private TimeStampedData(ASN1Sequence aSN1Sequence) {
        this.f18235version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        int i = 1;
        if (aSN1Sequence.getObjectAt(1) instanceof ASN1IA5String) {
            this.f18234dataUri = ASN1IA5String.getInstance(aSN1Sequence.getObjectAt(1));
            i = 2;
        }
        if ((aSN1Sequence.getObjectAt(i) instanceof MetaData) || (aSN1Sequence.getObjectAt(i) instanceof ASN1Sequence)) {
            this.metaData = MetaData.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        if (aSN1Sequence.getObjectAt(i) instanceof ASN1OctetString) {
            this.f18233content = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(i));
            i++;
        }
        this.temporalEvidence = Evidence.getInstance(aSN1Sequence.getObjectAt(i));
    }
}
