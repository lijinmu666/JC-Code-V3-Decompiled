package org.bouncycastle.p281jce.provider;

import java.security.cert.TrustAnchor;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.X500NameStyle;
import org.bouncycastle.p249jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.p366x509.X509AttributeCertificate;

/* loaded from: classes2.dex */
class PrincipalUtils {
    /* renamed from: getCA */
    public static X500Name m16253getCA(TrustAnchor trustAnchor) {
        return getX500Name(m16254notNull(trustAnchor).getCA());
    }

    private static byte[] getEncoded(X500Principal x500Principal) {
        return m16260notNull(m16257notNull(x500Principal).getEncoded());
    }

    public static X500Name getEncodedIssuerPrincipal(Object obj) {
        return obj instanceof X509Certificate ? getIssuerPrincipal((X509Certificate) obj) : getIssuerPrincipal((X509AttributeCertificate) obj);
    }

    public static X500Name getIssuerPrincipal(X509CRL x509crl) {
        return getX500Name(m16255notNull(x509crl).getIssuerX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static X500Name getSubjectPrincipal(X509Certificate x509Certificate) {
        return x509Certificate instanceof BCX509Certificate ? m16258notNull(((BCX509Certificate) x509Certificate).getSubjectX500Name()) : getX500Name(m16256notNull(x509Certificate).getSubjectX500Principal());
    }

    public static X500Name getX500Name(X500Principal x500Principal) {
        return m16258notNull(X500Name.getInstance(getEncoded(x500Principal)));
    }

    /* renamed from: notNull */
    private static TrustAnchor m16254notNull(TrustAnchor trustAnchor) {
        if (trustAnchor != null) {
            return trustAnchor;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static X500Name getIssuerPrincipal(X509Certificate x509Certificate) {
        return x509Certificate instanceof BCX509Certificate ? m16258notNull(((BCX509Certificate) x509Certificate).getIssuerX500Name()) : getX500Name(m16256notNull(x509Certificate).getIssuerX500Principal());
    }

    public static X500Name getX500Name(X500NameStyle x500NameStyle, X500Principal x500Principal) {
        return m16258notNull(X500Name.getInstance(x500NameStyle, getEncoded(x500Principal)));
    }

    /* renamed from: notNull */
    private static X509CRL m16255notNull(X509CRL x509crl) {
        if (x509crl != null) {
            return x509crl;
        }
        throw new IllegalStateException();
    }

    public static X500Name getIssuerPrincipal(X509AttributeCertificate x509AttributeCertificate) {
        return getX500Name((X500Principal) m16259notNull(x509AttributeCertificate).getIssuer().getPrincipals()[0]);
    }

    /* renamed from: notNull */
    private static X509Certificate m16256notNull(X509Certificate x509Certificate) {
        if (x509Certificate != null) {
            return x509Certificate;
        }
        throw new IllegalStateException();
    }

    /* renamed from: notNull */
    private static X500Principal m16257notNull(X500Principal x500Principal) {
        if (x500Principal != null) {
            return x500Principal;
        }
        throw new IllegalStateException();
    }

    /* renamed from: notNull */
    private static X500Name m16258notNull(X500Name x500Name) {
        if (x500Name != null) {
            return x500Name;
        }
        throw new IllegalStateException();
    }

    /* renamed from: notNull */
    private static X509AttributeCertificate m16259notNull(X509AttributeCertificate x509AttributeCertificate) {
        if (x509AttributeCertificate != null) {
            return x509AttributeCertificate;
        }
        throw new IllegalStateException();
    }

    /* renamed from: notNull */
    private static byte[] m16260notNull(byte[] bArr) {
        if (bArr != null) {
            return bArr;
        }
        throw new IllegalStateException();
    }
}
