package p131o;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.Xb */
/* loaded from: classes.dex */
public final class C3170Xb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        PendingIntent pendingIntent = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            if (AbstractC3926j6.m12379qdMbNW(iM12372VA) != 1) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                pendingIntent = (PendingIntent) AbstractC3926j6.m12381wA(parcel, iM12372VA, PendingIntent.CREATOR);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C4456r2(pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4456r2[i];
    }
}
