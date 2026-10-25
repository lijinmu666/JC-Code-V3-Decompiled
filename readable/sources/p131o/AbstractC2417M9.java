package p131o;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: o.M9 */
/* loaded from: classes.dex */
public abstract class AbstractC2417M9 {

    /* renamed from: mjFkc */
    public static Map f9555mjFkc = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: o.M9$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static float m9489AZxh(VelocityTracker velocityTracker, int i, int i2) {
            return velocityTracker.getAxisVelocity(i, i2);
        }

        /* renamed from: mjFkc */
        public static float m9490mjFkc(VelocityTracker velocityTracker, int i) {
            return velocityTracker.getAxisVelocity(i);
        }

        /* renamed from: wA */
        public static boolean m9491wA(VelocityTracker velocityTracker, int i) {
            return velocityTracker.isAxisSupported(i);
        }
    }

    /* renamed from: AZxh */
    public static void m9484AZxh(VelocityTracker velocityTracker, int i) {
        m9488wA(velocityTracker, i, Float.MAX_VALUE);
    }

    /* renamed from: KLFTb */
    public static C2486N9 m9485KLFTb(VelocityTracker velocityTracker) {
        return (C2486N9) f9555mjFkc.get(velocityTracker);
    }

    /* renamed from: ZfxDd */
    public static float m9486ZfxDd(VelocityTracker velocityTracker, int i) {
        if (Build.VERSION.SDK_INT >= 34) {
            return mjFkc.m9490mjFkc(velocityTracker, i);
        }
        if (i == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i == 1) {
            return velocityTracker.getYVelocity();
        }
        C2486N9 c2486n9M9485KLFTb = m9485KLFTb(velocityTracker);
        if (c2486n9M9485KLFTb != null) {
            return c2486n9M9485KLFTb.m9642ZfxDd(i);
        }
        return 0.0f;
    }

    /* renamed from: mjFkc */
    public static void m9487mjFkc(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!f9555mjFkc.containsKey(velocityTracker)) {
                f9555mjFkc.put(velocityTracker, new C2486N9());
            }
            ((C2486N9) f9555mjFkc.get(velocityTracker)).m9643mjFkc(motionEvent);
        }
    }

    /* renamed from: wA */
    public static void m9488wA(VelocityTracker velocityTracker, int i, float f) {
        velocityTracker.computeCurrentVelocity(i, f);
        C2486N9 c2486n9M9485KLFTb = m9485KLFTb(velocityTracker);
        if (c2486n9M9485KLFTb != null) {
            c2486n9M9485KLFTb.m9644wA(i, f);
        }
    }
}
