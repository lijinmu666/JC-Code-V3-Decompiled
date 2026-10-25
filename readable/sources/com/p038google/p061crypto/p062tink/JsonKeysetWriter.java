package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.EncryptedKeyset;
import com.p038google.p061crypto.p062tink.p073proto.KeysetInfo;
import com.p038google.p061crypto.p062tink.p075subtle.C0852Base64;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.util.Iterator;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import p131o.C3858i0;
import p131o.C4385q0;
import p131o.C4454r0;

/* loaded from: classes.dex */
public final class JsonKeysetWriter implements KeysetWriter {

    /* renamed from: UTF_8 */
    private static final Charset f2989UTF_8 = Charset.forName("UTF-8");
    private final OutputStream outputStream;

    private JsonKeysetWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /* renamed from: toJson */
    private C4385q0 m3336toJson(C0675Keyset c0675Keyset) {
        C4385q0 c4385q0 = new C4385q0();
        c4385q0.m13152IEE("primaryKeyId", Long.valueOf(toUnsignedLong(c0675Keyset.getPrimaryKeyId())));
        C3858i0 c3858i0 = new C3858i0();
        Iterator<C0675Keyset.Key> it = c0675Keyset.getKeyList().iterator();
        while (it.hasNext()) {
            c3858i0.m12264IEE(m3335toJson(it.next()));
        }
        c4385q0.m13158fehf("key", c3858i0);
        return c4385q0;
    }

    private long toUnsignedLong(int i) {
        return i & BodyPartID.bodyIdMax;
    }

    @Deprecated
    public static KeysetWriter withFile(File file) {
        return withOutputStream(new FileOutputStream(file));
    }

    public static KeysetWriter withOutputStream(OutputStream outputStream) {
        return new JsonKeysetWriter(outputStream);
    }

    @Deprecated
    public static KeysetWriter withPath(String str) {
        return withOutputStream(new FileOutputStream(new File(str)));
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetWriter
    /* renamed from: write */
    public void mo3326write(C0675Keyset c0675Keyset) throws IOException {
        try {
            try {
                OutputStream outputStream = this.outputStream;
                String string = m3336toJson(c0675Keyset).toString();
                Charset charset = f2989UTF_8;
                outputStream.write(string.getBytes(charset));
                this.outputStream.write(System.lineSeparator().getBytes(charset));
            } catch (C4454r0 e) {
                throw new IOException(e);
            }
        } finally {
            this.outputStream.close();
        }
    }

    @Deprecated
    public static KeysetWriter withPath(Path path) {
        return withOutputStream(new FileOutputStream(path.toFile()));
    }

    /* renamed from: toJson */
    private C4385q0 m3335toJson(C0675Keyset.Key key) {
        C4385q0 c4385q0 = new C4385q0();
        c4385q0.m13158fehf("keyData", m3334toJson(key.getKeyData()));
        c4385q0.m13153Pq("status", key.getStatus().name());
        c4385q0.m13152IEE("keyId", Long.valueOf(toUnsignedLong(key.getKeyId())));
        c4385q0.m13153Pq("outputPrefixType", key.getOutputPrefixType().name());
        return c4385q0;
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetWriter
    /* renamed from: write */
    public void mo3325write(EncryptedKeyset encryptedKeyset) throws IOException {
        OutputStream outputStream = this.outputStream;
        String string = m3333toJson(encryptedKeyset).toString();
        Charset charset = f2989UTF_8;
        outputStream.write(string.getBytes(charset));
        this.outputStream.write(System.lineSeparator().getBytes(charset));
        this.outputStream.close();
    }

    /* renamed from: toJson */
    private C4385q0 m3334toJson(C0669KeyData c0669KeyData) {
        C4385q0 c4385q0 = new C4385q0();
        c4385q0.m13153Pq("typeUrl", c0669KeyData.getTypeUrl());
        c4385q0.m13153Pq("value", C0852Base64.m4225encode(c0669KeyData.getValue().toByteArray()));
        c4385q0.m13153Pq("keyMaterialType", c0669KeyData.getKeyMaterialType().name());
        return c4385q0;
    }

    /* renamed from: toJson */
    private C4385q0 m3333toJson(EncryptedKeyset encryptedKeyset) {
        C4385q0 c4385q0 = new C4385q0();
        c4385q0.m13153Pq("encryptedKeyset", C0852Base64.m4225encode(encryptedKeyset.getEncryptedKeyset().toByteArray()));
        c4385q0.m13158fehf("keysetInfo", m3338toJson(encryptedKeyset.getKeysetInfo()));
        return c4385q0;
    }

    /* renamed from: toJson */
    private C4385q0 m3338toJson(KeysetInfo keysetInfo) {
        C4385q0 c4385q0 = new C4385q0();
        c4385q0.m13152IEE("primaryKeyId", Long.valueOf(toUnsignedLong(keysetInfo.getPrimaryKeyId())));
        C3858i0 c3858i0 = new C3858i0();
        Iterator<KeysetInfo.C0678KeyInfo> it = keysetInfo.getKeyInfoList().iterator();
        while (it.hasNext()) {
            c3858i0.m12264IEE(m3337toJson(it.next()));
        }
        c4385q0.m13158fehf("keyInfo", c3858i0);
        return c4385q0;
    }

    /* renamed from: toJson */
    private C4385q0 m3337toJson(KeysetInfo.C0678KeyInfo c0678KeyInfo) {
        C4385q0 c4385q0 = new C4385q0();
        c4385q0.m13153Pq("typeUrl", c0678KeyInfo.getTypeUrl());
        c4385q0.m13153Pq("status", c0678KeyInfo.getStatus().name());
        c4385q0.m13152IEE("keyId", Long.valueOf(toUnsignedLong(c0678KeyInfo.getKeyId())));
        c4385q0.m13153Pq("outputPrefixType", c0678KeyInfo.getOutputPrefixType().name());
        return c4385q0;
    }
}
