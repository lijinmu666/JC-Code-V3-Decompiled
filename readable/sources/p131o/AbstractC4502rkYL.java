package p131o;

import android.view.accessibility.AccessibilityManager;

/* renamed from: o.rkYL */
/* loaded from: classes.dex */
public abstract class AbstractC4502rkYL {

    /* renamed from: o.rkYL$AZxh */
    public static final class AZxh implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: mjFkc */
        public final mjFkc f16389mjFkc;

        public AZxh(mjFkc mjfkc) {
            this.f16389mjFkc = mjfkc;
        }

        /* renamed from: equals */
        public boolean m13398equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof AZxh) {
                return this.f16389mjFkc.equals(((AZxh) obj).f16389mjFkc);
            }
            return false;
        }

        public int hashCode() {
            return this.f16389mjFkc.hashCode();
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z) {
            this.f16389mjFkc.onTouchExplorationStateChanged(z);
        }
    }

    /* renamed from: o.rkYL$mjFkc */
    public interface mjFkc {
        void onTouchExplorationStateChanged(boolean z);
    }

    /* renamed from: AZxh */
    public static boolean m13396AZxh(AccessibilityManager accessibilityManager, mjFkc mjfkc) {
        return accessibilityManager.removeTouchExplorationStateChangeListener(new AZxh(mjfkc));
    }

    /* renamed from: mjFkc */
    public static boolean m13397mjFkc(AccessibilityManager accessibilityManager, mjFkc mjfkc) {
        return accessibilityManager.addTouchExplorationStateChangeListener(new AZxh(mjfkc));
    }
}
