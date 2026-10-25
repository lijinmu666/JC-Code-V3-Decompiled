package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function7;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n¨\u0006\u0004"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5", m6124f = "Zip.kt", m6125i = {0}, m6126l = {269}, m6127m = "invokeSuspend", m6128n = {"$this$safeFlow"}, m6130s = {"L$0"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,328:1\n*E\n"})
/* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5 */
/* loaded from: classes.dex */
public final class C1545xd7c321ea<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super C1133Unit>, Object> {

    /* renamed from: $flows */
    final /* synthetic */ InterfaceC1426Flow[] f6946$flows;
    final /* synthetic */ Function7 $transform$inlined;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6947L$0;

    /* renamed from: label */
    int f6948label;

    @Metadata(m4987d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", BuildConfig.f24315FLAVOR, "kotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5$1", m6124f = "Zip.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {270}, m6127m = "invokeSuspend", m6128n = {"$this$combineInternal", "it", "$completion", "args", "$this$combineTransform_u24lambda_u244", "$i$a$-combineTransformUnsafe-FlowKt__ZipKt$combineTransform$5"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,269:1\n217#2,8:270\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$$inlined$combineTransformUnsafe$FlowKt__ZipKt$5$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Function7 $transform$inlined;

        /* renamed from: I$0 */
        int f6949I$0;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6950L$0;

        /* renamed from: L$1 */
        /* synthetic */ Object f6951L$1;

        /* renamed from: L$2 */
        Object f6952L$2;

        /* renamed from: L$3 */
        Object f6953L$3;

        /* renamed from: L$4 */
        Object f6954L$4;

        /* renamed from: label */
        int f6955label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Continuation continuation, Function7 function7) {
            super(3, continuation);
            this.$transform$inlined = function7;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6950L$0;
            Object[] objArr = (Object[]) this.f6951L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6955label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function7 function7 = this.$transform$inlined;
                Object obj2 = objArr[0];
                Object obj3 = objArr[1];
                Object obj4 = objArr[2];
                Object obj5 = objArr[3];
                Object obj6 = objArr[4];
                this.f6950L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.f6951L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                this.f6952L$2 = SpillingKt.nullOutSpilledVariable(this);
                this.f6953L$3 = SpillingKt.nullOutSpilledVariable(objArr);
                this.f6954L$4 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.f6949I$0 = 0;
                this.f6955label = 1;
                InlineMarker.m6315mark(6);
                Object objMo6279invoke = function7.mo6279invoke(flowCollector, obj2, obj3, obj4, obj5, obj6, this);
                InlineMarker.m6315mark(7);
                if (objMo6279invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo6219invoke(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super C1133Unit> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation, this.$transform$inlined);
            anonymousClass1.f6950L$0 = flowCollector;
            anonymousClass1.f6951L$1 = objArr;
            return anonymousClass1.invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1545xd7c321ea(InterfaceC1426Flow[] interfaceC1426FlowArr, Continuation continuation, Function7 function7) {
        super(2, continuation);
        this.f6946$flows = interfaceC1426FlowArr;
        this.$transform$inlined = function7;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        C1545xd7c321ea c1545xd7c321ea = new C1545xd7c321ea(this.f6946$flows, continuation, this.$transform$inlined);
        c1545xd7c321ea.f6947L$0 = obj;
        return c1545xd7c321ea;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.f6947L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6948label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC1426Flow[] interfaceC1426FlowArr = this.f6946$flows;
            Function0 function0 = new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                @Override // p094kotlin.p105jvm.functions.Function0
                /* renamed from: invoke */
                public final Void mo4323invoke() {
                    return null;
                }
            };
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(null, this.$transform$inlined);
            this.f6947L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.f6948label = 1;
            if (CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, function0, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo2167invoke(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
        return ((C1545xd7c321ea) mo2166create(flowCollector, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
