package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.uB */
/* loaded from: classes.dex */
public abstract class AbstractC4666uB implements IInterface {

    /* renamed from: AZxh */
    public final String f16807AZxh;

    /* renamed from: mjFkc */
    public final IBinder f16808mjFkc;

    public AbstractC4666uB(IBinder iBinder, String str) {
        this.f16808mjFkc = iBinder;
        this.f16807AZxh = str;
    }

    /* renamed from: KLFTb */
    public final Parcel m13703KLFTb() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f16807AZxh);
        return parcelObtain;
    }

    /* renamed from: ZfxDd */
    public final Parcel m13704ZfxDd(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f16808mjFkc.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f16808mjFkc;
    }
}
