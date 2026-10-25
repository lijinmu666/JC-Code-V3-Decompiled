package org.bouncycastle.p226est.p227jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.p172x500.AttributeTypeAndValue;
import org.bouncycastle.p133asn1.p172x500.C5188RDN;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.p173style.C5189BCStyle;
import org.bouncycastle.p226est.ESTException;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.IPAddress;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class JsseDefaultHostnameAuthorizer implements JsseHostnameAuthorizer {

    /* renamed from: LOG */
    private static Logger f21217LOG = Logger.getLogger(JsseDefaultHostnameAuthorizer.class.getName());
    private final Set<String> knownSuffixes;

    public JsseDefaultHostnameAuthorizer(Set<String> set) {
        this.knownSuffixes = set;
    }

    public static boolean isValidNameMatch(String str, String str2, Set<String> set) throws IOException {
        if (!str2.contains("*")) {
            return str.equalsIgnoreCase(str2);
        }
        int iIndexOf = str2.indexOf(42);
        if (iIndexOf != str2.lastIndexOf("*") || str2.contains("..") || str2.charAt(str2.length() - 1) == '*') {
            return false;
        }
        int iIndexOf2 = str2.indexOf(46, iIndexOf);
        if (set != null && set.contains(C6250Strings.toLowerCase(str2.substring(iIndexOf2)))) {
            throw new IOException("Wildcard `" + str2 + "` matches known public suffix.");
        }
        String lowerCase = C6250Strings.toLowerCase(str2.substring(iIndexOf + 1));
        String lowerCase2 = C6250Strings.toLowerCase(str);
        if (lowerCase2.equals(lowerCase) || lowerCase.length() > lowerCase2.length()) {
            return false;
        }
        if (iIndexOf > 0) {
            return lowerCase2.startsWith(str2.substring(0, iIndexOf)) && lowerCase2.endsWith(lowerCase) && lowerCase2.substring(iIndexOf, lowerCase2.length() - lowerCase.length()).indexOf(46) < 0;
        }
        if (lowerCase2.substring(0, lowerCase2.length() - lowerCase.length()).indexOf(46) > 0) {
            return false;
        }
        return lowerCase2.endsWith(lowerCase);
    }

    @Override // org.bouncycastle.p226est.p227jcajce.JsseHostnameAuthorizer
    public boolean verified(String str, SSLSession sSLSession) throws ESTException {
        try {
            return m15979verify(str, (X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(sSLSession.getPeerCertificates()[0].getEncoded())));
        } catch (Exception e) {
            if (e instanceof ESTException) {
                throw ((ESTException) e);
            }
            throw new ESTException(e.getMessage(), e);
        }
    }

    /* renamed from: verify */
    public boolean m15979verify(String str, X509Certificate x509Certificate) throws CertificateParsingException, ESTException, UnknownHostException {
        boolean z;
        X500Principal subjectX500Principal;
        if (str == null) {
            throw new NullPointerException("'name' cannot be null");
        }
        boolean zIsValidIPv4 = IPAddress.isValidIPv4(str);
        boolean z2 = !zIsValidIPv4 && IPAddress.isValidIPv6(str);
        boolean z3 = zIsValidIPv4 || z2;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames != null) {
                InetAddress byName = null;
                z = false;
                for (List<?> list : subjectAlternativeNames) {
                    int iIntValue = ((Integer) list.get(0)).intValue();
                    if (iIntValue == 2) {
                        if (!z3 && isValidNameMatch(str, (String) list.get(1), this.knownSuffixes)) {
                            return true;
                        }
                        z = true;
                    } else if (iIntValue != 7) {
                        Logger logger = f21217LOG;
                        Level level = Level.INFO;
                        if (logger.isLoggable(level)) {
                            String hexString = list.get(1) instanceof byte[] ? C6255Hex.toHexString((byte[]) list.get(1)) : list.get(1).toString();
                            f21217LOG.log(level, "ignoring type " + iIntValue + " value = " + hexString);
                        }
                    } else if (z3) {
                        String str2 = (String) list.get(1);
                        if (str.equalsIgnoreCase(str2)) {
                            return true;
                        }
                        if (z2 && IPAddress.isValidIPv6(str2)) {
                            if (byName == null) {
                                try {
                                    byName = InetAddress.getByName(str);
                                } catch (UnknownHostException unused) {
                                    continue;
                                }
                            }
                            if (byName.equals(InetAddress.getByName(str2))) {
                                return true;
                            }
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                z = false;
            }
            if (z3 || z || (subjectX500Principal = x509Certificate.getSubjectX500Principal()) == null) {
                return false;
            }
            C5188RDN[] c5188rdnArrM14665getRDNs = X500Name.getInstance(subjectX500Principal.getEncoded()).m14665getRDNs();
            for (int length = c5188rdnArrM14665getRDNs.length - 1; length >= 0; length--) {
                AttributeTypeAndValue[] typesAndValues = c5188rdnArrM14665getRDNs[length].getTypesAndValues();
                for (int i = 0; i != typesAndValues.length; i++) {
                    AttributeTypeAndValue attributeTypeAndValue = typesAndValues[i];
                    if (C5189BCStyle.f18591CN.m14446equals((ASN1Primitive) attributeTypeAndValue.m14663getType())) {
                        ASN1Encodable aSN1Primitive = attributeTypeAndValue.getValue().toASN1Primitive();
                        return (aSN1Primitive instanceof ASN1String) && isValidNameMatch(str, ((ASN1String) aSN1Primitive).getString(), this.knownSuffixes);
                    }
                }
            }
            return false;
        } catch (Exception e) {
            throw new ESTException(e.getMessage(), e);
        }
    }
}
