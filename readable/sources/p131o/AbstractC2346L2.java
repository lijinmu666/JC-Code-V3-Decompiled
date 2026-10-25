package p131o;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.p017core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.conscrypt.BuildConfig;

/* renamed from: o.L2 */
/* loaded from: classes.dex */
public abstract class AbstractC2346L2 {

    /* renamed from: o.L2$AZxh */
    public static class AZxh extends KLFTb {

        /* renamed from: KLFTb */
        public CharSequence f9296KLFTb;

        @Override // p131o.AbstractC2346L2.KLFTb
        /* renamed from: AZxh */
        public void mo9310AZxh(InterfaceC2279K2 interfaceC2279K2) {
            Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(interfaceC2279K2.mo9117mjFkc()).setBigContentTitle(this.f9297AZxh).bigText(this.f9296KLFTb);
            if (this.f9298ZfxDd) {
                bigTextStyleBigText.setSummaryText(this.f9300wA);
            }
        }

        /* renamed from: lgHUyS */
        public AZxh m9311lgHUyS(CharSequence charSequence) {
            this.f9296KLFTb = ZfxDd.m9318KLFTb(charSequence);
            return this;
        }

        @Override // p131o.AbstractC2346L2.KLFTb
        /* renamed from: mjFkc */
        public void mo9312mjFkc(Bundle bundle) {
            super.mo9312mjFkc(bundle);
        }

        @Override // p131o.AbstractC2346L2.KLFTb
        /* renamed from: wA */
        public String mo9313wA() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }
    }

    /* renamed from: o.L2$KLFTb */
    public static abstract class KLFTb {

        /* renamed from: AZxh */
        public CharSequence f9297AZxh;

        /* renamed from: ZfxDd */
        public boolean f9298ZfxDd = false;

        /* renamed from: mjFkc */
        public ZfxDd f9299mjFkc;

        /* renamed from: wA */
        public CharSequence f9300wA;

        /* renamed from: AZxh */
        public abstract void mo9310AZxh(InterfaceC2279K2 interfaceC2279K2);

        /* renamed from: JHa */
        public RemoteViews m9314JHa(InterfaceC2279K2 interfaceC2279K2) {
            return null;
        }

        /* renamed from: KLFTb */
        public RemoteViews m9315KLFTb(InterfaceC2279K2 interfaceC2279K2) {
            return null;
        }

        /* renamed from: ZfxDd */
        public RemoteViews m9316ZfxDd(InterfaceC2279K2 interfaceC2279K2) {
            return null;
        }

        /* renamed from: mjFkc */
        public void mo9312mjFkc(Bundle bundle) {
            if (this.f9298ZfxDd) {
                bundle.putCharSequence("android.summaryText", this.f9300wA);
            }
            CharSequence charSequence = this.f9297AZxh;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strMo9313wA = mo9313wA();
            if (strMo9313wA != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strMo9313wA);
            }
        }

        /* renamed from: wA */
        public abstract String mo9313wA();

        /* renamed from: xJ */
        public void m9317xJ(ZfxDd zfxDd) {
            if (this.f9299mjFkc != zfxDd) {
                this.f9299mjFkc = zfxDd;
                if (zfxDd != null) {
                    zfxDd.m9322IEE(this);
                }
            }
        }
    }

    /* renamed from: o.L2$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public IconCompat f9348AZxh;

        /* renamed from: Dt */
        public CharSequence f9349Dt;

        /* renamed from: ETF */
        public PendingIntent f9350ETF;

        /* renamed from: JHa */
        public boolean f9351JHa;

        /* renamed from: KLFTb */
        public boolean f9352KLFTb;

        /* renamed from: VA */
        public boolean f9353VA;

        /* renamed from: ZfxDd */
        public final C3925j5[] f9354ZfxDd;

        /* renamed from: lgHUyS */
        public final boolean f9355lgHUyS;

        /* renamed from: mjFkc */
        public final Bundle f9356mjFkc;

        /* renamed from: qdMbNW */
        public int f9357qdMbNW;

        /* renamed from: wA */
        public final C3925j5[] f9358wA;

        /* renamed from: xJ */
        public final int f9359xJ;

        /* renamed from: o.L2$mjFkc$mjFkc, reason: collision with other inner class name */
        public static final class C6359mjFkc {

            /* renamed from: AZxh */
            public final CharSequence f9360AZxh;

            /* renamed from: Dt */
            public boolean f9361Dt;

            /* renamed from: JHa */
            public ArrayList f9362JHa;

            /* renamed from: KLFTb */
            public final Bundle f9363KLFTb;

            /* renamed from: ZfxDd */
            public boolean f9364ZfxDd;

            /* renamed from: lgHUyS */
            public boolean f9365lgHUyS;

            /* renamed from: mjFkc */
            public final IconCompat f9366mjFkc;

            /* renamed from: qdMbNW */
            public boolean f9367qdMbNW;

            /* renamed from: wA */
            public final PendingIntent f9368wA;

            /* renamed from: xJ */
            public int f9369xJ;

            public C6359mjFkc(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i != 0 ? IconCompat.m544mjFkc(null, BuildConfig.f24315FLAVOR, i) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            /* renamed from: AZxh */
            public mjFkc m9349AZxh() {
                m9351wA();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.f9362JHa;
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        C3925j5 c3925j5 = (C3925j5) it.next();
                        if (c3925j5.m12345ETF()) {
                            arrayList.add(c3925j5);
                        } else {
                            arrayList2.add(c3925j5);
                        }
                    }
                }
                return new mjFkc(this.f9366mjFkc, this.f9360AZxh, this.f9368wA, this.f9363KLFTb, arrayList2.isEmpty() ? null : (C3925j5[]) arrayList2.toArray(new C3925j5[arrayList2.size()]), arrayList.isEmpty() ? null : (C3925j5[]) arrayList.toArray(new C3925j5[arrayList.size()]), this.f9364ZfxDd, this.f9369xJ, this.f9365lgHUyS, this.f9367qdMbNW, this.f9361Dt);
            }

            /* renamed from: mjFkc */
            public C6359mjFkc m9350mjFkc(C3925j5 c3925j5) {
                if (this.f9362JHa == null) {
                    this.f9362JHa = new ArrayList();
                }
                if (c3925j5 != null) {
                    this.f9362JHa.add(c3925j5);
                }
                return this;
            }

            /* renamed from: wA */
            public final void m9351wA() {
                if (this.f9367qdMbNW && this.f9368wA == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public C6359mjFkc(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C3925j5[] c3925j5Arr, boolean z, int i, boolean z2, boolean z3, boolean z4) {
                this.f9364ZfxDd = true;
                this.f9365lgHUyS = true;
                this.f9366mjFkc = iconCompat;
                this.f9360AZxh = ZfxDd.m9318KLFTb(charSequence);
                this.f9368wA = pendingIntent;
                this.f9363KLFTb = bundle;
                this.f9362JHa = c3925j5Arr == null ? null : new ArrayList(Arrays.asList(c3925j5Arr));
                this.f9364ZfxDd = z;
                this.f9369xJ = i;
                this.f9365lgHUyS = z2;
                this.f9367qdMbNW = z3;
                this.f9361Dt = z4;
            }
        }

        public mjFkc(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.m544mjFkc(null, BuildConfig.f24315FLAVOR, i) : null, charSequence, pendingIntent);
        }

        /* renamed from: AZxh */
        public boolean m9339AZxh() {
            return this.f9352KLFTb;
        }

        /* renamed from: Dt */
        public boolean m9340Dt() {
            return this.f9355lgHUyS;
        }

        /* renamed from: JHa */
        public int m9341JHa() {
            return this.f9359xJ;
        }

        /* renamed from: KLFTb */
        public C3925j5[] m9342KLFTb() {
            return this.f9358wA;
        }

        /* renamed from: ZfxDd */
        public IconCompat m9343ZfxDd() {
            int i;
            if (this.f9348AZxh == null && (i = this.f9357qdMbNW) != 0) {
                this.f9348AZxh = IconCompat.m544mjFkc(null, BuildConfig.f24315FLAVOR, i);
            }
            return this.f9348AZxh;
        }

        /* renamed from: lgHUyS */
        public CharSequence m9344lgHUyS() {
            return this.f9349Dt;
        }

        /* renamed from: mjFkc */
        public PendingIntent m9345mjFkc() {
            return this.f9350ETF;
        }

        /* renamed from: qdMbNW */
        public boolean m9346qdMbNW() {
            return this.f9353VA;
        }

        /* renamed from: wA */
        public Bundle m9347wA() {
            return this.f9356mjFkc;
        }

        /* renamed from: xJ */
        public boolean m9348xJ() {
            return this.f9351JHa;
        }

        public mjFkc(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        public mjFkc(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, C3925j5[] c3925j5Arr, C3925j5[] c3925j5Arr2, boolean z, int i, boolean z2, boolean z3, boolean z4) {
            this.f9351JHa = true;
            this.f9348AZxh = iconCompat;
            if (iconCompat != null && iconCompat.m549ZfxDd() == 2) {
                this.f9357qdMbNW = iconCompat.m545AZxh();
            }
            this.f9349Dt = ZfxDd.m9318KLFTb(charSequence);
            this.f9350ETF = pendingIntent;
            this.f9356mjFkc = bundle == null ? new Bundle() : bundle;
            this.f9358wA = c3925j5Arr;
            this.f9354ZfxDd = c3925j5Arr2;
            this.f9352KLFTb = z;
            this.f9359xJ = i;
            this.f9351JHa = z2;
            this.f9355lgHUyS = z3;
            this.f9353VA = z4;
        }
    }

    /* renamed from: o.L2$wA */
    public static final class wA {
        /* renamed from: mjFkc */
        public static Notification.BubbleMetadata m9352mjFkc(wA wAVar) {
            return null;
        }
    }

    /* renamed from: mjFkc */
    public static Bundle m9309mjFkc(Notification notification) {
        return notification.extras;
    }

    /* renamed from: o.L2$ZfxDd */
    public static class ZfxDd {

        /* renamed from: AZxh */
        public ArrayList f9301AZxh;

        /* renamed from: BAnRFn */
        public boolean f9302BAnRFn;

        /* renamed from: CqaNbM */
        public RemoteViews f9303CqaNbM;

        /* renamed from: Dt */
        public IconCompat f9304Dt;

        /* renamed from: ETF */
        public CharSequence f9305ETF;

        /* renamed from: GMIER */
        public ArrayList f9306GMIER;

        /* renamed from: Gd */
        public boolean f9307Gd;

        /* renamed from: HGpJ */
        public String f9308HGpJ;

        /* renamed from: IEE */
        public CharSequence f9309IEE;

        /* renamed from: JHa */
        public CharSequence f9310JHa;

        /* renamed from: KLFTb */
        public CharSequence f9311KLFTb;

        /* renamed from: KLMXS */
        public RemoteViews f9312KLMXS;

        /* renamed from: KRTLGT */
        public Object f9313KRTLGT;

        /* renamed from: MiMN */
        public int f9314MiMN;

        /* renamed from: NPj */
        public int f9315NPj;

        /* renamed from: Ne */
        public Notification f9316Ne;

        /* renamed from: OjSQV */
        public int f9317OjSQV;

        /* renamed from: Pq */
        public CharSequence[] f9318Pq;

        /* renamed from: Ucbh */
        public boolean f9319Ucbh;

        /* renamed from: VA */
        public int f9320VA;

        /* renamed from: Vnb */
        public long f9321Vnb;

        /* renamed from: VocHEe */
        public boolean f9322VocHEe;

        /* renamed from: WrLQs */
        public boolean f9323WrLQs;

        /* renamed from: YoKzxo */
        public boolean f9324YoKzxo;

        /* renamed from: ZfxDd */
        public ArrayList f9325ZfxDd;

        /* renamed from: aqHPIZ */
        public Notification f9326aqHPIZ;

        /* renamed from: cMLeY */
        public int f9327cMLeY;

        /* renamed from: diqgf */
        public int f9328diqgf;

        /* renamed from: eyqo */
        public int f9329eyqo;

        /* renamed from: fehf */
        public CharSequence f9330fehf;

        /* renamed from: huTpC */
        public String f9331huTpC;

        /* renamed from: lB */
        public String f9332lB;

        /* renamed from: lgHUyS */
        public PendingIntent f9333lgHUyS;

        /* renamed from: mByQ */
        public int f9334mByQ;

        /* renamed from: mjFkc */
        public Context f9335mjFkc;

        /* renamed from: oCFDzJ */
        public boolean f9336oCFDzJ;

        /* renamed from: qGY */
        public KLFTb f9337qGY;

        /* renamed from: qdMbNW */
        public RemoteViews f9338qdMbNW;

        /* renamed from: rWxwaT */
        public String f9339rWxwaT;

        /* renamed from: rkYL */
        public boolean f9340rkYL;

        /* renamed from: vI */
        public boolean f9341vI;

        /* renamed from: vadzgd */
        public int f9342vadzgd;

        /* renamed from: wA */
        public ArrayList f9343wA;

        /* renamed from: wJVbdd */
        public Bundle f9344wJVbdd;

        /* renamed from: xJ */
        public PendingIntent f9345xJ;

        /* renamed from: xrEuO */
        public RemoteViews f9346xrEuO;

        /* renamed from: zvd */
        public String f9347zvd;

        public ZfxDd(Context context, String str) {
            this.f9301AZxh = new ArrayList();
            this.f9343wA = new ArrayList();
            this.f9325ZfxDd = new ArrayList();
            this.f9324YoKzxo = true;
            this.f9341vI = false;
            this.f9334mByQ = 0;
            this.f9317OjSQV = 0;
            this.f9327cMLeY = 0;
            this.f9315NPj = 0;
            this.f9342vadzgd = 0;
            Notification notification = new Notification();
            this.f9326aqHPIZ = notification;
            this.f9335mjFkc = context;
            this.f9347zvd = str;
            notification.when = System.currentTimeMillis();
            this.f9326aqHPIZ.audioStreamType = -1;
            this.f9314MiMN = 0;
            this.f9306GMIER = new ArrayList();
            this.f9336oCFDzJ = true;
        }

        /* renamed from: KLFTb */
        public static CharSequence m9318KLFTb(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        /* renamed from: AZxh */
        public ZfxDd m9319AZxh(mjFkc mjfkc) {
            if (mjfkc != null) {
                this.f9301AZxh.add(mjfkc);
            }
            return this;
        }

        /* renamed from: Dt */
        public ZfxDd m9320Dt(CharSequence charSequence) {
            this.f9310JHa = m9318KLFTb(charSequence);
            return this;
        }

        /* renamed from: ETF */
        public ZfxDd m9321ETF(CharSequence charSequence) {
            this.f9311KLFTb = m9318KLFTb(charSequence);
            return this;
        }

        /* renamed from: IEE */
        public ZfxDd m9322IEE(KLFTb kLFTb) {
            if (this.f9337qGY != kLFTb) {
                this.f9337qGY = kLFTb;
                if (kLFTb != null) {
                    kLFTb.m9317xJ(this);
                }
            }
            return this;
        }

        /* renamed from: JHa */
        public ZfxDd m9323JHa(boolean z) {
            m9326VA(16, z);
            return this;
        }

        /* renamed from: MiMN */
        public ZfxDd m9324MiMN(boolean z) {
            this.f9341vI = z;
            return this;
        }

        /* renamed from: Pq */
        public ZfxDd m9325Pq(CharSequence charSequence) {
            this.f9326aqHPIZ.tickerText = m9318KLFTb(charSequence);
            return this;
        }

        /* renamed from: VA */
        public final void m9326VA(int i, boolean z) {
            if (z) {
                Notification notification = this.f9326aqHPIZ;
                notification.flags = i | notification.flags;
            } else {
                Notification notification2 = this.f9326aqHPIZ;
                notification2.flags = (~i) & notification2.flags;
            }
        }

        /* renamed from: YoKzxo */
        public ZfxDd m9327YoKzxo(boolean z) {
            m9326VA(2, z);
            return this;
        }

        /* renamed from: ZfxDd */
        public Bundle m9328ZfxDd() {
            if (this.f9344wJVbdd == null) {
                this.f9344wJVbdd = new Bundle();
            }
            return this.f9344wJVbdd;
        }

        /* renamed from: diqgf */
        public ZfxDd m9329diqgf(int i) {
            this.f9317OjSQV = i;
            return this;
        }

        /* renamed from: eyqo */
        public ZfxDd m9330eyqo(long j) {
            this.f9326aqHPIZ.when = j;
            return this;
        }

        /* renamed from: fehf */
        public ZfxDd m9331fehf(int i) {
            this.f9326aqHPIZ.icon = i;
            return this;
        }

        /* renamed from: lgHUyS */
        public ZfxDd m9332lgHUyS(String str) {
            this.f9347zvd = str;
            return this;
        }

        /* renamed from: mjFkc */
        public ZfxDd m9333mjFkc(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f9301AZxh.add(new mjFkc(i, charSequence, pendingIntent));
            return this;
        }

        /* renamed from: qGY */
        public ZfxDd m9334qGY(int i, int i2, boolean z) {
            this.f9328diqgf = i;
            this.f9329eyqo = i2;
            this.f9319Ucbh = z;
            return this;
        }

        /* renamed from: qdMbNW */
        public ZfxDd m9335qdMbNW(PendingIntent pendingIntent) {
            this.f9345xJ = pendingIntent;
            return this;
        }

        /* renamed from: rkYL */
        public ZfxDd m9336rkYL(int i) {
            this.f9314MiMN = i;
            return this;
        }

        /* renamed from: wA */
        public Notification m9337wA() {
            return new C2410M2(this).m9430wA();
        }

        /* renamed from: xJ */
        public ZfxDd m9338xJ(String str) {
            this.f9332lB = str;
            return this;
        }

        public ZfxDd(Context context) {
            this(context, null);
        }
    }
}
