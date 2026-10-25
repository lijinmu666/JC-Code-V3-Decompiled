package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.conscrypt.BuildConfig;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Mixin */
/* loaded from: classes.dex */
public final class C0769Mixin extends GeneratedMessageLite<C0769Mixin, Builder> implements MixinOrBuilder {
    private static final C0769Mixin DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<C0769Mixin> f3732PARSER = null;
    public static final int ROOT_FIELD_NUMBER = 2;

    /* renamed from: name_ */
    private String f3733name_ = BuildConfig.f24315FLAVOR;

    /* renamed from: root_ */
    private String f3734root_ = BuildConfig.f24315FLAVOR;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Mixin$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3735xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3735xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3735xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3735xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3735xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3735xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3735xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3735xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Mixin$Builder */
    public static final class Builder extends GeneratedMessageLite.AbstractC0753Builder<C0769Mixin, Builder> implements MixinOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearName() {
            copyOnWrite();
            ((C0769Mixin) this.instance).clearName();
            return this;
        }

        public Builder clearRoot() {
            copyOnWrite();
            ((C0769Mixin) this.instance).clearRoot();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MixinOrBuilder
        /* renamed from: getName */
        public String mo4102getName() {
            return ((C0769Mixin) this.instance).mo4102getName();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MixinOrBuilder
        public ByteString getNameBytes() {
            return ((C0769Mixin) this.instance).getNameBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MixinOrBuilder
        /* renamed from: getRoot */
        public String mo4103getRoot() {
            return ((C0769Mixin) this.instance).mo4103getRoot();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MixinOrBuilder
        public ByteString getRootBytes() {
            return ((C0769Mixin) this.instance).getRootBytes();
        }

        /* renamed from: setName */
        public Builder m4104setName(String str) {
            copyOnWrite();
            ((C0769Mixin) this.instance).m4100setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((C0769Mixin) this.instance).setNameBytes(byteString);
            return this;
        }

        /* renamed from: setRoot */
        public Builder m4105setRoot(String str) {
            copyOnWrite();
            ((C0769Mixin) this.instance).m4101setRoot(str);
            return this;
        }

        public Builder setRootBytes(ByteString byteString) {
            copyOnWrite();
            ((C0769Mixin) this.instance).setRootBytes(byteString);
            return this;
        }

        private Builder() {
            super(C0769Mixin.DEFAULT_INSTANCE);
        }
    }

    static {
        C0769Mixin c0769Mixin = new C0769Mixin();
        DEFAULT_INSTANCE = c0769Mixin;
        GeneratedMessageLite.registerDefaultInstance(C0769Mixin.class, c0769Mixin);
    }

    private C0769Mixin() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.f3733name_ = getDefaultInstance().mo4102getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearRoot() {
        this.f3734root_ = getDefaultInstance().mo4103getRoot();
    }

    public static C0769Mixin getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static C0769Mixin parseDelimitedFrom(InputStream inputStream) {
        return (C0769Mixin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0769Mixin parseFrom(ByteBuffer byteBuffer) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<C0769Mixin> m4099parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setName */
    public void m4100setName(String str) {
        str.getClass();
        this.f3733name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3733name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setRoot */
    public void m4101setRoot(String str) {
        str.getClass();
        this.f3734root_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setRootBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3734root_ = byteString.toStringUtf8();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = AnonymousClass1.f3735xa1df5c61[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new C0769Mixin();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"name_", "root_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<C0769Mixin> defaultInstanceBasedParser = f3732PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (C0769Mixin.class) {
                        try {
                            defaultInstanceBasedParser = f3732PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3732PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MixinOrBuilder
    /* renamed from: getName */
    public String mo4102getName() {
        return this.f3733name_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MixinOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f3733name_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MixinOrBuilder
    /* renamed from: getRoot */
    public String mo4103getRoot() {
        return this.f3734root_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MixinOrBuilder
    public ByteString getRootBytes() {
        return ByteString.copyFromUtf8(this.f3734root_);
    }

    public static Builder newBuilder(C0769Mixin c0769Mixin) {
        return DEFAULT_INSTANCE.createBuilder(c0769Mixin);
    }

    public static C0769Mixin parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0769Mixin) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0769Mixin parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static C0769Mixin parseFrom(ByteString byteString) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static C0769Mixin parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static C0769Mixin parseFrom(byte[] bArr) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static C0769Mixin parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static C0769Mixin parseFrom(InputStream inputStream) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0769Mixin parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0769Mixin parseFrom(CodedInputStream codedInputStream) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static C0769Mixin parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0769Mixin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
