package p122kotlinx.coroutines.p125flow;

import java.util.Iterator;
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
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 Iterators.kt\nkotlin/collections/CollectionsKt__IteratorsKt\n*L\n1#1,111:1\n95#2:112\n96#2,2:114\n98#2:117\n32#3:113\n33#3:116\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n95#1:113\n95#1:116\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Iterator $this_asFlow$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4", m6124f = "Builders.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {114}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$asFlow_u24lambda_u243", "$this$forEach$iv", "element$iv", "value", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$4", "$i$f$forEach", "$i$a$-forEach-FlowKt__BuildersKt$asFlow$4$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "I$0", "I$1", "I$2"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4$1 */
    public static final class C14311 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6108I$0;

        /* renamed from: I$1 */
        int f6109I$1;

        /* renamed from: I$2 */
        int f6110I$2;

        /* renamed from: L$0 */
        Object f6111L$0;

        /* renamed from: L$1 */
        Object f6112L$1;

        /* renamed from: L$2 */
        Object f6113L$2;

        /* renamed from: L$3 */
        Object f6114L$3;

        /* renamed from: L$4 */
        Object f6115L$4;

        /* renamed from: L$5 */
        Object f6116L$5;

        /* renamed from: L$6 */
        Object f6117L$6;

        /* renamed from: label */
        int f6118label;

        /* renamed from: result */
        /* synthetic */ Object f6119result;

        public C14311(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6119result = obj;
            this.f6118label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4.this.mo4308collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$4(Iterator it) {
        this.$this_asFlow$inlined = it;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14311 c14311;
        Iterator it;
        Iterator it2;
        FlowCollector<? super T> flowCollector2;
        C14311 c143112;
        Object obj;
        int i;
        int i2;
        if (continuation instanceof C14311) {
            c14311 = (C14311) continuation;
            int i3 = c14311.f6118label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c14311.f6118label = i3 - Integer.MIN_VALUE;
            } else {
                c14311 = new C14311(continuation);
            }
        }
        Object obj2 = c14311.f6119result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = c14311.f6118label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj2);
            it = this.$this_asFlow$inlined;
            it2 = it;
            flowCollector2 = flowCollector;
            c143112 = c14311;
            obj = c143112;
            i = 0;
            i2 = 0;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = c14311.f6109I$1;
            int i5 = c14311.f6108I$0;
            Iterator it3 = (Iterator) c14311.f6115L$4;
            Iterator it4 = (Iterator) c14311.f6114L$3;
            FlowCollector<? super T> flowCollector3 = (FlowCollector) c14311.f6113L$2;
            Object obj3 = (Continuation) c14311.f6112L$1;
            FlowCollector<? super T> flowCollector4 = (FlowCollector) c14311.f6111L$0;
            ResultKt.throwOnFailure(obj2);
            flowCollector2 = flowCollector4;
            C14311 c143113 = c14311;
            i2 = i5;
            flowCollector = flowCollector3;
            it = it3;
            c143112 = c143113;
            it2 = it4;
            obj = obj3;
        }
        while (it.hasNext()) {
            Object next = it.next();
            c143112.f6111L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
            c143112.f6112L$1 = SpillingKt.nullOutSpilledVariable(obj);
            c143112.f6113L$2 = flowCollector;
            c143112.f6114L$3 = SpillingKt.nullOutSpilledVariable(it2);
            c143112.f6115L$4 = it;
            c143112.f6116L$5 = SpillingKt.nullOutSpilledVariable(next);
            c143112.f6117L$6 = SpillingKt.nullOutSpilledVariable(next);
            c143112.f6108I$0 = i2;
            c143112.f6109I$1 = i;
            c143112.f6110I$2 = 0;
            c143112.f6118label = 1;
            if (flowCollector.mo4309emit(next, c143112) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return C1133Unit.INSTANCE;
    }
}
