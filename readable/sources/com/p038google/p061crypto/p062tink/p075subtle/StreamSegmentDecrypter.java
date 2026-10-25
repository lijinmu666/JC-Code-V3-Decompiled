package com.p038google.p061crypto.p062tink.p075subtle;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface StreamSegmentDecrypter {
    void decryptSegment(ByteBuffer byteBuffer, int i, boolean z, ByteBuffer byteBuffer2);

    /* renamed from: init */
    void mo4213init(ByteBuffer byteBuffer, byte[] bArr);
}
