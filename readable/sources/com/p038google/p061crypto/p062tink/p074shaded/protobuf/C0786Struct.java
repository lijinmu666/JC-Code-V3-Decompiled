package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.WireFormat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Struct */
/* loaded from: classes.dex */
public final class C0786Struct extends GeneratedMessageLite<C0786Struct, Builder> implements StructOrBuilder {
    private static final C0786Struct DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 1;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<C0786Struct> f3776PARSER;

    /* renamed from: fields_ */
    private MapFieldLite<String, C0802Value> f3777fields_ = MapFieldLite.emptyMapField();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Struct$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3778xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3778xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3778xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3778xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3778xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3778xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3778xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3778xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Struct$Builder */
    public static final class Builder extends GeneratedMessageLite.AbstractC0753Builder<C0786Struct, Builder> implements StructOrBuilder {
        public /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFields() {
            copyOnWrite();
            ((C0786Struct) this.instance).getMutableFieldsMap().clear();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
        public boolean containsFields(String str) {
            str.getClass();
            return ((C0786Struct) this.instance).getFieldsMap().containsKey(str);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
        @Deprecated
        public Map<String, C0802Value> getFields() {
            return getFieldsMap();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
        public int getFieldsCount() {
            return ((C0786Struct) this.instance).getFieldsMap().size();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
        public Map<String, C0802Value> getFieldsMap() {
            return Collections.unmodifiableMap(((C0786Struct) this.instance).getFieldsMap());
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
        public C0802Value getFieldsOrDefault(String str, C0802Value c0802Value) {
            str.getClass();
            Map<String, C0802Value> fieldsMap = ((C0786Struct) this.instance).getFieldsMap();
            return fieldsMap.containsKey(str) ? fieldsMap.get(str) : c0802Value;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
        public C0802Value getFieldsOrThrow(String str) {
            str.getClass();
            Map<String, C0802Value> fieldsMap = ((C0786Struct) this.instance).getFieldsMap();
            if (fieldsMap.containsKey(str)) {
                return fieldsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        public Builder putAllFields(Map<String, C0802Value> map) {
            copyOnWrite();
            ((C0786Struct) this.instance).getMutableFieldsMap().putAll(map);
            return this;
        }

        public Builder putFields(String str, C0802Value c0802Value) {
            str.getClass();
            c0802Value.getClass();
            copyOnWrite();
            ((C0786Struct) this.instance).getMutableFieldsMap().put(str, c0802Value);
            return this;
        }

        public Builder removeFields(String str) {
            str.getClass();
            copyOnWrite();
            ((C0786Struct) this.instance).getMutableFieldsMap().remove(str);
            return this;
        }

        private Builder() {
            super(C0786Struct.DEFAULT_INSTANCE);
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Struct$FieldsDefaultEntryHolder */
    public static final class FieldsDefaultEntryHolder {
        static final MapEntryLite<String, C0802Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.f3830STRING, BuildConfig.f24315FLAVOR, WireFormat.FieldType.f3827MESSAGE, C0802Value.getDefaultInstance());

        private FieldsDefaultEntryHolder() {
        }
    }

    static {
        C0786Struct c0786Struct = new C0786Struct();
        DEFAULT_INSTANCE = c0786Struct;
        GeneratedMessageLite.registerDefaultInstance(C0786Struct.class, c0786Struct);
    }

    private C0786Struct() {
    }

    public static C0786Struct getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, C0802Value> getMutableFieldsMap() {
        return internalGetMutableFields();
    }

    private MapFieldLite<String, C0802Value> internalGetFields() {
        return this.f3777fields_;
    }

    private MapFieldLite<String, C0802Value> internalGetMutableFields() {
        if (!this.f3777fields_.isMutable()) {
            this.f3777fields_ = this.f3777fields_.mutableCopy();
        }
        return this.f3777fields_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static C0786Struct parseDelimitedFrom(InputStream inputStream) {
        return (C0786Struct) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0786Struct parseFrom(ByteBuffer byteBuffer) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<C0786Struct> m4128parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
    public boolean containsFields(String str) {
        str.getClass();
        return internalGetFields().containsKey(str);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = AnonymousClass1.f3778xa1df5c61[methodToInvoke.ordinal()];
        AnonymousClass1 anonymousClass1 = null;
        switch (i) {
            case 1:
                return new C0786Struct();
            case 2:
                return new Builder(anonymousClass1);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"fields_", FieldsDefaultEntryHolder.defaultEntry});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<C0786Struct> defaultInstanceBasedParser = f3776PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (C0786Struct.class) {
                        try {
                            defaultInstanceBasedParser = f3776PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3776PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
    @Deprecated
    public Map<String, C0802Value> getFields() {
        return getFieldsMap();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
    public int getFieldsCount() {
        return internalGetFields().size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
    public Map<String, C0802Value> getFieldsMap() {
        return Collections.unmodifiableMap(internalGetFields());
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
    public C0802Value getFieldsOrDefault(String str, C0802Value c0802Value) {
        str.getClass();
        MapFieldLite<String, C0802Value> mapFieldLiteInternalGetFields = internalGetFields();
        return mapFieldLiteInternalGetFields.containsKey(str) ? mapFieldLiteInternalGetFields.get(str) : c0802Value;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.StructOrBuilder
    public C0802Value getFieldsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, C0802Value> mapFieldLiteInternalGetFields = internalGetFields();
        if (mapFieldLiteInternalGetFields.containsKey(str)) {
            return mapFieldLiteInternalGetFields.get(str);
        }
        throw new IllegalArgumentException();
    }

    public static Builder newBuilder(C0786Struct c0786Struct) {
        return DEFAULT_INSTANCE.createBuilder(c0786Struct);
    }

    public static C0786Struct parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0786Struct) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0786Struct parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static C0786Struct parseFrom(ByteString byteString) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static C0786Struct parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static C0786Struct parseFrom(byte[] bArr) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static C0786Struct parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static C0786Struct parseFrom(InputStream inputStream) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static C0786Struct parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static C0786Struct parseFrom(CodedInputStream codedInputStream) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static C0786Struct parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (C0786Struct) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
