package p131o;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.MO */
/* loaded from: classes.dex */
public final class C2435MO implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        Bundle bundleM12377mjFkc = null;
        C1674BABY c1674baby = null;
        int iM12373YoKzxo = 0;
        C2987UokA[] c2987UokAArr = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                bundleM12377mjFkc = AbstractC3926j6.m12377mjFkc(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 2) {
                c2987UokAArr = (C2987UokA[]) AbstractC3926j6.m12368JHa(parcel, iM12372VA, C2987UokA.f10914CREATOR);
            } else if (iM12379qdMbNW == 3) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 4) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                c1674baby = (C1674BABY) AbstractC3926j6.m12381wA(parcel, iM12372VA, C1674BABY.f7452CREATOR);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C1885EN(bundleM12377mjFkc, c2987UokAArr, iM12373YoKzxo, c1674baby);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C1885EN[i];
    }
}
