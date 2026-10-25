package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0801Utf8;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MapEntryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.WireFormat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;

@CheckReturnValue
/* loaded from: classes.dex */
abstract class BinaryWriter extends ByteOutput implements InterfaceC0811Writer {
    public static final int DEFAULT_CHUNK_SIZE = 4096;
    private static final int MAP_KEY_NUMBER = 1;
    private static final int MAP_VALUE_NUMBER = 2;

    /* renamed from: alloc */
    private final BufferAllocator f3539alloc;

    /* renamed from: buffers */
    final ArrayDeque<AllocatedBuffer> f3540buffers;
    private final int chunkSize;
    int totalDoneBytes;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.BinaryWriter$1 */
    public static /* synthetic */ class C07201 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.m4187values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.f3817BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3821FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3822FIXED64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3825INT32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3826INT64.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3828SINT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3829SINT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3830STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3831UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3832UINT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3823FLOAT.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3819DOUBLE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3827MESSAGE.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3818BYTES.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3820ENUM.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public static final class SafeDirectWriter extends BinaryWriter {

        /* renamed from: buffer */
        private ByteBuffer f3541buffer;
        private int limitMinusOne;

        /* renamed from: pos */
        private int f3542pos;

        public SafeDirectWriter(BufferAllocator bufferAllocator, int i) {
            super(bufferAllocator, i, null);
            nextBuffer();
        }

        private int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.f3542pos;
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return this.f3542pos + 1;
        }

        private void writeVarint32FiveBytes(int i) {
            ByteBuffer byteBuffer = this.f3541buffer;
            int i2 = this.f3542pos;
            this.f3542pos = i2 - 1;
            byteBuffer.put(i2, (byte) (i >>> 28));
            int i3 = this.f3542pos;
            this.f3542pos = i3 - 4;
            this.f3541buffer.putInt(i3 - 3, (i & 127) | 128 | ((((i >>> 21) & 127) | 128) << 24) | ((((i >>> 14) & 127) | 128) << 16) | ((((i >>> 7) & 127) | 128) << 8));
        }

        private void writeVarint32FourBytes(int i) {
            int i2 = this.f3542pos;
            this.f3542pos = i2 - 4;
            this.f3541buffer.putInt(i2 - 3, (i & 127) | 128 | ((266338304 & i) << 3) | (((2080768 & i) | PKIFailureInfo.badSenderNonce) << 2) | (((i & 16256) | 16384) << 1));
        }

        private void writeVarint32OneByte(int i) {
            ByteBuffer byteBuffer = this.f3541buffer;
            int i2 = this.f3542pos;
            this.f3542pos = i2 - 1;
            byteBuffer.put(i2, (byte) i);
        }

        private void writeVarint32ThreeBytes(int i) {
            int i2 = this.f3542pos - 3;
            this.f3542pos = i2;
            this.f3541buffer.putInt(i2, (((i & 127) | 128) << 8) | ((2080768 & i) << 10) | (((i & 16256) | 16384) << 9));
        }

        private void writeVarint32TwoBytes(int i) {
            int i2 = this.f3542pos;
            this.f3542pos = i2 - 2;
            this.f3541buffer.putShort(i2 - 1, (short) ((i & 127) | 128 | ((i & 16256) << 1)));
        }

        private void writeVarint64EightBytes(long j) {
            int i = this.f3542pos;
            this.f3542pos = i - 8;
            this.f3541buffer.putLong(i - 7, (j & 127) | 128 | ((71494644084506624L & j) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | 2097152) << 2) | (((16256 & j) | 16384) << 1));
        }

        private void writeVarint64EightBytesWithSign(long j) {
            int i = this.f3542pos;
            this.f3542pos = i - 8;
            this.f3541buffer.putLong(i - 7, (j & 127) | 128 | (((71494644084506624L & j) | 72057594037927936L) << 7) | (((558551906910208L & j) | 562949953421312L) << 6) | (((4363686772736L & j) | 4398046511104L) << 5) | (((34091302912L & j) | 34359738368L) << 4) | (((266338304 & j) | 268435456) << 3) | (((2080768 & j) | 2097152) << 2) | (((16256 & j) | 16384) << 1));
        }

        private void writeVarint64FiveBytes(long j) {
            int i = this.f3542pos;
            this.f3542pos = i - 5;
            this.f3541buffer.putLong(i - 7, (((j & 127) | 128) << 24) | ((34091302912L & j) << 28) | (((266338304 & j) | 268435456) << 27) | (((2080768 & j) | 2097152) << 26) | (((16256 & j) | 16384) << 25));
        }

        private void writeVarint64FourBytes(long j) {
            writeVarint32FourBytes((int) j);
        }

        private void writeVarint64NineBytes(long j) {
            ByteBuffer byteBuffer = this.f3541buffer;
            int i = this.f3542pos;
            this.f3542pos = i - 1;
            byteBuffer.put(i, (byte) (j >>> 56));
            writeVarint64EightBytesWithSign(j & 72057594037927935L);
        }

        private void writeVarint64OneByte(long j) {
            writeVarint32OneByte((int) j);
        }

        private void writeVarint64SevenBytes(long j) {
            int i = this.f3542pos - 7;
            this.f3542pos = i;
            this.f3541buffer.putLong(i, (((j & 127) | 128) << 8) | ((558551906910208L & j) << 14) | (((4363686772736L & j) | 4398046511104L) << 13) | (((34091302912L & j) | 34359738368L) << 12) | (((266338304 & j) | 268435456) << 11) | (((2080768 & j) | 2097152) << 10) | (((16256 & j) | 16384) << 9));
        }

        private void writeVarint64SixBytes(long j) {
            int i = this.f3542pos;
            this.f3542pos = i - 6;
            this.f3541buffer.putLong(i - 7, (((j & 127) | 128) << 16) | ((4363686772736L & j) << 21) | (((34091302912L & j) | 34359738368L) << 20) | (((266338304 & j) | 268435456) << 19) | (((2080768 & j) | 2097152) << 18) | (((16256 & j) | 16384) << 17));
        }

        private void writeVarint64TenBytes(long j) {
            ByteBuffer byteBuffer = this.f3541buffer;
            int i = this.f3542pos;
            this.f3542pos = i - 1;
            byteBuffer.put(i, (byte) (j >>> 63));
            ByteBuffer byteBuffer2 = this.f3541buffer;
            int i2 = this.f3542pos;
            this.f3542pos = i2 - 1;
            byteBuffer2.put(i2, (byte) (((j >>> 56) & 127) | 128));
            writeVarint64EightBytesWithSign(j & 72057594037927935L);
        }

        private void writeVarint64ThreeBytes(long j) {
            writeVarint32ThreeBytes((int) j);
        }

        private void writeVarint64TwoBytes(long j) {
            writeVarint32TwoBytes((int) j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.f3541buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.f3541buffer.position(this.f3542pos + 1);
                this.f3541buffer = null;
                this.f3542pos = 0;
                this.limitMinusOne = 0;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void requireSpace(int i) {
            if (spaceLeft() < i) {
                nextBuffer(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3922write(byte b) {
            ByteBuffer byteBuffer = this.f3541buffer;
            int i = this.f3542pos;
            this.f3542pos = i - 1;
            byteBuffer.put(i, b);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeBool(int i, boolean z) {
            requireSpace(6);
            mo3922write(z ? (byte) 1 : (byte) 0);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeBytes(int i, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.mo3944size());
                writeTag(i, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        @Deprecated
        public void writeEndGroup(int i) {
            writeTag(i, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeFixed32(int i, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(i, 5);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeFixed64(int i, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i, 1);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        @Deprecated
        public void writeGroup(int i, Object obj) {
            writeTag(i, 4);
            Protobuf.getInstance().m4119writeTo(obj, this);
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeInt32(int i, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.f3540buffers.addFirst(AllocatedBuffer.m3911wrap(bArr, i, i2));
                nextBuffer();
            } else {
                int i3 = this.f3542pos - i2;
                this.f3542pos = i3;
                this.f3541buffer.position(i3 + 1);
                this.f3541buffer.put(bArr, i, i2);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeMessage(int i, Object obj) {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().m4119writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeSInt32(int i, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeSInt64(int i, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        @Deprecated
        public void writeStartGroup(int i) {
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeString(int i, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeTag(int i, int i2) {
            writeVarint32(WireFormat.m4185makeTag(i, i2));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeUInt32(int i, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeUInt64(int i, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeVarint32(int i) {
            if ((i & (-128)) == 0) {
                writeVarint32OneByte(i);
                return;
            }
            if ((i & (-16384)) == 0) {
                writeVarint32TwoBytes(i);
                return;
            }
            if (((-2097152) & i) == 0) {
                writeVarint32ThreeBytes(i);
            } else if (((-268435456) & i) == 0) {
                writeVarint32FourBytes(i);
            } else {
                writeVarint32FiveBytes(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    break;
                case 2:
                    writeVarint64TwoBytes(j);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j);
                    break;
                case 4:
                    writeVarint64FourBytes(j);
                    break;
                case 5:
                    writeVarint64FiveBytes(j);
                    break;
                case 6:
                    writeVarint64SixBytes(j);
                    break;
                case 7:
                    writeVarint64SevenBytes(j);
                    break;
                case 8:
                    writeVarint64EightBytes(j);
                    break;
                case 9:
                    writeVarint64NineBytes(j);
                    break;
                case 10:
                    writeVarint64TenBytes(j);
                    break;
            }
        }

        private void nextBuffer(int i) {
            nextBuffer(newDirectBuffer(i));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3924write(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
            int i3 = this.f3542pos - i2;
            this.f3542pos = i3;
            this.f3541buffer.position(i3 + 1);
            this.f3541buffer.put(bArr, i, i2);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer byteBufferNioBuffer = allocatedBuffer.nioBuffer();
                if (byteBufferNioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.f3540buffers.addFirst(allocatedBuffer);
                    this.f3541buffer = byteBufferNioBuffer;
                    byteBufferNioBuffer.limit(byteBufferNioBuffer.capacity());
                    this.f3541buffer.position(0);
                    this.f3541buffer.order(ByteOrder.LITTLE_ENDIAN);
                    int iLimit = this.f3541buffer.limit() - 1;
                    this.limitMinusOne = iLimit;
                    this.f3542pos = iLimit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeBool(boolean z) {
            mo3922write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeFixed32(int i) {
            int i2 = this.f3542pos;
            this.f3542pos = i2 - 4;
            this.f3541buffer.putInt(i2 - 3, i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeFixed64(long j) {
            int i = this.f3542pos;
            this.f3542pos = i - 8;
            this.f3541buffer.putLong(i - 7, j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeGroup(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
            writeTag(i, 4);
            interfaceC0777Schema.mo4094writeTo(obj, this);
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeInt32(int i) {
            if (i >= 0) {
                writeVarint32(i);
            } else {
                writeVarint64(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeSInt32(int i) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3923write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                nextBuffer(iRemaining);
            }
            int i = this.f3542pos - iRemaining;
            this.f3542pos = i;
            this.f3541buffer.position(i + 1);
            this.f3541buffer.put(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeMessage(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
            int totalBytesWritten = getTotalBytesWritten();
            interfaceC0777Schema.mo4094writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeString(String str) {
            int i;
            int i2;
            int i3;
            char cCharAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.f3542pos -= length;
            while (length >= 0 && (cCharAt = str.charAt(length)) < 128) {
                this.f3541buffer.put(this.f3542pos + length, (byte) cCharAt);
                length--;
            }
            if (length == -1) {
                this.f3542pos--;
                return;
            }
            this.f3542pos += length;
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128 && (i3 = this.f3542pos) >= 0) {
                    ByteBuffer byteBuffer = this.f3541buffer;
                    this.f3542pos = i3 - 1;
                    byteBuffer.put(i3, (byte) cCharAt2);
                } else if (cCharAt2 < 2048 && (i2 = this.f3542pos) > 0) {
                    ByteBuffer byteBuffer2 = this.f3541buffer;
                    this.f3542pos = i2 - 1;
                    byteBuffer2.put(i2, (byte) ((cCharAt2 & '?') | 128));
                    ByteBuffer byteBuffer3 = this.f3541buffer;
                    int i4 = this.f3542pos;
                    this.f3542pos = i4 - 1;
                    byteBuffer3.put(i4, (byte) ((cCharAt2 >>> 6) | 960));
                } else if ((cCharAt2 < 55296 || 57343 < cCharAt2) && (i = this.f3542pos) > 1) {
                    ByteBuffer byteBuffer4 = this.f3541buffer;
                    this.f3542pos = i - 1;
                    byteBuffer4.put(i, (byte) ((cCharAt2 & '?') | 128));
                    ByteBuffer byteBuffer5 = this.f3541buffer;
                    int i5 = this.f3542pos;
                    this.f3542pos = i5 - 1;
                    byteBuffer5.put(i5, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                    ByteBuffer byteBuffer6 = this.f3541buffer;
                    int i6 = this.f3542pos;
                    this.f3542pos = i6 - 1;
                    byteBuffer6.put(i6, (byte) ((cCharAt2 >>> '\f') | 480));
                } else {
                    if (this.f3542pos > 2) {
                        if (length != 0) {
                            char cCharAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                ByteBuffer byteBuffer7 = this.f3541buffer;
                                int i7 = this.f3542pos;
                                this.f3542pos = i7 - 1;
                                byteBuffer7.put(i7, (byte) ((codePoint & 63) | 128));
                                ByteBuffer byteBuffer8 = this.f3541buffer;
                                int i8 = this.f3542pos;
                                this.f3542pos = i8 - 1;
                                byteBuffer8.put(i8, (byte) (((codePoint >>> 6) & 63) | 128));
                                ByteBuffer byteBuffer9 = this.f3541buffer;
                                int i9 = this.f3542pos;
                                this.f3542pos = i9 - 1;
                                byteBuffer9.put(i9, (byte) (((codePoint >>> 12) & 63) | 128));
                                ByteBuffer byteBuffer10 = this.f3541buffer;
                                int i10 = this.f3542pos;
                                this.f3542pos = i10 - 1;
                                byteBuffer10.put(i10, (byte) ((codePoint >>> 18) | 240));
                            }
                        }
                        throw new C0801Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.f3540buffers.addFirst(AllocatedBuffer.m3909wrap(byteBuffer));
                nextBuffer();
            } else {
                int i = this.f3542pos - iRemaining;
                this.f3542pos = i;
                this.f3541buffer.position(i + 1);
                this.f3541buffer.put(byteBuffer);
            }
        }
    }

    public static final class SafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;

        /* renamed from: buffer */
        private byte[] f3543buffer;

        /* renamed from: limit */
        private int f3544limit;
        private int limitMinusOne;

        /* renamed from: offset */
        private int f3545offset;
        private int offsetMinusOne;

        /* renamed from: pos */
        private int f3546pos;

        public SafeHeapWriter(BufferAllocator bufferAllocator, int i) {
            super(bufferAllocator, i, null);
            nextBuffer();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i) {
            byte[] bArr = this.f3543buffer;
            int i2 = this.f3546pos;
            int i3 = i2 - 1;
            this.f3546pos = i3;
            bArr[i2] = (byte) (i >>> 28);
            int i4 = i2 - 2;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((i >>> 21) & 127) | 128);
            int i5 = i2 - 3;
            this.f3546pos = i5;
            bArr[i4] = (byte) (((i >>> 14) & 127) | 128);
            int i6 = i2 - 4;
            this.f3546pos = i6;
            bArr[i5] = (byte) (((i >>> 7) & 127) | 128);
            this.f3546pos = i2 - 5;
            bArr[i6] = (byte) ((i & 127) | 128);
        }

        private void writeVarint32FourBytes(int i) {
            byte[] bArr = this.f3543buffer;
            int i2 = this.f3546pos;
            int i3 = i2 - 1;
            this.f3546pos = i3;
            bArr[i2] = (byte) (i >>> 21);
            int i4 = i2 - 2;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((i >>> 14) & 127) | 128);
            int i5 = i2 - 3;
            this.f3546pos = i5;
            bArr[i4] = (byte) (((i >>> 7) & 127) | 128);
            this.f3546pos = i2 - 4;
            bArr[i5] = (byte) ((i & 127) | 128);
        }

        private void writeVarint32OneByte(int i) {
            byte[] bArr = this.f3543buffer;
            int i2 = this.f3546pos;
            this.f3546pos = i2 - 1;
            bArr[i2] = (byte) i;
        }

        private void writeVarint32ThreeBytes(int i) {
            byte[] bArr = this.f3543buffer;
            int i2 = this.f3546pos;
            int i3 = i2 - 1;
            this.f3546pos = i3;
            bArr[i2] = (byte) (i >>> 14);
            int i4 = i2 - 2;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((i >>> 7) & 127) | 128);
            this.f3546pos = i2 - 3;
            bArr[i4] = (byte) ((i & 127) | 128);
        }

        private void writeVarint32TwoBytes(int i) {
            byte[] bArr = this.f3543buffer;
            int i2 = this.f3546pos;
            int i3 = i2 - 1;
            this.f3546pos = i3;
            bArr[i2] = (byte) (i >>> 7);
            this.f3546pos = i2 - 2;
            bArr[i3] = (byte) ((i & 127) | 128);
        }

        private void writeVarint64EightBytes(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (j >>> 49);
            int i3 = i - 2;
            this.f3546pos = i3;
            bArr[i2] = (byte) (((j >>> 42) & 127) | 128);
            int i4 = i - 3;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((j >>> 35) & 127) | 128);
            int i5 = i - 4;
            this.f3546pos = i5;
            bArr[i4] = (byte) (((j >>> 28) & 127) | 128);
            int i6 = i - 5;
            this.f3546pos = i6;
            bArr[i5] = (byte) (((j >>> 21) & 127) | 128);
            int i7 = i - 6;
            this.f3546pos = i7;
            bArr[i6] = (byte) (((j >>> 14) & 127) | 128);
            int i8 = i - 7;
            this.f3546pos = i8;
            bArr[i7] = (byte) (((j >>> 7) & 127) | 128);
            this.f3546pos = i - 8;
            bArr[i8] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64FiveBytes(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (j >>> 28);
            int i3 = i - 2;
            this.f3546pos = i3;
            bArr[i2] = (byte) (((j >>> 21) & 127) | 128);
            int i4 = i - 3;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((j >>> 14) & 127) | 128);
            int i5 = i - 4;
            this.f3546pos = i5;
            bArr[i4] = (byte) (((j >>> 7) & 127) | 128);
            this.f3546pos = i - 5;
            bArr[i5] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64FourBytes(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (j >>> 21);
            int i3 = i - 2;
            this.f3546pos = i3;
            bArr[i2] = (byte) (((j >>> 14) & 127) | 128);
            int i4 = i - 3;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((j >>> 7) & 127) | 128);
            this.f3546pos = i - 4;
            bArr[i4] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64NineBytes(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (j >>> 56);
            int i3 = i - 2;
            this.f3546pos = i3;
            bArr[i2] = (byte) (((j >>> 49) & 127) | 128);
            int i4 = i - 3;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((j >>> 42) & 127) | 128);
            int i5 = i - 4;
            this.f3546pos = i5;
            bArr[i4] = (byte) (((j >>> 35) & 127) | 128);
            int i6 = i - 5;
            this.f3546pos = i6;
            bArr[i5] = (byte) (((j >>> 28) & 127) | 128);
            int i7 = i - 6;
            this.f3546pos = i7;
            bArr[i6] = (byte) (((j >>> 21) & 127) | 128);
            int i8 = i - 7;
            this.f3546pos = i8;
            bArr[i7] = (byte) (((j >>> 14) & 127) | 128);
            int i9 = i - 8;
            this.f3546pos = i9;
            bArr[i8] = (byte) (((j >>> 7) & 127) | 128);
            this.f3546pos = i - 9;
            bArr[i9] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64OneByte(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            this.f3546pos = i - 1;
            bArr[i] = (byte) j;
        }

        private void writeVarint64SevenBytes(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (j >>> 42);
            int i3 = i - 2;
            this.f3546pos = i3;
            bArr[i2] = (byte) (((j >>> 35) & 127) | 128);
            int i4 = i - 3;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((j >>> 28) & 127) | 128);
            int i5 = i - 4;
            this.f3546pos = i5;
            bArr[i4] = (byte) (((j >>> 21) & 127) | 128);
            int i6 = i - 5;
            this.f3546pos = i6;
            bArr[i5] = (byte) (((j >>> 14) & 127) | 128);
            int i7 = i - 6;
            this.f3546pos = i7;
            bArr[i6] = (byte) (((j >>> 7) & 127) | 128);
            this.f3546pos = i - 7;
            bArr[i7] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64SixBytes(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (j >>> 35);
            int i3 = i - 2;
            this.f3546pos = i3;
            bArr[i2] = (byte) (((j >>> 28) & 127) | 128);
            int i4 = i - 3;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((j >>> 21) & 127) | 128);
            int i5 = i - 4;
            this.f3546pos = i5;
            bArr[i4] = (byte) (((j >>> 14) & 127) | 128);
            int i6 = i - 5;
            this.f3546pos = i6;
            bArr[i5] = (byte) (((j >>> 7) & 127) | 128);
            this.f3546pos = i - 6;
            bArr[i6] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64TenBytes(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (j >>> 63);
            int i3 = i - 2;
            this.f3546pos = i3;
            bArr[i2] = (byte) (((j >>> 56) & 127) | 128);
            int i4 = i - 3;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((j >>> 49) & 127) | 128);
            int i5 = i - 4;
            this.f3546pos = i5;
            bArr[i4] = (byte) (((j >>> 42) & 127) | 128);
            int i6 = i - 5;
            this.f3546pos = i6;
            bArr[i5] = (byte) (((j >>> 35) & 127) | 128);
            int i7 = i - 6;
            this.f3546pos = i7;
            bArr[i6] = (byte) (((j >>> 28) & 127) | 128);
            int i8 = i - 7;
            this.f3546pos = i8;
            bArr[i7] = (byte) (((j >>> 21) & 127) | 128);
            int i9 = i - 8;
            this.f3546pos = i9;
            bArr[i8] = (byte) (((j >>> 14) & 127) | 128);
            int i10 = i - 9;
            this.f3546pos = i10;
            bArr[i9] = (byte) (((j >>> 7) & 127) | 128);
            this.f3546pos = i - 10;
            bArr[i10] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64ThreeBytes(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (((int) j) >>> 14);
            int i3 = i - 2;
            this.f3546pos = i3;
            bArr[i2] = (byte) (((j >>> 7) & 127) | 128);
            this.f3546pos = i - 3;
            bArr[i3] = (byte) ((j & 127) | 128);
        }

        private void writeVarint64TwoBytes(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (j >>> 7);
            this.f3546pos = i - 2;
            bArr[i2] = (byte) ((((int) j) & 127) | 128);
        }

        public int bytesWrittenToCurrentBuffer() {
            return this.limitMinusOne - this.f3546pos;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                AllocatedBuffer allocatedBuffer = this.allocatedBuffer;
                allocatedBuffer.position((this.f3546pos - allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.f3546pos = 0;
                this.limitMinusOne = 0;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void requireSpace(int i) {
            if (spaceLeft() < i) {
                nextBuffer(i);
            }
        }

        public int spaceLeft() {
            return this.f3546pos - this.offsetMinusOne;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3922write(byte b) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            this.f3546pos = i - 1;
            bArr[i] = b;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeBool(int i, boolean z) {
            requireSpace(6);
            mo3922write(z ? (byte) 1 : (byte) 0);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeBytes(int i, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.mo3944size());
                writeTag(i, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeEndGroup(int i) {
            writeTag(i, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeFixed32(int i, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(i, 5);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeFixed64(int i, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i, 1);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        @Deprecated
        public void writeGroup(int i, Object obj) {
            writeTag(i, 4);
            Protobuf.getInstance().m4119writeTo(obj, this);
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeInt32(int i, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.f3540buffers.addFirst(AllocatedBuffer.m3911wrap(bArr, i, i2));
                nextBuffer();
            } else {
                int i3 = this.f3546pos - i2;
                this.f3546pos = i3;
                System.arraycopy(bArr, i, this.f3543buffer, i3 + 1, i2);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeMessage(int i, Object obj) {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().m4119writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeSInt32(int i, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeSInt64(int i, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeStartGroup(int i) {
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeString(int i, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeTag(int i, int i2) {
            writeVarint32(WireFormat.m4185makeTag(i, i2));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeUInt32(int i, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeUInt64(int i, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeVarint32(int i) {
            if ((i & (-128)) == 0) {
                writeVarint32OneByte(i);
                return;
            }
            if ((i & (-16384)) == 0) {
                writeVarint32TwoBytes(i);
                return;
            }
            if (((-2097152) & i) == 0) {
                writeVarint32ThreeBytes(i);
            } else if (((-268435456) & i) == 0) {
                writeVarint32FourBytes(i);
            } else {
                writeVarint32FiveBytes(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    break;
                case 2:
                    writeVarint64TwoBytes(j);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j);
                    break;
                case 4:
                    writeVarint64FourBytes(j);
                    break;
                case 5:
                    writeVarint64FiveBytes(j);
                    break;
                case 6:
                    writeVarint64SixBytes(j);
                    break;
                case 7:
                    writeVarint64SevenBytes(j);
                    break;
                case 8:
                    writeVarint64EightBytes(j);
                    break;
                case 9:
                    writeVarint64NineBytes(j);
                    break;
                case 10:
                    writeVarint64TenBytes(j);
                    break;
            }
        }

        private void nextBuffer(int i) {
            nextBuffer(newHeapBuffer(i));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3924write(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
            int i3 = this.f3546pos - i2;
            this.f3546pos = i3;
            System.arraycopy(bArr, i, this.f3543buffer, i3 + 1, i2);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray()) {
                finishCurrentBuffer();
                this.f3540buffers.addFirst(allocatedBuffer);
                this.allocatedBuffer = allocatedBuffer;
                this.f3543buffer = allocatedBuffer.mo3912array();
                int iArrayOffset = allocatedBuffer.arrayOffset();
                this.f3544limit = allocatedBuffer.mo3913limit() + iArrayOffset;
                int iPosition = iArrayOffset + allocatedBuffer.position();
                this.f3545offset = iPosition;
                this.offsetMinusOne = iPosition - 1;
                int i = this.f3544limit - 1;
                this.limitMinusOne = i;
                this.f3546pos = i;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeBool(boolean z) {
            mo3922write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeFixed32(int i) {
            byte[] bArr = this.f3543buffer;
            int i2 = this.f3546pos;
            int i3 = i2 - 1;
            this.f3546pos = i3;
            bArr[i2] = (byte) ((i >> 24) & 255);
            int i4 = i2 - 2;
            this.f3546pos = i4;
            bArr[i3] = (byte) ((i >> 16) & 255);
            int i5 = i2 - 3;
            this.f3546pos = i5;
            bArr[i4] = (byte) ((i >> 8) & 255);
            this.f3546pos = i2 - 4;
            bArr[i5] = (byte) (i & 255);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeFixed64(long j) {
            byte[] bArr = this.f3543buffer;
            int i = this.f3546pos;
            int i2 = i - 1;
            this.f3546pos = i2;
            bArr[i] = (byte) (((int) (j >> 56)) & 255);
            int i3 = i - 2;
            this.f3546pos = i3;
            bArr[i2] = (byte) (((int) (j >> 48)) & 255);
            int i4 = i - 3;
            this.f3546pos = i4;
            bArr[i3] = (byte) (((int) (j >> 40)) & 255);
            int i5 = i - 4;
            this.f3546pos = i5;
            bArr[i4] = (byte) (((int) (j >> 32)) & 255);
            int i6 = i - 5;
            this.f3546pos = i6;
            bArr[i5] = (byte) (((int) (j >> 24)) & 255);
            int i7 = i - 6;
            this.f3546pos = i7;
            bArr[i6] = (byte) (((int) (j >> 16)) & 255);
            int i8 = i - 7;
            this.f3546pos = i8;
            bArr[i7] = (byte) (((int) (j >> 8)) & 255);
            this.f3546pos = i - 8;
            bArr[i8] = (byte) (((int) j) & 255);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeGroup(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
            writeTag(i, 4);
            interfaceC0777Schema.mo4094writeTo(obj, this);
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeInt32(int i) {
            if (i >= 0) {
                writeVarint32(i);
            } else {
                writeVarint64(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeSInt32(int i) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3923write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                nextBuffer(iRemaining);
            }
            int i = this.f3546pos - iRemaining;
            this.f3546pos = i;
            byteBuffer.get(this.f3543buffer, i + 1, iRemaining);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.f3540buffers.addFirst(AllocatedBuffer.m3909wrap(byteBuffer));
                nextBuffer();
            }
            int i = this.f3546pos - iRemaining;
            this.f3546pos = i;
            byteBuffer.get(this.f3543buffer, i + 1, iRemaining);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeMessage(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
            int totalBytesWritten = getTotalBytesWritten();
            interfaceC0777Schema.mo4094writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeString(String str) {
            int i;
            int i2;
            int i3;
            char cCharAt;
            requireSpace(str.length());
            int length = str.length() - 1;
            this.f3546pos -= length;
            while (length >= 0 && (cCharAt = str.charAt(length)) < 128) {
                this.f3543buffer[this.f3546pos + length] = (byte) cCharAt;
                length--;
            }
            if (length == -1) {
                this.f3546pos--;
                return;
            }
            this.f3546pos += length;
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128 && (i3 = this.f3546pos) > this.offsetMinusOne) {
                    byte[] bArr = this.f3543buffer;
                    this.f3546pos = i3 - 1;
                    bArr[i3] = (byte) cCharAt2;
                } else if (cCharAt2 < 2048 && (i2 = this.f3546pos) > this.f3545offset) {
                    byte[] bArr2 = this.f3543buffer;
                    int i4 = i2 - 1;
                    this.f3546pos = i4;
                    bArr2[i2] = (byte) ((cCharAt2 & '?') | 128);
                    this.f3546pos = i2 - 2;
                    bArr2[i4] = (byte) ((cCharAt2 >>> 6) | 960);
                } else if ((cCharAt2 < 55296 || 57343 < cCharAt2) && (i = this.f3546pos) > this.f3545offset + 1) {
                    byte[] bArr3 = this.f3543buffer;
                    int i5 = i - 1;
                    this.f3546pos = i5;
                    bArr3[i] = (byte) ((cCharAt2 & '?') | 128);
                    int i6 = i - 2;
                    this.f3546pos = i6;
                    bArr3[i5] = (byte) (((cCharAt2 >>> 6) & 63) | 128);
                    this.f3546pos = i - 3;
                    bArr3[i6] = (byte) ((cCharAt2 >>> '\f') | 480);
                } else {
                    if (this.f3546pos > this.f3545offset + 2) {
                        if (length != 0) {
                            char cCharAt3 = str.charAt(length - 1);
                            if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                length--;
                                int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                byte[] bArr4 = this.f3543buffer;
                                int i7 = this.f3546pos;
                                int i8 = i7 - 1;
                                this.f3546pos = i8;
                                bArr4[i7] = (byte) ((codePoint & 63) | 128);
                                int i9 = i7 - 2;
                                this.f3546pos = i9;
                                bArr4[i8] = (byte) (((codePoint >>> 6) & 63) | 128);
                                int i10 = i7 - 3;
                                this.f3546pos = i10;
                                bArr4[i9] = (byte) (((codePoint >>> 12) & 63) | 128);
                                this.f3546pos = i7 - 4;
                                bArr4[i10] = (byte) ((codePoint >>> 18) | 240);
                            }
                        }
                        throw new C0801Utf8.UnpairedSurrogateException(length - 1, length);
                    }
                    requireSpace(length);
                    length++;
                }
                length--;
            }
        }
    }

    public static final class UnsafeDirectWriter extends BinaryWriter {

        /* renamed from: buffer */
        private ByteBuffer f3547buffer;
        private long bufferOffset;
        private long limitMinusOne;

        /* renamed from: pos */
        private long f3548pos;

        public UnsafeDirectWriter(BufferAllocator bufferAllocator, int i) {
            super(bufferAllocator, i, null);
            nextBuffer();
        }

        private int bufferPos() {
            return (int) (this.f3548pos - this.bufferOffset);
        }

        private int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.f3548pos);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void nextBuffer() {
            nextBuffer(newDirectBuffer());
        }

        private int spaceLeft() {
            return bufferPos() + 1;
        }

        private void writeVarint32FiveBytes(int i) {
            long j = this.f3548pos;
            this.f3548pos = j - 1;
            UnsafeUtil.m4159putByte(j, (byte) (i >>> 28));
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (((i >>> 21) & 127) | 128));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((i >>> 14) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (((i >>> 7) & 127) | 128));
            long j5 = this.f3548pos;
            this.f3548pos = j5 - 1;
            UnsafeUtil.m4159putByte(j5, (byte) ((i & 127) | 128));
        }

        private void writeVarint32FourBytes(int i) {
            long j = this.f3548pos;
            this.f3548pos = j - 1;
            UnsafeUtil.m4159putByte(j, (byte) (i >>> 21));
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (((i >>> 14) & 127) | 128));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((i >>> 7) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) ((i & 127) | 128));
        }

        private void writeVarint32OneByte(int i) {
            long j = this.f3548pos;
            this.f3548pos = j - 1;
            UnsafeUtil.m4159putByte(j, (byte) i);
        }

        private void writeVarint32ThreeBytes(int i) {
            long j = this.f3548pos;
            this.f3548pos = j - 1;
            UnsafeUtil.m4159putByte(j, (byte) (i >>> 14));
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (((i >>> 7) & 127) | 128));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) ((i & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i) {
            long j = this.f3548pos;
            this.f3548pos = j - 1;
            UnsafeUtil.m4159putByte(j, (byte) (i >>> 7));
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) ((i & 127) | 128));
        }

        private void writeVarint64EightBytes(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (j >>> 49));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((j >>> 42) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (((j >>> 35) & 127) | 128));
            long j5 = this.f3548pos;
            this.f3548pos = j5 - 1;
            UnsafeUtil.m4159putByte(j5, (byte) (((j >>> 28) & 127) | 128));
            long j6 = this.f3548pos;
            this.f3548pos = j6 - 1;
            UnsafeUtil.m4159putByte(j6, (byte) (((j >>> 21) & 127) | 128));
            long j7 = this.f3548pos;
            this.f3548pos = j7 - 1;
            UnsafeUtil.m4159putByte(j7, (byte) (((j >>> 14) & 127) | 128));
            long j8 = this.f3548pos;
            this.f3548pos = j8 - 1;
            UnsafeUtil.m4159putByte(j8, (byte) (((j >>> 7) & 127) | 128));
            long j9 = this.f3548pos;
            this.f3548pos = j9 - 1;
            UnsafeUtil.m4159putByte(j9, (byte) ((j & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (j >>> 28));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((j >>> 21) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (((j >>> 14) & 127) | 128));
            long j5 = this.f3548pos;
            this.f3548pos = j5 - 1;
            UnsafeUtil.m4159putByte(j5, (byte) (((j >>> 7) & 127) | 128));
            long j6 = this.f3548pos;
            this.f3548pos = j6 - 1;
            UnsafeUtil.m4159putByte(j6, (byte) ((j & 127) | 128));
        }

        private void writeVarint64FourBytes(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (j >>> 21));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((j >>> 14) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (((j >>> 7) & 127) | 128));
            long j5 = this.f3548pos;
            this.f3548pos = j5 - 1;
            UnsafeUtil.m4159putByte(j5, (byte) ((j & 127) | 128));
        }

        private void writeVarint64NineBytes(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (j >>> 56));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((j >>> 49) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (((j >>> 42) & 127) | 128));
            long j5 = this.f3548pos;
            this.f3548pos = j5 - 1;
            UnsafeUtil.m4159putByte(j5, (byte) (((j >>> 35) & 127) | 128));
            long j6 = this.f3548pos;
            this.f3548pos = j6 - 1;
            UnsafeUtil.m4159putByte(j6, (byte) (((j >>> 28) & 127) | 128));
            long j7 = this.f3548pos;
            this.f3548pos = j7 - 1;
            UnsafeUtil.m4159putByte(j7, (byte) (((j >>> 21) & 127) | 128));
            long j8 = this.f3548pos;
            this.f3548pos = j8 - 1;
            UnsafeUtil.m4159putByte(j8, (byte) (((j >>> 14) & 127) | 128));
            long j9 = this.f3548pos;
            this.f3548pos = j9 - 1;
            UnsafeUtil.m4159putByte(j9, (byte) (((j >>> 7) & 127) | 128));
            long j10 = this.f3548pos;
            this.f3548pos = j10 - 1;
            UnsafeUtil.m4159putByte(j10, (byte) ((j & 127) | 128));
        }

        private void writeVarint64OneByte(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) j);
        }

        private void writeVarint64SevenBytes(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (j >>> 42));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((j >>> 35) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (((j >>> 28) & 127) | 128));
            long j5 = this.f3548pos;
            this.f3548pos = j5 - 1;
            UnsafeUtil.m4159putByte(j5, (byte) (((j >>> 21) & 127) | 128));
            long j6 = this.f3548pos;
            this.f3548pos = j6 - 1;
            UnsafeUtil.m4159putByte(j6, (byte) (((j >>> 14) & 127) | 128));
            long j7 = this.f3548pos;
            this.f3548pos = j7 - 1;
            UnsafeUtil.m4159putByte(j7, (byte) (((j >>> 7) & 127) | 128));
            long j8 = this.f3548pos;
            this.f3548pos = j8 - 1;
            UnsafeUtil.m4159putByte(j8, (byte) ((j & 127) | 128));
        }

        private void writeVarint64SixBytes(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (j >>> 35));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((j >>> 28) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (((j >>> 21) & 127) | 128));
            long j5 = this.f3548pos;
            this.f3548pos = j5 - 1;
            UnsafeUtil.m4159putByte(j5, (byte) (((j >>> 14) & 127) | 128));
            long j6 = this.f3548pos;
            this.f3548pos = j6 - 1;
            UnsafeUtil.m4159putByte(j6, (byte) (((j >>> 7) & 127) | 128));
            long j7 = this.f3548pos;
            this.f3548pos = j7 - 1;
            UnsafeUtil.m4159putByte(j7, (byte) ((j & 127) | 128));
        }

        private void writeVarint64TenBytes(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (j >>> 63));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((j >>> 56) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (((j >>> 49) & 127) | 128));
            long j5 = this.f3548pos;
            this.f3548pos = j5 - 1;
            UnsafeUtil.m4159putByte(j5, (byte) (((j >>> 42) & 127) | 128));
            long j6 = this.f3548pos;
            this.f3548pos = j6 - 1;
            UnsafeUtil.m4159putByte(j6, (byte) (((j >>> 35) & 127) | 128));
            long j7 = this.f3548pos;
            this.f3548pos = j7 - 1;
            UnsafeUtil.m4159putByte(j7, (byte) (((j >>> 28) & 127) | 128));
            long j8 = this.f3548pos;
            this.f3548pos = j8 - 1;
            UnsafeUtil.m4159putByte(j8, (byte) (((j >>> 21) & 127) | 128));
            long j9 = this.f3548pos;
            this.f3548pos = j9 - 1;
            UnsafeUtil.m4159putByte(j9, (byte) (((j >>> 14) & 127) | 128));
            long j10 = this.f3548pos;
            this.f3548pos = j10 - 1;
            UnsafeUtil.m4159putByte(j10, (byte) (((j >>> 7) & 127) | 128));
            long j11 = this.f3548pos;
            this.f3548pos = j11 - 1;
            UnsafeUtil.m4159putByte(j11, (byte) ((j & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (((int) j) >>> 14));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((j >>> 7) & 127) | 128));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) ((j & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (j >>> 7));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) ((((int) j) & 127) | 128));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.f3547buffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.f3547buffer.position(bufferPos() + 1);
                this.f3547buffer = null;
                this.f3548pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void requireSpace(int i) {
            if (spaceLeft() < i) {
                nextBuffer(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3922write(byte b) {
            long j = this.f3548pos;
            this.f3548pos = j - 1;
            UnsafeUtil.m4159putByte(j, b);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeBool(int i, boolean z) {
            requireSpace(6);
            mo3922write(z ? (byte) 1 : (byte) 0);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeBytes(int i, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.mo3944size());
                writeTag(i, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        @Deprecated
        public void writeEndGroup(int i) {
            writeTag(i, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeFixed32(int i, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(i, 5);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeFixed64(int i, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i, 1);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeGroup(int i, Object obj) {
            writeTag(i, 4);
            Protobuf.getInstance().m4119writeTo(obj, this);
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeInt32(int i, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                this.totalDoneBytes += i2;
                this.f3540buffers.addFirst(AllocatedBuffer.m3911wrap(bArr, i, i2));
                nextBuffer();
            } else {
                this.f3548pos -= i2;
                this.f3547buffer.position(bufferPos() + 1);
                this.f3547buffer.put(bArr, i, i2);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeMessage(int i, Object obj) {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().m4119writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeSInt32(int i, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeSInt64(int i, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        @Deprecated
        public void writeStartGroup(int i) {
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeString(int i, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeTag(int i, int i2) {
            writeVarint32(WireFormat.m4185makeTag(i, i2));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeUInt32(int i, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeUInt64(int i, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeVarint32(int i) {
            if ((i & (-128)) == 0) {
                writeVarint32OneByte(i);
                return;
            }
            if ((i & (-16384)) == 0) {
                writeVarint32TwoBytes(i);
                return;
            }
            if (((-2097152) & i) == 0) {
                writeVarint32ThreeBytes(i);
            } else if (((-268435456) & i) == 0) {
                writeVarint32FourBytes(i);
            } else {
                writeVarint32FiveBytes(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    break;
                case 2:
                    writeVarint64TwoBytes(j);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j);
                    break;
                case 4:
                    writeVarint64FourBytes(j);
                    break;
                case 5:
                    writeVarint64FiveBytes(j);
                    break;
                case 6:
                    writeVarint64SixBytes(j);
                    break;
                case 7:
                    writeVarint64SevenBytes(j);
                    break;
                case 8:
                    writeVarint64EightBytes(j);
                    break;
                case 9:
                    writeVarint64NineBytes(j);
                    break;
                case 10:
                    writeVarint64TenBytes(j);
                    break;
            }
        }

        private void nextBuffer(int i) {
            nextBuffer(newDirectBuffer(i));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3924write(byte[] bArr, int i, int i2) {
            if (spaceLeft() < i2) {
                nextBuffer(i2);
            }
            this.f3548pos -= i2;
            this.f3547buffer.position(bufferPos() + 1);
            this.f3547buffer.put(bArr, i, i2);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasNioBuffer()) {
                ByteBuffer byteBufferNioBuffer = allocatedBuffer.nioBuffer();
                if (byteBufferNioBuffer.isDirect()) {
                    finishCurrentBuffer();
                    this.f3540buffers.addFirst(allocatedBuffer);
                    this.f3547buffer = byteBufferNioBuffer;
                    byteBufferNioBuffer.limit(byteBufferNioBuffer.capacity());
                    this.f3547buffer.position(0);
                    long jAddressOffset = UnsafeUtil.addressOffset(this.f3547buffer);
                    this.bufferOffset = jAddressOffset;
                    long jLimit = jAddressOffset + (this.f3547buffer.limit() - 1);
                    this.limitMinusOne = jLimit;
                    this.f3548pos = jLimit;
                    return;
                }
                throw new RuntimeException("Allocator returned non-direct buffer");
            }
            throw new RuntimeException("Allocated buffer does not have NIO buffer");
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeBool(boolean z) {
            mo3922write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeFixed32(int i) {
            long j = this.f3548pos;
            this.f3548pos = j - 1;
            UnsafeUtil.m4159putByte(j, (byte) ((i >> 24) & 255));
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) ((i >> 16) & 255));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) ((i >> 8) & 255));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (i & 255));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeFixed64(long j) {
            long j2 = this.f3548pos;
            this.f3548pos = j2 - 1;
            UnsafeUtil.m4159putByte(j2, (byte) (((int) (j >> 56)) & 255));
            long j3 = this.f3548pos;
            this.f3548pos = j3 - 1;
            UnsafeUtil.m4159putByte(j3, (byte) (((int) (j >> 48)) & 255));
            long j4 = this.f3548pos;
            this.f3548pos = j4 - 1;
            UnsafeUtil.m4159putByte(j4, (byte) (((int) (j >> 40)) & 255));
            long j5 = this.f3548pos;
            this.f3548pos = j5 - 1;
            UnsafeUtil.m4159putByte(j5, (byte) (((int) (j >> 32)) & 255));
            long j6 = this.f3548pos;
            this.f3548pos = j6 - 1;
            UnsafeUtil.m4159putByte(j6, (byte) (((int) (j >> 24)) & 255));
            long j7 = this.f3548pos;
            this.f3548pos = j7 - 1;
            UnsafeUtil.m4159putByte(j7, (byte) (((int) (j >> 16)) & 255));
            long j8 = this.f3548pos;
            this.f3548pos = j8 - 1;
            UnsafeUtil.m4159putByte(j8, (byte) (((int) (j >> 8)) & 255));
            long j9 = this.f3548pos;
            this.f3548pos = j9 - 1;
            UnsafeUtil.m4159putByte(j9, (byte) (((int) j) & 255));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeGroup(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
            writeTag(i, 4);
            interfaceC0777Schema.mo4094writeTo(obj, this);
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeInt32(int i) {
            if (i >= 0) {
                writeVarint32(i);
            } else {
                writeVarint64(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeSInt32(int i) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3923write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                nextBuffer(iRemaining);
            }
            this.f3548pos -= iRemaining;
            this.f3547buffer.position(bufferPos() + 1);
            this.f3547buffer.put(byteBuffer);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeMessage(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
            int totalBytesWritten = getTotalBytesWritten();
            interfaceC0777Schema.mo4094writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void writeString(String str) {
            char cCharAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length < 0 || (cCharAt = str.charAt(length)) >= 128) {
                    break;
                }
                long j = this.f3548pos;
                this.f3548pos = j - 1;
                UnsafeUtil.m4159putByte(j, (byte) cCharAt);
            }
            if (length == -1) {
                return;
            }
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128) {
                    long j2 = this.f3548pos;
                    if (j2 >= this.bufferOffset) {
                        this.f3548pos = j2 - 1;
                        UnsafeUtil.m4159putByte(j2, (byte) cCharAt2);
                    } else if (cCharAt2 < 2048) {
                        long j3 = this.f3548pos;
                        if (j3 > this.bufferOffset) {
                            this.f3548pos = j3 - 1;
                            UnsafeUtil.m4159putByte(j3, (byte) ((cCharAt2 & '?') | 128));
                            long j4 = this.f3548pos;
                            this.f3548pos = j4 - 1;
                            UnsafeUtil.m4159putByte(j4, (byte) ((cCharAt2 >>> 6) | 960));
                        } else if (cCharAt2 < 55296 || 57343 < cCharAt2) {
                            long j5 = this.f3548pos;
                            if (j5 > this.bufferOffset + 1) {
                                this.f3548pos = j5 - 1;
                                UnsafeUtil.m4159putByte(j5, (byte) ((cCharAt2 & '?') | 128));
                                long j6 = this.f3548pos;
                                this.f3548pos = j6 - 1;
                                UnsafeUtil.m4159putByte(j6, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                                long j7 = this.f3548pos;
                                this.f3548pos = j7 - 1;
                                UnsafeUtil.m4159putByte(j7, (byte) ((cCharAt2 >>> '\f') | 480));
                            } else {
                                if (this.f3548pos > this.bufferOffset + 2) {
                                    if (length != 0) {
                                        char cCharAt3 = str.charAt(length - 1);
                                        if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                            length--;
                                            int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                            long j8 = this.f3548pos;
                                            this.f3548pos = j8 - 1;
                                            UnsafeUtil.m4159putByte(j8, (byte) ((codePoint & 63) | 128));
                                            long j9 = this.f3548pos;
                                            this.f3548pos = j9 - 1;
                                            UnsafeUtil.m4159putByte(j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                            long j10 = this.f3548pos;
                                            this.f3548pos = j10 - 1;
                                            UnsafeUtil.m4159putByte(j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                            long j11 = this.f3548pos;
                                            this.f3548pos = j11 - 1;
                                            UnsafeUtil.m4159putByte(j11, (byte) ((codePoint >>> 18) | 240));
                                        }
                                    }
                                    throw new C0801Utf8.UnpairedSurrogateException(length - 1, length);
                                }
                                requireSpace(length);
                                length++;
                            }
                        }
                    }
                }
                length--;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.f3540buffers.addFirst(AllocatedBuffer.m3909wrap(byteBuffer));
                nextBuffer();
            } else {
                this.f3548pos -= iRemaining;
                this.f3547buffer.position(bufferPos() + 1);
                this.f3547buffer.put(byteBuffer);
            }
        }
    }

    public static final class UnsafeHeapWriter extends BinaryWriter {
        private AllocatedBuffer allocatedBuffer;

        /* renamed from: buffer */
        private byte[] f3549buffer;

        /* renamed from: limit */
        private long f3550limit;
        private long limitMinusOne;

        /* renamed from: offset */
        private long f3551offset;
        private long offsetMinusOne;

        /* renamed from: pos */
        private long f3552pos;

        public UnsafeHeapWriter(BufferAllocator bufferAllocator, int i) {
            super(bufferAllocator, i, null);
            nextBuffer();
        }

        private int arrayPos() {
            return (int) this.f3552pos;
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeArrayOperations();
        }

        private void nextBuffer() {
            nextBuffer(newHeapBuffer());
        }

        private void writeVarint32FiveBytes(int i) {
            byte[] bArr = this.f3549buffer;
            long j = this.f3552pos;
            this.f3552pos = j - 1;
            UnsafeUtil.m4161putByte(bArr, j, (byte) (i >>> 28));
            byte[] bArr2 = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr2, j2, (byte) (((i >>> 21) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr3, j3, (byte) (((i >>> 14) & 127) | 128));
            byte[] bArr4 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr4, j4, (byte) (((i >>> 7) & 127) | 128));
            byte[] bArr5 = this.f3549buffer;
            long j5 = this.f3552pos;
            this.f3552pos = j5 - 1;
            UnsafeUtil.m4161putByte(bArr5, j5, (byte) ((i & 127) | 128));
        }

        private void writeVarint32FourBytes(int i) {
            byte[] bArr = this.f3549buffer;
            long j = this.f3552pos;
            this.f3552pos = j - 1;
            UnsafeUtil.m4161putByte(bArr, j, (byte) (i >>> 21));
            byte[] bArr2 = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr2, j2, (byte) (((i >>> 14) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr3, j3, (byte) (((i >>> 7) & 127) | 128));
            byte[] bArr4 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr4, j4, (byte) ((i & 127) | 128));
        }

        private void writeVarint32OneByte(int i) {
            byte[] bArr = this.f3549buffer;
            long j = this.f3552pos;
            this.f3552pos = j - 1;
            UnsafeUtil.m4161putByte(bArr, j, (byte) i);
        }

        private void writeVarint32ThreeBytes(int i) {
            byte[] bArr = this.f3549buffer;
            long j = this.f3552pos;
            this.f3552pos = j - 1;
            UnsafeUtil.m4161putByte(bArr, j, (byte) (i >>> 14));
            byte[] bArr2 = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr2, j2, (byte) (((i >>> 7) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr3, j3, (byte) ((i & 127) | 128));
        }

        private void writeVarint32TwoBytes(int i) {
            byte[] bArr = this.f3549buffer;
            long j = this.f3552pos;
            this.f3552pos = j - 1;
            UnsafeUtil.m4161putByte(bArr, j, (byte) (i >>> 7));
            byte[] bArr2 = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr2, j2, (byte) ((i & 127) | 128));
        }

        private void writeVarint64EightBytes(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (j >>> 49));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) (((j >>> 42) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr3, j4, (byte) (((j >>> 35) & 127) | 128));
            byte[] bArr4 = this.f3549buffer;
            long j5 = this.f3552pos;
            this.f3552pos = j5 - 1;
            UnsafeUtil.m4161putByte(bArr4, j5, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr5 = this.f3549buffer;
            long j6 = this.f3552pos;
            this.f3552pos = j6 - 1;
            UnsafeUtil.m4161putByte(bArr5, j6, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr6 = this.f3549buffer;
            long j7 = this.f3552pos;
            this.f3552pos = j7 - 1;
            UnsafeUtil.m4161putByte(bArr6, j7, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr7 = this.f3549buffer;
            long j8 = this.f3552pos;
            this.f3552pos = j8 - 1;
            UnsafeUtil.m4161putByte(bArr7, j8, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr8 = this.f3549buffer;
            long j9 = this.f3552pos;
            this.f3552pos = j9 - 1;
            UnsafeUtil.m4161putByte(bArr8, j9, (byte) ((j & 127) | 128));
        }

        private void writeVarint64FiveBytes(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (j >>> 28));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr3, j4, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr4 = this.f3549buffer;
            long j5 = this.f3552pos;
            this.f3552pos = j5 - 1;
            UnsafeUtil.m4161putByte(bArr4, j5, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr5 = this.f3549buffer;
            long j6 = this.f3552pos;
            this.f3552pos = j6 - 1;
            UnsafeUtil.m4161putByte(bArr5, j6, (byte) ((j & 127) | 128));
        }

        private void writeVarint64FourBytes(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (j >>> 21));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr3, j4, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr4 = this.f3549buffer;
            long j5 = this.f3552pos;
            this.f3552pos = j5 - 1;
            UnsafeUtil.m4161putByte(bArr4, j5, (byte) ((j & 127) | 128));
        }

        private void writeVarint64NineBytes(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (j >>> 56));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) (((j >>> 49) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr3, j4, (byte) (((j >>> 42) & 127) | 128));
            byte[] bArr4 = this.f3549buffer;
            long j5 = this.f3552pos;
            this.f3552pos = j5 - 1;
            UnsafeUtil.m4161putByte(bArr4, j5, (byte) (((j >>> 35) & 127) | 128));
            byte[] bArr5 = this.f3549buffer;
            long j6 = this.f3552pos;
            this.f3552pos = j6 - 1;
            UnsafeUtil.m4161putByte(bArr5, j6, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr6 = this.f3549buffer;
            long j7 = this.f3552pos;
            this.f3552pos = j7 - 1;
            UnsafeUtil.m4161putByte(bArr6, j7, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr7 = this.f3549buffer;
            long j8 = this.f3552pos;
            this.f3552pos = j8 - 1;
            UnsafeUtil.m4161putByte(bArr7, j8, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr8 = this.f3549buffer;
            long j9 = this.f3552pos;
            this.f3552pos = j9 - 1;
            UnsafeUtil.m4161putByte(bArr8, j9, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr9 = this.f3549buffer;
            long j10 = this.f3552pos;
            this.f3552pos = j10 - 1;
            UnsafeUtil.m4161putByte(bArr9, j10, (byte) ((j & 127) | 128));
        }

        private void writeVarint64OneByte(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) j);
        }

        private void writeVarint64SevenBytes(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (j >>> 42));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) (((j >>> 35) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr3, j4, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr4 = this.f3549buffer;
            long j5 = this.f3552pos;
            this.f3552pos = j5 - 1;
            UnsafeUtil.m4161putByte(bArr4, j5, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr5 = this.f3549buffer;
            long j6 = this.f3552pos;
            this.f3552pos = j6 - 1;
            UnsafeUtil.m4161putByte(bArr5, j6, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr6 = this.f3549buffer;
            long j7 = this.f3552pos;
            this.f3552pos = j7 - 1;
            UnsafeUtil.m4161putByte(bArr6, j7, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr7 = this.f3549buffer;
            long j8 = this.f3552pos;
            this.f3552pos = j8 - 1;
            UnsafeUtil.m4161putByte(bArr7, j8, (byte) ((j & 127) | 128));
        }

        private void writeVarint64SixBytes(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (j >>> 35));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr3, j4, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr4 = this.f3549buffer;
            long j5 = this.f3552pos;
            this.f3552pos = j5 - 1;
            UnsafeUtil.m4161putByte(bArr4, j5, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr5 = this.f3549buffer;
            long j6 = this.f3552pos;
            this.f3552pos = j6 - 1;
            UnsafeUtil.m4161putByte(bArr5, j6, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr6 = this.f3549buffer;
            long j7 = this.f3552pos;
            this.f3552pos = j7 - 1;
            UnsafeUtil.m4161putByte(bArr6, j7, (byte) ((j & 127) | 128));
        }

        private void writeVarint64TenBytes(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (j >>> 63));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) (((j >>> 56) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr3, j4, (byte) (((j >>> 49) & 127) | 128));
            byte[] bArr4 = this.f3549buffer;
            long j5 = this.f3552pos;
            this.f3552pos = j5 - 1;
            UnsafeUtil.m4161putByte(bArr4, j5, (byte) (((j >>> 42) & 127) | 128));
            byte[] bArr5 = this.f3549buffer;
            long j6 = this.f3552pos;
            this.f3552pos = j6 - 1;
            UnsafeUtil.m4161putByte(bArr5, j6, (byte) (((j >>> 35) & 127) | 128));
            byte[] bArr6 = this.f3549buffer;
            long j7 = this.f3552pos;
            this.f3552pos = j7 - 1;
            UnsafeUtil.m4161putByte(bArr6, j7, (byte) (((j >>> 28) & 127) | 128));
            byte[] bArr7 = this.f3549buffer;
            long j8 = this.f3552pos;
            this.f3552pos = j8 - 1;
            UnsafeUtil.m4161putByte(bArr7, j8, (byte) (((j >>> 21) & 127) | 128));
            byte[] bArr8 = this.f3549buffer;
            long j9 = this.f3552pos;
            this.f3552pos = j9 - 1;
            UnsafeUtil.m4161putByte(bArr8, j9, (byte) (((j >>> 14) & 127) | 128));
            byte[] bArr9 = this.f3549buffer;
            long j10 = this.f3552pos;
            this.f3552pos = j10 - 1;
            UnsafeUtil.m4161putByte(bArr9, j10, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr10 = this.f3549buffer;
            long j11 = this.f3552pos;
            this.f3552pos = j11 - 1;
            UnsafeUtil.m4161putByte(bArr10, j11, (byte) ((j & 127) | 128));
        }

        private void writeVarint64ThreeBytes(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (((int) j) >>> 14));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) (((j >>> 7) & 127) | 128));
            byte[] bArr3 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr3, j4, (byte) ((j & 127) | 128));
        }

        private void writeVarint64TwoBytes(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (j >>> 7));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) ((((int) j) & 127) | 128));
        }

        public int bytesWrittenToCurrentBuffer() {
            return (int) (this.limitMinusOne - this.f3552pos);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void finishCurrentBuffer() {
            if (this.allocatedBuffer != null) {
                this.totalDoneBytes += bytesWrittenToCurrentBuffer();
                this.allocatedBuffer.position((arrayPos() - this.allocatedBuffer.arrayOffset()) + 1);
                this.allocatedBuffer = null;
                this.f3552pos = 0L;
                this.limitMinusOne = 0L;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public int getTotalBytesWritten() {
            return this.totalDoneBytes + bytesWrittenToCurrentBuffer();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void requireSpace(int i) {
            if (spaceLeft() < i) {
                nextBuffer(i);
            }
        }

        public int spaceLeft() {
            return (int) (this.f3552pos - this.offsetMinusOne);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3922write(byte b) {
            byte[] bArr = this.f3549buffer;
            long j = this.f3552pos;
            this.f3552pos = j - 1;
            UnsafeUtil.m4161putByte(bArr, j, b);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeBool(int i, boolean z) {
            requireSpace(6);
            mo3922write(z ? (byte) 1 : (byte) 0);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeBytes(int i, ByteString byteString) {
            try {
                byteString.writeToReverse(this);
                requireSpace(10);
                writeVarint32(byteString.mo3944size());
                writeTag(i, 2);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeEndGroup(int i) {
            writeTag(i, 4);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeFixed32(int i, int i2) {
            requireSpace(9);
            writeFixed32(i2);
            writeTag(i, 5);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeFixed64(int i, long j) {
            requireSpace(13);
            writeFixed64(j);
            writeTag(i, 1);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeGroup(int i, Object obj) {
            writeTag(i, 4);
            Protobuf.getInstance().m4119writeTo(obj, this);
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeInt32(int i, int i2) {
            requireSpace(15);
            writeInt32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i, int i2) {
            if (i < 0 || i + i2 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            if (spaceLeft() >= i2) {
                this.f3552pos -= i2;
                System.arraycopy(bArr, i, this.f3549buffer, arrayPos() + 1, i2);
            } else {
                this.totalDoneBytes += i2;
                this.f3540buffers.addFirst(AllocatedBuffer.m3911wrap(bArr, i, i2));
                nextBuffer();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeMessage(int i, Object obj) {
            int totalBytesWritten = getTotalBytesWritten();
            Protobuf.getInstance().m4119writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeSInt32(int i, int i2) {
            requireSpace(10);
            writeSInt32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeSInt64(int i, long j) {
            requireSpace(15);
            writeSInt64(j);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeStartGroup(int i) {
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeString(int i, String str) {
            int totalBytesWritten = getTotalBytesWritten();
            writeString(str);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeTag(int i, int i2) {
            writeVarint32(WireFormat.m4185makeTag(i, i2));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeUInt32(int i, int i2) {
            requireSpace(10);
            writeVarint32(i2);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeUInt64(int i, long j) {
            requireSpace(15);
            writeVarint64(j);
            writeTag(i, 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeVarint32(int i) {
            if ((i & (-128)) == 0) {
                writeVarint32OneByte(i);
                return;
            }
            if ((i & (-16384)) == 0) {
                writeVarint32TwoBytes(i);
                return;
            }
            if (((-2097152) & i) == 0) {
                writeVarint32ThreeBytes(i);
            } else if (((-268435456) & i) == 0) {
                writeVarint32FourBytes(i);
            } else {
                writeVarint32FiveBytes(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeVarint64(long j) {
            switch (BinaryWriter.computeUInt64SizeNoTag(j)) {
                case 1:
                    writeVarint64OneByte(j);
                    break;
                case 2:
                    writeVarint64TwoBytes(j);
                    break;
                case 3:
                    writeVarint64ThreeBytes(j);
                    break;
                case 4:
                    writeVarint64FourBytes(j);
                    break;
                case 5:
                    writeVarint64FiveBytes(j);
                    break;
                case 6:
                    writeVarint64SixBytes(j);
                    break;
                case 7:
                    writeVarint64SevenBytes(j);
                    break;
                case 8:
                    writeVarint64EightBytes(j);
                    break;
                case 9:
                    writeVarint64NineBytes(j);
                    break;
                case 10:
                    writeVarint64TenBytes(j);
                    break;
            }
        }

        private void nextBuffer(int i) {
            nextBuffer(newHeapBuffer(i));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3924write(byte[] bArr, int i, int i2) {
            if (i < 0 || i + i2 > bArr.length) {
                throw new ArrayIndexOutOfBoundsException(String.format("value.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)));
            }
            requireSpace(i2);
            this.f3552pos -= i2;
            System.arraycopy(bArr, i, this.f3549buffer, arrayPos() + 1, i2);
        }

        private void nextBuffer(AllocatedBuffer allocatedBuffer) {
            if (allocatedBuffer.hasArray()) {
                finishCurrentBuffer();
                this.f3540buffers.addFirst(allocatedBuffer);
                this.allocatedBuffer = allocatedBuffer;
                this.f3549buffer = allocatedBuffer.mo3912array();
                long jArrayOffset = allocatedBuffer.arrayOffset();
                this.f3550limit = allocatedBuffer.mo3913limit() + jArrayOffset;
                long jPosition = jArrayOffset + allocatedBuffer.position();
                this.f3551offset = jPosition;
                this.offsetMinusOne = jPosition - 1;
                long j = this.f3550limit - 1;
                this.limitMinusOne = j;
                this.f3552pos = j;
                return;
            }
            throw new RuntimeException("Allocator returned non-heap buffer");
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeBool(boolean z) {
            mo3922write(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeFixed32(int i) {
            byte[] bArr = this.f3549buffer;
            long j = this.f3552pos;
            this.f3552pos = j - 1;
            UnsafeUtil.m4161putByte(bArr, j, (byte) ((i >> 24) & 255));
            byte[] bArr2 = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr2, j2, (byte) ((i >> 16) & 255));
            byte[] bArr3 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr3, j3, (byte) ((i >> 8) & 255));
            byte[] bArr4 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr4, j4, (byte) (i & 255));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeFixed64(long j) {
            byte[] bArr = this.f3549buffer;
            long j2 = this.f3552pos;
            this.f3552pos = j2 - 1;
            UnsafeUtil.m4161putByte(bArr, j2, (byte) (((int) (j >> 56)) & 255));
            byte[] bArr2 = this.f3549buffer;
            long j3 = this.f3552pos;
            this.f3552pos = j3 - 1;
            UnsafeUtil.m4161putByte(bArr2, j3, (byte) (((int) (j >> 48)) & 255));
            byte[] bArr3 = this.f3549buffer;
            long j4 = this.f3552pos;
            this.f3552pos = j4 - 1;
            UnsafeUtil.m4161putByte(bArr3, j4, (byte) (((int) (j >> 40)) & 255));
            byte[] bArr4 = this.f3549buffer;
            long j5 = this.f3552pos;
            this.f3552pos = j5 - 1;
            UnsafeUtil.m4161putByte(bArr4, j5, (byte) (((int) (j >> 32)) & 255));
            byte[] bArr5 = this.f3549buffer;
            long j6 = this.f3552pos;
            this.f3552pos = j6 - 1;
            UnsafeUtil.m4161putByte(bArr5, j6, (byte) (((int) (j >> 24)) & 255));
            byte[] bArr6 = this.f3549buffer;
            long j7 = this.f3552pos;
            this.f3552pos = j7 - 1;
            UnsafeUtil.m4161putByte(bArr6, j7, (byte) (((int) (j >> 16)) & 255));
            byte[] bArr7 = this.f3549buffer;
            long j8 = this.f3552pos;
            this.f3552pos = j8 - 1;
            UnsafeUtil.m4161putByte(bArr7, j8, (byte) (((int) (j >> 8)) & 255));
            byte[] bArr8 = this.f3549buffer;
            long j9 = this.f3552pos;
            this.f3552pos = j9 - 1;
            UnsafeUtil.m4161putByte(bArr8, j9, (byte) (((int) j) & 255));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeGroup(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
            writeTag(i, 4);
            interfaceC0777Schema.mo4094writeTo(obj, this);
            writeTag(i, 3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeInt32(int i) {
            if (i >= 0) {
                writeVarint32(i);
            } else {
                writeVarint64(i);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeSInt32(int i) {
            writeVarint32(CodedOutputStream.encodeZigZag32(i));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        public void writeSInt64(long j) {
            writeVarint64(CodedOutputStream.encodeZigZag64(j));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
        public void writeMessage(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
            int totalBytesWritten = getTotalBytesWritten();
            interfaceC0777Schema.mo4094writeTo(obj, this);
            int totalBytesWritten2 = getTotalBytesWritten() - totalBytesWritten;
            requireSpace(10);
            writeVarint32(totalBytesWritten2);
            writeTag(i, 2);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b5  */
        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryWriter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void writeString(String str) {
            char cCharAt;
            requireSpace(str.length());
            int length = str.length();
            while (true) {
                length--;
                if (length < 0 || (cCharAt = str.charAt(length)) >= 128) {
                    break;
                }
                byte[] bArr = this.f3549buffer;
                long j = this.f3552pos;
                this.f3552pos = j - 1;
                UnsafeUtil.m4161putByte(bArr, j, (byte) cCharAt);
            }
            if (length == -1) {
                return;
            }
            while (length >= 0) {
                char cCharAt2 = str.charAt(length);
                if (cCharAt2 < 128) {
                    long j2 = this.f3552pos;
                    if (j2 > this.offsetMinusOne) {
                        byte[] bArr2 = this.f3549buffer;
                        this.f3552pos = j2 - 1;
                        UnsafeUtil.m4161putByte(bArr2, j2, (byte) cCharAt2);
                    } else if (cCharAt2 < 2048) {
                        long j3 = this.f3552pos;
                        if (j3 > this.f3551offset) {
                            byte[] bArr3 = this.f3549buffer;
                            this.f3552pos = j3 - 1;
                            UnsafeUtil.m4161putByte(bArr3, j3, (byte) ((cCharAt2 & '?') | 128));
                            byte[] bArr4 = this.f3549buffer;
                            long j4 = this.f3552pos;
                            this.f3552pos = j4 - 1;
                            UnsafeUtil.m4161putByte(bArr4, j4, (byte) ((cCharAt2 >>> 6) | 960));
                        } else if (cCharAt2 < 55296 || 57343 < cCharAt2) {
                            long j5 = this.f3552pos;
                            if (j5 > this.f3551offset + 1) {
                                byte[] bArr5 = this.f3549buffer;
                                this.f3552pos = j5 - 1;
                                UnsafeUtil.m4161putByte(bArr5, j5, (byte) ((cCharAt2 & '?') | 128));
                                byte[] bArr6 = this.f3549buffer;
                                long j6 = this.f3552pos;
                                this.f3552pos = j6 - 1;
                                UnsafeUtil.m4161putByte(bArr6, j6, (byte) (((cCharAt2 >>> 6) & 63) | 128));
                                byte[] bArr7 = this.f3549buffer;
                                long j7 = this.f3552pos;
                                this.f3552pos = j7 - 1;
                                UnsafeUtil.m4161putByte(bArr7, j7, (byte) ((cCharAt2 >>> '\f') | 480));
                            } else {
                                if (this.f3552pos > this.f3551offset + 2) {
                                    if (length != 0) {
                                        char cCharAt3 = str.charAt(length - 1);
                                        if (Character.isSurrogatePair(cCharAt3, cCharAt2)) {
                                            length--;
                                            int codePoint = Character.toCodePoint(cCharAt3, cCharAt2);
                                            byte[] bArr8 = this.f3549buffer;
                                            long j8 = this.f3552pos;
                                            this.f3552pos = j8 - 1;
                                            UnsafeUtil.m4161putByte(bArr8, j8, (byte) ((codePoint & 63) | 128));
                                            byte[] bArr9 = this.f3549buffer;
                                            long j9 = this.f3552pos;
                                            this.f3552pos = j9 - 1;
                                            UnsafeUtil.m4161putByte(bArr9, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                                            byte[] bArr10 = this.f3549buffer;
                                            long j10 = this.f3552pos;
                                            this.f3552pos = j10 - 1;
                                            UnsafeUtil.m4161putByte(bArr10, j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                            byte[] bArr11 = this.f3549buffer;
                                            long j11 = this.f3552pos;
                                            this.f3552pos = j11 - 1;
                                            UnsafeUtil.m4161putByte(bArr11, j11, (byte) ((codePoint >>> 18) | 240));
                                        }
                                    }
                                    throw new C0801Utf8.UnpairedSurrogateException(length - 1, length);
                                }
                                requireSpace(length);
                                length++;
                            }
                        }
                    }
                }
                length--;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        /* renamed from: write */
        public void mo3923write(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            requireSpace(iRemaining);
            this.f3552pos -= iRemaining;
            byteBuffer.get(this.f3549buffer, arrayPos() + 1, iRemaining);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteOutput
        public void writeLazy(ByteBuffer byteBuffer) {
            int iRemaining = byteBuffer.remaining();
            if (spaceLeft() < iRemaining) {
                this.totalDoneBytes += iRemaining;
                this.f3540buffers.addFirst(AllocatedBuffer.m3909wrap(byteBuffer));
                nextBuffer();
            }
            this.f3552pos -= iRemaining;
            byteBuffer.get(this.f3549buffer, arrayPos() + 1, iRemaining);
        }
    }

    public /* synthetic */ BinaryWriter(BufferAllocator bufferAllocator, int i, C07201 c07201) {
        this(bufferAllocator, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte computeUInt64SizeNoTag(long j) {
        byte b;
        if (((-128) & j) == 0) {
            return (byte) 1;
        }
        if (j < 0) {
            return (byte) 10;
        }
        if (((-34359738368L) & j) != 0) {
            b = (byte) 6;
            j >>>= 28;
        } else {
            b = 2;
        }
        if (((-2097152) & j) != 0) {
            b = (byte) (b + 2);
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? (byte) (b + 1) : b;
    }

    public static boolean isUnsafeDirectSupported() {
        return UnsafeDirectWriter.isSupported();
    }

    public static boolean isUnsafeHeapSupported() {
        return UnsafeHeapWriter.isSupported();
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator) {
        return newDirectInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator) {
        return newHeapInstance(bufferAllocator, 4096);
    }

    public static BinaryWriter newSafeDirectInstance(BufferAllocator bufferAllocator, int i) {
        return new SafeDirectWriter(bufferAllocator, i);
    }

    public static BinaryWriter newSafeHeapInstance(BufferAllocator bufferAllocator, int i) {
        return new SafeHeapWriter(bufferAllocator, i);
    }

    public static BinaryWriter newUnsafeDirectInstance(BufferAllocator bufferAllocator, int i) {
        if (isUnsafeDirectSupported()) {
            return new UnsafeDirectWriter(bufferAllocator, i);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    public static BinaryWriter newUnsafeHeapInstance(BufferAllocator bufferAllocator, int i) {
        if (isUnsafeHeapSupported()) {
            return new UnsafeHeapWriter(bufferAllocator, i);
        }
        throw new UnsupportedOperationException("Unsafe operations not supported");
    }

    private final void writeBoolList_Internal(int i, List<Boolean> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeBool(i, list.get(size).booleanValue());
            }
            return;
        }
        requireSpace(list.size() + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeBool(list.get(size2).booleanValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    private final void writeDoubleList_Internal(int i, List<Double> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeDouble(i, list.get(size).doubleValue());
            }
            return;
        }
        requireSpace((list.size() * 8) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(Double.doubleToRawLongBits(list.get(size2).doubleValue()));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    private final void writeFixed32List_Internal(int i, List<Integer> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed32(i, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 4) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    private final void writeFixed64List_Internal(int i, List<Long> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFixed64(i, list.get(size).longValue());
            }
            return;
        }
        requireSpace((list.size() * 8) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed64(list.get(size2).longValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    private final void writeFloatList_Internal(int i, List<Float> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeFloat(i, list.get(size).floatValue());
            }
            return;
        }
        requireSpace((list.size() * 4) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeFixed32(Float.floatToRawIntBits(list.get(size2).floatValue()));
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    private final void writeInt32List_Internal(int i, List<Integer> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeInt32(i, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeInt32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    private void writeLazyString(int i, Object obj) {
        if (obj instanceof String) {
            writeString(i, (String) obj);
        } else {
            writeBytes(i, (ByteString) obj);
        }
    }

    public static final void writeMapEntryField(InterfaceC0811Writer interfaceC0811Writer, int i, WireFormat.FieldType fieldType, Object obj) {
        switch (C07201.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                interfaceC0811Writer.writeBool(i, ((Boolean) obj).booleanValue());
                return;
            case 2:
                interfaceC0811Writer.writeFixed32(i, ((Integer) obj).intValue());
                return;
            case 3:
                interfaceC0811Writer.writeFixed64(i, ((Long) obj).longValue());
                return;
            case 4:
                interfaceC0811Writer.writeInt32(i, ((Integer) obj).intValue());
                return;
            case 5:
                interfaceC0811Writer.writeInt64(i, ((Long) obj).longValue());
                return;
            case 6:
                interfaceC0811Writer.writeSFixed32(i, ((Integer) obj).intValue());
                return;
            case 7:
                interfaceC0811Writer.writeSFixed64(i, ((Long) obj).longValue());
                return;
            case 8:
                interfaceC0811Writer.writeSInt32(i, ((Integer) obj).intValue());
                return;
            case 9:
                interfaceC0811Writer.writeSInt64(i, ((Long) obj).longValue());
                return;
            case 10:
                interfaceC0811Writer.writeString(i, (String) obj);
                return;
            case 11:
                interfaceC0811Writer.writeUInt32(i, ((Integer) obj).intValue());
                return;
            case 12:
                interfaceC0811Writer.writeUInt64(i, ((Long) obj).longValue());
                return;
            case 13:
                interfaceC0811Writer.writeFloat(i, ((Float) obj).floatValue());
                return;
            case 14:
                interfaceC0811Writer.writeDouble(i, ((Double) obj).doubleValue());
                return;
            case 15:
                interfaceC0811Writer.writeMessage(i, obj);
                return;
            case 16:
                interfaceC0811Writer.writeBytes(i, (ByteString) obj);
                return;
            case 17:
                if (obj instanceof Internal.EnumLite) {
                    interfaceC0811Writer.writeEnum(i, ((Internal.EnumLite) obj).getNumber());
                    return;
                } else {
                    if (!(obj instanceof Integer)) {
                        throw new IllegalArgumentException("Unexpected type for enum in map.");
                    }
                    interfaceC0811Writer.writeEnum(i, ((Integer) obj).intValue());
                    return;
                }
            default:
                throw new IllegalArgumentException("Unsupported map value type for: " + fieldType);
        }
    }

    private final void writeSInt32List_Internal(int i, List<Integer> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt32(i, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 5) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    private final void writeSInt64List_Internal(int i, List<Long> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeSInt64(i, list.get(size).longValue());
            }
            return;
        }
        requireSpace((list.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeSInt64(list.get(size2).longValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    private final void writeUInt32List_Internal(int i, List<Integer> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeUInt32(i, list.get(size).intValue());
            }
            return;
        }
        requireSpace((list.size() * 5) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeVarint32(list.get(size2).intValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    private final void writeUInt64List_Internal(int i, List<Long> list, boolean z) {
        if (!z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeUInt64(i, list.get(size).longValue());
            }
            return;
        }
        requireSpace((list.size() * 10) + 10);
        int totalBytesWritten = getTotalBytesWritten();
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeVarint64(list.get(size2).longValue());
        }
        writeVarint32(getTotalBytesWritten() - totalBytesWritten);
        writeTag(i, 2);
    }

    @CanIgnoreReturnValue
    public final Queue<AllocatedBuffer> complete() {
        finishCurrentBuffer();
        return this.f3540buffers;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final InterfaceC0811Writer.FieldOrder fieldOrder() {
        return InterfaceC0811Writer.FieldOrder.DESCENDING;
    }

    public abstract void finishCurrentBuffer();

    public abstract int getTotalBytesWritten();

    public final AllocatedBuffer newDirectBuffer() {
        return this.f3539alloc.allocateDirectBuffer(this.chunkSize);
    }

    public final AllocatedBuffer newHeapBuffer() {
        return this.f3539alloc.allocateHeapBuffer(this.chunkSize);
    }

    public abstract void requireSpace(int i);

    public abstract void writeBool(boolean z);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeBoolList(int i, List<Boolean> list, boolean z) {
        if (list instanceof BooleanArrayList) {
            writeBoolList_Internal(i, (BooleanArrayList) list, z);
        } else {
            writeBoolList_Internal(i, list, z);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeBytesList(int i, List<ByteString> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeBytes(i, list.get(size));
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeDouble(int i, double d) {
        writeFixed64(i, Double.doubleToRawLongBits(d));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeDoubleList(int i, List<Double> list, boolean z) {
        if (list instanceof DoubleArrayList) {
            writeDoubleList_Internal(i, (DoubleArrayList) list, z);
        } else {
            writeDoubleList_Internal(i, list, z);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeEnum(int i, int i2) {
        writeInt32(i, i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeEnumList(int i, List<Integer> list, boolean z) {
        writeInt32List(i, list, z);
    }

    public abstract void writeFixed32(int i);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeFixed32List(int i, List<Integer> list, boolean z) {
        if (list instanceof IntArrayList) {
            writeFixed32List_Internal(i, (IntArrayList) list, z);
        } else {
            writeFixed32List_Internal(i, list, z);
        }
    }

    public abstract void writeFixed64(long j);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeFixed64List(int i, List<Long> list, boolean z) {
        if (list instanceof LongArrayList) {
            writeFixed64List_Internal(i, (LongArrayList) list, z);
        } else {
            writeFixed64List_Internal(i, list, z);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeFloat(int i, float f) {
        writeFixed32(i, Float.floatToRawIntBits(f));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeFloatList(int i, List<Float> list, boolean z) {
        if (list instanceof FloatArrayList) {
            writeFloatList_Internal(i, (FloatArrayList) list, z);
        } else {
            writeFloatList_Internal(i, list, z);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    @Deprecated
    public final void writeGroupList(int i, List<?> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i, list.get(size));
        }
    }

    public abstract void writeInt32(int i);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeInt32List(int i, List<Integer> list, boolean z) {
        if (list instanceof IntArrayList) {
            writeInt32List_Internal(i, (IntArrayList) list, z);
        } else {
            writeInt32List_Internal(i, list, z);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeInt64(int i, long j) {
        writeUInt64(i, j);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeInt64List(int i, List<Long> list, boolean z) {
        writeUInt64List(i, list, z);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            int totalBytesWritten = getTotalBytesWritten();
            writeMapEntryField(this, 2, metadata.valueType, entry.getValue());
            writeMapEntryField(this, 1, metadata.f3722keyType, entry.getKey());
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeMessageList(int i, List<?> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i, list.get(size));
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeMessageSetItem(int i, Object obj) {
        writeTag(1, 4);
        if (obj instanceof ByteString) {
            writeBytes(3, (ByteString) obj);
        } else {
            writeMessage(3, obj);
        }
        writeUInt32(2, i);
        writeTag(1, 3);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeSFixed32(int i, int i2) {
        writeFixed32(i, i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeSFixed32List(int i, List<Integer> list, boolean z) {
        writeFixed32List(i, list, z);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeSFixed64(int i, long j) {
        writeFixed64(i, j);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeSFixed64List(int i, List<Long> list, boolean z) {
        writeFixed64List(i, list, z);
    }

    public abstract void writeSInt32(int i);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeSInt32List(int i, List<Integer> list, boolean z) {
        if (list instanceof IntArrayList) {
            writeSInt32List_Internal(i, (IntArrayList) list, z);
        } else {
            writeSInt32List_Internal(i, list, z);
        }
    }

    public abstract void writeSInt64(long j);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeSInt64List(int i, List<Long> list, boolean z) {
        if (list instanceof LongArrayList) {
            writeSInt64List_Internal(i, (LongArrayList) list, z);
        } else {
            writeSInt64List_Internal(i, list, z);
        }
    }

    public abstract void writeString(String str);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeStringList(int i, List<String> list) {
        if (!(list instanceof LazyStringList)) {
            for (int size = list.size() - 1; size >= 0; size--) {
                writeString(i, list.get(size));
            }
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            writeLazyString(i, lazyStringList.mo4060getRaw(size2));
        }
    }

    public abstract void writeTag(int i, int i2);

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeUInt32List(int i, List<Integer> list, boolean z) {
        if (list instanceof IntArrayList) {
            writeUInt32List_Internal(i, (IntArrayList) list, z);
        } else {
            writeUInt32List_Internal(i, list, z);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeUInt64List(int i, List<Long> list, boolean z) {
        if (list instanceof LongArrayList) {
            writeUInt64List_Internal(i, (LongArrayList) list, z);
        } else {
            writeUInt64List_Internal(i, list, z);
        }
    }

    public abstract void writeVarint32(int i);

    public abstract void writeVarint64(long j);

    private BinaryWriter(BufferAllocator bufferAllocator, int i) {
        this.f3540buffers = new ArrayDeque<>(4);
        if (i <= 0) {
            throw new IllegalArgumentException("chunkSize must be > 0");
        }
        this.f3539alloc = (BufferAllocator) Internal.checkNotNull(bufferAllocator, "alloc");
        this.chunkSize = i;
    }

    public static BinaryWriter newDirectInstance(BufferAllocator bufferAllocator, int i) {
        return isUnsafeDirectSupported() ? newUnsafeDirectInstance(bufferAllocator, i) : newSafeDirectInstance(bufferAllocator, i);
    }

    public static BinaryWriter newHeapInstance(BufferAllocator bufferAllocator, int i) {
        return isUnsafeHeapSupported() ? newUnsafeHeapInstance(bufferAllocator, i) : newSafeHeapInstance(bufferAllocator, i);
    }

    public final AllocatedBuffer newDirectBuffer(int i) {
        return this.f3539alloc.allocateDirectBuffer(Math.max(i, this.chunkSize));
    }

    public final AllocatedBuffer newHeapBuffer(int i) {
        return this.f3539alloc.allocateHeapBuffer(Math.max(i, this.chunkSize));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    @Deprecated
    public final void writeGroupList(int i, List<?> list, InterfaceC0777Schema interfaceC0777Schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeGroup(i, list.get(size), interfaceC0777Schema);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeMessageList(int i, List<?> list, InterfaceC0777Schema interfaceC0777Schema) {
        for (int size = list.size() - 1; size >= 0; size--) {
            writeMessage(i, list.get(size), interfaceC0777Schema);
        }
    }

    private final void writeBoolList_Internal(int i, BooleanArrayList booleanArrayList, boolean z) {
        if (z) {
            requireSpace(booleanArrayList.size() + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = booleanArrayList.size() - 1; size >= 0; size--) {
                writeBool(booleanArrayList.getBoolean(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = booleanArrayList.size() - 1; size2 >= 0; size2--) {
            writeBool(i, booleanArrayList.getBoolean(size2));
        }
    }

    private final void writeDoubleList_Internal(int i, DoubleArrayList doubleArrayList, boolean z) {
        if (z) {
            requireSpace((doubleArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = doubleArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(Double.doubleToRawLongBits(doubleArrayList.getDouble(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = doubleArrayList.size() - 1; size2 >= 0; size2--) {
            writeDouble(i, doubleArrayList.getDouble(size2));
        }
    }

    private final void writeFixed32List_Internal(int i, IntArrayList intArrayList, boolean z) {
        if (z) {
            requireSpace((intArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(intArrayList.mo4039getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed32(i, intArrayList.mo4039getInt(size2));
        }
    }

    private final void writeFixed64List_Internal(int i, LongArrayList longArrayList, boolean z) {
        if (z) {
            requireSpace((longArrayList.size() * 8) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeFixed64(longArrayList.mo4045getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeFixed64(i, longArrayList.mo4045getLong(size2));
        }
    }

    private final void writeFloatList_Internal(int i, FloatArrayList floatArrayList, boolean z) {
        if (z) {
            requireSpace((floatArrayList.size() * 4) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = floatArrayList.size() - 1; size >= 0; size--) {
                writeFixed32(Float.floatToRawIntBits(floatArrayList.getFloat(size)));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = floatArrayList.size() - 1; size2 >= 0; size2--) {
            writeFloat(i, floatArrayList.getFloat(size2));
        }
    }

    private final void writeInt32List_Internal(int i, IntArrayList intArrayList, boolean z) {
        if (z) {
            requireSpace((intArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeInt32(intArrayList.mo4039getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeInt32(i, intArrayList.mo4039getInt(size2));
        }
    }

    private final void writeSInt32List_Internal(int i, IntArrayList intArrayList, boolean z) {
        if (z) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeSInt32(intArrayList.mo4039getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt32(i, intArrayList.mo4039getInt(size2));
        }
    }

    private final void writeSInt64List_Internal(int i, LongArrayList longArrayList, boolean z) {
        if (z) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeSInt64(longArrayList.mo4045getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeSInt64(i, longArrayList.mo4045getLong(size2));
        }
    }

    private final void writeUInt32List_Internal(int i, IntArrayList intArrayList, boolean z) {
        if (z) {
            requireSpace((intArrayList.size() * 5) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = intArrayList.size() - 1; size >= 0; size--) {
                writeVarint32(intArrayList.mo4039getInt(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = intArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt32(i, intArrayList.mo4039getInt(size2));
        }
    }

    private final void writeUInt64List_Internal(int i, LongArrayList longArrayList, boolean z) {
        if (z) {
            requireSpace((longArrayList.size() * 10) + 10);
            int totalBytesWritten = getTotalBytesWritten();
            for (int size = longArrayList.size() - 1; size >= 0; size--) {
                writeVarint64(longArrayList.mo4045getLong(size));
            }
            writeVarint32(getTotalBytesWritten() - totalBytesWritten);
            writeTag(i, 2);
            return;
        }
        for (int size2 = longArrayList.size() - 1; size2 >= 0; size2--) {
            writeUInt64(i, longArrayList.mo4045getLong(size2));
        }
    }
}
