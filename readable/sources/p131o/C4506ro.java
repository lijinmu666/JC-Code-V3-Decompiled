package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.ro */
/* loaded from: classes.dex */
public final class C4506ro implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        float fM12366ETF = 0.0f;
        int iM12373YoKzxo = 0;
        int iM12373YoKzxo2 = 0;
        int iM12373YoKzxo3 = 0;
        int iM12373YoKzxo4 = 0;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 2) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 3) {
                iM12373YoKzxo2 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 4) {
                iM12373YoKzxo3 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 5) {
                iM12373YoKzxo4 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 6) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                fM12366ETF = AbstractC3926j6.m12366ETF(parcel, iM12372VA);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C4237nn(iM12373YoKzxo, iM12373YoKzxo2, iM12373YoKzxo3, iM12373YoKzxo4, fM12366ETF);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4237nn[i];
    }
}
