package p094kotlin.p119time;

import java.util.concurrent.TimeUnit;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(m5061version = "1.6")
@Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\bB\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u00020\u0003X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000eÊ\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012¨\u0006\u000f"}, m4988d2 = {"Lkotlin/time/DurationUnit;", BuildConfig.f24315FLAVOR, "timeUnit", "Ljava/util/concurrent/TimeUnit;", "<init>", "(Ljava/lang/String;ILjava/util/concurrent/TimeUnit;)V", "getTimeUnit$kotlin_stdlib", "()Ljava/util/concurrent/TimeUnit;", "NANOSECONDS", "MICROSECONDS", "MILLISECONDS", "SECONDS", "MINUTES", "HOURS", "DAYS", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.6"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class DurationUnit {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ DurationUnit[] f5443$VALUES;
    private final TimeUnit timeUnit;
    public static final DurationUnit NANOSECONDS = new DurationUnit("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
    public static final DurationUnit MICROSECONDS = new DurationUnit("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
    public static final DurationUnit MILLISECONDS = new DurationUnit("MILLISECONDS", 2, TimeUnit.MILLISECONDS);

    /* renamed from: SECONDS */
    public static final DurationUnit f5447SECONDS = new DurationUnit("SECONDS", 3, TimeUnit.SECONDS);

    /* renamed from: MINUTES */
    public static final DurationUnit f5446MINUTES = new DurationUnit("MINUTES", 4, TimeUnit.MINUTES);

    /* renamed from: HOURS */
    public static final DurationUnit f5445HOURS = new DurationUnit("HOURS", 5, TimeUnit.HOURS);

    /* renamed from: DAYS */
    public static final DurationUnit f5444DAYS = new DurationUnit("DAYS", 6, TimeUnit.DAYS);

    /* renamed from: $values */
    private static final /* synthetic */ DurationUnit[] m6870$values() {
        return new DurationUnit[]{NANOSECONDS, MICROSECONDS, MILLISECONDS, f5447SECONDS, f5446MINUTES, f5445HOURS, f5444DAYS};
    }

    static {
        DurationUnit[] durationUnitArrM6870$values = m6870$values();
        f5443$VALUES = durationUnitArrM6870$values;
        $ENTRIES = EnumEntriesKt.enumEntries(durationUnitArrM6870$values);
    }

    private DurationUnit(String str, int i, TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    public static EnumEntries<DurationUnit> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static DurationUnit m6871valueOf(String str) {
        return (DurationUnit) Enum.valueOf(DurationUnit.class, str);
    }

    /* renamed from: values */
    public static DurationUnit[] m6872values() {
        return (DurationUnit[]) f5443$VALUES.clone();
    }

    /* renamed from: getTimeUnit$kotlin_stdlib, reason: from getter */
    public final TimeUnit getTimeUnit() {
        return this.timeUnit;
    }
}
