package org.bouncycastle.p177cert.p188path;

import java.util.Collections;
import java.util.Set;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CertPathValidationResult {

    /* renamed from: cause */
    private final CertPathValidationException f18901cause;

    /* renamed from: causes */
    private CertPathValidationException[] f18902causes;
    private final int certIndex;
    private int[] certIndexes;

    /* renamed from: isValid */
    private final boolean f18903isValid;
    private final int ruleIndex;
    private int[] ruleIndexes;
    private final Set unhandledCriticalExtensionOIDs;

    public CertPathValidationResult(CertPathValidationContext certPathValidationContext) {
        Set setUnmodifiableSet = Collections.unmodifiableSet(certPathValidationContext.getUnhandledCriticalExtensionOIDs());
        this.unhandledCriticalExtensionOIDs = setUnmodifiableSet;
        this.f18903isValid = setUnmodifiableSet.isEmpty();
        this.certIndex = -1;
        this.ruleIndex = -1;
        this.f18901cause = null;
    }

    public CertPathValidationException getCause() {
        CertPathValidationException certPathValidationException = this.f18901cause;
        if (certPathValidationException != null) {
            return certPathValidationException;
        }
        if (this.unhandledCriticalExtensionOIDs.isEmpty()) {
            return null;
        }
        return new CertPathValidationException("Unhandled Critical Extensions");
    }

    public CertPathValidationException[] getCauses() {
        CertPathValidationException[] certPathValidationExceptionArr = this.f18902causes;
        if (certPathValidationExceptionArr != null) {
            CertPathValidationException[] certPathValidationExceptionArr2 = new CertPathValidationException[certPathValidationExceptionArr.length];
            System.arraycopy(certPathValidationExceptionArr, 0, certPathValidationExceptionArr2, 0, certPathValidationExceptionArr.length);
            return certPathValidationExceptionArr2;
        }
        if (this.unhandledCriticalExtensionOIDs.isEmpty()) {
            return null;
        }
        return new CertPathValidationException[]{new CertPathValidationException("Unhandled Critical Extensions")};
    }

    public int getFailingCertIndex() {
        return this.certIndex;
    }

    public int[] getFailingCertIndexes() {
        return C6238Arrays.m18234clone(this.certIndexes);
    }

    public int getFailingRuleIndex() {
        return this.ruleIndex;
    }

    public int[] getFailingRuleIndexes() {
        return C6238Arrays.m18234clone(this.ruleIndexes);
    }

    public Set getUnhandledCriticalExtensionOIDs() {
        return this.unhandledCriticalExtensionOIDs;
    }

    public boolean isDetailed() {
        return this.certIndexes != null;
    }

    /* renamed from: isValid */
    public boolean m14825isValid() {
        return this.f18903isValid;
    }

    public CertPathValidationResult(CertPathValidationContext certPathValidationContext, int i, int i2, CertPathValidationException certPathValidationException) {
        this.unhandledCriticalExtensionOIDs = Collections.unmodifiableSet(certPathValidationContext.getUnhandledCriticalExtensionOIDs());
        this.f18903isValid = false;
        this.certIndex = i;
        this.ruleIndex = i2;
        this.f18901cause = certPathValidationException;
    }

    public CertPathValidationResult(CertPathValidationContext certPathValidationContext, int[] iArr, int[] iArr2, CertPathValidationException[] certPathValidationExceptionArr) {
        this.unhandledCriticalExtensionOIDs = Collections.unmodifiableSet(certPathValidationContext.getUnhandledCriticalExtensionOIDs());
        this.f18903isValid = false;
        this.f18901cause = certPathValidationExceptionArr[0];
        this.certIndex = iArr[0];
        this.ruleIndex = iArr2[0];
        this.f18902causes = certPathValidationExceptionArr;
        this.certIndexes = iArr;
        this.ruleIndexes = iArr2;
    }
}
