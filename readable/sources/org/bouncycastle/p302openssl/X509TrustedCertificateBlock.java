package org.bouncycastle.p302openssl;

import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class X509TrustedCertificateBlock {
    private final X509CertificateHolder certificateHolder;
    private final CertificateTrustBlock trustBlock;

    public X509TrustedCertificateBlock(X509CertificateHolder x509CertificateHolder, CertificateTrustBlock certificateTrustBlock) {
        this.certificateHolder = x509CertificateHolder;
        this.trustBlock = certificateTrustBlock;
    }

    public X509CertificateHolder getCertificateHolder() {
        return this.certificateHolder;
    }

    public byte[] getEncoded() {
        return C6238Arrays.concatenate(this.certificateHolder.getEncoded(), this.trustBlock.toASN1Sequence().getEncoded());
    }

    public CertificateTrustBlock getTrustBlock() {
        return this.trustBlock;
    }

    public X509TrustedCertificateBlock(byte[] bArr) {
        ASN1InputStream aSN1InputStream = new ASN1InputStream(bArr);
        this.certificateHolder = new X509CertificateHolder(aSN1InputStream.readObject().getEncoded());
        ASN1Primitive object = aSN1InputStream.readObject();
        if (object != null) {
            this.trustBlock = new CertificateTrustBlock(object.getEncoded());
        } else {
            this.trustBlock = null;
        }
    }
}
