package p131o;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: o.F */
/* loaded from: classes.dex */
public interface InterfaceC1929F extends IInterface {

    /* renamed from: o.F$mjFkc */
    public static abstract class mjFkc extends AbstractBinderC4004kD implements InterfaceC1929F {
        public mjFkc() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        /* renamed from: KLFTb */
        public static InterfaceC1929F m8243KLFTb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof InterfaceC1929F ? (InterfaceC1929F) iInterfaceQueryLocalInterface : new C3872iD(iBinder);
        }
    }
}
