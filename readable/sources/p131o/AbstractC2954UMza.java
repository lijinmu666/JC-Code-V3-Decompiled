package p131o;

/* renamed from: o.UMza */
/* loaded from: classes.dex */
public abstract class AbstractC2954UMza {

    /* renamed from: mjFkc */
    public static final String f10820mjFkc = "_COROUTINE";

    /* renamed from: AZxh */
    public static final StackTraceElement m10484AZxh(Throwable th, String str) {
        StackTraceElement stackTraceElement = th.getStackTrace()[0];
        return new StackTraceElement(f10820mjFkc + '.' + str, "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
    }

    /* renamed from: wA */
    public static final String m10486wA() {
        return f10820mjFkc;
    }
}
