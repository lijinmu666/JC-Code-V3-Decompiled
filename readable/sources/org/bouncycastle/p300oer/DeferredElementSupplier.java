package org.bouncycastle.p300oer;

import org.bouncycastle.p300oer.OERDefinition;

/* loaded from: classes2.dex */
public class DeferredElementSupplier implements ElementSupplier {
    private C5887Element buildProduct;

    /* renamed from: src */
    private final OERDefinition.C5888Builder f22539src;

    public DeferredElementSupplier(OERDefinition.C5888Builder c5888Builder) {
        this.f22539src = c5888Builder;
    }

    @Override // org.bouncycastle.p300oer.ElementSupplier
    /* renamed from: build */
    public C5887Element mo17122build() {
        C5887Element c5887Element;
        synchronized (this) {
            try {
                if (this.buildProduct == null) {
                    this.buildProduct = this.f22539src.m17146build();
                }
                c5887Element = this.buildProduct;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c5887Element;
    }
}
