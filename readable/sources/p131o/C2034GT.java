package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.GT */
/* loaded from: classes.dex */
public final class C2034GT extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2034GT> f8358CREATOR = new C4553sU();

    /* renamed from: AZxh */
    public final C2685QH f8359AZxh;

    /* renamed from: JHa */
    public final String f8360JHa;

    /* renamed from: KLFTb */
    public final float f8361KLFTb;

    /* renamed from: ZfxDd */
    public final String f8362ZfxDd;

    /* renamed from: mjFkc */
    public final C3823hR[] f8363mjFkc;

    /* renamed from: wA */
    public final C2685QH f8364wA;

    /* renamed from: xJ */
    public final boolean f8365xJ;

    public C2034GT(C3823hR[] c3823hRArr, C2685QH c2685qh, C2685QH c2685qh2, String str, float f, String str2, boolean z) {
        this.f8363mjFkc = c3823hRArr;
        this.f8359AZxh = c2685qh;
        this.f8364wA = c2685qh2;
        this.f8362ZfxDd = str;
        this.f8361KLFTb = f;
        this.f8360JHa = str2;
        this.f8365xJ = z;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        C3823hR[] c3823hRArr = this.f8363mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12473MiMN(parcel, 2, c3823hRArr, i, false);
        AbstractC3997k6.m12468Dt(parcel, 3, this.f8359AZxh, i, false);
        AbstractC3997k6.m12468Dt(parcel, 4, this.f8364wA, i, false);
        AbstractC3997k6.m12469ETF(parcel, 5, this.f8362ZfxDd, false);
        AbstractC3997k6.m12472KLFTb(parcel, 6, this.f8361KLFTb);
        AbstractC3997k6.m12469ETF(parcel, 7, this.f8360JHa, false);
        AbstractC3997k6.m12483wA(parcel, 8, this.f8365xJ);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
