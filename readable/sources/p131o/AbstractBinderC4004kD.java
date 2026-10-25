package p131o;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.kD */
/* loaded from: classes.dex */
public abstract class AbstractBinderC4004kD extends Binder implements IInterface {
    public AbstractBinderC4004kD(String str) {
        attachInterface(this, str);
    }

    /* renamed from: ZfxDd */
    public boolean mo8913ZfxDd(int i, Parcel parcel, Parcel parcel2, int i2) {
        return false;
    }

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
        return mo8913ZfxDd(i, parcel, parcel2, i2);
    }
}
