package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0773Option;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValue;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.SourceContext;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Enum */
/* loaded from: classes.dex */
public final class C0738Enum extends GeneratedMessageLite<C0738Enum, Builder> implements EnumOrBuilder {
    private static final C0738Enum DEFAULT_INSTANCE;
    public static final int ENUMVALUE_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<C0738Enum> f3616PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 4;
    public static final int SYNTAX_FIELD_NUMBER = 5;
    private SourceContext sourceContext_;

    /* renamed from: syntax_ */
    private int f3618syntax_;

    /* renamed from: name_ */
    private String f3617name_ = BuildConfig.f24315FLAVOR;
    private Internal.ProtobufList<EnumValue> enumvalue_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<C0773Option> options_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Enum$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3619xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3619xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3619xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3619xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3619xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3619xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3619xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3619xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Enum$Builder */
    public static final class Builder extends GeneratedMessageLite.AbstractC0753Builder<C0738Enum, Builder> implements EnumOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllEnumvalue(Iterable<? extends EnumValue> iterable) {
            copyOnWrite();
            ((C0738Enum) this.instance).addAllEnumvalue(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends C0773Option> iterable) {
            copyOnWrite();
            ((C0738Enum) this.instance).addAllOptions(iterable);
            return this;
        }

        public Builder addEnumvalue(EnumValue enumValue) {
            copyOnWrite();
            ((C0738Enum) this.instance).addEnumvalue(enumValue);
            return this;
        }

        public Builder addOptions(C0773Option c0773Option) {
            copyOnWrite();
            ((C0738Enum) this.instance).addOptions(c0773Option);
            return this;
        }

        public Builder clearEnumvalue() {
            copyOnWrite();
            ((C0738Enum) this.instance).clearEnumvalue();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((C0738Enum) this.instance).clearName();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((C0738Enum) this.instance).clearOptions();
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            ((C0738Enum) this.instance).clearSourceContext();
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((C0738Enum) this.instance).clearSyntax();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public EnumValue getEnumvalue(int i) {
            return ((C0738Enum) this.instance).getEnumvalue(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public int getEnumvalueCount() {
            return ((C0738Enum) this.instance).getEnumvalueCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public List<EnumValue> getEnumvalueList() {
            return Collections.unmodifiableList(((C0738Enum) this.instance).getEnumvalueList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        /* renamed from: getName */
        public String mo3974getName() {
            return ((C0738Enum) this.instance).mo3974getName();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public ByteString getNameBytes() {
            return ((C0738Enum) this.instance).getNameBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public C0773Option getOptions(int i) {
            return ((C0738Enum) this.instance).getOptions(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public int getOptionsCount() {
            return ((C0738Enum) this.instance).getOptionsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public List<C0773Option> getOptionsList() {
            return Collections.unmodifiableList(((C0738Enum) this.instance).getOptionsList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public SourceContext getSourceContext() {
            return ((C0738Enum) this.instance).getSourceContext();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public EnumC0788Syntax getSyntax() {
            return ((C0738Enum) this.instance).getSyntax();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public int getSyntaxValue() {
            return ((C0738Enum) this.instance).getSyntaxValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
        public boolean hasSourceContext() {
            return ((C0738Enum) this.instance).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((C0738Enum) this.instance).mergeSourceContext(sourceContext);
            return this;
        }

        public Builder removeEnumvalue(int i) {
            copyOnWrite();
            ((C0738Enum) this.instance).removeEnumvalue(i);
            return this;
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((C0738Enum) this.instance).removeOptions(i);
            return this;
        }

        public Builder setEnumvalue(int i, EnumValue enumValue) {
            copyOnWrite();
            ((C0738Enum) this.instance).setEnumvalue(i, enumValue);
            return this;
        }

        /* renamed from: setName */
        public Builder m3975setName(String str) {
            copyOnWrite();
            ((C0738Enum) this.instance).m3973setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((C0738Enum) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0738Enum) this.instance).setOptions(i, c0773Option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((C0738Enum) this.instance).setSourceContext(sourceContext);
            return this;
        }

        public Builder setSyntax(EnumC0788Syntax enumC0788Syntax) {
            copyOnWrite();
            ((C0738Enum) this.instance).setSyntax(enumC0788Syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            copyOnWrite();
            ((C0738Enum) this.instance).setSyntaxValue(i);
            return this;
        }

        private Builder() {
            super(C0738Enum.DEFAULT_INSTANCE);
        }

        public Builder addEnumvalue(int i, EnumValue enumValue) {
            copyOnWrite();
            ((C0738Enum) this.instance).addEnumvalue(i, enumValue);
            return this;
        }

        public Builder addOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0738Enum) this.instance).addOptions(i, c0773Option);
            return this;
        }

        public Builder setEnumvalue(int i, EnumValue.C0740Builder c0740Builder) {
            copyOnWrite();
            ((C0738Enum) this.instance).setEnumvalue(i, c0740Builder.mo3555build());
            return this;
        }

        public Builder setOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0738Enum) this.instance).setOptions(i, builder.mo3555build());
            return this;
        }

        public Builder setSourceContext(SourceContext.C0783Builder c0783Builder) {
            copyOnWrite();
            ((C0738Enum) this.instance).setSourceContext(c0783Builder.mo3555build());
            return this;
        }

        public Builder addEnumvalue(EnumValue.C0740Builder c0740Builder) {
            copyOnWrite();
            ((C0738Enum) this.instance).addEnumvalue(c0740Builder.mo3555build());
            return this;
        }

        public Builder addOptions(C0773Option.Builder builder) {
            copyOnWrite();
            ((C0738Enum) this.instance).addOptions(builder.mo3555build());
            return this;
        }

        public Builder addEnumvalue(int i, EnumValue.C0740Builder c0740Builder) {
            copyOnWrite();
            ((C0738Enum) this.instance).addEnumvalue(i, c0740Builder.mo3555build());
            return this;
        }

        public Builder addOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0738Enum) this.instance).addOptions(i, builder.mo3555build());
            return this;
        }
    }

    static {
        C0738Enum c0738Enum = new C0738Enum();
        DEFAULT_INSTANCE = c0738Enum;
        GeneratedMessageLite.registerDefaultInstance(C0738Enum.class, c0738Enum);
    }

    private C0738Enum() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllEnumvalue(Iterable<? extends EnumValue> iterable) {
        ensureEnumvalueIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.enumvalue_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends C0773Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnumvalue(EnumValue enumValue) {
        enumValue.getClass();
        ensureEnumvalueIsMutable();
        this.enumvalue_.add(enumValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(c0773Option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearEnumvalue() {
        this.enumvalue_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.f3617name_ = getDefaultInstance().mo3974getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSourceContext() {
        this.sourceContext_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearSyntax() {
        this.f3618syntax_ = 0;
    }

    private void ensureEnumvalueIsMutable() {
        Internal.ProtobufList<EnumValue> protobufList = this.enumvalue_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.enumvalue_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureOptionsIsMutable() {
        Internal.ProtobufList<C0773Option> protobufList = this.options_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static C0738Enum getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeSourceContext(SourceContext sourceContext) {
        sourceContext.getClass();
        SourceContext sourceContext2 = this.sourceContext_;
        if (sourceContext2 == null || sourceContext2 == SourceContext.getDefaultInstance()) {
            this.sourceContext_ = sourceContext;
        } else {
            this.sourceContext_ = SourceContext.newBuilder(this.sourceContext_).mergeFrom((SourceContext.C0783Builder) sourceContext).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static C0738Enum parseDelimitedFrom(InputStream inputStream) {
        return (C0738Enum) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0738Enum parseFrom(ByteBuffer byteBuffer) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<C0738Enum> m3972parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeEnumvalue(int i) {
        ensureEnumvalueIsMutable();
        this.enumvalue_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setEnumvalue(int i, EnumValue enumValue) {
        enumValue.getClass();
        ensureEnumvalueIsMutable();
        this.enumvalue_.set(i, enumValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setName */
    public void m3973setName(String str) {
        str.getClass();
        this.f3617name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3617name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.set(i, c0773Option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSourceContext(SourceContext sourceContext) {
        sourceContext.getClass();
        this.sourceContext_ = sourceContext;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntax(EnumC0788Syntax enumC0788Syntax) {
        this.f3618syntax_ = enumC0788Syntax.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntaxValue(int i) {
        this.f3618syntax_ = i;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = AnonymousClass1.f3619xa1df5c61[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new C0738Enum();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0002\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004\t\u0005\f", new Object[]{"name_", "enumvalue_", EnumValue.class, "options_", C0773Option.class, "sourceContext_", "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<C0738Enum> defaultInstanceBasedParser = f3616PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (C0738Enum.class) {
                        try {
                            defaultInstanceBasedParser = f3616PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3616PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public EnumValue getEnumvalue(int i) {
        return this.enumvalue_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public int getEnumvalueCount() {
        return this.enumvalue_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public List<EnumValue> getEnumvalueList() {
        return this.enumvalue_;
    }

    public EnumValueOrBuilder getEnumvalueOrBuilder(int i) {
        return this.enumvalue_.get(i);
    }

    public List<? extends EnumValueOrBuilder> getEnumvalueOrBuilderList() {
        return this.enumvalue_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    /* renamed from: getName */
    public String mo3974getName() {
        return this.f3617name_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f3617name_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public C0773Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public List<C0773Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public EnumC0788Syntax getSyntax() {
        EnumC0788Syntax enumC0788SyntaxForNumber = EnumC0788Syntax.forNumber(this.f3618syntax_);
        return enumC0788SyntaxForNumber == null ? EnumC0788Syntax.UNRECOGNIZED : enumC0788SyntaxForNumber;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public int getSyntaxValue() {
        return this.f3618syntax_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    public static Builder newBuilder(C0738Enum c0738Enum) {
        return DEFAULT_INSTANCE.createBuilder(c0738Enum);
    }

    public static C0738Enum parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0738Enum) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0738Enum parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static C0738Enum parseFrom(ByteString byteString) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addEnumvalue(int i, EnumValue enumValue) {
        enumValue.getClass();
        ensureEnumvalueIsMutable();
        this.enumvalue_.add(i, enumValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i, c0773Option);
    }

    public static C0738Enum parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static C0738Enum parseFrom(byte[] bArr) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static C0738Enum parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static C0738Enum parseFrom(InputStream inputStream) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0738Enum parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0738Enum parseFrom(CodedInputStream codedInputStream) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static C0738Enum parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0738Enum) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
