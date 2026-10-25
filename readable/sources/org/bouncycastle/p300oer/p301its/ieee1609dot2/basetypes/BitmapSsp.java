package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BitmapSsp extends ASN1Object {

    /* renamed from: string */
    private final DEROctetString f22691string;

    public BitmapSsp(DEROctetString dEROctetString) {
        this.f22691string = dEROctetString;
    }

    public static BitmapSsp getInstance(Object obj) {
        if (obj instanceof BitmapSsp) {
            return (BitmapSsp) obj;
        }
        if (obj != null) {
            return new BitmapSsp(ASN1OctetString.getInstance(obj).getOctets());
        }
        return null;
    }

    public DEROctetString getString() {
        return this.f22691string;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f22691string;
    }

    public BitmapSsp(byte[] bArr) {
        this.f22691string = new DEROctetString(C6238Arrays.m18231clone(bArr));
    }
}
