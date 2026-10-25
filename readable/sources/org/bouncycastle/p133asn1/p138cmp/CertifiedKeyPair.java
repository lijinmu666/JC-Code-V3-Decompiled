package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p141crmf.EncryptedKey;
import org.bouncycastle.p133asn1.p141crmf.EncryptedValue;
import org.bouncycastle.p133asn1.p141crmf.PKIPublicationInfo;

/* loaded from: classes.dex */
public class CertifiedKeyPair extends ASN1Object {
    private final CertOrEncCert certOrEncCert;
    private EncryptedKey privateKey;
    private PKIPublicationInfo publicationInfo;

    private CertifiedKeyPair(ASN1Sequence aSN1Sequence) {
        ASN1Object explicitBaseObject;
        this.certOrEncCert = CertOrEncCert.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.mo14450size() >= 2) {
            if (aSN1Sequence.mo14450size() == 2) {
                ASN1TaggedObject contextInstance = ASN1TaggedObject.getContextInstance(aSN1Sequence.getObjectAt(1));
                int tagNo = contextInstance.getTagNo();
                explicitBaseObject = contextInstance.getExplicitBaseObject();
                if (tagNo == 0) {
                    this.privateKey = EncryptedKey.getInstance(explicitBaseObject);
                    return;
                }
            } else {
                this.privateKey = EncryptedKey.getInstance(ASN1TaggedObject.getContextInstance(aSN1Sequence.getObjectAt(1)).getExplicitBaseObject());
                explicitBaseObject = ASN1TaggedObject.getContextInstance(aSN1Sequence.getObjectAt(2)).getExplicitBaseObject();
            }
            this.publicationInfo = PKIPublicationInfo.getInstance(explicitBaseObject);
        }
    }

    public static CertifiedKeyPair getInstance(Object obj) {
        if (obj instanceof CertifiedKeyPair) {
            return (CertifiedKeyPair) obj;
        }
        if (obj != null) {
            return new CertifiedKeyPair(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertOrEncCert getCertOrEncCert() {
        return this.certOrEncCert;
    }

    public EncryptedKey getPrivateKey() {
        return this.privateKey;
    }

    public PKIPublicationInfo getPublicationInfo() {
        return this.publicationInfo;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(this.certOrEncCert);
        EncryptedKey encryptedKey = this.privateKey;
        if (encryptedKey != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 0, (ASN1Encodable) encryptedKey));
        }
        PKIPublicationInfo pKIPublicationInfo = this.publicationInfo;
        if (pKIPublicationInfo != null) {
            aSN1EncodableVector.m14420add(new DERTaggedObject(true, 1, (ASN1Encodable) pKIPublicationInfo));
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert) {
        this(certOrEncCert, (EncryptedKey) null, (PKIPublicationInfo) null);
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert, EncryptedKey encryptedKey, PKIPublicationInfo pKIPublicationInfo) {
        if (certOrEncCert == null) {
            throw new IllegalArgumentException("'certOrEncCert' cannot be null");
        }
        this.certOrEncCert = certOrEncCert;
        this.privateKey = encryptedKey;
        this.publicationInfo = pKIPublicationInfo;
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert, EncryptedValue encryptedValue, PKIPublicationInfo pKIPublicationInfo) {
        if (certOrEncCert == null) {
            throw new IllegalArgumentException("'certOrEncCert' cannot be null");
        }
        this.certOrEncCert = certOrEncCert;
        this.privateKey = encryptedValue != null ? new EncryptedKey(encryptedValue) : null;
        this.publicationInfo = pKIPublicationInfo;
    }
}
