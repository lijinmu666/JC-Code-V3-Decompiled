package p094kotlin.annotation;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0010\b\u0012\u0012\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¨\u0006\u0016"}, m4988d2 = {"Lkotlin/annotation/AnnotationTarget;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "CLASS", "ANNOTATION_CLASS", "TYPE_PARAMETER", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPE", "EXPRESSION", "FILE", "TYPEALIAS", "Lkotlin/SinceKotlin;", "version", "1.1", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AnnotationTarget {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ AnnotationTarget[] f4926$VALUES;

    /* renamed from: CLASS */
    public static final AnnotationTarget f4927CLASS = new AnnotationTarget("CLASS", 0);
    public static final AnnotationTarget ANNOTATION_CLASS = new AnnotationTarget("ANNOTATION_CLASS", 1);
    public static final AnnotationTarget TYPE_PARAMETER = new AnnotationTarget("TYPE_PARAMETER", 2);
    public static final AnnotationTarget PROPERTY = new AnnotationTarget("PROPERTY", 3);

    /* renamed from: FIELD */
    public static final AnnotationTarget f4928FIELD = new AnnotationTarget("FIELD", 4);
    public static final AnnotationTarget LOCAL_VARIABLE = new AnnotationTarget("LOCAL_VARIABLE", 5);
    public static final AnnotationTarget VALUE_PARAMETER = new AnnotationTarget("VALUE_PARAMETER", 6);
    public static final AnnotationTarget CONSTRUCTOR = new AnnotationTarget("CONSTRUCTOR", 7);
    public static final AnnotationTarget FUNCTION = new AnnotationTarget("FUNCTION", 8);
    public static final AnnotationTarget PROPERTY_GETTER = new AnnotationTarget("PROPERTY_GETTER", 9);
    public static final AnnotationTarget PROPERTY_SETTER = new AnnotationTarget("PROPERTY_SETTER", 10);

    /* renamed from: TYPE */
    public static final AnnotationTarget f4930TYPE = new AnnotationTarget("TYPE", 11);
    public static final AnnotationTarget EXPRESSION = new AnnotationTarget("EXPRESSION", 12);

    /* renamed from: FILE */
    public static final AnnotationTarget f4929FILE = new AnnotationTarget("FILE", 13);

    @SinceKotlin(m5061version = "1.1")
    public static final AnnotationTarget TYPEALIAS = new AnnotationTarget("TYPEALIAS", 14);

    /* renamed from: $values */
    private static final /* synthetic */ AnnotationTarget[] m5106$values() {
        return new AnnotationTarget[]{f4927CLASS, ANNOTATION_CLASS, TYPE_PARAMETER, PROPERTY, f4928FIELD, LOCAL_VARIABLE, VALUE_PARAMETER, CONSTRUCTOR, FUNCTION, PROPERTY_GETTER, PROPERTY_SETTER, f4930TYPE, EXPRESSION, f4929FILE, TYPEALIAS};
    }

    static {
        AnnotationTarget[] annotationTargetArrM5106$values = m5106$values();
        f4926$VALUES = annotationTargetArrM5106$values;
        $ENTRIES = EnumEntriesKt.enumEntries(annotationTargetArrM5106$values);
    }

    private AnnotationTarget(String str, int i) {
    }

    public static EnumEntries<AnnotationTarget> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static AnnotationTarget m5107valueOf(String str) {
        return (AnnotationTarget) Enum.valueOf(AnnotationTarget.class, str);
    }

    /* renamed from: values */
    public static AnnotationTarget[] m5108values() {
        return (AnnotationTarget[]) f4926$VALUES.clone();
    }
}
