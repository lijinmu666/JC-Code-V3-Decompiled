package p131o;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.p038google.p039android.p042gms.p043auth.p044api.p045signin.GoogleSignInAccount;

/* renamed from: o.Id */
/* loaded from: classes.dex */
public final class C2176Id implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        Account account = null;
        int iM12373YoKzxo = 0;
        int iM12373YoKzxo2 = 0;
        GoogleSignInAccount googleSignInAccount = null;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            int iM12379qdMbNW = AbstractC3926j6.m12379qdMbNW(iM12372VA);
            if (iM12379qdMbNW == 1) {
                iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW == 2) {
                account = (Account) AbstractC3926j6.m12381wA(parcel, iM12372VA, Account.CREATOR);
            } else if (iM12379qdMbNW == 3) {
                iM12373YoKzxo2 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
            } else if (iM12379qdMbNW != 4) {
                AbstractC3926j6.m12375fehf(parcel, iM12372VA);
            } else {
                googleSignInAccount = (GoogleSignInAccount) AbstractC3926j6.m12381wA(parcel, iM12372VA, GoogleSignInAccount.f2226CREATOR);
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C1972Fd(iM12373YoKzxo, account, iM12373YoKzxo2, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C1972Fd[i];
    }
}
