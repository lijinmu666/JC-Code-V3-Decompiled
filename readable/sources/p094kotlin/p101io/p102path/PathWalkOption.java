package p094kotlin.p101io.p102path;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(m5061version = "2.1")
@Metadata(m4987d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006Ê\u0001\u0010\b\b\u0012\f\b\t\u0012\b\b\fJ\u0004\b\t0\nÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¨\u0006\u0007"}, m4988d2 = {"Lkotlin/io/path/PathWalkOption;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "INCLUDE_DIRECTORIES", "BREADTH_FIRST", "FOLLOW_LINKS", "kotlin-stdlib-jdk7", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/io/path/ExperimentalPathApi;", "Lkotlin/SinceKotlin;", "version", "2.1"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalPathApi.class})
/* loaded from: classes.dex */
public final class PathWalkOption {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ PathWalkOption[] f5144$VALUES;
    public static final PathWalkOption INCLUDE_DIRECTORIES = new PathWalkOption("INCLUDE_DIRECTORIES", 0);
    public static final PathWalkOption BREADTH_FIRST = new PathWalkOption("BREADTH_FIRST", 1);
    public static final PathWalkOption FOLLOW_LINKS = new PathWalkOption("FOLLOW_LINKS", 2);

    /* renamed from: $values */
    private static final /* synthetic */ PathWalkOption[] m6234$values() {
        return new PathWalkOption[]{INCLUDE_DIRECTORIES, BREADTH_FIRST, FOLLOW_LINKS};
    }

    static {
        PathWalkOption[] pathWalkOptionArrM6234$values = m6234$values();
        f5144$VALUES = pathWalkOptionArrM6234$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pathWalkOptionArrM6234$values);
    }

    private PathWalkOption(String str, int i) {
    }

    public static EnumEntries<PathWalkOption> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static PathWalkOption m6235valueOf(String str) {
        return (PathWalkOption) Enum.valueOf(PathWalkOption.class, str);
    }

    /* renamed from: values */
    public static PathWalkOption[] m6236values() {
        return (PathWalkOption[]) f5144$VALUES.clone();
    }
}
