package p131o;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import p131o.AbstractC2931U2;

/* renamed from: o.eEOGOh */
/* loaded from: classes.dex */
public final class C3613eEOGOh extends AbstractC1893ETF {

    /* renamed from: AZxh */
    public final int f13448AZxh;

    /* renamed from: ZfxDd */
    public final String f13449ZfxDd;

    /* renamed from: mjFkc */
    public final int f13450mjFkc;

    /* renamed from: wA */
    public final PendingIntent f13451wA;

    /* renamed from: KLFTb */
    public static final C3613eEOGOh f13447KLFTb = new C3613eEOGOh(0);

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C3613eEOGOh> f13446CREATOR = new C4266oD();

    public C3613eEOGOh(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f13450mjFkc = i;
        this.f13448AZxh = i2;
        this.f13451wA = pendingIntent;
        this.f13449ZfxDd = str;
    }

    /* renamed from: xJ */
    public static String m11821xJ(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i + ")";
                }
        }
    }

    /* renamed from: AZxh */
    public String m11822AZxh() {
        return this.f13449ZfxDd;
    }

    /* renamed from: JHa */
    public boolean m11823JHa() {
        return this.f13448AZxh == 0;
    }

    /* renamed from: ZfxDd */
    public boolean m11824ZfxDd() {
        return (this.f13448AZxh == 0 || this.f13451wA == null) ? false : true;
    }

    /* renamed from: equals */
    public boolean m11825equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3613eEOGOh)) {
            return false;
        }
        C3613eEOGOh c3613eEOGOh = (C3613eEOGOh) obj;
        return this.f13448AZxh == c3613eEOGOh.f13448AZxh && AbstractC2931U2.m10465mjFkc(this.f13451wA, c3613eEOGOh.f13451wA) && AbstractC2931U2.m10465mjFkc(this.f13449ZfxDd, c3613eEOGOh.f13449ZfxDd);
    }

    public int hashCode() {
        return AbstractC2931U2.m10464AZxh(Integer.valueOf(this.f13448AZxh), this.f13451wA, this.f13449ZfxDd);
    }

    /* renamed from: mjFkc */
    public int m11826mjFkc() {
        return this.f13448AZxh;
    }

    public String toString() {
        AbstractC2931U2.mjFkc mjfkcM10466wA = AbstractC2931U2.m10466wA(this);
        mjfkcM10466wA.m10467mjFkc("statusCode", m11821xJ(this.f13448AZxh));
        mjfkcM10466wA.m10467mjFkc("resolution", this.f13451wA);
        mjfkcM10466wA.m10467mjFkc("message", this.f13449ZfxDd);
        return mjfkcM10466wA.toString();
    }

    /* renamed from: wA */
    public PendingIntent m11827wA() {
        return this.f13451wA;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f13450mjFkc;
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12484xJ(parcel, 1, i2);
        AbstractC3997k6.m12484xJ(parcel, 2, m11826mjFkc());
        AbstractC3997k6.m12468Dt(parcel, 3, m11827wA(), i, false);
        AbstractC3997k6.m12469ETF(parcel, 4, m11822AZxh(), false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }

    public C3613eEOGOh(int i) {
        this(i, null, null);
    }

    public C3613eEOGOh(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public C3613eEOGOh(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }
}
