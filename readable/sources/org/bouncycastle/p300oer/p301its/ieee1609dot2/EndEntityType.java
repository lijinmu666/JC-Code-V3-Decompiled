package org.bouncycastle.p300oer.p301its.ieee1609dot2;

import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERBitString;

/* loaded from: classes2.dex */
public class EndEntityType extends ASN1Object {

    /* renamed from: app */
    public static final int f22639app = 128;

    /* renamed from: enrol */
    public static final int f22640enrol = 64;

    /* renamed from: type */
    private final ASN1BitString f22641type;

    public EndEntityType(int i) {
        this(new DERBitString(i));
    }

    public static EndEntityType getInstance(Object obj) {
        if (obj instanceof EndEntityType) {
            return (EndEntityType) obj;
        }
        if (obj != null) {
            return new EndEntityType(ASN1BitString.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getType */
    public ASN1BitString m17226getType() {
        return this.f22641type;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f22641type;
    }

    private EndEntityType(ASN1BitString aSN1BitString) {
        this.f22641type = aSN1BitString;
    }
}
