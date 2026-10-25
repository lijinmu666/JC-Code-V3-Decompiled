package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MapEntryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.WireFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes.dex */
final class CodedOutputStreamWriter implements InterfaceC0811Writer {

    /* renamed from: output */
    private final CodedOutputStream f3605output;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.CodedOutputStreamWriter$1 */
    public static /* synthetic */ class C07321 {
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
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3825INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3828SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3831UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3822FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3826INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3829SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3832UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3830STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.f3605output = codedOutputStream2;
        codedOutputStream2.f3592wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.f3592wrapper;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void writeDeterministicBooleanMapEntry(int i, boolean z, V v, MapEntryLite.Metadata<Boolean, V> metadata) {
        this.f3605output.writeTag(i, 2);
        this.f3605output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z), v));
        MapEntryLite.m4076writeTo(this.f3605output, metadata, Boolean.valueOf(z), v);
    }

    private <V> void writeDeterministicIntegerMap(int i, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = it.next().intValue();
            i2++;
        }
        Arrays.sort(iArr);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            V v = map.get(Integer.valueOf(i4));
            this.f3605output.writeTag(i, 2);
            this.f3605output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i4), v));
            MapEntryLite.m4076writeTo(this.f3605output, metadata, Integer.valueOf(i4), v);
        }
    }

    private <V> void writeDeterministicLongMap(int i, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr[i2] = it.next().longValue();
            i2++;
        }
        Arrays.sort(jArr);
        for (int i3 = 0; i3 < size; i3++) {
            long j = jArr[i3];
            V v = map.get(Long.valueOf(j));
            this.f3605output.writeTag(i, 2);
            this.f3605output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j), v));
            MapEntryLite.m4076writeTo(this.f3605output, metadata, Long.valueOf(j), v);
        }
    }

    private <K, V> void writeDeterministicMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        switch (C07321.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.f3722keyType.ordinal()]) {
            case 1:
                V v = map.get(Boolean.FALSE);
                if (v != null) {
                    writeDeterministicBooleanMapEntry(i, false, v, metadata);
                }
                V v2 = map.get(Boolean.TRUE);
                if (v2 != null) {
                    writeDeterministicBooleanMapEntry(i, true, v2, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.f3722keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strArr[i2] = it.next();
            i2++;
        }
        Arrays.sort(strArr);
        for (int i3 = 0; i3 < size; i3++) {
            String str = strArr[i3];
            V v = map.get(str);
            this.f3605output.writeTag(i, 2);
            this.f3605output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v));
            MapEntryLite.m4076writeTo(this.f3605output, metadata, str, v);
        }
    }

    private void writeLazyString(int i, Object obj) {
        if (obj instanceof String) {
            this.f3605output.writeString(i, (String) obj);
        } else {
            this.f3605output.writeBytes(i, (ByteString) obj);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public InterfaceC0811Writer.FieldOrder fieldOrder() {
        return InterfaceC0811Writer.FieldOrder.ASCENDING;
    }

    public int getTotalBytesWritten() {
        return this.f3605output.getTotalBytesWritten();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeBool(int i, boolean z) {
        this.f3605output.writeBool(i, z);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeBoolList(int i, List<Boolean> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeBool(i, list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeBoolSizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeBoolSizeNoTag += CodedOutputStream.computeBoolSizeNoTag(list.get(i3).booleanValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeBoolSizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeBoolNoTag(list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeBytes(int i, ByteString byteString) {
        this.f3605output.writeBytes(i, byteString);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeBytesList(int i, List<ByteString> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.f3605output.writeBytes(i, list.get(i2));
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeDouble(int i, double d) {
        this.f3605output.writeDouble(i, d);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeDoubleList(int i, List<Double> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeDouble(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeDoubleSizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeDoubleSizeNoTag += CodedOutputStream.computeDoubleSizeNoTag(list.get(i3).doubleValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeDoubleSizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeDoubleNoTag(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    @Deprecated
    public void writeEndGroup(int i) {
        this.f3605output.writeTag(i, 4);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeEnum(int i, int i2) {
        this.f3605output.writeEnum(i, i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeEnumList(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeEnum(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeEnumSizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeEnumSizeNoTag += CodedOutputStream.computeEnumSizeNoTag(list.get(i3).intValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeEnumSizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeEnumNoTag(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeFixed32(int i, int i2) {
        this.f3605output.writeFixed32(i, i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeFixed32List(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeFixed32(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeFixed32SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeFixed32SizeNoTag += CodedOutputStream.computeFixed32SizeNoTag(list.get(i3).intValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeFixed32SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeFixed32NoTag(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeFixed64(int i, long j) {
        this.f3605output.writeFixed64(i, j);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeFixed64List(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeFixed64(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeFixed64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeFixed64SizeNoTag += CodedOutputStream.computeFixed64SizeNoTag(list.get(i3).longValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeFixed64SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeFixed64NoTag(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeFloat(int i, float f) {
        this.f3605output.writeFloat(i, f);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeFloatList(int i, List<Float> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeFloat(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeFloatSizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeFloatSizeNoTag += CodedOutputStream.computeFloatSizeNoTag(list.get(i3).floatValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeFloatSizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeFloatNoTag(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    @Deprecated
    public void writeGroup(int i, Object obj) {
        this.f3605output.writeGroup(i, (MessageLite) obj);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    @Deprecated
    public void writeGroupList(int i, List<?> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeGroup(i, list.get(i2));
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeInt32(int i, int i2) {
        this.f3605output.writeInt32(i, i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeInt32List(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeInt32(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeInt32SizeNoTag += CodedOutputStream.computeInt32SizeNoTag(list.get(i3).intValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeInt32SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeInt32NoTag(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeInt64(int i, long j) {
        this.f3605output.writeInt64(i, j);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeInt64List(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeInt64(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeInt64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeInt64SizeNoTag += CodedOutputStream.computeInt64SizeNoTag(list.get(i3).longValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeInt64SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeInt64NoTag(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public <K, V> void writeMap(int i, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        if (this.f3605output.isSerializationDeterministic()) {
            writeDeterministicMap(i, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f3605output.writeTag(i, 2);
            this.f3605output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.m4076writeTo(this.f3605output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeMessage(int i, Object obj) {
        this.f3605output.writeMessage(i, (MessageLite) obj);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeMessageList(int i, List<?> list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeMessage(i, list.get(i2));
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public final void writeMessageSetItem(int i, Object obj) {
        if (obj instanceof ByteString) {
            this.f3605output.writeRawMessageSetExtension(i, (ByteString) obj);
        } else {
            this.f3605output.writeMessageSetExtension(i, (MessageLite) obj);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeSFixed32(int i, int i2) {
        this.f3605output.writeSFixed32(i, i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeSFixed32List(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeSFixed32(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeSFixed32SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeSFixed32SizeNoTag += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i3).intValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeSFixed32SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeSFixed32NoTag(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeSFixed64(int i, long j) {
        this.f3605output.writeSFixed64(i, j);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeSFixed64List(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeSFixed64(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeSFixed64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeSFixed64SizeNoTag += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i3).longValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeSFixed64SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeSFixed64NoTag(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeSInt32(int i, int i2) {
        this.f3605output.writeSInt32(i, i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeSInt32List(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeSInt32(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeSInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeSInt32SizeNoTag += CodedOutputStream.computeSInt32SizeNoTag(list.get(i3).intValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeSInt32SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeSInt32NoTag(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeSInt64(int i, long j) {
        this.f3605output.writeSInt64(i, j);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeSInt64List(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeSInt64(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeSInt64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeSInt64SizeNoTag += CodedOutputStream.computeSInt64SizeNoTag(list.get(i3).longValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeSInt64SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeSInt64NoTag(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    @Deprecated
    public void writeStartGroup(int i) {
        this.f3605output.writeTag(i, 3);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeString(int i, String str) {
        this.f3605output.writeString(i, str);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeStringList(int i, List<String> list) {
        int i2 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i2 < list.size()) {
                this.f3605output.writeString(i, list.get(i2));
                i2++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i2 < list.size()) {
                writeLazyString(i, lazyStringList.mo4060getRaw(i2));
                i2++;
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeUInt32(int i, int i2) {
        this.f3605output.writeUInt32(i, i2);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeUInt32List(int i, List<Integer> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeUInt32(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeUInt32SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeUInt32SizeNoTag += CodedOutputStream.computeUInt32SizeNoTag(list.get(i3).intValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeUInt32SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeUInt32NoTag(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeUInt64(int i, long j) {
        this.f3605output.writeUInt64(i, j);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeUInt64List(int i, List<Long> list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.f3605output.writeUInt64(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.f3605output.writeTag(i, 2);
        int iComputeUInt64SizeNoTag = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iComputeUInt64SizeNoTag += CodedOutputStream.computeUInt64SizeNoTag(list.get(i3).longValue());
        }
        this.f3605output.writeUInt32NoTag(iComputeUInt64SizeNoTag);
        while (i2 < list.size()) {
            this.f3605output.writeUInt64NoTag(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeGroup(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
        this.f3605output.writeGroup(i, (MessageLite) obj, interfaceC0777Schema);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeMessage(int i, Object obj, InterfaceC0777Schema interfaceC0777Schema) {
        this.f3605output.writeMessage(i, (MessageLite) obj, interfaceC0777Schema);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeGroupList(int i, List<?> list, InterfaceC0777Schema interfaceC0777Schema) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeGroup(i, list.get(i2), interfaceC0777Schema);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.InterfaceC0811Writer
    public void writeMessageList(int i, List<?> list, InterfaceC0777Schema interfaceC0777Schema) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            writeMessage(i, list.get(i2), interfaceC0777Schema);
        }
    }
}
