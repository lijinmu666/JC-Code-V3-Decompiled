package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public final class Zuc256Engine extends Zuc256CoreEngine {
    public Zuc256Engine() {
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Zuc256CoreEngine, org.bouncycastle.p194crypto.p201engines.Zuc128CoreEngine, org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new Zuc256Engine(this);
    }

    public Zuc256Engine(int i) {
        super(i);
    }

    private Zuc256Engine(Zuc256Engine zuc256Engine) {
        super(zuc256Engine);
    }
}
