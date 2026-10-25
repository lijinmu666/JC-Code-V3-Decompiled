package p131o;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.p038google.p039android.p042gms.p043auth.p044api.p045signin.GoogleSignInAccount;

/* renamed from: o.Fd */
/* loaded from: classes.dex */
public final class C1972Fd extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C1972Fd> f8231CREATOR = new C2176Id();

    /* renamed from: AZxh */
    public final Account f8232AZxh;

    /* renamed from: ZfxDd */
    public final GoogleSignInAccount f8233ZfxDd;

    /* renamed from: mjFkc */
    public final int f8234mjFkc;

    /* renamed from: wA */
    public final int f8235wA;

    public C1972Fd(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f8234mjFkc = i;
        this.f8232AZxh = account;
        this.f8235wA = i2;
        this.f8233ZfxDd = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f8234mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, i2);
        AbstractC3997k6.m12468Dt(parcel, 2, this.f8232AZxh, i, false);
        AbstractC3997k6.m12484xJ(parcel, 3, this.f8235wA);
        AbstractC3997k6.m12468Dt(parcel, 4, this.f8233ZfxDd, i, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    public C1972Fd(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }
}
