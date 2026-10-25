package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface RsaSsaPssPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    /* renamed from: getCrt */
    ByteString mo3874getCrt();

    /* renamed from: getD */
    ByteString mo3875getD();

    /* renamed from: getDp */
    ByteString mo3876getDp();

    /* renamed from: getDq */
    ByteString mo3877getDq();

    /* renamed from: getP */
    ByteString mo3878getP();

    RsaSsaPssPublicKey getPublicKey();

    /* renamed from: getQ */
    ByteString mo3879getQ();

    int getVersion();

    boolean hasPublicKey();
}
