package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.E5 */
/* loaded from: classes.dex */
public class C1866E5 extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C1866E5> f7957CREATOR = new C3871iC();

    /* renamed from: AZxh */
    public final boolean f7958AZxh;

    /* renamed from: KLFTb */
    public final int f7959KLFTb;

    /* renamed from: ZfxDd */
    public final int f7960ZfxDd;

    /* renamed from: mjFkc */
    public final int f7961mjFkc;

    /* renamed from: wA */
    public final boolean f7962wA;

    public C1866E5(int i, boolean z, boolean z2, int i2, int i3) {
        this.f7961mjFkc = i;
        this.f7958AZxh = z;
        this.f7962wA = z2;
        this.f7960ZfxDd = i2;
        this.f7959KLFTb = i3;
    }

    /* renamed from: AZxh */
    public int m8102AZxh() {
        return this.f7959KLFTb;
    }

    /* renamed from: JHa */
    public int m8103JHa() {
        return this.f7961mjFkc;
    }

    /* renamed from: ZfxDd */
    public boolean m8104ZfxDd() {
        return this.f7962wA;
    }

    /* renamed from: mjFkc */
    public int m8105mjFkc() {
        return this.f7960ZfxDd;
    }

    /* renamed from: wA */
    public boolean m8106wA() {
        return this.f7958AZxh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, m8103JHa());
        AbstractC3997k6.m12483wA(parcel, 2, m8106wA());
        AbstractC3997k6.m12483wA(parcel, 3, m8104ZfxDd());
        AbstractC3997k6.m12484xJ(parcel, 4, m8105mjFkc());
        AbstractC3997k6.m12484xJ(parcel, 5, m8102AZxh());
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
