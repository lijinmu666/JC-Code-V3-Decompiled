package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class WireFormat {
    static final int FIXED32_SIZE = 4;
    static final int FIXED64_SIZE = 8;
    static final int MAX_VARINT32_SIZE = 5;
    static final int MAX_VARINT64_SIZE = 10;
    static final int MAX_VARINT_SIZE = 10;
    static final int MESSAGE_SET_ITEM = 1;
    static final int MESSAGE_SET_MESSAGE = 3;
    static final int MESSAGE_SET_TYPE_ID = 2;
    static final int TAG_TYPE_BITS = 3;
    static final int TAG_TYPE_MASK = 7;
    public static final int WIRETYPE_END_GROUP = 4;
    public static final int WIRETYPE_FIXED32 = 5;
    public static final int WIRETYPE_FIXED64 = 1;
    public static final int WIRETYPE_LENGTH_DELIMITED = 2;
    public static final int WIRETYPE_START_GROUP = 3;
    public static final int WIRETYPE_VARINT = 0;
    static final int MESSAGE_SET_ITEM_TAG = m4185makeTag(1, 3);
    static final int MESSAGE_SET_ITEM_END_TAG = m4185makeTag(1, 4);
    static final int MESSAGE_SET_TYPE_ID_TAG = m4185makeTag(2, 0);
    static final int MESSAGE_SET_MESSAGE_TAG = m4185makeTag(3, 2);

    /* renamed from: com.google.crypto.tink.shaded.protobuf.WireFormat$1 */
    public static /* synthetic */ class C08031 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[FieldType.m4187values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[FieldType.f3819DOUBLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3823FLOAT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3826INT64.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3832UINT64.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3825INT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3822FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3821FIXED32.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3817BOOL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3818BYTES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3831UINT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.SFIXED64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3828SINT32.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3829SINT64.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3830STRING.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3824GROUP.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3827MESSAGE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[FieldType.f3820ENUM.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'INT64' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public static class FieldType {

        /* renamed from: $VALUES */
        private static final /* synthetic */ FieldType[] f3816$VALUES;

        /* renamed from: BOOL */
        public static final FieldType f3817BOOL;

        /* renamed from: BYTES */
        public static final FieldType f3818BYTES;

        /* renamed from: DOUBLE */
        public static final FieldType f3819DOUBLE;

        /* renamed from: ENUM */
        public static final FieldType f3820ENUM;

        /* renamed from: FIXED32 */
        public static final FieldType f3821FIXED32;

        /* renamed from: FIXED64 */
        public static final FieldType f3822FIXED64;

        /* renamed from: FLOAT */
        public static final FieldType f3823FLOAT;

        /* renamed from: GROUP */
        public static final FieldType f3824GROUP;

        /* renamed from: INT32 */
        public static final FieldType f3825INT32;

        /* renamed from: INT64 */
        public static final FieldType f3826INT64;

        /* renamed from: MESSAGE */
        public static final FieldType f3827MESSAGE;
        public static final FieldType SFIXED32;
        public static final FieldType SFIXED64;

        /* renamed from: SINT32 */
        public static final FieldType f3828SINT32;

        /* renamed from: SINT64 */
        public static final FieldType f3829SINT64;

        /* renamed from: STRING */
        public static final FieldType f3830STRING;

        /* renamed from: UINT32 */
        public static final FieldType f3831UINT32;

        /* renamed from: UINT64 */
        public static final FieldType f3832UINT64;
        private final JavaType javaType;
        private final int wireType;

        static {
            FieldType fieldType = new FieldType("DOUBLE", 0, JavaType.DOUBLE, 1);
            f3819DOUBLE = fieldType;
            FieldType fieldType2 = new FieldType("FLOAT", 1, JavaType.FLOAT, 5);
            f3823FLOAT = fieldType2;
            JavaType javaType = JavaType.LONG;
            FieldType fieldType3 = new FieldType("INT64", 2, javaType, 0);
            f3826INT64 = fieldType3;
            FieldType fieldType4 = new FieldType("UINT64", 3, javaType, 0);
            f3832UINT64 = fieldType4;
            JavaType javaType2 = JavaType.INT;
            FieldType fieldType5 = new FieldType("INT32", 4, javaType2, 0);
            f3825INT32 = fieldType5;
            FieldType fieldType6 = new FieldType("FIXED64", 5, javaType, 1);
            f3822FIXED64 = fieldType6;
            FieldType fieldType7 = new FieldType("FIXED32", 6, javaType2, 5);
            f3821FIXED32 = fieldType7;
            FieldType fieldType8 = new FieldType("BOOL", 7, JavaType.BOOLEAN, 0);
            f3817BOOL = fieldType8;
            FieldType fieldType9 = new FieldType("STRING", 8, JavaType.STRING, 2) { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.1
                {
                    C08031 c08031 = null;
                }

                @Override // com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            f3830STRING = fieldType9;
            JavaType javaType3 = JavaType.MESSAGE;
            FieldType fieldType10 = new FieldType("GROUP", 9, javaType3, 3) { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.2
                {
                    C08031 c08031 = null;
                }

                @Override // com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            f3824GROUP = fieldType10;
            int i = 2;
            FieldType fieldType11 = new FieldType("MESSAGE", 10, javaType3, i) { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.3
                {
                    C08031 c08031 = null;
                }

                @Override // com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            f3827MESSAGE = fieldType11;
            FieldType fieldType12 = new FieldType("BYTES", 11, JavaType.BYTE_STRING, i) { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType.4
                {
                    C08031 c08031 = null;
                }

                @Override // com.google.crypto.tink.shaded.protobuf.WireFormat.FieldType
                public boolean isPackable() {
                    return false;
                }
            };
            f3818BYTES = fieldType12;
            FieldType fieldType13 = new FieldType("UINT32", 12, javaType2, 0);
            f3831UINT32 = fieldType13;
            FieldType fieldType14 = new FieldType("ENUM", 13, JavaType.ENUM, 0);
            f3820ENUM = fieldType14;
            FieldType fieldType15 = new FieldType("SFIXED32", 14, javaType2, 5);
            SFIXED32 = fieldType15;
            FieldType fieldType16 = new FieldType("SFIXED64", 15, javaType, 1);
            SFIXED64 = fieldType16;
            FieldType fieldType17 = new FieldType("SINT32", 16, javaType2, 0);
            f3828SINT32 = fieldType17;
            FieldType fieldType18 = new FieldType("SINT64", 17, javaType, 0);
            f3829SINT64 = fieldType18;
            f3816$VALUES = new FieldType[]{fieldType, fieldType2, fieldType3, fieldType4, fieldType5, fieldType6, fieldType7, fieldType8, fieldType9, fieldType10, fieldType11, fieldType12, fieldType13, fieldType14, fieldType15, fieldType16, fieldType17, fieldType18};
        }

        public /* synthetic */ FieldType(String str, int i, JavaType javaType, int i2, C08031 c08031) {
            this(str, i, javaType, i2);
        }

        /* renamed from: valueOf */
        public static FieldType m4186valueOf(String str) {
            return (FieldType) Enum.valueOf(FieldType.class, str);
        }

        /* renamed from: values */
        public static FieldType[] m4187values() {
            return (FieldType[]) f3816$VALUES.clone();
        }

        public JavaType getJavaType() {
            return this.javaType;
        }

        public int getWireType() {
            return this.wireType;
        }

        public boolean isPackable() {
            return true;
        }

        private FieldType(String str, int i, JavaType javaType, int i2) {
            this.javaType = javaType;
            this.wireType = i2;
        }
    }

    public enum JavaType {
        INT(0),
        LONG(0L),
        FLOAT(Float.valueOf(0.0f)),
        DOUBLE(Double.valueOf(0.0d)),
        BOOLEAN(Boolean.FALSE),
        STRING(BuildConfig.f24315FLAVOR),
        BYTE_STRING(ByteString.f3559EMPTY),
        ENUM(null),
        MESSAGE(null);

        private final Object defaultDefault;

        JavaType(Object obj) {
            this.defaultDefault = obj;
        }

        public Object getDefaultDefault() {
            return this.defaultDefault;
        }
    }

    public enum Utf8Validation {
        LOOSE { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.Utf8Validation.1
            @Override // com.google.crypto.tink.shaded.protobuf.WireFormat.Utf8Validation
            public Object readString(CodedInputStream codedInputStream) {
                return codedInputStream.readString();
            }
        },
        STRICT { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.Utf8Validation.2
            @Override // com.google.crypto.tink.shaded.protobuf.WireFormat.Utf8Validation
            public Object readString(CodedInputStream codedInputStream) {
                return codedInputStream.readStringRequireUtf8();
            }
        },
        LAZY { // from class: com.google.crypto.tink.shaded.protobuf.WireFormat.Utf8Validation.3
            @Override // com.google.crypto.tink.shaded.protobuf.WireFormat.Utf8Validation
            public Object readString(CodedInputStream codedInputStream) {
                return codedInputStream.readBytes();
            }
        };

        public abstract Object readString(CodedInputStream codedInputStream);

        /* synthetic */ Utf8Validation(C08031 c08031) {
            this();
        }
    }

    private WireFormat() {
    }

    public static int getTagFieldNumber(int i) {
        return i >>> 3;
    }

    public static int getTagWireType(int i) {
        return i & 7;
    }

    /* renamed from: makeTag */
    public static int m4185makeTag(int i, int i2) {
        return (i << 3) | i2;
    }

    public static Object readPrimitiveField(CodedInputStream codedInputStream, FieldType fieldType, Utf8Validation utf8Validation) {
        switch (C08031.$SwitchMap$com$google$protobuf$WireFormat$FieldType[fieldType.ordinal()]) {
            case 1:
                return Double.valueOf(codedInputStream.readDouble());
            case 2:
                return Float.valueOf(codedInputStream.readFloat());
            case 3:
                return Long.valueOf(codedInputStream.readInt64());
            case 4:
                return Long.valueOf(codedInputStream.readUInt64());
            case 5:
                return Integer.valueOf(codedInputStream.readInt32());
            case 6:
                return Long.valueOf(codedInputStream.readFixed64());
            case 7:
                return Integer.valueOf(codedInputStream.readFixed32());
            case 8:
                return Boolean.valueOf(codedInputStream.readBool());
            case 9:
                return codedInputStream.readBytes();
            case 10:
                return Integer.valueOf(codedInputStream.readUInt32());
            case 11:
                return Integer.valueOf(codedInputStream.readSFixed32());
            case 12:
                return Long.valueOf(codedInputStream.readSFixed64());
            case 13:
                return Integer.valueOf(codedInputStream.readSInt32());
            case 14:
                return Long.valueOf(codedInputStream.readSInt64());
            case 15:
                return utf8Validation.readString(codedInputStream);
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }
}
