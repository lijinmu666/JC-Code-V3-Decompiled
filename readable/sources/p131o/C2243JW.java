package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.JW */
/* loaded from: classes.dex */
public final class C2243JW extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2243JW> f8985CREATOR = new C2314KW();

    /* renamed from: AZxh */
    public final List f8986AZxh;

    /* renamed from: mjFkc */
    public final String f8987mjFkc;

    public C2243JW(String str, List list) {
        this.f8987mjFkc = str;
        this.f8986AZxh = list;
    }

    /* renamed from: AZxh */
    public final List m8982AZxh() {
        return this.f8986AZxh;
    }

    /* renamed from: mjFkc */
    public final String m8983mjFkc() {
        return this.f8987mjFkc;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f8987mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 2, this.f8986AZxh, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
