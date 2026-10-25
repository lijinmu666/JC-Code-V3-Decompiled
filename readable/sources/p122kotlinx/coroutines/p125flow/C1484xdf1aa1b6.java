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
import p122kotlinx.coroutines.p125flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nLimit.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt$transformWhile$1\n*L\n1#1,141:1\n118#2:142\n*E\n"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1 */
/* loaded from: classes.dex */
public final class C1484xdf1aa1b6<T> implements FlowCollector<T> {
    final /* synthetic */ FlowCollector $$this$safeFlow$inlined;
    final /* synthetic */ Function3 $transform$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1", m6124f = "Limit.kt", m6125i = {0, 0, 0, 0}, m6126l = {142}, m6127m = "emit", m6128n = {"value", "$completion", "value", "$i$a$-collectWhile-FlowKt__LimitKt$transformWhile$1$1"}, m6130s = {"L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6527I$0;

        /* renamed from: L$0 */
        Object f6528L$0;

        /* renamed from: L$1 */
        Object f6529L$1;

        /* renamed from: L$2 */
        Object f6530L$2;

        /* renamed from: label */
        int f6531label;

        /* renamed from: result */
        /* synthetic */ Object f6532result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6532result = obj;
            this.f6531label |= Integer.MIN_VALUE;
            return C1484xdf1aa1b6.this.mo4309emit(null, this);
        }
    }

    public C1484xdf1aa1b6(Function3 function3, FlowCollector flowCollector) {
        this.$transform$inlined = function3;
        this.$$this$safeFlow$inlined = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.f6531label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.f6531label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object objMo6219invoke = anonymousClass1.f6532result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.f6531label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objMo6219invoke);
            Function3 function3 = this.$transform$inlined;
            FlowCollector flowCollector = this.$$this$safeFlow$inlined;
            anonymousClass1.f6528L$0 = SpillingKt.nullOutSpilledVariable(t);
            anonymousClass1.f6529L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
            anonymousClass1.f6530L$2 = SpillingKt.nullOutSpilledVariable(t);
            anonymousClass1.f6527I$0 = 0;
            anonymousClass1.f6531label = 1;
            InlineMarker.m6315mark(6);
            objMo6219invoke = function3.mo6219invoke(flowCollector, t, anonymousClass1);
            InlineMarker.m6315mark(7);
            if (objMo6219invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objMo6219invoke);
        }
        if (((Boolean) objMo6219invoke).booleanValue()) {
            return C1133Unit.INSTANCE;
        }
        throw new AbortFlowException(this);
    }
}
