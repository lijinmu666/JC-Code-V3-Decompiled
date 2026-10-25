package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;

/* loaded from: classes.dex */
public class CertConfirmContent extends ASN1Object {

    /* renamed from: content */
    private final ASN1Sequence f18100content;

    private CertConfirmContent(ASN1Sequence aSN1Sequence) {
        this.f18100content = aSN1Sequence;
    }

    public static CertConfirmContent getInstance(Object obj) {
        if (obj instanceof CertConfirmContent) {
            return (CertConfirmContent) obj;
        }
        if (obj != null) {
            return new CertConfirmContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return this.f18100content;
    }

    public CertStatus[] toCertStatusArray() {
        int iMo14450size = this.f18100content.mo14450size();
        CertStatus[] certStatusArr = new CertStatus[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            certStatusArr[i] = CertStatus.getInstance(this.f18100content.getObjectAt(i));
        }
        return certStatusArr;
    }
}
