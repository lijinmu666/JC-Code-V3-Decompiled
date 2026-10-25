package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.Pr */
/* loaded from: classes.dex */
public final class C2657Pr extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2657Pr> f10108CREATOR = new C4644ts();

    /* renamed from: AZxh */
    public final C4237nn f10109AZxh;

    /* renamed from: JHa */
    public final String f10110JHa;

    /* renamed from: KLFTb */
    public final float f10111KLFTb;

    /* renamed from: ZfxDd */
    public final String f10112ZfxDd;

    /* renamed from: mjFkc */
    public final C2190Iq[] f10113mjFkc;

    /* renamed from: wA */
    public final C4237nn f10114wA;

    /* renamed from: xJ */
    public final boolean f10115xJ;

    public C2657Pr(C2190Iq[] c2190IqArr, C4237nn c4237nn, C4237nn c4237nn2, String str, float f, String str2, boolean z) {
        this.f10113mjFkc = c2190IqArr;
        this.f10109AZxh = c4237nn;
        this.f10114wA = c4237nn2;
        this.f10112ZfxDd = str;
        this.f10111KLFTb = f;
        this.f10110JHa = str2;
        this.f10115xJ = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        C2190Iq[] c2190IqArr = this.f10113mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12473MiMN(parcel, 2, c2190IqArr, i, false);
        AbstractC3997k6.m12468Dt(parcel, 3, this.f10109AZxh, i, false);
        AbstractC3997k6.m12468Dt(parcel, 4, this.f10114wA, i, false);
        AbstractC3997k6.m12469ETF(parcel, 5, this.f10112ZfxDd, false);
        AbstractC3997k6.m12472KLFTb(parcel, 6, this.f10111KLFTb);
        AbstractC3997k6.m12469ETF(parcel, 7, this.f10110JHa, false);
        AbstractC3997k6.m12483wA(parcel, 8, this.f10115xJ);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
