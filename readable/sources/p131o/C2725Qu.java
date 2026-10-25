package p131o;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.Qu */
/* loaded from: classes.dex */
public final class C2725Qu extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2725Qu> f10291CREATOR = new C2792Ru();

    /* renamed from: AZxh */
    public final Rect f10292AZxh;

    /* renamed from: JHa */
    public final float f10293JHa;

    /* renamed from: KLFTb */
    public final float f10294KLFTb;

    /* renamed from: ZfxDd */
    public final String f10295ZfxDd;

    /* renamed from: mjFkc */
    public final String f10296mjFkc;

    /* renamed from: wA */
    public final List f10297wA;

    /* renamed from: xJ */
    public final List f10298xJ;

    public C2725Qu(String str, Rect rect, List list, String str2, float f, float f2, List list2) {
        this.f10296mjFkc = str;
        this.f10292AZxh = rect;
        this.f10297wA = list;
        this.f10295ZfxDd = str2;
        this.f10294KLFTb = f;
        this.f10293JHa = f2;
        this.f10298xJ = list2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f10296mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f10292AZxh, i, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 3, this.f10297wA, false);
        AbstractC3997k6.m12469ETF(parcel, 4, this.f10295ZfxDd, false);
        AbstractC3997k6.m12472KLFTb(parcel, 5, this.f10294KLFTb);
        AbstractC3997k6.m12472KLFTb(parcel, 6, this.f10293JHa);
        AbstractC3997k6.m12475YoKzxo(parcel, 7, this.f10298xJ, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
