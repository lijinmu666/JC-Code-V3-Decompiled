package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.p073proto.C0675Keyset;
import com.p038google.p061crypto.p062tink.p073proto.EncryptedKeyset;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class BinaryKeysetWriter implements KeysetWriter {
    private final OutputStream outputStream;

    private BinaryKeysetWriter(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Deprecated
    public static KeysetWriter withFile(File file) {
        return withOutputStream(new FileOutputStream(file));
    }

    public static KeysetWriter withOutputStream(OutputStream outputStream) {
        return new BinaryKeysetWriter(outputStream);
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetWriter
    /* renamed from: write */
    public void mo3326write(C0675Keyset c0675Keyset) throws IOException {
        try {
            c0675Keyset.mo3906writeTo(this.outputStream);
        } finally {
            this.outputStream.close();
        }
    }

    @Override // com.p038google.p061crypto.p062tink.KeysetWriter
    /* renamed from: write */
    public void mo3325write(EncryptedKeyset encryptedKeyset) throws IOException {
        try {
            encryptedKeyset.mo3906writeTo(this.outputStream);
        } finally {
            this.outputStream.close();
        }
    }
}
