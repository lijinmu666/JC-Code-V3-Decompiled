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
import p122kotlinx.coroutines.ExperimentalCoroutinesApi;
import p122kotlinx.coroutines.p125flow.internal.SafeCollector;

@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001c\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0086@¢\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH¦@¢\u0006\u0002\u0010\n¨\u0006\f"}, m4988d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "<init>", "()V", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@ExperimentalCoroutinesApi
/* loaded from: classes.dex */
public abstract class AbstractFlow<T> implements InterfaceC1426Flow<T>, CancellableFlow<T> {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.AbstractFlow", m6124f = "Flow.kt", m6125i = {0, 0}, m6126l = {226}, m6127m = "collect", m6128n = {"collector", "safeCollector"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.AbstractFlow$collect$1 */
    public static final class C14221 extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6050L$0;

        /* renamed from: L$1 */
        Object f6051L$1;

        /* renamed from: label */
        int f6052label;

        /* renamed from: result */
        /* synthetic */ Object f6053result;

        /* renamed from: this$0 */
        final /* synthetic */ AbstractFlow<T> f6054this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14221(AbstractFlow<T> abstractFlow, Continuation<? super C14221> continuation) {
            super(continuation);
            this.f6054this$0 = abstractFlow;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6053result = obj;
            this.f6052label |= Integer.MIN_VALUE;
            return this.f6054this$0.mo4308collect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) throws Throwable {
        C14221 c14221;
        SafeCollector safeCollector;
        if (continuation instanceof C14221) {
            c14221 = (C14221) continuation;
            int i = c14221.f6052label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14221.f6052label = i - Integer.MIN_VALUE;
            } else {
                c14221 = new C14221(this, continuation);
            }
        }
        Object obj = c14221.f6053result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14221.f6052label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            safeCollector = (SafeCollector) c14221.f6051L$1;
            try {
                ResultKt.throwOnFailure(obj);
                safeCollector.releaseIntercepted();
                return C1133Unit.INSTANCE;
            } catch (Throwable th) {
                th = th;
                safeCollector.releaseIntercepted();
                throw th;
            }
        }
        ResultKt.throwOnFailure(obj);
        SafeCollector safeCollector2 = new SafeCollector(flowCollector, c14221.getContext());
        try {
            c14221.f6050L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            c14221.f6051L$1 = safeCollector2;
            c14221.f6052label = 1;
            if (collectSafely(safeCollector2, c14221) == coroutine_suspended) {
                return coroutine_suspended;
            }
            safeCollector = safeCollector2;
            safeCollector.releaseIntercepted();
            return C1133Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            safeCollector = safeCollector2;
            safeCollector.releaseIntercepted();
            throw th;
        }
    }

    public abstract Object collectSafely(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation);
}
