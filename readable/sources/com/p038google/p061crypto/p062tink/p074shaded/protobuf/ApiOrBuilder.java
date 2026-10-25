package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface ApiOrBuilder extends MessageLiteOrBuilder {
    C0768Method getMethods(int i);

    int getMethodsCount();

    List<C0768Method> getMethodsList();

    C0769Mixin getMixins(int i);

    int getMixinsCount();

    List<C0769Mixin> getMixinsList();

    /* renamed from: getName */
    String mo3917getName();

    ByteString getNameBytes();

    C0773Option getOptions(int i);

    int getOptionsCount();

    List<C0773Option> getOptionsList();

    SourceContext getSourceContext();

    EnumC0788Syntax getSyntax();

    int getSyntaxValue();

    String getVersion();

    ByteString getVersionBytes();

    boolean hasSourceContext();
}
