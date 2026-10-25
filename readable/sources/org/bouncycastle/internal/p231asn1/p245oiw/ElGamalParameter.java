package org.bouncycastle.internal.p231asn1.p245oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class ElGamalParameter extends ASN1Object {

    /* renamed from: g */
    ASN1Integer f21275g;

    /* renamed from: p */
    ASN1Integer f21276p;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f21276p = new ASN1Integer(bigInteger);
        this.f21275g = new ASN1Integer(bigInteger2);
    }

    public static ElGamalParameter getInstance(Object obj) {
        if (obj instanceof ElGamalParameter) {
            return (ElGamalParameter) obj;
        }
        if (obj != null) {
            return new ElGamalParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getG */
    public BigInteger m15990getG() {
        return this.f21275g.getPositiveValue();
    }

    /* renamed from: getP */
    public BigInteger m15991getP() {
        return this.f21276p.getPositiveValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f21276p, this.f21275g);
    }

    private ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f21276p = (ASN1Integer) objects.nextElement();
        this.f21275g = (ASN1Integer) objects.nextElement();
    }
}
