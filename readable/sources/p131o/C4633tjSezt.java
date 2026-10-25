package p131o;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: o.tjSezt */
/* loaded from: classes.dex */
public class C4633tjSezt extends C3074W6 implements Map {

    /* renamed from: lgHUyS */
    public AbstractC4986z1 f16713lgHUyS;

    /* renamed from: o.tjSezt$mjFkc */
    public class mjFkc extends AbstractC4986z1 {
        public mjFkc() {
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: AZxh */
        public Object mo12004AZxh(int i, int i2) {
            return C4633tjSezt.this.f11417AZxh[(i << 1) + i2];
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: JHa */
        public int mo12005JHa(Object obj) {
            return C4633tjSezt.this.m10819lgHUyS(obj);
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: KLFTb */
        public int mo12006KLFTb(Object obj) {
            return C4633tjSezt.this.m10811JHa(obj);
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: ZfxDd */
        public int mo12007ZfxDd() {
            return C4633tjSezt.this.f11419wA;
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: lgHUyS */
        public void mo12008lgHUyS(int i) {
            C4633tjSezt.this.m10810ETF(i);
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: mjFkc */
        public void mo12009mjFkc() {
            C4633tjSezt.this.m10815clear();
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: qdMbNW */
        public Object mo12010qdMbNW(int i, Object obj) {
            return C4633tjSezt.this.m10814VA(i, obj);
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: wA */
        public Map mo12011wA() {
            return C4633tjSezt.this;
        }

        @Override // p131o.AbstractC4986z1
        /* renamed from: xJ */
        public void mo12012xJ(Object obj, Object obj2) {
            C4633tjSezt.this.m10821put(obj, obj2);
        }
    }

    public C4633tjSezt() {
    }

    /* renamed from: YoKzxo */
    public final AbstractC4986z1 m13646YoKzxo() {
        if (this.f16713lgHUyS == null) {
            this.f16713lgHUyS = new mjFkc();
        }
        return this.f16713lgHUyS;
    }

    @Override // java.util.Map
    public Set entrySet() {
        return m13646YoKzxo().m14080VA();
    }

    @Override // java.util.Map
    public Set keySet() {
        return m13646YoKzxo().m14079MiMN();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        m10828wA(this.f11419wA + map.size());
        for (Map.Entry entry : map.entrySet()) {
            m10821put(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: rkYL */
    public boolean m13647rkYL(Collection collection) {
        return AbstractC4986z1.m14076qGY(this, collection);
    }

    @Override // java.util.Map
    public Collection values() {
        return m13646YoKzxo().m14081YoKzxo();
    }

    public C4633tjSezt(int i) {
        super(i);
    }

    public C4633tjSezt(C3074W6 c3074w6) {
        super(c3074w6);
    }
}
