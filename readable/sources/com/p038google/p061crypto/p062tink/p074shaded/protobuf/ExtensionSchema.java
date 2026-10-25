package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.google.crypto.tink.shaded.protobuf.FieldSet.FieldDescriptorLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldSet;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes.dex */
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    public abstract int extensionNumber(Map.Entry<?, ?> entry);

    public abstract Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i);

    public abstract FieldSet<T> getExtensions(Object obj);

    public abstract FieldSet<T> getMutableExtensions(Object obj);

    public abstract boolean hasExtensions(MessageLite messageLite);

    public abstract void makeImmutable(Object obj);

    public abstract <UT, UB> UB parseExtension(Object obj, InterfaceC0775Reader interfaceC0775Reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema);

    public abstract void parseLengthPrefixedMessageSetItem(InterfaceC0775Reader interfaceC0775Reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet);

    public abstract void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<T> fieldSet);

    public abstract void serializeExtension(InterfaceC0811Writer interfaceC0811Writer, Map.Entry<?, ?> entry);

    public abstract void setExtensions(Object obj, FieldSet<T> fieldSet);
}
