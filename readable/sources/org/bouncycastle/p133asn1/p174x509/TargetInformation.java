package org.bouncycastle.p133asn1.p174x509;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class TargetInformation extends ASN1Object {

    /* renamed from: targets */
    private ASN1Sequence f18695targets;

    private TargetInformation(ASN1Sequence aSN1Sequence) {
        this.f18695targets = aSN1Sequence;
    }

    public static TargetInformation getInstance(Object obj) {
        if (obj instanceof TargetInformation) {
            return (TargetInformation) obj;
        }
        if (obj != null) {
            return new TargetInformation(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public C5193Targets[] getTargetsObjects() {
        C5193Targets[] c5193TargetsArr = new C5193Targets[this.f18695targets.mo14450size()];
        Enumeration objects = this.f18695targets.getObjects();
        int i = 0;
        while (objects.hasMoreElements()) {
            c5193TargetsArr[i] = C5193Targets.getInstance(objects.nextElement());
            i++;
        }
        return c5193TargetsArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18695targets;
    }

    public TargetInformation(C5193Targets c5193Targets) {
        this.f18695targets = new DERSequence(c5193Targets);
    }

    public TargetInformation(C5192Target[] c5192TargetArr) {
        this(new C5193Targets(c5192TargetArr));
    }
}
