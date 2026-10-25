package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import p131o.AbstractC2931U2;

/* renamed from: o.UokA */
/* loaded from: classes.dex */
public class C2987UokA extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C2987UokA> f10914CREATOR = new C4935yE();

    /* renamed from: AZxh */
    public final int f10915AZxh;

    /* renamed from: mjFkc */
    public final String f10916mjFkc;

    /* renamed from: wA */
    public final long f10917wA;

    public C2987UokA(String str, int i, long j) {
        this.f10916mjFkc = str;
        this.f10915AZxh = i;
        this.f10917wA = j;
    }

    /* renamed from: AZxh */
    public long m10647AZxh() {
        long j = this.f10917wA;
        return j == -1 ? this.f10915AZxh : j;
    }

    /* renamed from: equals */
    public final boolean m10648equals(Object obj) {
        if (obj instanceof C2987UokA) {
            C2987UokA c2987UokA = (C2987UokA) obj;
            if (((m10649mjFkc() != null && m10649mjFkc().equals(c2987UokA.m10649mjFkc())) || (m10649mjFkc() == null && c2987UokA.m10649mjFkc() == null)) && m10647AZxh() == c2987UokA.m10647AZxh()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return AbstractC2931U2.m10464AZxh(m10649mjFkc(), Long.valueOf(m10647AZxh()));
    }

    /* renamed from: mjFkc */
    public String m10649mjFkc() {
        return this.f10916mjFkc;
    }

    public final String toString() {
        AbstractC2931U2.mjFkc mjfkcM10466wA = AbstractC2931U2.m10466wA(this);
        mjfkcM10466wA.m10467mjFkc("name", m10649mjFkc());
        mjfkcM10466wA.m10467mjFkc("version", Long.valueOf(m10647AZxh()));
        return mjfkcM10466wA.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12469ETF(parcel, 1, m10649mjFkc(), false);
        AbstractC3997k6.m12484xJ(parcel, 2, this.f10915AZxh);
        AbstractC3997k6.m12481qdMbNW(parcel, 3, m10647AZxh());
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    public C2987UokA(String str, long j) {
        this.f10916mjFkc = str;
        this.f10917wA = j;
        this.f10915AZxh = -1;
    }
}
