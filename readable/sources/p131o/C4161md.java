package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.md */
/* loaded from: classes.dex */
public final class C4161md extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4161md> f15203CREATOR = new C4226nd();

    /* renamed from: AZxh */
    public final C3613eEOGOh f15204AZxh;

    /* renamed from: mjFkc */
    public final int f15205mjFkc;

    /* renamed from: wA */
    public final C2320Kd f15206wA;

    public C4161md(int i, C3613eEOGOh c3613eEOGOh, C2320Kd c2320Kd) {
        this.f15205mjFkc = i;
        this.f15204AZxh = c3613eEOGOh;
        this.f15206wA = c2320Kd;
    }

    /* renamed from: AZxh */
    public final C2320Kd m12776AZxh() {
        return this.f15206wA;
    }

    /* renamed from: mjFkc */
    public final C3613eEOGOh m12777mjFkc() {
        return this.f15204AZxh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, this.f15205mjFkc);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f15204AZxh, i, false);
        AbstractC3997k6.m12468Dt(parcel, 3, this.f15206wA, i, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
