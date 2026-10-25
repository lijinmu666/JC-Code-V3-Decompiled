package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.C0802Value;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ListValue extends GeneratedMessageLite<ListValue, C0763Builder> implements ListValueOrBuilder {
    private static final ListValue DEFAULT_INSTANCE;

    /* renamed from: PARSER */
    private static volatile InterfaceC0774Parser<ListValue> f3715PARSER = null;
    public static final int VALUES_FIELD_NUMBER = 1;

    /* renamed from: values_ */
    private Internal.ProtobufList<C0802Value> f3716values_ = GeneratedMessageLite.emptyProtobufList();

    /* renamed from: com.google.crypto.tink.shaded.protobuf.ListValue$1 */
    public static /* synthetic */ class C07621 {

        /* renamed from: $SwitchMap$com$google$protobuf$GeneratedMessageLite$MethodToInvoke */
        static final /* synthetic */ int[] f3717xa1df5c61;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.m4028values().length];
            f3717xa1df5c61 = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3717xa1df5c61[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3717xa1df5c61[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f3717xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3717xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3717xa1df5c61[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f3717xa1df5c61[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.ListValue$Builder */
    public static final class C0763Builder extends GeneratedMessageLite.AbstractC0753Builder<ListValue, C0763Builder> implements ListValueOrBuilder {
        public /* synthetic */ C0763Builder(C07621 c07621) {
            this();
        }

        public C0763Builder addAllValues(Iterable<? extends C0802Value> iterable) {
            copyOnWrite();
            ((ListValue) this.instance).addAllValues(iterable);
            return this;
        }

        public C0763Builder addValues(C0802Value c0802Value) {
            copyOnWrite();
            ((ListValue) this.instance).addValues(c0802Value);
            return this;
        }

        public C0763Builder clearValues() {
            copyOnWrite();
            ((ListValue) this.instance).clearValues();
            return this;
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListValueOrBuilder
        public C0802Value getValues(int i) {
            return ((ListValue) this.instance).getValues(i);
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListValueOrBuilder
        public int getValuesCount() {
            return ((ListValue) this.instance).getValuesCount();
        }

        @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListValueOrBuilder
        public List<C0802Value> getValuesList() {
            return Collections.unmodifiableList(((ListValue) this.instance).getValuesList());
        }

        public C0763Builder removeValues(int i) {
            copyOnWrite();
            ((ListValue) this.instance).removeValues(i);
            return this;
        }

        public C0763Builder setValues(int i, C0802Value c0802Value) {
            copyOnWrite();
            ((ListValue) this.instance).setValues(i, c0802Value);
            return this;
        }

        private C0763Builder() {
            super(ListValue.DEFAULT_INSTANCE);
        }

        public C0763Builder addValues(int i, C0802Value c0802Value) {
            copyOnWrite();
            ((ListValue) this.instance).addValues(i, c0802Value);
            return this;
        }

        public C0763Builder setValues(int i, C0802Value.Builder builder) {
            copyOnWrite();
            ((ListValue) this.instance).setValues(i, builder.mo3555build());
            return this;
        }

        public C0763Builder addValues(C0802Value.Builder builder) {
            copyOnWrite();
            ((ListValue) this.instance).addValues(builder.mo3555build());
            return this;
        }

        public C0763Builder addValues(int i, C0802Value.Builder builder) {
            copyOnWrite();
            ((ListValue) this.instance).addValues(i, builder.mo3555build());
            return this;
        }
    }

    static {
        ListValue listValue = new ListValue();
        DEFAULT_INSTANCE = listValue;
        GeneratedMessageLite.registerDefaultInstance(ListValue.class, listValue);
    }

    private ListValue() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addAllValues(Iterable<? extends C0802Value> iterable) {
        ensureValuesIsMutable();
        AbstractMessageLite.m3905addAll((Iterable) iterable, (List) this.f3716values_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValues(C0802Value c0802Value) {
        c0802Value.getClass();
        ensureValuesIsMutable();
        this.f3716values_.add(c0802Value);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearValues() {
        this.f3716values_ = GeneratedMessageLite.emptyProtobufList();
    }

    private void ensureValuesIsMutable() {
        Internal.ProtobufList<C0802Value> protobufList = this.f3716values_;
        if (protobufList.isModifiable()) {
            return;
        }
        this.f3716values_ = GeneratedMessageLite.mutableCopy(protobufList);
    }

    public static ListValue getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static C0763Builder newBuilder() {
        return DEFAULT_INSTANCE.createBuilder();
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream) {
        return (ListValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    /* renamed from: parser */
    public static InterfaceC0774Parser<ListValue> m4071parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeValues(int i) {
        ensureValuesIsMutable();
        this.f3716values_.remove(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setValues(int i, C0802Value c0802Value) {
        c0802Value.getClass();
        ensureValuesIsMutable();
        this.f3716values_.set(i, c0802Value);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.GeneratedMessageLite
    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        int i = C07621.f3717xa1df5c61[methodToInvoke.ordinal()];
        C07621 c07621 = null;
        switch (i) {
            case 1:
                return new ListValue();
            case 2:
                return new C0763Builder(c07621);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"values_", C0802Value.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                InterfaceC0774Parser<ListValue> defaultInstanceBasedParser = f3715PARSER;
                if (defaultInstanceBasedParser == null) {
                    synchronized (ListValue.class) {
                        try {
                            defaultInstanceBasedParser = f3715PARSER;
                            if (defaultInstanceBasedParser == null) {
                                defaultInstanceBasedParser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                                f3715PARSER = defaultInstanceBasedParser;
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

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListValueOrBuilder
    public C0802Value getValues(int i) {
        return this.f3716values_.get(i);
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListValueOrBuilder
    public int getValuesCount() {
        return this.f3716values_.size();
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.ListValueOrBuilder
    public List<C0802Value> getValuesList() {
        return this.f3716values_;
    }

    public ValueOrBuilder getValuesOrBuilder(int i) {
        return this.f3716values_.get(i);
    }

    public List<? extends ValueOrBuilder> getValuesOrBuilderList() {
        return this.f3716values_;
    }

    public static C0763Builder newBuilder(ListValue listValue) {
        return DEFAULT_INSTANCE.createBuilder(listValue);
    }

    public static ListValue parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListValue parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListValue parseFrom(ByteString byteString) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addValues(int i, C0802Value c0802Value) {
        c0802Value.getClass();
        ensureValuesIsMutable();
        this.f3716values_.add(i, c0802Value);
    }

    public static ListValue parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListValue parseFrom(byte[] bArr) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ListValue parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListValue parseFrom(InputStream inputStream) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ListValue parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListValue parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        return (ListValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
