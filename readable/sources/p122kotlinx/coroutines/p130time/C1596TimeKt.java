package p122kotlinx.coroutines.p130time;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p122kotlinx.coroutines.C1338DelayKt;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.FlowPreview;
import p122kotlinx.coroutines.TimeoutKt;
import p122kotlinx.coroutines.p125flow.C1427FlowKt;
import p122kotlinx.coroutines.p125flow.InterfaceC1426Flow;
import p122kotlinx.coroutines.p127selects.OnTimeoutKt;
import p122kotlinx.coroutines.p127selects.SelectBuilder;

@Metadata(m4987d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010\u0004\u001a&\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0007\u001a&\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007*\b\u0012\u0004\u0012\u0002H\u00070\u00062\u0006\u0010\n\u001a\u00020\u0003H\u0007\u001aA\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r2\u0006\u0010\u0002\u001a\u00020\u00032\u001c\u0010\u000e\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f¢\u0006\u0002\u0010\u0012\u001aR\u0010\u0013\u001a\u0002H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0014¢\u0006\u0002\b\u0016H\u0086@\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0017\u001aG\u0010\u0018\u001a\u0004\u0018\u0001H\u0007\"\u0004\b\u0000\u0010\u00072\u0006\u0010\u0002\u001a\u00020\u00032'\u0010\u000e\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u0014¢\u0006\u0002\b\u0016H\u0086@¢\u0006\u0002\u0010\u0017\u001a\f\u0010\u0019\u001a\u00020\u001a*\u00020\u0003H\u0002¨\u0006\u001b"}, m4988d2 = {"delay", BuildConfig.f24315FLAVOR, "duration", "Ljava/time/Duration;", "(Ljava/time/Duration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "debounce", "Lkotlinx/coroutines/flow/Flow;", "T", "timeout", "sample", "period", "onTimeout", "R", "Lkotlinx/coroutines/selects/SelectBuilder;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/selects/SelectBuilder;Ljava/time/Duration;Lkotlin/jvm/functions/Function1;)V", "withTimeout", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/ExtensionFunctionType;", "(Ljava/time/Duration;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "withTimeoutOrNull", "coerceToMillis", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.time.TimeKt */
/* loaded from: classes.dex */
public final class C1596TimeKt {
    private static final long coerceToMillis(Duration duration) {
        if (duration.compareTo(Duration.ZERO) <= 0) {
            return 0L;
        }
        if (duration.compareTo(ChronoUnit.MILLIS.getDuration()) <= 0) {
            return 1L;
        }
        return (duration.getSeconds() < 9223372036854775L || (duration.getSeconds() == 9223372036854775L && duration.getNano() < 807000000)) ? duration.toMillis() : LongCompanionObject.MAX_VALUE;
    }

    @FlowPreview
    public static final <T> InterfaceC1426Flow<T> debounce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Duration duration) {
        return C1427FlowKt.debounce(interfaceC1426Flow, coerceToMillis(duration));
    }

    /* renamed from: delay */
    public static final Object m7513delay(Duration duration, Continuation<? super C1133Unit> continuation) {
        Object objM6972delay = C1338DelayKt.m6972delay(coerceToMillis(duration), continuation);
        return objM6972delay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM6972delay : C1133Unit.INSTANCE;
    }

    public static final <R> void onTimeout(SelectBuilder<? super R> selectBuilder, Duration duration, Function1<? super Continuation<? super R>, ? extends Object> function1) {
        OnTimeoutKt.onTimeout(selectBuilder, coerceToMillis(duration), function1);
    }

    @FlowPreview
    /* renamed from: sample */
    public static final <T> InterfaceC1426Flow<T> m7514sample(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Duration duration) {
        return C1427FlowKt.m7243sample(interfaceC1426Flow, coerceToMillis(duration));
    }

    public static final <T> Object withTimeout(Duration duration, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return TimeoutKt.withTimeout(coerceToMillis(duration), function2, continuation);
    }

    public static final <T> Object withTimeoutOrNull(Duration duration, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        return TimeoutKt.withTimeoutOrNull(coerceToMillis(duration), function2, continuation);
    }
}
