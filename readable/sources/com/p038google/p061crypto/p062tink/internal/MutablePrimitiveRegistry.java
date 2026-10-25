package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.internal.PrimitiveRegistry;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class MutablePrimitiveRegistry {
    private static MutablePrimitiveRegistry globalInstance = new MutablePrimitiveRegistry();
    private final AtomicReference<PrimitiveRegistry> registry = new AtomicReference<>(new PrimitiveRegistry.C0428Builder().m3497build());

    public static MutablePrimitiveRegistry globalInstance() {
        return globalInstance;
    }

    public static void resetGlobalInstanceTestOnly() {
        globalInstance = new MutablePrimitiveRegistry();
    }

    public <WrapperPrimitiveT> Class<?> getInputPrimitiveClass(Class<WrapperPrimitiveT> cls) {
        return this.registry.get().getInputPrimitiveClass(cls);
    }

    public <KeyT extends AbstractC0308Key, PrimitiveT> PrimitiveT getPrimitive(KeyT keyt, Class<PrimitiveT> cls) {
        return (PrimitiveT) this.registry.get().getPrimitive(keyt, cls);
    }

    public synchronized <KeyT extends AbstractC0308Key, PrimitiveT> void registerPrimitiveConstructor(PrimitiveConstructor<KeyT, PrimitiveT> primitiveConstructor) {
        this.registry.set(new PrimitiveRegistry.C0428Builder(this.registry.get()).registerPrimitiveConstructor(primitiveConstructor).m3497build());
    }

    public synchronized <InputPrimitiveT, WrapperPrimitiveT> void registerPrimitiveWrapper(PrimitiveWrapper<InputPrimitiveT, WrapperPrimitiveT> primitiveWrapper) {
        this.registry.set(new PrimitiveRegistry.C0428Builder(this.registry.get()).registerPrimitiveWrapper(primitiveWrapper).m3497build());
    }

    /* renamed from: wrap */
    public <InputPrimitiveT, WrapperPrimitiveT> WrapperPrimitiveT m3492wrap(PrimitiveSet<InputPrimitiveT> primitiveSet, Class<WrapperPrimitiveT> cls) {
        return (WrapperPrimitiveT) this.registry.get().m3496wrap(primitiveSet, cls);
    }
}
