package p131o;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;

/* renamed from: o.fD */
/* loaded from: classes.dex */
public final class C3675fD implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        String strM12374ZfxDd = null;
        C3613eEOGOh c3613eEOGOh = null;
        int iM12373YoKzxo = 0;
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 2) {
                strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 3) {
                pendingIntent = (PendingIntent) AbstractC3926j6.m12381wA(parcel, iM12372VA, PendingIntent.CREATOR);
            } else if (iM12379qdMbNW != 4) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                c3613eEOGOh = (C3613eEOGOh) AbstractC3926j6.m12381wA(parcel, iM12372VA, C3613eEOGOh.f13446CREATOR);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C0210Status(iM12373YoKzxo, strM12374ZfxDd, pendingIntent, c3613eEOGOh);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C0210Status[i];
    }
}
