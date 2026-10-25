package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.WireFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CheckReturnValue
/* loaded from: classes.dex */
final class ExtensionSchemaLite extends ExtensionSchema<GeneratedMessageLite.ExtensionDescriptor> {

    /* renamed from: com.google.crypto.tink.shaded.protobuf.ExtensionSchemaLite$1 */
    public static /* synthetic */ class C07411 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.m4187values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.f3819DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3823FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3826INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3832UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3825INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3822FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3821FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3817BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3831UINT32.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3828SINT32.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3829SINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3820ENUM.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3818BYTES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3830STRING.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3824GROUP.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.f3827MESSAGE.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public int extensionNumber(Map.Entry<?, ?> entry) {
        return ((GeneratedMessageLite.ExtensionDescriptor) entry.getKey()).getNumber();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i) {
        return extensionRegistryLite.findLiteExtensionByNumber(messageLite, i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> getExtensions(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).extensions;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public FieldSet<GeneratedMessageLite.ExtensionDescriptor> getMutableExtensions(Object obj) {
        return ((GeneratedMessageLite.ExtendableMessage) obj).ensureExtensionsAreMutable();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public boolean hasExtensions(MessageLite messageLite) {
        return messageLite instanceof GeneratedMessageLite.ExtendableMessage;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public <UT, UB> UB parseExtension(Object obj, InterfaceC0775Reader interfaceC0775Reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        Object objValueOf;
        Object field;
        ArrayList arrayList;
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj2;
        int number = generatedExtension.getNumber();
        if (generatedExtension.descriptor.isRepeated() && generatedExtension.descriptor.isPacked()) {
            switch (C07411.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readDoubleList(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readFloatList(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readInt64List(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readUInt64List(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readInt32List(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readFixed64List(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readFixed32List(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readBoolList(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readUInt32List(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readSFixed32List(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readSFixed64List(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readSInt32List(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readSInt64List(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    interfaceC0775Reader.readEnumList(arrayList);
                    ub = (UB) SchemaUtil.filterUnknownEnumList(obj, number, arrayList, generatedExtension.descriptor.getEnumType(), ub, unknownFieldSchema);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + generatedExtension.descriptor.getLiteType());
            }
            fieldSet.setField(generatedExtension.descriptor, arrayList);
        } else {
            if (generatedExtension.getLiteType() != WireFormat.FieldType.f3820ENUM) {
                switch (C07411.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()]) {
                    case 1:
                        objValueOf = Double.valueOf(interfaceC0775Reader.readDouble());
                        break;
                    case 2:
                        objValueOf = Float.valueOf(interfaceC0775Reader.readFloat());
                        break;
                    case 3:
                        objValueOf = Long.valueOf(interfaceC0775Reader.readInt64());
                        break;
                    case 4:
                        objValueOf = Long.valueOf(interfaceC0775Reader.readUInt64());
                        break;
                    case 5:
                        objValueOf = Integer.valueOf(interfaceC0775Reader.readInt32());
                        break;
                    case 6:
                        objValueOf = Long.valueOf(interfaceC0775Reader.readFixed64());
                        break;
                    case 7:
                        objValueOf = Integer.valueOf(interfaceC0775Reader.readFixed32());
                        break;
                    case 8:
                        objValueOf = Boolean.valueOf(interfaceC0775Reader.readBool());
                        break;
                    case 9:
                        objValueOf = Integer.valueOf(interfaceC0775Reader.readUInt32());
                        break;
                    case 10:
                        objValueOf = Integer.valueOf(interfaceC0775Reader.readSFixed32());
                        break;
                    case 11:
                        objValueOf = Long.valueOf(interfaceC0775Reader.readSFixed64());
                        break;
                    case 12:
                        objValueOf = Integer.valueOf(interfaceC0775Reader.readSInt32());
                        break;
                    case 13:
                        objValueOf = Long.valueOf(interfaceC0775Reader.readSInt64());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        objValueOf = interfaceC0775Reader.readBytes();
                        break;
                    case 16:
                        objValueOf = interfaceC0775Reader.readString();
                        break;
                    case 17:
                        if (!generatedExtension.isRepeated()) {
                            Object field2 = fieldSet.getField(generatedExtension.descriptor);
                            if (field2 instanceof GeneratedMessageLite) {
                                InterfaceC0777Schema interfaceC0777SchemaSchemaFor = Protobuf.getInstance().schemaFor((Protobuf) field2);
                                if (!((GeneratedMessageLite) field2).isMutable()) {
                                    Object objNewInstance = interfaceC0777SchemaSchemaFor.newInstance();
                                    interfaceC0777SchemaSchemaFor.mergeFrom(objNewInstance, field2);
                                    fieldSet.setField(generatedExtension.descriptor, objNewInstance);
                                    field2 = objNewInstance;
                                }
                                interfaceC0775Reader.mergeGroupField(field2, interfaceC0777SchemaSchemaFor, extensionRegistryLite);
                                return ub;
                            }
                        }
                        objValueOf = interfaceC0775Reader.readGroup(generatedExtension.getMessageDefaultInstance().getClass(), extensionRegistryLite);
                        break;
                    case 18:
                        if (!generatedExtension.isRepeated()) {
                            Object field3 = fieldSet.getField(generatedExtension.descriptor);
                            if (field3 instanceof GeneratedMessageLite) {
                                InterfaceC0777Schema interfaceC0777SchemaSchemaFor2 = Protobuf.getInstance().schemaFor((Protobuf) field3);
                                if (!((GeneratedMessageLite) field3).isMutable()) {
                                    Object objNewInstance2 = interfaceC0777SchemaSchemaFor2.newInstance();
                                    interfaceC0777SchemaSchemaFor2.mergeFrom(objNewInstance2, field3);
                                    fieldSet.setField(generatedExtension.descriptor, objNewInstance2);
                                    field3 = objNewInstance2;
                                }
                                interfaceC0775Reader.mergeMessageField(field3, interfaceC0777SchemaSchemaFor2, extensionRegistryLite);
                                return ub;
                            }
                        }
                        objValueOf = interfaceC0775Reader.readMessage(generatedExtension.getMessageDefaultInstance().getClass(), extensionRegistryLite);
                        break;
                    default:
                        objValueOf = null;
                        break;
                }
            } else {
                int int32 = interfaceC0775Reader.readInt32();
                if (generatedExtension.descriptor.getEnumType().findValueByNumber(int32) == null) {
                    return (UB) SchemaUtil.storeUnknownEnum(obj, number, int32, ub, unknownFieldSchema);
                }
                objValueOf = Integer.valueOf(int32);
            }
            if (generatedExtension.isRepeated()) {
                fieldSet.addRepeatedField(generatedExtension.descriptor, objValueOf);
            } else {
                int i = C07411.$SwitchMap$com$google$protobuf$WireFormat$FieldType[generatedExtension.getLiteType().ordinal()];
                if ((i == 17 || i == 18) && (field = fieldSet.getField(generatedExtension.descriptor)) != null) {
                    objValueOf = Internal.mergeMessage(field, objValueOf);
                }
                fieldSet.setField(generatedExtension.descriptor, objValueOf);
            }
        }
        return ub;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public void parseLengthPrefixedMessageSetItem(InterfaceC0775Reader interfaceC0775Reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet) {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        fieldSet.setField(generatedExtension.descriptor, interfaceC0775Reader.readMessage(generatedExtension.getMessageDefaultInstance().getClass(), extensionRegistryLite));
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet) {
        GeneratedMessageLite.GeneratedExtension generatedExtension = (GeneratedMessageLite.GeneratedExtension) obj;
        MessageLite.InterfaceC0766Builder interfaceC0766BuilderNewBuilderForType = generatedExtension.getMessageDefaultInstance().newBuilderForType();
        CodedInputStream codedInputStreamNewCodedInput = byteString.newCodedInput();
        interfaceC0766BuilderNewBuilderForType.mergeFrom(codedInputStreamNewCodedInput, extensionRegistryLite);
        fieldSet.setField(generatedExtension.descriptor, interfaceC0766BuilderNewBuilderForType.buildPartial());
        codedInputStreamNewCodedInput.checkLastTagWas(0);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public void serializeExtension(InterfaceC0811Writer interfaceC0811Writer, Map.Entry<?, ?> entry) {
        GeneratedMessageLite.ExtensionDescriptor extensionDescriptor = (GeneratedMessageLite.ExtensionDescriptor) entry.getKey();
        if (!extensionDescriptor.isRepeated()) {
            switch (C07411.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extensionDescriptor.getLiteType().ordinal()]) {
                case 1:
                    interfaceC0811Writer.writeDouble(extensionDescriptor.getNumber(), ((Double) entry.getValue()).doubleValue());
                    break;
                case 2:
                    interfaceC0811Writer.writeFloat(extensionDescriptor.getNumber(), ((Float) entry.getValue()).floatValue());
                    break;
                case 3:
                    interfaceC0811Writer.writeInt64(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 4:
                    interfaceC0811Writer.writeUInt64(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 5:
                    interfaceC0811Writer.writeInt32(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 6:
                    interfaceC0811Writer.writeFixed64(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 7:
                    interfaceC0811Writer.writeFixed32(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 8:
                    interfaceC0811Writer.writeBool(extensionDescriptor.getNumber(), ((Boolean) entry.getValue()).booleanValue());
                    break;
                case 9:
                    interfaceC0811Writer.writeUInt32(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 10:
                    interfaceC0811Writer.writeSFixed32(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 11:
                    interfaceC0811Writer.writeSFixed64(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 12:
                    interfaceC0811Writer.writeSInt32(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 13:
                    interfaceC0811Writer.writeSInt64(extensionDescriptor.getNumber(), ((Long) entry.getValue()).longValue());
                    break;
                case 14:
                    interfaceC0811Writer.writeInt32(extensionDescriptor.getNumber(), ((Integer) entry.getValue()).intValue());
                    break;
                case 15:
                    interfaceC0811Writer.writeBytes(extensionDescriptor.getNumber(), (ByteString) entry.getValue());
                    break;
                case 16:
                    interfaceC0811Writer.writeString(extensionDescriptor.getNumber(), (String) entry.getValue());
                    break;
                case 17:
                    interfaceC0811Writer.writeGroup(extensionDescriptor.getNumber(), entry.getValue(), Protobuf.getInstance().schemaFor((Class) entry.getValue().getClass()));
                    break;
                case 18:
                    interfaceC0811Writer.writeMessage(extensionDescriptor.getNumber(), entry.getValue(), Protobuf.getInstance().schemaFor((Class) entry.getValue().getClass()));
                    break;
            }
        }
        switch (C07411.$SwitchMap$com$google$protobuf$WireFormat$FieldType[extensionDescriptor.getLiteType().ordinal()]) {
            case 1:
                SchemaUtil.writeDoubleList(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 2:
                SchemaUtil.writeFloatList(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 3:
                SchemaUtil.writeInt64List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 4:
                SchemaUtil.writeUInt64List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 5:
                SchemaUtil.writeInt32List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 6:
                SchemaUtil.writeFixed64List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 7:
                SchemaUtil.writeFixed32List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 8:
                SchemaUtil.writeBoolList(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 9:
                SchemaUtil.writeUInt32List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 10:
                SchemaUtil.writeSFixed32List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 11:
                SchemaUtil.writeSFixed64List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 12:
                SchemaUtil.writeSInt32List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 13:
                SchemaUtil.writeSInt64List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 14:
                SchemaUtil.writeInt32List(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, extensionDescriptor.isPacked());
                break;
            case 15:
                SchemaUtil.writeBytesList(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer);
                break;
            case 16:
                SchemaUtil.writeStringList(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer);
                break;
            case 17:
                List list = (List) entry.getValue();
                if (list != null && !list.isEmpty()) {
                    SchemaUtil.writeGroupList(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, Protobuf.getInstance().schemaFor((Class) list.get(0).getClass()));
                    break;
                }
                break;
            case 18:
                List list2 = (List) entry.getValue();
                if (list2 != null && !list2.isEmpty()) {
                    SchemaUtil.writeMessageList(extensionDescriptor.getNumber(), (List) entry.getValue(), interfaceC0811Writer, Protobuf.getInstance().schemaFor((Class) list2.get(0).getClass()));
                    break;
                }
                break;
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionSchema
    public void setExtensions(Object obj, FieldSet<GeneratedMessageLite.ExtensionDescriptor> fieldSet) {
        ((GeneratedMessageLite.ExtendableMessage) obj).extensions = fieldSet;
    }
}
