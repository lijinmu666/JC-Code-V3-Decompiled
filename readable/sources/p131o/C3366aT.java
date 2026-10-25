package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.aT */
/* loaded from: classes.dex */
public final class C3366aT implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        String strM12374ZfxDd = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            if (AbstractC3926j6.m12379qdMbNW(iM12372VA) != 2) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C4684uS(strM12374ZfxDd);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4684uS[i];
    }
}
