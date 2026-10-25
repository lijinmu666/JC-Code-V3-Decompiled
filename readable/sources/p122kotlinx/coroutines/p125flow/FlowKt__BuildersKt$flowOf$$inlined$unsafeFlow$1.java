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
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n1#1,111:1\n119#2,4:112\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Object[] $elements$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1", m6124f = "Builders.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {113}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$flowOf_u24lambda_u240", "element", "$i$a$-unsafeFlow-FlowKt__BuildersKt$flowOf$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1$1 */
    public static final class C14371 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6189I$0;

        /* renamed from: I$1 */
        int f6190I$1;

        /* renamed from: I$2 */
        int f6191I$2;

        /* renamed from: L$0 */
        Object f6192L$0;

        /* renamed from: L$1 */
        Object f6193L$1;

        /* renamed from: L$2 */
        Object f6194L$2;

        /* renamed from: L$3 */
        Object f6195L$3;

        /* renamed from: label */
        int f6196label;

        /* renamed from: result */
        /* synthetic */ Object f6197result;

        public C14371(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6197result = obj;
            this.f6196label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1.this.mo4308collect(null, this);
        }
    }

    public FlowKt__BuildersKt$flowOf$$inlined$unsafeFlow$1(Object[] objArr) {
        this.$elements$inlined = objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.lang.Object, kotlinx.coroutines.flow.FlowCollector] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r6v6, types: [kotlin.coroutines.Continuation] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007e -> B:20:0x0083). Please report as a decompilation issue!!! */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14371 c14371;
        C14371 c143712;
        int i;
        int i2;
        FlowCollector<? super T> flowCollector2;
        C14371 c143713;
        int length;
        ?? r12;
        if (continuation instanceof C14371) {
            c14371 = (C14371) continuation;
            int i3 = c14371.f6196label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c14371.f6196label = i3 - Integer.MIN_VALUE;
            } else {
                c14371 = new C14371(continuation);
            }
        }
        Object obj = c14371.f6197result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c14371.f6196label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            c143712 = c14371;
            i = 0;
            i2 = 0;
            flowCollector2 = flowCollector;
            c143713 = c143712;
            length = this.$elements$inlined.length;
            r12 = flowCollector2;
            if (i < length) {
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = c14371.f6191I$2;
            int i5 = c14371.f6190I$1;
            int i6 = c14371.f6189I$0;
            FlowCollector flowCollector3 = (FlowCollector) c14371.f6194L$2;
            ?? r6 = (Continuation) c14371.f6193L$1;
            FlowCollector<? super T> flowCollector4 = (FlowCollector) c14371.f6192L$0;
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector5 = flowCollector3;
            int i7 = i6;
            C14371 c143714 = c14371;
            flowCollector2 = flowCollector4;
            C14371 c143715 = r6;
            int i8 = i7;
            i = i5 + 1;
            c143713 = c143714;
            c143712 = c143715;
            i2 = i8;
            r12 = flowCollector5;
            if (i < length) {
                Object obj2 = this.$elements$inlined[i];
                c143713.f6192L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                c143713.f6193L$1 = SpillingKt.nullOutSpilledVariable(c143712);
                c143713.f6194L$2 = r12;
                c143713.f6195L$3 = SpillingKt.nullOutSpilledVariable(obj2);
                c143713.f6189I$0 = i2;
                c143713.f6190I$1 = i;
                c143713.f6191I$2 = length;
                c143713.f6196label = 1;
                if (r12.mo4309emit(obj2, c143713) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                C14371 c143716 = c143712;
                c143714 = c143713;
                i5 = i;
                i7 = i2;
                c143715 = c143716;
                flowCollector5 = r12;
                int i82 = i7;
                i = i5 + 1;
                c143713 = c143714;
                c143712 = c143715;
                i2 = i82;
                r12 = flowCollector5;
                if (i < length) {
                    return C1133Unit.INSTANCE;
                }
            }
        }
    }
}
