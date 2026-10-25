package com.p038google.p061crypto.p062tink.streamingaead;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.PrimitiveWrapper;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.StreamingAead;

/* loaded from: classes.dex */
public class StreamingAeadWrapper implements PrimitiveWrapper<StreamingAead, StreamingAead> {

    /* renamed from: WRAPPER */
    private static final StreamingAeadWrapper f3878WRAPPER = new StreamingAeadWrapper();

    public static void register() {
        Registry.registerPrimitiveWrapper(f3878WRAPPER);
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<StreamingAead> getInputPrimitiveClass() {
        return StreamingAead.class;
    }

    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    public Class<StreamingAead> getPrimitiveClass() {
        return StreamingAead.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.PrimitiveWrapper
    /* renamed from: wrap */
    public StreamingAead mo3385wrap(PrimitiveSet<StreamingAead> primitiveSet) {
        return new StreamingAeadHelper(primitiveSet);
    }
}
