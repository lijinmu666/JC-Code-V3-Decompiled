package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.KmsClients;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.KmsEnvelopeAeadKey;
import com.p038google.p061crypto.p062tink.p073proto.KmsEnvelopeAeadKeyFormat;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public class KmsEnvelopeAeadKeyManager extends KeyTypeManager<KmsEnvelopeAeadKey> {
    public KmsEnvelopeAeadKeyManager() {
        super(KmsEnvelopeAeadKey.class, new PrimitiveFactory<InterfaceC0305Aead, KmsEnvelopeAeadKey>(InterfaceC0305Aead.class) { // from class: com.google.crypto.tink.aead.KmsEnvelopeAeadKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public InterfaceC0305Aead getPrimitive(KmsEnvelopeAeadKey kmsEnvelopeAeadKey) {
                String kekUri = kmsEnvelopeAeadKey.getParams().getKekUri();
                return new KmsEnvelopeAead(kmsEnvelopeAeadKey.getParams().getDekTemplate(), KmsClients.m3375get(kekUri).mo3373getAead(kekUri));
            }
        });
    }

    public static KmsEnvelopeAeadKeyFormat createKeyFormat(String str, KeyTemplate keyTemplate) {
        return KmsEnvelopeAeadKeyFormat.newBuilder().setDekTemplate(com.p038google.p061crypto.p062tink.p073proto.KeyTemplate.newBuilder().setTypeUrl(keyTemplate.getTypeUrl()).setValue(ByteString.copyFrom(keyTemplate.getValue())).mo3555build()).setKekUri(str).mo3555build();
    }

    public static KeyTemplate createKeyTemplate(String str, KeyTemplate keyTemplate) {
        return KeyTemplate.m3342create(new KmsEnvelopeAeadKeyManager().getKeyType(), createKeyFormat(str, keyTemplate).toByteArray(), KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z) {
        Registry.registerKeyManager(new KmsEnvelopeAeadKeyManager(), z);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<KmsEnvelopeAeadKeyFormat, KmsEnvelopeAeadKey>(KmsEnvelopeAeadKeyFormat.class) { // from class: com.google.crypto.tink.aead.KmsEnvelopeAeadKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public KmsEnvelopeAeadKey createKey(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) {
                return KmsEnvelopeAeadKey.newBuilder().setParams(kmsEnvelopeAeadKeyFormat).setVersion(KmsEnvelopeAeadKeyManager.this.getVersion()).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public KmsEnvelopeAeadKeyFormat parseKeyFormat(ByteString byteString) {
                return KmsEnvelopeAeadKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(KmsEnvelopeAeadKeyFormat kmsEnvelopeAeadKeyFormat) throws GeneralSecurityException {
                if (kmsEnvelopeAeadKeyFormat.getKekUri().isEmpty() || !kmsEnvelopeAeadKeyFormat.hasDekTemplate()) {
                    throw new GeneralSecurityException("invalid key format: missing KEK URI or DEK template");
                }
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.REMOTE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KmsEnvelopeAeadKey parseKey(ByteString byteString) {
        return KmsEnvelopeAeadKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(KmsEnvelopeAeadKey kmsEnvelopeAeadKey) throws GeneralSecurityException {
        Validators.validateVersion(kmsEnvelopeAeadKey.getVersion(), getVersion());
    }
}
