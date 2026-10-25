package p122kotlinx.coroutines.p125flow;

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

@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,111:1\n161#2:112\n162#2,2:114\n164#2:117\n13826#3:113\n13827#3:116\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n161#1:113\n161#1:116\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7 implements InterfaceC1426Flow<Integer> {
    final /* synthetic */ int[] $this_asFlow$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7", m6124f = "Builders.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {114}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$asFlow_u24lambda_u246", "$this$forEach$iv", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$7", "$i$f$forEach", "element$iv", "value", "$i$a$-forEach-FlowKt__BuildersKt$asFlow$7$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$4", "I$5", "I$6"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7$1 */
    public static final class C14341 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6148I$0;

        /* renamed from: I$1 */
        int f6149I$1;

        /* renamed from: I$2 */
        int f6150I$2;

        /* renamed from: I$3 */
        int f6151I$3;

        /* renamed from: I$4 */
        int f6152I$4;

        /* renamed from: I$5 */
        int f6153I$5;

        /* renamed from: I$6 */
        int f6154I$6;

        /* renamed from: L$0 */
        Object f6155L$0;

        /* renamed from: L$1 */
        Object f6156L$1;

        /* renamed from: L$2 */
        Object f6157L$2;

        /* renamed from: L$3 */
        Object f6158L$3;

        /* renamed from: label */
        int f6159label;

        /* renamed from: result */
        /* synthetic */ Object f6160result;

        public C14341(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6160result = obj;
            this.f6159label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7.this.mo4308collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$7(int[] iArr) {
        this.$this_asFlow$inlined = iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x008c -> B:19:0x008f). Please report as a decompilation issue!!! */
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo4308collect(FlowCollector<? super Integer> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14341 c14341;
        int[] iArr;
        int length;
        C14341 c143412;
        Object obj;
        int i;
        int i2;
        FlowCollector flowCollector2;
        FlowCollector flowCollector3;
        int i3;
        if (continuation instanceof C14341) {
            c14341 = (C14341) continuation;
            int i4 = c14341.f6159label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c14341.f6159label = i4 - Integer.MIN_VALUE;
            } else {
                c14341 = new C14341(continuation);
            }
        }
        Object obj2 = c14341.f6160result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c14341.f6159label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj2);
            int[] iArr2 = this.$this_asFlow$inlined;
            iArr = iArr2;
            length = iArr2.length;
            c143412 = c14341;
            obj = c143412;
            i = 0;
            i2 = 0;
            flowCollector2 = flowCollector;
            flowCollector3 = flowCollector2;
            i3 = 0;
            if (i3 < length) {
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = c14341.f6151I$3;
            i3 = c14341.f6150I$2;
            int i6 = c14341.f6149I$1;
            int i7 = c14341.f6148I$0;
            int[] iArr3 = (int[]) c14341.f6158L$3;
            FlowCollector flowCollector4 = (FlowCollector) c14341.f6157L$2;
            Object obj3 = (Continuation) c14341.f6156L$1;
            FlowCollector flowCollector5 = (FlowCollector) c14341.f6155L$0;
            ResultKt.throwOnFailure(obj2);
            flowCollector2 = flowCollector4;
            i2 = i7;
            obj = obj3;
            iArr = iArr3;
            i = i6;
            c143412 = c14341;
            flowCollector3 = flowCollector5;
            i3++;
            if (i3 < length) {
                int i8 = iArr[i3];
                Integer numM6121boxInt = C1207Boxing.m6121boxInt(i8);
                c143412.f6155L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                c143412.f6156L$1 = SpillingKt.nullOutSpilledVariable(obj);
                c143412.f6157L$2 = flowCollector2;
                c143412.f6158L$3 = iArr;
                c143412.f6148I$0 = i2;
                c143412.f6149I$1 = i;
                c143412.f6150I$2 = i3;
                c143412.f6151I$3 = length;
                c143412.f6152I$4 = i8;
                c143412.f6153I$5 = i8;
                c143412.f6154I$6 = 0;
                c143412.f6159label = 1;
                if (flowCollector2.mo4309emit(numM6121boxInt, c143412) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i3++;
                if (i3 < length) {
                    return C1133Unit.INSTANCE;
                }
            }
        }
    }
}
