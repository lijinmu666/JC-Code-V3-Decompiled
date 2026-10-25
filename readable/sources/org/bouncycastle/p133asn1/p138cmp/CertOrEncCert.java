package org.bouncycastle.p133asn1.p138cmp;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.ASN1Util;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.p141crmf.EncryptedKey;
import org.bouncycastle.p133asn1.p141crmf.EncryptedValue;

/* loaded from: classes.dex */
public class CertOrEncCert extends ASN1Object implements ASN1Choice {
    private CMPCertificate certificate;
    private EncryptedKey encryptedCert;

    private CertOrEncCert(ASN1TaggedObject aSN1TaggedObject) {
        if (aSN1TaggedObject.hasContextTag(0)) {
            this.certificate = CMPCertificate.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else {
            if (aSN1TaggedObject.hasContextTag(1)) {
                this.encryptedCert = EncryptedKey.getInstance(aSN1TaggedObject.getExplicitBaseObject());
                return;
            }
            throw new IllegalArgumentException("unknown tag: " + ASN1Util.getTagText(aSN1TaggedObject));
        }
    }

    public static CertOrEncCert getInstance(Object obj) {
        if (obj instanceof CertOrEncCert) {
            return (CertOrEncCert) obj;
        }
        if (obj instanceof ASN1TaggedObject) {
            return new CertOrEncCert(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public CMPCertificate getCertificate() {
        return this.certificate;
    }

    public EncryptedKey getEncryptedCert() {
        return this.encryptedCert;
    }

    public boolean hasEncryptedCertificate() {
        return this.encryptedCert != null;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        CMPCertificate cMPCertificate = this.certificate;
        return cMPCertificate != null ? new DERTaggedObject(true, 0, (ASN1Encodable) cMPCertificate) : new DERTaggedObject(true, 1, (ASN1Encodable) this.encryptedCert);
    }

    public CertOrEncCert(CMPCertificate cMPCertificate) {
        if (cMPCertificate == null) {
            throw new IllegalArgumentException("'certificate' cannot be null");
        }
        this.certificate = cMPCertificate;
    }

    public CertOrEncCert(EncryptedKey encryptedKey) {
        if (encryptedKey == null) {
            throw new IllegalArgumentException("'encryptedCert' cannot be null");
        }
        this.encryptedCert = encryptedKey;
    }

    public CertOrEncCert(EncryptedValue encryptedValue) {
        if (encryptedValue == null) {
            throw new IllegalArgumentException("'encryptedCert' cannot be null");
        }
        this.encryptedCert = new EncryptedKey(encryptedValue);
    }
}
