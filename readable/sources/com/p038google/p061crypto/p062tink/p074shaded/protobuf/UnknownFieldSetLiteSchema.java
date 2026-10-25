package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

@CheckReturnValue
/* loaded from: classes.dex */
class UnknownFieldSetLiteSchema extends UnknownFieldSchema<UnknownFieldSetLite, UnknownFieldSetLite> {
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public void makeImmutable(Object obj) {
        getFromMessage(obj).makeImmutable();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public boolean shouldDiscardUnknownFields(InterfaceC0775Reader interfaceC0775Reader) {
        return false;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public void addFixed32(UnknownFieldSetLite unknownFieldSetLite, int i, int i2) {
        unknownFieldSetLite.storeField(WireFormat.m4185makeTag(i, 5), Integer.valueOf(i2));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public void addFixed64(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.storeField(WireFormat.m4185makeTag(i, 1), Long.valueOf(j));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public void addGroup(UnknownFieldSetLite unknownFieldSetLite, int i, UnknownFieldSetLite unknownFieldSetLite2) {
        unknownFieldSetLite.storeField(WireFormat.m4185makeTag(i, 3), unknownFieldSetLite2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public void addLengthDelimited(UnknownFieldSetLite unknownFieldSetLite, int i, ByteString byteString) {
        unknownFieldSetLite.storeField(WireFormat.m4185makeTag(i, 2), byteString);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public void addVarint(UnknownFieldSetLite unknownFieldSetLite, int i, long j) {
        unknownFieldSetLite.storeField(WireFormat.m4185makeTag(i, 0), Long.valueOf(j));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite getBuilderFromMessage(Object obj) {
        UnknownFieldSetLite fromMessage = getFromMessage(obj);
        if (fromMessage != UnknownFieldSetLite.getDefaultInstance()) {
            return fromMessage;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        setToMessage(obj, unknownFieldSetLiteNewInstance);
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite getFromMessage(Object obj) {
        return ((GeneratedMessageLite) obj).unknownFields;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public int getSerializedSize(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSize();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public int getSerializedSizeAsMessageSet(UnknownFieldSetLite unknownFieldSetLite) {
        return unknownFieldSetLite.getSerializedSizeAsMessageSet();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    /* renamed from: merge, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public UnknownFieldSetLite mo4144merge(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        return UnknownFieldSetLite.getDefaultInstance().m4146equals(unknownFieldSetLite2) ? unknownFieldSetLite : UnknownFieldSetLite.getDefaultInstance().m4146equals(unknownFieldSetLite) ? UnknownFieldSetLite.mutableCopyOf(unknownFieldSetLite, unknownFieldSetLite2) : unknownFieldSetLite.mergeFrom(unknownFieldSetLite2);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite newBuilder() {
        return UnknownFieldSetLite.newInstance();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public void setBuilderToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        setToMessage(obj, unknownFieldSetLite);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public void setToMessage(Object obj, UnknownFieldSetLite unknownFieldSetLite) {
        ((GeneratedMessageLite) obj).unknownFields = unknownFieldSetLite;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public UnknownFieldSetLite toImmutable(UnknownFieldSetLite unknownFieldSetLite) {
        unknownFieldSetLite.makeImmutable();
        return unknownFieldSetLite;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    public void writeAsMessageSetTo(UnknownFieldSetLite unknownFieldSetLite, InterfaceC0811Writer interfaceC0811Writer) {
        unknownFieldSetLite.writeAsMessageSetTo(interfaceC0811Writer);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnknownFieldSchema
    /* renamed from: writeTo, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public void mo4145writeTo(UnknownFieldSetLite unknownFieldSetLite, InterfaceC0811Writer interfaceC0811Writer) {
        unknownFieldSetLite.m4148writeTo(interfaceC0811Writer);
    }
}
