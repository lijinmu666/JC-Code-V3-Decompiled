package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MapEntryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.WireFormat;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes.dex */
final class CodedInputStreamReader implements InterfaceC0775Reader {
    private static final int FIXED32_MULTIPLE_MASK = 3;
    private static final int FIXED64_MULTIPLE_MASK = 7;
    private static final int NEXT_TAG_UNSET = 0;
    private int endGroupTag;

    /* renamed from: input */
    private final CodedInputStream f3588input;

    /* renamed from: nextTag */
    private int f3589nextTag = 0;

    /* renamed from: tag */
    private int f3590tag;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.CodedInputStreamReader$1 */
    public static /* synthetic */ class C07301 {
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

    private CodedInputStreamReader(CodedInputStream codedInputStream) {
        CodedInputStream codedInputStream2 = (CodedInputStream) Internal.checkNotNull(codedInputStream, "input");
        this.f3588input = codedInputStream2;
        codedInputStream2.f3570wrapper = this;
    }

    public static CodedInputStreamReader forCodedInput(CodedInputStream codedInputStream) {
        CodedInputStreamReader codedInputStreamReader = codedInputStream.f3570wrapper;
        return codedInputStreamReader != null ? codedInputStreamReader : new CodedInputStreamReader(codedInputStream);
    }

    private <T> void mergeGroupFieldInternal(T t, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) {
        int i = this.endGroupTag;
        this.endGroupTag = WireFormat.m4185makeTag(WireFormat.getTagFieldNumber(this.f3590tag), 4);
        try {
            interfaceC0777Schema.mergeFrom(t, this, extensionRegistryLite);
            if (this.f3590tag == this.endGroupTag) {
            } else {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } finally {
            this.endGroupTag = i;
        }
    }

    private <T> void mergeMessageFieldInternal(T t, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        int uInt32 = this.f3588input.readUInt32();
        CodedInputStream codedInputStream = this.f3588input;
        if (codedInputStream.recursionDepth >= codedInputStream.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        int iPushLimit = codedInputStream.pushLimit(uInt32);
        this.f3588input.recursionDepth++;
        interfaceC0777Schema.mergeFrom(t, this, extensionRegistryLite);
        this.f3588input.checkLastTagWas(0);
        r4.recursionDepth--;
        this.f3588input.popLimit(iPushLimit);
    }

    private Object readField(WireFormat.FieldType fieldType, Class<?> cls, ExtensionRegistryLite extensionRegistryLite) {
        switch (C07301.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
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
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private void requirePosition(int i) throws InvalidProtocolBufferException {
        if (this.f3588input.getTotalBytesRead() != i) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void requireWireType(int i) throws InvalidProtocolBufferException.InvalidWireTypeException {
        if (WireFormat.getTagWireType(this.f3590tag) != i) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
    }

    private void verifyPackedFixed32Length(int i) throws InvalidProtocolBufferException {
        if ((i & 3) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    private void verifyPackedFixed64Length(int i) throws InvalidProtocolBufferException {
        if ((i & 7) != 0) {
            throw InvalidProtocolBufferException.parseFailure();
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public int getFieldNumber() {
        int i = this.f3589nextTag;
        if (i != 0) {
            this.f3590tag = i;
            this.f3589nextTag = 0;
        } else {
            this.f3590tag = this.f3588input.mo3955readTag();
        }
        int i2 = this.f3590tag;
        if (i2 == 0 || i2 == this.endGroupTag) {
            return Integer.MAX_VALUE;
        }
        return WireFormat.getTagFieldNumber(i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    /* renamed from: getTag */
    public int mo3920getTag() {
        return this.f3590tag;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public <T> void mergeGroupField(T t, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(3);
        mergeGroupFieldInternal(t, interfaceC0777Schema, extensionRegistryLite);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public <T> void mergeMessageField(T t, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        requireWireType(2);
        mergeMessageFieldInternal(t, interfaceC0777Schema, extensionRegistryLite);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public boolean readBool() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(0);
        return this.f3588input.readBool();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readBoolList(List<Boolean> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof BooleanArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 0) {
                do {
                    list.add(Boolean.valueOf(this.f3588input.readBool()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
            do {
                list.add(Boolean.valueOf(this.f3588input.readBool()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 0) {
            do {
                booleanArrayList.addBoolean(this.f3588input.readBool());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
        do {
            booleanArrayList.addBoolean(this.f3588input.readBool());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public ByteString readBytes() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(2);
        return this.f3588input.readBytes();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readBytesList(List<ByteString> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iMo3955readTag;
        if (WireFormat.getTagWireType(this.f3590tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            list.add(readBytes());
            if (this.f3588input.mo3954isAtEnd()) {
                return;
            } else {
                iMo3955readTag = this.f3588input.mo3955readTag();
            }
        } while (iMo3955readTag == this.f3590tag);
        this.f3589nextTag = iMo3955readTag;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public double readDouble() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(1);
        return this.f3588input.readDouble();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readDoubleList(List<Double> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof DoubleArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 1) {
                do {
                    list.add(Double.valueOf(this.f3588input.readDouble()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int uInt32 = this.f3588input.readUInt32();
            verifyPackedFixed64Length(uInt32);
            int totalBytesRead = this.f3588input.getTotalBytesRead() + uInt32;
            do {
                list.add(Double.valueOf(this.f3588input.readDouble()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            return;
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 1) {
            do {
                doubleArrayList.addDouble(this.f3588input.readDouble());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int uInt322 = this.f3588input.readUInt32();
        verifyPackedFixed64Length(uInt322);
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + uInt322;
        do {
            doubleArrayList.addDouble(this.f3588input.readDouble());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public int readEnum() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(0);
        return this.f3588input.readEnum();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readEnumList(List<Integer> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 0) {
                do {
                    list.add(Integer.valueOf(this.f3588input.readEnum()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
            do {
                list.add(Integer.valueOf(this.f3588input.readEnum()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 0) {
            do {
                intArrayList.mo4038addInt(this.f3588input.readEnum());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
        do {
            intArrayList.mo4038addInt(this.f3588input.readEnum());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public int readFixed32() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(5);
        return this.f3588input.readFixed32();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readFixed32List(List<Integer> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 2) {
                int uInt32 = this.f3588input.readUInt32();
                verifyPackedFixed32Length(uInt32);
                int totalBytesRead = this.f3588input.getTotalBytesRead() + uInt32;
                do {
                    list.add(Integer.valueOf(this.f3588input.readFixed32()));
                } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.f3588input.readFixed32()));
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag == this.f3590tag);
            this.f3589nextTag = iMo3955readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 2) {
            int uInt322 = this.f3588input.readUInt32();
            verifyPackedFixed32Length(uInt322);
            int totalBytesRead2 = this.f3588input.getTotalBytesRead() + uInt322;
            do {
                intArrayList.mo4038addInt(this.f3588input.readFixed32());
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            intArrayList.mo4038addInt(this.f3588input.readFixed32());
            if (this.f3588input.mo3954isAtEnd()) {
                return;
            } else {
                iMo3955readTag2 = this.f3588input.mo3955readTag();
            }
        } while (iMo3955readTag2 == this.f3590tag);
        this.f3589nextTag = iMo3955readTag2;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public long readFixed64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(1);
        return this.f3588input.readFixed64();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readFixed64List(List<Long> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 1) {
                do {
                    list.add(Long.valueOf(this.f3588input.readFixed64()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int uInt32 = this.f3588input.readUInt32();
            verifyPackedFixed64Length(uInt32);
            int totalBytesRead = this.f3588input.getTotalBytesRead() + uInt32;
            do {
                list.add(Long.valueOf(this.f3588input.readFixed64()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 1) {
            do {
                longArrayList.mo4044addLong(this.f3588input.readFixed64());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int uInt322 = this.f3588input.readUInt32();
        verifyPackedFixed64Length(uInt322);
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + uInt322;
        do {
            longArrayList.mo4044addLong(this.f3588input.readFixed64());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public float readFloat() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(5);
        return this.f3588input.readFloat();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readFloatList(List<Float> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof FloatArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 2) {
                int uInt32 = this.f3588input.readUInt32();
                verifyPackedFixed32Length(uInt32);
                int totalBytesRead = this.f3588input.getTotalBytesRead() + uInt32;
                do {
                    list.add(Float.valueOf(this.f3588input.readFloat()));
                } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Float.valueOf(this.f3588input.readFloat()));
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag == this.f3590tag);
            this.f3589nextTag = iMo3955readTag;
            return;
        }
        FloatArrayList floatArrayList = (FloatArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 2) {
            int uInt322 = this.f3588input.readUInt32();
            verifyPackedFixed32Length(uInt322);
            int totalBytesRead2 = this.f3588input.getTotalBytesRead() + uInt322;
            do {
                floatArrayList.addFloat(this.f3588input.readFloat());
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            floatArrayList.addFloat(this.f3588input.readFloat());
            if (this.f3588input.mo3954isAtEnd()) {
                return;
            } else {
                iMo3955readTag2 = this.f3588input.mo3955readTag();
            }
        } while (iMo3955readTag2 == this.f3590tag);
        this.f3589nextTag = iMo3955readTag2;
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
        return this.f3588input.readInt32();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readInt32List(List<Integer> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 0) {
                do {
                    list.add(Integer.valueOf(this.f3588input.readInt32()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
            do {
                list.add(Integer.valueOf(this.f3588input.readInt32()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 0) {
            do {
                intArrayList.mo4038addInt(this.f3588input.readInt32());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
        do {
            intArrayList.mo4038addInt(this.f3588input.readInt32());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public long readInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(0);
        return this.f3588input.readInt64();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readInt64List(List<Long> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 0) {
                do {
                    list.add(Long.valueOf(this.f3588input.readInt64()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
            do {
                list.add(Long.valueOf(this.f3588input.readInt64()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 0) {
            do {
                longArrayList.mo4044addLong(this.f3588input.readInt64());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
        do {
            longArrayList.mo4044addLong(this.f3588input.readInt64());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0061, code lost:
    
        r7.f3588input.popLimit(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0066, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    /* renamed from: readMap */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public <K, V> void mo3921readMap(Map<K, V> map, MapEntryLite.Metadata<K, V> metadata, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(2);
        int iPushLimit = this.f3588input.pushLimit(this.f3588input.readUInt32());
        Object field = metadata.defaultKey;
        Object field2 = metadata.defaultValue;
        while (true) {
            try {
                int fieldNumber = getFieldNumber();
                if (fieldNumber == Integer.MAX_VALUE || this.f3588input.mo3954isAtEnd()) {
                    break;
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
            } catch (Throwable th) {
                this.f3588input.popLimit(iPushLimit);
                throw th;
            }
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
        return this.f3588input.readSFixed32();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readSFixed32List(List<Integer> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 2) {
                int uInt32 = this.f3588input.readUInt32();
                verifyPackedFixed32Length(uInt32);
                int totalBytesRead = this.f3588input.getTotalBytesRead() + uInt32;
                do {
                    list.add(Integer.valueOf(this.f3588input.readSFixed32()));
                } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
                return;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            do {
                list.add(Integer.valueOf(this.f3588input.readSFixed32()));
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag == this.f3590tag);
            this.f3589nextTag = iMo3955readTag;
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 2) {
            int uInt322 = this.f3588input.readUInt32();
            verifyPackedFixed32Length(uInt322);
            int totalBytesRead2 = this.f3588input.getTotalBytesRead() + uInt322;
            do {
                intArrayList.mo4038addInt(this.f3588input.readSFixed32());
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
            return;
        }
        if (tagWireType2 != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        do {
            intArrayList.mo4038addInt(this.f3588input.readSFixed32());
            if (this.f3588input.mo3954isAtEnd()) {
                return;
            } else {
                iMo3955readTag2 = this.f3588input.mo3955readTag();
            }
        } while (iMo3955readTag2 == this.f3590tag);
        this.f3589nextTag = iMo3955readTag2;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public long readSFixed64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(1);
        return this.f3588input.readSFixed64();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readSFixed64List(List<Long> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 1) {
                do {
                    list.add(Long.valueOf(this.f3588input.readSFixed64()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int uInt32 = this.f3588input.readUInt32();
            verifyPackedFixed64Length(uInt32);
            int totalBytesRead = this.f3588input.getTotalBytesRead() + uInt32;
            do {
                list.add(Long.valueOf(this.f3588input.readSFixed64()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 1) {
            do {
                longArrayList.mo4044addLong(this.f3588input.readSFixed64());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int uInt322 = this.f3588input.readUInt32();
        verifyPackedFixed64Length(uInt322);
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + uInt322;
        do {
            longArrayList.mo4044addLong(this.f3588input.readSFixed64());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public int readSInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(0);
        return this.f3588input.readSInt32();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readSInt32List(List<Integer> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 0) {
                do {
                    list.add(Integer.valueOf(this.f3588input.readSInt32()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
            do {
                list.add(Integer.valueOf(this.f3588input.readSInt32()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 0) {
            do {
                intArrayList.mo4038addInt(this.f3588input.readSInt32());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
        do {
            intArrayList.mo4038addInt(this.f3588input.readSInt32());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public long readSInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(0);
        return this.f3588input.readSInt64();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readSInt64List(List<Long> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 0) {
                do {
                    list.add(Long.valueOf(this.f3588input.readSInt64()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
            do {
                list.add(Long.valueOf(this.f3588input.readSInt64()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 0) {
            do {
                longArrayList.mo4044addLong(this.f3588input.readSInt64());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
        do {
            longArrayList.mo4044addLong(this.f3588input.readSInt64());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public String readString() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(2);
        return this.f3588input.readString();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readStringList(List<String> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        readStringListInternal(list, false);
    }

    public void readStringListInternal(List<String> list, boolean z) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (WireFormat.getTagWireType(this.f3590tag) != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        if (!(list instanceof LazyStringList) || z) {
            do {
                list.add(z ? readStringRequireUtf8() : readString());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag == this.f3590tag);
            this.f3589nextTag = iMo3955readTag;
            return;
        }
        LazyStringList lazyStringList = (LazyStringList) list;
        do {
            lazyStringList.mo4058add(readBytes());
            if (this.f3588input.mo3954isAtEnd()) {
                return;
            } else {
                iMo3955readTag2 = this.f3588input.mo3955readTag();
            }
        } while (iMo3955readTag2 == this.f3590tag);
        this.f3589nextTag = iMo3955readTag2;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readStringListRequireUtf8(List<String> list) throws InvalidProtocolBufferException.InvalidWireTypeException {
        readStringListInternal(list, true);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public String readStringRequireUtf8() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(2);
        return this.f3588input.readStringRequireUtf8();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public int readUInt32() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(0);
        return this.f3588input.readUInt32();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readUInt32List(List<Integer> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof IntArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 0) {
                do {
                    list.add(Integer.valueOf(this.f3588input.readUInt32()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
            do {
                list.add(Integer.valueOf(this.f3588input.readUInt32()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        IntArrayList intArrayList = (IntArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 0) {
            do {
                intArrayList.mo4038addInt(this.f3588input.readUInt32());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
        do {
            intArrayList.mo4038addInt(this.f3588input.readUInt32());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public long readUInt64() throws InvalidProtocolBufferException.InvalidWireTypeException {
        requireWireType(0);
        return this.f3588input.readUInt64();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public void readUInt64List(List<Long> list) throws InvalidProtocolBufferException {
        int iMo3955readTag;
        int iMo3955readTag2;
        if (!(list instanceof LongArrayList)) {
            int tagWireType = WireFormat.getTagWireType(this.f3590tag);
            if (tagWireType == 0) {
                do {
                    list.add(Long.valueOf(this.f3588input.readUInt64()));
                    if (this.f3588input.mo3954isAtEnd()) {
                        return;
                    } else {
                        iMo3955readTag = this.f3588input.mo3955readTag();
                    }
                } while (iMo3955readTag == this.f3590tag);
                this.f3589nextTag = iMo3955readTag;
                return;
            }
            if (tagWireType != 2) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            int totalBytesRead = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
            do {
                list.add(Long.valueOf(this.f3588input.readUInt64()));
            } while (this.f3588input.getTotalBytesRead() < totalBytesRead);
            requirePosition(totalBytesRead);
            return;
        }
        LongArrayList longArrayList = (LongArrayList) list;
        int tagWireType2 = WireFormat.getTagWireType(this.f3590tag);
        if (tagWireType2 == 0) {
            do {
                longArrayList.mo4044addLong(this.f3588input.readUInt64());
                if (this.f3588input.mo3954isAtEnd()) {
                    return;
                } else {
                    iMo3955readTag2 = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag2 == this.f3590tag);
            this.f3589nextTag = iMo3955readTag2;
            return;
        }
        if (tagWireType2 != 2) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int totalBytesRead2 = this.f3588input.getTotalBytesRead() + this.f3588input.readUInt32();
        do {
            longArrayList.mo4044addLong(this.f3588input.readUInt64());
        } while (this.f3588input.getTotalBytesRead() < totalBytesRead2);
        requirePosition(totalBytesRead2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public boolean shouldDiscardUnknownFields() {
        return this.f3588input.shouldDiscardUnknownFields();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public boolean skipField() {
        int i;
        if (this.f3588input.mo3954isAtEnd() || (i = this.f3590tag) == this.endGroupTag) {
            return false;
        }
        return this.f3588input.skipField(i);
    }

    private <T> T readGroup(InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) {
        T tNewInstance = interfaceC0777Schema.newInstance();
        mergeGroupFieldInternal(tNewInstance, interfaceC0777Schema, extensionRegistryLite);
        interfaceC0777Schema.makeImmutable(tNewInstance);
        return tNewInstance;
    }

    private <T> T readMessage(InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        T tNewInstance = interfaceC0777Schema.newInstance();
        mergeMessageFieldInternal(tNewInstance, interfaceC0777Schema, extensionRegistryLite);
        interfaceC0777Schema.makeImmutable(tNewInstance);
        return tNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    @Deprecated
    public <T> void readGroupList(List<T> list, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iMo3955readTag;
        if (WireFormat.getTagWireType(this.f3590tag) == 3) {
            int i = this.f3590tag;
            do {
                list.add(readGroup(interfaceC0777Schema, extensionRegistryLite));
                if (this.f3588input.mo3954isAtEnd() || this.f3589nextTag != 0) {
                    return;
                } else {
                    iMo3955readTag = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag == i);
            this.f3589nextTag = iMo3955readTag;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0775Reader
    public <T> void readMessageList(List<T> list, InterfaceC0777Schema<T> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException.InvalidWireTypeException {
        int iMo3955readTag;
        if (WireFormat.getTagWireType(this.f3590tag) == 2) {
            int i = this.f3590tag;
            do {
                list.add(readMessage(interfaceC0777Schema, extensionRegistryLite));
                if (this.f3588input.mo3954isAtEnd() || this.f3589nextTag != 0) {
                    return;
                } else {
                    iMo3955readTag = this.f3588input.mo3955readTag();
                }
            } while (iMo3955readTag == i);
            this.f3589nextTag = iMo3955readTag;
            return;
        }
        throw InvalidProtocolBufferException.invalidWireType();
    }
}
