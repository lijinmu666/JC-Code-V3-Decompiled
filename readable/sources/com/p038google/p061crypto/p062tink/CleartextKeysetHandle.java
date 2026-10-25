package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.monitoring.MonitoringAnnotations;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import java.security.GeneralSecurityException;
import java.util.Map;

/* loaded from: classes.dex */
public final class CleartextKeysetHandle {
    private CleartextKeysetHandle() {
    }

    public static KeysetHandle fromKeyset(C0675Keyset c0675Keyset) {
        return KeysetHandle.fromKeyset(c0675Keyset);
    }

    public static C0675Keyset getKeyset(KeysetHandle keysetHandle) {
        return keysetHandle.getKeyset();
    }

    @Deprecated
    public static final KeysetHandle parseFrom(byte[] bArr) throws GeneralSecurityException {
        try {
            return KeysetHandle.fromKeyset(C0675Keyset.parseFrom(bArr, ExtensionRegistryLite.getEmptyRegistry()));
        } catch (InvalidProtocolBufferException unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    /* renamed from: read */
    public static KeysetHandle m3327read(KeysetReader keysetReader) {
        return KeysetHandle.fromKeyset(keysetReader.mo3324read());
    }

    /* renamed from: write */
    public static void m3329write(KeysetHandle keysetHandle, KeysetWriter keysetWriter) {
        keysetWriter.mo3326write(keysetHandle.getKeyset());
    }

    @InterfaceC0389Alpha
    /* renamed from: read */
    public static KeysetHandle m3328read(KeysetReader keysetReader, Map<String, String> map) {
        return KeysetHandle.fromKeysetAndAnnotations(keysetReader.mo3324read(), MonitoringAnnotations.newBuilder().m3536addAll(map).m3537build());
    }
}
