package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.WireFormat;

/* loaded from: classes.dex */
public abstract class ExtensionLite<ContainingType extends MessageLite, Type> {
    public abstract Type getDefaultValue();

    public abstract WireFormat.FieldType getLiteType();

    public abstract MessageLite getMessageDefaultInstance();

    public abstract int getNumber();

    /* renamed from: isLite */
    public boolean m3981isLite() {
        return true;
    }

    public abstract boolean isRepeated();
}
