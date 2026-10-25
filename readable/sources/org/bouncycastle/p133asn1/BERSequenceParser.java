package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class BERSequenceParser implements ASN1SequenceParser {

    /* renamed from: _parser */
    private ASN1StreamParser f17970_parser;

    public BERSequenceParser(ASN1StreamParser aSN1StreamParser) {
        this.f17970_parser = aSN1StreamParser;
    }

    /* renamed from: parse */
    public static BERSequence m14467parse(ASN1StreamParser aSN1StreamParser) {
        return new BERSequence(aSN1StreamParser.readVector());
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return m14467parse(this.f17970_parser);
    }

    @Override // org.bouncycastle.p133asn1.ASN1SequenceParser
    public ASN1Encodable readObject() {
        return this.f17970_parser.readObject();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
