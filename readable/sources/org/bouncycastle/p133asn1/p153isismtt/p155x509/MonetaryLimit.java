package org.bouncycastle.p133asn1.p153isismtt.p155x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1PrintableString;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERPrintableString;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class MonetaryLimit extends ASN1Object {

    /* renamed from: amount */
    ASN1Integer f18408amount;
    ASN1PrintableString currency;
    ASN1Integer exponent;

    public MonetaryLimit(String str, int i, int i2) {
        this.currency = new DERPrintableString(str, true);
        this.f18408amount = ASN1Integer.m14429valueOf(i);
        this.exponent = ASN1Integer.m14429valueOf(i2);
    }

    public static MonetaryLimit getInstance(Object obj) {
        if (obj == null || (obj instanceof MonetaryLimit)) {
            return (MonetaryLimit) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new MonetaryLimit(ASN1Sequence.getInstance(obj));
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public BigInteger getAmount() {
        return this.f18408amount.getValue();
    }

    public String getCurrency() {
        return this.currency.getString();
    }

    public BigInteger getExponent() {
        return this.exponent.getValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.currency);
        aSN1EncodableVector.m14420add(this.f18408amount);
        aSN1EncodableVector.m14420add(this.exponent);
        return new DERSequence(aSN1EncodableVector);
    }

    private MonetaryLimit(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.currency = ASN1PrintableString.getInstance(objects.nextElement());
        this.f18408amount = ASN1Integer.getInstance(objects.nextElement());
        this.exponent = ASN1Integer.getInstance(objects.nextElement());
    }
}
