package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0801Utf8;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class CodedOutputStream extends ByteOutput {
    public static final int DEFAULT_BUFFER_SIZE = 4096;

    @Deprecated
    public static final int LITTLE_ENDIAN_32_SIZE = 4;
    private boolean serializationDeterministic;

    /* renamed from: wrapper */
    CodedOutputStreamWriter f3592wrapper;

    /* renamed from: logger */
    private static final Logger f3591logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();

    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {

        /* renamed from: buffer */
        final byte[] f3593buffer;

        /* renamed from: limit */
        final int f3594limit;
        int position;
        int totalBytesWritten;

        public AbstractBufferedEncoder(int i) {
            super();
            if (i < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i, 20)];
            this.f3593buffer = bArr;
            this.f3594limit = bArr.length;
        }

        /* renamed from: buffer */
        public final void m3961buffer(byte b) {
            byte[] bArr = this.f3593buffer;
            int i = this.position;
            this.position = i + 1;
            bArr[i] = b;
            this.totalBytesWritten++;
        }

        public final void bufferFixed32NoTag(int i) {
            byte[] bArr = this.f3593buffer;
            int i2 = this.position;
            int i3 = i2 + 1;
            this.position = i3;
            bArr[i2] = (byte) (i & 255);
            int i4 = i2 + 2;
            this.position = i4;
            bArr[i3] = (byte) ((i >> 8) & 255);
            int i5 = i2 + 3;
            this.position = i5;
            bArr[i4] = (byte) ((i >> 16) & 255);
            this.position = i2 + 4;
            bArr[i5] = (byte) ((i >> 24) & 255);
            this.totalBytesWritten += 4;
        }

        public final void bufferFixed64NoTag(long j) {
            byte[] bArr = this.f3593buffer;
            int i = this.position;
            int i2 = i + 1;
            this.position = i2;
            bArr[i] = (byte) (j & 255);
            int i3 = i + 2;
            this.position = i3;
            bArr[i2] = (byte) ((j >> 8) & 255);
            int i4 = i + 3;
            this.position = i4;
            bArr[i3] = (byte) ((j >> 16) & 255);
            int i5 = i + 4;
            this.position = i5;
            bArr[i4] = (byte) (255 & (j >> 24));
            int i6 = i + 5;
            this.position = i6;
            bArr[i5] = (byte) (((int) (j >> 32)) & 255);
            int i7 = i + 6;
            this.position = i7;
            bArr[i6] = (byte) (((int) (j >> 40)) & 255);
            int i8 = i + 7;
            this.position = i8;
            bArr[i7] = (byte) (((int) (j >> 48)) & 255);
            this.position = i + 8;
            bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            this.totalBytesWritten += 8;
        }

        public final void bufferInt32NoTag(int i) {
            if (i >= 0) {
                bufferUInt32NoTag(i);
            } else {
                bufferUInt64NoTag(i);
            }
        }

        public final void bufferTag(int i, int i2) {
            bufferUInt32NoTag(WireFormat.m4185makeTag(i, i2));
        }

        public final void bufferUInt32NoTag(int i) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((i & (-128)) != 0) {
                    byte[] bArr = this.f3593buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    this.totalBytesWritten++;
                    i >>>= 7;
                }
                byte[] bArr2 = this.f3593buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i;
                this.totalBytesWritten++;
                return;
            }
            long j = this.position;
            while ((i & (-128)) != 0) {
                byte[] bArr3 = this.f3593buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                UnsafeUtil.m4161putByte(bArr3, i4, (byte) ((i & 127) | 128));
                i >>>= 7;
            }
            byte[] bArr4 = this.f3593buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            UnsafeUtil.m4161putByte(bArr4, i5, (byte) i);
            this.totalBytesWritten += (int) (this.position - j);
        }

        public final void bufferUInt64NoTag(long j) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f3593buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    this.totalBytesWritten++;
                    j >>>= 7;
                }
                byte[] bArr2 = this.f3593buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) j;
                this.totalBytesWritten++;
                return;
            }
            long j2 = this.position;
            while ((j & (-128)) != 0) {
                byte[] bArr3 = this.f3593buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                UnsafeUtil.m4161putByte(bArr3, i3, (byte) ((((int) j) & 127) | 128));
                j >>>= 7;
            }
            byte[] bArr4 = this.f3593buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            UnsafeUtil.m4161putByte(bArr4, i4, (byte) j);
            this.totalBytesWritten += (int) (this.position - j2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.totalBytesWritten;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final int spaceLeft() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    public static class ArrayEncoder extends CodedOutputStream {

        /* renamed from: buffer */
        private final byte[] f3595buffer;

        /* renamed from: limit */
        private final int f3596limit;

        /* renamed from: offset */
        private final int f3597offset;
        private int position;

        public ArrayEncoder(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i + i2;
            if ((i | i2 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            this.f3595buffer = bArr;
            this.f3597offset = i;
            this.position = i;
            this.f3596limit = i3;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        /* renamed from: flush */
        public void mo3960flush() {
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final int getTotalBytesWritten() {
            return this.position - this.f3597offset;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.f3596limit - this.position;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public final void mo3922write(byte b) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f3595buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.f3596limit), 1), e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeBool(int i, boolean z) throws OutOfSpaceException {
            writeTag(i, 0);
            mo3922write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeByteArray(int i, byte[] bArr) throws OutOfSpaceException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            writeUInt32NoTag(i2);
            mo3924write(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeByteBuffer(int i, ByteBuffer byteBuffer) throws OutOfSpaceException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeBytes(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) throws OutOfSpaceException {
            writeUInt32NoTag(byteString.mo3944size());
            byteString.mo3945writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeFixed32(int i, int i2) throws OutOfSpaceException {
            writeTag(i, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f3595buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) (i & 255);
                int i4 = i2 + 2;
                this.position = i4;
                bArr[i3] = (byte) ((i >> 8) & 255);
                int i5 = i2 + 3;
                this.position = i5;
                bArr[i4] = (byte) ((i >> 16) & 255);
                this.position = i2 + 4;
                bArr[i5] = (byte) ((i >> 24) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.f3596limit), 1), e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeFixed64(int i, long j) throws OutOfSpaceException {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j) throws OutOfSpaceException {
            try {
                byte[] bArr = this.f3595buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) (((int) j) & 255);
                int i3 = i + 2;
                this.position = i3;
                bArr[i2] = (byte) (((int) (j >> 8)) & 255);
                int i4 = i + 3;
                this.position = i4;
                bArr[i3] = (byte) (((int) (j >> 16)) & 255);
                int i5 = i + 4;
                this.position = i5;
                bArr[i4] = (byte) (((int) (j >> 24)) & 255);
                int i6 = i + 5;
                this.position = i6;
                bArr[i5] = (byte) (((int) (j >> 32)) & 255);
                int i7 = i + 6;
                this.position = i7;
                bArr[i6] = (byte) (((int) (j >> 40)) & 255);
                int i8 = i + 7;
                this.position = i8;
                bArr[i7] = (byte) (((int) (j >> 48)) & 255);
                this.position = i + 8;
                bArr[i8] = (byte) (((int) (j >> 56)) & 255);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.f3596limit), 1), e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeInt32(int i, int i2) throws OutOfSpaceException {
            writeTag(i, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i) throws OutOfSpaceException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            mo3924write(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeMessage(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) throws OutOfSpaceException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.mo4026writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeRawBytes(ByteBuffer byteBuffer) throws OutOfSpaceException {
            if (byteBuffer.hasArray()) {
                mo3924write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            mo3923write(byteBufferDuplicate);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeString(int i, String str) throws OutOfSpaceException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) throws OutOfSpaceException {
            int i = this.position;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int i2 = i + iComputeUInt32SizeNoTag2;
                    this.position = i2;
                    int iM4180encode = C0801Utf8.m4180encode(str, this.f3595buffer, i2, spaceLeft());
                    this.position = i;
                    writeUInt32NoTag((iM4180encode - i) - iComputeUInt32SizeNoTag2);
                    this.position = iM4180encode;
                } else {
                    writeUInt32NoTag(C0801Utf8.encodedLength(str));
                    this.position = C0801Utf8.m4180encode(str, this.f3595buffer, this.position, spaceLeft());
                }
            } catch (C0801Utf8.UnpairedSurrogateException e) {
                this.position = i;
                inefficientWriteStringNoTag(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeTag(int i, int i2) throws OutOfSpaceException {
            writeUInt32NoTag(WireFormat.m4185makeTag(i, i2));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeUInt32(int i, int i2) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i) throws OutOfSpaceException {
            while ((i & (-128)) != 0) {
                try {
                    byte[] bArr = this.f3595buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.f3596limit), 1), e);
                }
            }
            byte[] bArr2 = this.f3595buffer;
            int i3 = this.position;
            this.position = i3 + 1;
            bArr2[i3] = (byte) i;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeUInt64(int i, long j) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j) throws OutOfSpaceException {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS && spaceLeft() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.f3595buffer;
                    int i = this.position;
                    this.position = i + 1;
                    UnsafeUtil.m4161putByte(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.f3595buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                UnsafeUtil.m4161putByte(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f3595buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.f3596limit), 1), e);
                }
            }
            byte[] bArr4 = this.f3595buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeByteArray(int i, byte[] bArr, int i2, int i3) throws OutOfSpaceException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public final void writeLazy(ByteBuffer byteBuffer) throws OutOfSpaceException {
            mo3923write(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeMessage(int i, MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) throws OutOfSpaceException {
            writeTag(i, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(interfaceC0777Schema));
            interfaceC0777Schema.mo4094writeTo(messageLite, this.f3592wrapper);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) throws OutOfSpaceException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(interfaceC0777Schema));
            interfaceC0777Schema.mo4094writeTo(messageLite, this.f3592wrapper);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public final void mo3924write(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            try {
                System.arraycopy(bArr, i, this.f3595buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.f3596limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public final void mo3923write(ByteBuffer byteBuffer) throws OutOfSpaceException {
            int iRemaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f3595buffer, this.position, iRemaining);
                this.position += iRemaining;
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.f3596limit), Integer.valueOf(iRemaining)), e);
            }
        }
    }

    public static final class ByteOutputEncoder extends AbstractBufferedEncoder {

        /* renamed from: out */
        private final ByteOutput f3598out;

        public ByteOutputEncoder(ByteOutput byteOutput, int i) {
            super(i);
            if (byteOutput == null) {
                throw new NullPointerException("out");
            }
            this.f3598out = byteOutput;
        }

        /* renamed from: doFlush */
        private void m3962doFlush() {
            this.f3598out.mo3924write(this.f3593buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i) {
            if (this.f3594limit - this.position < i) {
                m3962doFlush();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        /* renamed from: flush */
        public void mo3960flush() {
            if (this.position > 0) {
                m3962doFlush();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3922write(byte b) {
            if (this.position == this.f3594limit) {
                m3962doFlush();
            }
            m3961buffer(b);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z) {
            flushIfNotAvailable(11);
            bufferTag(i, 0);
            m3961buffer(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i2) {
            writeUInt32NoTag(i2);
            mo3924write(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.mo3944size());
            byteString.mo3945writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i2) {
            flushIfNotAvailable(14);
            bufferTag(i, 5);
            bufferFixed32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j) {
            flushIfNotAvailable(18);
            bufferTag(i, 1);
            bufferFixed64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeInt32(int i, int i2) {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i2) {
            mo3960flush();
            this.f3598out.writeLazy(bArr, i, i2);
            this.totalBytesWritten += i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.mo4026writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) {
            if (byteBuffer.hasArray()) {
                mo3924write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            mo3923write(byteBufferDuplicate);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws OutOfSpaceException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws OutOfSpaceException {
            int length = str.length() * 3;
            int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
            int i = iComputeUInt32SizeNoTag + length;
            int i2 = this.f3594limit;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iM4180encode = C0801Utf8.m4180encode(str, bArr, 0, length);
                writeUInt32NoTag(iM4180encode);
                writeLazy(bArr, 0, iM4180encode);
                return;
            }
            if (i > i2 - this.position) {
                m3962doFlush();
            }
            int i3 = this.position;
            try {
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int i4 = i3 + iComputeUInt32SizeNoTag2;
                    this.position = i4;
                    int iM4180encode2 = C0801Utf8.m4180encode(str, this.f3593buffer, i4, this.f3594limit - i4);
                    this.position = i3;
                    int i5 = (iM4180encode2 - i3) - iComputeUInt32SizeNoTag2;
                    bufferUInt32NoTag(i5);
                    this.position = iM4180encode2;
                    this.totalBytesWritten += i5;
                } else {
                    int iEncodedLength = C0801Utf8.encodedLength(str);
                    bufferUInt32NoTag(iEncodedLength);
                    this.position = C0801Utf8.m4180encode(str, this.f3593buffer, this.position, iEncodedLength);
                    this.totalBytesWritten += iEncodedLength;
                }
            } catch (C0801Utf8.UnpairedSurrogateException e) {
                this.totalBytesWritten -= this.position - i3;
                this.position = i3;
                inefficientWriteStringNoTag(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeTag(int i, int i2) {
            writeUInt32NoTag(WireFormat.m4185makeTag(i, i2));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i2) {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j) {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i2, int i3) {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, interfaceC0777Schema);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(interfaceC0777Schema));
            interfaceC0777Schema.mo4094writeTo(messageLite, this.f3592wrapper);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3924write(byte[] bArr, int i, int i2) {
            mo3960flush();
            this.f3598out.mo3924write(bArr, i, i2);
            this.totalBytesWritten += i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            mo3960flush();
            int iRemaining = byteBuffer.remaining();
            this.f3598out.writeLazy(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3923write(ByteBuffer byteBuffer) {
            mo3960flush();
            int iRemaining = byteBuffer.remaining();
            this.f3598out.mo3923write(byteBuffer);
            this.totalBytesWritten += iRemaining;
        }
    }

    public static final class HeapNioEncoder extends ArrayEncoder {
        private final ByteBuffer byteBuffer;
        private int initialPosition;

        public HeapNioEncoder(ByteBuffer byteBuffer) {
            super(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            this.byteBuffer = byteBuffer;
            this.initialPosition = byteBuffer.position();
        }

        @Override // com.google.crypto.tink.shaded.protobuf.CodedOutputStream.ArrayEncoder, com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        /* renamed from: flush */
        public void mo3960flush() {
            this.byteBuffer.position(this.initialPosition + getTotalBytesWritten());
        }
    }

    public static class OutOfSpaceException extends IOException {

        /* renamed from: MESSAGE */
        private static final String f3599MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        public OutOfSpaceException() {
            super(f3599MESSAGE);
        }

        public OutOfSpaceException(String str) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str);
        }

        public OutOfSpaceException(Throwable th) {
            super(f3599MESSAGE, th);
        }

        public OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }
    }

    public static final class OutputStreamEncoder extends AbstractBufferedEncoder {

        /* renamed from: out */
        private final OutputStream f3600out;

        public OutputStreamEncoder(OutputStream outputStream, int i) {
            super(i);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f3600out = outputStream;
        }

        /* renamed from: doFlush */
        private void m3963doFlush() throws IOException {
            this.f3600out.write(this.f3593buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i) throws IOException {
            if (this.f3594limit - this.position < i) {
                m3963doFlush();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        /* renamed from: flush */
        public void mo3960flush() throws IOException {
            if (this.position > 0) {
                m3963doFlush();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3922write(byte b) throws IOException {
            if (this.position == this.f3594limit) {
                m3963doFlush();
            }
            m3961buffer(b);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z) throws IOException {
            flushIfNotAvailable(11);
            bufferTag(i, 0);
            m3961buffer(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws IOException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i2) throws IOException {
            writeUInt32NoTag(i2);
            mo3924write(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws IOException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws IOException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws IOException {
            writeUInt32NoTag(byteString.mo3944size());
            byteString.mo3945writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i2) throws IOException {
            flushIfNotAvailable(14);
            bufferTag(i, 5);
            bufferFixed32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws IOException {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j) throws IOException {
            flushIfNotAvailable(18);
            bufferTag(i, 1);
            bufferFixed64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws IOException {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeInt32(int i, int i2) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws IOException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i2) throws IOException {
            mo3924write(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws IOException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.mo4026writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws IOException {
            if (byteBuffer.hasArray()) {
                mo3924write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            mo3923write(byteBufferDuplicate);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws IOException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws IOException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws IOException {
            int iEncodedLength;
            try {
                int length = str.length() * 3;
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i = iComputeUInt32SizeNoTag + length;
                int i2 = this.f3594limit;
                if (i > i2) {
                    byte[] bArr = new byte[length];
                    int iM4180encode = C0801Utf8.m4180encode(str, bArr, 0, length);
                    writeUInt32NoTag(iM4180encode);
                    writeLazy(bArr, 0, iM4180encode);
                    return;
                }
                if (i > i2 - this.position) {
                    m3963doFlush();
                }
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i3 = this.position;
                try {
                    if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                        int i4 = i3 + iComputeUInt32SizeNoTag2;
                        this.position = i4;
                        int iM4180encode2 = C0801Utf8.m4180encode(str, this.f3593buffer, i4, this.f3594limit - i4);
                        this.position = i3;
                        iEncodedLength = (iM4180encode2 - i3) - iComputeUInt32SizeNoTag2;
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = iM4180encode2;
                    } else {
                        iEncodedLength = C0801Utf8.encodedLength(str);
                        bufferUInt32NoTag(iEncodedLength);
                        this.position = C0801Utf8.m4180encode(str, this.f3593buffer, this.position, iEncodedLength);
                    }
                    this.totalBytesWritten += iEncodedLength;
                } catch (C0801Utf8.UnpairedSurrogateException e) {
                    this.totalBytesWritten -= this.position - i3;
                    this.position = i3;
                    throw e;
                } catch (ArrayIndexOutOfBoundsException e2) {
                    throw new OutOfSpaceException(e2);
                }
            } catch (C0801Utf8.UnpairedSurrogateException e3) {
                inefficientWriteStringNoTag(str, e3);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeTag(int i, int i2) throws IOException {
            writeUInt32NoTag(WireFormat.m4185makeTag(i, i2));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i2) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws IOException {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j) throws IOException {
            flushIfNotAvailable(20);
            bufferTag(i, 0);
            bufferUInt64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws IOException {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i2, int i3) throws IOException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws IOException {
            mo3923write(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) throws IOException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, interfaceC0777Schema);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) throws IOException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(interfaceC0777Schema));
            interfaceC0777Schema.mo4094writeTo(messageLite, this.f3592wrapper);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3924write(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f3594limit;
            int i4 = this.position;
            if (i3 - i4 >= i2) {
                System.arraycopy(bArr, i, this.f3593buffer, i4, i2);
                this.position += i2;
                this.totalBytesWritten += i2;
                return;
            }
            int i5 = i3 - i4;
            System.arraycopy(bArr, i, this.f3593buffer, i4, i5);
            int i6 = i + i5;
            int i7 = i2 - i5;
            this.position = this.f3594limit;
            this.totalBytesWritten += i5;
            m3963doFlush();
            if (i7 <= this.f3594limit) {
                System.arraycopy(bArr, i6, this.f3593buffer, 0, i7);
                this.position = i7;
            } else {
                this.f3600out.write(bArr, i6, i7);
            }
            this.totalBytesWritten += i7;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3923write(ByteBuffer byteBuffer) throws IOException {
            int iRemaining = byteBuffer.remaining();
            int i = this.f3594limit;
            int i2 = this.position;
            if (i - i2 >= iRemaining) {
                byteBuffer.get(this.f3593buffer, i2, iRemaining);
                this.position += iRemaining;
                this.totalBytesWritten += iRemaining;
                return;
            }
            int i3 = i - i2;
            byteBuffer.get(this.f3593buffer, i2, i3);
            int i4 = iRemaining - i3;
            this.position = this.f3594limit;
            this.totalBytesWritten += i3;
            m3963doFlush();
            while (true) {
                int i5 = this.f3594limit;
                if (i4 > i5) {
                    byteBuffer.get(this.f3593buffer, 0, i5);
                    this.f3600out.write(this.f3593buffer, 0, this.f3594limit);
                    int i6 = this.f3594limit;
                    i4 -= i6;
                    this.totalBytesWritten += i6;
                } else {
                    byteBuffer.get(this.f3593buffer, 0, i4);
                    this.position = i4;
                    this.totalBytesWritten += i4;
                    return;
                }
            }
        }
    }

    public static final class SafeDirectNioEncoder extends CodedOutputStream {

        /* renamed from: buffer */
        private final ByteBuffer f3601buffer;
        private final int initialPosition;
        private final ByteBuffer originalBuffer;

        public SafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.f3601buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            this.initialPosition = byteBuffer.position();
        }

        /* renamed from: encode */
        private void m3964encode(String str) throws OutOfSpaceException {
            try {
                C0801Utf8.encodeUtf8(str, this.f3601buffer);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        /* renamed from: flush */
        public void mo3960flush() {
            this.originalBuffer.position(this.f3601buffer.position());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return this.f3601buffer.position() - this.initialPosition;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public int spaceLeft() {
            return this.f3601buffer.remaining();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3922write(byte b) throws OutOfSpaceException {
            try {
                this.f3601buffer.put(b);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z) throws OutOfSpaceException {
            writeTag(i, 0);
            mo3922write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws OutOfSpaceException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            writeUInt32NoTag(i2);
            mo3924write(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws OutOfSpaceException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws OutOfSpaceException {
            writeUInt32NoTag(byteString.mo3944size());
            byteString.mo3945writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i2) throws OutOfSpaceException {
            writeTag(i, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) throws OutOfSpaceException {
            try {
                this.f3601buffer.putInt(i);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j) throws OutOfSpaceException {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) throws OutOfSpaceException {
            try {
                this.f3601buffer.putLong(j);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeInt32(int i, int i2) throws OutOfSpaceException {
            writeTag(i, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws OutOfSpaceException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            mo3924write(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws OutOfSpaceException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.mo4026writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws OutOfSpaceException {
            if (byteBuffer.hasArray()) {
                mo3924write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            mo3923write(byteBufferDuplicate);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws OutOfSpaceException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws OutOfSpaceException {
            int iPosition = this.f3601buffer.position();
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int iPosition2 = this.f3601buffer.position() + iComputeUInt32SizeNoTag2;
                    this.f3601buffer.position(iPosition2);
                    m3964encode(str);
                    int iPosition3 = this.f3601buffer.position();
                    this.f3601buffer.position(iPosition);
                    writeUInt32NoTag(iPosition3 - iPosition2);
                    this.f3601buffer.position(iPosition3);
                } else {
                    writeUInt32NoTag(C0801Utf8.encodedLength(str));
                    m3964encode(str);
                }
            } catch (C0801Utf8.UnpairedSurrogateException e) {
                this.f3601buffer.position(iPosition);
                inefficientWriteStringNoTag(str, e);
            } catch (IllegalArgumentException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeTag(int i, int i2) throws OutOfSpaceException {
            writeUInt32NoTag(WireFormat.m4185makeTag(i, i2));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i2) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws OutOfSpaceException {
            while ((i & (-128)) != 0) {
                try {
                    this.f3601buffer.put((byte) ((i & 127) | 128));
                    i >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new OutOfSpaceException(e);
                }
            }
            this.f3601buffer.put((byte) i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws OutOfSpaceException {
            while (((-128) & j) != 0) {
                try {
                    this.f3601buffer.put((byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                } catch (BufferOverflowException e) {
                    throw new OutOfSpaceException(e);
                }
            }
            this.f3601buffer.put((byte) j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i2, int i3) throws OutOfSpaceException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws OutOfSpaceException {
            mo3923write(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3924write(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            try {
                this.f3601buffer.put(bArr, i, i2);
            } catch (IndexOutOfBoundsException e) {
                throw new OutOfSpaceException(e);
            } catch (BufferOverflowException e2) {
                throw new OutOfSpaceException(e2);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, interfaceC0777Schema);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) throws OutOfSpaceException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(interfaceC0777Schema));
            interfaceC0777Schema.mo4094writeTo(messageLite, this.f3592wrapper);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3923write(ByteBuffer byteBuffer) throws OutOfSpaceException {
            try {
                this.f3601buffer.put(byteBuffer);
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }
    }

    public static final class UnsafeDirectNioEncoder extends CodedOutputStream {

        /* renamed from: address */
        private final long f3602address;

        /* renamed from: buffer */
        private final ByteBuffer f3603buffer;
        private final long initialPosition;

        /* renamed from: limit */
        private final long f3604limit;
        private final long oneVarintLimit;
        private final ByteBuffer originalBuffer;
        private long position;

        public UnsafeDirectNioEncoder(ByteBuffer byteBuffer) {
            super();
            this.originalBuffer = byteBuffer;
            this.f3603buffer = byteBuffer.duplicate().order(ByteOrder.LITTLE_ENDIAN);
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.f3602address = jAddressOffset;
            long jPosition = byteBuffer.position() + jAddressOffset;
            this.initialPosition = jPosition;
            long jLimit = jAddressOffset + byteBuffer.limit();
            this.f3604limit = jLimit;
            this.oneVarintLimit = jLimit - 10;
            this.position = jPosition;
        }

        private int bufferPos(long j) {
            return (int) (j - this.f3602address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void repositionBuffer(long j) {
            this.f3603buffer.position(bufferPos(j));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        /* renamed from: flush */
        public void mo3960flush() {
            this.originalBuffer.position(bufferPos(this.position));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public int getTotalBytesWritten() {
            return (int) (this.position - this.initialPosition);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public int spaceLeft() {
            return (int) (this.f3604limit - this.position);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3922write(byte b) throws OutOfSpaceException {
            long j = this.position;
            if (j >= this.f3604limit) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.f3604limit), 1));
            }
            this.position = 1 + j;
            UnsafeUtil.m4159putByte(j, b);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBool(int i, boolean z) throws OutOfSpaceException {
            writeTag(i, 0);
            mo3922write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr) throws OutOfSpaceException {
            writeByteArray(i, bArr, 0, bArr.length);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            writeUInt32NoTag(i2);
            mo3924write(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteBuffer(int i, ByteBuffer byteBuffer) throws OutOfSpaceException {
            writeTag(i, 2);
            writeUInt32NoTag(byteBuffer.capacity());
            writeRawBytes(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBytes(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(i, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) throws OutOfSpaceException {
            writeUInt32NoTag(byteString.mo3944size());
            byteString.mo3945writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed32(int i, int i2) throws OutOfSpaceException {
            writeTag(i, 5);
            writeFixed32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i) {
            this.f3603buffer.putInt(bufferPos(this.position), i);
            this.position += 4;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed64(int i, long j) throws OutOfSpaceException {
            writeTag(i, 1);
            writeFixed64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j) {
            this.f3603buffer.putLong(bufferPos(this.position), j);
            this.position += 8;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeInt32(int i, int i2) throws OutOfSpaceException {
            writeTag(i, 0);
            writeInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i) throws OutOfSpaceException {
            if (i >= 0) {
                writeUInt32NoTag(i);
            } else {
                writeUInt64NoTag(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            mo3924write(bArr, i, i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) throws OutOfSpaceException {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.mo4026writeTo(this);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i, MessageLite messageLite) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeRawBytes(ByteBuffer byteBuffer) throws OutOfSpaceException {
            if (byteBuffer.hasArray()) {
                mo3924write(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.capacity());
                return;
            }
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.clear();
            mo3923write(byteBufferDuplicate);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i, ByteString byteString) throws OutOfSpaceException {
            writeTag(1, 3);
            writeUInt32(2, i);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeString(int i, String str) throws OutOfSpaceException {
            writeTag(i, 2);
            writeStringNoTag(str);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) throws OutOfSpaceException {
            long j = this.position;
            try {
                int iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int iComputeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (iComputeUInt32SizeNoTag2 == iComputeUInt32SizeNoTag) {
                    int iBufferPos = bufferPos(this.position) + iComputeUInt32SizeNoTag2;
                    this.f3603buffer.position(iBufferPos);
                    C0801Utf8.encodeUtf8(str, this.f3603buffer);
                    int iPosition = this.f3603buffer.position() - iBufferPos;
                    writeUInt32NoTag(iPosition);
                    this.position += iPosition;
                } else {
                    int iEncodedLength = C0801Utf8.encodedLength(str);
                    writeUInt32NoTag(iEncodedLength);
                    repositionBuffer(this.position);
                    C0801Utf8.encodeUtf8(str, this.f3603buffer);
                    this.position += iEncodedLength;
                }
            } catch (C0801Utf8.UnpairedSurrogateException e) {
                this.position = j;
                repositionBuffer(j);
                inefficientWriteStringNoTag(str, e);
            } catch (IllegalArgumentException e2) {
                throw new OutOfSpaceException(e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new OutOfSpaceException(e3);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeTag(int i, int i2) throws OutOfSpaceException {
            writeUInt32NoTag(WireFormat.m4185makeTag(i, i2));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt32(int i, int i2) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt32NoTag(i2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i) throws OutOfSpaceException {
            if (this.position <= this.oneVarintLimit) {
                while ((i & (-128)) != 0) {
                    long j = this.position;
                    this.position = j + 1;
                    UnsafeUtil.m4159putByte(j, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
                long j2 = this.position;
                this.position = 1 + j2;
                UnsafeUtil.m4159putByte(j2, (byte) i);
                return;
            }
            while (true) {
                long j3 = this.position;
                if (j3 >= this.f3604limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.f3604limit), 1));
                }
                if ((i & (-128)) == 0) {
                    this.position = 1 + j3;
                    UnsafeUtil.m4159putByte(j3, (byte) i);
                    return;
                } else {
                    this.position = j3 + 1;
                    UnsafeUtil.m4159putByte(j3, (byte) ((i & 127) | 128));
                    i >>>= 7;
                }
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt64(int i, long j) throws OutOfSpaceException {
            writeTag(i, 0);
            writeUInt64NoTag(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j) throws OutOfSpaceException {
            if (this.position <= this.oneVarintLimit) {
                while ((j & (-128)) != 0) {
                    long j2 = this.position;
                    this.position = j2 + 1;
                    UnsafeUtil.m4159putByte(j2, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                long j3 = this.position;
                this.position = 1 + j3;
                UnsafeUtil.m4159putByte(j3, (byte) j);
                return;
            }
            while (true) {
                long j4 = this.position;
                if (j4 >= this.f3604limit) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.f3604limit), 1));
                }
                if ((j & (-128)) == 0) {
                    this.position = 1 + j4;
                    UnsafeUtil.m4159putByte(j4, (byte) j);
                    return;
                } else {
                    this.position = j4 + 1;
                    UnsafeUtil.m4159putByte(j4, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeByteArray(int i, byte[] bArr, int i2, int i3) throws OutOfSpaceException {
            writeTag(i, 2);
            writeByteArrayNoTag(bArr, i2, i3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) throws OutOfSpaceException {
            mo3923write(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessage(int i, MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) throws OutOfSpaceException {
            writeTag(i, 2);
            writeMessageNoTag(messageLite, interfaceC0777Schema);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) throws OutOfSpaceException {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(interfaceC0777Schema));
            interfaceC0777Schema.mo4094writeTo(messageLite, this.f3592wrapper);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3924write(byte[] bArr, int i, int i2) throws OutOfSpaceException {
            if (bArr != null && i >= 0 && i2 >= 0 && bArr.length - i2 >= i) {
                long j = i2;
                long j2 = this.f3604limit - j;
                long j3 = this.position;
                if (j2 >= j3) {
                    UnsafeUtil.copyMemory(bArr, i, j3, j);
                    this.position += j;
                    return;
                }
            }
            if (bArr == null) {
                throw new NullPointerException("value");
            }
            throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Long.valueOf(this.position), Long.valueOf(this.f3604limit), Integer.valueOf(i2)));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedOutputStream, com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3923write(ByteBuffer byteBuffer) throws OutOfSpaceException {
            try {
                int iRemaining = byteBuffer.remaining();
                repositionBuffer(this.position);
                this.f3603buffer.put(byteBuffer);
                this.position += iRemaining;
            } catch (BufferOverflowException e) {
                throw new OutOfSpaceException(e);
            }
        }
    }

    public static int computeBoolSize(int i, boolean z) {
        return computeTagSize(i) + computeBoolSizeNoTag(z);
    }

    public static int computeBoolSizeNoTag(boolean z) {
        return 1;
    }

    public static int computeByteArraySize(int i, byte[] bArr) {
        return computeTagSize(i) + computeByteArraySizeNoTag(bArr);
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeByteBufferSize(int i, ByteBuffer byteBuffer) {
        return computeTagSize(i) + computeByteBufferSizeNoTag(byteBuffer);
    }

    public static int computeByteBufferSizeNoTag(ByteBuffer byteBuffer) {
        return computeLengthDelimitedFieldSize(byteBuffer.capacity());
    }

    public static int computeBytesSize(int i, ByteString byteString) {
        return computeTagSize(i) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.mo3944size());
    }

    public static int computeDoubleSize(int i, double d) {
        return computeTagSize(i) + computeDoubleSizeNoTag(d);
    }

    public static int computeDoubleSizeNoTag(double d) {
        return 8;
    }

    public static int computeEnumSize(int i, int i2) {
        return computeTagSize(i) + computeEnumSizeNoTag(i2);
    }

    public static int computeEnumSizeNoTag(int i) {
        return computeInt32SizeNoTag(i);
    }

    public static int computeFixed32Size(int i, int i2) {
        return computeTagSize(i) + computeFixed32SizeNoTag(i2);
    }

    public static int computeFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeFixed64Size(int i, long j) {
        return computeTagSize(i) + computeFixed64SizeNoTag(j);
    }

    public static int computeFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeFloatSize(int i, float f) {
        return computeTagSize(i) + computeFloatSizeNoTag(f);
    }

    public static int computeFloatSizeNoTag(float f) {
        return 4;
    }

    @Deprecated
    public static int computeGroupSize(int i, MessageLite messageLite) {
        return (computeTagSize(i) * 2) + messageLite.getSerializedSize();
    }

    @InlineMe(replacement = "value.getSerializedSize()")
    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i, int i2) {
        return computeTagSize(i) + computeInt32SizeNoTag(i2);
    }

    public static int computeInt32SizeNoTag(int i) {
        if (i >= 0) {
            return computeUInt32SizeNoTag(i);
        }
        return 10;
    }

    public static int computeInt64Size(int i, long j) {
        return computeTagSize(i) + computeInt64SizeNoTag(j);
    }

    public static int computeInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeLazyFieldMessageSetExtensionSize(int i, LazyFieldLite lazyFieldLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeLazyFieldSize(3, lazyFieldLite);
    }

    public static int computeLazyFieldSize(int i, LazyFieldLite lazyFieldLite) {
        return computeTagSize(i) + computeLazyFieldSizeNoTag(lazyFieldLite);
    }

    public static int computeLazyFieldSizeNoTag(LazyFieldLite lazyFieldLite) {
        return computeLengthDelimitedFieldSize(lazyFieldLite.getSerializedSize());
    }

    public static int computeLengthDelimitedFieldSize(int i) {
        return computeUInt32SizeNoTag(i) + i;
    }

    public static int computeMessageSetExtensionSize(int i, MessageLite messageLite) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeMessageSize(3, messageLite);
    }

    public static int computeMessageSize(int i, MessageLite messageLite) {
        return computeTagSize(i) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    public static int computePreferredBufferSize(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    public static int computeRawMessageSetExtensionSize(int i, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i) + computeBytesSize(3, byteString);
    }

    @InlineMe(m4030imports = {"com.google.crypto.tink.shaded.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt32SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint32Size(int i) {
        return computeUInt32SizeNoTag(i);
    }

    @InlineMe(m4030imports = {"com.google.crypto.tink.shaded.protobuf.CodedOutputStream"}, replacement = "CodedOutputStream.computeUInt64SizeNoTag(value)")
    @Deprecated
    public static int computeRawVarint64Size(long j) {
        return computeUInt64SizeNoTag(j);
    }

    public static int computeSFixed32Size(int i, int i2) {
        return computeTagSize(i) + computeSFixed32SizeNoTag(i2);
    }

    public static int computeSFixed32SizeNoTag(int i) {
        return 4;
    }

    public static int computeSFixed64Size(int i, long j) {
        return computeTagSize(i) + computeSFixed64SizeNoTag(j);
    }

    public static int computeSFixed64SizeNoTag(long j) {
        return 8;
    }

    public static int computeSInt32Size(int i, int i2) {
        return computeTagSize(i) + computeSInt32SizeNoTag(i2);
    }

    public static int computeSInt32SizeNoTag(int i) {
        return computeUInt32SizeNoTag(encodeZigZag32(i));
    }

    public static int computeSInt64Size(int i, long j) {
        return computeTagSize(i) + computeSInt64SizeNoTag(j);
    }

    public static int computeSInt64SizeNoTag(long j) {
        return computeUInt64SizeNoTag(encodeZigZag64(j));
    }

    public static int computeStringSize(int i, String str) {
        return computeTagSize(i) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = C0801Utf8.encodedLength(str);
        } catch (C0801Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.f3692UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeTagSize(int i) {
        return computeUInt32SizeNoTag(WireFormat.m4185makeTag(i, 0));
    }

    public static int computeUInt32Size(int i, int i2) {
        return computeTagSize(i) + computeUInt32SizeNoTag(i2);
    }

    public static int computeUInt32SizeNoTag(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i, long j) {
        return computeTagSize(i) + computeUInt64SizeNoTag(j);
    }

    public static int computeUInt64SizeNoTag(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int encodeZigZag32(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static long encodeZigZag64(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream) {
        return newInstance(outputStream, 4096);
    }

    public static CodedOutputStream newSafeInstance(ByteBuffer byteBuffer) {
        return new SafeDirectNioEncoder(byteBuffer);
    }

    public static CodedOutputStream newUnsafeInstance(ByteBuffer byteBuffer) {
        return new UnsafeDirectNioEncoder(byteBuffer);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: flush */
    public abstract void mo3960flush();

    public abstract int getTotalBytesWritten();

    public final void inefficientWriteStringNoTag(String str, C0801Utf8.UnpairedSurrogateException unpairedSurrogateException) throws OutOfSpaceException {
        f3591logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.f3692UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new OutOfSpaceException(e);
        }
    }

    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract int spaceLeft();

    public void useDeterministicSerialization() {
        this.serializationDeterministic = true;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
    /* renamed from: write */
    public abstract void mo3922write(byte b);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
    /* renamed from: write */
    public abstract void mo3923write(ByteBuffer byteBuffer);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
    /* renamed from: write */
    public abstract void mo3924write(byte[] bArr, int i, int i2);

    public abstract void writeBool(int i, boolean z);

    public final void writeBoolNoTag(boolean z) {
        mo3922write(z ? (byte) 1 : (byte) 0);
    }

    public abstract void writeByteArray(int i, byte[] bArr);

    public abstract void writeByteArray(int i, byte[] bArr, int i2, int i3);

    public final void writeByteArrayNoTag(byte[] bArr) {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    public abstract void writeByteArrayNoTag(byte[] bArr, int i, int i2);

    public abstract void writeByteBuffer(int i, ByteBuffer byteBuffer);

    public abstract void writeBytes(int i, ByteString byteString);

    public abstract void writeBytesNoTag(ByteString byteString);

    public final void writeDouble(int i, double d) {
        writeFixed64(i, Double.doubleToRawLongBits(d));
    }

    public final void writeDoubleNoTag(double d) {
        writeFixed64NoTag(Double.doubleToRawLongBits(d));
    }

    public final void writeEnum(int i, int i2) {
        writeInt32(i, i2);
    }

    public final void writeEnumNoTag(int i) {
        writeInt32NoTag(i);
    }

    public abstract void writeFixed32(int i, int i2);

    public abstract void writeFixed32NoTag(int i);

    public abstract void writeFixed64(int i, long j);

    public abstract void writeFixed64NoTag(long j);

    public final void writeFloat(int i, float f) {
        writeFixed32(i, Float.floatToRawIntBits(f));
    }

    public final void writeFloatNoTag(float f) {
        writeFixed32NoTag(Float.floatToRawIntBits(f));
    }

    @Deprecated
    public final void writeGroup(int i, MessageLite messageLite) {
        writeTag(i, 3);
        writeGroupNoTag(messageLite);
        writeTag(i, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) {
        messageLite.mo4026writeTo(this);
    }

    public abstract void writeInt32(int i, int i2);

    public abstract void writeInt32NoTag(int i);

    public final void writeInt64(int i, long j) {
        writeUInt64(i, j);
    }

    public final void writeInt64NoTag(long j) {
        writeUInt64NoTag(j);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
    public abstract void writeLazy(ByteBuffer byteBuffer);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i, int i2);

    public abstract void writeMessage(int i, MessageLite messageLite);

    public abstract void writeMessage(int i, MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema);

    public abstract void writeMessageNoTag(MessageLite messageLite);

    public abstract void writeMessageNoTag(MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema);

    public abstract void writeMessageSetExtension(int i, MessageLite messageLite);

    public final void writeRawByte(byte b) {
        mo3922write(b);
    }

    public abstract void writeRawBytes(ByteBuffer byteBuffer);

    public final void writeRawBytes(byte[] bArr) {
        mo3924write(bArr, 0, bArr.length);
    }

    @InlineMe(replacement = "this.writeFixed32NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian32(int i) {
        writeFixed32NoTag(i);
    }

    @InlineMe(replacement = "this.writeFixed64NoTag(value)")
    @Deprecated
    public final void writeRawLittleEndian64(long j) {
        writeFixed64NoTag(j);
    }

    public abstract void writeRawMessageSetExtension(int i, ByteString byteString);

    @InlineMe(replacement = "this.writeUInt32NoTag(value)")
    @Deprecated
    public final void writeRawVarint32(int i) {
        writeUInt32NoTag(i);
    }

    @InlineMe(replacement = "this.writeUInt64NoTag(value)")
    @Deprecated
    public final void writeRawVarint64(long j) {
        writeUInt64NoTag(j);
    }

    public final void writeSFixed32(int i, int i2) {
        writeFixed32(i, i2);
    }

    public final void writeSFixed32NoTag(int i) {
        writeFixed32NoTag(i);
    }

    public final void writeSFixed64(int i, long j) {
        writeFixed64(i, j);
    }

    public final void writeSFixed64NoTag(long j) {
        writeFixed64NoTag(j);
    }

    public final void writeSInt32(int i, int i2) {
        writeUInt32(i, encodeZigZag32(i2));
    }

    public final void writeSInt32NoTag(int i) {
        writeUInt32NoTag(encodeZigZag32(i));
    }

    public final void writeSInt64(int i, long j) {
        writeUInt64(i, encodeZigZag64(j));
    }

    public final void writeSInt64NoTag(long j) {
        writeUInt64NoTag(encodeZigZag64(j));
    }

    public abstract void writeString(int i, String str);

    public abstract void writeStringNoTag(String str);

    public abstract void writeTag(int i, int i2);

    public abstract void writeUInt32(int i, int i2);

    public abstract void writeUInt32NoTag(int i);

    public abstract void writeUInt64(int i, long j);

    public abstract void writeUInt64NoTag(long j);

    private CodedOutputStream() {
    }

    @Deprecated
    public static int computeGroupSize(int i, MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) {
        return (computeTagSize(i) * 2) + computeGroupSizeNoTag(messageLite, interfaceC0777Schema);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(interfaceC0777Schema);
    }

    public static int computeMessageSize(int i, MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) {
        return computeTagSize(i) + computeMessageSizeNoTag(messageLite, interfaceC0777Schema);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(interfaceC0777Schema));
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i) {
        return new OutputStreamEncoder(outputStream, i);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) {
        interfaceC0777Schema.mo4094writeTo(messageLite, this.f3592wrapper);
    }

    public final void writeRawByte(int i) {
        mo3922write((byte) i);
    }

    public final void writeRawBytes(byte[] bArr, int i, int i2) {
        mo3924write(bArr, i, i2);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void writeRawBytes(ByteString byteString) {
        byteString.mo3945writeTo(this);
    }

    public static CodedOutputStream newInstance(byte[] bArr, int i, int i2) {
        return new ArrayEncoder(bArr, i, i2);
    }

    @Deprecated
    public final void writeGroup(int i, MessageLite messageLite, InterfaceC0777Schema interfaceC0777Schema) {
        writeTag(i, 3);
        writeGroupNoTag(messageLite, interfaceC0777Schema);
        writeTag(i, 4);
    }

    public static CodedOutputStream newInstance(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return new HeapNioEncoder(byteBuffer);
        }
        if (byteBuffer.isDirect() && !byteBuffer.isReadOnly()) {
            if (UnsafeDirectNioEncoder.isSupported()) {
                return newUnsafeInstance(byteBuffer);
            }
            return newSafeInstance(byteBuffer);
        }
        throw new IllegalArgumentException("ByteBuffer is read-only");
    }

    @Deprecated
    public static CodedOutputStream newInstance(ByteBuffer byteBuffer, int i) {
        return newInstance(byteBuffer);
    }

    public static CodedOutputStream newInstance(ByteOutput byteOutput, int i) {
        if (i >= 0) {
            return new ByteOutputEncoder(byteOutput, i);
        }
        throw new IllegalArgumentException("bufferSize must be positive");
    }
}
