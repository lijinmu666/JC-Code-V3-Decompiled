package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p119time.TimeSource;

@Metadata(m4987d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aM\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\r\u001aQ\u0010\u0000\u001a\u00020\u0001*\u00020\u000e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000f\u001aT\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0000\u0010\u00122\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0003H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aX\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0000\u0010\u0012*\u00020\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0003H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aX\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0011\"\u0004\b\u0000\u0010\u0012*\u00020\u000e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0003H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, m4988d2 = {"measureTime", "Lkotlin/time/Duration;", "block", "Lkotlin/Function0;", BuildConfig.f24315FLAVOR, "(Lkotlin/jvm/functions/Function0;)J", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;", "Lkotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "Lkotlin/time/TimeSource$Monotonic;", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lkotlin/time/TimedValue;", "T", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nmeasureTime.kt\nKotlin\n*S Kotlin\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n1#1,139:1\n63#1,3:140\n135#1,3:143\n*S KotlinDebug\n*F\n+ 1 measureTime.kt\nkotlin/time/MeasureTimeKt\n*L\n24#1:140,3\n95#1:143,3\n*E\n"})
/* loaded from: classes.dex */
public final class MeasureTimeKt {
    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long measureTime(Function0<C1133Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long jM19953markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m19953markNowz9LOYto();
        block.mo4323invoke();
        return TimeSource.Monotonic.ValueTimeMark.m19958elapsedNowUwyO8pc(jM19953markNowz9LOYto);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new TimedValue<>(block.mo4323invoke(), TimeSource.Monotonic.ValueTimeMark.m19958elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m19953markNowz9LOYto()), null);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long measureTime(TimeSource timeSource, Function0<C1133Unit> block) {
        Intrinsics.checkNotNullParameter(timeSource, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        TimeMark timeMarkMo6860markNow = timeSource.mo6860markNow();
        block.mo4323invoke();
        return timeMarkMo6860markNow.mo19824elapsedNowUwyO8pc();
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final <T> TimedValue<T> measureTimedValue(TimeSource timeSource, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(timeSource, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return new TimedValue<>(block.mo4323invoke(), timeSource.mo6860markNow().mo19824elapsedNowUwyO8pc(), null);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final long measureTime(TimeSource.Monotonic monotonic, Function0<C1133Unit> block) {
        Intrinsics.checkNotNullParameter(monotonic, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        long jM19953markNowz9LOYto = monotonic.m19953markNowz9LOYto();
        block.mo4323invoke();
        return TimeSource.Monotonic.ValueTimeMark.m19958elapsedNowUwyO8pc(jM19953markNowz9LOYto);
    }

    @SinceKotlin(m5061version = "1.9")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final <T> TimedValue<T> measureTimedValue(TimeSource.Monotonic monotonic, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(monotonic, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        return new TimedValue<>(block.mo4323invoke(), TimeSource.Monotonic.ValueTimeMark.m19958elapsedNowUwyO8pc(monotonic.m19953markNowz9LOYto()), null);
    }
}
