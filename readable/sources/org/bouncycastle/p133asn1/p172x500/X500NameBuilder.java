package org.bouncycastle.p133asn1.p172x500;

import java.util.Vector;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p172x500.p173style.C5189BCStyle;

/* loaded from: classes2.dex */
public class X500NameBuilder {

    /* renamed from: rdns */
    private Vector f18588rdns;

    /* renamed from: style */
    private X500NameStyle f18589style;

    public X500NameBuilder() {
        this(C5189BCStyle.INSTANCE);
    }

    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr, String[] strArr) {
        int length = strArr.length;
        ASN1Encodable[] aSN1EncodableArr = new ASN1Encodable[length];
        for (int i = 0; i != length; i++) {
            aSN1EncodableArr[i] = this.f18589style.stringToValue(aSN1ObjectIdentifierArr[i], strArr[i]);
        }
        return addMultiValuedRDN(aSN1ObjectIdentifierArr, aSN1EncodableArr);
    }

    /* renamed from: addRDN */
    public X500NameBuilder m14668addRDN(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        m14669addRDN(aSN1ObjectIdentifier, this.f18589style.stringToValue(aSN1ObjectIdentifier, str));
        return this;
    }

    /* renamed from: build */
    public X500Name m14671build() {
        return new X500Name(this.f18589style, buildRDNs());
    }

    public C5188RDN[] buildRDNs() {
        int size = this.f18588rdns.size();
        C5188RDN[] c5188rdnArr = new C5188RDN[size];
        for (int i = 0; i != size; i++) {
            c5188rdnArr[i] = (C5188RDN) this.f18588rdns.elementAt(i);
        }
        return c5188rdnArr;
    }

    public X500NameStyle getStyle() {
        return this.f18589style;
    }

    public X500NameBuilder(X500NameStyle x500NameStyle) {
        this.f18588rdns = new Vector();
        this.f18589style = x500NameStyle;
    }

    public X500NameBuilder addMultiValuedRDN(ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr, ASN1Encodable[] aSN1EncodableArr) {
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[aSN1ObjectIdentifierArr.length];
        for (int i = 0; i != aSN1ObjectIdentifierArr.length; i++) {
            attributeTypeAndValueArr[i] = new AttributeTypeAndValue(aSN1ObjectIdentifierArr[i], aSN1EncodableArr[i]);
        }
        return addMultiValuedRDN(attributeTypeAndValueArr);
    }

    /* renamed from: addRDN */
    public X500NameBuilder m14669addRDN(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f18588rdns.addElement(new C5188RDN(aSN1ObjectIdentifier, aSN1Encodable));
        return this;
    }

    public X500NameBuilder addMultiValuedRDN(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.f18588rdns.addElement(new C5188RDN(attributeTypeAndValueArr));
        return this;
    }

    /* renamed from: addRDN */
    public X500NameBuilder m14670addRDN(AttributeTypeAndValue attributeTypeAndValue) {
        this.f18588rdns.addElement(new C5188RDN(attributeTypeAndValue));
        return this;
    }
}
