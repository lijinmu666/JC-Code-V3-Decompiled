package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* renamed from: o.Uu */
/* loaded from: classes.dex */
public final class C2994Uu extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2994Uu> f10924CREATOR = new C3124Wu();

    /* renamed from: AZxh */
    public final List f10925AZxh;

    /* renamed from: mjFkc */
    public final String f10926mjFkc;

    public C2994Uu(String str, List list) {
        this.f10926mjFkc = str;
        this.f10925AZxh = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f10926mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, str, false);
        AbstractC3997k6.m12475YoKzxo(parcel, 2, this.f10925AZxh, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
