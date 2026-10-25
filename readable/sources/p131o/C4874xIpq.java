package p131o;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: o.xIpq */
/* loaded from: classes.dex */
public final class C4874xIpq {

    /* renamed from: mjFkc */
    public final InterfaceC1601A3 f17368mjFkc = new C1733C3(10);

    /* renamed from: AZxh */
    public final C3074W6 f17366AZxh = new C3074W6();

    /* renamed from: wA */
    public final ArrayList f17369wA = new ArrayList();

    /* renamed from: ZfxDd */
    public final HashSet f17367ZfxDd = new HashSet();

    /* renamed from: AZxh */
    public void m13922AZxh(Object obj) {
        if (this.f17366AZxh.containsKey(obj)) {
            return;
        }
        this.f17366AZxh.m10821put(obj, null);
    }

    /* renamed from: Dt */
    public final void m13923Dt(ArrayList arrayList) {
        arrayList.clear();
        this.f17368mjFkc.mo7551mjFkc(arrayList);
    }

    /* renamed from: JHa */
    public final ArrayList m13924JHa() {
        ArrayList arrayList = (ArrayList) this.f17368mjFkc.mo7550AZxh();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    /* renamed from: KLFTb */
    public final void m13925KLFTb(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f17366AZxh.m10817get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                m13925KLFTb(arrayList2.get(i), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    /* renamed from: ZfxDd */
    public boolean m13926ZfxDd(Object obj) {
        return this.f17366AZxh.containsKey(obj);
    }

    /* renamed from: lgHUyS */
    public ArrayList m13927lgHUyS() {
        this.f17369wA.clear();
        this.f17367ZfxDd.clear();
        int iM10827size = this.f17366AZxh.m10827size();
        for (int i = 0; i < iM10827size; i++) {
            m13925KLFTb(this.f17366AZxh.m10822qdMbNW(i), this.f17369wA, this.f17367ZfxDd);
        }
        return this.f17369wA;
    }

    /* renamed from: mjFkc */
    public void m13928mjFkc(Object obj, Object obj2) {
        if (!this.f17366AZxh.containsKey(obj) || !this.f17366AZxh.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayListM13924JHa = (ArrayList) this.f17366AZxh.m10817get(obj);
        if (arrayListM13924JHa == null) {
            arrayListM13924JHa = m13924JHa();
            this.f17366AZxh.m10821put(obj, arrayListM13924JHa);
        }
        arrayListM13924JHa.add(obj2);
    }

    /* renamed from: qdMbNW */
    public boolean m13929qdMbNW(Object obj) {
        int iM10827size = this.f17366AZxh.m10827size();
        for (int i = 0; i < iM10827size; i++) {
            ArrayList arrayList = (ArrayList) this.f17366AZxh.m10813MiMN(i);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: wA */
    public void m13930wA() {
        int iM10827size = this.f17366AZxh.m10827size();
        for (int i = 0; i < iM10827size; i++) {
            ArrayList arrayList = (ArrayList) this.f17366AZxh.m10813MiMN(i);
            if (arrayList != null) {
                m13923Dt(arrayList);
            }
        }
        this.f17366AZxh.m10815clear();
    }

    /* renamed from: xJ */
    public List m13931xJ(Object obj) {
        int iM10827size = this.f17366AZxh.m10827size();
        ArrayList arrayList = null;
        for (int i = 0; i < iM10827size; i++) {
            ArrayList arrayList2 = (ArrayList) this.f17366AZxh.m10813MiMN(i);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f17366AZxh.m10822qdMbNW(i));
            }
        }
        return arrayList;
    }
}
