package com.p038google.p039android.p042gms.p046common.p047api;

import android.os.Parcel;
import android.os.Parcelable;
import com.p038google.p039android.p042gms.p046common.internal.ReflectedParcelable;
import p131o.AbstractC1893ETF;
import p131o.AbstractC2138I3;
import p131o.AbstractC3997k6;
import p131o.C4996zB;

/* renamed from: com.google.android.gms.common.api.Scope */
/* loaded from: classes.dex */
public final class C0209Scope extends AbstractC1893ETF implements ReflectedParcelable {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C0209Scope> f2243CREATOR = new C4996zB();

    /* renamed from: AZxh */
    public final String f2244AZxh;

    /* renamed from: mjFkc */
    public final int f2245mjFkc;

    public C0209Scope(int i, String str) {
        AbstractC2138I3.m8641JHa(str, "scopeUri must not be null or empty");
        this.f2245mjFkc = i;
        this.f2244AZxh = str;
    }

    /* renamed from: equals */
    public boolean m2372equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0209Scope) {
            return this.f2244AZxh.equals(((C0209Scope) obj).f2244AZxh);
        }
        return false;
    }

    public int hashCode() {
        return this.f2244AZxh.hashCode();
    }

    /* renamed from: mjFkc */
    public String m2373mjFkc() {
        return this.f2244AZxh;
    }

    public String toString() {
        return this.f2244AZxh;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f2245mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, i2);
        AbstractC3997k6.m12469ETF(parcel, 2, m2373mjFkc(), false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    public C0209Scope(String str) {
        this(1, str);
    }
}
