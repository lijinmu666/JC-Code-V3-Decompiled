package org.bouncycastle.p133asn1;

/* loaded from: classes.dex */
abstract class ASN1UniversalType extends ASN1Type {

    /* renamed from: tag */
    final C5095ASN1Tag f17958tag;

    public ASN1UniversalType(Class cls, int i) {
        super(cls);
        this.f17958tag = C5095ASN1Tag.m14456create(0, i);
    }

    public final ASN1Primitive checkedCast(ASN1Primitive aSN1Primitive) {
        if (this.javaClass.isInstance(aSN1Primitive)) {
            return aSN1Primitive;
        }
        throw new IllegalStateException("unexpected object: " + aSN1Primitive.getClass().getName());
    }

    public final ASN1Primitive fromByteArray(byte[] bArr) {
        return checkedCast(ASN1Primitive.fromByteArray(bArr));
    }

    public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    public final ASN1Primitive getContextTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return checkedCast(ASN1Util.checkContextTagClass(aSN1TaggedObject).getBaseUniversal(z, this));
    }

    /* renamed from: getTag */
    public final C5095ASN1Tag m14462getTag() {
        return this.f17958tag;
    }

    public final ASN1Primitive getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return checkedCast(aSN1TaggedObject.getBaseUniversal(z, this));
    }
}
