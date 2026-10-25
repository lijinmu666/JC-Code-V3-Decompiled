package org.bouncycastle.p249jcajce;

import java.security.cert.Certificate;

/* loaded from: classes2.dex */
public interface PKIXCertRevocationChecker {
    /* renamed from: check */
    void mo16075check(Certificate certificate);

    void initialize(PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters);

    void setParameter(String str, Object obj);
}
