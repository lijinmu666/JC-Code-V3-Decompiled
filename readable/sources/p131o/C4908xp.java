package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.xp */
/* loaded from: classes.dex */
public final class C4908xp extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4908xp> f17428CREATOR = new C3650eq();

    /* renamed from: AZxh */
    public final C4237nn f17429AZxh;

    /* renamed from: Dt */
    public final int f17430Dt;

    /* renamed from: ETF */
    public final int f17431ETF;

    /* renamed from: JHa */
    public final float f17432JHa;

    /* renamed from: KLFTb */
    public final String f17433KLFTb;

    /* renamed from: ZfxDd */
    public final C4237nn f17434ZfxDd;

    /* renamed from: lgHUyS */
    public final int f17435lgHUyS;

    /* renamed from: mjFkc */
    public final C2657Pr[] f17436mjFkc;

    /* renamed from: qdMbNW */
    public final boolean f17437qdMbNW;

    /* renamed from: wA */
    public final C4237nn f17438wA;

    /* renamed from: xJ */
    public final String f17439xJ;

    public C4908xp(C2657Pr[] c2657PrArr, C4237nn c4237nn, C4237nn c4237nn2, C4237nn c4237nn3, String str, float f, String str2, int i, boolean z, int i2, int i3) {
        this.f17436mjFkc = c2657PrArr;
        this.f17429AZxh = c4237nn;
        this.f17438wA = c4237nn2;
        this.f17434ZfxDd = c4237nn3;
        this.f17433KLFTb = str;
        this.f17432JHa = f;
        this.f17439xJ = str2;
        this.f17435lgHUyS = i;
        this.f17437qdMbNW = z;
        this.f17430Dt = i2;
        this.f17431ETF = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        C2657Pr[] c2657PrArr = this.f17436mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12473MiMN(parcel, 2, c2657PrArr, i, false);
        AbstractC3997k6.m12468Dt(parcel, 3, this.f17429AZxh, i, false);
        AbstractC3997k6.m12468Dt(parcel, 4, this.f17438wA, i, false);
        AbstractC3997k6.m12468Dt(parcel, 5, this.f17434ZfxDd, i, false);
        AbstractC3997k6.m12469ETF(parcel, 6, this.f17433KLFTb, false);
        AbstractC3997k6.m12472KLFTb(parcel, 7, this.f17432JHa);
        AbstractC3997k6.m12469ETF(parcel, 8, this.f17439xJ, false);
        AbstractC3997k6.m12484xJ(parcel, 9, this.f17435lgHUyS);
        AbstractC3997k6.m12483wA(parcel, 10, this.f17437qdMbNW);
        AbstractC3997k6.m12484xJ(parcel, 11, this.f17430Dt);
        AbstractC3997k6.m12484xJ(parcel, 12, this.f17431ETF);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
