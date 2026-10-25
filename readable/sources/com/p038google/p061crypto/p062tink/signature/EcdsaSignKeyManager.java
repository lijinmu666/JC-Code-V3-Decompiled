package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.PublicKeySign;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaParams;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaPrivateKey;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaPublicKey;
import com.p038google.p061crypto.p062tink.p073proto.EcdsaSignatureEncoding;
import com.p038google.p061crypto.p062tink.p073proto.EllipticCurveType;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.EcdsaSignJce;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import com.p038google.p061crypto.p062tink.p075subtle.SelfKeyTestValidators;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import com.p038google.p061crypto.p062tink.signature.internal.C0839SigUtil;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class EcdsaSignKeyManager extends PrivateKeyTypeManager<EcdsaPrivateKey, EcdsaPublicKey> {
    public EcdsaSignKeyManager() {
        super(EcdsaPrivateKey.class, EcdsaPublicKey.class, new PrimitiveFactory<PublicKeySign, EcdsaPrivateKey>(PublicKeySign.class) { // from class: com.google.crypto.tink.signature.EcdsaSignKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public PublicKeySign getPrimitive(EcdsaPrivateKey ecdsaPrivateKey) throws NoSuchAlgorithmException {
                ECPrivateKey ecPrivateKey = EllipticCurves.getEcPrivateKey(C0839SigUtil.toCurveType(ecdsaPrivateKey.getPublicKey().getParams().getCurve()), ecdsaPrivateKey.getKeyValue().toByteArray());
                SelfKeyTestValidators.validateEcdsa(ecPrivateKey, EllipticCurves.getEcPublicKey(C0839SigUtil.toCurveType(ecdsaPrivateKey.getPublicKey().getParams().getCurve()), ecdsaPrivateKey.getPublicKey().mo3596getX().toByteArray(), ecdsaPrivateKey.getPublicKey().mo3597getY().toByteArray()), C0839SigUtil.toHashType(ecdsaPrivateKey.getPublicKey().getParams().getHashType()), C0839SigUtil.toEcdsaEncoding(ecdsaPrivateKey.getPublicKey().getParams().getEncoding()));
                return new EcdsaSignJce(ecPrivateKey, C0839SigUtil.toHashType(ecdsaPrivateKey.getPublicKey().getParams().getHashType()), C0839SigUtil.toEcdsaEncoding(ecdsaPrivateKey.getPublicKey().getParams().getEncoding()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<EcdsaKeyFormat> createKeyFormat(HashType hashType, EllipticCurveType ellipticCurveType, EcdsaSignatureEncoding ecdsaSignatureEncoding, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(EcdsaKeyFormat.newBuilder().setParams(EcdsaParams.newBuilder().setHashType(hashType).setCurve(ellipticCurveType).setEncoding(ecdsaSignatureEncoding).mo3555build()).mo3555build(), outputPrefixType);
    }

    public static KeyTemplate createKeyTemplate(HashType hashType, EllipticCurveType ellipticCurveType, EcdsaSignatureEncoding ecdsaSignatureEncoding, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.m3342create(new EcdsaSignKeyManager().getKeyType(), EcdsaKeyFormat.newBuilder().setParams(EcdsaParams.newBuilder().setHashType(hashType).setCurve(ellipticCurveType).setEncoding(ecdsaSignatureEncoding).mo3555build()).mo3555build().toByteArray(), outputPrefixType);
    }

    public static final KeyTemplate ecdsaP256Template() {
        return createKeyTemplate(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.DER, KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rawEcdsaP256Template() {
        return createKeyTemplate(HashType.SHA256, EllipticCurveType.NIST_P256, EcdsaSignatureEncoding.IEEE_P1363, KeyTemplate.OutputPrefixType.RAW);
    }

    public static void registerPair(boolean z) {
        Registry.registerAsymmetricKeyManagers(new EcdsaSignKeyManager(), new EcdsaVerifyKeyManager(), z);
        EcdsaProtoSerialization.register();
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<EcdsaKeyFormat, EcdsaPrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<EcdsaKeyFormat, EcdsaPrivateKey>(EcdsaKeyFormat.class) { // from class: com.google.crypto.tink.signature.EcdsaSignKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<EcdsaKeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                EllipticCurveType ellipticCurveType = EllipticCurveType.NIST_P256;
                EcdsaSignatureEncoding ecdsaSignatureEncoding = EcdsaSignatureEncoding.DER;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("ECDSA_P256", EcdsaSignKeyManager.createKeyFormat(hashType, ellipticCurveType, ecdsaSignatureEncoding, outputPrefixType));
                EcdsaSignatureEncoding ecdsaSignatureEncoding2 = EcdsaSignatureEncoding.IEEE_P1363;
                map.put("ECDSA_P256_IEEE_P1363", EcdsaSignKeyManager.createKeyFormat(hashType, ellipticCurveType, ecdsaSignatureEncoding2, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("ECDSA_P256_RAW", EcdsaSignKeyManager.createKeyFormat(hashType, ellipticCurveType, ecdsaSignatureEncoding2, outputPrefixType2));
                map.put("ECDSA_P256_IEEE_P1363_WITHOUT_PREFIX", EcdsaSignKeyManager.createKeyFormat(hashType, ellipticCurveType, ecdsaSignatureEncoding2, outputPrefixType2));
                HashType hashType2 = HashType.SHA512;
                EllipticCurveType ellipticCurveType2 = EllipticCurveType.NIST_P384;
                map.put("ECDSA_P384", EcdsaSignKeyManager.createKeyFormat(hashType2, ellipticCurveType2, ecdsaSignatureEncoding, outputPrefixType));
                map.put("ECDSA_P384_IEEE_P1363", EcdsaSignKeyManager.createKeyFormat(hashType2, ellipticCurveType2, ecdsaSignatureEncoding2, outputPrefixType));
                map.put("ECDSA_P384_SHA512", EcdsaSignKeyManager.createKeyFormat(hashType2, ellipticCurveType2, ecdsaSignatureEncoding, outputPrefixType));
                map.put("ECDSA_P384_SHA384", EcdsaSignKeyManager.createKeyFormat(HashType.SHA384, ellipticCurveType2, ecdsaSignatureEncoding, outputPrefixType));
                EllipticCurveType ellipticCurveType3 = EllipticCurveType.NIST_P521;
                map.put("ECDSA_P521", EcdsaSignKeyManager.createKeyFormat(hashType2, ellipticCurveType3, ecdsaSignatureEncoding, outputPrefixType));
                map.put("ECDSA_P521_IEEE_P1363", EcdsaSignKeyManager.createKeyFormat(hashType2, ellipticCurveType3, ecdsaSignatureEncoding2, outputPrefixType));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public EcdsaPrivateKey createKey(EcdsaKeyFormat ecdsaKeyFormat) {
                EcdsaParams params = ecdsaKeyFormat.getParams();
                KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(C0839SigUtil.toCurveType(params.getCurve()));
                ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
                ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
                ECPoint w = eCPublicKey.getW();
                return EcdsaPrivateKey.newBuilder().setVersion(EcdsaSignKeyManager.this.getVersion()).setPublicKey(EcdsaPublicKey.newBuilder().setVersion(EcdsaSignKeyManager.this.getVersion()).setParams(params).m3600setX(ByteString.copyFrom(w.getAffineX().toByteArray())).m3601setY(ByteString.copyFrom(w.getAffineY().toByteArray())).mo3555build()).setKeyValue(ByteString.copyFrom(eCPrivateKey.getS().toByteArray())).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public EcdsaKeyFormat parseKeyFormat(ByteString byteString) {
                return EcdsaKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(EcdsaKeyFormat ecdsaKeyFormat) {
                C0839SigUtil.validateEcdsaParams(ecdsaKeyFormat.getParams());
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager
    public EcdsaPublicKey getPublicKey(EcdsaPrivateKey ecdsaPrivateKey) {
        return ecdsaPrivateKey.getPublicKey();
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public EcdsaPrivateKey parseKey(ByteString byteString) {
        return EcdsaPrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(EcdsaPrivateKey ecdsaPrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(ecdsaPrivateKey.getVersion(), getVersion());
        C0839SigUtil.validateEcdsaParams(ecdsaPrivateKey.getPublicKey().getParams());
    }
}
