package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0742Field;
import java.util.List;

/* loaded from: classes.dex */
public interface FieldOrBuilder extends MessageLiteOrBuilder {
    C0742Field.Cardinality getCardinality();

    int getCardinalityValue();

    String getDefaultValue();

    ByteString getDefaultValueBytes();

    String getJsonName();

    ByteString getJsonNameBytes();

    /* renamed from: getKind */
    C0742Field.Kind mo3991getKind();

    int getKindValue();

    /* renamed from: getName */
    String mo3992getName();

    ByteString getNameBytes();

    int getNumber();

    int getOneofIndex();

    C0773Option getOptions(int i);

    int getOptionsCount();

    List<C0773Option> getOptionsList();

    boolean getPacked();

    String getTypeUrl();

    ByteString getTypeUrlBytes();
}
