package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
public class DERExternalParser implements ASN1ExternalParser {

    /* renamed from: _parser */
    private ASN1StreamParser f17989_parser;

    public DERExternalParser(ASN1StreamParser aSN1StreamParser) {
        this.f17989_parser = aSN1StreamParser;
    }

    /* renamed from: parse */
    public static DLExternal m14470parse(ASN1StreamParser aSN1StreamParser) throws ASN1Exception {
        try {
            return DLExternal.fromSequence(new DLSequence(aSN1StreamParser.readVector()));
        } catch (IllegalArgumentException e) {
            throw new ASN1Exception("corrupted stream detected", e);
        }
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return m14470parse(this.f17989_parser);
    }

    @Override // org.bouncycastle.p133asn1.ASN1ExternalParser
    public ASN1Encodable readObject() {
        return this.f17989_parser.readObject();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException("unable to get DER object", e);
        } catch (IllegalArgumentException e2) {
            throw new ASN1ParsingException("unable to get DER object", e2);
        }
    }
}
