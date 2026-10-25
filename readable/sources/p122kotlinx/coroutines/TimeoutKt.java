package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p119time.Duration;
import p094kotlin.p119time.DurationKt;
import p094kotlin.p119time.DurationUnit;
import p122kotlinx.coroutines.intrinsics.UndispatchedKt;

@Metadata(m4987d1 = {"\u0000J\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001aR\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\u001aT\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u000b\u001a\u00020\f2'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\r\u0010\n\u001aG\u0010\u000e\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@¢\u0006\u0002\u0010\n\u001aI\u0010\u000e\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u000b\u001a\u00020\f2'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0086@¢\u0006\u0004\b\u000f\u0010\n\u001a\\\u0010\u0010\u001a\u0004\u0018\u00010\b\"\u0004\b\u0000\u0010\u0011\"\b\b\u0001\u0010\u0001*\u0002H\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00010\u00132'\u0010\u0004\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tH\u0002¢\u0006\u0002\u0010\u0014\u001a*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0000¨\u0006\u001d"}, m4988d2 = {"withTimeout", "T", "timeMillis", BuildConfig.f24315FLAVOR, "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(JLkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "timeout", "Lkotlin/time/Duration;", "withTimeout-KLykuaI", "withTimeoutOrNull", "withTimeoutOrNull-KLykuaI", "setupTimeout", "U", "coroutine", "Lkotlinx/coroutines/TimeoutCoroutine;", "(Lkotlinx/coroutines/TimeoutCoroutine;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "TimeoutCancellationException", "Lkotlinx/coroutines/TimeoutCancellationException;", "time", "delay", "Lkotlinx/coroutines/Delay;", "Lkotlinx/coroutines/Job;", "coroutineName", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nTimeout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timeout.kt\nkotlinx/coroutines/TimeoutKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n1#2:284\n*E\n"})
/* loaded from: classes.dex */
public final class TimeoutKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.TimeoutKt", m6124f = "Timeout.kt", m6125i = {0, 0, 0}, m6126l = {156}, m6127m = "withTimeoutOrNull", m6128n = {"block", "coroutine", "timeMillis"}, m6130s = {"L$0", "L$1", "J$0"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.TimeoutKt$withTimeoutOrNull$1 */
    public static final class C13471<T> extends ContinuationImpl {

        /* renamed from: J$0 */
        long f5568J$0;

        /* renamed from: L$0 */
        Object f5569L$0;

        /* renamed from: L$1 */
        Object f5570L$1;

        /* renamed from: label */
        int f5571label;

        /* renamed from: result */
        /* synthetic */ Object f5572result;

        public C13471(Continuation<? super C13471> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5572result = obj;
            this.f5571label |= Integer.MIN_VALUE;
            return TimeoutKt.withTimeoutOrNull(0L, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final TimeoutCancellationException TimeoutCancellationException(long j, InterfaceC1337Delay interfaceC1337Delay, InterfaceC1342Job interfaceC1342Job, String str) {
        String string;
        DelayWithTimeoutDiagnostics delayWithTimeoutDiagnostics = interfaceC1337Delay instanceof DelayWithTimeoutDiagnostics ? (DelayWithTimeoutDiagnostics) interfaceC1337Delay : null;
        if (delayWithTimeoutDiagnostics != null) {
            Duration.Companion companion = Duration.INSTANCE;
            string = delayWithTimeoutDiagnostics.m19982timeoutMessageLRDsOJo(DurationKt.toDuration(j, DurationUnit.MILLISECONDS));
            if (string == null) {
                string = "Timed out waiting for " + j + " ms";
            }
        }
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Coroutine \"");
            sb.append(str);
            sb.append("\" ");
            if (string.length() > 0) {
                char lowerCase = Character.toLowerCase(string.charAt(0));
                String strSubstring = string.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                string = lowerCase + strSubstring;
            }
            sb.append(string);
            string = sb.toString();
        }
        return new TimeoutCancellationException(string, interfaceC1342Job);
    }

    private static final <U, T extends U> Object setupTimeout(TimeoutCoroutine<U, ? super T> timeoutCoroutine, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2) {
        C1344JobKt.disposeOnCompletion(timeoutCoroutine, C1338DelayKt.getDelay(timeoutCoroutine.uCont.get$context()).invokeOnTimeout(timeoutCoroutine.time, timeoutCoroutine, timeoutCoroutine.get$context()));
        return UndispatchedKt.startUndispatchedOrReturnIgnoreTimeout(timeoutCoroutine, timeoutCoroutine, function2);
    }

    public static final <T> Object withTimeout(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        if (j <= 0) {
            throw new TimeoutCancellationException("Timed out immediately");
        }
        Object obj = setupTimeout(new TimeoutCoroutine(j, continuation), function2);
        if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return obj;
    }

    /* renamed from: withTimeout-KLykuaI, reason: not valid java name */
    public static final <T> Object m19987withTimeoutKLykuaI(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return withTimeout(C1338DelayKt.m19981toDelayMillisLRDsOJo(j), function2, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.TimeoutCoroutine] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withTimeoutOrNull(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        C13471 c13471;
        C1235Ref.ObjectRef objectRef;
        if (continuation instanceof C13471) {
            c13471 = (C13471) continuation;
            int i = c13471.f5571label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c13471.f5571label = i - Integer.MIN_VALUE;
            } else {
                c13471 = new C13471(continuation);
            }
        }
        Object obj = c13471.f5572result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c13471.f5571label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (j <= 0) {
                return null;
            }
            C1235Ref.ObjectRef objectRef2 = new C1235Ref.ObjectRef();
            try {
                c13471.f5569L$0 = function2;
                c13471.f5570L$1 = objectRef2;
                c13471.f5568J$0 = j;
                c13471.f5571label = 1;
                ?? r2 = (T) new TimeoutCoroutine(j, c13471);
                objectRef2.f5202element = r2;
                Object obj2 = setupTimeout(r2, function2);
                if (obj2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(c13471);
                }
                return obj2 == coroutine_suspended ? coroutine_suspended : obj2;
            } catch (TimeoutCancellationException e) {
                e = e;
                objectRef = objectRef2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (C1235Ref.ObjectRef) c13471.f5570L$1;
            try {
                ResultKt.throwOnFailure(obj);
                return obj;
            } catch (TimeoutCancellationException e2) {
                e = e2;
            }
        }
        if (e.coroutine == objectRef.f5202element) {
            return null;
        }
        throw e;
    }

    /* renamed from: withTimeoutOrNull-KLykuaI, reason: not valid java name */
    public static final <T> Object m19988withTimeoutOrNullKLykuaI(long j, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return withTimeoutOrNull(C1338DelayKt.m19981toDelayMillisLRDsOJo(j), function2, continuation);
    }
}
