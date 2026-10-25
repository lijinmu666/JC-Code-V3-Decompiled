package p131o;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.oD */
/* loaded from: classes.dex */
public final class C4266oD implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        PendingIntent pendingIntent = null;
        int iM12373YoKzxo = 0;
        int iM12373YoKzxo2 = 0;
        String strM12374ZfxDd = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 2) {
                iM12373YoKzxo2 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 3) {
                pendingIntent = (PendingIntent) AbstractC3926j6.m12381wA(parcel, iM12372VA, PendingIntent.CREATOR);
            } else if (iM12379qdMbNW != 4) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C3613eEOGOh(iM12373YoKzxo, iM12373YoKzxo2, pendingIntent, strM12374ZfxDd);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C3613eEOGOh[i];
    }
}
