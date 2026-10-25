package p131o;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: o.r2 */
/* loaded from: classes.dex */
public class C4456r2 extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4456r2> f16275CREATOR = new C3170Xb();

    /* renamed from: mjFkc */
    public final PendingIntent f16276mjFkc;

    public C4456r2(PendingIntent pendingIntent) {
        this.f16276mjFkc = pendingIntent;
    }

    /* renamed from: mjFkc */
    public PendingIntent m13331mjFkc() {
        return this.f16276mjFkc;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12468Dt(parcel, 1, m13331mjFkc(), i, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
