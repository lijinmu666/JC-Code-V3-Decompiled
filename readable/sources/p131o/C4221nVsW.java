package p131o;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.p038google.p039android.p042gms.p046common.p047api.C0209Scope;
import p131o.InterfaceC1662B;

/* renamed from: o.nVsW */
/* loaded from: classes.dex */
public class C4221nVsW extends AbstractC1893ETF {

    /* renamed from: AZxh */
    public final int f15410AZxh;

    /* renamed from: Dt */
    public C2987UokA[] f15411Dt;

    /* renamed from: ETF */
    public final boolean f15412ETF;

    /* renamed from: JHa */
    public C0209Scope[] f15413JHa;

    /* renamed from: KLFTb */
    public IBinder f15414KLFTb;

    /* renamed from: MiMN */
    public boolean f15415MiMN;

    /* renamed from: VA */
    public final int f15416VA;

    /* renamed from: YoKzxo */
    public final String f15417YoKzxo;

    /* renamed from: ZfxDd */
    public String f15418ZfxDd;

    /* renamed from: lgHUyS */
    public Account f15419lgHUyS;

    /* renamed from: mjFkc */
    public final int f15420mjFkc;

    /* renamed from: qdMbNW */
    public C2987UokA[] f15421qdMbNW;

    /* renamed from: wA */
    public final int f15422wA;

    /* renamed from: xJ */
    public Bundle f15423xJ;

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4221nVsW> f15407CREATOR = new C3627eR();

    /* renamed from: rkYL */
    public static final C0209Scope[] f15409rkYL = new C0209Scope[0];

    /* renamed from: qGY */
    public static final C2987UokA[] f15408qGY = new C2987UokA[0];

    public C4221nVsW(int i, int i2, int i3, String str, IBinder iBinder, C0209Scope[] c0209ScopeArr, Bundle bundle, Account account, C2987UokA[] c2987UokAArr, C2987UokA[] c2987UokAArr2, boolean z, int i4, boolean z2, String str2) {
        c0209ScopeArr = c0209ScopeArr == null ? f15409rkYL : c0209ScopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        c2987UokAArr = c2987UokAArr == null ? f15408qGY : c2987UokAArr;
        c2987UokAArr2 = c2987UokAArr2 == null ? f15408qGY : c2987UokAArr2;
        this.f15420mjFkc = i;
        this.f15410AZxh = i2;
        this.f15422wA = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f15418ZfxDd = "com.google.android.gms";
        } else {
            this.f15418ZfxDd = str;
        }
        if (i < 2) {
            this.f15419lgHUyS = iBinder != null ? AbstractBinderC4739vI.m13768xJ(InterfaceC1662B.mjFkc.m7645KLFTb(iBinder)) : null;
        } else {
            this.f15414KLFTb = iBinder;
            this.f15419lgHUyS = account;
        }
        this.f15413JHa = c0209ScopeArr;
        this.f15423xJ = bundle;
        this.f15421qdMbNW = c2987UokAArr;
        this.f15411Dt = c2987UokAArr2;
        this.f15412ETF = z;
        this.f15416VA = i4;
        this.f15415MiMN = z2;
        this.f15417YoKzxo = str2;
    }

    /* renamed from: mjFkc */
    public final String m12892mjFkc() {
        return this.f15417YoKzxo;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        C3627eR.m11845mjFkc(this, parcel, i);
    }
}
