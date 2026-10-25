package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class BERSetParser implements ASN1SetParser {

    /* renamed from: _parser */
    private ASN1StreamParser f17971_parser;

    public BERSetParser(ASN1StreamParser aSN1StreamParser) {
        this.f17971_parser = aSN1StreamParser;
    }

    /* renamed from: parse */
    public static C5101BERSet m14468parse(ASN1StreamParser aSN1StreamParser) {
        return new C5101BERSet(aSN1StreamParser.readVector());
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return m14468parse(this.f17971_parser);
    }

    @Override // org.bouncycastle.p133asn1.ASN1SetParser
    public ASN1Encodable readObject() {
        return this.f17971_parser.readObject();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage(), e);
        }
    }
}
