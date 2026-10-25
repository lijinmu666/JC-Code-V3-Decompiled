package p131o;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.p022app.AbstractC0093KLFTb;
import androidx.fragment.p022app.C0099xJ;
import androidx.fragment.p022app.Fragment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.bVfe */
/* loaded from: classes.dex */
public class C3435bVfe {

    /* renamed from: wA */
    public C3467bzZHlx f13112wA;

    /* renamed from: mjFkc */
    public final ArrayList f13111mjFkc = new ArrayList();

    /* renamed from: AZxh */
    public final HashMap f13110AZxh = new HashMap();

    /* renamed from: AZxh */
    public void m11504AZxh() {
        this.f13110AZxh.values().removeAll(Collections.singleton(null));
    }

    /* renamed from: Dt */
    public List m11505Dt() {
        ArrayList arrayList = new ArrayList();
        for (C0099xJ c0099xJ : this.f13110AZxh.values()) {
            if (c0099xJ != null) {
                arrayList.add(c0099xJ.m1008ETF());
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    /* renamed from: ETF */
    public C0099xJ m11506ETF(String str) {
        return (C0099xJ) this.f13110AZxh.get(str);
    }

    /* renamed from: IEE */
    public void m11507IEE() {
        this.f13110AZxh.clear();
    }

    /* renamed from: JHa */
    public Fragment m11508JHa(int i) {
        for (int size = this.f13111mjFkc.size() - 1; size >= 0; size--) {
            Fragment fragment = (Fragment) this.f13111mjFkc.get(size);
            if (fragment != null && fragment.f1134diqgf == i) {
                return fragment;
            }
        }
        for (C0099xJ c0099xJ : this.f13110AZxh.values()) {
            if (c0099xJ != null) {
                Fragment fragmentM1008ETF = c0099xJ.m1008ETF();
                if (fragmentM1008ETF.f1134diqgf == i) {
                    return fragmentM1008ETF;
                }
            }
        }
        return null;
    }

    /* renamed from: KLFTb */
    public Fragment m11509KLFTb(String str) {
        C0099xJ c0099xJ = (C0099xJ) this.f13110AZxh.get(str);
        if (c0099xJ != null) {
            return c0099xJ.m1008ETF();
        }
        return null;
    }

    /* renamed from: MiMN */
    public C3467bzZHlx m11510MiMN() {
        return this.f13112wA;
    }

    /* renamed from: Pq */
    public void m11511Pq(List list) {
        this.f13111mjFkc.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                Fragment fragmentM11509KLFTb = m11509KLFTb(str);
                if (fragmentM11509KLFTb == null) {
                    throw new IllegalStateException("No instantiated fragment for (" + str + ")");
                }
                if (AbstractC0093KLFTb.m857dm(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str + "): " + fragmentM11509KLFTb);
                }
                m11518mjFkc(fragmentM11509KLFTb);
            }
        }
    }

    /* renamed from: VA */
    public List m11512VA() {
        ArrayList arrayList;
        if (this.f13111mjFkc.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f13111mjFkc) {
            arrayList = new ArrayList(this.f13111mjFkc);
        }
        return arrayList;
    }

    /* renamed from: YoKzxo */
    public void m11513YoKzxo(C0099xJ c0099xJ) {
        Fragment fragmentM1008ETF = c0099xJ.m1008ETF();
        if (m11522wA(fragmentM1008ETF.f1117KLFTb)) {
            return;
        }
        this.f13110AZxh.put(fragmentM1008ETF.f1117KLFTb, c0099xJ);
        if (fragmentM1008ETF.f1148vI) {
            if (fragmentM1008ETF.f1113HGpJ) {
                this.f13112wA.m11586wA(fragmentM1008ETF);
            } else {
                this.f13112wA.m11584lgHUyS(fragmentM1008ETF);
            }
            fragmentM1008ETF.f1148vI = false;
        }
        if (AbstractC0093KLFTb.m857dm(2)) {
            Log.v("FragmentManager", "Added fragment to active set " + fragmentM1008ETF);
        }
    }

    /* renamed from: ZfxDd */
    public void m11514ZfxDd(int i) {
        for (C0099xJ c0099xJ : this.f13110AZxh.values()) {
            if (c0099xJ != null) {
                c0099xJ.m1017fehf(i);
            }
        }
    }

    /* renamed from: diqgf */
    public void m11515diqgf(C3467bzZHlx c3467bzZHlx) {
        this.f13112wA = c3467bzZHlx;
    }

    /* renamed from: fehf */
    public void m11516fehf(Fragment fragment) {
        synchronized (this.f13111mjFkc) {
            this.f13111mjFkc.remove(fragment);
        }
        fragment.f1109Dt = false;
    }

    /* renamed from: lgHUyS */
    public int m11517lgHUyS(Fragment fragment) {
        View view;
        View view2;
        ViewGroup viewGroup = fragment.f1151wJVbdd;
        if (viewGroup == null) {
            return -1;
        }
        int iIndexOf = this.f13111mjFkc.indexOf(fragment);
        for (int i = iIndexOf - 1; i >= 0; i--) {
            Fragment fragment2 = (Fragment) this.f13111mjFkc.get(i);
            if (fragment2.f1151wJVbdd == viewGroup && (view2 = fragment2.f1140mByQ) != null) {
                return viewGroup.indexOfChild(view2) + 1;
            }
        }
        while (true) {
            iIndexOf++;
            if (iIndexOf >= this.f13111mjFkc.size()) {
                return -1;
            }
            Fragment fragment3 = (Fragment) this.f13111mjFkc.get(iIndexOf);
            if (fragment3.f1151wJVbdd == viewGroup && (view = fragment3.f1140mByQ) != null) {
                return viewGroup.indexOfChild(view);
            }
        }
    }

    /* renamed from: mjFkc */
    public void m11518mjFkc(Fragment fragment) {
        if (this.f13111mjFkc.contains(fragment)) {
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
        synchronized (this.f13111mjFkc) {
            this.f13111mjFkc.add(fragment);
        }
        fragment.f1109Dt = true;
    }

    /* renamed from: qGY */
    public void m11519qGY() {
        Iterator it = this.f13111mjFkc.iterator();
        while (it.hasNext()) {
            C0099xJ c0099xJ = (C0099xJ) this.f13110AZxh.get(((Fragment) it.next()).f1117KLFTb);
            if (c0099xJ != null) {
                c0099xJ.m1012MiMN();
            }
        }
        for (C0099xJ c0099xJ2 : this.f13110AZxh.values()) {
            if (c0099xJ2 != null) {
                c0099xJ2.m1012MiMN();
                Fragment fragmentM1008ETF = c0099xJ2.m1008ETF();
                if (fragmentM1008ETF.f1110ETF && !fragmentM1008ETF.m827oCFDzJ()) {
                    m11521rkYL(c0099xJ2);
                }
            }
        }
    }

    /* renamed from: qdMbNW */
    public List m11520qdMbNW() {
        ArrayList arrayList = new ArrayList();
        for (C0099xJ c0099xJ : this.f13110AZxh.values()) {
            if (c0099xJ != null) {
                arrayList.add(c0099xJ);
            }
        }
        return arrayList;
    }

    /* renamed from: rkYL */
    public void m11521rkYL(C0099xJ c0099xJ) {
        Fragment fragmentM1008ETF = c0099xJ.m1008ETF();
        if (fragmentM1008ETF.f1113HGpJ) {
            this.f13112wA.m11584lgHUyS(fragmentM1008ETF);
        }
        if (((C0099xJ) this.f13110AZxh.put(fragmentM1008ETF.f1117KLFTb, null)) != null && AbstractC0093KLFTb.m857dm(2)) {
            Log.v("FragmentManager", "Removed fragment from active set " + fragmentM1008ETF);
        }
    }

    /* renamed from: wA */
    public boolean m11522wA(String str) {
        return this.f13110AZxh.get(str) != null;
    }

    /* renamed from: xJ */
    public Fragment m11523xJ(String str) {
        if (str != null) {
            for (int size = this.f13111mjFkc.size() - 1; size >= 0; size--) {
                Fragment fragment = (Fragment) this.f13111mjFkc.get(size);
                if (fragment != null && str.equals(fragment.f1125Ucbh)) {
                    return fragment;
                }
            }
        }
        if (str == null) {
            return null;
        }
        for (C0099xJ c0099xJ : this.f13110AZxh.values()) {
            if (c0099xJ != null) {
                Fragment fragmentM1008ETF = c0099xJ.m1008ETF();
                if (str.equals(fragmentM1008ETF.f1125Ucbh)) {
                    return fragmentM1008ETF;
                }
            }
        }
        return null;
    }
}
