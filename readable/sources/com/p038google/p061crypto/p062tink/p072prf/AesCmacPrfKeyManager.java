package com.p038google.p061crypto.p062tink.p072prf;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p073proto.AesCmacPrfKey;
import com.p038google.p061crypto.p062tink.p073proto.AesCmacPrfKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.C0870Random;
import com.p038google.p061crypto.p062tink.p075subtle.PrfAesCmac;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class AesCmacPrfKeyManager extends KeyTypeManager<AesCmacPrfKey> {
    private static final int KEY_SIZE_IN_BYTES = 32;

    /* renamed from: VERSION */
    private static final int f3189VERSION = 0;

    public AesCmacPrfKeyManager() {
        super(AesCmacPrfKey.class, new PrimitiveFactory<InterfaceC0504Prf, AesCmacPrfKey>(InterfaceC0504Prf.class) { // from class: com.google.crypto.tink.prf.AesCmacPrfKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public InterfaceC0504Prf getPrimitive(AesCmacPrfKey aesCmacPrfKey) {
                return new PrfAesCmac(aesCmacPrfKey.getKeyValue().toByteArray());
            }
        });
    }

    public static final KeyTemplate aes256CmacTemplate() {
        return KeyTemplate.m3342create(new AesCmacPrfKeyManager().getKeyType(), AesCmacPrfKeyFormat.newBuilder().setKeySize(32).mo3555build().toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z) {
        Registry.registerKeyManager(new AesCmacPrfKeyManager(), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void validateSize(int i) throws GeneralSecurityException {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacPrfKey size wrong, must be 32 bytes");
        }
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacPrfKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<AesCmacPrfKeyFormat, AesCmacPrfKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesCmacPrfKeyFormat, AesCmacPrfKey>(AesCmacPrfKeyFormat.class) { // from class: com.google.crypto.tink.prf.AesCmacPrfKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<AesCmacPrfKeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                AesCmacPrfKeyFormat aesCmacPrfKeyFormatMo3555build = AesCmacPrfKeyFormat.newBuilder().setKeySize(32).mo3555build();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("AES256_CMAC_PRF", new KeyTypeManager.KeyFactory.KeyFormat(aesCmacPrfKeyFormatMo3555build, outputPrefixType));
                map.put("AES_CMAC_PRF", new KeyTypeManager.KeyFactory.KeyFormat(AesCmacPrfKeyFormat.newBuilder().setKeySize(32).mo3555build(), outputPrefixType));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesCmacPrfKey createKey(AesCmacPrfKeyFormat aesCmacPrfKeyFormat) {
                return AesCmacPrfKey.newBuilder().setVersion(0).setKeyValue(ByteString.copyFrom(C0870Random.randBytes(aesCmacPrfKeyFormat.getKeySize()))).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesCmacPrfKeyFormat parseKeyFormat(ByteString byteString) {
                return AesCmacPrfKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesCmacPrfKeyFormat aesCmacPrfKeyFormat) throws GeneralSecurityException {
                AesCmacPrfKeyManager.validateSize(aesCmacPrfKeyFormat.getKeySize());
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public AesCmacPrfKey parseKey(ByteString byteString) {
        return AesCmacPrfKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(AesCmacPrfKey aesCmacPrfKey) throws GeneralSecurityException {
        Validators.validateVersion(aesCmacPrfKey.getVersion(), getVersion());
        validateSize(aesCmacPrfKey.getKeyValue().mo3944size());
    }
}
