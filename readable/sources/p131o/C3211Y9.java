package p131o;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import java.util.Arrays;

/* renamed from: o.Y9 */
/* loaded from: classes.dex */
public class C3211Y9 {

    /* renamed from: Gd */
    public static final Interpolator f11806Gd = new mjFkc();

    /* renamed from: AZxh */
    public int f11807AZxh;

    /* renamed from: Dt */
    public int[] f11808Dt;

    /* renamed from: ETF */
    public int f11809ETF;

    /* renamed from: IEE */
    public OverScroller f11810IEE;

    /* renamed from: JHa */
    public float[] f11811JHa;

    /* renamed from: KLFTb */
    public float[] f11812KLFTb;

    /* renamed from: MiMN */
    public float f11813MiMN;

    /* renamed from: Pq */
    public final wA f11814Pq;

    /* renamed from: Ucbh */
    public final ViewGroup f11815Ucbh;

    /* renamed from: VA */
    public VelocityTracker f11816VA;

    /* renamed from: YoKzxo */
    public float f11817YoKzxo;

    /* renamed from: ZfxDd */
    public float[] f11818ZfxDd;

    /* renamed from: diqgf */
    public View f11819diqgf;

    /* renamed from: eyqo */
    public boolean f11820eyqo;

    /* renamed from: fehf */
    public int f11821fehf;

    /* renamed from: lgHUyS */
    public int[] f11823lgHUyS;

    /* renamed from: mjFkc */
    public int f11824mjFkc;

    /* renamed from: qGY */
    public final int f11825qGY;

    /* renamed from: qdMbNW */
    public int[] f11826qdMbNW;

    /* renamed from: rkYL */
    public int f11827rkYL;

    /* renamed from: xJ */
    public float[] f11829xJ;

    /* renamed from: wA */
    public int f11828wA = -1;

    /* renamed from: huTpC */
    public final Runnable f11822huTpC = new AZxh();

    /* renamed from: o.Y9$AZxh */
    public class AZxh implements Runnable {
        public AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C3211Y9.this.m11074mByQ(0);
        }
    }

    /* renamed from: o.Y9$mjFkc */
    public class mjFkc implements Interpolator {
        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    }

    /* renamed from: o.Y9$wA */
    public static abstract class wA {
        /* renamed from: AZxh */
        public abstract int mo2483AZxh(View view, int i, int i2);

        /* renamed from: Dt */
        public abstract void mo2484Dt(int i);

        /* renamed from: ETF */
        public abstract void mo2485ETF(View view, int i, int i2, int i3, int i4);

        /* renamed from: JHa */
        public void m11084JHa(int i, int i2) {
        }

        /* renamed from: KLFTb */
        public int mo2576KLFTb(View view) {
            return 0;
        }

        /* renamed from: MiMN */
        public abstract boolean mo2486MiMN(View view, int i);

        /* renamed from: VA */
        public abstract void mo2487VA(View view, float f, float f2);

        /* renamed from: ZfxDd */
        public int mo2489ZfxDd(View view) {
            return 0;
        }

        /* renamed from: lgHUyS */
        public void m11085lgHUyS(int i, int i2) {
        }

        /* renamed from: mjFkc */
        public abstract int mo2490mjFkc(View view, int i, int i2);

        /* renamed from: qdMbNW */
        public void mo2491qdMbNW(View view, int i) {
        }

        /* renamed from: wA */
        public int m11086wA(int i) {
            return i;
        }

        /* renamed from: xJ */
        public boolean m11087xJ(int i) {
            return false;
        }
    }

    public C3211Y9(Context context, ViewGroup viewGroup, wA wAVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (wAVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.f11815Ucbh = viewGroup;
        this.f11814Pq = wAVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        int i = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.f11825qGY = i;
        this.f11827rkYL = i;
        this.f11807AZxh = viewConfiguration.getScaledTouchSlop();
        this.f11813MiMN = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f11817YoKzxo = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f11810IEE = new OverScroller(context, f11806Gd);
    }

    /* renamed from: MiMN */
    public static C3211Y9 m11049MiMN(ViewGroup viewGroup, wA wAVar) {
        return new C3211Y9(viewGroup.getContext(), viewGroup, wAVar);
    }

    /* renamed from: VA */
    public static C3211Y9 m11050VA(ViewGroup viewGroup, float f, wA wAVar) {
        C3211Y9 c3211y9M11049MiMN = m11049MiMN(viewGroup, wAVar);
        c3211y9M11049MiMN.f11807AZxh = (int) (c3211y9M11049MiMN.f11807AZxh * (1.0f / f));
        return c3211y9M11049MiMN;
    }

    /* renamed from: AZxh */
    public void m11051AZxh(View view, int i) {
        if (view.getParent() == this.f11815Ucbh) {
            this.f11819diqgf = view;
            this.f11828wA = i;
            this.f11814Pq.mo2491qdMbNW(view, i);
            m11074mByQ(1);
            return;
        }
        throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f11815Ucbh + ")");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r2v1, types: [o.Y9$wA] */
    /* renamed from: BAnRFn */
    public final void m11052BAnRFn(float f, float f2, int i) {
        boolean zM11080wA = m11080wA(f, f2, i, 1);
        boolean z = zM11080wA;
        if (m11080wA(f2, f, i, 4)) {
            z = (zM11080wA ? 1 : 0) | 4;
        }
        boolean z2 = z;
        if (m11080wA(f, f2, i, 2)) {
            z2 = (z ? 1 : 0) | 2;
        }
        ?? r0 = z2;
        if (m11080wA(f2, f, i, 8)) {
            r0 = (z2 ? 1 : 0) | 8;
        }
        if (r0 != 0) {
            int[] iArr = this.f11826qdMbNW;
            iArr[i] = iArr[i] | r0;
            this.f11814Pq.m11084JHa(r0, i);
        }
    }

    /* renamed from: CqaNbM */
    public boolean m11053CqaNbM(View view, int i, int i2) {
        this.f11819diqgf = view;
        this.f11828wA = -1;
        boolean zM11063Pq = m11063Pq(i, i2, 0, 0);
        if (!zM11063Pq && this.f11824mjFkc == 0 && this.f11819diqgf != null) {
            this.f11819diqgf = null;
        }
        return zM11063Pq;
    }

    /* renamed from: Dt */
    public final int m11054Dt(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int iM11059JHa = m11059JHa(i3, (int) this.f11817YoKzxo, (int) this.f11813MiMN);
        int iM11059JHa2 = m11059JHa(i4, (int) this.f11817YoKzxo, (int) this.f11813MiMN);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iM11059JHa);
        int iAbs4 = Math.abs(iM11059JHa2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        if (iM11059JHa != 0) {
            f = iAbs3;
            f2 = i5;
        } else {
            f = iAbs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (iM11059JHa2 != 0) {
            f3 = iAbs4;
            f4 = i5;
        } else {
            f3 = iAbs2;
            f4 = i6;
        }
        return (int) ((m11077qdMbNW(i, iM11059JHa, this.f11814Pq.mo2489ZfxDd(view)) * f5) + (m11077qdMbNW(i2, iM11059JHa2, this.f11814Pq.mo2576KLFTb(view)) * (f3 / f4)));
    }

    /* renamed from: ETF */
    public boolean m11055ETF(boolean z) {
        if (this.f11824mjFkc == 2) {
            boolean zComputeScrollOffset = this.f11810IEE.computeScrollOffset();
            int currX = this.f11810IEE.getCurrX();
            int currY = this.f11810IEE.getCurrY();
            int left = currX - this.f11819diqgf.getLeft();
            int top = currY - this.f11819diqgf.getTop();
            if (left != 0) {
                AbstractC2876T9.m10259WrLQs(this.f11819diqgf, left);
            }
            if (top != 0) {
                AbstractC2876T9.m10240KRTLGT(this.f11819diqgf, top);
            }
            if (left != 0 || top != 0) {
                this.f11814Pq.mo2485ETF(this.f11819diqgf, currX, currY, left, top);
            }
            if (zComputeScrollOffset && currX == this.f11810IEE.getFinalX() && currY == this.f11810IEE.getFinalY()) {
                this.f11810IEE.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                if (z) {
                    this.f11815Ucbh.post(this.f11822huTpC);
                } else {
                    m11074mByQ(0);
                }
            }
        }
        return this.f11824mjFkc == 2;
    }

    /* renamed from: Gd */
    public final boolean m11056Gd(int i) {
        if (m11071huTpC(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    /* renamed from: HGpJ */
    public boolean m11057HGpJ(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    /* renamed from: IEE */
    public View m11058IEE(int i, int i2) {
        for (int childCount = this.f11815Ucbh.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f11815Ucbh.getChildAt(this.f11814Pq.m11086wA(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: JHa */
    public final int m11059JHa(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        return iAbs > i3 ? i > 0 ? i3 : -i3 : i;
    }

    /* renamed from: KLFTb */
    public final float m11060KLFTb(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        return fAbs > f3 ? f > 0.0f ? f3 : -f3 : f;
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ff  */
    /* renamed from: Ne */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m11061Ne(MotionEvent motionEvent) {
        boolean z;
        View viewM11058IEE;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m11075mjFkc();
        }
        if (this.f11816VA == null) {
            this.f11816VA = VelocityTracker.obtain();
        }
        this.f11816VA.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            z = false;
            int pointerId = motionEvent.getPointerId(0);
            m11072lB(x, y, pointerId);
            View viewM11058IEE2 = m11058IEE((int) x, (int) y);
            if (viewM11058IEE2 == this.f11819diqgf && this.f11824mjFkc == 2) {
                m11083xrEuO(viewM11058IEE2, pointerId);
            }
            int i = this.f11823lgHUyS[pointerId];
            int i2 = this.f11821fehf;
            if ((i & i2) != 0) {
                this.f11814Pq.m11085lgHUyS(i & i2, pointerId);
            }
        } else if (actionMasked == 1) {
            m11075mjFkc();
            z = false;
        } else {
            if (actionMasked != 2) {
                if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        float x2 = motionEvent.getX(actionIndex);
                        float y2 = motionEvent.getY(actionIndex);
                        m11072lB(x2, y2, pointerId2);
                        int i3 = this.f11824mjFkc;
                        if (i3 == 0) {
                            int i4 = this.f11823lgHUyS[pointerId2];
                            int i5 = this.f11821fehf;
                            if ((i4 & i5) != 0) {
                                this.f11814Pq.m11085lgHUyS(i4 & i5, pointerId2);
                            }
                        } else if (i3 == 2 && (viewM11058IEE = m11058IEE((int) x2, (int) y2)) == this.f11819diqgf) {
                            m11083xrEuO(viewM11058IEE, pointerId2);
                        }
                    } else if (actionMasked == 6) {
                        m11073lgHUyS(motionEvent.getPointerId(actionIndex));
                    }
                }
            } else if (this.f11818ZfxDd != null && this.f11812KLFTb != null) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i6 = 0; i6 < pointerCount; i6++) {
                    int pointerId3 = motionEvent.getPointerId(i6);
                    if (m11056Gd(pointerId3)) {
                        float x3 = motionEvent.getX(i6);
                        float y3 = motionEvent.getY(i6);
                        float f = x3 - this.f11818ZfxDd[pointerId3];
                        float f2 = y3 - this.f11812KLFTb[pointerId3];
                        View viewM11058IEE3 = m11058IEE((int) x3, (int) y3);
                        boolean z2 = viewM11058IEE3 != null && m11067ZfxDd(viewM11058IEE3, f, f2);
                        if (z2) {
                            int left = viewM11058IEE3.getLeft();
                            int i7 = (int) f;
                            int iMo2490mjFkc = this.f11814Pq.mo2490mjFkc(viewM11058IEE3, left + i7, i7);
                            int top = viewM11058IEE3.getTop();
                            int i8 = (int) f2;
                            int iMo2483AZxh = this.f11814Pq.mo2483AZxh(viewM11058IEE3, top + i8, i8);
                            int iMo2489ZfxDd = this.f11814Pq.mo2489ZfxDd(viewM11058IEE3);
                            int iMo2576KLFTb = this.f11814Pq.mo2576KLFTb(viewM11058IEE3);
                            if ((iMo2489ZfxDd == 0 || (iMo2489ZfxDd > 0 && iMo2490mjFkc == left)) && (iMo2576KLFTb == 0 || (iMo2576KLFTb > 0 && iMo2483AZxh == top))) {
                                break;
                            }
                            m11052BAnRFn(f, f2, pointerId3);
                            if (this.f11824mjFkc == 1 || (z2 && m11083xrEuO(viewM11058IEE3, pointerId3))) {
                                break;
                            }
                        }
                    }
                }
                m11081wJVbdd(motionEvent);
            }
            z = false;
        }
        if (this.f11824mjFkc == 1) {
            return true;
        }
        return z;
    }

    /* renamed from: OjSQV */
    public boolean m11062OjSQV(int i, int i2) {
        if (this.f11820eyqo) {
            return m11063Pq(i, i2, (int) this.f11816VA.getXVelocity(this.f11828wA), (int) this.f11816VA.getYVelocity(this.f11828wA));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* renamed from: Pq */
    public final boolean m11063Pq(int i, int i2, int i3, int i4) {
        int left = this.f11819diqgf.getLeft();
        int top = this.f11819diqgf.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f11810IEE.abortAnimation();
            m11074mByQ(0);
            return false;
        }
        this.f11810IEE.startScroll(left, top, i5, i6, m11054Dt(this.f11819diqgf, i5, i6, i3, i4));
        m11074mByQ(2);
        return true;
    }

    /* renamed from: Ucbh */
    public boolean m11064Ucbh(int i, int i2) {
        return m11057HGpJ(this.f11819diqgf, i, i2);
    }

    /* renamed from: VocHEe */
    public final void m11065VocHEe() {
        this.f11816VA.computeCurrentVelocity(NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE, this.f11813MiMN);
        m11066YoKzxo(m11060KLFTb(this.f11816VA.getXVelocity(this.f11828wA), this.f11817YoKzxo, this.f11813MiMN), m11060KLFTb(this.f11816VA.getYVelocity(this.f11828wA), this.f11817YoKzxo, this.f11813MiMN));
    }

    /* renamed from: YoKzxo */
    public final void m11066YoKzxo(float f, float f2) {
        this.f11820eyqo = true;
        this.f11814Pq.mo2487VA(this.f11819diqgf, f, f2);
        this.f11820eyqo = false;
        if (this.f11824mjFkc == 1) {
            m11074mByQ(0);
        }
    }

    /* renamed from: ZfxDd */
    public final boolean m11067ZfxDd(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f11814Pq.mo2489ZfxDd(view) > 0;
        boolean z2 = this.f11814Pq.mo2576KLFTb(view) > 0;
        if (!z || !z2) {
            return z ? Math.abs(f) > ((float) this.f11807AZxh) : z2 && Math.abs(f2) > ((float) this.f11807AZxh);
        }
        float f3 = (f * f) + (f2 * f2);
        int i = this.f11807AZxh;
        return f3 > ((float) (i * i));
    }

    /* renamed from: diqgf */
    public final int m11068diqgf(int i, int i2) {
        int i3 = i < this.f11815Ucbh.getLeft() + this.f11827rkYL ? 1 : 0;
        if (i2 < this.f11815Ucbh.getTop() + this.f11827rkYL) {
            i3 |= 4;
        }
        if (i > this.f11815Ucbh.getRight() - this.f11827rkYL) {
            i3 |= 2;
        }
        return i2 > this.f11815Ucbh.getBottom() - this.f11827rkYL ? i3 | 8 : i3;
    }

    /* renamed from: eyqo */
    public int m11069eyqo() {
        return this.f11807AZxh;
    }

    /* renamed from: fehf */
    public final void m11070fehf(int i) {
        float[] fArr = this.f11818ZfxDd;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.f11812KLFTb;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.f11811JHa;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.f11829xJ;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.f11823lgHUyS;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.f11826qdMbNW;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.f11808Dt;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.f11818ZfxDd = fArr2;
            this.f11812KLFTb = fArr3;
            this.f11811JHa = fArr4;
            this.f11829xJ = fArr5;
            this.f11823lgHUyS = iArr;
            this.f11826qdMbNW = iArr2;
            this.f11808Dt = iArr3;
        }
    }

    /* renamed from: huTpC */
    public boolean m11071huTpC(int i) {
        return (this.f11809ETF & (1 << i)) != 0;
    }

    /* renamed from: lB */
    public final void m11072lB(float f, float f2, int i) {
        m11070fehf(i);
        float[] fArr = this.f11818ZfxDd;
        this.f11811JHa[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.f11812KLFTb;
        this.f11829xJ[i] = f2;
        fArr2[i] = f2;
        this.f11823lgHUyS[i] = m11068diqgf((int) f, (int) f2);
        this.f11809ETF |= 1 << i;
    }

    /* renamed from: lgHUyS */
    public final void m11073lgHUyS(int i) {
        if (this.f11818ZfxDd == null || !m11071huTpC(i)) {
            return;
        }
        this.f11818ZfxDd[i] = 0.0f;
        this.f11812KLFTb[i] = 0.0f;
        this.f11811JHa[i] = 0.0f;
        this.f11829xJ[i] = 0.0f;
        this.f11823lgHUyS[i] = 0;
        this.f11826qdMbNW[i] = 0;
        this.f11808Dt[i] = 0;
        this.f11809ETF = (~(1 << i)) & this.f11809ETF;
    }

    /* renamed from: mByQ */
    public void m11074mByQ(int i) {
        this.f11815Ucbh.removeCallbacks(this.f11822huTpC);
        if (this.f11824mjFkc != i) {
            this.f11824mjFkc = i;
            this.f11814Pq.mo2484Dt(i);
            if (this.f11824mjFkc == 0) {
                this.f11819diqgf = null;
            }
        }
    }

    /* renamed from: mjFkc */
    public void m11075mjFkc() {
        this.f11828wA = -1;
        m11082xJ();
        VelocityTracker velocityTracker = this.f11816VA;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f11816VA = null;
        }
    }

    /* renamed from: qGY */
    public final void m11076qGY(int i, int i2, int i3, int i4) {
        int left = this.f11819diqgf.getLeft();
        int top = this.f11819diqgf.getTop();
        if (i3 != 0) {
            i = this.f11814Pq.mo2490mjFkc(this.f11819diqgf, i, i3);
            AbstractC2876T9.m10259WrLQs(this.f11819diqgf, i - left);
        }
        int i5 = i;
        if (i4 != 0) {
            i2 = this.f11814Pq.mo2483AZxh(this.f11819diqgf, i2, i4);
            AbstractC2876T9.m10240KRTLGT(this.f11819diqgf, i2 - top);
        }
        int i6 = i2;
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.f11814Pq.mo2485ETF(this.f11819diqgf, i5, i6, i5 - left, i6 - top);
    }

    /* renamed from: qdMbNW */
    public final int m11077qdMbNW(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f11815Ucbh.getWidth();
        float f = width / 2;
        float fM11078rkYL = f + (m11078rkYL(Math.min(1.0f, Math.abs(i) / width)) * f);
        int iAbs = Math.abs(i2);
        return Math.min(iAbs > 0 ? Math.round(Math.abs(fM11078rkYL / iAbs) * 1000.0f) * 4 : (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f), 600);
    }

    /* renamed from: rkYL */
    public final float m11078rkYL(float f) {
        return (float) Math.sin((f - 0.5f) * 0.47123894f);
    }

    /* renamed from: vI */
    public void m11079vI(MotionEvent motionEvent) {
        int i;
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            m11075mjFkc();
        }
        if (this.f11816VA == null) {
            this.f11816VA = VelocityTracker.obtain();
        }
        this.f11816VA.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = motionEvent.getPointerId(0);
            View viewM11058IEE = m11058IEE((int) x, (int) y);
            m11072lB(x, y, pointerId);
            m11083xrEuO(viewM11058IEE, pointerId);
            int i3 = this.f11823lgHUyS[pointerId];
            int i4 = this.f11821fehf;
            if ((i3 & i4) != 0) {
                this.f11814Pq.m11085lgHUyS(i3 & i4, pointerId);
                return;
            }
            return;
        }
        if (actionMasked == 1) {
            if (this.f11824mjFkc == 1) {
                m11065VocHEe();
            }
            m11075mjFkc();
            return;
        }
        if (actionMasked == 2) {
            if (this.f11824mjFkc == 1) {
                if (m11056Gd(this.f11828wA)) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f11828wA);
                    float x2 = motionEvent.getX(iFindPointerIndex);
                    float y2 = motionEvent.getY(iFindPointerIndex);
                    float[] fArr = this.f11811JHa;
                    int i5 = this.f11828wA;
                    int i6 = (int) (x2 - fArr[i5]);
                    int i7 = (int) (y2 - this.f11829xJ[i5]);
                    m11076qGY(this.f11819diqgf.getLeft() + i6, this.f11819diqgf.getTop() + i7, i6, i7);
                    m11081wJVbdd(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = motionEvent.getPointerCount();
            while (i2 < pointerCount) {
                int pointerId2 = motionEvent.getPointerId(i2);
                if (m11056Gd(pointerId2)) {
                    float x3 = motionEvent.getX(i2);
                    float y3 = motionEvent.getY(i2);
                    float f = x3 - this.f11818ZfxDd[pointerId2];
                    float f2 = y3 - this.f11812KLFTb[pointerId2];
                    m11052BAnRFn(f, f2, pointerId2);
                    if (this.f11824mjFkc != 1) {
                        View viewM11058IEE2 = m11058IEE((int) x3, (int) y3);
                        if (m11067ZfxDd(viewM11058IEE2, f, f2) && m11083xrEuO(viewM11058IEE2, pointerId2)) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                i2++;
            }
            m11081wJVbdd(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.f11824mjFkc == 1) {
                m11066YoKzxo(0.0f, 0.0f);
            }
            m11075mjFkc();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = motionEvent.getPointerId(actionIndex);
            float x4 = motionEvent.getX(actionIndex);
            float y4 = motionEvent.getY(actionIndex);
            m11072lB(x4, y4, pointerId3);
            if (this.f11824mjFkc != 0) {
                if (m11064Ucbh((int) x4, (int) y4)) {
                    m11083xrEuO(this.f11819diqgf, pointerId3);
                    return;
                }
                return;
            } else {
                m11083xrEuO(m11058IEE((int) x4, (int) y4), pointerId3);
                int i8 = this.f11823lgHUyS[pointerId3];
                int i9 = this.f11821fehf;
                if ((i8 & i9) != 0) {
                    this.f11814Pq.m11085lgHUyS(i8 & i9, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = motionEvent.getPointerId(actionIndex);
        if (this.f11824mjFkc == 1 && pointerId4 == this.f11828wA) {
            int pointerCount2 = motionEvent.getPointerCount();
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = motionEvent.getPointerId(i2);
                if (pointerId5 != this.f11828wA) {
                    View viewM11058IEE3 = m11058IEE((int) motionEvent.getX(i2), (int) motionEvent.getY(i2));
                    View view = this.f11819diqgf;
                    if (viewM11058IEE3 == view && m11083xrEuO(view, pointerId5)) {
                        i = this.f11828wA;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                m11065VocHEe();
            }
        }
        m11073lgHUyS(pointerId4);
    }

    /* renamed from: wA */
    public final boolean m11080wA(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.f11823lgHUyS[i] & i2) != i2 || (this.f11821fehf & i2) == 0 || (this.f11808Dt[i] & i2) == i2 || (this.f11826qdMbNW[i] & i2) == i2) {
            return false;
        }
        int i3 = this.f11807AZxh;
        if (fAbs <= i3 && fAbs2 <= i3) {
            return false;
        }
        if (fAbs >= fAbs2 * 0.5f || !this.f11814Pq.m11087xJ(i2)) {
            return (this.f11826qdMbNW[i] & i2) == 0 && fAbs > ((float) this.f11807AZxh);
        }
        int[] iArr = this.f11808Dt;
        iArr[i] = iArr[i] | i2;
        return false;
    }

    /* renamed from: wJVbdd */
    public final void m11081wJVbdd(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m11056Gd(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f11811JHa[pointerId] = x;
                this.f11829xJ[pointerId] = y;
            }
        }
    }

    /* renamed from: xJ */
    public final void m11082xJ() {
        float[] fArr = this.f11818ZfxDd;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f11812KLFTb, 0.0f);
        Arrays.fill(this.f11811JHa, 0.0f);
        Arrays.fill(this.f11829xJ, 0.0f);
        Arrays.fill(this.f11823lgHUyS, 0);
        Arrays.fill(this.f11826qdMbNW, 0);
        Arrays.fill(this.f11808Dt, 0);
        this.f11809ETF = 0;
    }

    /* renamed from: xrEuO */
    public boolean m11083xrEuO(View view, int i) {
        if (view == this.f11819diqgf && this.f11828wA == i) {
            return true;
        }
        if (view == null || !this.f11814Pq.mo2486MiMN(view, i)) {
            return false;
        }
        this.f11828wA = i;
        m11051AZxh(view, i);
        return true;
    }
}
