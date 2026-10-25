package p131o;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.p038google.p039android.p042gms.p046common.p047api.C0209Scope;

/* renamed from: o.eR */
/* loaded from: classes.dex */
public final class C3627eR implements Parcelable.Creator {
    /* renamed from: mjFkc */
    public static void m11845mjFkc(C4221nVsW c4221nVsW, Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, c4221nVsW.f15420mjFkc);
        AbstractC3997k6.m12484xJ(parcel, 2, c4221nVsW.f15410AZxh);
        AbstractC3997k6.m12484xJ(parcel, 3, c4221nVsW.f15422wA);
        AbstractC3997k6.m12469ETF(parcel, 4, c4221nVsW.f15418ZfxDd, false);
        AbstractC3997k6.m12471JHa(parcel, 5, c4221nVsW.f15414KLFTb, false);
        AbstractC3997k6.m12473MiMN(parcel, 6, c4221nVsW.f15413JHa, i, false);
        AbstractC3997k6.m12476ZfxDd(parcel, 7, c4221nVsW.f15423xJ, false);
        AbstractC3997k6.m12468Dt(parcel, 8, c4221nVsW.f15419lgHUyS, i, false);
        AbstractC3997k6.m12473MiMN(parcel, 10, c4221nVsW.f15421qdMbNW, i, false);
        AbstractC3997k6.m12473MiMN(parcel, 11, c4221nVsW.f15411Dt, i, false);
        AbstractC3997k6.m12483wA(parcel, 12, c4221nVsW.f15412ETF);
        AbstractC3997k6.m12484xJ(parcel, 13, c4221nVsW.f15416VA);
        AbstractC3997k6.m12483wA(parcel, 14, c4221nVsW.f15415MiMN);
        AbstractC3997k6.m12469ETF(parcel, 15, c4221nVsW.m12892mjFkc(), false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iM12367IEE = AbstractC3926j6.m12367IEE(parcel);
        C0209Scope[] c0209ScopeArr = C4221nVsW.f15409rkYL;
        Bundle bundle = new Bundle();
        C2987UokA[] c2987UokAArr = C4221nVsW.f15408qGY;
        C2987UokA[] c2987UokAArr2 = c2987UokAArr;
        String strM12374ZfxDd = null;
        IBinder iBinderM12370MiMN = null;
        Account account = null;
        String strM12374ZfxDd2 = null;
        int iM12373YoKzxo = 0;
        int iM12373YoKzxo2 = 0;
        int iM12373YoKzxo3 = 0;
        boolean zM12365Dt = false;
        int iM12373YoKzxo4 = 0;
        boolean zM12365Dt2 = false;
        while (parcel.dataPosition() < iM12367IEE) {
            int iM12372VA = AbstractC3926j6.m12372VA(parcel);
            switch (AbstractC3926j6.m12379qdMbNW(iM12372VA)) {
                case 1:
                    iM12373YoKzxo = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 2:
                    iM12373YoKzxo2 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 3:
                    iM12373YoKzxo3 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 4:
                    strM12374ZfxDd = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
                case 5:
                    iBinderM12370MiMN = AbstractC3926j6.m12370MiMN(parcel, iM12372VA);
                    break;
                case 6:
                    c0209ScopeArr = (C0209Scope[]) AbstractC3926j6.m12368JHa(parcel, iM12372VA, C0209Scope.f2243CREATOR);
                    break;
                case 7:
                    bundle = AbstractC3926j6.m12377mjFkc(parcel, iM12372VA);
                    break;
                case 8:
                    account = (Account) AbstractC3926j6.m12381wA(parcel, iM12372VA, Account.CREATOR);
                    break;
                case 9:
                default:
                    AbstractC3926j6.m12375fehf(parcel, iM12372VA);
                    break;
                case 10:
                    c2987UokAArr = (C2987UokA[]) AbstractC3926j6.m12368JHa(parcel, iM12372VA, C2987UokA.f10914CREATOR);
                    break;
                case 11:
                    c2987UokAArr2 = (C2987UokA[]) AbstractC3926j6.m12368JHa(parcel, iM12372VA, C2987UokA.f10914CREATOR);
                    break;
                case 12:
                    zM12365Dt = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
                    break;
                case 13:
                    iM12373YoKzxo4 = AbstractC3926j6.m12373YoKzxo(parcel, iM12372VA);
                    break;
                case 14:
                    zM12365Dt2 = AbstractC3926j6.m12365Dt(parcel, iM12372VA);
                    break;
                case 15:
                    strM12374ZfxDd2 = AbstractC3926j6.m12374ZfxDd(parcel, iM12372VA);
                    break;
            }
        }
        AbstractC3926j6.m12376lgHUyS(parcel, iM12367IEE);
        return new C4221nVsW(iM12373YoKzxo, iM12373YoKzxo2, iM12373YoKzxo3, strM12374ZfxDd, iBinderM12370MiMN, c0209ScopeArr, bundle, account, c2987UokAArr, c2987UokAArr2, zM12365Dt, iM12373YoKzxo4, zM12365Dt2, strM12374ZfxDd2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new C4221nVsW[i];
    }
}
