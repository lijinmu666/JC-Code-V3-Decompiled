package p094kotlin.p119time;

import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0010\b\t\u0012\f\b\n\u0012\b\b\fJ\u0004\b\t0\u000bb\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0005¢\u0006\u0002\b\u0005¨\u0006\u000e"}, m4988d2 = {"asClock", "Lkotlin/time/Clock;", "Lkotlin/time/TimeSource;", "origin", "Lkotlin/time/Instant;", "fromTimeSource", "Lkotlin/SinceKotlin;", "version", "2.3", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;", "Lkotlin/jvm/JvmName;", "name", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ClocksKt {
    @SinceKotlin(m5061version = "2.3")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    @InterfaceC1231JvmName(m6260name = "fromTimeSource")
    public static final InterfaceC1323Clock fromTimeSource(final TimeSource timeSource, final C1324Instant origin) {
        Intrinsics.checkNotNullParameter(timeSource, "<this>");
        Intrinsics.checkNotNullParameter(origin, "origin");
        return new InterfaceC1323Clock(timeSource, origin) { // from class: kotlin.time.ClocksKt$asClock$1

            /* renamed from: $origin */
            final /* synthetic */ C1324Instant f5440$origin;
            private final TimeMark startMark;

            {
                this.f5440$origin = origin;
                this.startMark = timeSource.mo6860markNow();
            }

            @Override // p094kotlin.p119time.InterfaceC1323Clock
            /* renamed from: now */
            public C1324Instant mo6153now() {
                return this.f5440$origin.m19941plusLRDsOJo(this.startMark.mo19824elapsedNowUwyO8pc());
            }
        };
    }
}
