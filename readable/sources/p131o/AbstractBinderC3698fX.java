package p131o;

import android.os.Parcel;

/* renamed from: o.fX */
/* loaded from: classes.dex */
public abstract class AbstractBinderC3698fX extends AbstractBinderC4004kD implements InterfaceC1810DB {
    public AbstractBinderC3698fX() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    @Override // p131o.AbstractBinderC4004kD
    /* renamed from: ZfxDd */
    public final boolean mo8913ZfxDd(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            InterfaceC1929F interfaceC1929FMo7982wA = mo7982wA();
            parcel2.writeNoException();
            AbstractC4468rE.m13364wA(parcel2, interfaceC1929FMo7982wA);
        } else {
            if (i != 2) {
                return false;
            }
            int iMo7981mjFkc = mo7981mjFkc();
            parcel2.writeNoException();
            parcel2.writeInt(iMo7981mjFkc);
        }
        return true;
    }
}
