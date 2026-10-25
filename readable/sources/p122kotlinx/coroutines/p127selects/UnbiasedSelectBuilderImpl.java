package p122kotlinx.coroutines.p127selects;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p122kotlinx.coroutines.CancellableContinuationImpl;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.CoroutineScopeKt;
import p122kotlinx.coroutines.CoroutineStart;

@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0001J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0001R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m4988d2 = {"Lkotlinx/coroutines/selects/UnbiasedSelectBuilderImpl;", "R", "Lkotlinx/coroutines/selects/UnbiasedSelectImplementation;", "uCont", "Lkotlin/coroutines/Continuation;", "<init>", "(Lkotlin/coroutines/Continuation;)V", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "initSelectResult", BuildConfig.f24315FLAVOR, "handleBuilderException", BuildConfig.f24315FLAVOR, "e", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@PublishedApi
/* loaded from: classes.dex */
public final class UnbiasedSelectBuilderImpl<R> extends UnbiasedSelectImplementation<R> {
    private final CancellableContinuationImpl<R> cont;

    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$initSelectResult$1", m6124f = "SelectOld.kt", m6125i = {}, m6126l = {C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$initSelectResult$1 */
    public static final class C15871 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {

        /* renamed from: label */
        int f7256label;

        /* renamed from: this$0 */
        final /* synthetic */ UnbiasedSelectBuilderImpl<R> f7257this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C15871(UnbiasedSelectBuilderImpl<R> unbiasedSelectBuilderImpl, Continuation<? super C15871> continuation) {
            super(2, continuation);
            this.f7257this$0 = unbiasedSelectBuilderImpl;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new C15871(this.f7257this$0, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f7256label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    UnbiasedSelectBuilderImpl<R> unbiasedSelectBuilderImpl = this.f7257this$0;
                    this.f7256label = 1;
                    obj = unbiasedSelectBuilderImpl.doSelect(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                SelectOldKt.resumeUndispatched(((UnbiasedSelectBuilderImpl) this.f7257this$0).cont, obj);
                this = (Continuation<? super R>) C1133Unit.INSTANCE;
                return this;
            } catch (Throwable th) {
                SelectOldKt.resumeUndispatchedWithException(((UnbiasedSelectBuilderImpl) this.f7257this$0).cont, th);
                return C1133Unit.INSTANCE;
            }
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
            return ((C15871) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public UnbiasedSelectBuilderImpl(Continuation<? super R> continuation) {
        super(continuation.get$context());
        this.cont = new CancellableContinuationImpl<>(IntrinsicsKt.intercepted(continuation), 1);
    }

    @PublishedApi
    public final void handleBuilderException(Throwable e) {
        CancellableContinuationImpl<R> cancellableContinuationImpl = this.cont;
        C1124Result.Companion companion = C1124Result.INSTANCE;
        cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(ResultKt.createFailure(e)));
    }

    @PublishedApi
    public final Object initSelectResult() {
        if (this.cont.isCompleted()) {
            return this.cont.getResult();
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(getContext()), null, CoroutineStart.UNDISPATCHED, new C15871(this, null), 1, null);
        return this.cont.getResult();
    }
}
