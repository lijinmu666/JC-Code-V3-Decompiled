package p131o;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import p131o.InterfaceC1662B;

/* renamed from: o.Kd */
/* loaded from: classes.dex */
public final class C2320Kd extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2320Kd> f9207CREATOR = new C2380Ld();

    /* renamed from: AZxh */
    public final IBinder f9208AZxh;

    /* renamed from: KLFTb */
    public final boolean f9209KLFTb;

    /* renamed from: ZfxDd */
    public final boolean f9210ZfxDd;

    /* renamed from: mjFkc */
    public final int f9211mjFkc;

    /* renamed from: wA */
    public final C3613eEOGOh f9212wA;

    public C2320Kd(int i, IBinder iBinder, C3613eEOGOh c3613eEOGOh, boolean z, boolean z2) {
        this.f9211mjFkc = i;
        this.f9208AZxh = iBinder;
        this.f9212wA = c3613eEOGOh;
        this.f9210ZfxDd = z;
        this.f9209KLFTb = z2;
    }

    /* renamed from: AZxh */
    public final InterfaceC1662B m9269AZxh() {
        IBinder iBinder = this.f9208AZxh;
        if (iBinder == null) {
            return null;
        }
        return InterfaceC1662B.mjFkc.m7645KLFTb(iBinder);
    }

    /* renamed from: equals */
    public final boolean m9270equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C2320Kd)) {
            return false;
        }
        C2320Kd c2320Kd = (C2320Kd) obj;
        return this.f9212wA.m11825equals(c2320Kd.f9212wA) && AbstractC2931U2.m10465mjFkc(m9269AZxh(), c2320Kd.m9269AZxh());
    }

    /* renamed from: mjFkc */
    public final C3613eEOGOh m9271mjFkc() {
        return this.f9212wA;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, this.f9211mjFkc);
        AbstractC3997k6.m12471JHa(parcel, 2, this.f9208AZxh, false);
        AbstractC3997k6.m12468Dt(parcel, 3, this.f9212wA, i, false);
        AbstractC3997k6.m12483wA(parcel, 4, this.f9210ZfxDd);
        AbstractC3997k6.m12483wA(parcel, 5, this.f9209KLFTb);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
