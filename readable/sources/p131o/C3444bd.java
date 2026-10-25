package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.bd */
/* loaded from: classes.dex */
public final class C3444bd extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C3444bd> f13124CREATOR = new C3702fd();

    /* renamed from: AZxh */
    public final String f13125AZxh;

    /* renamed from: mjFkc */
    public final List f13126mjFkc;

    public C3444bd(List list, String str) {
        this.f13126mjFkc = list;
        this.f13125AZxh = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        List list = this.f13126mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12474VA(parcel, 1, list, false);
        AbstractC3997k6.m12469ETF(parcel, 2, this.f13125AZxh, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
