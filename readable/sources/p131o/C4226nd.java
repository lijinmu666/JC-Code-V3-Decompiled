package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.nd */
/* loaded from: classes.dex */
public final class C4226nd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        C3613eEOGOh c3613eEOGOh = null;
        int iM12373YoKzxo = 0;
        C2320Kd c2320Kd = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 2) {
                c3613eEOGOh = (C3613eEOGOh) AbstractC3926j6.m12381wA(parcel, iM12372VA, C3613eEOGOh.f13446CREATOR);
            } else if (iM12379qdMbNW != 3) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                c2320Kd = (C2320Kd) AbstractC3926j6.m12381wA(parcel, iM12372VA, C2320Kd.f9207CREATOR);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C4161md(iM12373YoKzxo, c3613eEOGOh, c2320Kd);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4161md[i];
    }
}
