package p094kotlin.annotation;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m4988d2 = {"Lkotlin/annotation/AnnotationRetention;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SOURCE", "BINARY", "RUNTIME", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AnnotationRetention {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ AnnotationRetention[] f4922$VALUES;

    /* renamed from: SOURCE */
    public static final AnnotationRetention f4925SOURCE = new AnnotationRetention("SOURCE", 0);

    /* renamed from: BINARY */
    public static final AnnotationRetention f4923BINARY = new AnnotationRetention("BINARY", 1);

    /* renamed from: RUNTIME */
    public static final AnnotationRetention f4924RUNTIME = new AnnotationRetention("RUNTIME", 2);

    /* renamed from: $values */
    private static final /* synthetic */ AnnotationRetention[] m5103$values() {
        return new AnnotationRetention[]{f4925SOURCE, f4923BINARY, f4924RUNTIME};
    }

    static {
        AnnotationRetention[] annotationRetentionArrM5103$values = m5103$values();
        f4922$VALUES = annotationRetentionArrM5103$values;
        $ENTRIES = EnumEntriesKt.enumEntries(annotationRetentionArrM5103$values);
    }

    private AnnotationRetention(String str, int i) {
    }

    public static EnumEntries<AnnotationRetention> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static AnnotationRetention m5104valueOf(String str) {
        return (AnnotationRetention) Enum.valueOf(AnnotationRetention.class, str);
    }

    /* renamed from: values */
    public static AnnotationRetention[] m5105values() {
        return (AnnotationRetention[]) f4922$VALUES.clone();
    }
}
