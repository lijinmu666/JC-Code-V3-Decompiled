package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.ArraysKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.ExperimentalCoroutinesApi;
import p122kotlinx.coroutines.FlowPreview;
import p122kotlinx.coroutines.internal.SystemPropsKt;
import p122kotlinx.coroutines.p125flow.internal.ChannelFlowMerge;
import p122kotlinx.coroutines.p125flow.internal.ChannelFlowTransformLatest;
import p122kotlinx.coroutines.p125flow.internal.ChannelLimitedFlowMerge;

@Metadata(m4987d1 = {"\u0000T\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ab\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n27\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001al\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u000527\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eH\u0007¢\u0006\u0002\u0010\u0017\u001a$\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\nH\u0007\u001a\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\u001a\u001a7\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f2\u001e\u0010\u001b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\u001c\"\b\u0012\u0004\u0012\u0002H\f0\n¢\u0006\u0002\u0010\u001d\u001a.\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\f0\n\"\u0004\b\u0000\u0010\f*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\n0\n2\b\b\u0002\u0010\u0016\u001a\u00020\u0005H\u0007\u001am\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n2B\u0010\r\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0!\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\"0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130 ¢\u0006\u0002\b#H\u0007¢\u0006\u0002\u0010$\u001ae\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n29\b\u0004\u0010\r\u001a3\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\n0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eH\u0087\b¢\u0006\u0002\u0010\u0014\u001a\\\u0010&\u001a\b\u0012\u0004\u0012\u0002H\u000b0\n\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\f0\n21\u0010\r\u001a-\b\u0001\u0012\u0013\u0012\u0011H\f¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u000eH\u0007¢\u0006\u0002\u0010\u0014\"\u0016\u0010\u0000\u001a\u00020\u00018\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006'"}, m4988d2 = {"DEFAULT_CONCURRENCY_PROPERTY_NAME", BuildConfig.f24315FLAVOR, "getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations", "()V", "DEFAULT_CONCURRENCY", BuildConfig.f24315FLAVOR, "getDEFAULT_CONCURRENCY$annotations", "getDEFAULT_CONCURRENCY", "()I", "flatMapConcat", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "transform", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatMapMerge", "concurrency", "(Lkotlinx/coroutines/flow/Flow;ILkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flattenConcat", "merge", BuildConfig.f24315FLAVOR, "flows", BuildConfig.f24315FLAVOR, "([Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "flattenMerge", "transformLatest", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "flatMapLatest", "mapLatest", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 3 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 4 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 5 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,214:1\n49#2:215\n51#2:219\n49#2:220\n51#2:224\n45#3:216\n49#3:218\n45#3:221\n49#3:223\n105#4:217\n105#4:222\n105#4:225\n1#5:226\n*S KotlinDebug\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n43#1:215\n43#1:219\n70#1:220\n70#1:224\n43#1:216\n43#1:218\n70#1:221\n70#1:223\n43#1:217\n70#1:222\n78#1:225\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__MergeKt {
    private static final int DEFAULT_CONCURRENCY = SystemPropsKt.systemProp(C1427FlowKt.DEFAULT_CONCURRENCY_PROPERTY_NAME, 16, 1, Integer.MAX_VALUE);

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", m6124f = "Merge.kt", m6125i = {0, 0, 1, 1}, m6126l = {189, 189}, m6127m = "invokeSuspend", m6128n = {"$this$transformLatest", "it", "$this$transformLatest", "it"}, m6130s = {"L$0", "L$1", "L$0", "L$1"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nMerge.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1\n*L\n1#1,214:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1 */
    public static final class C14941<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super InterfaceC1426Flow<? extends R>>, Object> $transform;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6620L$0;

        /* renamed from: L$1 */
        /* synthetic */ Object f6621L$1;

        /* renamed from: L$2 */
        Object f6622L$2;

        /* renamed from: label */
        int f6623label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14941(Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2, Continuation<? super C14941> continuation) {
            super(3, continuation);
            this.$transform = function2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo6219invoke(Object obj, Object obj2, Continuation<? super C1133Unit> continuation) {
            return m7302invoke((FlowCollector) obj, (FlowCollector<? super R>) obj2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            FlowCollector flowCollector2 = (FlowCollector) this.f6620L$0;
            Object obj2 = this.f6621L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6623label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2<T, Continuation<? super InterfaceC1426Flow<? extends R>>, Object> function2 = this.$transform;
                this.f6620L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                this.f6621L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                this.f6622L$2 = flowCollector2;
                this.f6623label = 1;
                obj = function2.mo2167invoke(obj2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector2;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return C1133Unit.INSTANCE;
                }
                flowCollector = (FlowCollector) this.f6622L$2;
                ResultKt.throwOnFailure(obj);
            }
            this.f6620L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            this.f6621L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.f6622L$2 = null;
            this.f6623label = 2;
            if (C1427FlowKt.m7213emitAll(flowCollector, (InterfaceC1426Flow) obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return C1133Unit.INSTANCE;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6620L$0;
            InlineMarker.m6315mark(10);
            Object obj2 = this.f6621L$1;
            InlineMarker.m6315mark(10);
            InterfaceC1426Flow interfaceC1426Flow = (InterfaceC1426Flow) this.$transform.mo2167invoke(obj2, this);
            InlineMarker.m6315mark(0);
            C1427FlowKt.m7213emitAll(flowCollector, interfaceC1426Flow, this);
            InlineMarker.m6315mark(1);
            return C1133Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final Object m7302invoke(FlowCollector<? super R> flowCollector, T t, Continuation<? super C1133Unit> continuation) {
            C14941 c14941 = new C14941(this.$transform, continuation);
            c14941.f6620L$0 = flowCollector;
            c14941.f6621L$1 = t;
            return c14941.invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, T] */
    @Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", m6124f = "Merge.kt", m6125i = {0, 0, 1, 1}, m6126l = {213, 213}, m6127m = "invokeSuspend", m6128n = {"$this$transformLatest", "it", "$this$transformLatest", "it"}, m6130s = {"L$0", "L$1", "L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1 */
    public static final class C14951<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Function2<T, Continuation<? super R>, Object> $transform;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6628L$0;

        /* renamed from: L$1 */
        /* synthetic */ Object f6629L$1;

        /* renamed from: L$2 */
        Object f6630L$2;

        /* renamed from: label */
        int f6631label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14951(Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super C14951> continuation) {
            super(3, continuation);
            this.$transform = function2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo6219invoke(Object obj, Object obj2, Continuation<? super C1133Unit> continuation) {
            return m7304invoke((FlowCollector) obj, (FlowCollector<? super R>) obj2, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector;
            FlowCollector flowCollector2 = (FlowCollector) this.f6628L$0;
            Object obj2 = this.f6629L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6631label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function2<T, Continuation<? super R>, Object> function2 = this.$transform;
                this.f6628L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                this.f6629L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                this.f6630L$2 = flowCollector2;
                this.f6631label = 1;
                obj = function2.mo2167invoke(obj2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                flowCollector = flowCollector2;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return C1133Unit.INSTANCE;
                }
                FlowCollector flowCollector3 = (FlowCollector) this.f6630L$2;
                ResultKt.throwOnFailure(obj);
                flowCollector = flowCollector3;
            }
            this.f6628L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            this.f6629L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            this.f6630L$2 = null;
            this.f6631label = 2;
            if (flowCollector.mo4309emit(obj, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return C1133Unit.INSTANCE;
        }

        /* renamed from: invoke */
        public final Object m7304invoke(FlowCollector<? super R> flowCollector, T t, Continuation<? super C1133Unit> continuation) {
            C14951 c14951 = new C14951(this.$transform, continuation);
            c14951.f6628L$0 = flowCollector;
            c14951.f6629L$1 = t;
            return c14951.invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> flatMapConcat(final InterfaceC1426Flow<? extends T> interfaceC1426Flow, final Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        return C1427FlowKt.flattenConcat(new InterfaceC1426Flow<InterfaceC1426Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1

            @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,216:1\n50#2:217\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2 */
            public static final class C14922<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Function2 $transform$inlined;

                @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
                @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2", m6124f = "Merge.kt", m6125i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m6126l = {217, 217}, m6127m = "emit", m6128n = {"value", "$completion", "value", "$this$map_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "value", "$completion", "value", "$this$map_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapConcat$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: I$0 */
                    int f6602I$0;

                    /* renamed from: L$0 */
                    Object f6603L$0;

                    /* renamed from: L$1 */
                    Object f6604L$1;

                    /* renamed from: L$2 */
                    Object f6605L$2;

                    /* renamed from: L$3 */
                    Object f6606L$3;

                    /* renamed from: L$4 */
                    Object f6607L$4;

                    /* renamed from: label */
                    int f6608label;

                    /* renamed from: result */
                    /* synthetic */ Object f6609result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f6609result = obj;
                        this.f6608label |= Integer.MIN_VALUE;
                        return C14922.this.mo4309emit(null, this);
                    }
                }

                public C14922(FlowCollector flowCollector, Function2 function2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform$inlined = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object mo4309emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object obj2;
                    Object obj3;
                    AnonymousClass1 anonymousClass12;
                    int i;
                    FlowCollector flowCollector;
                    FlowCollector flowCollector2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.f6608label;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f6608label = i2 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj4 = anonymousClass1.f6609result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = anonymousClass1.f6608label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj4);
                        FlowCollector flowCollector3 = this.$this_unsafeFlow;
                        Function2 function2 = this.$transform$inlined;
                        anonymousClass1.f6603L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.f6604L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.f6605L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.f6606L$3 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                        anonymousClass1.f6607L$4 = flowCollector3;
                        anonymousClass1.f6602I$0 = 0;
                        anonymousClass1.f6608label = 1;
                        Object objMo2167invoke = function2.mo2167invoke(obj, anonymousClass1);
                        if (objMo2167invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = obj;
                        obj3 = obj2;
                        FlowCollector flowCollector4 = flowCollector3;
                        anonymousClass12 = anonymousClass1;
                        obj4 = objMo2167invoke;
                        i = 0;
                        flowCollector = flowCollector4;
                        flowCollector2 = flowCollector4;
                    } else {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj4);
                            return C1133Unit.INSTANCE;
                        }
                        i = anonymousClass1.f6602I$0;
                        FlowCollector flowCollector5 = (FlowCollector) anonymousClass1.f6607L$4;
                        flowCollector = (FlowCollector) anonymousClass1.f6606L$3;
                        obj2 = anonymousClass1.f6605L$2;
                        anonymousClass12 = (AnonymousClass1) anonymousClass1.f6604L$1;
                        obj3 = anonymousClass1.f6603L$0;
                        ResultKt.throwOnFailure(obj4);
                        flowCollector2 = flowCollector5;
                    }
                    anonymousClass1.f6603L$0 = SpillingKt.nullOutSpilledVariable(obj3);
                    anonymousClass1.f6604L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                    anonymousClass1.f6605L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                    anonymousClass1.f6606L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    anonymousClass1.f6607L$4 = null;
                    anonymousClass1.f6602I$0 = i;
                    anonymousClass1.f6608label = 2;
                    if (flowCollector2.mo4309emit(obj4, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return C1133Unit.INSTANCE;
                }
            }

            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector flowCollector, Continuation continuation) {
                Object objMo4308collect = interfaceC1426Flow.mo4308collect(new C14922(flowCollector, function2), continuation);
                return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
            }
        });
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> flatMapLatest(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        return C1427FlowKt.transformLatest(interfaceC1426Flow, new C14941(function2, null));
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> flatMapMerge(final InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i, final Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        return C1427FlowKt.flattenMerge(new InterfaceC1426Flow<InterfaceC1426Flow<? extends R>>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1

            @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,216:1\n50#2:217\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2 */
            public static final class C14932<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;
                final /* synthetic */ Function2 $transform$inlined;

                @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
                @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2", m6124f = "Merge.kt", m6125i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m6126l = {217, 217}, m6127m = "emit", m6128n = {"value", "$completion", "value", "$this$map_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1", "value", "$completion", "value", "$this$map_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
                /* renamed from: kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapMerge$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: I$0 */
                    int f6611I$0;

                    /* renamed from: L$0 */
                    Object f6612L$0;

                    /* renamed from: L$1 */
                    Object f6613L$1;

                    /* renamed from: L$2 */
                    Object f6614L$2;

                    /* renamed from: L$3 */
                    Object f6615L$3;

                    /* renamed from: L$4 */
                    Object f6616L$4;

                    /* renamed from: label */
                    int f6617label;

                    /* renamed from: result */
                    /* synthetic */ Object f6618result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f6618result = obj;
                        this.f6617label |= Integer.MIN_VALUE;
                        return C14932.this.mo4309emit(null, this);
                    }
                }

                public C14932(FlowCollector flowCollector, Function2 function2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$transform$inlined = function2;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object mo4309emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    Object obj2;
                    Object obj3;
                    AnonymousClass1 anonymousClass12;
                    int i;
                    FlowCollector flowCollector;
                    FlowCollector flowCollector2;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.f6617label;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f6617label = i2 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj4 = anonymousClass1.f6618result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = anonymousClass1.f6617label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj4);
                        FlowCollector flowCollector3 = this.$this_unsafeFlow;
                        Function2 function2 = this.$transform$inlined;
                        anonymousClass1.f6612L$0 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.f6613L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.f6614L$2 = SpillingKt.nullOutSpilledVariable(obj);
                        anonymousClass1.f6615L$3 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                        anonymousClass1.f6616L$4 = flowCollector3;
                        anonymousClass1.f6611I$0 = 0;
                        anonymousClass1.f6617label = 1;
                        Object objMo2167invoke = function2.mo2167invoke(obj, anonymousClass1);
                        if (objMo2167invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj2 = obj;
                        obj3 = obj2;
                        FlowCollector flowCollector4 = flowCollector3;
                        anonymousClass12 = anonymousClass1;
                        obj4 = objMo2167invoke;
                        i = 0;
                        flowCollector = flowCollector4;
                        flowCollector2 = flowCollector4;
                    } else {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj4);
                            return C1133Unit.INSTANCE;
                        }
                        i = anonymousClass1.f6611I$0;
                        FlowCollector flowCollector5 = (FlowCollector) anonymousClass1.f6616L$4;
                        flowCollector = (FlowCollector) anonymousClass1.f6615L$3;
                        obj2 = anonymousClass1.f6614L$2;
                        anonymousClass12 = (AnonymousClass1) anonymousClass1.f6613L$1;
                        obj3 = anonymousClass1.f6612L$0;
                        ResultKt.throwOnFailure(obj4);
                        flowCollector2 = flowCollector5;
                    }
                    anonymousClass1.f6612L$0 = SpillingKt.nullOutSpilledVariable(obj3);
                    anonymousClass1.f6613L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass12);
                    anonymousClass1.f6614L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                    anonymousClass1.f6615L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    anonymousClass1.f6616L$4 = null;
                    anonymousClass1.f6611I$0 = i;
                    anonymousClass1.f6617label = 2;
                    if (flowCollector2.mo4309emit(obj4, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return C1133Unit.INSTANCE;
                }
            }

            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector flowCollector, Continuation continuation) {
                Object objMo4308collect = interfaceC1426Flow.mo4308collect(new C14932(flowCollector, function2), continuation);
                return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
            }
        }, i);
    }

    public static /* synthetic */ InterfaceC1426Flow flatMapMerge$default(InterfaceC1426Flow interfaceC1426Flow, int i, Function2 function2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = DEFAULT_CONCURRENCY;
        }
        return C1427FlowKt.flatMapMerge(interfaceC1426Flow, i, function2);
    }

    @ExperimentalCoroutinesApi
    public static final <T> InterfaceC1426Flow<T> flattenConcat(final InterfaceC1426Flow<? extends InterfaceC1426Flow<? extends T>> interfaceC1426Flow) {
        return new InterfaceC1426Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__MergeKt$flattenConcat$$inlined$unsafeFlow$1
            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
                Object objMo4308collect = interfaceC1426Flow.mo4308collect(new FlowKt__MergeKt$flattenConcat$1$1(flowCollector), continuation);
                return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
            }
        };
    }

    @ExperimentalCoroutinesApi
    public static final <T> InterfaceC1426Flow<T> flattenMerge(InterfaceC1426Flow<? extends InterfaceC1426Flow<? extends T>> interfaceC1426Flow, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(("Expected positive concurrency level, but had " + i).toString());
        }
        if (i == 1) {
            return C1427FlowKt.flattenConcat(interfaceC1426Flow);
        }
        return new ChannelFlowMerge(interfaceC1426Flow, i, null, 0, null, 28, null);
    }

    public static /* synthetic */ InterfaceC1426Flow flattenMerge$default(InterfaceC1426Flow interfaceC1426Flow, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = DEFAULT_CONCURRENCY;
        }
        return C1427FlowKt.flattenMerge(interfaceC1426Flow, i);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return DEFAULT_CONCURRENCY;
    }

    @FlowPreview
    public static /* synthetic */ void getDEFAULT_CONCURRENCY$annotations() {
    }

    @FlowPreview
    public static /* synthetic */ void getDEFAULT_CONCURRENCY_PROPERTY_NAME$annotations() {
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> mapLatest(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return C1427FlowKt.transformLatest(interfaceC1426Flow, new C14951(function2, null));
    }

    /* renamed from: merge */
    public static final <T> InterfaceC1426Flow<T> m7300merge(Iterable<? extends InterfaceC1426Flow<? extends T>> iterable) {
        return new ChannelLimitedFlowMerge(iterable, null, 0, null, 14, null);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> transformLatest(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return new ChannelFlowTransformLatest(function3, interfaceC1426Flow, null, 0, null, 28, null);
    }

    /* renamed from: merge */
    public static final <T> InterfaceC1426Flow<T> m7301merge(InterfaceC1426Flow<? extends T>... interfaceC1426FlowArr) {
        return C1427FlowKt.m7229merge(ArraysKt.asIterable(interfaceC1426FlowArr));
    }
}
