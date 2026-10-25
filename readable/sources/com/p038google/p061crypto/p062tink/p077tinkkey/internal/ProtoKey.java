package com.p038google.p061crypto.p062tink.p077tinkkey.internal;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p077tinkkey.InterfaceC0877TinkKey;

/* loaded from: classes.dex */
public final class ProtoKey implements InterfaceC0877TinkKey {
    private final boolean hasSecret;

    /* renamed from: keyData */
    private final C0669KeyData f4019keyData;
    private final KeyTemplate.OutputPrefixType outputPrefixType;

    public ProtoKey(C0669KeyData c0669KeyData, KeyTemplate.OutputPrefixType outputPrefixType) {
        this.hasSecret = isSecret(c0669KeyData);
        this.f4019keyData = c0669KeyData;
        this.outputPrefixType = outputPrefixType;
    }

    private static boolean isSecret(C0669KeyData c0669KeyData) {
        return c0669KeyData.getKeyMaterialType() == C0669KeyData.KeyMaterialType.UNKNOWN_KEYMATERIAL || c0669KeyData.getKeyMaterialType() == C0669KeyData.KeyMaterialType.SYMMETRIC || c0669KeyData.getKeyMaterialType() == C0669KeyData.KeyMaterialType.ASYMMETRIC_PRIVATE;
    }

    @Override // com.p038google.p061crypto.p062tink.p077tinkkey.InterfaceC0877TinkKey
    public KeyTemplate getKeyTemplate() {
        throw new UnsupportedOperationException();
    }

    public KeyTemplate.OutputPrefixType getOutputPrefixType() {
        return this.outputPrefixType;
    }

    public C0669KeyData getProtoKey() {
        return this.f4019keyData;
    }

    @Override // com.p038google.p061crypto.p062tink.p077tinkkey.InterfaceC0877TinkKey
    public boolean hasSecret() {
        return this.hasSecret;
    }
}
