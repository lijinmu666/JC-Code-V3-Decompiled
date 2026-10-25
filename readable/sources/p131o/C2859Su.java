package p131o;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.Su */
/* loaded from: classes.dex */
public final class C2859Su extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2859Su> f10605CREATOR = new C2921Tu();

    /* renamed from: AZxh */
    public final Rect f10606AZxh;

    /* renamed from: JHa */
    public final float f10607JHa;

    /* renamed from: KLFTb */
    public final List f10608KLFTb;

    /* renamed from: ZfxDd */
    public final String f10609ZfxDd;

    /* renamed from: mjFkc */
    public final String f10610mjFkc;

    /* renamed from: wA */
    public final List f10611wA;

    /* renamed from: xJ */
    public final float f10612xJ;

    public C2859Su(String str, Rect rect, List list, String str2, List list2, float f, float f2) {
        this.f10610mjFkc = str;
        this.f10606AZxh = rect;
        this.f10611wA = list;
        this.f10609ZfxDd = str2;
        this.f10608KLFTb = list2;
        this.f10607JHa = f;
        this.f10612xJ = f2;
    }

    /* renamed from: AZxh */
    public final String m10197AZxh() {
        return this.f10609ZfxDd;
    }

    /* renamed from: ZfxDd */
    public final List m10198ZfxDd() {
        return this.f10611wA;
    }

    /* renamed from: mjFkc */
    public final Rect m10199mjFkc() {
        return this.f10606AZxh;
    }

    /* renamed from: wA */
    public final String m10200wA() {
        return this.f10610mjFkc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f10610mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f10606AZxh, i, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 3, this.f10611wA, false);
        AbstractC3997k6.m12469ETF(parcel, 4, this.f10609ZfxDd, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 5, this.f10608KLFTb, false);
        AbstractC3997k6.m12472KLFTb(parcel, 6, this.f10607JHa);
        AbstractC3997k6.m12472KLFTb(parcel, 7, this.f10612xJ);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
