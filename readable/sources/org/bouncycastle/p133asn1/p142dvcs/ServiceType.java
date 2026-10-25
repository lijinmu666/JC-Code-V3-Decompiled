package org.bouncycastle.p133asn1.p142dvcs;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class ServiceType extends ASN1Object {

    /* renamed from: value */
    private ASN1Enumerated f18323value;

    /* renamed from: CPD */
    public static final ServiceType f18320CPD = new ServiceType(1);

    /* renamed from: VSD */
    public static final ServiceType f18322VSD = new ServiceType(2);

    /* renamed from: VPKC */
    public static final ServiceType f18321VPKC = new ServiceType(3);

    /* renamed from: CCPD */
    public static final ServiceType f18319CCPD = new ServiceType(4);

    public ServiceType(int i) {
        this.f18323value = new ASN1Enumerated(i);
    }

    public static ServiceType getInstance(Object obj) {
        if (obj instanceof ServiceType) {
            return (ServiceType) obj;
        }
        if (obj != null) {
            return new ServiceType(ASN1Enumerated.getInstance(obj));
        }
        return null;
    }

    public BigInteger getValue() {
        return this.f18323value.getValue();
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18323value;
    }

    public String toString() {
        int iIntValueExact = this.f18323value.intValueExact();
        StringBuilder sb = new StringBuilder();
        sb.append(BuildConfig.f24315FLAVOR);
        sb.append(iIntValueExact);
        sb.append(iIntValueExact == f18320CPD.f18323value.intValueExact() ? "(CPD)" : iIntValueExact == f18322VSD.f18323value.intValueExact() ? "(VSD)" : iIntValueExact == f18321VPKC.f18323value.intValueExact() ? "(VPKC)" : iIntValueExact == f18319CCPD.f18323value.intValueExact() ? "(CCPD)" : "?");
        return sb.toString();
    }

    private ServiceType(ASN1Enumerated aSN1Enumerated) {
        this.f18323value = aSN1Enumerated;
    }

    public static ServiceType getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Enumerated.getInstance(aSN1TaggedObject, z));
    }
}
