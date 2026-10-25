package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.uS */
/* loaded from: classes.dex */
public final class C4684uS extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4684uS> f16855CREATOR = new C3366aT();

    /* renamed from: mjFkc */
    public final String f16856mjFkc;

    public C4684uS(String str) {
        this.f16856mjFkc = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f16856mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 2, str, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
