package p131o;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: o.xBQUgd */
/* loaded from: classes.dex */
public class C4865xBQUgd extends AbstractC2225JHa implements InterfaceC2604OzIs {

    /* renamed from: xJ */
    public static final InterfaceC3339a4 f17338xJ = C3510cdjp.m11614mjFkc();

    /* renamed from: AZxh */
    public final Map f17339AZxh;

    /* renamed from: JHa */
    public final AtomicReference f17340JHa;

    /* renamed from: KLFTb */
    public final C2984UmFn f17341KLFTb;

    /* renamed from: ZfxDd */
    public final List f17342ZfxDd;

    /* renamed from: mjFkc */
    public final Map f17343mjFkc;

    /* renamed from: wA */
    public final Map f17344wA;

    /* renamed from: o.xBQUgd$AZxh */
    public static final class AZxh {

        /* renamed from: mjFkc */
        public final Executor f17346mjFkc;

        /* renamed from: AZxh */
        public final List f17345AZxh = new ArrayList();

        /* renamed from: wA */
        public final List f17347wA = new ArrayList();

        public AZxh(Executor executor) {
            this.f17346mjFkc = executor;
        }

        /* renamed from: AZxh */
        public AZxh m13919AZxh(Collection collection) {
            this.f17345AZxh.addAll(collection);
            return this;
        }

        /* renamed from: mjFkc */
        public AZxh m13920mjFkc(C2957UOnCkw c2957UOnCkw) {
            this.f17347wA.add(c2957UOnCkw);
            return this;
        }

        /* renamed from: wA */
        public C4865xBQUgd m13921wA() {
            return new C4865xBQUgd(this.f17346mjFkc, this.f17345AZxh, this.f17347wA);
        }
    }

    /* renamed from: KLFTb */
    public static AZxh m13909KLFTb(Executor executor) {
        return new AZxh(executor);
    }

    /* renamed from: qdMbNW */
    public static List m13911qdMbNW(Iterable iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    @Override // p131o.AbstractC2225JHa, p131o.InterfaceC4803wGscSa
    /* renamed from: AZxh */
    public /* bridge */ /* synthetic */ Set mo8923AZxh(Class cls) {
        return super.mo8923AZxh(cls);
    }

    /* renamed from: JHa */
    public final void m13912JHa(List list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.f17342ZfxDd.iterator();
            while (it.hasNext()) {
                try {
                    InterfaceC1653ArO interfaceC1653ArO = (InterfaceC1653ArO) ((InterfaceC3339a4) it.next()).mo8427get();
                    if (interfaceC1653ArO != null) {
                        list.addAll(interfaceC1653ArO.mo4297mjFkc());
                        it.remove();
                    }
                } catch (C3534d0 e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.f17343mjFkc.isEmpty()) {
                AbstractC3694fTu.m11921mjFkc(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f17343mjFkc.keySet());
                arrayList2.addAll(list);
                AbstractC3694fTu.m11921mjFkc(arrayList2);
            }
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                C2957UOnCkw c2957UOnCkw = (C2957UOnCkw) it2.next();
                this.f17343mjFkc.put(c2957UOnCkw, new C2541O0(C2767RWb.m10082mjFkc(this, c2957UOnCkw)));
            }
            arrayList.addAll(m13917rkYL(list));
            arrayList.addAll(m13916qGY());
            m13914YoKzxo();
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            ((Runnable) it3.next()).run();
        }
        m13913MiMN();
    }

    /* renamed from: MiMN */
    public final void m13913MiMN() {
        Boolean bool = (Boolean) this.f17340JHa.get();
        if (bool != null) {
            m13918xJ(this.f17343mjFkc, bool.booleanValue());
        }
    }

    /* renamed from: YoKzxo */
    public final void m13914YoKzxo() {
        for (C2957UOnCkw c2957UOnCkw : this.f17343mjFkc.keySet()) {
            for (C4441qqdo c4441qqdo : c2957UOnCkw.m10498wA()) {
                if (c4441qqdo.m13302JHa() && !this.f17344wA.containsKey(c4441qqdo.m13301AZxh())) {
                    this.f17344wA.put(c4441qqdo.m13301AZxh(), C2668Q0.m9991AZxh(Collections.emptySet()));
                } else if (this.f17339AZxh.containsKey(c4441qqdo.m13301AZxh())) {
                    continue;
                } else {
                    if (c4441qqdo.m13303KLFTb()) {
                        throw new C3860i2(String.format("Unsatisfied dependency for component %s: %s", c2957UOnCkw, c4441qqdo.m13301AZxh()));
                    }
                    if (!c4441qqdo.m13302JHa()) {
                        this.f17339AZxh.put(c4441qqdo.m13301AZxh(), C4190n3.m12846mjFkc());
                    }
                }
            }
        }
    }

    @Override // p131o.InterfaceC4803wGscSa
    /* renamed from: ZfxDd */
    public synchronized InterfaceC3339a4 mo13844ZfxDd(Class cls) {
        C2668Q0 c2668q0 = (C2668Q0) this.f17344wA.get(cls);
        if (c2668q0 != null) {
            return c2668q0;
        }
        return f17338xJ;
    }

    /* renamed from: lgHUyS */
    public void m13915lgHUyS(boolean z) {
        HashMap map;
        if (AbstractC5024zd.m14125mjFkc(this.f17340JHa, null, Boolean.valueOf(z))) {
            synchronized (this) {
                map = new HashMap(this.f17343mjFkc);
            }
            m13918xJ(map, z);
        }
    }

    @Override // p131o.AbstractC2225JHa, p131o.InterfaceC4803wGscSa
    /* renamed from: mjFkc */
    public /* bridge */ /* synthetic */ Object mo8924mjFkc(Class cls) {
        return super.mo8924mjFkc(cls);
    }

    /* renamed from: qGY */
    public final List m13916qGY() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f17343mjFkc.entrySet()) {
            C2957UOnCkw c2957UOnCkw = (C2957UOnCkw) entry.getKey();
            if (!c2957UOnCkw.m10492Dt()) {
                InterfaceC3339a4 interfaceC3339a4 = (InterfaceC3339a4) entry.getValue();
                for (Class cls : c2957UOnCkw.m10494KLFTb()) {
                    if (!map.containsKey(cls)) {
                        map.put(cls, new HashSet());
                    }
                    ((Set) map.get(cls)).add(interfaceC3339a4);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.f17344wA.containsKey(entry2.getKey())) {
                C2668Q0 c2668q0 = (C2668Q0) this.f17344wA.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(RunnableC1904EeoThB.m8167mjFkc(c2668q0, (InterfaceC3339a4) it.next()));
                }
            } else {
                this.f17344wA.put((Class) entry2.getKey(), C2668Q0.m9991AZxh((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    /* renamed from: rkYL */
    public final List m13917rkYL(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C2957UOnCkw c2957UOnCkw = (C2957UOnCkw) it.next();
            if (c2957UOnCkw.m10492Dt()) {
                InterfaceC3339a4 interfaceC3339a4 = (InterfaceC3339a4) this.f17343mjFkc.get(c2957UOnCkw);
                for (Class cls : c2957UOnCkw.m10494KLFTb()) {
                    if (this.f17339AZxh.containsKey(cls)) {
                        arrayList.add(RunnableC3953jTNPnW.m12434mjFkc((C4190n3) ((InterfaceC3339a4) this.f17339AZxh.get(cls)), interfaceC3339a4));
                    } else {
                        this.f17339AZxh.put(cls, interfaceC3339a4);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // p131o.InterfaceC4803wGscSa
    /* renamed from: wA */
    public synchronized InterfaceC3339a4 mo13845wA(Class cls) {
        AbstractC2207J3.m8886wA(cls, "Null interface requested.");
        return (InterfaceC3339a4) this.f17339AZxh.get(cls);
    }

    /* renamed from: xJ */
    public final void m13918xJ(Map map, boolean z) {
        for (Map.Entry entry : map.entrySet()) {
            C2957UOnCkw c2957UOnCkw = (C2957UOnCkw) entry.getKey();
            InterfaceC3339a4 interfaceC3339a4 = (InterfaceC3339a4) entry.getValue();
            if (c2957UOnCkw.m10496lgHUyS() || (c2957UOnCkw.m10497qdMbNW() && z)) {
                interfaceC3339a4.mo8427get();
            }
        }
        this.f17341KLFTb.m10646mjFkc();
    }

    public C4865xBQUgd(Executor executor, Iterable iterable, Collection collection) {
        this.f17343mjFkc = new HashMap();
        this.f17339AZxh = new HashMap();
        this.f17344wA = new HashMap();
        this.f17340JHa = new AtomicReference();
        C2984UmFn c2984UmFn = new C2984UmFn(executor);
        this.f17341KLFTb = c2984UmFn;
        ArrayList arrayList = new ArrayList();
        arrayList.add(C2957UOnCkw.m10489VA(c2984UmFn, C2984UmFn.class, InterfaceC4392q7.class, InterfaceC3406b4.class));
        arrayList.add(C2957UOnCkw.m10489VA(this, InterfaceC2604OzIs.class, new Class[0]));
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C2957UOnCkw c2957UOnCkw = (C2957UOnCkw) it.next();
            if (c2957UOnCkw != null) {
                arrayList.add(c2957UOnCkw);
            }
        }
        this.f17342ZfxDd = m13911qdMbNW(iterable);
        m13912JHa(arrayList);
    }
}
