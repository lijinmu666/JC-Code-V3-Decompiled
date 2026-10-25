package org.bouncycastle.p133asn1.p174x509;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class BasicConstraints extends ASN1Object {

    /* renamed from: cA */
    ASN1Boolean f18628cA;
    ASN1Integer pathLenConstraint;

    public BasicConstraints(int i) {
        this.f18628cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        this.f18628cA = ASN1Boolean.getInstance(true);
        this.pathLenConstraint = ASN1Integer.m14429valueOf(i);
    }

    public static BasicConstraints fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.basicConstraints));
    }

    public static BasicConstraints getInstance(Object obj) {
        if (obj instanceof BasicConstraints) {
            return (BasicConstraints) obj;
        }
        if (obj instanceof X509Extension) {
            return getInstance(X509Extension.convertValueToObject((X509Extension) obj));
        }
        if (obj != null) {
            return new BasicConstraints(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getPathLenConstraint() {
        ASN1Integer aSN1Integer = this.pathLenConstraint;
        if (aSN1Integer != null) {
            return aSN1Integer.getValue();
        }
        return null;
    }

    public ASN1Integer getPathLenConstraintInteger() {
        return this.pathLenConstraint;
    }

    /* renamed from: isCA */
    public boolean m14675isCA() {
        ASN1Boolean aSN1Boolean = this.f18628cA;
        return aSN1Boolean != null && aSN1Boolean.m14419isTrue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        ASN1Boolean aSN1Boolean = this.f18628cA;
        if (aSN1Boolean != null) {
            aSN1EncodableVector.m14420add(aSN1Boolean);
        }
        ASN1Integer aSN1Integer = this.pathLenConstraint;
        if (aSN1Integer != null) {
            aSN1EncodableVector.m14420add(aSN1Integer);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuilder sb;
        if (this.pathLenConstraint == null) {
            sb = new StringBuilder();
            sb.append("BasicConstraints: isCa(");
            sb.append(m14675isCA());
            sb.append(")");
        } else {
            sb = new StringBuilder();
            sb.append("BasicConstraints: isCa(");
            sb.append(m14675isCA());
            sb.append("), pathLenConstraint = ");
            sb.append(this.pathLenConstraint.getValue());
        }
        return sb.toString();
    }

    private BasicConstraints(ASN1Sequence aSN1Sequence) {
        this.f18628cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        if (aSN1Sequence.mo14450size() == 0) {
            this.f18628cA = null;
            this.pathLenConstraint = null;
            return;
        }
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Boolean) {
            this.f18628cA = ASN1Boolean.getInstance(aSN1Sequence.getObjectAt(0));
        } else {
            this.f18628cA = null;
            this.pathLenConstraint = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0));
        }
        if (aSN1Sequence.mo14450size() > 1) {
            if (this.f18628cA == null) {
                throw new IllegalArgumentException("wrong sequence in constructor");
            }
            this.pathLenConstraint = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
        }
    }

    public static BasicConstraints getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BasicConstraints(boolean z) {
        this.f18628cA = ASN1Boolean.getInstance(false);
        this.pathLenConstraint = null;
        if (z) {
            this.f18628cA = ASN1Boolean.getInstance(true);
        } else {
            this.f18628cA = null;
        }
        this.pathLenConstraint = null;
    }
}
