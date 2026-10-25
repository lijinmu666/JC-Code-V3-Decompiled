package org.bouncycastle.p133asn1.p174x509;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class CRLDistPoint extends ASN1Object {

    /* renamed from: seq */
    ASN1Sequence f18629seq;

    private CRLDistPoint(ASN1Sequence aSN1Sequence) {
        this.f18629seq = aSN1Sequence;
    }

    public static CRLDistPoint fromExtensions(Extensions extensions) {
        return getInstance(Extensions.getExtensionParsedValue(extensions, Extension.cRLDistributionPoints));
    }

    public static CRLDistPoint getInstance(Object obj) {
        if (obj instanceof CRLDistPoint) {
            return (CRLDistPoint) obj;
        }
        if (obj != null) {
            return new CRLDistPoint(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public DistributionPoint[] getDistributionPoints() {
        DistributionPoint[] distributionPointArr = new DistributionPoint[this.f18629seq.mo14450size()];
        for (int i = 0; i != this.f18629seq.mo14450size(); i++) {
            distributionPointArr[i] = DistributionPoint.getInstance(this.f18629seq.getObjectAt(i));
        }
        return distributionPointArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18629seq;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append("CRLDistPoint:");
        sb.append(strLineSeparator);
        DistributionPoint[] distributionPoints = getDistributionPoints();
        for (int i = 0; i != distributionPoints.length; i++) {
            sb.append("    ");
            sb.append(distributionPoints[i]);
            sb.append(strLineSeparator);
        }
        return sb.toString();
    }

    public CRLDistPoint(DistributionPoint[] distributionPointArr) {
        this.f18629seq = null;
        this.f18629seq = new DERSequence(distributionPointArr);
    }

    public static CRLDistPoint getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }
}
