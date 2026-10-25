package androidx.recyclerview.p023widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.p023widget.RecyclerView;
import p131o.AbstractC2876T9;

/* renamed from: androidx.recyclerview.widget.ZfxDd */
/* loaded from: classes.dex */
public class C0174ZfxDd extends RecyclerView.AbstractC0161rkYL implements RecyclerView.InterfaceC0145Pq {

    /* renamed from: AZxh */
    public final int f1819AZxh;

    /* renamed from: BAnRFn */
    public final Runnable f1820BAnRFn;

    /* renamed from: Dt */
    public final int f1821Dt;

    /* renamed from: ETF */
    public int f1822ETF;

    /* renamed from: JHa */
    public final int f1826JHa;

    /* renamed from: KLFTb */
    public final int f1827KLFTb;

    /* renamed from: MiMN */
    public float f1828MiMN;

    /* renamed from: Pq */
    public RecyclerView f1829Pq;

    /* renamed from: VA */
    public int f1831VA;

    /* renamed from: VocHEe */
    public int f1832VocHEe;

    /* renamed from: YoKzxo */
    public int f1833YoKzxo;

    /* renamed from: ZfxDd */
    public final Drawable f1834ZfxDd;

    /* renamed from: lB */
    public final RecyclerView.AbstractC0151diqgf f1839lB;

    /* renamed from: lgHUyS */
    public final Drawable f1840lgHUyS;

    /* renamed from: mjFkc */
    public final int f1841mjFkc;

    /* renamed from: qGY */
    public float f1842qGY;

    /* renamed from: qdMbNW */
    public final int f1843qdMbNW;

    /* renamed from: rkYL */
    public int f1844rkYL;

    /* renamed from: vI */
    public final ValueAnimator f1845vI;

    /* renamed from: wA */
    public final StateListDrawable f1846wA;

    /* renamed from: xJ */
    public final StateListDrawable f1847xJ;

    /* renamed from: wJVbdd */
    public static final int[] f1818wJVbdd = {R.attr.state_pressed};

    /* renamed from: mByQ */
    public static final int[] f1817mByQ = new int[0];

    /* renamed from: fehf */
    public int f1837fehf = 0;

    /* renamed from: IEE */
    public int f1825IEE = 0;

    /* renamed from: diqgf */
    public boolean f1835diqgf = false;

    /* renamed from: eyqo */
    public boolean f1836eyqo = false;

    /* renamed from: Ucbh */
    public int f1830Ucbh = 0;

    /* renamed from: huTpC */
    public int f1838huTpC = 0;

    /* renamed from: Gd */
    public final int[] f1823Gd = new int[2];

    /* renamed from: HGpJ */
    public final int[] f1824HGpJ = new int[2];

    /* renamed from: androidx.recyclerview.widget.ZfxDd$AZxh */
    public class AZxh extends RecyclerView.AbstractC0151diqgf {
        public AZxh() {
        }

        @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0151diqgf
        /* renamed from: AZxh */
        public void mo1635AZxh(RecyclerView recyclerView, int i, int i2) {
            C0174ZfxDd.this.m1973BAnRFn(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* renamed from: androidx.recyclerview.widget.ZfxDd$ZfxDd */
    public class ZfxDd implements ValueAnimator.AnimatorUpdateListener {
        public ZfxDd() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int iFloatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            C0174ZfxDd.this.f1846wA.setAlpha(iFloatValue);
            C0174ZfxDd.this.f1834ZfxDd.setAlpha(iFloatValue);
            C0174ZfxDd.this.m1981Ucbh();
        }
    }

    /* renamed from: androidx.recyclerview.widget.ZfxDd$mjFkc */
    public class mjFkc implements Runnable {
        public mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0174ZfxDd.this.m1987fehf(500);
        }
    }

    /* renamed from: androidx.recyclerview.widget.ZfxDd$wA */
    public class wA extends AnimatorListenerAdapter {

        /* renamed from: mjFkc */
        public boolean f1852mjFkc = false;

        public wA() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f1852mjFkc = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f1852mjFkc) {
                this.f1852mjFkc = false;
                return;
            }
            if (((Float) C0174ZfxDd.this.f1845vI.getAnimatedValue()).floatValue() == 0.0f) {
                C0174ZfxDd c0174ZfxDd = C0174ZfxDd.this;
                c0174ZfxDd.f1832VocHEe = 0;
                c0174ZfxDd.m1977HGpJ(0);
            } else {
                C0174ZfxDd c0174ZfxDd2 = C0174ZfxDd.this;
                c0174ZfxDd2.f1832VocHEe = 2;
                c0174ZfxDd2.m1981Ucbh();
            }
        }
    }

    public C0174ZfxDd(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i, int i2, int i3) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f1845vI = valueAnimatorOfFloat;
        this.f1832VocHEe = 0;
        this.f1820BAnRFn = new mjFkc();
        this.f1839lB = new AZxh();
        this.f1846wA = stateListDrawable;
        this.f1834ZfxDd = drawable;
        this.f1847xJ = stateListDrawable2;
        this.f1840lgHUyS = drawable2;
        this.f1827KLFTb = Math.max(i, stateListDrawable.getIntrinsicWidth());
        this.f1826JHa = Math.max(i, drawable.getIntrinsicWidth());
        this.f1843qdMbNW = Math.max(i, stateListDrawable2.getIntrinsicWidth());
        this.f1821Dt = Math.max(i, drawable2.getIntrinsicWidth());
        this.f1841mjFkc = i2;
        this.f1819AZxh = i3;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        valueAnimatorOfFloat.addListener(new wA());
        valueAnimatorOfFloat.addUpdateListener(new ZfxDd());
        m1974Dt(recyclerView);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.InterfaceC0145Pq
    /* renamed from: AZxh */
    public void mo1577AZxh(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f1830Ucbh == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean zM1986eyqo = m1986eyqo(motionEvent.getX(), motionEvent.getY());
            boolean zM1985diqgf = m1985diqgf(motionEvent.getX(), motionEvent.getY());
            if (zM1986eyqo || zM1985diqgf) {
                if (zM1985diqgf) {
                    this.f1838huTpC = 1;
                    this.f1842qGY = (int) motionEvent.getX();
                } else if (zM1986eyqo) {
                    this.f1838huTpC = 2;
                    this.f1828MiMN = (int) motionEvent.getY();
                }
                m1977HGpJ(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f1830Ucbh == 2) {
            this.f1828MiMN = 0.0f;
            this.f1842qGY = 0.0f;
            m1977HGpJ(1);
            this.f1838huTpC = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f1830Ucbh == 2) {
            m1983VocHEe();
            if (this.f1838huTpC == 1) {
                m1978IEE(motionEvent.getX());
            }
            if (this.f1838huTpC == 2) {
                m1989lB(motionEvent.getY());
            }
        }
    }

    /* renamed from: BAnRFn */
    public void m1973BAnRFn(int i, int i2) {
        int iComputeVerticalScrollRange = this.f1829Pq.computeVerticalScrollRange();
        int i3 = this.f1825IEE;
        this.f1835diqgf = iComputeVerticalScrollRange - i3 > 0 && i3 >= this.f1841mjFkc;
        int iComputeHorizontalScrollRange = this.f1829Pq.computeHorizontalScrollRange();
        int i4 = this.f1837fehf;
        boolean z = iComputeHorizontalScrollRange - i4 > 0 && i4 >= this.f1841mjFkc;
        this.f1836eyqo = z;
        boolean z2 = this.f1835diqgf;
        if (!z2 && !z) {
            if (this.f1830Ucbh != 0) {
                m1977HGpJ(0);
                return;
            }
            return;
        }
        if (z2) {
            float f = i3;
            this.f1831VA = (int) ((f * (i2 + (f / 2.0f))) / iComputeVerticalScrollRange);
            this.f1822ETF = Math.min(i3, (i3 * i3) / iComputeVerticalScrollRange);
        }
        if (this.f1836eyqo) {
            float f2 = i4;
            this.f1844rkYL = (int) ((f2 * (i + (f2 / 2.0f))) / iComputeHorizontalScrollRange);
            this.f1833YoKzxo = Math.min(i4, (i4 * i4) / iComputeHorizontalScrollRange);
        }
        int i5 = this.f1830Ucbh;
        if (i5 == 0 || i5 == 1) {
            m1977HGpJ(1);
        }
    }

    /* renamed from: Dt */
    public void m1974Dt(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f1829Pq;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            m1982VA();
        }
        this.f1829Pq = recyclerView;
        if (recyclerView != null) {
            m1992vI();
        }
    }

    /* renamed from: ETF */
    public final void m1975ETF() {
        this.f1829Pq.removeCallbacks(this.f1820BAnRFn);
    }

    /* renamed from: Gd */
    public final int m1976Gd(float f, float f2, int[] iArr, int i, int i2, int i3) {
        int i4 = iArr[1] - iArr[0];
        if (i4 == 0) {
            return 0;
        }
        int i5 = i - i3;
        int i6 = (int) (((f2 - f) / i4) * i5);
        int i7 = i2 + i6;
        if (i7 >= i5 || i7 < 0) {
            return 0;
        }
        return i6;
    }

    /* renamed from: HGpJ */
    public void m1977HGpJ(int i) {
        if (i == 2 && this.f1830Ucbh != 2) {
            this.f1846wA.setState(f1818wJVbdd);
            m1975ETF();
        }
        if (i == 0) {
            m1981Ucbh();
        } else {
            m1983VocHEe();
        }
        if (this.f1830Ucbh == 2 && i != 2) {
            this.f1846wA.setState(f1817mByQ);
            m1988huTpC(1200);
        } else if (i == 1) {
            m1988huTpC(1500);
        }
        this.f1830Ucbh = i;
    }

    /* renamed from: IEE */
    public final void m1978IEE(float f) {
        int[] iArrM1991rkYL = m1991rkYL();
        float fMax = Math.max(iArrM1991rkYL[0], Math.min(iArrM1991rkYL[1], f));
        if (Math.abs(this.f1844rkYL - fMax) < 2.0f) {
            return;
        }
        int iM1976Gd = m1976Gd(this.f1842qGY, fMax, iArrM1991rkYL, this.f1829Pq.computeHorizontalScrollRange(), this.f1829Pq.computeHorizontalScrollOffset(), this.f1837fehf);
        if (iM1976Gd != 0) {
            this.f1829Pq.scrollBy(iM1976Gd, 0);
        }
        this.f1842qGY = fMax;
    }

    /* renamed from: MiMN */
    public final void m1979MiMN(Canvas canvas) {
        int i = this.f1825IEE;
        int i2 = this.f1843qdMbNW;
        int i3 = this.f1844rkYL;
        int i4 = this.f1833YoKzxo;
        this.f1847xJ.setBounds(0, 0, i4, i2);
        this.f1840lgHUyS.setBounds(0, 0, this.f1837fehf, this.f1821Dt);
        canvas.translate(0.0f, i - i2);
        this.f1840lgHUyS.draw(canvas);
        canvas.translate(i3 - (i4 / 2), 0.0f);
        this.f1847xJ.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    /* renamed from: Pq */
    public final boolean m1980Pq() {
        return AbstractC2876T9.m10276huTpC(this.f1829Pq) == 1;
    }

    /* renamed from: Ucbh */
    public void m1981Ucbh() {
        this.f1829Pq.invalidate();
    }

    /* renamed from: VA */
    public final void m1982VA() {
        this.f1829Pq.m1441Jk(this);
        this.f1829Pq.m1445KRckQg(this);
        this.f1829Pq.m1510mPWV(this.f1839lB);
        m1975ETF();
    }

    /* renamed from: VocHEe */
    public void m1983VocHEe() {
        int i = this.f1832VocHEe;
        if (i != 0) {
            if (i != 3) {
                return;
            } else {
                this.f1845vI.cancel();
            }
        }
        this.f1832VocHEe = 1;
        ValueAnimator valueAnimator = this.f1845vI;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f1845vI.setDuration(500L);
        this.f1845vI.setStartDelay(0L);
        this.f1845vI.start();
    }

    /* renamed from: YoKzxo */
    public final void m1984YoKzxo(Canvas canvas) {
        int i = this.f1837fehf;
        int i2 = this.f1827KLFTb;
        int i3 = i - i2;
        int i4 = this.f1831VA;
        int i5 = this.f1822ETF;
        int i6 = i4 - (i5 / 2);
        this.f1846wA.setBounds(0, 0, i2, i5);
        this.f1834ZfxDd.setBounds(0, 0, this.f1826JHa, this.f1825IEE);
        if (!m1980Pq()) {
            canvas.translate(i3, 0.0f);
            this.f1834ZfxDd.draw(canvas);
            canvas.translate(0.0f, i6);
            this.f1846wA.draw(canvas);
            canvas.translate(-i3, -i6);
            return;
        }
        this.f1834ZfxDd.draw(canvas);
        canvas.translate(this.f1827KLFTb, i6);
        canvas.scale(-1.0f, 1.0f);
        this.f1846wA.draw(canvas);
        canvas.scale(-1.0f, 1.0f);
        canvas.translate(-this.f1827KLFTb, -i6);
    }

    /* renamed from: diqgf */
    public boolean m1985diqgf(float f, float f2) {
        if (f2 >= this.f1825IEE - this.f1843qdMbNW) {
            int i = this.f1844rkYL;
            int i2 = this.f1833YoKzxo;
            if (f >= i - (i2 / 2) && f <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: eyqo */
    public boolean m1986eyqo(float f, float f2) {
        if (!m1980Pq() ? f >= this.f1837fehf - this.f1827KLFTb : f <= this.f1827KLFTb) {
            int i = this.f1831VA;
            int i2 = this.f1822ETF;
            if (f2 >= i - (i2 / 2) && f2 <= i + (i2 / 2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: fehf */
    public void m1987fehf(int i) {
        int i2 = this.f1832VocHEe;
        if (i2 == 1) {
            this.f1845vI.cancel();
        } else if (i2 != 2) {
            return;
        }
        this.f1832VocHEe = 3;
        ValueAnimator valueAnimator = this.f1845vI;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f1845vI.setDuration(i);
        this.f1845vI.start();
    }

    /* renamed from: huTpC */
    public final void m1988huTpC(int i) {
        m1975ETF();
        this.f1829Pq.postDelayed(this.f1820BAnRFn, i);
    }

    /* renamed from: lB */
    public final void m1989lB(float f) {
        int[] iArrM1990qGY = m1990qGY();
        float fMax = Math.max(iArrM1990qGY[0], Math.min(iArrM1990qGY[1], f));
        if (Math.abs(this.f1831VA - fMax) < 2.0f) {
            return;
        }
        int iM1976Gd = m1976Gd(this.f1828MiMN, fMax, iArrM1990qGY, this.f1829Pq.computeVerticalScrollRange(), this.f1829Pq.computeVerticalScrollOffset(), this.f1825IEE);
        if (iM1976Gd != 0) {
            this.f1829Pq.scrollBy(0, iM1976Gd);
        }
        this.f1828MiMN = fMax;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.InterfaceC0145Pq
    /* renamed from: mjFkc */
    public boolean mo1578mjFkc(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i = this.f1830Ucbh;
        if (i == 1) {
            boolean zM1986eyqo = m1986eyqo(motionEvent.getX(), motionEvent.getY());
            boolean zM1985diqgf = m1985diqgf(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!zM1986eyqo && !zM1985diqgf) {
                return false;
            }
            if (zM1985diqgf) {
                this.f1838huTpC = 1;
                this.f1842qGY = (int) motionEvent.getX();
            } else if (zM1986eyqo) {
                this.f1838huTpC = 2;
                this.f1828MiMN = (int) motionEvent.getY();
            }
            m1977HGpJ(2);
        } else if (i != 2) {
            return false;
        }
        return true;
    }

    /* renamed from: qGY */
    public final int[] m1990qGY() {
        int[] iArr = this.f1823Gd;
        int i = this.f1819AZxh;
        iArr[0] = i;
        iArr[1] = this.f1825IEE - i;
        return iArr;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0161rkYL
    /* renamed from: qdMbNW */
    public void mo1828qdMbNW(Canvas canvas, RecyclerView recyclerView, RecyclerView.C0148VocHEe c0148VocHEe) {
        if (this.f1837fehf != this.f1829Pq.getWidth() || this.f1825IEE != this.f1829Pq.getHeight()) {
            this.f1837fehf = this.f1829Pq.getWidth();
            this.f1825IEE = this.f1829Pq.getHeight();
            m1977HGpJ(0);
        } else if (this.f1832VocHEe != 0) {
            if (this.f1835diqgf) {
                m1984YoKzxo(canvas);
            }
            if (this.f1836eyqo) {
                m1979MiMN(canvas);
            }
        }
    }

    /* renamed from: rkYL */
    public final int[] m1991rkYL() {
        int[] iArr = this.f1824HGpJ;
        int i = this.f1819AZxh;
        iArr[0] = i;
        iArr[1] = this.f1837fehf - i;
        return iArr;
    }

    /* renamed from: vI */
    public final void m1992vI() {
        this.f1829Pq.m1518qdMbNW(this);
        this.f1829Pq.m1427ETF(this);
        this.f1829Pq.m1465VA(this.f1839lB);
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.InterfaceC0145Pq
    /* renamed from: wA */
    public void mo1579wA(boolean z) {
    }
}
