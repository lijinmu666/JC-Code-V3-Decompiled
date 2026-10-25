package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public interface RegistryConfigOrBuilder extends MessageLiteOrBuilder {
    String getConfigName();

    ByteString getConfigNameBytes();

    KeyTypeEntry getEntry(int i);

    int getEntryCount();

    List<KeyTypeEntry> getEntryList();
}
