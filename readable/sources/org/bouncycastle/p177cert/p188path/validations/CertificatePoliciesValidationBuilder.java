package org.bouncycastle.p177cert.p188path.validations;

import org.bouncycastle.p177cert.p188path.CertPath;

/* loaded from: classes2.dex */
public class CertificatePoliciesValidationBuilder {
    private boolean isAnyPolicyInhibited;
    private boolean isExplicitPolicyRequired;
    private boolean isPolicyMappingInhibited;

    /* renamed from: build */
    public CertificatePoliciesValidation m14828build(int i) {
        return new CertificatePoliciesValidation(i, this.isExplicitPolicyRequired, this.isAnyPolicyInhibited, this.isPolicyMappingInhibited);
    }

    public void setAnyPolicyInhibited(boolean z) {
        this.isAnyPolicyInhibited = z;
    }

    public void setExplicitPolicyRequired(boolean z) {
        this.isExplicitPolicyRequired = z;
    }

    public void setPolicyMappingInhibited(boolean z) {
        this.isPolicyMappingInhibited = z;
    }

    /* renamed from: build */
    public CertificatePoliciesValidation m14829build(CertPath certPath) {
        return m14828build(certPath.m14822length());
    }
}
