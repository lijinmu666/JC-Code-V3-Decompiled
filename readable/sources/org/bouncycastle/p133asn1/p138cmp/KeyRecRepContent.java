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

/* loaded from: classes.dex */
public class KeyRecRepContent extends ASN1Object {

    /* renamed from: caCerts */
    private ASN1Sequence f18122caCerts;
    private ASN1Sequence keyPairHist;
    private CMPCertificate newSigCert;

    /* renamed from: status */
    private final PKIStatusInfo f18123status;

    private KeyRecRepContent(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f18123status = PKIStatusInfo.getInstance(objects.nextElement());
        while (objects.hasMoreElements()) {
            ASN1TaggedObject contextInstance = ASN1TaggedObject.getContextInstance(objects.nextElement());
            int tagNo = contextInstance.getTagNo();
            if (tagNo == 0) {
                this.newSigCert = CMPCertificate.getInstance(contextInstance.getExplicitBaseObject());
            } else if (tagNo == 1) {
                this.f18122caCerts = ASN1Sequence.getInstance(contextInstance.getExplicitBaseObject());
            } else {
                if (tagNo != 2) {
                    throw new IllegalArgumentException("unknown tag number: " + contextInstance.getTagNo());
                }
                this.keyPairHist = ASN1Sequence.getInstance(contextInstance.getExplicitBaseObject());
            }
        }
    }

    private void addOptional(ASN1EncodableVector aSN1EncodableVector, int i, ASN1Encodable aSN1Encodable) {
        if (aSN1Encodable != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, i, aSN1Encodable));
        }
    }

    public static KeyRecRepContent getInstance(Object obj) {
        if (obj instanceof KeyRecRepContent) {
            return (KeyRecRepContent) obj;
        }
        if (obj != null) {
            return new KeyRecRepContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CMPCertificate[] getCaCerts() {
        ASN1Sequence aSN1Sequence = this.f18122caCerts;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        CMPCertificate[] cMPCertificateArr = new CMPCertificate[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            cMPCertificateArr[i] = CMPCertificate.getInstance(this.f18122caCerts.getObjectAt(i));
        }
        return cMPCertificateArr;
    }

    public CertifiedKeyPair[] getKeyPairHist() {
        ASN1Sequence aSN1Sequence = this.keyPairHist;
        if (aSN1Sequence == null) {
            return null;
        }
        int iMo14450size = aSN1Sequence.mo14450size();
        CertifiedKeyPair[] certifiedKeyPairArr = new CertifiedKeyPair[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            certifiedKeyPairArr[i] = CertifiedKeyPair.getInstance(this.keyPairHist.getObjectAt(i));
        }
        return certifiedKeyPairArr;
    }

    public CMPCertificate getNewSigCert() {
        return this.newSigCert;
    }

    public PKIStatusInfo getStatus() {
        return this.f18123status;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(4);
        aSN1EncodableVector.m14420add(this.f18123status);
        addOptional(aSN1EncodableVector, 0, this.newSigCert);
        addOptional(aSN1EncodableVector, 1, this.f18122caCerts);
        addOptional(aSN1EncodableVector, 2, this.keyPairHist);
        return new DERSequence(aSN1EncodableVector);
    }
}
