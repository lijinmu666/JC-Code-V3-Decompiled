package org.bouncycastle.p177cert.p185jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.cert.CRLException;
import java.security.cert.CertificateException;
import java.security.cert.X509CRL;
import org.bouncycastle.p177cert.X509CRLHolder;

/* loaded from: classes2.dex */
public class JcaX509CRLConverter {

    /* renamed from: helper */
    private CertHelper f18875helper;

    public static class ExCRLException extends CRLException {

        /* renamed from: cause */
        private Throwable f18876cause;

        public ExCRLException(String str, Throwable th) {
            super(str);
            this.f18876cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f18876cause;
        }
    }

    public JcaX509CRLConverter() {
        this.f18875helper = new DefaultCertHelper();
        this.f18875helper = new DefaultCertHelper();
    }

    /* renamed from: getCRL */
    public X509CRL m14813getCRL(X509CRLHolder x509CRLHolder) throws ExCRLException {
        try {
            return (X509CRL) this.f18875helper.getCertificateFactory("X.509").generateCRL(new ByteArrayInputStream(x509CRLHolder.getEncoded()));
        } catch (IOException e) {
            throw new ExCRLException("exception parsing certificate: " + e.getMessage(), e);
        } catch (NoSuchProviderException e2) {
            throw new ExCRLException("cannot find required provider:" + e2.getMessage(), e2);
        } catch (CertificateException e3) {
            throw new ExCRLException("cannot create factory: " + e3.getMessage(), e3);
        }
    }

    public JcaX509CRLConverter setProvider(String str) {
        this.f18875helper = new NamedCertHelper(str);
        return this;
    }

    public JcaX509CRLConverter setProvider(Provider provider) {
        this.f18875helper = new ProviderCertHelper(provider);
        return this;
    }
}
