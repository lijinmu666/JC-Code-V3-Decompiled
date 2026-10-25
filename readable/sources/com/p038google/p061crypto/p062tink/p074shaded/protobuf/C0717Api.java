package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0768Method;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0769Mixin;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0773Option;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.SourceContext;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Api */
/* loaded from: classes.dex */
public final class C0717Api extends GeneratedMessageLite<C0717Api, Builder> implements ApiOrBuilder {
    private static final C0717Api DEFAULT_INSTANCE;
    public static final int METHODS_FIELD_NUMBER = 2;
    public static final int MIXINS_FIELD_NUMBER = 6;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int OPTIONS_FIELD_NUMBER = 3;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<C0717Api> f3527PARSER = null;
    public static final int SOURCE_CONTEXT_FIELD_NUMBER = 5;
    public static final int SYNTAX_FIELD_NUMBER = 7;
    public static final int VERSION_FIELD_NUMBER = 4;
    private SourceContext sourceContext_;

    /* renamed from: syntax_ */
    private int f3530syntax_;

    /* renamed from: name_ */
    private String f3529name_ = BuildConfig.f24315FLAVOR;
    private Internal.ProtobufList<C0768Method> methods_ = GeneratedMessageLite.emptyProtobufList();
    private Internal.ProtobufList<C0773Option> options_ = GeneratedMessageLite.emptyProtobufList();
    private String version_ = BuildConfig.f24315FLAVOR;

    /* renamed from: mixins_ */
    private Internal.ProtobufList<C0769Mixin> f3528mixins_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Api$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3531xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3531xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3531xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3531xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3531xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3531xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3531xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3531xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Api$Builder */
    public static final class Builder extends GeneratedMessageLite.AbstractC0753Builder<C0717Api, Builder> implements ApiOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllMethods(Iterable<? extends C0768Method> iterable) {
            copyOnWrite();
            ((C0717Api) this.instance).addAllMethods(iterable);
            return this;
        }

        public Builder addAllMixins(Iterable<? extends C0769Mixin> iterable) {
            copyOnWrite();
            ((C0717Api) this.instance).addAllMixins(iterable);
            return this;
        }

        public Builder addAllOptions(Iterable<? extends C0773Option> iterable) {
            copyOnWrite();
            ((C0717Api) this.instance).addAllOptions(iterable);
            return this;
        }

        public Builder addMethods(C0768Method c0768Method) {
            copyOnWrite();
            ((C0717Api) this.instance).addMethods(c0768Method);
            return this;
        }

        public Builder addMixins(C0769Mixin c0769Mixin) {
            copyOnWrite();
            ((C0717Api) this.instance).addMixins(c0769Mixin);
            return this;
        }

        public Builder addOptions(C0773Option c0773Option) {
            copyOnWrite();
            ((C0717Api) this.instance).addOptions(c0773Option);
            return this;
        }

        public Builder clearMethods() {
            copyOnWrite();
            ((C0717Api) this.instance).clearMethods();
            return this;
        }

        public Builder clearMixins() {
            copyOnWrite();
            ((C0717Api) this.instance).clearMixins();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((C0717Api) this.instance).clearName();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((C0717Api) this.instance).clearOptions();
            return this;
        }

        public Builder clearSourceContext() {
            copyOnWrite();
            ((C0717Api) this.instance).clearSourceContext();
            return this;
        }

        public Builder clearSyntax() {
            copyOnWrite();
            ((C0717Api) this.instance).clearSyntax();
            return this;
        }

        public Builder clearVersion() {
            copyOnWrite();
            ((C0717Api) this.instance).clearVersion();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public C0768Method getMethods(int i) {
            return ((C0717Api) this.instance).getMethods(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public int getMethodsCount() {
            return ((C0717Api) this.instance).getMethodsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public List<C0768Method> getMethodsList() {
            return Collections.unmodifiableList(((C0717Api) this.instance).getMethodsList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public C0769Mixin getMixins(int i) {
            return ((C0717Api) this.instance).getMixins(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public int getMixinsCount() {
            return ((C0717Api) this.instance).getMixinsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public List<C0769Mixin> getMixinsList() {
            return Collections.unmodifiableList(((C0717Api) this.instance).getMixinsList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        /* renamed from: getName */
        public String mo3917getName() {
            return ((C0717Api) this.instance).mo3917getName();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public ByteString getNameBytes() {
            return ((C0717Api) this.instance).getNameBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public C0773Option getOptions(int i) {
            return ((C0717Api) this.instance).getOptions(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public int getOptionsCount() {
            return ((C0717Api) this.instance).getOptionsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public List<C0773Option> getOptionsList() {
            return Collections.unmodifiableList(((C0717Api) this.instance).getOptionsList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public SourceContext getSourceContext() {
            return ((C0717Api) this.instance).getSourceContext();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public EnumC0788Syntax getSyntax() {
            return ((C0717Api) this.instance).getSyntax();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public int getSyntaxValue() {
            return ((C0717Api) this.instance).getSyntaxValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public String getVersion() {
            return ((C0717Api) this.instance).getVersion();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public ByteString getVersionBytes() {
            return ((C0717Api) this.instance).getVersionBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
        public boolean hasSourceContext() {
            return ((C0717Api) this.instance).hasSourceContext();
        }

        public Builder mergeSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((C0717Api) this.instance).mergeSourceContext(sourceContext);
            return this;
        }

        public Builder removeMethods(int i) {
            copyOnWrite();
            ((C0717Api) this.instance).removeMethods(i);
            return this;
        }

        public Builder removeMixins(int i) {
            copyOnWrite();
            ((C0717Api) this.instance).removeMixins(i);
            return this;
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((C0717Api) this.instance).removeOptions(i);
            return this;
        }

        public Builder setMethods(int i, C0768Method c0768Method) {
            copyOnWrite();
            ((C0717Api) this.instance).setMethods(i, c0768Method);
            return this;
        }

        public Builder setMixins(int i, C0769Mixin c0769Mixin) {
            copyOnWrite();
            ((C0717Api) this.instance).setMixins(i, c0769Mixin);
            return this;
        }

        /* renamed from: setName */
        public Builder m3918setName(String str) {
            copyOnWrite();
            ((C0717Api) this.instance).m3916setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((C0717Api) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0717Api) this.instance).setOptions(i, c0773Option);
            return this;
        }

        public Builder setSourceContext(SourceContext sourceContext) {
            copyOnWrite();
            ((C0717Api) this.instance).setSourceContext(sourceContext);
            return this;
        }

        public Builder setSyntax(EnumC0788Syntax enumC0788Syntax) {
            copyOnWrite();
            ((C0717Api) this.instance).setSyntax(enumC0788Syntax);
            return this;
        }

        public Builder setSyntaxValue(int i) {
            copyOnWrite();
            ((C0717Api) this.instance).setSyntaxValue(i);
            return this;
        }

        public Builder setVersion(String str) {
            copyOnWrite();
            ((C0717Api) this.instance).setVersion(str);
            return this;
        }

        public Builder setVersionBytes(ByteString byteString) {
            copyOnWrite();
            ((C0717Api) this.instance).setVersionBytes(byteString);
            return this;
        }

        private Builder() {
            super(C0717Api.DEFAULT_INSTANCE);
        }

        public Builder addMethods(int i, C0768Method c0768Method) {
            copyOnWrite();
            ((C0717Api) this.instance).addMethods(i, c0768Method);
            return this;
        }

        public Builder addMixins(int i, C0769Mixin c0769Mixin) {
            copyOnWrite();
            ((C0717Api) this.instance).addMixins(i, c0769Mixin);
            return this;
        }

        public Builder addOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0717Api) this.instance).addOptions(i, c0773Option);
            return this;
        }

        public Builder setMethods(int i, C0768Method.Builder builder) {
            copyOnWrite();
            ((C0717Api) this.instance).setMethods(i, builder.mo3555build());
            return this;
        }

        public Builder setMixins(int i, C0769Mixin.Builder builder) {
            copyOnWrite();
            ((C0717Api) this.instance).setMixins(i, builder.mo3555build());
            return this;
        }

        public Builder setOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0717Api) this.instance).setOptions(i, builder.mo3555build());
            return this;
        }

        public Builder setSourceContext(SourceContext.C0783Builder c0783Builder) {
            copyOnWrite();
            ((C0717Api) this.instance).setSourceContext(c0783Builder.mo3555build());
            return this;
        }

        public Builder addMethods(C0768Method.Builder builder) {
            copyOnWrite();
            ((C0717Api) this.instance).addMethods(builder.mo3555build());
            return this;
        }

        public Builder addMixins(C0769Mixin.Builder builder) {
            copyOnWrite();
            ((C0717Api) this.instance).addMixins(builder.mo3555build());
            return this;
        }

        public Builder addOptions(C0773Option.Builder builder) {
            copyOnWrite();
            ((C0717Api) this.instance).addOptions(builder.mo3555build());
            return this;
        }

        public Builder addMethods(int i, C0768Method.Builder builder) {
            copyOnWrite();
            ((C0717Api) this.instance).addMethods(i, builder.mo3555build());
            return this;
        }

        public Builder addMixins(int i, C0769Mixin.Builder builder) {
            copyOnWrite();
            ((C0717Api) this.instance).addMixins(i, builder.mo3555build());
            return this;
        }

        public Builder addOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0717Api) this.instance).addOptions(i, builder.mo3555build());
            return this;
        }
    }

    static {
        C0717Api c0717Api = new C0717Api();
        DEFAULT_INSTANCE = c0717Api;
        GeneratedMessageLite.registerDefaultInstance(C0717Api.class, c0717Api);
    }

    private C0717Api() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMethods(Iterable<? extends C0768Method> iterable) {
        ensureMethodsIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.methods_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllMixins(Iterable<? extends C0769Mixin> iterable) {
        ensureMixinsIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.f3528mixins_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends C0773Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMethods(C0768Method c0768Method) {
        c0768Method.getClass();
        ensureMethodsIsMutable();
        this.methods_.add(c0768Method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMixins(C0769Mixin c0769Mixin) {
        c0769Mixin.getClass();
        ensureMixinsIsMutable();
        this.f3528mixins_.add(c0769Mixin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(c0773Option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMethods() {
        this.methods_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearMixins() {
        this.f3528mixins_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.f3529name_ = getDefaultInstance().mo3917getName();
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
        this.f3530syntax_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = getDefaultInstance().getVersion();
    }

    private void ensureMethodsIsMutable() {
        Internal.ProtobufList<C0768Method> protobufList = this.methods_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.methods_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureMixinsIsMutable() {
        Internal.ProtobufList<C0769Mixin> protobufList = this.f3528mixins_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.f3528mixins_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    private void ensureOptionsIsMutable() {
        Internal.ProtobufList<C0773Option> protobufList = this.options_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static C0717Api getDefaultInstance() {
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

    public static C0717Api parseDelimitedFrom(InputStream inputStream) {
        return (C0717Api) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0717Api parseFrom(ByteBuffer byteBuffer) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<C0717Api> m3915parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMethods(int i) {
        ensureMethodsIsMutable();
        this.methods_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMixins(int i) {
        ensureMixinsIsMutable();
        this.f3528mixins_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMethods(int i, C0768Method c0768Method) {
        c0768Method.getClass();
        ensureMethodsIsMutable();
        this.methods_.set(i, c0768Method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setMixins(int i, C0769Mixin c0769Mixin) {
        c0769Mixin.getClass();
        ensureMixinsIsMutable();
        this.f3528mixins_.set(i, c0769Mixin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setName */
    public void m3916setName(String str) {
        str.getClass();
        this.f3529name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3529name_ = byteString.toStringUtf8();
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
        this.f3530syntax_ = enumC0788Syntax.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setSyntaxValue(int i) {
        this.f3530syntax_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(String str) {
        str.getClass();
        this.version_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersionBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.version_ = byteString.toStringUtf8();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = AnonymousClass1.f3531xa1df5c61[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new C0717Api();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0003\u0000\u0001Ȉ\u0002\u001b\u0003\u001b\u0004Ȉ\u0005\t\u0006\u001b\u0007\f", new Object[]{"name_", "methods_", C0768Method.class, "options_", C0773Option.class, "version_", "sourceContext_", "mixins_", C0769Mixin.class, "syntax_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<C0717Api> defaultInstanceBasedParser = f3527PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (C0717Api.class) {
                        try {
                            defaultInstanceBasedParser = f3527PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3527PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public C0768Method getMethods(int i) {
        return this.methods_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public int getMethodsCount() {
        return this.methods_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public List<C0768Method> getMethodsList() {
        return this.methods_;
    }

    public MethodOrBuilder getMethodsOrBuilder(int i) {
        return this.methods_.get(i);
    }

    public List<? extends MethodOrBuilder> getMethodsOrBuilderList() {
        return this.methods_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public C0769Mixin getMixins(int i) {
        return this.f3528mixins_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public int getMixinsCount() {
        return this.f3528mixins_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public List<C0769Mixin> getMixinsList() {
        return this.f3528mixins_;
    }

    public MixinOrBuilder getMixinsOrBuilder(int i) {
        return this.f3528mixins_.get(i);
    }

    public List<? extends MixinOrBuilder> getMixinsOrBuilderList() {
        return this.f3528mixins_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    /* renamed from: getName */
    public String mo3917getName() {
        return this.f3529name_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f3529name_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public C0773Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public List<C0773Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public SourceContext getSourceContext() {
        SourceContext sourceContext = this.sourceContext_;
        return sourceContext == null ? SourceContext.getDefaultInstance() : sourceContext;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public EnumC0788Syntax getSyntax() {
        EnumC0788Syntax enumC0788SyntaxForNumber = EnumC0788Syntax.forNumber(this.f3530syntax_);
        return enumC0788SyntaxForNumber == null ? EnumC0788Syntax.UNRECOGNIZED : enumC0788SyntaxForNumber;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public int getSyntaxValue() {
        return this.f3530syntax_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public String getVersion() {
        return this.version_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public ByteString getVersionBytes() {
        return ByteString.copyFromUtf8(this.version_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ApiOrBuilder
    public boolean hasSourceContext() {
        return this.sourceContext_ != null;
    }

    public static Builder newBuilder(C0717Api c0717Api) {
        return DEFAULT_INSTANCE.createBuilder(c0717Api);
    }

    public static C0717Api parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0717Api) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0717Api parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static C0717Api parseFrom(ByteString byteString) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMethods(int i, C0768Method c0768Method) {
        c0768Method.getClass();
        ensureMethodsIsMutable();
        this.methods_.add(i, c0768Method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addMixins(int i, C0769Mixin c0769Mixin) {
        c0769Mixin.getClass();
        ensureMixinsIsMutable();
        this.f3528mixins_.add(i, c0769Mixin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i, c0773Option);
    }

    public static C0717Api parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static C0717Api parseFrom(byte[] bArr) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static C0717Api parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static C0717Api parseFrom(InputStream inputStream) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0717Api parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0717Api parseFrom(CodedInputStream codedInputStream) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static C0717Api parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0717Api) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
