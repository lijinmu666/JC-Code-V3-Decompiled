package org.bouncycastle.p361util.p364test;

/* loaded from: classes2.dex */
public class TestFailedException extends RuntimeException {

    /* renamed from: _result */
    private TestResult f24268_result;

    public TestFailedException(TestResult testResult) {
        this.f24268_result = testResult;
    }

    public TestResult getResult() {
        return this.f24268_result;
    }
}
