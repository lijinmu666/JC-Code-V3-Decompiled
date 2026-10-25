package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPublicKey;
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
public final class JwtRsaSsaPssPrivateKey extends GeneratedMessageLite<JwtRsaSsaPssPrivateKey, C0665Builder> implements JwtRsaSsaPssPrivateKeyOrBuilder {
    public static final int CRT_FIELD_NUMBER = 8;
    private static final JwtRsaSsaPssPrivateKey DEFAULT_INSTANCE;
    public static final int DP_FIELD_NUMBER = 6;
    public static final int DQ_FIELD_NUMBER = 7;
    public static final int D_FIELD_NUMBER = 3;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<JwtRsaSsaPssPrivateKey> f3423PARSER = null;
    public static final int PUBLIC_KEY_FIELD_NUMBER = 2;
    public static final int P_FIELD_NUMBER = 4;
    public static final int Q_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;

    /* renamed from: crt_ */
    private ByteString f3424crt_;

    /* renamed from: d_ */
    private ByteString f3425d_;

    /* renamed from: dp_ */
    private ByteString f3426dp_;

    /* renamed from: dq_ */
    private ByteString f3427dq_;

    /* renamed from: p_ */
    private ByteString f3428p_;
    private JwtRsaSsaPssPublicKey publicKey_;

    /* renamed from: q_ */
    private ByteString f3429q_;
    private int version_;

    /* renamed from: com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey$1 */
    public static /* synthetic */ class C06641 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3430xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3430xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3430xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3430xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3430xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3430xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3430xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3430xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.proto.JwtRsaSsaPssPrivateKey$Builder */
    public static final class C0665Builder extends GeneratedMessageLite.AbstractC0753Builder<JwtRsaSsaPssPrivateKey, C0665Builder> implements JwtRsaSsaPssPrivateKeyOrBuilder {
        public /* synthetic */ C0665Builder(C06641 c06641) {
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

        public C0665Builder clearCrt() {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).clearCrt();
            return this;
        }

        /* renamed from: clearD */
        public C0665Builder m3764clearD() {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3746clearD();
            return this;
        }

        /* renamed from: clearDp */
        public C0665Builder m3765clearDp() {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3747clearDp();
            return this;
        }

        /* renamed from: clearDq */
        public C0665Builder m3766clearDq() {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3748clearDq();
            return this;
        }

        /* renamed from: clearP */
        public C0665Builder m3767clearP() {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3749clearP();
            return this;
        }

        public C0665Builder clearPublicKey() {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).clearPublicKey();
            return this;
        }

        /* renamed from: clearQ */
        public C0665Builder m3768clearQ() {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3750clearQ();
            return this;
        }

        public C0665Builder clearVersion() {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mo3558clone() {
            return super.mo3558clone();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getCrt */
        public ByteString mo3758getCrt() {
            return ((JwtRsaSsaPssPrivateKey) this.instance).mo3758getCrt();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getD */
        public ByteString mo3759getD() {
            return ((JwtRsaSsaPssPrivateKey) this.instance).mo3759getD();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getDp */
        public ByteString mo3760getDp() {
            return ((JwtRsaSsaPssPrivateKey) this.instance).mo3760getDp();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getDq */
        public ByteString mo3761getDq() {
            return ((JwtRsaSsaPssPrivateKey) this.instance).mo3761getDq();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getP */
        public ByteString mo3762getP() {
            return ((JwtRsaSsaPssPrivateKey) this.instance).mo3762getP();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
        public JwtRsaSsaPssPublicKey getPublicKey() {
            return ((JwtRsaSsaPssPrivateKey) this.instance).getPublicKey();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
        /* renamed from: getQ */
        public ByteString mo3763getQ() {
            return ((JwtRsaSsaPssPrivateKey) this.instance).mo3763getQ();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
        public int getVersion() {
            return ((JwtRsaSsaPssPrivateKey) this.instance).getVersion();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
        public boolean hasPublicKey() {
            return ((JwtRsaSsaPssPrivateKey) this.instance).hasPublicKey();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return super.internalMergeFrom((C0665Builder) abstractMessageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public C0665Builder mergePublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).mergePublicKey(jwtRsaSsaPssPublicKey);
            return this;
        }

        /* renamed from: setCrt */
        public C0665Builder m3769setCrt(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3752setCrt(byteString);
            return this;
        }

        /* renamed from: setD */
        public C0665Builder m3770setD(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3753setD(byteString);
            return this;
        }

        /* renamed from: setDp */
        public C0665Builder m3771setDp(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3754setDp(byteString);
            return this;
        }

        /* renamed from: setDq */
        public C0665Builder m3772setDq(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3755setDq(byteString);
            return this;
        }

        /* renamed from: setP */
        public C0665Builder m3773setP(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3756setP(byteString);
            return this;
        }

        public C0665Builder setPublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).setPublicKey(jwtRsaSsaPssPublicKey);
            return this;
        }

        /* renamed from: setQ */
        public C0665Builder m3774setQ(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).m3757setQ(byteString);
            return this;
        }

        public C0665Builder setVersion(int i) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).setVersion(i);
            return this;
        }

        private C0665Builder() {
            super(JwtRsaSsaPssPrivateKey.DEFAULT_INSTANCE);
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

        public C0665Builder setPublicKey(JwtRsaSsaPssPublicKey.C0667Builder c0667Builder) {
            copyOnWrite();
            ((JwtRsaSsaPssPrivateKey) this.instance).setPublicKey(c0667Builder.mo3555build());
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
        JwtRsaSsaPssPrivateKey jwtRsaSsaPssPrivateKey = new JwtRsaSsaPssPrivateKey();
        DEFAULT_INSTANCE = jwtRsaSsaPssPrivateKey;
        GeneratedMessageLite.registerDefaultInstance(JwtRsaSsaPssPrivateKey.class, jwtRsaSsaPssPrivateKey);
    }

    private JwtRsaSsaPssPrivateKey() {
        ByteString byteString = ByteString.f3559EMPTY;
        this.f3425d_ = byteString;
        this.f3428p_ = byteString;
        this.f3429q_ = byteString;
        this.f3426dp_ = byteString;
        this.f3427dq_ = byteString;
        this.f3424crt_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCrt() {
        this.f3424crt_ = getDefaultInstance().mo3758getCrt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearD */
    public void m3746clearD() {
        this.f3425d_ = getDefaultInstance().mo3759getD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearDp */
    public void m3747clearDp() {
        this.f3426dp_ = getDefaultInstance().mo3760getDp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearDq */
    public void m3748clearDq() {
        this.f3427dq_ = getDefaultInstance().mo3761getDq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearP */
    public void m3749clearP() {
        this.f3428p_ = getDefaultInstance().mo3762getP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPublicKey() {
        this.publicKey_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearQ */
    public void m3750clearQ() {
        this.f3429q_ = getDefaultInstance().mo3763getQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static JwtRsaSsaPssPrivateKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergePublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) {
        jwtRsaSsaPssPublicKey.getClass();
        JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey2 = this.publicKey_;
        if (jwtRsaSsaPssPublicKey2 == null || jwtRsaSsaPssPublicKey2 == JwtRsaSsaPssPublicKey.getDefaultInstance()) {
            this.publicKey_ = jwtRsaSsaPssPublicKey;
        } else {
            this.publicKey_ = JwtRsaSsaPssPublicKey.newBuilder(this.publicKey_).mergeFrom((JwtRsaSsaPssPublicKey.C0667Builder) jwtRsaSsaPssPublicKey).buildPartial();
        }
    }

    public static C0665Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static JwtRsaSsaPssPrivateKey parseDelimitedFrom(InputStream inputStream) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(ByteBuffer byteBuffer) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<JwtRsaSsaPssPrivateKey> m3751parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setCrt */
    public void m3752setCrt(ByteString byteString) {
        byteString.getClass();
        this.f3424crt_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setD */
    public void m3753setD(ByteString byteString) {
        byteString.getClass();
        this.f3425d_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDp */
    public void m3754setDp(ByteString byteString) {
        byteString.getClass();
        this.f3426dp_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setDq */
    public void m3755setDq(ByteString byteString) {
        byteString.getClass();
        this.f3427dq_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setP */
    public void m3756setP(ByteString byteString) {
        byteString.getClass();
        this.f3428p_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPublicKey(JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey) {
        jwtRsaSsaPssPublicKey.getClass();
        this.publicKey_ = jwtRsaSsaPssPublicKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setQ */
    public void m3757setQ(ByteString byteString) {
        byteString.getClass();
        this.f3429q_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = C06641.f3430xa1df5c61[methodToInvoke.ordinal()];
        C06641 c06641 = null;
        switch (i) {
            case 1:
                return new JwtRsaSsaPssPrivateKey();
            case 2:
                return new C0665Builder(c06641);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"version_", "publicKey_", "d_", "p_", "q_", "dp_", "dq_", "crt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<JwtRsaSsaPssPrivateKey> defaultInstanceBasedParser = f3423PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (JwtRsaSsaPssPrivateKey.class) {
                        try {
                            defaultInstanceBasedParser = f3423PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3423PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getCrt */
    public ByteString mo3758getCrt() {
        return this.f3424crt_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getD */
    public ByteString mo3759getD() {
        return this.f3425d_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return super.getDefaultInstanceForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getDp */
    public ByteString mo3760getDp() {
        return this.f3426dp_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getDq */
    public ByteString mo3761getDq() {
        return this.f3427dq_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getP */
    public ByteString mo3762getP() {
        return this.f3428p_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
    public JwtRsaSsaPssPublicKey getPublicKey() {
        JwtRsaSsaPssPublicKey jwtRsaSsaPssPublicKey = this.publicKey_;
        return jwtRsaSsaPssPublicKey == null ? JwtRsaSsaPssPublicKey.getDefaultInstance() : jwtRsaSsaPssPublicKey;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
    /* renamed from: getQ */
    public ByteString mo3763getQ() {
        return this.f3429q_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPrivateKeyOrBuilder
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

    public static C0665Builder newBuilder(JwtRsaSsaPssPrivateKey jwtRsaSsaPssPrivateKey) {
        return DEFAULT_INSTANCE.createBuilder(jwtRsaSsaPssPrivateKey);
    }

    public static JwtRsaSsaPssPrivateKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(ByteString byteString) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(byte[] bArr) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(InputStream inputStream) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(CodedInputStream codedInputStream) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static JwtRsaSsaPssPrivateKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPssPrivateKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
