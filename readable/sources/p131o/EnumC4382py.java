package p131o;

import org.conscrypt.BuildConfig;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'wA' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* renamed from: o.py */
/* loaded from: classes.dex */
public final class EnumC4382py {

    /* renamed from: AZxh */
    public static final EnumC4382py f15991AZxh;

    /* renamed from: Dt */
    public static final EnumC4382py f15992Dt;

    /* renamed from: ETF */
    public static final EnumC4382py f15993ETF;

    /* renamed from: JHa */
    public static final EnumC4382py f15994JHa;

    /* renamed from: KLFTb */
    public static final EnumC4382py f15995KLFTb;

    /* renamed from: VA */
    public static final /* synthetic */ EnumC4382py[] f15996VA;

    /* renamed from: ZfxDd */
    public static final EnumC4382py f15997ZfxDd;

    /* renamed from: lgHUyS */
    public static final EnumC4382py f15998lgHUyS;

    /* renamed from: qdMbNW */
    public static final EnumC4382py f15999qdMbNW;

    /* renamed from: wA */
    public static final EnumC4382py f16000wA;

    /* renamed from: xJ */
    public static final EnumC4382py f16001xJ;

    /* renamed from: mjFkc */
    public final Class f16002mjFkc;

    static {
        EnumC4382py enumC4382py = new EnumC4382py("VOID", 0, Void.class, Void.class, null);
        f15991AZxh = enumC4382py;
        Class cls = Integer.TYPE;
        EnumC4382py enumC4382py2 = new EnumC4382py("INT", 1, cls, Integer.class, 0);
        f16000wA = enumC4382py2;
        EnumC4382py enumC4382py3 = new EnumC4382py("LONG", 2, Long.TYPE, Long.class, 0L);
        f15997ZfxDd = enumC4382py3;
        EnumC4382py enumC4382py4 = new EnumC4382py("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f15995KLFTb = enumC4382py4;
        EnumC4382py enumC4382py5 = new EnumC4382py("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f15994JHa = enumC4382py5;
        EnumC4382py enumC4382py6 = new EnumC4382py("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f16001xJ = enumC4382py6;
        EnumC4382py enumC4382py7 = new EnumC4382py("STRING", 6, String.class, String.class, BuildConfig.f24315FLAVOR);
        f15998lgHUyS = enumC4382py7;
        EnumC4382py enumC4382py8 = new EnumC4382py("BYTE_STRING", 7, AbstractC4981yx.class, AbstractC4981yx.class, AbstractC4981yx.f17599AZxh);
        f15999qdMbNW = enumC4382py8;
        EnumC4382py enumC4382py9 = new EnumC4382py("ENUM", 8, cls, Integer.class, null);
        f15992Dt = enumC4382py9;
        EnumC4382py enumC4382py10 = new EnumC4382py("MESSAGE", 9, Object.class, Object.class, null);
        f15993ETF = enumC4382py10;
        f15996VA = new EnumC4382py[]{enumC4382py, enumC4382py2, enumC4382py3, enumC4382py4, enumC4382py5, enumC4382py6, enumC4382py7, enumC4382py8, enumC4382py9, enumC4382py10};
    }

    public EnumC4382py(String str, int i, Class cls, Class cls2, Object obj) {
        this.f16002mjFkc = cls2;
    }

    /* renamed from: values */
    public static EnumC4382py[] m13148values() {
        return (EnumC4382py[]) f15996VA.clone();
    }

    /* renamed from: KLFTb */
    public final Class m13149KLFTb() {
        return this.f16002mjFkc;
    }
}
