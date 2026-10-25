package p131o;

import java.io.Serializable;

/* renamed from: o.BD */
/* loaded from: classes.dex */
public final class C1678BD extends AbstractC4397qC implements Serializable {

    /* renamed from: AZxh */
    public final Object f7460AZxh;

    /* renamed from: mjFkc */
    public final Object f7461mjFkc;

    public C1678BD(Object obj, Object obj2) {
        this.f7461mjFkc = obj;
        this.f7460AZxh = obj2;
    }

    @Override // p131o.AbstractC4397qC, java.util.Map.Entry
    public final Object getKey() {
        return this.f7461mjFkc;
    }

    @Override // p131o.AbstractC4397qC, java.util.Map.Entry
    public final Object getValue() {
        return this.f7460AZxh;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }
}
