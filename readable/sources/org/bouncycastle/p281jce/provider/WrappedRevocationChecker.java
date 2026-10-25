package org.bouncycastle.p281jce.provider;

import java.security.cert.CertPathValidatorException;
import java.security.cert.Certificate;
import java.security.cert.PKIXCertPathChecker;
import org.bouncycastle.p249jcajce.PKIXCertRevocationChecker;
import org.bouncycastle.p249jcajce.PKIXCertRevocationCheckerParameters;

/* loaded from: classes2.dex */
class WrappedRevocationChecker implements PKIXCertRevocationChecker {

    /* renamed from: checker */
    private final PKIXCertPathChecker f22038checker;

    public WrappedRevocationChecker(PKIXCertPathChecker pKIXCertPathChecker) {
        this.f22038checker = pKIXCertPathChecker;
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    /* renamed from: check */
    public void mo16075check(Certificate certificate) throws CertPathValidatorException {
        this.f22038checker.check(certificate);
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    public void initialize(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters) throws CertPathValidatorException {
        this.f22038checker.init(false);
    }

    @Override // org.bouncycastle.p249jcajce.PKIXCertRevocationChecker
    public void setParameter(String str, Object obj) {
    }
}
