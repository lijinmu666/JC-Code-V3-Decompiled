package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public final class Zuc128Engine extends Zuc128CoreEngine {
    public Zuc128Engine() {
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Zuc128CoreEngine, org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new Zuc128Engine(this);
    }

    private Zuc128Engine(Zuc128Engine zuc128Engine) {
        super(zuc128Engine);
    }
}
