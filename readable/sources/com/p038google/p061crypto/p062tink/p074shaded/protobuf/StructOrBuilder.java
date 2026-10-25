package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.Map;

/* loaded from: classes.dex */
public interface StructOrBuilder extends MessageLiteOrBuilder {
    boolean containsFields(String str);

    @Deprecated
    Map<String, C0802Value> getFields();

    int getFieldsCount();

    Map<String, C0802Value> getFieldsMap();

    C0802Value getFieldsOrDefault(String str, C0802Value c0802Value);

    C0802Value getFieldsOrThrow(String str);
}
