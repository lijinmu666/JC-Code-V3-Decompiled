package org.bouncycastle.p133asn1;

import java.io.IOException;

/* loaded from: classes.dex */
class BERTaggedObjectParser implements ASN1TaggedObjectParser {

    /* renamed from: _parser */
    final ASN1StreamParser f17972_parser;
    final int _tagClass;

    /* renamed from: _tagNo */
    final int f17973_tagNo;

    public BERTaggedObjectParser(int i, int i2, ASN1StreamParser aSN1StreamParser) {
        this._tagClass = i;
        this.f17973_tagNo = i2;
        this.f17972_parser = aSN1StreamParser;
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return this.f17972_parser.loadTaggedIL(this._tagClass, this.f17973_tagNo);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public int getTagClass() {
        return this._tagClass;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public int getTagNo() {
        return this.f17973_tagNo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public boolean hasContextTag() {
        return this._tagClass == 128;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    /* renamed from: hasTag */
    public boolean mo14457hasTag(int i, int i2) {
        return this._tagClass == i && this.f17973_tagNo == i2;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public boolean hasTagClass(int i) {
        return this._tagClass == i;
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseBaseUniversal(boolean z, int i) {
        ASN1StreamParser aSN1StreamParser = this.f17972_parser;
        return z ? aSN1StreamParser.parseObject(i) : aSN1StreamParser.parseImplicitConstructedIL(i);
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1Encodable parseExplicitBaseObject() {
        return this.f17972_parser.readObject();
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseExplicitBaseTagged() {
        return this.f17972_parser.parseTaggedObject();
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public ASN1TaggedObjectParser parseImplicitBaseTagged(int i, int i2) {
        return new BERTaggedObjectParser(i, i2, this.f17972_parser);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException(e.getMessage());
        }
    }

    @Override // org.bouncycastle.p133asn1.ASN1TaggedObjectParser
    public boolean hasContextTag(int i) {
        return this._tagClass == 128 && this.f17973_tagNo == i;
    }
}
