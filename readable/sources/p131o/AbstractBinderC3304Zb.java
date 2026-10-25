package p131o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.Zb */
/* loaded from: classes.dex */
public abstract class AbstractBinderC3304Zb extends Binder implements IInterface {
    public AbstractBinderC3304Zb(String str) {
        attachInterface(this, str);
    }

    /* renamed from: Ucbh */
    public abstract boolean mo9521Ucbh(int i, Parcel parcel, Parcel parcel2, int i2);

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return mo9521Ucbh(i, parcel, parcel2, i2);
    }
}
