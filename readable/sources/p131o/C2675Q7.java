package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: o.Q7 */
/* loaded from: classes.dex */
public class C2675Q7 extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2675Q7> f10150CREATOR = new C2704Qb();

    /* renamed from: AZxh */
    public List f10151AZxh;

    /* renamed from: mjFkc */
    public final int f10152mjFkc;

    public C2675Q7(int i, List list) {
        this.f10152mjFkc = i;
        this.f10151AZxh = list;
    }

    /* renamed from: AZxh */
    public final List m9998AZxh() {
        return this.f10151AZxh;
    }

    /* renamed from: mjFkc */
    public final int m9999mjFkc() {
        return this.f10152mjFkc;
    }

    /* renamed from: wA */
    public final void m10000wA(C3729g2 c3729g2) {
        if (this.f10151AZxh == null) {
            this.f10151AZxh = new ArrayList();
        }
        this.f10151AZxh.add(c3729g2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, this.f10152mjFkc);
        AbstractC3997k6.m12475YoKzxo(parcel, 2, this.f10151AZxh, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
