package org.bouncycastle.p133asn1.p142dvcs;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p138cmp.PKIStatusInfo;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p146ess.ESSCertID;
import org.bouncycastle.p133asn1.p164ocsp.C5131CertID;
import org.bouncycastle.p133asn1.p164ocsp.CertStatus;
import org.bouncycastle.p133asn1.p164ocsp.OCSPResponse;
import org.bouncycastle.p133asn1.p168smime.SMIMECapabilities;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p133asn1.p174x509.Extension;

/* loaded from: classes2.dex */
public class CertEtcToken extends ASN1Object implements ASN1Choice {
    public static final int TAG_ASSERTION = 3;
    public static final int TAG_CAPABILITIES = 8;
    public static final int TAG_CERTIFICATE = 0;

    /* renamed from: TAG_CRL */
    public static final int f18297TAG_CRL = 4;
    public static final int TAG_ESSCERTID = 1;
    public static final int TAG_OCSPCERTID = 6;
    public static final int TAG_OCSPCERTSTATUS = 5;
    public static final int TAG_OCSPRESPONSE = 7;
    public static final int TAG_PKISTATUS = 2;
    private static final boolean[] explicit = {false, true, false, true, false, true, false, false, true};
    private Extension extension;

    /* renamed from: tagNo */
    private int f18298tagNo;

    /* renamed from: value */
    private ASN1Encodable f18299value;

    public CertEtcToken(int i, ASN1Encodable aSN1Encodable) {
        this.f18298tagNo = i;
        this.f18299value = aSN1Encodable;
    }

    public static CertEtcToken[] arrayFromSequence(ASN1Sequence aSN1Sequence) {
        int iMo14450size = aSN1Sequence.mo14450size();
        CertEtcToken[] certEtcTokenArr = new CertEtcToken[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            certEtcTokenArr[i] = getInstance(aSN1Sequence.getObjectAt(i));
        }
        return certEtcTokenArr;
    }

    public static CertEtcToken getInstance(Object obj) {
        if (obj instanceof CertEtcToken) {
            return (CertEtcToken) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CertEtcToken(ASN1TaggedObject.getContextInstance(obj));
        }
        if (obj != null) {
            return new CertEtcToken(Extension.getInstance(obj));
        }
        return null;
    }

    public Extension getExtension() {
        return this.extension;
    }

    public int getTagNo() {
        return this.f18298tagNo;
    }

    public ASN1Encodable getValue() {
        return this.f18299value;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        Extension extension = this.extension;
        if (extension != null) {
            return extension.toASN1Primitive();
        }
        boolean[] zArr = explicit;
        int i = this.f18298tagNo;
        return new DERTaggedObject(zArr[i], i, this.f18299value);
    }

    public String toString() {
        return "CertEtcToken {\n" + this.f18299value + "}\n";
    }

    private CertEtcToken(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable certificate;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f18298tagNo = tagNo;
        switch (tagNo) {
            case 0:
                certificate = Certificate.getInstance(aSN1TaggedObject, false);
                break;
            case 1:
                certificate = ESSCertID.getInstance(aSN1TaggedObject.getExplicitBaseObject());
                break;
            case 2:
                certificate = PKIStatusInfo.getInstance(aSN1TaggedObject, false);
                break;
            case 3:
                certificate = ContentInfo.getInstance(aSN1TaggedObject.getExplicitBaseObject());
                break;
            case 4:
                certificate = CertificateList.getInstance(aSN1TaggedObject, false);
                break;
            case 5:
                certificate = CertStatus.getInstance(aSN1TaggedObject.getExplicitBaseObject());
                break;
            case 6:
                certificate = C5131CertID.getInstance(aSN1TaggedObject, false);
                break;
            case 7:
                certificate = OCSPResponse.getInstance(aSN1TaggedObject, false);
                break;
            case 8:
                certificate = SMIMECapabilities.getInstance(aSN1TaggedObject.getExplicitBaseObject());
                break;
            default:
                throw new IllegalArgumentException("Unknown tag: " + this.f18298tagNo);
        }
        this.f18299value = certificate;
    }

    public CertEtcToken(Extension extension) {
        this.f18298tagNo = -1;
        this.extension = extension;
    }
}
