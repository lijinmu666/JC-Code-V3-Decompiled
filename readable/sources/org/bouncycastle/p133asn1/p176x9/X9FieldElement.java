package org.bouncycastle.p133asn1.p176x9;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p284math.p285ec.ECFieldElement;

/* loaded from: classes2.dex */
public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter = new X9IntegerConverter();

    /* renamed from: f */
    protected ECFieldElement f18785f;

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f18785f = eCFieldElement;
    }

    public ECFieldElement getValue() {
        return this.f18785f;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(converter.integerToBytes(this.f18785f.toBigInteger(), converter.getByteLength(this.f18785f)));
    }
}
