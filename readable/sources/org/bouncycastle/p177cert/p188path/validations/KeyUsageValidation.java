package org.bouncycastle.p177cert.p188path.validations;

import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.KeyUsage;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p188path.CertPathValidation;
import org.bouncycastle.p177cert.p188path.CertPathValidationContext;
import org.bouncycastle.p177cert.p188path.CertPathValidationException;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class KeyUsageValidation implements CertPathValidation {
    private boolean isMandatory;

    public KeyUsageValidation() {
        this(true);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new KeyUsageValidation(this.isMandatory);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        this.isMandatory = ((KeyUsageValidation) memoable).isMandatory;
    }

    @Override // org.bouncycastle.p177cert.p188path.CertPathValidation
    public void validate(CertPathValidationContext certPathValidationContext, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        certPathValidationContext.addHandledExtension(Extension.keyUsage);
        if (certPathValidationContext.isEndEntity()) {
            return;
        }
        KeyUsage keyUsageFromExtensions = KeyUsage.fromExtensions(x509CertificateHolder.getExtensions());
        if (keyUsageFromExtensions != null) {
            if (!keyUsageFromExtensions.hasUsages(4)) {
                throw new CertPathValidationException("Issuer certificate KeyUsage extension does not permit key signing");
            }
        } else if (this.isMandatory) {
            throw new CertPathValidationException("KeyUsage extension not present in CA certificate");
        }
    }

    public KeyUsageValidation(boolean z) {
        this.isMandatory = z;
    }
}
