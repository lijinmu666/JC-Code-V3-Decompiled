package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.nn */
/* loaded from: classes.dex */
public final class C4237nn extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4237nn> f15462CREATOR = new C4506ro();

    /* renamed from: AZxh */
    public final int f15463AZxh;

    /* renamed from: KLFTb */
    public final float f15464KLFTb;

    /* renamed from: ZfxDd */
    public final int f15465ZfxDd;

    /* renamed from: mjFkc */
    public final int f15466mjFkc;

    /* renamed from: wA */
    public final int f15467wA;

    public C4237nn(int i, int i2, int i3, int i4, float f) {
        this.f15466mjFkc = i;
        this.f15463AZxh = i2;
        this.f15467wA = i3;
        this.f15465ZfxDd = i4;
        this.f15464KLFTb = f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f15466mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 2, i2);
        AbstractC3997k6.m12484xJ(parcel, 3, this.f15463AZxh);
        AbstractC3997k6.m12484xJ(parcel, 4, this.f15467wA);
        AbstractC3997k6.m12484xJ(parcel, 5, this.f15465ZfxDd);
        AbstractC3997k6.m12472KLFTb(parcel, 6, this.f15464KLFTb);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
