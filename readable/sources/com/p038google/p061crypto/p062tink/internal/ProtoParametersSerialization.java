package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;

/* loaded from: classes.dex */
public final class ProtoParametersSerialization implements Serialization {
    private final KeyTemplate keyTemplate;
    private final C0878Bytes objectIdentifier;

    private ProtoParametersSerialization(KeyTemplate keyTemplate) {
        this.keyTemplate = keyTemplate;
        this.objectIdentifier = C0431Util.toBytesFromPrintableAscii(keyTemplate.getTypeUrl());
    }

    /* renamed from: create */
    public static ProtoParametersSerialization m3501create(String str, OutputPrefixType outputPrefixType, MessageLite messageLite) {
        return m3500create(KeyTemplate.newBuilder().setTypeUrl(str).setOutputPrefixType(outputPrefixType).setValue(messageLite.toByteString()).mo3555build());
    }

    public KeyTemplate getKeyTemplate() {
        return this.keyTemplate;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.Serialization
    public C0878Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }

    /* renamed from: create */
    public static ProtoParametersSerialization m3500create(KeyTemplate keyTemplate) {
        return new ProtoParametersSerialization(keyTemplate);
    }
}
