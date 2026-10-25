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
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.SafeCollector;

@Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BD\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\r\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00028\u0000H\u0096A¢\u0006\u0002\u0010\u0011R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u0012"}, m4988d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nShare.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n+ 2 CoroutineScope.kt\nkotlinx/coroutines/CoroutineScopeKt\n*L\n1#1,482:1\n1307#2:483\n*S KotlinDebug\n*F\n+ 1 Share.kt\nkotlinx/coroutines/flow/SubscribedFlowCollector\n*L\n473#1:483\n*E\n"})
/* loaded from: classes.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {
    private final Function2<FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> action;
    private final FlowCollector<T> collector;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.SubscribedFlowCollector", m6124f = "Share.kt", m6125i = {0, 1}, m6126l = {475, 479}, m6127m = "onSubscription", m6128n = {"safeCollector", "safeCollector"}, m6130s = {"L$0", "L$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.SubscribedFlowCollector$onSubscription$1 */
    public static final class C15581 extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f7050L$0;

        /* renamed from: label */
        int f7051label;

        /* renamed from: result */
        /* synthetic */ Object f7052result;

        /* renamed from: this$0 */
        final /* synthetic */ SubscribedFlowCollector<T> f7053this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15581(SubscribedFlowCollector<T> subscribedFlowCollector, Continuation<? super C15581> continuation) {
            super(continuation);
            this.f7053this$0 = subscribedFlowCollector;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7052result = obj;
            this.f7051label |= Integer.MIN_VALUE;
            return this.f7053this$0.onSubscription(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SubscribedFlowCollector(FlowCollector<? super T> flowCollector, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        this.collector = flowCollector;
        this.action = function2;
    }

    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    public Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
        return this.collector.mo4309emit(t, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, kotlinx.coroutines.flow.internal.SafeCollector] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object onSubscription(Continuation<? super C1133Unit> continuation) {
        C15581 c15581;
        if (continuation instanceof C15581) {
            c15581 = (C15581) continuation;
            int i = c15581.f7051label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15581.f7051label = i - Integer.MIN_VALUE;
            } else {
                c15581 = new C15581(this, continuation);
            }
        }
        Object obj = c15581.f7052result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r2 = c15581.f7051label;
        try {
            if (r2 == 0) {
                ResultKt.throwOnFailure(obj);
                SafeCollector safeCollector = new SafeCollector(this.collector, c15581.getContext());
                Function2<FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> function2 = this.action;
                c15581.f7050L$0 = safeCollector;
                c15581.f7051label = 1;
                Object objMo2167invoke = function2.mo2167invoke(safeCollector, c15581);
                r2 = safeCollector;
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (r2 != 1) {
                    if (r2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return C1133Unit.INSTANCE;
                }
                SafeCollector safeCollector2 = (SafeCollector) c15581.f7050L$0;
                ResultKt.throwOnFailure(obj);
                r2 = safeCollector2;
            }
            r2.releaseIntercepted();
            FlowCollector<T> flowCollector = this.collector;
            if (!(flowCollector instanceof SubscribedFlowCollector)) {
                return C1133Unit.INSTANCE;
            }
            c15581.f7050L$0 = SpillingKt.nullOutSpilledVariable(r2);
            c15581.f7051label = 2;
            if (((SubscribedFlowCollector) flowCollector).onSubscription(c15581) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return C1133Unit.INSTANCE;
        } catch (Throwable th) {
            r2.releaseIntercepted();
            throw th;
        }
    }
}
