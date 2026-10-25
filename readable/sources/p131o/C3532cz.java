package p131o;

import java.util.Iterator;
import java.util.Map;

/* renamed from: o.cz */
/* loaded from: classes.dex */
public final class C3532cz implements Iterator {

    /* renamed from: AZxh */
    public boolean f13274AZxh;

    /* renamed from: ZfxDd */
    public final /* synthetic */ AbstractC3794gz f13275ZfxDd;

    /* renamed from: mjFkc */
    public int f13276mjFkc = -1;

    /* renamed from: wA */
    public Iterator f13277wA;

    public /* synthetic */ C3532cz(AbstractC3794gz abstractC3794gz, AbstractC3466bz abstractC3466bz) {
        this.f13275ZfxDd = abstractC3794gz;
    }

    /* renamed from: AZxh */
    public final Iterator m11627AZxh() {
        if (this.f13277wA == null) {
            this.f13277wA = this.f13275ZfxDd.f13894wA.entrySet().iterator();
        }
        return this.f13277wA;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.f13276mjFkc + 1;
        AbstractC3794gz abstractC3794gz = this.f13275ZfxDd;
        if (i >= abstractC3794gz.f13889AZxh) {
            return !abstractC3794gz.f13894wA.isEmpty() && m11627AZxh().hasNext();
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        this.f13274AZxh = true;
        int i = this.f13276mjFkc + 1;
        this.f13276mjFkc = i;
        AbstractC3794gz abstractC3794gz = this.f13275ZfxDd;
        return i < abstractC3794gz.f13889AZxh ? (C3400az) abstractC3794gz.f13893mjFkc[i] : (Map.Entry) m11627AZxh().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.f13274AZxh) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f13274AZxh = false;
        this.f13275ZfxDd.m12128rkYL();
        int i = this.f13276mjFkc;
        AbstractC3794gz abstractC3794gz = this.f13275ZfxDd;
        if (i >= abstractC3794gz.f13889AZxh) {
            m11627AZxh().remove();
        } else {
            this.f13276mjFkc = i - 1;
            abstractC3794gz.m12124MiMN(i);
        }
    }
}
