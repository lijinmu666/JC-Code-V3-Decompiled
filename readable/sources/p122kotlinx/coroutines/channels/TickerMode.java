package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;
import p122kotlinx.coroutines.ObsoleteCoroutinesApi;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@ObsoleteCoroutinesApi
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m4988d2 = {"Lkotlinx/coroutines/channels/TickerMode;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "FIXED_PERIOD", "FIXED_DELAY", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class TickerMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ TickerMode[] f6008$VALUES;
    public static final TickerMode FIXED_PERIOD = new TickerMode("FIXED_PERIOD", 0);
    public static final TickerMode FIXED_DELAY = new TickerMode("FIXED_DELAY", 1);

    /* renamed from: $values */
    private static final /* synthetic */ TickerMode[] m7159$values() {
        return new TickerMode[]{FIXED_PERIOD, FIXED_DELAY};
    }

    static {
        TickerMode[] tickerModeArrM7159$values = m7159$values();
        f6008$VALUES = tickerModeArrM7159$values;
        $ENTRIES = EnumEntriesKt.enumEntries(tickerModeArrM7159$values);
    }

    private TickerMode(String str, int i) {
    }

    public static EnumEntries<TickerMode> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static TickerMode m7160valueOf(String str) {
        return (TickerMode) Enum.valueOf(TickerMode.class, str);
    }

    /* renamed from: values */
    public static TickerMode[] m7161values() {
        return (TickerMode[]) f6008$VALUES.clone();
    }
}
