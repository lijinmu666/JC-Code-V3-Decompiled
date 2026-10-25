package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m4988d2 = {"Lkotlin/LazyThreadSafetyMode;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SYNCHRONIZED", "PUBLICATION", "NONE", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class LazyThreadSafetyMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ LazyThreadSafetyMode[] f4889$VALUES;
    public static final LazyThreadSafetyMode SYNCHRONIZED = new LazyThreadSafetyMode("SYNCHRONIZED", 0);
    public static final LazyThreadSafetyMode PUBLICATION = new LazyThreadSafetyMode("PUBLICATION", 1);

    /* renamed from: NONE */
    public static final LazyThreadSafetyMode f4890NONE = new LazyThreadSafetyMode("NONE", 2);

    /* renamed from: $values */
    private static final /* synthetic */ LazyThreadSafetyMode[] m4983$values() {
        return new LazyThreadSafetyMode[]{SYNCHRONIZED, PUBLICATION, f4890NONE};
    }

    static {
        LazyThreadSafetyMode[] lazyThreadSafetyModeArrM4983$values = m4983$values();
        f4889$VALUES = lazyThreadSafetyModeArrM4983$values;
        $ENTRIES = EnumEntriesKt.enumEntries(lazyThreadSafetyModeArrM4983$values);
    }

    private LazyThreadSafetyMode(String str, int i) {
    }

    public static EnumEntries<LazyThreadSafetyMode> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static LazyThreadSafetyMode m4984valueOf(String str) {
        return (LazyThreadSafetyMode) Enum.valueOf(LazyThreadSafetyMode.class, str);
    }

    /* renamed from: values */
    public static LazyThreadSafetyMode[] m4985values() {
        return (LazyThreadSafetyMode[]) f4889$VALUES.clone();
    }
}
