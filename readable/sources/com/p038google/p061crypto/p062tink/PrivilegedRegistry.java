package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite;
import java.io.InputStream;

/* loaded from: classes.dex */
public class PrivilegedRegistry {
    private PrivilegedRegistry() {
    }

    public static C0669KeyData deriveKey(KeyTemplate keyTemplate, InputStream inputStream) {
        return Registry.deriveKey(keyTemplate, inputStream);
    }

    public static MessageLite parseKeyData(C0669KeyData c0669KeyData) {
        return Registry.parseKeyData(c0669KeyData);
    }
}
