package com.p038google.p061crypto.p062tink.p077tinkkey.internal;

import com.p038google.p061crypto.p062tink.internal.KeyStatusTypeProtoConverter;
import com.p038google.p061crypto.p062tink.p073proto.KeyStatusType;
import com.p038google.p061crypto.p062tink.p077tinkkey.InterfaceC0877TinkKey;
import com.p038google.p061crypto.p062tink.p077tinkkey.KeyHandle;

/* loaded from: classes.dex */
public final class InternalKeyHandle extends KeyHandle {
    public InternalKeyHandle(InterfaceC0877TinkKey interfaceC0877TinkKey, KeyStatusType keyStatusType, int i) {
        super(interfaceC0877TinkKey, KeyStatusTypeProtoConverter.fromProto(keyStatusType), i);
    }
}
