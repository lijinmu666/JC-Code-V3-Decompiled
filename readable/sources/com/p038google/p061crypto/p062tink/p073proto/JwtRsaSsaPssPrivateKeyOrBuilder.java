package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;

/* loaded from: classes.dex */
public interface JwtRsaSsaPssPrivateKeyOrBuilder extends MessageLiteOrBuilder {
    /* renamed from: getCrt */
    ByteString mo3758getCrt();

    /* renamed from: getD */
    ByteString mo3759getD();

    /* renamed from: getDp */
    ByteString mo3760getDp();

    /* renamed from: getDq */
    ByteString mo3761getDq();

    /* renamed from: getP */
    ByteString mo3762getP();

    JwtRsaSsaPssPublicKey getPublicKey();

    /* renamed from: getQ */
    ByteString mo3763getQ();

    int getVersion();

    boolean hasPublicKey();
}
