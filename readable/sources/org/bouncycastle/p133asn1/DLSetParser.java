package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class DLSetParser implements ASN1SetParser {

    /* renamed from: _parser */
    private ASN1StreamParser f18000_parser;

    public DLSetParser(ASN1StreamParser aSN1StreamParser) {
        this.f18000_parser = aSN1StreamParser;
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return DLFactory.createSet(this.f18000_parser.readVector());
    }

    @Override // org.bouncycastle.p133asn1.ASN1SetParser
    public ASN1Encodable readObject() {
        return this.f18000_parser.readObject();
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
