package p094kotlin.p113reflect;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(m5061version = "1.1")
@Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006Ê\u0001\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¨\u0006\u0007"}, m4988d2 = {"Lkotlin/reflect/KVariance;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "INVARIANT", "IN", "OUT", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.1"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class KVariance {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ KVariance[] f5271$VALUES;
    public static final KVariance INVARIANT = new KVariance("INVARIANT", 0);

    /* renamed from: IN */
    public static final KVariance f5272IN = new KVariance("IN", 1);

    /* renamed from: OUT */
    public static final KVariance f5273OUT = new KVariance("OUT", 2);

    /* renamed from: $values */
    private static final /* synthetic */ KVariance[] m6542$values() {
        return new KVariance[]{INVARIANT, f5272IN, f5273OUT};
    }

    static {
        KVariance[] kVarianceArrM6542$values = m6542$values();
        f5271$VALUES = kVarianceArrM6542$values;
        $ENTRIES = EnumEntriesKt.enumEntries(kVarianceArrM6542$values);
    }

    private KVariance(String str, int i) {
    }

    public static EnumEntries<KVariance> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static KVariance m6543valueOf(String str) {
        return (KVariance) Enum.valueOf(KVariance.class, str);
    }

    /* renamed from: values */
    public static KVariance[] m6544values() {
        return (KVariance[]) f5271$VALUES.clone();
    }
}
