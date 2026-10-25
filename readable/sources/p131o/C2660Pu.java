package p131o;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: o.Pu */
/* loaded from: classes.dex */
public final class C2660Pu implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        String strM12374ZfxDd = null;
        Rect rect = null;
        ArrayList arrayListM12382xJ = null;
        String strM12374ZfxDd2 = null;
        ArrayList arrayListM12382xJ2 = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 2) {
                rect = (Rect) AbstractC3926j6.m12381wA(parcel, iM12372VA, Rect.CREATOR);
            } else if (iM12379qdMbNW == 3) {
                arrayListM12382xJ = AbstractC3926j6.m12382xJ(parcel, iM12372VA, Point.CREATOR);
            } else if (iM12379qdMbNW == 4) {
                strM12374ZfxDd2 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 5) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                arrayListM12382xJ2 = AbstractC3926j6.m12382xJ(parcel, iM12372VA, C2859Su.f10605CREATOR);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C2598Ou(strM12374ZfxDd, rect, arrayListM12382xJ, strM12374ZfxDd2, arrayListM12382xJ2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C2598Ou[i];
    }
}
