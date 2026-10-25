package p131o;

import android.graphics.RectF;
import java.util.Arrays;

/* renamed from: o.KLMXS */
/* loaded from: classes.dex */
public final class C2300KLMXS implements InterfaceC3498cQmsjG {

    /* renamed from: AZxh */
    public final float f9150AZxh;

    /* renamed from: mjFkc */
    public final InterfaceC3498cQmsjG f9151mjFkc;

    public C2300KLMXS(float f, InterfaceC3498cQmsjG interfaceC3498cQmsjG) {
        while (interfaceC3498cQmsjG instanceof C2300KLMXS) {
            interfaceC3498cQmsjG = ((C2300KLMXS) interfaceC3498cQmsjG).f9151mjFkc;
            f += ((C2300KLMXS) interfaceC3498cQmsjG).f9150AZxh;
        }
        this.f9151mjFkc = interfaceC3498cQmsjG;
        this.f9150AZxh = f;
    }

    /* renamed from: equals */
    public boolean m9184equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2300KLMXS)) {
            return false;
        }
        C2300KLMXS c2300klmxs = (C2300KLMXS) obj;
        return this.f9151mjFkc.equals(c2300klmxs.f9151mjFkc) && this.f9150AZxh == c2300klmxs.f9150AZxh;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f9151mjFkc, Float.valueOf(this.f9150AZxh)});
    }

    @Override // p131o.InterfaceC3498cQmsjG
    /* renamed from: mjFkc */
    public float mo9185mjFkc(RectF rectF) {
        return Math.max(0.0f, this.f9151mjFkc.mo9185mjFkc(rectF) + this.f9150AZxh);
    }
}
