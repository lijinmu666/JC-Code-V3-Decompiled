package org.bouncycastle.p133asn1.p139cms;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.ASN1TaggedObjectParser;
import org.bouncycastle.p133asn1.ASN1Util;

/* loaded from: classes.dex */
public class ContentInfoParser {

    /* renamed from: content */
    private ASN1TaggedObjectParser f18185content;
    private ASN1ObjectIdentifier contentType;

    public ContentInfoParser(ASN1SequenceParser aSN1SequenceParser) {
        this.contentType = (ASN1ObjectIdentifier) aSN1SequenceParser.readObject();
        this.f18185content = (ASN1TaggedObjectParser) aSN1SequenceParser.readObject();
    }

    public ASN1Encodable getContent(int i) {
        ASN1TaggedObjectParser aSN1TaggedObjectParser = this.f18185content;
        if (aSN1TaggedObjectParser != null) {
            return ASN1Util.parseExplicitContextBaseObject(aSN1TaggedObjectParser, 0);
        }
        return null;
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentType;
    }
}
