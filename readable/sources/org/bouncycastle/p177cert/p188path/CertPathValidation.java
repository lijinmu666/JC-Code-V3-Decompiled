package org.bouncycastle.p177cert.p188path;

import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public interface CertPathValidation extends Memoable {
    void validate(CertPathValidationContext certPathValidationContext, X509CertificateHolder x509CertificateHolder);
}
