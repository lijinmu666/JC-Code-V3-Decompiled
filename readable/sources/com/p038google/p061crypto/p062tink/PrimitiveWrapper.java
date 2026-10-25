package com.p038google.p061crypto.p062tink;

/* loaded from: classes.dex */
public interface PrimitiveWrapper<B, P> {
    Class<B> getInputPrimitiveClass();

    Class<P> getPrimitiveClass();

    /* renamed from: wrap */
    P mo3385wrap(PrimitiveSet<B> primitiveSet);
}
