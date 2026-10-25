package p131o;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.FW */
/* loaded from: classes.dex */
public final class C1967FW extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C1967FW> f8209CREATOR = new C2037GW();

    /* renamed from: AZxh */
    public final Rect f8210AZxh;

    /* renamed from: JHa */
    public final float f8211JHa;

    /* renamed from: KLFTb */
    public final float f8212KLFTb;

    /* renamed from: ZfxDd */
    public final String f8213ZfxDd;

    /* renamed from: mjFkc */
    public final String f8214mjFkc;

    /* renamed from: wA */
    public final List f8215wA;

    /* renamed from: xJ */
    public final List f8216xJ;

    public C1967FW(String str, Rect rect, List list, String str2, float f, float f2, List list2) {
        this.f8214mjFkc = str;
        this.f8210AZxh = rect;
        this.f8215wA = list;
        this.f8213ZfxDd = str2;
        this.f8212KLFTb = f;
        this.f8211JHa = f2;
        this.f8216xJ = list2;
    }

    /* renamed from: AZxh */
    public final float m8306AZxh() {
        return this.f8212KLFTb;
    }

    /* renamed from: JHa */
    public final String m8307JHa() {
        return this.f8214mjFkc;
    }

    /* renamed from: ZfxDd */
    public final String m8308ZfxDd() {
        return this.f8213ZfxDd;
    }

    /* renamed from: lgHUyS */
    public final List m8309lgHUyS() {
        return this.f8216xJ;
    }

    /* renamed from: mjFkc */
    public final float m8310mjFkc() {
        return this.f8211JHa;
    }

    /* renamed from: wA */
    public final Rect m8311wA() {
        return this.f8210AZxh;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f8214mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f8210AZxh, i, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 3, this.f8215wA, false);
        AbstractC3997k6.m12469ETF(parcel, 4, this.f8213ZfxDd, false);
        AbstractC3997k6.m12472KLFTb(parcel, 5, this.f8212KLFTb);
        AbstractC3997k6.m12472KLFTb(parcel, 6, this.f8211JHa);
        AbstractC3997k6.m12475YoKzxo(parcel, 7, this.f8216xJ, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    /* renamed from: xJ */
    public final List m8312xJ() {
        return this.f8215wA;
    }
}
