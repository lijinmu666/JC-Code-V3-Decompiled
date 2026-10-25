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
public class DomainParameters extends ASN1Object {

    /* renamed from: g */
    private final ASN1Integer f18762g;

    /* renamed from: j */
    private final ASN1Integer f18763j;

    /* renamed from: p */
    private final ASN1Integer f18764p;

    /* renamed from: q */
    private final ASN1Integer f18765q;
    private final ValidationParams validationParams;

    public DomainParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, ValidationParams validationParams) {
        if (bigInteger == null) {
            throw new IllegalArgumentException("'p' cannot be null");
        }
        if (bigInteger2 == null) {
            throw new IllegalArgumentException("'g' cannot be null");
        }
        if (bigInteger3 == null) {
            throw new IllegalArgumentException("'q' cannot be null");
        }
        this.f18764p = new ASN1Integer(bigInteger);
        this.f18762g = new ASN1Integer(bigInteger2);
        this.f18765q = new ASN1Integer(bigInteger3);
        this.f18763j = bigInteger4 != null ? new ASN1Integer(bigInteger4) : null;
        this.validationParams = validationParams;
    }

    public static DomainParameters getInstance(Object obj) {
        if (obj instanceof DomainParameters) {
            return (DomainParameters) obj;
        }
        if (obj != null) {
            return new DomainParameters(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getNext */
    private static ASN1Encodable m14722getNext(Enumeration enumeration) {
        if (enumeration.hasMoreElements()) {
            return (ASN1Encodable) enumeration.nextElement();
        }
        return null;
    }

    /* renamed from: getG */
    public BigInteger m14723getG() {
        return this.f18762g.getPositiveValue();
    }

    /* renamed from: getJ */
    public BigInteger m14724getJ() {
        ASN1Integer aSN1Integer = this.f18763j;
        if (aSN1Integer == null) {
            return null;
        }
        return aSN1Integer.getPositiveValue();
    }

    /* renamed from: getP */
    public BigInteger m14725getP() {
        return this.f18764p.getPositiveValue();
    }

    /* renamed from: getQ */
    public BigInteger m14726getQ() {
        return this.f18765q.getPositiveValue();
    }

    public ValidationParams getValidationParams() {
        return this.validationParams;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.m14420add(this.f18764p);
        aSN1EncodableVector.m14420add(this.f18762g);
        aSN1EncodableVector.m14420add(this.f18765q);
        ASN1Integer aSN1Integer = this.f18763j;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        ValidationParams validationParams = this.validationParams;
        if (validationParams != null) {
            aSN1EncodableVector.m14420add(validationParams);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    private DomainParameters(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() < 3 || aSN1Sequence.mo14450size() > 5) {
            throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.mo14450size());
        }
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18764p = ASN1Integer.getInstance(objects.nextElement());
        this.f18762g = ASN1Integer.getInstance(objects.nextElement());
        this.f18765q = ASN1Integer.getInstance(objects.nextElement());
        ASN1Encodable aSN1EncodableM14722getNext = m14722getNext(objects);
        if (aSN1EncodableM14722getNext == null || !(aSN1EncodableM14722getNext instanceof ASN1Integer)) {
            this.f18763j = null;
        } else {
            this.f18763j = ASN1Integer.getInstance(aSN1EncodableM14722getNext);
            aSN1EncodableM14722getNext = m14722getNext(objects);
        }
        if (aSN1EncodableM14722getNext != null) {
            this.validationParams = ValidationParams.getInstance(aSN1EncodableM14722getNext.toASN1Primitive());
        } else {
            this.validationParams = null;
        }
    }

    public static DomainParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
