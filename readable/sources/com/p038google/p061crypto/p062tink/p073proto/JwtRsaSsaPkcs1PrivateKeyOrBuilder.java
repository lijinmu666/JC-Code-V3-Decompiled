package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface JwtRsaSsaPkcs1PrivateKeyOrBuilder extends MessageLiteOrBuilder {
    /* renamed from: getCrt */
    ByteString mo3713getCrt();

    /* renamed from: getD */
    ByteString mo3714getD();

    /* renamed from: getDp */
    ByteString mo3715getDp();

    /* renamed from: getDq */
    ByteString mo3716getDq();

    /* renamed from: getP */
    ByteString mo3717getP();

    JwtRsaSsaPkcs1PublicKey getPublicKey();

    /* renamed from: getQ */
    ByteString mo3718getQ();

    int getVersion();

    boolean hasPublicKey();
}
