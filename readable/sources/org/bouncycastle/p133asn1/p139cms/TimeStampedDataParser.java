package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1OctetStringParser;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.DERIA5String;

/* loaded from: classes.dex */
public class TimeStampedDataParser {

    /* renamed from: content */
    private ASN1OctetStringParser f18236content;

    /* renamed from: dataUri */
    private ASN1IA5String f18237dataUri;
    private MetaData metaData;

    /* renamed from: parser */
    private ASN1SequenceParser f18238parser;
    private Evidence temporalEvidence;

    /* renamed from: version */
    private ASN1Integer f18239version;

    private TimeStampedDataParser(ASN1SequenceParser aSN1SequenceParser) {
        this.f18238parser = aSN1SequenceParser;
        this.f18239version = ASN1Integer.getInstance(aSN1SequenceParser.readObject());
        ASN1Encodable object = aSN1SequenceParser.readObject();
        if (object instanceof ASN1IA5String) {
            this.f18237dataUri = ASN1IA5String.getInstance(object);
            object = aSN1SequenceParser.readObject();
        }
        if ((object instanceof MetaData) || (object instanceof ASN1SequenceParser)) {
            this.metaData = MetaData.getInstance(object.toASN1Primitive());
            object = aSN1SequenceParser.readObject();
        }
        if (object instanceof ASN1OctetStringParser) {
            this.f18236content = (ASN1OctetStringParser) object;
        }
    }

    public static TimeStampedDataParser getInstance(Object obj) {
        if (obj instanceof ASN1Sequence) {
            return new TimeStampedDataParser(((ASN1Sequence) obj).m14449parser());
        }
        if (obj instanceof ASN1SequenceParser) {
            return new TimeStampedDataParser((ASN1SequenceParser) obj);
        }
        return null;
    }

    public ASN1OctetStringParser getContent() {
        return this.f18236content;
    }

    public DERIA5String getDataUri() {
        ASN1IA5String aSN1IA5String = this.f18237dataUri;
        return (aSN1IA5String == null || (aSN1IA5String instanceof DERIA5String)) ? (DERIA5String) aSN1IA5String : new DERIA5String(this.f18237dataUri.getString(), false);
    }

    public ASN1IA5String getDataUriIA5() {
        return this.f18237dataUri;
    }

    public MetaData getMetaData() {
        return this.metaData;
    }

    public Evidence getTemporalEvidence() {
        if (this.temporalEvidence == null) {
            this.temporalEvidence = Evidence.getInstance(this.f18238parser.readObject().toASN1Primitive());
        }
        return this.temporalEvidence;
    }

    public int getVersion() {
        return this.f18239version.getValue().intValue();
    }
}
