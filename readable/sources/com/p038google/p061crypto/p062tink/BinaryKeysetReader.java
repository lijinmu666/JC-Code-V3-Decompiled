package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.EncryptedKeyset;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class BinaryKeysetReader implements KeysetReader {
    private final InputStream inputStream;

    private BinaryKeysetReader(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public static KeysetReader withBytes(byte[] bArr) {
        return new BinaryKeysetReader(new ByteArrayInputStream(bArr));
    }

    @Deprecated
    public static KeysetReader withFile(File file) {
        return withInputStream(new FileInputStream(file));
    }

    public static KeysetReader withInputStream(InputStream inputStream) {
        return new BinaryKeysetReader(inputStream);
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetReader
    /* renamed from: read */
    public C0675Keyset mo3324read() throws IOException {
        try {
            return C0675Keyset.parseFrom(this.inputStream, ExtensionRegistryLite.getEmptyRegistry());
        } finally {
            this.inputStream.close();
        }
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetReader
    public EncryptedKeyset readEncrypted() throws IOException {
        try {
            return EncryptedKeyset.parseFrom(this.inputStream, ExtensionRegistryLite.getEmptyRegistry());
        } finally {
            this.inputStream.close();
        }
    }
}
