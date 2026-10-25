package com.p038google.p039android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;
import p131o.AbstractC1870E9;
import p131o.AbstractC3003V2;
import p131o.AbstractC4793w7;
import p131o.C4656u2;

/* renamed from: com.google.android.material.datepicker.mjFkc */
/* loaded from: classes.dex */
public final class C0256mjFkc implements Parcelable {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C0256mjFkc> f2656CREATOR = new mjFkc();

    /* renamed from: AZxh */
    public final C4656u2 f2657AZxh;

    /* renamed from: JHa */
    public final int f2658JHa;

    /* renamed from: KLFTb */
    public final int f2659KLFTb;

    /* renamed from: ZfxDd */
    public final int f2660ZfxDd;

    /* renamed from: mjFkc */
    public final C4656u2 f2661mjFkc;

    /* renamed from: wA */
    public C4656u2 f2662wA;

    /* renamed from: com.google.android.material.datepicker.mjFkc$AZxh */
    public interface AZxh extends Parcelable {
    }

    /* renamed from: com.google.android.material.datepicker.mjFkc$mjFkc */
    public class mjFkc implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public C0256mjFkc[] newArray(int i) {
            return new C0256mjFkc[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public C0256mjFkc createFromParcel(Parcel parcel) {
            C4656u2 c4656u2 = (C4656u2) parcel.readParcelable(C4656u2.class.getClassLoader());
            C4656u2 c4656u22 = (C4656u2) parcel.readParcelable(C4656u2.class.getClassLoader());
            C4656u2 c4656u23 = (C4656u2) parcel.readParcelable(C4656u2.class.getClassLoader());
            AbstractC4793w7.m13819mjFkc(parcel.readParcelable(AZxh.class.getClassLoader()));
            return new C0256mjFkc(c4656u2, c4656u22, null, c4656u23, parcel.readInt(), null);
        }
    }

    public /* synthetic */ C0256mjFkc(C4656u2 c4656u2, C4656u2 c4656u22, AZxh aZxh, C4656u2 c4656u23, int i, mjFkc mjfkc) {
        this(c4656u2, c4656u22, aZxh, c4656u23, i);
    }

    /* renamed from: AZxh */
    public C4656u2 m2917AZxh() {
        return this.f2657AZxh;
    }

    /* renamed from: JHa */
    public C4656u2 m2918JHa() {
        return this.f2662wA;
    }

    /* renamed from: ZfxDd */
    public int m2919ZfxDd() {
        return this.f2658JHa;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: equals */
    public boolean m2920equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0256mjFkc)) {
            return false;
        }
        C0256mjFkc c0256mjFkc = (C0256mjFkc) obj;
        if (this.f2661mjFkc.m13672equals(c0256mjFkc.f2661mjFkc) && this.f2657AZxh.m13672equals(c0256mjFkc.f2657AZxh) && AbstractC3003V2.m10659mjFkc(this.f2662wA, c0256mjFkc.f2662wA) && this.f2660ZfxDd == c0256mjFkc.f2660ZfxDd) {
            throw null;
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2661mjFkc, this.f2657AZxh, this.f2662wA, Integer.valueOf(this.f2660ZfxDd), null});
    }

    /* renamed from: lgHUyS */
    public int m2921lgHUyS() {
        return this.f2659KLFTb;
    }

    /* renamed from: mjFkc */
    public AZxh m2922mjFkc() {
        return null;
    }

    /* renamed from: wA */
    public int m2923wA() {
        return this.f2660ZfxDd;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2661mjFkc, 0);
        parcel.writeParcelable(this.f2657AZxh, 0);
        parcel.writeParcelable(this.f2662wA, 0);
        parcel.writeParcelable(null, 0);
        parcel.writeInt(this.f2660ZfxDd);
    }

    /* renamed from: xJ */
    public C4656u2 m2924xJ() {
        return this.f2661mjFkc;
    }

    public C0256mjFkc(C4656u2 c4656u2, C4656u2 c4656u22, AZxh aZxh, C4656u2 c4656u23, int i) {
        Objects.requireNonNull(c4656u2, "start cannot be null");
        Objects.requireNonNull(c4656u22, "end cannot be null");
        Objects.requireNonNull(aZxh, "validator cannot be null");
        this.f2661mjFkc = c4656u2;
        this.f2657AZxh = c4656u22;
        this.f2662wA = c4656u23;
        this.f2660ZfxDd = i;
        if (c4656u23 != null && c4656u2.compareTo(c4656u23) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (c4656u23 != null && c4656u23.compareTo(c4656u22) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i < 0 || i > AbstractC1870E9.m8116lgHUyS().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.f2658JHa = c4656u2.m13668IEE(c4656u22) + 1;
        this.f2659KLFTb = (c4656u22.f16769wA - c4656u2.f16769wA) + 1;
    }
}
