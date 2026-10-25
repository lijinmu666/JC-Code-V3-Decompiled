package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.KeysetInfo;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* loaded from: classes.dex */
public interface KeysetInfoOrBuilder extends MessageLiteOrBuilder {
    KeysetInfo.C0678KeyInfo getKeyInfo(int i);

    int getKeyInfoCount();

    List<KeysetInfo.C0678KeyInfo> getKeyInfoList();

    int getPrimaryKeyId();
}
