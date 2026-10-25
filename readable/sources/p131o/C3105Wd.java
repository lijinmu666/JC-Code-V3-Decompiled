package p131o;

import com.indidevs.p086android.p087adbeesh.notifications.NotificationFlowConfig;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;

/* renamed from: o.Wd */
/* loaded from: classes.dex */
public final class C3105Wd implements InterfaceC3855hy {

    /* renamed from: mjFkc */
    public static final InterfaceC3855hy f11474mjFkc = new C3105Wd();

    @Override // p131o.InterfaceC3855hy
    /* renamed from: mjFkc */
    public final boolean mo7629mjFkc(int i) {
        if (i == 3000 || i == 4000 || i == 5000 || i == 6000 || i == 6001 || i == 7000 || i == 7001) {
            return true;
        }
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                switch (i) {
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                        return true;
                    default:
                        switch (i) {
                            case 40:
                            case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                            case C5125EACTags.CURRENCY_CODE /* 42 */:
                                return true;
                            default:
                                switch (i) {
                                    case NotificationFlowConfig.DEFAULT_BASE_REQUEST_CODE /* 1000 */:
                                    case 1001:
                                    case 1002:
                                    case 1003:
                                    case 1004:
                                    case 1005:
                                    case 1006:
                                    case 1007:
                                    case 1008:
                                    case 1009:
                                    case 1010:
                                    case 1011:
                                    case 1012:
                                    case 1013:
                                    case 1014:
                                    case 1015:
                                    case 1016:
                                        return true;
                                    default:
                                        switch (i) {
                                            case 2000:
                                            case 2001:
                                            case 2002:
                                            case 2003:
                                                return true;
                                            default:
                                                return false;
                                        }
                                }
                        }
                }
        }
    }
}
