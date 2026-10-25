package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfParams;
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
public final class EciesAeadHkdfPublicKey extends GeneratedMessageLite<EciesAeadHkdfPublicKey, C0592Builder> implements EciesAeadHkdfPublicKeyOrBuilder {
    private static final EciesAeadHkdfPublicKey DEFAULT_INSTANCE;
    public static final int PARAMS_FIELD_NUMBER = 2;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<EciesAeadHkdfPublicKey> f3298PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final int X_FIELD_NUMBER = 3;
    public static final int Y_FIELD_NUMBER = 4;

    /* renamed from: params_ */
    private EciesAeadHkdfParams f3299params_;
    private int version_;

    /* renamed from: x_ */
    private ByteString f3300x_;

    /* renamed from: y_ */
    private ByteString f3301y_;

    /* renamed from: com.google.crypto.tink.proto.EciesAeadHkdfPublicKey$1 */
    public static /* synthetic */ class C05911 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3302xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3302xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3302xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3302xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3302xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3302xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3302xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3302xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.proto.EciesAeadHkdfPublicKey$Builder */
    public static final class C0592Builder extends GeneratedMessageLite.AbstractC0753Builder<EciesAeadHkdfPublicKey, C0592Builder> implements EciesAeadHkdfPublicKeyOrBuilder {
        public /* synthetic */ C0592Builder(C05911 c05911) {
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

        public C0592Builder clearParams() {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).clearParams();
            return this;
        }

        public C0592Builder clearVersion() {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).clearVersion();
            return this;
        }

        /* renamed from: clearX */
        public C0592Builder m3616clearX() {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).m3609clearX();
            return this;
        }

        /* renamed from: clearY */
        public C0592Builder m3617clearY() {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).m3610clearY();
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

        @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
        public EciesAeadHkdfParams getParams() {
            return ((EciesAeadHkdfPublicKey) this.instance).getParams();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
        public int getVersion() {
            return ((EciesAeadHkdfPublicKey) this.instance).getVersion();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
        /* renamed from: getX */
        public ByteString mo3614getX() {
            return ((EciesAeadHkdfPublicKey) this.instance).mo3614getX();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
        /* renamed from: getY */
        public ByteString mo3615getY() {
            return ((EciesAeadHkdfPublicKey) this.instance).mo3615getY();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
        public boolean hasParams() {
            return ((EciesAeadHkdfPublicKey) this.instance).hasParams();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return super.internalMergeFrom((C0592Builder) abstractMessageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public C0592Builder mergeParams(EciesAeadHkdfParams eciesAeadHkdfParams) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).mergeParams(eciesAeadHkdfParams);
            return this;
        }

        public C0592Builder setParams(EciesAeadHkdfParams eciesAeadHkdfParams) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).setParams(eciesAeadHkdfParams);
            return this;
        }

        public C0592Builder setVersion(int i) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).setVersion(i);
            return this;
        }

        /* renamed from: setX */
        public C0592Builder m3618setX(ByteString byteString) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).m3612setX(byteString);
            return this;
        }

        /* renamed from: setY */
        public C0592Builder m3619setY(ByteString byteString) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).m3613setY(byteString);
            return this;
        }

        private C0592Builder() {
            super(EciesAeadHkdfPublicKey.DEFAULT_INSTANCE);
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

        public C0592Builder setParams(EciesAeadHkdfParams.C0588Builder c0588Builder) {
            copyOnWrite();
            ((EciesAeadHkdfPublicKey) this.instance).setParams(c0588Builder.mo3555build());
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
        EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey = new EciesAeadHkdfPublicKey();
        DEFAULT_INSTANCE = eciesAeadHkdfPublicKey;
        GeneratedMessageLite.registerDefaultInstance(EciesAeadHkdfPublicKey.class, eciesAeadHkdfPublicKey);
    }

    private EciesAeadHkdfPublicKey() {
        ByteString byteString = ByteString.f3559EMPTY;
        this.f3300x_ = byteString;
        this.f3301y_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearParams() {
        this.f3299params_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearX */
    public void m3609clearX() {
        this.f3300x_ = getDefaultInstance().mo3614getX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearY */
    public void m3610clearY() {
        this.f3301y_ = getDefaultInstance().mo3615getY();
    }

    public static EciesAeadHkdfPublicKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeParams(EciesAeadHkdfParams eciesAeadHkdfParams) {
        eciesAeadHkdfParams.getClass();
        EciesAeadHkdfParams eciesAeadHkdfParams2 = this.f3299params_;
        if (eciesAeadHkdfParams2 == null || eciesAeadHkdfParams2 == EciesAeadHkdfParams.getDefaultInstance()) {
            this.f3299params_ = eciesAeadHkdfParams;
        } else {
            this.f3299params_ = EciesAeadHkdfParams.newBuilder(this.f3299params_).mergeFrom((EciesAeadHkdfParams.C0588Builder) eciesAeadHkdfParams).buildPartial();
        }
    }

    public static C0592Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static EciesAeadHkdfPublicKey parseDelimitedFrom(InputStream inputStream) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EciesAeadHkdfPublicKey parseFrom(ByteBuffer byteBuffer) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<EciesAeadHkdfPublicKey> m3611parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setParams(EciesAeadHkdfParams eciesAeadHkdfParams) {
        eciesAeadHkdfParams.getClass();
        this.f3299params_ = eciesAeadHkdfParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setX */
    public void m3612setX(ByteString byteString) {
        byteString.getClass();
        this.f3300x_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setY */
    public void m3613setY(ByteString byteString) {
        byteString.getClass();
        this.f3301y_ = byteString;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = C05911.f3302xa1df5c61[methodToInvoke.ordinal()];
        C05911 c05911 = null;
        switch (i) {
            case 1:
                return new EciesAeadHkdfPublicKey();
            case 2:
                return new C0592Builder(c05911);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"version_", "params_", "x_", "y_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<EciesAeadHkdfPublicKey> defaultInstanceBasedParser = f3298PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (EciesAeadHkdfPublicKey.class) {
                        try {
                            defaultInstanceBasedParser = f3298PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3298PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
    public EciesAeadHkdfParams getParams() {
        EciesAeadHkdfParams eciesAeadHkdfParams = this.f3299params_;
        return eciesAeadHkdfParams == null ? EciesAeadHkdfParams.getDefaultInstance() : eciesAeadHkdfParams;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
    /* renamed from: getX */
    public ByteString mo3614getX() {
        return this.f3300x_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
    /* renamed from: getY */
    public ByteString mo3615getY() {
        return this.f3301y_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKeyOrBuilder
    public boolean hasParams() {
        return this.f3299params_ != null;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder newBuilderForType() {
        return super.newBuilderForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder toBuilder() {
        return super.toBuilder();
    }

    public static C0592Builder newBuilder(EciesAeadHkdfPublicKey eciesAeadHkdfPublicKey) {
        return DEFAULT_INSTANCE.createBuilder(eciesAeadHkdfPublicKey);
    }

    public static EciesAeadHkdfPublicKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EciesAeadHkdfPublicKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EciesAeadHkdfPublicKey parseFrom(ByteString byteString) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EciesAeadHkdfPublicKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EciesAeadHkdfPublicKey parseFrom(byte[] bArr) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EciesAeadHkdfPublicKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EciesAeadHkdfPublicKey parseFrom(InputStream inputStream) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EciesAeadHkdfPublicKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EciesAeadHkdfPublicKey parseFrom(CodedInputStream codedInputStream) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EciesAeadHkdfPublicKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (EciesAeadHkdfPublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
