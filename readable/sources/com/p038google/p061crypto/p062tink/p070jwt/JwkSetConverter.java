package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.KeyStatus;
import com.p038google.p061crypto.p062tink.KeysetHandle;
import com.p038google.p061crypto.p062tink.internal.LegacyProtoKey;
import com.p038google.p061crypto.p062tink.internal.ProtoKeySerialization;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.JwtEcdsaAlgorithm;
import com.p038google.p061crypto.p062tink.p073proto.JwtEcdsaPublicKey;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1Algorithm;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKey;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssAlgorithm;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPssPublicKey;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import com.p038google.p061crypto.p062tink.p075subtle.C0852Base64;
import com.p038google.p061crypto.p062tink.p077tinkkey.KeyAccess;
import java.io.StringReader;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.Optional;
import javax.annotation.Nullable;
import p131o.AbstractC4187n0;
import p131o.AbstractC4194n7;
import p131o.C3858i0;
import p131o.C4385q0;
import p131o.C4454r0;
import p131o.C4587t0;

/* loaded from: classes.dex */
public final class JwkSetConverter {
    private static final String JWT_ECDSA_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey";
    private static final String JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey";
    private static final String JWT_RSA_SSA_PSS_PUBLIC_KEY_URL = "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey";

    /* renamed from: com.google.crypto.tink.jwt.JwkSetConverter$1 */
    public static /* synthetic */ class C04321 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm;

        static {
            int[] iArr = new int[JwtRsaSsaPssAlgorithm.m3744values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm = iArr;
            try {
                iArr[JwtRsaSsaPssAlgorithm.PS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[JwtRsaSsaPssAlgorithm.PS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[JwtRsaSsaPkcs1Algorithm.m3699values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm = iArr2;
            try {
                iArr2[JwtRsaSsaPkcs1Algorithm.RS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[JwtRsaSsaPkcs1Algorithm.RS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr3 = new int[JwtEcdsaAlgorithm.m3676values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm = iArr3;
            try {
                iArr3[JwtEcdsaAlgorithm.ES256.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES384.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[JwtEcdsaAlgorithm.ES512.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    private JwkSetConverter() {
    }

    private static C4385q0 convertJwtEcdsaKey(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        String str2;
        try {
            JwtEcdsaPublicKey from = JwtEcdsaPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = C04321.$SwitchMap$com$google$crypto$tink$proto$JwtEcdsaAlgorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "ES256";
                str2 = "P-256";
            } else if (i == 2) {
                str = "ES384";
                str2 = "P-384";
            } else {
                if (i != 3) {
                    throw new GeneralSecurityException("unknown algorithm");
                }
                str = "ES512";
                str2 = "P-521";
            }
            C4385q0 c4385q0 = new C4385q0();
            c4385q0.m13153Pq("kty", "EC");
            c4385q0.m13153Pq("crv", str2);
            c4385q0.m13153Pq("x", C0852Base64.urlSafeEncode(from.mo3684getX().toByteArray()));
            c4385q0.m13153Pq("y", C0852Base64.urlSafeEncode(from.mo3685getY().toByteArray()));
            c4385q0.m13153Pq("use", "sig");
            c4385q0.m13153Pq("alg", str);
            C3858i0 c3858i0 = new C3858i0();
            c3858i0.m12271fehf("verify");
            c4385q0.m13158fehf("key_ops", c3858i0);
            Optional<String> optionalM3505getKid = m3505getKid(protoKeySerialization.getIdRequirementOrNull());
            if (optionalM3505getKid.isPresent()) {
                c4385q0.m13153Pq("kid", optionalM3505getKid.get());
            } else if (from.hasCustomKid()) {
                c4385q0.m13153Pq("kid", from.getCustomKid().getValue());
            }
            return c4385q0;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtEcdsaPublicKey proto", e);
        }
    }

    private static C4385q0 convertJwtRsaSsaPkcs1(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPkcs1PublicKey from = JwtRsaSsaPkcs1PublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = C04321.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPkcs1Algorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "RS256";
            } else if (i == 2) {
                str = "RS384";
            } else {
                if (i != 3) {
                    throw new GeneralSecurityException("unknown algorithm");
                }
                str = "RS512";
            }
            C4385q0 c4385q0 = new C4385q0();
            c4385q0.m13153Pq("kty", "RSA");
            c4385q0.m13153Pq("n", C0852Base64.urlSafeEncode(from.mo3736getN().toByteArray()));
            c4385q0.m13153Pq("e", C0852Base64.urlSafeEncode(from.mo3735getE().toByteArray()));
            c4385q0.m13153Pq("use", "sig");
            c4385q0.m13153Pq("alg", str);
            C3858i0 c3858i0 = new C3858i0();
            c3858i0.m12271fehf("verify");
            c4385q0.m13158fehf("key_ops", c3858i0);
            Optional<String> optionalM3505getKid = m3505getKid(protoKeySerialization.getIdRequirementOrNull());
            if (optionalM3505getKid.isPresent()) {
                c4385q0.m13153Pq("kid", optionalM3505getKid.get());
            } else if (from.hasCustomKid()) {
                c4385q0.m13153Pq("kid", from.getCustomKid().getValue());
            }
            return c4385q0;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPkcs1PublicKey proto", e);
        }
    }

    private static C4385q0 convertJwtRsaSsaPss(ProtoKeySerialization protoKeySerialization) throws GeneralSecurityException {
        String str;
        try {
            JwtRsaSsaPssPublicKey from = JwtRsaSsaPssPublicKey.parseFrom(protoKeySerialization.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            int i = C04321.$SwitchMap$com$google$crypto$tink$proto$JwtRsaSsaPssAlgorithm[from.getAlgorithm().ordinal()];
            if (i == 1) {
                str = "PS256";
            } else if (i == 2) {
                str = "PS384";
            } else {
                if (i != 3) {
                    throw new GeneralSecurityException("unknown algorithm");
                }
                str = "PS512";
            }
            C4385q0 c4385q0 = new C4385q0();
            c4385q0.m13153Pq("kty", "RSA");
            c4385q0.m13153Pq("n", C0852Base64.urlSafeEncode(from.mo3781getN().toByteArray()));
            c4385q0.m13153Pq("e", C0852Base64.urlSafeEncode(from.mo3780getE().toByteArray()));
            c4385q0.m13153Pq("use", "sig");
            c4385q0.m13153Pq("alg", str);
            C3858i0 c3858i0 = new C3858i0();
            c3858i0.m12271fehf("verify");
            c4385q0.m13158fehf("key_ops", c3858i0);
            Optional<String> optionalM3505getKid = m3505getKid(protoKeySerialization.getIdRequirementOrNull());
            if (optionalM3505getKid.isPresent()) {
                c4385q0.m13153Pq("kid", optionalM3505getKid.get());
            } else if (from.hasCustomKid()) {
                c4385q0.m13153Pq("kid", from.getCustomKid().getValue());
            }
            return c4385q0;
        } catch (InvalidProtocolBufferException e) {
            throw new GeneralSecurityException("failed to parse value as JwtRsaSsaPssPublicKey proto", e);
        }
    }

    private static ProtoKeySerialization convertToEcdsaKey(C4385q0 c4385q0) throws GeneralSecurityException {
        JwtEcdsaAlgorithm jwtEcdsaAlgorithm;
        String stringItem = getStringItem(c4385q0, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "ES256":
                expectStringItem(c4385q0, "crv", "P-256");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES256;
                break;
            case "ES384":
                expectStringItem(c4385q0, "crv", "P-384");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES384;
                break;
            case "ES512":
                expectStringItem(c4385q0, "crv", "P-521");
                jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Ecdsa Algorithm: " + getStringItem(c4385q0, "alg"));
        }
        if (c4385q0.m13151HGpJ("d")) {
            throw new UnsupportedOperationException("importing ECDSA private keys is not implemented");
        }
        expectStringItem(c4385q0, "kty", "EC");
        validateUseIsSig(c4385q0);
        validateKeyOpsIsVerify(c4385q0);
        JwtEcdsaPublicKey.C0644Builder c0644BuilderM3689setY = JwtEcdsaPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtEcdsaAlgorithm).m3688setX(ByteString.copyFrom(C0852Base64.urlSafeDecode(getStringItem(c4385q0, "x")))).m3689setY(ByteString.copyFrom(C0852Base64.urlSafeDecode(getStringItem(c4385q0, "y"))));
        if (c4385q0.m13151HGpJ("kid")) {
            c0644BuilderM3689setY.setCustomKid(JwtEcdsaPublicKey.CustomKid.newBuilder().setValue(getStringItem(c4385q0, "kid")).mo3555build());
        }
        return ProtoKeySerialization.m3499create(JWT_ECDSA_PUBLIC_KEY_URL, c0644BuilderM3689setY.mo3555build().toByteString(), C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToRsaSsaPkcs1Key(C4385q0 c4385q0) throws GeneralSecurityException {
        JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm;
        String stringItem = getStringItem(c4385q0, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "RS256":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS256;
                break;
            case "RS384":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS384;
                break;
            case "RS512":
                jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(c4385q0, "alg"));
        }
        if (c4385q0.m13151HGpJ("p") || c4385q0.m13151HGpJ("q") || c4385q0.m13151HGpJ("dp") || c4385q0.m13151HGpJ("dq") || c4385q0.m13151HGpJ("d") || c4385q0.m13151HGpJ("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(c4385q0, "kty", "RSA");
        validateUseIsSig(c4385q0);
        validateKeyOpsIsVerify(c4385q0);
        JwtRsaSsaPkcs1PublicKey.C0659Builder c0659BuilderM3740setN = JwtRsaSsaPkcs1PublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPkcs1Algorithm).m3739setE(ByteString.copyFrom(C0852Base64.urlSafeDecode(getStringItem(c4385q0, "e")))).m3740setN(ByteString.copyFrom(C0852Base64.urlSafeDecode(getStringItem(c4385q0, "n"))));
        if (c4385q0.m13151HGpJ("kid")) {
            c0659BuilderM3740setN.setCustomKid(JwtRsaSsaPkcs1PublicKey.CustomKid.newBuilder().setValue(getStringItem(c4385q0, "kid")).mo3555build());
        }
        return ProtoKeySerialization.m3499create(JWT_RSA_SSA_PKCS1_PUBLIC_KEY_URL, c0659BuilderM3740setN.mo3555build().toByteString(), C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static ProtoKeySerialization convertToRsaSsaPssKey(C4385q0 c4385q0) throws GeneralSecurityException {
        JwtRsaSsaPssAlgorithm jwtRsaSsaPssAlgorithm;
        String stringItem = getStringItem(c4385q0, "alg");
        stringItem.hashCode();
        switch (stringItem) {
            case "PS256":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS256;
                break;
            case "PS384":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS384;
                break;
            case "PS512":
                jwtRsaSsaPssAlgorithm = JwtRsaSsaPssAlgorithm.PS512;
                break;
            default:
                throw new GeneralSecurityException("Unknown Rsa Algorithm: " + getStringItem(c4385q0, "alg"));
        }
        if (c4385q0.m13151HGpJ("p") || c4385q0.m13151HGpJ("q") || c4385q0.m13151HGpJ("dq") || c4385q0.m13151HGpJ("dq") || c4385q0.m13151HGpJ("d") || c4385q0.m13151HGpJ("qi")) {
            throw new UnsupportedOperationException("importing RSA private keys is not implemented");
        }
        expectStringItem(c4385q0, "kty", "RSA");
        validateUseIsSig(c4385q0);
        validateKeyOpsIsVerify(c4385q0);
        JwtRsaSsaPssPublicKey.C0667Builder c0667BuilderM3785setN = JwtRsaSsaPssPublicKey.newBuilder().setVersion(0).setAlgorithm(jwtRsaSsaPssAlgorithm).m3784setE(ByteString.copyFrom(C0852Base64.urlSafeDecode(getStringItem(c4385q0, "e")))).m3785setN(ByteString.copyFrom(C0852Base64.urlSafeDecode(getStringItem(c4385q0, "n"))));
        if (c4385q0.m13151HGpJ("kid")) {
            c0667BuilderM3785setN.setCustomKid(JwtRsaSsaPssPublicKey.CustomKid.newBuilder().setValue(getStringItem(c4385q0, "kid")).mo3555build());
        }
        return ProtoKeySerialization.m3499create(JWT_RSA_SSA_PSS_PUBLIC_KEY_URL, c0667BuilderM3785setN.mo3555build().toByteString(), C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC, OutputPrefixType.RAW, null);
    }

    private static void expectStringItem(C4385q0 c4385q0, String str, String str2) throws GeneralSecurityException {
        String stringItem = getStringItem(c4385q0, str);
        if (stringItem.equals(str2)) {
            return;
        }
        throw new GeneralSecurityException("unexpected " + str + " value: " + stringItem);
    }

    @Deprecated
    public static String fromKeysetHandle(KeysetHandle keysetHandle, KeyAccess keyAccess) {
        return fromPublicKeysetHandle(keysetHandle);
    }

    public static String fromPublicKeysetHandle(KeysetHandle keysetHandle) throws GeneralSecurityException {
        C3858i0 c3858i0 = new C3858i0();
        for (int i = 0; i < keysetHandle.m3354size(); i++) {
            KeysetHandle.C0316Entry c0316EntryM3352getAt = keysetHandle.m3352getAt(i);
            if (c0316EntryM3352getAt.getStatus() == KeyStatus.f2991ENABLED) {
                AbstractC0308Key abstractC0308KeyM3361getKey = c0316EntryM3352getAt.m3361getKey();
                if (!(abstractC0308KeyM3361getKey instanceof LegacyProtoKey)) {
                    throw new GeneralSecurityException("only LegacyProtoKey is currently supported");
                }
                ProtoKeySerialization serialization = ((LegacyProtoKey) abstractC0308KeyM3361getKey).getSerialization(null);
                if (serialization.getOutputPrefixType() != OutputPrefixType.RAW && serialization.getOutputPrefixType() != OutputPrefixType.TINK) {
                    throw new GeneralSecurityException("only OutputPrefixType RAW and TINK are supported");
                }
                if (serialization.getKeyMaterialType() != C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    throw new GeneralSecurityException("only public keys can be converted");
                }
                String typeUrl = serialization.getTypeUrl();
                typeUrl.hashCode();
                switch (typeUrl) {
                    case "type.googleapis.com/google.crypto.tink.JwtEcdsaPublicKey":
                        c3858i0.m12264IEE(convertJwtEcdsaKey(serialization));
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PublicKey":
                        c3858i0.m12264IEE(convertJwtRsaSsaPkcs1(serialization));
                        break;
                    case "type.googleapis.com/google.crypto.tink.JwtRsaSsaPssPublicKey":
                        c3858i0.m12264IEE(convertJwtRsaSsaPss(serialization));
                        break;
                    default:
                        throw new GeneralSecurityException(String.format("key type %s is not supported", serialization.getTypeUrl()));
                }
            }
        }
        C4385q0 c4385q0 = new C4385q0();
        c4385q0.m13158fehf("keys", c3858i0);
        return c4385q0.toString();
    }

    /* renamed from: getKid */
    private static Optional<String> m3505getKid(@Nullable Integer num) {
        return num == null ? Optional.empty() : Optional.of(C0852Base64.urlSafeEncode(ByteBuffer.allocate(4).putInt(num.intValue()).array()));
    }

    private static String getStringItem(C4385q0 c4385q0, String str) throws GeneralSecurityException {
        if (!c4385q0.m13151HGpJ(str)) {
            throw new GeneralSecurityException(str + " not found");
        }
        if (c4385q0.m13154Ucbh(str).m12833qGY() && c4385q0.m13154Ucbh(str).m12834qdMbNW().m13436Ucbh()) {
            return c4385q0.m13154Ucbh(str).mo12267VA();
        }
        throw new GeneralSecurityException(str + " is not a string");
    }

    @Deprecated
    public static KeysetHandle toKeysetHandle(String str, KeyAccess keyAccess) {
        return toPublicKeysetHandle(str);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0072 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static KeysetHandle toPublicKeysetHandle(String str) throws GeneralSecurityException {
        ProtoKeySerialization protoKeySerializationConvertToEcdsaKey;
        try {
            C4587t0 c4587t0 = new C4587t0(new StringReader(str));
            c4587t0.m13566rWxwaT(false);
            C4385q0 c4385q0M12832lgHUyS = AbstractC4194n7.m12850mjFkc(c4587t0).m12832lgHUyS();
            KeysetHandle.C0315Builder c0315BuilderNewBuilder = KeysetHandle.newBuilder();
            Iterator it = c4385q0M12832lgHUyS.m13154Ucbh("keys").m12836xJ().iterator();
            while (it.hasNext()) {
                C4385q0 c4385q0M12832lgHUyS2 = ((AbstractC4187n0) it.next()).m12832lgHUyS();
                String strSubstring = getStringItem(c4385q0M12832lgHUyS2, "alg").substring(0, 2);
                strSubstring.hashCode();
                char c = 65535;
                switch (strSubstring.hashCode()) {
                    case 2222:
                        if (strSubstring.equals("ES")) {
                            c = 0;
                        }
                        switch (c) {
                            case 0:
                                protoKeySerializationConvertToEcdsaKey = convertToEcdsaKey(c4385q0M12832lgHUyS2);
                                break;
                            case 1:
                                protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPssKey(c4385q0M12832lgHUyS2);
                                break;
                            case 2:
                                protoKeySerializationConvertToEcdsaKey = convertToRsaSsaPkcs1Key(c4385q0M12832lgHUyS2);
                                break;
                            default:
                                throw new GeneralSecurityException("unexpected alg value: " + getStringItem(c4385q0M12832lgHUyS2, "alg"));
                        }
                        c0315BuilderNewBuilder.addEntry(KeysetHandle.importKey(new LegacyProtoKey(protoKeySerializationConvertToEcdsaKey, null)).withRandomId());
                    case 2563:
                        if (strSubstring.equals("PS")) {
                            c = 1;
                        }
                        switch (c) {
                        }
                        c0315BuilderNewBuilder.addEntry(KeysetHandle.importKey(new LegacyProtoKey(protoKeySerializationConvertToEcdsaKey, null)).withRandomId());
                        break;
                    case 2625:
                        if (strSubstring.equals("RS")) {
                            c = 2;
                        }
                        switch (c) {
                        }
                        c0315BuilderNewBuilder.addEntry(KeysetHandle.importKey(new LegacyProtoKey(protoKeySerializationConvertToEcdsaKey, null)).withRandomId());
                        break;
                    default:
                        switch (c) {
                        }
                        c0315BuilderNewBuilder.addEntry(KeysetHandle.importKey(new LegacyProtoKey(protoKeySerializationConvertToEcdsaKey, null)).withRandomId());
                        break;
                }
            }
            if (c0315BuilderNewBuilder.m3358size() <= 0) {
                throw new GeneralSecurityException("empty keyset");
            }
            c0315BuilderNewBuilder.m3357getAt(0).makePrimary();
            return c0315BuilderNewBuilder.m3356build();
        } catch (IllegalStateException | StackOverflowError | C4454r0 e) {
            throw new GeneralSecurityException("JWK set is invalid JSON", e);
        }
    }

    private static void validateKeyOpsIsVerify(C4385q0 c4385q0) throws GeneralSecurityException {
        if (c4385q0.m13151HGpJ("key_ops")) {
            if (!c4385q0.m13154Ucbh("key_ops").m12830MiMN()) {
                throw new GeneralSecurityException("key_ops is not an array");
            }
            C3858i0 c3858i0M12836xJ = c4385q0.m13154Ucbh("key_ops").m12836xJ();
            if (c3858i0M12836xJ.m12273size() != 1) {
                throw new GeneralSecurityException("key_ops must contain exactly one element");
            }
            if (!c3858i0M12836xJ.m12269diqgf(0).m12833qGY() || !c3858i0M12836xJ.m12269diqgf(0).m12834qdMbNW().m13436Ucbh()) {
                throw new GeneralSecurityException("key_ops is not a string");
            }
            if (c3858i0M12836xJ.m12269diqgf(0).mo12267VA().equals("verify")) {
                return;
            }
            throw new GeneralSecurityException("unexpected keyOps value: " + c3858i0M12836xJ.m12269diqgf(0).mo12267VA());
        }
    }

    private static void validateUseIsSig(C4385q0 c4385q0) throws GeneralSecurityException {
        if (c4385q0.m13151HGpJ("use")) {
            expectStringItem(c4385q0, "use", "sig");
        }
    }
}
