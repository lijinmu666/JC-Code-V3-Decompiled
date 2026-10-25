package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 SharingStarted.kt\nkotlinx/coroutines/flow/StartedLazily\n*L\n1#1,111:1\n151#2,2:112\n*E\n"})
/* loaded from: classes.dex */
public final class StartedLazily$command$$inlined$unsafeFlow$1 implements InterfaceC1426Flow<SharingCommand> {
    final /* synthetic */ StateFlow $subscriptionCount$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1", m6124f = "SharingStarted.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {113}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$command_u24lambda_u240", "started", "$i$a$-unsafeFlow-StartedLazily$command$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.StartedLazily$command$$inlined$unsafeFlow$1$1 */
    public static final class C15541 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f7020I$0;

        /* renamed from: L$0 */
        Object f7021L$0;

        /* renamed from: L$1 */
        Object f7022L$1;

        /* renamed from: L$2 */
        Object f7023L$2;

        /* renamed from: L$3 */
        Object f7024L$3;

        /* renamed from: label */
        int f7025label;

        /* renamed from: result */
        /* synthetic */ Object f7026result;

        public C15541(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7026result = obj;
            this.f7025label |= Integer.MIN_VALUE;
            return StartedLazily$command$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public StartedLazily$command$$inlined$unsafeFlow$1(StateFlow stateFlow) {
        this.$subscriptionCount$inlined = stateFlow;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super SharingCommand> flowCollector, Continuation<? super C1133Unit> continuation) {
        C15541 c15541;
        if (continuation instanceof C15541) {
            c15541 = (C15541) continuation;
            int i = c15541.f7025label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15541.f7025label = i - Integer.MIN_VALUE;
            } else {
                c15541 = new C15541(continuation);
            }
        }
        Object obj = c15541.f7026result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15541.f7025label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            C1235Ref.BooleanRef booleanRef = new C1235Ref.BooleanRef();
            StateFlow stateFlow = this.$subscriptionCount$inlined;
            StartedLazily$command$1$1 startedLazily$command$1$1 = new StartedLazily$command$1$1(booleanRef, flowCollector);
            c15541.f7021L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c15541.f7022L$1 = SpillingKt.nullOutSpilledVariable(c15541);
            c15541.f7023L$2 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c15541.f7024L$3 = SpillingKt.nullOutSpilledVariable(booleanRef);
            c15541.f7020I$0 = 0;
            c15541.f7025label = 1;
            if (stateFlow.mo4308collect(startedLazily$command$1$1, c15541) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }
}
