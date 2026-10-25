package p131o;

import android.util.SparseArray;
import p131o.C2820SKTn;

/* renamed from: o.H2 */
/* loaded from: classes.dex */
public abstract class AbstractC2069H2 {

    /* renamed from: o.H2$AZxh */
    public enum AZxh {
        UNKNOWN_MOBILE_SUBTYPE(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        /* JADX INFO: Fake field, exist only in values array */
        EVDO_0(5),
        /* JADX INFO: Fake field, exist only in values array */
        EVDO_A(6),
        RTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        IDEN(11),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TD_SCDMA(17),
        IWLAN(18),
        LTE_CA(19),
        COMBINED(100);


        /* renamed from: huTpC */
        public static final SparseArray f8498huTpC;

        /* renamed from: lgHUyS */
        public static final AZxh f8499lgHUyS;

        /* renamed from: xJ */
        public static final AZxh f8504xJ;

        /* renamed from: mjFkc */
        public final int f8505mjFkc;

        static {
            AZxh aZxh = UNKNOWN_MOBILE_SUBTYPE;
            AZxh aZxh2 = GPRS;
            AZxh aZxh3 = EDGE;
            AZxh aZxh4 = UMTS;
            AZxh aZxh5 = CDMA;
            AZxh aZxh6 = EVDO_0;
            f8504xJ = aZxh6;
            AZxh aZxh7 = EVDO_A;
            f8499lgHUyS = aZxh7;
            AZxh aZxh8 = RTT;
            AZxh aZxh9 = HSDPA;
            AZxh aZxh10 = HSUPA;
            AZxh aZxh11 = HSPA;
            AZxh aZxh12 = IDEN;
            AZxh aZxh13 = EVDO_B;
            AZxh aZxh14 = LTE;
            AZxh aZxh15 = EHRPD;
            AZxh aZxh16 = HSPAP;
            AZxh aZxh17 = GSM;
            AZxh aZxh18 = TD_SCDMA;
            AZxh aZxh19 = IWLAN;
            AZxh aZxh20 = LTE_CA;
            SparseArray sparseArray = new SparseArray();
            f8498huTpC = sparseArray;
            sparseArray.put(0, aZxh);
            sparseArray.put(1, aZxh2);
            sparseArray.put(2, aZxh3);
            sparseArray.put(3, aZxh4);
            sparseArray.put(4, aZxh5);
            sparseArray.put(5, aZxh6);
            sparseArray.put(6, aZxh7);
            sparseArray.put(7, aZxh8);
            sparseArray.put(8, aZxh9);
            sparseArray.put(9, aZxh10);
            sparseArray.put(10, aZxh11);
            sparseArray.put(11, aZxh12);
            sparseArray.put(12, aZxh13);
            sparseArray.put(13, aZxh14);
            sparseArray.put(14, aZxh15);
            sparseArray.put(15, aZxh16);
            sparseArray.put(16, aZxh17);
            sparseArray.put(17, aZxh18);
            sparseArray.put(18, aZxh19);
            sparseArray.put(19, aZxh20);
        }

        AZxh(int i) {
            this.f8505mjFkc = i;
        }

        /* renamed from: KLFTb */
        public static AZxh m8497KLFTb(int i) {
            return (AZxh) f8498huTpC.get(i);
        }

        /* renamed from: lgHUyS */
        public int m8500lgHUyS() {
            return this.f8505mjFkc;
        }
    }

    /* renamed from: o.H2$mjFkc */
    public static abstract class mjFkc {
        /* renamed from: AZxh */
        public abstract mjFkc mo8501AZxh(AZxh aZxh);

        /* renamed from: mjFkc */
        public abstract AbstractC2069H2 mo8502mjFkc();

        /* renamed from: wA */
        public abstract mjFkc mo8503wA(wA wAVar);
    }

    /* renamed from: o.H2$wA */
    public enum wA {
        MOBILE(0),
        WIFI(1),
        MOBILE_MMS(2),
        MOBILE_SUPL(3),
        MOBILE_DUN(4),
        /* JADX INFO: Fake field, exist only in values array */
        MOBILE_HIPRI(5),
        /* JADX INFO: Fake field, exist only in values array */
        WIMAX(6),
        BLUETOOTH(7),
        DUMMY(8),
        ETHERNET(9),
        MOBILE_FOTA(10),
        MOBILE_IMS(11),
        MOBILE_CBS(12),
        WIFI_P2P(13),
        MOBILE_IA(14),
        MOBILE_EMERGENCY(15),
        PROXY(16),
        VPN(17),
        NONE(-1);


        /* renamed from: eyqo */
        public static final SparseArray f8519eyqo;

        /* renamed from: lgHUyS */
        public static final wA f8521lgHUyS;

        /* renamed from: xJ */
        public static final wA f8526xJ;

        /* renamed from: mjFkc */
        public final int f8527mjFkc;

        static {
            wA wAVar = MOBILE;
            wA wAVar2 = WIFI;
            wA wAVar3 = MOBILE_MMS;
            wA wAVar4 = MOBILE_SUPL;
            wA wAVar5 = MOBILE_DUN;
            wA wAVar6 = MOBILE_HIPRI;
            f8526xJ = wAVar6;
            wA wAVar7 = WIMAX;
            f8521lgHUyS = wAVar7;
            wA wAVar8 = BLUETOOTH;
            wA wAVar9 = DUMMY;
            wA wAVar10 = ETHERNET;
            wA wAVar11 = MOBILE_FOTA;
            wA wAVar12 = MOBILE_IMS;
            wA wAVar13 = MOBILE_CBS;
            wA wAVar14 = WIFI_P2P;
            wA wAVar15 = MOBILE_IA;
            wA wAVar16 = MOBILE_EMERGENCY;
            wA wAVar17 = PROXY;
            wA wAVar18 = VPN;
            wA wAVar19 = NONE;
            SparseArray sparseArray = new SparseArray();
            f8519eyqo = sparseArray;
            sparseArray.put(0, wAVar);
            sparseArray.put(1, wAVar2);
            sparseArray.put(2, wAVar3);
            sparseArray.put(3, wAVar4);
            sparseArray.put(4, wAVar5);
            sparseArray.put(5, wAVar6);
            sparseArray.put(6, wAVar7);
            sparseArray.put(7, wAVar8);
            sparseArray.put(8, wAVar9);
            sparseArray.put(9, wAVar10);
            sparseArray.put(10, wAVar11);
            sparseArray.put(11, wAVar12);
            sparseArray.put(12, wAVar13);
            sparseArray.put(13, wAVar14);
            sparseArray.put(14, wAVar15);
            sparseArray.put(15, wAVar16);
            sparseArray.put(16, wAVar17);
            sparseArray.put(17, wAVar18);
            sparseArray.put(-1, wAVar19);
        }

        wA(int i) {
            this.f8527mjFkc = i;
        }

        /* renamed from: KLFTb */
        public static wA m8504KLFTb(int i) {
            return (wA) f8519eyqo.get(i);
        }

        /* renamed from: lgHUyS */
        public int m8507lgHUyS() {
            return this.f8527mjFkc;
        }
    }

    /* renamed from: mjFkc */
    public static mjFkc m8494mjFkc() {
        return new C2820SKTn.AZxh();
    }

    /* renamed from: AZxh */
    public abstract AZxh mo8495AZxh();

    /* renamed from: wA */
    public abstract wA mo8496wA();
}
