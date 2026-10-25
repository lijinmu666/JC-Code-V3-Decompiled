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
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,111:1\n172#2:112\n173#2,2:114\n175#2:117\n13833#3:113\n13834#3:116\n*S KotlinDebug\n*F\n+ 1 Builders.kt\nkotlinx/coroutines/flow/FlowKt__BuildersKt\n*L\n172#1:113\n172#1:116\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8 implements InterfaceC1426Flow<Long> {
    final /* synthetic */ long[] $this_asFlow$inlined;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8", m6124f = "Builders.kt", m6125i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, m6126l = {114}, m6127m = "collect", m6128n = {"collector", "$completion", "$this$asFlow_u24lambda_u247", "$this$forEach$iv", "$i$a$-unsafeFlow-FlowKt__BuildersKt$asFlow$8", "$i$f$forEach", "element$iv", "value", "$i$a$-forEach-FlowKt__BuildersKt$asFlow$8$1"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "J$0", "J$1", "I$4"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8$1 */
    public static final class C14351 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6162I$0;

        /* renamed from: I$1 */
        int f6163I$1;

        /* renamed from: I$2 */
        int f6164I$2;

        /* renamed from: I$3 */
        int f6165I$3;

        /* renamed from: I$4 */
        int f6166I$4;

        /* renamed from: J$0 */
        long f6167J$0;

        /* renamed from: J$1 */
        long f6168J$1;

        /* renamed from: L$0 */
        Object f6169L$0;

        /* renamed from: L$1 */
        Object f6170L$1;

        /* renamed from: L$2 */
        Object f6171L$2;

        /* renamed from: L$3 */
        Object f6172L$3;

        /* renamed from: label */
        int f6173label;

        /* renamed from: result */
        /* synthetic */ Object f6174result;

        public C14351(Continuation continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6174result = obj;
            this.f6173label |= Integer.MIN_VALUE;
            return FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8.this.mo4308collect(null, this);
        }
    }

    public FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$8(long[] jArr) {
        this.$this_asFlow$inlined = jArr;
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
    public Object mo4308collect(FlowCollector<? super Long> flowCollector, Continuation<? super C1133Unit> continuation) {
        C14351 c14351;
        long[] jArr;
        int length;
        C14351 c143512;
        Object obj;
        int i;
        int i2;
        FlowCollector flowCollector2;
        FlowCollector flowCollector3;
        int i3;
        if (continuation instanceof C14351) {
            c14351 = (C14351) continuation;
            int i4 = c14351.f6173label;
            if ((i4 & Integer.MIN_VALUE) != 0) {
                c14351.f6173label = i4 - Integer.MIN_VALUE;
            } else {
                c14351 = new C14351(continuation);
            }
        }
        Object obj2 = c14351.f6174result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = c14351.f6173label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj2);
            long[] jArr2 = this.$this_asFlow$inlined;
            jArr = jArr2;
            length = jArr2.length;
            c143512 = c14351;
            obj = c143512;
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
            length = c14351.f6165I$3;
            i3 = c14351.f6164I$2;
            int i6 = c14351.f6163I$1;
            int i7 = c14351.f6162I$0;
            long[] jArr3 = (long[]) c14351.f6172L$3;
            FlowCollector flowCollector4 = (FlowCollector) c14351.f6171L$2;
            Object obj3 = (Continuation) c14351.f6170L$1;
            FlowCollector flowCollector5 = (FlowCollector) c14351.f6169L$0;
            ResultKt.throwOnFailure(obj2);
            flowCollector2 = flowCollector4;
            i2 = i7;
            obj = obj3;
            jArr = jArr3;
            i = i6;
            c143512 = c14351;
            flowCollector3 = flowCollector5;
            i3++;
            if (i3 < length) {
                long j = jArr[i3];
                Long lM6122boxLong = C1207Boxing.m6122boxLong(j);
                c143512.f6169L$0 = SpillingKt.nullOutSpilledVariable(flowCollector3);
                c143512.f6170L$1 = SpillingKt.nullOutSpilledVariable(obj);
                c143512.f6171L$2 = flowCollector2;
                c143512.f6172L$3 = jArr;
                c143512.f6162I$0 = i2;
                c143512.f6163I$1 = i;
                c143512.f6164I$2 = i3;
                c143512.f6165I$3 = length;
                c143512.f6167J$0 = j;
                c143512.f6168J$1 = j;
                c143512.f6166I$4 = 0;
                c143512.f6173label = 1;
                if (flowCollector2.mo4309emit(lM6122boxLong, c143512) == coroutine_suspended) {
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
