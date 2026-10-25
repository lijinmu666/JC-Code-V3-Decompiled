package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class Validity extends ASN1Object {
    private final C5194Time notAfter;
    private final C5194Time notBefore;

    private Validity(ASN1Sequence aSN1Sequence) {
        int iMo14450size = aSN1Sequence.mo14450size();
        if (iMo14450size == 2) {
            this.notBefore = C5194Time.getInstance(aSN1Sequence.getObjectAt(0));
            this.notAfter = C5194Time.getInstance(aSN1Sequence.getObjectAt(1));
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + iMo14450size);
        }
    }

    public static Validity getInstance(Object obj) {
        if (obj instanceof Validity) {
            return (Validity) obj;
        }
        if (obj != null) {
            return new Validity(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5194Time getNotAfter() {
        return this.notAfter;
    }

    public C5194Time getNotBefore() {
        return this.notBefore;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.notBefore, this.notAfter);
    }

    public Validity(C5194Time c5194Time, C5194Time c5194Time2) {
        if (c5194Time == null) {
            throw new NullPointerException("'notBefore' cannot be null");
        }
        if (c5194Time2 == null) {
            throw new NullPointerException("'notAfter' cannot be null");
        }
        this.notBefore = c5194Time;
        this.notAfter = c5194Time2;
    }

    public static Validity getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return new Validity(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
