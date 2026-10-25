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
import p094kotlin.p112ranges.IntRange;

@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,111:1\n181#2:112\n182#2,2:114\n184#2:117\n1869#3:113\n1870#3:116\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n181#1:113\n181#1:116\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9 implements InterfaceC1426Flow<Integer> {
    final /* synthetic */ IntRange $this_asFlow$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9", m6124f = "Builders.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {114}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$asFlow_u24lambda_u248", "$this$forEach$iv", "element$iv", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$9", "$i$f$forEach", "value", "$i$a$-forEach-FlowKt__BuildersKt$asFlow$9$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$5", "I$0", "I$1", "I$2", "I$3"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9$1 */
    public static final class C14361 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6176I$0;

        /* renamed from: I$1 */
        int f6177I$1;

        /* renamed from: I$2 */
        int f6178I$2;

        /* renamed from: I$3 */
        int f6179I$3;

        /* renamed from: L$0 */
        Object f6180L$0;

        /* renamed from: L$1 */
        Object f6181L$1;

        /* renamed from: L$2 */
        Object f6182L$2;

        /* renamed from: L$3 */
        Object f6183L$3;

        /* renamed from: L$4 */
        Object f6184L$4;

        /* renamed from: L$5 */
        Object f6185L$5;

        /* renamed from: label */
        int f6186label;

        /* renamed from: result */
        /* synthetic */ Object f6187result;

        public C14361(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6187result = obj;
            this.f6186label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9.this.mo4308collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$9(IntRange intRange) {
        this.$this_asFlow$inlined = intRange;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super Integer> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14361 c14361;
        Object obj;
        Iterator<Integer> it;
        C14361 c143612;
        Object obj2;
        int i;
        int i2;
        FlowCollector flowCollector2;
        FlowCollector flowCollector3;
        if (continuation instanceof C14361) {
            c14361 = (C14361) continuation;
            int i3 = c14361.f6186label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c14361.f6186label = i3 - Integer.MIN_VALUE;
            } else {
                c14361 = new C14361(continuation);
            }
        }
        Object obj3 = c14361.f6187result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c14361.f6186label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj3);
            IntRange intRange = this.$this_asFlow$inlined;
            obj = intRange;
            it = intRange.iterator();
            c143612 = c14361;
            obj2 = c143612;
            i = 0;
            i2 = 0;
            flowCollector2 = flowCollector;
            flowCollector3 = flowCollector2;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i5 = c14361.f6177I$1;
            int i6 = c14361.f6176I$0;
            Iterator<Integer> it2 = (Iterator) c14361.f6184L$4;
            Object obj4 = (Iterable) c14361.f6183L$3;
            FlowCollector flowCollector4 = (FlowCollector) c14361.f6182L$2;
            Object obj5 = (Continuation) c14361.f6181L$1;
            FlowCollector flowCollector5 = (FlowCollector) c14361.f6180L$0;
            ResultKt.throwOnFailure(obj3);
            flowCollector3 = flowCollector5;
            C14361 c143613 = c14361;
            i = i5;
            flowCollector2 = flowCollector4;
            it = it2;
            obj2 = obj5;
            obj = obj4;
            i2 = i6;
            c143612 = c143613;
        }
        while (it.hasNext()) {
            Integer next = it.next();
            int iIntValue = next.intValue();
            Integer numM6121boxInt = C1207Boxing.m6121boxInt(iIntValue);
            c143612.f6180L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
            c143612.f6181L$1 = SpillingKt.nullOutSpilledVariable(obj2);
            c143612.f6182L$2 = flowCollector2;
            c143612.f6183L$3 = SpillingKt.nullOutSpilledVariable(obj);
            c143612.f6184L$4 = it;
            c143612.f6185L$5 = SpillingKt.nullOutSpilledVariable(next);
            c143612.f6176I$0 = i2;
            c143612.f6177I$1 = i;
            c143612.f6178I$2 = iIntValue;
            c143612.f6179I$3 = 0;
            c143612.f6186label = 1;
            if (flowCollector2.mo4309emit(numM6121boxInt, c143612) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return C1133Unit.INSTANCE;
    }
}
