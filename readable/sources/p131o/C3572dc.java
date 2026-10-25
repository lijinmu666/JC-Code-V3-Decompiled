package p131o;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.p038google.p039android.p042gms.p043auth.p044api.p045signin.GoogleSignInAccount;
import com.p038google.p039android.p042gms.p046common.p047api.C0209Scope;
import java.util.ArrayList;

/* renamed from: o.dc */
/* loaded from: classes.dex */
public final class C3572dc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        String strM12374ZfxDd = null;
        String strM12374ZfxDd2 = null;
        String strM12374ZfxDd3 = null;
        String strM12374ZfxDd4 = null;
        Uri uri = null;
        String strM12374ZfxDd5 = null;
        String strM12374ZfxDd6 = null;
        ArrayList arrayListM12382xJ = null;
        String strM12374ZfxDd7 = null;
        String strM12374ZfxDd8 = null;
        long jM12380rkYL = 0;
        int iM12373YoKzxo = 0;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            switch (AbstractC3926j6.m12379qdMbNW(iM12372VA)) {
                case 1:
                    iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 2:
                    strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 3:
                    strM12374ZfxDd2 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 4:
                    strM12374ZfxDd3 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 5:
                    strM12374ZfxDd4 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 6:
                    uri = (Uri) AbstractC3926j6.m12381wA(parcel, iM12372VA, Uri.CREATOR);
                    break;
                case 7:
                    strM12374ZfxDd5 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 8:
                    jM12380rkYL = AbstractC3926j6.m12380rkYL(parcel, iM12372VA);
                    break;
                case 9:
                    strM12374ZfxDd6 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 10:
                    arrayListM12382xJ = AbstractC3926j6.m12382xJ(parcel, iM12372VA, C0209Scope.f2243CREATOR);
                    break;
                case 11:
                    strM12374ZfxDd7 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 12:
                    strM12374ZfxDd8 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                default:
                    AbstractC3926j6.m12375fehf(parcel, iM12372VA);
                    break;
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new GoogleSignInAccount(iM12373YoKzxo, strM12374ZfxDd, strM12374ZfxDd2, strM12374ZfxDd3, strM12374ZfxDd4, uri, strM12374ZfxDd5, jM12380rkYL, strM12374ZfxDd6, arrayListM12382xJ, strM12374ZfxDd7, strM12374ZfxDd8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
