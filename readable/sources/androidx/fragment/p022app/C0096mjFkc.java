package androidx.fragment.p022app;

import android.util.Log;
import androidx.fragment.p022app.AbstractC0093KLFTb;
import androidx.fragment.p022app.AbstractC0095lgHUyS;
import androidx.fragment.p022app.Fragment;
import java.io.PrintWriter;
import java.util.ArrayList;
import p131o.AbstractC3423bL;
import p131o.C4058l1;

/* renamed from: androidx.fragment.app.mjFkc */
/* loaded from: classes.dex */
public final class C0096mjFkc extends AbstractC0095lgHUyS implements AbstractC0093KLFTb.lgHUyS {

    /* renamed from: Ucbh */
    public int f1281Ucbh;

    /* renamed from: diqgf */
    public final AbstractC0093KLFTb f1282diqgf;

    /* renamed from: eyqo */
    public boolean f1283eyqo;

    /* JADX WARN: Illegal instructions before constructor call */
    public C0096mjFkc(AbstractC0093KLFTb abstractC0093KLFTb) {
        AbstractC3423bL abstractC3423bLM872JYgkl = abstractC0093KLFTb.m872JYgkl();
        abstractC0093KLFTb.m925nxI();
        super(abstractC3423bLM872JYgkl, null);
        this.f1281Ucbh = -1;
        this.f1282diqgf = abstractC0093KLFTb;
    }

    /* renamed from: HGpJ */
    public static boolean m970HGpJ(AbstractC0095lgHUyS.mjFkc mjfkc) {
        Fragment fragment = mjfkc.f1273AZxh;
        return (fragment == null || !fragment.f1109Dt || fragment.f1140mByQ == null || fragment.f1112Gd || fragment.f1137huTpC || !fragment.m803aqHPIZ()) ? false : true;
    }

    /* renamed from: BAnRFn */
    public void m971BAnRFn(Fragment.InterfaceC0089ZfxDd interfaceC0089ZfxDd) {
        for (int i = 0; i < this.f1271wA.size(); i++) {
            AbstractC0095lgHUyS.mjFkc mjfkc = (AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(i);
            if (m970HGpJ(mjfkc)) {
                mjfkc.f1273AZxh.m814giT(interfaceC0089ZfxDd);
            }
        }
    }

    @Override // androidx.fragment.p022app.AbstractC0095lgHUyS
    /* renamed from: Dt */
    public void mo958Dt(int i, Fragment fragment, String str, int i2) {
        super.mo958Dt(i, fragment, str, i2);
        fragment.f1136fehf = this.f1282diqgf;
    }

    @Override // androidx.fragment.p022app.AbstractC0095lgHUyS
    /* renamed from: ETF */
    public AbstractC0095lgHUyS mo959ETF(Fragment fragment) {
        AbstractC0093KLFTb abstractC0093KLFTb = fragment.f1136fehf;
        if (abstractC0093KLFTb == null || abstractC0093KLFTb == this.f1282diqgf) {
            return super.mo959ETF(fragment);
        }
        throw new IllegalStateException("Cannot remove Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
    }

    /* renamed from: Gd */
    public boolean m972Gd(ArrayList arrayList, int i, int i2) {
        if (i2 == i) {
            return false;
        }
        int size = this.f1271wA.size();
        int i3 = -1;
        for (int i4 = 0; i4 < size; i4++) {
            Fragment fragment = ((AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(i4)).f1273AZxh;
            int i5 = fragment != null ? fragment.f1135eyqo : 0;
            if (i5 != 0 && i5 != i3) {
                for (int i6 = i; i6 < i2; i6++) {
                    C0096mjFkc c0096mjFkc = (C0096mjFkc) arrayList.get(i6);
                    int size2 = c0096mjFkc.f1271wA.size();
                    for (int i7 = 0; i7 < size2; i7++) {
                        Fragment fragment2 = ((AbstractC0095lgHUyS.mjFkc) c0096mjFkc.f1271wA.get(i7)).f1273AZxh;
                        if ((fragment2 != null ? fragment2.f1135eyqo : 0) == i5) {
                            return true;
                        }
                    }
                }
                i3 = i5;
            }
        }
        return false;
    }

    /* renamed from: IEE */
    public void m973IEE(String str, PrintWriter printWriter, boolean z) {
        String str2;
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f1256ETF);
            printWriter.print(" mIndex=");
            printWriter.print(this.f1281Ucbh);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f1283eyqo);
            if (this.f1266lgHUyS != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f1266lgHUyS));
            }
            if (this.f1264ZfxDd != 0 || this.f1259KLFTb != 0) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1264ZfxDd));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1259KLFTb));
            }
            if (this.f1258JHa != 0 || this.f1272xJ != 0) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f1258JHa));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f1272xJ));
            }
            if (this.f1262VA != 0 || this.f1260MiMN != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1262VA));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f1260MiMN);
            }
            if (this.f1263YoKzxo != 0 || this.f1270rkYL != null) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f1263YoKzxo));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f1270rkYL);
            }
        }
        if (this.f1271wA.isEmpty()) {
            return;
        }
        printWriter.print(str);
        printWriter.println("Operations:");
        int size = this.f1271wA.size();
        for (int i = 0; i < size; i++) {
            AbstractC0095lgHUyS.mjFkc mjfkc = (AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(i);
            switch (mjfkc.f1278mjFkc) {
                case 0:
                    str2 = "NULL";
                    break;
                case 1:
                    str2 = "ADD";
                    break;
                case 2:
                    str2 = "REPLACE";
                    break;
                case 3:
                    str2 = "REMOVE";
                    break;
                case 4:
                    str2 = "HIDE";
                    break;
                case 5:
                    str2 = "SHOW";
                    break;
                case 6:
                    str2 = "DETACH";
                    break;
                case 7:
                    str2 = "ATTACH";
                    break;
                case 8:
                    str2 = "SET_PRIMARY_NAV";
                    break;
                case 9:
                    str2 = "UNSET_PRIMARY_NAV";
                    break;
                case 10:
                    str2 = "OP_SET_MAX_LIFECYCLE";
                    break;
                default:
                    str2 = "cmd=" + mjfkc.f1278mjFkc;
                    break;
            }
            printWriter.print(str);
            printWriter.print("  Op #");
            printWriter.print(i);
            printWriter.print(": ");
            printWriter.print(str2);
            printWriter.print(" ");
            printWriter.println(mjfkc.f1273AZxh);
            if (z) {
                if (mjfkc.f1279wA != 0 || mjfkc.f1276ZfxDd != 0) {
                    printWriter.print(str);
                    printWriter.print("enterAnim=#");
                    printWriter.print(Integer.toHexString(mjfkc.f1279wA));
                    printWriter.print(" exitAnim=#");
                    printWriter.println(Integer.toHexString(mjfkc.f1276ZfxDd));
                }
                if (mjfkc.f1275KLFTb != 0 || mjfkc.f1274JHa != 0) {
                    printWriter.print(str);
                    printWriter.print("popEnterAnim=#");
                    printWriter.print(Integer.toHexString(mjfkc.f1275KLFTb));
                    printWriter.print(" popExitAnim=#");
                    printWriter.println(Integer.toHexString(mjfkc.f1274JHa));
                }
            }
        }
    }

    @Override // androidx.fragment.p022app.AbstractC0095lgHUyS
    /* renamed from: JHa */
    public int mo960JHa() {
        return m982qGY(true);
    }

    @Override // androidx.fragment.p022app.AbstractC0095lgHUyS
    /* renamed from: KLFTb */
    public int mo961KLFTb() {
        return m982qGY(false);
    }

    /* renamed from: Pq */
    public void m974Pq() {
        int size = this.f1271wA.size();
        for (int i = 0; i < size; i++) {
            AbstractC0095lgHUyS.mjFkc mjfkc = (AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(i);
            Fragment fragment = mjfkc.f1273AZxh;
            if (fragment != null) {
                fragment.m832sRqPfw(false);
                fragment.m823lti(this.f1266lgHUyS);
                fragment.m816gtr(this.f1268qGY, this.f1265fehf);
            }
            switch (mjfkc.f1278mjFkc) {
                case 1:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m931tISON(fragment, false);
                    this.f1282diqgf.m875KLFTb(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + mjfkc.f1278mjFkc);
                case 3:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m901XbiWeM(fragment);
                    break;
                case 4:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m918jm(fragment);
                    break;
                case 5:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m931tISON(fragment, false);
                    this.f1282diqgf.m930sRqPfw(fragment);
                    break;
                case 6:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m909diqgf(fragment);
                    break;
                case 7:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m931tISON(fragment, false);
                    this.f1282diqgf.m928qdMbNW(fragment);
                    break;
                case 8:
                    this.f1282diqgf.m923lti(fragment);
                    break;
                case 9:
                    this.f1282diqgf.m923lti(null);
                    break;
                case 10:
                    this.f1282diqgf.m893Vgyli(fragment, mjfkc.f1277lgHUyS);
                    break;
            }
            if (!this.f1257IEE && mjfkc.f1278mjFkc != 1 && fragment != null && !AbstractC0093KLFTb.f1194KLMXS) {
                this.f1282diqgf.m880Moer(fragment);
            }
        }
        if (this.f1257IEE || AbstractC0093KLFTb.f1194KLMXS) {
            return;
        }
        AbstractC0093KLFTb abstractC0093KLFTb = this.f1282diqgf;
        abstractC0093KLFTb.m888SmIWf(abstractC0093KLFTb.f1225rkYL, true);
    }

    /* renamed from: Ucbh */
    public String m975Ucbh() {
        return this.f1256ETF;
    }

    /* renamed from: VocHEe */
    public void m976VocHEe() {
        if (this.f1261Pq != null) {
            for (int i = 0; i < this.f1261Pq.size(); i++) {
                ((Runnable) this.f1261Pq.get(i)).run();
            }
            this.f1261Pq = null;
        }
    }

    /* renamed from: diqgf */
    public void m977diqgf(boolean z) {
        for (int size = this.f1271wA.size() - 1; size >= 0; size--) {
            AbstractC0095lgHUyS.mjFkc mjfkc = (AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(size);
            Fragment fragment = mjfkc.f1273AZxh;
            if (fragment != null) {
                fragment.m832sRqPfw(true);
                fragment.m823lti(AbstractC0093KLFTb.m860uH(this.f1266lgHUyS));
                fragment.m816gtr(this.f1265fehf, this.f1268qGY);
            }
            switch (mjfkc.f1278mjFkc) {
                case 1:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m931tISON(fragment, true);
                    this.f1282diqgf.m901XbiWeM(fragment);
                    break;
                case 2:
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + mjfkc.f1278mjFkc);
                case 3:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m875KLFTb(fragment);
                    break;
                case 4:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m930sRqPfw(fragment);
                    break;
                case 5:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m931tISON(fragment, true);
                    this.f1282diqgf.m918jm(fragment);
                    break;
                case 6:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m928qdMbNW(fragment);
                    break;
                case 7:
                    fragment.m836uH(mjfkc.f1279wA, mjfkc.f1276ZfxDd, mjfkc.f1275KLFTb, mjfkc.f1274JHa);
                    this.f1282diqgf.m931tISON(fragment, true);
                    this.f1282diqgf.m909diqgf(fragment);
                    break;
                case 8:
                    this.f1282diqgf.m923lti(null);
                    break;
                case 9:
                    this.f1282diqgf.m923lti(fragment);
                    break;
                case 10:
                    this.f1282diqgf.m893Vgyli(fragment, mjfkc.f1280xJ);
                    break;
            }
            if (!this.f1257IEE && mjfkc.f1278mjFkc != 3 && fragment != null && !AbstractC0093KLFTb.f1194KLMXS) {
                this.f1282diqgf.m880Moer(fragment);
            }
        }
        if (this.f1257IEE || !z || AbstractC0093KLFTb.f1194KLMXS) {
            return;
        }
        AbstractC0093KLFTb abstractC0093KLFTb = this.f1282diqgf;
        abstractC0093KLFTb.m888SmIWf(abstractC0093KLFTb.f1225rkYL, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b2  */
    /* renamed from: eyqo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Fragment m978eyqo(ArrayList arrayList, Fragment fragment) {
        Fragment fragment2 = fragment;
        int i = 0;
        while (i < this.f1271wA.size()) {
            AbstractC0095lgHUyS.mjFkc mjfkc = (AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(i);
            int i2 = mjfkc.f1278mjFkc;
            if (i2 == 1) {
                arrayList.add(mjfkc.f1273AZxh);
            } else if (i2 == 2) {
                Fragment fragment3 = mjfkc.f1273AZxh;
                int i3 = fragment3.f1135eyqo;
                boolean z = false;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Fragment fragment4 = (Fragment) arrayList.get(size);
                    if (fragment4.f1135eyqo == i3) {
                        if (fragment4 == fragment3) {
                            z = true;
                        } else {
                            if (fragment4 == fragment2) {
                                this.f1271wA.add(i, new AbstractC0095lgHUyS.mjFkc(9, fragment4));
                                i++;
                                fragment2 = null;
                            }
                            AbstractC0095lgHUyS.mjFkc mjfkc2 = new AbstractC0095lgHUyS.mjFkc(3, fragment4);
                            mjfkc2.f1279wA = mjfkc.f1279wA;
                            mjfkc2.f1275KLFTb = mjfkc.f1275KLFTb;
                            mjfkc2.f1276ZfxDd = mjfkc.f1276ZfxDd;
                            mjfkc2.f1274JHa = mjfkc.f1274JHa;
                            this.f1271wA.add(i, mjfkc2);
                            arrayList.remove(fragment4);
                            i++;
                        }
                    }
                }
                if (z) {
                    this.f1271wA.remove(i);
                    i--;
                } else {
                    mjfkc.f1278mjFkc = 1;
                    arrayList.add(fragment3);
                }
            } else if (i2 == 3 || i2 == 6) {
                arrayList.remove(mjfkc.f1273AZxh);
                Fragment fragment5 = mjfkc.f1273AZxh;
                if (fragment5 == fragment2) {
                    this.f1271wA.add(i, new AbstractC0095lgHUyS.mjFkc(9, fragment5));
                    i++;
                    fragment2 = null;
                }
            } else if (i2 != 7) {
                if (i2 == 8) {
                    this.f1271wA.add(i, new AbstractC0095lgHUyS.mjFkc(9, fragment2));
                    i++;
                    fragment2 = mjfkc.f1273AZxh;
                }
            }
            i++;
        }
        return fragment2;
    }

    /* renamed from: fehf */
    public void m979fehf(String str, PrintWriter printWriter) {
        m973IEE(str, printWriter, true);
    }

    /* renamed from: huTpC */
    public boolean m980huTpC(int i) {
        int size = this.f1271wA.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = ((AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(i2)).f1273AZxh;
            int i3 = fragment != null ? fragment.f1135eyqo : 0;
            if (i3 != 0 && i3 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d  */
    /* renamed from: lB */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Fragment m981lB(ArrayList arrayList, Fragment fragment) {
        for (int size = this.f1271wA.size() - 1; size >= 0; size--) {
            AbstractC0095lgHUyS.mjFkc mjfkc = (AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(size);
            int i = mjfkc.f1278mjFkc;
            if (i == 1) {
                arrayList.remove(mjfkc.f1273AZxh);
            } else if (i != 3) {
                switch (i) {
                    case 6:
                        arrayList.add(mjfkc.f1273AZxh);
                        break;
                    case 8:
                        fragment = null;
                        break;
                    case 9:
                        fragment = mjfkc.f1273AZxh;
                        break;
                    case 10:
                        mjfkc.f1277lgHUyS = mjfkc.f1280xJ;
                        break;
                }
            }
        }
        return fragment;
    }

    @Override // androidx.fragment.p022app.AbstractC0095lgHUyS
    /* renamed from: lgHUyS */
    public void mo966lgHUyS() {
        m967qdMbNW();
        this.f1282diqgf.m908cMLeY(this, true);
    }

    @Override // androidx.fragment.p022app.AbstractC0093KLFTb.lgHUyS
    /* renamed from: mjFkc */
    public boolean mo950mjFkc(ArrayList arrayList, ArrayList arrayList2) {
        if (AbstractC0093KLFTb.m857dm(2)) {
            Log.v("FragmentManager", "Run: " + this);
        }
        arrayList.add(this);
        arrayList2.add(Boolean.FALSE);
        if (!this.f1269qdMbNW) {
            return true;
        }
        this.f1282diqgf.m904ZfxDd(this);
        return true;
    }

    /* renamed from: qGY */
    public int m982qGY(boolean z) {
        if (this.f1283eyqo) {
            throw new IllegalStateException("commit already called");
        }
        if (AbstractC0093KLFTb.m857dm(2)) {
            Log.v("FragmentManager", "Commit: " + this);
            PrintWriter printWriter = new PrintWriter(new C4058l1("FragmentManager"));
            m979fehf("  ", printWriter);
            printWriter.close();
        }
        this.f1283eyqo = true;
        if (this.f1269qdMbNW) {
            this.f1281Ucbh = this.f1282diqgf.m940xJ();
        } else {
            this.f1281Ucbh = -1;
        }
        this.f1282diqgf.m942xrEuO(this, z);
        return this.f1281Ucbh;
    }

    /* renamed from: rkYL */
    public void m983rkYL(int i) {
        if (this.f1269qdMbNW) {
            if (AbstractC0093KLFTb.m857dm(2)) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            int size = this.f1271wA.size();
            for (int i2 = 0; i2 < size; i2++) {
                AbstractC0095lgHUyS.mjFkc mjfkc = (AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(i2);
                Fragment fragment = mjfkc.f1273AZxh;
                if (fragment != null) {
                    fragment.f1143qGY += i;
                    if (AbstractC0093KLFTb.m857dm(2)) {
                        Log.v("FragmentManager", "Bump nesting of " + mjfkc.f1273AZxh + " to " + mjfkc.f1273AZxh.f1143qGY);
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f1281Ucbh >= 0) {
            sb.append(" #");
            sb.append(this.f1281Ucbh);
        }
        if (this.f1256ETF != null) {
            sb.append(" ");
            sb.append(this.f1256ETF);
        }
        sb.append("}");
        return sb.toString();
    }

    /* renamed from: vI */
    public boolean m984vI() {
        for (int i = 0; i < this.f1271wA.size(); i++) {
            if (m970HGpJ((AbstractC0095lgHUyS.mjFkc) this.f1271wA.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.fragment.p022app.AbstractC0095lgHUyS
    /* renamed from: xJ */
    public void mo969xJ() {
        m967qdMbNW();
        this.f1282diqgf.m908cMLeY(this, false);
    }
}
