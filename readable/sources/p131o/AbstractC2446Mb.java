package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.Mb */
/* loaded from: classes.dex */
public abstract class AbstractC2446Mb implements IInterface {

    /* renamed from: AZxh */
    public final String f9584AZxh;

    /* renamed from: mjFkc */
    public final IBinder f9585mjFkc;

    public AbstractC2446Mb(IBinder iBinder, String str) {
        this.f9585mjFkc = iBinder;
        this.f9584AZxh = str;
    }

    /* renamed from: KLFTb */
    public final void m9518KLFTb(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f9585mjFkc.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    /* renamed from: ZfxDd */
    public final Parcel m9519ZfxDd() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f9584AZxh);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9585mjFkc;
    }

    /* renamed from: xJ */
    public final void m9520xJ(int i, Parcel parcel) {
        try {
            this.f9585mjFkc.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
