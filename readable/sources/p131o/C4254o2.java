package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.o2 */
/* loaded from: classes.dex */
public class C4254o2 extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4254o2> f15493CREATOR = new C2316Kb();

    /* renamed from: AZxh */
    public final int f15494AZxh;

    /* renamed from: mjFkc */
    public final boolean f15495mjFkc;

    public C4254o2(boolean z, int i) {
        this.f15495mjFkc = z;
        this.f15494AZxh = i;
    }

    /* renamed from: AZxh */
    public int m12927AZxh() {
        return this.f15494AZxh;
    }

    /* renamed from: mjFkc */
    public boolean m12928mjFkc() {
        return this.f15495mjFkc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12483wA(parcel, 1, m12928mjFkc());
        AbstractC3997k6.m12484xJ(parcel, 2, m12927AZxh());
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
