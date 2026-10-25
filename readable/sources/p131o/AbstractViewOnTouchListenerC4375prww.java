package p131o;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;

/* renamed from: o.prww */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC4375prww implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: AZxh */
    public final int f15972AZxh;

    /* renamed from: JHa */
    public Runnable f15973JHa;

    /* renamed from: KLFTb */
    public Runnable f15974KLFTb;

    /* renamed from: ZfxDd */
    public final View f15975ZfxDd;

    /* renamed from: lgHUyS */
    public int f15976lgHUyS;

    /* renamed from: mjFkc */
    public final float f15977mjFkc;

    /* renamed from: qdMbNW */
    public final int[] f15978qdMbNW = new int[2];

    /* renamed from: wA */
    public final int f15979wA;

    /* renamed from: xJ */
    public boolean f15980xJ;

    /* renamed from: o.prww$AZxh */
    public class AZxh implements Runnable {
        public AZxh() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractViewOnTouchListenerC4375prww.this.m13142KLFTb();
        }
    }

    /* renamed from: o.prww$mjFkc */
    public class mjFkc implements Runnable {
        public mjFkc() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = AbstractViewOnTouchListenerC4375prww.this.f15975ZfxDd.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    public AbstractViewOnTouchListenerC4375prww(View view) {
        this.f15975ZfxDd = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f15977mjFkc = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f15972AZxh = tapTimeout;
        this.f15979wA = (tapTimeout + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    /* renamed from: lgHUyS */
    public static boolean m13139lgHUyS(View view, float f, float f2, float f3) {
        float f4 = -f3;
        return f >= f4 && f2 >= f4 && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
    }

    /* renamed from: AZxh */
    public abstract InterfaceC2674Q6 mo44AZxh();

    /* renamed from: Dt */
    public final boolean m13140Dt(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f15978qdMbNW);
        motionEvent.offsetLocation(-r1[0], -r1[1]);
        return true;
    }

    /* renamed from: JHa */
    public final boolean m13141JHa(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException {
        AbstractC2511NU abstractC2511NU;
        View view = this.f15975ZfxDd;
        InterfaceC2674Q6 interfaceC2674Q6Mo44AZxh = mo44AZxh();
        if (interfaceC2674Q6Mo44AZxh == null || !interfaceC2674Q6Mo44AZxh.mo9Dt() || (abstractC2511NU = (AbstractC2511NU) interfaceC2674Q6Mo44AZxh.mo12KLFTb()) == null || !abstractC2511NU.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        m13144qdMbNW(view, motionEventObtainNoHistory);
        m13140Dt(abstractC2511NU, motionEventObtainNoHistory);
        boolean zMo9663KLFTb = abstractC2511NU.mo9663KLFTb(motionEventObtainNoHistory, this.f15976lgHUyS);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zMo9663KLFTb && (actionMasked != 1 && actionMasked != 3);
    }

    /* renamed from: KLFTb */
    public void m13142KLFTb() {
        m13143mjFkc();
        View view = this.f15975ZfxDd;
        if (view.isEnabled() && !view.isLongClickable() && mo45wA()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.f15980xJ = true;
        }
    }

    /* renamed from: ZfxDd */
    public boolean mo368ZfxDd() {
        InterfaceC2674Q6 interfaceC2674Q6Mo44AZxh = mo44AZxh();
        if (interfaceC2674Q6Mo44AZxh == null || !interfaceC2674Q6Mo44AZxh.mo9Dt()) {
            return true;
        }
        interfaceC2674Q6Mo44AZxh.mo21ZfxDd();
        return true;
    }

    /* renamed from: mjFkc */
    public final void m13143mjFkc() {
        Runnable runnable = this.f15973JHa;
        if (runnable != null) {
            this.f15975ZfxDd.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f15974KLFTb;
        if (runnable2 != null) {
            this.f15975ZfxDd.removeCallbacks(runnable2);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.f15980xJ;
        if (z2) {
            z = m13141JHa(motionEvent) || !mo368ZfxDd();
        } else {
            z = m13145xJ(motionEvent) && mo45wA();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                this.f15975ZfxDd.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.f15980xJ = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f15980xJ = false;
        this.f15976lgHUyS = -1;
        Runnable runnable = this.f15974KLFTb;
        if (runnable != null) {
            this.f15975ZfxDd.removeCallbacks(runnable);
        }
    }

    /* renamed from: qdMbNW */
    public final boolean m13144qdMbNW(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.f15978qdMbNW);
        motionEvent.offsetLocation(r1[0], r1[1]);
        return true;
    }

    /* renamed from: wA */
    public abstract boolean mo45wA();

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* renamed from: xJ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m13145xJ(MotionEvent motionEvent) {
        View view = this.f15975ZfxDd;
        if (!view.isEnabled()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f15976lgHUyS = motionEvent.getPointerId(0);
            if (this.f15974KLFTb == null) {
                this.f15974KLFTb = new mjFkc();
            }
            view.postDelayed(this.f15974KLFTb, this.f15972AZxh);
            if (this.f15973JHa == null) {
                this.f15973JHa = new AZxh();
            }
            view.postDelayed(this.f15973JHa, this.f15979wA);
        } else if (actionMasked == 1) {
            m13143mjFkc();
        } else if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f15976lgHUyS);
            if (iFindPointerIndex >= 0 && !m13139lgHUyS(view, motionEvent.getX(iFindPointerIndex), motionEvent.getY(iFindPointerIndex), this.f15977mjFkc)) {
                m13143mjFkc();
                view.getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            }
        } else if (actionMasked == 3) {
        }
        return false;
    }
}
