package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.ld */
/* loaded from: classes.dex */
public final class C4095ld implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        C1972Fd c1972Fd = null;
        int iM12373YoKzxo = 0;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 2) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                c1972Fd = (C1972Fd) AbstractC3926j6.m12381wA(parcel, iM12372VA, C1972Fd.f8231CREATOR);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C3961jd(iM12373YoKzxo, c1972Fd);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C3961jd[i];
    }
}
