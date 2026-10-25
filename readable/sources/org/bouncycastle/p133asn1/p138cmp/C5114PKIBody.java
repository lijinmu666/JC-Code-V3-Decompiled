package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p141crmf.CertReqMessages;
import org.bouncycastle.p133asn1.p166pkcs.CertificationRequest;
import org.bouncycastle.p361util.Exceptions;

/* renamed from: org.bouncycastle.asn1.cmp.PKIBody */
/* loaded from: classes.dex */
public class C5114PKIBody extends ASN1Object implements ASN1Choice {
    public static final int TYPE_CA_KEY_UPDATE_ANN = 15;
    public static final int TYPE_CERT_ANN = 16;
    public static final int TYPE_CERT_CONFIRM = 24;
    public static final int TYPE_CERT_REP = 3;
    public static final int TYPE_CERT_REQ = 2;
    public static final int TYPE_CONFIRM = 19;
    public static final int TYPE_CRL_ANN = 18;
    public static final int TYPE_CROSS_CERT_REP = 14;
    public static final int TYPE_CROSS_CERT_REQ = 13;
    public static final int TYPE_ERROR = 23;
    public static final int TYPE_GEN_MSG = 21;
    public static final int TYPE_GEN_REP = 22;
    public static final int TYPE_INIT_REP = 1;
    public static final int TYPE_INIT_REQ = 0;
    public static final int TYPE_KEY_RECOVERY_REP = 10;
    public static final int TYPE_KEY_RECOVERY_REQ = 9;
    public static final int TYPE_KEY_UPDATE_REP = 8;
    public static final int TYPE_KEY_UPDATE_REQ = 7;
    public static final int TYPE_NESTED = 20;
    public static final int TYPE_P10_CERT_REQ = 4;
    public static final int TYPE_POLL_REP = 26;
    public static final int TYPE_POLL_REQ = 25;
    public static final int TYPE_POPO_CHALL = 5;
    public static final int TYPE_POPO_REP = 6;
    public static final int TYPE_REVOCATION_ANN = 17;
    public static final int TYPE_REVOCATION_REP = 12;
    public static final int TYPE_REVOCATION_REQ = 11;

    /* renamed from: body */
    private final ASN1Encodable f18130body;

    /* renamed from: tagNo */
    private final int f18131tagNo;

    public C5114PKIBody(int i, ASN1Encodable aSN1Encodable) {
        this.f18131tagNo = i;
        this.f18130body = getBodyForType(i, aSN1Encodable);
    }

    private static ASN1Encodable getBodyForType(int i, ASN1Encodable aSN1Encodable) {
        try {
            switch (i) {
                case 0:
                    return CertReqMessages.getInstance(aSN1Encodable);
                case 1:
                    return CertRepMessage.getInstance(aSN1Encodable);
                case 2:
                    return CertReqMessages.getInstance(aSN1Encodable);
                case 3:
                    return CertRepMessage.getInstance(aSN1Encodable);
                case 4:
                    return CertificationRequest.getInstance(aSN1Encodable);
                case 5:
                    return POPODecKeyChallContent.getInstance(aSN1Encodable);
                case 6:
                    return POPODecKeyRespContent.getInstance(aSN1Encodable);
                case 7:
                    return CertReqMessages.getInstance(aSN1Encodable);
                case 8:
                    return CertRepMessage.getInstance(aSN1Encodable);
                case 9:
                    return CertReqMessages.getInstance(aSN1Encodable);
                case 10:
                    return KeyRecRepContent.getInstance(aSN1Encodable);
                case 11:
                    return RevReqContent.getInstance(aSN1Encodable);
                case 12:
                    return RevRepContent.getInstance(aSN1Encodable);
                case 13:
                    return CertReqMessages.getInstance(aSN1Encodable);
                case 14:
                    return CertRepMessage.getInstance(aSN1Encodable);
                case 15:
                    return CAKeyUpdAnnContent.getInstance(aSN1Encodable);
                case 16:
                    return CMPCertificate.getInstance(aSN1Encodable);
                case 17:
                    return RevAnnContent.getInstance(aSN1Encodable);
                case 18:
                    return CRLAnnContent.getInstance(aSN1Encodable);
                case 19:
                    return PKIConfirmContent.getInstance(aSN1Encodable);
                case 20:
                    return PKIMessages.getInstance(aSN1Encodable);
                case 21:
                    return GenMsgContent.getInstance(aSN1Encodable);
                case 22:
                    return GenRepContent.getInstance(aSN1Encodable);
                case 23:
                    return ErrorMsgContent.getInstance(aSN1Encodable);
                case 24:
                    return CertConfirmContent.getInstance(aSN1Encodable);
                case 25:
                    return PollReqContent.getInstance(aSN1Encodable);
                case 26:
                    return PollRepContent.getInstance(aSN1Encodable);
                default:
                    throw new IllegalArgumentException("unknown tag number: " + i);
            }
        } catch (ClassCastException unused) {
            throw new IllegalArgumentException("body type of " + i + " has incorrect type got: " + aSN1Encodable.getClass());
        } catch (IllegalArgumentException unused2) {
            throw new IllegalArgumentException("body type of " + i + " has incorrect type got: " + aSN1Encodable.getClass());
        }
    }

    public static C5114PKIBody getInstance(Object obj) {
        if (obj == null || (obj instanceof C5114PKIBody)) {
            return (C5114PKIBody) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new C5114PKIBody((ASN1TaggedObject) obj);
        }
        throw new IllegalArgumentException("Invalid object: " + obj.getClass().getName());
    }

    public ASN1Encodable getContent() {
        return this.f18130body;
    }

    /* renamed from: getType */
    public int m14517getType() {
        return this.f18131tagNo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(true, this.f18131tagNo, this.f18130body);
    }

    private C5114PKIBody(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo = aSN1TaggedObject.getTagNo();
        this.f18131tagNo = tagNo;
        try {
            this.f18130body = getBodyForType(tagNo, aSN1TaggedObject.getExplicitBaseObject());
        } catch (ClassCastException e) {
            throw Exceptions.illegalArgumentException("malformed body found: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw Exceptions.illegalArgumentException("malformed body found: " + e2.getMessage(), e2);
        }
    }
}
