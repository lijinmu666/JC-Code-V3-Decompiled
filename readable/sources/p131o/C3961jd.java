package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.jd */
/* loaded from: classes.dex */
public final class C3961jd extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C3961jd> f14322CREATOR = new C4095ld();

    /* renamed from: AZxh */
    public final C1972Fd f14323AZxh;

    /* renamed from: mjFkc */
    public final int f14324mjFkc;

    public C3961jd(int i, C1972Fd c1972Fd) {
        this.f14324mjFkc = i;
        this.f14323AZxh = c1972Fd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, this.f14324mjFkc);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f14323AZxh, i, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
