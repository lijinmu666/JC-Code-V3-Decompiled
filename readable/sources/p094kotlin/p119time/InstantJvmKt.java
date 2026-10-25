package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.internal.PlatformImplementationsKt;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0003H\u0080\u0080\u0004\u001a\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0080\u0080\u0004\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m4988d2 = {"systemClock", "Lkotlin/time/Clock;", "systemClockNow", "Lkotlin/time/Instant;", "serializedInstant", BuildConfig.f24315FLAVOR, "instant", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class InstantJvmKt {
    private static final InterfaceC1323Clock systemClock = PlatformImplementationsKt.IMPLEMENTATIONS.getSystemClock();

    public static final Object serializedInstant(C1324Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "instant");
        return new InstantSerialized(instant.getEpochSeconds(), instant.getNanosecondsOfSecond());
    }

    public static final C1324Instant systemClockNow() {
        return systemClock.mo6153now();
    }
}
