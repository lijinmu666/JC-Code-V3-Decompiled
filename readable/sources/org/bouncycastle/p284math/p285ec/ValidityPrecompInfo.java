package org.bouncycastle.p284math.p285ec;

/* loaded from: classes2.dex */
class ValidityPrecompInfo implements PreCompInfo {
    static final String PRECOMP_NAME = "bc_validity";

    /* renamed from: failed */
    private boolean f22146failed = false;
    private boolean curveEquationPassed = false;
    private boolean orderPassed = false;

    public boolean hasCurveEquationPassed() {
        return this.curveEquationPassed;
    }

    public boolean hasFailed() {
        return this.f22146failed;
    }

    public boolean hasOrderPassed() {
        return this.orderPassed;
    }

    public void reportCurveEquationPassed() {
        this.curveEquationPassed = true;
    }

    public void reportFailed() {
        this.f22146failed = true;
    }

    public void reportOrderPassed() {
        this.orderPassed = true;
    }
}
