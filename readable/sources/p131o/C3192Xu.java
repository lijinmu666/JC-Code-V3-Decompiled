package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.Xu */
/* loaded from: classes.dex */
public final class C3192Xu extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C3192Xu> f11714CREATOR = new C3259Yu();

    /* renamed from: AZxh */
    public final String f11715AZxh;

    /* renamed from: JHa */
    public final String f11716JHa;

    /* renamed from: KLFTb */
    public final int f11717KLFTb;

    /* renamed from: ZfxDd */
    public final boolean f11718ZfxDd;

    /* renamed from: mjFkc */
    public final String f11719mjFkc;

    /* renamed from: wA */
    public final String f11720wA;

    /* renamed from: xJ */
    public final boolean f11721xJ;

    public C3192Xu(String str, String str2, String str3, boolean z, int i, String str4, boolean z2) {
        this.f11719mjFkc = str;
        this.f11715AZxh = str2;
        this.f11720wA = str3;
        this.f11716JHa = str4;
        this.f11717KLFTb = i;
        this.f11718ZfxDd = z;
        this.f11721xJ = z2;
    }

    /* renamed from: AZxh */
    public final String m10993AZxh() {
        return this.f11716JHa;
    }

    /* renamed from: ZfxDd */
    public final boolean m10994ZfxDd() {
        return this.f11721xJ;
    }

    /* renamed from: mjFkc */
    public final String m10995mjFkc() {
        return this.f11719mjFkc;
    }

    /* renamed from: wA */
    public final String m10996wA() {
        return this.f11720wA;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f11719mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12469ETF(parcel, 2, this.f11715AZxh, false);
        AbstractC3997k6.m12469ETF(parcel, 3, this.f11720wA, false);
        AbstractC3997k6.m12483wA(parcel, 4, this.f11718ZfxDd);
        AbstractC3997k6.m12484xJ(parcel, 5, this.f11717KLFTb);
        AbstractC3997k6.m12469ETF(parcel, 6, this.f11716JHa, false);
        AbstractC3997k6.m12483wA(parcel, 7, this.f11721xJ);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
