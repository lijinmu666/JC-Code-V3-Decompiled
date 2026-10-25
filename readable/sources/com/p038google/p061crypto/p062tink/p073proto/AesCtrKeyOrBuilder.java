package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesCtrParams getParams();

    int getVersion();

    boolean hasParams();
}
