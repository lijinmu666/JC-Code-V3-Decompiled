package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.sW */
/* loaded from: classes.dex */
public final class C4555sW extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4555sW> f16515CREATOR = new C4622tW();

    /* renamed from: AZxh */
    public final int f16516AZxh;

    /* renamed from: KLFTb */
    public final long f16517KLFTb;

    /* renamed from: ZfxDd */
    public final int f16518ZfxDd;

    /* renamed from: mjFkc */
    public final int f16519mjFkc;

    /* renamed from: wA */
    public final int f16520wA;

    public C4555sW(int i, int i2, int i3, int i4, long j) {
        this.f16519mjFkc = i;
        this.f16516AZxh = i2;
        this.f16520wA = i3;
        this.f16518ZfxDd = i4;
        this.f16517KLFTb = j;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f16519mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, i2);
        AbstractC3997k6.m12484xJ(parcel, 2, this.f16516AZxh);
        AbstractC3997k6.m12484xJ(parcel, 3, this.f16520wA);
        AbstractC3997k6.m12484xJ(parcel, 4, this.f16518ZfxDd);
        AbstractC3997k6.m12481qdMbNW(parcel, 5, this.f16517KLFTb);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
