package org.bouncycastle.p310pkix;

import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.SubjectKeyIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.KeyTransRecipientId;
import org.bouncycastle.p191cms.RecipientId;

/* loaded from: classes2.dex */
public class PKIXIdentity {
    private final X509CertificateHolder[] certificateHolders;
    private final PrivateKeyInfo privateKeyInfo;

    public PKIXIdentity(PrivateKeyInfo privateKeyInfo, X509CertificateHolder x509CertificateHolder) {
        this(privateKeyInfo, new X509CertificateHolder[]{x509CertificateHolder});
    }

    private byte[] getSubjectKeyIdentifier() {
        SubjectKeyIdentifier subjectKeyIdentifierFromExtensions = SubjectKeyIdentifier.fromExtensions(this.certificateHolders[0].getExtensions());
        if (subjectKeyIdentifierFromExtensions == null) {
            return null;
        }
        return subjectKeyIdentifierFromExtensions.getKeyIdentifier();
    }

    public X509CertificateHolder getCertificate() {
        return this.certificateHolders[0];
    }

    public X509CertificateHolder[] getCertificateChain() {
        X509CertificateHolder[] x509CertificateHolderArr = this.certificateHolders;
        int length = x509CertificateHolderArr.length;
        X509CertificateHolder[] x509CertificateHolderArr2 = new X509CertificateHolder[length];
        System.arraycopy(x509CertificateHolderArr, 0, x509CertificateHolderArr2, 0, length);
        return x509CertificateHolderArr2;
    }

    public PrivateKeyInfo getPrivateKeyInfo() {
        return this.privateKeyInfo;
    }

    public RecipientId getRecipientId() {
        return new KeyTransRecipientId(this.certificateHolders[0].getIssuer(), this.certificateHolders[0].getSerialNumber(), getSubjectKeyIdentifier());
    }

    public PKIXIdentity(PrivateKeyInfo privateKeyInfo, X509CertificateHolder[] x509CertificateHolderArr) {
        this.privateKeyInfo = privateKeyInfo;
        X509CertificateHolder[] x509CertificateHolderArr2 = new X509CertificateHolder[x509CertificateHolderArr.length];
        this.certificateHolders = x509CertificateHolderArr2;
        System.arraycopy(x509CertificateHolderArr, 0, x509CertificateHolderArr2, 0, x509CertificateHolderArr.length);
    }
}
