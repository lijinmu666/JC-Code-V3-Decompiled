package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0773Option;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Field */
/* loaded from: classes.dex */
public final class C0742Field extends GeneratedMessageLite<C0742Field, Builder> implements FieldOrBuilder {
    public static final int CARDINALITY_FIELD_NUMBER = 2;
    private static final C0742Field DEFAULT_INSTANCE;
    public static final int DEFAULT_VALUE_FIELD_NUMBER = 11;
    public static final int JSON_NAME_FIELD_NUMBER = 10;
    public static final int KIND_FIELD_NUMBER = 1;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int NUMBER_FIELD_NUMBER = 3;
    public static final int ONEOF_INDEX_FIELD_NUMBER = 7;
    public static final int OPTIONS_FIELD_NUMBER = 9;
    public static final int PACKED_FIELD_NUMBER = 8;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<C0742Field> f3626PARSER = null;
    public static final int TYPE_URL_FIELD_NUMBER = 6;
    private int cardinality_;

    /* renamed from: kind_ */
    private int f3627kind_;

    /* renamed from: number_ */
    private int f3629number_;
    private int oneofIndex_;

    /* renamed from: packed_ */
    private boolean f3630packed_;

    /* renamed from: name_ */
    private String f3628name_ = BuildConfig.f24315FLAVOR;
    private String typeUrl_ = BuildConfig.f24315FLAVOR;
    private Internal.ProtobufList<C0773Option> options_ = GeneratedMessageLite.emptyProtobufList();
    private String jsonName_ = BuildConfig.f24315FLAVOR;
    private String defaultValue_ = BuildConfig.f24315FLAVOR;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Field$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3631xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3631xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3631xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3631xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3631xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3631xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3631xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3631xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Field$Builder */
    public static final class Builder extends GeneratedMessageLite.AbstractC0753Builder<C0742Field, Builder> implements FieldOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllOptions(Iterable<? extends C0773Option> iterable) {
            copyOnWrite();
            ((C0742Field) this.instance).addAllOptions(iterable);
            return this;
        }

        public Builder addOptions(C0773Option c0773Option) {
            copyOnWrite();
            ((C0742Field) this.instance).addOptions(c0773Option);
            return this;
        }

        public Builder clearCardinality() {
            copyOnWrite();
            ((C0742Field) this.instance).clearCardinality();
            return this;
        }

        public Builder clearDefaultValue() {
            copyOnWrite();
            ((C0742Field) this.instance).clearDefaultValue();
            return this;
        }

        public Builder clearJsonName() {
            copyOnWrite();
            ((C0742Field) this.instance).clearJsonName();
            return this;
        }

        public Builder clearKind() {
            copyOnWrite();
            ((C0742Field) this.instance).clearKind();
            return this;
        }

        public Builder clearName() {
            copyOnWrite();
            ((C0742Field) this.instance).clearName();
            return this;
        }

        public Builder clearNumber() {
            copyOnWrite();
            ((C0742Field) this.instance).clearNumber();
            return this;
        }

        public Builder clearOneofIndex() {
            copyOnWrite();
            ((C0742Field) this.instance).clearOneofIndex();
            return this;
        }

        public Builder clearOptions() {
            copyOnWrite();
            ((C0742Field) this.instance).clearOptions();
            return this;
        }

        public Builder clearPacked() {
            copyOnWrite();
            ((C0742Field) this.instance).clearPacked();
            return this;
        }

        public Builder clearTypeUrl() {
            copyOnWrite();
            ((C0742Field) this.instance).clearTypeUrl();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public Cardinality getCardinality() {
            return ((C0742Field) this.instance).getCardinality();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public int getCardinalityValue() {
            return ((C0742Field) this.instance).getCardinalityValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public String getDefaultValue() {
            return ((C0742Field) this.instance).getDefaultValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public ByteString getDefaultValueBytes() {
            return ((C0742Field) this.instance).getDefaultValueBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public String getJsonName() {
            return ((C0742Field) this.instance).getJsonName();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public ByteString getJsonNameBytes() {
            return ((C0742Field) this.instance).getJsonNameBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        /* renamed from: getKind */
        public Kind mo3991getKind() {
            return ((C0742Field) this.instance).mo3991getKind();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public int getKindValue() {
            return ((C0742Field) this.instance).getKindValue();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        /* renamed from: getName */
        public String mo3992getName() {
            return ((C0742Field) this.instance).mo3992getName();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public ByteString getNameBytes() {
            return ((C0742Field) this.instance).getNameBytes();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public int getNumber() {
            return ((C0742Field) this.instance).getNumber();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public int getOneofIndex() {
            return ((C0742Field) this.instance).getOneofIndex();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public C0773Option getOptions(int i) {
            return ((C0742Field) this.instance).getOptions(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public int getOptionsCount() {
            return ((C0742Field) this.instance).getOptionsCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public List<C0773Option> getOptionsList() {
            return Collections.unmodifiableList(((C0742Field) this.instance).getOptionsList());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public boolean getPacked() {
            return ((C0742Field) this.instance).getPacked();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public String getTypeUrl() {
            return ((C0742Field) this.instance).getTypeUrl();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
        public ByteString getTypeUrlBytes() {
            return ((C0742Field) this.instance).getTypeUrlBytes();
        }

        public Builder removeOptions(int i) {
            copyOnWrite();
            ((C0742Field) this.instance).removeOptions(i);
            return this;
        }

        public Builder setCardinality(Cardinality cardinality) {
            copyOnWrite();
            ((C0742Field) this.instance).setCardinality(cardinality);
            return this;
        }

        public Builder setCardinalityValue(int i) {
            copyOnWrite();
            ((C0742Field) this.instance).setCardinalityValue(i);
            return this;
        }

        public Builder setDefaultValue(String str) {
            copyOnWrite();
            ((C0742Field) this.instance).setDefaultValue(str);
            return this;
        }

        public Builder setDefaultValueBytes(ByteString byteString) {
            copyOnWrite();
            ((C0742Field) this.instance).setDefaultValueBytes(byteString);
            return this;
        }

        public Builder setJsonName(String str) {
            copyOnWrite();
            ((C0742Field) this.instance).setJsonName(str);
            return this;
        }

        public Builder setJsonNameBytes(ByteString byteString) {
            copyOnWrite();
            ((C0742Field) this.instance).setJsonNameBytes(byteString);
            return this;
        }

        /* renamed from: setKind */
        public Builder m3993setKind(Kind kind) {
            copyOnWrite();
            ((C0742Field) this.instance).m3989setKind(kind);
            return this;
        }

        public Builder setKindValue(int i) {
            copyOnWrite();
            ((C0742Field) this.instance).setKindValue(i);
            return this;
        }

        /* renamed from: setName */
        public Builder m3994setName(String str) {
            copyOnWrite();
            ((C0742Field) this.instance).m3990setName(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            copyOnWrite();
            ((C0742Field) this.instance).setNameBytes(byteString);
            return this;
        }

        public Builder setNumber(int i) {
            copyOnWrite();
            ((C0742Field) this.instance).setNumber(i);
            return this;
        }

        public Builder setOneofIndex(int i) {
            copyOnWrite();
            ((C0742Field) this.instance).setOneofIndex(i);
            return this;
        }

        public Builder setOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0742Field) this.instance).setOptions(i, c0773Option);
            return this;
        }

        public Builder setPacked(boolean z) {
            copyOnWrite();
            ((C0742Field) this.instance).setPacked(z);
            return this;
        }

        public Builder setTypeUrl(String str) {
            copyOnWrite();
            ((C0742Field) this.instance).setTypeUrl(str);
            return this;
        }

        public Builder setTypeUrlBytes(ByteString byteString) {
            copyOnWrite();
            ((C0742Field) this.instance).setTypeUrlBytes(byteString);
            return this;
        }

        private Builder() {
            super(C0742Field.DEFAULT_INSTANCE);
        }

        public Builder addOptions(int i, C0773Option c0773Option) {
            copyOnWrite();
            ((C0742Field) this.instance).addOptions(i, c0773Option);
            return this;
        }

        public Builder setOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0742Field) this.instance).setOptions(i, builder.mo3555build());
            return this;
        }

        public Builder addOptions(C0773Option.Builder builder) {
            copyOnWrite();
            ((C0742Field) this.instance).addOptions(builder.mo3555build());
            return this;
        }

        public Builder addOptions(int i, C0773Option.Builder builder) {
            copyOnWrite();
            ((C0742Field) this.instance).addOptions(i, builder.mo3555build());
            return this;
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Field$Cardinality */
    public enum Cardinality implements Internal.EnumLite {
        CARDINALITY_UNKNOWN(0),
        CARDINALITY_OPTIONAL(1),
        CARDINALITY_REQUIRED(2),
        CARDINALITY_REPEATED(3),
        UNRECOGNIZED(-1);

        public static final int CARDINALITY_OPTIONAL_VALUE = 1;
        public static final int CARDINALITY_REPEATED_VALUE = 3;
        public static final int CARDINALITY_REQUIRED_VALUE = 2;
        public static final int CARDINALITY_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Cardinality> internalValueMap = new Internal.EnumLiteMap<Cardinality>() { // from class: com.google.crypto.tink.shaded.protobuf.Field.Cardinality.1
            @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
            public Cardinality findValueByNumber(int i) {
                return Cardinality.forNumber(i);
            }
        };

        /* renamed from: value */
        private final int f3633value;

        /* renamed from: com.google.crypto.tink.shaded.protobuf.Field$Cardinality$CardinalityVerifier */
        public static final class CardinalityVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new CardinalityVerifier();

            private CardinalityVerifier() {
            }

            @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Cardinality.forNumber(i) != null;
            }
        }

        Cardinality(int i) {
            this.f3633value = i;
        }

        public static Cardinality forNumber(int i) {
            if (i == 0) {
                return CARDINALITY_UNKNOWN;
            }
            if (i == 1) {
                return CARDINALITY_OPTIONAL;
            }
            if (i == 2) {
                return CARDINALITY_REQUIRED;
            }
            if (i != 3) {
                return null;
            }
            return CARDINALITY_REPEATED;
        }

        public static Internal.EnumLiteMap<Cardinality> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return CardinalityVerifier.INSTANCE;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.f3633value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        /* renamed from: valueOf */
        public static Cardinality m3995valueOf(int i) {
            return forNumber(i);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Field$Kind */
    public enum Kind implements Internal.EnumLite {
        TYPE_UNKNOWN(0),
        TYPE_DOUBLE(1),
        TYPE_FLOAT(2),
        TYPE_INT64(3),
        TYPE_UINT64(4),
        TYPE_INT32(5),
        TYPE_FIXED64(6),
        TYPE_FIXED32(7),
        TYPE_BOOL(8),
        TYPE_STRING(9),
        TYPE_GROUP(10),
        TYPE_MESSAGE(11),
        TYPE_BYTES(12),
        TYPE_UINT32(13),
        TYPE_ENUM(14),
        TYPE_SFIXED32(15),
        TYPE_SFIXED64(16),
        TYPE_SINT32(17),
        TYPE_SINT64(18),
        UNRECOGNIZED(-1);

        public static final int TYPE_BOOL_VALUE = 8;
        public static final int TYPE_BYTES_VALUE = 12;
        public static final int TYPE_DOUBLE_VALUE = 1;
        public static final int TYPE_ENUM_VALUE = 14;
        public static final int TYPE_FIXED32_VALUE = 7;
        public static final int TYPE_FIXED64_VALUE = 6;
        public static final int TYPE_FLOAT_VALUE = 2;
        public static final int TYPE_GROUP_VALUE = 10;
        public static final int TYPE_INT32_VALUE = 5;
        public static final int TYPE_INT64_VALUE = 3;
        public static final int TYPE_MESSAGE_VALUE = 11;
        public static final int TYPE_SFIXED32_VALUE = 15;
        public static final int TYPE_SFIXED64_VALUE = 16;
        public static final int TYPE_SINT32_VALUE = 17;
        public static final int TYPE_SINT64_VALUE = 18;
        public static final int TYPE_STRING_VALUE = 9;
        public static final int TYPE_UINT32_VALUE = 13;
        public static final int TYPE_UINT64_VALUE = 4;
        public static final int TYPE_UNKNOWN_VALUE = 0;
        private static final Internal.EnumLiteMap<Kind> internalValueMap = new Internal.EnumLiteMap<Kind>() { // from class: com.google.crypto.tink.shaded.protobuf.Field.Kind.1
            @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
            public Kind findValueByNumber(int i) {
                return Kind.forNumber(i);
            }
        };

        /* renamed from: value */
        private final int f3635value;

        /* renamed from: com.google.crypto.tink.shaded.protobuf.Field$Kind$KindVerifier */
        public static final class KindVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new KindVerifier();

            private KindVerifier() {
            }

            @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i) {
                return Kind.forNumber(i) != null;
            }
        }

        Kind(int i) {
            this.f3635value = i;
        }

        public static Kind forNumber(int i) {
            switch (i) {
                case 0:
                    return TYPE_UNKNOWN;
                case 1:
                    return TYPE_DOUBLE;
                case 2:
                    return TYPE_FLOAT;
                case 3:
                    return TYPE_INT64;
                case 4:
                    return TYPE_UINT64;
                case 5:
                    return TYPE_INT32;
                case 6:
                    return TYPE_FIXED64;
                case 7:
                    return TYPE_FIXED32;
                case 8:
                    return TYPE_BOOL;
                case 9:
                    return TYPE_STRING;
                case 10:
                    return TYPE_GROUP;
                case 11:
                    return TYPE_MESSAGE;
                case 12:
                    return TYPE_BYTES;
                case 13:
                    return TYPE_UINT32;
                case 14:
                    return TYPE_ENUM;
                case 15:
                    return TYPE_SFIXED32;
                case 16:
                    return TYPE_SFIXED64;
                case 17:
                    return TYPE_SINT32;
                case 18:
                    return TYPE_SINT64;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<Kind> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return KindVerifier.INSTANCE;
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.f3635value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        /* renamed from: valueOf */
        public static Kind m3998valueOf(int i) {
            return forNumber(i);
        }
    }

    static {
        C0742Field c0742Field = new C0742Field();
        DEFAULT_INSTANCE = c0742Field;
        GeneratedMessageLite.registerDefaultInstance(C0742Field.class, c0742Field);
    }

    private C0742Field() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllOptions(Iterable<? extends C0773Option> iterable) {
        ensureOptionsIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.options_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(c0773Option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCardinality() {
        this.cardinality_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearDefaultValue() {
        this.defaultValue_ = getDefaultInstance().getDefaultValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearJsonName() {
        this.jsonName_ = getDefaultInstance().getJsonName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearKind() {
        this.f3627kind_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearName() {
        this.f3628name_ = getDefaultInstance().mo3992getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearNumber() {
        this.f3629number_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOneofIndex() {
        this.oneofIndex_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearOptions() {
        this.options_ = GeneratedMessageLite.emptyProtobufList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearPacked() {
        this.f3630packed_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearTypeUrl() {
        this.typeUrl_ = getDefaultInstance().getTypeUrl();
    }

    private void ensureOptionsIsMutable() {
        Internal.ProtobufList<C0773Option> protobufList = this.options_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.options_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static C0742Field getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static C0742Field parseDelimitedFrom(InputStream inputStream) {
        return (C0742Field) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0742Field parseFrom(ByteBuffer byteBuffer) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<C0742Field> m3988parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeOptions(int i) {
        ensureOptionsIsMutable();
        this.options_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardinality(Cardinality cardinality) {
        this.cardinality_ = cardinality.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCardinalityValue(int i) {
        this.cardinality_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultValue(String str) {
        str.getClass();
        this.defaultValue_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDefaultValueBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.defaultValue_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJsonName(String str) {
        str.getClass();
        this.jsonName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setJsonNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.jsonName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setKind */
    public void m3989setKind(Kind kind) {
        this.f3627kind_ = kind.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKindValue(int i) {
        this.f3627kind_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: setName */
    public void m3990setName(String str) {
        str.getClass();
        this.f3628name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNameBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.f3628name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNumber(int i) {
        this.f3629number_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOneofIndex(int i) {
        this.oneofIndex_ = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.set(i, c0773Option);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPacked(boolean z) {
        this.f3630packed_ = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrl(String str) {
        str.getClass();
        this.typeUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTypeUrlBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.typeUrl_ = byteString.toStringUtf8();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = AnonymousClass1.f3631xa1df5c61[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new C0742Field();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\n\u0000\u0000\u0001\u000b\n\u0000\u0001\u0000\u0001\f\u0002\f\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\u0004\b\u0007\t\u001b\nȈ\u000bȈ", new Object[]{"kind_", "cardinality_", "number_", "name_", "typeUrl_", "oneofIndex_", "packed_", "options_", C0773Option.class, "jsonName_", "defaultValue_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<C0742Field> defaultInstanceBasedParser = f3626PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (C0742Field.class) {
                        try {
                            defaultInstanceBasedParser = f3626PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3626PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public Cardinality getCardinality() {
        Cardinality cardinalityForNumber = Cardinality.forNumber(this.cardinality_);
        return cardinalityForNumber == null ? Cardinality.UNRECOGNIZED : cardinalityForNumber;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public int getCardinalityValue() {
        return this.cardinality_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public String getDefaultValue() {
        return this.defaultValue_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public ByteString getDefaultValueBytes() {
        return ByteString.copyFromUtf8(this.defaultValue_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public String getJsonName() {
        return this.jsonName_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public ByteString getJsonNameBytes() {
        return ByteString.copyFromUtf8(this.jsonName_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    /* renamed from: getKind */
    public Kind mo3991getKind() {
        Kind kindForNumber = Kind.forNumber(this.f3627kind_);
        return kindForNumber == null ? Kind.UNRECOGNIZED : kindForNumber;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public int getKindValue() {
        return this.f3627kind_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    /* renamed from: getName */
    public String mo3992getName() {
        return this.f3628name_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.f3628name_);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public int getNumber() {
        return this.f3629number_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public int getOneofIndex() {
        return this.oneofIndex_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public C0773Option getOptions(int i) {
        return this.options_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public int getOptionsCount() {
        return this.options_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public List<C0773Option> getOptionsList() {
        return this.options_;
    }

    public OptionOrBuilder getOptionsOrBuilder(int i) {
        return this.options_.get(i);
    }

    public List<? extends OptionOrBuilder> getOptionsOrBuilderList() {
        return this.options_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public boolean getPacked() {
        return this.f3630packed_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public String getTypeUrl() {
        return this.typeUrl_;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.FieldOrBuilder
    public ByteString getTypeUrlBytes() {
        return ByteString.copyFromUtf8(this.typeUrl_);
    }

    public static Builder newBuilder(C0742Field c0742Field) {
        return DEFAULT_INSTANCE.createBuilder(c0742Field);
    }

    public static C0742Field parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0742Field) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0742Field parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static C0742Field parseFrom(ByteString byteString) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addOptions(int i, C0773Option c0773Option) {
        c0773Option.getClass();
        ensureOptionsIsMutable();
        this.options_.add(i, c0773Option);
    }

    public static C0742Field parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static C0742Field parseFrom(byte[] bArr) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static C0742Field parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static C0742Field parseFrom(InputStream inputStream) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0742Field parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0742Field parseFrom(CodedInputStream codedInputStream) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static C0742Field parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0742Field) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
