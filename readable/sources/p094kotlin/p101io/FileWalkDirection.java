package p094kotlin.p101io;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m4988d2 = {"Lkotlin/io/FileWalkDirection;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "TOP_DOWN", "BOTTOM_UP", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class FileWalkDirection {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ FileWalkDirection[] f5071$VALUES;
    public static final FileWalkDirection TOP_DOWN = new FileWalkDirection("TOP_DOWN", 0);
    public static final FileWalkDirection BOTTOM_UP = new FileWalkDirection("BOTTOM_UP", 1);

    /* renamed from: $values */
    private static final /* synthetic */ FileWalkDirection[] m6190$values() {
        return new FileWalkDirection[]{TOP_DOWN, BOTTOM_UP};
    }

    static {
        FileWalkDirection[] fileWalkDirectionArrM6190$values = m6190$values();
        f5071$VALUES = fileWalkDirectionArrM6190$values;
        $ENTRIES = EnumEntriesKt.enumEntries(fileWalkDirectionArrM6190$values);
    }

    private FileWalkDirection(String str, int i) {
    }

    public static EnumEntries<FileWalkDirection> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static FileWalkDirection m6191valueOf(String str) {
        return (FileWalkDirection) Enum.valueOf(FileWalkDirection.class, str);
    }

    /* renamed from: values */
    public static FileWalkDirection[] m6192values() {
        return (FileWalkDirection[]) f5071$VALUES.clone();
    }
}
