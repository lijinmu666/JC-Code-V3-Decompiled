package com.p038google.p061crypto.p062tink.streamingaead;

import com.p038google.p061crypto.p062tink.KeysetHandle;
import com.p038google.p061crypto.p062tink.StreamingAead;

@Deprecated
/* loaded from: classes.dex */
public final class StreamingAeadFactory {
    private StreamingAeadFactory() {
    }

    public static StreamingAead getPrimitive(KeysetHandle keysetHandle) {
        StreamingAeadWrapper.register();
        return (StreamingAead) keysetHandle.getPrimitive(StreamingAead.class);
    }
}
