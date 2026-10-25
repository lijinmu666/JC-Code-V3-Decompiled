package p131o;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;

/* renamed from: o.ZODYfo */
/* loaded from: classes.dex */
public class C3294ZODYfo {

    /* renamed from: AZxh */
    public final InterfaceC3194XvQLwQ f12161AZxh;

    /* renamed from: Dt */
    public final int[] f12162Dt;

    /* renamed from: JHa */
    public float f12163JHa;

    /* renamed from: KLFTb */
    public VelocityTracker f12164KLFTb;

    /* renamed from: ZfxDd */
    public final mjFkc f12165ZfxDd;

    /* renamed from: lgHUyS */
    public int f12166lgHUyS;

    /* renamed from: mjFkc */
    public final Context f12167mjFkc;

    /* renamed from: qdMbNW */
    public int f12168qdMbNW;

    /* renamed from: wA */
    public final AZxh f12169wA;

    /* renamed from: xJ */
    public int f12170xJ;

    /* renamed from: o.ZODYfo$AZxh */
    public interface AZxh {
        /* renamed from: mjFkc */
        void mo9969mjFkc(Context context, int[] iArr, MotionEvent motionEvent, int i);
    }

    /* renamed from: o.ZODYfo$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        float mo9508mjFkc(VelocityTracker velocityTracker, MotionEvent motionEvent, int i);
    }

    public C3294ZODYfo(Context context, InterfaceC3194XvQLwQ interfaceC3194XvQLwQ) {
        this(context, interfaceC3194XvQLwQ, new AZxh() { // from class: o.PvPg
            @Override // p131o.C3294ZODYfo.AZxh
            /* renamed from: mjFkc */
            public final void mo9969mjFkc(Context context2, int[] iArr, MotionEvent motionEvent, int i) {
                C3294ZODYfo.m11197wA(context2, iArr, motionEvent, i);
            }
        }, new mjFkc() { // from class: o.MQhVKd
            @Override // p131o.C3294ZODYfo.mjFkc
            /* renamed from: mjFkc */
            public final float mo9508mjFkc(VelocityTracker velocityTracker, MotionEvent motionEvent, int i) {
                return C3294ZODYfo.m11195JHa(velocityTracker, motionEvent, i);
            }
        });
    }

    /* renamed from: JHa */
    public static float m11195JHa(VelocityTracker velocityTracker, MotionEvent motionEvent, int i) {
        AbstractC2417M9.m9487mjFkc(velocityTracker, motionEvent);
        AbstractC2417M9.m9484AZxh(velocityTracker, NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE);
        return AbstractC2417M9.m9486ZfxDd(velocityTracker, i);
    }

    /* renamed from: wA */
    public static void m11197wA(Context context, int[] iArr, MotionEvent motionEvent, int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        iArr[0] = AbstractC3141X9.m10904xJ(context, viewConfiguration, motionEvent.getDeviceId(), i, motionEvent.getSource());
        iArr[1] = AbstractC3141X9.m10897JHa(context, viewConfiguration, motionEvent.getDeviceId(), i, motionEvent.getSource());
    }

    /* renamed from: KLFTb */
    public final float m11198KLFTb(MotionEvent motionEvent, int i) {
        if (this.f12164KLFTb == null) {
            this.f12164KLFTb = VelocityTracker.obtain();
        }
        return this.f12165ZfxDd.mo9508mjFkc(this.f12164KLFTb, motionEvent, i);
    }

    /* renamed from: ZfxDd */
    public final boolean m11199ZfxDd(MotionEvent motionEvent, int i) {
        int source = motionEvent.getSource();
        int deviceId = motionEvent.getDeviceId();
        if (this.f12166lgHUyS == source && this.f12168qdMbNW == deviceId && this.f12170xJ == i) {
            return false;
        }
        this.f12169wA.mo9969mjFkc(this.f12167mjFkc, this.f12162Dt, motionEvent, i);
        this.f12166lgHUyS = source;
        this.f12168qdMbNW = deviceId;
        this.f12170xJ = i;
        return true;
    }

    /* renamed from: xJ */
    public void m11200xJ(MotionEvent motionEvent, int i) {
        boolean zM11199ZfxDd = m11199ZfxDd(motionEvent, i);
        if (this.f12162Dt[0] == Integer.MAX_VALUE) {
            VelocityTracker velocityTracker = this.f12164KLFTb;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f12164KLFTb = null;
                return;
            }
            return;
        }
        float fM11198KLFTb = m11198KLFTb(motionEvent, i) * this.f12161AZxh.mo621AZxh();
        float fSignum = Math.signum(fM11198KLFTb);
        if (zM11199ZfxDd || (fSignum != Math.signum(this.f12163JHa) && fSignum != 0.0f)) {
            this.f12161AZxh.mo623wA();
        }
        float fAbs = Math.abs(fM11198KLFTb);
        int[] iArr = this.f12162Dt;
        if (fAbs < iArr[0]) {
            return;
        }
        float fMax = Math.max(-r6, Math.min(fM11198KLFTb, iArr[1]));
        this.f12163JHa = this.f12161AZxh.mo622mjFkc(fMax) ? fMax : 0.0f;
    }

    public C3294ZODYfo(Context context, InterfaceC3194XvQLwQ interfaceC3194XvQLwQ, AZxh aZxh, mjFkc mjfkc) {
        this.f12170xJ = -1;
        this.f12166lgHUyS = -1;
        this.f12168qdMbNW = -1;
        this.f12162Dt = new int[]{Integer.MAX_VALUE, 0};
        this.f12167mjFkc = context;
        this.f12161AZxh = interfaceC3194XvQLwQ;
        this.f12169wA = aZxh;
        this.f12165ZfxDd = mjfkc;
    }
}
