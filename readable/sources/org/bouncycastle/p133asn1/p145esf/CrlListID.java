package org.bouncycastle.p133asn1.p145esf;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;

/* loaded from: classes2.dex */
public class CrlListID extends ASN1Object {

    /* renamed from: crls */
    private ASN1Sequence f18368crls;

    private CrlListID(ASN1Sequence aSN1Sequence) {
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
        this.f18368crls = aSN1Sequence2;
        Enumeration objects = aSN1Sequence2.getObjects();
        while (objects.hasMoreElements()) {
            CrlValidatedID.getInstance(objects.nextElement());
        }
    }

    public static CrlListID getInstance(Object obj) {
        if (obj instanceof CrlListID) {
            return (CrlListID) obj;
        }
        if (obj != null) {
            return new CrlListID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCrls */
    public CrlValidatedID[] m14604getCrls() {
        int iMo14450size = this.f18368crls.mo14450size();
        CrlValidatedID[] crlValidatedIDArr = new CrlValidatedID[iMo14450size];
        for (int i = 0; i < iMo14450size; i++) {
            crlValidatedIDArr[i] = CrlValidatedID.getInstance(this.f18368crls.getObjectAt(i));
        }
        return crlValidatedIDArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.f18368crls);
    }

    public CrlListID(CrlValidatedID[] crlValidatedIDArr) {
        this.f18368crls = new DERSequence(crlValidatedIDArr);
    }
}
