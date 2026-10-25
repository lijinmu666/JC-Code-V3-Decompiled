package p094kotlin.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(m5061version = "1.2")
@Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0081\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006Ê\u0001\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¨\u0006\u0007"}, m4988d2 = {"Lkotlin/internal/RequireKotlinVersionKind;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.2"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class RequireKotlinVersionKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ RequireKotlinVersionKind[] f5053$VALUES;
    public static final RequireKotlinVersionKind LANGUAGE_VERSION = new RequireKotlinVersionKind("LANGUAGE_VERSION", 0);
    public static final RequireKotlinVersionKind COMPILER_VERSION = new RequireKotlinVersionKind("COMPILER_VERSION", 1);
    public static final RequireKotlinVersionKind API_VERSION = new RequireKotlinVersionKind("API_VERSION", 2);

    /* renamed from: $values */
    private static final /* synthetic */ RequireKotlinVersionKind[] m6148$values() {
        return new RequireKotlinVersionKind[]{LANGUAGE_VERSION, COMPILER_VERSION, API_VERSION};
    }

    static {
        RequireKotlinVersionKind[] requireKotlinVersionKindArrM6148$values = m6148$values();
        f5053$VALUES = requireKotlinVersionKindArrM6148$values;
        $ENTRIES = EnumEntriesKt.enumEntries(requireKotlinVersionKindArrM6148$values);
    }

    private RequireKotlinVersionKind(String str, int i) {
    }

    public static EnumEntries<RequireKotlinVersionKind> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static RequireKotlinVersionKind m6149valueOf(String str) {
        return (RequireKotlinVersionKind) Enum.valueOf(RequireKotlinVersionKind.class, str);
    }

    /* renamed from: values */
    public static RequireKotlinVersionKind[] m6150values() {
        return (RequireKotlinVersionKind[]) f5053$VALUES.clone();
    }
}
