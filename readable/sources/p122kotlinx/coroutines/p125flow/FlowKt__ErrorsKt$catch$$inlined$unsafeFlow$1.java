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

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Errors.kt\nkotlinx/coroutines/flow/FlowKt__ErrorsKt\n*L\n1#1,111:1\n55#2,3:112\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Function3 $action$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_catch$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", m6124f = "Errors.kt", m6125i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, m6126l = {112, 113}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$catch_u24lambda_u240", "$i$a$-unsafeFlow-FlowKt__ErrorsKt$catch$1", "collector", "$completion", "$this$catch_u24lambda_u240", "exception", "$i$a$-unsafeFlow-FlowKt__ErrorsKt$catch$1"}, m6130s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1$1 */
    public static final class C14751 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6469I$0;

        /* renamed from: L$0 */
        Object f6470L$0;

        /* renamed from: L$1 */
        Object f6471L$1;

        /* renamed from: L$2 */
        Object f6472L$2;

        /* renamed from: L$3 */
        Object f6473L$3;

        /* renamed from: label */
        int f6474label;

        /* renamed from: result */
        /* synthetic */ Object f6475result;

        public C14751(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6475result = obj;
            this.f6474label |= Integer.MIN_VALUE;
            return FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(InterfaceC1426Flow interfaceC1426Flow, Function3 function3) {
        this.$this_catch$inlined = interfaceC1426Flow;
        this.$action$inlined = function3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14751 c14751;
        int i;
        FlowCollector<? super T> flowCollector2;
        Continuation continuation2;
        if (continuation instanceof C14751) {
            c14751 = (C14751) continuation;
            int i2 = c14751.f6474label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c14751.f6474label = i2 - Integer.MIN_VALUE;
            } else {
                c14751 = new C14751(continuation);
            }
        }
        Object objCatchImpl = c14751.f6475result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c14751.f6474label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(objCatchImpl);
            InterfaceC1426Flow interfaceC1426Flow = this.$this_catch$inlined;
            c14751.f6470L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14751.f6471L$1 = SpillingKt.nullOutSpilledVariable(c14751);
            c14751.f6472L$2 = flowCollector;
            i = 0;
            c14751.f6469I$0 = 0;
            c14751.f6474label = 1;
            objCatchImpl = C1427FlowKt.catchImpl(interfaceC1426Flow, flowCollector, c14751);
            if (objCatchImpl == coroutine_suspended) {
                return coroutine_suspended;
            }
            flowCollector2 = flowCollector;
            continuation2 = c14751;
        } else {
            if (i3 != 1) {
                if (i3 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objCatchImpl);
                return C1133Unit.INSTANCE;
            }
            int i4 = c14751.f6469I$0;
            FlowCollector<? super T> flowCollector3 = (FlowCollector) c14751.f6472L$2;
            continuation2 = (Continuation) c14751.f6471L$1;
            flowCollector2 = (FlowCollector) c14751.f6470L$0;
            ResultKt.throwOnFailure(objCatchImpl);
            i = i4;
            flowCollector = flowCollector3;
        }
        Throwable th = (Throwable) objCatchImpl;
        if (th != null) {
            Function3 function3 = this.$action$inlined;
            c14751.f6470L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            c14751.f6471L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
            c14751.f6472L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14751.f6473L$3 = SpillingKt.nullOutSpilledVariable(th);
            c14751.f6469I$0 = i;
            c14751.f6474label = 2;
            InlineMarker.m6315mark(6);
            Object objMo6219invoke = function3.mo6219invoke(flowCollector, th, c14751);
            InlineMarker.m6315mark(7);
            if (objMo6219invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return C1133Unit.INSTANCE;
    }
}
