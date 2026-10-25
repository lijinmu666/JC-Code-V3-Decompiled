package com.p038google.p061crypto.p062tink.p070jwt;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1Algorithm;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1KeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PrivateKey;
import com.p038google.p061crypto.p062tink.p073proto.JwtRsaSsaPkcs1PublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.EngineFactory;
import com.p038google.p061crypto.p062tink.p075subtle.RsaSsaPkcs1SignJce;
import com.p038google.p061crypto.p062tink.p075subtle.SelfKeyTestValidators;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.RSAKeyGenParameterSpec;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/* loaded from: classes.dex */
public final class JwtRsaSsaPkcs1SignKeyManager extends PrivateKeyTypeManager<JwtRsaSsaPkcs1PrivateKey, JwtRsaSsaPkcs1PublicKey> {

    public static class JwtPublicKeySignFactory extends PrimitiveFactory<JwtPublicKeySignInternal, JwtRsaSsaPkcs1PrivateKey> {
        public JwtPublicKeySignFactory() {
            super(JwtPublicKeySignInternal.class);
        }

        @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
        public JwtPublicKeySignInternal getPrimitive(JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) {
            RSAPrivateCrtKey rSAPrivateCrtKeyCreatePrivateKey = JwtRsaSsaPkcs1SignKeyManager.createPrivateKey(jwtRsaSsaPkcs1PrivateKey);
            JwtRsaSsaPkcs1SignKeyManager.selfTestKey(rSAPrivateCrtKeyCreatePrivateKey, jwtRsaSsaPkcs1PrivateKey);
            JwtRsaSsaPkcs1Algorithm algorithm = jwtRsaSsaPkcs1PrivateKey.getPublicKey().getAlgorithm();
            final RsaSsaPkcs1SignJce rsaSsaPkcs1SignJce = new RsaSsaPkcs1SignJce(rSAPrivateCrtKeyCreatePrivateKey, JwtRsaSsaPkcs1VerifyKeyManager.hashForPkcs1Algorithm(algorithm));
            final String strName = algorithm.name();
            final Optional optionalOf = jwtRsaSsaPkcs1PrivateKey.getPublicKey().hasCustomKid() ? Optional.of(jwtRsaSsaPkcs1PrivateKey.getPublicKey().getCustomKid().getValue()) : Optional.empty();
            return new JwtPublicKeySignInternal() { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1SignKeyManager.JwtPublicKeySignFactory.1
                @Override // com.p038google.p061crypto.p062tink.p070jwt.JwtPublicKeySignInternal
                public String signAndEncodeWithKid(C0454RawJwt c0454RawJwt, Optional<String> optional) throws JwtInvalidException {
                    if (optionalOf.isPresent()) {
                        if (optional.isPresent()) {
                            throw new JwtInvalidException("custom_kid can only be set for RAW keys.");
                        }
                        optional = optionalOf;
                    }
                    String strCreateUnsignedCompact = JwtFormat.createUnsignedCompact(strName, optional, c0454RawJwt);
                    return JwtFormat.createSignedCompact(strCreateUnsignedCompact, rsaSsaPkcs1SignJce.mo3386sign(strCreateUnsignedCompact.getBytes(StandardCharsets.US_ASCII)));
                }
            };
        }
    }

    public JwtRsaSsaPkcs1SignKeyManager() {
        super(JwtRsaSsaPkcs1PrivateKey.class, JwtRsaSsaPkcs1PublicKey.class, new JwtPublicKeySignFactory());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<JwtRsaSsaPkcs1KeyFormat> createKeyFormat(JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm, int i, BigInteger bigInteger, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(JwtRsaSsaPkcs1KeyFormat.newBuilder().setAlgorithm(jwtRsaSsaPkcs1Algorithm).setModulusSizeInBits(i).setPublicExponent(ByteString.copyFrom(bigInteger.toByteArray())).mo3555build(), outputPrefixType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RSAPrivateCrtKey createPrivateKey(JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) {
        return (RSAPrivateCrtKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePrivate(new RSAPrivateCrtKeySpec(new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.getPublicKey().mo3736getN().toByteArray()), new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.getPublicKey().mo3735getE().toByteArray()), new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.mo3714getD().toByteArray()), new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.mo3717getP().toByteArray()), new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.mo3718getQ().toByteArray()), new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.mo3715getDp().toByteArray()), new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.mo3716getDq().toByteArray()), new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.mo3713getCrt().toByteArray())));
    }

    public static void registerPair(boolean z) {
        Registry.registerAsymmetricKeyManagers(new JwtRsaSsaPkcs1SignKeyManager(), new JwtRsaSsaPkcs1VerifyKeyManager(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void selfTestKey(RSAPrivateCrtKey rSAPrivateCrtKey, JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) {
        SelfKeyTestValidators.validateRsaSsaPkcs1(rSAPrivateCrtKey, (RSAPublicKey) EngineFactory.KEY_FACTORY.getInstance("RSA").generatePublic(new RSAPublicKeySpec(new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.getPublicKey().mo3736getN().toByteArray()), new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.getPublicKey().mo3735getE().toByteArray()))), JwtRsaSsaPkcs1VerifyKeyManager.hashForPkcs1Algorithm(jwtRsaSsaPkcs1PrivateKey.getPublicKey().getAlgorithm()));
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.JwtRsaSsaPkcs1PrivateKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<JwtRsaSsaPkcs1KeyFormat, JwtRsaSsaPkcs1PrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<JwtRsaSsaPkcs1KeyFormat, JwtRsaSsaPkcs1PrivateKey>(JwtRsaSsaPkcs1KeyFormat.class) { // from class: com.google.crypto.tink.jwt.JwtRsaSsaPkcs1SignKeyManager.1
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<JwtRsaSsaPkcs1KeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm = JwtRsaSsaPkcs1Algorithm.RS256;
                BigInteger bigInteger = RSAKeyGenParameterSpec.F4;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("JWT_RS256_2048_F4_RAW", JwtRsaSsaPkcs1SignKeyManager.createKeyFormat(jwtRsaSsaPkcs1Algorithm, 2048, bigInteger, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.TINK;
                map.put("JWT_RS256_2048_F4", JwtRsaSsaPkcs1SignKeyManager.createKeyFormat(jwtRsaSsaPkcs1Algorithm, 2048, bigInteger, outputPrefixType2));
                map.put("JWT_RS256_3072_F4_RAW", JwtRsaSsaPkcs1SignKeyManager.createKeyFormat(jwtRsaSsaPkcs1Algorithm, 3072, bigInteger, outputPrefixType));
                map.put("JWT_RS256_3072_F4", JwtRsaSsaPkcs1SignKeyManager.createKeyFormat(jwtRsaSsaPkcs1Algorithm, 3072, bigInteger, outputPrefixType2));
                JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm2 = JwtRsaSsaPkcs1Algorithm.RS384;
                map.put("JWT_RS384_3072_F4_RAW", JwtRsaSsaPkcs1SignKeyManager.createKeyFormat(jwtRsaSsaPkcs1Algorithm2, 3072, bigInteger, outputPrefixType));
                map.put("JWT_RS384_3072_F4", JwtRsaSsaPkcs1SignKeyManager.createKeyFormat(jwtRsaSsaPkcs1Algorithm2, 3072, bigInteger, outputPrefixType2));
                JwtRsaSsaPkcs1Algorithm jwtRsaSsaPkcs1Algorithm3 = JwtRsaSsaPkcs1Algorithm.RS512;
                map.put("JWT_RS512_4096_F4_RAW", JwtRsaSsaPkcs1SignKeyManager.createKeyFormat(jwtRsaSsaPkcs1Algorithm3, 4096, bigInteger, outputPrefixType));
                map.put("JWT_RS512_4096_F4", JwtRsaSsaPkcs1SignKeyManager.createKeyFormat(jwtRsaSsaPkcs1Algorithm3, 4096, bigInteger, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public JwtRsaSsaPkcs1PrivateKey createKey(JwtRsaSsaPkcs1KeyFormat jwtRsaSsaPkcs1KeyFormat) throws InvalidAlgorithmParameterException {
                JwtRsaSsaPkcs1Algorithm algorithm = jwtRsaSsaPkcs1KeyFormat.getAlgorithm();
                KeyPairGenerator engineFactory = EngineFactory.KEY_PAIR_GENERATOR.getInstance("RSA");
                engineFactory.initialize(new RSAKeyGenParameterSpec(jwtRsaSsaPkcs1KeyFormat.getModulusSizeInBits(), new BigInteger(1, jwtRsaSsaPkcs1KeyFormat.getPublicExponent().toByteArray())));
                KeyPair keyPairGenerateKeyPair = engineFactory.generateKeyPair();
                RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyPairGenerateKeyPair.getPrivate();
                return JwtRsaSsaPkcs1PrivateKey.newBuilder().setVersion(JwtRsaSsaPkcs1SignKeyManager.this.getVersion()).setPublicKey(JwtRsaSsaPkcs1PublicKey.newBuilder().setVersion(JwtRsaSsaPkcs1SignKeyManager.this.getVersion()).setAlgorithm(algorithm).m3739setE(ByteString.copyFrom(rSAPublicKey.getPublicExponent().toByteArray())).m3740setN(ByteString.copyFrom(rSAPublicKey.getModulus().toByteArray())).mo3555build()).m3725setD(ByteString.copyFrom(rSAPrivateCrtKey.getPrivateExponent().toByteArray())).m3728setP(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeP().toByteArray())).m3729setQ(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeQ().toByteArray())).m3726setDp(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeExponentP().toByteArray())).m3727setDq(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeExponentQ().toByteArray())).m3724setCrt(ByteString.copyFrom(rSAPrivateCrtKey.getCrtCoefficient().toByteArray())).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public JwtRsaSsaPkcs1PrivateKey deriveKey(JwtRsaSsaPkcs1KeyFormat jwtRsaSsaPkcs1KeyFormat, InputStream inputStream) {
                throw new UnsupportedOperationException();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public JwtRsaSsaPkcs1KeyFormat parseKeyFormat(ByteString byteString) {
                return JwtRsaSsaPkcs1KeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(JwtRsaSsaPkcs1KeyFormat jwtRsaSsaPkcs1KeyFormat) throws GeneralSecurityException {
                Validators.validateRsaModulusSize(jwtRsaSsaPkcs1KeyFormat.getModulusSizeInBits());
                Validators.validateRsaPublicExponent(new BigInteger(1, jwtRsaSsaPkcs1KeyFormat.getPublicExponent().toByteArray()));
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager
    public JwtRsaSsaPkcs1PublicKey getPublicKey(JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) {
        return jwtRsaSsaPkcs1PrivateKey.getPublicKey();
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public JwtRsaSsaPkcs1PrivateKey parseKey(ByteString byteString) {
        return JwtRsaSsaPkcs1PrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(JwtRsaSsaPkcs1PrivateKey jwtRsaSsaPkcs1PrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(jwtRsaSsaPkcs1PrivateKey.getVersion(), getVersion());
        Validators.validateRsaModulusSize(new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.getPublicKey().mo3736getN().toByteArray()).bitLength());
        Validators.validateRsaPublicExponent(new BigInteger(1, jwtRsaSsaPkcs1PrivateKey.getPublicKey().mo3735getE().toByteArray()));
    }
}
