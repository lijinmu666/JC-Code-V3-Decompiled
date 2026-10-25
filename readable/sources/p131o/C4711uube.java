package p131o;

import android.content.Context;
import android.graphics.Color;

/* renamed from: o.uube */
/* loaded from: classes.dex */
public class C4711uube {

    /* renamed from: JHa */
    public static final int f16923JHa = (int) Math.round(5.1000000000000005d);

    /* renamed from: AZxh */
    public final int f16924AZxh;

    /* renamed from: KLFTb */
    public final float f16925KLFTb;

    /* renamed from: ZfxDd */
    public final int f16926ZfxDd;

    /* renamed from: mjFkc */
    public final boolean f16927mjFkc;

    /* renamed from: wA */
    public final int f16928wA;

    public C4711uube(Context context) {
        this(AbstractC1931F1.m8245AZxh(context, AbstractC3800h4.f13936VA, false), AbstractC2345L1.m9298AZxh(context, AbstractC3800h4.f13924ETF, 0), AbstractC2345L1.m9298AZxh(context, AbstractC3800h4.f13923Dt, 0), AbstractC2345L1.m9298AZxh(context, AbstractC3800h4.f13945lgHUyS, 0), context.getResources().getDisplayMetrics().density);
    }

    /* renamed from: AZxh */
    public int m13731AZxh(int i, float f) {
        int i2;
        float fM13734mjFkc = m13734mjFkc(f);
        int iAlpha = Color.alpha(i);
        int iM9306qdMbNW = AbstractC2345L1.m9306qdMbNW(AbstractC4898xfXeiC.m13959ETF(i, 255), this.f16924AZxh, fM13734mjFkc);
        if (fM13734mjFkc > 0.0f && (i2 = this.f16928wA) != 0) {
            iM9306qdMbNW = AbstractC2345L1.m9304lgHUyS(iM9306qdMbNW, AbstractC4898xfXeiC.m13959ETF(i2, f16923JHa));
        }
        return AbstractC4898xfXeiC.m13959ETF(iM9306qdMbNW, iAlpha);
    }

    /* renamed from: KLFTb */
    public final boolean m13732KLFTb(int i) {
        return AbstractC4898xfXeiC.m13959ETF(i, 255) == this.f16926ZfxDd;
    }

    /* renamed from: ZfxDd */
    public boolean m13733ZfxDd() {
        return this.f16927mjFkc;
    }

    /* renamed from: mjFkc */
    public float m13734mjFkc(float f) {
        if (this.f16925KLFTb <= 0.0f || f <= 0.0f) {
            return 0.0f;
        }
        return Math.min(((((float) Math.log1p(f / r2)) * 4.5f) + 2.0f) / 100.0f, 1.0f);
    }

    /* renamed from: wA */
    public int m13735wA(int i, float f) {
        return (this.f16927mjFkc && m13732KLFTb(i)) ? m13731AZxh(i, f) : i;
    }

    public C4711uube(boolean z, int i, int i2, int i3, float f) {
        this.f16927mjFkc = z;
        this.f16924AZxh = i;
        this.f16928wA = i2;
        this.f16926ZfxDd = i3;
        this.f16925KLFTb = f;
    }
}
