package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class KeyStatus {

    /* renamed from: name */
    private final String f2992name;

    /* renamed from: ENABLED */
    public static final KeyStatus f2991ENABLED = new KeyStatus("ENABLED");
    public static final KeyStatus DISABLED = new KeyStatus("DISABLED");
    public static final KeyStatus DESTROYED = new KeyStatus("DESTROYED");

    private KeyStatus(String str) {
        this.f2992name = str;
    }

    public String toString() {
        return this.f2992name;
    }
}
