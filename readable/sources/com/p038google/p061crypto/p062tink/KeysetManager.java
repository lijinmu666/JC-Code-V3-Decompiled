package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.internal.C0431Util;
import com.p038google.p061crypto.p062tink.internal.KeyStatusTypeProtoConverter;
import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.KeyStatusType;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p077tinkkey.KeyAccess;
import com.p038google.p061crypto.p062tink.p077tinkkey.KeyHandle;
import com.p038google.p061crypto.p062tink.p077tinkkey.SecretKeyAccess;
import com.p038google.p061crypto.p062tink.p077tinkkey.internal.ProtoKey;
import java.security.GeneralSecurityException;
import java.util.Iterator;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class KeysetManager {

    @GuardedBy("this")
    private final C0675Keyset.Builder keysetBuilder;

    private KeysetManager(C0675Keyset.Builder builder) {
        this.keysetBuilder = builder;
    }

    private synchronized C0675Keyset.Key createKeysetKey(C0669KeyData c0669KeyData, OutputPrefixType outputPrefixType) {
        int iNewKeyId;
        iNewKeyId = newKeyId();
        if (outputPrefixType == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException("unknown output prefix type");
        }
        return C0675Keyset.Key.newBuilder().setKeyData(c0669KeyData).setKeyId(iNewKeyId).setStatus(KeyStatusType.ENABLED).setOutputPrefixType(outputPrefixType).mo3555build();
    }

    private synchronized boolean keyIdExists(int i) {
        Iterator<C0675Keyset.Key> it = this.keysetBuilder.getKeyList().iterator();
        while (it.hasNext()) {
            if (it.next().getKeyId() == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: newKey */
    private synchronized C0675Keyset.Key m3362newKey(KeyTemplate keyTemplate) {
        return createKeysetKey(Registry.newKeyData(keyTemplate), keyTemplate.getOutputPrefixType());
    }

    private synchronized int newKeyId() {
        int iRandKeyId;
        iRandKeyId = C0431Util.randKeyId();
        while (keyIdExists(iRandKeyId)) {
            iRandKeyId = C0431Util.randKeyId();
        }
        return iRandKeyId;
    }

    public static KeysetManager withEmptyKeyset() {
        return new KeysetManager(C0675Keyset.newBuilder());
    }

    public static KeysetManager withKeysetHandle(KeysetHandle keysetHandle) {
        return new KeysetManager(keysetHandle.getKeyset().toBuilder());
    }

    @Deprecated
    /* renamed from: add */
    public synchronized KeysetManager m3364add(KeyTemplate keyTemplate) {
        addNewKey(keyTemplate, false);
        return this;
    }

    @Deprecated
    public synchronized int addNewKey(KeyTemplate keyTemplate, boolean z) {
        C0675Keyset.Key keyM3362newKey;
        try {
            keyM3362newKey = m3362newKey(keyTemplate);
            this.keysetBuilder.m3804addKey(keyM3362newKey);
            if (z) {
                this.keysetBuilder.setPrimaryKeyId(keyM3362newKey.getKeyId());
            }
        } catch (Throwable th) {
            throw th;
        }
        return keyM3362newKey.getKeyId();
    }

    /* renamed from: delete */
    public synchronized KeysetManager m3367delete(int i) {
        if (i == this.keysetBuilder.getPrimaryKeyId()) {
            throw new GeneralSecurityException("cannot delete the primary key");
        }
        for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
            if (this.keysetBuilder.mo3800getKey(i2).getKeyId() == i) {
                this.keysetBuilder.removeKey(i2);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    /* renamed from: destroy */
    public synchronized KeysetManager m3368destroy(int i) {
        try {
            if (i == this.keysetBuilder.getPrimaryKeyId()) {
                throw new GeneralSecurityException("cannot destroy the primary key");
            }
            for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
                C0675Keyset.Key keyMo3800getKey = this.keysetBuilder.mo3800getKey(i2);
                if (keyMo3800getKey.getKeyId() == i) {
                    if (keyMo3800getKey.getStatus() != KeyStatusType.ENABLED && keyMo3800getKey.getStatus() != KeyStatusType.DISABLED && keyMo3800getKey.getStatus() != KeyStatusType.DESTROYED) {
                        throw new GeneralSecurityException("cannot destroy key with id " + i);
                    }
                    this.keysetBuilder.m3806setKey(i2, keyMo3800getKey.toBuilder().setStatus(KeyStatusType.DESTROYED).clearKeyData().mo3555build());
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    /* renamed from: disable */
    public synchronized KeysetManager m3369disable(int i) {
        try {
            if (i == this.keysetBuilder.getPrimaryKeyId()) {
                throw new GeneralSecurityException("cannot disable the primary key");
            }
            for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
                C0675Keyset.Key keyMo3800getKey = this.keysetBuilder.mo3800getKey(i2);
                if (keyMo3800getKey.getKeyId() == i) {
                    if (keyMo3800getKey.getStatus() != KeyStatusType.ENABLED && keyMo3800getKey.getStatus() != KeyStatusType.DISABLED) {
                        throw new GeneralSecurityException("cannot disable key with id " + i);
                    }
                    this.keysetBuilder.m3806setKey(i2, keyMo3800getKey.toBuilder().setStatus(KeyStatusType.DISABLED).mo3555build());
                }
            }
            throw new GeneralSecurityException("key not found: " + i);
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    /* renamed from: enable */
    public synchronized KeysetManager m3370enable(int i) {
        for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
            try {
                C0675Keyset.Key keyMo3800getKey = this.keysetBuilder.mo3800getKey(i2);
                if (keyMo3800getKey.getKeyId() == i) {
                    KeyStatusType status = keyMo3800getKey.getStatus();
                    KeyStatusType keyStatusType = KeyStatusType.ENABLED;
                    if (status != keyStatusType && keyMo3800getKey.getStatus() != KeyStatusType.DISABLED) {
                        throw new GeneralSecurityException("cannot enable key with id " + i);
                    }
                    this.keysetBuilder.m3806setKey(i2, keyMo3800getKey.toBuilder().setStatus(keyStatusType).mo3555build());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    public synchronized KeysetHandle getKeysetHandle() {
        return KeysetHandle.fromKeyset(this.keysetBuilder.mo3555build());
    }

    @Deprecated
    /* renamed from: promote */
    public synchronized KeysetManager m3371promote(int i) {
        return setPrimary(i);
    }

    @Deprecated
    /* renamed from: rotate */
    public synchronized KeysetManager m3372rotate(KeyTemplate keyTemplate) {
        addNewKey(keyTemplate, true);
        return this;
    }

    public synchronized KeysetManager setPrimary(int i) {
        for (int i2 = 0; i2 < this.keysetBuilder.getKeyCount(); i2++) {
            C0675Keyset.Key keyMo3800getKey = this.keysetBuilder.mo3800getKey(i2);
            if (keyMo3800getKey.getKeyId() == i) {
                if (!keyMo3800getKey.getStatus().equals(KeyStatusType.ENABLED)) {
                    throw new GeneralSecurityException("cannot set key as primary because it's not enabled: " + i);
                }
                this.keysetBuilder.setPrimaryKeyId(i);
            }
        }
        throw new GeneralSecurityException("key not found: " + i);
        return this;
    }

    /* renamed from: add */
    public synchronized KeysetManager m3363add(KeyTemplate keyTemplate) {
        addNewKey(keyTemplate.getProto(), false);
        return this;
    }

    /* renamed from: add */
    public synchronized KeysetManager m3365add(KeyHandle keyHandle) {
        try {
            ProtoKey protoKey = (ProtoKey) keyHandle.m4288getKey(SecretKeyAccess.insecureSecretAccess());
            if (!keyIdExists(keyHandle.m4287getId())) {
                this.keysetBuilder.m3804addKey(C0675Keyset.Key.newBuilder().setKeyData(protoKey.getProtoKey()).setKeyId(keyHandle.m4287getId()).setStatus(KeyStatusTypeProtoConverter.m3487toProto(keyHandle.getStatus())).setOutputPrefixType(KeyTemplate.m3343toProto(protoKey.getOutputPrefixType())).mo3555build());
            } else {
                throw new GeneralSecurityException("Trying to add a key with an ID already contained in the keyset.");
            }
        } catch (ClassCastException e) {
            throw new UnsupportedOperationException("KeyHandles which contain TinkKeys that are not ProtoKeys are not yet supported.", e);
        }
        return this;
    }

    /* renamed from: add */
    public synchronized KeysetManager m3366add(KeyHandle keyHandle, KeyAccess keyAccess) {
        return m3365add(keyHandle);
    }
}
