package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes.dex */
public class BEROctetStringParser implements ASN1OctetStringParser {

    /* renamed from: _parser */
    private ASN1StreamParser f17968_parser;

    public BEROctetStringParser(ASN1StreamParser aSN1StreamParser) {
        this.f17968_parser = aSN1StreamParser;
    }

    /* renamed from: parse */
    public static BEROctetString m14465parse(ASN1StreamParser aSN1StreamParser) {
        return new BEROctetString(C6257Streams.m18363readAll(new ConstructedOctetStream(aSN1StreamParser)));
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return m14465parse(this.f17968_parser);
    }

    @Override // org.bouncycastle.p133asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return new ConstructedOctetStream(this.f17968_parser);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }
}
