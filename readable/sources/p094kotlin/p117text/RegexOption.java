package p094kotlin.p117text;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\bB\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0003\u001a\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0005\u001a\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m4988d2 = {"Lkotlin/text/RegexOption;", "Lkotlin/text/FlagEnum;", BuildConfig.f24315FLAVOR, "value", BuildConfig.f24315FLAVOR, "mask", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getMask", "IGNORE_CASE", "MULTILINE", "LITERAL", "UNIX_LINES", "COMMENTS", "DOT_MATCHES_ALL", "CANON_EQ", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class RegexOption implements FlagEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ RegexOption[] f5404$VALUES;
    public static final RegexOption CANON_EQ;
    public static final RegexOption COMMENTS;
    public static final RegexOption DOT_MATCHES_ALL;
    public static final RegexOption IGNORE_CASE;

    /* renamed from: LITERAL */
    public static final RegexOption f5405LITERAL;
    public static final RegexOption MULTILINE;
    public static final RegexOption UNIX_LINES;
    private final int mask;
    private final int value;

    /* renamed from: $values */
    private static final /* synthetic */ RegexOption[] m6708$values() {
        return new RegexOption[]{IGNORE_CASE, MULTILINE, f5405LITERAL, UNIX_LINES, COMMENTS, DOT_MATCHES_ALL, CANON_EQ};
    }

    static {
        int i = 2;
        IGNORE_CASE = new RegexOption("IGNORE_CASE", 0, i, 0, 2, null);
        int i2 = 2;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i3 = 0;
        MULTILINE = new RegexOption("MULTILINE", 1, 8, i3, i2, defaultConstructorMarker);
        int i4 = 2;
        DefaultConstructorMarker defaultConstructorMarker2 = null;
        int i5 = 0;
        f5405LITERAL = new RegexOption("LITERAL", i, 16, i5, i4, defaultConstructorMarker2);
        UNIX_LINES = new RegexOption("UNIX_LINES", 3, 1, i3, i2, defaultConstructorMarker);
        COMMENTS = new RegexOption("COMMENTS", 4, 4, i5, i4, defaultConstructorMarker2);
        DOT_MATCHES_ALL = new RegexOption("DOT_MATCHES_ALL", 5, 32, i3, i2, defaultConstructorMarker);
        CANON_EQ = new RegexOption("CANON_EQ", 6, 128, i5, i4, defaultConstructorMarker2);
        RegexOption[] regexOptionArrM6708$values = m6708$values();
        f5404$VALUES = regexOptionArrM6708$values;
        $ENTRIES = EnumEntriesKt.enumEntries(regexOptionArrM6708$values);
    }

    private RegexOption(String str, int i, int i2, int i3) {
        this.value = i2;
        this.mask = i3;
    }

    public static EnumEntries<RegexOption> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static RegexOption m6709valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    /* renamed from: values */
    public static RegexOption[] m6710values() {
        return (RegexOption[]) f5404$VALUES.clone();
    }

    @Override // p094kotlin.p117text.FlagEnum
    public int getMask() {
        return this.mask;
    }

    @Override // p094kotlin.p117text.FlagEnum
    public int getValue() {
        return this.value;
    }

    public /* synthetic */ RegexOption(String str, int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, (i4 & 2) != 0 ? i2 : i3);
    }
}
