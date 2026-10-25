package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface AesCtrHmacStreamingKeyOrBuilder extends MessageLiteOrBuilder {
    ByteString getKeyValue();

    AesCtrHmacStreamingParams getParams();

    int getVersion();

    boolean hasParams();
}
