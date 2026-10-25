package p131o;

import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.tE */
/* loaded from: classes.dex */
public abstract class AbstractC4602tE {
    static {
        AbstractC4602tE.class.getClassLoader();
    }

    /* renamed from: AZxh */
    public static void m13612AZxh(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }

    /* renamed from: mjFkc */
    public static void m13613mjFkc(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
