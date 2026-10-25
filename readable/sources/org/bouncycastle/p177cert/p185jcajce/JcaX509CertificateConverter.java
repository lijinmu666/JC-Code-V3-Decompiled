package org.bouncycastle.p177cert.p185jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CertificateException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class JcaX509CertificateConverter {

    /* renamed from: helper */
    private CertHelper f18877helper;

    public static class ExCertificateException extends CertificateException {

        /* renamed from: cause */
        private Throwable f18878cause;

        public ExCertificateException(String str, Throwable th) {
            super(str);
            this.f18878cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f18878cause;
        }
    }

    public static class ExCertificateParsingException extends CertificateParsingException {

        /* renamed from: cause */
        private Throwable f18879cause;

        public ExCertificateParsingException(String str, Throwable th) {
            super(str);
            this.f18879cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f18879cause;
        }
    }

    public JcaX509CertificateConverter() {
        this.f18877helper = new DefaultCertHelper();
        this.f18877helper = new DefaultCertHelper();
    }

    public X509Certificate getCertificate(X509CertificateHolder x509CertificateHolder) throws ExCertificateParsingException, ExCertificateException {
        try {
            return (X509Certificate) this.f18877helper.getCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(x509CertificateHolder.getEncoded()));
        } catch (IOException e) {
            throw new ExCertificateParsingException("exception parsing certificate: " + e.getMessage(), e);
        } catch (NoSuchProviderException e2) {
            throw new ExCertificateException("cannot find required provider:" + e2.getMessage(), e2);
        }
    }

    public JcaX509CertificateConverter setProvider(String str) {
        this.f18877helper = new NamedCertHelper(str);
        return this;
    }

    public JcaX509CertificateConverter setProvider(Provider provider) {
        this.f18877helper = new ProviderCertHelper(provider);
        return this;
    }
}
