package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.PO */
/* loaded from: classes.dex */
public final class C2630PO extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2630PO> f10073CREATOR = new C3295ZP();

    /* renamed from: AZxh */
    public final C2685QH f10074AZxh;

    /* renamed from: Dt */
    public final int f10075Dt;

    /* renamed from: ETF */
    public final int f10076ETF;

    /* renamed from: JHa */
    public final float f10077JHa;

    /* renamed from: KLFTb */
    public final String f10078KLFTb;

    /* renamed from: ZfxDd */
    public final C2685QH f10079ZfxDd;

    /* renamed from: lgHUyS */
    public final int f10080lgHUyS;

    /* renamed from: mjFkc */
    public final C2034GT[] f10081mjFkc;

    /* renamed from: qdMbNW */
    public final boolean f10082qdMbNW;

    /* renamed from: wA */
    public final C2685QH f10083wA;

    /* renamed from: xJ */
    public final String f10084xJ;

    public C2630PO(C2034GT[] c2034gtArr, C2685QH c2685qh, C2685QH c2685qh2, C2685QH c2685qh3, String str, float f, String str2, int i, boolean z, int i2, int i3) {
        this.f10081mjFkc = c2034gtArr;
        this.f10074AZxh = c2685qh;
        this.f10083wA = c2685qh2;
        this.f10079ZfxDd = c2685qh3;
        this.f10078KLFTb = str;
        this.f10077JHa = f;
        this.f10084xJ = str2;
        this.f10080lgHUyS = i;
        this.f10082qdMbNW = z;
        this.f10075Dt = i2;
        this.f10076ETF = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        C2034GT[] c2034gtArr = this.f10081mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12473MiMN(parcel, 2, c2034gtArr, i, false);
        AbstractC3997k6.m12468Dt(parcel, 3, this.f10074AZxh, i, false);
        AbstractC3997k6.m12468Dt(parcel, 4, this.f10083wA, i, false);
        AbstractC3997k6.m12468Dt(parcel, 5, this.f10079ZfxDd, i, false);
        AbstractC3997k6.m12469ETF(parcel, 6, this.f10078KLFTb, false);
        AbstractC3997k6.m12472KLFTb(parcel, 7, this.f10077JHa);
        AbstractC3997k6.m12469ETF(parcel, 8, this.f10084xJ, false);
        AbstractC3997k6.m12484xJ(parcel, 9, this.f10080lgHUyS);
        AbstractC3997k6.m12483wA(parcel, 10, this.f10082qdMbNW);
        AbstractC3997k6.m12484xJ(parcel, 11, this.f10075Dt);
        AbstractC3997k6.m12484xJ(parcel, 12, this.f10076ETF);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
