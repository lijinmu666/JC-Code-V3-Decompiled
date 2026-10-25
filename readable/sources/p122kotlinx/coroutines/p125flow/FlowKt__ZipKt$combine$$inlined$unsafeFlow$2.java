package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(m4987d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007¸\u0006\u0000"}, m4988d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 176)
@SourceDebugExtension(m6344value = {"SMAP\nSafeCollector.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,111:1\n234#2,2:112\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$2<R> implements InterfaceC1426Flow<R> {
    final /* synthetic */ InterfaceC1426Flow[] $flows$inlined;
    final /* synthetic */ Function2 $transform$inlined;

    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(InterfaceC1426Flow[] interfaceC1426FlowArr, Function2 function2) {
        this.$flows$inlined = interfaceC1426FlowArr;
        this.$transform$inlined = function2;
    }

    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    public Object mo4308collect(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
        InterfaceC1426Flow[] interfaceC1426FlowArr = this.$flows$inlined;
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$5$1 flowKt__ZipKt$combine$5$1 = new FlowKt__ZipKt$combine$5$1(this.$flows$inlined);
        Intrinsics.needClassReification();
        Object objCombineInternal = CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, flowKt__ZipKt$combine$5$1, new FlowKt__ZipKt$combine$5$2(this.$transform$inlined, null), continuation);
        return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : C1133Unit.INSTANCE;
    }

    public Object collect$$forInline(FlowCollector flowCollector, Continuation continuation) {
        InlineMarker.m6315mark(4);
        new ContinuationImpl(continuation) { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$2.1

            /* renamed from: label */
            int f6900label;

            /* renamed from: result */
            /* synthetic */ Object f6901result;

            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f6901result = obj;
                this.f6900label |= Integer.MIN_VALUE;
                return FlowKt__ZipKt$combine$$inlined$unsafeFlow$2.this.mo4308collect(null, this);
            }
        };
        InlineMarker.m6315mark(5);
        InterfaceC1426Flow[] interfaceC1426FlowArr = this.$flows$inlined;
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$5$1 flowKt__ZipKt$combine$5$1 = new FlowKt__ZipKt$combine$5$1(this.$flows$inlined);
        Intrinsics.needClassReification();
        FlowKt__ZipKt$combine$5$2 flowKt__ZipKt$combine$5$2 = new FlowKt__ZipKt$combine$5$2(this.$transform$inlined, null);
        InlineMarker.m6315mark(0);
        CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, flowKt__ZipKt$combine$5$1, flowKt__ZipKt$combine$5$2, continuation);
        InlineMarker.m6315mark(1);
        return C1133Unit.INSTANCE;
    }
}
