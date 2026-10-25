package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.HybridDecrypt;
import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.KeyTemplates;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager;
import com.p038google.p061crypto.p062tink.p063aead.AesCtrHmacAeadKeyManager;
import com.p038google.p061crypto.p062tink.p063aead.AesGcmKeyManager;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.EcPointFormat;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadDemParams;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfParams;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPrivateKey;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfPublicKey;
import com.p038google.p061crypto.p062tink.p073proto.EciesHkdfKemParams;
import com.p038google.p061crypto.p062tink.p073proto.EllipticCurveType;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.EciesAeadHkdfHybridDecrypt;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
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
public final class EciesAeadHkdfPrivateKeyManager extends PrivateKeyTypeManager<EciesAeadHkdfPrivateKey, EciesAeadHkdfPublicKey> {
    private static final byte[] EMPTY_SALT = new byte[0];

    /* renamed from: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager$3 */
    public static /* synthetic */ class C03973 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType;

        static {
            int[] iArr = new int[KeyTemplate.OutputPrefixType.m3345values().length];
            $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType = iArr;
            try {
                iArr[KeyTemplate.OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[KeyTemplate.OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[KeyTemplate.OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[KeyTemplate.OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public EciesAeadHkdfPrivateKeyManager() {
        super(EciesAeadHkdfPrivateKey.class, EciesAeadHkdfPublicKey.class, new PrimitiveFactory<HybridDecrypt, EciesAeadHkdfPrivateKey>(HybridDecrypt.class) { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public HybridDecrypt getPrimitive(EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey) throws NoSuchAlgorithmException {
                EciesAeadHkdfParams params = eciesAeadHkdfPrivateKey.getPublicKey().getParams();
                EciesHkdfKemParams kemParams = params.getKemParams();
                return new EciesAeadHkdfHybridDecrypt(EllipticCurves.getEcPrivateKey(HybridUtil.toCurveType(kemParams.getCurveType()), eciesAeadHkdfPrivateKey.getKeyValue().toByteArray()), kemParams.getHkdfSalt().toByteArray(), HybridUtil.toHmacAlgo(kemParams.getHkdfHashType()), HybridUtil.toPointFormatType(params.getEcPointFormat()), new RegistryEciesAeadHkdfDemHelper(params.getDemParams().getAeadDem()));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<EciesAeadHkdfKeyFormat> createKeyFormat(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, byte[] bArr, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(EciesAeadHkdfKeyFormat.newBuilder().setParams(createParams(ellipticCurveType, hashType, ecPointFormat, keyTemplate, bArr)).mo3555build(), outputPrefixType);
    }

    private static KeyTemplate createKeyTemplate(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, KeyTemplate.OutputPrefixType outputPrefixType, byte[] bArr) {
        return KeyTemplate.m3342create(new EciesAeadHkdfPrivateKeyManager().getKeyType(), EciesAeadHkdfKeyFormat.newBuilder().setParams(createParams(ellipticCurveType, hashType, ecPointFormat, keyTemplate, bArr)).mo3555build().toByteArray(), outputPrefixType);
    }

    public static EciesAeadHkdfParams createParams(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, byte[] bArr) {
        EciesHkdfKemParams eciesHkdfKemParamsMo3555build = EciesHkdfKemParams.newBuilder().setCurveType(ellipticCurveType).setHkdfHashType(hashType).setHkdfSalt(ByteString.copyFrom(bArr)).mo3555build();
        return EciesAeadHkdfParams.newBuilder().setKemParams(eciesHkdfKemParamsMo3555build).setDemParams(EciesAeadDemParams.newBuilder().setAeadDem(com.p038google.p061crypto.p062tink.p073proto.KeyTemplate.newBuilder().setTypeUrl(keyTemplate.getTypeUrl()).setValue(ByteString.copyFrom(keyTemplate.getValue())).setOutputPrefixType(m3457toProto(keyTemplate.getOutputPrefixType())).mo3555build()).mo3555build()).setEcPointFormat(ecPointFormat).mo3555build();
    }

    public static final KeyTemplate eciesP256HkdfHmacSha256Aes128CtrHmacSha256Template() {
        return createKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.UNCOMPRESSED, AesCtrHmacAeadKeyManager.aes128CtrHmacSha256Template(), KeyTemplate.OutputPrefixType.TINK, EMPTY_SALT);
    }

    public static final KeyTemplate eciesP256HkdfHmacSha256Aes128GcmTemplate() {
        return createKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.UNCOMPRESSED, AesGcmKeyManager.aes128GcmTemplate(), KeyTemplate.OutputPrefixType.TINK, EMPTY_SALT);
    }

    public static final KeyTemplate rawEciesP256HkdfHmacSha256Aes128CtrHmacSha256CompressedTemplate() {
        return createKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.COMPRESSED, AesCtrHmacAeadKeyManager.aes128CtrHmacSha256Template(), KeyTemplate.OutputPrefixType.RAW, EMPTY_SALT);
    }

    public static final KeyTemplate rawEciesP256HkdfHmacSha256Aes128GcmCompressedTemplate() {
        return createKeyTemplate(EllipticCurveType.NIST_P256, HashType.SHA256, EcPointFormat.COMPRESSED, AesGcmKeyManager.aes128GcmTemplate(), KeyTemplate.OutputPrefixType.RAW, EMPTY_SALT);
    }

    public static void registerPair(boolean z) {
        Registry.registerAsymmetricKeyManagers(new EciesAeadHkdfPrivateKeyManager(), new EciesAeadHkdfPublicKeyManager(), z);
    }

    /* renamed from: toProto */
    private static OutputPrefixType m3457toProto(KeyTemplate.OutputPrefixType outputPrefixType) {
        int i = C03973.$SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return OutputPrefixType.TINK;
        }
        if (i == 2) {
            return OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return OutputPrefixType.RAW;
        }
        if (i == 4) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<EciesAeadHkdfKeyFormat, EciesAeadHkdfPrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<EciesAeadHkdfKeyFormat, EciesAeadHkdfPrivateKey>(EciesAeadHkdfKeyFormat.class) { // from class: com.google.crypto.tink.hybrid.EciesAeadHkdfPrivateKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<EciesAeadHkdfKeyFormat>> keyFormats() throws GeneralSecurityException {
                HashMap map = new HashMap();
                EllipticCurveType ellipticCurveType = EllipticCurveType.NIST_P256;
                HashType hashType = HashType.SHA256;
                EcPointFormat ecPointFormat = EcPointFormat.UNCOMPRESSED;
                KeyTemplate keyTemplateM3346get = KeyTemplates.m3346get("AES128_GCM");
                byte[] bArr = EciesAeadHkdfPrivateKeyManager.EMPTY_SALT;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", EciesAeadHkdfPrivateKeyManager.createKeyFormat(ellipticCurveType, hashType, ecPointFormat, keyTemplateM3346get, bArr, outputPrefixType));
                KeyTemplate keyTemplateM3346get2 = KeyTemplates.m3346get("AES128_GCM");
                byte[] bArr2 = EciesAeadHkdfPrivateKeyManager.EMPTY_SALT;
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", EciesAeadHkdfPrivateKeyManager.createKeyFormat(ellipticCurveType, hashType, ecPointFormat, keyTemplateM3346get2, bArr2, outputPrefixType2));
                EcPointFormat ecPointFormat2 = EcPointFormat.COMPRESSED;
                map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", EciesAeadHkdfPrivateKeyManager.createKeyFormat(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.m3346get("AES128_GCM"), EciesAeadHkdfPrivateKeyManager.EMPTY_SALT, outputPrefixType));
                map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", EciesAeadHkdfPrivateKeyManager.createKeyFormat(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.m3346get("AES128_GCM"), EciesAeadHkdfPrivateKeyManager.EMPTY_SALT, outputPrefixType2));
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", EciesAeadHkdfPrivateKeyManager.createKeyFormat(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.m3346get("AES128_GCM"), EciesAeadHkdfPrivateKeyManager.EMPTY_SALT, outputPrefixType2));
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", EciesAeadHkdfPrivateKeyManager.createKeyFormat(ellipticCurveType, hashType, ecPointFormat, KeyTemplates.m3346get("AES128_CTR_HMAC_SHA256"), EciesAeadHkdfPrivateKeyManager.EMPTY_SALT, outputPrefixType));
                map.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", EciesAeadHkdfPrivateKeyManager.createKeyFormat(ellipticCurveType, hashType, ecPointFormat, KeyTemplates.m3346get("AES128_CTR_HMAC_SHA256"), EciesAeadHkdfPrivateKeyManager.EMPTY_SALT, outputPrefixType2));
                map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", EciesAeadHkdfPrivateKeyManager.createKeyFormat(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.m3346get("AES128_CTR_HMAC_SHA256"), EciesAeadHkdfPrivateKeyManager.EMPTY_SALT, outputPrefixType));
                map.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", EciesAeadHkdfPrivateKeyManager.createKeyFormat(ellipticCurveType, hashType, ecPointFormat2, KeyTemplates.m3346get("AES128_CTR_HMAC_SHA256"), EciesAeadHkdfPrivateKeyManager.EMPTY_SALT, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public EciesAeadHkdfPrivateKey createKey(EciesAeadHkdfKeyFormat eciesAeadHkdfKeyFormat) {
                KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(HybridUtil.toCurveType(eciesAeadHkdfKeyFormat.getParams().getKemParams().getCurveType()));
                ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
                ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
                ECPoint w = eCPublicKey.getW();
                return EciesAeadHkdfPrivateKey.newBuilder().setVersion(EciesAeadHkdfPrivateKeyManager.this.getVersion()).setPublicKey(EciesAeadHkdfPublicKey.newBuilder().setVersion(EciesAeadHkdfPrivateKeyManager.this.getVersion()).setParams(eciesAeadHkdfKeyFormat.getParams()).m3618setX(ByteString.copyFrom(w.getAffineX().toByteArray())).m3619setY(ByteString.copyFrom(w.getAffineY().toByteArray())).mo3555build()).setKeyValue(ByteString.copyFrom(eCPrivateKey.getS().toByteArray())).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public EciesAeadHkdfKeyFormat parseKeyFormat(ByteString byteString) {
                return EciesAeadHkdfKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(EciesAeadHkdfKeyFormat eciesAeadHkdfKeyFormat) {
                HybridUtil.validate(eciesAeadHkdfKeyFormat.getParams());
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager
    public EciesAeadHkdfPublicKey getPublicKey(EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey) {
        return eciesAeadHkdfPrivateKey.getPublicKey();
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public EciesAeadHkdfPrivateKey parseKey(ByteString byteString) {
        return EciesAeadHkdfPrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(EciesAeadHkdfPrivateKey eciesAeadHkdfPrivateKey) throws GeneralSecurityException {
        if (eciesAeadHkdfPrivateKey.getKeyValue().m3943isEmpty()) {
            throw new GeneralSecurityException("invalid ECIES private key");
        }
        Validators.validateVersion(eciesAeadHkdfPrivateKey.getVersion(), getVersion());
        HybridUtil.validate(eciesAeadHkdfPrivateKey.getPublicKey().getParams());
    }
}
