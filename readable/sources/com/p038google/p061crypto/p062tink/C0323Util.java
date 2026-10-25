package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.KeyStatusType;
import com.p038google.p061crypto.p062tink.p073proto.KeysetInfo;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.Iterator;

/* renamed from: com.google.crypto.tink.Util */
/* loaded from: classes.dex */
final class C0323Util {

    /* renamed from: UTF_8 */
    public static final Charset f3022UTF_8 = Charset.forName("UTF-8");

    private C0323Util() {
    }

    public static KeysetInfo.C0678KeyInfo getKeyInfo(C0675Keyset.Key key) {
        return KeysetInfo.C0678KeyInfo.newBuilder().setTypeUrl(key.getKeyData().getTypeUrl()).setStatus(key.getStatus()).setOutputPrefixType(key.getOutputPrefixType()).setKeyId(key.getKeyId()).mo3555build();
    }

    public static KeysetInfo getKeysetInfo(C0675Keyset c0675Keyset) {
        KeysetInfo.C0677Builder primaryKeyId = KeysetInfo.newBuilder().setPrimaryKeyId(c0675Keyset.getPrimaryKeyId());
        Iterator<C0675Keyset.Key> it = c0675Keyset.getKeyList().iterator();
        while (it.hasNext()) {
            primaryKeyId.addKeyInfo(getKeyInfo(it.next()));
        }
        return primaryKeyId.mo3555build();
    }

    /* renamed from: readAll */
    public static byte[] m3393readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    public static void validateKey(C0675Keyset.Key key) throws GeneralSecurityException {
        if (!key.hasKeyData()) {
            throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(key.getKeyId())));
        }
        if (key.getOutputPrefixType() == OutputPrefixType.UNKNOWN_PREFIX) {
            throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(key.getKeyId())));
        }
        if (key.getStatus() == KeyStatusType.UNKNOWN_STATUS) {
            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(key.getKeyId())));
        }
    }

    public static void validateKeyset(C0675Keyset c0675Keyset) {
        int primaryKeyId = c0675Keyset.getPrimaryKeyId();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (C0675Keyset.Key key : c0675Keyset.getKeyList()) {
            if (key.getStatus() == KeyStatusType.ENABLED) {
                validateKey(key);
                if (key.getKeyId() == primaryKeyId) {
                    if (z) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z = true;
                }
                if (key.getKeyData().getKeyMaterialType() != C0669KeyData.KeyMaterialType.ASYMMETRIC_PUBLIC) {
                    z2 = false;
                }
                i++;
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
