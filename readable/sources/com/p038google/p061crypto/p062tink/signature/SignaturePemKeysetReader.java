package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.KeysetReader;
import com.p038google.p061crypto.p062tink.PemKeyType;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaParams;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaPublicKey;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaSignatureEncoding;
import com.p038google.p061crypto.p062tink.p073proto.EllipticCurveType;
import com.p038google.p061crypto.p062tink.p073proto.EncryptedKeyset;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.KeyStatusType;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPkcs1Params;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPkcs1PublicKey;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssParams;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPublicKey;
import com.p038google.p061crypto.p062tink.p075subtle.C0864Enums;
import com.p038google.p061crypto.p062tink.p075subtle.C0870Random;
import com.p038google.p061crypto.p062tink.signature.internal.C0839SigUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.security.Key;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPublicKey;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class SignaturePemKeysetReader implements KeysetReader {

    /* renamed from: pemKeys */
    private List<C0837PemKey> f3871pemKeys;

    /* renamed from: com.google.crypto.tink.signature.SignaturePemKeysetReader$1 */
    public static /* synthetic */ class C08351 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[C0864Enums.HashType.m4261values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[C0864Enums.HashType.SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[C0864Enums.HashType.SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[C0864Enums.HashType.SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.signature.SignaturePemKeysetReader$Builder */
    public static final class C0836Builder {

        /* renamed from: pemKeys */
        private List<C0837PemKey> f3872pemKeys = new ArrayList();

        /* renamed from: addPem */
        public C0836Builder m4209addPem(String str, PemKeyType pemKeyType) {
            C0837PemKey c0837PemKey = new C0837PemKey(null);
            c0837PemKey.f3873reader = new BufferedReader(new StringReader(str));
            c0837PemKey.f3874type = pemKeyType;
            this.f3872pemKeys.add(c0837PemKey);
            return this;
        }

        /* renamed from: build */
        public KeysetReader m4210build() {
            return new SignaturePemKeysetReader(this.f3872pemKeys);
        }
    }

    /* renamed from: com.google.crypto.tink.signature.SignaturePemKeysetReader$PemKey */
    public static final class C0837PemKey {

        /* renamed from: reader */
        BufferedReader f3873reader;

        /* renamed from: type */
        PemKeyType f3874type;

        private C0837PemKey() {
        }

        public /* synthetic */ C0837PemKey(C08351 c08351) {
            this();
        }
    }

    public SignaturePemKeysetReader(List<C0837PemKey> list) {
        this.f3871pemKeys = list;
    }

    private static C0669KeyData convertEcPublicKey(PemKeyType pemKeyType, ECPublicKey eCPublicKey) throws IOException {
        if (pemKeyType.algorithm.equals("ECDSA")) {
            return C0669KeyData.newBuilder().setTypeUrl(new EcdsaVerifyKeyManager().getKeyType()).setValue(EcdsaPublicKey.newBuilder().setVersion(new EcdsaVerifyKeyManager().getVersion()).setParams(EcdsaParams.newBuilder().setHashType(getHashType(pemKeyType)).setCurve(getCurveType(pemKeyType)).setEncoding(EcdsaSignatureEncoding.DER).mo3555build()).m3600setX(C0839SigUtil.toUnsignedIntByteString(eCPublicKey.getW().getAffineX())).m3601setY(C0839SigUtil.toUnsignedIntByteString(eCPublicKey.getW().getAffineY())).mo3555build().toByteString()).setKeyMaterialType(C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).mo3555build();
        }
        throw new IOException("unsupported EC signature algorithm: " + pemKeyType.algorithm);
    }

    private static C0669KeyData convertRsaPublicKey(PemKeyType pemKeyType, RSAPublicKey rSAPublicKey) throws IOException {
        if (pemKeyType.algorithm.equals("RSASSA-PKCS1-v1_5")) {
            return C0669KeyData.newBuilder().setTypeUrl(new RsaSsaPkcs1VerifyKeyManager().getKeyType()).setValue(RsaSsaPkcs1PublicKey.newBuilder().setVersion(new RsaSsaPkcs1VerifyKeyManager().getVersion()).setParams(RsaSsaPkcs1Params.newBuilder().setHashType(getHashType(pemKeyType)).mo3555build()).m3858setE(C0839SigUtil.toUnsignedIntByteString(rSAPublicKey.getPublicExponent())).m3859setN(C0839SigUtil.toUnsignedIntByteString(rSAPublicKey.getModulus())).mo3555build().toByteString()).setKeyMaterialType(C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).mo3555build();
        }
        if (pemKeyType.algorithm.equals("RSASSA-PSS")) {
            return C0669KeyData.newBuilder().setTypeUrl(new RsaSsaPssVerifyKeyManager().getKeyType()).setValue(RsaSsaPssPublicKey.newBuilder().setVersion(new RsaSsaPssVerifyKeyManager().getVersion()).setParams(RsaSsaPssParams.newBuilder().setSigHash(getHashType(pemKeyType)).setMgf1Hash(getHashType(pemKeyType)).setSaltLength(getDigestSizeInBytes(pemKeyType)).mo3555build()).m3900setE(C0839SigUtil.toUnsignedIntByteString(rSAPublicKey.getPublicExponent())).m3901setN(C0839SigUtil.toUnsignedIntByteString(rSAPublicKey.getModulus())).mo3555build().toByteString()).setKeyMaterialType(C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC).mo3555build();
        }
        throw new IOException("unsupported RSA signature algorithm: " + pemKeyType.algorithm);
    }

    private static EllipticCurveType getCurveType(PemKeyType pemKeyType) {
        int i = pemKeyType.keySizeInBits;
        if (i == 256) {
            return EllipticCurveType.NIST_P256;
        }
        if (i == 384) {
            return EllipticCurveType.NIST_P384;
        }
        if (i == 521) {
            return EllipticCurveType.NIST_P521;
        }
        throw new IllegalArgumentException("unsupported curve for key size: " + pemKeyType.keySizeInBits);
    }

    private static int getDigestSizeInBytes(PemKeyType pemKeyType) {
        int i = C08351.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[pemKeyType.f3012hash.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 48;
        }
        if (i == 3) {
            return 64;
        }
        throw new IllegalArgumentException("unsupported hash type: " + pemKeyType.f3012hash.name());
    }

    private static HashType getHashType(PemKeyType pemKeyType) {
        int i = C08351.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[pemKeyType.f3012hash.ordinal()];
        if (i == 1) {
            return HashType.SHA256;
        }
        if (i == 2) {
            return HashType.SHA384;
        }
        if (i == 3) {
            return HashType.SHA512;
        }
        throw new IllegalArgumentException("unsupported hash type: " + pemKeyType.f3012hash.name());
    }

    public static C0836Builder newBuilder() {
        return new C0836Builder();
    }

    /* renamed from: readKey */
    private static C0675Keyset.Key m4208readKey(BufferedReader bufferedReader, PemKeyType pemKeyType) throws IOException {
        C0669KeyData c0669KeyDataConvertEcPublicKey;
        Key keyM3380readKey = pemKeyType.m3380readKey(bufferedReader);
        if (keyM3380readKey == null) {
            return null;
        }
        if (keyM3380readKey instanceof RSAPublicKey) {
            c0669KeyDataConvertEcPublicKey = convertRsaPublicKey(pemKeyType, (RSAPublicKey) keyM3380readKey);
        } else {
            if (!(keyM3380readKey instanceof ECPublicKey)) {
                return null;
            }
            c0669KeyDataConvertEcPublicKey = convertEcPublicKey(pemKeyType, (ECPublicKey) keyM3380readKey);
        }
        return C0675Keyset.Key.newBuilder().setKeyData(c0669KeyDataConvertEcPublicKey).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(OutputPrefixType.RAW).setKeyId(C0870Random.m4280randInt()).mo3555build();
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetReader
    /* renamed from: read */
    public C0675Keyset mo3324read() throws IOException {
        C0675Keyset.Builder builderNewBuilder = C0675Keyset.newBuilder();
        for (C0837PemKey c0837PemKey : this.f3871pemKeys) {
            for (C0675Keyset.Key keyM4208readKey = m4208readKey(c0837PemKey.f3873reader, c0837PemKey.f3874type); keyM4208readKey != null; keyM4208readKey = m4208readKey(c0837PemKey.f3873reader, c0837PemKey.f3874type)) {
                builderNewBuilder.m3804addKey(keyM4208readKey);
            }
        }
        if (builderNewBuilder.getKeyCount() == 0) {
            throw new IOException("cannot find any key");
        }
        builderNewBuilder.setPrimaryKeyId(builderNewBuilder.mo3800getKey(0).getKeyId());
        return builderNewBuilder.mo3555build();
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetReader
    public EncryptedKeyset readEncrypted() {
        throw new UnsupportedOperationException();
    }
}
