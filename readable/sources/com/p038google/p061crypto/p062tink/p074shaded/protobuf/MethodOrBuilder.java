package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.List;

/* loaded from: classes.dex */
public interface MethodOrBuilder extends MessageLiteOrBuilder {
    /* renamed from: getName */
    String mo4097getName();

    ByteString getNameBytes();

    C0773Option getOptions(int i);

    int getOptionsCount();

    List<C0773Option> getOptionsList();

    boolean getRequestStreaming();

    String getRequestTypeUrl();

    ByteString getRequestTypeUrlBytes();

    boolean getResponseStreaming();

    String getResponseTypeUrl();

    ByteString getResponseTypeUrlBytes();

    EnumC0788Syntax getSyntax();

    int getSyntaxValue();
}
