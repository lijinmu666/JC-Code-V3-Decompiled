package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.ZP */
/* loaded from: classes.dex */
public final class C3295ZP implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        int iM12373YoKzxo = 0;
        boolean zM12365Dt = false;
        int iM12373YoKzxo2 = 0;
        int iM12373YoKzxo3 = 0;
        C2034GT[] c2034gtArr = null;
        C2685QH c2685qh = null;
        C2685QH c2685qh2 = null;
        C2685QH c2685qh3 = null;
        String strM12374ZfxDd = null;
        String strM12374ZfxDd2 = null;
        float fM12366ETF = 0.0f;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            switch (AbstractC3926j6.m12379qdMbNW(iM12372VA)) {
                case 2:
                    c2034gtArr = (C2034GT[]) AbstractC3926j6.m12368JHa(parcel, iM12372VA, C2034GT.f8358CREATOR);
                    break;
                case 3:
                    c2685qh = (C2685QH) AbstractC3926j6.m12381wA(parcel, iM12372VA, C2685QH.f10164CREATOR);
                    break;
                case 4:
                    c2685qh2 = (C2685QH) AbstractC3926j6.m12381wA(parcel, iM12372VA, C2685QH.f10164CREATOR);
                    break;
                case 5:
                    c2685qh3 = (C2685QH) AbstractC3926j6.m12381wA(parcel, iM12372VA, C2685QH.f10164CREATOR);
                    break;
                case 6:
                    strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 7:
                    fM12366ETF = AbstractC3926j6.m12366ETF(parcel, iM12372VA);
                    break;
                case 8:
                    strM12374ZfxDd2 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 9:
                    iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 10:
                    zM12365Dt = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
                    break;
                case 11:
                    iM12373YoKzxo2 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 12:
                    iM12373YoKzxo3 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                default:
                    AbstractC3926j6.m12375fehf(parcel, iM12372VA);
                    break;
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C2630PO(c2034gtArr, c2685qh, c2685qh2, c2685qh3, strM12374ZfxDd, fM12366ETF, strM12374ZfxDd2, iM12373YoKzxo, zM12365Dt, iM12373YoKzxo2, iM12373YoKzxo3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C2630PO[i];
    }
}
