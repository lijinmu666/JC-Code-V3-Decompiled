package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.List;
import p094kotlin.C1126UByte;

/* loaded from: classes.dex */
final class NioByteString extends ByteString.LeafByteString {

    /* renamed from: buffer */
    private final ByteBuffer f3736buffer;

    public NioByteString(ByteBuffer byteBuffer) {
        Internal.checkNotNull(byteBuffer, "buffer");
        this.f3736buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("NioByteString instances are not to be serialized directly");
    }

    /* renamed from: slice */
    private ByteBuffer m4108slice(int i, int i2) {
        if (i < this.f3736buffer.position() || i2 > this.f3736buffer.limit() || i > i2) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2)));
        }
        ByteBuffer byteBufferSlice = this.f3736buffer.slice();
        byteBufferSlice.position(i - this.f3736buffer.position());
        byteBufferSlice.limit(i2 - this.f3736buffer.position());
        return byteBufferSlice;
    }

    private Object writeReplace() {
        return ByteString.copyFrom(this.f3736buffer.slice());
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public ByteBuffer asReadOnlyByteBuffer() {
        return this.f3736buffer.asReadOnlyBuffer();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public List<ByteBuffer> asReadOnlyByteBufferList() {
        return Collections.singletonList(asReadOnlyByteBuffer());
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: byteAt */
    public byte mo3937byteAt(int i) {
        try {
            return this.f3736buffer.get(i);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: copyTo */
    public void mo3939copyTo(ByteBuffer byteBuffer) {
        byteBuffer.put(this.f3736buffer.slice());
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i, int i2, int i3) {
        ByteBuffer byteBufferSlice = this.f3736buffer.slice();
        byteBufferSlice.position(i);
        byteBufferSlice.get(bArr, i2, i3);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: equals */
    public boolean mo3942equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        if (mo3944size() != byteString.mo3944size()) {
            return false;
        }
        if (mo3944size() == 0) {
            return true;
        }
        return obj instanceof NioByteString ? this.f3736buffer.equals(((NioByteString) obj).f3736buffer) : obj instanceof RopeByteString ? obj.equals(this) : this.f3736buffer.equals(byteString.asReadOnlyByteBuffer());
    }

    @Override // com.google.crypto.tink.shaded.protobuf.ByteString.LeafByteString
    public boolean equalsRange(ByteString byteString, int i, int i2) {
        return substring(0, i2).mo3942equals(byteString.substring(i, i2 + i));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public byte internalByteAt(int i) {
        return mo3937byteAt(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public boolean isValidUtf8() {
        return C0801Utf8.isValidUtf8(this.f3736buffer);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public CodedInputStream newCodedInput() {
        return CodedInputStream.newInstance(this.f3736buffer, true);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public InputStream newInput() {
        return new InputStream() { // from class: com.google.crypto.tink.shaded.protobuf.NioByteString.1

            /* renamed from: buf */
            private final ByteBuffer f3737buf;

            {
                this.f3737buf = NioByteString.this.f3736buffer.slice();
            }

            @Override // java.io.InputStream
            public int available() {
                return this.f3737buf.remaining();
            }

            @Override // java.io.InputStream
            public void mark(int i) {
                this.f3737buf.mark();
            }

            @Override // java.io.InputStream
            public boolean markSupported() {
                return true;
            }

            @Override // java.io.InputStream
            public int read() {
                if (this.f3737buf.hasRemaining()) {
                    return this.f3737buf.get() & C1126UByte.MAX_VALUE;
                }
                return -1;
            }

            @Override // java.io.InputStream
            public void reset() throws IOException {
                try {
                    this.f3737buf.reset();
                } catch (InvalidMarkException e) {
                    throw new IOException(e);
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                if (!this.f3737buf.hasRemaining()) {
                    return -1;
                }
                int iMin = Math.min(i2, this.f3737buf.remaining());
                this.f3737buf.get(bArr, i, iMin);
                return iMin;
            }
        };
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public int partialHash(int i, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + this.f3736buffer.get(i4);
        }
        return i;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public int partialIsValidUtf8(int i, int i2, int i3) {
        return C0801Utf8.partialIsValidUtf8(i, this.f3736buffer, i2, i3 + i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: size */
    public int mo3944size() {
        return this.f3736buffer.remaining();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public ByteString substring(int i, int i2) {
        try {
            return new NioByteString(m4108slice(i, i2));
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (IndexOutOfBoundsException e2) {
            throw new ArrayIndexOutOfBoundsException(e2.getMessage());
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public String toStringInternal(Charset charset) {
        byte[] byteArray;
        int length;
        int iArrayOffset;
        if (this.f3736buffer.hasArray()) {
            byteArray = this.f3736buffer.array();
            iArrayOffset = this.f3736buffer.arrayOffset() + this.f3736buffer.position();
            length = this.f3736buffer.remaining();
        } else {
            byteArray = toByteArray();
            length = byteArray.length;
            iArrayOffset = 0;
        }
        return new String(byteArray, iArrayOffset, length, charset);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: writeTo */
    public void mo3946writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(toByteArray());
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    public void writeToInternal(OutputStream outputStream, int i, int i2) throws IOException {
        if (!this.f3736buffer.hasArray()) {
            ByteBufferWriter.m3930write(m4108slice(i, i2 + i), outputStream);
        } else {
            outputStream.write(this.f3736buffer.array(), this.f3736buffer.arrayOffset() + this.f3736buffer.position() + i, i2);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString
    /* renamed from: writeTo */
    public void mo3945writeTo(ByteOutput byteOutput) {
        byteOutput.writeLazy(this.f3736buffer.slice());
    }
}
