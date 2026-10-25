package org.bouncycastle.p177cert.p188path.validations;

import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.p174x509.BasicConstraints;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p188path.CertPathValidation;
import org.bouncycastle.p177cert.p188path.CertPathValidationContext;
import org.bouncycastle.p177cert.p188path.CertPathValidationException;
import org.bouncycastle.p361util.Integers;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class BasicConstraintsValidation implements CertPathValidation {
    private boolean isMandatory;
    private Integer maxPathLength;
    private boolean previousCertWasCA;

    public BasicConstraintsValidation() {
        this(true);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        BasicConstraintsValidation basicConstraintsValidation = new BasicConstraintsValidation();
        basicConstraintsValidation.isMandatory = this.isMandatory;
        basicConstraintsValidation.previousCertWasCA = this.previousCertWasCA;
        basicConstraintsValidation.maxPathLength = this.maxPathLength;
        return basicConstraintsValidation;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        BasicConstraintsValidation basicConstraintsValidation = (BasicConstraintsValidation) memoable;
        this.isMandatory = basicConstraintsValidation.isMandatory;
        this.previousCertWasCA = basicConstraintsValidation.previousCertWasCA;
        this.maxPathLength = basicConstraintsValidation.maxPathLength;
    }

    @Override // org.bouncycastle.p177cert.p188path.CertPathValidation
    public void validate(CertPathValidationContext certPathValidationContext, X509CertificateHolder x509CertificateHolder) throws CertPathValidationException {
        ASN1Integer pathLenConstraintInteger;
        certPathValidationContext.addHandledExtension(Extension.basicConstraints);
        if (!this.previousCertWasCA) {
            throw new CertPathValidationException("Basic constraints violated: issuer is not a CA");
        }
        BasicConstraints basicConstraintsFromExtensions = BasicConstraints.fromExtensions(x509CertificateHolder.getExtensions());
        this.previousCertWasCA = (basicConstraintsFromExtensions != null && basicConstraintsFromExtensions.m14675isCA()) || (basicConstraintsFromExtensions == null && !this.isMandatory);
        if (this.maxPathLength != null && !x509CertificateHolder.getSubject().mo14431equals(x509CertificateHolder.getIssuer())) {
            if (this.maxPathLength.intValue() < 0) {
                throw new CertPathValidationException("Basic constraints violated: path length exceeded");
            }
            this.maxPathLength = Integers.m18296valueOf(this.maxPathLength.intValue() - 1);
        }
        if (basicConstraintsFromExtensions == null || !basicConstraintsFromExtensions.m14675isCA() || (pathLenConstraintInteger = basicConstraintsFromExtensions.getPathLenConstraintInteger()) == null) {
            return;
        }
        int iIntPositiveValueExact = pathLenConstraintInteger.intPositiveValueExact();
        Integer num = this.maxPathLength;
        if (num == null || iIntPositiveValueExact < num.intValue()) {
            this.maxPathLength = Integers.m18296valueOf(iIntPositiveValueExact);
        }
    }

    public BasicConstraintsValidation(boolean z) {
        this.previousCertWasCA = true;
        this.maxPathLength = null;
        this.isMandatory = z;
    }
}
