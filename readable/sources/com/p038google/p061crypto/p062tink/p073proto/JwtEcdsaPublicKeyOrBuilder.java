package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.JwtEcdsaPublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface JwtEcdsaPublicKeyOrBuilder extends MessageLiteOrBuilder {
    JwtEcdsaAlgorithm getAlgorithm();

    int getAlgorithmValue();

    JwtEcdsaPublicKey.CustomKid getCustomKid();

    int getVersion();

    /* renamed from: getX */
    ByteString mo3684getX();

    /* renamed from: getY */
    ByteString mo3685getY();

    boolean hasCustomKid();
}
