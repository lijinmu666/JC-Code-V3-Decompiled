package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssParams;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0774Parser;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class RsaSsaPssKeyFormat extends GeneratedMessageLite<RsaSsaPssKeyFormat, C0700Builder> implements RsaSsaPssKeyFormatOrBuilder {
    private static final RsaSsaPssKeyFormat DEFAULT_INSTANCE;
    public static final int MODULUS_SIZE_IN_BITS_FIELD_NUMBER = 2;
    public static final int PARAMS_FIELD_NUMBER = 1;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<RsaSsaPssKeyFormat> f3501PARSER = null;
    public static final int PUBLIC_EXPONENT_FIELD_NUMBER = 3;
    private int modulusSizeInBits_;

    /* renamed from: params_ */
    private RsaSsaPssParams f3502params_;
    private ByteString publicExponent_ = ByteString.f3559EMPTY;

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssKeyFormat$1 */
    public static /* synthetic */ class C06991 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3503xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3503xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3503xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3503xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3503xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3503xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3503xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3503xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssKeyFormat$Builder */
    public static final class C0700Builder extends GeneratedMessageLite.AbstractC0753Builder<RsaSsaPssKeyFormat, C0700Builder> implements RsaSsaPssKeyFormatOrBuilder {
        public /* synthetic */ C0700Builder(C06991 c06991) {
            this();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        /* renamed from: build */
        public /* bridge */ /* synthetic */ MessageLite mo3555build() {
            return super.mo3555build();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite buildPartial() {
            return super.buildPartial();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        /* renamed from: clear */
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mo3556clear() {
            return super.mo3556clear();
        }

        public C0700Builder clearModulusSizeInBits() {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).clearModulusSizeInBits();
            return this;
        }

        public C0700Builder clearParams() {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).clearParams();
            return this;
        }

        public C0700Builder clearPublicExponent() {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).clearPublicExponent();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mo3558clone() {
            return super.mo3558clone();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssKeyFormatOrBuilder
        public int getModulusSizeInBits() {
            return ((RsaSsaPssKeyFormat) this.instance).getModulusSizeInBits();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssKeyFormatOrBuilder
        public RsaSsaPssParams getParams() {
            return ((RsaSsaPssKeyFormat) this.instance).getParams();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssKeyFormatOrBuilder
        public ByteString getPublicExponent() {
            return ((RsaSsaPssKeyFormat) this.instance).getPublicExponent();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssKeyFormatOrBuilder
        public boolean hasParams() {
            return ((RsaSsaPssKeyFormat) this.instance).hasParams();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return super.internalMergeFrom((C0700Builder) abstractMessageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public C0700Builder mergeParams(RsaSsaPssParams rsaSsaPssParams) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).mergeParams(rsaSsaPssParams);
            return this;
        }

        public C0700Builder setModulusSizeInBits(int i) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setModulusSizeInBits(i);
            return this;
        }

        public C0700Builder setParams(RsaSsaPssParams rsaSsaPssParams) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setParams(rsaSsaPssParams);
            return this;
        }

        public C0700Builder setPublicExponent(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setPublicExponent(byteString);
            return this;
        }

        private C0700Builder() {
            super(RsaSsaPssKeyFormat.DEFAULT_INSTANCE);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mo3558clone() {
            return super.mo3558clone();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(byte[] bArr, int i, int i2) {
            return super.mergeFrom(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ Object mo3558clone() {
            return super.mo3558clone();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(bArr, i, i2, extensionRegistryLite);
        }

        public C0700Builder setParams(RsaSsaPssParams.C0702Builder c0702Builder) {
            copyOnWrite();
            ((RsaSsaPssKeyFormat) this.instance).setParams(c0702Builder.mo3555build());
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(ByteString byteString) {
            return super.mergeFrom(byteString);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(byteString, extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(CodedInputStream codedInputStream) {
            return super.mergeFrom(codedInputStream);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(MessageLite messageLite) {
            return super.mergeFrom(messageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(InputStream inputStream) {
            return super.mergeFrom(inputStream);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(inputStream, extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(byte[] bArr) {
            return super.mergeFrom(bArr);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(byte[] bArr, int i, int i2) {
            return super.mergeFrom(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(byte[] bArr, int i, int i2, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(bArr, i, i2, extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder mergeFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(bArr, extensionRegistryLite);
        }
    }

    static {
        RsaSsaPssKeyFormat rsaSsaPssKeyFormat = new RsaSsaPssKeyFormat();
        DEFAULT_INSTANCE = rsaSsaPssKeyFormat;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPssKeyFormat.class, rsaSsaPssKeyFormat);
    }

    private RsaSsaPssKeyFormat() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearModulusSizeInBits() {
        this.modulusSizeInBits_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.f3502params_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicExponent() {
        this.publicExponent_ = getDefaultInstance().getPublicExponent();
    }

    public static RsaSsaPssKeyFormat getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(RsaSsaPssParams rsaSsaPssParams) {
        rsaSsaPssParams.getClass();
        RsaSsaPssParams rsaSsaPssParams2 = this.f3502params_;
        if (rsaSsaPssParams2 == null || rsaSsaPssParams2 == RsaSsaPssParams.getDefaultInstance()) {
            this.f3502params_ = rsaSsaPssParams;
        } else {
            this.f3502params_ = RsaSsaPssParams.newBuilder(this.f3502params_).mergeFrom((RsaSsaPssParams.C0702Builder) rsaSsaPssParams).buildPartial();
        }
    }

    public static C0700Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RsaSsaPssKeyFormat parseDelimitedFrom(InputStream inputStream) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteBuffer byteBuffer) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<RsaSsaPssKeyFormat> m3860parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setModulusSizeInBits(int i) {
        this.modulusSizeInBits_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(RsaSsaPssParams rsaSsaPssParams) {
        rsaSsaPssParams.getClass();
        this.f3502params_ = rsaSsaPssParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicExponent(ByteString byteString) {
        byteString.getClass();
        this.publicExponent_ = byteString;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = C06991.f3503xa1df5c61[methodToInvoke.ordinal()];
        C06991 c06991 = null;
        switch (i) {
            case 1:
                return new RsaSsaPssKeyFormat();
            case 2:
                return new C0700Builder(c06991);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\n", new Object[]{"params_", "modulusSizeInBits_", "publicExponent_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<RsaSsaPssKeyFormat> defaultInstanceBasedParser = f3501PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (RsaSsaPssKeyFormat.class) {
                        try {
                            defaultInstanceBasedParser = f3501PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3501PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return super.getDefaultInstanceForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssKeyFormatOrBuilder
    public int getModulusSizeInBits() {
        return this.modulusSizeInBits_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssKeyFormatOrBuilder
    public RsaSsaPssParams getParams() {
        RsaSsaPssParams rsaSsaPssParams = this.f3502params_;
        return rsaSsaPssParams == null ? RsaSsaPssParams.getDefaultInstance() : rsaSsaPssParams;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssKeyFormatOrBuilder
    public ByteString getPublicExponent() {
        return this.publicExponent_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssKeyFormatOrBuilder
    public boolean hasParams() {
        return this.f3502params_ != null;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder newBuilderForType() {
        return super.newBuilderForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder toBuilder() {
        return super.toBuilder();
    }

    public static C0700Builder newBuilder(RsaSsaPssKeyFormat rsaSsaPssKeyFormat) {
        return DEFAULT_INSTANCE.createBuilder(rsaSsaPssKeyFormat);
    }

    public static RsaSsaPssKeyFormat parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteString byteString) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RsaSsaPssKeyFormat parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseFrom(byte[] bArr) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RsaSsaPssKeyFormat parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseFrom(InputStream inputStream) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPssKeyFormat parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPssKeyFormat parseFrom(CodedInputStream codedInputStream) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RsaSsaPssKeyFormat parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssKeyFormat) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
