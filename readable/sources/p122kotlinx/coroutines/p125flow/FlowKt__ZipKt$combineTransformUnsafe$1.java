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
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.CombineKt;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1", m6124f = "Zip.kt", m6125i = {0}, m6126l = {269}, m6127m = "invokeSuspend", m6128n = {"$this$safeFlow"}, m6130s = {"L$0"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransformUnsafe$1\n*L\n1#1,328:1\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__ZipKt$combineTransformUnsafe$1<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super C1133Unit>, Object> {

    /* renamed from: $flows */
    final /* synthetic */ InterfaceC1426Flow<T>[] f6984$flows;
    final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> $transform;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6985L$0;

    /* renamed from: label */
    int f6986label;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1", m6124f = "Zip.kt", m6125i = {0, 0}, m6126l = {269}, m6127m = "invokeSuspend", m6128n = {"$this$combineInternal", "it"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransformUnsafe$1$1 */
    public static final class C15491<T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> $transform;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6987L$0;

        /* renamed from: L$1 */
        /* synthetic */ Object f6988L$1;

        /* renamed from: label */
        int f6989label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C15491(Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super C15491> continuation) {
            super(3, continuation);
            this.$transform = function3;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6987L$0;
            Object[] objArr = (Object[]) this.f6988L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6989label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> function3 = this.$transform;
                this.f6987L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.f6988L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                this.f6989label = 1;
                if (function3.mo6219invoke(flowCollector, objArr, this) == coroutine_suspended) {
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

        public final Object invokeSuspend$$forInline(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6987L$0;
            InlineMarker.m6315mark(10);
            Object[] objArr = (Object[]) this.f6988L$1;
            InlineMarker.m6315mark(10);
            this.$transform.mo6219invoke(flowCollector, objArr, this);
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo6219invoke(FlowCollector<? super R> flowCollector, T[] tArr, Continuation<? super C1133Unit> continuation) {
            Intrinsics.needClassReification();
            C15491 c15491 = new C15491(this.$transform, continuation);
            c15491.f6987L$0 = flowCollector;
            c15491.f6988L$1 = tArr;
            return c15491.invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__ZipKt$combineTransformUnsafe$1(InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super FlowKt__ZipKt$combineTransformUnsafe$1> continuation) {
        super(2, continuation);
        this.f6984$flows = interfaceC1426FlowArr;
        this.$transform = function3;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        FlowKt__ZipKt$combineTransformUnsafe$1 flowKt__ZipKt$combineTransformUnsafe$1 = new FlowKt__ZipKt$combineTransformUnsafe$1(this.f6984$flows, this.$transform, continuation);
        flowKt__ZipKt$combineTransformUnsafe$1.f6985L$0 = obj;
        return flowKt__ZipKt$combineTransformUnsafe$1;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.f6985L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f6986label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InterfaceC1426Flow<T>[] interfaceC1426FlowArr = this.f6984$flows;
            Function0 function0 = new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                @Override // p094kotlin.p105jvm.functions.Function0
                /* renamed from: invoke */
                public final Void mo4323invoke() {
                    return null;
                }
            };
            Intrinsics.needClassReification();
            C15491 c15491 = new C15491(this.$transform, null);
            this.f6985L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
            this.f6986label = 1;
            if (CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, function0, c15491, this) == coroutine_suspended) {
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

    public final Object invokeSuspend$$forInline(Object obj) {
        FlowCollector flowCollector = (FlowCollector) this.f6985L$0;
        InlineMarker.m6315mark(10);
        InterfaceC1426Flow<T>[] interfaceC1426FlowArr = this.f6984$flows;
        Function0 function0 = new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final Void mo4323invoke() {
                return null;
            }
        };
        Intrinsics.needClassReification();
        C15491 c15491 = new C15491(this.$transform, null);
        InlineMarker.m6315mark(0);
        CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, function0, c15491, this);
        InlineMarker.m6315mark(1);
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo2167invoke(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
        return ((FlowKt__ZipKt$combineTransformUnsafe$1) mo2166create(flowCollector, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
