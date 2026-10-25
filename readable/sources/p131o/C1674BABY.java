package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.BABY */
/* loaded from: classes.dex */
public class C1674BABY extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C1674BABY> f7452CREATOR = new C3094WP();

    /* renamed from: AZxh */
    public final boolean f7453AZxh;

    /* renamed from: JHa */
    public final int[] f7454JHa;

    /* renamed from: KLFTb */
    public final int f7455KLFTb;

    /* renamed from: ZfxDd */
    public final int[] f7456ZfxDd;

    /* renamed from: mjFkc */
    public final C1866E5 f7457mjFkc;

    /* renamed from: wA */
    public final boolean f7458wA;

    public C1674BABY(C1866E5 c1866e5, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.f7457mjFkc = c1866e5;
        this.f7453AZxh = z;
        this.f7458wA = z2;
        this.f7456ZfxDd = iArr;
        this.f7455KLFTb = i;
        this.f7454JHa = iArr2;
    }

    /* renamed from: AZxh */
    public int[] m7680AZxh() {
        return this.f7456ZfxDd;
    }

    /* renamed from: JHa */
    public boolean m7681JHa() {
        return this.f7458wA;
    }

    /* renamed from: ZfxDd */
    public boolean m7682ZfxDd() {
        return this.f7453AZxh;
    }

    /* renamed from: mjFkc */
    public int m7683mjFkc() {
        return this.f7455KLFTb;
    }

    /* renamed from: wA */
    public int[] m7684wA() {
        return this.f7454JHa;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12468Dt(parcel, 1, this.f7457mjFkc, i, false);
        AbstractC3997k6.m12483wA(parcel, 2, m7682ZfxDd());
        AbstractC3997k6.m12483wA(parcel, 3, m7681JHa());
        AbstractC3997k6.m12478lgHUyS(parcel, 4, m7680AZxh(), false);
        AbstractC3997k6.m12484xJ(parcel, 5, m7683mjFkc());
        AbstractC3997k6.m12478lgHUyS(parcel, 6, m7684wA(), false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    /* renamed from: xJ */
    public final C1866E5 m7685xJ() {
        return this.f7457mjFkc;
    }
}
