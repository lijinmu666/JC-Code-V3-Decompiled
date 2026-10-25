package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.QH */
/* loaded from: classes.dex */
public final class C2685QH extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2685QH> f10164CREATOR = new C3287ZI();

    /* renamed from: AZxh */
    public final int f10165AZxh;

    /* renamed from: KLFTb */
    public final float f10166KLFTb;

    /* renamed from: ZfxDd */
    public final int f10167ZfxDd;

    /* renamed from: mjFkc */
    public final int f10168mjFkc;

    /* renamed from: wA */
    public final int f10169wA;

    public C2685QH(int i, int i2, int i3, int i4, float f) {
        this.f10168mjFkc = i;
        this.f10165AZxh = i2;
        this.f10169wA = i3;
        this.f10167ZfxDd = i4;
        this.f10166KLFTb = f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f10168mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 2, i2);
        AbstractC3997k6.m12484xJ(parcel, 3, this.f10165AZxh);
        AbstractC3997k6.m12484xJ(parcel, 4, this.f10169wA);
        AbstractC3997k6.m12484xJ(parcel, 5, this.f10167ZfxDd);
        AbstractC3997k6.m12472KLFTb(parcel, 6, this.f10166KLFTb);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
