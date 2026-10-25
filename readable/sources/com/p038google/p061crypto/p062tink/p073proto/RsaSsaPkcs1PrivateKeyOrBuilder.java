package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPkcs1PrivateKeyOrBuilder extends MessageLiteOrBuilder {
    /* renamed from: getCrt */
    ByteString mo3832getCrt();

    /* renamed from: getD */
    ByteString mo3833getD();

    /* renamed from: getDp */
    ByteString mo3834getDp();

    /* renamed from: getDq */
    ByteString mo3835getDq();

    /* renamed from: getP */
    ByteString mo3836getP();

    RsaSsaPkcs1PublicKey getPublicKey();

    /* renamed from: getQ */
    ByteString mo3837getQ();

    int getVersion();

    boolean hasPublicKey();
}
