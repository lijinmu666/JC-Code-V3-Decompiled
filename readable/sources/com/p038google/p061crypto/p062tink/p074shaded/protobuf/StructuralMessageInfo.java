package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CheckReturnValue
/* loaded from: classes.dex */
final class StructuralMessageInfo implements MessageInfo {
    private final int[] checkInitialized;
    private final MessageLite defaultInstance;

    /* renamed from: fields */
    private final FieldInfo[] f3779fields;
    private final boolean messageSetWireFormat;

    /* renamed from: syntax */
    private final ProtoSyntax f3780syntax;

    public StructuralMessageInfo(ProtoSyntax protoSyntax, boolean z, int[] iArr, FieldInfo[] fieldInfoArr, Object obj) {
        this.f3780syntax = protoSyntax;
        this.messageSetWireFormat = z;
        this.checkInitialized = iArr;
        this.f3779fields = fieldInfoArr;
        this.defaultInstance = (MessageLite) Internal.checkNotNull(obj, "defaultInstance");
    }

    public static C0787Builder newBuilder() {
        return new C0787Builder();
    }

    public int[] getCheckInitialized() {
        return this.checkInitialized;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfo
    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public FieldInfo[] getFields() {
        return this.f3779fields;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfo
    public ProtoSyntax getSyntax() {
        return this.f3780syntax;
    }

    @Override // com.p038google.p061crypto.p062tink.p074shaded.protobuf.MessageInfo
    public boolean isMessageSetWireFormat() {
        return this.messageSetWireFormat;
    }

    public static C0787Builder newBuilder(int i) {
        return new C0787Builder(i);
    }

    /* renamed from: com.google.crypto.tink.shaded.protobuf.StructuralMessageInfo$Builder */
    public static final class C0787Builder {
        private int[] checkInitialized;
        private Object defaultInstance;

        /* renamed from: fields */
        private final List<FieldInfo> f3781fields;
        private boolean messageSetWireFormat;

        /* renamed from: syntax */
        private ProtoSyntax f3782syntax;
        private boolean wasBuilt;

        public C0787Builder() {
            this.checkInitialized = null;
            this.f3781fields = new ArrayList();
        }

        /* renamed from: build */
        public StructuralMessageInfo m4129build() {
            if (this.wasBuilt) {
                throw new IllegalStateException("Builder can only build once");
            }
            if (this.f3782syntax == null) {
                throw new IllegalStateException("Must specify a proto syntax");
            }
            this.wasBuilt = true;
            Collections.sort(this.f3781fields);
            return new StructuralMessageInfo(this.f3782syntax, this.messageSetWireFormat, this.checkInitialized, (FieldInfo[]) this.f3781fields.toArray(new FieldInfo[0]), this.defaultInstance);
        }

        public void withCheckInitialized(int[] iArr) {
            this.checkInitialized = iArr;
        }

        public void withDefaultInstance(Object obj) {
            this.defaultInstance = obj;
        }

        public void withField(FieldInfo fieldInfo) {
            if (this.wasBuilt) {
                throw new IllegalStateException("Builder can only build once");
            }
            this.f3781fields.add(fieldInfo);
        }

        public void withMessageSetWireFormat(boolean z) {
            this.messageSetWireFormat = z;
        }

        public void withSyntax(ProtoSyntax protoSyntax) {
            this.f3782syntax = (ProtoSyntax) Internal.checkNotNull(protoSyntax, "syntax");
        }

        public C0787Builder(int i) {
            this.checkInitialized = null;
            this.f3781fields = new ArrayList(i);
        }
    }
}
