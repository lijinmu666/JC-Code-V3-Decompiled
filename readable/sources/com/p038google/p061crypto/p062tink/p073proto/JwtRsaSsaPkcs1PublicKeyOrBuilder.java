package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface JwtRsaSsaPkcs1PublicKeyOrBuilder extends MessageLiteOrBuilder {
    JwtRsaSsaPkcs1Algorithm getAlgorithm();

    int getAlgorithmValue();

    JwtRsaSsaPkcs1PublicKey.CustomKid getCustomKid();

    /* renamed from: getE */
    ByteString mo3735getE();

    /* renamed from: getN */
    ByteString mo3736getN();

    int getVersion();

    boolean hasCustomKid();
}
