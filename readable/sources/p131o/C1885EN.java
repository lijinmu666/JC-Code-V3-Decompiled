package p131o;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.EN */
/* loaded from: classes.dex */
public final class C1885EN extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C1885EN> f7979CREATOR = new C2435MO();

    /* renamed from: AZxh */
    public C2987UokA[] f7980AZxh;

    /* renamed from: ZfxDd */
    public C1674BABY f7981ZfxDd;

    /* renamed from: mjFkc */
    public Bundle f7982mjFkc;

    /* renamed from: wA */
    public int f7983wA;

    public C1885EN(Bundle bundle, C2987UokA[] c2987UokAArr, int i, C1674BABY c1674baby) {
        this.f7982mjFkc = bundle;
        this.f7980AZxh = c2987UokAArr;
        this.f7983wA = i;
        this.f7981ZfxDd = c1674baby;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12476ZfxDd(parcel, 1, this.f7982mjFkc, false);
        AbstractC3997k6.m12473MiMN(parcel, 2, this.f7980AZxh, i, false);
        AbstractC3997k6.m12484xJ(parcel, 3, this.f7983wA);
        AbstractC3997k6.m12468Dt(parcel, 4, this.f7981ZfxDd, i, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
