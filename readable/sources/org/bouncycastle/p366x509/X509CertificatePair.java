package org.bouncycastle.p366x509;

import java.io.IOException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.CertificatePair;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p281jce.provider.X509CertificateObject;

/* loaded from: classes2.dex */
public class X509CertificatePair {
    private final JcaJceHelper bcHelper = new BCJcaJceHelper();

    /* renamed from: forward */
    private X509Certificate f24288forward;

    /* renamed from: reverse */
    private X509Certificate f24289reverse;

    public X509CertificatePair(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        this.f24288forward = x509Certificate;
        this.f24289reverse = x509Certificate2;
    }

    /* renamed from: equals */
    public boolean m18394equals(Object obj) {
        if (obj == null || !(obj instanceof X509CertificatePair)) {
            return false;
        }
        X509CertificatePair x509CertificatePair = (X509CertificatePair) obj;
        X509Certificate x509Certificate = this.f24288forward;
        boolean zEquals = x509Certificate != null ? x509Certificate.equals(x509CertificatePair.f24288forward) : x509CertificatePair.f24288forward == null;
        X509Certificate x509Certificate2 = this.f24289reverse;
        return zEquals && (x509Certificate2 != null ? x509Certificate2.equals(x509CertificatePair.f24289reverse) : x509CertificatePair.f24289reverse == null);
    }

    public byte[] getEncoded() throws CertificateEncodingException {
        Certificate certificate;
        try {
            Certificate certificate2 = null;
            if (this.f24288forward != null) {
                certificate = Certificate.getInstance(new ASN1InputStream(this.f24288forward.getEncoded()).readObject());
                if (certificate == null) {
                    throw new CertificateEncodingException("unable to get encoding for forward");
                }
            } else {
                certificate = null;
            }
            if (this.f24289reverse != null && (certificate2 = Certificate.getInstance(new ASN1InputStream(this.f24289reverse.getEncoded()).readObject())) == null) {
                throw new CertificateEncodingException("unable to get encoding for reverse");
            }
            return new CertificatePair(certificate, certificate2).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e) {
            throw new ExtCertificateEncodingException(e.toString(), e);
        } catch (IllegalArgumentException e2) {
            throw new ExtCertificateEncodingException(e2.toString(), e2);
        }
    }

    public X509Certificate getForward() {
        return this.f24288forward;
    }

    public X509Certificate getReverse() {
        return this.f24289reverse;
    }

    public int hashCode() {
        X509Certificate x509Certificate = this.f24288forward;
        int iHashCode = x509Certificate != null ? (-1) ^ x509Certificate.hashCode() : -1;
        X509Certificate x509Certificate2 = this.f24289reverse;
        return x509Certificate2 != null ? (iHashCode * 17) ^ x509Certificate2.hashCode() : iHashCode;
    }

    public X509CertificatePair(CertificatePair certificatePair) {
        if (certificatePair.getForward() != null) {
            this.f24288forward = new X509CertificateObject(certificatePair.getForward());
        }
        if (certificatePair.getReverse() != null) {
            this.f24289reverse = new X509CertificateObject(certificatePair.getReverse());
        }
    }
}
