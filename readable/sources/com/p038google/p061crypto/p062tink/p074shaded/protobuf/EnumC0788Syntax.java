package com.p038google.p061crypto.p062tink.p074shaded.protobuf;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.Internal;

/* renamed from: com.google.crypto.tink.shaded.protobuf.Syntax */
/* loaded from: classes.dex */
public enum EnumC0788Syntax implements Internal.EnumLite {
    SYNTAX_PROTO2(0),
    SYNTAX_PROTO3(1),
    UNRECOGNIZED(-1);

    public static final int SYNTAX_PROTO2_VALUE = 0;
    public static final int SYNTAX_PROTO3_VALUE = 1;
    private static final Internal.EnumLiteMap<EnumC0788Syntax> internalValueMap = new Internal.EnumLiteMap<EnumC0788Syntax>() { // from class: com.google.crypto.tink.shaded.protobuf.Syntax.1
        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLiteMap
        public EnumC0788Syntax findValueByNumber(int i) {
            return EnumC0788Syntax.forNumber(i);
        }
    };

    /* renamed from: value */
    private final int f3784value;

    /* renamed from: com.google.crypto.tink.shaded.protobuf.Syntax$SyntaxVerifier */
    public static final class SyntaxVerifier implements Internal.EnumVerifier {
        static final Internal.EnumVerifier INSTANCE = new SyntaxVerifier();

        private SyntaxVerifier() {
        }

        @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumVerifier
        public boolean isInRange(int i) {
            return EnumC0788Syntax.forNumber(i) != null;
        }
    }

    EnumC0788Syntax(int i) {
        this.f3784value = i;
    }

    public static EnumC0788Syntax forNumber(int i) {
        if (i == 0) {
            return SYNTAX_PROTO2;
        }
        if (i != 1) {
            return null;
        }
        return SYNTAX_PROTO3;
    }

    public static Internal.EnumLiteMap<EnumC0788Syntax> internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal.EnumVerifier internalGetVerifier() {
        return SyntaxVerifier.INSTANCE;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.EnumLite
    public final int getNumber() {
        if (this != UNRECOGNIZED) {
            return this.f3784value;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Deprecated
    /* renamed from: valueOf */
    public static EnumC0788Syntax m4130valueOf(int i) {
        return forNumber(i);
    }
}
