package p122kotlinx.coroutines.p125flow.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.internal.ScopeCoroutine;
import p122kotlinx.coroutines.p125flow.FlowCollector;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;
import p122kotlinx.coroutines.p125flow.internal.SafeCollector_commonKt;

@Metadata(m4987d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0001\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0080\u0010\u001aK\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\u0004\b\u0000\u0010\n2/\b\u0004\u0010\u000b\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0010H\u0081\b¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m4988d2 = {"checkContext", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/flow/internal/SafeCollector;", "currentContext", "Lkotlin/coroutines/CoroutineContext;", "transitiveCoroutineParent", "Lkotlinx/coroutines/Job;", "collectJob", "unsafeFlow", "Lkotlinx/coroutines/flow/Flow;", "T", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SafeCollector_commonKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n*L\n1#1,111:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1 */
    public static final class C15711<T> implements InterfaceC1426Flow<T> {

        /* renamed from: $block */
        final /* synthetic */ Function2<FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> f7175$block;

        /* JADX WARN: Multi-variable type inference failed */
        public C15711(Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
            this.f7175$block = function2;
        }

        @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
        /* renamed from: collect */
        public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
            Object objMo2167invoke = this.f7175$block.mo2167invoke(flowCollector, continuation);
            return objMo2167invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo2167invoke : C1133Unit.INSTANCE;
        }

        public Object collect$$forInline(FlowCollector<? super T> flowCollector, final Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.internal.SafeCollector_commonKt$unsafeFlow$1$collect$1

                /* renamed from: label */
                int f7176label;

                /* renamed from: result */
                /* synthetic */ Object f7177result;

                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    this.f7177result = obj;
                    this.f7176label |= Integer.MIN_VALUE;
                    return this.f7178this$0.mo4308collect(null, this);
                }
            };
            InlineMarker.m6315mark(5);
            this.f7175$block.mo2167invoke(flowCollector, continuation);
            return C1133Unit.INSTANCE;
        }
    }

    @InterfaceC1231JvmName(m6260name = "checkContext")
    public static final void checkContext(final SafeCollector<?> safeCollector, CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.mo6097fold(0, new Function2() { // from class: o.g6
            @Override // p094kotlin.p105jvm.functions.Function2
            /* renamed from: invoke */
            public final Object mo2167invoke(Object obj, Object obj2) {
                return Integer.valueOf(SafeCollector_commonKt.checkContext$lambda$0(safeCollector, ((Integer) obj).intValue(), (CoroutineContext.InterfaceC1197Element) obj2));
            }
        })).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int checkContext$lambda$0(SafeCollector safeCollector, int i, CoroutineContext.InterfaceC1197Element interfaceC1197Element) {
        CoroutineContext.InterfaceC1198Key<?> interfaceC1198KeyMo6099getKey = interfaceC1197Element.mo6099getKey();
        CoroutineContext.InterfaceC1197Element interfaceC1197ElementMo6098get = safeCollector.collectContext.mo6098get(interfaceC1198KeyMo6099getKey);
        if (interfaceC1198KeyMo6099getKey != InterfaceC1342Job.INSTANCE) {
            if (interfaceC1197Element != interfaceC1197ElementMo6098get) {
                return Integer.MIN_VALUE;
            }
            return i + 1;
        }
        InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) interfaceC1197ElementMo6098get;
        Intrinsics.checkNotNull(interfaceC1197Element, "null cannot be cast to non-null type kotlinx.coroutines.Job");
        InterfaceC1342Job interfaceC1342JobTransitiveCoroutineParent = transitiveCoroutineParent((InterfaceC1342Job) interfaceC1197Element, interfaceC1342Job);
        if (interfaceC1342JobTransitiveCoroutineParent == interfaceC1342Job) {
            return interfaceC1342Job == null ? i : i + 1;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + interfaceC1342JobTransitiveCoroutineParent + ", expected child of " + interfaceC1342Job + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
    }

    public static final InterfaceC1342Job transitiveCoroutineParent(InterfaceC1342Job interfaceC1342Job, InterfaceC1342Job interfaceC1342Job2) {
        while (interfaceC1342Job != null) {
            if (interfaceC1342Job == interfaceC1342Job2 || !(interfaceC1342Job instanceof ScopeCoroutine)) {
                return interfaceC1342Job;
            }
            interfaceC1342Job = ((ScopeCoroutine) interfaceC1342Job).getParent();
        }
        return null;
    }

    @PublishedApi
    public static final <T> InterfaceC1426Flow<T> unsafeFlow(Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return new C15711(function2);
    }
}
