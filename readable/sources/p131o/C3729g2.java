package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.g2 */
/* loaded from: classes.dex */
public class C3729g2 extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C3729g2> f13668CREATOR = new C4492rd();

    /* renamed from: AZxh */
    public final int f13669AZxh;

    /* renamed from: JHa */
    public final String f13670JHa;

    /* renamed from: KLFTb */
    public final long f13671KLFTb;

    /* renamed from: ZfxDd */
    public final long f13672ZfxDd;

    /* renamed from: lgHUyS */
    public final int f13673lgHUyS;

    /* renamed from: mjFkc */
    public final int f13674mjFkc;

    /* renamed from: qdMbNW */
    public final int f13675qdMbNW;

    /* renamed from: wA */
    public final int f13676wA;

    /* renamed from: xJ */
    public final String f13677xJ;

    public C3729g2(int i, int i2, int i3, long j, long j2, String str, String str2, int i4, int i5) {
        this.f13674mjFkc = i;
        this.f13669AZxh = i2;
        this.f13676wA = i3;
        this.f13672ZfxDd = j;
        this.f13671KLFTb = j2;
        this.f13670JHa = str;
        this.f13677xJ = str2;
        this.f13673lgHUyS = i4;
        this.f13675qdMbNW = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f13674mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, i2);
        AbstractC3997k6.m12484xJ(parcel, 2, this.f13669AZxh);
        AbstractC3997k6.m12484xJ(parcel, 3, this.f13676wA);
        AbstractC3997k6.m12481qdMbNW(parcel, 4, this.f13672ZfxDd);
        AbstractC3997k6.m12481qdMbNW(parcel, 5, this.f13671KLFTb);
        AbstractC3997k6.m12469ETF(parcel, 6, this.f13670JHa, false);
        AbstractC3997k6.m12469ETF(parcel, 7, this.f13677xJ, false);
        AbstractC3997k6.m12484xJ(parcel, 8, this.f13673lgHUyS);
        AbstractC3997k6.m12484xJ(parcel, 9, this.f13675qdMbNW);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
