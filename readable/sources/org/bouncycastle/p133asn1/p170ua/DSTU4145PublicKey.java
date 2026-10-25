package org.bouncycastle.p133asn1.p170ua;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class DSTU4145PublicKey extends ASN1Object {

    /* renamed from: pubKey */
    private ASN1OctetString f18575pubKey;

    private DSTU4145PublicKey(ASN1OctetString aSN1OctetString) {
        this.f18575pubKey = aSN1OctetString;
    }

    public static DSTU4145PublicKey getInstance(Object obj) {
        if (obj instanceof DSTU4145PublicKey) {
            return (DSTU4145PublicKey) obj;
        }
        if (obj != null) {
            return new DSTU4145PublicKey(ASN1OctetString.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18575pubKey;
    }

    public DSTU4145PublicKey(AbstractC5820ECPoint abstractC5820ECPoint) {
        this.f18575pubKey = new DEROctetString(DSTU4145PointEncoder.encodePoint(abstractC5820ECPoint));
    }
}
