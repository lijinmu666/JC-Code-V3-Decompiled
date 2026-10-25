package p131o;

import android.graphics.Rect;
import android.view.DisplayCutout;
import java.util.List;

/* renamed from: o.CRhd */
/* loaded from: classes.dex */
public final class C1760CRhd {

    /* renamed from: mjFkc */
    public final DisplayCutout f7630mjFkc;

    /* renamed from: o.CRhd$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static List<Rect> m7840AZxh(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        /* renamed from: JHa */
        public static int m7841JHa(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }

        /* renamed from: KLFTb */
        public static int m7842KLFTb(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        /* renamed from: ZfxDd */
        public static int m7843ZfxDd(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        /* renamed from: mjFkc */
        public static DisplayCutout m7844mjFkc(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        /* renamed from: wA */
        public static int m7845wA(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }
    }

    public C1760CRhd(DisplayCutout displayCutout) {
        this.f7630mjFkc = displayCutout;
    }

    /* renamed from: KLFTb */
    public static C1760CRhd m7834KLFTb(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new C1760CRhd(displayCutout);
    }

    /* renamed from: AZxh */
    public int m7835AZxh() {
        return mjFkc.m7843ZfxDd(this.f7630mjFkc);
    }

    /* renamed from: ZfxDd */
    public int m7836ZfxDd() {
        return mjFkc.m7841JHa(this.f7630mjFkc);
    }

    /* renamed from: equals */
    public boolean m7837equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1760CRhd.class != obj.getClass()) {
            return false;
        }
        return AbstractC3003V2.m10659mjFkc(this.f7630mjFkc, ((C1760CRhd) obj).f7630mjFkc);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f7630mjFkc;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    /* renamed from: mjFkc */
    public int m7838mjFkc() {
        return mjFkc.m7845wA(this.f7630mjFkc);
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f7630mjFkc + "}";
    }

    /* renamed from: wA */
    public int m7839wA() {
        return mjFkc.m7842KLFTb(this.f7630mjFkc);
    }
}
