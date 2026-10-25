package org.bouncycastle.p133asn1.p176x9;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class DHDomainParameters extends ASN1Object {

    /* renamed from: g */
    private ASN1Integer f18756g;

    /* renamed from: j */
    private ASN1Integer f18757j;

    /* renamed from: p */
    private ASN1Integer f18758p;

    /* renamed from: q */
    private ASN1Integer f18759q;
    private DHValidationParms validationParms;

    public DHDomainParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, DHValidationParms dHValidationParms) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (bigInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (bigInteger3 == null) {
            throw new IllegalArgumentException("'q' cannot be null");
        }
        this.f18758p = new ASN1Integer(bigInteger);
        this.f18756g = new ASN1Integer(bigInteger2);
        this.f18759q = new ASN1Integer(bigInteger3);
        this.f18757j = new ASN1Integer(bigInteger4);
        this.validationParms = dHValidationParms;
    }

    public static DHDomainParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof DHDomainParameters)) {
            return (DHDomainParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new DHDomainParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid DHDomainParameters: " + obj.getClass().getName());
    }

    /* renamed from: getNext */
    private static ASN1Encodable m14715getNext(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            return (ASN1Encodable) enumeration.nextElement();
        }
        return null;
    }

    /* renamed from: getG */
    public ASN1Integer m14716getG() {
        return this.f18756g;
    }

    /* renamed from: getJ */
    public ASN1Integer m14717getJ() {
        return this.f18757j;
    }

    /* renamed from: getP */
    public ASN1Integer m14718getP() {
        return this.f18758p;
    }

    /* renamed from: getQ */
    public ASN1Integer m14719getQ() {
        return this.f18759q;
    }

    public DHValidationParms getValidationParms() {
        return this.validationParms;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.m14420add(this.f18758p);
        aSN1EncodableVector.m14420add(this.f18756g);
        aSN1EncodableVector.m14420add(this.f18759q);
        ASN1Integer aSN1Integer = this.f18757j;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        DHValidationParms dHValidationParms = this.validationParms;
        if (dHValidationParms != null) {
            aSN1EncodableVector.m14420add(dHValidationParms);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public DHDomainParameters(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, ASN1Integer aSN1Integer3, ASN1Integer aSN1Integer4, DHValidationParms dHValidationParms) {
        if (aSN1Integer == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (aSN1Integer2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (aSN1Integer3 == null) {
            throw new IllegalArgumentException("'q' cannot be null");
        }
        this.f18758p = aSN1Integer;
        this.f18756g = aSN1Integer2;
        this.f18759q = aSN1Integer3;
        this.f18757j = aSN1Integer4;
        this.validationParms = dHValidationParms;
    }

    public static DHDomainParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    private DHDomainParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 3 || aSN1Sequence.mo14450size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18758p = ASN1Integer.getInstance(objects.nextElement());
        this.f18756g = ASN1Integer.getInstance(objects.nextElement());
        this.f18759q = ASN1Integer.getInstance(objects.nextElement());
        ASN1Encodable aSN1EncodableM14715getNext = m14715getNext(objects);
        if (aSN1EncodableM14715getNext != null && (aSN1EncodableM14715getNext instanceof ASN1Integer)) {
            this.f18757j = ASN1Integer.getInstance(aSN1EncodableM14715getNext);
            aSN1EncodableM14715getNext = m14715getNext(objects);
        }
        if (aSN1EncodableM14715getNext != null) {
            this.validationParms = DHValidationParms.getInstance(aSN1EncodableM14715getNext.toASN1Primitive());
        }
    }
}
