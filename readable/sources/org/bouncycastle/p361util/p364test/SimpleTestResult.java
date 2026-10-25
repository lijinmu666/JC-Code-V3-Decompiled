package org.bouncycastle.p361util.p364test;

import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SimpleTestResult implements TestResult {
    private static final String SEPARATOR = C6250Strings.lineSeparator();
    private Throwable exception;

    /* renamed from: message */
    private String f24266message;

    /* renamed from: success */
    private boolean f24267success;

    public SimpleTestResult(boolean z, String str) {
        this.f24267success = z;
        this.f24266message = str;
    }

    /* renamed from: failed */
    public static TestResult m18378failed(InterfaceC6260Test interfaceC6260Test, String str) {
        return new SimpleTestResult(false, interfaceC6260Test.mo18374getName() + ": " + str);
    }

    public static String failedMessage(String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(" failing ");
        sb.append(str2);
        String str5 = SEPARATOR;
        sb.append(str5);
        sb.append("    expected: ");
        sb.append(str3);
        sb.append(str5);
        sb.append("    got     : ");
        sb.append(str4);
        return sb.toString();
    }

    public static TestResult successful(InterfaceC6260Test interfaceC6260Test, String str) {
        return new SimpleTestResult(true, interfaceC6260Test.mo18374getName() + ": " + str);
    }

    @Override // org.bouncycastle.p361util.p364test.TestResult
    public Throwable getException() {
        return this.exception;
    }

    @Override // org.bouncycastle.p361util.p364test.TestResult
    public boolean isSuccessful() {
        return this.f24267success;
    }

    @Override // org.bouncycastle.p361util.p364test.TestResult
    public String toString() {
        return this.f24266message;
    }

    public SimpleTestResult(boolean z, String str, Throwable th) {
        this.f24267success = z;
        this.f24266message = str;
        this.exception = th;
    }

    /* renamed from: failed */
    public static TestResult m18379failed(InterfaceC6260Test interfaceC6260Test, String str, Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        String str2 = SEPARATOR;
        sb.append(str2);
        sb.append("Expected: ");
        sb.append(obj);
        sb.append(str2);
        sb.append("Found   : ");
        sb.append(obj2);
        return m18378failed(interfaceC6260Test, sb.toString());
    }

    /* renamed from: failed */
    public static TestResult m18380failed(InterfaceC6260Test interfaceC6260Test, String str, Throwable th) {
        return new SimpleTestResult(false, interfaceC6260Test.mo18374getName() + ": " + str, th);
    }
}
