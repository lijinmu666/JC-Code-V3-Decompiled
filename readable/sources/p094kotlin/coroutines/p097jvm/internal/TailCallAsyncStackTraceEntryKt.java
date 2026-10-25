package p094kotlin.coroutines.p097jvm.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aa\u0010\u0000\u001a\u0002H\u0001\"\u0014\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2\u0006\u0010\r\u001a\u0002H\u0001H\u0081\u0080\u0004b\u0002\b\u000f¢\u0006\u0002\u0010\u000e\u001a]\u0010\u0010\u001a\u0002H\u0001\"\u0014\b\u0000\u0010\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\f2\u0006\u0010\r\u001a\u0002H\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010\u000e¨\u0006\u0011"}, m4988d2 = {"wrapContinuation", "T", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "declaringClass", BuildConfig.f24315FLAVOR, "methodName", "fileName", "lineNumber", BuildConfig.f24315FLAVOR, "spilledVariables", BuildConfig.f24315FLAVOR, "continuation", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "Lkotlin/PublishedApi;", "wrapContinuationReal", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class TailCallAsyncStackTraceEntryKt {
    /* JADX WARN: Incorrect return type in method signature: <T::Lkotlin/coroutines/Continuation<-Ljava/lang/Object;>;:Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Object;TT;)TT; */
    @PublishedApi
    public static final Continuation wrapContinuation(String declaringClass, String methodName, String fileName, int i, Object[] spilledVariables, Continuation continuation) {
        Intrinsics.checkNotNullParameter(declaringClass, "declaringClass");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(spilledVariables, "spilledVariables");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continuation;
    }

    /* JADX WARN: Incorrect return type in method signature: <T::Lkotlin/coroutines/Continuation<-Ljava/lang/Object;>;:Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Object;TT;)TT; */
    public static final Continuation wrapContinuationReal(String declaringClass, String methodName, String fileName, int i, Object[] spilledVariables, Continuation continuation) {
        Intrinsics.checkNotNullParameter(declaringClass, "declaringClass");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(spilledVariables, "spilledVariables");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return new TailCallBaseContinuationImpl(declaringClass, methodName, fileName, i, spilledVariables, continuation);
    }
}
