package com.p038google.p039android.p042gms.p046common.p047api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.p038google.p039android.p042gms.p046common.internal.ReflectedParcelable;
import p131o.AbstractC1893ETF;
import p131o.AbstractC2931U2;
import p131o.AbstractC3437bWIyu;
import p131o.AbstractC3997k6;
import p131o.C3613eEOGOh;
import p131o.C3675fD;

/* renamed from: com.google.android.gms.common.api.Status */
/* loaded from: classes.dex */
public final class C0210Status extends AbstractC1893ETF implements ReflectedParcelable {

    /* renamed from: AZxh */
    public final String f2255AZxh;

    /* renamed from: ZfxDd */
    public final C3613eEOGOh f2256ZfxDd;

    /* renamed from: mjFkc */
    public final int f2257mjFkc;

    /* renamed from: wA */
    public final PendingIntent f2258wA;

    /* renamed from: KLFTb */
    public static final C0210Status f2250KLFTb = new C0210Status(-1);

    /* renamed from: JHa */
    public static final C0210Status f2249JHa = new C0210Status(0);

    /* renamed from: xJ */
    public static final C0210Status f2254xJ = new C0210Status(14);

    /* renamed from: lgHUyS */
    public static final C0210Status f2252lgHUyS = new C0210Status(8);

    /* renamed from: qdMbNW */
    public static final C0210Status f2253qdMbNW = new C0210Status(15);

    /* renamed from: Dt */
    public static final C0210Status f2247Dt = new C0210Status(16);

    /* renamed from: VA */
    public static final C0210Status f2251VA = new C0210Status(17);

    /* renamed from: ETF */
    public static final C0210Status f2248ETF = new C0210Status(18);

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C0210Status> f2246CREATOR = new C3675fD();

    public C0210Status(int i, String str, PendingIntent pendingIntent, C3613eEOGOh c3613eEOGOh) {
        this.f2257mjFkc = i;
        this.f2255AZxh = str;
        this.f2258wA = pendingIntent;
        this.f2256ZfxDd = c3613eEOGOh;
    }

    /* renamed from: AZxh */
    public int m2374AZxh() {
        return this.f2257mjFkc;
    }

    /* renamed from: JHa */
    public boolean m2375JHa() {
        return this.f2257mjFkc <= 0;
    }

    /* renamed from: ZfxDd */
    public boolean m2376ZfxDd() {
        return this.f2258wA != null;
    }

    /* renamed from: equals */
    public boolean m2377equals(Object obj) {
        if (!(obj instanceof C0210Status)) {
            return false;
        }
        C0210Status c0210Status = (C0210Status) obj;
        return this.f2257mjFkc == c0210Status.f2257mjFkc && AbstractC2931U2.m10465mjFkc(this.f2255AZxh, c0210Status.f2255AZxh) && AbstractC2931U2.m10465mjFkc(this.f2258wA, c0210Status.f2258wA) && AbstractC2931U2.m10465mjFkc(this.f2256ZfxDd, c0210Status.f2256ZfxDd);
    }

    public int hashCode() {
        return AbstractC2931U2.m10464AZxh(Integer.valueOf(this.f2257mjFkc), this.f2255AZxh, this.f2258wA, this.f2256ZfxDd);
    }

    /* renamed from: mjFkc */
    public C3613eEOGOh m2378mjFkc() {
        return this.f2256ZfxDd;
    }

    public String toString() {
        AbstractC2931U2.mjFkc mjfkcM10466wA = AbstractC2931U2.m10466wA(this);
        mjfkcM10466wA.m10467mjFkc("statusCode", m2380xJ());
        mjfkcM10466wA.m10467mjFkc("resolution", this.f2258wA);
        return mjfkcM10466wA.toString();
    }

    /* renamed from: wA */
    public String m2379wA() {
        return this.f2255AZxh;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, m2374AZxh());
        AbstractC3997k6.m12469ETF(parcel, 2, m2379wA(), false);
        AbstractC3997k6.m12468Dt(parcel, 3, this.f2258wA, i, false);
        AbstractC3997k6.m12468Dt(parcel, 4, m2378mjFkc(), i, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    /* renamed from: xJ */
    public final String m2380xJ() {
        String str = this.f2255AZxh;
        return str != null ? str : AbstractC3437bWIyu.m11524mjFkc(this.f2257mjFkc);
    }

    public C0210Status(int i) {
        this(i, (String) null);
    }

    public C0210Status(C3613eEOGOh c3613eEOGOh, String str) {
        this(c3613eEOGOh, str, 17);
    }

    public C0210Status(int i, String str) {
        this(i, str, (PendingIntent) null);
    }

    public C0210Status(C3613eEOGOh c3613eEOGOh, String str, int i) {
        this(i, str, c3613eEOGOh.m11827wA(), c3613eEOGOh);
    }

    public C0210Status(int i, String str, PendingIntent pendingIntent) {
        this(i, str, pendingIntent, null);
    }
}
