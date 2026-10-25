package p131o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.p016widget.CoordinatorLayout;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;

/* renamed from: o.t */
/* loaded from: classes.dex */
public abstract class AbstractC4586t extends AbstractC4025ka {

    /* renamed from: Dt */
    public VelocityTracker f16574Dt;

    /* renamed from: JHa */
    public boolean f16575JHa;

    /* renamed from: KLFTb */
    public OverScroller f16576KLFTb;

    /* renamed from: ZfxDd */
    public Runnable f16577ZfxDd;

    /* renamed from: lgHUyS */
    public int f16578lgHUyS;

    /* renamed from: qdMbNW */
    public int f16579qdMbNW;

    /* renamed from: xJ */
    public int f16580xJ;

    /* renamed from: o.t$mjFkc */
    public class mjFkc implements Runnable {

        /* renamed from: AZxh */
        public final View f16581AZxh;

        /* renamed from: mjFkc */
        public final CoordinatorLayout f16582mjFkc;

        public mjFkc(CoordinatorLayout coordinatorLayout, View view) {
            this.f16582mjFkc = coordinatorLayout;
            this.f16581AZxh = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f16581AZxh == null || (overScroller = AbstractC4586t.this.f16576KLFTb) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                AbstractC4586t.this.mo2442rWxwaT(this.f16582mjFkc, this.f16581AZxh);
                return;
            }
            AbstractC4586t abstractC4586t = AbstractC4586t.this;
            abstractC4586t.m13538NPj(this.f16582mjFkc, this.f16581AZxh, abstractC4586t.f16576KLFTb.getCurrY());
            AbstractC2876T9.m10258WGXroI(this.f16581AZxh, this);
        }
    }

    public AbstractC4586t() {
        this.f16580xJ = -1;
        this.f16579qdMbNW = -1;
    }

    /* renamed from: CqaNbM */
    public final void m13537CqaNbM() {
        if (this.f16574Dt == null) {
            this.f16574Dt = VelocityTracker.obtain();
        }
    }

    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: ETF */
    public boolean mo488ETF(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f16579qdMbNW < 0) {
            this.f16579qdMbNW = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f16575JHa) {
            int i = this.f16580xJ;
            if (i == -1 || (iFindPointerIndex = motionEvent.findPointerIndex(i)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            if (Math.abs(y - this.f16578lgHUyS) > this.f16579qdMbNW) {
                this.f16578lgHUyS = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f16580xJ = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = mo2431Ne(view) && coordinatorLayout.m482vI(view, x, y2);
            this.f16575JHa = z;
            if (z) {
                this.f16578lgHUyS = y2;
                this.f16580xJ = motionEvent.getPointerId(0);
                m13537CqaNbM();
                OverScroller overScroller = this.f16576KLFTb;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f16576KLFTb.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f16574Dt;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* renamed from: KLMXS */
    public abstract int mo2429KLMXS(View view);

    /* renamed from: NPj */
    public int m13538NPj(CoordinatorLayout coordinatorLayout, View view, int i) {
        return mo2444vadzgd(coordinatorLayout, view, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* renamed from: Ne */
    public abstract boolean mo2431Ne(View view);

    /* renamed from: Vnb */
    public final int m13539Vnb(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        return mo2444vadzgd(coordinatorLayout, view, mo2439cMLeY() - i, i2, i3);
    }

    /* renamed from: cMLeY */
    public abstract int mo2439cMLeY();

    /* renamed from: rWxwaT */
    public abstract void mo2442rWxwaT(CoordinatorLayout coordinatorLayout, View view);

    /* renamed from: vadzgd */
    public abstract int mo2444vadzgd(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3);

    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.p016widget.CoordinatorLayout.AbstractC0058AZxh
    /* renamed from: wJVbdd */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean mo513wJVbdd(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean z;
        VelocityTracker velocityTracker;
        VelocityTracker velocityTracker2;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            VelocityTracker velocityTracker3 = this.f16574Dt;
            if (velocityTracker3 != null) {
                velocityTracker3.addMovement(motionEvent);
                this.f16574Dt.computeCurrentVelocity(NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE);
                m13540xrEuO(coordinatorLayout, view, -mo2445zvd(view), 0, this.f16574Dt.getYVelocity(this.f16580xJ));
                z = true;
            }
            this.f16575JHa = false;
            this.f16580xJ = -1;
            velocityTracker = this.f16574Dt;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f16574Dt = null;
            }
            velocityTracker2 = this.f16574Dt;
            if (velocityTracker2 != null) {
            }
            if (this.f16575JHa) {
                return true;
            }
        }
        if (actionMasked == 2) {
            int iFindPointerIndex = motionEvent.findPointerIndex(this.f16580xJ);
            if (iFindPointerIndex == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(iFindPointerIndex);
            int i = this.f16578lgHUyS - y;
            this.f16578lgHUyS = y;
            m13539Vnb(coordinatorLayout, view, i, mo2429KLMXS(view), 0);
        } else if (actionMasked != 3) {
            if (actionMasked == 6) {
                int i2 = motionEvent.getActionIndex() == 0 ? 1 : 0;
                this.f16580xJ = motionEvent.getPointerId(i2);
                this.f16578lgHUyS = (int) (motionEvent.getY(i2) + 0.5f);
            }
        }
        z = false;
        velocityTracker2 = this.f16574Dt;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return !this.f16575JHa || z;
        z = false;
        this.f16575JHa = false;
        this.f16580xJ = -1;
        velocityTracker = this.f16574Dt;
        if (velocityTracker != null) {
        }
        velocityTracker2 = this.f16574Dt;
        if (velocityTracker2 != null) {
        }
        if (this.f16575JHa) {
        }
    }

    /* renamed from: xrEuO */
    public final boolean m13540xrEuO(CoordinatorLayout coordinatorLayout, View view, int i, int i2, float f) {
        Runnable runnable = this.f16577ZfxDd;
        if (runnable != null) {
            view.removeCallbacks(runnable);
            this.f16577ZfxDd = null;
        }
        if (this.f16576KLFTb == null) {
            this.f16576KLFTb = new OverScroller(view.getContext());
        }
        this.f16576KLFTb.fling(0, mo2449mByQ(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.f16576KLFTb.computeScrollOffset()) {
            mo2442rWxwaT(coordinatorLayout, view);
            return false;
        }
        mjFkc mjfkc = new mjFkc(coordinatorLayout, view);
        this.f16577ZfxDd = mjfkc;
        AbstractC2876T9.m10258WGXroI(view, mjfkc);
        return true;
    }

    /* renamed from: zvd */
    public abstract int mo2445zvd(View view);

    public AbstractC4586t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16580xJ = -1;
        this.f16579qdMbNW = -1;
    }
}
