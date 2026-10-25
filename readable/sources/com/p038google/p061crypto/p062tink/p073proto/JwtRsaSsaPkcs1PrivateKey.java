package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKey;
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
public final class JwtRsaSsaPkcs1PrivateKey extends GeneratedMessageLite<JwtRsaSsaPkcs1PrivateKey, C0657Builder> implements JwtRsaSsaPkcs1PrivateKeyOrBuilder {
    public static final int CRT_FIELD_NUMBER = 8;
    private static final JwtRsaSsaPkcs1PrivateKey DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<JwtRsaSsaPkcs1PrivateKey> f3402PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;

    /* renamed from: crt_ */
    private ByteString f3403crt_;

    /* renamed from: d_ */
    private ByteString f3404d_;

    /* renamed from: dp_ */
    private ByteString f3405dp_;

    /* renamed from: dq_ */
    private ByteString f3406dq_;

    /* renamed from: p_ */
    private ByteString f3407p_;
    private JwtRsaSsaPkcs1PublicKey publicKey_;

    /* renamed from: q_ */
    private ByteString f3408q_;
    private int version_;

    /* renamed from: com.google.crypto.tink.proto.JwtRsaSsaPkcs1PrivateKey$1 */
    public static /* synthetic */ class C06561 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3409xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3409xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3409xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3409xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3409xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3409xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3409xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3409xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.proto.JwtRsaSsaPkcs1PrivateKey$Builder */
    public static final class C0657Builder extends GeneratedMessageLite.AbstractC0753Builder<JwtRsaSsaPkcs1PrivateKey, C0657Builder> implements JwtRsaSsaPkcs1PrivateKeyOrBuilder {
        public /* synthetic */ C0657Builder(C06561 c06561) {
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

        public C0657Builder clearCrt() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).clearCrt();
            return this;
        }

        /* renamed from: clearD */
        public C0657Builder m3719clearD() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3701clearD();
            return this;
        }

        /* renamed from: clearDp */
        public C0657Builder m3720clearDp() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3702clearDp();
            return this;
        }

        /* renamed from: clearDq */
        public C0657Builder m3721clearDq() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3703clearDq();
            return this;
        }

        /* renamed from: clearP */
        public C0657Builder m3722clearP() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3704clearP();
            return this;
        }

        public C0657Builder clearPublicKey() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).clearPublicKey();
            return this;
        }

        /* renamed from: clearQ */
        public C0657Builder m3723clearQ() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3705clearQ();
            return this;
        }

        public C0657Builder clearVersion() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mo3558clone() {
            return super.mo3558clone();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
        /* renamed from: getCrt */
        public ByteString mo3713getCrt() {
            return ((JwtRsaSsaPkcs1PrivateKey) this.instance).mo3713getCrt();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
        /* renamed from: getD */
        public ByteString mo3714getD() {
            return ((JwtRsaSsaPkcs1PrivateKey) this.instance).mo3714getD();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
        /* renamed from: getDp */
        public ByteString mo3715getDp() {
            return ((JwtRsaSsaPkcs1PrivateKey) this.instance).mo3715getDp();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
        /* renamed from: getDq */
        public ByteString mo3716getDq() {
            return ((JwtRsaSsaPkcs1PrivateKey) this.instance).mo3716getDq();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
        /* renamed from: getP */
        public ByteString mo3717getP() {
            return ((JwtRsaSsaPkcs1PrivateKey) this.instance).mo3717getP();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
        public JwtRsaSsaPkcs1PublicKey getPublicKey() {
            return ((JwtRsaSsaPkcs1PrivateKey) this.instance).getPublicKey();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
        /* renamed from: getQ */
        public ByteString mo3718getQ() {
            return ((JwtRsaSsaPkcs1PrivateKey) this.instance).mo3718getQ();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
        public int getVersion() {
            return ((JwtRsaSsaPkcs1PrivateKey) this.instance).getVersion();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
        public boolean hasPublicKey() {
            return ((JwtRsaSsaPkcs1PrivateKey) this.instance).hasPublicKey();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return super.internalMergeFrom((C0657Builder) abstractMessageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public C0657Builder mergePublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).mergePublicKey(jwtRsaSsaPkcs1PublicKey);
            return this;
        }

        /* renamed from: setCrt */
        public C0657Builder m3724setCrt(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3707setCrt(byteString);
            return this;
        }

        /* renamed from: setD */
        public C0657Builder m3725setD(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3708setD(byteString);
            return this;
        }

        /* renamed from: setDp */
        public C0657Builder m3726setDp(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3709setDp(byteString);
            return this;
        }

        /* renamed from: setDq */
        public C0657Builder m3727setDq(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3710setDq(byteString);
            return this;
        }

        /* renamed from: setP */
        public C0657Builder m3728setP(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3711setP(byteString);
            return this;
        }

        public C0657Builder setPublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).setPublicKey(jwtRsaSsaPkcs1PublicKey);
            return this;
        }

        /* renamed from: setQ */
        public C0657Builder m3729setQ(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).m3712setQ(byteString);
            return this;
        }

        public C0657Builder setVersion(int i) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).setVersion(i);
            return this;
        }

        private C0657Builder() {
            super(JwtRsaSsaPkcs1PrivateKey.DEFAULT_INSTANCE);
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

        public C0657Builder setPublicKey(JwtRsaSsaPkcs1PublicKey.C0659Builder c0659Builder) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PrivateKey) this.instance).setPublicKey(c0659Builder.mo3555build());
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
        JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey = new JwtRsaSsaPkcs1PrivateKey();
        DEFAULT_INSTANCE = jwtRsaSsaPkcs1PrivateKey;
        GeneratedMessageLite.registerDefaultInstance(JwtRsaSsaPkcs1PrivateKey.class, jwtRsaSsaPkcs1PrivateKey);
    }

    private JwtRsaSsaPkcs1PrivateKey() {
        ByteString byteString = ByteString.f3559EMPTY;
        this.f3404d_ = byteString;
        this.f3407p_ = byteString;
        this.f3408q_ = byteString;
        this.f3405dp_ = byteString;
        this.f3406dq_ = byteString;
        this.f3403crt_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCrt() {
        this.f3403crt_ = getDefaultInstance().mo3713getCrt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearD */
    public void m3701clearD() {
        this.f3404d_ = getDefaultInstance().mo3714getD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearDp */
    public void m3702clearDp() {
        this.f3405dp_ = getDefaultInstance().mo3715getDp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearDq */
    public void m3703clearDq() {
        this.f3406dq_ = getDefaultInstance().mo3716getDq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearP */
    public void m3704clearP() {
        this.f3407p_ = getDefaultInstance().mo3717getP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearQ */
    public void m3705clearQ() {
        this.f3408q_ = getDefaultInstance().mo3718getQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static JwtRsaSsaPkcs1PrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
        jwtRsaSsaPkcs1PublicKey.getClass();
        JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey2 = this.publicKey_;
        if (jwtRsaSsaPkcs1PublicKey2 == null || jwtRsaSsaPkcs1PublicKey2 == JwtRsaSsaPkcs1PublicKey.getDefaultInstance()) {
            this.publicKey_ = jwtRsaSsaPkcs1PublicKey;
        } else {
            this.publicKey_ = JwtRsaSsaPkcs1PublicKey.newBuilder(this.publicKey_).mergeFrom((JwtRsaSsaPkcs1PublicKey.C0659Builder) jwtRsaSsaPkcs1PublicKey).buildPartial();
        }
    }

    public static C0657Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static JwtRsaSsaPkcs1PrivateKey parseDelimitedFrom(InputStream inputStream) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(ByteBuffer byteBuffer) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<JwtRsaSsaPkcs1PrivateKey> m3706parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCrt */
    public void m3707setCrt(ByteString byteString) {
        byteString.getClass();
        this.f3403crt_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setD */
    public void m3708setD(ByteString byteString) {
        byteString.getClass();
        this.f3404d_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDp */
    public void m3709setDp(ByteString byteString) {
        byteString.getClass();
        this.f3405dp_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDq */
    public void m3710setDq(ByteString byteString) {
        byteString.getClass();
        this.f3406dq_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setP */
    public void m3711setP(ByteString byteString) {
        byteString.getClass();
        this.f3407p_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicKey(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
        jwtRsaSsaPkcs1PublicKey.getClass();
        this.publicKey_ = jwtRsaSsaPkcs1PublicKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setQ */
    public void m3712setQ(ByteString byteString) {
        byteString.getClass();
        this.f3408q_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = C06561.f3409xa1df5c61[methodToInvoke.ordinal()];
        C06561 c06561 = null;
        switch (i) {
            case 1:
                return new JwtRsaSsaPkcs1PrivateKey();
            case 2:
                return new C0657Builder(c06561);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"version_", "publicKey_", "d_", "p_", "q_", "dp_", "dq_", "crt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<JwtRsaSsaPkcs1PrivateKey> defaultInstanceBasedParser = f3402PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (JwtRsaSsaPkcs1PrivateKey.class) {
                        try {
                            defaultInstanceBasedParser = f3402PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3402PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
    /* renamed from: getCrt */
    public ByteString mo3713getCrt() {
        return this.f3403crt_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
    /* renamed from: getD */
    public ByteString mo3714getD() {
        return this.f3404d_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return super.getDefaultInstanceForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
    /* renamed from: getDp */
    public ByteString mo3715getDp() {
        return this.f3405dp_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
    /* renamed from: getDq */
    public ByteString mo3716getDq() {
        return this.f3406dq_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
    /* renamed from: getP */
    public ByteString mo3717getP() {
        return this.f3407p_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
    public JwtRsaSsaPkcs1PublicKey getPublicKey() {
        JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey = this.publicKey_;
        return jwtRsaSsaPkcs1PublicKey == null ? JwtRsaSsaPkcs1PublicKey.getDefaultInstance() : jwtRsaSsaPkcs1PublicKey;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
    /* renamed from: getQ */
    public ByteString mo3718getQ() {
        return this.f3408q_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKeyOrBuilder
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

    public static C0657Builder newBuilder(JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) {
        return DEFAULT_INSTANCE.createBuilder(jwtRsaSsaPkcs1PrivateKey);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(ByteString byteString) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(byte[] bArr) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(InputStream inputStream) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(CodedInputStream codedInputStream) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static JwtRsaSsaPkcs1PrivateKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
