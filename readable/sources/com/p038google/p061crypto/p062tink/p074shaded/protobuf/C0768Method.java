package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0773Option;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Method */
/* loaded from: classes.dex */
public final class C0768Method extends GeneratedMessageLite<C0768Method, Builder> implements MethodOrBuilder {
    private static final C0768Method DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 6;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<C0768Method> f3728PARSER = null;
    public static final int REQUEST_STREAMING_FIELD_NUMBER = 3;
    public static final int REQUEST_TYPE_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_STREAMING_FIELD_NUMBER = 5;
    public static final int RESPONSE_TYPE_URL_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    private boolean requestStreaming_;
    private boolean responseStreaming_;

    /* renamed from: syntax_ */
    private int f3730syntax_;

    /* renamed from: name_ */
    private String f3729name_ = BuildConfig.f24315FLAVOR;
    private String requestTypeUrl_ = BuildConfig.f24315FLAVOR;
    private String responseTypeUrl_ = BuildConfig.f24315FLAVOR;
    private Internal.ProtobufList<C0773Option> options_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Method$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3731xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3731xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3731xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3731xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3731xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3731xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3731xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3731xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Method$Builder */
    public static final class Builder extends GeneratedMessageLite.AbstractC0753Builder<C0768Method, Builder> implements MethodOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends C0773Option> iterable) {
            copyOnWrite();
            ((C0768Method) this.instance).addAllOptions(iterable);
            return this;
        }

        public Builder addOptions(C0773Option c0773Option) {
            copyOnWrite();
            ((C0768Method) this.instance).addOptions(c0773Option);
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((C0768Method) this.instance).clearName();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((C0768Method) this.instance).clearOptions();
            return this;
        }

        public Builder clearRequestStreaming() {
            copyOnWrite();
            ((C0768Method) this.instance).clearRequestStreaming();
            return this;
        }

        public Builder clearRequestTypeUrl() {
            copyOnWrite();
            ((C0768Method) this.instance).clearRequestTypeUrl();
            return this;
        }

        public Builder clearResponseStreaming() {
            copyOnWrite();
            ((C0768Method) this.instance).clearResponseStreaming();
            return this;
        }

        public Builder clearResponseTypeUrl() {
            copyOnWrite();
            ((C0768Method) this.instance).clearResponseTypeUrl();
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((C0768Method) this.instance).clearSyntax();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        /* renamed from: getName */
        public String mo4097getName() {
            return ((C0768Method) this.instance).mo4097getName();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public ByteString getNameBytes() {
            return ((C0768Method) this.instance).getNameBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public C0773Option getOptions(int i) {
            return ((C0768Method) this.instance).getOptions(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public int getOptionsCount() {
            return ((C0768Method) this.instance).getOptionsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public List<C0773Option> getOptionsList() {
            return Collections.unmodifiableList(((C0768Method) this.instance).getOptionsList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public boolean getRequestStreaming() {
            return ((C0768Method) this.instance).getRequestStreaming();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public String getRequestTypeUrl() {
            return ((C0768Method) this.instance).getRequestTypeUrl();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public ByteString getRequestTypeUrlBytes() {
            return ((C0768Method) this.instance).getRequestTypeUrlBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public boolean getResponseStreaming() {
            return ((C0768Method) this.instance).getResponseStreaming();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public String getResponseTypeUrl() {
            return ((C0768Method) this.instance).getResponseTypeUrl();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public ByteString getResponseTypeUrlBytes() {
            return ((C0768Method) this.instance).getResponseTypeUrlBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public EnumC0788Syntax getSyntax() {
            return ((C0768Method) this.instance).getSyntax();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
        public int getSyntaxValue() {
            return ((C0768Method) this.instance).getSyntaxValue();
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((C0768Method) this.instance).removeOptions(i);
            return this;
        }

        /* renamed from: setName */
        public Builder m4098setName(String str) {
            copyOnWrite();
            ((C0768Method) this.instance).m4096setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((C0768Method) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0768Method) this.instance).setOptions(i, c0773Option);
            return this;
        }

        public Builder setRequestStreaming(boolean z) {
            copyOnWrite();
            ((C0768Method) this.instance).setRequestStreaming(z);
            return this;
        }

        public Builder setRequestTypeUrl(String str) {
            copyOnWrite();
            ((C0768Method) this.instance).setRequestTypeUrl(str);
            return this;
        }

        public Builder setRequestTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((C0768Method) this.instance).setRequestTypeUrlBytes(byteString);
            return this;
        }

        public Builder setResponseStreaming(boolean z) {
            copyOnWrite();
            ((C0768Method) this.instance).setResponseStreaming(z);
            return this;
        }

        public Builder setResponseTypeUrl(String str) {
            copyOnWrite();
            ((C0768Method) this.instance).setResponseTypeUrl(str);
            return this;
        }

        public Builder setResponseTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((C0768Method) this.instance).setResponseTypeUrlBytes(byteString);
            return this;
        }

        public Builder setSyntax(EnumC0788Syntax enumC0788Syntax) {
            copyOnWrite();
            ((C0768Method) this.instance).setSyntax(enumC0788Syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            copyOnWrite();
            ((C0768Method) this.instance).setSyntaxValue(i);
            return this;
        }

        private Builder() {
            super(C0768Method.DEFAULT_INSTANCE);
        }

        public Builder addOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0768Method) this.instance).addOptions(i, c0773Option);
            return this;
        }

        public Builder setOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0768Method) this.instance).setOptions(i, builder.mo3555build());
            return this;
        }

        public Builder addOptions(C0773Option.Builder builder) {
            copyOnWrite();
            ((C0768Method) this.instance).addOptions(builder.mo3555build());
            return this;
        }

        public Builder addOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0768Method) this.instance).addOptions(i, builder.mo3555build());
            return this;
        }
    }

    static {
        C0768Method c0768Method = new C0768Method();
        DEFAULT_INSTANCE = c0768Method;
        GeneratedMessageLite.registerDefaultInstance(C0768Method.class, c0768Method);
    }

    private C0768Method() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends C0773Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(c0773Option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.f3729name_ = getDefaultInstance().mo4097getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestStreaming() {
        this.requestStreaming_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRequestTypeUrl() {
        this.requestTypeUrl_ = getDefaultInstance().getRequestTypeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseStreaming() {
        this.responseStreaming_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearResponseTypeUrl() {
        this.responseTypeUrl_ = getDefaultInstance().getResponseTypeUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSyntax() {
        this.f3730syntax_ = 0;
    }

    private void ensureOptionsIsMutable() {
        Internal.ProtobufList<C0773Option> protobufList = this.options_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static C0768Method getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static C0768Method parseDelimitedFrom(InputStream inputStream) {
        return (C0768Method) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0768Method parseFrom(ByteBuffer byteBuffer) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<C0768Method> m4095parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setName */
    public void m4096setName(String str) {
        str.getClass();
        this.f3729name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3729name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.set(i, c0773Option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestStreaming(boolean z) {
        this.requestStreaming_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestTypeUrl(String str) {
        str.getClass();
        this.requestTypeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRequestTypeUrlBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.requestTypeUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseStreaming(boolean z) {
        this.responseStreaming_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseTypeUrl(String str) {
        str.getClass();
        this.responseTypeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setResponseTypeUrlBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.responseTypeUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntax(EnumC0788Syntax enumC0788Syntax) {
        this.f3730syntax_ = enumC0788Syntax.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntaxValue(int i) {
        this.f3730syntax_ = i;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = AnonymousClass1.f3731xa1df5c61[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new C0768Method();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001Ȉ\u0002Ȉ\u0003\u0007\u0004Ȉ\u0005\u0007\u0006\u001b\u0007\f", new Object[]{"name_", "requestTypeUrl_", "requestStreaming_", "responseTypeUrl_", "responseStreaming_", "options_", C0773Option.class, "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<C0768Method> defaultInstanceBasedParser = f3728PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (C0768Method.class) {
                        try {
                            defaultInstanceBasedParser = f3728PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3728PARSER = defaultInstanceBasedParser;
                            }
                        } finally {
                        }
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    /* renamed from: getName */
    public String mo4097getName() {
        return this.f3729name_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f3729name_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public C0773Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public List<C0773Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public boolean getRequestStreaming() {
        return this.requestStreaming_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public String getRequestTypeUrl() {
        return this.requestTypeUrl_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public ByteString getRequestTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.requestTypeUrl_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public boolean getResponseStreaming() {
        return this.responseStreaming_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public String getResponseTypeUrl() {
        return this.responseTypeUrl_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public ByteString getResponseTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.responseTypeUrl_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public EnumC0788Syntax getSyntax() {
        EnumC0788Syntax enumC0788SyntaxForNumber = EnumC0788Syntax.forNumber(this.f3730syntax_);
        return enumC0788SyntaxForNumber == null ? EnumC0788Syntax.UNRECOGNIZED : enumC0788SyntaxForNumber;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MethodOrBuilder
    public int getSyntaxValue() {
        return this.f3730syntax_;
    }

    public static Builder newBuilder(C0768Method c0768Method) {
        return DEFAULT_INSTANCE.createBuilder(c0768Method);
    }

    public static C0768Method parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0768Method) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0768Method parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static C0768Method parseFrom(ByteString byteString) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i, c0773Option);
    }

    public static C0768Method parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static C0768Method parseFrom(byte[] bArr) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static C0768Method parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static C0768Method parseFrom(InputStream inputStream) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0768Method parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0768Method parseFrom(CodedInputStream codedInputStream) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static C0768Method parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0768Method) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
