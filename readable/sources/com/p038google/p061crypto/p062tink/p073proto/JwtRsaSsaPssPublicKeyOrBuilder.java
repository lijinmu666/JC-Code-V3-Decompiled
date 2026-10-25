package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface JwtRsaSsaPssPublicKeyOrBuilder extends MessageLiteOrBuilder {
    JwtRsaSsaPssAlgorithm getAlgorithm();

    int getAlgorithmValue();

    JwtRsaSsaPssPublicKey.CustomKid getCustomKid();

    /* renamed from: getE */
    ByteString mo3780getE();

    /* renamed from: getN */
    ByteString mo3781getN();

    int getVersion();

    boolean hasCustomKid();
}
