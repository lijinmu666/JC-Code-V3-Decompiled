package p131o;

import android.graphics.Insets;
import android.graphics.Rect;

/* renamed from: o.S */
/* loaded from: classes.dex */
public final class C2798S {

    /* renamed from: KLFTb */
    public static final C2798S f10505KLFTb = new C2798S(0, 0, 0, 0);

    /* renamed from: AZxh */
    public final int f10506AZxh;

    /* renamed from: ZfxDd */
    public final int f10507ZfxDd;

    /* renamed from: mjFkc */
    public final int f10508mjFkc;

    /* renamed from: wA */
    public final int f10509wA;

    /* renamed from: o.S$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static Insets m10124mjFkc(int i, int i2, int i3, int i4) {
            return Insets.of(i, i2, i3, i4);
        }
    }

    public C2798S(int i, int i2, int i3, int i4) {
        this.f10508mjFkc = i;
        this.f10506AZxh = i2;
        this.f10509wA = i3;
        this.f10507ZfxDd = i4;
    }

    /* renamed from: AZxh */
    public static C2798S m10118AZxh(int i, int i2, int i3, int i4) {
        return (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) ? f10505KLFTb : new C2798S(i, i2, i3, i4);
    }

    /* renamed from: ZfxDd */
    public static C2798S m10119ZfxDd(Insets insets) {
        return m10118AZxh(insets.left, insets.top, insets.right, insets.bottom);
    }

    /* renamed from: mjFkc */
    public static C2798S m10120mjFkc(C2798S c2798s, C2798S c2798s2) {
        return m10118AZxh(Math.max(c2798s.f10508mjFkc, c2798s2.f10508mjFkc), Math.max(c2798s.f10506AZxh, c2798s2.f10506AZxh), Math.max(c2798s.f10509wA, c2798s2.f10509wA), Math.max(c2798s.f10507ZfxDd, c2798s2.f10507ZfxDd));
    }

    /* renamed from: wA */
    public static C2798S m10121wA(Rect rect) {
        return m10118AZxh(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: KLFTb */
    public Insets m10122KLFTb() {
        return mjFkc.m10124mjFkc(this.f10508mjFkc, this.f10506AZxh, this.f10509wA, this.f10507ZfxDd);
    }

    /* renamed from: equals */
    public boolean m10123equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2798S.class != obj.getClass()) {
            return false;
        }
        C2798S c2798s = (C2798S) obj;
        return this.f10507ZfxDd == c2798s.f10507ZfxDd && this.f10508mjFkc == c2798s.f10508mjFkc && this.f10509wA == c2798s.f10509wA && this.f10506AZxh == c2798s.f10506AZxh;
    }

    public int hashCode() {
        return (((((this.f10508mjFkc * 31) + this.f10506AZxh) * 31) + this.f10509wA) * 31) + this.f10507ZfxDd;
    }

    public String toString() {
        return "Insets{left=" + this.f10508mjFkc + ", top=" + this.f10506AZxh + ", right=" + this.f10509wA + ", bottom=" + this.f10507ZfxDd + '}';
    }
}
