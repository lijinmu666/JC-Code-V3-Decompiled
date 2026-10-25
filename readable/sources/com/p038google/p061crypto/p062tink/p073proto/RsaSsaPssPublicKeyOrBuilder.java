package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPssPublicKeyOrBuilder extends MessageLiteOrBuilder {
    /* renamed from: getE */
    ByteString mo3896getE();

    /* renamed from: getN */
    ByteString mo3897getN();

    RsaSsaPssParams getParams();

    int getVersion();

    boolean hasParams();
}
