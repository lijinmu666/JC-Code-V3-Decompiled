package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p070jwt.JwtFormat;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.JwtHmacAlgorithm;
import com.p038google.p061crypto.p062tink.p073proto.JwtHmacKey;
import com.p038google.p061crypto.p062tink.p073proto.JwtHmacKeyFormat;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.C0869PrfMac;
import com.p038google.p061crypto.p062tink.p075subtle.C0870Random;
import com.p038google.p061crypto.p062tink.p075subtle.PrfHmacJce;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.crypto.spec.SecretKeySpec;
import p131o.C4385q0;

/* loaded from: classes.dex */
public final class JwtHmacKeyManager extends KeyTypeManager<JwtHmacKey> {

    /* renamed from: com.google.crypto.tink.jwt.JwtHmacKeyManager$3 */
    public static /* synthetic */ class C04403 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm;

        static {
            int[] iArr = new int[JwtHmacAlgorithm.m3693values().length];
            $SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm = iArr;
            try {
                iArr[JwtHmacAlgorithm.HS256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm[JwtHmacAlgorithm.HS384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm[JwtHmacAlgorithm.HS512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.jwt.JwtHmacKeyManager$JwtHmac */
    public static final class C0441JwtHmac implements JwtMacInternal {
        private final String algorithm;
        private final Optional<String> customKidFromHmacKey;

        /* renamed from: prfMac */
        private final C0869PrfMac f3128prfMac;

        public C0441JwtHmac(String str, Optional<String> optional, C0869PrfMac c0869PrfMac) {
            this.algorithm = str;
            this.customKidFromHmacKey = optional;
            this.f3128prfMac = c0869PrfMac;
        }

        @Override // com.p038google.p061crypto.p062tink.p070jwt.JwtMacInternal
        public String computeMacAndEncodeWithKid(C0454RawJwt c0454RawJwt, Optional<String> optional) throws JwtInvalidException {
            if (this.customKidFromHmacKey.isPresent()) {
                if (optional.isPresent()) {
                    throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
                }
                optional = this.customKidFromHmacKey;
            }
            String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(this.algorithm, optional, c0454RawJwt);
            return JwtFormat.createSignedCompact(strCreateUnsignedCompact, this.f3128prfMac.computeMac(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
        }

        @Override // com.p038google.p061crypto.p062tink.p070jwt.JwtMacInternal
        public VerifiedJwt verifyMacAndDecodeWithKid(String str, JwtValidator jwtValidator, Optional<String> optional) throws GeneralSecurityException {
            JwtFormat.C0437Parts c0437PartsSplitSignedCompact = JwtFormat.splitSignedCompact(str);
            this.f3128prfMac.verifyMac(c0437PartsSplitSignedCompact.signatureOrMac, c0437PartsSplitSignedCompact.unsignedCompact.getBytes(StandardCharsets.US_ASCII));
            C4385q0 json = JsonUtil.parseJson(c0437PartsSplitSignedCompact.f3125header);
            JwtFormat.validateHeader(this.algorithm, optional, this.customKidFromHmacKey, json);
            return jwtValidator.validate(C0454RawJwt.fromJsonPayload(JwtFormat.getTypeHeader(json), c0437PartsSplitSignedCompact.f3126payload));
        }
    }

    public JwtHmacKeyManager() {
        super(JwtHmacKey.class, new PrimitiveFactory<JwtMacInternal, JwtHmacKey>(JwtMacInternal.class) { // from class: com.google.crypto.tink.jwt.JwtHmacKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public JwtMacInternal getPrimitive(JwtHmacKey jwtHmacKey) {
                JwtHmacAlgorithm algorithm = jwtHmacKey.getAlgorithm();
                PrfHmacJce prfHmacJce = new PrfHmacJce(JwtHmacKeyManager.getHmacAlgorithm(algorithm), new SecretKeySpec(jwtHmacKey.getKeyValue().toByteArray(), "HMAC"));
                return new C0441JwtHmac(JwtHmacKeyManager.getAlgorithmName(algorithm), jwtHmacKey.hasCustomKid() ? Optional.of(jwtHmacKey.getCustomKid().getValue()) : Optional.empty(), new C0869PrfMac(prfHmacJce, prfHmacJce.getMaxOutputLength()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<JwtHmacKeyFormat> createKeyFormat(JwtHmacAlgorithm jwtHmacAlgorithm, int i, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(JwtHmacKeyFormat.newBuilder().setAlgorithm(jwtHmacAlgorithm).setKeySize(i).mo3555build(), outputPrefixType);
    }

    private static KeyTemplate createTemplate(JwtHmacAlgorithm jwtHmacAlgorithm, int i) {
        return KeyTemplate.m3342create(new JwtHmacKeyManager().getKeyType(), JwtHmacKeyFormat.newBuilder().setAlgorithm(jwtHmacAlgorithm).setKeySize(i).mo3555build().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getAlgorithmName(JwtHmacAlgorithm jwtHmacAlgorithm) throws GeneralSecurityException {
        int i = C04403.$SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm[jwtHmacAlgorithm.ordinal()];
        if (i == 1) {
            return "HS256";
        }
        if (i == 2) {
            return "HS384";
        }
        if (i == 3) {
            return "HS512";
        }
        throw new GeneralSecurityException("unknown algorithm");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getHmacAlgorithm(JwtHmacAlgorithm jwtHmacAlgorithm) throws GeneralSecurityException {
        int i = C04403.$SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm[jwtHmacAlgorithm.ordinal()];
        if (i == 1) {
            return "HMACSHA256";
        }
        if (i == 2) {
            return "HMACSHA384";
        }
        if (i == 3) {
            return "HMACSHA512";
        }
        throw new GeneralSecurityException("unknown algorithm");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getMinimumKeySizeInBytes(JwtHmacAlgorithm jwtHmacAlgorithm) throws GeneralSecurityException {
        int i = C04403.$SwitchMap$com$google$crypto$tink$proto$JwtHmacAlgorithm[jwtHmacAlgorithm.ordinal()];
        if (i == 1) {
            return 32;
        }
        if (i == 2) {
            return 48;
        }
        if (i == 3) {
            return 64;
        }
        throw new GeneralSecurityException("unknown algorithm");
    }

    public static final KeyTemplate hs256Template() {
        return createTemplate(JwtHmacAlgorithm.HS256, 32);
    }

    public static final KeyTemplate hs384Template() {
        return createTemplate(JwtHmacAlgorithm.HS384, 48);
    }

    public static final KeyTemplate hs512Template() {
        return createTemplate(JwtHmacAlgorithm.HS512, 64);
    }

    public static void register(boolean z) {
        Registry.registerKeyManager(new JwtHmacKeyManager(), z);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtHmacKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<JwtHmacKeyFormat, JwtHmacKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<JwtHmacKeyFormat, JwtHmacKey>(JwtHmacKeyFormat.class) { // from class: com.google.crypto.tink.jwt.JwtHmacKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<JwtHmacKeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                JwtHmacAlgorithm jwtHmacAlgorithm = JwtHmacAlgorithm.HS256;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("JWT_HS256_RAW", JwtHmacKeyManager.createKeyFormat(jwtHmacAlgorithm, 32, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.TINK;
                map.put("JWT_HS256", JwtHmacKeyManager.createKeyFormat(jwtHmacAlgorithm, 32, outputPrefixType2));
                JwtHmacAlgorithm jwtHmacAlgorithm2 = JwtHmacAlgorithm.HS384;
                map.put("JWT_HS384_RAW", JwtHmacKeyManager.createKeyFormat(jwtHmacAlgorithm2, 48, outputPrefixType));
                map.put("JWT_HS384", JwtHmacKeyManager.createKeyFormat(jwtHmacAlgorithm2, 48, outputPrefixType2));
                JwtHmacAlgorithm jwtHmacAlgorithm3 = JwtHmacAlgorithm.HS512;
                map.put("JWT_HS512_RAW", JwtHmacKeyManager.createKeyFormat(jwtHmacAlgorithm3, 64, outputPrefixType));
                map.put("JWT_HS512", JwtHmacKeyManager.createKeyFormat(jwtHmacAlgorithm3, 64, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public JwtHmacKey createKey(JwtHmacKeyFormat jwtHmacKeyFormat) {
                return JwtHmacKey.newBuilder().setVersion(JwtHmacKeyManager.this.getVersion()).setAlgorithm(jwtHmacKeyFormat.getAlgorithm()).setKeyValue(ByteString.copyFrom(C0870Random.randBytes(jwtHmacKeyFormat.getKeySize()))).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public JwtHmacKey deriveKey(JwtHmacKeyFormat jwtHmacKeyFormat, InputStream inputStream) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public JwtHmacKeyFormat parseKeyFormat(ByteString byteString) {
                return JwtHmacKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(JwtHmacKeyFormat jwtHmacKeyFormat) throws GeneralSecurityException {
                if (jwtHmacKeyFormat.getKeySize() < JwtHmacKeyManager.getMinimumKeySizeInBytes(jwtHmacKeyFormat.getAlgorithm())) {
                    throw new GeneralSecurityException("key too short");
                }
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public JwtHmacKey parseKey(ByteString byteString) {
        return JwtHmacKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(JwtHmacKey jwtHmacKey) throws GeneralSecurityException {
        Validators.validateVersion(jwtHmacKey.getVersion(), getVersion());
        if (jwtHmacKey.getKeyValue().mo3944size() < getMinimumKeySizeInBytes(jwtHmacKey.getAlgorithm())) {
            throw new GeneralSecurityException("key too short");
        }
    }
}
