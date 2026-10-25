package com.p038google.p061crypto.p062tink.p075subtle;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface StreamSegmentEncrypter {
    void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, ByteBuffer byteBuffer3);

    void encryptSegment(ByteBuffer byteBuffer, boolean z, ByteBuffer byteBuffer2);

    ByteBuffer getHeader();
}
