package androidx.fragment.p022app;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.p022app.AbstractC0095lgHUyS;
import androidx.fragment.p022app.AbstractC0097qdMbNW;
import androidx.fragment.p022app.Fragment;
import androidx.lifecycle.AbstractC0112wA;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import p131o.AbstractC3204Y2;
import p131o.AbstractC3346aAlqX;
import p131o.AbstractC3423bL;
import p131o.AbstractC3963jeHSg;
import p131o.AbstractC4793w7;
import p131o.AbstractC4925y4;
import p131o.C1726BxruE;
import p131o.C1833DanUFX;
import p131o.C3435bVfe;
import p131o.C3467bzZHlx;
import p131o.C3762gYa;
import p131o.C3793gy;
import p131o.C3893ia;
import p131o.C4058l1;
import p131o.InterfaceC1898EaLbDP;
import p131o.InterfaceC3669f7;
import p131o.LayoutInflaterFactory2C2723Qs;

/* renamed from: androidx.fragment.app.KLFTb */
/* loaded from: classes.dex */
public abstract class AbstractC0093KLFTb {

    /* renamed from: KLMXS */
    public static boolean f1194KLMXS = true;

    /* renamed from: xrEuO */
    public static boolean f1195xrEuO;

    /* renamed from: AZxh */
    public boolean f1196AZxh;

    /* renamed from: BAnRFn */
    public boolean f1197BAnRFn;

    /* renamed from: Dt */
    public ArrayList f1199Dt;

    /* renamed from: Gd */
    public boolean f1201Gd;

    /* renamed from: HGpJ */
    public boolean f1202HGpJ;

    /* renamed from: IEE */
    public Fragment f1203IEE;

    /* renamed from: Ne */
    public C3467bzZHlx f1207Ne;

    /* renamed from: OjSQV */
    public ArrayList f1208OjSQV;

    /* renamed from: VocHEe */
    public boolean f1212VocHEe;

    /* renamed from: ZfxDd */
    public ArrayList f1214ZfxDd;

    /* renamed from: fehf */
    public Fragment f1217fehf;

    /* renamed from: lB */
    public ArrayList f1219lB;

    /* renamed from: mByQ */
    public ArrayList f1221mByQ;

    /* renamed from: qGY */
    public AbstractC3963jeHSg f1223qGY;

    /* renamed from: vI */
    public boolean f1226vI;

    /* renamed from: wJVbdd */
    public ArrayList f1228wJVbdd;

    /* renamed from: mjFkc */
    public final ArrayList f1222mjFkc = new ArrayList();

    /* renamed from: wA */
    public final C3435bVfe f1227wA = new C3435bVfe();

    /* renamed from: KLFTb */
    public final LayoutInflaterFactory2C2723Qs f1205KLFTb = new LayoutInflaterFactory2C2723Qs(this);

    /* renamed from: JHa */
    public final AbstractC3204Y2 f1204JHa = new mjFkc(false);

    /* renamed from: xJ */
    public final AtomicInteger f1229xJ = new AtomicInteger();

    /* renamed from: lgHUyS */
    public final Map f1220lgHUyS = Collections.synchronizedMap(new HashMap());

    /* renamed from: qdMbNW */
    public final Map f1224qdMbNW = Collections.synchronizedMap(new HashMap());

    /* renamed from: ETF */
    public Map f1200ETF = Collections.synchronizedMap(new HashMap());

    /* renamed from: VA */
    public final AbstractC0097qdMbNW.mjFkc f1211VA = new AZxh();

    /* renamed from: MiMN */
    public final C1833DanUFX f1206MiMN = new C1833DanUFX(this);

    /* renamed from: YoKzxo */
    public final CopyOnWriteArrayList f1213YoKzxo = new CopyOnWriteArrayList();

    /* renamed from: rkYL */
    public int f1225rkYL = -1;

    /* renamed from: Pq */
    public AbstractC3423bL f1209Pq = null;

    /* renamed from: diqgf */
    public AbstractC3423bL f1215diqgf = new wA();

    /* renamed from: eyqo */
    public InterfaceC3669f7 f1216eyqo = null;

    /* renamed from: Ucbh */
    public InterfaceC3669f7 f1210Ucbh = new ZfxDd();

    /* renamed from: huTpC */
    public ArrayDeque f1218huTpC = new ArrayDeque();

    /* renamed from: CqaNbM */
    public Runnable f1198CqaNbM = new KLFTb();

    /* renamed from: androidx.fragment.app.KLFTb$AZxh */
    public class AZxh implements AbstractC0097qdMbNW.mjFkc {
        public AZxh() {
        }
    }

    /* renamed from: androidx.fragment.app.KLFTb$Dt */
    public static class Dt implements Fragment.InterfaceC0089ZfxDd {

        /* renamed from: AZxh */
        public final C0096mjFkc f1231AZxh;

        /* renamed from: mjFkc */
        public final boolean f1232mjFkc;

        /* renamed from: wA */
        public int f1233wA;

        public Dt(C0096mjFkc c0096mjFkc, boolean z) {
            this.f1232mjFkc = z;
            this.f1231AZxh = c0096mjFkc;
        }

        /* renamed from: AZxh */
        public void m946AZxh() {
            C0096mjFkc c0096mjFkc = this.f1231AZxh;
            c0096mjFkc.f1282diqgf.m927qGY(c0096mjFkc, this.f1232mjFkc, false, false);
        }

        /* renamed from: ZfxDd */
        public boolean m947ZfxDd() {
            return this.f1233wA == 0;
        }

        @Override // androidx.fragment.p022app.Fragment.InterfaceC0089ZfxDd
        /* renamed from: mjFkc */
        public void mo851mjFkc() {
            this.f1233wA++;
        }

        /* renamed from: wA */
        public void m948wA() {
            boolean z = this.f1233wA > 0;
            for (Fragment fragment : this.f1231AZxh.f1282diqgf.m874JrJO()) {
                fragment.m814giT(null);
                if (z && fragment.m803aqHPIZ()) {
                    fragment.m811fLidf();
                }
            }
            C0096mjFkc c0096mjFkc = this.f1231AZxh;
            c0096mjFkc.f1282diqgf.m927qGY(c0096mjFkc, this.f1232mjFkc, !z, true);
        }
    }

    /* renamed from: androidx.fragment.app.KLFTb$JHa */
    public class JHa implements InterfaceC1898EaLbDP {

        /* renamed from: mjFkc */
        public final /* synthetic */ Fragment f1235mjFkc;

        public JHa(Fragment fragment) {
            this.f1235mjFkc = fragment;
        }
    }

    /* renamed from: androidx.fragment.app.KLFTb$KLFTb */
    public class KLFTb implements Runnable {
        public KLFTb() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AbstractC0093KLFTb.this.m945zvd(true);
        }
    }

    /* renamed from: androidx.fragment.app.KLFTb$ZfxDd */
    public class ZfxDd implements InterfaceC3669f7 {
        public ZfxDd() {
        }

        @Override // p131o.InterfaceC3669f7
        /* renamed from: mjFkc */
        public AbstractC0086Dt mo949mjFkc(ViewGroup viewGroup) {
            return new C0098wA(viewGroup);
        }
    }

    /* renamed from: androidx.fragment.app.KLFTb$lgHUyS */
    public interface lgHUyS {
        /* renamed from: mjFkc */
        boolean mo950mjFkc(ArrayList arrayList, ArrayList arrayList2);
    }

    /* renamed from: androidx.fragment.app.KLFTb$mjFkc */
    public class mjFkc extends AbstractC3204Y2 {
        public mjFkc(boolean z) {
            super(z);
        }
    }

    /* renamed from: androidx.fragment.app.KLFTb$qdMbNW */
    public class qdMbNW implements lgHUyS {

        /* renamed from: AZxh */
        public final int f1239AZxh;

        /* renamed from: mjFkc */
        public final String f1241mjFkc;

        /* renamed from: wA */
        public final int f1242wA;

        public qdMbNW(String str, int i, int i2) {
            this.f1241mjFkc = str;
            this.f1239AZxh = i;
            this.f1242wA = i2;
        }

        @Override // androidx.fragment.p022app.AbstractC0093KLFTb.lgHUyS
        /* renamed from: mjFkc */
        public boolean mo950mjFkc(ArrayList arrayList, ArrayList arrayList2) {
            Fragment fragment = AbstractC0093KLFTb.this.f1203IEE;
            if (fragment == null || this.f1239AZxh >= 0 || this.f1241mjFkc != null || !fragment.m777MiMN().m943yX()) {
                return AbstractC0093KLFTb.this.m878LREOK(arrayList, arrayList2, this.f1241mjFkc, this.f1239AZxh, this.f1242wA);
            }
            return false;
        }
    }

    /* renamed from: androidx.fragment.app.KLFTb$wA */
    public class wA extends AbstractC3423bL {
        public wA() {
        }

        @Override // p131o.AbstractC3423bL
        /* renamed from: mjFkc */
        public Fragment mo951mjFkc(ClassLoader classLoader, String str) {
            AbstractC0093KLFTb.this.m925nxI();
            AbstractC0093KLFTb.this.m925nxI();
            throw null;
        }
    }

    /* renamed from: androidx.fragment.app.KLFTb$xJ */
    public static class xJ implements Parcelable {

        /* renamed from: CREATOR */
        public static final Parcelable.Creator<xJ> f1244CREATOR = new mjFkc();

        /* renamed from: AZxh */
        public int f1245AZxh;

        /* renamed from: mjFkc */
        public String f1246mjFkc;

        /* renamed from: androidx.fragment.app.KLFTb$xJ$mjFkc */
        public class mjFkc implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
            public xJ[] newArray(int i) {
                return new xJ[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
            public xJ createFromParcel(Parcel parcel) {
                return new xJ(parcel);
            }
        }

        public xJ(Parcel parcel) {
            this.f1246mjFkc = parcel.readString();
            this.f1245AZxh = parcel.readInt();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f1246mjFkc);
            parcel.writeInt(this.f1245AZxh);
        }
    }

    /* renamed from: JBhc */
    public static Fragment m856JBhc(View view) {
        Object tag = view.getTag(AbstractC4925y4.f17475mjFkc);
        if (tag instanceof Fragment) {
            return (Fragment) tag;
        }
        return null;
    }

    /* renamed from: dm */
    public static boolean m857dm(int i) {
        return f1195xrEuO || Log.isLoggable("FragmentManager", i);
    }

    /* renamed from: rWxwaT */
    public static void m859rWxwaT(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        while (i < i2) {
            C0096mjFkc c0096mjFkc = (C0096mjFkc) arrayList.get(i);
            if (((Boolean) arrayList2.get(i)).booleanValue()) {
                c0096mjFkc.m983rkYL(-1);
                c0096mjFkc.m977diqgf(i == i2 + (-1));
            } else {
                c0096mjFkc.m983rkYL(1);
                c0096mjFkc.m974Pq();
            }
            i++;
        }
    }

    /* renamed from: uH */
    public static int m860uH(int i) {
        if (i == 4097) {
            return 8194;
        }
        if (i != 4099) {
            return i != 8194 ? 0 : 4097;
        }
        return 4099;
    }

    /* renamed from: ANMGZc */
    public void m861ANMGZc(Fragment fragment) {
        if (fragment.f1109Dt && m932tQ(fragment)) {
            this.f1201Gd = true;
        }
    }

    /* renamed from: BAnRFn */
    public void m862BAnRFn() {
        this.f1202HGpJ = false;
        this.f1226vI = false;
        this.f1207Ne.m11585qdMbNW(false);
        m939wJVbdd(7);
    }

    /* renamed from: CqaNbM */
    public final void m863CqaNbM() {
        if (f1194KLMXS) {
            Iterator it = m903YoKzxo().iterator();
            while (it.hasNext()) {
                ((AbstractC0086Dt) it.next()).m724Dt();
            }
        } else {
            if (this.f1200ETF.isEmpty()) {
                return;
            }
            for (Fragment fragment : this.f1200ETF.keySet()) {
                m865ETF(fragment);
                m887SOS(fragment);
            }
        }
    }

    /* renamed from: Dt */
    public AbstractC0095lgHUyS m864Dt() {
        return new C0096mjFkc(this);
    }

    /* renamed from: ETF */
    public final void m865ETF(Fragment fragment) {
        HashSet hashSet = (HashSet) this.f1200ETF.get(fragment);
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                ((C1726BxruE) it.next()).m7741mjFkc();
            }
            hashSet.clear();
            m885Pq(fragment);
            this.f1200ETF.remove(fragment);
        }
    }

    /* renamed from: GMIER */
    public final C3467bzZHlx m866GMIER(Fragment fragment) {
        return this.f1207Ne.m11581KLFTb(fragment);
    }

    /* renamed from: Gd */
    public void m867Gd() {
        m939wJVbdd(1);
    }

    /* renamed from: HGpJ */
    public final void m868HGpJ(Fragment fragment) {
        if (fragment == null || !fragment.m808equals(m936vadzgd(fragment.f1117KLFTb))) {
            return;
        }
        fragment.m815gtIJp();
    }

    /* renamed from: IEE */
    public C0099xJ m869IEE(Fragment fragment) {
        C0099xJ c0099xJM11506ETF = this.f1227wA.m11506ETF(fragment.f1117KLFTb);
        if (c0099xJM11506ETF != null) {
            return c0099xJM11506ETF;
        }
        new C0099xJ(this.f1206MiMN, this.f1227wA, fragment);
        throw null;
    }

    /* renamed from: IVlxe */
    public final void m870IVlxe(C3762gYa c3762gYa) {
        int size = c3762gYa.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = (Fragment) c3762gYa.m11997ETF(i);
            if (!fragment.f1109Dt) {
                View viewM799XbiWeM = fragment.m799XbiWeM();
                fragment.f1133cMLeY = viewM799XbiWeM.getAlpha();
                viewM799XbiWeM.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: JHa */
    public void m871JHa(InterfaceC1898EaLbDP interfaceC1898EaLbDP) {
        this.f1213YoKzxo.add(interfaceC1898EaLbDP);
    }

    /* renamed from: JYgkl */
    public AbstractC3423bL m872JYgkl() {
        AbstractC3423bL abstractC3423bL = this.f1209Pq;
        if (abstractC3423bL != null) {
            return abstractC3423bL;
        }
        Fragment fragment = this.f1217fehf;
        return fragment != null ? fragment.f1136fehf.m872JYgkl() : this.f1215diqgf;
    }

    /* renamed from: JYn */
    public final ViewGroup m873JYn(Fragment fragment) {
        ViewGroup viewGroup = fragment.f1151wJVbdd;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (fragment.f1135eyqo > 0 && this.f1223qGY.mo849AZxh()) {
            View viewMo850mjFkc = this.f1223qGY.mo850mjFkc(fragment.f1135eyqo);
            if (viewMo850mjFkc instanceof ViewGroup) {
                return (ViewGroup) viewMo850mjFkc;
            }
        }
        return null;
    }

    /* renamed from: JrJO */
    public List m874JrJO() {
        return this.f1227wA.m11512VA();
    }

    /* renamed from: KLFTb */
    public C0099xJ m875KLFTb(Fragment fragment) {
        if (m857dm(2)) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        C0099xJ c0099xJM869IEE = m869IEE(fragment);
        fragment.f1136fehf = this;
        this.f1227wA.m11513YoKzxo(c0099xJM869IEE);
        if (!fragment.f1112Gd) {
            this.f1227wA.m11518mjFkc(fragment);
            fragment.f1110ETF = false;
            if (fragment.f1140mByQ == null) {
                fragment.f1154zvd = false;
            }
            if (m932tQ(fragment)) {
                this.f1201Gd = true;
            }
        }
        return c0099xJM869IEE;
    }

    /* renamed from: KLMXS */
    public final void m876KLMXS(boolean z) {
        if (this.f1196AZxh) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (!this.f1212VocHEe) {
            throw new IllegalStateException("FragmentManager has not been attached to a host.");
        }
        throw new IllegalStateException("FragmentManager has been destroyed");
    }

    /* renamed from: KRTLGT */
    public int m877KRTLGT() {
        ArrayList arrayList = this.f1214ZfxDd;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: LREOK */
    public boolean m878LREOK(ArrayList arrayList, ArrayList arrayList2, String str, int i, int i2) {
        int i3;
        ArrayList arrayList3 = this.f1214ZfxDd;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size = arrayList3.size() - 1;
            if (size < 0) {
                return false;
            }
            arrayList.add(this.f1214ZfxDd.remove(size));
            arrayList2.add(Boolean.TRUE);
        } else {
            if (str != null || i >= 0) {
                int size2 = arrayList3.size() - 1;
                while (size2 >= 0) {
                    C0096mjFkc c0096mjFkc = (C0096mjFkc) this.f1214ZfxDd.get(size2);
                    if ((str != null && str.equals(c0096mjFkc.m975Ucbh())) || (i >= 0 && i == c0096mjFkc.f1281Ucbh)) {
                        break;
                    }
                    size2--;
                }
                if (size2 < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        C0096mjFkc c0096mjFkc2 = (C0096mjFkc) this.f1214ZfxDd.get(size2);
                        if (str == null || !str.equals(c0096mjFkc2.m975Ucbh())) {
                            if (i < 0 || i != c0096mjFkc2.f1281Ucbh) {
                                break;
                            }
                        }
                    }
                }
                i3 = size2;
            } else {
                i3 = -1;
            }
            if (i3 == this.f1214ZfxDd.size() - 1) {
                return false;
            }
            for (int size3 = this.f1214ZfxDd.size() - 1; size3 > i3; size3--) {
                arrayList.add(this.f1214ZfxDd.remove(size3));
                arrayList2.add(Boolean.TRUE);
            }
        }
        return true;
    }

    /* renamed from: MiMN */
    public final void m879MiMN() {
        this.f1196AZxh = false;
        this.f1228wJVbdd.clear();
        this.f1219lB.clear();
    }

    /* renamed from: Moer */
    public void m880Moer(Fragment fragment) {
        if (!this.f1227wA.m11522wA(fragment.f1117KLFTb)) {
            if (m857dm(3)) {
                Log.d("FragmentManager", "Ignoring moving " + fragment + " to state " + this.f1225rkYL + "since it is not added to " + this);
                return;
            }
            return;
        }
        m887SOS(fragment);
        View view = fragment.f1140mByQ;
        if (view == null || !fragment.f1118KLMXS || fragment.f1151wJVbdd == null) {
            if (fragment.f1154zvd) {
                m912fehf(fragment);
            }
        } else {
            float f = fragment.f1133cMLeY;
            if (f > 0.0f) {
                view.setAlpha(f);
            }
            fragment.f1133cMLeY = 0.0f;
            fragment.f1118KLMXS = false;
            throw null;
        }
    }

    /* renamed from: NKyg */
    public void m881NKyg() {
    }

    /* renamed from: NPj */
    public final void m882NPj(ArrayList arrayList, ArrayList arrayList2) {
        int iIndexOf;
        int iIndexOf2;
        ArrayList arrayList3 = this.f1208OjSQV;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            Dt dt = (Dt) this.f1208OjSQV.get(i);
            if (arrayList != null && !dt.f1232mjFkc && (iIndexOf2 = arrayList.indexOf(dt.f1231AZxh)) != -1 && arrayList2 != null && ((Boolean) arrayList2.get(iIndexOf2)).booleanValue()) {
                this.f1208OjSQV.remove(i);
                i--;
                size--;
                dt.m946AZxh();
            } else if (dt.m947ZfxDd() || (arrayList != null && dt.f1231AZxh.m972Gd(arrayList, 0, arrayList.size()))) {
                this.f1208OjSQV.remove(i);
                i--;
                size--;
                if (arrayList == null || dt.f1232mjFkc || (iIndexOf = arrayList.indexOf(dt.f1231AZxh)) == -1 || arrayList2 == null || !((Boolean) arrayList2.get(iIndexOf)).booleanValue()) {
                    dt.m948wA();
                } else {
                    dt.m946AZxh();
                }
            }
            i++;
        }
    }

    /* renamed from: Ne */
    public final void m883Ne() {
        if (this.f1197BAnRFn) {
            this.f1197BAnRFn = false;
            m898XD();
        }
    }

    /* renamed from: OjSQV */
    public void m884OjSQV() {
        m939wJVbdd(2);
    }

    /* renamed from: Pq */
    public final void m885Pq(Fragment fragment) {
        fragment.m786SmIWf();
        this.f1206MiMN.m8028VA(fragment, false);
        fragment.f1151wJVbdd = null;
        fragment.f1140mByQ = null;
        fragment.f1142oCFDzJ = null;
        fragment.f1132aqHPIZ.mo1060lgHUyS(null);
        fragment.f1120MiMN = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x013f  */
    /* renamed from: Qr */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m886Qr(Fragment fragment, int i) {
        ViewGroup viewGroup;
        C0099xJ c0099xJM11506ETF = this.f1227wA.m11506ETF(fragment.f1117KLFTb);
        int i2 = 1;
        if (c0099xJM11506ETF == null) {
            c0099xJM11506ETF = new C0099xJ(this.f1206MiMN, this.f1227wA, fragment);
            c0099xJM11506ETF.m1017fehf(1);
        }
        if (fragment.f1126VA && fragment.f1120MiMN && fragment.f1141mjFkc == 2) {
            i = Math.max(i, 2);
        }
        int iMin = Math.min(i, c0099xJM11506ETF.m1016ZfxDd());
        int i3 = fragment.f1141mjFkc;
        if (i3 <= iMin) {
            if (i3 < iMin && !this.f1200ETF.isEmpty()) {
                m865ETF(fragment);
            }
            int i4 = fragment.f1141mjFkc;
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 4) {
                                if (i4 == 5) {
                                }
                            }
                            if (iMin > 5) {
                                c0099xJM11506ETF.m1022rkYL();
                            }
                        }
                        if (iMin > 4) {
                            c0099xJM11506ETF.m1009IEE();
                        }
                        if (iMin > 5) {
                        }
                    }
                    if (iMin > 2) {
                        c0099xJM11506ETF.m1019mjFkc();
                    }
                    if (iMin > 4) {
                    }
                    if (iMin > 5) {
                    }
                }
                if (iMin > -1) {
                    c0099xJM11506ETF.m1007Dt();
                }
                if (iMin > 1) {
                    c0099xJM11506ETF.m1010JHa();
                }
                if (iMin > 2) {
                }
                if (iMin > 4) {
                }
                if (iMin > 5) {
                }
            } else if (iMin > -1) {
                c0099xJM11506ETF.m1023wA();
            }
            if (iMin > 0) {
                c0099xJM11506ETF.m1011KLFTb();
            }
            if (iMin > -1) {
            }
            if (iMin > 1) {
            }
            if (iMin > 2) {
            }
            if (iMin > 4) {
            }
            if (iMin > 5) {
            }
        } else if (i3 > iMin) {
            if (i3 == 0) {
                i2 = iMin;
                if (i2 < 0) {
                    c0099xJM11506ETF.m1021qdMbNW();
                }
                iMin = i2;
            } else {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 == 7) {
                                    if (iMin < 7) {
                                        c0099xJM11506ETF.m1015YoKzxo();
                                    }
                                }
                            }
                            if (iMin < 5) {
                                c0099xJM11506ETF.m1013Pq();
                            }
                        }
                        if (iMin < 4) {
                            if (m857dm(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + fragment);
                            }
                            if (fragment.f1140mByQ != null) {
                                throw null;
                            }
                        }
                    }
                    if (iMin < 2) {
                        View view = fragment.f1140mByQ;
                        if (view != null && (viewGroup = fragment.f1151wJVbdd) != null) {
                            viewGroup.endViewTransition(view);
                            fragment.f1140mByQ.clearAnimation();
                            if (!fragment.m775KRTLGT()) {
                                if (this.f1225rkYL > -1 && !this.f1212VocHEe && fragment.f1140mByQ.getVisibility() == 0 && fragment.f1133cMLeY >= 0.0f) {
                                    throw null;
                                }
                                fragment.f1133cMLeY = 0.0f;
                                ViewGroup viewGroup2 = fragment.f1151wJVbdd;
                                View view2 = fragment.f1140mByQ;
                                viewGroup2.removeView(view2);
                                if (m857dm(2)) {
                                    Log.v("FragmentManager", "Removing view " + view2 + " for fragment " + fragment + " from container " + viewGroup2);
                                }
                                if (viewGroup2 != fragment.f1151wJVbdd) {
                                    return;
                                }
                            }
                        }
                        if (this.f1200ETF.get(fragment) == null) {
                            c0099xJM11506ETF.m1018lgHUyS();
                        }
                    }
                }
                if (iMin < 1) {
                    if (this.f1200ETF.get(fragment) == null) {
                        c0099xJM11506ETF.m1024xJ();
                        i2 = iMin;
                    }
                    if (i2 < 0) {
                    }
                    iMin = i2;
                }
            }
        }
        if (fragment.f1141mjFkc != iMin) {
            if (m857dm(3)) {
                Log.d("FragmentManager", "moveToState: Fragment state for " + fragment + " not updated inline; expected state " + iMin + " found " + fragment.f1141mjFkc);
            }
            fragment.f1141mjFkc = iMin;
        }
    }

    /* renamed from: SOS */
    public void m887SOS(Fragment fragment) {
        m886Qr(fragment, this.f1225rkYL);
    }

    /* renamed from: SmIWf */
    public void m888SmIWf(int i, boolean z) {
        if (i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f1225rkYL) {
            this.f1225rkYL = i;
            if (f1194KLMXS) {
                this.f1227wA.m11519qGY();
            } else {
                Iterator it = this.f1227wA.m11512VA().iterator();
                while (it.hasNext()) {
                    m880Moer((Fragment) it.next());
                }
                for (C0099xJ c0099xJ : this.f1227wA.m11520qdMbNW()) {
                    Fragment fragmentM1008ETF = c0099xJ.m1008ETF();
                    if (!fragmentM1008ETF.f1118KLMXS) {
                        m880Moer(fragmentM1008ETF);
                    }
                    if (fragmentM1008ETF.f1110ETF && !fragmentM1008ETF.m827oCFDzJ()) {
                        this.f1227wA.m11521rkYL(c0099xJ);
                    }
                }
            }
            m898XD();
        }
    }

    /* renamed from: SwgkN */
    public InterfaceC3669f7 m889SwgkN() {
        InterfaceC3669f7 interfaceC3669f7 = this.f1216eyqo;
        if (interfaceC3669f7 != null) {
            return interfaceC3669f7;
        }
        Fragment fragment = this.f1217fehf;
        return fragment != null ? fragment.f1136fehf.m889SwgkN() : this.f1210Ucbh;
    }

    /* renamed from: Ucbh */
    public void m890Ucbh() {
        this.f1202HGpJ = false;
        this.f1226vI = false;
        this.f1207Ne.m11585qdMbNW(false);
        m939wJVbdd(1);
    }

    /* renamed from: VA */
    public boolean m891VA() {
        boolean zM932tQ = false;
        for (Fragment fragment : this.f1227wA.m11505Dt()) {
            if (fragment != null) {
                zM932tQ = m932tQ(fragment);
            }
            if (zM932tQ) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Vdz */
    public C3893ia m892Vdz(Fragment fragment) {
        return this.f1207Ne.m11587xJ(fragment);
    }

    /* renamed from: Vgyli */
    public void m893Vgyli(Fragment fragment, AbstractC0112wA.AZxh aZxh) {
        if (fragment.m808equals(m936vadzgd(fragment.f1117KLFTb))) {
            fragment.f1121NPj = aZxh;
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: Vnb */
    public final void m894Vnb(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        int iM911fFz;
        int i3 = i;
        boolean z = ((C0096mjFkc) arrayList.get(i3)).f1257IEE;
        ArrayList arrayList3 = this.f1221mByQ;
        if (arrayList3 == null) {
            this.f1221mByQ = new ArrayList();
        } else {
            arrayList3.clear();
        }
        this.f1221mByQ.addAll(this.f1227wA.m11512VA());
        Fragment fragmentM907bbzow = m907bbzow();
        boolean z2 = false;
        for (int i4 = i3; i4 < i2; i4++) {
            C0096mjFkc c0096mjFkc = (C0096mjFkc) arrayList.get(i4);
            fragmentM907bbzow = !((Boolean) arrayList2.get(i4)).booleanValue() ? c0096mjFkc.m978eyqo(this.f1221mByQ, fragmentM907bbzow) : c0096mjFkc.m981lB(this.f1221mByQ, fragmentM907bbzow);
            z2 = z2 || c0096mjFkc.f1269qdMbNW;
        }
        this.f1221mByQ.clear();
        if (!z && this.f1225rkYL >= 1) {
            if (!f1194KLMXS) {
                throw null;
            }
            for (int i5 = i3; i5 < i2; i5++) {
                Iterator it = ((C0096mjFkc) arrayList.get(i5)).f1271wA.iterator();
                while (it.hasNext()) {
                    Fragment fragment = ((AbstractC0095lgHUyS.mjFkc) it.next()).f1273AZxh;
                    if (fragment != null && fragment.f1136fehf != null) {
                        this.f1227wA.m11513YoKzxo(m869IEE(fragment));
                    }
                }
            }
        }
        m859rWxwaT(arrayList, arrayList2, i, i2);
        if (f1194KLMXS) {
            boolean zBooleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
            for (int i6 = i3; i6 < i2; i6++) {
                C0096mjFkc c0096mjFkc2 = (C0096mjFkc) arrayList.get(i6);
                if (zBooleanValue) {
                    for (int size = c0096mjFkc2.f1271wA.size() - 1; size >= 0; size--) {
                        Fragment fragment2 = ((AbstractC0095lgHUyS.mjFkc) c0096mjFkc2.f1271wA.get(size)).f1273AZxh;
                        if (fragment2 != null) {
                            m869IEE(fragment2).m1012MiMN();
                        }
                    }
                } else {
                    Iterator it2 = c0096mjFkc2.f1271wA.iterator();
                    while (it2.hasNext()) {
                        Fragment fragment3 = ((AbstractC0095lgHUyS.mjFkc) it2.next()).f1273AZxh;
                        if (fragment3 != null) {
                            m869IEE(fragment3).m1012MiMN();
                        }
                    }
                }
            }
            m888SmIWf(this.f1225rkYL, true);
            for (AbstractC0086Dt abstractC0086Dt : m929rkYL(arrayList, i3, i2)) {
                abstractC0086Dt.m730fehf(zBooleanValue);
                abstractC0086Dt.m735rkYL();
                abstractC0086Dt.m737xJ();
            }
        } else {
            if (z) {
                C3762gYa c3762gYa = new C3762gYa();
                m938wA(c3762gYa);
                iM911fFz = m911fFz(arrayList, arrayList2, i, i2, c3762gYa);
                m870IVlxe(c3762gYa);
            } else {
                iM911fFz = i2;
            }
            if (iM911fFz != i3 && z) {
                int i7 = this.f1225rkYL;
                if (i7 >= 1) {
                    throw null;
                }
                m888SmIWf(i7, true);
            }
        }
        while (i3 < i2) {
            C0096mjFkc c0096mjFkc3 = (C0096mjFkc) arrayList.get(i3);
            if (((Boolean) arrayList2.get(i3)).booleanValue() && c0096mjFkc3.f1281Ucbh >= 0) {
                c0096mjFkc3.f1281Ucbh = -1;
            }
            c0096mjFkc3.m976VocHEe();
            i3++;
        }
        if (z2) {
            m902XtE();
        }
    }

    /* renamed from: VocHEe */
    public void m895VocHEe() {
        m916gtr();
        m868HGpJ(this.f1203IEE);
    }

    /* renamed from: WGXroI */
    public C1833DanUFX m896WGXroI() {
        return this.f1206MiMN;
    }

    /* renamed from: WrLQs */
    public final boolean m897WrLQs(ArrayList arrayList, ArrayList arrayList2) {
        synchronized (this.f1222mjFkc) {
            try {
                if (!this.f1222mjFkc.isEmpty()) {
                    int size = this.f1222mjFkc.size();
                    for (int i = 0; i < size; i++) {
                        ((lgHUyS) this.f1222mjFkc.get(i)).mo950mjFkc(arrayList, arrayList2);
                    }
                    this.f1222mjFkc.clear();
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return false;
    }

    /* renamed from: XD */
    public final void m898XD() {
        Iterator it = this.f1227wA.m11520qdMbNW().iterator();
        while (it.hasNext()) {
            m920kism((C0099xJ) it.next());
        }
    }

    /* renamed from: XFUzSY */
    public final void m899XFUzSY(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        m882NPj(arrayList, arrayList2);
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((C0096mjFkc) arrayList.get(i)).f1257IEE) {
                if (i2 != i) {
                    m894Vnb(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((C0096mjFkc) arrayList.get(i2)).f1257IEE) {
                        i2++;
                    }
                }
                m894Vnb(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            m894Vnb(arrayList, arrayList2, i2, size);
        }
    }

    /* renamed from: XV */
    public Fragment m900XV() {
        return this.f1217fehf;
    }

    /* renamed from: XbiWeM */
    public void m901XbiWeM(Fragment fragment) {
        if (m857dm(2)) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f1143qGY);
        }
        boolean zM827oCFDzJ = fragment.m827oCFDzJ();
        if (fragment.f1112Gd && zM827oCFDzJ) {
            return;
        }
        this.f1227wA.m11516fehf(fragment);
        if (m932tQ(fragment)) {
            this.f1201Gd = true;
        }
        fragment.f1110ETF = true;
        m914giT(fragment);
    }

    /* renamed from: XtE */
    public final void m902XtE() {
        ArrayList arrayList = this.f1199Dt;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        AbstractC4793w7.m13819mjFkc(this.f1199Dt.get(0));
        throw null;
    }

    /* renamed from: YoKzxo */
    public final Set m903YoKzxo() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f1227wA.m11520qdMbNW().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((C0099xJ) it.next()).m1008ETF().f1151wJVbdd;
            if (viewGroup != null) {
                hashSet.add(AbstractC0086Dt.m722YoKzxo(viewGroup, m889SwgkN()));
            }
        }
        return hashSet;
    }

    /* renamed from: ZfxDd */
    public void m904ZfxDd(C0096mjFkc c0096mjFkc) {
        if (this.f1214ZfxDd == null) {
            this.f1214ZfxDd = new ArrayList();
        }
        this.f1214ZfxDd.add(c0096mjFkc);
    }

    /* renamed from: alEkx */
    public boolean m905alEkx() {
        return this.f1212VocHEe;
    }

    /* renamed from: aqHPIZ */
    public Fragment m906aqHPIZ(String str) {
        return this.f1227wA.m11523xJ(str);
    }

    /* renamed from: bbzow */
    public Fragment m907bbzow() {
        return this.f1203IEE;
    }

    /* renamed from: cMLeY */
    public void m908cMLeY(lgHUyS lghuys, boolean z) {
        if (z) {
            return;
        }
        m876KLMXS(z);
        if (lghuys.mo950mjFkc(this.f1219lB, this.f1228wJVbdd)) {
            this.f1196AZxh = true;
            try {
                m899XFUzSY(this.f1219lB, this.f1228wJVbdd);
            } finally {
                m879MiMN();
            }
        }
        m916gtr();
        m883Ne();
        this.f1227wA.m11504AZxh();
    }

    /* renamed from: diqgf */
    public void m909diqgf(Fragment fragment) {
        if (m857dm(2)) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.f1112Gd) {
            return;
        }
        fragment.f1112Gd = true;
        if (fragment.f1109Dt) {
            if (m857dm(2)) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            this.f1227wA.m11516fehf(fragment);
            if (m932tQ(fragment)) {
                this.f1201Gd = true;
            }
            m914giT(fragment);
        }
    }

    /* renamed from: eyqo */
    public void m910eyqo() {
        this.f1202HGpJ = false;
        this.f1226vI = false;
        this.f1207Ne.m11585qdMbNW(false);
        m939wJVbdd(4);
    }

    /* renamed from: fFz */
    public final int m911fFz(ArrayList arrayList, ArrayList arrayList2, int i, int i2, C3762gYa c3762gYa) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            C0096mjFkc c0096mjFkc = (C0096mjFkc) arrayList.get(i4);
            boolean zBooleanValue = ((Boolean) arrayList2.get(i4)).booleanValue();
            if (c0096mjFkc.m984vI() && !c0096mjFkc.m972Gd(arrayList, i4 + 1, i2)) {
                if (this.f1208OjSQV == null) {
                    this.f1208OjSQV = new ArrayList();
                }
                Dt dt = new Dt(c0096mjFkc, zBooleanValue);
                this.f1208OjSQV.add(dt);
                c0096mjFkc.m971BAnRFn(dt);
                if (zBooleanValue) {
                    c0096mjFkc.m974Pq();
                } else {
                    c0096mjFkc.m977diqgf(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, c0096mjFkc);
                }
                m938wA(c3762gYa);
            }
        }
        return i3;
    }

    /* renamed from: fehf */
    public final void m912fehf(Fragment fragment) {
        if (fragment.f1140mByQ != null) {
            throw null;
        }
        m861ANMGZc(fragment);
        fragment.f1154zvd = false;
        fragment.m787SwgkN(fragment.f1137huTpC);
    }

    /* renamed from: gYa */
    public final boolean m913gYa(String str, int i, int i2) {
        m945zvd(false);
        m876KLMXS(true);
        Fragment fragment = this.f1203IEE;
        if (fragment != null && i < 0 && str == null && fragment.m777MiMN().m943yX()) {
            return true;
        }
        boolean zM878LREOK = m878LREOK(this.f1219lB, this.f1228wJVbdd, str, i, i2);
        if (zM878LREOK) {
            this.f1196AZxh = true;
            try {
                m899XFUzSY(this.f1219lB, this.f1228wJVbdd);
            } finally {
                m879MiMN();
            }
        }
        m916gtr();
        m883Ne();
        this.f1227wA.m11504AZxh();
        return zM878LREOK;
    }

    /* renamed from: giT */
    public final void m914giT(Fragment fragment) {
        ViewGroup viewGroupM873JYn = m873JYn(fragment);
        if (viewGroupM873JYn == null || fragment.m831rkYL() + fragment.m767IEE() + fragment.m759BAnRFn() + fragment.m821lB() <= 0) {
            return;
        }
        if (viewGroupM873JYn.getTag(AbstractC4925y4.f17476wA) == null) {
            viewGroupM873JYn.setTag(AbstractC4925y4.f17476wA, fragment);
        }
        ((Fragment) viewGroupM873JYn.getTag(AbstractC4925y4.f17476wA)).m832sRqPfw(fragment.m793VocHEe());
    }

    /* renamed from: gtIJp */
    public void m915gtIJp(FragmentContainerView fragmentContainerView) {
        View view;
        for (C0099xJ c0099xJ : this.f1227wA.m11520qdMbNW()) {
            Fragment fragmentM1008ETF = c0099xJ.m1008ETF();
            if (fragmentM1008ETF.f1135eyqo == fragmentContainerView.getId() && (view = fragmentM1008ETF.f1140mByQ) != null && view.getParent() == null) {
                fragmentM1008ETF.f1151wJVbdd = fragmentContainerView;
                c0099xJ.m1006AZxh();
            }
        }
    }

    /* renamed from: gtr */
    public final void m916gtr() {
        synchronized (this.f1222mjFkc) {
            try {
                if (this.f1222mjFkc.isEmpty()) {
                    this.f1204JHa.m11043AZxh(m877KRTLGT() > 0 && m944yfx(this.f1217fehf));
                } else {
                    this.f1204JHa.m11043AZxh(true);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: huTpC */
    public void m917huTpC() {
        this.f1212VocHEe = true;
        m945zvd(true);
        m863CqaNbM();
        m939wJVbdd(-1);
        this.f1223qGY = null;
        this.f1217fehf = null;
    }

    /* renamed from: jm */
    public void m918jm(Fragment fragment) {
        if (m857dm(2)) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.f1137huTpC) {
            return;
        }
        fragment.f1137huTpC = true;
        fragment.f1154zvd = true ^ fragment.f1154zvd;
        m914giT(fragment);
    }

    /* renamed from: jx */
    public void m919jx(Parcelable parcelable) {
        if (parcelable == null) {
            return;
        }
        C0092JHa c0092JHa = (C0092JHa) parcelable;
        if (c0092JHa.f1191mjFkc == null) {
            return;
        }
        this.f1227wA.m11507IEE();
        Iterator it = c0092JHa.f1191mjFkc.iterator();
        while (it.hasNext()) {
            C3793gy c3793gy = (C3793gy) it.next();
            if (c3793gy != null) {
                Fragment fragmentM11582ZfxDd = this.f1207Ne.m11582ZfxDd(c3793gy.f13876AZxh);
                fragmentM11582ZfxDd.getClass();
                if (m857dm(2)) {
                    Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + fragmentM11582ZfxDd);
                }
                Fragment fragmentM1008ETF = new C0099xJ(this.f1206MiMN, this.f1227wA, fragmentM11582ZfxDd, c3793gy).m1008ETF();
                fragmentM1008ETF.f1136fehf = this;
                if (!m857dm(2)) {
                    throw null;
                }
                Log.v("FragmentManager", "restoreSaveState: active (" + fragmentM1008ETF.f1117KLFTb + "): " + fragmentM1008ETF);
                throw null;
            }
        }
        for (Fragment fragment : this.f1207Ne.m11580JHa()) {
            if (!this.f1227wA.m11522wA(fragment.f1117KLFTb)) {
                if (m857dm(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + fragment + " that was not found in the set of active Fragments " + c0092JHa.f1191mjFkc);
                }
                this.f1207Ne.m11584lgHUyS(fragment);
                fragment.f1136fehf = this;
                C0099xJ c0099xJ = new C0099xJ(this.f1206MiMN, this.f1227wA, fragment);
                c0099xJ.m1017fehf(1);
                c0099xJ.m1012MiMN();
                fragment.f1110ETF = true;
                c0099xJ.m1012MiMN();
            }
        }
        this.f1227wA.m11511Pq(c0092JHa.f1186AZxh);
        if (c0092JHa.f1192wA != null) {
            this.f1214ZfxDd = new ArrayList(c0092JHa.f1192wA.length);
            int i = 0;
            while (true) {
                C0085AZxh[] c0085AZxhArr = c0092JHa.f1192wA;
                if (i >= c0085AZxhArr.length) {
                    break;
                }
                C0096mjFkc c0096mjFkcM718mjFkc = c0085AZxhArr[i].m718mjFkc(this);
                if (m857dm(2)) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i + " (index " + c0096mjFkcM718mjFkc.f1281Ucbh + "): " + c0096mjFkcM718mjFkc);
                    PrintWriter printWriter = new PrintWriter(new C4058l1("FragmentManager"));
                    c0096mjFkcM718mjFkc.m973IEE("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1214ZfxDd.add(c0096mjFkcM718mjFkc);
                i++;
            }
        } else {
            this.f1214ZfxDd = null;
        }
        this.f1229xJ.set(c0092JHa.f1189ZfxDd);
        String str = c0092JHa.f1188KLFTb;
        if (str != null) {
            Fragment fragmentM936vadzgd = m936vadzgd(str);
            this.f1203IEE = fragmentM936vadzgd;
            m868HGpJ(fragmentM936vadzgd);
        }
        ArrayList arrayList = c0092JHa.f1187JHa;
        if (arrayList != null && arrayList.size() > 0) {
            throw null;
        }
        this.f1218huTpC = new ArrayDeque(c0092JHa.f1190lgHUyS);
    }

    /* renamed from: kism */
    public void m920kism(C0099xJ c0099xJ) {
        Fragment fragmentM1008ETF = c0099xJ.m1008ETF();
        if (fragmentM1008ETF.f1123OjSQV) {
            if (this.f1196AZxh) {
                this.f1197BAnRFn = true;
                return;
            }
            fragmentM1008ETF.f1123OjSQV = false;
            if (f1194KLMXS) {
                c0099xJ.m1012MiMN();
            } else {
                m887SOS(fragmentM1008ETF);
            }
        }
    }

    /* renamed from: lB */
    public void m921lB() {
        this.f1202HGpJ = false;
        this.f1226vI = false;
        this.f1207Ne.m11585qdMbNW(false);
        m939wJVbdd(5);
    }

    /* renamed from: lgHUyS */
    public void m922lgHUyS(AbstractC3346aAlqX abstractC3346aAlqX, AbstractC3963jeHSg abstractC3963jeHSg, Fragment fragment) {
        this.f1223qGY = abstractC3963jeHSg;
        this.f1217fehf = fragment;
        if (fragment != null) {
            m871JHa(new JHa(fragment));
        }
        if (this.f1217fehf != null) {
            m916gtr();
        }
        if (fragment != null) {
            this.f1207Ne = fragment.f1136fehf.m866GMIER(fragment);
        } else {
            this.f1207Ne = new C3467bzZHlx(false);
        }
        this.f1207Ne.m11585qdMbNW(m941xROA());
        this.f1227wA.m11515diqgf(this.f1207Ne);
    }

    /* renamed from: lti */
    public void m923lti(Fragment fragment) {
        if (fragment == null || fragment.m808equals(m936vadzgd(fragment.f1117KLFTb))) {
            Fragment fragment2 = this.f1203IEE;
            this.f1203IEE = fragment;
            m868HGpJ(fragment2);
            m868HGpJ(this.f1203IEE);
            return;
        }
        throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
    }

    /* renamed from: mByQ */
    public void m924mByQ() {
        this.f1226vI = true;
        this.f1207Ne.m11585qdMbNW(true);
        m939wJVbdd(4);
    }

    /* renamed from: nxI */
    public AbstractC3346aAlqX m925nxI() {
        return null;
    }

    /* renamed from: oCFDzJ */
    public Fragment m926oCFDzJ(int i) {
        return this.f1227wA.m11508JHa(i);
    }

    /* renamed from: qGY */
    public void m927qGY(C0096mjFkc c0096mjFkc, boolean z, boolean z2, boolean z3) {
        if (z) {
            c0096mjFkc.m977diqgf(z3);
        } else {
            c0096mjFkc.m974Pq();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(c0096mjFkc);
        arrayList2.add(Boolean.valueOf(z));
        if (z2 && this.f1225rkYL >= 1) {
            throw null;
        }
        if (z3) {
            m888SmIWf(this.f1225rkYL, true);
        }
        for (Fragment fragment : this.f1227wA.m11505Dt()) {
            if (fragment != null && fragment.f1140mByQ != null && fragment.f1118KLMXS && c0096mjFkc.m980huTpC(fragment.f1135eyqo)) {
                float f = fragment.f1133cMLeY;
                if (f > 0.0f) {
                    fragment.f1140mByQ.setAlpha(f);
                }
                if (z3) {
                    fragment.f1133cMLeY = 0.0f;
                } else {
                    fragment.f1133cMLeY = -1.0f;
                    fragment.f1118KLMXS = false;
                }
            }
        }
    }

    /* renamed from: qdMbNW */
    public void m928qdMbNW(Fragment fragment) {
        if (m857dm(2)) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f1112Gd) {
            fragment.f1112Gd = false;
            if (fragment.f1109Dt) {
                return;
            }
            this.f1227wA.m11518mjFkc(fragment);
            if (m857dm(2)) {
                Log.v("FragmentManager", "add from attach: " + fragment);
            }
            if (m932tQ(fragment)) {
                this.f1201Gd = true;
            }
        }
    }

    /* renamed from: rkYL */
    public final Set m929rkYL(ArrayList arrayList, int i, int i2) {
        ViewGroup viewGroup;
        HashSet hashSet = new HashSet();
        while (i < i2) {
            Iterator it = ((C0096mjFkc) arrayList.get(i)).f1271wA.iterator();
            while (it.hasNext()) {
                Fragment fragment = ((AbstractC0095lgHUyS.mjFkc) it.next()).f1273AZxh;
                if (fragment != null && (viewGroup = fragment.f1151wJVbdd) != null) {
                    hashSet.add(AbstractC0086Dt.m721MiMN(viewGroup, this));
                }
            }
            i++;
        }
        return hashSet;
    }

    /* renamed from: sRqPfw */
    public void m930sRqPfw(Fragment fragment) {
        if (m857dm(2)) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f1137huTpC) {
            fragment.f1137huTpC = false;
            fragment.f1154zvd = !fragment.f1154zvd;
        }
    }

    /* renamed from: tISON */
    public void m931tISON(Fragment fragment, boolean z) {
        ViewGroup viewGroupM873JYn = m873JYn(fragment);
        if (viewGroupM873JYn == null || !(viewGroupM873JYn instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) viewGroupM873JYn).setDrawDisappearingViewsLast(!z);
    }

    /* renamed from: tQ */
    public final boolean m932tQ(Fragment fragment) {
        return (fragment.f1128VocHEe && fragment.f1107BAnRFn) || fragment.f1114IEE.m891VA();
    }

    /* renamed from: tjSezt */
    public void m933tjSezt(int i, int i2) {
        if (i >= 0) {
            m942xrEuO(new qdMbNW(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f1217fehf;
        if (fragment != null) {
            sb.append(fragment.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.f1217fehf)));
            sb.append("}");
        } else {
            sb.append("null");
        }
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: uHVRx */
    public AbstractC3963jeHSg m934uHVRx() {
        return this.f1223qGY;
    }

    /* renamed from: vI */
    public void m935vI() {
        m939wJVbdd(5);
    }

    /* renamed from: vadzgd */
    public Fragment m936vadzgd(String str) {
        return this.f1227wA.m11509KLFTb(str);
    }

    /* renamed from: vjlshU */
    public boolean m937vjlshU(int i) {
        return this.f1225rkYL >= i;
    }

    /* renamed from: wA */
    public final void m938wA(C3762gYa c3762gYa) {
        int i = this.f1225rkYL;
        if (i < 1) {
            return;
        }
        int iMin = Math.min(i, 5);
        for (Fragment fragment : this.f1227wA.m11512VA()) {
            if (fragment.f1141mjFkc < iMin) {
                m886Qr(fragment, iMin);
                if (fragment.f1140mByQ != null && !fragment.f1137huTpC && fragment.f1118KLMXS) {
                    c3762gYa.add(fragment);
                }
            }
        }
    }

    /* renamed from: wJVbdd */
    public final void m939wJVbdd(int i) {
        try {
            this.f1196AZxh = true;
            this.f1227wA.m11514ZfxDd(i);
            m888SmIWf(i, false);
            if (f1194KLMXS) {
                Iterator it = m903YoKzxo().iterator();
                while (it.hasNext()) {
                    ((AbstractC0086Dt) it.next()).m724Dt();
                }
            }
            this.f1196AZxh = false;
            m945zvd(true);
        } catch (Throwable th) {
            this.f1196AZxh = false;
            throw th;
        }
    }

    /* renamed from: xJ */
    public int m940xJ() {
        return this.f1229xJ.getAndIncrement();
    }

    /* renamed from: xROA */
    public boolean m941xROA() {
        return this.f1202HGpJ || this.f1226vI;
    }

    /* renamed from: xrEuO */
    public void m942xrEuO(lgHUyS lghuys, boolean z) {
        if (!z) {
            if (!this.f1212VocHEe) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        synchronized (this.f1222mjFkc) {
            try {
                if (!z) {
                    throw new IllegalStateException("Activity has been destroyed");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: yX */
    public boolean m943yX() {
        return m913gYa(null, -1, 0);
    }

    /* renamed from: yfx */
    public boolean m944yfx(Fragment fragment) {
        if (fragment == null) {
            return true;
        }
        AbstractC0093KLFTb abstractC0093KLFTb = fragment.f1136fehf;
        return fragment.m808equals(abstractC0093KLFTb.m907bbzow()) && m944yfx(abstractC0093KLFTb.f1217fehf);
    }

    /* renamed from: zvd */
    public boolean m945zvd(boolean z) {
        m876KLMXS(z);
        boolean z2 = false;
        while (m897WrLQs(this.f1219lB, this.f1228wJVbdd)) {
            z2 = true;
            this.f1196AZxh = true;
            try {
                m899XFUzSY(this.f1219lB, this.f1228wJVbdd);
            } finally {
                m879MiMN();
            }
        }
        m916gtr();
        m883Ne();
        this.f1227wA.m11504AZxh();
        return z2;
    }
}
