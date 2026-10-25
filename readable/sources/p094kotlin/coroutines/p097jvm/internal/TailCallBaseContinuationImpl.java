package p094kotlin.coroutines.p097jvm.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0001\u0018\u00002\u00020\u0001BI\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u0012\u000e\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\f¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0018\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001aH\u0094\u0080\u0004¢\u0006\u0002\u0010\u001bJ\n\u0010\u001c\u001a\u00020\u001dH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\u0005\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0015\u0010\u0006\u001a\u00020\u0007X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001f\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tX\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\fX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u001e\u001a\u00020\u001f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b \u0010!Ê\u0001\u0002\b#¨\u0006\""}, m4988d2 = {"Lkotlin/coroutines/jvm/internal/TailCallBaseContinuationImpl;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "declaringClass", BuildConfig.f24315FLAVOR, "methodName", "fileName", "lineNumber", BuildConfig.f24315FLAVOR, "spilledVariables", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "continuation", "Lkotlin/coroutines/Continuation;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "getDeclaringClass", "()Ljava/lang/String;", "getMethodName", "getFileName", "getLineNumber", "()I", "getSpilledVariables", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlin-stdlib", "Lkotlin/PublishedApi;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@PublishedApi
/* loaded from: classes.dex */
public final class TailCallBaseContinuationImpl extends BaseContinuationImpl {
    private final Continuation<Object> continuation;
    private final String declaringClass;
    private final String fileName;
    private final int lineNumber;
    private final String methodName;
    private final Object[] spilledVariables;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TailCallBaseContinuationImpl(String declaringClass, String methodName, String fileName, int i, Object[] spilledVariables, Continuation<Object> continuation) {
        super(continuation);
        Intrinsics.checkNotNullParameter(declaringClass, "declaringClass");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(spilledVariables, "spilledVariables");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        this.declaringClass = declaringClass;
        this.methodName = methodName;
        this.fileName = fileName;
        this.lineNumber = i;
        this.spilledVariables = spilledVariables;
        this.continuation = continuation;
    }

    @Override // p094kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return this.continuation.getContext();
    }

    public final String getDeclaringClass() {
        return this.declaringClass;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final String getMethodName() {
        return this.methodName;
    }

    public final Object[] getSpilledVariables() {
        return this.spilledVariables;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl, p094kotlin.coroutines.p097jvm.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        String str;
        String moduleName = ModuleNameRetriever.INSTANCE.getModuleName(this);
        if (moduleName == null) {
            str = this.declaringClass;
        } else {
            str = moduleName + '/' + this.declaringClass;
        }
        return new StackTraceElement(str, this.methodName, this.fileName, this.lineNumber);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public Object invokeSuspend(Object result) {
        ResultKt.throwOnFailure(result);
        return result;
    }
}
