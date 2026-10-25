package org.bouncycastle.p177cert.p188path;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
class CertPathValidationResultBuilder {

    /* renamed from: context */
    private final CertPathValidationContext f18904context;
    private final List<Integer> certIndexes = new ArrayList();
    private final List<Integer> ruleIndexes = new ArrayList();
    private final List<CertPathValidationException> exceptions = new ArrayList();

    public CertPathValidationResultBuilder(CertPathValidationContext certPathValidationContext) {
        this.f18904context = certPathValidationContext;
    }

    /* renamed from: toInts */
    private int[] m14826toInts(List<Integer> list) {
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i != size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        return iArr;
    }

    public void addException(int i, int i2, CertPathValidationException certPathValidationException) {
        this.certIndexes.add(Integers.m18296valueOf(i));
        this.ruleIndexes.add(Integers.m18296valueOf(i2));
        this.exceptions.add(certPathValidationException);
    }

    /* renamed from: build */
    public CertPathValidationResult m14827build() {
        if (this.exceptions.isEmpty()) {
            return new CertPathValidationResult(this.f18904context);
        }
        CertPathValidationContext certPathValidationContext = this.f18904context;
        int[] iArrM14826toInts = m14826toInts(this.certIndexes);
        int[] iArrM14826toInts2 = m14826toInts(this.ruleIndexes);
        List<CertPathValidationException> list = this.exceptions;
        return new CertPathValidationResult(certPathValidationContext, iArrM14826toInts, iArrM14826toInts2, (CertPathValidationException[]) list.toArray(new CertPathValidationException[list.size()]));
    }
}
