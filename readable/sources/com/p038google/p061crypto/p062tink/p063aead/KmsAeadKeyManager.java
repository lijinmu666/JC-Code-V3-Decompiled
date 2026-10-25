package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.KmsClients;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.KmsAeadKey;
import com.p038google.p061crypto.p062tink.p073proto.KmsAeadKeyFormat;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class KmsAeadKeyManager extends KeyTypeManager<KmsAeadKey> {
    public KmsAeadKeyManager() {
        super(KmsAeadKey.class, new PrimitiveFactory<InterfaceC0305Aead, KmsAeadKey>(InterfaceC0305Aead.class) { // from class: com.google.crypto.tink.aead.KmsAeadKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public InterfaceC0305Aead getPrimitive(KmsAeadKey kmsAeadKey) {
                String keyUri = kmsAeadKey.getParams().getKeyUri();
                return KmsClients.m3375get(keyUri).mo3373getAead(keyUri);
            }
        });
    }

    public static KmsAeadKeyFormat createKeyFormat(String str) {
        return KmsAeadKeyFormat.newBuilder().setKeyUri(str).mo3555build();
    }

    public static KeyTemplate createKeyTemplate(String str) {
        return KeyTemplate.m3342create(new KmsAeadKeyManager().getKeyType(), createKeyFormat(str).toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z) {
        Registry.registerKeyManager(new KmsAeadKeyManager(), z);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<KmsAeadKeyFormat, KmsAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<KmsAeadKeyFormat, KmsAeadKey>(KmsAeadKeyFormat.class) { // from class: com.google.crypto.tink.aead.KmsAeadKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(KmsAeadKeyFormat kmsAeadKeyFormat) {
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public KmsAeadKey createKey(KmsAeadKeyFormat kmsAeadKeyFormat) {
                return KmsAeadKey.newBuilder().setParams(kmsAeadKeyFormat).setVersion(KmsAeadKeyManager.this.getVersion()).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public KmsAeadKeyFormat parseKeyFormat(ByteString byteString) {
                return KmsAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.REMOTE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KmsAeadKey parseKey(ByteString byteString) {
        return KmsAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(KmsAeadKey kmsAeadKey) throws GeneralSecurityException {
        Validators.validateVersion(kmsAeadKey.getVersion(), getVersion());
    }
}
