package p131o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import p131o.C4525s5;

/* renamed from: o.bbzow */
/* loaded from: classes.dex */
public final class C3442bbzow {

    /* renamed from: AZxh */
    public static final PorterDuff.Mode f13115AZxh = PorterDuff.Mode.SRC_IN;

    /* renamed from: wA */
    public static C3442bbzow f13116wA;

    /* renamed from: mjFkc */
    public C4525s5 f13117mjFkc;

    /* renamed from: o.bbzow$mjFkc */
    public class mjFkc implements C4525s5.wA {

        /* renamed from: mjFkc */
        public final int[] f13122mjFkc = {AbstractC4591t4.f16625aqHPIZ, AbstractC4591t4.f16641vadzgd, AbstractC4591t4.f16634mjFkc};

        /* renamed from: AZxh */
        public final int[] f13118AZxh = {AbstractC4591t4.f16639rkYL, AbstractC4591t4.f16603BAnRFn, AbstractC4591t4.f16627diqgf, AbstractC4591t4.f16636qGY, AbstractC4591t4.f16629fehf, AbstractC4591t4.f16617Pq, AbstractC4591t4.f16609IEE};

        /* renamed from: wA */
        public final int[] f13123wA = {AbstractC4591t4.f16614NPj, AbstractC4591t4.f16635oCFDzJ, AbstractC4591t4.f16606ETF, AbstractC4591t4.f16646zvd, AbstractC4591t4.f16626cMLeY, AbstractC4591t4.f16638rWxwaT, AbstractC4591t4.f16620Vnb};

        /* renamed from: ZfxDd */
        public final int[] f13121ZfxDd = {AbstractC4591t4.f16630huTpC, AbstractC4591t4.f16637qdMbNW, AbstractC4591t4.f16618Ucbh};

        /* renamed from: KLFTb */
        public final int[] f13120KLFTb = {AbstractC4591t4.f16612KLMXS, AbstractC4591t4.f16622WrLQs};

        /* renamed from: JHa */
        public final int[] f13119JHa = {AbstractC4591t4.f16642wA, AbstractC4591t4.f16644xJ, AbstractC4591t4.f16624ZfxDd, AbstractC4591t4.f16632lgHUyS};

        @Override // p131o.C4525s5.wA
        /* renamed from: AZxh */
        public Drawable mo11539AZxh(C4525s5 c4525s5, Context context, int i) {
            if (i == AbstractC4591t4.f16605Dt) {
                return new LayerDrawable(new Drawable[]{c4525s5.m13476qdMbNW(context, AbstractC4591t4.f16637qdMbNW), c4525s5.m13476qdMbNW(context, AbstractC4591t4.f16606ETF)});
            }
            if (i == AbstractC4591t4.f16608HGpJ) {
                return m11545VA(c4525s5, context, AbstractC4256o4.f15505xJ);
            }
            if (i == AbstractC4591t4.f16607Gd) {
                return m11545VA(c4525s5, context, AbstractC4256o4.f15501lgHUyS);
            }
            if (i == AbstractC4591t4.f16640vI) {
                return m11545VA(c4525s5, context, AbstractC4256o4.f15503qdMbNW);
            }
            return null;
        }

        /* renamed from: Dt */
        public final ColorStateList m11540Dt(Context context) {
            return m11547lgHUyS(context, AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14118qdMbNW));
        }

        /* renamed from: ETF */
        public final ColorStateList m11541ETF(Context context) {
            int[][] iArr = new int[3][];
            int[] iArr2 = new int[3];
            ColorStateList colorStateListM13065KLFTb = AbstractC4326p8.m13065KLFTb(context, AbstractC3862i4.f14108MiMN);
            if (colorStateListM13065KLFTb == null || !colorStateListM13065KLFTb.isStateful()) {
                iArr[0] = AbstractC4326p8.f15900AZxh;
                iArr2[0] = AbstractC4326p8.m13063AZxh(context, AbstractC3862i4.f14108MiMN);
                iArr[1] = AbstractC4326p8.f15902JHa;
                iArr2[1] = AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14103Dt);
                iArr[2] = AbstractC4326p8.f15907qdMbNW;
                iArr2[2] = AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14108MiMN);
            } else {
                int[] iArr3 = AbstractC4326p8.f15900AZxh;
                iArr[0] = iArr3;
                iArr2[0] = colorStateListM13065KLFTb.getColorForState(iArr3, 0);
                iArr[1] = AbstractC4326p8.f15902JHa;
                iArr2[1] = AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14103Dt);
                iArr[2] = AbstractC4326p8.f15907qdMbNW;
                iArr2[2] = colorStateListM13065KLFTb.getDefaultColor();
            }
            return new ColorStateList(iArr, iArr2);
        }

        /* renamed from: JHa */
        public final boolean m11542JHa(int[] iArr, int i) {
            for (int i2 : iArr) {
                if (i2 == i) {
                    return true;
                }
            }
            return false;
        }

        @Override // p131o.C4525s5.wA
        /* renamed from: KLFTb */
        public boolean mo11543KLFTb(Context context, int i, Drawable drawable) {
            if (i == AbstractC4591t4.f16631lB) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                m11544MiMN(layerDrawable.findDrawableByLayerId(R.id.background), AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14110VA), C3442bbzow.f13115AZxh);
                m11544MiMN(layerDrawable.findDrawableByLayerId(R.id.secondaryProgress), AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14110VA), C3442bbzow.f13115AZxh);
                m11544MiMN(layerDrawable.findDrawableByLayerId(R.id.progress), AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14103Dt), C3442bbzow.f13115AZxh);
                return true;
            }
            if (i != AbstractC4591t4.f16608HGpJ && i != AbstractC4591t4.f16607Gd && i != AbstractC4591t4.f16640vI) {
                return false;
            }
            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
            m11544MiMN(layerDrawable2.findDrawableByLayerId(R.id.background), AbstractC4326p8.m13063AZxh(context, AbstractC3862i4.f14110VA), C3442bbzow.f13115AZxh);
            m11544MiMN(layerDrawable2.findDrawableByLayerId(R.id.secondaryProgress), AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14103Dt), C3442bbzow.f13115AZxh);
            m11544MiMN(layerDrawable2.findDrawableByLayerId(R.id.progress), AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14103Dt), C3442bbzow.f13115AZxh);
            return true;
        }

        /* renamed from: MiMN */
        public final void m11544MiMN(Drawable drawable, int i, PorterDuff.Mode mode) {
            if (AbstractC3397awnh.m11434mjFkc(drawable)) {
                drawable = drawable.mutate();
            }
            if (mode == null) {
                mode = C3442bbzow.f13115AZxh;
            }
            drawable.setColorFilter(C3442bbzow.m11534ZfxDd(i, mode));
        }

        /* renamed from: VA */
        public final LayerDrawable m11545VA(C4525s5 c4525s5, Context context, int i) throws Resources.NotFoundException {
            BitmapDrawable bitmapDrawable;
            BitmapDrawable bitmapDrawable2;
            BitmapDrawable bitmapDrawable3;
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
            Drawable drawableM13476qdMbNW = c4525s5.m13476qdMbNW(context, AbstractC4591t4.f16616OjSQV);
            Drawable drawableM13476qdMbNW2 = c4525s5.m13476qdMbNW(context, AbstractC4591t4.f16615Ne);
            if ((drawableM13476qdMbNW instanceof BitmapDrawable) && drawableM13476qdMbNW.getIntrinsicWidth() == dimensionPixelSize && drawableM13476qdMbNW.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable = (BitmapDrawable) drawableM13476qdMbNW;
                bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                drawableM13476qdMbNW.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableM13476qdMbNW.draw(canvas);
                bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
                bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
            }
            bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
            if ((drawableM13476qdMbNW2 instanceof BitmapDrawable) && drawableM13476qdMbNW2.getIntrinsicWidth() == dimensionPixelSize && drawableM13476qdMbNW2.getIntrinsicHeight() == dimensionPixelSize) {
                bitmapDrawable3 = (BitmapDrawable) drawableM13476qdMbNW2;
            } else {
                Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
                drawableM13476qdMbNW2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                drawableM13476qdMbNW2.draw(canvas2);
                bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
            }
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
            layerDrawable.setId(0, R.id.background);
            layerDrawable.setId(1, R.id.secondaryProgress);
            layerDrawable.setId(2, R.id.progress);
            return layerDrawable;
        }

        @Override // p131o.C4525s5.wA
        /* renamed from: ZfxDd */
        public ColorStateList mo11546ZfxDd(Context context, int i) {
            if (i == AbstractC4591t4.f16613MiMN) {
                return AbstractC4768vjlshU.m13795mjFkc(context, AbstractC4061l4.f14670wA);
            }
            if (i == AbstractC4591t4.f16645xrEuO) {
                return AbstractC4768vjlshU.m13795mjFkc(context, AbstractC4061l4.f14666JHa);
            }
            if (i == AbstractC4591t4.f16604CqaNbM) {
                return m11541ETF(context);
            }
            if (i == AbstractC4591t4.f16610JHa) {
                return m11540Dt(context);
            }
            if (i == AbstractC4591t4.f16602AZxh) {
                return m11551xJ(context);
            }
            if (i == AbstractC4591t4.f16611KLFTb) {
                return m11549qdMbNW(context);
            }
            if (i == AbstractC4591t4.f16643wJVbdd || i == AbstractC4591t4.f16633mByQ) {
                return AbstractC4768vjlshU.m13795mjFkc(context, AbstractC4061l4.f14667KLFTb);
            }
            if (m11542JHa(this.f13118AZxh, i)) {
                return AbstractC4326p8.m13065KLFTb(context, AbstractC3862i4.f14110VA);
            }
            if (m11542JHa(this.f13120KLFTb, i)) {
                return AbstractC4768vjlshU.m13795mjFkc(context, AbstractC4061l4.f14665AZxh);
            }
            if (m11542JHa(this.f13119JHa, i)) {
                return AbstractC4768vjlshU.m13795mjFkc(context, AbstractC4061l4.f14669mjFkc);
            }
            if (i == AbstractC4591t4.f16621VocHEe) {
                return AbstractC4768vjlshU.m13795mjFkc(context, AbstractC4061l4.f14668ZfxDd);
            }
            return null;
        }

        /* renamed from: lgHUyS */
        public final ColorStateList m11547lgHUyS(Context context, int i) {
            int iM13068wA = AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14104ETF);
            return new ColorStateList(new int[][]{AbstractC4326p8.f15900AZxh, AbstractC4326p8.f15903KLFTb, AbstractC4326p8.f15908wA, AbstractC4326p8.f15907qdMbNW}, new int[]{AbstractC4326p8.m13063AZxh(context, AbstractC3862i4.f14118qdMbNW), AbstractC4898xfXeiC.m13967xJ(iM13068wA, i), AbstractC4898xfXeiC.m13967xJ(iM13068wA, i), i});
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0066 A[RETURN] */
        @Override // p131o.C4525s5.wA
        /* renamed from: mjFkc */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean mo11548mjFkc(Context context, int i, Drawable drawable) {
            int i2;
            boolean z;
            int iRound;
            PorterDuff.Mode mode = C3442bbzow.f13115AZxh;
            if (m11542JHa(this.f13122mjFkc, i)) {
                i2 = AbstractC3862i4.f14110VA;
            } else if (m11542JHa(this.f13123wA, i)) {
                i2 = AbstractC3862i4.f14103Dt;
            } else {
                if (m11542JHa(this.f13121ZfxDd, i)) {
                    mode = PorterDuff.Mode.MULTIPLY;
                } else {
                    if (i == AbstractC4591t4.f16628eyqo) {
                        z = true;
                        iRound = Math.round(40.8f);
                        i2 = 16842800;
                        if (!z) {
                            return false;
                        }
                        if (AbstractC3397awnh.m11434mjFkc(drawable)) {
                            drawable = drawable.mutate();
                        }
                        drawable.setColorFilter(C3442bbzow.m11534ZfxDd(AbstractC4326p8.m13068wA(context, i2), mode));
                        if (iRound != -1) {
                            drawable.setAlpha(iRound);
                        }
                        return true;
                    }
                    if (i != AbstractC4591t4.f16619VA) {
                        i2 = 0;
                        z = false;
                        iRound = -1;
                        if (!z) {
                        }
                    }
                }
                i2 = 16842801;
            }
            z = true;
            iRound = -1;
            if (!z) {
            }
        }

        /* renamed from: qdMbNW */
        public final ColorStateList m11549qdMbNW(Context context) {
            return m11547lgHUyS(context, AbstractC4326p8.m13068wA(context, AbstractC3862i4.f14115lgHUyS));
        }

        @Override // p131o.C4525s5.wA
        /* renamed from: wA */
        public PorterDuff.Mode mo11550wA(int i) {
            if (i == AbstractC4591t4.f16604CqaNbM) {
                return PorterDuff.Mode.MULTIPLY;
            }
            return null;
        }

        /* renamed from: xJ */
        public final ColorStateList m11551xJ(Context context) {
            return m11547lgHUyS(context, 0);
        }
    }

    /* renamed from: AZxh */
    public static synchronized C3442bbzow m11532AZxh() {
        try {
            if (f13116wA == null) {
                m11533JHa();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f13116wA;
    }

    /* renamed from: JHa */
    public static synchronized void m11533JHa() {
        if (f13116wA == null) {
            C3442bbzow c3442bbzow = new C3442bbzow();
            f13116wA = c3442bbzow;
            c3442bbzow.f13117mjFkc = C4525s5.m13462xJ();
            f13116wA.f13117mjFkc.m13468Pq(new mjFkc());
        }
    }

    /* renamed from: ZfxDd */
    public static synchronized PorterDuffColorFilter m11534ZfxDd(int i, PorterDuff.Mode mode) {
        return C4525s5.m13456ETF(i, mode);
    }

    /* renamed from: xJ */
    public static void m11536xJ(Drawable drawable, C4929y8 c4929y8, int[] iArr) {
        C4525s5.m13459eyqo(drawable, c4929y8, iArr);
    }

    /* renamed from: KLFTb */
    public synchronized ColorStateList m11537KLFTb(Context context, int i) {
        return this.f13117mjFkc.m13470VA(context, i);
    }

    /* renamed from: wA */
    public synchronized Drawable m11538wA(Context context, int i) {
        return this.f13117mjFkc.m13476qdMbNW(context, i);
    }
}
