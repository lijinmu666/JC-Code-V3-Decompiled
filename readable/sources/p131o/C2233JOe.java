package p131o;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;

/* renamed from: o.JOe */
/* loaded from: classes.dex */
public class C2233JOe extends AbstractC2485N8 {

    /* renamed from: rWxwaT */
    public static final String[] f8944rWxwaT = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: Vnb */
    public static final Property f8940Vnb = new AZxh(PointF.class, "boundsOrigin");

    /* renamed from: NPj */
    public static final Property f8939NPj = new wA(PointF.class, "topLeft");

    /* renamed from: vadzgd */
    public static final Property f8945vadzgd = new ZfxDd(PointF.class, "bottomRight");

    /* renamed from: oCFDzJ */
    public static final Property f8943oCFDzJ = new KLFTb(PointF.class, "bottomRight");

    /* renamed from: aqHPIZ */
    public static final Property f8942aqHPIZ = new JHa(PointF.class, "topLeft");

    /* renamed from: WrLQs */
    public static final Property f8941WrLQs = new xJ(PointF.class, "position");

    /* renamed from: KRTLGT */
    public static C3603e5 f8938KRTLGT = new C3603e5();

    /* renamed from: KLMXS */
    public int[] f8946KLMXS = new int[2];

    /* renamed from: zvd */
    public boolean f8948zvd = false;

    /* renamed from: cMLeY */
    public boolean f8947cMLeY = false;

    /* renamed from: o.JOe$AZxh */
    public static class AZxh extends Property {

        /* renamed from: mjFkc */
        public Rect f8949mjFkc;

        public AZxh(Class cls, String str) {
            super(cls, str);
            this.f8949mjFkc = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f8949mjFkc);
            this.f8949mjFkc.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f8949mjFkc);
        }

        @Override // android.util.Property
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f8949mjFkc);
            Rect rect = this.f8949mjFkc;
            return new PointF(rect.left, rect.top);
        }
    }

    /* renamed from: o.JOe$Dt */
    public class Dt extends AbstractC2549O8 {

        /* renamed from: AZxh */
        public final /* synthetic */ ViewGroup f8950AZxh;

        /* renamed from: mjFkc */
        public boolean f8951mjFkc = false;

        public Dt(ViewGroup viewGroup) {
            this.f8950AZxh = viewGroup;
        }

        @Override // p131o.AbstractC2549O8, p131o.AbstractC2485N8.JHa
        /* renamed from: AZxh */
        public void mo8141AZxh(AbstractC2485N8 abstractC2485N8) {
            AbstractC3570da.m11731AZxh(this.f8950AZxh, false);
            this.f8951mjFkc = true;
        }

        @Override // p131o.AbstractC2549O8, p131o.AbstractC2485N8.JHa
        /* renamed from: KLFTb */
        public void mo8143KLFTb(AbstractC2485N8 abstractC2485N8) {
            AbstractC3570da.m11731AZxh(this.f8950AZxh, true);
        }

        @Override // p131o.AbstractC2549O8, p131o.AbstractC2485N8.JHa
        /* renamed from: mjFkc */
        public void mo8145mjFkc(AbstractC2485N8 abstractC2485N8) {
            AbstractC3570da.m11731AZxh(this.f8950AZxh, false);
        }

        @Override // p131o.AbstractC2485N8.JHa
        /* renamed from: wA */
        public void mo8146wA(AbstractC2485N8 abstractC2485N8) {
            if (!this.f8951mjFkc) {
                AbstractC3570da.m11731AZxh(this.f8950AZxh, false);
            }
            abstractC2485N8.mo9616aqHPIZ(this);
        }
    }

    /* renamed from: o.JOe$ETF */
    public static class ETF {

        /* renamed from: AZxh */
        public int f8953AZxh;

        /* renamed from: JHa */
        public int f8954JHa;

        /* renamed from: KLFTb */
        public View f8955KLFTb;

        /* renamed from: ZfxDd */
        public int f8956ZfxDd;

        /* renamed from: mjFkc */
        public int f8957mjFkc;

        /* renamed from: wA */
        public int f8958wA;

        /* renamed from: xJ */
        public int f8959xJ;

        public ETF(View view) {
            this.f8955KLFTb = view;
        }

        /* renamed from: AZxh */
        public final void m8954AZxh() {
            AbstractC4623ta.m13631JHa(this.f8955KLFTb, this.f8957mjFkc, this.f8953AZxh, this.f8958wA, this.f8956ZfxDd);
            this.f8954JHa = 0;
            this.f8959xJ = 0;
        }

        /* renamed from: mjFkc */
        public void m8955mjFkc(PointF pointF) {
            this.f8958wA = Math.round(pointF.x);
            this.f8956ZfxDd = Math.round(pointF.y);
            int i = this.f8959xJ + 1;
            this.f8959xJ = i;
            if (this.f8954JHa == i) {
                m8954AZxh();
            }
        }

        /* renamed from: wA */
        public void m8956wA(PointF pointF) {
            this.f8957mjFkc = Math.round(pointF.x);
            this.f8953AZxh = Math.round(pointF.y);
            int i = this.f8954JHa + 1;
            this.f8954JHa = i;
            if (i == this.f8959xJ) {
                m8954AZxh();
            }
        }
    }

    /* renamed from: o.JOe$JHa */
    public static class JHa extends Property {
        public JHa(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            AbstractC4623ta.m13631JHa(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }

        @Override // android.util.Property
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }
    }

    /* renamed from: o.JOe$KLFTb */
    public static class KLFTb extends Property {
        public KLFTb(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            AbstractC4623ta.m13631JHa(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }

        @Override // android.util.Property
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }
    }

    /* renamed from: o.JOe$ZfxDd */
    public static class ZfxDd extends Property {
        public ZfxDd(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void set(ETF etf, PointF pointF) {
            etf.m8955mjFkc(pointF);
        }

        @Override // android.util.Property
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public PointF get(ETF etf) {
            return null;
        }
    }

    /* renamed from: o.JOe$lgHUyS */
    public class lgHUyS extends AnimatorListenerAdapter {
        private ETF mViewBounds;

        /* renamed from: mjFkc */
        public final /* synthetic */ ETF f8961mjFkc;

        public lgHUyS(ETF etf) {
            this.f8961mjFkc = etf;
            this.mViewBounds = etf;
        }
    }

    /* renamed from: o.JOe$mjFkc */
    public class mjFkc extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public final /* synthetic */ BitmapDrawable f8962AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ float f8964ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ ViewGroup f8965mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ View f8966wA;

        public mjFkc(ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.f8965mjFkc = viewGroup;
            this.f8962AZxh = bitmapDrawable;
            this.f8966wA = view;
            this.f8964ZfxDd = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AbstractC4623ta.m13629AZxh(this.f8965mjFkc).mo11528ZfxDd(this.f8962AZxh);
            AbstractC4623ta.m13638xJ(this.f8966wA, this.f8964ZfxDd);
        }
    }

    /* renamed from: o.JOe$qdMbNW */
    public class qdMbNW extends AnimatorListenerAdapter {

        /* renamed from: AZxh */
        public final /* synthetic */ View f8967AZxh;

        /* renamed from: JHa */
        public final /* synthetic */ int f8968JHa;

        /* renamed from: KLFTb */
        public final /* synthetic */ int f8969KLFTb;

        /* renamed from: ZfxDd */
        public final /* synthetic */ int f8970ZfxDd;

        /* renamed from: mjFkc */
        public boolean f8972mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ Rect f8973wA;

        /* renamed from: xJ */
        public final /* synthetic */ int f8974xJ;

        public qdMbNW(View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f8967AZxh = view;
            this.f8973wA = rect;
            this.f8970ZfxDd = i;
            this.f8969KLFTb = i2;
            this.f8968JHa = i3;
            this.f8974xJ = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f8972mjFkc = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f8972mjFkc) {
                return;
            }
            AbstractC2876T9.m10243Moer(this.f8967AZxh, this.f8973wA);
            AbstractC4623ta.m13631JHa(this.f8967AZxh, this.f8970ZfxDd, this.f8969KLFTb, this.f8968JHa, this.f8974xJ);
        }
    }

    /* renamed from: o.JOe$wA */
    public static class wA extends Property {
        public wA(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void set(ETF etf, PointF pointF) {
            etf.m8956wA(pointF);
        }

        @Override // android.util.Property
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public PointF get(ETF etf) {
            return null;
        }
    }

    /* renamed from: o.JOe$xJ */
    public static class xJ extends Property {
        public xJ(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            AbstractC4623ta.m13631JHa(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }

        @Override // android.util.Property
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }
    }

    /* renamed from: JBhc */
    public final void m8950JBhc(C2875T8 c2875t8) {
        View view = c2875t8.f10645AZxh;
        if (!AbstractC2876T9.m10287rWxwaT(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        c2875t8.f10646mjFkc.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        c2875t8.f10646mjFkc.put("android:changeBounds:parent", c2875t8.f10645AZxh.getParent());
        if (this.f8947cMLeY) {
            c2875t8.f10645AZxh.getLocationInWindow(this.f8946KLMXS);
            c2875t8.f10646mjFkc.put("android:changeBounds:windowX", Integer.valueOf(this.f8946KLMXS[0]));
            c2875t8.f10646mjFkc.put("android:changeBounds:windowY", Integer.valueOf(this.f8946KLMXS[1]));
        }
        if (this.f8948zvd) {
            c2875t8.f10646mjFkc.put("android:changeBounds:clip", AbstractC2876T9.m10285qGY(view));
        }
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: OjSQV */
    public String[] mo8132OjSQV() {
        return f8944rWxwaT;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: VA */
    public void mo8133VA(C2875T8 c2875t8) {
        m8950JBhc(c2875t8);
    }

    /* renamed from: Vdz */
    public final boolean m8951Vdz(View view, View view2) {
        if (!this.f8947cMLeY) {
            return true;
        }
        C2875T8 c2875t8M9609Ucbh = m9609Ucbh(view, true);
        if (c2875t8M9609Ucbh == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == c2875t8M9609Ucbh.f10645AZxh) {
            return true;
        }
        return false;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: qGY */
    public Animator mo8138qGY(ViewGroup viewGroup, C2875T8 c2875t8, C2875T8 c2875t82) {
        int i;
        View view;
        int i2;
        ObjectAnimator objectAnimator;
        Animator animatorM10137wA;
        if (c2875t8 == null || c2875t82 == null) {
            return null;
        }
        Map map = c2875t8.f10646mjFkc;
        Map map2 = c2875t82.f10646mjFkc;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = c2875t82.f10645AZxh;
        if (!m8951Vdz(viewGroup2, viewGroup3)) {
            int iIntValue = ((Integer) c2875t8.f10646mjFkc.get("android:changeBounds:windowX")).intValue();
            int iIntValue2 = ((Integer) c2875t8.f10646mjFkc.get("android:changeBounds:windowY")).intValue();
            int iIntValue3 = ((Integer) c2875t82.f10646mjFkc.get("android:changeBounds:windowX")).intValue();
            int iIntValue4 = ((Integer) c2875t82.f10646mjFkc.get("android:changeBounds:windowY")).intValue();
            if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
                return null;
            }
            viewGroup.getLocationInWindow(this.f8946KLMXS);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
            view2.draw(new Canvas(bitmapCreateBitmap));
            BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            float fM13637wA = AbstractC4623ta.m13637wA(view2);
            AbstractC4623ta.m13638xJ(view2, 0.0f);
            AbstractC4623ta.m13629AZxh(viewGroup).mo11527AZxh(bitmapDrawable);
            AbstractC4590t3 abstractC4590t3M9596Gd = m9596Gd();
            int[] iArr = this.f8946KLMXS;
            int i3 = iArr[0];
            int i4 = iArr[1];
            ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, AbstractC3205Y3.m11045mjFkc(f8940Vnb, abstractC4590t3M9596Gd.mo9638mjFkc(iIntValue - i3, iIntValue2 - i4, iIntValue3 - i3, iIntValue4 - i4)));
            objectAnimatorOfPropertyValuesHolder.addListener(new mjFkc(viewGroup, bitmapDrawable, view2, fM13637wA));
            return objectAnimatorOfPropertyValuesHolder;
        }
        Rect rect = (Rect) c2875t8.f10646mjFkc.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) c2875t82.f10646mjFkc.get("android:changeBounds:bounds");
        int i5 = rect.left;
        int i6 = rect2.left;
        int i7 = rect.top;
        int i8 = rect2.top;
        int i9 = rect.right;
        int i10 = rect2.right;
        int i11 = rect.bottom;
        int i12 = rect2.bottom;
        int i13 = i9 - i5;
        int i14 = i11 - i7;
        int i15 = i10 - i6;
        int i16 = i12 - i8;
        Rect rect3 = (Rect) c2875t8.f10646mjFkc.get("android:changeBounds:clip");
        Rect rect4 = (Rect) c2875t82.f10646mjFkc.get("android:changeBounds:clip");
        if ((i13 == 0 || i14 == 0) && (i15 == 0 || i16 == 0)) {
            i = 0;
        } else {
            i = (i5 == i6 && i7 == i8) ? 0 : 1;
            if (i9 != i10 || i11 != i12) {
                i++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i++;
        }
        if (i <= 0) {
            return null;
        }
        if (this.f8948zvd) {
            view = view2;
            AbstractC4623ta.m13631JHa(view, i5, i7, Math.max(i13, i15) + i5, Math.max(i14, i16) + i7);
            ObjectAnimator objectAnimatorM9996mjFkc = (i5 == i6 && i7 == i8) ? null : AbstractC2670Q2.m9996mjFkc(view, f8941WrLQs, m9596Gd().mo9638mjFkc(i5, i7, i6, i8));
            if (rect3 == null) {
                i2 = 0;
                rect3 = new Rect(0, 0, i13, i14);
            } else {
                i2 = 0;
            }
            Rect rect5 = rect4 == null ? new Rect(i2, i2, i15, i16) : rect4;
            if (rect3.equals(rect5)) {
                objectAnimator = null;
            } else {
                AbstractC2876T9.m10243Moer(view, rect3);
                ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", f8938KRTLGT, rect3, rect5);
                objectAnimatorOfObject.addListener(new qdMbNW(view, rect4, i6, i8, i10, i12));
                objectAnimator = objectAnimatorOfObject;
            }
            animatorM10137wA = AbstractC2807S8.m10137wA(objectAnimatorM9996mjFkc, objectAnimator);
        } else {
            view = view2;
            AbstractC4623ta.m13631JHa(view, i5, i7, i9, i11);
            if (i != 2) {
                animatorM10137wA = (i5 == i6 && i7 == i8) ? AbstractC2670Q2.m9996mjFkc(view, f8943oCFDzJ, m9596Gd().mo9638mjFkc(i9, i11, i10, i12)) : AbstractC2670Q2.m9996mjFkc(view, f8942aqHPIZ, m9596Gd().mo9638mjFkc(i5, i7, i6, i8));
            } else if (i13 == i15 && i14 == i16) {
                animatorM10137wA = AbstractC2670Q2.m9996mjFkc(view, f8941WrLQs, m9596Gd().mo9638mjFkc(i5, i7, i6, i8));
            } else {
                ETF etf = new ETF(view);
                ObjectAnimator objectAnimatorM9996mjFkc2 = AbstractC2670Q2.m9996mjFkc(etf, f8939NPj, m9596Gd().mo9638mjFkc(i5, i7, i6, i8));
                ObjectAnimator objectAnimatorM9996mjFkc3 = AbstractC2670Q2.m9996mjFkc(etf, f8945vadzgd, m9596Gd().mo9638mjFkc(i9, i11, i10, i12));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorM9996mjFkc2, objectAnimatorM9996mjFkc3);
                animatorSet.addListener(new lgHUyS(etf));
                animatorM10137wA = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            AbstractC3570da.m11731AZxh(viewGroup4, true);
            mo9627mjFkc(new Dt(viewGroup4));
        }
        return animatorM10137wA;
    }

    @Override // p131o.AbstractC2485N8
    /* renamed from: qdMbNW */
    public void mo8139qdMbNW(C2875T8 c2875t8) {
        m8950JBhc(c2875t8);
    }
}
