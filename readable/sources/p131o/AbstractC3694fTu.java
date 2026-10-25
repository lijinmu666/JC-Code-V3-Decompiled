package p131o;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* renamed from: o.fTu */
/* loaded from: classes.dex */
public abstract class AbstractC3694fTu {

    /* renamed from: o.fTu$AZxh */
    public static class AZxh {

        /* renamed from: mjFkc */
        public final C2957UOnCkw f13581mjFkc;

        /* renamed from: AZxh */
        public final Set f13580AZxh = new HashSet();

        /* renamed from: wA */
        public final Set f13582wA = new HashSet();

        public AZxh(C2957UOnCkw c2957UOnCkw) {
            this.f13581mjFkc = c2957UOnCkw;
        }

        /* renamed from: AZxh */
        public void m11923AZxh(AZxh aZxh) {
            this.f13582wA.add(aZxh);
        }

        /* renamed from: JHa */
        public boolean m11924JHa() {
            return this.f13582wA.isEmpty();
        }

        /* renamed from: KLFTb */
        public boolean m11925KLFTb() {
            return this.f13580AZxh.isEmpty();
        }

        /* renamed from: ZfxDd */
        public Set m11926ZfxDd() {
            return this.f13580AZxh;
        }

        /* renamed from: mjFkc */
        public void m11927mjFkc(AZxh aZxh) {
            this.f13580AZxh.add(aZxh);
        }

        /* renamed from: wA */
        public C2957UOnCkw m11928wA() {
            return this.f13581mjFkc;
        }

        /* renamed from: xJ */
        public void m11929xJ(AZxh aZxh) {
            this.f13582wA.remove(aZxh);
        }
    }

    /* renamed from: o.fTu$wA */
    public static class wA {

        /* renamed from: AZxh */
        public final boolean f13583AZxh;

        /* renamed from: mjFkc */
        public final Class f13584mjFkc;

        /* renamed from: equals */
        public boolean m11931equals(Object obj) {
            if (!(obj instanceof wA)) {
                return false;
            }
            wA wAVar = (wA) obj;
            return wAVar.f13584mjFkc.equals(this.f13584mjFkc) && wAVar.f13583AZxh == this.f13583AZxh;
        }

        public int hashCode() {
            return Boolean.valueOf(this.f13583AZxh).hashCode() ^ ((this.f13584mjFkc.hashCode() ^ 1000003) * 1000003);
        }

        public wA(Class cls, boolean z) {
            this.f13584mjFkc = cls;
            this.f13583AZxh = z;
        }
    }

    /* renamed from: AZxh */
    public static Set m11920AZxh(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            AZxh aZxh = (AZxh) it.next();
            if (aZxh.m11924JHa()) {
                hashSet.add(aZxh);
            }
        }
        return hashSet;
    }

    /* renamed from: mjFkc */
    public static void m11921mjFkc(List list) {
        Set<AZxh> setM11922wA = m11922wA(list);
        Set setM11920AZxh = m11920AZxh(setM11922wA);
        int i = 0;
        while (!setM11920AZxh.isEmpty()) {
            AZxh aZxh = (AZxh) setM11920AZxh.iterator().next();
            setM11920AZxh.remove(aZxh);
            i++;
            for (AZxh aZxh2 : aZxh.m11926ZfxDd()) {
                aZxh2.m11929xJ(aZxh);
                if (aZxh2.m11924JHa()) {
                    setM11920AZxh.add(aZxh2);
                }
            }
        }
        if (i == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (AZxh aZxh3 : setM11922wA) {
            if (!aZxh3.m11924JHa() && !aZxh3.m11925KLFTb()) {
                arrayList.add(aZxh3.m11928wA());
            }
        }
        throw new C4157mZG(arrayList);
    }

    /* renamed from: wA */
    public static Set m11922wA(List list) {
        Set<AZxh> set;
        HashMap map = new HashMap(list.size());
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (AZxh aZxh : (Set) it2.next()) {
                        for (C4441qqdo c4441qqdo : aZxh.m11928wA().m10498wA()) {
                            if (c4441qqdo.m13304ZfxDd() && (set = (Set) map.get(new wA(c4441qqdo.m13301AZxh(), c4441qqdo.m13302JHa()))) != null) {
                                for (AZxh aZxh2 : set) {
                                    aZxh.m11927mjFkc(aZxh2);
                                    aZxh2.m11923AZxh(aZxh);
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                return hashSet;
            }
            C2957UOnCkw c2957UOnCkw = (C2957UOnCkw) it.next();
            AZxh aZxh3 = new AZxh(c2957UOnCkw);
            for (Class cls : c2957UOnCkw.m10494KLFTb()) {
                wA wAVar = new wA(cls, !c2957UOnCkw.m10492Dt());
                if (!map.containsKey(wAVar)) {
                    map.put(wAVar, new HashSet());
                }
                Set set2 = (Set) map.get(wAVar);
                if (!set2.isEmpty() && !wAVar.f13583AZxh) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(aZxh3);
            }
        }
    }
}
