package org.bouncycastle.p133asn1.p165oiw;

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
    ASN1Integer f18452g;

    /* renamed from: p */
    ASN1Integer f18453p;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f18453p = new ASN1Integer(bigInteger);
        this.f18452g = new ASN1Integer(bigInteger2);
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
    public BigInteger m14624getG() {
        return this.f18452g.getPositiveValue();
    }

    /* renamed from: getP */
    public BigInteger m14625getP() {
        return this.f18453p.getPositiveValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18453p, this.f18452g);
    }

    private ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18453p = (ASN1Integer) objects.nextElement();
        this.f18452g = (ASN1Integer) objects.nextElement();
    }
}
