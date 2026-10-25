package org.bouncycastle.p177cert.p185jcajce;

import java.security.cert.X509Certificate;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.X500NameStyle;
import org.bouncycastle.p249jcajce.interfaces.BCX509Certificate;

/* loaded from: classes2.dex */
public class JcaX500NameUtil {
    private static byte[] getEncoded(X500Principal x500Principal) {
        return m14811notNull(x500Principal).getEncoded();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static X500Name getIssuer(X509Certificate x509Certificate) {
        return x509Certificate instanceof BCX509Certificate ? m14812notNull(((BCX509Certificate) x509Certificate).getIssuerX500Name()) : getX500Name(x509Certificate.getIssuerX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static X500Name getSubject(X509Certificate x509Certificate) {
        return x509Certificate instanceof BCX509Certificate ? m14812notNull(((BCX509Certificate) x509Certificate).getSubjectX500Name()) : getX500Name(x509Certificate.getSubjectX500Principal());
    }

    public static X500Name getX500Name(X500Principal x500Principal) {
        return X500Name.getInstance(getEncoded(x500Principal));
    }

    /* renamed from: notNull */
    private static X500Principal m14811notNull(X500Principal x500Principal) {
        if (x500Principal != null) {
            return x500Principal;
        }
        throw new IllegalStateException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static X500Name getIssuer(X500NameStyle x500NameStyle, X509Certificate x509Certificate) {
        return x509Certificate instanceof BCX509Certificate ? X500Name.getInstance(x500NameStyle, m14812notNull(((BCX509Certificate) x509Certificate).getIssuerX500Name())) : getX500Name(x500NameStyle, x509Certificate.getIssuerX500Principal());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static X500Name getSubject(X500NameStyle x500NameStyle, X509Certificate x509Certificate) {
        return x509Certificate instanceof BCX509Certificate ? X500Name.getInstance(x500NameStyle, m14812notNull(((BCX509Certificate) x509Certificate).getSubjectX500Name())) : getX500Name(x500NameStyle, x509Certificate.getSubjectX500Principal());
    }

    public static X500Name getX500Name(X500NameStyle x500NameStyle, X500Principal x500Principal) {
        return X500Name.getInstance(x500NameStyle, getEncoded(x500Principal));
    }

    /* renamed from: notNull */
    private static X500Name m14812notNull(X500Name x500Name) {
        if (x500Name != null) {
            return x500Name;
        }
        throw new IllegalStateException();
    }
}
