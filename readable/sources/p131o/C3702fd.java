package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: o.fd */
/* loaded from: classes.dex */
public final class C3702fd implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        ArrayList arrayListM12369KLFTb = null;
        String strM12374ZfxDd = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                arrayListM12369KLFTb = AbstractC3926j6.m12369KLFTb(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 2) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C3444bd(arrayListM12369KLFTb, strM12374ZfxDd);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C3444bd[i];
    }
}
