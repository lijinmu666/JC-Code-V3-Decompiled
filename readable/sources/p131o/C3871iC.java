package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.iC */
/* loaded from: classes.dex */
public final class C3871iC implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        int iM12373YoKzxo = 0;
        boolean zM12365Dt = false;
        boolean zM12365Dt2 = false;
        int iM12373YoKzxo2 = 0;
        int iM12373YoKzxo3 = 0;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 2) {
                zM12365Dt = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 3) {
                zM12365Dt2 = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 4) {
                iM12373YoKzxo2 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 5) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                iM12373YoKzxo3 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C1866E5(iM12373YoKzxo, zM12365Dt, zM12365Dt2, iM12373YoKzxo2, iM12373YoKzxo3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C1866E5[i];
    }
}
