package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.p125flow.internal.AbortFlowException;
import p122kotlinx.coroutines.p125flow.internal.FlowExceptions_commonKt;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001aB\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b\u001aB\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b\u001aB\u0010\n\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0005H\u0086@¢\u0006\u0002\u0010\b¨\u0006\u000b"}, m4988d2 = {"any", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/flow/Flow;", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "all", "none", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nLogic.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Logic.kt\nkotlinx/coroutines/flow/FlowKt__LogicKt\n+ 2 Limit.kt\nkotlinx/coroutines/flow/FlowKt__LimitKt\n*L\n1#1,108:1\n124#2,17:109\n124#2,17:126\n*S KotlinDebug\n*F\n+ 1 Logic.kt\nkotlinx/coroutines/flow/FlowKt__LogicKt\n*L\n36#1:109,17\n73#1:126,17\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__LogicKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LogicKt", m6124f = "Logic.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {119}, m6127m = "all", m6128n = {"$this$all", "predicate", "foundCounterExample", "$this$collectWhile$iv", "collector$iv", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LogicKt$all$1 */
    public static final class C14891<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6582I$0;

        /* renamed from: L$0 */
        Object f6583L$0;

        /* renamed from: L$1 */
        Object f6584L$1;

        /* renamed from: L$2 */
        Object f6585L$2;

        /* renamed from: L$3 */
        Object f6586L$3;

        /* renamed from: L$4 */
        Object f6587L$4;

        /* renamed from: label */
        int f6588label;

        /* renamed from: result */
        /* synthetic */ Object f6589result;

        public C14891(Continuation<? super C14891> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6589result = obj;
            this.f6588label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7182all(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LogicKt", m6124f = "Logic.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {119}, m6127m = "any", m6128n = {"$this$any", "predicate", "found", "$this$collectWhile$iv", "collector$iv", "$i$f$collectWhile"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LogicKt$any$1 */
    public static final class C14901<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6590I$0;

        /* renamed from: L$0 */
        Object f6591L$0;

        /* renamed from: L$1 */
        Object f6592L$1;

        /* renamed from: L$2 */
        Object f6593L$2;

        /* renamed from: L$3 */
        Object f6594L$3;

        /* renamed from: L$4 */
        Object f6595L$4;

        /* renamed from: label */
        int f6596label;

        /* renamed from: result */
        /* synthetic */ Object f6597result;

        public C14901(Continuation<? super C14901> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6597result = obj;
            this.f6596label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7183any(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__LogicKt", m6124f = "Logic.kt", m6125i = {0, 0}, m6126l = {107}, m6127m = "none", m6128n = {"$this$none", "predicate"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__LogicKt$none$1 */
    public static final class C14911<T> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6598L$0;

        /* renamed from: L$1 */
        Object f6599L$1;

        /* renamed from: label */
        int f6600label;

        /* renamed from: result */
        /* synthetic */ Object f6601result;

        public C14911(Continuation<? super C14911> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6601result = obj;
            this.f6600label |= Integer.MIN_VALUE;
            return C1427FlowKt.m7233none(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: all */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7297all(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        C14891 c14891;
        C1235Ref.BooleanRef booleanRef;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof C14891) {
            c14891 = (C14891) continuation;
            int i = c14891.f6588label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14891.f6588label = i - Integer.MIN_VALUE;
            } else {
                c14891 = new C14891(continuation);
            }
        }
        Object obj = c14891.f6589result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14891.f6588label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.BooleanRef booleanRef2 = new C1235Ref.BooleanRef();
            FlowCollector<? super Object> flowKt__LogicKt$all$$inlined$collectWhile$1 = new FlowKt__LogicKt$all$$inlined$collectWhile$1<>(function2, booleanRef2);
            try {
                c14891.f6583L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c14891.f6584L$1 = SpillingKt.nullOutSpilledVariable(function2);
                c14891.f6585L$2 = booleanRef2;
                c14891.f6586L$3 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c14891.f6587L$4 = flowKt__LogicKt$all$$inlined$collectWhile$1;
                c14891.f6582I$0 = 0;
                c14891.f6588label = 1;
                if (interfaceC1426Flow.mo4308collect(flowKt__LogicKt$all$$inlined$collectWhile$1, c14891) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef = booleanRef2;
            } catch (AbortFlowException e2) {
                booleanRef = booleanRef2;
                e = e2;
                flowCollector = flowKt__LogicKt$all$$inlined$collectWhile$1;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c14891.get$context());
                return C1207Boxing.boxBoolean(!booleanRef.f5195element);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__LogicKt$all$$inlined$collectWhile$1) c14891.f6587L$4;
            booleanRef = (C1235Ref.BooleanRef) c14891.f6585L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c14891.get$context());
                return C1207Boxing.boxBoolean(!booleanRef.f5195element);
            }
        }
        return C1207Boxing.boxBoolean(!booleanRef.f5195element);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: any */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7298any(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        C14901 c14901;
        C1235Ref.BooleanRef booleanRef;
        AbortFlowException e;
        FlowCollector<? super Object> flowCollector;
        if (continuation instanceof C14901) {
            c14901 = (C14901) continuation;
            int i = c14901.f6596label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14901.f6596label = i - Integer.MIN_VALUE;
            } else {
                c14901 = new C14901(continuation);
            }
        }
        Object obj = c14901.f6597result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14901.f6596label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.BooleanRef booleanRef2 = new C1235Ref.BooleanRef();
            FlowCollector<? super Object> flowKt__LogicKt$any$$inlined$collectWhile$1 = new FlowKt__LogicKt$any$$inlined$collectWhile$1<>(function2, booleanRef2);
            try {
                c14901.f6591L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c14901.f6592L$1 = SpillingKt.nullOutSpilledVariable(function2);
                c14901.f6593L$2 = booleanRef2;
                c14901.f6594L$3 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
                c14901.f6595L$4 = flowKt__LogicKt$any$$inlined$collectWhile$1;
                c14901.f6590I$0 = 0;
                c14901.f6596label = 1;
                if (interfaceC1426Flow.mo4308collect(flowKt__LogicKt$any$$inlined$collectWhile$1, c14901) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                booleanRef = booleanRef2;
            } catch (AbortFlowException e2) {
                booleanRef = booleanRef2;
                e = e2;
                flowCollector = flowKt__LogicKt$any$$inlined$collectWhile$1;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c14901.get$context());
                return C1207Boxing.boxBoolean(booleanRef.f5195element);
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            flowCollector = (FlowKt__LogicKt$any$$inlined$collectWhile$1) c14901.f6595L$4;
            booleanRef = (C1235Ref.BooleanRef) c14901.f6593L$2;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (AbortFlowException e3) {
                e = e3;
                FlowExceptions_commonKt.checkOwnership(e, flowCollector);
                C1344JobKt.ensureActive(c14901.get$context());
                return C1207Boxing.boxBoolean(booleanRef.f5195element);
            }
        }
        return C1207Boxing.boxBoolean(booleanRef.f5195element);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: none */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object m7299none(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        C14911 c14911;
        if (continuation instanceof C14911) {
            c14911 = (C14911) continuation;
            int i = c14911.f6600label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14911.f6600label = i - Integer.MIN_VALUE;
            } else {
                c14911 = new C14911(continuation);
            }
        }
        Object objM7183any = c14911.f6601result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14911.f6600label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objM7183any);
            c14911.f6598L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
            c14911.f6599L$1 = SpillingKt.nullOutSpilledVariable(function2);
            c14911.f6600label = 1;
            objM7183any = C1427FlowKt.m7183any(interfaceC1426Flow, function2, c14911);
            if (objM7183any == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objM7183any);
        }
        return C1207Boxing.boxBoolean(!((Boolean) objM7183any).booleanValue());
    }
}
