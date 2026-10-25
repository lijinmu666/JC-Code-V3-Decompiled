package p131o;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

/* renamed from: o.VW */
/* loaded from: classes.dex */
public final class C3033VW extends AbstractC4666uB implements InterfaceC1662B {
    public C3033VW(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override // p131o.InterfaceC1662B
    /* renamed from: zzb */
    public final Account mo7644zzb() {
        Parcel parcelM13704ZfxDd = m13704ZfxDd(2, m13703KLFTb());
        Account account = (Account) AbstractC4468rE.m13363mjFkc(parcelM13704ZfxDd, Account.CREATOR);
        parcelM13704ZfxDd.recycle();
        return account;
    }
}
