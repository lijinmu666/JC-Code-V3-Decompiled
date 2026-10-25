package org.bouncycastle.p133asn1.p172x500;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.p173style.C5189BCStyle;

/* loaded from: classes2.dex */
public class X500Name extends ASN1Object implements ASN1Choice {
    private static X500NameStyle defaultStyle = C5189BCStyle.INSTANCE;
    private int hashCodeValue;
    private boolean isHashCodeCalculated;

    /* renamed from: rdnSeq */
    private DERSequence f18585rdnSeq;

    /* renamed from: rdns */
    private C5188RDN[] f18586rdns;

    /* renamed from: style */
    private X500NameStyle f18587style;

    public X500Name(String str) {
        this(defaultStyle, str);
    }

    public static X500NameStyle getDefaultStyle() {
        return defaultStyle;
    }

    public static X500Name getInstance(Object obj) {
        if (obj instanceof X500Name) {
            return (X500Name) obj;
        }
        if (obj != null) {
            return new X500Name(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static void setDefaultStyle(X500NameStyle x500NameStyle) {
        if (x500NameStyle == null) {
            throw new NullPointerException("cannot set style to null");
        }
        defaultStyle = x500NameStyle;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    /* renamed from: equals */
    public boolean mo14431equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X500Name) && !(obj instanceof ASN1Sequence)) {
            return false;
        }
        if (toASN1Primitive().m14446equals(((ASN1Encodable) obj).toASN1Primitive())) {
            return true;
        }
        try {
            return this.f18587style.areEqual(this, getInstance(obj));
        } catch (Exception unused) {
            return false;
        }
    }

    public ASN1ObjectIdentifier[] getAttributeTypes() {
        int length = this.f18586rdns.length;
        int iM14664size = 0;
        for (int i = 0; i < length; i++) {
            iM14664size += this.f18586rdns[i].m14664size();
        }
        ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = new ASN1ObjectIdentifier[iM14664size];
        int iCollectAttributeTypes = 0;
        for (int i2 = 0; i2 < length; i2++) {
            iCollectAttributeTypes += this.f18586rdns[i2].collectAttributeTypes(aSN1ObjectIdentifierArr, iCollectAttributeTypes);
        }
        return aSN1ObjectIdentifierArr;
    }

    /* renamed from: getRDNs */
    public C5188RDN[] m14665getRDNs() {
        return (C5188RDN[]) this.f18586rdns.clone();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        if (this.isHashCodeCalculated) {
            return this.hashCodeValue;
        }
        this.isHashCodeCalculated = true;
        int iCalculateHashCode = this.f18587style.calculateHashCode(this);
        this.hashCodeValue = iCalculateHashCode;
        return iCalculateHashCode;
    }

    /* renamed from: size */
    public int m14667size() {
        return this.f18586rdns.length;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18585rdnSeq;
    }

    public String toString() {
        return this.f18587style.toString(this);
    }

    private X500Name(ASN1Sequence aSN1Sequence) {
        this(defaultStyle, aSN1Sequence);
    }

    public static X500Name getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, true));
    }

    /* renamed from: getRDNs */
    public C5188RDN[] m14666getRDNs(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int length = this.f18586rdns.length;
        C5188RDN[] c5188rdnArr = new C5188RDN[length];
        int i = 0;
        int i2 = 0;
        while (true) {
            C5188RDN[] c5188rdnArr2 = this.f18586rdns;
            if (i == c5188rdnArr2.length) {
                break;
            }
            C5188RDN c5188rdn = c5188rdnArr2[i];
            if (c5188rdn.containsAttributeType(aSN1ObjectIdentifier)) {
                c5188rdnArr[i2] = c5188rdn;
                i2++;
            }
            i++;
        }
        if (i2 >= length) {
            return c5188rdnArr;
        }
        C5188RDN[] c5188rdnArr3 = new C5188RDN[i2];
        System.arraycopy(c5188rdnArr, 0, c5188rdnArr3, 0, i2);
        return c5188rdnArr3;
    }

    public X500Name(X500NameStyle x500NameStyle, String str) {
        this(x500NameStyle.fromString(str));
        this.f18587style = x500NameStyle;
    }

    public static X500Name getInstance(X500NameStyle x500NameStyle, Object obj) {
        if (obj instanceof X500Name) {
            return new X500Name(x500NameStyle, (X500Name) obj);
        }
        if (obj != null) {
            return new X500Name(x500NameStyle, ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    private X500Name(X500NameStyle x500NameStyle, ASN1Sequence aSN1Sequence) {
        int iMo14450size = aSN1Sequence.mo14450size();
        this.f18587style = x500NameStyle;
        this.f18586rdns = new C5188RDN[iMo14450size];
        boolean z = true;
        for (int i = 0; i < iMo14450size; i++) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i);
            C5188RDN c5188rdn = C5188RDN.getInstance(objectAt);
            z &= c5188rdn == objectAt;
            this.f18586rdns[i] = c5188rdn;
        }
        this.f18585rdnSeq = z ? DERSequence.m14472convert(aSN1Sequence) : new DERSequence(this.f18586rdns);
    }

    public X500Name(X500NameStyle x500NameStyle, X500Name x500Name) {
        this.f18587style = x500NameStyle;
        this.f18586rdns = x500Name.f18586rdns;
        this.f18585rdnSeq = x500Name.f18585rdnSeq;
    }

    public X500Name(X500NameStyle x500NameStyle, C5188RDN[] c5188rdnArr) {
        this.f18587style = x500NameStyle;
        this.f18586rdns = (C5188RDN[]) c5188rdnArr.clone();
        this.f18585rdnSeq = new DERSequence(this.f18586rdns);
    }

    public X500Name(C5188RDN[] c5188rdnArr) {
        this(defaultStyle, c5188rdnArr);
    }
}
