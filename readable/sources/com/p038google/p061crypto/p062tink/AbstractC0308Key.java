package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* renamed from: com.google.crypto.tink.Key */
/* loaded from: classes.dex */
public abstract class AbstractC0308Key {
    public abstract boolean equalsKey(AbstractC0308Key abstractC0308Key);

    @Nullable
    public abstract Integer getIdRequirementOrNull();

    public abstract Parameters getParameters();
}
