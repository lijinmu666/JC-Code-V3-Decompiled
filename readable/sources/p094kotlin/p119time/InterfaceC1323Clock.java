package p094kotlin.p119time;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;

@SinceKotlin(m5061version = "2.3")
@Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005J\n\u0010\u0002\u001a\u00020\u0003H¦\u0080\u0004Ê\u0001\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tÊ\u0001\u0010\b\n\u0012\f\b\u000b\u0012\b\b\fJ\u0004\b\t0\f¨\u0006\u0006"}, m4988d2 = {"Lkotlin/time/Clock;", BuildConfig.f24315FLAVOR, "now", "Lkotlin/time/Instant;", "System", "Companion", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "2.3", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalTime.class})
/* renamed from: kotlin.time.Clock */
/* loaded from: classes.dex */
public interface InterfaceC1323Clock {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m4988d2 = {"Lkotlin/time/Clock$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.time.Clock$Companion, reason: from kotlin metadata */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    @Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004¨\u0006\u0006"}, m4988d2 = {"Lkotlin/time/Clock$System;", "Lkotlin/time/Clock;", "<init>", "()V", "now", "Lkotlin/time/Instant;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.time.Clock$System */
    public static final class System implements InterfaceC1323Clock {
        public static final System INSTANCE = new System();

        private System() {
        }

        @Override // p094kotlin.p119time.InterfaceC1323Clock
        /* renamed from: now */
        public C1324Instant mo6153now() {
            return InstantJvmKt.systemClockNow();
        }
    }

    /* renamed from: now */
    C1324Instant mo6153now();
}
