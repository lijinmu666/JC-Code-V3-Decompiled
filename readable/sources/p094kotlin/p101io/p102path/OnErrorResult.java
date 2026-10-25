package p094kotlin.p101io.p102path;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(m5061version = "1.8")
@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005Ê\u0001\u0002\b\u0007Ê\u0001\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n¨\u0006\u0006"}, m4988d2 = {"Lkotlin/io/path/OnErrorResult;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SKIP_SUBTREE", "TERMINATE", "kotlin-stdlib-jdk7", "Lkotlin/io/path/ExperimentalPathApi;", "Lkotlin/SinceKotlin;", "version", "1.8"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@ExperimentalPathApi
/* loaded from: classes.dex */
public final class OnErrorResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ OnErrorResult[] f5113$VALUES;
    public static final OnErrorResult SKIP_SUBTREE = new OnErrorResult("SKIP_SUBTREE", 0);
    public static final OnErrorResult TERMINATE = new OnErrorResult("TERMINATE", 1);

    /* renamed from: $values */
    private static final /* synthetic */ OnErrorResult[] m6227$values() {
        return new OnErrorResult[]{SKIP_SUBTREE, TERMINATE};
    }

    static {
        OnErrorResult[] onErrorResultArrM6227$values = m6227$values();
        f5113$VALUES = onErrorResultArrM6227$values;
        $ENTRIES = EnumEntriesKt.enumEntries(onErrorResultArrM6227$values);
    }

    private OnErrorResult(String str, int i) {
    }

    public static EnumEntries<OnErrorResult> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static OnErrorResult m6228valueOf(String str) {
        return (OnErrorResult) Enum.valueOf(OnErrorResult.class, str);
    }

    /* renamed from: values */
    public static OnErrorResult[] m6229values() {
        return (OnErrorResult[]) f5113$VALUES.clone();
    }
}
