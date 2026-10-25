package p131o;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: o.JB */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2215JB extends AbstractBinderC4004kD implements InterfaceC1729C {
    public AbstractBinderC2215JB() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override // p131o.AbstractBinderC4004kD
    /* renamed from: ZfxDd */
    public final boolean mo8913ZfxDd(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) AbstractC4468rE.m13363mjFkc(parcel, Bundle.CREATOR);
            AbstractC4468rE.m13362AZxh(parcel);
            mo7745eyqo(i3, strongBinder, bundle);
        } else if (i == 2) {
            int i4 = parcel.readInt();
            Bundle bundle2 = (Bundle) AbstractC4468rE.m13363mjFkc(parcel, Bundle.CREATOR);
            AbstractC4468rE.m13362AZxh(parcel);
            mo7746qGY(i4, bundle2);
        } else {
            if (i != 3) {
                return false;
            }
            int i5 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            C1885EN c1885en = (C1885EN) AbstractC4468rE.m13363mjFkc(parcel, C1885EN.f7979CREATOR);
            AbstractC4468rE.m13362AZxh(parcel);
            mo7744YoKzxo(i5, strongBinder2, c1885en);
        }
        parcel2.writeNoException();
        return true;
    }
}
