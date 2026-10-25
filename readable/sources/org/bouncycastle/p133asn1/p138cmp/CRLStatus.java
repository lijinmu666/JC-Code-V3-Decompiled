package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.C5194Time;

/* loaded from: classes.dex */
public class CRLStatus extends ASN1Object {

    /* renamed from: source */
    private final CRLSource f18099source;
    private final C5194Time thisUpdate;

    private CRLStatus(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() == 1 || aSN1Sequence.mo14450size() == 2) {
            this.f18099source = CRLSource.getInstance(aSN1Sequence.getObjectAt(0));
            this.thisUpdate = aSN1Sequence.mo14450size() == 2 ? C5194Time.getInstance(aSN1Sequence.getObjectAt(1)) : null;
        } else {
            throw new IllegalArgumentException("expected sequence size of 1 or 2, got " + aSN1Sequence.mo14450size());
        }
    }

    public static CRLStatus getInstance(Object obj) {
        if (obj instanceof CRLStatus) {
            return (CRLStatus) obj;
        }
        if (obj != null) {
            return new CRLStatus(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CRLSource getSource() {
        return this.f18099source;
    }

    public C5194Time getThisUpdate() {
        return this.thisUpdate;
    }

    /* renamed from: getTime */
    public C5194Time m14501getTime() {
        return this.thisUpdate;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.m14420add(this.f18099source);
        C5194Time c5194Time = this.thisUpdate;
        if (c5194Time != null) {
            aSN1EncodableVector.m14420add(c5194Time);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CRLStatus(CRLSource cRLSource, C5194Time c5194Time) {
        this.f18099source = cRLSource;
        this.thisUpdate = c5194Time;
    }
}
