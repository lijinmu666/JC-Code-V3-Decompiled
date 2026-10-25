package p131o;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: o.ZfxDd */
/* loaded from: classes.dex */
public final class C3311ZfxDd implements InterfaceC3498cQmsjG {

    /* renamed from: mjFkc */
    public final float f12186mjFkc;

    public C3311ZfxDd(float f) {
        this.f12186mjFkc = f;
    }

    /* renamed from: equals */
    public boolean m11212equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3311ZfxDd) && this.f12186mjFkc == ((C3311ZfxDd) obj).f12186mjFkc;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f12186mjFkc)});
    }

    @Override // p131o.InterfaceC3498cQmsjG
    /* renamed from: mjFkc */
    public float mo9185mjFkc(RectF rectF) {
        return this.f12186mjFkc;
    }
}
