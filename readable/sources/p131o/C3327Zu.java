package p131o;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.Zu */
/* loaded from: classes.dex */
public final class C3327Zu extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C3327Zu> f12236CREATOR = new C3394av();

    /* renamed from: AZxh */
    public final Rect f12237AZxh;

    /* renamed from: KLFTb */
    public final float f12238KLFTb;

    /* renamed from: ZfxDd */
    public final float f12239ZfxDd;

    /* renamed from: mjFkc */
    public final String f12240mjFkc;

    /* renamed from: wA */
    public final List f12241wA;

    public C3327Zu(String str, Rect rect, List list, float f, float f2) {
        this.f12240mjFkc = str;
        this.f12237AZxh = rect;
        this.f12241wA = list;
        this.f12239ZfxDd = f;
        this.f12238KLFTb = f2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f12240mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f12237AZxh, i, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 3, this.f12241wA, false);
        AbstractC3997k6.m12472KLFTb(parcel, 4, this.f12239ZfxDd);
        AbstractC3997k6.m12472KLFTb(parcel, 5, this.f12238KLFTb);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
