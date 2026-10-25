package p131o;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.yW */
/* loaded from: classes.dex */
public final class C4954yW extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4954yW> f17522CREATOR = new C1896EW();

    /* renamed from: AZxh */
    public final Rect f17523AZxh;

    /* renamed from: KLFTb */
    public final List f17524KLFTb;

    /* renamed from: ZfxDd */
    public final String f17525ZfxDd;

    /* renamed from: mjFkc */
    public final String f17526mjFkc;

    /* renamed from: wA */
    public final List f17527wA;

    public C4954yW(String str, Rect rect, List list, String str2, List list2) {
        this.f17526mjFkc = str;
        this.f17523AZxh = rect;
        this.f17527wA = list;
        this.f17525ZfxDd = str2;
        this.f17524KLFTb = list2;
    }

    /* renamed from: AZxh */
    public final String m14008AZxh() {
        return this.f17525ZfxDd;
    }

    /* renamed from: JHa */
    public final List m14009JHa() {
        return this.f17524KLFTb;
    }

    /* renamed from: ZfxDd */
    public final List m14010ZfxDd() {
        return this.f17527wA;
    }

    /* renamed from: mjFkc */
    public final Rect m14011mjFkc() {
        return this.f17523AZxh;
    }

    /* renamed from: wA */
    public final String m14012wA() {
        return this.f17526mjFkc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f17526mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f17523AZxh, i, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 3, this.f17527wA, false);
        AbstractC3997k6.m12469ETF(parcel, 4, this.f17525ZfxDd, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 5, this.f17524KLFTb, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
