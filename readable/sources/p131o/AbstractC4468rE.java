package p131o;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.rE */
/* loaded from: classes.dex */
public abstract class AbstractC4468rE {

    /* renamed from: mjFkc */
    public static final ClassLoader f16309mjFkc = AbstractC4468rE.class.getClassLoader();

    /* renamed from: AZxh */
    public static void m13362AZxh(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail <= 0) {
            return;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + iDataAvail);
    }

    /* renamed from: mjFkc */
    public static Parcelable m13363mjFkc(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    /* renamed from: wA */
    public static void m13364wA(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
        } else {
            parcel.writeStrongBinder(iInterface.asBinder());
        }
    }
}
