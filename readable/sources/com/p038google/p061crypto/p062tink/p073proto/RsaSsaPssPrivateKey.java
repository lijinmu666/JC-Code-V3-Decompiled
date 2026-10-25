package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPublicKey;
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
public final class RsaSsaPssPrivateKey extends GeneratedMessageLite<RsaSsaPssPrivateKey, C0704Builder> implements RsaSsaPssPrivateKeyOrBuilder {
    public static final int CRT_FIELD_NUMBER = 8;
    private static final RsaSsaPssPrivateKey DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<RsaSsaPssPrivateKey> f3506PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;

    /* renamed from: crt_ */
    private ByteString f3507crt_;

    /* renamed from: d_ */
    private ByteString f3508d_;

    /* renamed from: dp_ */
    private ByteString f3509dp_;

    /* renamed from: dq_ */
    private ByteString f3510dq_;

    /* renamed from: p_ */
    private ByteString f3511p_;
    private RsaSsaPssPublicKey publicKey_;

    /* renamed from: q_ */
    private ByteString f3512q_;
    private int version_;

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssPrivateKey$1 */
    public static /* synthetic */ class C07031 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3513xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3513xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3513xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3513xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3513xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3513xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3513xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3513xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.proto.RsaSsaPssPrivateKey$Builder */
    public static final class C0704Builder extends GeneratedMessageLite.AbstractC0753Builder<RsaSsaPssPrivateKey, C0704Builder> implements RsaSsaPssPrivateKeyOrBuilder {
        public /* synthetic */ C0704Builder(C07031 c07031) {
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

        public C0704Builder clearCrt() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearCrt();
            return this;
        }

        /* renamed from: clearD */
        public C0704Builder m3880clearD() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3862clearD();
            return this;
        }

        /* renamed from: clearDp */
        public C0704Builder m3881clearDp() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3863clearDp();
            return this;
        }

        /* renamed from: clearDq */
        public C0704Builder m3882clearDq() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3864clearDq();
            return this;
        }

        /* renamed from: clearP */
        public C0704Builder m3883clearP() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3865clearP();
            return this;
        }

        public C0704Builder clearPublicKey() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearPublicKey();
            return this;
        }

        /* renamed from: clearQ */
        public C0704Builder m3884clearQ() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3866clearQ();
            return this;
        }

        public C0704Builder clearVersion() {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mo3558clone() {
            return super.mo3558clone();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getCrt */
        public ByteString mo3874getCrt() {
            return ((RsaSsaPssPrivateKey) this.instance).mo3874getCrt();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getD */
        public ByteString mo3875getD() {
            return ((RsaSsaPssPrivateKey) this.instance).mo3875getD();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getDp */
        public ByteString mo3876getDp() {
            return ((RsaSsaPssPrivateKey) this.instance).mo3876getDp();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getDq */
        public ByteString mo3877getDq() {
            return ((RsaSsaPssPrivateKey) this.instance).mo3877getDq();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getP */
        public ByteString mo3878getP() {
            return ((RsaSsaPssPrivateKey) this.instance).mo3878getP();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
        public RsaSsaPssPublicKey getPublicKey() {
            return ((RsaSsaPssPrivateKey) this.instance).getPublicKey();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getQ */
        public ByteString mo3879getQ() {
            return ((RsaSsaPssPrivateKey) this.instance).mo3879getQ();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
        public int getVersion() {
            return ((RsaSsaPssPrivateKey) this.instance).getVersion();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
        public boolean hasPublicKey() {
            return ((RsaSsaPssPrivateKey) this.instance).hasPublicKey();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return super.internalMergeFrom((C0704Builder) abstractMessageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public C0704Builder mergePublicKey(RsaSsaPssPublicKey rsaSsaPssPublicKey) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).mergePublicKey(rsaSsaPssPublicKey);
            return this;
        }

        /* renamed from: setCrt */
        public C0704Builder m3885setCrt(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3868setCrt(byteString);
            return this;
        }

        /* renamed from: setD */
        public C0704Builder m3886setD(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3869setD(byteString);
            return this;
        }

        /* renamed from: setDp */
        public C0704Builder m3887setDp(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3870setDp(byteString);
            return this;
        }

        /* renamed from: setDq */
        public C0704Builder m3888setDq(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3871setDq(byteString);
            return this;
        }

        /* renamed from: setP */
        public C0704Builder m3889setP(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3872setP(byteString);
            return this;
        }

        public C0704Builder setPublicKey(RsaSsaPssPublicKey rsaSsaPssPublicKey) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setPublicKey(rsaSsaPssPublicKey);
            return this;
        }

        /* renamed from: setQ */
        public C0704Builder m3890setQ(ByteString byteString) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).m3873setQ(byteString);
            return this;
        }

        public C0704Builder setVersion(int i) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setVersion(i);
            return this;
        }

        private C0704Builder() {
            super(RsaSsaPssPrivateKey.DEFAULT_INSTANCE);
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

        public C0704Builder setPublicKey(RsaSsaPssPublicKey.C0706Builder c0706Builder) {
            copyOnWrite();
            ((RsaSsaPssPrivateKey) this.instance).setPublicKey(c0706Builder.mo3555build());
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
        RsaSsaPssPrivateKey rsaSsaPssPrivateKey = new RsaSsaPssPrivateKey();
        DEFAULT_INSTANCE = rsaSsaPssPrivateKey;
        GeneratedMessageLite.registerDefaultInstance(RsaSsaPssPrivateKey.class, rsaSsaPssPrivateKey);
    }

    private RsaSsaPssPrivateKey() {
        ByteString byteString = ByteString.f3559EMPTY;
        this.f3508d_ = byteString;
        this.f3511p_ = byteString;
        this.f3512q_ = byteString;
        this.f3509dp_ = byteString;
        this.f3510dq_ = byteString;
        this.f3507crt_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCrt() {
        this.f3507crt_ = getDefaultInstance().mo3874getCrt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearD */
    public void m3862clearD() {
        this.f3508d_ = getDefaultInstance().mo3875getD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearDp */
    public void m3863clearDp() {
        this.f3509dp_ = getDefaultInstance().mo3876getDp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearDq */
    public void m3864clearDq() {
        this.f3510dq_ = getDefaultInstance().mo3877getDq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearP */
    public void m3865clearP() {
        this.f3511p_ = getDefaultInstance().mo3878getP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearQ */
    public void m3866clearQ() {
        this.f3512q_ = getDefaultInstance().mo3879getQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static RsaSsaPssPrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePublicKey(RsaSsaPssPublicKey rsaSsaPssPublicKey) {
        rsaSsaPssPublicKey.getClass();
        RsaSsaPssPublicKey rsaSsaPssPublicKey2 = this.publicKey_;
        if (rsaSsaPssPublicKey2 == null || rsaSsaPssPublicKey2 == RsaSsaPssPublicKey.getDefaultInstance()) {
            this.publicKey_ = rsaSsaPssPublicKey;
        } else {
            this.publicKey_ = RsaSsaPssPublicKey.newBuilder(this.publicKey_).mergeFrom((RsaSsaPssPublicKey.C0706Builder) rsaSsaPssPublicKey).buildPartial();
        }
    }

    public static C0704Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static RsaSsaPssPrivateKey parseDelimitedFrom(InputStream inputStream) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPssPrivateKey parseFrom(ByteBuffer byteBuffer) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<RsaSsaPssPrivateKey> m3867parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCrt */
    public void m3868setCrt(ByteString byteString) {
        byteString.getClass();
        this.f3507crt_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setD */
    public void m3869setD(ByteString byteString) {
        byteString.getClass();
        this.f3508d_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDp */
    public void m3870setDp(ByteString byteString) {
        byteString.getClass();
        this.f3509dp_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDq */
    public void m3871setDq(ByteString byteString) {
        byteString.getClass();
        this.f3510dq_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setP */
    public void m3872setP(ByteString byteString) {
        byteString.getClass();
        this.f3511p_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicKey(RsaSsaPssPublicKey rsaSsaPssPublicKey) {
        rsaSsaPssPublicKey.getClass();
        this.publicKey_ = rsaSsaPssPublicKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setQ */
    public void m3873setQ(ByteString byteString) {
        byteString.getClass();
        this.f3512q_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = C07031.f3513xa1df5c61[methodToInvoke.ordinal()];
        C07031 c07031 = null;
        switch (i) {
            case 1:
                return new RsaSsaPssPrivateKey();
            case 2:
                return new C0704Builder(c07031);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"version_", "publicKey_", "d_", "p_", "q_", "dp_", "dq_", "crt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<RsaSsaPssPrivateKey> defaultInstanceBasedParser = f3506PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (RsaSsaPssPrivateKey.class) {
                        try {
                            defaultInstanceBasedParser = f3506PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3506PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getCrt */
    public ByteString mo3874getCrt() {
        return this.f3507crt_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getD */
    public ByteString mo3875getD() {
        return this.f3508d_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return super.getDefaultInstanceForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getDp */
    public ByteString mo3876getDp() {
        return this.f3509dp_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getDq */
    public ByteString mo3877getDq() {
        return this.f3510dq_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getP */
    public ByteString mo3878getP() {
        return this.f3511p_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
    public RsaSsaPssPublicKey getPublicKey() {
        RsaSsaPssPublicKey rsaSsaPssPublicKey = this.publicKey_;
        return rsaSsaPssPublicKey == null ? RsaSsaPssPublicKey.getDefaultInstance() : rsaSsaPssPublicKey;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getQ */
    public ByteString mo3879getQ() {
        return this.f3512q_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKeyOrBuilder
    public boolean hasPublicKey() {
        return this.publicKey_ != null;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder newBuilderForType() {
        return super.newBuilderForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder toBuilder() {
        return super.toBuilder();
    }

    public static C0704Builder newBuilder(RsaSsaPssPrivateKey rsaSsaPssPrivateKey) {
        return DEFAULT_INSTANCE.createBuilder(rsaSsaPssPrivateKey);
    }

    public static RsaSsaPssPrivateKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPssPrivateKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RsaSsaPssPrivateKey parseFrom(ByteString byteString) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static RsaSsaPssPrivateKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RsaSsaPssPrivateKey parseFrom(byte[] bArr) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static RsaSsaPssPrivateKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RsaSsaPssPrivateKey parseFrom(InputStream inputStream) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static RsaSsaPssPrivateKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RsaSsaPssPrivateKey parseFrom(CodedInputStream codedInputStream) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RsaSsaPssPrivateKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (RsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
