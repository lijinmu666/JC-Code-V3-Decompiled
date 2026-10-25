package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.rd */
/* loaded from: classes.dex */
public final class C4492rd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        int iM12373YoKzxo = -1;
        int iM12373YoKzxo2 = 0;
        int iM12373YoKzxo3 = 0;
        int iM12373YoKzxo4 = 0;
        int iM12373YoKzxo5 = 0;
        String strM12374ZfxDd = null;
        String strM12374ZfxDd2 = null;
        long jM12380rkYL = 0;
        long jM12380rkYL2 = 0;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            switch (AbstractC3926j6.m12379qdMbNW(iM12372VA)) {
                case 1:
                    iM12373YoKzxo2 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 2:
                    iM12373YoKzxo3 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 3:
                    iM12373YoKzxo4 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 4:
                    jM12380rkYL = AbstractC3926j6.m12380rkYL(parcel, iM12372VA);
                    break;
                case 5:
                    jM12380rkYL2 = AbstractC3926j6.m12380rkYL(parcel, iM12372VA);
                    break;
                case 6:
                    strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 7:
                    strM12374ZfxDd2 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 8:
                    iM12373YoKzxo5 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 9:
                    iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                default:
                    AbstractC3926j6.m12375fehf(parcel, iM12372VA);
                    break;
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C3729g2(iM12373YoKzxo2, iM12373YoKzxo3, iM12373YoKzxo4, jM12380rkYL, jM12380rkYL2, strM12374ZfxDd, strM12374ZfxDd2, iM12373YoKzxo5, iM12373YoKzxo);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C3729g2[i];
    }
}
