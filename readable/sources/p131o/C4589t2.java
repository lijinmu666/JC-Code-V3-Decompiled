package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.t2 */
/* loaded from: classes.dex */
public class C4589t2 extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4589t2> f16599CREATOR = new C2379Lc();

    /* renamed from: AZxh */
    public final boolean f16600AZxh;

    /* renamed from: mjFkc */
    public final int f16601mjFkc;

    public C4589t2(int i) {
        this(i, false);
    }

    /* renamed from: mjFkc */
    public int m13573mjFkc() {
        return this.f16601mjFkc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, m13573mjFkc());
        AbstractC3997k6.m12483wA(parcel, 2, this.f16600AZxh);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    public C4589t2(int i, boolean z) {
        this.f16601mjFkc = i;
        this.f16600AZxh = z;
    }
}
