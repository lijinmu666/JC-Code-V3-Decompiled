package p131o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.el */
/* loaded from: classes.dex */
public abstract class AbstractBinderC3645el extends Binder implements IInterface {
    public AbstractBinderC3645el(String str) {
        attachInterface(this, str);
    }

    /* renamed from: ZfxDd */
    public abstract boolean mo8465ZfxDd(int i, Parcel parcel, Parcel parcel2, int i2);

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return mo8465ZfxDd(i, parcel, parcel2, i2);
    }
}
