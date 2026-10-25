package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPkcs1PublicKeyOrBuilder extends MessageLiteOrBuilder {
    /* renamed from: getE */
    ByteString mo3854getE();

    /* renamed from: getN */
    ByteString mo3855getN();

    RsaSsaPkcs1Params getParams();

    int getVersion();

    boolean hasParams();
}
