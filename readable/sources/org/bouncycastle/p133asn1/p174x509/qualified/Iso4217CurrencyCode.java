package org.bouncycastle.p133asn1.p174x509.qualified;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1PrintableString;
import org.bouncycastle.p133asn1.DERPrintableString;

/* loaded from: classes2.dex */
public class Iso4217CurrencyCode extends ASN1Object implements ASN1Choice {

    /* renamed from: numeric */
    int f18747numeric;

    /* renamed from: obj */
    ASN1Encodable f18748obj;
    final int ALPHABETIC_MAXSIZE = 3;
    final int NUMERIC_MINSIZE = 1;
    final int NUMERIC_MAXSIZE = 999;

    public Iso4217CurrencyCode(int i) {
        if (i > 999 || i < 1) {
            throw new IllegalArgumentException("wrong size in numeric code : not in (1..999)");
        }
        this.f18748obj = ASN1Integer.m14429valueOf(i);
    }

    public static Iso4217CurrencyCode getInstance(Object obj) {
        if (obj == null || (obj instanceof Iso4217CurrencyCode)) {
            return (Iso4217CurrencyCode) obj;
        }
        if (obj instanceof ASN1Integer) {
            return new Iso4217CurrencyCode(ASN1Integer.getInstance(obj).intValueExact());
        }
        if (obj instanceof ASN1PrintableString) {
            return new Iso4217CurrencyCode(ASN1PrintableString.getInstance(obj).getString());
        }
        throw new IllegalArgumentException("unknown object in getInstance");
    }

    public String getAlphabetic() {
        return ((ASN1PrintableString) this.f18748obj).getString();
    }

    public int getNumeric() {
        return ((ASN1Integer) this.f18748obj).intValueExact();
    }

    public boolean isAlphabetic() {
        return this.f18748obj instanceof ASN1PrintableString;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18748obj.toASN1Primitive();
    }

    public Iso4217CurrencyCode(String str) {
        if (str.length() > 3) {
            throw new IllegalArgumentException("wrong size in alphabetic code : max size is 3");
        }
        this.f18748obj = new DERPrintableString(str);
    }
}
