package p122kotlinx.coroutines.p125flow;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¨\u0006\u0004"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ShareKt$asFlow$$inlined$transform$1", m6124f = "Share.kt", m6125i = {0}, m6126l = {36}, m6127m = "invokeSuspend", m6128n = {"$this$flow"}, m6130s = {"L$0"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1\n*L\n1#1,216:1\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__ShareKt$asFlow$$inlined$transform$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ InterfaceC1426Flow $this_transform;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6729L$0;

    /* renamed from: label */
    int f6730label;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nEmitters.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Emitters.kt\nkotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1$1\n+ 2 Share.kt\nkotlinx/coroutines/flow/FlowKt__ShareKt\n*L\n1#1,38:1\n382#2:39\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$asFlow$$inlined$transform$1$1 */
    public static final class C15161<T> implements FlowCollector {
        final /* synthetic */ FlowCollector<T> $$this$flow;

        @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
        @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ShareKt$asFlow$$inlined$transform$1$1", m6124f = "Share.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {C5125EACTags.INTERCHANGE_CONTROL}, m6127m = "emit", m6128n = {"value", "$completion", "value", "$this$asFlow_u24lambda_u240", "$i$a$-transform-FlowKt__ShareKt$asFlow$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ShareKt$asFlow$$inlined$transform$1$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends ContinuationImpl {

            /* renamed from: I$0 */
            int f6731I$0;

            /* renamed from: L$0 */
            Object f6732L$0;

            /* renamed from: L$1 */
            Object f6733L$1;

            /* renamed from: L$2 */
            Object f6734L$2;

            /* renamed from: L$3 */
            Object f6735L$3;

            /* renamed from: label */
            int f6736label;

            /* renamed from: result */
            /* synthetic */ Object f6737result;

            public AnonymousClass1(Continuation continuation) {
                super(continuation);
            }

            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f6737result = obj;
                this.f6736label |= Integer.MIN_VALUE;
                return C15161.this.mo4309emit(null, this);
            }
        }

        public C15161(FlowCollector flowCollector) {
            this.$$this$flow = flowCollector;
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
                int i = anonymousClass1.f6736label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    anonymousClass1.f6736label = i - Integer.MIN_VALUE;
                } else {
                    anonymousClass1 = new AnonymousClass1(continuation);
                }
            }
            Object obj = anonymousClass1.f6737result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = anonymousClass1.f6736label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector<T> flowCollector = this.$$this$flow;
                anonymousClass1.f6732L$0 = SpillingKt.nullOutSpilledVariable(t);
                anonymousClass1.f6733L$1 = SpillingKt.nullOutSpilledVariable(anonymousClass1);
                anonymousClass1.f6734L$2 = SpillingKt.nullOutSpilledVariable(t);
                anonymousClass1.f6735L$3 = SpillingKt.nullOutSpilledVariable(flowCollector);
                anonymousClass1.f6731I$0 = 0;
                anonymousClass1.f6736label = 1;
                if (flowCollector.mo4309emit(t, anonymousClass1) == coroutine_suspended) {
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
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$asFlow$$inlined$transform$1(InterfaceC1426Flow interfaceC1426Flow, Continuation continuation) {
        super(2, continuation);
        this.$this_transform = interfaceC1426Flow;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        FlowKt__ShareKt$asFlow$$inlined$transform$1 flowKt__ShareKt$asFlow$$inlined$transform$1 = new FlowKt__ShareKt$asFlow$$inlined$transform$1(this.$this_transform, continuation);
        flowKt__ShareKt$asFlow$$inlined$transform$1.f6729L$0 = obj;
        return flowKt__ShareKt$asFlow$$inlined$transform$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.f6729L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6730label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC1426Flow interfaceC1426Flow = this.$this_transform;
            C15161 c15161 = new C15161(flowCollector);
            this.f6729L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.f6730label = 1;
            if (interfaceC1426Flow.mo4308collect(c15161, this) == coroutine_suspended) {
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

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo2167invoke(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        return ((FlowKt__ShareKt$asFlow$$inlined$transform$1) mo2166create(flowCollector, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
