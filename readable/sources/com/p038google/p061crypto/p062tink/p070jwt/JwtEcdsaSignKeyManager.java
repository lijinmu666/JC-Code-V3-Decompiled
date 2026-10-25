package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.JwtEcdsaAlgorithm;
import com.p038google.p061crypto.p062tink.p073proto.JwtEcdsaKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.JwtEcdsaPrivateKey;
import com.p038google.p061crypto.p062tink.p073proto.JwtEcdsaPublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.EcdsaSignJce;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import com.p038google.p061crypto.p062tink.p075subtle.SelfKeyTestValidators;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/* loaded from: classes.dex */
public final class JwtEcdsaSignKeyManager extends PrivateKeyTypeManager<JwtEcdsaPrivateKey, JwtEcdsaPublicKey> {

    public static class JwtPublicKeySignFactory extends PrimitiveFactory<JwtPublicKeySignInternal, JwtEcdsaPrivateKey> {
        public JwtPublicKeySignFactory() {
            super(JwtPublicKeySignInternal.class);
        }

        private static final void selfTestKey(ECPrivateKey eCPrivateKey, JwtEcdsaPrivateKey jwtEcdsaPrivateKey) throws GeneralSecurityException {
            SelfKeyTestValidators.validateEcdsa(eCPrivateKey, EllipticCurves.getEcPublicKey(JwtEcdsaVerifyKeyManager.getCurve(jwtEcdsaPrivateKey.getPublicKey().getAlgorithm()), jwtEcdsaPrivateKey.getPublicKey().mo3684getX().toByteArray(), jwtEcdsaPrivateKey.getPublicKey().mo3685getY().toByteArray()), JwtEcdsaVerifyKeyManager.hashForEcdsaAlgorithm(jwtEcdsaPrivateKey.getPublicKey().getAlgorithm()), EllipticCurves.EcdsaEncoding.IEEE_P1363);
        }

        @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
        public JwtPublicKeySignInternal getPrimitive(JwtEcdsaPrivateKey jwtEcdsaPrivateKey) throws GeneralSecurityException {
            ECPrivateKey ecPrivateKey = EllipticCurves.getEcPrivateKey(JwtEcdsaVerifyKeyManager.getCurve(jwtEcdsaPrivateKey.getPublicKey().getAlgorithm()), jwtEcdsaPrivateKey.getKeyValue().toByteArray());
            selfTestKey(ecPrivateKey, jwtEcdsaPrivateKey);
            JwtEcdsaAlgorithm algorithm = jwtEcdsaPrivateKey.getPublicKey().getAlgorithm();
            final EcdsaSignJce ecdsaSignJce = new EcdsaSignJce(ecPrivateKey, JwtEcdsaVerifyKeyManager.hashForEcdsaAlgorithm(algorithm), EllipticCurves.EcdsaEncoding.IEEE_P1363);
            final String strName = algorithm.name();
            final Optional optionalOf = jwtEcdsaPrivateKey.getPublicKey().hasCustomKid() ? Optional.of(jwtEcdsaPrivateKey.getPublicKey().getCustomKid().getValue()) : Optional.empty();
            return new JwtPublicKeySignInternal() { // from class: com.google.crypto.tink.jwt.JwtEcdsaSignKeyManager.JwtPublicKeySignFactory.1
                @Override // com.p038google.p061crypto.p062tink.p070jwt.JwtPublicKeySignInternal
                public String signAndEncodeWithKid(C0454RawJwt c0454RawJwt, Optional<String> optional) throws JwtInvalidException {
                    if (optionalOf.isPresent()) {
                        if (optional.isPresent()) {
                            throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
                        }
                        optional = optionalOf;
                    }
                    String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(strName, optional, c0454RawJwt);
                    return JwtFormat.createSignedCompact(strCreateUnsignedCompact, ecdsaSignJce.mo3386sign(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
                }
            };
        }
    }

    public JwtEcdsaSignKeyManager() {
        super(JwtEcdsaPrivateKey.class, JwtEcdsaPublicKey.class, new JwtPublicKeySignFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<JwtEcdsaKeyFormat> createKeyFormat(JwtEcdsaAlgorithm jwtEcdsaAlgorithm, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(JwtEcdsaKeyFormat.newBuilder().setAlgorithm(jwtEcdsaAlgorithm).mo3555build(), outputPrefixType);
    }

    public static void registerPair(boolean z) {
        Registry.registerAsymmetricKeyManagers(new JwtEcdsaSignKeyManager(), new JwtEcdsaVerifyKeyManager(), z);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtEcdsaPrivateKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<JwtEcdsaKeyFormat, JwtEcdsaPrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<JwtEcdsaKeyFormat, JwtEcdsaPrivateKey>(JwtEcdsaKeyFormat.class) { // from class: com.google.crypto.tink.jwt.JwtEcdsaSignKeyManager.1
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<JwtEcdsaKeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                JwtEcdsaAlgorithm jwtEcdsaAlgorithm = JwtEcdsaAlgorithm.ES256;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("JWT_ES256_RAW", JwtEcdsaSignKeyManager.createKeyFormat(jwtEcdsaAlgorithm, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.TINK;
                map.put("JWT_ES256", JwtEcdsaSignKeyManager.createKeyFormat(jwtEcdsaAlgorithm, outputPrefixType2));
                JwtEcdsaAlgorithm jwtEcdsaAlgorithm2 = JwtEcdsaAlgorithm.ES384;
                map.put("JWT_ES384_RAW", JwtEcdsaSignKeyManager.createKeyFormat(jwtEcdsaAlgorithm2, outputPrefixType));
                map.put("JWT_ES384", JwtEcdsaSignKeyManager.createKeyFormat(jwtEcdsaAlgorithm2, outputPrefixType2));
                JwtEcdsaAlgorithm jwtEcdsaAlgorithm3 = JwtEcdsaAlgorithm.ES512;
                map.put("JWT_ES512_RAW", JwtEcdsaSignKeyManager.createKeyFormat(jwtEcdsaAlgorithm3, outputPrefixType));
                map.put("JWT_ES512", JwtEcdsaSignKeyManager.createKeyFormat(jwtEcdsaAlgorithm3, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public JwtEcdsaPrivateKey createKey(JwtEcdsaKeyFormat jwtEcdsaKeyFormat) {
                JwtEcdsaAlgorithm algorithm = jwtEcdsaKeyFormat.getAlgorithm();
                KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(JwtEcdsaVerifyKeyManager.getCurve(jwtEcdsaKeyFormat.getAlgorithm()));
                ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
                ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
                ECPoint w = eCPublicKey.getW();
                return JwtEcdsaPrivateKey.newBuilder().setVersion(JwtEcdsaSignKeyManager.this.getVersion()).setPublicKey(JwtEcdsaPublicKey.newBuilder().setVersion(JwtEcdsaSignKeyManager.this.getVersion()).setAlgorithm(algorithm).m3688setX(ByteString.copyFrom(w.getAffineX().toByteArray())).m3689setY(ByteString.copyFrom(w.getAffineY().toByteArray())).mo3555build()).setKeyValue(ByteString.copyFrom(eCPrivateKey.getS().toByteArray())).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public JwtEcdsaPrivateKey deriveKey(JwtEcdsaKeyFormat jwtEcdsaKeyFormat, InputStream inputStream) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public JwtEcdsaKeyFormat parseKeyFormat(ByteString byteString) {
                return JwtEcdsaKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(JwtEcdsaKeyFormat jwtEcdsaKeyFormat) throws GeneralSecurityException {
                JwtEcdsaVerifyKeyManager.validateEcdsaAlgorithm(jwtEcdsaKeyFormat.getAlgorithm());
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager
    public JwtEcdsaPublicKey getPublicKey(JwtEcdsaPrivateKey jwtEcdsaPrivateKey) {
        return jwtEcdsaPrivateKey.getPublicKey();
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public JwtEcdsaPrivateKey parseKey(ByteString byteString) {
        return JwtEcdsaPrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(JwtEcdsaPrivateKey jwtEcdsaPrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(jwtEcdsaPrivateKey.getVersion(), getVersion());
        JwtEcdsaVerifyKeyManager.validateEcdsaAlgorithm(jwtEcdsaPrivateKey.getPublicKey().getAlgorithm());
    }
}
