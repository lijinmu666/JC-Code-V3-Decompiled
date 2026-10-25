package p131o;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: o.h5 */
/* loaded from: classes.dex */
public final class C3801h5 implements InterfaceC3498cQmsjG {

    /* renamed from: mjFkc */
    public final float f13957mjFkc;

    public C3801h5(float f) {
        this.f13957mjFkc = f;
    }

    /* renamed from: AZxh */
    public static float m12165AZxh(RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    /* renamed from: equals */
    public boolean m12166equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3801h5) && this.f13957mjFkc == ((C3801h5) obj).f13957mjFkc;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f13957mjFkc)});
    }

    @Override // p131o.InterfaceC3498cQmsjG
    /* renamed from: mjFkc */
    public float mo9185mjFkc(RectF rectF) {
        return this.f13957mjFkc * m12165AZxh(rectF);
    }
}
