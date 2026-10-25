package com.p038google.p061crypto.p062tink.p071mac;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ChunkedMacVerification {
    /* renamed from: update */
    void mo3519update(ByteBuffer byteBuffer);

    void verifyMac();
}
