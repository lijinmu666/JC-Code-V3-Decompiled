package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;

/* loaded from: classes.dex */
public interface PrivateKeyManager<P> extends KeyManager<P> {
    C0669KeyData getPublicKeyData(ByteString byteString);
}
