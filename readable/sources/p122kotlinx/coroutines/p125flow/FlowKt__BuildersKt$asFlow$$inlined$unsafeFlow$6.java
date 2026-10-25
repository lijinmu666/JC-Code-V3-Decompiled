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
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,111:1\n150#2:112\n151#2,2:114\n153#2:117\n13805#3:113\n13806#3:116\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n150#1:113\n150#1:116\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6<T> implements InterfaceC1426Flow<T> {
    final /* synthetic */ Object[] $this_asFlow$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6", m6124f = "Builders.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {114}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$asFlow_u24lambda_u245", "$this$forEach$iv", "element$iv", "value", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$6", "$i$f$forEach", "$i$a$-forEach-FlowKt__BuildersKt$asFlow$6$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$4"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6$1 */
    public static final class C14331 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6134I$0;

        /* renamed from: I$1 */
        int f6135I$1;

        /* renamed from: I$2 */
        int f6136I$2;

        /* renamed from: I$3 */
        int f6137I$3;

        /* renamed from: I$4 */
        int f6138I$4;

        /* renamed from: L$0 */
        Object f6139L$0;

        /* renamed from: L$1 */
        Object f6140L$1;

        /* renamed from: L$2 */
        Object f6141L$2;

        /* renamed from: L$3 */
        Object f6142L$3;

        /* renamed from: L$4 */
        Object f6143L$4;

        /* renamed from: L$5 */
        Object f6144L$5;

        /* renamed from: label */
        int f6145label;

        /* renamed from: result */
        /* synthetic */ Object f6146result;

        public C14331(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6146result = obj;
            this.f6145label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6.this.mo4308collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$6(Object[] objArr) {
        this.$this_asFlow$inlined = objArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0090 -> B:19:0x0093). Please report as a decompilation issue!!! */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14331 c14331;
        Object[] objArr;
        int length;
        C14331 c143312;
        Object obj;
        int i;
        int i2;
        FlowCollector<? super T> flowCollector2;
        int i3;
        FlowCollector flowCollector3;
        if (continuation instanceof C14331) {
            c14331 = (C14331) continuation;
            int i4 = c14331.f6145label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c14331.f6145label = i4 - Integer.MIN_VALUE;
            } else {
                c14331 = new C14331(continuation);
            }
        }
        Object obj2 = c14331.f6146result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c14331.f6145label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj2);
            Object[] objArr2 = this.$this_asFlow$inlined;
            objArr = objArr2;
            length = objArr2.length;
            c143312 = c14331;
            obj = c143312;
            i = 0;
            i2 = 0;
            FlowCollector<? super T> flowCollector4 = flowCollector;
            flowCollector2 = flowCollector4;
            i3 = 0;
            flowCollector3 = flowCollector4;
            if (i3 < length) {
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = c14331.f6137I$3;
            i3 = c14331.f6136I$2;
            int i6 = c14331.f6135I$1;
            int i7 = c14331.f6134I$0;
            Object[] objArr3 = (Object[]) c14331.f6142L$3;
            FlowCollector flowCollector5 = (FlowCollector) c14331.f6141L$2;
            Object obj3 = (Continuation) c14331.f6140L$1;
            FlowCollector<? super T> flowCollector6 = (FlowCollector) c14331.f6139L$0;
            ResultKt.throwOnFailure(obj2);
            FlowCollector flowCollector7 = flowCollector5;
            i2 = i7;
            obj = obj3;
            objArr = objArr3;
            i = i6;
            c143312 = c14331;
            flowCollector2 = flowCollector6;
            i3++;
            flowCollector3 = flowCollector7;
            if (i3 < length) {
                Object obj4 = objArr[i3];
                c143312.f6139L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                c143312.f6140L$1 = SpillingKt.nullOutSpilledVariable(obj);
                c143312.f6141L$2 = flowCollector3;
                c143312.f6142L$3 = objArr;
                c143312.f6143L$4 = SpillingKt.nullOutSpilledVariable(obj4);
                c143312.f6144L$5 = SpillingKt.nullOutSpilledVariable(obj4);
                c143312.f6134I$0 = i2;
                c143312.f6135I$1 = i;
                c143312.f6136I$2 = i3;
                c143312.f6137I$3 = length;
                c143312.f6138I$4 = 0;
                c143312.f6145label = 1;
                Object objMo4309emit = flowCollector3.mo4309emit(obj4, c143312);
                flowCollector7 = flowCollector3;
                if (objMo4309emit == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i3++;
                flowCollector3 = flowCollector7;
                if (i3 < length) {
                    return C1133Unit.INSTANCE;
                }
            }
        }
    }
}
