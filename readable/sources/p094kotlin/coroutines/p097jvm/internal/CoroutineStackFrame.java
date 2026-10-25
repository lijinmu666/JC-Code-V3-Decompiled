package p094kotlin.coroutines.p097jvm.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;

@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H¦\u0080\u0004R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004Ê\u0001\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¨\u0006\u0007"}, m4988d2 = {"Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", BuildConfig.f24315FLAVOR, "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface CoroutineStackFrame {
    CoroutineStackFrame getCallerFrame();

    StackTraceElement getStackTraceElement();
}
