package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.PublicKeyVerify;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.Ed25519PublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.Ed25519Verify;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
class Ed25519PublicKeyManager extends KeyTypeManager<Ed25519PublicKey> {
    public Ed25519PublicKeyManager() {
        super(Ed25519PublicKey.class, new PrimitiveFactory<PublicKeyVerify, Ed25519PublicKey>(PublicKeyVerify.class) { // from class: com.google.crypto.tink.signature.Ed25519PublicKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public PublicKeyVerify getPrimitive(Ed25519PublicKey ed25519PublicKey) {
                return new Ed25519Verify(ed25519PublicKey.getKeyValue().toByteArray());
            }
        });
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public int getVersion() {
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public C0669KeyData.KeyMaterialType keyMaterialType() {
        return C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public Ed25519PublicKey parseKey(ByteString byteString) {
        return Ed25519PublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(Ed25519PublicKey ed25519PublicKey) {
        Validators.validateVersion(ed25519PublicKey.getVersion(), getVersion());
        if (ed25519PublicKey.getKeyValue().mo3944size() != 32) {
            throw new GeneralSecurityException("invalid Ed25519 public key: incorrect key length");
        }
    }
}
