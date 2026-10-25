package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u001ap\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012D\b\u0004\u0010\u0000\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\u0002\b\fH\u0086\b¢\u0006\u0002\u0010\r\u001ap\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012D\b\u0004\u0010\u0000\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\u0002\b\fH\u0081\b¢\u0006\u0002\u0010\r\u001aP\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012-\u0010\u0010\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011¢\u0006\u0002\b\f¢\u0006\u0002\u0010\u0012\u001ag\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012D\u0010\u0010\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\u0002\b\f¢\u0006\u0002\u0010\r\u001aP\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00012-\u0010\u0010\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0011¢\u0006\u0002\b\f¢\u0006\u0002\u0010\u0012\u001a\u0010\u0010\u0017\u001a\u00020\n*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001ap\u0010\u0018\u001a\u00020\n\"\u0004\b\u0000\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00052D\u0010\u0010\u001a@\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004¢\u0006\u0002\b\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0082@¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, m4988d2 = {"transform", "Lkotlinx/coroutines/flow/Flow;", "R", "T", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "unsafeTransform", "onStart", "action", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "onCompletion", BuildConfig.f24315FLAVOR, "cause", "onEmpty", "ensureActive", "invokeSafely", "invokeSafely$FlowKt__EmittersKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function3;Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,216:1\n105#2:217\n105#2:218\n105#2:219\n105#2:220\n*S KotlinDebug\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt\n*L\n45#1:217\n70#1:218\n140#1:219\n175#1:220\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__EmittersKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1", m6124f = "Emitters.kt", m6125i = {0}, m6126l = {36}, m6127m = "invokeSuspend", m6128n = {"$this$flow"}, m6130s = {"L$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1\n*L\n1#1,216:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1 */
    public static final class C14741<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ InterfaceC1426Flow<T> $this_transform;
        final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super C1133Unit>, Object> $transform;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6459L$0;

        /* renamed from: label */
        int f6460label;

        @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$transform$1$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements FlowCollector {
            final /* synthetic */ FlowCollector<R> $$this$flow;
            final /* synthetic */ Function3<FlowCollector<? super R>, T, Continuation<? super C1133Unit>, Object> $transform;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3, FlowCollector<? super R> flowCollector) {
                this.$transform = function3;
                this.$$this$flow = flowCollector;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @Override // p122kotlinx.coroutines.p125flow.FlowCollector
            /* renamed from: emit */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
                FlowKt__EmittersKt$transform$1$1$emit$1 flowKt__EmittersKt$transform$1$1$emit$1;
                if (continuation instanceof FlowKt__EmittersKt$transform$1$1$emit$1) {
                    flowKt__EmittersKt$transform$1$1$emit$1 = (FlowKt__EmittersKt$transform$1$1$emit$1) continuation;
                    int i = flowKt__EmittersKt$transform$1$1$emit$1.f6462label;
                    if ((i & Integer.MIN_VALUE) != 0) {
                        flowKt__EmittersKt$transform$1$1$emit$1.f6462label = i - Integer.MIN_VALUE;
                    } else {
                        flowKt__EmittersKt$transform$1$1$emit$1 = new FlowKt__EmittersKt$transform$1$1$emit$1(this, continuation);
                    }
                }
                Object obj = flowKt__EmittersKt$transform$1$1$emit$1.f6463result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i2 = flowKt__EmittersKt$transform$1$1$emit$1.f6462label;
                if (i2 == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3<FlowCollector<? super R>, T, Continuation<? super C1133Unit>, Object> function3 = this.$transform;
                    FlowCollector<R> flowCollector = this.$$this$flow;
                    flowKt__EmittersKt$transform$1$1$emit$1.f6461L$0 = SpillingKt.nullOutSpilledVariable(t);
                    flowKt__EmittersKt$transform$1$1$emit$1.f6462label = 1;
                    if (function3.mo6219invoke(flowCollector, t, flowKt__EmittersKt$transform$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return C1133Unit.INSTANCE;
            }

            public final Object emit$$forInline(T t, Continuation<? super C1133Unit> continuation) {
                InlineMarker.m6315mark(4);
                new FlowKt__EmittersKt$transform$1$1$emit$1(this, continuation);
                InlineMarker.m6315mark(5);
                this.$transform.mo6219invoke(this.$$this$flow, t, continuation);
                return C1133Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14741(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super C14741> continuation) {
            super(2, continuation);
            this.$this_transform = interfaceC1426Flow;
            this.$transform = function3;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C14741 c14741 = new C14741(this.$this_transform, this.$transform, continuation);
            c14741.f6459L$0 = obj;
            return c14741;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6459L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6460label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC1426Flow<T> interfaceC1426Flow = this.$this_transform;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, flowCollector);
                this.f6459L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.f6460label = 1;
                if (interfaceC1426Flow.mo4308collect(anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return C1133Unit.INSTANCE;
        }

        public final Object invokeSuspend$$forInline(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6459L$0;
            InlineMarker.m6315mark(10);
            InterfaceC1426Flow<T> interfaceC1426Flow = this.$this_transform;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$transform, flowCollector);
            InlineMarker.m6315mark(0);
            interfaceC1426Flow.mo4308collect(anonymousClass1, this);
            InlineMarker.m6315mark(1);
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
            return ((C14741) mo2166create(flowCollector, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public static final void ensureActive(FlowCollector<?> flowCollector) {
        if (flowCollector instanceof ThrowingCollector) {
            throw ((ThrowingCollector) flowCollector).e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object invokeSafely$FlowKt__EmittersKt(FlowCollector<? super T> flowCollector, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super C1133Unit>, ? extends Object> function3, Throwable th, Continuation<? super C1133Unit> continuation) {
        FlowKt__EmittersKt$invokeSafely$1 flowKt__EmittersKt$invokeSafely$1;
        if (continuation instanceof FlowKt__EmittersKt$invokeSafely$1) {
            flowKt__EmittersKt$invokeSafely$1 = (FlowKt__EmittersKt$invokeSafely$1) continuation;
            int i = flowKt__EmittersKt$invokeSafely$1.f6453label;
            if ((i & Integer.MIN_VALUE) != 0) {
                flowKt__EmittersKt$invokeSafely$1.f6453label = i - Integer.MIN_VALUE;
            } else {
                flowKt__EmittersKt$invokeSafely$1 = new FlowKt__EmittersKt$invokeSafely$1(continuation);
            }
        }
        Object obj = flowKt__EmittersKt$invokeSafely$1.f6454result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = flowKt__EmittersKt$invokeSafely$1.f6453label;
        try {
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                flowKt__EmittersKt$invokeSafely$1.f6450L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                flowKt__EmittersKt$invokeSafely$1.f6451L$1 = SpillingKt.nullOutSpilledVariable(function3);
                flowKt__EmittersKt$invokeSafely$1.f6452L$2 = th;
                flowKt__EmittersKt$invokeSafely$1.f6453label = 1;
                if (function3.mo6219invoke(flowCollector, th, flowKt__EmittersKt$invokeSafely$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                th = (Throwable) flowKt__EmittersKt$invokeSafely$1.f6452L$2;
                ResultKt.throwOnFailure(obj);
            }
            return C1133Unit.INSTANCE;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                ExceptionsKt.addSuppressed(th2, th);
            }
            throw th2;
        }
    }

    public static final <T> InterfaceC1426Flow<T> onCompletion(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return new FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(interfaceC1426Flow, function3);
    }

    /* renamed from: onEmpty */
    public static final <T> InterfaceC1426Flow<T> m7288onEmpty(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return new FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(interfaceC1426Flow, function2);
    }

    /* renamed from: onStart */
    public static final <T> InterfaceC1426Flow<T> m7289onStart(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return new FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(function2, interfaceC1426Flow);
    }

    public static final <T, R> InterfaceC1426Flow<R> transform(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return C1427FlowKt.m7219flow(new C14741(interfaceC1426Flow, function3, null));
    }

    @PublishedApi
    public static final <T, R> InterfaceC1426Flow<R> unsafeTransform(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return new FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1(interfaceC1426Flow, function3);
    }
}
