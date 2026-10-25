package com.p038google.p061crypto.p062tink.p077tinkkey;

import com.p038google.p061crypto.p062tink.KeyTemplate;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.internal.C0431Util;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p077tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes.dex */
public class KeyHandle {

    /* renamed from: id */
    private final int f4014id;

    /* renamed from: key */
    private final InterfaceC0877TinkKey f4015key;

    /* renamed from: status */
    private final KeyStatusType f4016status;

    public enum KeyStatusType {
        ENABLED,
        DISABLED,
        DESTROYED
    }

    private KeyHandle(InterfaceC0877TinkKey interfaceC0877TinkKey) {
        this.f4015key = interfaceC0877TinkKey;
        this.f4016status = KeyStatusType.ENABLED;
        this.f4014id = C0431Util.randKeyId();
    }

    private void checkAccess(KeyAccess keyAccess) throws GeneralSecurityException {
        if (hasSecret() && !keyAccess.canAccessSecret()) {
            throw new GeneralSecurityException("No access");
        }
    }

    public static KeyHandle createFromKey(InterfaceC0877TinkKey interfaceC0877TinkKey, KeyAccess keyAccess) throws GeneralSecurityException {
        KeyHandle keyHandle = new KeyHandle(interfaceC0877TinkKey);
        keyHandle.checkAccess(keyAccess);
        return keyHandle;
    }

    public static KeyHandle generateNew(KeyTemplate keyTemplate) {
        return new KeyHandle(new ProtoKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType()));
    }

    /* renamed from: getId */
    public int m4287getId() {
        return this.f4014id;
    }

    /* renamed from: getKey */
    public InterfaceC0877TinkKey m4288getKey(KeyAccess keyAccess) throws GeneralSecurityException {
        checkAccess(keyAccess);
        return this.f4015key;
    }

    public KeyTemplate getKeyTemplate() {
        return this.f4015key.getKeyTemplate();
    }

    public KeyStatusType getStatus() {
        return this.f4016status;
    }

    public boolean hasSecret() {
        return this.f4015key.hasSecret();
    }

    @Deprecated
    public static KeyHandle createFromKey(C0669KeyData c0669KeyData, KeyTemplate.OutputPrefixType outputPrefixType) {
        return new KeyHandle(new ProtoKey(c0669KeyData, outputPrefixType));
    }

    public KeyHandle(InterfaceC0877TinkKey interfaceC0877TinkKey, KeyStatusType keyStatusType, int i) {
        this.f4015key = interfaceC0877TinkKey;
        this.f4016status = keyStatusType;
        this.f4014id = i;
    }
}
