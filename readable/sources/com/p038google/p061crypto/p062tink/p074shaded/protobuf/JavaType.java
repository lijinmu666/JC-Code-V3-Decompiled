package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import org.conscrypt.BuildConfig;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class JavaType {

    /* renamed from: $VALUES */
    private static final /* synthetic */ JavaType[] f3698$VALUES;

    /* renamed from: BOOLEAN */
    public static final JavaType f3699BOOLEAN;
    public static final JavaType BYTE_STRING;

    /* renamed from: DOUBLE */
    public static final JavaType f3700DOUBLE;

    /* renamed from: ENUM */
    public static final JavaType f3701ENUM;

    /* renamed from: FLOAT */
    public static final JavaType f3702FLOAT;

    /* renamed from: INT */
    public static final JavaType f3703INT;

    /* renamed from: LONG */
    public static final JavaType f3704LONG;

    /* renamed from: MESSAGE */
    public static final JavaType f3705MESSAGE;

    /* renamed from: STRING */
    public static final JavaType f3706STRING;

    /* renamed from: VOID */
    public static final JavaType f3707VOID;
    private final Class<?> boxedType;
    private final Object defaultDefault;

    /* renamed from: type */
    private final Class<?> f3708type;

    static {
        JavaType javaType = new JavaType("VOID", 0, Void.class, Void.class, null);
        f3707VOID = javaType;
        Class cls = Integer.TYPE;
        JavaType javaType2 = new JavaType("INT", 1, cls, Integer.class, 0);
        f3703INT = javaType2;
        JavaType javaType3 = new JavaType("LONG", 2, Long.TYPE, Long.class, 0L);
        f3704LONG = javaType3;
        JavaType javaType4 = new JavaType("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f3702FLOAT = javaType4;
        JavaType javaType5 = new JavaType("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f3700DOUBLE = javaType5;
        JavaType javaType6 = new JavaType("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f3699BOOLEAN = javaType6;
        JavaType javaType7 = new JavaType("STRING", 6, String.class, String.class, BuildConfig.f24315FLAVOR);
        f3706STRING = javaType7;
        JavaType javaType8 = new JavaType("BYTE_STRING", 7, ByteString.class, ByteString.class, ByteString.f3559EMPTY);
        BYTE_STRING = javaType8;
        JavaType javaType9 = new JavaType("ENUM", 8, cls, Integer.class, null);
        f3701ENUM = javaType9;
        JavaType javaType10 = new JavaType("MESSAGE", 9, Object.class, Object.class, null);
        f3705MESSAGE = javaType10;
        f3698$VALUES = new JavaType[]{javaType, javaType2, javaType3, javaType4, javaType5, javaType6, javaType7, javaType8, javaType9, javaType10};
    }

    private JavaType(String str, int i, Class cls, Class cls2, Object obj) {
        this.f3708type = cls;
        this.boxedType = cls2;
        this.defaultDefault = obj;
    }

    /* renamed from: valueOf */
    public static JavaType m4047valueOf(String str) {
        return (JavaType) Enum.valueOf(JavaType.class, str);
    }

    /* renamed from: values */
    public static JavaType[] m4048values() {
        return (JavaType[]) f3698$VALUES.clone();
    }

    public Class<?> getBoxedType() {
        return this.boxedType;
    }

    public Object getDefaultDefault() {
        return this.defaultDefault;
    }

    /* renamed from: getType */
    public Class<?> m4049getType() {
        return this.f3708type;
    }

    public boolean isValidType(Class<?> cls) {
        return this.f3708type.isAssignableFrom(cls);
    }
}
