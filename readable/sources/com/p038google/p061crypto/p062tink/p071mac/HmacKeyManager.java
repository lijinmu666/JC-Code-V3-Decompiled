package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.InterfaceC0317Mac;
import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.MutablePrimitiveRegistry;
import com.p038google.p061crypto.p062tink.internal.PrimitiveConstructor;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import com.p038google.p061crypto.p062tink.p071mac.C0465HmacKey;
import com.p038google.p061crypto.p062tink.p071mac.internal.ChunkedHmacImpl;
import com.p038google.p061crypto.p062tink.p073proto.C0614HmacKey;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.HmacKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.HmacParams;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.C0869PrfMac;
import com.p038google.p061crypto.p062tink.p075subtle.C0870Random;
import com.p038google.p061crypto.p062tink.p075subtle.PrfHmacJce;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class HmacKeyManager extends KeyTypeManager<C0614HmacKey> {
    private static final PrimitiveConstructor<C0465HmacKey, ChunkedMac> CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR = PrimitiveConstructor.m3495create(new PrimitiveConstructor.PrimitiveConstructionFunction() { // from class: o.z
        @Override // com.google.crypto.tink.internal.PrimitiveConstructor.PrimitiveConstructionFunction
        public final Object constructPrimitive(AbstractC0308Key abstractC0308Key) {
            return new ChunkedHmacImpl((C0465HmacKey) abstractC0308Key);
        }
    }, C0465HmacKey.class, ChunkedMac.class);
    private static final int MIN_KEY_SIZE_IN_BYTES = 16;
    private static final int MIN_TAG_SIZE_IN_BYTES = 10;

    /* renamed from: com.google.crypto.tink.mac.HmacKeyManager$3 */
    public static /* synthetic */ class C04683 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] iArr = new int[HashType.m3630values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public HmacKeyManager() {
        super(C0614HmacKey.class, new PrimitiveFactory<InterfaceC0317Mac, C0614HmacKey>(InterfaceC0317Mac.class) { // from class: com.google.crypto.tink.mac.HmacKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public InterfaceC0317Mac getPrimitive(C0614HmacKey c0614HmacKey) throws GeneralSecurityException {
                HashType hashTypeMo3644getHash = c0614HmacKey.getParams().mo3644getHash();
                SecretKeySpec secretKeySpec = new SecretKeySpec(c0614HmacKey.getKeyValue().toByteArray(), "HMAC");
                int tagSize = c0614HmacKey.getParams().getTagSize();
                int i = C04683.$SwitchMap$com$google$crypto$tink$proto$HashType[hashTypeMo3644getHash.ordinal()];
                if (i == 1) {
                    return new C0869PrfMac(new PrfHmacJce("HMACSHA1", secretKeySpec), tagSize);
                }
                if (i == 2) {
                    return new C0869PrfMac(new PrfHmacJce("HMACSHA224", secretKeySpec), tagSize);
                }
                if (i == 3) {
                    return new C0869PrfMac(new PrfHmacJce("HMACSHA256", secretKeySpec), tagSize);
                }
                if (i == 4) {
                    return new C0869PrfMac(new PrfHmacJce("HMACSHA384", secretKeySpec), tagSize);
                }
                if (i == 5) {
                    return new C0869PrfMac(new PrfHmacJce("HMACSHA512", secretKeySpec), tagSize);
                }
                throw new GeneralSecurityException("unknown hash");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static KeyTypeManager.KeyFactory.KeyFormat<HmacKeyFormat> createKeyFormat(int i, int i2, HashType hashType, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyTypeManager.KeyFactory.KeyFormat<>(HmacKeyFormat.newBuilder().setParams(HmacParams.newBuilder().m3645setHash(hashType).setTagSize(i2).mo3555build()).setKeySize(i).mo3555build(), outputPrefixType);
    }

    private static KeyTemplate createTemplate(int i, int i2, HashType hashType) {
        return KeyTemplate.m3342create(new HmacKeyManager().getKeyType(), HmacKeyFormat.newBuilder().setParams(HmacParams.newBuilder().m3645setHash(hashType).setTagSize(i2).mo3555build()).setKeySize(i).mo3555build().toByteArray(), KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate hmacSha256HalfDigestTemplate() {
        return createTemplate(32, 16, HashType.SHA256);
    }

    public static final KeyTemplate hmacSha256Template() {
        return createTemplate(32, 32, HashType.SHA256);
    }

    public static final KeyTemplate hmacSha512HalfDigestTemplate() {
        return createTemplate(64, 32, HashType.SHA512);
    }

    public static final KeyTemplate hmacSha512Template() {
        return createTemplate(64, 64, HashType.SHA512);
    }

    public static void register(boolean z) {
        Registry.registerKeyManager(new HmacKeyManager(), z);
        HmacProtoSerialization.register();
        MutablePrimitiveRegistry.globalInstance().registerPrimitiveConstructor(CHUNKED_MAC_PRIMITIVE_CONSTRUCTOR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateParams(HmacParams hmacParams) throws GeneralSecurityException {
        if (hmacParams.getTagSize() < 10) {
            throw new GeneralSecurityException("tag size too small");
        }
        int i = C04683.$SwitchMap$com$google$crypto$tink$proto$HashType[hmacParams.mo3644getHash().ordinal()];
        if (i == 1) {
            if (hmacParams.getTagSize() > 20) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i == 2) {
            if (hmacParams.getTagSize() > 28) {
                throw new GeneralSecurityException("tag size too big");
            }
            return;
        }
        if (i == 3) {
            if (hmacParams.getTagSize() > 32) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else if (i == 4) {
            if (hmacParams.getTagSize() > 48) {
                throw new GeneralSecurityException("tag size too big");
            }
        } else {
            if (i != 5) {
                throw new GeneralSecurityException("unknown hash type");
            }
            if (hmacParams.getTagSize() > 64) {
                throw new GeneralSecurityException("tag size too big");
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public TinkFipsUtil.AlgorithmFipsCompatibility fipsStatus() {
        return TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_REQUIRES_BORINGCRYPTO;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<HmacKeyFormat, C0614HmacKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<HmacKeyFormat, C0614HmacKey>(HmacKeyFormat.class) { // from class: com.google.crypto.tink.mac.HmacKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<HmacKeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                HashType hashType = HashType.SHA256;
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.TINK;
                map.put("HMAC_SHA256_128BITTAG", HmacKeyManager.createKeyFormat(32, 16, hashType, outputPrefixType));
                KeyTemplate.OutputPrefixType outputPrefixType2 = KeyTemplate.OutputPrefixType.RAW;
                map.put("HMAC_SHA256_128BITTAG_RAW", HmacKeyManager.createKeyFormat(32, 16, hashType, outputPrefixType2));
                map.put("HMAC_SHA256_256BITTAG", HmacKeyManager.createKeyFormat(32, 32, hashType, outputPrefixType));
                map.put("HMAC_SHA256_256BITTAG_RAW", HmacKeyManager.createKeyFormat(32, 32, hashType, outputPrefixType2));
                HashType hashType2 = HashType.SHA512;
                map.put("HMAC_SHA512_128BITTAG", HmacKeyManager.createKeyFormat(64, 16, hashType2, outputPrefixType));
                map.put("HMAC_SHA512_128BITTAG_RAW", HmacKeyManager.createKeyFormat(64, 16, hashType2, outputPrefixType2));
                map.put("HMAC_SHA512_256BITTAG", HmacKeyManager.createKeyFormat(64, 32, hashType2, outputPrefixType));
                map.put("HMAC_SHA512_256BITTAG_RAW", HmacKeyManager.createKeyFormat(64, 32, hashType2, outputPrefixType2));
                map.put("HMAC_SHA512_512BITTAG", HmacKeyManager.createKeyFormat(64, 64, hashType2, outputPrefixType));
                map.put("HMAC_SHA512_512BITTAG_RAW", HmacKeyManager.createKeyFormat(64, 64, hashType2, outputPrefixType2));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public C0614HmacKey createKey(HmacKeyFormat hmacKeyFormat) {
                return C0614HmacKey.newBuilder().setVersion(HmacKeyManager.this.getVersion()).setParams(hmacKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(C0870Random.randBytes(hmacKeyFormat.getKeySize()))).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public C0614HmacKey deriveKey(HmacKeyFormat hmacKeyFormat, InputStream inputStream) throws GeneralSecurityException {
                Validators.validateVersion(hmacKeyFormat.getVersion(), HmacKeyManager.this.getVersion());
                byte[] bArr = new byte[hmacKeyFormat.getKeySize()];
                try {
                    KeyTypeManager.KeyFactory.readFully(inputStream, bArr);
                    return C0614HmacKey.newBuilder().setVersion(HmacKeyManager.this.getVersion()).setParams(hmacKeyFormat.getParams()).setKeyValue(ByteString.copyFrom(bArr)).mo3555build();
                } catch (IOException e) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e);
                }
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public HmacKeyFormat parseKeyFormat(ByteString byteString) {
                return HmacKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(HmacKeyFormat hmacKeyFormat) throws GeneralSecurityException {
                if (hmacKeyFormat.getKeySize() < 16) {
                    throw new GeneralSecurityException("key too short");
                }
                HmacKeyManager.validateParams(hmacKeyFormat.getParams());
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0614HmacKey parseKey(ByteString byteString) {
        return C0614HmacKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(C0614HmacKey c0614HmacKey) throws GeneralSecurityException {
        Validators.validateVersion(c0614HmacKey.getVersion(), getVersion());
        if (c0614HmacKey.getKeyValue().mo3944size() < 16) {
            throw new GeneralSecurityException("key too short");
        }
        validateParams(c0614HmacKey.getParams());
    }
}
