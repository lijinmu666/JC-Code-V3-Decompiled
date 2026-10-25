package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.PublicKeySign;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.Ed25519KeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.Ed25519PrivateKey;
import com.p038google.p061crypto.p062tink.p073proto.Ed25519PublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.Ed25519Sign;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class Ed25519PrivateKeyManager extends PrivateKeyTypeManager<Ed25519PrivateKey, Ed25519PublicKey> {
    public Ed25519PrivateKeyManager() {
        super(Ed25519PrivateKey.class, Ed25519PublicKey.class, new PrimitiveFactory<PublicKeySign, Ed25519PrivateKey>(PublicKeySign.class) { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public PublicKeySign getPrimitive(Ed25519PrivateKey ed25519PrivateKey) {
                return new Ed25519Sign(ed25519PrivateKey.getKeyValue().toByteArray());
            }
        });
    }

    public static final KeyTemplate ed25519Template() {
        return KeyTemplate.m3342create(new Ed25519PrivateKeyManager().getKeyType(), new byte[0], KeyTemplate.OutputPrefixType.TINK);
    }

    public static final KeyTemplate rawEd25519Template() {
        return KeyTemplate.m3342create(new Ed25519PrivateKeyManager().getKeyType(), new byte[0], KeyTemplate.OutputPrefixType.RAW);
    }

    public static void registerPair(boolean z) {
        Registry.registerAsymmetricKeyManagers(new Ed25519PrivateKeyManager(), new Ed25519PublicKeyManager(), z);
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public KeyTypeManager.KeyFactory<Ed25519KeyFormat, Ed25519PrivateKey> keyFactory() {
        return new KeyTypeManager.KeyFactory<Ed25519KeyFormat, Ed25519PrivateKey>(Ed25519KeyFormat.class) { // from class: com.google.crypto.tink.signature.Ed25519PrivateKeyManager.2
            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Map<String, KeyTypeManager.KeyFactory.KeyFormat<Ed25519KeyFormat>> keyFormats() {
                HashMap map = new HashMap();
                map.put("ED25519", new KeyTypeManager.KeyFactory.KeyFormat(Ed25519KeyFormat.getDefaultInstance(), KeyTemplate.OutputPrefixType.TINK));
                Ed25519KeyFormat defaultInstance = Ed25519KeyFormat.getDefaultInstance();
                KeyTemplate.OutputPrefixType outputPrefixType = KeyTemplate.OutputPrefixType.RAW;
                map.put("ED25519_RAW", new KeyTypeManager.KeyFactory.KeyFormat(defaultInstance, outputPrefixType));
                map.put("ED25519WithRawOutput", new KeyTypeManager.KeyFactory.KeyFormat(Ed25519KeyFormat.getDefaultInstance(), outputPrefixType));
                return Collections.unmodifiableMap(map);
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public void validateKeyFormat(Ed25519KeyFormat ed25519KeyFormat) {
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Ed25519PrivateKey createKey(Ed25519KeyFormat ed25519KeyFormat) {
                Ed25519Sign.C0858KeyPair c0858KeyPairNewKeyPair = Ed25519Sign.C0858KeyPair.newKeyPair();
                return Ed25519PrivateKey.newBuilder().setVersion(Ed25519PrivateKeyManager.this.getVersion()).setKeyValue(ByteString.copyFrom(c0858KeyPairNewKeyPair.getPrivateKey())).setPublicKey(Ed25519PublicKey.newBuilder().setVersion(Ed25519PrivateKeyManager.this.getVersion()).setKeyValue(ByteString.copyFrom(c0858KeyPairNewKeyPair.getPublicKey())).mo3555build()).mo3555build();
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Ed25519PrivateKey deriveKey(Ed25519KeyFormat ed25519KeyFormat, InputStream inputStream) throws GeneralSecurityException {
                Validators.validateVersion(ed25519KeyFormat.getVersion(), Ed25519PrivateKeyManager.this.getVersion());
                byte[] bArr = new byte[32];
                try {
                    KeyTypeManager.KeyFactory.readFully(inputStream, bArr);
                    Ed25519Sign.C0858KeyPair c0858KeyPairNewKeyPairFromSeed = Ed25519Sign.C0858KeyPair.newKeyPairFromSeed(bArr);
                    return Ed25519PrivateKey.newBuilder().setVersion(Ed25519PrivateKeyManager.this.getVersion()).setKeyValue(ByteString.copyFrom(c0858KeyPairNewKeyPairFromSeed.getPrivateKey())).setPublicKey(Ed25519PublicKey.newBuilder().setVersion(Ed25519PrivateKeyManager.this.getVersion()).setKeyValue(ByteString.copyFrom(c0858KeyPairNewKeyPairFromSeed.getPublicKey())).mo3555build()).mo3555build();
                } catch (IOException e) {
                    throw new GeneralSecurityException("Reading pseudorandomness failed", e);
                }
            }

            @Override // com.google.crypto.tink.internal.KeyTypeManager.KeyFactory
            public Ed25519KeyFormat parseKeyFormat(ByteString byteString) {
                return Ed25519KeyFormat.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.PrivateKeyTypeManager
    public Ed25519PublicKey getPublicKey(Ed25519PrivateKey ed25519PrivateKey) {
        return ed25519PrivateKey.getPublicKey();
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public Ed25519PrivateKey parseKey(ByteString byteString) {
        return Ed25519PrivateKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(Ed25519PrivateKey ed25519PrivateKey) throws GeneralSecurityException {
        Validators.validateVersion(ed25519PrivateKey.getVersion(), getVersion());
        new Ed25519PublicKeyManager().validateKey(ed25519PrivateKey.getPublicKey());
        if (ed25519PrivateKey.getKeyValue().mo3944size() != 32) {
            throw new GeneralSecurityException("invalid Ed25519 private key: incorrect key length");
        }
    }
}
