package com.p038google.p061crypto.p062tink.p066daead;

import com.p038google.p061crypto.p062tink.DeterministicAead;
import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p073proto.AesSivKey;
import com.p038google.p061crypto.p062tink.p073proto.AesSivKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.C0851AesSiv;
import com.p038google.p061crypto.p062tink.p075subtle.C0870Random;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class AesSivKeyManager extends KeyTypeManager<AesSivKey> {
    private static final int KEY_SIZE_IN_BYTES = 64;

    public AesSivKeyManager() {
        super(AesSivKey.class, new PrimitiveFactory<DeterministicAead, AesSivKey>(DeterministicAead.class) { // from class: com.google.crypto.tink.daead.AesSivKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public DeterministicAead getPrimitive(AesSivKey aesSivKey) {
                return new C0851AesSiv(aesSivKey.getKeyValue().toByteArray());
            }
        });
    }

    public static final KeyTemplate aes256SivTemplate() {
        return createKeyTemplate(64, KeyTemplate.OutputPrefixType.TINK);
    }

    private static KeyTemplate createKeyTemplate(int i, KeyTemplate.OutputPrefixType outputPrefixType) {
        return KeyTemplate.m3342create(new AesSivKeyManager().getKeyType(), AesSivKeyFormat.newBuilder().setKeySize(i).mo3555build().toByteArray(), outputPrefixType);
    }

    public static final KeyTemplate rawAes256SivTemplate() {
        return createKeyTemplate(64, KeyTemplate.OutputPrefixType.RAW);
    }

    public static void register(boolean z) {
        Registry.registerKeyManager(new AesSivKeyManager(), z);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesSivKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<AesSivKeyFormat, AesSivKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<AesSivKeyFormat, AesSivKey>(AesSivKeyFormat.class) { // from class: com.google.crypto.tink.daead.AesSivKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<AesSivKeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                map.put("AES256_SIV", new KeyTypeManager.KeyFactory.KeyFormat(AesSivKeyFormat.newBuilder().setKeySize(64).mo3555build(), KeyTemplate.OutputPrefixType.TINK));
                map.put("AES256_SIV_RAW", new KeyTypeManager.KeyFactory.KeyFormat(AesSivKeyFormat.newBuilder().setKeySize(64).mo3555build(), KeyTemplate.OutputPrefixType.RAW));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesSivKey createKey(AesSivKeyFormat aesSivKeyFormat) {
                return AesSivKey.newBuilder().setKeyValue(ByteString.copyFrom(C0870Random.randBytes(aesSivKeyFormat.getKeySize()))).setVersion(AesSivKeyManager.this.getVersion()).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesSivKey deriveKey(AesSivKeyFormat aesSivKeyFormat, InputStream inputStream) throws GeneralSecurityException {
                Validators.validateVersion(aesSivKeyFormat.getVersion(), AesSivKeyManager.this.getVersion());
                byte[] bArr = new byte[64];
                try {
                    KeyTypeManager.KeyFactory.readFully(inputStream, bArr);
                    return AesSivKey.newBuilder().setKeyValue(ByteString.copyFrom(bArr)).setVersion(AesSivKeyManager.this.getVersion()).mo3555build();
                } catch (IOException e) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e);
                }
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public AesSivKeyFormat parseKeyFormat(ByteString byteString) {
                return AesSivKeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(AesSivKeyFormat aesSivKeyFormat) throws InvalidAlgorithmParameterException {
                if (aesSivKeyFormat.getKeySize() == 64) {
                    return;
                }
                throw new InvalidAlgorithmParameterException("invalid key size: " + aesSivKeyFormat.getKeySize() + ". Valid keys must have 64 bytes.");
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.SYMMETRIC;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public AesSivKey parseKey(ByteString byteString) {
        return AesSivKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(AesSivKey aesSivKey) throws GeneralSecurityException {
        Validators.validateVersion(aesSivKey.getVersion(), getVersion());
        if (aesSivKey.getKeyValue().mo3944size() == 64) {
            return;
        }
        throw new InvalidKeyException("invalid key size: " + aesSivKey.getKeyValue().mo3944size() + ". Valid keys must have 64 bytes.");
    }
}
