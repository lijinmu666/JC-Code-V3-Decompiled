package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.NR */
/* loaded from: classes.dex */
public final class C2508NR implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            AbstractC3926j6.m12379qdMbNW(iM12372VA);
            AbstractC3926j6.m12375fehf(parcel, iM12372VA);
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C3823hR();
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C3823hR[i];
    }
}
