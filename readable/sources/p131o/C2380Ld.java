package p131o;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.Ld */
/* loaded from: classes.dex */
public final class C2380Ld implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        int iM12373YoKzxo = 0;
        boolean zM12365Dt = false;
        boolean zM12365Dt2 = false;
        IBinder iBinderM12370MiMN = null;
        C3613eEOGOh c3613eEOGOh = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 2) {
                iBinderM12370MiMN = AbstractC3926j6.m12370MiMN(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 3) {
                c3613eEOGOh = (C3613eEOGOh) AbstractC3926j6.m12381wA(parcel, iM12372VA, C3613eEOGOh.f13446CREATOR);
            } else if (iM12379qdMbNW == 4) {
                zM12365Dt = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 5) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                zM12365Dt2 = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C2320Kd(iM12373YoKzxo, iBinderM12370MiMN, c3613eEOGOh, zM12365Dt, zM12365Dt2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C2320Kd[i];
    }
}
