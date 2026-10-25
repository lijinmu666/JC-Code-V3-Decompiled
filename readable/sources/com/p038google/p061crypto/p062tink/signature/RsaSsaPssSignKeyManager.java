package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.PublicKeySign;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssParams;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPrivateKey;
import com.p038google.p061crypto.p062tink.p073proto.RsaSsaPssPublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.EngineFactory;
import com.p038google.p061crypto.p062tink.p075subtle.RsaSsaPssSignJce;
import com.p038google.p061crypto.p062tink.p075subtle.SelfKeyTestValidators;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import com.p038google.p061crypto.p062tink.signature.internal.C0839SigUtil;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
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
public final class RsaSsaPssSignKeyManager extends PrivateKeyTypeManager<RsaSsaPssPrivateKey, RsaSsaPssPublicKey> {
    public RsaSsaPssSignKeyManager() {
        super(RsaSsaPssPrivateKey.class, RsaSsaPssPublicKey.class, new PrimitiveFactory<PublicKeySign, RsaSsaPssPrivateKey>(PublicKeySign.class) { // from class: com.google.crypto.tink.signature.RsaSsaPssSignKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public PublicKeySign getPrimitive(RsaSsaPssPrivateKey rsaSsaPssPrivateKey) {
                KeyFactory engineFactory = EngineFactory.KEY_FACTORY.getInstance("RSA");
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) engineFactory.generatePrivate(new RSAPrivateCrtKeySpec(new BigInteger(1, rsaSsaPssPrivateKey.getPublicKey().mo3897getN().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.getPublicKey().mo3896getE().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.mo3875getD().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.mo3878getP().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.mo3879getQ().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.mo3876getDp().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.mo3877getDq().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.mo3874getCrt().toByteArray())));
                RsaSsaPssParams params = rsaSsaPssPrivateKey.getPublicKey().getParams();
                SelfKeyTestValidators.validateRsaSsaPss(rSAPrivateCrtKey, (RSAPublicKey) engineFactory.generatePublic(new RSAPublicKeySpec(new BigInteger(1, rsaSsaPssPrivateKey.getPublicKey().mo3897getN().toByteArray()), new BigInteger(1, rsaSsaPssPrivateKey.getPublicKey().mo3896getE().toByteArray()))), C0839SigUtil.toHashType(params.getSigHash()), C0839SigUtil.toHashType(params.getMgf1Hash()), params.getSaltLength());
                return new RsaSsaPssSignJce(rSAPrivateCrtKey, C0839SigUtil.toHashType(params.getSigHash()), C0839SigUtil.toHashType(params.getMgf1Hash()), params.getSaltLength());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static RsaSsaPssKeyFormat createKeyFormat(HashType hashType, HashType hashType2, int i, int i2, BigInteger bigInteger) {
        return RsaSsaPssKeyFormat.newBuilder().setParams(RsaSsaPssParams.newBuilder().setSigHash(hashType).setMgf1Hash(hashType2).setSaltLength(i).mo3555build()).setModulusSizeInBits(i2).setPublicExponent(ByteString.copyFrom(bigInteger.toByteArray())).mo3555build();
    }

    private static KeyTemplate createKeyTemplate(HashType hashType, HashType hashType2, int i, int i2, BigInteger bigInteger, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.m3342create(new RsaSsaPssSignKeyManager().getKeyType(), createKeyFormat(hashType, hashType2, i, i2, bigInteger).toByteArray(), outputPrefixType);
    }

    public static final KeyTemplate rawRsa3072PssSha256F4Template() {
        HashType hashType = HashType.SHA256;
        return createKeyTemplate(hashType, hashType, 32, 3072, RSAKeyGenParameterSpec.F4, KeyTemplate.OutputPrefixType.RAW);
    }

    public static final KeyTemplate rawRsa4096PssSha512F4Template() {
        HashType hashType = HashType.SHA512;
        return createKeyTemplate(hashType, hashType, 64, 4096, RSAKeyGenParameterSpec.F4, KeyTemplate.OutputPrefixType.RAW);
    }

    public static void registerPair(boolean z) {
        Registry.registerAsymmetricKeyManagers(new RsaSsaPssSignKeyManager(), new RsaSsaPssVerifyKeyManager(), z);
    }

    public static final KeyTemplate rsa3072PssSha256F4Template() {
        HashType hashType = HashType.SHA256;
        return createKeyTemplate(hashType, hashType, 32, 3072, RSAKeyGenParameterSpec.F4, KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rsa4096PssSha512F4Template() {
        HashType hashType = HashType.SHA512;
        return createKeyTemplate(hashType, hashType, 64, 4096, RSAKeyGenParameterSpec.F4, KeyTemplate.OutputPrefixType.TINK);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.RsaSsaPssPrivateKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<RsaSsaPssKeyFormat, RsaSsaPssPrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<RsaSsaPssKeyFormat, RsaSsaPssPrivateKey>(RsaSsaPssKeyFormat.class) { // from class: com.google.crypto.tink.signature.RsaSsaPssSignKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<RsaSsaPssKeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                BigInteger bigInteger = RSAKeyGenParameterSpec.F4;
                RsaSsaPssKeyFormat rsaSsaPssKeyFormatCreateKeyFormat = RsaSsaPssSignKeyManager.createKeyFormat(hashType, hashType, 32, 3072, bigInteger);
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("RSA_SSA_PSS_3072_SHA256_F4", new KeyTypeManager.KeyFactory.KeyFormat(rsaSsaPssKeyFormatCreateKeyFormat, outputPrefixType));
                RsaSsaPssKeyFormat rsaSsaPssKeyFormatCreateKeyFormat2 = RsaSsaPssSignKeyManager.createKeyFormat(hashType, hashType, 32, 3072, bigInteger);
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("RSA_SSA_PSS_3072_SHA256_F4_RAW", new KeyTypeManager.KeyFactory.KeyFormat(rsaSsaPssKeyFormatCreateKeyFormat2, outputPrefixType2));
                map.put("RSA_SSA_PSS_3072_SHA256_SHA256_32_F4", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPssSignKeyManager.createKeyFormat(hashType, hashType, 32, 3072, bigInteger), outputPrefixType));
                HashType hashType2 = HashType.SHA512;
                map.put("RSA_SSA_PSS_4096_SHA512_F4", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPssSignKeyManager.createKeyFormat(hashType2, hashType2, 64, 4096, bigInteger), outputPrefixType));
                map.put("RSA_SSA_PSS_4096_SHA512_F4_RAW", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPssSignKeyManager.createKeyFormat(hashType2, hashType2, 64, 4096, bigInteger), outputPrefixType2));
                map.put("RSA_SSA_PSS_4096_SHA512_SHA512_64_F4", new KeyTypeManager.KeyFactory.KeyFormat(RsaSsaPssSignKeyManager.createKeyFormat(hashType2, hashType2, 64, 4096, bigInteger), outputPrefixType));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public RsaSsaPssPrivateKey createKey(RsaSsaPssKeyFormat rsaSsaPssKeyFormat) throws GeneralSecurityException {
                RsaSsaPssParams params = rsaSsaPssKeyFormat.getParams();
                Validators.validateRsaModulusSize(rsaSsaPssKeyFormat.getModulusSizeInBits());
                Validators.validateSignatureHash(C0839SigUtil.toHashType(params.getSigHash()));
                KeyPairGenerator engineFactory = EngineFactory.KEY_PAIR_GENERATOR.getInstance("RSA");
                engineFactory.initialize(new RSAKeyGenParameterSpec(rsaSsaPssKeyFormat.getModulusSizeInBits(), new BigInteger(1, rsaSsaPssKeyFormat.getPublicExponent().toByteArray())));
                KeyPair keyPairGenerateKeyPair = engineFactory.generateKeyPair();
                RSAPublicKey rSAPublicKey = (RSAPublicKey) keyPairGenerateKeyPair.getPublic();
                RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) keyPairGenerateKeyPair.getPrivate();
                return RsaSsaPssPrivateKey.newBuilder().setVersion(RsaSsaPssSignKeyManager.this.getVersion()).setPublicKey(RsaSsaPssPublicKey.newBuilder().setVersion(RsaSsaPssSignKeyManager.this.getVersion()).setParams(params).m3900setE(ByteString.copyFrom(rSAPublicKey.getPublicExponent().toByteArray())).m3901setN(ByteString.copyFrom(rSAPublicKey.getModulus().toByteArray())).mo3555build()).m3886setD(ByteString.copyFrom(rSAPrivateCrtKey.getPrivateExponent().toByteArray())).m3889setP(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeP().toByteArray())).m3890setQ(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeQ().toByteArray())).m3887setDp(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeExponentP().toByteArray())).m3888setDq(ByteString.copyFrom(rSAPrivateCrtKey.getPrimeExponentQ().toByteArray())).m3885setCrt(ByteString.copyFrom(rSAPrivateCrtKey.getCrtCoefficient().toByteArray())).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public RsaSsaPssKeyFormat parseKeyFormat(ByteString byteString) {
                return RsaSsaPssKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(RsaSsaPssKeyFormat rsaSsaPssKeyFormat) throws GeneralSecurityException {
                C0839SigUtil.validateRsaSsaPssParams(rsaSsaPssKeyFormat.getParams());
                Validators.validateRsaModulusSize(rsaSsaPssKeyFormat.getModulusSizeInBits());
                Validators.validateRsaPublicExponent(new BigInteger(1, rsaSsaPssKeyFormat.getPublicExponent().toByteArray()));
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager
    public RsaSsaPssPublicKey getPublicKey(RsaSsaPssPrivateKey rsaSsaPssPrivateKey) {
        return rsaSsaPssPrivateKey.getPublicKey();
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public RsaSsaPssPrivateKey parseKey(ByteString byteString) {
        return RsaSsaPssPrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(RsaSsaPssPrivateKey rsaSsaPssPrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(rsaSsaPssPrivateKey.getVersion(), getVersion());
        Validators.validateRsaModulusSize(new BigInteger(1, rsaSsaPssPrivateKey.getPublicKey().mo3897getN().toByteArray()).bitLength());
        Validators.validateRsaPublicExponent(new BigInteger(1, rsaSsaPssPrivateKey.getPublicKey().mo3896getE().toByteArray()));
        C0839SigUtil.validateRsaSsaPssParams(rsaSsaPssPrivateKey.getPublicKey().getParams());
    }
}
