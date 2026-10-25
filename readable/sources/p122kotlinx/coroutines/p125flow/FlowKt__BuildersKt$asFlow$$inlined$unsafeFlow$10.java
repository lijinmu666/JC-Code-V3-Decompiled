package p122kotlinx.coroutines.p125flow;

import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p112ranges.LongRange;

@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n190#2:112\n191#2,2:114\n193#2:117\n1869#3:113\n1870#3:116\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n190#1:113\n190#1:116\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10 implements InterfaceC1426Flow<Long> {
    final /* synthetic */ LongRange $this_asFlow$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10", m6124f = "Builders.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {114}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$asFlow_u24lambda_u249", "$this$forEach$iv", "element$iv", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$10", "$i$f$forEach", "value", "$i$a$-forEach-FlowKt__BuildersKt$asFlow$10$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$5", "I$0", "I$1", "J$0", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10$1 */
    public static final class C14281 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6074I$0;

        /* renamed from: I$1 */
        int f6075I$1;

        /* renamed from: I$2 */
        int f6076I$2;

        /* renamed from: J$0 */
        long f6077J$0;

        /* renamed from: L$0 */
        Object f6078L$0;

        /* renamed from: L$1 */
        Object f6079L$1;

        /* renamed from: L$2 */
        Object f6080L$2;

        /* renamed from: L$3 */
        Object f6081L$3;

        /* renamed from: L$4 */
        Object f6082L$4;

        /* renamed from: L$5 */
        Object f6083L$5;

        /* renamed from: label */
        int f6084label;

        /* renamed from: result */
        /* synthetic */ Object f6085result;

        public C14281(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6085result = obj;
            this.f6084label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10.this.mo4308collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$10(LongRange longRange) {
        this.$this_asFlow$inlined = longRange;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super Long> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14281 c14281;
        Object obj;
        Iterator<Long> it;
        C14281 c142812;
        Object obj2;
        int i;
        int i2;
        FlowCollector flowCollector2;
        FlowCollector flowCollector3;
        if (continuation instanceof C14281) {
            c14281 = (C14281) continuation;
            int i3 = c14281.f6084label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c14281.f6084label = i3 - Integer.MIN_VALUE;
            } else {
                c14281 = new C14281(continuation);
            }
        }
        Object obj3 = c14281.f6085result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c14281.f6084label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj3);
            LongRange longRange = this.$this_asFlow$inlined;
            obj = longRange;
            it = longRange.iterator();
            c142812 = c14281;
            obj2 = c142812;
            i = 0;
            i2 = 0;
            flowCollector2 = flowCollector;
            flowCollector3 = flowCollector2;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i5 = c14281.f6075I$1;
            int i6 = c14281.f6074I$0;
            Iterator<Long> it2 = (Iterator) c14281.f6082L$4;
            Object obj4 = (Iterable) c14281.f6081L$3;
            FlowCollector flowCollector4 = (FlowCollector) c14281.f6080L$2;
            Object obj5 = (Continuation) c14281.f6079L$1;
            FlowCollector flowCollector5 = (FlowCollector) c14281.f6078L$0;
            ResultKt.throwOnFailure(obj3);
            flowCollector3 = flowCollector5;
            C14281 c142813 = c14281;
            i = i5;
            flowCollector2 = flowCollector4;
            it = it2;
            obj2 = obj5;
            obj = obj4;
            i2 = i6;
            c142812 = c142813;
        }
        while (it.hasNext()) {
            Long next = it.next();
            long jLongValue = next.longValue();
            Long lM6122boxLong = C1207Boxing.m6122boxLong(jLongValue);
            c142812.f6078L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
            c142812.f6079L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            c142812.f6080L$2 = flowCollector2;
            c142812.f6081L$3 = SpillingKt.nullOutSpilledVariable(obj);
            c142812.f6082L$4 = it;
            c142812.f6083L$5 = SpillingKt.nullOutSpilledVariable(next);
            c142812.f6074I$0 = i2;
            c142812.f6075I$1 = i;
            c142812.f6077J$0 = jLongValue;
            c142812.f6076I$2 = 0;
            c142812.f6084label = 1;
            if (flowCollector2.mo4309emit(lM6122boxLong, c142812) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return C1133Unit.INSTANCE;
    }
}
