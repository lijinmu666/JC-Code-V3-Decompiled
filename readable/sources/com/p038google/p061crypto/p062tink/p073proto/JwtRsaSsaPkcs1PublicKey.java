package com.p038google.p061crypto.p062tink.p073proto;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0774Parser;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class JwtRsaSsaPkcs1PublicKey extends GeneratedMessageLite<JwtRsaSsaPkcs1PublicKey, C0659Builder> implements JwtRsaSsaPkcs1PublicKeyOrBuilder {
    public static final int ALGORITHM_FIELD_NUMBER = 2;
    public static final int CUSTOM_KID_FIELD_NUMBER = 5;
    private static final JwtRsaSsaPkcs1PublicKey DEFAULT_INSTANCE;
    public static final int E_FIELD_NUMBER = 4;
    public static final int N_FIELD_NUMBER = 3;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<JwtRsaSsaPkcs1PublicKey> f3410PARSER = null;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int algorithm_;
    private CustomKid customKid_;

    /* renamed from: e_ */
    private ByteString f3411e_;

    /* renamed from: n_ */
    private ByteString f3412n_;
    private int version_;

    /* renamed from: com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey$1 */
    public static /* synthetic */ class C06581 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3413xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3413xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3413xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3413xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3413xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3413xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3413xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3413xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey$Builder */
    public static final class C0659Builder extends GeneratedMessageLite.AbstractC0753Builder<JwtRsaSsaPkcs1PublicKey, C0659Builder> implements JwtRsaSsaPkcs1PublicKeyOrBuilder {
        public /* synthetic */ C0659Builder(C06581 c06581) {
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

        public C0659Builder clearAlgorithm() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).clearAlgorithm();
            return this;
        }

        public C0659Builder clearCustomKid() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).clearCustomKid();
            return this;
        }

        /* renamed from: clearE */
        public C0659Builder m3737clearE() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).m3730clearE();
            return this;
        }

        /* renamed from: clearN */
        public C0659Builder m3738clearN() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).m3731clearN();
            return this;
        }

        public C0659Builder clearVersion() {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).clearVersion();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        /* renamed from: clone */
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mo3558clone() {
            return super.mo3558clone();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
        public JwtRsaSsaPkcs1Algorithm getAlgorithm() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getAlgorithm();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
        public int getAlgorithmValue() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getAlgorithmValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
        public CustomKid getCustomKid() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getCustomKid();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
        public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
            return super.getDefaultInstanceForType();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
        /* renamed from: getE */
        public ByteString mo3735getE() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).mo3735getE();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
        /* renamed from: getN */
        public ByteString mo3736getN() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).mo3736getN();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
        public int getVersion() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).getVersion();
        }

        @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
        public boolean hasCustomKid() {
            return ((JwtRsaSsaPkcs1PublicKey) this.instance).hasCustomKid();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
            return super.internalMergeFrom((C0659Builder) abstractMessageLite);
        }

        public C0659Builder mergeCustomKid(CustomKid customKid) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).mergeCustomKid(customKid);
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return super.mergeFrom(codedInputStream, extensionRegistryLite);
        }

        public C0659Builder setAlgorithm(JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setAlgorithm(jwtRsaSsaPkcs1Algorithm);
            return this;
        }

        public C0659Builder setAlgorithmValue(int i) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setAlgorithmValue(i);
            return this;
        }

        public C0659Builder setCustomKid(CustomKid customKid) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setCustomKid(customKid);
            return this;
        }

        /* renamed from: setE */
        public C0659Builder m3739setE(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).m3733setE(byteString);
            return this;
        }

        /* renamed from: setN */
        public C0659Builder m3740setN(ByteString byteString) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).m3734setN(byteString);
            return this;
        }

        public C0659Builder setVersion(int i) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setVersion(i);
            return this;
        }

        private C0659Builder() {
            super(JwtRsaSsaPkcs1PublicKey.DEFAULT_INSTANCE);
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

        public C0659Builder setCustomKid(CustomKid.C0660Builder c0660Builder) {
            copyOnWrite();
            ((JwtRsaSsaPkcs1PublicKey) this.instance).setCustomKid(c0660Builder.mo3555build());
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

    public static final class CustomKid extends GeneratedMessageLite<CustomKid, C0660Builder> implements CustomKidOrBuilder {
        private static final CustomKid DEFAULT_INSTANCE;

        /* renamed from: PARSER */
        private static volatile InterfaceC0774Parser<CustomKid> f3414PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 1;

        /* renamed from: value_ */
        private String f3415value_ = BuildConfig.f24315FLAVOR;

        /* renamed from: com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey$CustomKid$Builder */
        public static final class C0660Builder extends GeneratedMessageLite.AbstractC0753Builder<CustomKid, C0660Builder> implements CustomKidOrBuilder {
            public /* synthetic */ C0660Builder(C06581 c06581) {
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

            public C0660Builder clearValue() {
                copyOnWrite();
                ((CustomKid) this.instance).clearValue();
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

            @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.CustomKidOrBuilder
            public String getValue() {
                return ((CustomKid) this.instance).getValue();
            }

            @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.CustomKidOrBuilder
            public ByteString getValueBytes() {
                return ((CustomKid) this.instance).getValueBytes();
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder internalMergeFrom(AbstractMessageLite abstractMessageLite) {
                return super.internalMergeFrom((C0660Builder) abstractMessageLite);
            }

            @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite.AbstractC0753Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.AbstractMessageLite.AbstractC0712Builder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite.InterfaceC0766Builder
            public /* bridge */ /* synthetic */ AbstractMessageLite.AbstractC0712Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
                return super.mergeFrom(codedInputStream, extensionRegistryLite);
            }

            public C0660Builder setValue(String str) {
                copyOnWrite();
                ((CustomKid) this.instance).setValue(str);
                return this;
            }

            public C0660Builder setValueBytes(ByteString byteString) {
                copyOnWrite();
                ((CustomKid) this.instance).setValueBytes(byteString);
                return this;
            }

            private C0660Builder() {
                super(CustomKid.DEFAULT_INSTANCE);
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
            CustomKid customKid = new CustomKid();
            DEFAULT_INSTANCE = customKid;
            GeneratedMessageLite.registerDefaultInstance(CustomKid.class, customKid);
        }

        private CustomKid() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.f3415value_ = getDefaultInstance().getValue();
        }

        public static CustomKid getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static C0660Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static CustomKid parseDelimitedFrom(InputStream inputStream) {
            return (CustomKid) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CustomKid parseFrom(ByteBuffer byteBuffer) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
        }

        /* renamed from: parser */
        public static InterfaceC0774Parser<CustomKid> m3741parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValue(String str) {
            str.getClass();
            this.f3415value_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setValueBytes(ByteString byteString) {
            AbstractMessageLite.checkByteStringIsUtf8(byteString);
            this.f3415value_ = byteString.toStringUtf8();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
        public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            int i = C06581.f3413xa1df5c61[methodToInvoke.ordinal()];
            C06581 c06581 = null;
            switch (i) {
                case 1:
                    return new CustomKid();
                case 2:
                    return new C0660Builder(c06581);
                case 3:
                    return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    InterfaceC0774Parser<CustomKid> defaultInstanceBasedParser = f3414PARSER;
                    if (defaultInstanceBasedParser == null) {
                        synchronized (CustomKid.class) {
                            try {
                                defaultInstanceBasedParser = f3414PARSER;
                                if (defaultInstanceBasedParser == null) {
                                    defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                    f3414PARSER = defaultInstanceBasedParser;
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

        @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.CustomKidOrBuilder
        public String getValue() {
            return this.f3415value_;
        }

        @Override // com.google.crypto.tink.proto.JwtRsaSsaPkcs1PublicKey.CustomKidOrBuilder
        public ByteString getValueBytes() {
            return ByteString.copyFromUtf8(this.f3415value_);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder newBuilderForType() {
            return super.newBuilderForType();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
        public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder toBuilder() {
            return super.toBuilder();
        }

        public static C0660Builder newBuilder(CustomKid customKid) {
            return DEFAULT_INSTANCE.createBuilder(customKid);
        }

        public static CustomKid parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomKid) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CustomKid parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CustomKid parseFrom(ByteString byteString) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
        }

        public static CustomKid parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CustomKid parseFrom(byte[] bArr) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
        }

        public static CustomKid parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CustomKid parseFrom(InputStream inputStream) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
        }

        public static CustomKid parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CustomKid parseFrom(CodedInputStream codedInputStream) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CustomKid parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
            return (CustomKid) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    public interface CustomKidOrBuilder extends MessageLiteOrBuilder {
        String getValue();

        ByteString getValueBytes();
    }

    static {
        JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey = new JwtRsaSsaPkcs1PublicKey();
        DEFAULT_INSTANCE = jwtRsaSsaPkcs1PublicKey;
        GeneratedMessageLite.registerDefaultInstance(JwtRsaSsaPkcs1PublicKey.class, jwtRsaSsaPkcs1PublicKey);
    }

    private JwtRsaSsaPkcs1PublicKey() {
        ByteString byteString = ByteString.f3559EMPTY;
        this.f3412n_ = byteString;
        this.f3411e_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearAlgorithm() {
        this.algorithm_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCustomKid() {
        this.customKid_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearE */
    public void m3730clearE() {
        this.f3411e_ = getDefaultInstance().mo3735getE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: clearN */
    public void m3731clearN() {
        this.f3412n_ = getDefaultInstance().mo3736getN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static JwtRsaSsaPkcs1PublicKey getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeCustomKid(CustomKid customKid) {
        customKid.getClass();
        CustomKid customKid2 = this.customKid_;
        if (customKid2 == null || customKid2 == CustomKid.getDefaultInstance()) {
            this.customKid_ = customKid;
        } else {
            this.customKid_ = CustomKid.newBuilder(this.customKid_).mergeFrom((CustomKid.C0660Builder) customKid).buildPartial();
        }
    }

    public static C0659Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static JwtRsaSsaPkcs1PublicKey parseDelimitedFrom(InputStream inputStream) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(ByteBuffer byteBuffer) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<JwtRsaSsaPkcs1PublicKey> m3732parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlgorithm(JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm) {
        this.algorithm_ = jwtRsaSsaPkcs1Algorithm.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAlgorithmValue(int i) {
        this.algorithm_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCustomKid(CustomKid customKid) {
        customKid.getClass();
        this.customKid_ = customKid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setE */
    public void m3733setE(ByteString byteString) {
        byteString.getClass();
        this.f3411e_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setN */
    public void m3734setN(ByteString byteString) {
        byteString.getClass();
        this.f3412n_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVersion(int i) {
        this.version_ = i;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = C06581.f3413xa1df5c61[methodToInvoke.ordinal()];
        C06581 c06581 = null;
        switch (i) {
            case 1:
                return new JwtRsaSsaPkcs1PublicKey();
            case 2:
                return new C0659Builder(c06581);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u000b\u0002\f\u0003\n\u0004\n\u0005\t", new Object[]{"version_", "algorithm_", "n_", "e_", "customKid_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<JwtRsaSsaPkcs1PublicKey> defaultInstanceBasedParser = f3410PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (JwtRsaSsaPkcs1PublicKey.class) {
                        try {
                            defaultInstanceBasedParser = f3410PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3410PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public JwtRsaSsaPkcs1Algorithm getAlgorithm() {
        JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1AlgorithmForNumber = JwtRsaSsaPkcs1Algorithm.forNumber(this.algorithm_);
        return jwtRsaSsaPkcs1AlgorithmForNumber == null ? JwtRsaSsaPkcs1Algorithm.UNRECOGNIZED : jwtRsaSsaPkcs1AlgorithmForNumber;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public int getAlgorithmValue() {
        return this.algorithm_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public CustomKid getCustomKid() {
        CustomKid customKid = this.customKid_;
        return customKid == null ? CustomKid.getDefaultInstance() : customKid;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLiteOrBuilder
    public /* bridge */ /* synthetic */ MessageLite getDefaultInstanceForType() {
        return super.getDefaultInstanceForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    /* renamed from: getE */
    public ByteString mo3735getE() {
        return this.f3411e_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    /* renamed from: getN */
    public ByteString mo3736getN() {
        return this.f3412n_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public int getVersion() {
        return this.version_;
    }

    @Override // com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKeyOrBuilder
    public boolean hasCustomKid() {
        return this.customKid_ != null;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder newBuilderForType() {
        return super.newBuilderForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite, com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite
    public /* bridge */ /* synthetic */ MessageLite.InterfaceC0766Builder toBuilder() {
        return super.toBuilder();
    }

    public static C0659Builder newBuilder(JwtRsaSsaPkcs1PublicKey jwtRsaSsaPkcs1PublicKey) {
        return DEFAULT_INSTANCE.createBuilder(jwtRsaSsaPkcs1PublicKey);
    }

    public static JwtRsaSsaPkcs1PublicKey parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(ByteString byteString) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(byte[] bArr) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(InputStream inputStream) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(CodedInputStream codedInputStream) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static JwtRsaSsaPkcs1PublicKey parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (JwtRsaSsaPkcs1PublicKey) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
