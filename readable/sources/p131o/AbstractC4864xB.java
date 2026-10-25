package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.xB */
/* loaded from: classes.dex */
public abstract class AbstractC4864xB implements IInterface {

    /* renamed from: AZxh */
    public final String f17336AZxh;

    /* renamed from: mjFkc */
    public final IBinder f17337mjFkc;

    public AbstractC4864xB(IBinder iBinder, String str) {
        this.f17337mjFkc = iBinder;
        this.f17336AZxh = str;
    }

    /* renamed from: KLFTb */
    public final Parcel m13904KLFTb(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f17337mjFkc.transact(i, parcel, parcelObtain, 0);
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

    /* renamed from: ZfxDd */
    public final Parcel m13905ZfxDd() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f17336AZxh);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f17337mjFkc;
    }

    /* renamed from: xJ */
    public final void m13906xJ(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f17337mjFkc.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }
}
