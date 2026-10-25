package p131o;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* renamed from: o.Tu */
/* loaded from: classes.dex */
public final class C2921Tu implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        float fM12366ETF = 0.0f;
        float fM12366ETF2 = 0.0f;
        String strM12374ZfxDd = null;
        Rect rect = null;
        ArrayList arrayListM12382xJ = null;
        String strM12374ZfxDd2 = null;
        ArrayList arrayListM12382xJ2 = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            switch (AbstractC3926j6.m12379qdMbNW(iM12372VA)) {
                case 1:
                    strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 2:
                    rect = (Rect) AbstractC3926j6.m12381wA(parcel, iM12372VA, Rect.CREATOR);
                    break;
                case 3:
                    arrayListM12382xJ = AbstractC3926j6.m12382xJ(parcel, iM12372VA, Point.CREATOR);
                    break;
                case 4:
                    strM12374ZfxDd2 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 5:
                    arrayListM12382xJ2 = AbstractC3926j6.m12382xJ(parcel, iM12372VA, C2725Qu.f10291CREATOR);
                    break;
                case 6:
                    fM12366ETF = AbstractC3926j6.m12366ETF(parcel, iM12372VA);
                    break;
                case 7:
                    fM12366ETF2 = AbstractC3926j6.m12366ETF(parcel, iM12372VA);
                    break;
                default:
                    AbstractC3926j6.m12375fehf(parcel, iM12372VA);
                    break;
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C2859Su(strM12374ZfxDd, rect, arrayListM12382xJ, strM12374ZfxDd2, arrayListM12382xJ2, fM12366ETF, fM12366ETF2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C2859Su[i];
    }
}
