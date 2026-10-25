package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldSet;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

@CheckReturnValue
/* loaded from: classes.dex */
final class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> PROTO2_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(false);
    private static final UnknownFieldSchema<?, ?> PROTO3_UNKNOWN_FIELD_SET_SCHEMA = getUnknownFieldSetSchema(true);
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    private SchemaUtil() {
    }

    public static int computeSizeBoolList(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(size) : size * CodedOutputStream.computeBoolSize(i, true);
    }

    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    public static int computeSizeByteStringList(int i, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = size * CodedOutputStream.computeTagSize(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iComputeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i2));
        }
        return iComputeTagSize;
    }

    public static int computeSizeEnumList(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeEnumListNoTag) : iComputeSizeEnumListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int iComputeEnumSizeNoTag;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            iComputeEnumSizeNoTag = 0;
            while (i < size) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(intArrayList.mo4039getInt(i));
                i++;
            }
        } else {
            iComputeEnumSizeNoTag = 0;
            while (i < size) {
                iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i).intValue());
                i++;
            }
        }
        return iComputeEnumSizeNoTag;
    }

    public static int computeSizeFixed32List(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 4) : size * CodedOutputStream.computeFixed32Size(i, 0);
    }

    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    public static int computeSizeFixed64List(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 8) : size * CodedOutputStream.computeFixed64Size(i, 0L);
    }

    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    public static int computeSizeGroupList(int i, List<MessageLite> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(i, list.get(i2));
        }
        return iComputeGroupSize;
    }

    public static int computeSizeInt32List(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt32ListNoTag) : iComputeSizeInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int iComputeInt32SizeNoTag;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            iComputeInt32SizeNoTag = 0;
            while (i < size) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(intArrayList.mo4039getInt(i));
                i++;
            }
        } else {
            iComputeInt32SizeNoTag = 0;
            while (i < size) {
                iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i).intValue());
                i++;
            }
        }
        return iComputeInt32SizeNoTag;
    }

    public static int computeSizeInt64List(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int iComputeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeInt64ListNoTag) : iComputeSizeInt64ListNoTag + (list.size() * CodedOutputStream.computeTagSize(i));
    }

    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int iComputeInt64SizeNoTag;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            iComputeInt64SizeNoTag = 0;
            while (i < size) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(longArrayList.mo4045getLong(i));
                i++;
            }
        } else {
            iComputeInt64SizeNoTag = 0;
            while (i < size) {
                iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i).longValue());
                i++;
            }
        }
        return iComputeInt64SizeNoTag;
    }

    public static int computeSizeMessage(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
        return obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSize(i, (LazyFieldLite) obj) : CodedOutputStream.computeMessageSize(i, (MessageLite) obj, interfaceC0777Schema);
    }

    public static int computeSizeMessageList(int i, List<?> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            iComputeTagSize += obj instanceof LazyFieldLite ? CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj) : CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj);
        }
        return iComputeTagSize;
    }

    public static int computeSizeSInt32List(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt32ListNoTag) : iComputeSizeSInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int iComputeSInt32SizeNoTag;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            iComputeSInt32SizeNoTag = 0;
            while (i < size) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.mo4039getInt(i));
                i++;
            }
        } else {
            iComputeSInt32SizeNoTag = 0;
            while (i < size) {
                iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i).intValue());
                i++;
            }
        }
        return iComputeSInt32SizeNoTag;
    }

    public static int computeSizeSInt64List(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeSInt64ListNoTag) : iComputeSizeSInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int iComputeSInt64SizeNoTag;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            iComputeSInt64SizeNoTag = 0;
            while (i < size) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.mo4045getLong(i));
                i++;
            }
        } else {
            iComputeSInt64SizeNoTag = 0;
            while (i < size) {
                iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i).longValue());
                i++;
            }
        }
        return iComputeSInt64SizeNoTag;
    }

    public static int computeSizeStringList(int i, List<?> list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < size) {
                Object objMo4060getRaw = lazyStringList.mo4060getRaw(i2);
                iComputeTagSize += objMo4060getRaw instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) objMo4060getRaw) : CodedOutputStream.computeStringSizeNoTag((String) objMo4060getRaw);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                iComputeTagSize += obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj);
                i2++;
            }
        }
        return iComputeTagSize;
    }

    public static int computeSizeUInt32List(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt32ListNoTag) : iComputeSizeUInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int iComputeUInt32SizeNoTag;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            iComputeUInt32SizeNoTag = 0;
            while (i < size) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.mo4039getInt(i));
                i++;
            }
        } else {
            iComputeUInt32SizeNoTag = 0;
            while (i < size) {
                iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i).intValue());
                i++;
            }
        }
        return iComputeUInt32SizeNoTag;
    }

    public static int computeSizeUInt64List(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        return z ? CodedOutputStream.computeTagSize(i) + CodedOutputStream.computeLengthDelimitedFieldSize(iComputeSizeUInt64ListNoTag) : iComputeSizeUInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i));
    }

    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int iComputeUInt64SizeNoTag;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            iComputeUInt64SizeNoTag = 0;
            while (i < size) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.mo4045getLong(i));
                i++;
            }
        } else {
            iComputeUInt64SizeNoTag = 0;
            while (i < size) {
                iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i).longValue());
                i++;
            }
        }
        return iComputeUInt64SizeNoTag;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i, List<Integer> list, Internal.EnumLiteMap<?> enumLiteMap, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumLiteMap == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = list.get(i3);
                int iIntValue = num.intValue();
                if (enumLiteMap.findValueByNumber(iIntValue) != null) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    ub = (UB) storeUnknownEnum(obj, i, iIntValue, ub, unknownFieldSchema);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (enumLiteMap.findValueByNumber(iIntValue2) == null) {
                    ub = (UB) storeUnknownEnum(obj, i, iIntValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Object getMapDefaultEntry(Class<?> cls, String str) {
        try {
            Field[] declaredFields = Class.forName(cls.getName() + "$" + toCamelCase(str, true) + "DefaultEntryHolder").getDeclaredFields();
            if (declaredFields.length == 1) {
                return UnsafeUtil.getStaticObject(declaredFields[0]);
            }
            throw new IllegalStateException("Unable to look up map field default entry holder class for " + str + " in " + cls.getName());
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema(boolean z) {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        try {
            return Class.forName("com.google.crypto.tink.shaded.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t, T t2) {
        FieldSet<T> extensions = extensionSchema.getExtensions(t2);
        if (extensions.m4008isEmpty()) {
            return;
        }
        extensionSchema.getMutableExtensions(t).mergeFrom(extensions);
    }

    public static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t, T t2, long j) {
        UnsafeUtil.putObject(t, j, mapFieldSchema.mergeFrom(UnsafeUtil.getObject(t, j), UnsafeUtil.getObject(t2, j)));
    }

    public static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t, T t2) {
        unknownFieldSchema.setToMessage(t, unknownFieldSchema.mo4144merge(unknownFieldSchema.getFromMessage(t), unknownFieldSchema.getFromMessage(t2)));
    }

    public static UnknownFieldSchema<?, ?> proto2UnknownFieldSetSchema() {
        return PROTO2_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> proto3UnknownFieldSetSchema() {
        return PROTO3_UNKNOWN_FIELD_SET_SCHEMA;
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    public static boolean safeEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static boolean shouldUseTableSwitch(int i, int i2, int i3) {
        if (i2 < 40) {
            return true;
        }
        long j = i2 - i;
        long j2 = i3;
        return j + 10 <= ((2 * j2) + 3) + ((j2 + 3) * 3);
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB storeUnknownEnum(Object obj, int i, int i2, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.getBuilderFromMessage(obj);
        }
        unknownFieldSchema.addVarint(ub, i, i2);
        return ub;
    }

    public static String toCamelCase(String str, boolean z) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ('a' > cCharAt || cCharAt > 'z') {
                if ('A' > cCharAt || cCharAt > 'Z') {
                    if ('0' <= cCharAt && cCharAt <= '9') {
                        sb.append(cCharAt);
                    }
                    z = true;
                } else if (i != 0 || z) {
                    sb.append(cCharAt);
                } else {
                    sb.append((char) (cCharAt + ' '));
                }
            } else if (z) {
                sb.append((char) (cCharAt - ' '));
            } else {
                sb.append(cCharAt);
            }
            z = false;
        }
        return sb.toString();
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBool(int i, boolean z, InterfaceC0811Writer interfaceC0811Writer) {
        if (z) {
            interfaceC0811Writer.writeBool(i, true);
        }
    }

    public static void writeBoolList(int i, List<Boolean> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeBoolList(i, list, z);
    }

    public static void writeBytes(int i, ByteString byteString, InterfaceC0811Writer interfaceC0811Writer) {
        if (byteString == null || byteString.m3943isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeBytes(i, byteString);
    }

    public static void writeBytesList(int i, List<ByteString> list, InterfaceC0811Writer interfaceC0811Writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeBytesList(i, list);
    }

    public static void writeDouble(int i, double d, InterfaceC0811Writer interfaceC0811Writer) {
        if (Double.doubleToRawLongBits(d) != 0) {
            interfaceC0811Writer.writeDouble(i, d);
        }
    }

    public static void writeDoubleList(int i, List<Double> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeDoubleList(i, list, z);
    }

    public static void writeEnum(int i, int i2, InterfaceC0811Writer interfaceC0811Writer) {
        if (i2 != 0) {
            interfaceC0811Writer.writeEnum(i, i2);
        }
    }

    public static void writeEnumList(int i, List<Integer> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeEnumList(i, list, z);
    }

    public static void writeFixed32(int i, int i2, InterfaceC0811Writer interfaceC0811Writer) {
        if (i2 != 0) {
            interfaceC0811Writer.writeFixed32(i, i2);
        }
    }

    public static void writeFixed32List(int i, List<Integer> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeFixed32List(i, list, z);
    }

    public static void writeFixed64(int i, long j, InterfaceC0811Writer interfaceC0811Writer) {
        if (j != 0) {
            interfaceC0811Writer.writeFixed64(i, j);
        }
    }

    public static void writeFixed64List(int i, List<Long> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeFixed64List(i, list, z);
    }

    public static void writeFloat(int i, float f, InterfaceC0811Writer interfaceC0811Writer) {
        if (Float.floatToRawIntBits(f) != 0) {
            interfaceC0811Writer.writeFloat(i, f);
        }
    }

    public static void writeFloatList(int i, List<Float> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeFloatList(i, list, z);
    }

    public static void writeGroupList(int i, List<?> list, InterfaceC0811Writer interfaceC0811Writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeGroupList(i, list);
    }

    public static void writeInt32(int i, int i2, InterfaceC0811Writer interfaceC0811Writer) {
        if (i2 != 0) {
            interfaceC0811Writer.writeInt32(i, i2);
        }
    }

    public static void writeInt32List(int i, List<Integer> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeInt32List(i, list, z);
    }

    public static void writeInt64(int i, long j, InterfaceC0811Writer interfaceC0811Writer) {
        if (j != 0) {
            interfaceC0811Writer.writeInt64(i, j);
        }
    }

    public static void writeInt64List(int i, List<Long> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeInt64List(i, list, z);
    }

    public static void writeLazyFieldList(int i, List<?> list, InterfaceC0811Writer interfaceC0811Writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            ((LazyFieldLite) it.next()).m4054writeTo(interfaceC0811Writer, i);
        }
    }

    public static void writeMessage(int i, Object obj, InterfaceC0811Writer interfaceC0811Writer) {
        if (obj != null) {
            interfaceC0811Writer.writeMessage(i, obj);
        }
    }

    public static void writeMessageList(int i, List<?> list, InterfaceC0811Writer interfaceC0811Writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeMessageList(i, list);
    }

    public static void writeSFixed32(int i, int i2, InterfaceC0811Writer interfaceC0811Writer) {
        if (i2 != 0) {
            interfaceC0811Writer.writeSFixed32(i, i2);
        }
    }

    public static void writeSFixed32List(int i, List<Integer> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeSFixed32List(i, list, z);
    }

    public static void writeSFixed64(int i, long j, InterfaceC0811Writer interfaceC0811Writer) {
        if (j != 0) {
            interfaceC0811Writer.writeSFixed64(i, j);
        }
    }

    public static void writeSFixed64List(int i, List<Long> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeSFixed64List(i, list, z);
    }

    public static void writeSInt32(int i, int i2, InterfaceC0811Writer interfaceC0811Writer) {
        if (i2 != 0) {
            interfaceC0811Writer.writeSInt32(i, i2);
        }
    }

    public static void writeSInt32List(int i, List<Integer> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeSInt32List(i, list, z);
    }

    public static void writeSInt64(int i, long j, InterfaceC0811Writer interfaceC0811Writer) {
        if (j != 0) {
            interfaceC0811Writer.writeSInt64(i, j);
        }
    }

    public static void writeSInt64List(int i, List<Long> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeSInt64List(i, list, z);
    }

    public static void writeString(int i, Object obj, InterfaceC0811Writer interfaceC0811Writer) {
        if (obj instanceof String) {
            writeStringInternal(i, (String) obj, interfaceC0811Writer);
        } else {
            writeBytes(i, (ByteString) obj, interfaceC0811Writer);
        }
    }

    private static void writeStringInternal(int i, String str, InterfaceC0811Writer interfaceC0811Writer) {
        if (str == null || str.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeString(i, str);
    }

    public static void writeStringList(int i, List<String> list, InterfaceC0811Writer interfaceC0811Writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeStringList(i, list);
    }

    public static void writeUInt32(int i, int i2, InterfaceC0811Writer interfaceC0811Writer) {
        if (i2 != 0) {
            interfaceC0811Writer.writeUInt32(i, i2);
        }
    }

    public static void writeUInt32List(int i, List<Integer> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeUInt32List(i, list, z);
    }

    public static void writeUInt64(int i, long j, InterfaceC0811Writer interfaceC0811Writer) {
        if (j != 0) {
            interfaceC0811Writer.writeUInt64(i, j);
        }
    }

    public static void writeUInt64List(int i, List<Long> list, InterfaceC0811Writer interfaceC0811Writer, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeUInt64List(i, list, z);
    }

    public static boolean shouldUseTableSwitch(FieldInfo[] fieldInfoArr) {
        if (fieldInfoArr.length == 0) {
            return false;
        }
        return shouldUseTableSwitch(fieldInfoArr[0].getFieldNumber(), fieldInfoArr[fieldInfoArr.length - 1].getFieldNumber(), fieldInfoArr.length);
    }

    public static int computeSizeGroupList(int i, List<MessageLite> list, InterfaceC0777Schema interfaceC0777Schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeGroupSize = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iComputeGroupSize += CodedOutputStream.computeGroupSize(i, list.get(i2), interfaceC0777Schema);
        }
        return iComputeGroupSize;
    }

    public static void writeGroupList(int i, List<?> list, InterfaceC0811Writer interfaceC0811Writer, InterfaceC0777Schema interfaceC0777Schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeGroupList(i, list, interfaceC0777Schema);
    }

    public static void writeMessageList(int i, List<?> list, InterfaceC0811Writer interfaceC0811Writer, InterfaceC0777Schema interfaceC0777Schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        interfaceC0811Writer.writeMessageList(i, list, interfaceC0777Schema);
    }

    public static int computeSizeMessageList(int i, List<?> list, InterfaceC0777Schema interfaceC0777Schema) {
        int iComputeMessageSizeNoTag;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iComputeTagSize = CodedOutputStream.computeTagSize(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof LazyFieldLite) {
                iComputeMessageSizeNoTag = CodedOutputStream.computeLazyFieldSizeNoTag((LazyFieldLite) obj);
            } else {
                iComputeMessageSizeNoTag = CodedOutputStream.computeMessageSizeNoTag((MessageLite) obj, interfaceC0777Schema);
            }
            iComputeTagSize += iComputeMessageSizeNoTag;
        }
        return iComputeTagSize;
    }

    @CanIgnoreReturnValue
    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = list.get(i3);
                int iIntValue = num.intValue();
                if (enumVerifier.isInRange(iIntValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    ub = (UB) storeUnknownEnum(obj, i, iIntValue, ub, unknownFieldSchema);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int iIntValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(iIntValue2)) {
                    ub = (UB) storeUnknownEnum(obj, i, iIntValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
