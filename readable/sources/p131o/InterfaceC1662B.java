package p131o;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;

/* renamed from: o.B */
/* loaded from: classes.dex */
public interface InterfaceC1662B extends IInterface {

    /* renamed from: o.B$mjFkc */
    public static abstract class mjFkc extends AbstractBinderC4004kD implements InterfaceC1662B {
        /* renamed from: KLFTb */
        public static InterfaceC1662B m7645KLFTb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof InterfaceC1662B ? (InterfaceC1662B) iInterfaceQueryLocalInterface : new C3033VW(iBinder);
        }
    }

    /* renamed from: zzb */
    Account mo7644zzb();
}
