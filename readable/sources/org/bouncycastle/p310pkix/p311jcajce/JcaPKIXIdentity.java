package org.bouncycastle.p310pkix.p311jcajce;

import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;
import org.bouncycastle.p310pkix.PKIXIdentity;

/* loaded from: classes2.dex */
public class JcaPKIXIdentity extends PKIXIdentity {

    /* renamed from: certs */
    private final X509Certificate[] f22981certs;

    /* renamed from: privKey */
    private final PrivateKey f22982privKey;

    public JcaPKIXIdentity(PrivateKey privateKey, X509Certificate x509Certificate) {
        this(privateKey, new X509Certificate[]{x509Certificate});
    }

    private static X509CertificateHolder[] getCertificates(X509Certificate[] x509CertificateArr) {
        int length = x509CertificateArr.length;
        X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[length];
        for (int i = 0; i != length; i++) {
            try {
                x509CertificateHolderArr[i] = new JcaX509CertificateHolder(x509CertificateArr[i]);
            } catch (CertificateEncodingException e) {
                throw new IllegalArgumentException("Unable to process certificates: " + e.getMessage());
            }
        }
        return x509CertificateHolderArr;
    }

    private static PrivateKeyInfo getPrivateKeyInfo(PrivateKey privateKey) {
        try {
            return PrivateKeyInfo.getInstance(privateKey.getEncoded());
        } catch (Exception unused) {
            return null;
        }
    }

    public PrivateKey getPrivateKey() {
        return this.f22982privKey;
    }

    public X509Certificate getX509Certificate() {
        return this.f22981certs[0];
    }

    public X509Certificate[] getX509CertificateChain() {
        X509Certificate[] x509CertificateArr = this.f22981certs;
        int length = x509CertificateArr.length;
        X509Certificate[] x509CertificateArr2 = new X509Certificate[length];
        System.arraycopy(x509CertificateArr, 0, x509CertificateArr2, 0, length);
        return x509CertificateArr2;
    }

    public JcaPKIXIdentity(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
        super(getPrivateKeyInfo(privateKey), getCertificates(x509CertificateArr));
        this.f22982privKey = privateKey;
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        this.f22981certs = x509CertificateArr2;
        System.arraycopy(x509CertificateArr, 0, x509CertificateArr2, 0, x509CertificateArr.length);
    }
}
