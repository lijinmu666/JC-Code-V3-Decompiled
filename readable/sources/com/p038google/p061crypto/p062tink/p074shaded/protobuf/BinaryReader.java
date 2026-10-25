package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MapEntryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.WireFormat;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

@CheckReturnValue
/* loaded from: classes.dex */
abstract class BinaryReader implements InterfaceC0775Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.BinaryReader$1 */
    public static /* synthetic */ class C07191 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.m4187values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.f3817BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3818BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3819DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3820ENUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3821FIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3822FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3823FLOAT.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3825INT32.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3826INT64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3827MESSAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3828SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3829SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3830STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3831UINT32.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3832UINT64.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public /* synthetic */ BinaryReader(C07191 c07191) {
        this();
    }

    public static BinaryReader newInstance(ByteBuffer byteBuffer, boolean z) {
        if (byteBuffer.hasArray()) {
            return new SafeHeapReader(byteBuffer, z);
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }

    public abstract int getTotalBytesRead();

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public boolean shouldDiscardUnknownFields() {
        return false;
    }

    public static final class SafeHeapReader extends BinaryReader {

        /* renamed from: buffer */
        private final byte[] f3535buffer;
        private final boolean bufferIsImmutable;
        private int endGroupTag;
        private final int initialPos;

        /* renamed from: limit */
        private int f3536limit;

        /* renamed from: pos */
        private int f3537pos;

        /* renamed from: tag */
        private int f3538tag;

        public SafeHeapReader(ByteBuffer byteBuffer, boolean z) {
            super(null);
            this.bufferIsImmutable = z;
            this.f3535buffer = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            this.f3537pos = iArrayOffset;
            this.initialPos = iArrayOffset;
            this.f3536limit = byteBuffer.arrayOffset() + byteBuffer.limit();
        }

        /* renamed from: isAtEnd */
        private boolean m3919isAtEnd() {
            return this.f3537pos == this.f3536limit;
        }

        private byte readByte() throws InvalidProtocolBufferException {
            int i = this.f3537pos;
            if (i == this.f3536limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f3535buffer;
            this.f3537pos = i + 1;
            return bArr[i];
        }

        private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) {
            switch (C07191.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
                case 1:
                    return Boolean.valueOf(readBool());
                case 2:
                    return readBytes();
                case 3:
                    return Double.valueOf(readDouble());
                case 4:
                    return Integer.valueOf(readEnum());
                case 5:
                    return Integer.valueOf(readFixed32());
                case 6:
                    return Long.valueOf(readFixed64());
                case 7:
                    return Float.valueOf(readFloat());
                case 8:
                    return Integer.valueOf(readInt32());
                case 9:
                    return Long.valueOf(readInt64());
                case 10:
                    return readMessage(cls, extensionRegistryLite);
                case 11:
                    return Integer.valueOf(readSFixed32());
                case 12:
                    return Long.valueOf(readSFixed64());
                case 13:
                    return Integer.valueOf(readSInt32());
                case 14:
                    return Long.valueOf(readSInt64());
                case 15:
                    return readStringRequireUtf8();
                case 16:
                    return Integer.valueOf(readUInt32());
                case 17:
                    return Long.valueOf(readUInt64());
                default:
                    throw new RuntimeException("unsupported field type.");
            }
        }

        private int readLittleEndian32() throws InvalidProtocolBufferException {
            requireBytes(4);
            return readLittleEndian32_NoCheck();
        }

        private int readLittleEndian32_NoCheck() {
            int i = this.f3537pos;
            byte[] bArr = this.f3535buffer;
            this.f3537pos = i + 4;
            return (bArr[i] & C1126UByte.MAX_VALUE) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 16) | ((bArr[i + 3] & C1126UByte.MAX_VALUE) << 24);
        }

        private long readLittleEndian64() throws InvalidProtocolBufferException {
            requireBytes(8);
            return readLittleEndian64_NoCheck();
        }

        private long readLittleEndian64_NoCheck() {
            int i = this.f3537pos;
            byte[] bArr = this.f3535buffer;
            this.f3537pos = i + 8;
            return ((bArr[i + 7] & 255) << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48);
        }

        private int readVarint32() throws InvalidProtocolBufferException {
            int i;
            int i2 = this.f3537pos;
            int i3 = this.f3536limit;
            if (i3 == i2) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f3535buffer;
            int i4 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.f3537pos = i4;
                return b;
            }
            if (i3 - i4 < 9) {
                return (int) readVarint64SlowPath();
            }
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
                                            if (bArr[i7] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i5 = i12;
                                            i = i11;
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
            this.f3537pos = i5;
            return i;
        }

        private long readVarint64SlowPath() throws InvalidProtocolBufferException {
            long j = 0;
            for (int i = 0; i < 64; i += 7) {
                j |= (r3 & ByteCompanionObject.MAX_VALUE) << i;
                if ((readByte() & ByteCompanionObject.MIN_VALUE) == 0) {
                    return j;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void requireBytes(int i) throws InvalidProtocolBufferException {
            if (i < 0 || i > this.f3536limit - this.f3537pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requirePosition(int i) throws InvalidProtocolBufferException {
            if (this.f3537pos != i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
        }

        private void requireWireType(int i) throws InvalidProtocolBufferException.InvalidWireTypeException {
            if (WireFormat.getTagWireType(this.f3538tag) != i) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
        }

        private void skipBytes(int i) throws InvalidProtocolBufferException {
            requireBytes(i);
            this.f3537pos += i;
        }

        private void skipGroup() throws InvalidProtocolBufferException {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(this.f3538tag), 4);
            while (getFieldNumber() != Integer.MAX_VALUE && skipField()) {
            }
            if (this.f3538tag != this.endGroupTag) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            this.endGroupTag = i;
        }

        private void skipVarint() throws InvalidProtocolBufferException {
            int i = this.f3536limit;
            int i2 = this.f3537pos;
            if (i - i2 >= 10) {
                byte[] bArr = this.f3535buffer;
                int i3 = 0;
                while (i3 < 10) {
                    int i4 = i2 + 1;
                    if (bArr[i2] >= 0) {
                        this.f3537pos = i4;
                        return;
                    } else {
                        i3++;
                        i2 = i4;
                    }
                }
            }
            skipVarintSlowPath();
        }

        private void skipVarintSlowPath() throws InvalidProtocolBufferException {
            for (int i = 0; i < 10; i++) {
                if (readByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void verifyPackedFixed32Length(int i) throws InvalidProtocolBufferException {
            requireBytes(i);
            if ((i & 3) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        private void verifyPackedFixed64Length(int i) throws InvalidProtocolBufferException {
            requireBytes(i);
            if ((i & 7) != 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public int getFieldNumber() throws InvalidProtocolBufferException {
            if (m3919isAtEnd()) {
                return Integer.MAX_VALUE;
            }
            int varint32 = readVarint32();
            this.f3538tag = varint32;
            if (varint32 == this.endGroupTag) {
                return Integer.MAX_VALUE;
            }
            return WireFormat.getTagFieldNumber(varint32);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        /* renamed from: getTag */
        public int mo3920getTag() {
            return this.f3538tag;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.BinaryReader
        public int getTotalBytesRead() {
            return this.f3537pos - this.initialPos;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public <T> void mergeGroupField(T t, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) {
            int i = this.endGroupTag;
            this.endGroupTag = WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(this.f3538tag), 4);
            try {
                interfaceC0777Schema.mergeFrom(t, this, extensionRegistryLite);
                if (this.f3538tag == this.endGroupTag) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.endGroupTag = i;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public <T> void mergeMessageField(T t, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            int varint32 = readVarint32();
            requireBytes(varint32);
            int i = this.f3536limit;
            int i2 = this.f3537pos + varint32;
            this.f3536limit = i2;
            try {
                interfaceC0777Schema.mergeFrom(t, this, extensionRegistryLite);
                if (this.f3537pos == i2) {
                } else {
                    throw InvalidProtocolBufferException.parseFailure();
                }
            } finally {
                this.f3536limit = i;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public boolean readBool() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint32() != 0;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readBoolList(List<Boolean> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof BooleanArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.f3537pos + readVarint32();
                    while (this.f3537pos < varint32) {
                        list.add(Boolean.valueOf(readVarint32() != 0));
                    }
                    requirePosition(varint32);
                    return;
                }
                do {
                    list.add(Boolean.valueOf(readBool()));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i;
                return;
            }
            BooleanArrayList booleanArrayList = (BooleanArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.f3537pos + readVarint32();
                while (this.f3537pos < varint322) {
                    booleanArrayList.addBoolean(readVarint32() != 0);
                }
                requirePosition(varint322);
                return;
            }
            do {
                booleanArrayList.addBoolean(readBool());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i2 = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public ByteString readBytes() throws InvalidProtocolBufferException {
            requireWireType(2);
            int varint32 = readVarint32();
            if (varint32 == 0) {
                return ByteString.f3559EMPTY;
            }
            requireBytes(varint32);
            ByteString byteStringM3936wrap = this.bufferIsImmutable ? ByteString.m3936wrap(this.f3535buffer, this.f3537pos, varint32) : ByteString.copyFrom(this.f3535buffer, this.f3537pos, varint32);
            this.f3537pos += varint32;
            return byteStringM3936wrap;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readBytesList(List<ByteString> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i;
            if (WireFormat.getTagWireType(this.f3538tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(readBytes());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(1);
            return Double.longBitsToDouble(readLittleEndian64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readDoubleList(List<Double> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof DoubleArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType == 1) {
                    do {
                        list.add(Double.valueOf(readDouble()));
                        if (m3919isAtEnd()) {
                            return;
                        } else {
                            i = this.f3537pos;
                        }
                    } while (readVarint32() == this.f3538tag);
                    this.f3537pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = readVarint32();
                verifyPackedFixed64Length(varint32);
                int i3 = this.f3537pos + varint32;
                while (this.f3537pos < i3) {
                    list.add(Double.valueOf(Double.longBitsToDouble(readLittleEndian64_NoCheck())));
                }
                return;
            }
            DoubleArrayList doubleArrayList = (DoubleArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 == 1) {
                do {
                    doubleArrayList.addDouble(readDouble());
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i2 = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i2;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = readVarint32();
            verifyPackedFixed64Length(varint322);
            int i4 = this.f3537pos + varint322;
            while (this.f3537pos < i4) {
                doubleArrayList.addDouble(Double.longBitsToDouble(readLittleEndian64_NoCheck()));
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public int readEnum() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readEnumList(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.f3537pos + readVarint32();
                    while (this.f3537pos < varint32) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readEnum()));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.f3537pos + readVarint32();
                while (this.f3537pos < varint322) {
                    intArrayList.mo4038addInt(readVarint32());
                }
                return;
            }
            do {
                intArrayList.mo4038addInt(readEnum());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i2 = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public int readFixed32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readFixed32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType == 2) {
                    int varint32 = readVarint32();
                    verifyPackedFixed32Length(varint32);
                    int i3 = this.f3537pos + varint32;
                    while (this.f3537pos < i3) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(readFixed32()));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 == 2) {
                int varint322 = readVarint32();
                verifyPackedFixed32Length(varint322);
                int i4 = this.f3537pos + varint322;
                while (this.f3537pos < i4) {
                    intArrayList.mo4038addInt(readLittleEndian32_NoCheck());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.mo4038addInt(readFixed32());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i2 = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public long readFixed64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readFixed64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof LongArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readFixed64()));
                        if (m3919isAtEnd()) {
                            return;
                        } else {
                            i = this.f3537pos;
                        }
                    } while (readVarint32() == this.f3538tag);
                    this.f3537pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = readVarint32();
                verifyPackedFixed64Length(varint32);
                int i3 = this.f3537pos + varint32;
                while (this.f3537pos < i3) {
                    list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 == 1) {
                do {
                    longArrayList.mo4044addLong(readFixed64());
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i2 = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i2;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = readVarint32();
            verifyPackedFixed64Length(varint322);
            int i4 = this.f3537pos + varint322;
            while (this.f3537pos < i4) {
                longArrayList.mo4044addLong(readLittleEndian64_NoCheck());
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(5);
            return Float.intBitsToFloat(readLittleEndian32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readFloatList(List<Float> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof FloatArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType == 2) {
                    int varint32 = readVarint32();
                    verifyPackedFixed32Length(varint32);
                    int i3 = this.f3537pos + varint32;
                    while (this.f3537pos < i3) {
                        list.add(Float.valueOf(Float.intBitsToFloat(readLittleEndian32_NoCheck())));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i;
                return;
            }
            FloatArrayList floatArrayList = (FloatArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 == 2) {
                int varint322 = readVarint32();
                verifyPackedFixed32Length(varint322);
                int i4 = this.f3537pos + varint322;
                while (this.f3537pos < i4) {
                    floatArrayList.addFloat(Float.intBitsToFloat(readLittleEndian32_NoCheck()));
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                floatArrayList.addFloat(readFloat());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i2 = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        @Deprecated
        public <T> T readGroup(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(3);
            return (T) readGroup(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        @Deprecated
        public <T> T readGroupBySchemaWithCheck(InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(3);
            return (T) readGroup(interfaceC0777Schema, extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        @Deprecated
        public <T> void readGroupList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            readGroupList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public int readInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readInt32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType == 0) {
                    do {
                        list.add(Integer.valueOf(readInt32()));
                        if (m3919isAtEnd()) {
                            return;
                        } else {
                            i = this.f3537pos;
                        }
                    } while (readVarint32() == this.f3538tag);
                    this.f3537pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = this.f3537pos + readVarint32();
                while (this.f3537pos < varint32) {
                    list.add(Integer.valueOf(readVarint32()));
                }
                requirePosition(varint32);
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 == 0) {
                do {
                    intArrayList.mo4038addInt(readInt32());
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i2 = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i2;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = this.f3537pos + readVarint32();
            while (this.f3537pos < varint322) {
                intArrayList.mo4038addInt(readVarint32());
            }
            requirePosition(varint322);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public long readInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readInt64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof LongArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType == 0) {
                    do {
                        list.add(Long.valueOf(readInt64()));
                        if (m3919isAtEnd()) {
                            return;
                        } else {
                            i = this.f3537pos;
                        }
                    } while (readVarint32() == this.f3538tag);
                    this.f3537pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = this.f3537pos + readVarint32();
                while (this.f3537pos < varint32) {
                    list.add(Long.valueOf(readVarint64()));
                }
                requirePosition(varint32);
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 == 0) {
                do {
                    longArrayList.mo4044addLong(readInt64());
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i2 = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i2;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = this.f3537pos + readVarint32();
            while (this.f3537pos < varint322) {
                longArrayList.mo4044addLong(readVarint64());
            }
            requirePosition(varint322);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        /* renamed from: readMap */
        public <K, V> void mo3921readMap(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            requireWireType(2);
            int varint32 = readVarint32();
            requireBytes(varint32);
            int i = this.f3536limit;
            this.f3536limit = this.f3537pos + varint32;
            try {
                Object field = metadata.defaultKey;
                Object field2 = metadata.defaultValue;
                while (true) {
                    int fieldNumber = getFieldNumber();
                    if (fieldNumber == Integer.MAX_VALUE) {
                        map.put(field, field2);
                        return;
                    }
                    if (fieldNumber == 1) {
                        field = readField(metadata.f3722keyType, null, null);
                    } else if (fieldNumber != 2) {
                        try {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                            if (!skipField()) {
                                throw new InvalidProtocolBufferException("Unable to parse map entry.");
                            }
                        }
                    } else {
                        field2 = readField(metadata.valueType, metadata.defaultValue.getClass(), extensionRegistryLite);
                    }
                }
            } finally {
                this.f3536limit = i;
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public <T> T readMessage(Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(2);
            return (T) readMessage(Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public <T> T readMessageBySchemaWithCheck(InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(2);
            return (T) readMessage(interfaceC0777Schema, extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public <T> void readMessageList(List<T> list, Class<T> cls, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            readMessageList(list, Protobuf.getInstance().schemaFor((Class) cls), extensionRegistryLite);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public int readSFixed32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(5);
            return readLittleEndian32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readSFixed32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType == 2) {
                    int varint32 = readVarint32();
                    verifyPackedFixed32Length(varint32);
                    int i3 = this.f3537pos + varint32;
                    while (this.f3537pos < i3) {
                        list.add(Integer.valueOf(readLittleEndian32_NoCheck()));
                    }
                    return;
                }
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                do {
                    list.add(Integer.valueOf(readSFixed32()));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 == 2) {
                int varint322 = readVarint32();
                verifyPackedFixed32Length(varint322);
                int i4 = this.f3537pos + varint322;
                while (this.f3537pos < i4) {
                    intArrayList.mo4038addInt(readLittleEndian32_NoCheck());
                }
                return;
            }
            if (tagWireType2 != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                intArrayList.mo4038addInt(readSFixed32());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i2 = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public long readSFixed64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(1);
            return readLittleEndian64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readSFixed64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof LongArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType == 1) {
                    do {
                        list.add(Long.valueOf(readSFixed64()));
                        if (m3919isAtEnd()) {
                            return;
                        } else {
                            i = this.f3537pos;
                        }
                    } while (readVarint32() == this.f3538tag);
                    this.f3537pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = readVarint32();
                verifyPackedFixed64Length(varint32);
                int i3 = this.f3537pos + varint32;
                while (this.f3537pos < i3) {
                    list.add(Long.valueOf(readLittleEndian64_NoCheck()));
                }
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 == 1) {
                do {
                    longArrayList.mo4044addLong(readSFixed64());
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i2 = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i2;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = readVarint32();
            verifyPackedFixed64Length(varint322);
            int i4 = this.f3537pos + varint322;
            while (this.f3537pos < i4) {
                longArrayList.mo4044addLong(readLittleEndian64_NoCheck());
            }
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public int readSInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag32(readVarint32());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readSInt32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.f3537pos + readVarint32();
                    while (this.f3537pos < varint32) {
                        list.add(Integer.valueOf(CodedInputStream.decodeZigZag32(readVarint32())));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readSInt32()));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.f3537pos + readVarint32();
                while (this.f3537pos < varint322) {
                    intArrayList.mo4038addInt(CodedInputStream.decodeZigZag32(readVarint32()));
                }
                return;
            }
            do {
                intArrayList.mo4038addInt(readSInt32());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i2 = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public long readSInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return CodedInputStream.decodeZigZag64(readVarint64());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readSInt64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof LongArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.f3537pos + readVarint32();
                    while (this.f3537pos < varint32) {
                        list.add(Long.valueOf(CodedInputStream.decodeZigZag64(readVarint64())));
                    }
                    return;
                }
                do {
                    list.add(Long.valueOf(readSInt64()));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i;
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.f3537pos + readVarint32();
                while (this.f3537pos < varint322) {
                    longArrayList.mo4044addLong(CodedInputStream.decodeZigZag64(readVarint64()));
                }
                return;
            }
            do {
                longArrayList.mo4044addLong(readSInt64());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i2 = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public String readString() {
            return readStringInternal(false);
        }

        public String readStringInternal(boolean z) throws InvalidProtocolBufferException {
            requireWireType(2);
            int varint32 = readVarint32();
            if (varint32 == 0) {
                return BuildConfig.f24315FLAVOR;
            }
            requireBytes(varint32);
            if (z) {
                byte[] bArr = this.f3535buffer;
                int i = this.f3537pos;
                if (!C0801Utf8.isValidUtf8(bArr, i, i + varint32)) {
                    throw InvalidProtocolBufferException.invalidUtf8();
                }
            }
            String str = new String(this.f3535buffer, this.f3537pos, varint32, Internal.f3692UTF_8);
            this.f3537pos += varint32;
            return str;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readStringList(List<String> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            readStringListInternal(list, false);
        }

        public void readStringListInternal(List<String> list, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i;
            int i2;
            if (WireFormat.getTagWireType(this.f3538tag) != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            if (!(list instanceof LazyStringList) || z) {
                do {
                    list.add(readStringInternal(z));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i;
                return;
            }
            LazyStringList lazyStringList = (LazyStringList) list;
            do {
                lazyStringList.mo4058add(readBytes());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i2 = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readStringListRequireUtf8(List<String> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
            readStringListInternal(list, true);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public String readStringRequireUtf8() {
            return readStringInternal(true);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public int readUInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint32();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readUInt32List(List<Integer> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof IntArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType != 0) {
                    if (tagWireType != 2) {
                        throw InvalidProtocolBufferException.invalidWireType();
                    }
                    int varint32 = this.f3537pos + readVarint32();
                    while (this.f3537pos < varint32) {
                        list.add(Integer.valueOf(readVarint32()));
                    }
                    return;
                }
                do {
                    list.add(Integer.valueOf(readUInt32()));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i;
                return;
            }
            IntArrayList intArrayList = (IntArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 != 0) {
                if (tagWireType2 != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint322 = this.f3537pos + readVarint32();
                while (this.f3537pos < varint322) {
                    intArrayList.mo4038addInt(readVarint32());
                }
                return;
            }
            do {
                intArrayList.mo4038addInt(readUInt32());
                if (m3919isAtEnd()) {
                    return;
                } else {
                    i2 = this.f3537pos;
                }
            } while (readVarint32() == this.f3538tag);
            this.f3537pos = i2;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public long readUInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
            requireWireType(0);
            return readVarint64();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public void readUInt64List(List<Long> list) throws InvalidProtocolBufferException {
            int i;
            int i2;
            if (!(list instanceof LongArrayList)) {
                int tagWireType = WireFormat.getTagWireType(this.f3538tag);
                if (tagWireType == 0) {
                    do {
                        list.add(Long.valueOf(readUInt64()));
                        if (m3919isAtEnd()) {
                            return;
                        } else {
                            i = this.f3537pos;
                        }
                    } while (readVarint32() == this.f3538tag);
                    this.f3537pos = i;
                    return;
                }
                if (tagWireType != 2) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                int varint32 = this.f3537pos + readVarint32();
                while (this.f3537pos < varint32) {
                    list.add(Long.valueOf(readVarint64()));
                }
                requirePosition(varint32);
                return;
            }
            LongArrayList longArrayList = (LongArrayList) list;
            int tagWireType2 = WireFormat.getTagWireType(this.f3538tag);
            if (tagWireType2 == 0) {
                do {
                    longArrayList.mo4044addLong(readUInt64());
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i2 = this.f3537pos;
                    }
                } while (readVarint32() == this.f3538tag);
                this.f3537pos = i2;
                return;
            }
            if (tagWireType2 != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int varint322 = this.f3537pos + readVarint32();
            while (this.f3537pos < varint322) {
                longArrayList.mo4044addLong(readVarint64());
            }
            requirePosition(varint322);
        }

        public long readVarint64() throws InvalidProtocolBufferException {
            long j;
            long j2;
            long j3;
            int i = this.f3537pos;
            int i2 = this.f3536limit;
            if (i2 == i) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.f3535buffer;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.f3537pos = i3;
                return b;
            }
            if (i2 - i3 < 9) {
                return readVarint64SlowPath();
            }
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
                                            if (bArr[i4] < 0) {
                                                throw InvalidProtocolBufferException.malformedVarint();
                                            }
                                            i4 = i11;
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
            this.f3537pos = i4;
            return j;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public boolean skipField() throws InvalidProtocolBufferException {
            int i;
            if (m3919isAtEnd() || (i = this.f3538tag) == this.endGroupTag) {
                return false;
            }
            int tagWireType = WireFormat.getTagWireType(i);
            if (tagWireType == 0) {
                skipVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipBytes(readVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipGroup();
                return true;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipBytes(4);
            return true;
        }

        private <T> T readGroup(InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) {
            T tNewInstance = interfaceC0777Schema.newInstance();
            mergeGroupField(tNewInstance, interfaceC0777Schema, extensionRegistryLite);
            interfaceC0777Schema.makeImmutable(tNewInstance);
            return tNewInstance;
        }

        private <T> T readMessage(InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            T tNewInstance = interfaceC0777Schema.newInstance();
            mergeMessageField(tNewInstance, interfaceC0777Schema, extensionRegistryLite);
            interfaceC0777Schema.makeImmutable(tNewInstance);
            return tNewInstance;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        @Deprecated
        public <T> void readGroupList(List<T> list, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i;
            if (WireFormat.getTagWireType(this.f3538tag) == 3) {
                int i2 = this.f3538tag;
                do {
                    list.add(readGroup(interfaceC0777Schema, extensionRegistryLite));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == i2);
                this.f3537pos = i;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
        public <T> void readMessageList(List<T> list, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
            int i;
            if (WireFormat.getTagWireType(this.f3538tag) == 2) {
                int i2 = this.f3538tag;
                do {
                    list.add(readMessage(interfaceC0777Schema, extensionRegistryLite));
                    if (m3919isAtEnd()) {
                        return;
                    } else {
                        i = this.f3537pos;
                    }
                } while (readVarint32() == i2);
                this.f3537pos = i;
                return;
            }
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private BinaryReader() {
    }
}
