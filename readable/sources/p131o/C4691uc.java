package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: o.uc */
/* loaded from: classes.dex */
public final class C4691uc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        ArrayList arrayListM12382xJ = null;
        String strM12374ZfxDd = null;
        boolean zM12365Dt = false;
        String strM12374ZfxDd2 = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                arrayListM12382xJ = AbstractC3926j6.m12382xJ(parcel, iM12372VA, C2987UokA.f10914CREATOR);
            } else if (iM12379qdMbNW == 2) {
                zM12365Dt = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 3) {
                strM12374ZfxDd2 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 4) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C4673uHVRx(arrayListM12382xJ, zM12365Dt, strM12374ZfxDd2, strM12374ZfxDd);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4673uHVRx[i];
    }
}
