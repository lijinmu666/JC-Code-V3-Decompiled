package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import com.p038google.p039android.p042gms.p046common.p047api.C0209Scope;

/* renamed from: o.zB */
/* loaded from: classes.dex */
public final class C4996zB implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        String strM12374ZfxDd = null;
        int iM12373YoKzxo = 0;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 2) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C0209Scope(iM12373YoKzxo, strM12374ZfxDd);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C0209Scope[i];
    }
}
