package p094kotlin.p113reflect;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(m5061version = "1.1")
@Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¨\u0006\b"}, m4988d2 = {"Lkotlin/reflect/KVisibility;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "PUBLIC", "PROTECTED", "INTERNAL", "PRIVATE", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.1"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class KVisibility {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ KVisibility[] f5274$VALUES;

    /* renamed from: PUBLIC */
    public static final KVisibility f5276PUBLIC = new KVisibility("PUBLIC", 0);
    public static final KVisibility PROTECTED = new KVisibility("PROTECTED", 1);
    public static final KVisibility INTERNAL = new KVisibility("INTERNAL", 2);

    /* renamed from: PRIVATE */
    public static final KVisibility f5275PRIVATE = new KVisibility("PRIVATE", 3);

    /* renamed from: $values */
    private static final /* synthetic */ KVisibility[] m6545$values() {
        return new KVisibility[]{f5276PUBLIC, PROTECTED, INTERNAL, f5275PRIVATE};
    }

    static {
        KVisibility[] kVisibilityArrM6545$values = m6545$values();
        f5274$VALUES = kVisibilityArrM6545$values;
        $ENTRIES = EnumEntriesKt.enumEntries(kVisibilityArrM6545$values);
    }

    private KVisibility(String str, int i) {
    }

    public static EnumEntries<KVisibility> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static KVisibility m6546valueOf(String str) {
        return (KVisibility) Enum.valueOf(KVisibility.class, str);
    }

    /* renamed from: values */
    public static KVisibility[] m6547values() {
        return (KVisibility[]) f5274$VALUES.clone();
    }
}
