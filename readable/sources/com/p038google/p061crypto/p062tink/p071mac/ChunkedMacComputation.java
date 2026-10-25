package com.p038google.p061crypto.p062tink.p071mac;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface ChunkedMacComputation {
    byte[] computeMac();

    /* renamed from: update */
    void mo3518update(ByteBuffer byteBuffer);
}
