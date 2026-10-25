package org.bouncycastle.p133asn1.p138cmp;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p141crmf.C5116CertId;
import org.bouncycastle.p133asn1.p174x509.CertificateList;

/* loaded from: classes.dex */
public class RevRepContent extends ASN1Object {

    /* renamed from: crls */
    private ASN1Sequence f18160crls;
    private ASN1Sequence revCerts;

    /* renamed from: status */
    private final ASN1Sequence f18161status;

    private RevRepContent(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18161status = ASN1Sequence.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1TaggedObject aSN1TaggedObject = ASN1TaggedObject.getInstance(objects.nextElement());
            if (aSN1TaggedObject.hasContextTag(0)) {
                this.revCerts = ASN1Sequence.getInstance(aSN1TaggedObject, true);
            } else if (aSN1TaggedObject.hasContextTag(1)) {
                this.f18160crls = ASN1Sequence.getInstance(aSN1TaggedObject, true);
            }
        }
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }

    public static RevRepContent getInstance(Object obj) {
        if (obj instanceof RevRepContent) {
            return (RevRepContent) obj;
        }
        if (obj != null) {
            return new RevRepContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getCrls */
    public CertificateList[] m14524getCrls() {
        ASN1Sequence aSN1Sequence = this.f18160crls;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        CertificateList[] certificateListArr = new CertificateList[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            certificateListArr[i] = CertificateList.getInstance(this.f18160crls.getObjectAt(i));
        }
        return certificateListArr;
    }

    public C5116CertId[] getRevCerts() {
        ASN1Sequence aSN1Sequence = this.revCerts;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        C5116CertId[] c5116CertIdArr = new C5116CertId[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            c5116CertIdArr[i] = C5116CertId.getInstance(this.revCerts.getObjectAt(i));
        }
        return c5116CertIdArr;
    }

    public PKIStatusInfo[] getStatus() {
        int iMo14450size = this.f18161status.mo14450size();
        PKIStatusInfo[] pKIStatusInfoArr = new PKIStatusInfo[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            pKIStatusInfoArr[i] = PKIStatusInfo.getInstance(this.f18161status.getObjectAt(i));
        }
        return pKIStatusInfoArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.f18161status);
        addOptional(aSN1EncodableVector, 0, this.revCerts);
        addOptional(aSN1EncodableVector, 1, this.f18160crls);
        return new DERSequence(aSN1EncodableVector);
    }
}
