package p131o;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import p131o.InterfaceC1662B;

/* renamed from: o.vI */
/* loaded from: classes.dex */
public abstract class AbstractBinderC4739vI extends InterfaceC1662B.mjFkc {
    /* renamed from: xJ */
    public static Account m13768xJ(InterfaceC1662B interfaceC1662B) {
        Account accountMo7644zzb = null;
        if (interfaceC1662B != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                try {
                    accountMo7644zzb = interfaceC1662B.mo7644zzb();
                } catch (RemoteException unused) {
                    Log.w("AccountAccessor", "Remote account accessor probably died");
                }
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return accountMo7644zzb;
    }
}
