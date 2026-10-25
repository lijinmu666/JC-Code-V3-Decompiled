package p131o;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.Ob */
/* loaded from: classes.dex */
public final class C2577Ob extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2577Ob> f9963CREATOR = new C3508cc();

    /* renamed from: AZxh */
    public int f9964AZxh;

    /* renamed from: mjFkc */
    public final int f9965mjFkc;

    /* renamed from: wA */
    public Intent f9966wA;

    public C2577Ob(int i, int i2, Intent intent) {
        this.f9965mjFkc = i;
        this.f9964AZxh = i2;
        this.f9966wA = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f9965mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, i2);
        AbstractC3997k6.m12484xJ(parcel, 2, this.f9964AZxh);
        AbstractC3997k6.m12468Dt(parcel, 3, this.f9966wA, i, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
