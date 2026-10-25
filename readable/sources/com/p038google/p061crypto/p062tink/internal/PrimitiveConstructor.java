package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;

/* loaded from: classes.dex */
public abstract class PrimitiveConstructor<KeyT extends AbstractC0308Key, PrimitiveT> {
    private final Class<KeyT> keyClass;
    private final Class<PrimitiveT> primitiveClass;

    public interface PrimitiveConstructionFunction<KeyT extends AbstractC0308Key, PrimitiveT> {
        PrimitiveT constructPrimitive(KeyT keyt);
    }

    /* renamed from: create */
    public static <KeyT extends AbstractC0308Key, PrimitiveT> PrimitiveConstructor<KeyT, PrimitiveT> m3495create(final PrimitiveConstructionFunction<KeyT, PrimitiveT> primitiveConstructionFunction, Class<KeyT> cls, Class<PrimitiveT> cls2) {
        return (PrimitiveConstructor<KeyT, PrimitiveT>) new PrimitiveConstructor<KeyT, PrimitiveT>(cls, cls2) { // from class: com.google.crypto.tink.internal.PrimitiveConstructor.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveConstructor
            public PrimitiveT constructPrimitive(KeyT keyt) {
                return (PrimitiveT) primitiveConstructionFunction.constructPrimitive(keyt);
            }
        };
    }

    public abstract PrimitiveT constructPrimitive(KeyT keyt);

    public Class<KeyT> getKeyClass() {
        return this.keyClass;
    }

    public Class<PrimitiveT> getPrimitiveClass() {
        return this.primitiveClass;
    }

    private PrimitiveConstructor(Class<KeyT> cls, Class<PrimitiveT> cls2) {
        this.keyClass = cls;
        this.primitiveClass = cls2;
    }
}
