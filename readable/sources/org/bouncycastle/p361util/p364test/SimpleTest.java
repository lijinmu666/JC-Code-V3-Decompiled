package org.bouncycastle.p361util.p364test;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public abstract class SimpleTest implements InterfaceC6260Test {

    public interface TestExceptionOperation {
        void operation();
    }

    /* renamed from: runTest */
    public static void m18368runTest(InterfaceC6260Test interfaceC6260Test) {
        m18369runTest(interfaceC6260Test, System.out);
    }

    public static void runTests(InterfaceC6260Test[] interfaceC6260TestArr) {
        runTests(interfaceC6260TestArr, System.out);
    }

    /* renamed from: success */
    private TestResult m18370success() {
        return SimpleTestResult.successful(this, "Okay");
    }

    public boolean areEqual(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        return C6238Arrays.areEqual(bArr, i, i2, bArr2, i3, i4);
    }

    /* renamed from: fail */
    public void m18371fail(String str) {
        throw new TestFailedException(SimpleTestResult.m18378failed(this, str));
    }

    @Override // org.bouncycastle.p361util.p364test.InterfaceC6260Test
    /* renamed from: getName */
    public abstract String mo18374getName();

    public void isEquals(int i, int i2) {
        if (i != i2) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, "no message"));
        }
    }

    /* renamed from: isTrue */
    public void m18375isTrue(String str, boolean z) {
        if (!z) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, str));
        }
    }

    @Override // org.bouncycastle.p361util.p364test.InterfaceC6260Test
    /* renamed from: perform */
    public TestResult mo18377perform() {
        try {
            performTest();
            return m18370success();
        } catch (TestFailedException e) {
            return e.getResult();
        } catch (Exception e2) {
            return SimpleTestResult.m18380failed(this, "Exception: " + e2, e2);
        }
    }

    public abstract void performTest();

    public Exception testException(String str, String str2, TestExceptionOperation testExceptionOperation) {
        try {
            testExceptionOperation.operation();
            m18371fail(str);
            return null;
        } catch (Exception e) {
            if (str != null) {
                m18375isTrue(e.getMessage(), e.getMessage().indexOf(str) >= 0);
            }
            m18375isTrue(e.getMessage(), e.getClass().getName().indexOf(str2) >= 0);
            return e;
        }
    }

    /* renamed from: runTest */
    public static void m18369runTest(InterfaceC6260Test interfaceC6260Test, PrintStream printStream) {
        TestResult testResultMo18377perform = interfaceC6260Test.mo18377perform();
        if (testResultMo18377perform.getException() != null) {
            testResultMo18377perform.getException().printStackTrace(printStream);
        }
        printStream.println(testResultMo18377perform);
    }

    public static void runTests(InterfaceC6260Test[] interfaceC6260TestArr, PrintStream printStream) {
        Vector vector = new Vector();
        for (int i = 0; i != interfaceC6260TestArr.length; i++) {
            TestResult testResultMo18377perform = interfaceC6260TestArr[i].mo18377perform();
            if (!testResultMo18377perform.isSuccessful()) {
                vector.addElement(testResultMo18377perform);
            }
            if (testResultMo18377perform.getException() != null) {
                testResultMo18377perform.getException().printStackTrace(printStream);
            }
            printStream.println(testResultMo18377perform);
        }
        printStream.println("-----");
        if (vector.isEmpty()) {
            printStream.println("All tests successful.");
            return;
        }
        printStream.println("Completed with " + vector.size() + " FAILURES:");
        Enumeration enumerationElements = vector.elements();
        while (enumerationElements.hasMoreElements()) {
            System.out.println("=>  " + ((TestResult) enumerationElements.nextElement()));
        }
    }

    public boolean areEqual(byte[] bArr, byte[] bArr2) {
        return C6238Arrays.areEqual(bArr, bArr2);
    }

    /* renamed from: fail */
    public void m18372fail(String str, Object obj, Object obj2) {
        throw new TestFailedException(SimpleTestResult.m18379failed(this, str, obj, obj2));
    }

    public void isEquals(long j, long j2) {
        if (j != j2) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, "no message"));
        }
    }

    /* renamed from: isTrue */
    public void m18376isTrue(boolean z) {
        if (!z) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, "no message"));
        }
    }

    public boolean areEqual(byte[][] bArr, byte[][] bArr2) {
        if (bArr == null && bArr2 == null) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (!areEqual(bArr[i], bArr2[i])) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: fail */
    public void m18373fail(String str, Throwable th) {
        throw new TestFailedException(SimpleTestResult.m18380failed(this, str, th));
    }

    public void isEquals(Object obj, Object obj2) {
        if (!obj.equals(obj2)) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, "no message"));
        }
    }

    public void isEquals(String str, long j, long j2) {
        if (j != j2) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, str));
        }
    }

    public void isEquals(String str, Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return;
        }
        if (obj == null) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, str));
        }
        if (obj2 == null) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, str));
        }
        if (!obj.equals(obj2)) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, str));
        }
    }

    public void isEquals(String str, boolean z, boolean z2) {
        if (z != z2) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, str));
        }
    }

    public void isEquals(boolean z, boolean z2) {
        if (z != z2) {
            throw new TestFailedException(SimpleTestResult.m18378failed(this, "no message"));
        }
    }
}
