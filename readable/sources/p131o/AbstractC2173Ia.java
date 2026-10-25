package p131o;

import java.util.ArrayList;

/* renamed from: o.Ia */
/* loaded from: classes.dex */
public abstract class AbstractC2173Ia extends C3776gjvQ {

    /* renamed from: tjSezt */
    public ArrayList f8762tjSezt = new ArrayList();

    /* renamed from: AZxh */
    public void m8789AZxh(C3776gjvQ c3776gjvQ) {
        this.f8762tjSezt.add(c3776gjvQ);
        if (c3776gjvQ.m12044Ne() != null) {
            ((AbstractC2173Ia) c3776gjvQ.m12044Ne()).m8792XD(c3776gjvQ);
        }
        c3776gjvQ.m12092tjSezt(this);
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: JrJO */
    public void mo8790JrJO() {
        this.f8762tjSezt.clear();
        super.mo8790JrJO();
    }

    @Override // p131o.C3776gjvQ
    /* renamed from: WGXroI */
    public void mo8791WGXroI(C2768RWyiuY c2768RWyiuY) {
        super.mo8791WGXroI(c2768RWyiuY);
        int size = this.f8762tjSezt.size();
        for (int i = 0; i < size; i++) {
            ((C3776gjvQ) this.f8762tjSezt.get(i)).mo8791WGXroI(c2768RWyiuY);
        }
    }

    /* renamed from: XD */
    public void m8792XD(C3776gjvQ c3776gjvQ) {
        this.f8762tjSezt.remove(c3776gjvQ);
        c3776gjvQ.m12092tjSezt(null);
    }

    /* renamed from: gtr */
    public void m8793gtr() {
        this.f8762tjSezt.clear();
    }

    /* renamed from: sRqPfw */
    public abstract void mo8794sRqPfw();
}
