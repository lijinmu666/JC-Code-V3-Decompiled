package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.Eu */
/* loaded from: classes.dex */
public final class C1923Eu extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C1923Eu> f8093CREATOR = new C1995Fu();

    /* renamed from: AZxh */
    public final int f8094AZxh;

    /* renamed from: KLFTb */
    public final long f8095KLFTb;

    /* renamed from: ZfxDd */
    public final int f8096ZfxDd;

    /* renamed from: mjFkc */
    public final int f8097mjFkc;

    /* renamed from: wA */
    public final int f8098wA;

    public C1923Eu(int i, int i2, int i3, int i4, long j) {
        this.f8097mjFkc = i;
        this.f8094AZxh = i2;
        this.f8098wA = i3;
        this.f8096ZfxDd = i4;
        this.f8095KLFTb = j;
    }

    /* renamed from: AZxh */
    public final int m8228AZxh() {
        return this.f8097mjFkc;
    }

    /* renamed from: JHa */
    public final long m8229JHa() {
        return this.f8095KLFTb;
    }

    /* renamed from: ZfxDd */
    public final int m8230ZfxDd() {
        return this.f8094AZxh;
    }

    /* renamed from: mjFkc */
    public final int m8231mjFkc() {
        return this.f8098wA;
    }

    /* renamed from: wA */
    public final int m8232wA() {
        return this.f8096ZfxDd;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, this.f8097mjFkc);
        AbstractC3997k6.m12484xJ(parcel, 2, this.f8094AZxh);
        AbstractC3997k6.m12484xJ(parcel, 3, this.f8098wA);
        AbstractC3997k6.m12484xJ(parcel, 4, this.f8096ZfxDd);
        AbstractC3997k6.m12481qdMbNW(parcel, 5, this.f8095KLFTb);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
