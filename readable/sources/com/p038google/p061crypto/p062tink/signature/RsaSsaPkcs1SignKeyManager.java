package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.PublicKeySign;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPkcs1KeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPkcs1Params;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPkcs1PrivateKey;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPkcs1PublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.EngineFactory;
import com.p038google.p061crypto.p062tink.p075subtle.RsaSsaPkcs1SignJce;
import com.p038google.p061crypto.p062tink.p075subtle.SelfKeyTestValidators;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import com.p038google.p061crypto.p062tink.signature.internal.C0839SigUtil;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
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

/* loaded from: classes.dex */
public final class RsaSsaPkcs1SignKeyManager extends PrivateKeyTypeManager<RsaSsaPkcs1PrivateKey, RsaSsaPkcs1PublicKey> {
    public RsaSsaPkcs1SignKeyManager() {
        super(RsaSsaPkcs1PrivateKey.class, RsaSsaPkcs1PublicKey.class, new PrimitiveFactory<PublicKeySign, RsaSsaPkcs1PrivateKey>(PublicKeySign.class) { // from class: com.google.crypto.tink.signature.RsaSsaPkcs1SignKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public PublicKeySign getPrimitive(RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) {
                KeyFactory engineFactory = EngineFactory.KEY_FACTORY.getInstance("RSA");
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) engineFactory.generatePrivate(new RSAPrivateCrtKeySpec(new BigInteger(1, rsaSsaPkcs1PrivateKey.getPublicKey().mo3855getN().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.getPublicKey().mo3854getE().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.mo3833getD().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.mo3836getP().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.mo3837getQ().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.mo3834getDp().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.mo3835getDq().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.mo3832getCrt().toByteArray())));
                RsaSsaPkcs1Params params = rsaSsaPkcs1PrivateKey.getPublicKey().getParams();
                SelfKeyTestValidators.validateRsaSsaPkcs1(rSAPrivateCrtKey, (RSAPublicKey) engineFactory.generatePublic(new RSAPublicKeySpec(new BigInteger(1, rsaSsaPkcs1PrivateKey.getPublicKey().mo3855getN().toByteArray()), new BigInteger(1, rsaSsaPkcs1PrivateKey.getPublicKey().mo3854getE().toByteArray()))), C0839SigUtil.toHashType(params.getHashType()));
                return new RsaSsaPkcs1SignJce(rSAPrivateCrtKey, C0839SigUtil.toHashType(params.getHashType()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPkcs1KeyFormat createKeyFormat(HashType hashType, int i, BigInteger bigInteger) {
        return RsaSsaPkcs1KeyFormat.newBuilder().setParams(RsaSsaPkcs1Params.newBuilder().setHashType(hashType).mo3555build()).setModulusSizeInBits(i).setPublicExponent(ByteString.copyFrom(bigInteger.toByteArray())).mo3555build();
    }

    private static KeyTemplate createKeyTemplate(HashType hashType, int i, BigInteger bigInteger, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.m3342create(new RsaSsaPkcs1SignKeyManager().getKeyType(), createKeyFormat(hashType, i, bigInteger).toByteArray(), outputPrefixType);
    }

    public static final KeyTemplate rawRsa3072SsaPkcs1Sha256F4Template() {
        return createKeyTemplate(HashType.SHA256, 3072, RSAKeyGenParameterSpec.F4, KeyTemplate.OutputPrefixType.RAW);
    }

    public static final KeyTemplate rawRsa4096SsaPkcs1Sha512F4Template() {
        return createKeyTemplate(HashType.SHA512, 4096, RSAKeyGenParameterSpec.F4, KeyTemplate.OutputPrefixType.RAW);
    }

    public static void registerPair(boolean z) {
        Registry.registerAsymmetricKeyManagers(new RsaSsaPkcs1SignKeyManager(), new RsaSsaPkcs1VerifyKeyManager(), z);
    }

    public static final KeyTemplate rsa3072SsaPkcs1Sha256F4Template() {
        return createKeyTemplate(HashType.SHA256, 3072, RSAKeyGenParameterSpec.F4, KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rsa4096SsaPkcs1Sha512F4Template() {
        return createKeyTemplate(HashType.SHA512, 4096, RSAKeyGenParameterSpec.F4, KeyTemplate.OutputPrefixType.TINK);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPkcs1PrivateKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<RsaSsaPkcs1KeyFormat, RsaSsaPkcs1PrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<RsaSsaPkcs1KeyFormat, RsaSsaPkcs1PrivateKey>(RsaSsaPkcs1KeyFormat.class) { // from class: com.google.crypto.tink.signature.RsaSsaPkcs1SignKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<RsaSsaPkcs1KeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                BigInteger bigInteger = RSAKeyGenParameterSpec.F4;
                RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormatCreateKeyFormat = RsaSsaPkcs1SignKeyManager.createKeyFormat(hashType, 3072, bigInteger);
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("RSA_SSA_PKCS1_3072_SHA256_F4", new KeyTypeManager.KeyFactory.KeyFormat(rsaSsaPkcs1KeyFormatCreateKeyFormat, outputPrefixType));
                RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormatCreateKeyFormat2 = RsaSsaPkcs1SignKeyManager.createKeyFormat(hashType, 3072, bigInteger);
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("RSA_SSA_PKCS1_3072_SHA256_F4_RAW", new KeyTypeManager.KeyFactory.KeyFormat(rsaSsaPkcs1KeyFormatCreateKeyFormat2, outputPrefixType2));
                map.put("RSA_SSA_PKCS1_3072_SHA256_F4_WITHOUT_PREFIX", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPkcs1SignKeyManager.createKeyFormat(hashType, 3072, bigInteger), outputPrefixType2));
                HashType hashType2 = HashType.SHA512;
                map.put("RSA_SSA_PKCS1_4096_SHA512_F4", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPkcs1SignKeyManager.createKeyFormat(hashType2, 4096, bigInteger), outputPrefixType));
                map.put("RSA_SSA_PKCS1_4096_SHA512_F4_RAW", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPkcs1SignKeyManager.createKeyFormat(hashType2, 4096, bigInteger), outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public RsaSsaPkcs1PrivateKey createKey(RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormat) throws InvalidAlgorithmParameterException {
                RsaSsaPkcs1Params params = rsaSsaPkcs1KeyFormat.getParams();
                KeyPairGenerator engineFactory = EngineFactory.KEY_PAIR_GENERATOR.getInstance("RSA");
                engineFactory.initialize(new RSAKeyGenParameterSpec(rsaSsaPkcs1KeyFormat.getModulusSizeInBits(), new BigInteger(1, rsaSsaPkcs1KeyFormat.getPublicExponent().toByteArray())));
                KeyPair keyPairGenerateKeyPair = engineFactory.generateKeyPair();
                RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyPairGenerateKeyPair.getPrivate();
                return RsaSsaPkcs1PrivateKey.newBuilder().setVersion(RsaSsaPkcs1SignKeyManager.this.getVersion()).setPublicKey(RsaSsaPkcs1PublicKey.newBuilder().setVersion(RsaSsaPkcs1SignKeyManager.this.getVersion()).setParams(params).m3858setE(ByteString.copyFrom(rSAPublicKey.getPublicExponent().toByteArray())).m3859setN(ByteString.copyFrom(rSAPublicKey.getModulus().toByteArray())).mo3555build()).m3844setD(ByteString.copyFrom(rSAPrivateCrtKey.getPrivateExponent().toByteArray())).m3847setP(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeP().toByteArray())).m3848setQ(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeQ().toByteArray())).m3845setDp(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeExponentP().toByteArray())).m3846setDq(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeExponentQ().toByteArray())).m3843setCrt(ByteString.copyFrom(rSAPrivateCrtKey.getCrtCoefficient().toByteArray())).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public RsaSsaPkcs1KeyFormat parseKeyFormat(ByteString byteString) {
                return RsaSsaPkcs1KeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(RsaSsaPkcs1KeyFormat rsaSsaPkcs1KeyFormat) throws GeneralSecurityException {
                C0839SigUtil.validateRsaSsaPkcs1Params(rsaSsaPkcs1KeyFormat.getParams());
                Validators.validateRsaModulusSize(rsaSsaPkcs1KeyFormat.getModulusSizeInBits());
                Validators.validateRsaPublicExponent(new BigInteger(1, rsaSsaPkcs1KeyFormat.getPublicExponent().toByteArray()));
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager
    public RsaSsaPkcs1PublicKey getPublicKey(RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) {
        return rsaSsaPkcs1PrivateKey.getPublicKey();
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public RsaSsaPkcs1PrivateKey parseKey(ByteString byteString) {
        return RsaSsaPkcs1PrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(RsaSsaPkcs1PrivateKey rsaSsaPkcs1PrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(rsaSsaPkcs1PrivateKey.getVersion(), getVersion());
        Validators.validateRsaModulusSize(new BigInteger(1, rsaSsaPkcs1PrivateKey.getPublicKey().mo3855getN().toByteArray()).bitLength());
        Validators.validateRsaPublicExponent(new BigInteger(1, rsaSsaPkcs1PrivateKey.getPublicKey().mo3854getE().toByteArray()));
        C0839SigUtil.validateRsaSsaPkcs1Params(rsaSsaPkcs1PrivateKey.getPublicKey().getParams());
    }
}
