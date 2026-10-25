package org.bouncycastle.p310pkix.p311jcajce;

import java.security.cert.CertPathValidatorException;

/* loaded from: classes2.dex */
class CRLNotFoundException extends CertPathValidatorException {
    public CRLNotFoundException(String str) {
        super(str);
    }

    public CRLNotFoundException(String str, Throwable th) {
        super(str, th);
    }
}
