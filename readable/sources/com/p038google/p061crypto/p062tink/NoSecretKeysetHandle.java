package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes.dex */
public final class NoSecretKeysetHandle {
    private NoSecretKeysetHandle() {
    }

    @Deprecated
    public static final KeysetHandle parseFrom(byte[] bArr) throws GeneralSecurityException {
        try {
            C0675Keyset from = C0675Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry());
            validate(from);
            return KeysetHandle.fromKeyset(from);
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    /* renamed from: read */
    public static final KeysetHandle m3377read(KeysetReader keysetReader) throws GeneralSecurityException {
        C0675Keyset c0675KeysetMo3324read = keysetReader.mo3324read();
        validate(c0675KeysetMo3324read);
        return KeysetHandle.fromKeyset(c0675KeysetMo3324read);
    }

    private static void validate(C0675Keyset c0675Keyset) throws GeneralSecurityException {
        for (C0675Keyset.Key key : c0675Keyset.getKeyList()) {
            if (key.getKeyData().getKeyMaterialType() == C0669KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || key.getKeyData().getKeyMaterialType() == C0669KeyData.KeyMaterialType.SYMMETRIC || key.getKeyData().getKeyMaterialType() == C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("keyset contains secret key material");
            }
        }
    }
}
