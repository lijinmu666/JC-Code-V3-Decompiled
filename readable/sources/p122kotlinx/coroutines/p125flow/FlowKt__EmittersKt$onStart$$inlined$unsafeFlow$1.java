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
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,111:1\n71#2:112\n72#2,7:114\n1307#3:113\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n71#1:113\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Function2 $action$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_onStart$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", m6124f = "Emitters.kt", m6125i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m6126l = {115, 119}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$onStart_u24lambda_u240", "safeCollector", "$i$a$-unsafeFlow-FlowKt__EmittersKt$onStart$1", "collector", "$completion", "$this$onStart_u24lambda_u240", "safeCollector", "$i$a$-unsafeFlow-FlowKt__EmittersKt$onStart$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 */
    public static final class C14721 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6439I$0;

        /* renamed from: L$0 */
        Object f6440L$0;

        /* renamed from: L$1 */
        Object f6441L$1;

        /* renamed from: L$2 */
        Object f6442L$2;

        /* renamed from: L$3 */
        Object f6443L$3;

        /* renamed from: label */
        int f6444label;

        /* renamed from: result */
        /* synthetic */ Object f6445result;

        public C14721(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6445result = obj;
            this.f6444label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Function2 function2, InterfaceC1426Flow interfaceC1426Flow) {
        this.$action$inlined = function2;
        this.$this_onStart$inlined = interfaceC1426Flow;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14721 c14721;
        int i;
        FlowCollector<? super T> flowCollector2;
        Object obj;
        if (continuation instanceof C14721) {
            c14721 = (C14721) continuation;
            int i2 = c14721.f6444label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14721.f6444label = i2 - Integer.MIN_VALUE;
            } else {
                c14721 = new C14721(continuation);
            }
        }
        Object obj2 = c14721.f6445result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c14721.f6444label;
        try {
            if (r2 == 0) {
                ResultKt.throwOnFailure(obj2);
                SafeCollector safeCollector = new SafeCollector(flowCollector, c14721.getContext());
                Function2 function2 = this.$action$inlined;
                c14721.f6440L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                c14721.f6441L$1 = SpillingKt.nullOutSpilledVariable(c14721);
                c14721.f6442L$2 = flowCollector;
                c14721.f6443L$3 = safeCollector;
                i = 0;
                c14721.f6439I$0 = 0;
                c14721.f6444label = 1;
                InlineMarker.m6315mark(6);
                Object objMo2167invoke = function2.mo2167invoke(safeCollector, c14721);
                InlineMarker.m6315mark(7);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector2 = flowCollector;
                obj = c14721;
                r2 = safeCollector;
            } else {
                if (r2 != 1) {
                    if (r2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj2);
                    return C1133Unit.INSTANCE;
                }
                int i3 = c14721.f6439I$0;
                SafeCollector safeCollector2 = (SafeCollector) c14721.f6443L$3;
                FlowCollector<? super T> flowCollector3 = (FlowCollector) c14721.f6442L$2;
                Object obj3 = (Continuation) c14721.f6441L$1;
                flowCollector2 = (FlowCollector) c14721.f6440L$0;
                ResultKt.throwOnFailure(obj2);
                obj = obj3;
                i = i3;
                flowCollector = flowCollector3;
                r2 = safeCollector2;
            }
            r2.releaseIntercepted();
            InterfaceC1426Flow interfaceC1426Flow = this.$this_onStart$inlined;
            c14721.f6440L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            c14721.f6441L$1 = SpillingKt.nullOutSpilledVariable(obj);
            c14721.f6442L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14721.f6443L$3 = SpillingKt.nullOutSpilledVariable(r2);
            c14721.f6439I$0 = i;
            c14721.f6444label = 2;
            if (interfaceC1426Flow.mo4308collect(flowCollector, c14721) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return C1133Unit.INSTANCE;
        } catch (Throwable th) {
            r2.releaseIntercepted();
            throw th;
        }
    }
}
