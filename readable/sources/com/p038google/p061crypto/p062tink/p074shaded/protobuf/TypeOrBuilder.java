package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface TypeOrBuilder extends MessageLiteOrBuilder {
    C0742Field getFields(int i);

    int getFieldsCount();

    List<C0742Field> getFieldsList();

    /* renamed from: getName */
    String mo4138getName();

    ByteString getNameBytes();

    String getOneofs(int i);

    ByteString getOneofsBytes(int i);

    int getOneofsCount();

    List<String> getOneofsList();

    C0773Option getOptions(int i);

    int getOptionsCount();

    List<C0773Option> getOptionsList();

    SourceContext getSourceContext();

    EnumC0788Syntax getSyntax();

    int getSyntaxValue();

    boolean hasSourceContext();
}
