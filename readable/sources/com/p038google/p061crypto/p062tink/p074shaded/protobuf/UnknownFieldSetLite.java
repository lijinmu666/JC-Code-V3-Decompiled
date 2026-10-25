package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class UnknownFieldSetLite {
    private static final UnknownFieldSetLite DEFAULT_INSTANCE = new UnknownFieldSetLite(0, new int[0], new Object[0], false);
    private static final int MIN_CAPACITY = 8;

    /* renamed from: count */
    private int f3800count;
    private boolean isMutable;
    private int memoizedSerializedSize;

    /* renamed from: objects */
    private Object[] f3801objects;

    /* renamed from: tags */
    private int[] f3802tags;

    private UnknownFieldSetLite() {
        this(0, new int[8], new Object[8], true);
    }

    private void ensureCapacity(int i) {
        int[] iArr = this.f3802tags;
        if (i > iArr.length) {
            int i2 = this.f3800count;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.f3802tags = Arrays.copyOf(iArr, i);
            this.f3801objects = Arrays.copyOf(this.f3801objects, i);
        }
    }

    public static UnknownFieldSetLite getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    private static int hashCode(int[] iArr, int i) {
        int i2 = 17;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 31) + iArr[i3];
        }
        return i2;
    }

    private UnknownFieldSetLite mergeFrom(CodedInputStream codedInputStream) {
        int iMo3955readTag;
        do {
            iMo3955readTag = codedInputStream.mo3955readTag();
            if (iMo3955readTag == 0) {
                break;
            }
        } while (mergeFieldFrom(iMo3955readTag, codedInputStream));
        return this;
    }

    public static UnknownFieldSetLite mutableCopyOf(UnknownFieldSetLite unknownFieldSetLite, UnknownFieldSetLite unknownFieldSetLite2) {
        int i = unknownFieldSetLite.f3800count + unknownFieldSetLite2.f3800count;
        int[] iArrCopyOf = Arrays.copyOf(unknownFieldSetLite.f3802tags, i);
        System.arraycopy(unknownFieldSetLite2.f3802tags, 0, iArrCopyOf, unknownFieldSetLite.f3800count, unknownFieldSetLite2.f3800count);
        Object[] objArrCopyOf = Arrays.copyOf(unknownFieldSetLite.f3801objects, i);
        System.arraycopy(unknownFieldSetLite2.f3801objects, 0, objArrCopyOf, unknownFieldSetLite.f3800count, unknownFieldSetLite2.f3800count);
        return new UnknownFieldSetLite(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static UnknownFieldSetLite newInstance() {
        return new UnknownFieldSetLite();
    }

    private static boolean objectsEquals(Object[] objArr, Object[] objArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!objArr[i2].equals(objArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private static boolean tagsEquals(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private static void writeField(int i, Object obj, InterfaceC0811Writer interfaceC0811Writer) {
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            interfaceC0811Writer.writeInt64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 1) {
            interfaceC0811Writer.writeFixed64(tagFieldNumber, ((Long) obj).longValue());
            return;
        }
        if (tagWireType == 2) {
            interfaceC0811Writer.writeBytes(tagFieldNumber, (ByteString) obj);
            return;
        }
        if (tagWireType != 3) {
            if (tagWireType != 5) {
                throw new RuntimeException(InvalidProtocolBufferException.invalidWireType());
            }
            interfaceC0811Writer.writeFixed32(tagFieldNumber, ((Integer) obj).intValue());
        } else if (interfaceC0811Writer.fieldOrder() == InterfaceC0811Writer.FieldOrder.ASCENDING) {
            interfaceC0811Writer.writeStartGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).m4148writeTo(interfaceC0811Writer);
            interfaceC0811Writer.writeEndGroup(tagFieldNumber);
        } else {
            interfaceC0811Writer.writeEndGroup(tagFieldNumber);
            ((UnknownFieldSetLite) obj).m4148writeTo(interfaceC0811Writer);
            interfaceC0811Writer.writeStartGroup(tagFieldNumber);
        }
    }

    public void checkMutable() {
        if (!this.isMutable) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: equals */
    public boolean m4146equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UnknownFieldSetLite)) {
            return false;
        }
        UnknownFieldSetLite unknownFieldSetLite = (UnknownFieldSetLite) obj;
        int i = this.f3800count;
        return i == unknownFieldSetLite.f3800count && tagsEquals(this.f3802tags, unknownFieldSetLite.f3802tags, i) && objectsEquals(this.f3801objects, unknownFieldSetLite.f3801objects, this.f3800count);
    }

    public int getSerializedSize() {
        int iComputeUInt64Size;
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.f3800count; i3++) {
            int i4 = this.f3802tags[i3];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i4);
            int tagWireType = WireFormat.getTagWireType(i4);
            if (tagWireType == 0) {
                iComputeUInt64Size = CodedOutputStream.computeUInt64Size(tagFieldNumber, ((Long) this.f3801objects[i3]).longValue());
            } else if (tagWireType == 1) {
                iComputeUInt64Size = CodedOutputStream.computeFixed64Size(tagFieldNumber, ((Long) this.f3801objects[i3]).longValue());
            } else if (tagWireType == 2) {
                iComputeUInt64Size = CodedOutputStream.computeBytesSize(tagFieldNumber, (ByteString) this.f3801objects[i3]);
            } else if (tagWireType == 3) {
                iComputeUInt64Size = (CodedOutputStream.computeTagSize(tagFieldNumber) * 2) + ((UnknownFieldSetLite) this.f3801objects[i3]).getSerializedSize();
            } else {
                if (tagWireType != 5) {
                    throw new IllegalStateException(InvalidProtocolBufferException.invalidWireType());
                }
                iComputeUInt64Size = CodedOutputStream.computeFixed32Size(tagFieldNumber, ((Integer) this.f3801objects[i3]).intValue());
            }
            i2 += iComputeUInt64Size;
        }
        this.memoizedSerializedSize = i2;
        return i2;
    }

    public int getSerializedSizeAsMessageSet() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int iComputeRawMessageSetExtensionSize = 0;
        for (int i2 = 0; i2 < this.f3800count; i2++) {
            iComputeRawMessageSetExtensionSize += CodedOutputStream.computeRawMessageSetExtensionSize(WireFormat.getTagFieldNumber(this.f3802tags[i2]), (ByteString) this.f3801objects[i2]);
        }
        this.memoizedSerializedSize = iComputeRawMessageSetExtensionSize;
        return iComputeRawMessageSetExtensionSize;
    }

    public void makeImmutable() {
        this.isMutable = false;
    }

    public boolean mergeFieldFrom(int i, CodedInputStream codedInputStream) throws InvalidProtocolBufferException.InvalidWireTypeException {
        checkMutable();
        int tagFieldNumber = WireFormat.getTagFieldNumber(i);
        int tagWireType = WireFormat.getTagWireType(i);
        if (tagWireType == 0) {
            storeField(i, Long.valueOf(codedInputStream.readInt64()));
            return true;
        }
        if (tagWireType == 1) {
            storeField(i, Long.valueOf(codedInputStream.readFixed64()));
            return true;
        }
        if (tagWireType == 2) {
            storeField(i, codedInputStream.readBytes());
            return true;
        }
        if (tagWireType == 3) {
            UnknownFieldSetLite unknownFieldSetLite = new UnknownFieldSetLite();
            unknownFieldSetLite.mergeFrom(codedInputStream);
            codedInputStream.checkLastTagWas(WireFormat.m4185makeTag(tagFieldNumber, 4));
            storeField(i, unknownFieldSetLite);
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        storeField(i, Integer.valueOf(codedInputStream.readFixed32()));
        return true;
    }

    public UnknownFieldSetLite mergeLengthDelimitedField(int i, ByteString byteString) {
        checkMutable();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        storeField(WireFormat.m4185makeTag(i, 2), byteString);
        return this;
    }

    public UnknownFieldSetLite mergeVarintField(int i, int i2) {
        checkMutable();
        if (i == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        storeField(WireFormat.m4185makeTag(i, 0), Long.valueOf(i2));
        return this;
    }

    public final void printWithIndent(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.f3800count; i2++) {
            MessageLiteToString.printField(sb, i, String.valueOf(WireFormat.getTagFieldNumber(this.f3802tags[i2])), this.f3801objects[i2]);
        }
    }

    public void storeField(int i, Object obj) {
        checkMutable();
        ensureCapacity(this.f3800count + 1);
        int[] iArr = this.f3802tags;
        int i2 = this.f3800count;
        iArr[i2] = i;
        this.f3801objects[i2] = obj;
        this.f3800count = i2 + 1;
    }

    public void writeAsMessageSetTo(CodedOutputStream codedOutputStream) {
        for (int i = 0; i < this.f3800count; i++) {
            codedOutputStream.writeRawMessageSetExtension(WireFormat.getTagFieldNumber(this.f3802tags[i]), (ByteString) this.f3801objects[i]);
        }
    }

    /* renamed from: writeTo */
    public void m4147writeTo(CodedOutputStream codedOutputStream) throws InvalidProtocolBufferException.InvalidWireTypeException {
        for (int i = 0; i < this.f3800count; i++) {
            int i2 = this.f3802tags[i];
            int tagFieldNumber = WireFormat.getTagFieldNumber(i2);
            int tagWireType = WireFormat.getTagWireType(i2);
            if (tagWireType == 0) {
                codedOutputStream.writeUInt64(tagFieldNumber, ((Long) this.f3801objects[i]).longValue());
            } else if (tagWireType == 1) {
                codedOutputStream.writeFixed64(tagFieldNumber, ((Long) this.f3801objects[i]).longValue());
            } else if (tagWireType == 2) {
                codedOutputStream.writeBytes(tagFieldNumber, (ByteString) this.f3801objects[i]);
            } else if (tagWireType == 3) {
                codedOutputStream.writeTag(tagFieldNumber, 3);
                ((UnknownFieldSetLite) this.f3801objects[i]).m4147writeTo(codedOutputStream);
                codedOutputStream.writeTag(tagFieldNumber, 4);
            } else {
                if (tagWireType != 5) {
                    throw InvalidProtocolBufferException.invalidWireType();
                }
                codedOutputStream.writeFixed32(tagFieldNumber, ((Integer) this.f3801objects[i]).intValue());
            }
        }
    }

    private UnknownFieldSetLite(int i, int[] iArr, Object[] objArr, boolean z) {
        this.memoizedSerializedSize = -1;
        this.f3800count = i;
        this.f3802tags = iArr;
        this.f3801objects = objArr;
        this.isMutable = z;
    }

    private static int hashCode(Object[] objArr, int i) {
        int iHashCode = 17;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode = (iHashCode * 31) + objArr[i2].hashCode();
        }
        return iHashCode;
    }

    public int hashCode() {
        int i = this.f3800count;
        return ((((527 + i) * 31) + hashCode(this.f3802tags, i)) * 31) + hashCode(this.f3801objects, this.f3800count);
    }

    @CanIgnoreReturnValue
    public UnknownFieldSetLite mergeFrom(UnknownFieldSetLite unknownFieldSetLite) {
        if (unknownFieldSetLite.m4146equals(getDefaultInstance())) {
            return this;
        }
        checkMutable();
        int i = this.f3800count + unknownFieldSetLite.f3800count;
        ensureCapacity(i);
        System.arraycopy(unknownFieldSetLite.f3802tags, 0, this.f3802tags, this.f3800count, unknownFieldSetLite.f3800count);
        System.arraycopy(unknownFieldSetLite.f3801objects, 0, this.f3801objects, this.f3800count, unknownFieldSetLite.f3800count);
        this.f3800count = i;
        return this;
    }

    public void writeAsMessageSetTo(InterfaceC0811Writer interfaceC0811Writer) {
        if (interfaceC0811Writer.fieldOrder() == InterfaceC0811Writer.FieldOrder.DESCENDING) {
            for (int i = this.f3800count - 1; i >= 0; i--) {
                interfaceC0811Writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.f3802tags[i]), this.f3801objects[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.f3800count; i2++) {
            interfaceC0811Writer.writeMessageSetItem(WireFormat.getTagFieldNumber(this.f3802tags[i2]), this.f3801objects[i2]);
        }
    }

    /* renamed from: writeTo */
    public void m4148writeTo(InterfaceC0811Writer interfaceC0811Writer) {
        if (this.f3800count == 0) {
            return;
        }
        if (interfaceC0811Writer.fieldOrder() == InterfaceC0811Writer.FieldOrder.ASCENDING) {
            for (int i = 0; i < this.f3800count; i++) {
                writeField(this.f3802tags[i], this.f3801objects[i], interfaceC0811Writer);
            }
            return;
        }
        for (int i2 = this.f3800count - 1; i2 >= 0; i2--) {
            writeField(this.f3802tags[i2], this.f3801objects[i2], interfaceC0811Writer);
        }
    }
}
