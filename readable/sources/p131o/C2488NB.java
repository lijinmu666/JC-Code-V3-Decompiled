package p131o;

import android.os.IBinder;
import android.os.Parcel;

/* renamed from: o.NB */
/* loaded from: classes.dex */
public final class C2488NB implements InterfaceC1798D {

    /* renamed from: mjFkc */
    public final IBinder f9713mjFkc;

    public C2488NB(IBinder iBinder) {
        this.f9713mjFkc = iBinder;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f9713mjFkc;
    }

    @Override // p131o.InterfaceC1798D
    /* renamed from: qdMbNW */
    public final void mo7946qdMbNW(InterfaceC1729C interfaceC1729C, C4221nVsW c4221nVsW) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(interfaceC1729C != null ? interfaceC1729C.asBinder() : null);
            if (c4221nVsW != null) {
                parcelObtain.writeInt(1);
                C3627eR.m11845mjFkc(c4221nVsW, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f9713mjFkc.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            parcelObtain2.recycle();
            parcelObtain.recycle();
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }
}
