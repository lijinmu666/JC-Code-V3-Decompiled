package org.bouncycastle.p177cert.p188path.validations;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.PolicyConstraints;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p188path.CertPathValidation;
import org.bouncycastle.p177cert.p188path.CertPathValidationContext;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class CertificatePoliciesValidation implements CertPathValidation {
    private int explicitPolicy;
    private int inhibitAnyPolicy;
    private int policyMapping;

    public CertificatePoliciesValidation(int i) {
        this(i, false, false, false);
    }

    private int countDown(int i) {
        if (i != 0) {
            return i - 1;
        }
        return 0;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        CertificatePoliciesValidation certificatePoliciesValidation = new CertificatePoliciesValidation(0);
        certificatePoliciesValidation.explicitPolicy = this.explicitPolicy;
        certificatePoliciesValidation.policyMapping = this.policyMapping;
        certificatePoliciesValidation.inhibitAnyPolicy = this.inhibitAnyPolicy;
        return certificatePoliciesValidation;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        CertificatePoliciesValidation certificatePoliciesValidation = (CertificatePoliciesValidation) memoable;
        this.explicitPolicy = certificatePoliciesValidation.explicitPolicy;
        this.policyMapping = certificatePoliciesValidation.policyMapping;
        this.inhibitAnyPolicy = certificatePoliciesValidation.inhibitAnyPolicy;
    }

    @Override // org.bouncycastle.p177cert.p188path.CertPathValidation
    public void validate(CertPathValidationContext certPathValidationContext, X509CertificateHolder x509CertificateHolder) {
        int iIntValueExact;
        certPathValidationContext.addHandledExtension(Extension.policyConstraints);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = Extension.inhibitAnyPolicy;
        certPathValidationContext.addHandledExtension(aSN1ObjectIdentifier);
        if (certPathValidationContext.isEndEntity() || ValidationUtils.isSelfIssued(x509CertificateHolder)) {
            return;
        }
        this.explicitPolicy = countDown(this.explicitPolicy);
        this.policyMapping = countDown(this.policyMapping);
        this.inhibitAnyPolicy = countDown(this.inhibitAnyPolicy);
        PolicyConstraints policyConstraintsFromExtensions = PolicyConstraints.fromExtensions(x509CertificateHolder.getExtensions());
        if (policyConstraintsFromExtensions != null) {
            BigInteger requireExplicitPolicyMapping = policyConstraintsFromExtensions.getRequireExplicitPolicyMapping();
            if (requireExplicitPolicyMapping != null && requireExplicitPolicyMapping.intValue() < this.explicitPolicy) {
                this.explicitPolicy = requireExplicitPolicyMapping.intValue();
            }
            BigInteger inhibitPolicyMapping = policyConstraintsFromExtensions.getInhibitPolicyMapping();
            if (inhibitPolicyMapping != null && inhibitPolicyMapping.intValue() < this.policyMapping) {
                this.policyMapping = inhibitPolicyMapping.intValue();
            }
        }
        Extension extension = x509CertificateHolder.getExtension(aSN1ObjectIdentifier);
        if (extension == null || (iIntValueExact = ASN1Integer.getInstance(extension.getParsedValue()).intValueExact()) >= this.inhibitAnyPolicy) {
            return;
        }
        this.inhibitAnyPolicy = iIntValueExact;
    }

    public CertificatePoliciesValidation(int i, boolean z, boolean z2, boolean z3) {
        if (z) {
            this.explicitPolicy = 0;
        } else {
            this.explicitPolicy = i + 1;
        }
        if (z2) {
            this.inhibitAnyPolicy = 0;
        } else {
            this.inhibitAnyPolicy = i + 1;
        }
        if (z3) {
            this.policyMapping = 0;
        } else {
            this.policyMapping = i + 1;
        }
    }
}
