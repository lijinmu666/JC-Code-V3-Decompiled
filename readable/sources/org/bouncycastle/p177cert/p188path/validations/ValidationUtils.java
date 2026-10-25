package org.bouncycastle.p177cert.p188path.validations;

import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
class ValidationUtils {
    public static boolean isSelfIssued(X509CertificateHolder x509CertificateHolder) {
        return x509CertificateHolder.getSubject().mo14431equals(x509CertificateHolder.getIssuer());
    }
}
