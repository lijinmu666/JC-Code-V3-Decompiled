package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacStreamingParams;
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
public final class AesCtrHmacStreamingKey extends GeneratedMessageLite<AesCtrHmacStreamingKey, C0528Builder> implements AesCtrHmacStreamingKeyOrBuilder {
    private static final AesCtrHmacStreamingKey DEFAULT_INSTANCE;
    public static final int KEY_VALUE_FIELD_NUMBER = 3;
    public static final int PARAMS_FIELD_NUMBER = 2;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<AesCtrHmacStreamingKey> f3221PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private ByteString keyValue_ = ByteString.f3559EMPTY;

    /* renamed from: params_ */
    private AesCtrHmacStreamingParams f3222params_;
    private int version_;

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacStreamingKey$1 */
    public static /* synthetic */ class C05271 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3223xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3223xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3223xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3223xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3223xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3223xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3223xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3223xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.proto.AesCtrHmacStreamingKey$Builder */
    public static final class C0528Builder extends GeneratedMessageLite.AbstractC0753Builder<AesCtrHmacStreamingKey, C0528Builder> implements AesCtrHmacStreamingKeyOrBuilder {
        public /* synthetic */ C0528Builder(C05271 c05271) {
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

        public C0528Builder clearKeyValue() {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).clearKeyValue();
            return this;
        }

        public C0528Builder clearParams() {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).clearParams();
            return this;
        }

        public C0528Builder clearVersion() {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).clearVersion();
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

        @Override // com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacStreamingKeyOrBuilder
        public ByteString getKeyValue() {
            return ((AesCtrHmacStreamingKey) this.instance).getKeyValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacStreamingKeyOrBuilder
        public AesCtrHmacStreamingParams getParams() {
            return ((AesCtrHmacStreamingKey) this.instance).getParams();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacStreamingKeyOrBuilder
        public int getVersion() {
            return ((AesCtrHmacStreamingKey) this.instance).getVersion();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacStreamingKeyOrBuilder
        public boolean hasParams() {
            return ((AesCtrHmacStreamingKey) this.instance).hasParams();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return super.internalMergeFrom((C0528Builder) abstractMessageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public C0528Builder mergeParams(AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).mergeParams(aesCtrHmacStreamingParams);
            return this;
        }

        public C0528Builder setKeyValue(ByteString byteString) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).setKeyValue(byteString);
            return this;
        }

        public C0528Builder setParams(AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).setParams(aesCtrHmacStreamingParams);
            return this;
        }

        public C0528Builder setVersion(int i) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).setVersion(i);
            return this;
        }

        private C0528Builder() {
            super(AesCtrHmacStreamingKey.DEFAULT_INSTANCE);
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

        public C0528Builder setParams(AesCtrHmacStreamingParams.C0532Builder c0532Builder) {
            copyOnWrite();
            ((AesCtrHmacStreamingKey) this.instance).setParams(c0532Builder.mo3555build());
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
        AesCtrHmacStreamingKey aesCtrHmacStreamingKey = new AesCtrHmacStreamingKey();
        DEFAULT_INSTANCE = aesCtrHmacStreamingKey;
        GeneratedMessageLite.registerDefaultInstance(AesCtrHmacStreamingKey.class, aesCtrHmacStreamingKey);
    }

    private AesCtrHmacStreamingKey() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKeyValue() {
        this.keyValue_ = getDefaultInstance().getKeyValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.f3222params_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static AesCtrHmacStreamingKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
        aesCtrHmacStreamingParams.getClass();
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams2 = this.f3222params_;
        if (aesCtrHmacStreamingParams2 == null || aesCtrHmacStreamingParams2 == AesCtrHmacStreamingParams.getDefaultInstance()) {
            this.f3222params_ = aesCtrHmacStreamingParams;
        } else {
            this.f3222params_ = AesCtrHmacStreamingParams.newBuilder(this.f3222params_).mergeFrom((AesCtrHmacStreamingParams.C0532Builder) aesCtrHmacStreamingParams).buildPartial();
        }
    }

    public static C0528Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static AesCtrHmacStreamingKey parseDelimitedFrom(InputStream inputStream) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacStreamingKey parseFrom(ByteBuffer byteBuffer) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<AesCtrHmacStreamingKey> m3565parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyValue(ByteString byteString) {
        byteString.getClass();
        this.keyValue_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(AesCtrHmacStreamingParams aesCtrHmacStreamingParams) {
        aesCtrHmacStreamingParams.getClass();
        this.f3222params_ = aesCtrHmacStreamingParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = C05271.f3223xa1df5c61[methodToInvoke.ordinal()];
        C05271 c05271 = null;
        switch (i) {
            case 1:
                return new AesCtrHmacStreamingKey();
            case 2:
                return new C0528Builder(c05271);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"version_", "params_", "keyValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<AesCtrHmacStreamingKey> defaultInstanceBasedParser = f3221PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (AesCtrHmacStreamingKey.class) {
                        try {
                            defaultInstanceBasedParser = f3221PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3221PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacStreamingKeyOrBuilder
    public ByteString getKeyValue() {
        return this.keyValue_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacStreamingKeyOrBuilder
    public AesCtrHmacStreamingParams getParams() {
        AesCtrHmacStreamingParams aesCtrHmacStreamingParams = this.f3222params_;
        return aesCtrHmacStreamingParams == null ? AesCtrHmacStreamingParams.getDefaultInstance() : aesCtrHmacStreamingParams;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacStreamingKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacStreamingKeyOrBuilder
    public boolean hasParams() {
        return this.f3222params_ != null;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder newBuilderForType() {
        return super.newBuilderForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder toBuilder() {
        return super.toBuilder();
    }

    public static C0528Builder newBuilder(AesCtrHmacStreamingKey aesCtrHmacStreamingKey) {
        return DEFAULT_INSTANCE.createBuilder(aesCtrHmacStreamingKey);
    }

    public static AesCtrHmacStreamingKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingKey parseFrom(ByteString byteString) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static AesCtrHmacStreamingKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingKey parseFrom(byte[] bArr) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static AesCtrHmacStreamingKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingKey parseFrom(InputStream inputStream) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static AesCtrHmacStreamingKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AesCtrHmacStreamingKey parseFrom(CodedInputStream codedInputStream) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AesCtrHmacStreamingKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (AesCtrHmacStreamingKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
