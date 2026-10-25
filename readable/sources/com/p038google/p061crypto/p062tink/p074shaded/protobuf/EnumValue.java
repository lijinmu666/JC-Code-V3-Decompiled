package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0773Option;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class EnumValue extends GeneratedMessageLite<EnumValue, C0740Builder> implements EnumValueOrBuilder {
    private static final EnumValue DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    public static final int NUMBER_FIELD_NUMBER = 2;
    public static final int OPTIONS_FIELD_NUMBER = 3;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<EnumValue> f3620PARSER;

    /* renamed from: number_ */
    private int f3622number_;

    /* renamed from: name_ */
    private String f3621name_ = BuildConfig.f24315FLAVOR;
    private Internal.ProtobufList<C0773Option> options_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.EnumValue$1 */
    public static /* synthetic */ class C07391 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3623xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3623xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3623xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3623xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3623xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3623xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3623xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3623xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.EnumValue$Builder */
    public static final class C0740Builder extends GeneratedMessageLite.AbstractC0753Builder<EnumValue, C0740Builder> implements EnumValueOrBuilder {
        public /* synthetic */ C0740Builder(C07391 c07391) {
            this();
        }

        public C0740Builder addAllOptions(Iterable<? extends C0773Option> iterable) {
            copyOnWrite();
            ((EnumValue) this.instance).addAllOptions(iterable);
            return this;
        }

        public C0740Builder addOptions(C0773Option c0773Option) {
            copyOnWrite();
            ((EnumValue) this.instance).addOptions(c0773Option);
            return this;
        }

        public C0740Builder clearName() {
            copyOnWrite();
            ((EnumValue) this.instance).clearName();
            return this;
        }

        public C0740Builder clearNumber() {
            copyOnWrite();
            ((EnumValue) this.instance).clearNumber();
            return this;
        }

        public C0740Builder clearOptions() {
            copyOnWrite();
            ((EnumValue) this.instance).clearOptions();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
        /* renamed from: getName */
        public String mo3978getName() {
            return ((EnumValue) this.instance).mo3978getName();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
        public ByteString getNameBytes() {
            return ((EnumValue) this.instance).getNameBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
        public int getNumber() {
            return ((EnumValue) this.instance).getNumber();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
        public C0773Option getOptions(int i) {
            return ((EnumValue) this.instance).getOptions(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
        public int getOptionsCount() {
            return ((EnumValue) this.instance).getOptionsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
        public List<C0773Option> getOptionsList() {
            return Collections.unmodifiableList(((EnumValue) this.instance).getOptionsList());
        }

        public C0740Builder removeOptions(int i) {
            copyOnWrite();
            ((EnumValue) this.instance).removeOptions(i);
            return this;
        }

        /* renamed from: setName */
        public C0740Builder m3979setName(String str) {
            copyOnWrite();
            ((EnumValue) this.instance).m3977setName(str);
            return this;
        }

        public C0740Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((EnumValue) this.instance).setNameBytes(byteString);
            return this;
        }

        public C0740Builder setNumber(int i) {
            copyOnWrite();
            ((EnumValue) this.instance).setNumber(i);
            return this;
        }

        public C0740Builder setOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((EnumValue) this.instance).setOptions(i, c0773Option);
            return this;
        }

        private C0740Builder() {
            super(EnumValue.DEFAULT_INSTANCE);
        }

        public C0740Builder addOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((EnumValue) this.instance).addOptions(i, c0773Option);
            return this;
        }

        public C0740Builder setOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((EnumValue) this.instance).setOptions(i, builder.mo3555build());
            return this;
        }

        public C0740Builder addOptions(C0773Option.Builder builder) {
            copyOnWrite();
            ((EnumValue) this.instance).addOptions(builder.mo3555build());
            return this;
        }

        public C0740Builder addOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((EnumValue) this.instance).addOptions(i, builder.mo3555build());
            return this;
        }
    }

    static {
        EnumValue enumValue = new EnumValue();
        DEFAULT_INSTANCE = enumValue;
        GeneratedMessageLite.registerDefaultInstance(EnumValue.class, enumValue);
    }

    private EnumValue() {
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
        this.f3621name_ = getDefaultInstance().mo3978getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumber() {
        this.f3622number_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureOptionsIsMutable() {
        Internal.ProtobufList<C0773Option> protobufList = this.options_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static EnumValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C0740Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream) {
        return (EnumValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<EnumValue> m3976parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setName */
    public void m3977setName(String str) {
        str.getClass();
        this.f3621name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3621name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumber(int i) {
        this.f3622number_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.set(i, c0773Option);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = C07391.f3623xa1df5c61[methodToInvoke.ordinal()];
        C07391 c07391 = null;
        switch (i) {
            case 1:
                return new EnumValue();
            case 2:
                return new C0740Builder(c07391);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0001\u0000\u0001Ȉ\u0002\u0004\u0003\u001b", new Object[]{"name_", "number_", "options_", C0773Option.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<EnumValue> defaultInstanceBasedParser = f3620PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (EnumValue.class) {
                        try {
                            defaultInstanceBasedParser = f3620PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3620PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
    /* renamed from: getName */
    public String mo3978getName() {
        return this.f3621name_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f3621name_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
    public int getNumber() {
        return this.f3622number_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
    public C0773Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.EnumValueOrBuilder
    public List<C0773Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    public static C0740Builder newBuilder(EnumValue enumValue) {
        return DEFAULT_INSTANCE.createBuilder(enumValue);
    }

    public static EnumValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EnumValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EnumValue parseFrom(ByteString byteString) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i, c0773Option);
    }

    public static EnumValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EnumValue parseFrom(byte[] bArr) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EnumValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EnumValue parseFrom(InputStream inputStream) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnumValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EnumValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EnumValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
