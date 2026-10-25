package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
class DLTaggedObjectParser extends BERTaggedObjectParser {
    private final boolean _constructed;

    public DLTaggedObjectParser(int i, int i2, boolean z, ASN1StreamParser aSN1StreamParser) {
        super(i, i2, aSN1StreamParser);
        this._constructed = z;
    }

    private ASN1StreamParser checkConstructed() throws IOException {
        if (this._constructed) {
            return this.f17972_parser;
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    @Override // org.bouncycastle.p133asn1.BERTaggedObjectParser, org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return this.f17972_parser.loadTaggedDL(this._tagClass, this.f17973_tagNo, this._constructed);
    }

    @Override // org.bouncycastle.p133asn1.BERTaggedObjectParser, org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseBaseUniversal(boolean z, int i) {
        if (z) {
            return checkConstructed().parseObject(i);
        }
        boolean z2 = this._constructed;
        ASN1StreamParser aSN1StreamParser = this.f17972_parser;
        return z2 ? aSN1StreamParser.parseImplicitConstructedDL(i) : aSN1StreamParser.parseImplicitPrimitive(i);
    }

    @Override // org.bouncycastle.p133asn1.BERTaggedObjectParser, org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseExplicitBaseObject() {
        return checkConstructed().readObject();
    }

    @Override // org.bouncycastle.p133asn1.BERTaggedObjectParser, org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseExplicitBaseTagged() {
        return checkConstructed().parseTaggedObject();
    }

    @Override // org.bouncycastle.p133asn1.BERTaggedObjectParser, org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseImplicitBaseTagged(int i, int i2) {
        return new DLTaggedObjectParser(i, i2, this._constructed, this.f17972_parser);
    }
}
