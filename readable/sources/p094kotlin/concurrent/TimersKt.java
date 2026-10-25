package p094kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001a8\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001a@\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001a@\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001a@\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001a@\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001a \u0010\u000e\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0081\u0080\u0004b\u0002\b\u0013\u001aT\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001aR\u0010\u000e\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001aT\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001aR\u0010\u0016\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u001a,\u0010\u0017\u001a\u00020\u00012\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\u0088\u0004b\u0002\b\tø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0018"}, m4988d2 = {"schedule", "Ljava/util/TimerTask;", "Ljava/util/Timer;", "delay", BuildConfig.f24315FLAVOR, "action", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "Lkotlin/internal/InlineOnly;", "time", "Ljava/util/Date;", "period", "scheduleAtFixedRate", "timer", "name", BuildConfig.f24315FLAVOR, "daemon", BuildConfig.f24315FLAVOR, "Lkotlin/PublishedApi;", "initialDelay", "startAt", "fixedRateTimer", "timerTask", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "TimersKt")
/* loaded from: classes.dex */
public final class TimersKt {

    @Metadata(m4987d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m4988d2 = {"kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nTimer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Timer.kt\nkotlin/concurrent/TimersKt$timerTask$1\n*L\n1#1,149:1\n*E\n"})
    /* renamed from: kotlin.concurrent.TimersKt$timerTask$1 */
    public static final class C11911 extends TimerTask {

        /* renamed from: $action */
        final /* synthetic */ Function1<TimerTask, C1133Unit> f5028$action;

        /* JADX WARN: Multi-variable type inference failed */
        public C11911(Function1<? super TimerTask, C1133Unit> function1) {
            this.f5028$action = function1;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f5028$action.mo2237invoke(this);
        }
    }

    @InlineOnly
    private static final Timer fixedRateTimer(String str, boolean z, long j, long j2, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timerM6083timer = m6083timer(str, z);
        timerM6083timer.scheduleAtFixedRate(new C11911(action), j, j2);
        return timerM6083timer;
    }

    public static /* synthetic */ Timer fixedRateTimer$default(String str, boolean z, long j, long j2, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timerM6083timer = m6083timer(str, z);
        timerM6083timer.scheduleAtFixedRate(new C11911(action), j, j2);
        return timerM6083timer;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer timer, long j, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        C11911 c11911 = new C11911(action);
        timer.schedule(c11911, j);
        return c11911;
    }

    @InlineOnly
    private static final TimerTask scheduleAtFixedRate(Timer timer, long j, long j2, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        C11911 c11911 = new C11911(action);
        timer.scheduleAtFixedRate(c11911, j, j2);
        return c11911;
    }

    @PublishedApi
    /* renamed from: timer */
    public static final Timer m6083timer(String str, boolean z) {
        return str == null ? new Timer(z) : new Timer(str, z);
    }

    public static /* synthetic */ Timer timer$default(String str, boolean z, long j, long j2, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            j = 0;
        }
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timerM6083timer = m6083timer(str, z);
        timerM6083timer.schedule(new C11911(action), j, j2);
        return timerM6083timer;
    }

    @InlineOnly
    private static final TimerTask timerTask(Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return new C11911(action);
    }

    @InlineOnly
    /* renamed from: timer */
    private static final Timer m6084timer(String str, boolean z, long j, long j2, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timerM6083timer = m6083timer(str, z);
        timerM6083timer.schedule(new C11911(action), j, j2);
        return timerM6083timer;
    }

    @InlineOnly
    private static final Timer fixedRateTimer(String str, boolean z, Date startAt, long j, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timerM6083timer = m6083timer(str, z);
        timerM6083timer.scheduleAtFixedRate(new C11911(action), startAt, j);
        return timerM6083timer;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer timer, Date time, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(action, "action");
        C11911 c11911 = new C11911(action);
        timer.schedule(c11911, time);
        return c11911;
    }

    @InlineOnly
    private static final TimerTask scheduleAtFixedRate(Timer timer, Date time, long j, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(action, "action");
        C11911 c11911 = new C11911(action);
        timer.scheduleAtFixedRate(c11911, time, j);
        return c11911;
    }

    public static /* synthetic */ Timer fixedRateTimer$default(String str, boolean z, Date startAt, long j, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timerM6083timer = m6083timer(str, z);
        timerM6083timer.scheduleAtFixedRate(new C11911(action), startAt, j);
        return timerM6083timer;
    }

    @InlineOnly
    /* renamed from: timer */
    private static final Timer m6085timer(String str, boolean z, Date startAt, long j, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timerM6083timer = m6083timer(str, z);
        timerM6083timer.schedule(new C11911(action), startAt, j);
        return timerM6083timer;
    }

    public static /* synthetic */ Timer timer$default(String str, boolean z, Date startAt, long j, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timerM6083timer = m6083timer(str, z);
        timerM6083timer.schedule(new C11911(action), startAt, j);
        return timerM6083timer;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer timer, long j, long j2, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        C11911 c11911 = new C11911(action);
        timer.schedule(c11911, j, j2);
        return c11911;
    }

    @InlineOnly
    private static final TimerTask schedule(Timer timer, Date time, long j, Function1<? super TimerTask, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(timer, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(action, "action");
        C11911 c11911 = new C11911(action);
        timer.schedule(c11911, time, j);
        return c11911;
    }
}
