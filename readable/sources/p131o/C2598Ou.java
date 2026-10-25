package p131o;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.Ou */
/* loaded from: classes.dex */
public final class C2598Ou extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2598Ou> f10009CREATOR = new C2660Pu();

    /* renamed from: AZxh */
    public final Rect f10010AZxh;

    /* renamed from: KLFTb */
    public final List f10011KLFTb;

    /* renamed from: ZfxDd */
    public final String f10012ZfxDd;

    /* renamed from: mjFkc */
    public final String f10013mjFkc;

    /* renamed from: wA */
    public final List f10014wA;

    public C2598Ou(String str, Rect rect, List list, String str2, List list2) {
        this.f10013mjFkc = str;
        this.f10010AZxh = rect;
        this.f10014wA = list;
        this.f10012ZfxDd = str2;
        this.f10011KLFTb = list2;
    }

    /* renamed from: mjFkc */
    public final String m9916mjFkc() {
        return this.f10013mjFkc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f10013mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f10010AZxh, i, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 3, this.f10014wA, false);
        AbstractC3997k6.m12469ETF(parcel, 4, this.f10012ZfxDd, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 5, this.f10011KLFTb, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
