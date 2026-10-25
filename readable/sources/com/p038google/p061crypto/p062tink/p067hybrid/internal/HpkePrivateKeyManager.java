package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.HybridDecrypt;
import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.EnumC0628HpkeKdf;
import com.p038google.p061crypto.p062tink.p073proto.EnumC0629HpkeKem;
import com.p038google.p061crypto.p062tink.p073proto.HpkeAead;
import com.p038google.p061crypto.p062tink.p073proto.HpkeKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.HpkeParams;
import com.p038google.p061crypto.p062tink.p073proto.HpkePrivateKey;
import com.p038google.p061crypto.p062tink.p073proto.HpkePublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.C0874X25519;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class HpkePrivateKeyManager extends PrivateKeyTypeManager<HpkePrivateKey, HpkePublicKey> {

    /* renamed from: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager$3 */
    public static /* synthetic */ class C04063 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HpkeKem;

        static {
            int[] iArr = new int[EnumC0629HpkeKem.m3660values().length];
            $SwitchMap$com$google$crypto$tink$proto$HpkeKem = iArr;
            try {
                iArr[EnumC0629HpkeKem.DHKEM_X25519_HKDF_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P256_HKDF_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P384_HKDF_SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P521_HKDF_SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public HpkePrivateKeyManager() {
        super(HpkePrivateKey.class, HpkePublicKey.class, new PrimitiveFactory<HybridDecrypt, HpkePrivateKey>(HybridDecrypt.class) { // from class: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public HybridDecrypt getPrimitive(HpkePrivateKey hpkePrivateKey) {
                return HpkeDecrypt.createHpkeDecrypt(hpkePrivateKey);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<HpkeKeyFormat> createKeyFormat(EnumC0629HpkeKem enumC0629HpkeKem, EnumC0628HpkeKdf enumC0628HpkeKdf, HpkeAead hpkeAead, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(HpkeKeyFormat.newBuilder().setParams(HpkeParams.newBuilder().m3671setKem(enumC0629HpkeKem).m3670setKdf(enumC0628HpkeKdf).m3669setAead(hpkeAead).mo3555build()).mo3555build(), outputPrefixType);
    }

    public static void registerPair(boolean z) {
        Registry.registerAsymmetricKeyManagers(new HpkePrivateKeyManager(), new HpkePublicKeyManager(), z);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HpkePrivateKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<HpkeKeyFormat, HpkePrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HpkeKeyFormat, HpkePrivateKey>(HpkeKeyFormat.class) { // from class: com.google.crypto.tink.hybrid.internal.HpkePrivateKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<HpkeKeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                EnumC0629HpkeKem enumC0629HpkeKem = EnumC0629HpkeKem.DHKEM_X25519_HKDF_SHA256;
                EnumC0628HpkeKdf enumC0628HpkeKdf = EnumC0628HpkeKdf.HKDF_SHA256;
                HpkeAead hpkeAead = HpkeAead.AES_128_GCM;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem, enumC0628HpkeKdf, hpkeAead, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem, enumC0628HpkeKdf, hpkeAead, outputPrefixType2));
                HpkeAead hpkeAead2 = HpkeAead.AES_256_GCM;
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem, enumC0628HpkeKdf, hpkeAead2, outputPrefixType));
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem, enumC0628HpkeKdf, hpkeAead2, outputPrefixType2));
                HpkeAead hpkeAead3 = HpkeAead.CHACHA20_POLY1305;
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem, enumC0628HpkeKdf, hpkeAead3, outputPrefixType));
                map.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem, enumC0628HpkeKdf, hpkeAead3, outputPrefixType2));
                EnumC0629HpkeKem enumC0629HpkeKem2 = EnumC0629HpkeKem.DHKEM_P256_HKDF_SHA256;
                map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem2, enumC0628HpkeKdf, hpkeAead, outputPrefixType));
                map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem2, enumC0628HpkeKdf, hpkeAead, outputPrefixType2));
                map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem2, enumC0628HpkeKdf, hpkeAead2, outputPrefixType));
                map.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem2, enumC0628HpkeKdf, hpkeAead2, outputPrefixType2));
                EnumC0629HpkeKem enumC0629HpkeKem3 = EnumC0629HpkeKem.DHKEM_P384_HKDF_SHA384;
                EnumC0628HpkeKdf enumC0628HpkeKdf2 = EnumC0628HpkeKdf.HKDF_SHA384;
                map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem3, enumC0628HpkeKdf2, hpkeAead, outputPrefixType));
                map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem3, enumC0628HpkeKdf2, hpkeAead, outputPrefixType2));
                map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem3, enumC0628HpkeKdf2, hpkeAead2, outputPrefixType));
                map.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem3, enumC0628HpkeKdf2, hpkeAead2, outputPrefixType2));
                EnumC0629HpkeKem enumC0629HpkeKem4 = EnumC0629HpkeKem.DHKEM_P521_HKDF_SHA512;
                EnumC0628HpkeKdf enumC0628HpkeKdf3 = EnumC0628HpkeKdf.HKDF_SHA512;
                map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem4, enumC0628HpkeKdf3, hpkeAead, outputPrefixType));
                map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem4, enumC0628HpkeKdf3, hpkeAead, outputPrefixType2));
                map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem4, enumC0628HpkeKdf3, hpkeAead2, outputPrefixType));
                map.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", HpkePrivateKeyManager.createKeyFormat(enumC0629HpkeKem4, enumC0628HpkeKdf3, hpkeAead2, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public HpkePrivateKey createKey(HpkeKeyFormat hpkeKeyFormat) throws GeneralSecurityException {
                byte[] bArrGeneratePrivateKey;
                byte[] bArrPublicFromPrivate;
                int i = C04063.$SwitchMap$com$google$crypto$tink$proto$HpkeKem[hpkeKeyFormat.getParams().mo3668getKem().ordinal()];
                if (i == 1) {
                    bArrGeneratePrivateKey = C0874X25519.generatePrivateKey();
                    bArrPublicFromPrivate = C0874X25519.publicFromPrivate(bArrGeneratePrivateKey);
                } else {
                    if (i != 2 && i != 3 && i != 4) {
                        throw new GeneralSecurityException("Invalid KEM");
                    }
                    EllipticCurves.CurveType curveTypeNistHpkeKemToCurve = HpkeUtil.nistHpkeKemToCurve(hpkeKeyFormat.getParams().mo3668getKem());
                    KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(curveTypeNistHpkeKemToCurve);
                    bArrPublicFromPrivate = EllipticCurves.pointEncode(curveTypeNistHpkeKemToCurve, EllipticCurves.PointFormatType.UNCOMPRESSED, ((ECPublicKey) keyPairGenerateKeyPair.getPublic()).getW());
                    bArrGeneratePrivateKey = ((ECPrivateKey) keyPairGenerateKeyPair.getPrivate()).getS().toByteArray();
                }
                return HpkePrivateKey.newBuilder().setVersion(HpkePrivateKeyManager.this.getVersion()).setPublicKey(HpkePublicKey.newBuilder().setVersion(HpkePrivateKeyManager.this.getVersion()).setParams(hpkeKeyFormat.getParams()).setPublicKey(ByteString.copyFrom(bArrPublicFromPrivate)).mo3555build()).setPrivateKey(ByteString.copyFrom(bArrGeneratePrivateKey)).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public HpkeKeyFormat parseKeyFormat(ByteString byteString) {
                return HpkeKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(HpkeKeyFormat hpkeKeyFormat) throws GeneralSecurityException {
                HpkeUtil.validateParams(hpkeKeyFormat.getParams());
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager
    public HpkePublicKey getPublicKey(HpkePrivateKey hpkePrivateKey) {
        return hpkePrivateKey.getPublicKey();
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public HpkePrivateKey parseKey(ByteString byteString) {
        return HpkePrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(HpkePrivateKey hpkePrivateKey) throws GeneralSecurityException {
        if (hpkePrivateKey.getPrivateKey().m3943isEmpty()) {
            throw new GeneralSecurityException("Private key is empty.");
        }
        if (!hpkePrivateKey.hasPublicKey()) {
            throw new GeneralSecurityException("Missing public key.");
        }
        Validators.validateVersion(hpkePrivateKey.getVersion(), getVersion());
        HpkeUtil.validateParams(hpkePrivateKey.getPublicKey().getParams());
    }
}
