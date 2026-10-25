package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ArrayDecoders;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldSet;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MapEntryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.WireFormat;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import sun.misc.Unsafe;

@CheckReturnValue
/* loaded from: classes.dex */
final class MessageSchema<T> implements InterfaceC0777Schema<T> {
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int INTS_PER_FIELD = 3;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    static final int ONEOF_TYPE_OFFSET = 51;
    private static final int REQUIRED_MASK = 268435456;

    /* renamed from: buffer */
    private final int[] f3724buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;

    /* renamed from: lite */
    private final boolean f3725lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;

    /* renamed from: objects */
    private final Object[] f3726objects;

    /* renamed from: proto3 */
    private final boolean f3727proto3;
    private final int repeatedFieldOffsetStart;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];

    /* renamed from: UNSAFE */
    private static final Unsafe f3723UNSAFE = UnsafeUtil.getUnsafe();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.MessageSchema$1 */
    public static /* synthetic */ class C07671 {
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3821FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3822FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3823FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3820ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3825INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3831UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3826INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3832UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3827MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3828SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3829SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3830STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private MessageSchema(int[] iArr, Object[] objArr, int i, int i2, MessageLite messageLite, boolean z, boolean z2, int[] iArr2, int i3, int i4, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.f3724buffer = iArr;
        this.f3726objects = objArr;
        this.minFieldNumber = i;
        this.maxFieldNumber = i2;
        this.f3725lite = messageLite instanceof GeneratedMessageLite;
        this.f3727proto3 = z;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z2;
        this.intArray = iArr2;
        this.checkInitializedCount = i3;
        this.repeatedFieldOffsetStart = i4;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t, T t2, int i) {
        return isFieldPresent(t, i) == isFieldPresent(t2, i);
    }

    private static <T> boolean booleanAt(T t, long j) {
        return UnsafeUtil.getBoolean(t, j);
    }

    private static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K, V> int decodeMapEntry(byte[] bArr, int i, int i2, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32;
        int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
        int i3 = registers.f3532int1;
        if (i3 < 0 || i3 > i2 - iDecodeVarint322) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i4 = iDecodeVarint322 + i3;
        Object obj = metadata.defaultKey;
        Object obj2 = metadata.defaultValue;
        while (iDecodeVarint322 < i4) {
            int i5 = iDecodeVarint322 + 1;
            byte b = bArr[iDecodeVarint322];
            if (b < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(b, bArr, i5, registers);
                b = registers.f3532int1;
            } else {
                iDecodeVarint32 = i5;
            }
            int i6 = b >>> 3;
            int i7 = b & 7;
            if (i6 != 1) {
                if (i6 == 2 && i7 == metadata.valueType.getWireType()) {
                    iDecodeVarint322 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.valueType, metadata.defaultValue.getClass(), registers);
                    obj2 = registers.f3534object1;
                } else {
                    iDecodeVarint322 = ArrayDecoders.skipField(b, bArr, iDecodeVarint32, i2, registers);
                }
            } else if (i7 == metadata.f3722keyType.getWireType()) {
                iDecodeVarint322 = decodeMapEntryValue(bArr, iDecodeVarint32, i2, metadata.f3722keyType, null, registers);
                obj = registers.f3534object1;
            } else {
                iDecodeVarint322 = ArrayDecoders.skipField(b, bArr, iDecodeVarint32, i2, registers);
            }
        }
        if (iDecodeVarint322 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i4;
    }

    private int decodeMapEntryValue(byte[] bArr, int i, int i2, WireFormat.FieldType fieldType, Class<?> cls, ArrayDecoders.Registers registers) {
        switch (C07671.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.f3534object1 = Boolean.valueOf(registers.f3533long1 != 0);
                return iDecodeVarint64;
            case 2:
                return ArrayDecoders.decodeBytes(bArr, i, registers);
            case 3:
                registers.f3534object1 = Double.valueOf(ArrayDecoders.decodeDouble(bArr, i));
                return i + 8;
            case 4:
            case 5:
                registers.f3534object1 = Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i));
                return i + 4;
            case 6:
            case 7:
                registers.f3534object1 = Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i));
                return i + 8;
            case 8:
                registers.f3534object1 = Float.valueOf(ArrayDecoders.decodeFloat(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.f3534object1 = Integer.valueOf(registers.f3532int1);
                return iDecodeVarint32;
            case 12:
            case 13:
                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.f3534object1 = Long.valueOf(registers.f3533long1);
                return iDecodeVarint642;
            case 14:
                return ArrayDecoders.decodeMessageField(Protobuf.getInstance().schemaFor((Class) cls), bArr, i, i2, registers);
            case 15:
                int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                registers.f3534object1 = Integer.valueOf(CodedInputStream.decodeZigZag32(registers.f3532int1));
                return iDecodeVarint322;
            case 16:
                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                registers.f3534object1 = Long.valueOf(CodedInputStream.decodeZigZag64(registers.f3533long1));
                return iDecodeVarint643;
            case 17:
                return ArrayDecoders.decodeStringRequireUtf8(bArr, i, registers);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static <T> double doubleAt(T t, long j) {
        return UnsafeUtil.getDouble(t, j);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        Internal.EnumVerifier enumFieldVerifier;
        int iNumberAt = numberAt(i);
        Object object = UnsafeUtil.getObject(obj, m4091offset(typeAndOffsetAt(i)));
        return (object == null || (enumFieldVerifier = getEnumFieldVerifier(i)) == null) ? ub : (UB) filterUnknownEnumMap(i, iNumberAt, this.mapFieldSchema.forMutableMapData(object), enumFieldVerifier, ub, unknownFieldSchema, obj2);
    }

    private <K, V, UT, UB> UB filterUnknownEnumMap(int i, int i2, Map<K, V> map, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj) {
        MapEntryLite.Metadata<?, ?> metadataForMapMetadata = this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!enumVerifier.isInRange(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = unknownFieldSchema.getBuilderFromMessage(obj);
                }
                ByteString.CodedBuilder codedBuilderNewCodedBuilder = ByteString.newCodedBuilder(MapEntryLite.computeSerializedSize(metadataForMapMetadata, next.getKey(), next.getValue()));
                try {
                    MapEntryLite.m4076writeTo(codedBuilderNewCodedBuilder.getCodedOutput(), metadataForMapMetadata, next.getKey(), next.getValue());
                    unknownFieldSchema.addLengthDelimited(ub, i2, codedBuilderNewCodedBuilder.m3948build());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* renamed from: floatAt */
    private static <T> float m4087floatAt(T t, long j) {
        return UnsafeUtil.getFloat(t, j);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i) {
        return (Internal.EnumVerifier) this.f3726objects[((i / 3) * 2) + 1];
    }

    private Object getMapFieldDefaultEntry(int i) {
        return this.f3726objects[(i / 3) * 2];
    }

    private InterfaceC0777Schema getMessageFieldSchema(int i) {
        int i2 = (i / 3) * 2;
        InterfaceC0777Schema interfaceC0777Schema = (InterfaceC0777Schema) this.f3726objects[i2];
        if (interfaceC0777Schema != null) {
            return interfaceC0777Schema;
        }
        InterfaceC0777Schema<T> interfaceC0777SchemaSchemaFor = Protobuf.getInstance().schemaFor((Class) this.f3726objects[i2 + 1]);
        this.f3726objects[i2] = interfaceC0777SchemaSchemaFor;
        return interfaceC0777SchemaSchemaFor;
    }

    public static UnknownFieldSetLite getMutableUnknownFields(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        UnknownFieldSetLite unknownFieldSetLite = generatedMessageLite.unknownFields;
        if (unknownFieldSetLite != UnknownFieldSetLite.getDefaultInstance()) {
            return unknownFieldSetLite;
        }
        UnknownFieldSetLite unknownFieldSetLiteNewInstance = UnknownFieldSetLite.newInstance();
        generatedMessageLite.unknownFields = unknownFieldSetLiteNewInstance;
        return unknownFieldSetLiteNewInstance;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int getSerializedSizeProto2(T t) {
        int i;
        int i2;
        int iComputeDoubleSize;
        int iComputeBoolSize;
        int iComputeSFixed32Size;
        boolean z;
        int iComputeSizeFixed32List;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = f3723UNSAFE;
        int i3 = 1048575;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < this.f3724buffer.length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i5);
            int iNumberAt = numberAt(i5);
            int iM4092type = m4092type(iTypeAndOffsetAt);
            if (iM4092type <= 17) {
                i = this.f3724buffer[i5 + 2];
                int i8 = i & i3;
                i2 = 1 << (i >>> 20);
                if (i8 != i4) {
                    i7 = unsafe.getInt(t, i8);
                    i4 = i8;
                }
            } else {
                i = (!this.useCachedSizeField || iM4092type < FieldType.DOUBLE_LIST_PACKED.m4014id() || iM4092type > FieldType.SINT64_LIST_PACKED.m4014id()) ? 0 : this.f3724buffer[i5 + 2] & i3;
                i2 = 0;
            }
            long jM4091offset = m4091offset(iTypeAndOffsetAt);
            switch (iM4092type) {
                case 0:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i6 += iComputeDoubleSize;
                        break;
                    }
                case 1:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i6 += iComputeDoubleSize;
                        break;
                    }
                case 2:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, unsafe.getLong(t, jM4091offset));
                        i6 += iComputeDoubleSize;
                        break;
                    }
                case 3:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, unsafe.getLong(t, jM4091offset));
                        i6 += iComputeDoubleSize;
                        break;
                    }
                case 4:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, unsafe.getInt(t, jM4091offset));
                        i6 += iComputeDoubleSize;
                        break;
                    }
                case 5:
                    if ((i7 & i2) == 0) {
                        break;
                    } else {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i6 += iComputeDoubleSize;
                        break;
                    }
                case 6:
                    if ((i7 & i2) != 0) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i6 += iComputeDoubleSize;
                        break;
                    }
                    break;
                case 7:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 8:
                    if ((i7 & i2) != 0) {
                        Object object = unsafe.getObject(t, jM4091offset);
                        iComputeBoolSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 9:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i5));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 10:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 11:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, unsafe.getInt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 12:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, unsafe.getInt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 13:
                    if ((i7 & i2) != 0) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case 14:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 15:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, unsafe.getInt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 16:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, unsafe.getLong(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 17:
                    if ((i7 & i2) != 0) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i5));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 18:
                    iComputeBoolSize = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeBoolSize;
                    break;
                case 19:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 20:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt64List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 21:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeUInt64List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 22:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeInt32List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 23:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 24:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 25:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeBoolList(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 26:
                    iComputeBoolSize = SchemaUtil.computeSizeStringList(iNumberAt, (List) unsafe.getObject(t, jM4091offset));
                    i6 += iComputeBoolSize;
                    break;
                case 27:
                    iComputeBoolSize = SchemaUtil.computeSizeMessageList(iNumberAt, (List) unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i5));
                    i6 += iComputeBoolSize;
                    break;
                case 28:
                    iComputeBoolSize = SchemaUtil.computeSizeByteStringList(iNumberAt, (List) unsafe.getObject(t, jM4091offset));
                    i6 += iComputeBoolSize;
                    break;
                case 29:
                    iComputeBoolSize = SchemaUtil.computeSizeUInt32List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeBoolSize;
                    break;
                case 30:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeEnumList(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed32List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 32:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeFixed64List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 33:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt32List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 34:
                    z = false;
                    iComputeSizeFixed32List = SchemaUtil.computeSizeSInt64List(iNumberAt, (List) unsafe.getObject(t, jM4091offset), false);
                    i6 += iComputeSizeFixed32List;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeSFixed32Size = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case 49:
                    iComputeBoolSize = SchemaUtil.computeSizeGroupList(iNumberAt, (List) unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i5));
                    i6 += iComputeBoolSize;
                    break;
                case 50:
                    iComputeBoolSize = this.mapFieldSchema.getSerializedSize(iNumberAt, unsafe.getObject(t, jM4091offset), getMapFieldDefaultEntry(i5));
                    i6 += iComputeBoolSize;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i6 += iComputeBoolSize;
                    }
                    break;
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i6 += iComputeBoolSize;
                    }
                    break;
                case C5125EACTags.f18346SEX /* 53 */:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeSFixed32Size = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i6 += iComputeBoolSize;
                    }
                    break;
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        Object object2 = unsafe.getObject(t, jM4091offset);
                        iComputeBoolSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = SchemaUtil.computeSizeMessage(iNumberAt, unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i5));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) unsafe.getObject(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeSFixed32Size = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i6 += iComputeSFixed32Size;
                    }
                    break;
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i6 += iComputeBoolSize;
                    }
                    break;
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jM4091offset));
                        i6 += iComputeBoolSize;
                    }
                    break;
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    if (isOneofPresent(t, iNumberAt, i5)) {
                        iComputeBoolSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i5));
                        i6 += iComputeBoolSize;
                    }
                    break;
            }
            i5 += 3;
            i3 = 1048575;
        }
        int unknownFieldsSerializedSize = i6 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t).getSerializedSize() : unknownFieldsSerializedSize;
    }

    private int getSerializedSizeProto3(T t) {
        int iComputeDoubleSize;
        int iComputeSizeFixed64ListNoTag;
        int iComputeTagSize;
        int iComputeUInt32SizeNoTag;
        Unsafe unsafe = f3723UNSAFE;
        int i = 0;
        for (int i2 = 0; i2 < this.f3724buffer.length; i2 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i2);
            int iM4092type = m4092type(iTypeAndOffsetAt);
            int iNumberAt = numberAt(i2);
            long jM4091offset = m4091offset(iTypeAndOffsetAt);
            int i3 = (iM4092type < FieldType.DOUBLE_LIST_PACKED.m4014id() || iM4092type > FieldType.SINT64_LIST_PACKED.m4014id()) ? 0 : this.f3724buffer[i2 + 2] & 1048575;
            switch (iM4092type) {
                case 0:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, UnsafeUtil.m4157getLong(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, UnsafeUtil.m4157getLong(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, UnsafeUtil.m4154getInt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t, i2)) {
                        Object object = UnsafeUtil.getObject(t, jM4091offset);
                        iComputeDoubleSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object) : CodedOutputStream.computeStringSize(iNumberAt, (String) object);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jM4091offset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, UnsafeUtil.m4154getInt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, UnsafeUtil.m4154getInt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, UnsafeUtil.m4154getInt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, UnsafeUtil.m4157getLong(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jM4091offset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 19:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 20:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt64List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 21:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt64List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 22:
                    iComputeDoubleSize = SchemaUtil.computeSizeInt32List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 23:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 24:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 25:
                    iComputeDoubleSize = SchemaUtil.computeSizeBoolList(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 26:
                    iComputeDoubleSize = SchemaUtil.computeSizeStringList(iNumberAt, m4089listAt(t, jM4091offset));
                    i += iComputeDoubleSize;
                    break;
                case 27:
                    iComputeDoubleSize = SchemaUtil.computeSizeMessageList(iNumberAt, m4089listAt(t, jM4091offset), getMessageFieldSchema(i2));
                    i += iComputeDoubleSize;
                    break;
                case 28:
                    iComputeDoubleSize = SchemaUtil.computeSizeByteStringList(iNumberAt, m4089listAt(t, jM4091offset));
                    i += iComputeDoubleSize;
                    break;
                case 29:
                    iComputeDoubleSize = SchemaUtil.computeSizeUInt32List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 30:
                    iComputeDoubleSize = SchemaUtil.computeSizeEnumList(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed32List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 32:
                    iComputeDoubleSize = SchemaUtil.computeSizeFixed64List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 33:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt32List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 34:
                    iComputeDoubleSize = SchemaUtil.computeSizeSInt64List(iNumberAt, m4089listAt(t, jM4091offset), false);
                    i += iComputeDoubleSize;
                    break;
                case 35:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 36:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 40:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 46:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 48:
                    iComputeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t, jM4091offset));
                    if (iComputeSizeFixed64ListNoTag <= 0) {
                        break;
                    } else {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t, i3, iComputeSizeFixed64ListNoTag);
                        }
                        iComputeTagSize = CodedOutputStream.computeTagSize(iNumberAt);
                        iComputeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(iComputeSizeFixed64ListNoTag);
                        iComputeDoubleSize = iComputeTagSize + iComputeUInt32SizeNoTag + iComputeSizeFixed64ListNoTag;
                        i += iComputeDoubleSize;
                        break;
                    }
                case 49:
                    iComputeDoubleSize = SchemaUtil.computeSizeGroupList(iNumberAt, m4089listAt(t, jM4091offset), getMessageFieldSchema(i2));
                    i += iComputeDoubleSize;
                    break;
                case 50:
                    iComputeDoubleSize = this.mapFieldSchema.getSerializedSize(iNumberAt, UnsafeUtil.getObject(t, jM4091offset), getMapFieldDefaultEntry(i2));
                    i += iComputeDoubleSize;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeDoubleSize(iNumberAt, 0.0d);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFloatSize(iNumberAt, 0.0f);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18346SEX /* 53 */:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt64Size(iNumberAt, oneofLongAt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt64Size(iNumberAt, oneofLongAt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeInt32Size(iNumberAt, oneofIntAt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBoolSize(iNumberAt, true);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        Object object2 = UnsafeUtil.getObject(t, jM4091offset);
                        iComputeDoubleSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(iNumberAt, (String) object2);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = SchemaUtil.computeSizeMessage(iNumberAt, UnsafeUtil.getObject(t, jM4091offset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeBytesSize(iNumberAt, (ByteString) UnsafeUtil.getObject(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeUInt32Size(iNumberAt, oneofIntAt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeEnumSize(iNumberAt, oneofIntAt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed32Size(iNumberAt, 0);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSFixed64Size(iNumberAt, 0L);
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt32Size(iNumberAt, oneofIntAt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeSInt64Size(iNumberAt, oneofLongAt(t, jM4091offset));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    if (isOneofPresent(t, iNumberAt, i2)) {
                        iComputeDoubleSize = CodedOutputStream.computeGroupSize(iNumberAt, (MessageLite) UnsafeUtil.getObject(t, jM4091offset), getMessageFieldSchema(i2));
                        i += iComputeDoubleSize;
                        break;
                    } else {
                        break;
                    }
            }
        }
        return i + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t);
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t));
    }

    /* renamed from: intAt */
    private static <T> int m4088intAt(T t, long j) {
        return UnsafeUtil.m4154getInt(t, j);
    }

    private static boolean isEnforceUtf8(int i) {
        return (i & 536870912) != 0;
    }

    private boolean isFieldPresent(T t, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? isFieldPresent(t, i) : (i3 & i4) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i, int i2) {
        List list = (List) UnsafeUtil.getObject(obj, m4091offset(i));
        if (list.isEmpty()) {
            return true;
        }
        InterfaceC0777Schema messageFieldSchema = getMessageFieldSchema(i2);
        for (int i3 = 0; i3 < list.size(); i3++) {
            if (!messageFieldSchema.isInitialized(list.get(i3))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.google.crypto.tink.shaded.protobuf.Schema] */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    private boolean isMapInitialized(T t, int i, int i2) {
        Map<?, ?> mapForMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t, m4091offset(i)));
        if (mapForMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? SchemaFor = 0;
        for (Object obj : mapForMapData.values()) {
            SchemaFor = SchemaFor;
            if (SchemaFor == 0) {
                SchemaFor = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!SchemaFor.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t, T t2, int i) {
        long jPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i) & 1048575;
        return UnsafeUtil.m4154getInt(t, jPresenceMaskAndOffsetAt) == UnsafeUtil.m4154getInt(t2, jPresenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t, int i, int i2) {
        return UnsafeUtil.m4154getInt(t, (long) (presenceMaskAndOffsetAt(i2) & 1048575)) == i;
    }

    private static boolean isRequired(int i) {
        return (i & REQUIRED_MASK) != 0;
    }

    /* renamed from: listAt */
    private static List<?> m4089listAt(Object obj, long j) {
        return (List) UnsafeUtil.getObject(obj, j);
    }

    /* renamed from: longAt */
    private static <T> long m4090longAt(T t, long j) {
        return UnsafeUtil.m4157getLong(t, j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:243:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
    
        r0 = r18.checkInitializedCount;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
    
        if (r0 >= r18.repeatedFieldOffsetStart) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009b, code lost:
    
        r4 = filterMapUnknownEnumValues(r21, r18.intArray[r0], r4, r19, r21);
        r0 = r0 + 1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
    
        r10 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
    
        if (r4 == null) goto L243;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b4, code lost:
    
        r7.setBuilderToMessage(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b7, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:172:0x064f A[Catch: all -> 0x0675, TRY_LEAVE, TryCatch #9 {all -> 0x0675, blocks: (B:170:0x0649, B:172:0x064f, B:184:0x0679, B:185:0x067e), top: B:213:0x0649 }] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x06b5 A[LOOP:4: B:198:0x06b1->B:200:0x06b5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x06ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t, InterfaceC0775Reader interfaceC0775Reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        UnknownFieldSchema unknownFieldSchema2;
        T t2;
        int i;
        Object objFilterMapUnknownEnumValues;
        T t3;
        Object mutableExtensions;
        ExtensionRegistryLite extensionRegistryLite2;
        Object obj;
        UnknownFieldSchema unknownFieldSchema3 = unknownFieldSchema;
        T t4 = t;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite;
        Object builderFromMessage = null;
        Object obj2 = null;
        while (true) {
            try {
                int fieldNumber = interfaceC0775Reader.getFieldNumber();
                int iPositionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (iPositionForFieldNumber >= 0) {
                    t2 = t4;
                    try {
                        int iTypeAndOffsetAt = typeAndOffsetAt(iPositionForFieldNumber);
                        switch (m4092type(iTypeAndOffsetAt)) {
                            case 0:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putDouble(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readDouble());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 1:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putFloat(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readFloat());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 2:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4166putLong(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readInt64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 3:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4166putLong(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readUInt64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 4:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4163putInt(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readInt32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 5:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4166putLong(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readFixed64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 6:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4163putInt(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readFixed32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 7:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putBoolean(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readBool());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 8:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readString(t2, iTypeAndOffsetAt, interfaceC0775Reader);
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 9:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                MessageLite messageLite = (MessageLite) mutableMessageFieldForMerge(t2, iPositionForFieldNumber);
                                interfaceC0775Reader.mergeMessageField(messageLite, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                storeMessageField(t2, iPositionForFieldNumber, messageLite);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 10:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readBytes());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 11:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4163putInt(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readUInt32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 12:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                int i2 = interfaceC0775Reader.readEnum();
                                Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(iPositionForFieldNumber);
                                if (enumFieldVerifier != null && !enumFieldVerifier.isInRange(i2)) {
                                    builderFromMessage = SchemaUtil.storeUnknownEnum(t2, fieldNumber, i2, obj, unknownFieldSchema2);
                                    t4 = t2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                }
                                UnsafeUtil.m4163putInt(t2, m4091offset(iTypeAndOffsetAt), i2);
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 13:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4163putInt(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readSFixed32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 14:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4166putLong(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readSFixed64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 15:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4163putInt(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readSInt32());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 16:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.m4166putLong(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readSInt64());
                                setFieldPresent(t2, iPositionForFieldNumber);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 17:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                MessageLite messageLite2 = (MessageLite) mutableMessageFieldForMerge(t2, iPositionForFieldNumber);
                                interfaceC0775Reader.mergeGroupField(messageLite2, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite2);
                                storeMessageField(t2, iPositionForFieldNumber, messageLite2);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 18:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readDoubleList(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 19:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readFloatList(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 20:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readInt64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 21:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readUInt64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 22:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readInt32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 23:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readFixed64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 24:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readFixed32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 25:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readBoolList(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 26:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readStringList(t2, iTypeAndOffsetAt, interfaceC0775Reader);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 27:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readMessageList(t, iTypeAndOffsetAt, interfaceC0775Reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 28:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readBytesList(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 29:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readUInt32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 30:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                List<Integer> listMutableListAt = this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt));
                                interfaceC0775Reader.readEnumList(listMutableListAt);
                                builderFromMessage = SchemaUtil.filterUnknownEnumList(t, fieldNumber, listMutableListAt, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case InterfaceC5102BERTags.f17975DATE /* 31 */:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readSFixed32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 32:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readSFixed64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 33:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readSInt32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 34:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readSInt64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 35:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readDoubleList(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 36:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readFloatList(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readInt64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readUInt64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readInt32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 40:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readFixed64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readFixed32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.CURRENCY_CODE /* 42 */:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readBoolList(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readUInt32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                List<Integer> listMutableListAt2 = this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt));
                                interfaceC0775Reader.readEnumList(listMutableListAt2);
                                builderFromMessage = SchemaUtil.filterUnknownEnumList(t, fieldNumber, listMutableListAt2, getEnumFieldVerifier(iPositionForFieldNumber), builderFromMessage, unknownFieldSchema);
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readSFixed32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 46:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readSFixed64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readSInt32List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 48:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                interfaceC0775Reader.readSInt64List(this.listFieldSchema.mutableListAt(t2, m4091offset(iTypeAndOffsetAt)));
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 49:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                try {
                                    readGroupList(t, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite);
                                    builderFromMessage = obj;
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                    builderFromMessage = obj;
                                    try {
                                        if (!unknownFieldSchema2.shouldDiscardUnknownFields(interfaceC0775Reader)) {
                                            if (builderFromMessage == null) {
                                                builderFromMessage = unknownFieldSchema2.getBuilderFromMessage(t2);
                                            }
                                            if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage, interfaceC0775Reader)) {
                                                Object objFilterMapUnknownEnumValues2 = builderFromMessage;
                                                for (int i3 = this.checkInitializedCount; i3 < this.repeatedFieldOffsetStart; i3++) {
                                                    objFilterMapUnknownEnumValues2 = filterMapUnknownEnumValues(t, this.intArray[i3], objFilterMapUnknownEnumValues2, unknownFieldSchema, t);
                                                }
                                                if (objFilterMapUnknownEnumValues2 != null) {
                                                    unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues2);
                                                    return;
                                                }
                                                return;
                                            }
                                        } else if (!interfaceC0775Reader.skipField()) {
                                            Object objFilterMapUnknownEnumValues3 = builderFromMessage;
                                            for (int i4 = this.checkInitializedCount; i4 < this.repeatedFieldOffsetStart; i4++) {
                                                objFilterMapUnknownEnumValues3 = filterMapUnknownEnumValues(t, this.intArray[i4], objFilterMapUnknownEnumValues3, unknownFieldSchema, t);
                                            }
                                            if (objFilterMapUnknownEnumValues3 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues3);
                                                return;
                                            }
                                            return;
                                        }
                                        t4 = t2;
                                        extensionRegistryLite3 = extensionRegistryLite2;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                    } catch (Throwable th) {
                                        th = th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    builderFromMessage = obj;
                                    objFilterMapUnknownEnumValues = builderFromMessage;
                                    while (i < this.repeatedFieldOffsetStart) {
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                    }
                                    throw th;
                                }
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 50:
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                try {
                                    mergeMap(t, iPositionForFieldNumber, getMapFieldDefaultEntry(iPositionForFieldNumber), extensionRegistryLite, interfaceC0775Reader);
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    if (!unknownFieldSchema2.shouldDiscardUnknownFields(interfaceC0775Reader)) {
                                    }
                                    t4 = t2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    builderFromMessage = obj;
                                    objFilterMapUnknownEnumValues = builderFromMessage;
                                    while (i < this.repeatedFieldOffsetStart) {
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                    }
                                    throw th;
                                }
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 51:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Double.valueOf(interfaceC0775Reader.readDouble()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Float.valueOf(interfaceC0775Reader.readFloat()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.f18346SEX /* 53 */:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Long.valueOf(interfaceC0775Reader.readInt64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Long.valueOf(interfaceC0775Reader.readUInt64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 55:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Integer.valueOf(interfaceC0775Reader.readInt32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 56:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Long.valueOf(interfaceC0775Reader.readFixed64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 57:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Integer.valueOf(interfaceC0775Reader.readFixed32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Boolean.valueOf(interfaceC0775Reader.readBool()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                                readString(t2, iTypeAndOffsetAt, interfaceC0775Reader);
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 60:
                                MessageLite messageLite3 = (MessageLite) mutableOneofMessageFieldForMerge(t2, fieldNumber, iPositionForFieldNumber);
                                interfaceC0775Reader.mergeMessageField(messageLite3, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                storeOneofMessageField(t2, fieldNumber, iPositionForFieldNumber, messageLite3);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 61:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), interfaceC0775Reader.readBytes());
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 62:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Integer.valueOf(interfaceC0775Reader.readUInt32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case 63:
                                int i5 = interfaceC0775Reader.readEnum();
                                Internal.EnumVerifier enumFieldVerifier2 = getEnumFieldVerifier(iPositionForFieldNumber);
                                if (enumFieldVerifier2 != null && !enumFieldVerifier2.isInRange(i5)) {
                                    builderFromMessage = SchemaUtil.storeUnknownEnum(t2, fieldNumber, i5, builderFromMessage, unknownFieldSchema3);
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    t4 = t2;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                }
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Integer.valueOf(i5));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 64:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Integer.valueOf(interfaceC0775Reader.readSFixed32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.ELEMENT_LIST /* 65 */:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Long.valueOf(interfaceC0775Reader.readSFixed64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.f18344ADDRESS /* 66 */:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Integer.valueOf(interfaceC0775Reader.readSInt32()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                                UnsafeUtil.putObject(t2, m4091offset(iTypeAndOffsetAt), Long.valueOf(interfaceC0775Reader.readSInt64()));
                                setOneofPresent(t2, fieldNumber, iPositionForFieldNumber);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                                MessageLite messageLite4 = (MessageLite) mutableOneofMessageFieldForMerge(t2, fieldNumber, iPositionForFieldNumber);
                                interfaceC0775Reader.mergeGroupField(messageLite4, getMessageFieldSchema(iPositionForFieldNumber), extensionRegistryLite3);
                                storeOneofMessageField(t2, fieldNumber, iPositionForFieldNumber, messageLite4);
                                obj = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                builderFromMessage = obj;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                            default:
                                if (builderFromMessage == null) {
                                    try {
                                        builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t2);
                                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                        extensionRegistryLite2 = extensionRegistryLite3;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        if (!unknownFieldSchema2.shouldDiscardUnknownFields(interfaceC0775Reader)) {
                                        }
                                        t4 = t2;
                                        extensionRegistryLite3 = extensionRegistryLite2;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        unknownFieldSchema2 = unknownFieldSchema3;
                                        objFilterMapUnknownEnumValues = builderFromMessage;
                                        while (i < this.repeatedFieldOffsetStart) {
                                        }
                                        if (objFilterMapUnknownEnumValues != null) {
                                        }
                                        throw th;
                                    }
                                }
                                if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, interfaceC0775Reader)) {
                                    Object objFilterMapUnknownEnumValues4 = builderFromMessage;
                                    for (int i6 = this.checkInitializedCount; i6 < this.repeatedFieldOffsetStart; i6++) {
                                        objFilterMapUnknownEnumValues4 = filterMapUnknownEnumValues(t, this.intArray[i6], objFilterMapUnknownEnumValues4, unknownFieldSchema, t);
                                    }
                                    if (objFilterMapUnknownEnumValues4 != null) {
                                        unknownFieldSchema3.setBuilderToMessage(t2, objFilterMapUnknownEnumValues4);
                                        return;
                                    }
                                    return;
                                }
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t4 = t2;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                } else {
                    if (fieldNumber == Integer.MAX_VALUE) {
                        Object objFilterMapUnknownEnumValues5 = builderFromMessage;
                        for (int i7 = this.checkInitializedCount; i7 < this.repeatedFieldOffsetStart; i7++) {
                            objFilterMapUnknownEnumValues5 = filterMapUnknownEnumValues(t, this.intArray[i7], objFilterMapUnknownEnumValues5, unknownFieldSchema, t);
                        }
                        if (objFilterMapUnknownEnumValues5 != null) {
                            unknownFieldSchema3.setBuilderToMessage(t4, objFilterMapUnknownEnumValues5);
                            return;
                        }
                        return;
                    }
                    try {
                        Object objFindExtensionByNumber = !this.hasExtensions ? null : extensionSchema.findExtensionByNumber(extensionRegistryLite3, this.defaultInstance, fieldNumber);
                        if (objFindExtensionByNumber != null) {
                            if (obj2 == null) {
                                try {
                                    mutableExtensions = extensionSchema.getMutableExtensions(t);
                                } catch (Throwable th6) {
                                    th = th6;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    t2 = t4;
                                    objFilterMapUnknownEnumValues = builderFromMessage;
                                    while (i < this.repeatedFieldOffsetStart) {
                                    }
                                    if (objFilterMapUnknownEnumValues != null) {
                                    }
                                    throw th;
                                }
                            } else {
                                mutableExtensions = obj2;
                            }
                            t3 = t4;
                            try {
                                builderFromMessage = extensionSchema.parseExtension(t, interfaceC0775Reader, objFindExtensionByNumber, extensionRegistryLite, mutableExtensions, builderFromMessage, unknownFieldSchema);
                                obj2 = mutableExtensions;
                            } catch (Throwable th7) {
                                th = th7;
                                t2 = t3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                objFilterMapUnknownEnumValues = builderFromMessage;
                                while (i < this.repeatedFieldOffsetStart) {
                                }
                                if (objFilterMapUnknownEnumValues != null) {
                                }
                                throw th;
                            }
                        } else {
                            t3 = t4;
                            if (!unknownFieldSchema3.shouldDiscardUnknownFields(interfaceC0775Reader)) {
                                if (builderFromMessage == null) {
                                    builderFromMessage = unknownFieldSchema3.getBuilderFromMessage(t3);
                                }
                                if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, interfaceC0775Reader)) {
                                }
                            } else if (!interfaceC0775Reader.skipField()) {
                            }
                        }
                        t4 = t3;
                    } catch (Throwable th8) {
                        th = th8;
                        t2 = t4;
                    }
                }
            } catch (Throwable th9) {
                th = th9;
            }
            objFilterMapUnknownEnumValues = builderFromMessage;
            for (i = this.checkInitializedCount; i < this.repeatedFieldOffsetStart; i++) {
                objFilterMapUnknownEnumValues = filterMapUnknownEnumValues(t, this.intArray[i], objFilterMapUnknownEnumValues, unknownFieldSchema, t);
            }
            if (objFilterMapUnknownEnumValues != null) {
                unknownFieldSchema2.setBuilderToMessage(t2, objFilterMapUnknownEnumValues);
            }
            throw th;
        }
    }

    private final <K, V> void mergeMap(Object obj, int i, Object obj2, ExtensionRegistryLite extensionRegistryLite, InterfaceC0775Reader interfaceC0775Reader) {
        long jM4091offset = m4091offset(typeAndOffsetAt(i));
        Object object = UnsafeUtil.getObject(obj, jM4091offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, jM4091offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            UnsafeUtil.putObject(obj, jM4091offset, objNewMapField);
            object = objNewMapField;
        }
        interfaceC0775Reader.mo3921readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t, T t2, int i) {
        if (isFieldPresent(t2, i)) {
            long jM4091offset = m4091offset(typeAndOffsetAt(i));
            Unsafe unsafe = f3723UNSAFE;
            Object object = unsafe.getObject(t2, jM4091offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
            }
            InterfaceC0777Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isFieldPresent(t, i)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t, jM4091offset, objNewInstance);
                } else {
                    unsafe.putObject(t, jM4091offset, object);
                }
                setFieldPresent(t, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jM4091offset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t, jM4091offset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t, T t2, int i) {
        int iNumberAt = numberAt(i);
        if (isOneofPresent(t2, iNumberAt, i)) {
            long jM4091offset = m4091offset(typeAndOffsetAt(i));
            Unsafe unsafe = f3723UNSAFE;
            Object object = unsafe.getObject(t2, jM4091offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i) + " is present but null: " + t2);
            }
            InterfaceC0777Schema messageFieldSchema = getMessageFieldSchema(i);
            if (!isOneofPresent(t, iNumberAt, i)) {
                if (isMutable(object)) {
                    Object objNewInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(objNewInstance, object);
                    unsafe.putObject(t, jM4091offset, objNewInstance);
                } else {
                    unsafe.putObject(t, jM4091offset, object);
                }
                setOneofPresent(t, iNumberAt, i);
                return;
            }
            Object object2 = unsafe.getObject(t, jM4091offset);
            if (!isMutable(object2)) {
                Object objNewInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(objNewInstance2, object2);
                unsafe.putObject(t, jM4091offset, objNewInstance2);
                object2 = objNewInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jM4091offset = m4091offset(iTypeAndOffsetAt);
        int iNumberAt = numberAt(i);
        switch (m4092type(iTypeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putDouble(t, jM4091offset, UnsafeUtil.getDouble(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 1:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putFloat(t, jM4091offset, UnsafeUtil.getFloat(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 2:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4166putLong(t, jM4091offset, UnsafeUtil.m4157getLong(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 3:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4166putLong(t, jM4091offset, UnsafeUtil.m4157getLong(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 4:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4163putInt(t, jM4091offset, UnsafeUtil.m4154getInt(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 5:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4166putLong(t, jM4091offset, UnsafeUtil.m4157getLong(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 6:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4163putInt(t, jM4091offset, UnsafeUtil.m4154getInt(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 7:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putBoolean(t, jM4091offset, UnsafeUtil.getBoolean(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 8:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jM4091offset, UnsafeUtil.getObject(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 9:
                mergeMessage(t, t2, i);
                break;
            case 10:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.putObject(t, jM4091offset, UnsafeUtil.getObject(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 11:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4163putInt(t, jM4091offset, UnsafeUtil.m4154getInt(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 12:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4163putInt(t, jM4091offset, UnsafeUtil.m4154getInt(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 13:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4163putInt(t, jM4091offset, UnsafeUtil.m4154getInt(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 14:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4166putLong(t, jM4091offset, UnsafeUtil.m4157getLong(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 15:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4163putInt(t, jM4091offset, UnsafeUtil.m4154getInt(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 16:
                if (isFieldPresent(t2, i)) {
                    UnsafeUtil.m4166putLong(t, jM4091offset, UnsafeUtil.m4157getLong(t2, jM4091offset));
                    setFieldPresent(t, i);
                    break;
                }
                break;
            case 17:
                mergeMessage(t, t2, i);
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case InterfaceC5102BERTags.f17975DATE /* 31 */:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
            case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
            case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
            case 40:
            case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
            case C5125EACTags.CURRENCY_CODE /* 42 */:
            case C5125EACTags.DATE_OF_BIRTH /* 43 */:
            case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
            case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
            case 46:
            case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t, t2, jM4091offset);
                break;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t, t2, jM4091offset);
                break;
            case 51:
            case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
            case C5125EACTags.f18346SEX /* 53 */:
            case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
            case 55:
            case 56:
            case 57:
            case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
            case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jM4091offset, UnsafeUtil.getObject(t2, jM4091offset));
                    setOneofPresent(t, iNumberAt, i);
                    break;
                }
                break;
            case 60:
                mergeOneofMessage(t, t2, i);
                break;
            case 61:
            case 62:
            case 63:
            case 64:
            case C5125EACTags.ELEMENT_LIST /* 65 */:
            case C5125EACTags.f18344ADDRESS /* 66 */:
            case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                if (isOneofPresent(t2, iNumberAt, i)) {
                    UnsafeUtil.putObject(t, jM4091offset, UnsafeUtil.getObject(t2, jM4091offset));
                    setOneofPresent(t, iNumberAt, i);
                    break;
                }
                break;
            case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                mergeOneofMessage(t, t2, i);
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t, int i) {
        InterfaceC0777Schema messageFieldSchema = getMessageFieldSchema(i);
        long jM4091offset = m4091offset(typeAndOffsetAt(i));
        if (!isFieldPresent(t, i)) {
            return messageFieldSchema.newInstance();
        }
        Object object = f3723UNSAFE.getObject(t, jM4091offset);
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t, int i, int i2) {
        InterfaceC0777Schema messageFieldSchema = getMessageFieldSchema(i2);
        if (!isOneofPresent(t, i, i2)) {
            return messageFieldSchema.newInstance();
        }
        Object object = f3723UNSAFE.getObject(t, m4091offset(typeAndOffsetAt(i2)));
        if (isMutable(object)) {
            return object;
        }
        Object objNewInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(objNewInstance, object);
        }
        return objNewInstance;
    }

    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        return messageInfo instanceof RawMessageInfo ? newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema) : newSchemaForMessageInfo((StructuralMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    public static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int fieldNumber;
        int fieldNumber2;
        int i;
        boolean z = structuralMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        FieldInfo[] fields = structuralMessageInfo.getFields();
        if (fields.length == 0) {
            fieldNumber = 0;
            fieldNumber2 = 0;
        } else {
            fieldNumber = fields[0].getFieldNumber();
            fieldNumber2 = fields[fields.length - 1].getFieldNumber();
        }
        int length = fields.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        int i2 = 0;
        int i3 = 0;
        for (FieldInfo fieldInfo : fields) {
            if (fieldInfo.m4001getType() == FieldType.f3658MAP) {
                i2++;
            } else if (fieldInfo.m4001getType().m4014id() >= 18 && fieldInfo.m4001getType().m4014id() <= 49) {
                i3++;
            }
        }
        int[] iArr2 = i2 > 0 ? new int[i2] : null;
        int[] iArr3 = i3 > 0 ? new int[i3] : null;
        int[] checkInitialized = structuralMessageInfo.getCheckInitialized();
        if (checkInitialized == null) {
            checkInitialized = EMPTY_INT_ARRAY;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i4 < fields.length) {
            FieldInfo fieldInfo2 = fields[i4];
            int fieldNumber3 = fieldInfo2.getFieldNumber();
            storeFieldData(fieldInfo2, iArr, i5, objArr);
            if (i6 < checkInitialized.length && checkInitialized[i6] == fieldNumber3) {
                checkInitialized[i6] = i5;
                i6++;
            }
            if (fieldInfo2.m4001getType() == FieldType.f3658MAP) {
                iArr2[i7] = i5;
                i7++;
            } else {
                if (fieldInfo2.m4001getType().m4014id() >= 18 && fieldInfo2.m4001getType().m4014id() <= 49) {
                    i = i5;
                    iArr3[i8] = (int) UnsafeUtil.objectFieldOffset(fieldInfo2.getField());
                    i8++;
                }
                i4++;
                i5 = i + 3;
            }
            i = i5;
            i4++;
            i5 = i + 3;
        }
        if (iArr2 == null) {
            iArr2 = EMPTY_INT_ARRAY;
        }
        if (iArr3 == null) {
            iArr3 = EMPTY_INT_ARRAY;
        }
        int[] iArr4 = new int[checkInitialized.length + iArr2.length + iArr3.length];
        System.arraycopy(checkInitialized, 0, iArr4, 0, checkInitialized.length);
        System.arraycopy(iArr2, 0, iArr4, checkInitialized.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, checkInitialized.length + iArr2.length, iArr3.length);
        return new MessageSchema<>(iArr, objArr, fieldNumber, fieldNumber2, structuralMessageInfo.getDefaultInstance(), z, true, iArr4, checkInitialized.length, checkInitialized.length + iArr2.length, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x036d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i;
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        int iCharAt5;
        int[] iArr;
        int i2;
        int i3;
        int i4;
        char cCharAt;
        int i5;
        char cCharAt2;
        int i6;
        char cCharAt3;
        int i7;
        char cCharAt4;
        int i8;
        char cCharAt5;
        int i9;
        char cCharAt6;
        int i10;
        char cCharAt7;
        int i11;
        char cCharAt8;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int iObjectFieldOffset;
        String str;
        boolean z;
        int iObjectFieldOffset2;
        int i18;
        int i19;
        Field fieldReflectField;
        char cCharAt9;
        int i20;
        int i21;
        Object obj;
        Field fieldReflectField2;
        Object obj2;
        Field fieldReflectField3;
        int i22;
        char cCharAt10;
        int i23;
        char cCharAt11;
        int i24;
        char cCharAt12;
        int i25;
        char cCharAt13;
        boolean z2 = rawMessageInfo.getSyntax() == ProtoSyntax.PROTO3;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        char c = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i26 = 1;
            while (true) {
                i = i26 + 1;
                if (stringInfo.charAt(i26) < 55296) {
                    break;
                }
                i26 = i;
            }
        } else {
            i = 1;
        }
        int i27 = i + 1;
        int iCharAt6 = stringInfo.charAt(i);
        if (iCharAt6 >= 55296) {
            int i28 = iCharAt6 & 8191;
            int i29 = 13;
            while (true) {
                i25 = i27 + 1;
                cCharAt13 = stringInfo.charAt(i27);
                if (cCharAt13 < 55296) {
                    break;
                }
                i28 |= (cCharAt13 & 8191) << i29;
                i29 += 13;
                i27 = i25;
            }
            iCharAt6 = i28 | (cCharAt13 << i29);
            i27 = i25;
        }
        if (iCharAt6 == 0) {
            iCharAt = 0;
            iCharAt2 = 0;
            iCharAt3 = 0;
            iCharAt4 = 0;
            iCharAt5 = 0;
            i2 = 0;
            iArr = EMPTY_INT_ARRAY;
            i3 = 0;
        } else {
            int i30 = i27 + 1;
            int iCharAt7 = stringInfo.charAt(i27);
            if (iCharAt7 >= 55296) {
                int i31 = iCharAt7 & 8191;
                int i32 = 13;
                while (true) {
                    i11 = i30 + 1;
                    cCharAt8 = stringInfo.charAt(i30);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i31 |= (cCharAt8 & 8191) << i32;
                    i32 += 13;
                    i30 = i11;
                }
                iCharAt7 = i31 | (cCharAt8 << i32);
                i30 = i11;
            }
            int i33 = i30 + 1;
            int iCharAt8 = stringInfo.charAt(i30);
            if (iCharAt8 >= 55296) {
                int i34 = iCharAt8 & 8191;
                int i35 = 13;
                while (true) {
                    i10 = i33 + 1;
                    cCharAt7 = stringInfo.charAt(i33);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i34 |= (cCharAt7 & 8191) << i35;
                    i35 += 13;
                    i33 = i10;
                }
                iCharAt8 = i34 | (cCharAt7 << i35);
                i33 = i10;
            }
            int i36 = i33 + 1;
            iCharAt = stringInfo.charAt(i33);
            if (iCharAt >= 55296) {
                int i37 = iCharAt & 8191;
                int i38 = 13;
                while (true) {
                    i9 = i36 + 1;
                    cCharAt6 = stringInfo.charAt(i36);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i37 |= (cCharAt6 & 8191) << i38;
                    i38 += 13;
                    i36 = i9;
                }
                iCharAt = i37 | (cCharAt6 << i38);
                i36 = i9;
            }
            int i39 = i36 + 1;
            iCharAt2 = stringInfo.charAt(i36);
            if (iCharAt2 >= 55296) {
                int i40 = iCharAt2 & 8191;
                int i41 = 13;
                while (true) {
                    i8 = i39 + 1;
                    cCharAt5 = stringInfo.charAt(i39);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i40 |= (cCharAt5 & 8191) << i41;
                    i41 += 13;
                    i39 = i8;
                }
                iCharAt2 = i40 | (cCharAt5 << i41);
                i39 = i8;
            }
            int i42 = i39 + 1;
            iCharAt3 = stringInfo.charAt(i39);
            if (iCharAt3 >= 55296) {
                int i43 = iCharAt3 & 8191;
                int i44 = 13;
                while (true) {
                    i7 = i42 + 1;
                    cCharAt4 = stringInfo.charAt(i42);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i43 |= (cCharAt4 & 8191) << i44;
                    i44 += 13;
                    i42 = i7;
                }
                iCharAt3 = i43 | (cCharAt4 << i44);
                i42 = i7;
            }
            int i45 = i42 + 1;
            iCharAt4 = stringInfo.charAt(i42);
            if (iCharAt4 >= 55296) {
                int i46 = iCharAt4 & 8191;
                int i47 = 13;
                while (true) {
                    i6 = i45 + 1;
                    cCharAt3 = stringInfo.charAt(i45);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i46 |= (cCharAt3 & 8191) << i47;
                    i47 += 13;
                    i45 = i6;
                }
                iCharAt4 = i46 | (cCharAt3 << i47);
                i45 = i6;
            }
            int i48 = i45 + 1;
            int iCharAt9 = stringInfo.charAt(i45);
            if (iCharAt9 >= 55296) {
                int i49 = iCharAt9 & 8191;
                int i50 = 13;
                while (true) {
                    i5 = i48 + 1;
                    cCharAt2 = stringInfo.charAt(i48);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i49 |= (cCharAt2 & 8191) << i50;
                    i50 += 13;
                    i48 = i5;
                }
                iCharAt9 = i49 | (cCharAt2 << i50);
                i48 = i5;
            }
            int i51 = i48 + 1;
            iCharAt5 = stringInfo.charAt(i48);
            if (iCharAt5 >= 55296) {
                int i52 = iCharAt5 & 8191;
                int i53 = 13;
                while (true) {
                    i4 = i51 + 1;
                    cCharAt = stringInfo.charAt(i51);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i52 |= (cCharAt & 8191) << i53;
                    i53 += 13;
                    i51 = i4;
                }
                iCharAt5 = i52 | (cCharAt << i53);
                i51 = i4;
            }
            iArr = new int[iCharAt5 + iCharAt4 + iCharAt9];
            i2 = (iCharAt7 * 2) + iCharAt8;
            i3 = iCharAt7;
            i27 = i51;
        }
        Unsafe unsafe = f3723UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr2 = new int[iCharAt3 * 3];
        Object[] objArr = new Object[iCharAt3 * 2];
        int i54 = iCharAt5 + iCharAt4;
        int i55 = iCharAt5;
        int i56 = i54;
        int i57 = 0;
        int i58 = 0;
        while (i27 < length) {
            int i59 = i27 + 1;
            int iCharAt10 = stringInfo.charAt(i27);
            if (iCharAt10 >= c) {
                int i60 = iCharAt10 & 8191;
                int i61 = i59;
                int i62 = 13;
                while (true) {
                    i24 = i61 + 1;
                    cCharAt12 = stringInfo.charAt(i61);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i60 |= (cCharAt12 & 8191) << i62;
                    i62 += 13;
                    i61 = i24;
                }
                iCharAt10 = i60 | (cCharAt12 << i62);
                i12 = i24;
            } else {
                i12 = i59;
            }
            int i63 = i12 + 1;
            int iCharAt11 = stringInfo.charAt(i12);
            if (iCharAt11 >= c) {
                int i64 = iCharAt11 & 8191;
                int i65 = i63;
                int i66 = 13;
                while (true) {
                    i23 = i65 + 1;
                    cCharAt11 = stringInfo.charAt(i65);
                    i13 = length;
                    if (cCharAt11 < 55296) {
                        break;
                    }
                    i64 |= (cCharAt11 & 8191) << i66;
                    i66 += 13;
                    i65 = i23;
                    length = i13;
                }
                iCharAt11 = i64 | (cCharAt11 << i66);
                i14 = i23;
            } else {
                i13 = length;
                i14 = i63;
            }
            int i67 = iCharAt11 & 255;
            int i68 = iCharAt5;
            if ((iCharAt11 & 1024) != 0) {
                iArr[i57] = i58;
                i57++;
            }
            int i69 = i57;
            if (i67 >= 51) {
                int i70 = i14 + 1;
                int iCharAt12 = stringInfo.charAt(i14);
                char c2 = 55296;
                if (iCharAt12 >= 55296) {
                    int i71 = iCharAt12 & 8191;
                    int i72 = 13;
                    while (true) {
                        i22 = i70 + 1;
                        cCharAt10 = stringInfo.charAt(i70);
                        if (cCharAt10 < c2) {
                            break;
                        }
                        i71 |= (cCharAt10 & 8191) << i72;
                        i72 += 13;
                        i70 = i22;
                        c2 = 55296;
                    }
                    iCharAt12 = i71 | (cCharAt10 << i72);
                    i70 = i22;
                }
                int i73 = i67 - 51;
                int i74 = i70;
                if (i73 == 9 || i73 == 17) {
                    i21 = i2 + 1;
                    objArr[((i58 / 3) * 2) + 1] = objects[i2];
                } else {
                    if (i73 == 12 && !z2) {
                        i21 = i2 + 1;
                        objArr[((i58 / 3) * 2) + 1] = objects[i2];
                    }
                    int i75 = iCharAt12 * 2;
                    obj = objects[i75];
                    if (obj instanceof Field) {
                        fieldReflectField2 = reflectField(cls, (String) obj);
                        objects[i75] = fieldReflectField2;
                    } else {
                        fieldReflectField2 = (Field) obj;
                    }
                    i15 = iCharAt;
                    i16 = iCharAt2;
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                    int i76 = i75 + 1;
                    obj2 = objects[i76];
                    if (obj2 instanceof Field) {
                        fieldReflectField3 = reflectField(cls, (String) obj2);
                        objects[i76] = fieldReflectField3;
                    } else {
                        fieldReflectField3 = (Field) obj2;
                    }
                    str = stringInfo;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                    z = z2;
                    i18 = i74;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i19 = 0;
                }
                i2 = i21;
                int i752 = iCharAt12 * 2;
                obj = objects[i752];
                if (obj instanceof Field) {
                }
                i15 = iCharAt;
                i16 = iCharAt2;
                int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldReflectField2);
                int i762 = i752 + 1;
                obj2 = objects[i762];
                if (obj2 instanceof Field) {
                }
                str = stringInfo;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField3);
                z = z2;
                i18 = i74;
                iObjectFieldOffset = iObjectFieldOffset32;
                i19 = 0;
            } else {
                i15 = iCharAt;
                i16 = iCharAt2;
                int i77 = i2 + 1;
                Field fieldReflectField4 = reflectField(cls, (String) objects[i2]);
                if (i67 == 9 || i67 == 17) {
                    objArr[((i58 / 3) * 2) + 1] = fieldReflectField4.getType();
                } else {
                    if (i67 == 27 || i67 == 49) {
                        i20 = i2 + 2;
                        objArr[((i58 / 3) * 2) + 1] = objects[i77];
                    } else if (i67 == 12 || i67 == 30 || i67 == 44) {
                        if (!z2) {
                            i20 = i2 + 2;
                            objArr[((i58 / 3) * 2) + 1] = objects[i77];
                        }
                    } else if (i67 == 50) {
                        int i78 = i55 + 1;
                        iArr[i55] = i58;
                        int i79 = (i58 / 3) * 2;
                        int i80 = i2 + 2;
                        objArr[i79] = objects[i77];
                        if ((iCharAt11 & 2048) != 0) {
                            i77 = i2 + 3;
                            objArr[i79 + 1] = objects[i80];
                            i55 = i78;
                        } else {
                            i55 = i78;
                            i17 = i80;
                            iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                            i2 = i17;
                            if ((iCharAt11 & 4096) != 4096 || i67 > 17) {
                                str = stringInfo;
                                z = z2;
                                iObjectFieldOffset2 = 1048575;
                                i18 = i14;
                                i19 = 0;
                            } else {
                                int i81 = i14 + 1;
                                int iCharAt13 = stringInfo.charAt(i14);
                                if (iCharAt13 >= 55296) {
                                    int i82 = iCharAt13 & 8191;
                                    int i83 = 13;
                                    while (true) {
                                        i18 = i81 + 1;
                                        cCharAt9 = stringInfo.charAt(i81);
                                        if (cCharAt9 < 55296) {
                                            break;
                                        }
                                        i82 |= (cCharAt9 & 8191) << i83;
                                        i83 += 13;
                                        i81 = i18;
                                    }
                                    iCharAt13 = i82 | (cCharAt9 << i83);
                                } else {
                                    i18 = i81;
                                }
                                int i84 = (i3 * 2) + (iCharAt13 / 32);
                                Object obj3 = objects[i84];
                                str = stringInfo;
                                if (obj3 instanceof Field) {
                                    fieldReflectField = (Field) obj3;
                                } else {
                                    fieldReflectField = reflectField(cls, (String) obj3);
                                    objects[i84] = fieldReflectField;
                                }
                                z = z2;
                                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldReflectField);
                                i19 = iCharAt13 % 32;
                            }
                            if (i67 >= 18 && i67 <= 49) {
                                iArr[i56] = iObjectFieldOffset;
                                i56++;
                            }
                        }
                    }
                    i17 = i20;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                    i2 = i17;
                    if ((iCharAt11 & 4096) != 4096) {
                        str = stringInfo;
                        z = z2;
                        iObjectFieldOffset2 = 1048575;
                        i18 = i14;
                        i19 = 0;
                        if (i67 >= 18) {
                            iArr[i56] = iObjectFieldOffset;
                            i56++;
                        }
                    }
                }
                i17 = i77;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldReflectField4);
                i2 = i17;
                if ((iCharAt11 & 4096) != 4096) {
                }
            }
            int i85 = i58 + 1;
            iArr2[i58] = iCharAt10;
            int i86 = i58 + 2;
            iArr2[i85] = ((iCharAt11 & 256) != 0 ? REQUIRED_MASK : 0) | ((iCharAt11 & 512) != 0 ? 536870912 : 0) | (i67 << 20) | iObjectFieldOffset;
            i58 += 3;
            iArr2[i86] = (i19 << 20) | iObjectFieldOffset2;
            z2 = z;
            iCharAt = i15;
            iCharAt5 = i68;
            i27 = i18;
            length = i13;
            stringInfo = str;
            i57 = i69;
            iCharAt2 = i16;
            c = 55296;
        }
        return new MessageSchema<>(iArr2, objArr, iCharAt, iCharAt2, rawMessageInfo.getDefaultInstance(), z2, false, iArr, iCharAt5, i54, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private int numberAt(int i) {
        return this.f3724buffer[i];
    }

    /* renamed from: offset */
    private static long m4091offset(int i) {
        return i & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t, long j) {
        return ((Boolean) UnsafeUtil.getObject(t, j)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t, long j) {
        return ((Double) UnsafeUtil.getObject(t, j)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t, long j) {
        return ((Float) UnsafeUtil.getObject(t, j)).floatValue();
    }

    private static <T> int oneofIntAt(T t, long j) {
        return ((Integer) UnsafeUtil.getObject(t, j)).intValue();
    }

    private static <T> long oneofLongAt(T t, long j) {
        return ((Long) UnsafeUtil.getObject(t, j)).longValue();
    }

    private <K, V> int parseMapField(T t, byte[] bArr, int i, int i2, int i3, long j, ArrayDecoders.Registers registers) {
        Unsafe unsafe = f3723UNSAFE;
        Object mapFieldDefaultEntry = getMapFieldDefaultEntry(i3);
        Object object = unsafe.getObject(t, j);
        if (this.mapFieldSchema.isImmutable(object)) {
            Object objNewMapField = this.mapFieldSchema.newMapField(mapFieldDefaultEntry);
            this.mapFieldSchema.mergeFrom(objNewMapField, object);
            unsafe.putObject(t, j, objNewMapField);
            object = objNewMapField;
        }
        return decodeMapEntry(bArr, i, i2, this.mapFieldSchema.forMapMetadata(mapFieldDefaultEntry), this.mapFieldSchema.forMutableMapData(object), registers);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int parseOneofField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iMergeMessageField;
        Unsafe unsafe = f3723UNSAFE;
        long j2 = this.f3724buffer[i8 + 2] & 1048575;
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(ArrayDecoders.decodeDouble(bArr, i)));
                    int i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(ArrayDecoders.decodeFloat(bArr, i)));
                    int i10 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i10;
                }
                return i;
            case C5125EACTags.f18346SEX /* 53 */:
            case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                if (i5 == 0) {
                    int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                    unsafe.putObject(t, j, Long.valueOf(registers.f3533long1));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint64;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    int iDecodeVarint32 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    unsafe.putObject(t, j, Integer.valueOf(registers.f3532int1));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint32;
                }
                return i;
            case 56:
            case C5125EACTags.ELEMENT_LIST /* 65 */:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(ArrayDecoders.decodeFixed64(bArr, i)));
                    int i11 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i11;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(ArrayDecoders.decodeFixed32(bArr, i)));
                    int i12 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i12;
                }
                return i;
            case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                if (i5 == 0) {
                    int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                    unsafe.putObject(t, j, Boolean.valueOf(registers.f3533long1 != 0));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint642;
                }
                return i;
            case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                if (i5 == 2) {
                    int iDecodeVarint322 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    int i13 = registers.f3532int1;
                    if (i13 == 0) {
                        unsafe.putObject(t, j, BuildConfig.f24315FLAVOR);
                    } else {
                        if ((i6 & 536870912) != 0 && !C0801Utf8.isValidUtf8(bArr, iDecodeVarint322, iDecodeVarint322 + i13)) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        unsafe.putObject(t, j, new String(bArr, iDecodeVarint322, i13, Internal.f3692UTF_8));
                        iDecodeVarint322 += i13;
                    }
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint322;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    Object objMutableOneofMessageFieldForMerge = mutableOneofMessageFieldForMerge(t, i4, i8);
                    iMergeMessageField = ArrayDecoders.mergeMessageField(objMutableOneofMessageFieldForMerge, getMessageFieldSchema(i8), bArr, i, i2, registers);
                    storeOneofMessageField(t, i4, i8, objMutableOneofMessageFieldForMerge);
                    break;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    int iDecodeBytes = ArrayDecoders.decodeBytes(bArr, i, registers);
                    unsafe.putObject(t, j, registers.f3534object1);
                    unsafe.putInt(t, j2, i4);
                    return iDecodeBytes;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int iDecodeVarint323 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    int i14 = registers.f3532int1;
                    Internal.EnumVerifier enumFieldVerifier = getEnumFieldVerifier(i8);
                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i14)) {
                        unsafe.putObject(t, j, Integer.valueOf(i14));
                        unsafe.putInt(t, j2, i4);
                    } else {
                        getMutableUnknownFields(t).storeField(i3, Long.valueOf(i14));
                    }
                    return iDecodeVarint323;
                }
                return i;
            case C5125EACTags.f18344ADDRESS /* 66 */:
                if (i5 == 0) {
                    int iDecodeVarint324 = ArrayDecoders.decodeVarint32(bArr, i, registers);
                    unsafe.putObject(t, j, Integer.valueOf(CodedInputStream.decodeZigZag32(registers.f3532int1)));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint324;
                }
                return i;
            case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                if (i5 == 0) {
                    int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr, i, registers);
                    unsafe.putObject(t, j, Long.valueOf(CodedInputStream.decodeZigZag64(registers.f3533long1)));
                    unsafe.putInt(t, j2, i4);
                    return iDecodeVarint643;
                }
                return i;
            case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                if (i5 == 3) {
                    Object objMutableOneofMessageFieldForMerge2 = mutableOneofMessageFieldForMerge(t, i4, i8);
                    iMergeMessageField = ArrayDecoders.mergeGroupField(objMutableOneofMessageFieldForMerge2, getMessageFieldSchema(i8), bArr, i, i2, (i3 & (-8)) | 4, registers);
                    storeOneofMessageField(t, i4, i8, objMutableOneofMessageFieldForMerge2);
                    break;
                }
                return i;
            default:
                return i;
        }
        return iMergeMessageField;
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x02b2, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02e8, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0307, code lost:
    
        if (r0 != r15) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0298, code lost:
    
        if (r0 != r10) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x029a, code lost:
    
        r15 = r29;
        r14 = r30;
        r12 = r31;
        r13 = r33;
        r11 = r34;
        r1 = r18;
        r8 = r19;
        r7 = r22;
        r6 = r26;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:25:0x0089. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v12, types: [int] */
    @CanIgnoreReturnValue
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int parseProto3Message(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        byte b;
        int iDecodeVarint32;
        int i3;
        int i4;
        int i5;
        Unsafe unsafe;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int iDecodeBytes;
        MessageSchema<T> messageSchema = this;
        T t2 = t;
        byte[] bArr2 = bArr;
        int i13 = i2;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(t);
        Unsafe unsafe2 = f3723UNSAFE;
        int i14 = -1;
        int iDecodeUnknownField = i;
        int i15 = -1;
        int i16 = 0;
        int i17 = 0;
        int i18 = 1048575;
        while (iDecodeUnknownField < i13) {
            int i19 = iDecodeUnknownField + 1;
            byte b2 = bArr2[iDecodeUnknownField];
            if (b2 < 0) {
                iDecodeVarint32 = ArrayDecoders.decodeVarint32(b2, bArr2, i19, registers2);
                b = registers2.f3532int1;
            } else {
                b = b2;
                iDecodeVarint32 = i19;
            }
            int i20 = b >>> 3;
            int i21 = b & 7;
            int iPositionForFieldNumber = i20 > i15 ? messageSchema.positionForFieldNumber(i20, i16 / 3) : messageSchema.positionForFieldNumber(i20);
            if (iPositionForFieldNumber == i14) {
                i3 = iDecodeVarint32;
                i4 = i20;
                i5 = i14;
                unsafe = unsafe2;
                i6 = 0;
            } else {
                int i22 = messageSchema.f3724buffer[iPositionForFieldNumber + 1];
                int iM4092type = m4092type(i22);
                long jM4091offset = m4091offset(i22);
                if (iM4092type <= 17) {
                    int i23 = messageSchema.f3724buffer[iPositionForFieldNumber + 2];
                    int i24 = 1 << (i23 >>> 20);
                    int i25 = 1048575;
                    int i26 = i23 & 1048575;
                    if (i26 != i18) {
                        if (i18 != 1048575) {
                            unsafe2.putInt(t2, i18, i17);
                            i25 = 1048575;
                        }
                        if (i26 != i25) {
                            i17 = unsafe2.getInt(t2, i26);
                        }
                        i18 = i26;
                    }
                    switch (iM4092type) {
                        case 0:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            i11 = iDecodeVarint32;
                            i12 = i17;
                            if (i21 != 1) {
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                UnsafeUtil.putDouble(t2, jM4091offset, ArrayDecoders.decodeDouble(bArr2, i11));
                                iDecodeUnknownField = i11 + 8;
                                i17 = i12 | i24;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 1:
                            i4 = i20;
                            registers2 = registers;
                            i11 = iDecodeVarint32;
                            i12 = i17;
                            i10 = iPositionForFieldNumber;
                            if (i21 != 5) {
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                UnsafeUtil.putFloat(t2, jM4091offset, ArrayDecoders.decodeFloat(bArr2, i11));
                                iDecodeUnknownField = i11 + 4;
                                i17 = i12 | i24;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 2:
                        case 3:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            i11 = iDecodeVarint32;
                            i12 = i17;
                            if (i21 != 0) {
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                int iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i11, registers2);
                                unsafe2.putLong(t, jM4091offset, registers2.f3533long1);
                                i17 = i12 | i24;
                                i16 = i10;
                                iDecodeUnknownField = iDecodeVarint64;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 4:
                        case 11:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            i11 = iDecodeVarint32;
                            i12 = i17;
                            if (i21 != 0) {
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i11, registers2);
                                unsafe2.putInt(t2, jM4091offset, registers2.f3532int1);
                                i17 = i12 | i24;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 5:
                        case 14:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            i12 = i17;
                            if (i21 != 1) {
                                i11 = iDecodeVarint32;
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                i11 = iDecodeVarint32;
                                unsafe2.putLong(t, jM4091offset, ArrayDecoders.decodeFixed64(bArr2, iDecodeVarint32));
                                iDecodeUnknownField = i11 + 8;
                                i17 = i12 | i24;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 6:
                        case 13:
                            i4 = i20;
                            registers2 = registers;
                            i12 = i17;
                            i10 = iPositionForFieldNumber;
                            if (i21 != 5) {
                                i11 = iDecodeVarint32;
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                unsafe2.putInt(t2, jM4091offset, ArrayDecoders.decodeFixed32(bArr2, iDecodeVarint32));
                                iDecodeUnknownField = iDecodeVarint32 + 4;
                                i17 = i12 | i24;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 7:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            boolean z = true;
                            i12 = i17;
                            if (i21 != 0) {
                                i11 = iDecodeVarint32;
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                int iDecodeVarint642 = ArrayDecoders.decodeVarint64(bArr2, iDecodeVarint32, registers2);
                                if (registers2.f3533long1 == 0) {
                                    z = false;
                                }
                                UnsafeUtil.putBoolean(t2, jM4091offset, z);
                                i17 = i12 | i24;
                                iDecodeUnknownField = iDecodeVarint642;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 8:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            i12 = i17;
                            if (i21 != 2) {
                                i11 = iDecodeVarint32;
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                iDecodeUnknownField = (536870912 & i22) == 0 ? ArrayDecoders.decodeString(bArr2, iDecodeVarint32, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr2, iDecodeVarint32, registers2);
                                unsafe2.putObject(t2, jM4091offset, registers2.f3534object1);
                                i17 = i12 | i24;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 9:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            if (i21 != 2) {
                                i11 = iDecodeVarint32;
                                i12 = i17;
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                Object objMutableMessageFieldForMerge = messageSchema.mutableMessageFieldForMerge(t2, i10);
                                iDecodeUnknownField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema.getMessageFieldSchema(i10), bArr, iDecodeVarint32, i2, registers);
                                messageSchema.storeMessageField(t2, i10, objMutableMessageFieldForMerge);
                                i17 |= i24;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 10:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            if (i21 != 2) {
                                i11 = iDecodeVarint32;
                                i12 = i17;
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                iDecodeBytes = ArrayDecoders.decodeBytes(bArr2, iDecodeVarint32, registers2);
                                unsafe2.putObject(t2, jM4091offset, registers2.f3534object1);
                                i17 |= i24;
                                iDecodeUnknownField = iDecodeBytes;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 12:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            if (i21 != 0) {
                                i11 = iDecodeVarint32;
                                i12 = i17;
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                iDecodeBytes = ArrayDecoders.decodeVarint32(bArr2, iDecodeVarint32, registers2);
                                unsafe2.putInt(t2, jM4091offset, registers2.f3532int1);
                                i17 |= i24;
                                iDecodeUnknownField = iDecodeBytes;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 15:
                            i4 = i20;
                            registers2 = registers;
                            i10 = iPositionForFieldNumber;
                            if (i21 != 0) {
                                i11 = iDecodeVarint32;
                                i12 = i17;
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, iDecodeVarint32, registers2);
                                unsafe2.putInt(t2, jM4091offset, CodedInputStream.decodeZigZag32(registers2.f3532int1));
                                i17 |= i24;
                                i16 = i10;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        case 16:
                            if (i21 != 0) {
                                i4 = i20;
                                i10 = iPositionForFieldNumber;
                                i11 = iDecodeVarint32;
                                i12 = i17;
                                i17 = i12;
                                i6 = i10;
                                unsafe = unsafe2;
                                i3 = i11;
                                i5 = -1;
                                break;
                            } else {
                                registers2 = registers;
                                int iDecodeVarint643 = ArrayDecoders.decodeVarint64(bArr2, iDecodeVarint32, registers2);
                                i4 = i20;
                                unsafe2.putLong(t, jM4091offset, CodedInputStream.decodeZigZag64(registers2.f3533long1));
                                i17 |= i24;
                                i16 = iPositionForFieldNumber;
                                iDecodeUnknownField = iDecodeVarint643;
                                i15 = i4;
                                i14 = -1;
                                break;
                            }
                        default:
                            i4 = i20;
                            i10 = iPositionForFieldNumber;
                            i11 = iDecodeVarint32;
                            i12 = i17;
                            i17 = i12;
                            i6 = i10;
                            unsafe = unsafe2;
                            i3 = i11;
                            i5 = -1;
                            break;
                    }
                } else {
                    i4 = i20;
                    int i27 = i17;
                    registers2 = registers;
                    int i28 = iDecodeVarint32;
                    if (iM4092type != 27) {
                        if (iM4092type <= 49) {
                            i7 = i27;
                            i6 = iPositionForFieldNumber;
                            i5 = -1;
                            unsafe = unsafe2;
                            i8 = i18;
                            iDecodeUnknownField = parseRepeatedField(t, bArr, i28, i2, b, i4, i21, iPositionForFieldNumber, i22, iM4092type, jM4091offset, registers);
                        } else {
                            i7 = i27;
                            i8 = i18;
                            i6 = iPositionForFieldNumber;
                            unsafe = unsafe2;
                            i9 = i28;
                            i5 = -1;
                            if (iM4092type != 50) {
                                iDecodeUnknownField = parseOneofField(t, bArr, i9, i2, b, i4, i21, i22, iM4092type, jM4091offset, i6, registers);
                            } else if (i21 == 2) {
                                iDecodeUnknownField = parseMapField(t, bArr, i9, i2, i6, jM4091offset, registers);
                            }
                        }
                        i16 = i6;
                        unsafe2 = unsafe;
                    } else if (i21 == 2) {
                        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t2, jM4091offset);
                        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                            int size = protobufListMutableCopyWithCapacity2.size();
                            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                            unsafe2.putObject(t2, jM4091offset, protobufListMutableCopyWithCapacity2);
                        }
                        iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema.getMessageFieldSchema(iPositionForFieldNumber), b, bArr, i28, i2, protobufListMutableCopyWithCapacity2, registers);
                        i16 = iPositionForFieldNumber;
                        i17 = i27;
                        i15 = i4;
                        i14 = -1;
                    } else {
                        i8 = i18;
                        i6 = iPositionForFieldNumber;
                        unsafe = unsafe2;
                        i9 = i28;
                        i7 = i27;
                        i5 = -1;
                    }
                    i3 = i9;
                    i18 = i8;
                    i17 = i7;
                }
            }
            iDecodeUnknownField = ArrayDecoders.decodeUnknownField(b, bArr, i3, i2, getMutableUnknownFields(t), registers);
            messageSchema = this;
            t2 = t;
            bArr2 = bArr;
            i13 = i2;
            registers2 = registers;
            i15 = i4;
            i14 = i5;
            i16 = i6;
            unsafe2 = unsafe;
        }
        int i29 = i17;
        Unsafe unsafe3 = unsafe2;
        if (i18 != 1048575) {
            unsafe3.putInt(t, i18, i29);
        }
        if (iDecodeUnknownField == i2) {
            return iDecodeUnknownField;
        }
        throw InvalidProtocolBufferException.parseFailure();
    }

    private int parseRepeatedField(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, long j, int i7, long j2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        int iDecodeVarint32List;
        Unsafe unsafe = f3723UNSAFE;
        Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe.getObject(t, j2);
        if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
            int size = protobufListMutableCopyWithCapacity2.size();
            protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
            unsafe.putObject(t, j2, protobufListMutableCopyWithCapacity2);
        }
        switch (i7) {
            case 18:
            case 35:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedDoubleList(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeDoubleList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 19:
            case 36:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFloatList(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFloatList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 20:
            case 21:
            case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
            case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint64List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint64List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 22:
            case 29:
            case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
            case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedVarint32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed64List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 1) {
                    return ArrayDecoders.decodeFixed64List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 24:
            case InterfaceC5102BERTags.f17975DATE /* 31 */:
            case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
            case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedFixed32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 5) {
                    return ArrayDecoders.decodeFixed32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 25:
            case C5125EACTags.CURRENCY_CODE /* 42 */:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedBoolList(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeBoolList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 26:
                if (i5 == 2) {
                    return (j & 536870912) == 0 ? ArrayDecoders.decodeStringList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers) : ArrayDecoders.decodeStringListRequireUtf8(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 27:
                if (i5 == 2) {
                    return ArrayDecoders.decodeMessageList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 28:
                if (i5 == 2) {
                    return ArrayDecoders.decodeBytesList(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 30:
            case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                if (i5 == 2) {
                    iDecodeVarint32List = ArrayDecoders.decodePackedVarint32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                } else if (i5 == 0) {
                    iDecodeVarint32List = ArrayDecoders.decodeVarint32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                SchemaUtil.filterUnknownEnumList((Object) t, i4, (List<Integer>) protobufListMutableCopyWithCapacity2, getEnumFieldVerifier(i6), (Object) null, (UnknownFieldSchema<UT, Object>) this.unknownFieldSchema);
                return iDecodeVarint32List;
            case 33:
            case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt32List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt32List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 34:
            case 48:
                if (i5 == 2) {
                    return ArrayDecoders.decodePackedSInt64List(bArr, i, protobufListMutableCopyWithCapacity2, registers);
                }
                if (i5 == 0) {
                    return ArrayDecoders.decodeSInt64List(i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
            case 49:
                if (i5 == 3) {
                    return ArrayDecoders.decodeGroupList(getMessageFieldSchema(i6), i3, bArr, i, i2, protobufListMutableCopyWithCapacity2, registers);
                }
                break;
        }
        return i;
    }

    private int positionForFieldNumber(int i) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, 0);
    }

    private int presenceMaskAndOffsetAt(int i) {
        return this.f3724buffer[i + 2];
    }

    private <E> void readGroupList(Object obj, long j, InterfaceC0775Reader interfaceC0775Reader, InterfaceC0777Schema<E> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) {
        interfaceC0775Reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j), interfaceC0777Schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i, InterfaceC0775Reader interfaceC0775Reader, InterfaceC0777Schema<E> interfaceC0777Schema, ExtensionRegistryLite extensionRegistryLite) {
        interfaceC0775Reader.readMessageList(this.listFieldSchema.mutableListAt(obj, m4091offset(i)), interfaceC0777Schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i, InterfaceC0775Reader interfaceC0775Reader) {
        if (isEnforceUtf8(i)) {
            UnsafeUtil.putObject(obj, m4091offset(i), interfaceC0775Reader.readStringRequireUtf8());
        } else if (this.f3725lite) {
            UnsafeUtil.putObject(obj, m4091offset(i), interfaceC0775Reader.readString());
        } else {
            UnsafeUtil.putObject(obj, m4091offset(i), interfaceC0775Reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i, InterfaceC0775Reader interfaceC0775Reader) {
        if (isEnforceUtf8(i)) {
            interfaceC0775Reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, m4091offset(i)));
        } else {
            interfaceC0775Reader.readStringList(this.listFieldSchema.mutableListAt(obj, m4091offset(i)));
        }
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void setFieldPresent(T t, int i) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j == 1048575) {
            return;
        }
        UnsafeUtil.m4163putInt(t, j, (1 << (iPresenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.m4154getInt(t, j));
    }

    private void setOneofPresent(T t, int i, int i2) {
        UnsafeUtil.m4163putInt(t, presenceMaskAndOffsetAt(i2) & 1048575, i);
    }

    private int slowPositionForFieldNumber(int i, int i2) {
        int length = (this.f3724buffer.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int iNumberAt = numberAt(i4);
            if (i == iNumberAt) {
                return i4;
            }
            if (i < iNumberAt) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void storeFieldData(FieldInfo fieldInfo, int[] iArr, int i, Object[] objArr) {
        int iObjectFieldOffset;
        int iM4014id;
        long jObjectFieldOffset;
        int iObjectFieldOffset2;
        int iNumberOfTrailingZeros;
        OneofInfo oneof = fieldInfo.getOneof();
        if (oneof == null) {
            FieldType fieldTypeM4001getType = fieldInfo.m4001getType();
            iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(fieldInfo.getField());
            iM4014id = fieldTypeM4001getType.m4014id();
            if (!fieldTypeM4001getType.m4015isList() && !fieldTypeM4001getType.m4016isMap()) {
                Field presenceField = fieldInfo.getPresenceField();
                iObjectFieldOffset2 = presenceField == null ? 1048575 : (int) UnsafeUtil.objectFieldOffset(presenceField);
                iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(fieldInfo.getPresenceMask());
            } else if (fieldInfo.getCachedSizeField() == null) {
                iObjectFieldOffset2 = 0;
                iNumberOfTrailingZeros = 0;
            } else {
                jObjectFieldOffset = UnsafeUtil.objectFieldOffset(fieldInfo.getCachedSizeField());
            }
            iArr[i] = fieldInfo.getFieldNumber();
            iArr[i + 1] = (fieldInfo.isRequired() ? REQUIRED_MASK : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | (iM4014id << 20) | iObjectFieldOffset;
            iArr[i + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
            Class<?> messageFieldClass = fieldInfo.getMessageFieldClass();
            if (fieldInfo.getMapDefaultEntry() != null) {
                if (messageFieldClass != null) {
                    objArr[((i / 3) * 2) + 1] = messageFieldClass;
                    return;
                } else {
                    if (fieldInfo.getEnumVerifier() != null) {
                        objArr[((i / 3) * 2) + 1] = fieldInfo.getEnumVerifier();
                        return;
                    }
                    return;
                }
            }
            int i2 = (i / 3) * 2;
            objArr[i2] = fieldInfo.getMapDefaultEntry();
            if (messageFieldClass != null) {
                objArr[i2 + 1] = messageFieldClass;
                return;
            } else {
                if (fieldInfo.getEnumVerifier() != null) {
                    objArr[i2 + 1] = fieldInfo.getEnumVerifier();
                    return;
                }
                return;
            }
        }
        iM4014id = fieldInfo.m4001getType().m4014id() + 51;
        iObjectFieldOffset = (int) UnsafeUtil.objectFieldOffset(oneof.getValueField());
        jObjectFieldOffset = UnsafeUtil.objectFieldOffset(oneof.getCaseField());
        iObjectFieldOffset2 = (int) jObjectFieldOffset;
        iNumberOfTrailingZeros = 0;
        iArr[i] = fieldInfo.getFieldNumber();
        if (!fieldInfo.isEnforceUtf8()) {
        }
        iArr[i + 1] = (fieldInfo.isRequired() ? REQUIRED_MASK : 0) | (!fieldInfo.isEnforceUtf8() ? 536870912 : 0) | (iM4014id << 20) | iObjectFieldOffset;
        iArr[i + 2] = iObjectFieldOffset2 | (iNumberOfTrailingZeros << 20);
        Class<?> messageFieldClass2 = fieldInfo.getMessageFieldClass();
        if (fieldInfo.getMapDefaultEntry() != null) {
        }
    }

    private void storeMessageField(T t, int i, Object obj) {
        f3723UNSAFE.putObject(t, m4091offset(typeAndOffsetAt(i)), obj);
        setFieldPresent(t, i);
    }

    private void storeOneofMessageField(T t, int i, int i2, Object obj) {
        f3723UNSAFE.putObject(t, m4091offset(typeAndOffsetAt(i2)), obj);
        setOneofPresent(t, i, i2);
    }

    /* renamed from: type */
    private static int m4092type(int i) {
        return (i & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i) {
        return this.f3724buffer[i + 1];
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto2(T t, InterfaceC0811Writer interfaceC0811Writer) {
        Iterator it;
        Map.Entry<?, ?> entry;
        int i;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.m4008isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.f3724buffer.length;
        Unsafe unsafe = f3723UNSAFE;
        int i2 = 1048575;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i4);
            int iNumberAt = numberAt(i4);
            int iM4092type = m4092type(iTypeAndOffsetAt);
            if (iM4092type <= 17) {
                int i6 = this.f3724buffer[i4 + 2];
                int i7 = i6 & i2;
                if (i7 != i3) {
                    i5 = unsafe.getInt(t, i7);
                    i3 = i7;
                }
                i = 1 << (i6 >>> 20);
            } else {
                i = 0;
            }
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(interfaceC0811Writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            long jM4091offset = m4091offset(iTypeAndOffsetAt);
            switch (iM4092type) {
                case 0:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeDouble(iNumberAt, doubleAt(t, jM4091offset));
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 1:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeFloat(iNumberAt, m4087floatAt(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 2:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeInt64(iNumberAt, unsafe.getLong(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 3:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeUInt64(iNumberAt, unsafe.getLong(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 4:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeInt32(iNumberAt, unsafe.getInt(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 5:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeFixed64(iNumberAt, unsafe.getLong(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 6:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeFixed32(iNumberAt, unsafe.getInt(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 7:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeBool(iNumberAt, booleanAt(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 8:
                    if ((i & i5) != 0) {
                        writeString(iNumberAt, unsafe.getObject(t, jM4091offset), interfaceC0811Writer);
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 9:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeMessage(iNumberAt, unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 10:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 11:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeUInt32(iNumberAt, unsafe.getInt(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 12:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeEnum(iNumberAt, unsafe.getInt(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 13:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeSFixed32(iNumberAt, unsafe.getInt(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 14:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeSFixed64(iNumberAt, unsafe.getLong(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 15:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeSInt32(iNumberAt, unsafe.getInt(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 16:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeSInt64(iNumberAt, unsafe.getLong(t, jM4091offset));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 17:
                    if ((i & i5) != 0) {
                        interfaceC0811Writer.writeGroup(iNumberAt, unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i4));
                    } else {
                        continue;
                    }
                    i4 += 3;
                    i2 = 1048575;
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, getMessageFieldSchema(i4));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                    SchemaUtil.writeSFixed32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, false);
                    continue;
                    i4 += 3;
                    i2 = 1048575;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                    SchemaUtil.writeInt64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                    SchemaUtil.writeUInt64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                    SchemaUtil.writeInt32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                    SchemaUtil.writeFixed32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                    SchemaUtil.writeBoolList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                    SchemaUtil.writeUInt32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                    SchemaUtil.writeEnumList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                    SchemaUtil.writeSFixed32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                    SchemaUtil.writeSInt32List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i4), (List) unsafe.getObject(t, jM4091offset), interfaceC0811Writer, getMessageFieldSchema(i4));
                    break;
                case 50:
                    writeMapHelper(interfaceC0811Writer, iNumberAt, unsafe.getObject(t, jM4091offset), i4);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeDouble(iNumberAt, oneofDoubleAt(t, jM4091offset));
                        break;
                    }
                    break;
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeFloat(iNumberAt, oneofFloatAt(t, jM4091offset));
                        break;
                    }
                    break;
                case C5125EACTags.f18346SEX /* 53 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeInt64(iNumberAt, oneofLongAt(t, jM4091offset));
                        break;
                    }
                    break;
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeUInt64(iNumberAt, oneofLongAt(t, jM4091offset));
                        break;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeInt32(iNumberAt, oneofIntAt(t, jM4091offset));
                        break;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeFixed64(iNumberAt, oneofLongAt(t, jM4091offset));
                        break;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeFixed32(iNumberAt, oneofIntAt(t, jM4091offset));
                        break;
                    }
                    break;
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeBool(iNumberAt, oneofBooleanAt(t, jM4091offset));
                        break;
                    }
                    break;
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        writeString(iNumberAt, unsafe.getObject(t, jM4091offset), interfaceC0811Writer);
                        break;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeMessage(iNumberAt, unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i4));
                        break;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeBytes(iNumberAt, (ByteString) unsafe.getObject(t, jM4091offset));
                        break;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeUInt32(iNumberAt, oneofIntAt(t, jM4091offset));
                        break;
                    }
                    break;
                case 63:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeEnum(iNumberAt, oneofIntAt(t, jM4091offset));
                        break;
                    }
                    break;
                case 64:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeSFixed32(iNumberAt, oneofIntAt(t, jM4091offset));
                        break;
                    }
                    break;
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeSFixed64(iNumberAt, oneofLongAt(t, jM4091offset));
                        break;
                    }
                    break;
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeSInt32(iNumberAt, oneofIntAt(t, jM4091offset));
                        break;
                    }
                    break;
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeSInt64(iNumberAt, oneofLongAt(t, jM4091offset));
                        break;
                    }
                    break;
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    if (isOneofPresent(t, iNumberAt, i4)) {
                        interfaceC0811Writer.writeGroup(iNumberAt, unsafe.getObject(t, jM4091offset), getMessageFieldSchema(i4));
                        break;
                    }
                    break;
            }
            i4 += 3;
            i2 = 1048575;
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(interfaceC0811Writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, interfaceC0811Writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrderProto3(T t, InterfaceC0811Writer interfaceC0811Writer) {
        Iterator it;
        Map.Entry<?, ?> entry;
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.m4008isEmpty()) {
                it = null;
                entry = null;
            } else {
                it = extensions.iterator();
                entry = (Map.Entry) it.next();
            }
        }
        int length = this.f3724buffer.length;
        for (int i = 0; i < length; i += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i);
            int iNumberAt = numberAt(i);
            while (entry != null && this.extensionSchema.extensionNumber(entry) <= iNumberAt) {
                this.extensionSchema.serializeExtension(interfaceC0811Writer, entry);
                entry = it.hasNext() ? (Map.Entry) it.next() : null;
            }
            switch (m4092type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeDouble(iNumberAt, doubleAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeFloat(iNumberAt, m4087floatAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeInt64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeUInt64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeInt32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeFixed64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeFixed32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeBool(iNumberAt, booleanAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeUInt32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeEnum(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeSFixed32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeSFixed64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeSInt32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeSInt64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t, i)) {
                        interfaceC0811Writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, getMessageFieldSchema(i));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                    SchemaUtil.writeInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                    SchemaUtil.writeUInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                    SchemaUtil.writeInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                    SchemaUtil.writeFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                    SchemaUtil.writeBoolList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                    SchemaUtil.writeUInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                    SchemaUtil.writeEnumList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                    SchemaUtil.writeSFixed32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                    SchemaUtil.writeSInt32List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(i), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, getMessageFieldSchema(i));
                    break;
                case 50:
                    writeMapHelper(interfaceC0811Writer, iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), i);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeDouble(iNumberAt, oneofDoubleAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeFloat(iNumberAt, oneofFloatAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18346SEX /* 53 */:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeInt64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeUInt64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeInt32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeFixed64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeFixed32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeBool(iNumberAt, oneofBooleanAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeUInt32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeEnum(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeSFixed32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeSFixed64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeSInt32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeSInt64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    if (isOneofPresent(t, iNumberAt, i)) {
                        interfaceC0811Writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), getMessageFieldSchema(i));
                        break;
                    } else {
                        break;
                    }
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(interfaceC0811Writer, entry);
            entry = it.hasNext() ? (Map.Entry) it.next() : null;
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t, interfaceC0811Writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInDescendingOrder(T t, InterfaceC0811Writer interfaceC0811Writer) {
        Iterator itDescendingIterator;
        Map.Entry<?, ?> entry;
        writeUnknownInMessageTo(this.unknownFieldSchema, t, interfaceC0811Writer);
        if (this.hasExtensions) {
            FieldSet<T> extensions = this.extensionSchema.getExtensions(t);
            if (extensions.m4008isEmpty()) {
                itDescendingIterator = null;
                entry = null;
            } else {
                itDescendingIterator = extensions.descendingIterator();
                entry = (Map.Entry) itDescendingIterator.next();
            }
        }
        for (int length = this.f3724buffer.length - 3; length >= 0; length -= 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(length);
            int iNumberAt = numberAt(length);
            while (entry != null && this.extensionSchema.extensionNumber(entry) > iNumberAt) {
                this.extensionSchema.serializeExtension(interfaceC0811Writer, entry);
                entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
            }
            switch (m4092type(iTypeAndOffsetAt)) {
                case 0:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeDouble(iNumberAt, doubleAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeFloat(iNumberAt, m4087floatAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeInt64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeUInt64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeInt32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeFixed64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeFixed32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeBool(iNumberAt, booleanAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (isFieldPresent(t, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeUInt32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeEnum(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeSFixed32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeSFixed64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeSInt32(iNumberAt, m4088intAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeSInt64(iNumberAt, m4090longAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (isFieldPresent(t, length)) {
                        interfaceC0811Writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 19:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 20:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 21:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 22:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 23:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 24:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 25:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 26:
                    SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer);
                    break;
                case 27:
                    SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, getMessageFieldSchema(length));
                    break;
                case 28:
                    SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer);
                    break;
                case 29:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 30:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 32:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 33:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 34:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, false);
                    break;
                case 35:
                    SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 36:
                    SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                    SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                    SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                    SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 40:
                    SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                    SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                    SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                    SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                    SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                    SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 46:
                    SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                    SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 48:
                    SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, true);
                    break;
                case 49:
                    SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer, getMessageFieldSchema(length));
                    break;
                case 50:
                    writeMapHelper(interfaceC0811Writer, iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), length);
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeDouble(iNumberAt, oneofDoubleAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeFloat(iNumberAt, oneofFloatAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18346SEX /* 53 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeInt64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeUInt64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeInt32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeFixed64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeFixed32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeBool(iNumberAt, oneofBooleanAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        writeString(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), interfaceC0811Writer);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeMessage(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeBytes(iNumberAt, (ByteString) UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeUInt32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeEnum(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeSFixed32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeSFixed64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeSInt32(iNumberAt, oneofIntAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeSInt64(iNumberAt, oneofLongAt(t, m4091offset(iTypeAndOffsetAt)));
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    if (isOneofPresent(t, iNumberAt, length)) {
                        interfaceC0811Writer.writeGroup(iNumberAt, UnsafeUtil.getObject(t, m4091offset(iTypeAndOffsetAt)), getMessageFieldSchema(length));
                        break;
                    } else {
                        break;
                    }
            }
        }
        while (entry != null) {
            this.extensionSchema.serializeExtension(interfaceC0811Writer, entry);
            entry = itDescendingIterator.hasNext() ? (Map.Entry) itDescendingIterator.next() : null;
        }
    }

    private <K, V> void writeMapHelper(InterfaceC0811Writer interfaceC0811Writer, int i, Object obj, int i2) {
        if (obj != null) {
            interfaceC0811Writer.writeMap(i, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i2)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i, Object obj, InterfaceC0811Writer interfaceC0811Writer) {
        if (obj instanceof String) {
            interfaceC0811Writer.writeString(i, (String) obj);
        } else {
            interfaceC0811Writer.writeBytes(i, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, InterfaceC0811Writer interfaceC0811Writer) {
        unknownFieldSchema.mo4145writeTo(unknownFieldSchema.getFromMessage(t), interfaceC0811Writer);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    /* renamed from: equals */
    public boolean mo4093equals(T t, T t2) {
        int length = this.f3724buffer.length;
        for (int i = 0; i < length; i += 3) {
            if (!m4086equals(t, t2, i)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t).equals(this.unknownFieldSchema.getFromMessage(t2))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t).m4007equals(this.extensionSchema.getExtensions(t2));
        }
        return true;
    }

    public int getSchemaSize() {
        return this.f3724buffer.length * 3;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    public int getSerializedSize(T t) {
        return this.f3727proto3 ? getSerializedSizeProto3(t) : getSerializedSizeProto2(t);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    public int hashCode(T t) {
        int i;
        int iHashLong;
        int length = this.f3724buffer.length;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int iTypeAndOffsetAt = typeAndOffsetAt(i3);
            int iNumberAt = numberAt(i3);
            long jM4091offset = m4091offset(iTypeAndOffsetAt);
            int iHashCode = 37;
            switch (m4092type(iTypeAndOffsetAt)) {
                case 0:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t, jM4091offset)));
                    i2 = i + iHashLong;
                    break;
                case 1:
                    i = i2 * 53;
                    iHashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t, jM4091offset));
                    i2 = i + iHashLong;
                    break;
                case 2:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.m4157getLong(t, jM4091offset));
                    i2 = i + iHashLong;
                    break;
                case 3:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.m4157getLong(t, jM4091offset));
                    i2 = i + iHashLong;
                    break;
                case 4:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.m4154getInt(t, jM4091offset);
                    i2 = i + iHashLong;
                    break;
                case 5:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.m4157getLong(t, jM4091offset));
                    i2 = i + iHashLong;
                    break;
                case 6:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.m4154getInt(t, jM4091offset);
                    i2 = i + iHashLong;
                    break;
                case 7:
                    i = i2 * 53;
                    iHashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t, jM4091offset));
                    i2 = i + iHashLong;
                    break;
                case 8:
                    i = i2 * 53;
                    iHashLong = ((String) UnsafeUtil.getObject(t, jM4091offset)).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t, jM4091offset);
                    if (object != null) {
                        iHashCode = object.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 10:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jM4091offset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 11:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.m4154getInt(t, jM4091offset);
                    i2 = i + iHashLong;
                    break;
                case 12:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.m4154getInt(t, jM4091offset);
                    i2 = i + iHashLong;
                    break;
                case 13:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.m4154getInt(t, jM4091offset);
                    i2 = i + iHashLong;
                    break;
                case 14:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.m4157getLong(t, jM4091offset));
                    i2 = i + iHashLong;
                    break;
                case 15:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.m4154getInt(t, jM4091offset);
                    i2 = i + iHashLong;
                    break;
                case 16:
                    i = i2 * 53;
                    iHashLong = Internal.hashLong(UnsafeUtil.m4157getLong(t, jM4091offset));
                    i2 = i + iHashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t, jM4091offset);
                    if (object2 != null) {
                        iHashCode = object2.hashCode();
                    }
                    i2 = (i2 * 53) + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                case 40:
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                case 46:
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                case 48:
                case 49:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jM4091offset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 50:
                    i = i2 * 53;
                    iHashLong = UnsafeUtil.getObject(t, jM4091offset).hashCode();
                    i2 = i + iHashLong;
                    break;
                case 51:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t, jM4091offset)));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Float.floatToIntBits(oneofFloatAt(t, jM4091offset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18346SEX /* 53 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jM4091offset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jM4091offset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jM4091offset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jM4091offset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jM4091offset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashBoolean(oneofBooleanAt(t, jM4091offset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = ((String) UnsafeUtil.getObject(t, jM4091offset)).hashCode();
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jM4091offset).hashCode();
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jM4091offset).hashCode();
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jM4091offset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jM4091offset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jM4091offset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jM4091offset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = oneofIntAt(t, jM4091offset);
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = Internal.hashLong(oneofLongAt(t, jM4091offset));
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    if (isOneofPresent(t, iNumberAt, i3)) {
                        i = i2 * 53;
                        iHashLong = UnsafeUtil.getObject(t, jM4091offset).hashCode();
                        i2 = i + iHashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i2 * 53) + this.unknownFieldSchema.getFromMessage(t).hashCode();
        return this.hasExtensions ? (iHashCode2 * 53) + this.extensionSchema.getExtensions(t).hashCode() : iHashCode2;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0089  */
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isInitialized(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.checkInitializedCount) {
            int i6 = this.intArray[i5];
            int iNumberAt = numberAt(i6);
            int iTypeAndOffsetAt = typeAndOffsetAt(i6);
            int i7 = this.f3724buffer[i6 + 2];
            int i8 = i7 & 1048575;
            int i9 = 1 << (i7 >>> 20);
            if (i8 != i3) {
                if (i8 != 1048575) {
                    i4 = f3723UNSAFE.getInt(t, i8);
                }
                i2 = i4;
                i = i8;
            } else {
                i = i3;
                i2 = i4;
            }
            if (isRequired(iTypeAndOffsetAt) && !isFieldPresent(t, i6, i, i2, i9)) {
                return false;
            }
            int iM4092type = m4092type(iTypeAndOffsetAt);
            if (iM4092type == 9 || iM4092type == 17) {
                if (isFieldPresent(t, i6, i, i2, i9) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iM4092type == 27) {
                if (!isListInitialized(t, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            } else if (iM4092type == 60 || iM4092type == 68) {
                if (isOneofPresent(t, iNumberAt, i6) && !isInitialized(t, iTypeAndOffsetAt, getMessageFieldSchema(i6))) {
                    return false;
                }
            } else if (iM4092type != 49) {
                if (iM4092type == 50 && !isMapInitialized(t, iTypeAndOffsetAt, i6)) {
                    return false;
                }
            }
            i5++;
            i3 = i;
            i4 = i2;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void makeImmutable(T t) {
        if (isMutable(t)) {
            if (t instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.f3724buffer.length;
            for (int i = 0; i < length; i += 3) {
                int iTypeAndOffsetAt = typeAndOffsetAt(i);
                long jM4091offset = m4091offset(iTypeAndOffsetAt);
                int iM4092type = m4092type(iTypeAndOffsetAt);
                if (iM4092type != 9) {
                    switch (iM4092type) {
                        case 17:
                            if (isFieldPresent(t, i)) {
                                getMessageFieldSchema(i).makeImmutable(f3723UNSAFE.getObject(t, jM4091offset));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case InterfaceC5102BERTags.f17975DATE /* 31 */:
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                        case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                        case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                        case 40:
                        case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                        case C5125EACTags.CURRENCY_CODE /* 42 */:
                        case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                        case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                        case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                        case 46:
                        case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                        case 48:
                        case 49:
                            this.listFieldSchema.makeImmutableListAt(t, jM4091offset);
                            break;
                        case 50:
                            Unsafe unsafe = f3723UNSAFE;
                            Object object = unsafe.getObject(t, jM4091offset);
                            if (object != null) {
                                unsafe.putObject(t, jM4091offset, this.mapFieldSchema.toImmutable(object));
                                break;
                            } else {
                                break;
                            }
                    }
                }
            }
            this.unknownFieldSchema.makeImmutable(t);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t);
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    public void mergeFrom(T t, T t2) {
        checkMutable(t);
        t2.getClass();
        for (int i = 0; i < this.f3724buffer.length; i += 3) {
            mergeSingleField(t, t2, i);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t, t2);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t, t2);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:24:0x0090. Please report as an issue. */
    @CanIgnoreReturnValue
    public int parseProto2Message(T t, byte[] bArr, int i, int i2, int i3, ArrayDecoders.Registers registers) {
        Unsafe unsafe;
        int i4;
        MessageSchema<T> messageSchema;
        int i5;
        int i6;
        int i7;
        int i8;
        T t2;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        byte[] bArr2;
        int iDecodeVarint64;
        int i20;
        int i21;
        MessageSchema<T> messageSchema2 = this;
        T t3 = t;
        byte[] bArr3 = bArr;
        int i22 = i2;
        int i23 = i3;
        ArrayDecoders.Registers registers2 = registers;
        checkMutable(t);
        Unsafe unsafe2 = f3723UNSAFE;
        int iDecodeUnknownField = i;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = -1;
        int i28 = 1048575;
        while (true) {
            if (iDecodeUnknownField < i22) {
                int i29 = iDecodeUnknownField + 1;
                byte b = bArr3[iDecodeUnknownField];
                if (b < 0) {
                    int iDecodeVarint32 = ArrayDecoders.decodeVarint32(b, bArr3, i29, registers2);
                    i9 = registers2.f3532int1;
                    i29 = iDecodeVarint32;
                } else {
                    i9 = b;
                }
                int i30 = i9 >>> 3;
                int i31 = i9 & 7;
                int iPositionForFieldNumber = i30 > i27 ? messageSchema2.positionForFieldNumber(i30, i24 / 3) : messageSchema2.positionForFieldNumber(i30);
                if (iPositionForFieldNumber == -1) {
                    i10 = i30;
                    i11 = i29;
                    i6 = i9;
                    i12 = i26;
                    i13 = i28;
                    unsafe = unsafe2;
                    i4 = i23;
                    i14 = 0;
                } else {
                    int i32 = messageSchema2.f3724buffer[iPositionForFieldNumber + 1];
                    int iM4092type = m4092type(i32);
                    long jM4091offset = m4091offset(i32);
                    int i33 = i9;
                    if (iM4092type <= 17) {
                        int i34 = messageSchema2.f3724buffer[iPositionForFieldNumber + 2];
                        int i35 = 1 << (i34 >>> 20);
                        int i36 = i34 & 1048575;
                        if (i36 != i28) {
                            if (i28 != 1048575) {
                                unsafe2.putInt(t3, i28, i26);
                            }
                            i16 = i36;
                            i15 = unsafe2.getInt(t3, i36);
                        } else {
                            i15 = i26;
                            i16 = i28;
                        }
                        switch (iM4092type) {
                            case 0:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 1) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    UnsafeUtil.putDouble(t3, jM4091offset, ArrayDecoders.decodeDouble(bArr2, i29));
                                    iDecodeUnknownField = i29 + 8;
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 1:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 5) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    UnsafeUtil.putFloat(t3, jM4091offset, ArrayDecoders.decodeFloat(bArr2, i29));
                                    iDecodeUnknownField = i29 + 4;
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 2:
                            case 3:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i29, registers2);
                                    unsafe2.putLong(t, jM4091offset, registers2.f3533long1);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i29, registers2);
                                    unsafe2.putInt(t3, jM4091offset, registers2.f3532int1);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 1) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    unsafe2.putLong(t, jM4091offset, ArrayDecoders.decodeFixed64(bArr2, i29));
                                    iDecodeUnknownField = i29 + 8;
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 5) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    unsafe2.putInt(t3, jM4091offset, ArrayDecoders.decodeFixed32(bArr2, i29));
                                    iDecodeUnknownField = i29 + 4;
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 7:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint64(bArr2, i29, registers2);
                                    UnsafeUtil.putBoolean(t3, jM4091offset, registers2.f3533long1 != 0);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 8:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 2) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iDecodeUnknownField = (536870912 & i32) == 0 ? ArrayDecoders.decodeString(bArr2, i29, registers2) : ArrayDecoders.decodeStringRequireUtf8(bArr2, i29, registers2);
                                    unsafe2.putObject(t3, jM4091offset, registers2.f3534object1);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 9:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 2) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    Object objMutableMessageFieldForMerge = messageSchema2.mutableMessageFieldForMerge(t3, i19);
                                    iDecodeUnknownField = ArrayDecoders.mergeMessageField(objMutableMessageFieldForMerge, messageSchema2.getMessageFieldSchema(i19), bArr, i29, i2, registers);
                                    messageSchema2.storeMessageField(t3, i19, objMutableMessageFieldForMerge);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 10:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 2) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iDecodeUnknownField = ArrayDecoders.decodeBytes(bArr2, i29, registers2);
                                    unsafe2.putObject(t3, jM4091offset, registers2.f3534object1);
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 12:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i29, registers2);
                                    int i37 = registers2.f3532int1;
                                    Internal.EnumVerifier enumFieldVerifier = messageSchema2.getEnumFieldVerifier(i19);
                                    if (enumFieldVerifier == null || enumFieldVerifier.isInRange(i37)) {
                                        unsafe2.putInt(t3, jM4091offset, i37);
                                        i26 = i15 | i35;
                                        i23 = i3;
                                        i24 = i19;
                                        i25 = i18;
                                        i27 = i10;
                                        i28 = i17;
                                        bArr3 = bArr2;
                                    } else {
                                        getMutableUnknownFields(t).storeField(i18, Long.valueOf(i37));
                                        i24 = i19;
                                        i26 = i15;
                                        i25 = i18;
                                        i27 = i10;
                                        i28 = i17;
                                        i23 = i3;
                                        bArr3 = bArr2;
                                    }
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iDecodeUnknownField = ArrayDecoders.decodeVarint32(bArr2, i29, registers2);
                                    unsafe2.putInt(t3, jM4091offset, CodedInputStream.decodeZigZag32(registers2.f3532int1));
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 16:
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                bArr2 = bArr;
                                if (i31 != 0) {
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    iDecodeVarint64 = ArrayDecoders.decodeVarint64(bArr2, i29, registers2);
                                    unsafe2.putLong(t, jM4091offset, CodedInputStream.decodeZigZag64(registers2.f3533long1));
                                    i26 = i15 | i35;
                                    i23 = i3;
                                    i24 = i19;
                                    iDecodeUnknownField = iDecodeVarint64;
                                    i25 = i18;
                                    i27 = i10;
                                    i28 = i17;
                                    bArr3 = bArr2;
                                }
                            case 17:
                                if (i31 != 3) {
                                    i10 = i30;
                                    i17 = i16;
                                    i18 = i33;
                                    i19 = iPositionForFieldNumber;
                                    i13 = i17;
                                    i4 = i3;
                                    i11 = i29;
                                    i14 = i19;
                                    unsafe = unsafe2;
                                    i12 = i15;
                                    i6 = i18;
                                    break;
                                } else {
                                    Object objMutableMessageFieldForMerge2 = messageSchema2.mutableMessageFieldForMerge(t3, iPositionForFieldNumber);
                                    iDecodeUnknownField = ArrayDecoders.mergeGroupField(objMutableMessageFieldForMerge2, messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), bArr, i29, i2, (i30 << 3) | 4, registers);
                                    messageSchema2.storeMessageField(t3, iPositionForFieldNumber, objMutableMessageFieldForMerge2);
                                    i26 = i15 | i35;
                                    i28 = i16;
                                    i23 = i3;
                                    i24 = iPositionForFieldNumber;
                                    i25 = i33;
                                    i27 = i30;
                                    bArr3 = bArr;
                                }
                            default:
                                i10 = i30;
                                i19 = iPositionForFieldNumber;
                                i17 = i16;
                                i18 = i33;
                                i13 = i17;
                                i4 = i3;
                                i11 = i29;
                                i14 = i19;
                                unsafe = unsafe2;
                                i12 = i15;
                                i6 = i18;
                                break;
                        }
                    } else {
                        i10 = i30;
                        i13 = i28;
                        i12 = i26;
                        if (iM4092type == 27) {
                            if (i31 == 2) {
                                Internal.ProtobufList protobufListMutableCopyWithCapacity2 = (Internal.ProtobufList) unsafe2.getObject(t3, jM4091offset);
                                if (!protobufListMutableCopyWithCapacity2.isModifiable()) {
                                    int size = protobufListMutableCopyWithCapacity2.size();
                                    protobufListMutableCopyWithCapacity2 = protobufListMutableCopyWithCapacity2.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
                                    unsafe2.putObject(t3, jM4091offset, protobufListMutableCopyWithCapacity2);
                                }
                                iDecodeUnknownField = ArrayDecoders.decodeMessageList(messageSchema2.getMessageFieldSchema(iPositionForFieldNumber), i33, bArr, i29, i2, protobufListMutableCopyWithCapacity2, registers);
                                i24 = iPositionForFieldNumber;
                                i25 = i33;
                                i28 = i13;
                                i26 = i12;
                                i27 = i10;
                                bArr3 = bArr;
                                i23 = i3;
                            } else {
                                i20 = i29;
                                unsafe = unsafe2;
                                i14 = iPositionForFieldNumber;
                                i21 = i33;
                                i4 = i3;
                                i11 = i20;
                            }
                        } else if (iM4092type <= 49) {
                            int i38 = i29;
                            unsafe = unsafe2;
                            i14 = iPositionForFieldNumber;
                            i21 = i33;
                            iDecodeUnknownField = parseRepeatedField(t, bArr, i29, i2, i33, i10, i31, iPositionForFieldNumber, i32, iM4092type, jM4091offset, registers);
                            if (iDecodeUnknownField != i38) {
                                messageSchema2 = this;
                                t3 = t;
                                bArr3 = bArr;
                                i22 = i2;
                                i23 = i3;
                                registers2 = registers;
                                i28 = i13;
                                i26 = i12;
                                i24 = i14;
                                i25 = i21;
                                i27 = i10;
                                unsafe2 = unsafe;
                            } else {
                                i4 = i3;
                                i11 = iDecodeUnknownField;
                            }
                        } else {
                            i20 = i29;
                            unsafe = unsafe2;
                            i14 = iPositionForFieldNumber;
                            i21 = i33;
                            if (iM4092type != 50) {
                                iDecodeUnknownField = parseOneofField(t, bArr, i20, i2, i21, i10, i31, i32, iM4092type, jM4091offset, i14, registers);
                                if (iDecodeUnknownField != i20) {
                                    messageSchema2 = this;
                                    t3 = t;
                                    bArr3 = bArr;
                                    i22 = i2;
                                    i23 = i3;
                                    registers2 = registers;
                                    i28 = i13;
                                    i26 = i12;
                                    i24 = i14;
                                    i25 = i21;
                                    i27 = i10;
                                    unsafe2 = unsafe;
                                } else {
                                    i4 = i3;
                                    i11 = iDecodeUnknownField;
                                }
                            } else if (i31 == 2) {
                                iDecodeUnknownField = parseMapField(t, bArr, i20, i2, i14, jM4091offset, registers);
                                if (iDecodeUnknownField != i20) {
                                    messageSchema2 = this;
                                    t3 = t;
                                    bArr3 = bArr;
                                    i22 = i2;
                                    i23 = i3;
                                    registers2 = registers;
                                    i28 = i13;
                                    i26 = i12;
                                    i24 = i14;
                                    i25 = i21;
                                    i27 = i10;
                                    unsafe2 = unsafe;
                                } else {
                                    i4 = i3;
                                    i11 = iDecodeUnknownField;
                                }
                            } else {
                                i4 = i3;
                                i11 = i20;
                            }
                        }
                        i6 = i21;
                    }
                }
                if (i6 != i4 || i4 == 0) {
                    iDecodeUnknownField = (!this.hasExtensions || registers.extensionRegistry == ExtensionRegistryLite.getEmptyRegistry()) ? ArrayDecoders.decodeUnknownField(i6, bArr, i11, i2, getMutableUnknownFields(t), registers) : ArrayDecoders.decodeExtensionOrUnknownField(i6, bArr, i11, i2, t, this.defaultInstance, this.unknownFieldSchema, registers);
                    t3 = t;
                    bArr3 = bArr;
                    i22 = i2;
                    i25 = i6;
                    messageSchema2 = this;
                    registers2 = registers;
                    i28 = i13;
                    i26 = i12;
                    i24 = i14;
                    i27 = i10;
                    unsafe2 = unsafe;
                    i23 = i4;
                } else {
                    i8 = 1048575;
                    messageSchema = this;
                    i5 = i11;
                    i7 = i13;
                    i26 = i12;
                }
            } else {
                int i39 = i28;
                unsafe = unsafe2;
                i4 = i23;
                messageSchema = messageSchema2;
                i5 = iDecodeUnknownField;
                i6 = i25;
                i7 = i39;
                i8 = 1048575;
            }
        }
        if (i7 != i8) {
            t2 = t;
            unsafe.putInt(t2, i7, i26);
        } else {
            t2 = t;
        }
        UnknownFieldSetLite unknownFieldSetLite = null;
        for (int i40 = messageSchema.checkInitializedCount; i40 < messageSchema.repeatedFieldOffsetStart; i40++) {
            unknownFieldSetLite = (UnknownFieldSetLite) filterMapUnknownEnumValues(t, messageSchema.intArray[i40], unknownFieldSetLite, messageSchema.unknownFieldSchema, t);
        }
        if (unknownFieldSetLite != null) {
            messageSchema.unknownFieldSchema.setBuilderToMessage(t2, unknownFieldSetLite);
        }
        if (i4 == 0) {
            if (i5 != i2) {
                throw InvalidProtocolBufferException.parseFailure();
            }
        } else if (i5 > i2 || i6 != i4) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        return i5;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    /* renamed from: writeTo */
    public void mo4094writeTo(T t, InterfaceC0811Writer interfaceC0811Writer) {
        if (interfaceC0811Writer.fieldOrder() == InterfaceC0811Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t, interfaceC0811Writer);
        } else if (this.f3727proto3) {
            writeFieldsInAscendingOrderProto3(t, interfaceC0811Writer);
        } else {
            writeFieldsInAscendingOrderProto2(t, interfaceC0811Writer);
        }
    }

    private boolean isFieldPresent(T t, int i) {
        int iPresenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i);
        long j = 1048575 & iPresenceMaskAndOffsetAt;
        if (j != 1048575) {
            return ((1 << (iPresenceMaskAndOffsetAt >>> 20)) & UnsafeUtil.m4154getInt(t, j)) != 0;
        }
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jM4091offset = m4091offset(iTypeAndOffsetAt);
        switch (m4092type(iTypeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t, jM4091offset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t, jM4091offset)) != 0;
            case 2:
                return UnsafeUtil.m4157getLong(t, jM4091offset) != 0;
            case 3:
                return UnsafeUtil.m4157getLong(t, jM4091offset) != 0;
            case 4:
                return UnsafeUtil.m4154getInt(t, jM4091offset) != 0;
            case 5:
                return UnsafeUtil.m4157getLong(t, jM4091offset) != 0;
            case 6:
                return UnsafeUtil.m4154getInt(t, jM4091offset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t, jM4091offset);
            case 8:
                Object object = UnsafeUtil.getObject(t, jM4091offset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.f3559EMPTY.mo3942equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(t, jM4091offset) != null;
            case 10:
                return !ByteString.f3559EMPTY.mo3942equals(UnsafeUtil.getObject(t, jM4091offset));
            case 11:
                return UnsafeUtil.m4154getInt(t, jM4091offset) != 0;
            case 12:
                return UnsafeUtil.m4154getInt(t, jM4091offset) != 0;
            case 13:
                return UnsafeUtil.m4154getInt(t, jM4091offset) != 0;
            case 14:
                return UnsafeUtil.m4157getLong(t, jM4091offset) != 0;
            case 15:
                return UnsafeUtil.m4154getInt(t, jM4091offset) != 0;
            case 16:
                return UnsafeUtil.m4157getLong(t, jM4091offset) != 0;
            case 17:
                return UnsafeUtil.getObject(t, jM4091offset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private int positionForFieldNumber(int i, int i2) {
        if (i < this.minFieldNumber || i > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i, i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    public void mergeFrom(T t, InterfaceC0775Reader interfaceC0775Reader, ExtensionRegistryLite extensionRegistryLite) throws Throwable {
        extensionRegistryLite.getClass();
        checkMutable(t);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t, interfaceC0775Reader, extensionRegistryLite);
    }

    /* renamed from: equals */
    private boolean m4086equals(T t, T t2, int i) {
        int iTypeAndOffsetAt = typeAndOffsetAt(i);
        long jM4091offset = m4091offset(iTypeAndOffsetAt);
        switch (m4092type(iTypeAndOffsetAt)) {
            case 0:
                if (arePresentForEquals(t, t2, i) && Double.doubleToLongBits(UnsafeUtil.getDouble(t, jM4091offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t2, jM4091offset))) {
                    break;
                }
                break;
            case 1:
                if (arePresentForEquals(t, t2, i) && Float.floatToIntBits(UnsafeUtil.getFloat(t, jM4091offset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t2, jM4091offset))) {
                    break;
                }
                break;
            case 2:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4157getLong(t, jM4091offset) == UnsafeUtil.m4157getLong(t2, jM4091offset)) {
                    break;
                }
                break;
            case 3:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4157getLong(t, jM4091offset) == UnsafeUtil.m4157getLong(t2, jM4091offset)) {
                    break;
                }
                break;
            case 4:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4154getInt(t, jM4091offset) == UnsafeUtil.m4154getInt(t2, jM4091offset)) {
                    break;
                }
                break;
            case 5:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4157getLong(t, jM4091offset) == UnsafeUtil.m4157getLong(t2, jM4091offset)) {
                    break;
                }
                break;
            case 6:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4154getInt(t, jM4091offset) == UnsafeUtil.m4154getInt(t2, jM4091offset)) {
                    break;
                }
                break;
            case 7:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.getBoolean(t, jM4091offset) == UnsafeUtil.getBoolean(t2, jM4091offset)) {
                    break;
                }
                break;
            case 8:
                if (arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jM4091offset), UnsafeUtil.getObject(t2, jM4091offset))) {
                    break;
                }
                break;
            case 9:
                if (arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jM4091offset), UnsafeUtil.getObject(t2, jM4091offset))) {
                    break;
                }
                break;
            case 10:
                if (arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jM4091offset), UnsafeUtil.getObject(t2, jM4091offset))) {
                    break;
                }
                break;
            case 11:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4154getInt(t, jM4091offset) == UnsafeUtil.m4154getInt(t2, jM4091offset)) {
                    break;
                }
                break;
            case 12:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4154getInt(t, jM4091offset) == UnsafeUtil.m4154getInt(t2, jM4091offset)) {
                    break;
                }
                break;
            case 13:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4154getInt(t, jM4091offset) == UnsafeUtil.m4154getInt(t2, jM4091offset)) {
                    break;
                }
                break;
            case 14:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4157getLong(t, jM4091offset) == UnsafeUtil.m4157getLong(t2, jM4091offset)) {
                    break;
                }
                break;
            case 15:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4154getInt(t, jM4091offset) == UnsafeUtil.m4154getInt(t2, jM4091offset)) {
                    break;
                }
                break;
            case 16:
                if (arePresentForEquals(t, t2, i) && UnsafeUtil.m4157getLong(t, jM4091offset) == UnsafeUtil.m4157getLong(t2, jM4091offset)) {
                    break;
                }
                break;
            case 17:
                if (arePresentForEquals(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jM4091offset), UnsafeUtil.getObject(t2, jM4091offset))) {
                    break;
                }
                break;
            case 51:
            case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
            case C5125EACTags.f18346SEX /* 53 */:
            case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
            case 55:
            case 56:
            case 57:
            case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
            case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case C5125EACTags.ELEMENT_LIST /* 65 */:
            case C5125EACTags.f18344ADDRESS /* 66 */:
            case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
            case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                if (isOneofCaseEqual(t, t2, i) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t, jM4091offset), UnsafeUtil.getObject(t2, jM4091offset))) {
                    break;
                }
                break;
        }
        return true;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0777Schema
    public void mergeFrom(T t, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers) throws InvalidProtocolBufferException {
        if (this.f3727proto3) {
            parseProto3Message(t, bArr, i, i2, registers);
        } else {
            parseProto2Message(t, bArr, i, i2, 0, registers);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i, InterfaceC0777Schema interfaceC0777Schema) {
        return interfaceC0777Schema.isInitialized(UnsafeUtil.getObject(obj, m4091offset(i)));
    }
}
