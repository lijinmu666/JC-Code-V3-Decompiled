package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.ts */
/* loaded from: classes.dex */
public final class C4644ts implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        boolean zM12365Dt = false;
        C2190Iq[] c2190IqArr = null;
        C4237nn c4237nn = null;
        C4237nn c4237nn2 = null;
        String strM12374ZfxDd = null;
        String strM12374ZfxDd2 = null;
        float fM12366ETF = 0.0f;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            switch (AbstractC3926j6.m12379qdMbNW(iM12372VA)) {
                case 2:
                    c2190IqArr = (C2190Iq[]) AbstractC3926j6.m12368JHa(parcel, iM12372VA, C2190Iq.f8791CREATOR);
                    break;
                case 3:
                    c4237nn = (C4237nn) AbstractC3926j6.m12381wA(parcel, iM12372VA, C4237nn.f15462CREATOR);
                    break;
                case 4:
                    c4237nn2 = (C4237nn) AbstractC3926j6.m12381wA(parcel, iM12372VA, C4237nn.f15462CREATOR);
                    break;
                case 5:
                    strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 6:
                    fM12366ETF = AbstractC3926j6.m12366ETF(parcel, iM12372VA);
                    break;
                case 7:
                    strM12374ZfxDd2 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 8:
                    zM12365Dt = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
                    break;
                default:
                    AbstractC3926j6.m12375fehf(parcel, iM12372VA);
                    break;
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C2657Pr(c2190IqArr, c4237nn, c4237nn2, strM12374ZfxDd, fM12366ETF, strM12374ZfxDd2, zM12365Dt);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C2657Pr[i];
    }
}
