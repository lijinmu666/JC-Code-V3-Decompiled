package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.MW */
/* loaded from: classes.dex */
public final class C2444MW implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        boolean zM12365Dt = false;
        int iM12373YoKzxo = 0;
        boolean zM12365Dt2 = false;
        String strM12374ZfxDd = null;
        String strM12374ZfxDd2 = null;
        String strM12374ZfxDd3 = null;
        String strM12374ZfxDd4 = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            switch (AbstractC3926j6.m12379qdMbNW(iM12372VA)) {
                case 1:
                    strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 2:
                    strM12374ZfxDd2 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 3:
                    strM12374ZfxDd3 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 4:
                    zM12365Dt = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
                    break;
                case 5:
                    iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 6:
                    strM12374ZfxDd4 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 7:
                    zM12365Dt2 = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
                    break;
                default:
                    AbstractC3926j6.m12375fehf(parcel, iM12372VA);
                    break;
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C2376LW(strM12374ZfxDd, strM12374ZfxDd2, strM12374ZfxDd3, zM12365Dt, iM12373YoKzxo, strM12374ZfxDd4, zM12365Dt2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C2376LW[i];
    }
}
