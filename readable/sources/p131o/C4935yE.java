package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.yE */
/* loaded from: classes.dex */
public final class C4935yE implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        long jM12380rkYL = -1;
        int iM12373YoKzxo = 0;
        String strM12374ZfxDd = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 2) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 3) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                jM12380rkYL = AbstractC3926j6.m12380rkYL(parcel, iM12372VA);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C2987UokA(strM12374ZfxDd, iM12373YoKzxo, jM12380rkYL);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C2987UokA[i];
    }
}
