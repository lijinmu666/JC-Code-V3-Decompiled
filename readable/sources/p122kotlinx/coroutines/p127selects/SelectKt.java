package p122kotlinx.coroutines.p127selects;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.InlineMarker;
import p122kotlinx.coroutines.CancellableContinuation;
import p122kotlinx.coroutines.InternalCoroutinesApi;
import p122kotlinx.coroutines.internal.C1578Symbol;

@Metadata(m4987d1 = {"\u0000j\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aB\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0007\u001ac\u0010\u0019\u001a\u00020\u001a*\b\u0012\u0004\u0012\u00020\u00050\u001b2O\u0010\u001c\u001aK\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001d\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0002\u001a\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020!H\u0002\"]\u0010\u0017\u001aQ\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\tj\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020!X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010-\u001a\u00020)X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/*¦\u0001\b\u0007\u0010\b\"M\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0000\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\t2M\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0000\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00050\tB\u0002\b\u0010*¦\u0001\b\u0007\u0010\u0011\"M\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2M\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0012\u0012\u0006\u0012\u0004\u0018\u00010\n0\tB\u0002\b\u0010*Ú\u0001\b\u0000\u0010\u0013\"i\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0000\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0014\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\t0\t2i\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0000\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0014\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\t0\t¨\u00060"}, m4988d2 = {"select", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RegistrationFunction", "Lkotlin/Function3;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "clauseObject", "Lkotlinx/coroutines/selects/SelectInstance;", "param", "Lkotlinx/coroutines/InternalCoroutinesApi;", "ProcessResultFunction", "clauseResult", "OnCancellationConstructor", "internalResult", BuildConfig.f24315FLAVOR, "Lkotlin/coroutines/CoroutineContext;", "DUMMY_PROCESS_RESULT_FUNCTION", "Lkotlinx/coroutines/selects/ProcessResultFunction;", "tryResume", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CancellableContinuation;", "onCancellation", "cause", "value", "context", "TRY_SELECT_SUCCESSFUL", BuildConfig.f24315FLAVOR, "TRY_SELECT_REREGISTER", "TRY_SELECT_CANCELLED", "TRY_SELECT_ALREADY_SELECTED", "TrySelectDetailedResult", "Lkotlinx/coroutines/selects/TrySelectDetailedResult;", "trySelectInternalResult", "STATE_REG", "Lkotlinx/coroutines/internal/Symbol;", "STATE_COMPLETED", "STATE_CANCELLED", "NO_RESULT", "PARAM_CLAUSE_0", "getPARAM_CLAUSE_0", "()Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SelectKt {
    private static final int TRY_SELECT_ALREADY_SELECTED = 3;
    private static final int TRY_SELECT_CANCELLED = 2;
    private static final int TRY_SELECT_REREGISTER = 1;
    private static final int TRY_SELECT_SUCCESSFUL = 0;
    private static final Function3<Object, Object, Object, Object> DUMMY_PROCESS_RESULT_FUNCTION = new Function3() { // from class: kotlinx.coroutines.selects.SelectKt$DUMMY_PROCESS_RESULT_FUNCTION$1
        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke */
        public final Void mo6219invoke(Object obj, Object obj2, Object obj3) {
            return null;
        }
    };
    private static final C1578Symbol STATE_REG = new C1578Symbol("STATE_REG");
    private static final C1578Symbol STATE_COMPLETED = new C1578Symbol("STATE_COMPLETED");
    private static final C1578Symbol STATE_CANCELLED = new C1578Symbol("STATE_CANCELLED");
    private static final C1578Symbol NO_RESULT = new C1578Symbol("NO_RESULT");
    private static final C1578Symbol PARAM_CLAUSE_0 = new C1578Symbol("PARAM_CLAUSE_0");

    @InternalCoroutinesApi
    public static /* synthetic */ void ProcessResultFunction$annotations() {
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void RegistrationFunction$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TrySelectDetailedResult TrySelectDetailedResult(int i) {
        if (i == 0) {
            return TrySelectDetailedResult.SUCCESSFUL;
        }
        if (i == 1) {
            return TrySelectDetailedResult.REREGISTER;
        }
        if (i == 2) {
            return TrySelectDetailedResult.CANCELLED;
        }
        if (i == 3) {
            return TrySelectDetailedResult.ALREADY_SELECTED;
        }
        throw new IllegalStateException(("Unexpected internal result: " + i).toString());
    }

    public static final C1578Symbol getPARAM_CLAUSE_0() {
        return PARAM_CLAUSE_0;
    }

    /* renamed from: select */
    public static final <R> Object m7488select(Function1<? super SelectBuilder<? super R>, C1133Unit> function1, Continuation<? super R> continuation) {
        SelectImplementation selectImplementation = new SelectImplementation(continuation.getContext());
        function1.mo2237invoke(selectImplementation);
        return selectImplementation.doSelect(continuation);
    }

    private static final <R> Object select$$forInline(Function1<? super SelectBuilder<? super R>, C1133Unit> function1, Continuation<? super R> continuation) {
        InlineMarker.m6315mark(3);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean tryResume(CancellableContinuation<? super C1133Unit> cancellableContinuation, Function3<? super Throwable, Object, ? super CoroutineContext, C1133Unit> function3) {
        Object objTryResume = cancellableContinuation.tryResume(C1133Unit.INSTANCE, null, function3);
        if (objTryResume == null) {
            return false;
        }
        cancellableContinuation.completeResume(objTryResume);
        return true;
    }
}
