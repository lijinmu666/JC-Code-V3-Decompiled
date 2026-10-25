package p131o;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: o.XtE */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC3191XtE implements View.OnTouchListener {

    /* renamed from: IEE */
    public static final int f11684IEE = ViewConfiguration.getTapTimeout();

    /* renamed from: MiMN */
    public boolean f11690MiMN;

    /* renamed from: VA */
    public boolean f11691VA;

    /* renamed from: YoKzxo */
    public boolean f11692YoKzxo;

    /* renamed from: ZfxDd */
    public Runnable f11693ZfxDd;

    /* renamed from: fehf */
    public boolean f11694fehf;

    /* renamed from: lgHUyS */
    public int f11695lgHUyS;

    /* renamed from: qGY */
    public boolean f11697qGY;

    /* renamed from: rkYL */
    public boolean f11699rkYL;

    /* renamed from: wA */
    public final View f11700wA;

    /* renamed from: xJ */
    public int f11701xJ;

    /* renamed from: mjFkc */
    public final mjFkc f11696mjFkc = new mjFkc();

    /* renamed from: AZxh */
    public final Interpolator f11685AZxh = new AccelerateInterpolator();

    /* renamed from: KLFTb */
    public float[] f11689KLFTb = {0.0f, 0.0f};

    /* renamed from: JHa */
    public float[] f11688JHa = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: qdMbNW */
    public float[] f11698qdMbNW = {0.0f, 0.0f};

    /* renamed from: Dt */
    public float[] f11686Dt = {0.0f, 0.0f};

    /* renamed from: ETF */
    public float[] f11687ETF = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: o.XtE$AZxh */
    public class AZxh implements Runnable {
        public AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnTouchListenerC3191XtE abstractViewOnTouchListenerC3191XtE = AbstractViewOnTouchListenerC3191XtE.this;
            if (abstractViewOnTouchListenerC3191XtE.f11699rkYL) {
                if (abstractViewOnTouchListenerC3191XtE.f11690MiMN) {
                    abstractViewOnTouchListenerC3191XtE.f11690MiMN = false;
                    abstractViewOnTouchListenerC3191XtE.f11696mjFkc.m10985MiMN();
                }
                mjFkc mjfkc = AbstractViewOnTouchListenerC3191XtE.this.f11696mjFkc;
                if (mjfkc.m10988lgHUyS() || !AbstractViewOnTouchListenerC3191XtE.this.m10971eyqo()) {
                    AbstractViewOnTouchListenerC3191XtE.this.f11699rkYL = false;
                    return;
                }
                AbstractViewOnTouchListenerC3191XtE abstractViewOnTouchListenerC3191XtE2 = AbstractViewOnTouchListenerC3191XtE.this;
                if (abstractViewOnTouchListenerC3191XtE2.f11692YoKzxo) {
                    abstractViewOnTouchListenerC3191XtE2.f11692YoKzxo = false;
                    abstractViewOnTouchListenerC3191XtE2.m10978wA();
                }
                mjfkc.m10989mjFkc();
                AbstractViewOnTouchListenerC3191XtE.this.mo10961Dt(mjfkc.m10980AZxh(), mjfkc.m10991wA());
                AbstractC2876T9.m10258WGXroI(AbstractViewOnTouchListenerC3191XtE.this.f11700wA, this);
            }
        }
    }

    /* renamed from: o.XtE$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public int f11703AZxh;

        /* renamed from: Dt */
        public float f11704Dt;

        /* renamed from: ETF */
        public int f11705ETF;

        /* renamed from: ZfxDd */
        public float f11708ZfxDd;

        /* renamed from: mjFkc */
        public int f11710mjFkc;

        /* renamed from: wA */
        public float f11712wA;

        /* renamed from: KLFTb */
        public long f11707KLFTb = Long.MIN_VALUE;

        /* renamed from: qdMbNW */
        public long f11711qdMbNW = -1;

        /* renamed from: JHa */
        public long f11706JHa = 0;

        /* renamed from: xJ */
        public int f11713xJ = 0;

        /* renamed from: lgHUyS */
        public int f11709lgHUyS = 0;

        /* renamed from: AZxh */
        public int m10980AZxh() {
            return this.f11713xJ;
        }

        /* renamed from: Dt */
        public void m10981Dt(int i) {
            this.f11703AZxh = i;
        }

        /* renamed from: ETF */
        public void m10982ETF(int i) {
            this.f11710mjFkc = i;
        }

        /* renamed from: JHa */
        public int m10983JHa() {
            float f = this.f11708ZfxDd;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: KLFTb */
        public final float m10984KLFTb(long j) {
            if (j < this.f11707KLFTb) {
                return 0.0f;
            }
            long j2 = this.f11711qdMbNW;
            if (j2 < 0 || j < j2) {
                return AbstractViewOnTouchListenerC3191XtE.m10959KLFTb((j - r0) / this.f11710mjFkc, 0.0f, 1.0f) * 0.5f;
            }
            float f = this.f11704Dt;
            return (1.0f - f) + (f * AbstractViewOnTouchListenerC3191XtE.m10959KLFTb((j - j2) / this.f11705ETF, 0.0f, 1.0f));
        }

        /* renamed from: MiMN */
        public void m10985MiMN() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f11707KLFTb = jCurrentAnimationTimeMillis;
            this.f11711qdMbNW = -1L;
            this.f11706JHa = jCurrentAnimationTimeMillis;
            this.f11704Dt = 0.5f;
            this.f11713xJ = 0;
            this.f11709lgHUyS = 0;
        }

        /* renamed from: VA */
        public void m10986VA(float f, float f2) {
            this.f11712wA = f;
            this.f11708ZfxDd = f2;
        }

        /* renamed from: ZfxDd */
        public int m10987ZfxDd() {
            float f = this.f11712wA;
            return (int) (f / Math.abs(f));
        }

        /* renamed from: lgHUyS */
        public boolean m10988lgHUyS() {
            return this.f11711qdMbNW > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f11711qdMbNW + ((long) this.f11705ETF);
        }

        /* renamed from: mjFkc */
        public void m10989mjFkc() {
            if (this.f11706JHa == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float fM10992xJ = m10992xJ(m10984KLFTb(jCurrentAnimationTimeMillis));
            long j = jCurrentAnimationTimeMillis - this.f11706JHa;
            this.f11706JHa = jCurrentAnimationTimeMillis;
            float f = j * fM10992xJ;
            this.f11713xJ = (int) (this.f11712wA * f);
            this.f11709lgHUyS = (int) (f * this.f11708ZfxDd);
        }

        /* renamed from: qdMbNW */
        public void m10990qdMbNW() {
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f11705ETF = AbstractViewOnTouchListenerC3191XtE.m10958JHa((int) (jCurrentAnimationTimeMillis - this.f11707KLFTb), 0, this.f11703AZxh);
            this.f11704Dt = m10984KLFTb(jCurrentAnimationTimeMillis);
            this.f11711qdMbNW = jCurrentAnimationTimeMillis;
        }

        /* renamed from: wA */
        public int m10991wA() {
            return this.f11709lgHUyS;
        }

        /* renamed from: xJ */
        public final float m10992xJ(float f) {
            return ((-4.0f) * f * f) + (f * 4.0f);
        }
    }

    public AbstractViewOnTouchListenerC3191XtE(View view) {
        this.f11700wA = view;
        float f = Resources.getSystem().getDisplayMetrics().density;
        float f2 = (int) ((1575.0f * f) + 0.5f);
        m10977rkYL(f2, f2);
        float f3 = (int) ((f * 315.0f) + 0.5f);
        m10975qGY(f3, f3);
        m10967VA(1);
        m10968YoKzxo(Float.MAX_VALUE, Float.MAX_VALUE);
        m10965Pq(0.2f, 0.2f);
        m10970diqgf(1.0f, 1.0f);
        m10962ETF(f11684IEE);
        m10963IEE(500);
        m10972fehf(500);
    }

    /* renamed from: JHa */
    public static int m10958JHa(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    /* renamed from: KLFTb */
    public static float m10959KLFTb(float f, float f2, float f3) {
        return f > f3 ? f3 : f < f2 ? f2 : f;
    }

    /* renamed from: AZxh */
    public abstract boolean mo10960AZxh(int i);

    /* renamed from: Dt */
    public abstract void mo10961Dt(int i, int i2);

    /* renamed from: ETF */
    public AbstractViewOnTouchListenerC3191XtE m10962ETF(int i) {
        this.f11695lgHUyS = i;
        return this;
    }

    /* renamed from: IEE */
    public AbstractViewOnTouchListenerC3191XtE m10963IEE(int i) {
        this.f11696mjFkc.m10982ETF(i);
        return this;
    }

    /* renamed from: MiMN */
    public AbstractViewOnTouchListenerC3191XtE m10964MiMN(boolean z) {
        if (this.f11697qGY && !z) {
            m10976qdMbNW();
        }
        this.f11697qGY = z;
        return this;
    }

    /* renamed from: Pq */
    public AbstractViewOnTouchListenerC3191XtE m10965Pq(float f, float f2) {
        float[] fArr = this.f11689KLFTb;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    /* renamed from: Ucbh */
    public final void m10966Ucbh() {
        int i;
        if (this.f11693ZfxDd == null) {
            this.f11693ZfxDd = new AZxh();
        }
        this.f11699rkYL = true;
        this.f11690MiMN = true;
        if (this.f11691VA || (i = this.f11695lgHUyS) <= 0) {
            this.f11693ZfxDd.run();
        } else {
            AbstractC2876T9.m10261XV(this.f11700wA, this.f11693ZfxDd, i);
        }
        this.f11691VA = true;
    }

    /* renamed from: VA */
    public AbstractViewOnTouchListenerC3191XtE m10967VA(int i) {
        this.f11701xJ = i;
        return this;
    }

    /* renamed from: YoKzxo */
    public AbstractViewOnTouchListenerC3191XtE m10968YoKzxo(float f, float f2) {
        float[] fArr = this.f11688JHa;
        fArr[0] = f;
        fArr[1] = f2;
        return this;
    }

    /* renamed from: ZfxDd */
    public final float m10969ZfxDd(int i, float f, float f2, float f3) {
        float fM10973lgHUyS = m10973lgHUyS(this.f11689KLFTb[i], f2, this.f11688JHa[i], f);
        if (fM10973lgHUyS == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f11698qdMbNW[i];
        float f5 = this.f11686Dt[i];
        float f6 = this.f11687ETF[i];
        float f7 = f4 * f3;
        return fM10973lgHUyS > 0.0f ? m10959KLFTb(fM10973lgHUyS * f7, f5, f6) : -m10959KLFTb((-fM10973lgHUyS) * f7, f5, f6);
    }

    /* renamed from: diqgf */
    public AbstractViewOnTouchListenerC3191XtE m10970diqgf(float f, float f2) {
        float[] fArr = this.f11698qdMbNW;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: eyqo */
    public boolean m10971eyqo() {
        mjFkc mjfkc = this.f11696mjFkc;
        int iM10983JHa = mjfkc.m10983JHa();
        int iM10987ZfxDd = mjfkc.m10987ZfxDd();
        return (iM10983JHa != 0 && mo10960AZxh(iM10983JHa)) || (iM10987ZfxDd != 0 && mo10974mjFkc(iM10987ZfxDd));
    }

    /* renamed from: fehf */
    public AbstractViewOnTouchListenerC3191XtE m10972fehf(int i) {
        this.f11696mjFkc.m10981Dt(i);
        return this;
    }

    /* renamed from: lgHUyS */
    public final float m10973lgHUyS(float f, float f2, float f3, float f4) {
        float interpolation;
        float fM10959KLFTb = m10959KLFTb(f * f2, 0.0f, f3);
        float fM10979xJ = m10979xJ(f2 - f4, fM10959KLFTb) - m10979xJ(f4, fM10959KLFTb);
        if (fM10979xJ < 0.0f) {
            interpolation = -this.f11685AZxh.getInterpolation(-fM10979xJ);
        } else {
            if (fM10979xJ <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f11685AZxh.getInterpolation(fM10979xJ);
        }
        return m10959KLFTb(interpolation, -1.0f, 1.0f);
    }

    /* renamed from: mjFkc */
    public abstract boolean mo10974mjFkc(int i);

    /* JADX WARN: Removed duplicated region for block: B:13:0x0016  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f11697qGY) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                m10976qdMbNW();
            } else if (actionMasked != 2) {
                if (actionMasked == 3) {
                }
            }
            return this.f11694fehf && this.f11699rkYL;
        }
        this.f11692YoKzxo = true;
        this.f11691VA = false;
        this.f11696mjFkc.m10986VA(m10969ZfxDd(0, motionEvent.getX(), view.getWidth(), this.f11700wA.getWidth()), m10969ZfxDd(1, motionEvent.getY(), view.getHeight(), this.f11700wA.getHeight()));
        if (!this.f11699rkYL && m10971eyqo()) {
            m10966Ucbh();
        }
        if (this.f11694fehf) {
            return false;
        }
    }

    /* renamed from: qGY */
    public AbstractViewOnTouchListenerC3191XtE m10975qGY(float f, float f2) {
        float[] fArr = this.f11686Dt;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: qdMbNW */
    public final void m10976qdMbNW() {
        if (this.f11690MiMN) {
            this.f11699rkYL = false;
        } else {
            this.f11696mjFkc.m10990qdMbNW();
        }
    }

    /* renamed from: rkYL */
    public AbstractViewOnTouchListenerC3191XtE m10977rkYL(float f, float f2) {
        float[] fArr = this.f11687ETF;
        fArr[0] = f / 1000.0f;
        fArr[1] = f2 / 1000.0f;
        return this;
    }

    /* renamed from: wA */
    public void m10978wA() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f11700wA.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* renamed from: xJ */
    public final float m10979xJ(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        int i = this.f11701xJ;
        if (i == 0 || i == 1) {
            if (f < f2) {
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f11699rkYL && i == 1) {
                    return 1.0f;
                }
            }
        } else if (i == 2 && f < 0.0f) {
            return f / (-f2);
        }
        return 0.0f;
    }
}
