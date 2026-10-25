package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class DLSequenceParser implements ASN1SequenceParser {

    /* renamed from: _parser */
    private ASN1StreamParser f17999_parser;

    public DLSequenceParser(ASN1StreamParser aSN1StreamParser) {
        this.f17999_parser = aSN1StreamParser;
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return DLFactory.createSequence(this.f17999_parser.readVector());
    }

    @Override // org.bouncycastle.p133asn1.ASN1SequenceParser
    public ASN1Encodable readObject() {
        return this.f17999_parser.readObject();
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
