package p122kotlinx.coroutines.p127selects;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m4988d2 = {"Lkotlinx/coroutines/selects/TrySelectDetailedResult;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SUCCESSFUL", "REREGISTER", "CANCELLED", "ALREADY_SELECTED", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class TrySelectDetailedResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ TrySelectDetailedResult[] f7254$VALUES;
    public static final TrySelectDetailedResult SUCCESSFUL = new TrySelectDetailedResult("SUCCESSFUL", 0);
    public static final TrySelectDetailedResult REREGISTER = new TrySelectDetailedResult("REREGISTER", 1);
    public static final TrySelectDetailedResult CANCELLED = new TrySelectDetailedResult("CANCELLED", 2);
    public static final TrySelectDetailedResult ALREADY_SELECTED = new TrySelectDetailedResult("ALREADY_SELECTED", 3);

    /* renamed from: $values */
    private static final /* synthetic */ TrySelectDetailedResult[] m7489$values() {
        return new TrySelectDetailedResult[]{SUCCESSFUL, REREGISTER, CANCELLED, ALREADY_SELECTED};
    }

    static {
        TrySelectDetailedResult[] trySelectDetailedResultArrM7489$values = m7489$values();
        f7254$VALUES = trySelectDetailedResultArrM7489$values;
        $ENTRIES = EnumEntriesKt.enumEntries(trySelectDetailedResultArrM7489$values);
    }

    private TrySelectDetailedResult(String str, int i) {
    }

    public static EnumEntries<TrySelectDetailedResult> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static TrySelectDetailedResult m7490valueOf(String str) {
        return (TrySelectDetailedResult) Enum.valueOf(TrySelectDetailedResult.class, str);
    }

    /* renamed from: values */
    public static TrySelectDetailedResult[] m7491values() {
        return (TrySelectDetailedResult[]) f7254$VALUES.clone();
    }
}
