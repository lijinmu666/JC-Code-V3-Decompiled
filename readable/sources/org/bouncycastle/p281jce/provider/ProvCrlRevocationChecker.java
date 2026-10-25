package org.bouncycastle.p281jce.provider;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.p249jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.p249jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;

/* loaded from: classes2.dex */
class ProvCrlRevocationChecker implements PKIXCertRevocationChecker {
    private Date currentDate = null;

    /* renamed from: helper */
    private final JcaJceHelper f22030helper;

    /* renamed from: params */
    private PKIXCertRevocationCheckerParameters f22031params;

    public ProvCrlRevocationChecker(JcaJceHelper jcaJceHelper) {
        this.f22030helper = jcaJceHelper;
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    /* renamed from: check */
    public void mo16075check(Certificate certificate) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertPathValidatorException, CRLException, NoSuchProviderException {
        try {
            PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters = this.f22031params;
            RFC3280CertPathUtilities.checkCRLs(pKIXCertRevocationCheckerParameters, pKIXCertRevocationCheckerParameters.getParamsPKIX(), this.currentDate, this.f22031params.getValidDate(), (X509Certificate) certificate, this.f22031params.getSigningCert(), this.f22031params.getWorkingPublicKey(), this.f22031params.getCertPath().getCertificates(), this.f22030helper);
        } catch (AnnotatedException e) {
            throw new CertPathValidatorException(e.getMessage(), e.getCause() != null ? e.getCause() : e, this.f22031params.getCertPath(), this.f22031params.getIndex());
        }
    }

    /* renamed from: init */
    public void m16261init(boolean z) throws CertPathValidatorException {
        if (z) {
            throw new CertPathValidatorException("forward checking not supported");
        }
        this.f22031params = null;
        this.currentDate = new Date();
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    public void initialize(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters) {
        this.f22031params = pKIXCertRevocationCheckerParameters;
        this.currentDate = new Date();
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    public void setParameter(String str, Object obj) {
    }
}
