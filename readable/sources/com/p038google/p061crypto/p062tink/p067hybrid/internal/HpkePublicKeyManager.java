package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.HybridEncrypt;
import com.p038google.p061crypto.p062tink.internal.KeyTypeManager;
import com.p038google.p061crypto.p062tink.internal.PrimitiveFactory;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.HpkePublicKey;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p075subtle.Validators;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class HpkePublicKeyManager extends KeyTypeManager<HpkePublicKey> {
    public HpkePublicKeyManager() {
        super(HpkePublicKey.class, new PrimitiveFactory<HybridEncrypt, HpkePublicKey>(HybridEncrypt.class) { // from class: com.google.crypto.tink.hybrid.internal.HpkePublicKeyManager.1
            @Override // com.p038google.p061crypto.p062tink.internal.PrimitiveFactory
            public HybridEncrypt getPrimitive(HpkePublicKey hpkePublicKey) {
                return HpkeEncrypt.createHpkeEncrypt(hpkePublicKey);
            }
        });
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HpkePublicKey";
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
    public HpkePublicKey parseKey(ByteString byteString) {
        return HpkePublicKey.parseFrom(byteString, ExtensionRegistryLite.getEmptyRegistry());
    }

    @Override // com.p038google.p061crypto.p062tink.internal.KeyTypeManager
    public void validateKey(HpkePublicKey hpkePublicKey) throws GeneralSecurityException {
        Validators.validateVersion(hpkePublicKey.getVersion(), getVersion());
        if (!hpkePublicKey.hasParams()) {
            throw new GeneralSecurityException("Missing HPKE key params.");
        }
        HpkeUtil.validateParams(hpkePublicKey.getParams());
    }
}
