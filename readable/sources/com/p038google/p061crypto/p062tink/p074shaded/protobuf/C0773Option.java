package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0716Any;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.conscrypt.BuildConfig;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Option */
/* loaded from: classes.dex */
public final class C0773Option extends GeneratedMessageLite<C0773Option, Builder> implements OptionOrBuilder {
    private static final C0773Option DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<C0773Option> f3742PARSER = null;
    public static final int VALUE_FIELD_NUMBER = 2;

    /* renamed from: name_ */
    private String f3743name_ = BuildConfig.f24315FLAVOR;

    /* renamed from: value_ */
    private C0716Any f3744value_;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Option$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3745xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3745xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3745xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3745xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3745xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3745xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3745xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3745xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Option$Builder */
    public static final class Builder extends GeneratedMessageLite.AbstractC0753Builder<C0773Option, Builder> implements OptionOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearName() {
            copyOnWrite();
            ((C0773Option) this.instance).clearName();
            return this;
        }

        public Builder clearValue() {
            copyOnWrite();
            ((C0773Option) this.instance).clearValue();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.OptionOrBuilder
        /* renamed from: getName */
        public String mo4115getName() {
            return ((C0773Option) this.instance).mo4115getName();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.OptionOrBuilder
        public ByteString getNameBytes() {
            return ((C0773Option) this.instance).getNameBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.OptionOrBuilder
        public C0716Any getValue() {
            return ((C0773Option) this.instance).getValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.OptionOrBuilder
        public boolean hasValue() {
            return ((C0773Option) this.instance).hasValue();
        }

        public Builder mergeValue(C0716Any c0716Any) {
            copyOnWrite();
            ((C0773Option) this.instance).mergeValue(c0716Any);
            return this;
        }

        /* renamed from: setName */
        public Builder m4116setName(String str) {
            copyOnWrite();
            ((C0773Option) this.instance).m4114setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((C0773Option) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setValue(C0716Any c0716Any) {
            copyOnWrite();
            ((C0773Option) this.instance).setValue(c0716Any);
            return this;
        }

        private Builder() {
            super(C0773Option.DEFAULT_INSTANCE);
        }

        public Builder setValue(C0716Any.Builder builder) {
            copyOnWrite();
            ((C0773Option) this.instance).setValue(builder.mo3555build());
            return this;
        }
    }

    static {
        C0773Option c0773Option = new C0773Option();
        DEFAULT_INSTANCE = c0773Option;
        GeneratedMessageLite.registerDefaultInstance(C0773Option.class, c0773Option);
    }

    private C0773Option() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.f3743name_ = getDefaultInstance().mo4115getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValue() {
        this.f3744value_ = null;
    }

    public static C0773Option getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeValue(C0716Any c0716Any) {
        c0716Any.getClass();
        C0716Any c0716Any2 = this.f3744value_;
        if (c0716Any2 == null || c0716Any2 == C0716Any.getDefaultInstance()) {
            this.f3744value_ = c0716Any;
        } else {
            this.f3744value_ = C0716Any.newBuilder(this.f3744value_).mergeFrom((C0716Any.Builder) c0716Any).buildPartial();
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static C0773Option parseDelimitedFrom(InputStream inputStream) {
        return (C0773Option) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0773Option parseFrom(ByteBuffer byteBuffer) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<C0773Option> m4113parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setName */
    public void m4114setName(String str) {
        str.getClass();
        this.f3743name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3743name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValue(C0716Any c0716Any) {
        c0716Any.getClass();
        this.f3744value_ = c0716Any;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = AnonymousClass1.f3745xa1df5c61[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new C0773Option();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"name_", "value_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<C0773Option> defaultInstanceBasedParser = f3742PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (C0773Option.class) {
                        try {
                            defaultInstanceBasedParser = f3742PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3742PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.OptionOrBuilder
    /* renamed from: getName */
    public String mo4115getName() {
        return this.f3743name_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.OptionOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f3743name_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.OptionOrBuilder
    public C0716Any getValue() {
        C0716Any c0716Any = this.f3744value_;
        return c0716Any == null ? C0716Any.getDefaultInstance() : c0716Any;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.OptionOrBuilder
    public boolean hasValue() {
        return this.f3744value_ != null;
    }

    public static Builder newBuilder(C0773Option c0773Option) {
        return DEFAULT_INSTANCE.createBuilder(c0773Option);
    }

    public static C0773Option parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0773Option) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0773Option parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static C0773Option parseFrom(ByteString byteString) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static C0773Option parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static C0773Option parseFrom(byte[] bArr) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static C0773Option parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static C0773Option parseFrom(InputStream inputStream) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0773Option parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0773Option parseFrom(CodedInputStream codedInputStream) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static C0773Option parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0773Option) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
