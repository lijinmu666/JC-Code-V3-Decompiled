package p131o;

import java.util.HashMap;
import java.util.Map;
import p131o.C3802h6;

/* renamed from: o.tyXzYJ */
/* loaded from: classes.dex */
public class C4651tyXzYJ extends C3802h6 {

    /* renamed from: KLFTb */
    public final HashMap f16757KLFTb = new HashMap();

    @Override // p131o.C3802h6
    /* renamed from: Dt */
    public Object mo12167Dt(Object obj, Object obj2) {
        C3802h6.wA wAVarMo12169JHa = mo12169JHa(obj);
        if (wAVarMo12169JHa != null) {
            return wAVarMo12169JHa.f13967AZxh;
        }
        this.f16757KLFTb.put(obj, m12174qdMbNW(obj, obj2));
        return null;
    }

    @Override // p131o.C3802h6
    /* renamed from: ETF */
    public Object mo12168ETF(Object obj) {
        Object objMo12168ETF = super.mo12168ETF(obj);
        this.f16757KLFTb.remove(obj);
        return objMo12168ETF;
    }

    @Override // p131o.C3802h6
    /* renamed from: JHa */
    public C3802h6.wA mo12169JHa(Object obj) {
        return (C3802h6.wA) this.f16757KLFTb.get(obj);
    }

    /* renamed from: VA */
    public Map.Entry m13659VA(Object obj) {
        if (contains(obj)) {
            return ((C3802h6.wA) this.f16757KLFTb.get(obj)).f13968ZfxDd;
        }
        return null;
    }

    public boolean contains(Object obj) {
        return this.f16757KLFTb.containsKey(obj);
    }
}
