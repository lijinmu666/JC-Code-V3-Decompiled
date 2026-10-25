package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes.dex */
public class BERBitStringParser implements ASN1BitStringParser {
    private ConstructedBitStream _bitStream;

    /* renamed from: parser */
    private final ASN1StreamParser f17961parser;

    public BERBitStringParser(ASN1StreamParser aSN1StreamParser) {
        this.f17961parser = aSN1StreamParser;
    }

    /* renamed from: parse */
    public static BERBitString m14464parse(ASN1StreamParser aSN1StreamParser) {
        ConstructedBitStream constructedBitStream = new ConstructedBitStream(aSN1StreamParser, false);
        return new BERBitString(C6257Streams.m18363readAll(constructedBitStream), constructedBitStream.getPadBits());
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitStringParser
    public InputStream getBitStream() {
        ConstructedBitStream constructedBitStream = new ConstructedBitStream(this.f17961parser, false);
        this._bitStream = constructedBitStream;
        return constructedBitStream;
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return m14464parse(this.f17961parser);
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitStringParser
    public InputStream getOctetStream() {
        ConstructedBitStream constructedBitStream = new ConstructedBitStream(this.f17961parser, true);
        this._bitStream = constructedBitStream;
        return constructedBitStream;
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitStringParser
    public int getPadBits() {
        return this._bitStream.getPadBits();
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
