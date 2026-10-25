package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.CF */
/* loaded from: classes.dex */
public final class C1747CF extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C1747CF> f7600CREATOR = new C2222JG();

    /* renamed from: AZxh */
    public int f7601AZxh;

    /* renamed from: KLFTb */
    public int f7602KLFTb;

    /* renamed from: ZfxDd */
    public long f7603ZfxDd;

    /* renamed from: mjFkc */
    public int f7604mjFkc;

    /* renamed from: wA */
    public int f7605wA;

    public C1747CF(int i, int i2, int i3, long j, int i4) {
        this.f7604mjFkc = i;
        this.f7601AZxh = i2;
        this.f7605wA = i3;
        this.f7603ZfxDd = j;
        this.f7602KLFTb = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 2, this.f7604mjFkc);
        AbstractC3997k6.m12484xJ(parcel, 3, this.f7601AZxh);
        AbstractC3997k6.m12484xJ(parcel, 4, this.f7605wA);
        AbstractC3997k6.m12481qdMbNW(parcel, 5, this.f7603ZfxDd);
        AbstractC3997k6.m12484xJ(parcel, 6, this.f7602KLFTb);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
