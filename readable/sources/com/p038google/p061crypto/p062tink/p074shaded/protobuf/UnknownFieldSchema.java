package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

@CheckReturnValue
/* loaded from: classes.dex */
abstract class UnknownFieldSchema<T, B> {
    public abstract void addFixed32(B b, int i, int i2);

    public abstract void addFixed64(B b, int i, long j);

    public abstract void addGroup(B b, int i, T t);

    public abstract void addLengthDelimited(B b, int i, ByteString byteString);

    public abstract void addVarint(B b, int i, long j);

    public abstract B getBuilderFromMessage(Object obj);

    public abstract T getFromMessage(Object obj);

    public abstract int getSerializedSize(T t);

    public abstract int getSerializedSizeAsMessageSet(T t);

    public abstract void makeImmutable(Object obj);

    /* renamed from: merge */
    public abstract T mo4144merge(T t, T t2);

    public final void mergeFrom(B b, InterfaceC0775Reader interfaceC0775Reader) {
        while (interfaceC0775Reader.getFieldNumber() != Integer.MAX_VALUE && mergeOneFieldFrom(b, interfaceC0775Reader)) {
        }
    }

    public final boolean mergeOneFieldFrom(B b, InterfaceC0775Reader interfaceC0775Reader) throws InvalidProtocolBufferException {
        int iMo3920getTag = interfaceC0775Reader.mo3920getTag();
        int tagFieldNumber = WireFormat.getTagFieldNumber(iMo3920getTag);
        int tagWireType = WireFormat.getTagWireType(iMo3920getTag);
        if (tagWireType == 0) {
            addVarint(b, tagFieldNumber, interfaceC0775Reader.readInt64());
            return true;
        }
        if (tagWireType == 1) {
            addFixed64(b, tagFieldNumber, interfaceC0775Reader.readFixed64());
            return true;
        }
        if (tagWireType == 2) {
            addLengthDelimited(b, tagFieldNumber, interfaceC0775Reader.readBytes());
            return true;
        }
        if (tagWireType != 3) {
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            addFixed32(b, tagFieldNumber, interfaceC0775Reader.readFixed32());
            return true;
        }
        B bNewBuilder = newBuilder();
        int iM4185makeTag = WireFormat.m4185makeTag(tagFieldNumber, 4);
        mergeFrom(bNewBuilder, interfaceC0775Reader);
        if (iM4185makeTag != interfaceC0775Reader.mo3920getTag()) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
        addGroup(b, tagFieldNumber, toImmutable(bNewBuilder));
        return true;
    }

    public abstract B newBuilder();

    public abstract void setBuilderToMessage(Object obj, B b);

    public abstract void setToMessage(Object obj, T t);

    public abstract boolean shouldDiscardUnknownFields(InterfaceC0775Reader interfaceC0775Reader);

    public abstract T toImmutable(B b);

    public abstract void writeAsMessageSetTo(T t, InterfaceC0811Writer interfaceC0811Writer);

    /* renamed from: writeTo */
    public abstract void mo4145writeTo(T t, InterfaceC0811Writer interfaceC0811Writer);
}
