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

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\b"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 176)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n1#1,111:1\n46#2,4:112\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__TransformKt$filter$$inlined$unsafeTransform$1<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Function2 $predicate$inlined;
    final /* synthetic */ InterfaceC1426Flow $this_unsafeTransform$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,216:1\n18#2,2:217\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2 */
    public static final class C15232<T> implements FlowCollector {
        final /* synthetic */ Function2 $predicate$inlined;
        final /* synthetic */ FlowCollector $this_unsafeFlow;

        @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
        @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2", m6124f = "Transform.kt", m6125i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m6126l = {217, 217}, m6127m = "emit", m6128n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1", "value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: I$0 */
            int f6771I$0;

            /* renamed from: L$0 */
            Object f6772L$0;

            /* renamed from: L$1 */
            Object f6773L$1;

            /* renamed from: L$2 */
            Object f6774L$2;

            /* renamed from: L$3 */
            Object f6775L$3;

            /* renamed from: label */
            int f6776label;

            /* renamed from: result */
            /* synthetic */ Object f6777result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f6777result = obj;
                this.f6776label |= Integer.MIN_VALUE;
                return C15232.this.mo4309emit(null, this);
            }
        }

        public C15232(FlowCollector flowCollector, Function2 function2) {
            this.$this_unsafeFlow = flowCollector;
            this.$predicate$inlined = function2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            AnonymousClass1 anonymousClass1;
            Object obj;
            Continuation continuation2;
            FlowCollector flowCollector;
            int i;
            Object obj2;
            if (continuation instanceof AnonymousClass1) {
                anonymousClass1 = (AnonymousClass1) continuation;
                int i2 = anonymousClass1.f6776label;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.f6776label = i2 - Integer.MIN_VALUE;
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
            }
            Object obj3 = anonymousClass1.f6777result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = anonymousClass1.f6776label;
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj3);
                FlowCollector flowCollector2 = this.$this_unsafeFlow;
                Function2 function2 = this.$predicate$inlined;
                anonymousClass1.f6772L$0 = SpillingKt.nullOutSpilledVariable(t);
                anonymousClass1.f6773L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                anonymousClass1.f6774L$2 = t;
                anonymousClass1.f6775L$3 = flowCollector2;
                anonymousClass1.f6771I$0 = 0;
                anonymousClass1.f6776label = 1;
                Object objMo2167invoke = function2.mo2167invoke(t, anonymousClass1);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = t;
                continuation2 = anonymousClass1;
                flowCollector = flowCollector2;
                obj3 = objMo2167invoke;
                i = 0;
                obj2 = obj;
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj3);
                    return C1133Unit.INSTANCE;
                }
                i = anonymousClass1.f6771I$0;
                FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.f6775L$3;
                obj2 = anonymousClass1.f6774L$2;
                continuation2 = (Continuation) anonymousClass1.f6773L$1;
                obj = anonymousClass1.f6772L$0;
                ResultKt.throwOnFailure(obj3);
                flowCollector = flowCollector3;
            }
            if (((Boolean) obj3).booleanValue()) {
                anonymousClass1.f6772L$0 = SpillingKt.nullOutSpilledVariable(obj);
                anonymousClass1.f6773L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                anonymousClass1.f6774L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                anonymousClass1.f6775L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                anonymousClass1.f6771I$0 = i;
                anonymousClass1.f6776label = 2;
                if (flowCollector.mo4309emit(obj2, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return C1133Unit.INSTANCE;
        }

        public final Object emit$$forInline(Object obj, Continuation continuation) {
            InlineMarker.m6315mark(4);
            new AnonymousClass1(continuation);
            InlineMarker.m6315mark(5);
            FlowCollector flowCollector = this.$this_unsafeFlow;
            if (((Boolean) this.$predicate$inlined.mo2167invoke(obj, continuation)).booleanValue()) {
                InlineMarker.m6315mark(0);
                flowCollector.mo4309emit(obj, continuation);
                InlineMarker.m6315mark(1);
            }
            return C1133Unit.INSTANCE;
        }
    }

    public FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(InterfaceC1426Flow interfaceC1426Flow, Function2 function2) {
        this.$this_unsafeTransform$inlined = interfaceC1426Flow;
        this.$predicate$inlined = function2;
    }

    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    public Object mo4308collect(FlowCollector flowCollector, Continuation continuation) {
        Object objMo4308collect = this.$this_unsafeTransform$inlined.mo4308collect(new C15232(flowCollector, this.$predicate$inlined), continuation);
        return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
    }

    public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
        InlineMarker.m6315mark(4);
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.1

            /* renamed from: label */
            int f6768label;

            /* renamed from: result */
            /* synthetic */ Object f6769result;

            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f6769result = obj;
                this.f6768label |= Integer.MIN_VALUE;
                return FlowKt__TransformKt$filter$$inlined$unsafeTransform$1.this.mo4308collect(null, this);
            }
        };
        InlineMarker.m6315mark(5);
        InterfaceC1426Flow interfaceC1426Flow = this.$this_unsafeTransform$inlined;
        C15232 c15232 = new C15232(flowCollector, this.$predicate$inlined);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c15232, continuation);
        InlineMarker.m6315mark(1);
        return C1133Unit.INSTANCE;
    }
}
