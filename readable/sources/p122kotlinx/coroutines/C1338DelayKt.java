package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.ContinuationInterceptor;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p119time.Duration;
import p094kotlin.p119time.DurationKt;
import p094kotlin.p119time.DurationUnit;

@Metadata(m4987d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0002\u001a\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0086@¢\u0006\u0004\b\n\u0010\u0007\u001a\u0013\u0010\u000f\u001a\u00020\u0006*\u00020\tH\u0000¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0003\u001a\u00020\u000b*\u00020\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, m4988d2 = {"awaitCancellation", BuildConfig.f24315FLAVOR, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "delay", BuildConfig.f24315FLAVOR, "timeMillis", BuildConfig.f24315FLAVOR, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n+ 2 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n*L\n1#1,159:1\n433#2,10:160\n433#2,10:170\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/DelayKt\n*L\n103#1:160,10\n123#1:170,10\n*E\n"})
/* renamed from: kotlinx.coroutines.DelayKt */
/* loaded from: classes.dex */
public final class C1338DelayKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.DelayKt", m6124f = "Delay.kt", m6125i = {0}, m6126l = {160}, m6127m = "awaitCancellation", m6128n = {"$i$f$suspendCancellableCoroutine"}, m6130s = {"I$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.DelayKt$awaitCancellation$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5512I$0;

        /* renamed from: label */
        int f5513label;

        /* renamed from: result */
        /* synthetic */ Object f5514result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5514result = obj;
            this.f5513label |= Integer.MIN_VALUE;
            return C1338DelayKt.awaitCancellation(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object awaitCancellation(Continuation<?> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.f5513label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.f5513label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.f5514result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.f5513label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass1.f5512I$0 = 0;
            anonymousClass1.f5513label = 1;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(anonymousClass1), 1);
            cancellableContinuationImpl.initCancellability();
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(anonymousClass1);
            }
            if (result == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    /* renamed from: delay */
    public static final Object m6972delay(long j, Continuation<? super C1133Unit> continuation) {
        if (j <= 0) {
            return C1133Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (j < LongCompanionObject.MAX_VALUE) {
            getDelay(cancellableContinuationImpl.get$context()).mo20044scheduleResumeAfterDelay(j, cancellableContinuationImpl);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : C1133Unit.INSTANCE;
    }

    /* renamed from: delay-VtjQ1oo, reason: not valid java name */
    public static final Object m19980delayVtjQ1oo(long j, Continuation<? super C1133Unit> continuation) {
        Object objM6972delay = m6972delay(m19981toDelayMillisLRDsOJo(j), continuation);
        return objM6972delay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM6972delay : C1133Unit.INSTANCE;
    }

    public static final InterfaceC1337Delay getDelay(CoroutineContext coroutineContext) {
        CoroutineContext.InterfaceC1197Element interfaceC1197ElementMo6098get = coroutineContext.mo6098get(ContinuationInterceptor.INSTANCE);
        InterfaceC1337Delay interfaceC1337Delay = interfaceC1197ElementMo6098get instanceof InterfaceC1337Delay ? (InterfaceC1337Delay) interfaceC1197ElementMo6098get : null;
        return interfaceC1337Delay == null ? DefaultExecutorKt.getDefaultDelay() : interfaceC1337Delay;
    }

    /* renamed from: toDelayMillis-LRDsOJo, reason: not valid java name */
    public static final long m19981toDelayMillisLRDsOJo(long j) {
        boolean zM19863isPositiveimpl = Duration.m19863isPositiveimpl(j);
        if (zM19863isPositiveimpl) {
            return Duration.m19847getInWholeMillisecondsimpl(Duration.m19865plusLRDsOJo(j, DurationKt.toDuration(999999L, DurationUnit.NANOSECONDS)));
        }
        if (zM19863isPositiveimpl) {
            throw new NoWhenBranchMatchedException();
        }
        return 0L;
    }
}
