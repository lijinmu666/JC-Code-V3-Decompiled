package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* renamed from: o.u2 */
/* loaded from: classes.dex */
public final class C4656u2 implements Comparable, Parcelable {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4656u2> f16763CREATOR = new mjFkc();

    /* renamed from: AZxh */
    public final int f16764AZxh;

    /* renamed from: JHa */
    public final long f16765JHa;

    /* renamed from: KLFTb */
    public final int f16766KLFTb;

    /* renamed from: ZfxDd */
    public final int f16767ZfxDd;

    /* renamed from: mjFkc */
    public final Calendar f16768mjFkc;

    /* renamed from: wA */
    public final int f16769wA;

    /* renamed from: xJ */
    public String f16770xJ;

    /* renamed from: o.u2$mjFkc */
    public class mjFkc implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public C4656u2[] newArray(int i) {
            return new C4656u2[i];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public C4656u2 createFromParcel(Parcel parcel) {
            return C4656u2.m13667qdMbNW(parcel.readInt(), parcel.readInt());
        }
    }

    public C4656u2(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarM8119wA = AbstractC1870E9.m8119wA(calendar);
        this.f16768mjFkc = calendarM8119wA;
        this.f16764AZxh = calendarM8119wA.get(2);
        this.f16769wA = calendarM8119wA.get(1);
        this.f16767ZfxDd = calendarM8119wA.getMaximum(7);
        this.f16766KLFTb = calendarM8119wA.getActualMaximum(5);
        this.f16765JHa = calendarM8119wA.getTimeInMillis();
    }

    /* renamed from: Dt */
    public static C4656u2 m13665Dt(long j) {
        Calendar calendarM8116lgHUyS = AbstractC1870E9.m8116lgHUyS();
        calendarM8116lgHUyS.setTimeInMillis(j);
        return new C4656u2(calendarM8116lgHUyS);
    }

    /* renamed from: ETF */
    public static C4656u2 m13666ETF() {
        return new C4656u2(AbstractC1870E9.m8113JHa());
    }

    /* renamed from: qdMbNW */
    public static C4656u2 m13667qdMbNW(int i, int i2) {
        Calendar calendarM8116lgHUyS = AbstractC1870E9.m8116lgHUyS();
        calendarM8116lgHUyS.set(1, i);
        calendarM8116lgHUyS.set(2, i2);
        return new C4656u2(calendarM8116lgHUyS);
    }

    /* renamed from: IEE */
    public int m13668IEE(C4656u2 c4656u2) {
        if (this.f16768mjFkc instanceof GregorianCalendar) {
            return ((c4656u2.f16769wA - this.f16769wA) * 12) + (c4656u2.f16764AZxh - this.f16764AZxh);
        }
        throw new IllegalArgumentException("Only Gregorian calendars are supported.");
    }

    /* renamed from: MiMN */
    public long m13669MiMN(int i) {
        Calendar calendarM8119wA = AbstractC1870E9.m8119wA(this.f16768mjFkc);
        calendarM8119wA.set(5, i);
        return calendarM8119wA.getTimeInMillis();
    }

    /* renamed from: VA */
    public int m13670VA(int i) {
        int i2 = this.f16768mjFkc.get(7);
        if (i <= 0) {
            i = this.f16768mjFkc.getFirstDayOfWeek();
        }
        int i3 = i2 - i;
        return i3 < 0 ? i3 + this.f16767ZfxDd : i3;
    }

    /* renamed from: YoKzxo */
    public int m13671YoKzxo(long j) {
        Calendar calendarM8119wA = AbstractC1870E9.m8119wA(this.f16768mjFkc);
        calendarM8119wA.setTimeInMillis(j);
        return calendarM8119wA.get(5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* renamed from: equals */
    public boolean m13672equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C4656u2)) {
            return false;
        }
        C4656u2 c4656u2 = (C4656u2) obj;
        return this.f16764AZxh == c4656u2.f16764AZxh && this.f16769wA == c4656u2.f16769wA;
    }

    /* renamed from: fehf */
    public C4656u2 m13673fehf(int i) {
        Calendar calendarM8119wA = AbstractC1870E9.m8119wA(this.f16768mjFkc);
        calendarM8119wA.add(2, i);
        return new C4656u2(calendarM8119wA);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f16764AZxh), Integer.valueOf(this.f16769wA)});
    }

    @Override // java.lang.Comparable
    /* renamed from: lgHUyS, reason: merged with bridge method [inline-methods] */
    public int compareTo(C4656u2 c4656u2) {
        return this.f16768mjFkc.compareTo(c4656u2.f16768mjFkc);
    }

    /* renamed from: qGY */
    public long m13675qGY() {
        return this.f16768mjFkc.getTimeInMillis();
    }

    /* renamed from: rkYL */
    public String m13676rkYL() {
        if (this.f16770xJ == null) {
            this.f16770xJ = AbstractC5019zZ.m14113JHa(this.f16768mjFkc.getTimeInMillis());
        }
        return this.f16770xJ;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f16769wA);
        parcel.writeInt(this.f16764AZxh);
    }
}
