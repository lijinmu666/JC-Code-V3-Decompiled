package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;

    /* renamed from: wrapper */
    CodedInputStreamReader f3570wrapper;

    public static final class ArrayDecoder extends CodedInputStream {

        /* renamed from: buffer */
        private final byte[] f3571buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;

        /* renamed from: lastTag */
        private int f3572lastTag;

        /* renamed from: limit */
        private int f3573limit;

        /* renamed from: pos */
        private int f3574pos;
        private int startPos;

        private void recomputeBufferSizeAfterLimit() {
            int i = this.f3573limit + this.bufferSizeAfterLimit;
            this.f3573limit = i;
            int i2 = i - this.startPos;
            int i3 = this.currentLimit;
            if (i2 <= i3) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i4 = i2 - i3;
            this.bufferSizeAfterLimit = i4;
            this.f3573limit = i - i4;
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            if (this.f3573limit - this.f3574pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.f3571buffer;
                int i2 = this.f3574pos;
                this.f3574pos = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.f3572lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean z) {
            this.enableAliasing = z;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f3572lastTag;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.f3574pos - this.startPos;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        /* renamed from: isAtEnd */
        public boolean mo3954isAtEnd() {
            return this.f3574pos == this.f3573limit;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i + getTotalBytesRead();
            if (totalBytesRead < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i2 = this.currentLimit;
            if (totalBytesRead > i2) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.f3573limit;
                int i2 = this.f3574pos;
                if (rawVarint32 <= i - i2) {
                    ByteBuffer byteBufferWrap = (this.immutable || !this.enableAliasing) ? ByteBuffer.wrap(Arrays.copyOfRange(this.f3571buffer, i2, i2 + rawVarint32)) : ByteBuffer.wrap(this.f3571buffer, i2, rawVarint32).slice();
                    this.f3574pos += rawVarint32;
                    return byteBufferWrap;
                }
            }
            if (rawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public ByteString readBytes() {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.f3573limit;
                int i2 = this.f3574pos;
                if (rawVarint32 <= i - i2) {
                    ByteString byteStringM3936wrap = (this.immutable && this.enableAliasing) ? ByteString.m3936wrap(this.f3571buffer, i2, rawVarint32) : ByteString.copyFrom(this.f3571buffer, i2, rawVarint32);
                    this.f3574pos += rawVarint32;
                    return byteStringM3936wrap;
                }
            }
            return rawVarint32 == 0 ? ByteString.f3559EMPTY : ByteString.m3935wrap(readRawBytes(rawVarint32));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            interfaceC0766Builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.m4185makeTag(i, 4));
            this.recursionDepth--;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void readMessage(MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            interfaceC0766Builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(iPushLimit);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            int i = this.f3574pos;
            if (i == this.f3573limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f3571buffer;
            this.f3574pos = i + 1;
            return bArr[i];
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws InvalidProtocolBufferException {
            if (i > 0) {
                int i2 = this.f3573limit;
                int i3 = this.f3574pos;
                if (i <= i2 - i3) {
                    int i4 = i + i3;
                    this.f3574pos = i4;
                    return Arrays.copyOfRange(this.f3571buffer, i3, i4);
                }
            }
            if (i > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws InvalidProtocolBufferException {
            int i = this.f3574pos;
            if (this.f3573limit - i < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f3571buffer;
            this.f3574pos = i + 4;
            return (bArr[i] & C1126UByte.MAX_VALUE) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16) | ((bArr[i + 3] & C1126UByte.MAX_VALUE) << 24);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            int i = this.f3574pos;
            if (this.f3573limit - i < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f3571buffer;
            this.f3574pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readRawVarint32() {
            int i;
            int i2 = this.f3574pos;
            int i3 = this.f3573limit;
            if (i3 != i2) {
                byte[] bArr = this.f3571buffer;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.f3574pos = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.f3574pos = i5;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j;
            long j2;
            long j3;
            int i = this.f3574pos;
            int i2 = this.f3573limit;
            if (i2 != i) {
                byte[] bArr = this.f3571buffer;
                int i3 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.f3574pos = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << 14) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                long j4 = (-2080896) ^ i9;
                                i4 = i8;
                                j = j4;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (bArr[i8] << 28);
                                if (j6 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    int i10 = i + 6;
                                    long j7 = j6 ^ (bArr[i4] << 35);
                                    if (j7 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (bArr[i10] << 42);
                                        if (j6 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i10 = i + 8;
                                            j7 = j6 ^ (bArr[i4] << 49);
                                            if (j7 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i11 = i + 10;
                                                    if (bArr[i4] >= 0) {
                                                        i4 = i11;
                                                    }
                                                }
                                                j = j8;
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j6 ^ j3;
                            }
                        }
                    }
                    this.f3574pos = i4;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & ByteCompanionObject.MAX_VALUE) << i;
                if ((readRawByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.f3573limit;
                int i2 = this.f3574pos;
                if (rawVarint32 <= i - i2) {
                    String str = new String(this.f3571buffer, i2, rawVarint32, Internal.f3692UTF_8);
                    this.f3574pos += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return BuildConfig.f24315FLAVOR;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.f3573limit;
                int i2 = this.f3574pos;
                if (rawVarint32 <= i - i2) {
                    String strDecodeUtf8 = C0801Utf8.decodeUtf8(this.f3571buffer, i2, rawVarint32);
                    this.f3574pos += rawVarint32;
                    return strDecodeUtf8;
                }
            }
            if (rawVarint32 == 0) {
                return BuildConfig.f24315FLAVOR;
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        /* renamed from: readTag */
        public int mo3955readTag() throws InvalidProtocolBufferException {
            if (mo3954isAtEnd()) {
                this.f3572lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.f3572lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.f3572lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder) throws InvalidProtocolBufferException {
            readGroup(i, interfaceC0766Builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.f3574pos;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean skipField(int i) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipMessage() throws InvalidProtocolBufferException {
            int iMo3955readTag;
            do {
                iMo3955readTag = mo3955readTag();
                if (iMo3955readTag == 0) {
                    return;
                }
            } while (skipField(iMo3955readTag));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                int i2 = this.f3573limit;
                int i3 = this.f3574pos;
                if (i <= i2 - i3) {
                    this.f3574pos = i3 + i;
                    return;
                }
            }
            if (i >= 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private ArrayDecoder(byte[] bArr, int i, int i2, boolean z) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.f3571buffer = bArr;
            this.f3573limit = i2 + i;
            this.f3574pos = i;
            this.startPos = i;
            this.immutable = z;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int iMo3955readTag;
            do {
                iMo3955readTag = mo3955readTag();
                if (iMo3955readTag == 0) {
                    return;
                }
            } while (skipField(iMo3955readTag, codedOutputStream));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            T partialFrom = interfaceC0774Parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.m4185makeTag(i, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i);
                skipMessage(codedOutputStream);
                int iM4185makeTag = WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(iM4185makeTag);
                codedOutputStream.writeUInt32NoTag(iM4185makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T partialFrom = interfaceC0774Parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static final class IterableDirectByteBufferDecoder extends CodedInputStream {
        private int bufferSizeAfterCurrentLimit;
        private long currentAddress;
        private ByteBuffer currentByteBuffer;
        private long currentByteBufferLimit;
        private long currentByteBufferPos;
        private long currentByteBufferStartPos;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;

        /* renamed from: input */
        private final Iterable<ByteBuffer> f3575input;
        private final Iterator<ByteBuffer> iterator;

        /* renamed from: lastTag */
        private int f3576lastTag;
        private int startOffset;
        private int totalBufferSize;
        private int totalBytesRead;

        private long currentRemaining() {
            return this.currentByteBufferLimit - this.currentByteBufferPos;
        }

        private void getNextByteBuffer() throws InvalidProtocolBufferException {
            if (!this.iterator.hasNext()) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            tryGetNextByteBuffer();
        }

        private void readRawBytesTo(byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            if (i2 < 0 || i2 > remaining()) {
                if (i2 > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i2 != 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                return;
            }
            int i3 = i2;
            while (i3 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = Math.min(i3, (int) currentRemaining());
                long j = iMin;
                UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, (i2 - i3) + i, j);
                i3 -= iMin;
                this.currentByteBufferPos += j;
            }
        }

        private void recomputeBufferSizeAfterLimit() {
            int i = this.totalBufferSize + this.bufferSizeAfterCurrentLimit;
            this.totalBufferSize = i;
            int i2 = i - this.startOffset;
            int i3 = this.currentLimit;
            if (i2 <= i3) {
                this.bufferSizeAfterCurrentLimit = 0;
                return;
            }
            int i4 = i2 - i3;
            this.bufferSizeAfterCurrentLimit = i4;
            this.totalBufferSize = i - i4;
        }

        private int remaining() {
            return (int) (((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos);
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* renamed from: slice */
        private ByteBuffer m3956slice(int i, int i2) {
            int iPosition = this.currentByteBuffer.position();
            int iLimit = this.currentByteBuffer.limit();
            ByteBuffer byteBuffer = this.currentByteBuffer;
            try {
                try {
                    byteBuffer.position(i);
                    byteBuffer.limit(i2);
                    return this.currentByteBuffer.slice();
                } catch (IllegalArgumentException unused) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        private void tryGetNextByteBuffer() {
            ByteBuffer next = this.iterator.next();
            this.currentByteBuffer = next;
            this.totalBytesRead += (int) (this.currentByteBufferPos - this.currentByteBufferStartPos);
            long jPosition = next.position();
            this.currentByteBufferPos = jPosition;
            this.currentByteBufferStartPos = jPosition;
            this.currentByteBufferLimit = this.currentByteBuffer.limit();
            long jAddressOffset = UnsafeUtil.addressOffset(this.currentByteBuffer);
            this.currentAddress = jAddressOffset;
            this.currentByteBufferPos += jAddressOffset;
            this.currentByteBufferStartPos += jAddressOffset;
            this.currentByteBufferLimit += jAddressOffset;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.f3576lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean z) {
            this.enableAliasing = z;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f3576lastTag;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (((this.totalBytesRead - this.startOffset) + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        /* renamed from: isAtEnd */
        public boolean mo3954isAtEnd() {
            return (((long) this.totalBytesRead) + this.currentByteBufferPos) - this.currentByteBufferStartPos == ((long) this.totalBufferSize);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i + getTotalBytesRead();
            int i2 = this.currentLimit;
            if (totalBytesRead > i2) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j = rawVarint32;
                if (j <= currentRemaining()) {
                    if (this.immutable || !this.enableAliasing) {
                        byte[] bArr = new byte[rawVarint32];
                        UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j);
                        this.currentByteBufferPos += j;
                        return ByteBuffer.wrap(bArr);
                    }
                    long j2 = this.currentByteBufferPos + j;
                    this.currentByteBufferPos = j2;
                    long j3 = this.currentAddress;
                    return m3956slice((int) ((j2 - j3) - j), (int) (j2 - j3));
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return ByteBuffer.wrap(bArr2);
            }
            if (rawVarint32 == 0) {
                return Internal.EMPTY_BYTE_BUFFER;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public ByteString readBytes() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j = rawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j <= j2 - j3) {
                    if (this.immutable && this.enableAliasing) {
                        int i = (int) (j3 - this.currentAddress);
                        ByteString byteStringM3934wrap = ByteString.m3934wrap(m3956slice(i, rawVarint32 + i));
                        this.currentByteBufferPos += j;
                        return byteStringM3934wrap;
                    }
                    byte[] bArr = new byte[rawVarint32];
                    UnsafeUtil.copyMemory(j3, bArr, 0L, j);
                    this.currentByteBufferPos += j;
                    return ByteString.m3935wrap(bArr);
                }
            }
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return ByteString.f3559EMPTY;
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (!this.immutable || !this.enableAliasing) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return ByteString.m3935wrap(bArr2);
            }
            ArrayList arrayList = new ArrayList();
            while (rawVarint32 > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = Math.min(rawVarint32, (int) currentRemaining());
                int i2 = (int) (this.currentByteBufferPos - this.currentAddress);
                arrayList.add(ByteString.m3934wrap(m3956slice(i2, i2 + iMin)));
                rawVarint32 -= iMin;
                this.currentByteBufferPos += iMin;
            }
            return ByteString.copyFrom(arrayList);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            interfaceC0766Builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.m4185makeTag(i, 4));
            this.recursionDepth--;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void readMessage(MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            interfaceC0766Builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(iPushLimit);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            if (currentRemaining() == 0) {
                getNextByteBuffer();
            }
            long j = this.currentByteBufferPos;
            this.currentByteBufferPos = 1 + j;
            return UnsafeUtil.m4150getByte(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws InvalidProtocolBufferException {
            if (i >= 0) {
                long j = i;
                if (j <= currentRemaining()) {
                    byte[] bArr = new byte[i];
                    UnsafeUtil.copyMemory(this.currentByteBufferPos, bArr, 0L, j);
                    this.currentByteBufferPos += j;
                    return bArr;
                }
            }
            if (i >= 0 && i <= remaining()) {
                byte[] bArr2 = new byte[i];
                readRawBytesTo(bArr2, 0, i);
                return bArr2;
            }
            if (i > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() {
            if (currentRemaining() < 4) {
                return ((readRawByte() & C1126UByte.MAX_VALUE) << 24) | (readRawByte() & C1126UByte.MAX_VALUE) | ((readRawByte() & C1126UByte.MAX_VALUE) << 8) | ((readRawByte() & C1126UByte.MAX_VALUE) << 16);
            }
            long j = this.currentByteBufferPos;
            this.currentByteBufferPos = 4 + j;
            return (UnsafeUtil.m4150getByte(j) & C1126UByte.MAX_VALUE) | ((UnsafeUtil.m4150getByte(1 + j) & C1126UByte.MAX_VALUE) << 8) | ((UnsafeUtil.m4150getByte(2 + j) & C1126UByte.MAX_VALUE) << 16) | ((UnsafeUtil.m4150getByte(j + 3) & C1126UByte.MAX_VALUE) << 24);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() {
            if (currentRemaining() < 8) {
                return ((readRawByte() & 255) << 56) | (readRawByte() & 255) | ((readRawByte() & 255) << 8) | ((readRawByte() & 255) << 16) | ((readRawByte() & 255) << 24) | ((readRawByte() & 255) << 32) | ((readRawByte() & 255) << 40) | ((readRawByte() & 255) << 48);
            }
            this.currentByteBufferPos = 8 + this.currentByteBufferPos;
            return (UnsafeUtil.m4150getByte(r13) & 255) | ((UnsafeUtil.m4150getByte(1 + r13) & 255) << 8) | ((UnsafeUtil.m4150getByte(2 + r13) & 255) << 16) | ((UnsafeUtil.m4150getByte(3 + r13) & 255) << 24) | ((UnsafeUtil.m4150getByte(4 + r13) & 255) << 32) | ((UnsafeUtil.m4150getByte(5 + r13) & 255) << 40) | ((UnsafeUtil.m4150getByte(6 + r13) & 255) << 48) | ((UnsafeUtil.m4150getByte(r13 + 7) & 255) << 56);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readRawVarint32() {
            int i;
            long j = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j) {
                long j2 = j + 1;
                byte bM4150getByte = UnsafeUtil.m4150getByte(j);
                if (bM4150getByte >= 0) {
                    this.currentByteBufferPos++;
                    return bM4150getByte;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j3 = 2 + j;
                    int iM4150getByte = (UnsafeUtil.m4150getByte(j2) << 7) ^ bM4150getByte;
                    if (iM4150getByte < 0) {
                        i = iM4150getByte ^ (-128);
                    } else {
                        long j4 = 3 + j;
                        int iM4150getByte2 = (UnsafeUtil.m4150getByte(j3) << 14) ^ iM4150getByte;
                        if (iM4150getByte2 >= 0) {
                            i = iM4150getByte2 ^ 16256;
                        } else {
                            long j5 = 4 + j;
                            int iM4150getByte3 = iM4150getByte2 ^ (UnsafeUtil.m4150getByte(j4) << 21);
                            if (iM4150getByte3 < 0) {
                                i = (-2080896) ^ iM4150getByte3;
                            } else {
                                j4 = 5 + j;
                                byte bM4150getByte2 = UnsafeUtil.m4150getByte(j5);
                                int i2 = (iM4150getByte3 ^ (bM4150getByte2 << 28)) ^ 266354560;
                                if (bM4150getByte2 < 0) {
                                    j5 = 6 + j;
                                    if (UnsafeUtil.m4150getByte(j4) < 0) {
                                        j4 = 7 + j;
                                        if (UnsafeUtil.m4150getByte(j5) < 0) {
                                            j5 = 8 + j;
                                            if (UnsafeUtil.m4150getByte(j4) < 0) {
                                                j4 = 9 + j;
                                                if (UnsafeUtil.m4150getByte(j5) < 0) {
                                                    long j6 = j + 10;
                                                    if (UnsafeUtil.m4150getByte(j4) >= 0) {
                                                        i = i2;
                                                        j3 = j6;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i2;
                                }
                                i = i2;
                            }
                            j3 = j5;
                        }
                        j3 = j4;
                    }
                    this.currentByteBufferPos = j3;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j;
            long j2;
            long j3;
            long j4 = this.currentByteBufferPos;
            if (this.currentByteBufferLimit != j4) {
                long j5 = j4 + 1;
                byte bM4150getByte = UnsafeUtil.m4150getByte(j4);
                if (bM4150getByte >= 0) {
                    this.currentByteBufferPos++;
                    return bM4150getByte;
                }
                if (this.currentByteBufferLimit - this.currentByteBufferPos >= 10) {
                    long j6 = 2 + j4;
                    int iM4150getByte = (UnsafeUtil.m4150getByte(j5) << 7) ^ bM4150getByte;
                    if (iM4150getByte < 0) {
                        j = iM4150getByte ^ (-128);
                    } else {
                        long j7 = 3 + j4;
                        int iM4150getByte2 = (UnsafeUtil.m4150getByte(j6) << 14) ^ iM4150getByte;
                        if (iM4150getByte2 >= 0) {
                            j = iM4150getByte2 ^ 16256;
                            j6 = j7;
                        } else {
                            long j8 = 4 + j4;
                            int iM4150getByte3 = iM4150getByte2 ^ (UnsafeUtil.m4150getByte(j7) << 21);
                            if (iM4150getByte3 < 0) {
                                j = (-2080896) ^ iM4150getByte3;
                                j6 = j8;
                            } else {
                                long j9 = 5 + j4;
                                long jM4150getByte = (UnsafeUtil.m4150getByte(j8) << 28) ^ iM4150getByte3;
                                if (jM4150getByte >= 0) {
                                    j3 = 266354560;
                                } else {
                                    long j10 = 6 + j4;
                                    long jM4150getByte2 = jM4150getByte ^ (UnsafeUtil.m4150getByte(j9) << 35);
                                    if (jM4150getByte2 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        j9 = 7 + j4;
                                        jM4150getByte = jM4150getByte2 ^ (UnsafeUtil.m4150getByte(j10) << 42);
                                        if (jM4150getByte >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            j10 = 8 + j4;
                                            jM4150getByte2 = jM4150getByte ^ (UnsafeUtil.m4150getByte(j9) << 49);
                                            if (jM4150getByte2 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                j9 = 9 + j4;
                                                long jM4150getByte3 = (jM4150getByte2 ^ (UnsafeUtil.m4150getByte(j10) << 56)) ^ 71499008037633920L;
                                                if (jM4150getByte3 < 0) {
                                                    long j11 = j4 + 10;
                                                    if (UnsafeUtil.m4150getByte(j9) >= 0) {
                                                        j = jM4150getByte3;
                                                        j6 = j11;
                                                    }
                                                } else {
                                                    j = jM4150getByte3;
                                                    j6 = j9;
                                                }
                                            }
                                        }
                                    }
                                    j = j2 ^ jM4150getByte2;
                                    j6 = j10;
                                }
                                j = j3 ^ jM4150getByte;
                                j6 = j9;
                            }
                        }
                    }
                    this.currentByteBufferPos = j6;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & ByteCompanionObject.MAX_VALUE) << i;
                if ((readRawByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j = rawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j <= j2 - j3) {
                    byte[] bArr = new byte[rawVarint32];
                    UnsafeUtil.copyMemory(j3, bArr, 0L, j);
                    String str = new String(bArr, Internal.f3692UTF_8);
                    this.currentByteBufferPos += j;
                    return str;
                }
            }
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                byte[] bArr2 = new byte[rawVarint32];
                readRawBytesTo(bArr2, 0, rawVarint32);
                return new String(bArr2, Internal.f3692UTF_8);
            }
            if (rawVarint32 == 0) {
                return BuildConfig.f24315FLAVOR;
            }
            if (rawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                long j = rawVarint32;
                long j2 = this.currentByteBufferLimit;
                long j3 = this.currentByteBufferPos;
                if (j <= j2 - j3) {
                    String strDecodeUtf8 = C0801Utf8.decodeUtf8(this.currentByteBuffer, (int) (j3 - this.currentByteBufferStartPos), rawVarint32);
                    this.currentByteBufferPos += j;
                    return strDecodeUtf8;
                }
            }
            if (rawVarint32 >= 0 && rawVarint32 <= remaining()) {
                byte[] bArr = new byte[rawVarint32];
                readRawBytesTo(bArr, 0, rawVarint32);
                return C0801Utf8.decodeUtf8(bArr, 0, rawVarint32);
            }
            if (rawVarint32 == 0) {
                return BuildConfig.f24315FLAVOR;
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        /* renamed from: readTag */
        public int mo3955readTag() throws InvalidProtocolBufferException {
            if (mo3954isAtEnd()) {
                this.f3576lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.f3576lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.f3576lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder) throws InvalidProtocolBufferException {
            readGroup(i, interfaceC0766Builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startOffset = (int) ((this.totalBytesRead + this.currentByteBufferPos) - this.currentByteBufferStartPos);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean skipField(int i) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipMessage() throws InvalidProtocolBufferException {
            int iMo3955readTag;
            do {
                iMo3955readTag = mo3955readTag();
                if (iMo3955readTag == 0) {
                    return;
                }
            } while (skipField(iMo3955readTag));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws InvalidProtocolBufferException {
            if (i < 0 || i > ((this.totalBufferSize - this.totalBytesRead) - this.currentByteBufferPos) + this.currentByteBufferStartPos) {
                if (i >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            while (i > 0) {
                if (currentRemaining() == 0) {
                    getNextByteBuffer();
                }
                int iMin = Math.min(i, (int) currentRemaining());
                i -= iMin;
                this.currentByteBufferPos += iMin;
            }
        }

        private IterableDirectByteBufferDecoder(Iterable<ByteBuffer> iterable, int i, boolean z) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.totalBufferSize = i;
            this.f3575input = iterable;
            this.iterator = iterable.iterator();
            this.immutable = z;
            this.totalBytesRead = 0;
            this.startOffset = 0;
            if (i != 0) {
                tryGetNextByteBuffer();
                return;
            }
            this.currentByteBuffer = Internal.EMPTY_BYTE_BUFFER;
            this.currentByteBufferPos = 0L;
            this.currentByteBufferStartPos = 0L;
            this.currentByteBufferLimit = 0L;
            this.currentAddress = 0L;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int iMo3955readTag;
            do {
                iMo3955readTag = mo3955readTag();
                if (iMo3955readTag == 0) {
                    return;
                }
            } while (skipField(iMo3955readTag, codedOutputStream));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            T partialFrom = interfaceC0774Parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.m4185makeTag(i, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i);
                skipMessage(codedOutputStream);
                int iM4185makeTag = WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(iM4185makeTag);
                codedOutputStream.writeUInt32NoTag(iM4185makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T partialFrom = interfaceC0774Parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static final class StreamDecoder extends CodedInputStream {

        /* renamed from: buffer */
        private final byte[] f3577buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;

        /* renamed from: input */
        private final InputStream f3578input;

        /* renamed from: lastTag */
        private int f3579lastTag;

        /* renamed from: pos */
        private int f3580pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        public interface RefillCallback {
            void onRefill();
        }

        public class SkippedDataSink implements RefillCallback {
            private ByteArrayOutputStream byteArrayStream;

            /* renamed from: lastPos */
            private int f3581lastPos;

            private SkippedDataSink() {
                this.f3581lastPos = StreamDecoder.this.f3580pos;
            }

            public ByteBuffer getSkippedData() {
                ByteArrayOutputStream byteArrayOutputStream = this.byteArrayStream;
                if (byteArrayOutputStream == null) {
                    return ByteBuffer.wrap(StreamDecoder.this.f3577buffer, this.f3581lastPos, StreamDecoder.this.f3580pos - this.f3581lastPos);
                }
                byteArrayOutputStream.write(StreamDecoder.this.f3577buffer, this.f3581lastPos, StreamDecoder.this.f3580pos);
                return ByteBuffer.wrap(this.byteArrayStream.toByteArray());
            }

            @Override // com.google.crypto.tink.shaded.protobuf.CodedInputStream.StreamDecoder.RefillCallback
            public void onRefill() {
                if (this.byteArrayStream == null) {
                    this.byteArrayStream = new ByteArrayOutputStream();
                }
                this.byteArrayStream.write(StreamDecoder.this.f3577buffer, this.f3581lastPos, StreamDecoder.this.f3580pos - this.f3581lastPos);
                this.f3581lastPos = 0;
            }
        }

        private static int available(InputStream inputStream) throws InvalidProtocolBufferException {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        /* renamed from: read */
        private static int m3957read(InputStream inputStream, byte[] bArr, int i, int i2) throws InvalidProtocolBufferException {
            try {
                return inputStream.read(bArr, i, i2);
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        private ByteString readBytesSlowPath(int i) throws IOException {
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i);
            if (rawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(rawBytesSlowPathOneChunk);
            }
            int i2 = this.f3580pos;
            int i3 = this.bufferSize;
            int length = i3 - i2;
            this.totalBytesRetired += i3;
            this.f3580pos = 0;
            this.bufferSize = 0;
            List<byte[]> rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.f3577buffer, i2, bArr, 0, length);
            for (byte[] bArr2 : rawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return ByteString.m3935wrap(bArr);
        }

        private byte[] readRawBytesSlowPath(int i, boolean z) throws IOException {
            byte[] rawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i);
            if (rawBytesSlowPathOneChunk != null) {
                return z ? (byte[]) rawBytesSlowPathOneChunk.clone() : rawBytesSlowPathOneChunk;
            }
            int i2 = this.f3580pos;
            int i3 = this.bufferSize;
            int length = i3 - i2;
            this.totalBytesRetired += i3;
            this.f3580pos = 0;
            this.bufferSize = 0;
            List<byte[]> rawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i - length);
            byte[] bArr = new byte[i];
            System.arraycopy(this.f3577buffer, i2, bArr, 0, length);
            for (byte[] bArr2 : rawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
                length += bArr2.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(int i) throws InvalidProtocolBufferException {
            if (i == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i2 = this.totalBytesRetired;
            int i3 = this.f3580pos;
            int i4 = i2 + i3 + i;
            if (i4 - this.sizeLimit > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i5 = this.currentLimit;
            if (i4 > i5) {
                skipRawBytes((i5 - i2) - i3);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i6 = this.bufferSize - i3;
            int i7 = i - i6;
            if (i7 >= 4096 && i7 > available(this.f3578input)) {
                return null;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.f3577buffer, this.f3580pos, bArr, 0, i6);
            this.totalBytesRetired += this.bufferSize;
            this.f3580pos = 0;
            this.bufferSize = 0;
            while (i6 < i) {
                int iM3957read = m3957read(this.f3578input, bArr, i6, i - i6);
                if (iM3957read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += iM3957read;
                i6 += iM3957read;
            }
            return bArr;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int i) throws IOException {
            ArrayList arrayList = new ArrayList();
            while (i > 0) {
                int iMin = Math.min(i, 4096);
                byte[] bArr = new byte[iMin];
                int i2 = 0;
                while (i2 < iMin) {
                    int i3 = this.f3578input.read(bArr, i2, iMin - i2);
                    if (i3 == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += i3;
                    i2 += i3;
                }
                i -= iMin;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i;
            int i2 = this.totalBytesRetired + i;
            int i3 = this.currentLimit;
            if (i2 <= i3) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i4 = i2 - i3;
            this.bufferSizeAfterLimit = i4;
            this.bufferSize = i - i4;
        }

        private void refillBuffer(int i) throws InvalidProtocolBufferException {
            if (tryRefillBuffer(i)) {
                return;
            }
            if (i <= (this.sizeLimit - this.totalBytesRetired) - this.f3580pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }

        /* renamed from: skip */
        private static long m3958skip(InputStream inputStream, long j) throws InvalidProtocolBufferException {
            try {
                return inputStream.skip(j);
            } catch (InvalidProtocolBufferException e) {
                e.setThrownFromInputStream();
                throw e;
            }
        }

        private void skipRawBytesSlowPath(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i2 = this.totalBytesRetired;
            int i3 = this.f3580pos;
            int i4 = i2 + i3 + i;
            int i5 = this.currentLimit;
            if (i4 > i5) {
                skipRawBytes((i5 - i2) - i3);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i6 = 0;
            if (this.refillCallback == null) {
                this.totalBytesRetired = i2 + i3;
                int i7 = this.bufferSize - i3;
                this.bufferSize = 0;
                this.f3580pos = 0;
                i6 = i7;
                while (i6 < i) {
                    try {
                        long j = i - i6;
                        long jM3958skip = m3958skip(this.f3578input, j);
                        if (jM3958skip < 0 || jM3958skip > j) {
                            throw new IllegalStateException(this.f3578input.getClass() + "#skip returned invalid result: " + jM3958skip + "\nThe InputStream implementation is buggy.");
                        }
                        if (jM3958skip == 0) {
                            break;
                        } else {
                            i6 += (int) jM3958skip;
                        }
                    } finally {
                        this.totalBytesRetired += i6;
                        recomputeBufferSizeAfterLimit();
                    }
                }
            }
            if (i6 >= i) {
                return;
            }
            int i8 = this.bufferSize;
            int i9 = i8 - this.f3580pos;
            this.f3580pos = i8;
            refillBuffer(1);
            while (true) {
                int i10 = i - i9;
                int i11 = this.bufferSize;
                if (i10 <= i11) {
                    this.f3580pos = i10;
                    return;
                } else {
                    i9 += i11;
                    this.f3580pos = i11;
                    refillBuffer(1);
                }
            }
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            if (this.bufferSize - this.f3580pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                byte[] bArr = this.f3577buffer;
                int i2 = this.f3580pos;
                this.f3580pos = i2 + 1;
                if (bArr[i2] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int i) throws InvalidProtocolBufferException {
            int i2 = this.f3580pos;
            if (i2 + i <= this.bufferSize) {
                throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
            }
            int i3 = this.sizeLimit;
            int i4 = this.totalBytesRetired;
            if (i > (i3 - i4) - i2 || i4 + i2 + i > this.currentLimit) {
                return false;
            }
            RefillCallback refillCallback = this.refillCallback;
            if (refillCallback != null) {
                refillCallback.onRefill();
            }
            int i5 = this.f3580pos;
            if (i5 > 0) {
                int i6 = this.bufferSize;
                if (i6 > i5) {
                    byte[] bArr = this.f3577buffer;
                    System.arraycopy(bArr, i5, bArr, 0, i6 - i5);
                }
                this.totalBytesRetired += i5;
                this.bufferSize -= i5;
                this.f3580pos = 0;
            }
            InputStream inputStream = this.f3578input;
            byte[] bArr2 = this.f3577buffer;
            int i7 = this.bufferSize;
            int iM3957read = m3957read(inputStream, bArr2, i7, Math.min(bArr2.length - i7, (this.sizeLimit - this.totalBytesRetired) - i7));
            if (iM3957read == 0 || iM3957read < -1 || iM3957read > this.f3577buffer.length) {
                throw new IllegalStateException(this.f3578input.getClass() + "#read(byte[]) returned invalid result: " + iM3957read + "\nThe InputStream implementation is buggy.");
            }
            if (iM3957read <= 0) {
                return false;
            }
            this.bufferSize += iM3957read;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize >= i) {
                return true;
            }
            return tryRefillBuffer(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.f3579lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean z) {
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - (this.totalBytesRetired + this.f3580pos);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f3579lastTag;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.f3580pos;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        /* renamed from: isAtEnd */
        public boolean mo3954isAtEnd() {
            return this.f3580pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i2 = i + this.totalBytesRetired + this.f3580pos;
            int i3 = this.currentLimit;
            if (i2 > i3) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = i2;
            recomputeBufferSizeAfterLimit();
            return i3;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte[] readByteArray() {
            int rawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.f3580pos;
            if (rawVarint32 > i - i2 || rawVarint32 <= 0) {
                return readRawBytesSlowPath(rawVarint32, false);
            }
            byte[] bArrCopyOfRange = Arrays.copyOfRange(this.f3577buffer, i2, i2 + rawVarint32);
            this.f3580pos += rawVarint32;
            return bArrCopyOfRange;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() {
            int rawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.f3580pos;
            if (rawVarint32 > i - i2 || rawVarint32 <= 0) {
                return rawVarint32 == 0 ? Internal.EMPTY_BYTE_BUFFER : ByteBuffer.wrap(readRawBytesSlowPath(rawVarint32, true));
            }
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(Arrays.copyOfRange(this.f3577buffer, i2, i2 + rawVarint32));
            this.f3580pos += rawVarint32;
            return byteBufferWrap;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public ByteString readBytes() {
            int rawVarint32 = readRawVarint32();
            int i = this.bufferSize;
            int i2 = this.f3580pos;
            if (rawVarint32 > i - i2 || rawVarint32 <= 0) {
                return rawVarint32 == 0 ? ByteString.f3559EMPTY : readBytesSlowPath(rawVarint32);
            }
            ByteString byteStringCopyFrom = ByteString.copyFrom(this.f3577buffer, i2, rawVarint32);
            this.f3580pos += rawVarint32;
            return byteStringCopyFrom;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            interfaceC0766Builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.m4185makeTag(i, 4));
            this.recursionDepth--;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void readMessage(MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            interfaceC0766Builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(iPushLimit);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            if (this.f3580pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.f3577buffer;
            int i = this.f3580pos;
            this.f3580pos = i + 1;
            return bArr[i];
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) {
            int i2 = this.f3580pos;
            if (i > this.bufferSize - i2 || i <= 0) {
                return readRawBytesSlowPath(i, false);
            }
            int i3 = i + i2;
            this.f3580pos = i3;
            return Arrays.copyOfRange(this.f3577buffer, i2, i3);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws InvalidProtocolBufferException {
            int i = this.f3580pos;
            if (this.bufferSize - i < 4) {
                refillBuffer(4);
                i = this.f3580pos;
            }
            byte[] bArr = this.f3577buffer;
            this.f3580pos = i + 4;
            return (bArr[i] & C1126UByte.MAX_VALUE) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16) | ((bArr[i + 3] & C1126UByte.MAX_VALUE) << 24);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            int i = this.f3580pos;
            if (this.bufferSize - i < 8) {
                refillBuffer(8);
                i = this.f3580pos;
            }
            byte[] bArr = this.f3577buffer;
            this.f3580pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readRawVarint32() {
            int i;
            int i2 = this.f3580pos;
            int i3 = this.bufferSize;
            if (i3 != i2) {
                byte[] bArr = this.f3577buffer;
                int i4 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0) {
                    this.f3580pos = i4;
                    return b;
                }
                if (i3 - i4 >= 9) {
                    int i5 = i2 + 2;
                    int i6 = (bArr[i4] << 7) ^ b;
                    if (i6 < 0) {
                        i = i6 ^ (-128);
                    } else {
                        int i7 = i2 + 3;
                        int i8 = (bArr[i5] << 14) ^ i6;
                        if (i8 >= 0) {
                            i = i8 ^ 16256;
                        } else {
                            int i9 = i2 + 4;
                            int i10 = i8 ^ (bArr[i7] << 21);
                            if (i10 < 0) {
                                i = (-2080896) ^ i10;
                            } else {
                                i7 = i2 + 5;
                                byte b2 = bArr[i9];
                                int i11 = (i10 ^ (b2 << 28)) ^ 266354560;
                                if (b2 < 0) {
                                    i9 = i2 + 6;
                                    if (bArr[i7] < 0) {
                                        i7 = i2 + 7;
                                        if (bArr[i9] < 0) {
                                            i9 = i2 + 8;
                                            if (bArr[i7] < 0) {
                                                i7 = i2 + 9;
                                                if (bArr[i9] < 0) {
                                                    int i12 = i2 + 10;
                                                    if (bArr[i7] >= 0) {
                                                        i5 = i12;
                                                        i = i11;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = i11;
                                }
                                i = i11;
                            }
                            i5 = i9;
                        }
                        i5 = i7;
                    }
                    this.f3580pos = i5;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j;
            long j2;
            long j3;
            int i = this.f3580pos;
            int i2 = this.bufferSize;
            if (i2 != i) {
                byte[] bArr = this.f3577buffer;
                int i3 = i + 1;
                byte b = bArr[i];
                if (b >= 0) {
                    this.f3580pos = i3;
                    return b;
                }
                if (i2 - i3 >= 9) {
                    int i4 = i + 2;
                    int i5 = (bArr[i3] << 7) ^ b;
                    if (i5 < 0) {
                        j = i5 ^ (-128);
                    } else {
                        int i6 = i + 3;
                        int i7 = (bArr[i4] << 14) ^ i5;
                        if (i7 >= 0) {
                            j = i7 ^ 16256;
                            i4 = i6;
                        } else {
                            int i8 = i + 4;
                            int i9 = i7 ^ (bArr[i6] << 21);
                            if (i9 < 0) {
                                long j4 = (-2080896) ^ i9;
                                i4 = i8;
                                j = j4;
                            } else {
                                long j5 = i9;
                                i4 = i + 5;
                                long j6 = j5 ^ (bArr[i8] << 28);
                                if (j6 >= 0) {
                                    j3 = 266354560;
                                } else {
                                    int i10 = i + 6;
                                    long j7 = j6 ^ (bArr[i4] << 35);
                                    if (j7 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        i4 = i + 7;
                                        j6 = j7 ^ (bArr[i10] << 42);
                                        if (j6 >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            i10 = i + 8;
                                            j7 = j6 ^ (bArr[i4] << 49);
                                            if (j7 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                i4 = i + 9;
                                                long j8 = (j7 ^ (bArr[i10] << 56)) ^ 71499008037633920L;
                                                if (j8 < 0) {
                                                    int i11 = i + 10;
                                                    if (bArr[i4] >= 0) {
                                                        i4 = i11;
                                                    }
                                                }
                                                j = j8;
                                            }
                                        }
                                    }
                                    j = j7 ^ j2;
                                    i4 = i10;
                                }
                                j = j6 ^ j3;
                            }
                        }
                    }
                    this.f3580pos = i4;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & ByteCompanionObject.MAX_VALUE) << i;
                if ((readRawByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0) {
                int i = this.bufferSize;
                int i2 = this.f3580pos;
                if (rawVarint32 <= i - i2) {
                    String str = new String(this.f3577buffer, i2, rawVarint32, Internal.f3692UTF_8);
                    this.f3580pos += rawVarint32;
                    return str;
                }
            }
            if (rawVarint32 == 0) {
                return BuildConfig.f24315FLAVOR;
            }
            if (rawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(rawVarint32, false), Internal.f3692UTF_8);
            }
            refillBuffer(rawVarint32);
            String str2 = new String(this.f3577buffer, this.f3580pos, rawVarint32, Internal.f3692UTF_8);
            this.f3580pos += rawVarint32;
            return str2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws IOException {
            byte[] rawBytesSlowPath;
            int rawVarint32 = readRawVarint32();
            int i = this.f3580pos;
            int i2 = this.bufferSize;
            if (rawVarint32 <= i2 - i && rawVarint32 > 0) {
                rawBytesSlowPath = this.f3577buffer;
                this.f3580pos = i + rawVarint32;
            } else {
                if (rawVarint32 == 0) {
                    return BuildConfig.f24315FLAVOR;
                }
                i = 0;
                if (rawVarint32 <= i2) {
                    refillBuffer(rawVarint32);
                    rawBytesSlowPath = this.f3577buffer;
                    this.f3580pos = rawVarint32;
                } else {
                    rawBytesSlowPath = readRawBytesSlowPath(rawVarint32, false);
                }
            }
            return C0801Utf8.decodeUtf8(rawBytesSlowPath, i, rawVarint32);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        /* renamed from: readTag */
        public int mo3955readTag() throws InvalidProtocolBufferException {
            if (mo3954isAtEnd()) {
                this.f3579lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.f3579lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.f3579lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder) throws InvalidProtocolBufferException {
            readGroup(i, interfaceC0766Builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.totalBytesRetired = -this.f3580pos;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean skipField(int i) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipMessage() throws InvalidProtocolBufferException {
            int iMo3955readTag;
            do {
                iMo3955readTag = mo3955readTag();
                if (iMo3955readTag == 0) {
                    return;
                }
            } while (skipField(iMo3955readTag));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws InvalidProtocolBufferException {
            int i2 = this.bufferSize;
            int i3 = this.f3580pos;
            if (i > i2 - i3 || i < 0) {
                skipRawBytesSlowPath(i);
            } else {
                this.f3580pos = i3 + i;
            }
        }

        private StreamDecoder(InputStream inputStream, int i) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.refillCallback = null;
            Internal.checkNotNull(inputStream, "input");
            this.f3578input = inputStream;
            this.f3577buffer = new byte[i];
            this.bufferSize = 0;
            this.f3580pos = 0;
            this.totalBytesRetired = 0;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int iMo3955readTag;
            do {
                iMo3955readTag = mo3955readTag();
                if (iMo3955readTag == 0) {
                    return;
                }
            } while (skipField(iMo3955readTag, codedOutputStream));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            T partialFrom = interfaceC0774Parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.m4185makeTag(i, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i);
                skipMessage(codedOutputStream);
                int iM4185makeTag = WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(iM4185makeTag);
                codedOutputStream.writeUInt32NoTag(iM4185makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T partialFrom = interfaceC0774Parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static final class UnsafeDirectNioDecoder extends CodedInputStream {

        /* renamed from: address */
        private final long f3583address;

        /* renamed from: buffer */
        private final ByteBuffer f3584buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;

        /* renamed from: lastTag */
        private int f3585lastTag;

        /* renamed from: limit */
        private long f3586limit;

        /* renamed from: pos */
        private long f3587pos;
        private long startPos;

        private int bufferPos(long j) {
            return (int) (j - this.f3583address);
        }

        public static boolean isSupported() {
            return UnsafeUtil.hasUnsafeByteBufferOperations();
        }

        private void recomputeBufferSizeAfterLimit() {
            long j = this.f3586limit + this.bufferSizeAfterLimit;
            this.f3586limit = j;
            int i = (int) (j - this.startPos);
            int i2 = this.currentLimit;
            if (i <= i2) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i3 = i - i2;
            this.bufferSizeAfterLimit = i3;
            this.f3586limit = j - i3;
        }

        private int remaining() {
            return (int) (this.f3586limit - this.f3587pos);
        }

        private void skipRawVarint() throws InvalidProtocolBufferException {
            if (remaining() >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                long j = this.f3587pos;
                this.f3587pos = 1 + j;
                if (UnsafeUtil.m4150getByte(j) >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        /* renamed from: slice */
        private ByteBuffer m3959slice(long j, long j2) {
            int iPosition = this.f3584buffer.position();
            int iLimit = this.f3584buffer.limit();
            ByteBuffer byteBuffer = this.f3584buffer;
            try {
                try {
                    byteBuffer.position(bufferPos(j));
                    byteBuffer.limit(bufferPos(j2));
                    return this.f3584buffer.slice();
                } catch (IllegalArgumentException e) {
                    InvalidProtocolBufferException invalidProtocolBufferExceptionTruncatedMessage = InvalidProtocolBufferException.truncatedMessage();
                    invalidProtocolBufferExceptionTruncatedMessage.initCause(e);
                    throw invalidProtocolBufferExceptionTruncatedMessage;
                }
            } finally {
                byteBuffer.position(iPosition);
                byteBuffer.limit(iLimit);
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void checkLastTagWas(int i) throws InvalidProtocolBufferException {
            if (this.f3585lastTag != i) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void enableAliasing(boolean z) {
            this.enableAliasing = z;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getBytesUntilLimit() {
            int i = this.currentLimit;
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
            return i - getTotalBytesRead();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getLastTag() {
            return this.f3585lastTag;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return (int) (this.f3587pos - this.startPos);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        /* renamed from: isAtEnd */
        public boolean mo3954isAtEnd() {
            return this.f3587pos == this.f3586limit;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void popLimit(int i) {
            this.currentLimit = i;
            recomputeBufferSizeAfterLimit();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int pushLimit(int i) throws InvalidProtocolBufferException {
            if (i < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i + getTotalBytesRead();
            int i2 = this.currentLimit;
            if (totalBytesRead > i2) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte[] readByteArray() {
            return readRawBytes(readRawVarint32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public ByteBuffer readByteBuffer() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return Internal.EMPTY_BYTE_BUFFER;
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable || !this.enableAliasing) {
                byte[] bArr = new byte[rawVarint32];
                long j = rawVarint32;
                UnsafeUtil.copyMemory(this.f3587pos, bArr, 0L, j);
                this.f3587pos += j;
                return ByteBuffer.wrap(bArr);
            }
            long j2 = this.f3587pos;
            long j3 = rawVarint32;
            ByteBuffer byteBufferM3959slice = m3959slice(j2, j2 + j3);
            this.f3587pos += j3;
            return byteBufferM3959slice;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public ByteString readBytes() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return ByteString.f3559EMPTY;
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (this.immutable && this.enableAliasing) {
                long j = this.f3587pos;
                long j2 = rawVarint32;
                ByteBuffer byteBufferM3959slice = m3959slice(j, j + j2);
                this.f3587pos += j2;
                return ByteString.m3934wrap(byteBufferM3959slice);
            }
            byte[] bArr = new byte[rawVarint32];
            long j3 = rawVarint32;
            UnsafeUtil.copyMemory(this.f3587pos, bArr, 0L, j3);
            this.f3587pos += j3;
            return ByteString.m3935wrap(bArr);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void readGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            interfaceC0766Builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.m4185makeTag(i, 4));
            this.recursionDepth--;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void readMessage(MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            interfaceC0766Builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() != 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            popLimit(iPushLimit);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte readRawByte() throws InvalidProtocolBufferException {
            long j = this.f3587pos;
            if (j == this.f3586limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f3587pos = 1 + j;
            return UnsafeUtil.m4150getByte(j);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public byte[] readRawBytes(int i) throws InvalidProtocolBufferException {
            if (i < 0 || i > remaining()) {
                if (i > 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                if (i == 0) {
                    return Internal.EMPTY_BYTE_ARRAY;
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
            byte[] bArr = new byte[i];
            long j = this.f3587pos;
            long j2 = i;
            m3959slice(j, j + j2).get(bArr);
            this.f3587pos += j2;
            return bArr;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readRawLittleEndian32() throws InvalidProtocolBufferException {
            long j = this.f3587pos;
            if (this.f3586limit - j < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f3587pos = 4 + j;
            return (UnsafeUtil.m4150getByte(j) & C1126UByte.MAX_VALUE) | ((UnsafeUtil.m4150getByte(1 + j) & C1126UByte.MAX_VALUE) << 8) | ((UnsafeUtil.m4150getByte(2 + j) & C1126UByte.MAX_VALUE) << 16) | ((UnsafeUtil.m4150getByte(j + 3) & C1126UByte.MAX_VALUE) << 24);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawLittleEndian64() throws InvalidProtocolBufferException {
            long j = this.f3587pos;
            if (this.f3586limit - j < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.f3587pos = 8 + j;
            return ((UnsafeUtil.m4150getByte(j + 7) & 255) << 56) | (UnsafeUtil.m4150getByte(j) & 255) | ((UnsafeUtil.m4150getByte(1 + j) & 255) << 8) | ((UnsafeUtil.m4150getByte(2 + j) & 255) << 16) | ((UnsafeUtil.m4150getByte(3 + j) & 255) << 24) | ((UnsafeUtil.m4150getByte(4 + j) & 255) << 32) | ((UnsafeUtil.m4150getByte(5 + j) & 255) << 40) | ((UnsafeUtil.m4150getByte(6 + j) & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x008c, code lost:
        
            if (com.p038google.p061crypto.p062tink.p074shaded.protobuf.UnsafeUtil.m4150getByte(r3) < 0) goto L34;
         */
        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int readRawVarint32() {
            int i;
            long j = this.f3587pos;
            if (this.f3586limit != j) {
                long j2 = 1 + j;
                byte bM4150getByte = UnsafeUtil.m4150getByte(j);
                if (bM4150getByte >= 0) {
                    this.f3587pos = j2;
                    return bM4150getByte;
                }
                if (this.f3586limit - j2 >= 9) {
                    long j3 = 2 + j;
                    int iM4150getByte = (UnsafeUtil.m4150getByte(j2) << 7) ^ bM4150getByte;
                    if (iM4150getByte < 0) {
                        i = iM4150getByte ^ (-128);
                    } else {
                        long j4 = 3 + j;
                        int iM4150getByte2 = iM4150getByte ^ (UnsafeUtil.m4150getByte(j3) << 14);
                        if (iM4150getByte2 >= 0) {
                            i = iM4150getByte2 ^ 16256;
                        } else {
                            j3 = 4 + j;
                            int iM4150getByte3 = iM4150getByte2 ^ (UnsafeUtil.m4150getByte(j4) << 21);
                            if (iM4150getByte3 < 0) {
                                i = (-2080896) ^ iM4150getByte3;
                            } else {
                                j4 = 5 + j;
                                byte bM4150getByte2 = UnsafeUtil.m4150getByte(j3);
                                int i2 = (iM4150getByte3 ^ (bM4150getByte2 << 28)) ^ 266354560;
                                if (bM4150getByte2 < 0) {
                                    j3 = 6 + j;
                                    if (UnsafeUtil.m4150getByte(j4) < 0) {
                                        j4 = 7 + j;
                                        if (UnsafeUtil.m4150getByte(j3) < 0) {
                                            j3 = 8 + j;
                                            if (UnsafeUtil.m4150getByte(j4) < 0) {
                                                j4 = j + 9;
                                                if (UnsafeUtil.m4150getByte(j3) < 0) {
                                                    j3 = 10 + j;
                                                }
                                            }
                                        }
                                    }
                                    i = i2;
                                }
                                i = i2;
                            }
                        }
                        j3 = j4;
                    }
                    this.f3587pos = j3;
                    return i;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawVarint64() {
            long j;
            long j2;
            long j3;
            int i;
            long j4 = this.f3587pos;
            if (this.f3586limit != j4) {
                long j5 = 1 + j4;
                byte bM4150getByte = UnsafeUtil.m4150getByte(j4);
                if (bM4150getByte >= 0) {
                    this.f3587pos = j5;
                    return bM4150getByte;
                }
                if (this.f3586limit - j5 >= 9) {
                    long j6 = 2 + j4;
                    int iM4150getByte = (UnsafeUtil.m4150getByte(j5) << 7) ^ bM4150getByte;
                    if (iM4150getByte >= 0) {
                        long j7 = 3 + j4;
                        int iM4150getByte2 = iM4150getByte ^ (UnsafeUtil.m4150getByte(j6) << 14);
                        if (iM4150getByte2 >= 0) {
                            j = iM4150getByte2 ^ 16256;
                            j6 = j7;
                        } else {
                            j6 = 4 + j4;
                            int iM4150getByte3 = iM4150getByte2 ^ (UnsafeUtil.m4150getByte(j7) << 21);
                            if (iM4150getByte3 < 0) {
                                i = (-2080896) ^ iM4150getByte3;
                            } else {
                                long j8 = 5 + j4;
                                long jM4150getByte = iM4150getByte3 ^ (UnsafeUtil.m4150getByte(j6) << 28);
                                if (jM4150getByte >= 0) {
                                    j3 = 266354560;
                                } else {
                                    long j9 = 6 + j4;
                                    long jM4150getByte2 = jM4150getByte ^ (UnsafeUtil.m4150getByte(j8) << 35);
                                    if (jM4150getByte2 < 0) {
                                        j2 = -34093383808L;
                                    } else {
                                        j8 = 7 + j4;
                                        jM4150getByte = jM4150getByte2 ^ (UnsafeUtil.m4150getByte(j9) << 42);
                                        if (jM4150getByte >= 0) {
                                            j3 = 4363953127296L;
                                        } else {
                                            j9 = 8 + j4;
                                            jM4150getByte2 = jM4150getByte ^ (UnsafeUtil.m4150getByte(j8) << 49);
                                            if (jM4150getByte2 < 0) {
                                                j2 = -558586000294016L;
                                            } else {
                                                long j10 = j4 + 9;
                                                long jM4150getByte3 = (jM4150getByte2 ^ (UnsafeUtil.m4150getByte(j9) << 56)) ^ 71499008037633920L;
                                                if (jM4150getByte3 < 0) {
                                                    long j11 = j4 + 10;
                                                    if (UnsafeUtil.m4150getByte(j10) >= 0) {
                                                        j6 = j11;
                                                        j = jM4150getByte3;
                                                    }
                                                } else {
                                                    j = jM4150getByte3;
                                                    j6 = j10;
                                                }
                                            }
                                        }
                                    }
                                    j = j2 ^ jM4150getByte2;
                                    j6 = j9;
                                }
                                j = j3 ^ jM4150getByte;
                                j6 = j8;
                            }
                        }
                        this.f3587pos = j6;
                        return j;
                    }
                    i = iM4150getByte ^ (-128);
                    j = i;
                    this.f3587pos = j6;
                    return j;
                }
            }
            return readRawVarint64SlowPath();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readRawVarint64SlowPath() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & ByteCompanionObject.MAX_VALUE) << i;
                if ((readRawByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public String readString() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 <= 0 || rawVarint32 > remaining()) {
                if (rawVarint32 == 0) {
                    return BuildConfig.f24315FLAVOR;
                }
                if (rawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = new byte[rawVarint32];
            long j = rawVarint32;
            UnsafeUtil.copyMemory(this.f3587pos, bArr, 0L, j);
            String str = new String(bArr, Internal.f3692UTF_8);
            this.f3587pos += j;
            return str;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public String readStringRequireUtf8() throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            if (rawVarint32 > 0 && rawVarint32 <= remaining()) {
                String strDecodeUtf8 = C0801Utf8.decodeUtf8(this.f3584buffer, bufferPos(this.f3587pos), rawVarint32);
                this.f3587pos += rawVarint32;
                return strDecodeUtf8;
            }
            if (rawVarint32 == 0) {
                return BuildConfig.f24315FLAVOR;
            }
            if (rawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        /* renamed from: readTag */
        public int mo3955readTag() throws InvalidProtocolBufferException {
            if (mo3954isAtEnd()) {
                this.f3585lastTag = 0;
                return 0;
            }
            int rawVarint32 = readRawVarint32();
            this.f3585lastTag = rawVarint32;
            if (WireFormat.getTagFieldNumber(rawVarint32) != 0) {
                return this.f3585lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        @Deprecated
        public void readUnknownGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder) throws InvalidProtocolBufferException {
            readGroup(i, interfaceC0766Builder, ExtensionRegistryLite.getEmptyRegistry());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void resetSizeCounter() {
            this.startPos = this.f3587pos;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean skipField(int i) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(i), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipMessage() throws InvalidProtocolBufferException {
            int iMo3955readTag;
            do {
                iMo3955readTag = mo3955readTag();
                if (iMo3955readTag == 0) {
                    return;
                }
            } while (skipField(iMo3955readTag));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipRawBytes(int i) throws InvalidProtocolBufferException {
            if (i >= 0 && i <= remaining()) {
                this.f3587pos += i;
            } else {
                if (i >= 0) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                throw InvalidProtocolBufferException.negativeSize();
            }
        }

        private UnsafeDirectNioDecoder(ByteBuffer byteBuffer, boolean z) {
            super();
            this.currentLimit = Integer.MAX_VALUE;
            this.f3584buffer = byteBuffer;
            long jAddressOffset = UnsafeUtil.addressOffset(byteBuffer);
            this.f3583address = jAddressOffset;
            this.f3586limit = byteBuffer.limit() + jAddressOffset;
            long jPosition = jAddressOffset + byteBuffer.position();
            this.f3587pos = jPosition;
            this.startPos = jPosition;
            this.immutable = z;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public void skipMessage(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int iMo3955readTag;
            do {
                iMo3955readTag = mo3955readTag();
                if (iMo3955readTag == 0) {
                    return;
                }
            } while (skipField(iMo3955readTag, codedOutputStream));
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readGroup(int i, InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            checkRecursionLimit();
            this.recursionDepth++;
            T partialFrom = interfaceC0774Parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(WireFormat.m4185makeTag(i, 4));
            this.recursionDepth--;
            return partialFrom;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public boolean skipField(int i, CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException {
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                long int64 = readInt64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeUInt64NoTag(int64);
                return true;
            }
            if (tagWireType == 1) {
                long rawLittleEndian64 = readRawLittleEndian64();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed64NoTag(rawLittleEndian64);
                return true;
            }
            if (tagWireType == 2) {
                ByteString bytes = readBytes();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeBytesNoTag(bytes);
                return true;
            }
            if (tagWireType == 3) {
                codedOutputStream.writeUInt32NoTag(i);
                skipMessage(codedOutputStream);
                int iM4185makeTag = WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(i), 4);
                checkLastTagWas(iM4185makeTag);
                codedOutputStream.writeUInt32NoTag(iM4185makeTag);
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType == 5) {
                int rawLittleEndian32 = readRawLittleEndian32();
                codedOutputStream.writeUInt32NoTag(i);
                codedOutputStream.writeFixed32NoTag(rawLittleEndian32);
                return true;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.CodedInputStream
        public <T extends MessageLite> T readMessage(InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int rawVarint32 = readRawVarint32();
            checkRecursionLimit();
            int iPushLimit = pushLimit(rawVarint32);
            this.recursionDepth++;
            T partialFrom = interfaceC0774Parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            if (getBytesUntilLimit() == 0) {
                popLimit(iPushLimit);
                return partialFrom;
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    public static int decodeZigZag32(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long decodeZigZag64(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, 4096);
    }

    public static int readRawVarint32(int i, InputStream inputStream) throws IOException {
        if ((i & 128) == 0) {
            return i;
        }
        int i2 = i & 127;
        int i3 = 7;
        while (i3 < 32) {
            int i4 = inputStream.read();
            if (i4 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i2 |= (i4 & 127) << i3;
            if ((i4 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        while (i3 < 64) {
            int i5 = inputStream.read();
            if (i5 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((i5 & 128) == 0) {
                return i2;
            }
            i3 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }

    public abstract void checkLastTagWas(int i);

    public void checkRecursionLimit() throws InvalidProtocolBufferException {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public final void discardUnknownFields() {
        this.shouldDiscardUnknownFields = true;
    }

    public abstract void enableAliasing(boolean z);

    public abstract int getBytesUntilLimit();

    public abstract int getLastTag();

    public abstract int getTotalBytesRead();

    /* renamed from: isAtEnd */
    public abstract boolean mo3954isAtEnd();

    public abstract void popLimit(int i);

    public abstract int pushLimit(int i);

    public abstract boolean readBool();

    public abstract byte[] readByteArray();

    public abstract ByteBuffer readByteBuffer();

    public abstract ByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract <T extends MessageLite> T readGroup(int i, InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract <T extends MessageLite> T readMessage(InterfaceC0774Parser<T> interfaceC0774Parser, ExtensionRegistryLite extensionRegistryLite);

    public abstract void readMessage(MessageLite.InterfaceC0766Builder interfaceC0766Builder, ExtensionRegistryLite extensionRegistryLite);

    public abstract byte readRawByte();

    public abstract byte[] readRawBytes(int i);

    public abstract int readRawLittleEndian32();

    public abstract long readRawLittleEndian64();

    public abstract int readRawVarint32();

    public abstract long readRawVarint64();

    public abstract long readRawVarint64SlowPath();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    /* renamed from: readTag */
    public abstract int mo3955readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    @Deprecated
    public abstract void readUnknownGroup(int i, MessageLite.InterfaceC0766Builder interfaceC0766Builder);

    public abstract void resetSizeCounter();

    public final int setRecursionLimit(int i) {
        if (i >= 0) {
            int i2 = this.recursionLimit;
            this.recursionLimit = i;
            return i2;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i);
    }

    public final int setSizeLimit(int i) {
        if (i >= 0) {
            int i2 = this.sizeLimit;
            this.sizeLimit = i;
            return i2;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i);
    }

    public final boolean shouldDiscardUnknownFields() {
        return this.shouldDiscardUnknownFields;
    }

    public abstract boolean skipField(int i);

    @Deprecated
    public abstract boolean skipField(int i, CodedOutputStream codedOutputStream);

    public abstract void skipMessage();

    public abstract void skipMessage(CodedOutputStream codedOutputStream);

    public abstract void skipRawBytes(int i);

    public final void unsetDiscardUnknownFields() {
        this.shouldDiscardUnknownFields = false;
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = Integer.MAX_VALUE;
        this.shouldDiscardUnknownFields = false;
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i) {
        if (i > 0) {
            return inputStream == null ? newInstance(Internal.EMPTY_BYTE_ARRAY) : new StreamDecoder(inputStream, i);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable) {
        if (!UnsafeDirectNioDecoder.isSupported()) {
            return newInstance(new IterableByteBufferInputStream(iterable));
        }
        return newInstance(iterable, false);
    }

    public static int readRawVarint32(InputStream inputStream) throws IOException {
        int i = inputStream.read();
        if (i != -1) {
            return readRawVarint32(i, inputStream);
        }
        throw InvalidProtocolBufferException.truncatedMessage();
    }

    public static CodedInputStream newInstance(Iterable<ByteBuffer> iterable, boolean z) {
        int i = 0;
        int iRemaining = 0;
        for (ByteBuffer byteBuffer : iterable) {
            iRemaining += byteBuffer.remaining();
            if (byteBuffer.hasArray()) {
                i |= 1;
            } else {
                i = byteBuffer.isDirect() ? i | 2 : i | 4;
            }
        }
        if (i == 2) {
            return new IterableDirectByteBufferDecoder(iterable, iRemaining, z);
        }
        return newInstance(new IterableByteBufferInputStream(iterable));
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i2) {
        return newInstance(bArr, i, i2, false);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i, int i2, boolean z) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i, i2, z);
        try {
            arrayDecoder.pushLimit(i2);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer) {
        return newInstance(byteBuffer, false);
    }

    public static CodedInputStream newInstance(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return newInstance(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z);
        }
        if (byteBuffer.isDirect() && UnsafeDirectNioDecoder.isSupported()) {
            return new UnsafeDirectNioDecoder(byteBuffer, z);
        }
        int iRemaining = byteBuffer.remaining();
        byte[] bArr = new byte[iRemaining];
        byteBuffer.duplicate().get(bArr);
        return newInstance(bArr, 0, iRemaining, true);
    }
}
