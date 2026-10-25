package p131o;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.WP */
/* loaded from: classes.dex */
public final class C3094WP implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        C1866E5 c1866e5 = null;
        int[] iArrM12364AZxh = null;
        int[] iArrM12364AZxh2 = null;
        boolean zM12365Dt = false;
        boolean zM12365Dt2 = false;
        int iM12373YoKzxo = 0;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            switch (AbstractC3926j6.m12379qdMbNW(iM12372VA)) {
                case 1:
                    c1866e5 = (C1866E5) AbstractC3926j6.m12381wA(parcel, iM12372VA, C1866E5.f7957CREATOR);
                    break;
                case 2:
                    zM12365Dt = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
                    break;
                case 3:
                    zM12365Dt2 = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
                    break;
                case 4:
                    iArrM12364AZxh = AbstractC3926j6.m12364AZxh(parcel, iM12372VA);
                    break;
                case 5:
                    iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 6:
                    iArrM12364AZxh2 = AbstractC3926j6.m12364AZxh(parcel, iM12372VA);
                    break;
                default:
                    AbstractC3926j6.m12375fehf(parcel, iM12372VA);
                    break;
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C1674BABY(c1866e5, zM12365Dt, zM12365Dt2, iArrM12364AZxh, iM12373YoKzxo, iArrM12364AZxh2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C1674BABY[i];
    }
}
