package com.p038google.p061crypto.p062tink.streamingaead;

import com.p038google.p061crypto.p062tink.PrimitiveSet;
import com.p038google.p061crypto.p062tink.StreamingAead;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class StreamingAeadHelper implements StreamingAead {
    PrimitiveSet<StreamingAead> primitives;

    public StreamingAeadHelper(PrimitiveSet<StreamingAead> primitiveSet) throws GeneralSecurityException {
        if (primitiveSet.getPrimary() == null) {
            throw new GeneralSecurityException("Missing primary primitive.");
        }
        this.primitives = primitiveSet;
    }

    @Override // com.p038google.p061crypto.p062tink.StreamingAead
    public ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) {
        return new ReadableByteChannelDecrypter(this.primitives, readableByteChannel, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.StreamingAead
    public InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) {
        return new InputStreamDecrypter(this.primitives, inputStream, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.StreamingAead
    public WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) {
        return this.primitives.getPrimary().getPrimitive().newEncryptingChannel(writableByteChannel, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.StreamingAead
    public OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) {
        return this.primitives.getPrimary().getPrimitive().newEncryptingStream(outputStream, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.StreamingAead
    public SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        return new SeekableByteChannelDecrypter(this.primitives, seekableByteChannel, bArr);
    }
}
