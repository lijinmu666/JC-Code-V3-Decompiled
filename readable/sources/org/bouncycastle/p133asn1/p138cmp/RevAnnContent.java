package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p141crmf.C5116CertId;
import org.bouncycastle.p133asn1.p174x509.Extensions;

/* loaded from: classes.dex */
public class RevAnnContent extends ASN1Object {
    private final ASN1GeneralizedTime badSinceDate;

    /* renamed from: certId */
    private final C5116CertId f18158certId;
    private Extensions crlDetails;

    /* renamed from: status */
    private final PKIStatus f18159status;
    private final ASN1GeneralizedTime willBeRevokedAt;

    private RevAnnContent(ASN1Sequence aSN1Sequence) {
        this.f18159status = PKIStatus.getInstance(aSN1Sequence.getObjectAt(0));
        this.f18158certId = C5116CertId.getInstance(aSN1Sequence.getObjectAt(1));
        this.willBeRevokedAt = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(2));
        this.badSinceDate = ASN1GeneralizedTime.getInstance(aSN1Sequence.getObjectAt(3));
        if (aSN1Sequence.mo14450size() > 4) {
            this.crlDetails = Extensions.getInstance(aSN1Sequence.getObjectAt(4));
        }
    }

    public static RevAnnContent getInstance(Object obj) {
        if (obj instanceof RevAnnContent) {
            return (RevAnnContent) obj;
        }
        if (obj != null) {
            return new RevAnnContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1GeneralizedTime getBadSinceDate() {
        return this.badSinceDate;
    }

    public C5116CertId getCertId() {
        return this.f18158certId;
    }

    public Extensions getCrlDetails() {
        return this.crlDetails;
    }

    public PKIStatus getStatus() {
        return this.f18159status;
    }

    public ASN1GeneralizedTime getWillBeRevokedAt() {
        return this.willBeRevokedAt;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(5);
        aSN1EncodableVector.m14420add(this.f18159status);
        aSN1EncodableVector.m14420add(this.f18158certId);
        aSN1EncodableVector.m14420add(this.willBeRevokedAt);
        aSN1EncodableVector.m14420add(this.badSinceDate);
        Extensions extensions = this.crlDetails;
        if (extensions != null) {
            aSN1EncodableVector.m14420add(extensions);
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public RevAnnContent(PKIStatus pKIStatus, C5116CertId c5116CertId, ASN1GeneralizedTime aSN1GeneralizedTime, ASN1GeneralizedTime aSN1GeneralizedTime2) {
        this(pKIStatus, c5116CertId, aSN1GeneralizedTime, aSN1GeneralizedTime2, null);
    }

    public RevAnnContent(PKIStatus pKIStatus, C5116CertId c5116CertId, ASN1GeneralizedTime aSN1GeneralizedTime, ASN1GeneralizedTime aSN1GeneralizedTime2, Extensions extensions) {
        this.f18159status = pKIStatus;
        this.f18158certId = c5116CertId;
        this.willBeRevokedAt = aSN1GeneralizedTime;
        this.badSinceDate = aSN1GeneralizedTime2;
        this.crlDetails = extensions;
    }
}
