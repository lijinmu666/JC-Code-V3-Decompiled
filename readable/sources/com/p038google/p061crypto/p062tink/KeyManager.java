package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite;

/* loaded from: classes.dex */
public interface KeyManager<P> {
    boolean doesSupport(String str);

    String getKeyType();

    P getPrimitive(ByteString byteString);

    P getPrimitive(MessageLite messageLite);

    Class<P> getPrimitiveClass();

    int getVersion();

    /* renamed from: newKey */
    MessageLite mo3339newKey(ByteString byteString);

    /* renamed from: newKey */
    MessageLite mo3340newKey(MessageLite messageLite);

    C0669KeyData newKeyData(ByteString byteString);
}
