package p131o;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.NW */
/* loaded from: classes.dex */
public final class C2513NW extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2513NW> f9761CREATOR = new C2575OW();

    /* renamed from: AZxh */
    public final Rect f9762AZxh;

    /* renamed from: KLFTb */
    public final float f9763KLFTb;

    /* renamed from: ZfxDd */
    public final float f9764ZfxDd;

    /* renamed from: mjFkc */
    public final String f9765mjFkc;

    /* renamed from: wA */
    public final List f9766wA;

    public C2513NW(String str, Rect rect, List list, float f, float f2) {
        this.f9765mjFkc = str;
        this.f9762AZxh = rect;
        this.f9766wA = list;
        this.f9764ZfxDd = f;
        this.f9763KLFTb = f2;
    }

    /* renamed from: AZxh */
    public final float m9686AZxh() {
        return this.f9764ZfxDd;
    }

    /* renamed from: JHa */
    public final List m9687JHa() {
        return this.f9766wA;
    }

    /* renamed from: ZfxDd */
    public final String m9688ZfxDd() {
        return this.f9765mjFkc;
    }

    /* renamed from: mjFkc */
    public final float m9689mjFkc() {
        return this.f9763KLFTb;
    }

    /* renamed from: wA */
    public final Rect m9690wA() {
        return this.f9762AZxh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f9765mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f9762AZxh, i, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 3, this.f9766wA, false);
        AbstractC3997k6.m12472KLFTb(parcel, 4, this.f9764ZfxDd);
        AbstractC3997k6.m12472KLFTb(parcel, 5, this.f9763KLFTb);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
