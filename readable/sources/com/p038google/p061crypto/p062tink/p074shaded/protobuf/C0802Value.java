package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0786Struct;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListValue;
import java.io.InputStream;
import java.nio.ByteBuffer;
import org.conscrypt.BuildConfig;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Value */
/* loaded from: classes.dex */
public final class C0802Value extends GeneratedMessageLite<C0802Value, Builder> implements ValueOrBuilder {
    public static final int BOOL_VALUE_FIELD_NUMBER = 4;
    private static final C0802Value DEFAULT_INSTANCE;
    public static final int LIST_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 1;
    public static final int NUMBER_VALUE_FIELD_NUMBER = 2;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<C0802Value> f3811PARSER = null;
    public static final int STRING_VALUE_FIELD_NUMBER = 3;
    public static final int STRUCT_VALUE_FIELD_NUMBER = 5;
    private int kindCase_ = 0;

    /* renamed from: kind_ */
    private Object f3812kind_;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Value$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3813xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3813xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3813xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3813xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3813xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3813xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3813xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3813xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Value$Builder */
    public static final class Builder extends GeneratedMessageLite.AbstractC0753Builder<C0802Value, Builder> implements ValueOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBoolValue() {
            copyOnWrite();
            ((C0802Value) this.instance).clearBoolValue();
            return this;
        }

        public Builder clearKind() {
            copyOnWrite();
            ((C0802Value) this.instance).clearKind();
            return this;
        }

        public Builder clearListValue() {
            copyOnWrite();
            ((C0802Value) this.instance).clearListValue();
            return this;
        }

        public Builder clearNullValue() {
            copyOnWrite();
            ((C0802Value) this.instance).clearNullValue();
            return this;
        }

        public Builder clearNumberValue() {
            copyOnWrite();
            ((C0802Value) this.instance).clearNumberValue();
            return this;
        }

        public Builder clearStringValue() {
            copyOnWrite();
            ((C0802Value) this.instance).clearStringValue();
            return this;
        }

        public Builder clearStructValue() {
            copyOnWrite();
            ((C0802Value) this.instance).clearStructValue();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public boolean getBoolValue() {
            return ((C0802Value) this.instance).getBoolValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public KindCase getKindCase() {
            return ((C0802Value) this.instance).getKindCase();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public ListValue getListValue() {
            return ((C0802Value) this.instance).getListValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public NullValue getNullValue() {
            return ((C0802Value) this.instance).getNullValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public int getNullValueValue() {
            return ((C0802Value) this.instance).getNullValueValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public double getNumberValue() {
            return ((C0802Value) this.instance).getNumberValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public String getStringValue() {
            return ((C0802Value) this.instance).getStringValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public ByteString getStringValueBytes() {
            return ((C0802Value) this.instance).getStringValueBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public C0786Struct getStructValue() {
            return ((C0802Value) this.instance).getStructValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public boolean hasBoolValue() {
            return ((C0802Value) this.instance).hasBoolValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public boolean hasListValue() {
            return ((C0802Value) this.instance).hasListValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public boolean hasNullValue() {
            return ((C0802Value) this.instance).hasNullValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public boolean hasNumberValue() {
            return ((C0802Value) this.instance).hasNumberValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public boolean hasStringValue() {
            return ((C0802Value) this.instance).hasStringValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
        public boolean hasStructValue() {
            return ((C0802Value) this.instance).hasStructValue();
        }

        public Builder mergeListValue(ListValue listValue) {
            copyOnWrite();
            ((C0802Value) this.instance).mergeListValue(listValue);
            return this;
        }

        public Builder mergeStructValue(C0786Struct c0786Struct) {
            copyOnWrite();
            ((C0802Value) this.instance).mergeStructValue(c0786Struct);
            return this;
        }

        public Builder setBoolValue(boolean z) {
            copyOnWrite();
            ((C0802Value) this.instance).setBoolValue(z);
            return this;
        }

        public Builder setListValue(ListValue listValue) {
            copyOnWrite();
            ((C0802Value) this.instance).setListValue(listValue);
            return this;
        }

        public Builder setNullValue(NullValue nullValue) {
            copyOnWrite();
            ((C0802Value) this.instance).setNullValue(nullValue);
            return this;
        }

        public Builder setNullValueValue(int i) {
            copyOnWrite();
            ((C0802Value) this.instance).setNullValueValue(i);
            return this;
        }

        public Builder setNumberValue(double d) {
            copyOnWrite();
            ((C0802Value) this.instance).setNumberValue(d);
            return this;
        }

        public Builder setStringValue(String str) {
            copyOnWrite();
            ((C0802Value) this.instance).setStringValue(str);
            return this;
        }

        public Builder setStringValueBytes(ByteString byteString) {
            copyOnWrite();
            ((C0802Value) this.instance).setStringValueBytes(byteString);
            return this;
        }

        public Builder setStructValue(C0786Struct c0786Struct) {
            copyOnWrite();
            ((C0802Value) this.instance).setStructValue(c0786Struct);
            return this;
        }

        private Builder() {
            super(C0802Value.DEFAULT_INSTANCE);
        }

        public Builder setListValue(ListValue.C0763Builder c0763Builder) {
            copyOnWrite();
            ((C0802Value) this.instance).setListValue(c0763Builder.mo3555build());
            return this;
        }

        public Builder setStructValue(C0786Struct.Builder builder) {
            copyOnWrite();
            ((C0802Value) this.instance).setStructValue(builder.mo3555build());
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Value$KindCase */
    public enum KindCase {
        NULL_VALUE(1),
        NUMBER_VALUE(2),
        STRING_VALUE(3),
        BOOL_VALUE(4),
        STRUCT_VALUE(5),
        LIST_VALUE(6),
        KIND_NOT_SET(0);


        /* renamed from: value */
        private final int f3815value;

        KindCase(int i) {
            this.f3815value = i;
        }

        public static KindCase forNumber(int i) {
            switch (i) {
                case 0:
                    return KIND_NOT_SET;
                case 1:
                    return NULL_VALUE;
                case 2:
                    return NUMBER_VALUE;
                case 3:
                    return STRING_VALUE;
                case 4:
                    return BOOL_VALUE;
                case 5:
                    return STRUCT_VALUE;
                case 6:
                    return LIST_VALUE;
                default:
                    return null;
            }
        }

        public int getNumber() {
            return this.f3815value;
        }

        @Deprecated
        /* renamed from: valueOf */
        public static KindCase m4182valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        C0802Value c0802Value = new C0802Value();
        DEFAULT_INSTANCE = c0802Value;
        GeneratedMessageLite.registerDefaultInstance(C0802Value.class, c0802Value);
    }

    private C0802Value() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearBoolValue() {
        if (this.kindCase_ == 4) {
            this.kindCase_ = 0;
            this.f3812kind_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.kindCase_ = 0;
        this.f3812kind_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearListValue() {
        if (this.kindCase_ == 6) {
            this.kindCase_ = 0;
            this.f3812kind_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNullValue() {
        if (this.kindCase_ == 1) {
            this.kindCase_ = 0;
            this.f3812kind_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumberValue() {
        if (this.kindCase_ == 2) {
            this.kindCase_ = 0;
            this.f3812kind_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStringValue() {
        if (this.kindCase_ == 3) {
            this.kindCase_ = 0;
            this.f3812kind_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearStructValue() {
        if (this.kindCase_ == 5) {
            this.kindCase_ = 0;
            this.f3812kind_ = null;
        }
    }

    public static C0802Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeListValue(ListValue listValue) {
        listValue.getClass();
        if (this.kindCase_ != 6 || this.f3812kind_ == ListValue.getDefaultInstance()) {
            this.f3812kind_ = listValue;
        } else {
            this.f3812kind_ = ListValue.newBuilder((ListValue) this.f3812kind_).mergeFrom((ListValue.C0763Builder) listValue).buildPartial();
        }
        this.kindCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mergeStructValue(C0786Struct c0786Struct) {
        c0786Struct.getClass();
        if (this.kindCase_ != 5 || this.f3812kind_ == C0786Struct.getDefaultInstance()) {
            this.f3812kind_ = c0786Struct;
        } else {
            this.f3812kind_ = C0786Struct.newBuilder((C0786Struct) this.f3812kind_).mergeFrom((C0786Struct.Builder) c0786Struct).buildPartial();
        }
        this.kindCase_ = 5;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static C0802Value parseDelimitedFrom(InputStream inputStream) {
        return (C0802Value) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0802Value parseFrom(ByteBuffer byteBuffer) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<C0802Value> m4181parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBoolValue(boolean z) {
        this.kindCase_ = 4;
        this.f3812kind_ = Boolean.valueOf(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setListValue(ListValue listValue) {
        listValue.getClass();
        this.f3812kind_ = listValue;
        this.kindCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNullValue(NullValue nullValue) {
        this.f3812kind_ = Integer.valueOf(nullValue.getNumber());
        this.kindCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNullValueValue(int i) {
        this.kindCase_ = 1;
        this.f3812kind_ = Integer.valueOf(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumberValue(double d) {
        this.kindCase_ = 2;
        this.f3812kind_ = Double.valueOf(d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStringValue(String str) {
        str.getClass();
        this.kindCase_ = 3;
        this.f3812kind_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStringValueBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3812kind_ = byteString.toStringUtf8();
        this.kindCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setStructValue(C0786Struct c0786Struct) {
        c0786Struct.getClass();
        this.f3812kind_ = c0786Struct;
        this.kindCase_ = 5;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = AnonymousClass1.f3813xa1df5c61[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new C0802Value();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001?\u0000\u00023\u0000\u0003Ȼ\u0000\u0004:\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"kind_", "kindCase_", C0786Struct.class, ListValue.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<C0802Value> defaultInstanceBasedParser = f3811PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (C0802Value.class) {
                        try {
                            defaultInstanceBasedParser = f3811PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3811PARSER = defaultInstanceBasedParser;
                            }
                        } finally {
                        }
                    }
                }
                return defaultInstanceBasedParser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public boolean getBoolValue() {
        if (this.kindCase_ == 4) {
            return ((Boolean) this.f3812kind_).booleanValue();
        }
        return false;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public KindCase getKindCase() {
        return KindCase.forNumber(this.kindCase_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public ListValue getListValue() {
        return this.kindCase_ == 6 ? (ListValue) this.f3812kind_ : ListValue.getDefaultInstance();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public NullValue getNullValue() {
        if (this.kindCase_ != 1) {
            return NullValue.NULL_VALUE;
        }
        NullValue nullValueForNumber = NullValue.forNumber(((Integer) this.f3812kind_).intValue());
        return nullValueForNumber == null ? NullValue.UNRECOGNIZED : nullValueForNumber;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public int getNullValueValue() {
        if (this.kindCase_ == 1) {
            return ((Integer) this.f3812kind_).intValue();
        }
        return 0;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public double getNumberValue() {
        if (this.kindCase_ == 2) {
            return ((Double) this.f3812kind_).doubleValue();
        }
        return 0.0d;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public String getStringValue() {
        return this.kindCase_ == 3 ? (String) this.f3812kind_ : BuildConfig.f24315FLAVOR;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public ByteString getStringValueBytes() {
        return ByteString.copyFromUtf8(this.kindCase_ == 3 ? (String) this.f3812kind_ : BuildConfig.f24315FLAVOR);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public C0786Struct getStructValue() {
        return this.kindCase_ == 5 ? (C0786Struct) this.f3812kind_ : C0786Struct.getDefaultInstance();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public boolean hasBoolValue() {
        return this.kindCase_ == 4;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public boolean hasListValue() {
        return this.kindCase_ == 6;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public boolean hasNullValue() {
        return this.kindCase_ == 1;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public boolean hasNumberValue() {
        return this.kindCase_ == 2;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public boolean hasStringValue() {
        return this.kindCase_ == 3;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ValueOrBuilder
    public boolean hasStructValue() {
        return this.kindCase_ == 5;
    }

    public static Builder newBuilder(C0802Value c0802Value) {
        return DEFAULT_INSTANCE.createBuilder(c0802Value);
    }

    public static C0802Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0802Value) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0802Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static C0802Value parseFrom(ByteString byteString) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static C0802Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static C0802Value parseFrom(byte[] bArr) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static C0802Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static C0802Value parseFrom(InputStream inputStream) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0802Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0802Value parseFrom(CodedInputStream codedInputStream) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static C0802Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0802Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
