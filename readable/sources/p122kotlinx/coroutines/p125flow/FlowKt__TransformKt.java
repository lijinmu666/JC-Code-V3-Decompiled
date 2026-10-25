package p122kotlinx.coroutines.p125flow;

import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.IndexedValue;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p113reflect.InterfaceC1242KClass;
import p122kotlinx.coroutines.ExperimentalCoroutinesApi;
import p122kotlinx.coroutines.p125flow.internal.NullSurrogateKt;

@Metadata(m4987d1 = {"\u0000R\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\u001aJ\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001aJ\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001a\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0006\b\u0000\u0010\u000b\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u001a,\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\b\b\u0000\u0010\u000b*\u00020\u0007*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\r\u001a\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\u001a_\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u00020\u000123\b\u0004\u0010\u0010\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001ae\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u000b*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u000125\b\u0004\u0010\u0010\u001a/\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000b0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\b¢\u0006\u0002\u0010\b\u001a\"\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00160\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aE\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0018\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00190\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\u0010\b\u001aw\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001b\u001a\u0002H\u000b2F\u0010\u001c\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d¢\u0006\u0002\u0010\u001f\u001aw\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u001b\u001a\u0002H\u000b2F\u0010\u001c\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u000b¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d¢\u0006\u0002\u0010\u001f\u001ai\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012F\u0010\u001c\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u001d¢\u0006\u0002\u0010\"\u001a,\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020$0\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010%\u001a\u00020&H\u0007¨\u0006'"}, m4988d2 = {"filter", "Lkotlinx/coroutines/flow/Flow;", "T", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "filterNot", "filterIsInstance", "R", "klass", "Lkotlin/reflect/KClass;", "filterNotNull", "map", "transform", "Lkotlin/ParameterName;", "name", "value", "mapNotNull", "withIndex", "Lkotlin/collections/IndexedValue;", "onEach", "action", BuildConfig.f24315FLAVOR, "scan", "initial", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "runningFold", "runningReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "chunked", BuildConfig.f24315FLAVOR, "size", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nTransform.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n+ 2 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 3 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 4 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,167:1\n17#1:174\n19#1:178\n17#1:179\n19#1:183\n45#2:168\n49#2:170\n45#2:171\n49#2:173\n45#2:175\n49#2:177\n45#2:180\n49#2:182\n45#2:184\n49#2:186\n45#2:187\n49#2:189\n45#2:190\n49#2:192\n45#2:194\n49#2:196\n105#3:169\n105#3:172\n105#3:176\n105#3:181\n105#3:185\n105#3:188\n105#3:191\n105#3:193\n105#3:195\n105#3:197\n105#3:198\n105#3:200\n1#4:199\n*S KotlinDebug\n*F\n+ 1 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n32#1:174\n32#1:178\n37#1:179\n37#1:183\n17#1:168\n17#1:170\n24#1:171\n24#1:173\n32#1:175\n32#1:177\n37#1:180\n37#1:182\n42#1:184\n42#1:186\n49#1:187\n49#1:189\n56#1:190\n56#1:192\n74#1:194\n74#1:196\n17#1:169\n24#1:172\n32#1:176\n37#1:181\n42#1:185\n49#1:188\n56#1:191\n64#1:193\n74#1:195\n101#1:197\n121#1:198\n152#1:200\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__TransformKt {
    @ExperimentalCoroutinesApi
    /* renamed from: chunked */
    public static final <T> InterfaceC1426Flow<List<T>> m7333chunked(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        if (i >= 1) {
            return new FlowKt__TransformKt$chunked$$inlined$unsafeFlow$1(interfaceC1426Flow, i);
        }
        throw new IllegalArgumentException(("Expected positive chunk size, but got " + i).toString());
    }

    /* renamed from: filter */
    public static final <T> InterfaceC1426Flow<T> m7334filter(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(interfaceC1426Flow, function2);
    }

    public static final /* synthetic */ <R> InterfaceC1426Flow<R> filterIsInstance(InterfaceC1426Flow<?> interfaceC1426Flow) {
        Intrinsics.needClassReification();
        return new FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(interfaceC1426Flow);
    }

    public static final <T> InterfaceC1426Flow<T> filterNot(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(interfaceC1426Flow, function2);
    }

    public static final <T> InterfaceC1426Flow<T> filterNotNull(final InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return new InterfaceC1426Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1

            @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,216:1\n43#2,2:217\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2 */
            public static final class C15292<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
                @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2", m6124f = "Transform.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {217}, m6127m = "emit", m6128n = {"value", "$completion", "value", "$this$filterNotNull_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filterNotNull$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: I$0 */
                    int f6809I$0;

                    /* renamed from: L$0 */
                    Object f6810L$0;

                    /* renamed from: L$1 */
                    Object f6811L$1;

                    /* renamed from: L$2 */
                    Object f6812L$2;

                    /* renamed from: L$3 */
                    Object f6813L$3;

                    /* renamed from: label */
                    int f6814label;

                    /* renamed from: result */
                    /* synthetic */ Object f6815result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f6815result = obj;
                        this.f6814label |= Integer.MIN_VALUE;
                        return C15292.this.mo4309emit(null, this);
                    }
                }

                public C15292(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.f6814label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f6814label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj = anonymousClass1.f6815result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.f6814label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        if (t != null) {
                            anonymousClass1.f6810L$0 = SpillingKt.nullOutSpilledVariable(t);
                            anonymousClass1.f6811L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.f6812L$2 = SpillingKt.nullOutSpilledVariable(t);
                            anonymousClass1.f6813L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.f6809I$0 = 0;
                            anonymousClass1.f6814label = 1;
                            if (flowCollector.mo4309emit(t, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    return C1133Unit.INSTANCE;
                }
            }

            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector flowCollector, Continuation continuation) {
                Object objMo4308collect = interfaceC1426Flow.mo4308collect(new C15292(flowCollector), continuation);
                return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
            }
        };
    }

    /* renamed from: map */
    public static final <T, R> InterfaceC1426Flow<R> m7335map(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(interfaceC1426Flow, function2);
    }

    public static final <T, R> InterfaceC1426Flow<R> mapNotNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(interfaceC1426Flow, function2);
    }

    /* renamed from: onEach */
    public static final <T> InterfaceC1426Flow<T> m7336onEach(final InterfaceC1426Flow<? extends T> interfaceC1426Flow, final Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return new InterfaceC1426Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,216:1\n75#2,2:217\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 */
            public static final class C15342<T> implements FlowCollector {
                final /* synthetic */ Function2 $action$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
                @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", m6124f = "Transform.kt", m6125i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, m6126l = {217, 218}, m6127m = "emit", m6128n = {"value", "$completion", "value", "$this$onEach_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$onEach$1", "value", "$completion", "value", "$this$onEach_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$onEach$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: I$0 */
                    int f6841I$0;

                    /* renamed from: L$0 */
                    Object f6842L$0;

                    /* renamed from: L$1 */
                    Object f6843L$1;

                    /* renamed from: L$2 */
                    Object f6844L$2;

                    /* renamed from: L$3 */
                    Object f6845L$3;

                    /* renamed from: label */
                    int f6846label;

                    /* renamed from: result */
                    /* synthetic */ Object f6847result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f6847result = obj;
                        this.f6846label |= Integer.MIN_VALUE;
                        return C15342.this.mo4309emit(null, this);
                    }
                }

                public C15342(FlowCollector flowCollector, Function2 function2) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$action$inlined = function2;
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
                    int i;
                    Object obj2;
                    FlowCollector flowCollector;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i2 = anonymousClass1.f6846label;
                        if ((i2 & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f6846label = i2 - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj3 = anonymousClass1.f6847result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = anonymousClass1.f6846label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj3);
                        FlowCollector flowCollector2 = this.$this_unsafeFlow;
                        Function2 function2 = this.$action$inlined;
                        anonymousClass1.f6842L$0 = SpillingKt.nullOutSpilledVariable(t);
                        anonymousClass1.f6843L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                        anonymousClass1.f6844L$2 = t;
                        anonymousClass1.f6845L$3 = flowCollector2;
                        anonymousClass1.f6841I$0 = 0;
                        anonymousClass1.f6846label = 1;
                        InlineMarker.m6315mark(6);
                        Object objMo2167invoke = function2.mo2167invoke(t, anonymousClass1);
                        InlineMarker.m6315mark(7);
                        if (objMo2167invoke == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        obj = t;
                        continuation2 = anonymousClass1;
                        i = 0;
                        obj2 = obj;
                        flowCollector = flowCollector2;
                    } else {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj3);
                            return C1133Unit.INSTANCE;
                        }
                        i = anonymousClass1.f6841I$0;
                        FlowCollector flowCollector3 = (FlowCollector) anonymousClass1.f6845L$3;
                        obj2 = anonymousClass1.f6844L$2;
                        continuation2 = (Continuation) anonymousClass1.f6843L$1;
                        obj = anonymousClass1.f6842L$0;
                        ResultKt.throwOnFailure(obj3);
                        flowCollector = flowCollector3;
                    }
                    anonymousClass1.f6842L$0 = SpillingKt.nullOutSpilledVariable(obj);
                    anonymousClass1.f6843L$1 = SpillingKt.nullOutSpilledVariable(continuation2);
                    anonymousClass1.f6844L$2 = SpillingKt.nullOutSpilledVariable(obj2);
                    anonymousClass1.f6845L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    anonymousClass1.f6841I$0 = i;
                    anonymousClass1.f6846label = 2;
                    if (flowCollector.mo4309emit(obj2, anonymousClass1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return C1133Unit.INSTANCE;
                }
            }

            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector flowCollector, Continuation continuation) {
                Object objMo4308collect = interfaceC1426Flow.mo4308collect(new C15342(flowCollector, function2), continuation);
                return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
            }
        };
    }

    public static final <T, R> InterfaceC1426Flow<R> runningFold(InterfaceC1426Flow<? extends T> interfaceC1426Flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return new FlowKt__TransformKt$runningFold$$inlined$unsafeFlow$1(r, interfaceC1426Flow, function3);
    }

    public static final <T> InterfaceC1426Flow<T> runningReduce(final InterfaceC1426Flow<? extends T> interfaceC1426Flow, final Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return new InterfaceC1426Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$$inlined$unsafeFlow$1
            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
                C1235Ref.ObjectRef objectRef = new C1235Ref.ObjectRef();
                objectRef.f5202element = (T) NullSurrogateKt.f7173NULL;
                Object objMo4308collect = interfaceC1426Flow.mo4308collect(new FlowKt__TransformKt$runningReduce$1$1(objectRef, function3, flowCollector), continuation);
                return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
            }
        };
    }

    /* renamed from: scan */
    public static final <T, R> InterfaceC1426Flow<R> m7337scan(InterfaceC1426Flow<? extends T> interfaceC1426Flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return C1427FlowKt.runningFold(interfaceC1426Flow, r, function3);
    }

    public static final <T> InterfaceC1426Flow<IndexedValue<T>> withIndex(final InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return new InterfaceC1426Flow<IndexedValue<? extends T>>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1
            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector<? super IndexedValue<? extends T>> flowCollector, Continuation<? super C1133Unit> continuation) {
                Object objMo4308collect = interfaceC1426Flow.mo4308collect(new FlowKt__TransformKt$withIndex$1$1(flowCollector, new C1235Ref.IntRef()), continuation);
                return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
            }
        };
    }

    public static final <R> InterfaceC1426Flow<R> filterIsInstance(final InterfaceC1426Flow<?> interfaceC1426Flow, final InterfaceC1242KClass<R> interfaceC1242KClass) {
        return (InterfaceC1426Flow<R>) new InterfaceC1426Flow<Object>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2

            @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1\n+ 2 Transform.kt\nkotlinx/coroutines/flow/FlowKt__TransformKt\n*L\n1#1,216:1\n18#2:217\n37#2:218\n19#2:219\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2 */
            public static final class C15262<T> implements FlowCollector {
                final /* synthetic */ InterfaceC1242KClass $klass$inlined;
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
                @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2", m6124f = "Transform.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {217}, m6127m = "emit", m6128n = {"value", "$completion", "value", "$this$filter_u24lambda_u240", "$i$a$-unsafeTransform-FlowKt__TransformKt$filter$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$filterIsInstance$$inlined$filter$2$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* renamed from: I$0 */
                    int f6790I$0;

                    /* renamed from: L$0 */
                    Object f6791L$0;

                    /* renamed from: L$1 */
                    Object f6792L$1;

                    /* renamed from: L$2 */
                    Object f6793L$2;

                    /* renamed from: L$3 */
                    Object f6794L$3;

                    /* renamed from: label */
                    int f6795label;

                    /* renamed from: result */
                    /* synthetic */ Object f6796result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f6796result = obj;
                        this.f6795label |= Integer.MIN_VALUE;
                        return C15262.this.mo4309emit(null, this);
                    }
                }

                public C15262(FlowCollector flowCollector, InterfaceC1242KClass interfaceC1242KClass) {
                    this.$this_unsafeFlow = flowCollector;
                    this.$klass$inlined = interfaceC1242KClass;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // p122kotlinx.coroutines.p125flow.FlowCollector
                /* renamed from: emit */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object mo4309emit(Object obj, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        int i = anonymousClass1.f6795label;
                        if ((i & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.f6795label = i - Integer.MIN_VALUE;
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                    }
                    Object obj2 = anonymousClass1.f6796result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i2 = anonymousClass1.f6795label;
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj2);
                        FlowCollector flowCollector = this.$this_unsafeFlow;
                        if (this.$klass$inlined.isInstance(obj)) {
                            anonymousClass1.f6791L$0 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.f6792L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                            anonymousClass1.f6793L$2 = SpillingKt.nullOutSpilledVariable(obj);
                            anonymousClass1.f6794L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                            anonymousClass1.f6790I$0 = 0;
                            anonymousClass1.f6795label = 1;
                            if (flowCollector.mo4309emit(obj, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                    }
                    return C1133Unit.INSTANCE;
                }
            }

            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector<? super Object> flowCollector, Continuation continuation) {
                Object objMo4308collect = interfaceC1426Flow.mo4308collect(new C15262(flowCollector, interfaceC1242KClass), continuation);
                return objMo4308collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objMo4308collect : C1133Unit.INSTANCE;
            }
        };
    }
}
