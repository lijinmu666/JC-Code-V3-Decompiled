package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0742Field;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0773Option;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.SourceContext;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Type */
/* loaded from: classes.dex */
public final class C0793Type extends GeneratedMessageLite<C0793Type, Builder> implements TypeOrBuilder {
    private static final C0793Type DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int ONEOFS_FIELD_NUMBER = 3;
    public static final int OPTIONS_FIELD_NUMBER = 4;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<C0793Type> f3788PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 6;
    private SourceContext sourceContext_;

    /* renamed from: syntax_ */
    private int f3792syntax_;

    /* renamed from: name_ */
    private String f3790name_ = BuildConfig.f24315FLAVOR;

    /* renamed from: fields_ */
    private Internal.ProtobufList<C0742Field> f3789fields_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: oneofs_ */
    private Internal.ProtobufList<String> f3791oneofs_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<C0773Option> options_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Type$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3793xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3793xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3793xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3793xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3793xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3793xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3793xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3793xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Type$Builder */
    public static final class Builder extends GeneratedMessageLite.AbstractC0753Builder<C0793Type, Builder> implements TypeOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFields(Iterable<? extends C0742Field> iterable) {
            copyOnWrite();
            ((C0793Type) this.instance).addAllFields(iterable);
            return this;
        }

        public Builder addAllOneofs(Iterable<String> iterable) {
            copyOnWrite();
            ((C0793Type) this.instance).addAllOneofs(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends C0773Option> iterable) {
            copyOnWrite();
            ((C0793Type) this.instance).addAllOptions(iterable);
            return this;
        }

        public Builder addFields(C0742Field c0742Field) {
            copyOnWrite();
            ((C0793Type) this.instance).addFields(c0742Field);
            return this;
        }

        public Builder addOneofs(String str) {
            copyOnWrite();
            ((C0793Type) this.instance).addOneofs(str);
            return this;
        }

        public Builder addOneofsBytes(ByteString byteString) {
            copyOnWrite();
            ((C0793Type) this.instance).addOneofsBytes(byteString);
            return this;
        }

        public Builder addOptions(C0773Option c0773Option) {
            copyOnWrite();
            ((C0793Type) this.instance).addOptions(c0773Option);
            return this;
        }

        public Builder clearFields() {
            copyOnWrite();
            ((C0793Type) this.instance).clearFields();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((C0793Type) this.instance).clearName();
            return this;
        }

        public Builder clearOneofs() {
            copyOnWrite();
            ((C0793Type) this.instance).clearOneofs();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((C0793Type) this.instance).clearOptions();
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            ((C0793Type) this.instance).clearSourceContext();
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((C0793Type) this.instance).clearSyntax();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public C0742Field getFields(int i) {
            return ((C0793Type) this.instance).getFields(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public int getFieldsCount() {
            return ((C0793Type) this.instance).getFieldsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public List<C0742Field> getFieldsList() {
            return Collections.unmodifiableList(((C0793Type) this.instance).getFieldsList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        /* renamed from: getName */
        public String mo4138getName() {
            return ((C0793Type) this.instance).mo4138getName();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public ByteString getNameBytes() {
            return ((C0793Type) this.instance).getNameBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public String getOneofs(int i) {
            return ((C0793Type) this.instance).getOneofs(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public ByteString getOneofsBytes(int i) {
            return ((C0793Type) this.instance).getOneofsBytes(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public int getOneofsCount() {
            return ((C0793Type) this.instance).getOneofsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public List<String> getOneofsList() {
            return Collections.unmodifiableList(((C0793Type) this.instance).getOneofsList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public C0773Option getOptions(int i) {
            return ((C0793Type) this.instance).getOptions(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public int getOptionsCount() {
            return ((C0793Type) this.instance).getOptionsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public List<C0773Option> getOptionsList() {
            return Collections.unmodifiableList(((C0793Type) this.instance).getOptionsList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public SourceContext getSourceContext() {
            return ((C0793Type) this.instance).getSourceContext();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public EnumC0788Syntax getSyntax() {
            return ((C0793Type) this.instance).getSyntax();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public int getSyntaxValue() {
            return ((C0793Type) this.instance).getSyntaxValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
        public boolean hasSourceContext() {
            return ((C0793Type) this.instance).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((C0793Type) this.instance).mergeSourceContext(sourceContext);
            return this;
        }

        public Builder removeFields(int i) {
            copyOnWrite();
            ((C0793Type) this.instance).removeFields(i);
            return this;
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((C0793Type) this.instance).removeOptions(i);
            return this;
        }

        public Builder setFields(int i, C0742Field c0742Field) {
            copyOnWrite();
            ((C0793Type) this.instance).setFields(i, c0742Field);
            return this;
        }

        /* renamed from: setName */
        public Builder m4139setName(String str) {
            copyOnWrite();
            ((C0793Type) this.instance).m4137setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((C0793Type) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setOneofs(int i, String str) {
            copyOnWrite();
            ((C0793Type) this.instance).setOneofs(i, str);
            return this;
        }

        public Builder setOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0793Type) this.instance).setOptions(i, c0773Option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((C0793Type) this.instance).setSourceContext(sourceContext);
            return this;
        }

        public Builder setSyntax(EnumC0788Syntax enumC0788Syntax) {
            copyOnWrite();
            ((C0793Type) this.instance).setSyntax(enumC0788Syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            copyOnWrite();
            ((C0793Type) this.instance).setSyntaxValue(i);
            return this;
        }

        private Builder() {
            super(C0793Type.DEFAULT_INSTANCE);
        }

        public Builder addFields(int i, C0742Field c0742Field) {
            copyOnWrite();
            ((C0793Type) this.instance).addFields(i, c0742Field);
            return this;
        }

        public Builder addOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0793Type) this.instance).addOptions(i, c0773Option);
            return this;
        }

        public Builder setFields(int i, C0742Field.Builder builder) {
            copyOnWrite();
            ((C0793Type) this.instance).setFields(i, builder.mo3555build());
            return this;
        }

        public Builder setOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0793Type) this.instance).setOptions(i, builder.mo3555build());
            return this;
        }

        public Builder setSourceContext(SourceContext.C0783Builder c0783Builder) {
            copyOnWrite();
            ((C0793Type) this.instance).setSourceContext(c0783Builder.mo3555build());
            return this;
        }

        public Builder addFields(C0742Field.Builder builder) {
            copyOnWrite();
            ((C0793Type) this.instance).addFields(builder.mo3555build());
            return this;
        }

        public Builder addOptions(C0773Option.Builder builder) {
            copyOnWrite();
            ((C0793Type) this.instance).addOptions(builder.mo3555build());
            return this;
        }

        public Builder addFields(int i, C0742Field.Builder builder) {
            copyOnWrite();
            ((C0793Type) this.instance).addFields(i, builder.mo3555build());
            return this;
        }

        public Builder addOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0793Type) this.instance).addOptions(i, builder.mo3555build());
            return this;
        }
    }

    static {
        C0793Type c0793Type = new C0793Type();
        DEFAULT_INSTANCE = c0793Type;
        GeneratedMessageLite.registerDefaultInstance(C0793Type.class, c0793Type);
    }

    private C0793Type() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllFields(Iterable<? extends C0742Field> iterable) {
        ensureFieldsIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.f3789fields_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOneofs(Iterable<String> iterable) {
        ensureOneofsIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.f3791oneofs_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends C0773Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFields(C0742Field c0742Field) {
        c0742Field.getClass();
        ensureFieldsIsMutable();
        this.f3789fields_.add(c0742Field);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOneofs(String str) {
        str.getClass();
        ensureOneofsIsMutable();
        this.f3791oneofs_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOneofsBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        ensureOneofsIsMutable();
        this.f3791oneofs_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(c0773Option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearFields() {
        this.f3789fields_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.f3790name_ = getDefaultInstance().mo4138getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOneofs() {
        this.f3791oneofs_ = GeneratedMessageLite.emptyProtobufList();
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
        this.f3792syntax_ = 0;
    }

    private void ensureFieldsIsMutable() {
        Internal.ProtobufList<C0742Field> protobufList = this.f3789fields_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.f3789fields_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureOneofsIsMutable() {
        Internal.ProtobufList<String> protobufList = this.f3791oneofs_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.f3791oneofs_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureOptionsIsMutable() {
        Internal.ProtobufList<C0773Option> protobufList = this.options_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static C0793Type getDefaultInstance() {
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

    public static C0793Type parseDelimitedFrom(InputStream inputStream) {
        return (C0793Type) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0793Type parseFrom(ByteBuffer byteBuffer) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<C0793Type> m4136parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeFields(int i) {
        ensureFieldsIsMutable();
        this.f3789fields_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setFields(int i, C0742Field c0742Field) {
        c0742Field.getClass();
        ensureFieldsIsMutable();
        this.f3789fields_.set(i, c0742Field);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setName */
    public void m4137setName(String str) {
        str.getClass();
        this.f3790name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3790name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOneofs(int i, String str) {
        str.getClass();
        ensureOneofsIsMutable();
        this.f3791oneofs_.set(i, str);
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
        this.f3792syntax_ = enumC0788Syntax.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntaxValue(int i) {
        this.f3792syntax_ = i;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = AnonymousClass1.f3793xa1df5c61[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new C0793Type();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003Ț\u0004\u001b\u0005\t\u0006\f", new Object[]{"name_", "fields_", C0742Field.class, "oneofs_", "options_", C0773Option.class, "sourceContext_", "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<C0793Type> defaultInstanceBasedParser = f3788PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (C0793Type.class) {
                        try {
                            defaultInstanceBasedParser = f3788PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3788PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public C0742Field getFields(int i) {
        return this.f3789fields_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public int getFieldsCount() {
        return this.f3789fields_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public List<C0742Field> getFieldsList() {
        return this.f3789fields_;
    }

    public FieldOrBuilder getFieldsOrBuilder(int i) {
        return this.f3789fields_.get(i);
    }

    public List<? extends FieldOrBuilder> getFieldsOrBuilderList() {
        return this.f3789fields_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    /* renamed from: getName */
    public String mo4138getName() {
        return this.f3790name_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f3790name_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public String getOneofs(int i) {
        return this.f3791oneofs_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public ByteString getOneofsBytes(int i) {
        return ByteString.copyFromUtf8(this.f3791oneofs_.get(i));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public int getOneofsCount() {
        return this.f3791oneofs_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public List<String> getOneofsList() {
        return this.f3791oneofs_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public C0773Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public List<C0773Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public EnumC0788Syntax getSyntax() {
        EnumC0788Syntax enumC0788SyntaxForNumber = EnumC0788Syntax.forNumber(this.f3792syntax_);
        return enumC0788SyntaxForNumber == null ? EnumC0788Syntax.UNRECOGNIZED : enumC0788SyntaxForNumber;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public int getSyntaxValue() {
        return this.f3792syntax_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.TypeOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    public static Builder newBuilder(C0793Type c0793Type) {
        return DEFAULT_INSTANCE.createBuilder(c0793Type);
    }

    public static C0793Type parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0793Type) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0793Type parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static C0793Type parseFrom(ByteString byteString) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addFields(int i, C0742Field c0742Field) {
        c0742Field.getClass();
        ensureFieldsIsMutable();
        this.f3789fields_.add(i, c0742Field);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i, c0773Option);
    }

    public static C0793Type parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static C0793Type parseFrom(byte[] bArr) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static C0793Type parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static C0793Type parseFrom(InputStream inputStream) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0793Type parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0793Type parseFrom(CodedInputStream codedInputStream) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static C0793Type parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0793Type) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
