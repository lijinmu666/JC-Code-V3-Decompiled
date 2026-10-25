package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;

/* loaded from: classes2.dex */
public abstract class UintBase extends ASN1Object {

    /* renamed from: value */
    protected final BigInteger f22780value;

    public UintBase(int i) {
        this(BigInteger.valueOf(i));
    }

    public abstract void assertLimit();

    public BigInteger getValue() {
        return this.f22780value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new ASN1Integer(this.f22780value);
    }

    public UintBase(long j) {
        this(BigInteger.valueOf(j));
    }

    public UintBase(BigInteger bigInteger) {
        this.f22780value = bigInteger;
        assertLimit();
    }

    public UintBase(ASN1Integer aSN1Integer) {
        this(aSN1Integer.getValue());
    }
}
