package org.bouncycastle.p133asn1.p146ess;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;

/* loaded from: classes2.dex */
public class ContentIdentifier extends ASN1Object {

    /* renamed from: value */
    ASN1OctetString f18375value;

    private ContentIdentifier(ASN1OctetString aSN1OctetString) {
        this.f18375value = aSN1OctetString;
    }

    public static ContentIdentifier getInstance(Object obj) {
        if (obj instanceof ContentIdentifier) {
            return (ContentIdentifier) obj;
        }
        if (obj != null) {
            return new ContentIdentifier(ASN1OctetString.getInstance(obj));
        }
        return null;
    }

    public ASN1OctetString getValue() {
        return this.f18375value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18375value;
    }

    public ContentIdentifier(byte[] bArr) {
        this(new DEROctetString(bArr));
    }
}
