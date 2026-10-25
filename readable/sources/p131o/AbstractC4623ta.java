package p131o;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;

/* renamed from: o.ta */
/* loaded from: classes.dex */
public abstract class AbstractC4623ta {

    /* renamed from: mjFkc */
    public static final AbstractC1634Aa f16704mjFkc = new C5020za();

    /* renamed from: AZxh */
    public static final Property f16703AZxh = new mjFkc(Float.class, "translationAlpha");

    /* renamed from: wA */
    public static final Property f16705wA = new AZxh(Rect.class, "clipBounds");

    /* renamed from: o.ta$AZxh */
    public static class AZxh extends Property {
        public AZxh(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            AbstractC2876T9.m10243Moer(view, rect);
        }

        @Override // android.util.Property
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return AbstractC2876T9.m10285qGY(view);
        }
    }

    /* renamed from: o.ta$mjFkc */
    public static class mjFkc extends Property {
        public mjFkc(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            AbstractC4623ta.m13638xJ(view, f.floatValue());
        }

        @Override // android.util.Property
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(AbstractC4623ta.m13637wA(view));
        }
    }

    /* renamed from: AZxh */
    public static InterfaceC4223na m13629AZxh(View view) {
        return new C4158ma(view);
    }

    /* renamed from: Dt */
    public static void m13630Dt(View view, Matrix matrix) {
        f16704mjFkc.mo7616lgHUyS(view, matrix);
    }

    /* renamed from: JHa */
    public static void m13631JHa(View view, int i, int i2, int i3, int i4) {
        f16704mjFkc.mo7615ZfxDd(view, i, i2, i3, i4);
    }

    /* renamed from: KLFTb */
    public static void m13632KLFTb(View view) {
        f16704mjFkc.mo7618wA(view);
    }

    /* renamed from: ZfxDd */
    public static InterfaceC2445Ma m13633ZfxDd(View view) {
        return new C2377La(view);
    }

    /* renamed from: lgHUyS */
    public static void m13634lgHUyS(View view, int i) {
        f16704mjFkc.mo7613JHa(view, i);
    }

    /* renamed from: mjFkc */
    public static void m13635mjFkc(View view) {
        f16704mjFkc.mo7617mjFkc(view);
    }

    /* renamed from: qdMbNW */
    public static void m13636qdMbNW(View view, Matrix matrix) {
        f16704mjFkc.mo7619xJ(view, matrix);
    }

    /* renamed from: wA */
    public static float m13637wA(View view) {
        return f16704mjFkc.mo7612AZxh(view);
    }

    /* renamed from: xJ */
    public static void m13638xJ(View view, float f) {
        f16704mjFkc.mo7614KLFTb(view, f);
    }
}
