package org.bouncycastle.p133asn1.p174x509;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* renamed from: org.bouncycastle.asn1.x509.Targets */
/* loaded from: classes2.dex */
public class C5193Targets extends ASN1Object {

    /* renamed from: targets */
    private ASN1Sequence f18696targets;

    private C5193Targets(ASN1Sequence aSN1Sequence) {
        this.f18696targets = aSN1Sequence;
    }

    public static C5193Targets getInstance(Object obj) {
        if (obj instanceof C5193Targets) {
            return (C5193Targets) obj;
        }
        if (obj != null) {
            return new C5193Targets(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5192Target[] getTargets() {
        C5192Target[] c5192TargetArr = new C5192Target[this.f18696targets.mo14450size()];
        Enumeration objects = this.f18696targets.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            c5192TargetArr[i] = C5192Target.getInstance(objects.nextElement());
            i++;
        }
        return c5192TargetArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18696targets;
    }

    public C5193Targets(C5192Target[] c5192TargetArr) {
        this.f18696targets = new DERSequence(c5192TargetArr);
    }
}
