package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p361util.BigIntegers;

/* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.IValue */
/* loaded from: classes2.dex */
public class C5949IValue extends ASN1Object {

    /* renamed from: value */
    private final BigInteger f22733value;

    private C5949IValue(ASN1Integer aSN1Integer) {
        int iIntValueExact = BigIntegers.intValueExact(aSN1Integer.getValue());
        if (iIntValueExact < 0 || iIntValueExact > 65535) {
            throw new IllegalArgumentException("value out of range");
        }
        this.f22733value = aSN1Integer.getValue();
    }

    public static C5949IValue getInstance(Object obj) {
        if (obj instanceof C5949IValue) {
            return (C5949IValue) obj;
        }
        if (obj != null) {
            return new C5949IValue(ASN1Integer.getInstance(obj));
        }
        return null;
    }

    public BigInteger getValue() {
        return this.f22733value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f22733value);
    }
}
