package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.LW */
/* loaded from: classes.dex */
public final class C2376LW extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2376LW> f9451CREATOR = new C2444MW();

    /* renamed from: AZxh */
    public final String f9452AZxh;

    /* renamed from: JHa */
    public final String f9453JHa;

    /* renamed from: KLFTb */
    public final int f9454KLFTb;

    /* renamed from: ZfxDd */
    public final boolean f9455ZfxDd;

    /* renamed from: mjFkc */
    public final String f9456mjFkc;

    /* renamed from: wA */
    public final String f9457wA;

    /* renamed from: xJ */
    public final boolean f9458xJ;

    public C2376LW(String str, String str2, String str3, boolean z, int i, String str4, boolean z2) {
        this.f9456mjFkc = str;
        this.f9452AZxh = str2;
        this.f9457wA = str3;
        this.f9453JHa = str4;
        this.f9454KLFTb = i;
        this.f9455ZfxDd = z;
        this.f9458xJ = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f9456mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12469ETF(parcel, 2, this.f9452AZxh, false);
        AbstractC3997k6.m12469ETF(parcel, 3, this.f9457wA, false);
        AbstractC3997k6.m12483wA(parcel, 4, this.f9455ZfxDd);
        AbstractC3997k6.m12484xJ(parcel, 5, this.f9454KLFTb);
        AbstractC3997k6.m12469ETF(parcel, 6, this.f9453JHa, false);
        AbstractC3997k6.m12483wA(parcel, 7, this.f9458xJ);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
