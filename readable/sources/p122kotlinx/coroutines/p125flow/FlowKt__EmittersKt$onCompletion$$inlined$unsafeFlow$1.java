package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,111:1\n141#2,13:112\n154#2,6:126\n1307#3:125\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n153#1:125\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_onCompletion$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", m6124f = "Emitters.kt", m6125i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2}, m6126l = {113, 120, 127}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$onCompletion_u24lambda_u240", "$i$a$-unsafeFlow-FlowKt__EmittersKt$onCompletion$1", "collector", "$completion", "$this$onCompletion_u24lambda_u240", "e", "$i$a$-unsafeFlow-FlowKt__EmittersKt$onCompletion$1", "collector", "$completion", "$this$onCompletion_u24lambda_u240", "sc", "$i$a$-unsafeFlow-FlowKt__EmittersKt$onCompletion$1"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 */
    public static final class C14701 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6422I$0;

        /* renamed from: L$0 */
        Object f6423L$0;

        /* renamed from: L$1 */
        Object f6424L$1;

        /* renamed from: L$2 */
        Object f6425L$2;

        /* renamed from: L$3 */
        Object f6426L$3;

        /* renamed from: label */
        int f6427label;

        /* renamed from: result */
        /* synthetic */ Object f6428result;

        public C14701(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6428result = obj;
            this.f6427label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(InterfaceC1426Flow interfaceC1426Flow, Function3 function3) {
        this.$this_onCompletion$inlined = interfaceC1426Flow;
        this.$action$inlined = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0105 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) throws Throwable {
        C14701 c14701;
        int i;
        int i2;
        Continuation continuation2;
        FlowCollector<? super T> flowCollector2;
        FlowCollector<? super T> flowCollector3;
        ThrowingCollector throwingCollector;
        Function3 function3;
        SafeCollector safeCollector;
        SafeCollector safeCollector2;
        Object objMo6219invoke;
        if (continuation instanceof C14701) {
            c14701 = (C14701) continuation;
            int i3 = c14701.f6427label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c14701.f6427label = i3 - Integer.MIN_VALUE;
            } else {
                c14701 = new C14701(continuation);
            }
        }
        Object obj = c14701.f6428result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c14701.f6427label;
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 == 2) {
                    Throwable th = (Throwable) c14701.f6426L$3;
                    ResultKt.throwOnFailure(obj);
                    throw th;
                }
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                safeCollector2 = (SafeCollector) c14701.f6426L$3;
                try {
                    ResultKt.throwOnFailure(obj);
                    safeCollector2.releaseIntercepted();
                    return C1133Unit.INSTANCE;
                } catch (Throwable th2) {
                    th = th2;
                    safeCollector2.releaseIntercepted();
                    throw th;
                }
            }
            int i5 = c14701.f6422I$0;
            FlowCollector<? super T> flowCollector4 = (FlowCollector) c14701.f6425L$2;
            continuation2 = (Continuation) c14701.f6424L$1;
            flowCollector3 = (FlowCollector) c14701.f6423L$0;
            try {
                ResultKt.throwOnFailure(obj);
                i = i5;
                flowCollector = flowCollector4;
                safeCollector = new SafeCollector(flowCollector, c14701.getContext());
                try {
                    Function3 function32 = this.$action$inlined;
                    c14701.f6423L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                    c14701.f6424L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                    c14701.f6425L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    c14701.f6426L$3 = safeCollector;
                    c14701.f6422I$0 = i;
                    c14701.f6427label = 3;
                    InlineMarker.m6315mark(6);
                    objMo6219invoke = function32.mo6219invoke(safeCollector, null, c14701);
                    InlineMarker.m6315mark(7);
                    if (objMo6219invoke != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    safeCollector2 = safeCollector;
                    safeCollector2.releaseIntercepted();
                    return C1133Unit.INSTANCE;
                } catch (Throwable th3) {
                    th = th3;
                    safeCollector2 = safeCollector;
                    safeCollector2.releaseIntercepted();
                    throw th;
                }
            } catch (Throwable th4) {
                i2 = i5;
                flowCollector = flowCollector3;
                th = th4;
                flowCollector2 = flowCollector4;
                throwingCollector = new ThrowingCollector(th);
                function3 = this.$action$inlined;
                c14701.f6423L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                c14701.f6424L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                c14701.f6425L$2 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                c14701.f6426L$3 = th;
                c14701.f6422I$0 = i2;
                c14701.f6427label = 2;
                if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function3, th, c14701) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        i = 0;
        try {
            InterfaceC1426Flow interfaceC1426Flow = this.$this_onCompletion$inlined;
            c14701.f6423L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14701.f6424L$1 = SpillingKt.nullOutSpilledVariable(c14701);
            c14701.f6425L$2 = flowCollector;
            c14701.f6422I$0 = 0;
            c14701.f6427label = 1;
            if (interfaceC1426Flow.mo4308collect(flowCollector, c14701) == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector3 = flowCollector;
            continuation2 = c14701;
            safeCollector = new SafeCollector(flowCollector, c14701.getContext());
            Function3 function322 = this.$action$inlined;
            c14701.f6423L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
            c14701.f6424L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
            c14701.f6425L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14701.f6426L$3 = safeCollector;
            c14701.f6422I$0 = i;
            c14701.f6427label = 3;
            InlineMarker.m6315mark(6);
            objMo6219invoke = function322.mo6219invoke(safeCollector, null, c14701);
            InlineMarker.m6315mark(7);
            if (objMo6219invoke != coroutine_suspended) {
            }
        } catch (Throwable th5) {
            th = th5;
            i2 = 0;
            continuation2 = c14701;
            flowCollector2 = flowCollector;
            throwingCollector = new ThrowingCollector(th);
            function3 = this.$action$inlined;
            c14701.f6423L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14701.f6424L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
            c14701.f6425L$2 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            c14701.f6426L$3 = th;
            c14701.f6422I$0 = i2;
            c14701.f6427label = 2;
            if (FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(throwingCollector, function3, th, c14701) != coroutine_suspended) {
            }
        }
    }
}
