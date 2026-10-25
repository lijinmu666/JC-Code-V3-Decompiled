package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m4988d2 = {"Lkotlin/DeprecationLevel;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "HIDDEN", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class DeprecationLevel {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ DeprecationLevel[] f4879$VALUES;

    /* renamed from: WARNING */
    public static final DeprecationLevel f4882WARNING = new DeprecationLevel("WARNING", 0);

    /* renamed from: ERROR */
    public static final DeprecationLevel f4880ERROR = new DeprecationLevel("ERROR", 1);

    /* renamed from: HIDDEN */
    public static final DeprecationLevel f4881HIDDEN = new DeprecationLevel("HIDDEN", 2);

    /* renamed from: $values */
    private static final /* synthetic */ DeprecationLevel[] m4973$values() {
        return new DeprecationLevel[]{f4882WARNING, f4880ERROR, f4881HIDDEN};
    }

    static {
        DeprecationLevel[] deprecationLevelArrM4973$values = m4973$values();
        f4879$VALUES = deprecationLevelArrM4973$values;
        $ENTRIES = EnumEntriesKt.enumEntries(deprecationLevelArrM4973$values);
    }

    private DeprecationLevel(String str, int i) {
    }

    public static EnumEntries<DeprecationLevel> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static DeprecationLevel m4974valueOf(String str) {
        return (DeprecationLevel) Enum.valueOf(DeprecationLevel.class, str);
    }

    /* renamed from: values */
    public static DeprecationLevel[] m4975values() {
        return (DeprecationLevel[]) f4879$VALUES.clone();
    }
}
