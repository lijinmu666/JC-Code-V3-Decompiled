package p131o;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* renamed from: o.h6 */
/* loaded from: classes.dex */
public class C3802h6 implements Iterable {

    /* renamed from: AZxh */
    public wA f13958AZxh;

    /* renamed from: mjFkc */
    public wA f13960mjFkc;

    /* renamed from: wA */
    public final WeakHashMap f13961wA = new WeakHashMap();

    /* renamed from: ZfxDd */
    public int f13959ZfxDd = 0;

    /* renamed from: o.h6$AZxh */
    public static class AZxh extends KLFTb {
        public AZxh(wA wAVar, wA wAVar2) {
            super(wAVar, wAVar2);
        }

        @Override // p131o.C3802h6.KLFTb
        /* renamed from: ZfxDd */
        public wA mo12177ZfxDd(wA wAVar) {
            return wAVar.f13968ZfxDd;
        }

        @Override // p131o.C3802h6.KLFTb
        /* renamed from: wA */
        public wA mo12178wA(wA wAVar) {
            return wAVar.f13970wA;
        }
    }

    /* renamed from: o.h6$JHa */
    public static abstract class JHa {
        /* renamed from: AZxh */
        public abstract void mo12179AZxh(wA wAVar);
    }

    /* renamed from: o.h6$KLFTb */
    public static abstract class KLFTb extends JHa implements Iterator {

        /* renamed from: AZxh */
        public wA f13962AZxh;

        /* renamed from: mjFkc */
        public wA f13963mjFkc;

        public KLFTb(wA wAVar, wA wAVar2) {
            this.f13963mjFkc = wAVar2;
            this.f13962AZxh = wAVar;
        }

        @Override // p131o.C3802h6.JHa
        /* renamed from: AZxh */
        public void mo12179AZxh(wA wAVar) {
            if (this.f13963mjFkc == wAVar && wAVar == this.f13962AZxh) {
                this.f13962AZxh = null;
                this.f13963mjFkc = null;
            }
            wA wAVar2 = this.f13963mjFkc;
            if (wAVar2 == wAVar) {
                this.f13963mjFkc = mo12178wA(wAVar2);
            }
            if (this.f13962AZxh == wAVar) {
                this.f13962AZxh = m12180JHa();
            }
        }

        /* renamed from: JHa */
        public final wA m12180JHa() {
            wA wAVar = this.f13962AZxh;
            wA wAVar2 = this.f13963mjFkc;
            if (wAVar == wAVar2 || wAVar2 == null) {
                return null;
            }
            return mo12177ZfxDd(wAVar);
        }

        @Override // java.util.Iterator
        /* renamed from: KLFTb, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            wA wAVar = this.f13962AZxh;
            this.f13962AZxh = m12180JHa();
            return wAVar;
        }

        /* renamed from: ZfxDd */
        public abstract wA mo12177ZfxDd(wA wAVar);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f13962AZxh != null;
        }

        /* renamed from: wA */
        public abstract wA mo12178wA(wA wAVar);
    }

    /* renamed from: o.h6$ZfxDd */
    public class ZfxDd extends JHa implements Iterator {

        /* renamed from: AZxh */
        public boolean f13964AZxh = true;

        /* renamed from: mjFkc */
        public wA f13965mjFkc;

        public ZfxDd() {
        }

        @Override // p131o.C3802h6.JHa
        /* renamed from: AZxh */
        public void mo12179AZxh(wA wAVar) {
            wA wAVar2 = this.f13965mjFkc;
            if (wAVar == wAVar2) {
                wA wAVar3 = wAVar2.f13968ZfxDd;
                this.f13965mjFkc = wAVar3;
                this.f13964AZxh = wAVar3 == null;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f13964AZxh) {
                return C3802h6.this.f13960mjFkc != null;
            }
            wA wAVar = this.f13965mjFkc;
            return (wAVar == null || wAVar.f13970wA == null) ? false : true;
        }

        @Override // java.util.Iterator
        /* renamed from: wA, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f13964AZxh) {
                this.f13964AZxh = false;
                this.f13965mjFkc = C3802h6.this.f13960mjFkc;
            } else {
                wA wAVar = this.f13965mjFkc;
                this.f13965mjFkc = wAVar != null ? wAVar.f13970wA : null;
            }
            return this.f13965mjFkc;
        }
    }

    /* renamed from: o.h6$mjFkc */
    public static class mjFkc extends KLFTb {
        public mjFkc(wA wAVar, wA wAVar2) {
            super(wAVar, wAVar2);
        }

        @Override // p131o.C3802h6.KLFTb
        /* renamed from: ZfxDd */
        public wA mo12177ZfxDd(wA wAVar) {
            return wAVar.f13970wA;
        }

        @Override // p131o.C3802h6.KLFTb
        /* renamed from: wA */
        public wA mo12178wA(wA wAVar) {
            return wAVar.f13968ZfxDd;
        }
    }

    /* renamed from: o.h6$wA */
    public static class wA implements Map.Entry {

        /* renamed from: AZxh */
        public final Object f13967AZxh;

        /* renamed from: ZfxDd */
        public wA f13968ZfxDd;

        /* renamed from: mjFkc */
        public final Object f13969mjFkc;

        /* renamed from: wA */
        public wA f13970wA;

        public wA(Object obj, Object obj2) {
            this.f13969mjFkc = obj;
            this.f13967AZxh = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof wA)) {
                return false;
            }
            wA wAVar = (wA) obj;
            return this.f13969mjFkc.equals(wAVar.f13969mjFkc) && this.f13967AZxh.equals(wAVar.f13967AZxh);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f13969mjFkc;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f13967AZxh;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f13967AZxh.hashCode() ^ this.f13969mjFkc.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f13969mjFkc + "=" + this.f13967AZxh;
        }
    }

    /* renamed from: Dt */
    public Object mo12167Dt(Object obj, Object obj2) {
        wA wAVarMo12169JHa = mo12169JHa(obj);
        if (wAVarMo12169JHa != null) {
            return wAVarMo12169JHa.f13967AZxh;
        }
        m12174qdMbNW(obj, obj2);
        return null;
    }

    /* renamed from: ETF */
    public Object mo12168ETF(Object obj) {
        wA wAVarMo12169JHa = mo12169JHa(obj);
        if (wAVarMo12169JHa == null) {
            return null;
        }
        this.f13959ZfxDd--;
        if (!this.f13961wA.isEmpty()) {
            Iterator it = this.f13961wA.keySet().iterator();
            while (it.hasNext()) {
                ((JHa) it.next()).mo12179AZxh(wAVarMo12169JHa);
            }
        }
        wA wAVar = wAVarMo12169JHa.f13968ZfxDd;
        if (wAVar != null) {
            wAVar.f13970wA = wAVarMo12169JHa.f13970wA;
        } else {
            this.f13960mjFkc = wAVarMo12169JHa.f13970wA;
        }
        wA wAVar2 = wAVarMo12169JHa.f13970wA;
        if (wAVar2 != null) {
            wAVar2.f13968ZfxDd = wAVar;
        } else {
            this.f13958AZxh = wAVar;
        }
        wAVarMo12169JHa.f13970wA = null;
        wAVarMo12169JHa.f13968ZfxDd = null;
        return wAVarMo12169JHa.f13967AZxh;
    }

    /* renamed from: JHa */
    public wA mo12169JHa(Object obj) {
        wA wAVar = this.f13960mjFkc;
        while (wAVar != null && !wAVar.f13969mjFkc.equals(obj)) {
            wAVar = wAVar.f13970wA;
        }
        return wAVar;
    }

    /* renamed from: ZfxDd */
    public Map.Entry m12170ZfxDd() {
        return this.f13960mjFkc;
    }

    /* renamed from: equals */
    public boolean m12171equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3802h6)) {
            return false;
        }
        C3802h6 c3802h6 = (C3802h6) obj;
        if (m12175size() != c3802h6.m12175size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c3802h6.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        mjFkc mjfkc = new mjFkc(this.f13960mjFkc, this.f13958AZxh);
        this.f13961wA.put(mjfkc, Boolean.FALSE);
        return mjfkc;
    }

    /* renamed from: lgHUyS */
    public Map.Entry m12172lgHUyS() {
        return this.f13958AZxh;
    }

    /* renamed from: mjFkc */
    public Iterator m12173mjFkc() {
        AZxh aZxh = new AZxh(this.f13958AZxh, this.f13960mjFkc);
        this.f13961wA.put(aZxh, Boolean.FALSE);
        return aZxh;
    }

    /* renamed from: qdMbNW */
    public wA m12174qdMbNW(Object obj, Object obj2) {
        wA wAVar = new wA(obj, obj2);
        this.f13959ZfxDd++;
        wA wAVar2 = this.f13958AZxh;
        if (wAVar2 == null) {
            this.f13960mjFkc = wAVar;
            this.f13958AZxh = wAVar;
            return wAVar;
        }
        wAVar2.f13970wA = wAVar;
        wAVar.f13968ZfxDd = wAVar2;
        this.f13958AZxh = wAVar;
        return wAVar;
    }

    /* renamed from: size */
    public int m12175size() {
        return this.f13959ZfxDd;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /* renamed from: xJ */
    public ZfxDd m12176xJ() {
        ZfxDd zfxDd = new ZfxDd();
        this.f13961wA.put(zfxDd, Boolean.FALSE);
        return zfxDd;
    }
}
