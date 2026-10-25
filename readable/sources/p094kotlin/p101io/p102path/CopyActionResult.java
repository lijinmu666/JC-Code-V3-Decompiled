package p094kotlin.p101io.p102path;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(m5061version = "1.8")
@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006Ê\u0001\u0002\b\bÊ\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¨\u0006\u0007"}, m4988d2 = {"Lkotlin/io/path/CopyActionResult;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CONTINUE", "SKIP_SUBTREE", "TERMINATE", "kotlin-stdlib-jdk7", "Lkotlin/io/path/ExperimentalPathApi;", "Lkotlin/SinceKotlin;", "version", "1.8"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@ExperimentalPathApi
/* loaded from: classes.dex */
public final class CopyActionResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ CopyActionResult[] f5097$VALUES;
    public static final CopyActionResult CONTINUE = new CopyActionResult("CONTINUE", 0);
    public static final CopyActionResult SKIP_SUBTREE = new CopyActionResult("SKIP_SUBTREE", 1);
    public static final CopyActionResult TERMINATE = new CopyActionResult("TERMINATE", 2);

    /* renamed from: $values */
    private static final /* synthetic */ CopyActionResult[] m6220$values() {
        return new CopyActionResult[]{CONTINUE, SKIP_SUBTREE, TERMINATE};
    }

    static {
        CopyActionResult[] copyActionResultArrM6220$values = m6220$values();
        f5097$VALUES = copyActionResultArrM6220$values;
        $ENTRIES = EnumEntriesKt.enumEntries(copyActionResultArrM6220$values);
    }

    private CopyActionResult(String str, int i) {
    }

    public static EnumEntries<CopyActionResult> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static CopyActionResult m6221valueOf(String str) {
        return (CopyActionResult) Enum.valueOf(CopyActionResult.class, str);
    }

    /* renamed from: values */
    public static CopyActionResult[] m6222values() {
        return (CopyActionResult[]) f5097$VALUES.clone();
    }
}
