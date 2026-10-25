package com.p038google.p061crypto.p062tink;

@Deprecated
/* loaded from: classes.dex */
public interface Catalogue<P> {
    KeyManager<P> getKeyManager(String str, String str2, int i);

    PrimitiveWrapper<?, P> getPrimitiveWrapper();
}
