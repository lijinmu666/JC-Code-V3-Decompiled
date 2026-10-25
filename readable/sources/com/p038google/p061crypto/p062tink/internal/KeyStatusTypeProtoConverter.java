package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.p073proto.KeyStatusType;
import com.p038google.p061crypto.p062tink.p077tinkkey.KeyHandle;

/* loaded from: classes.dex */
public final class KeyStatusTypeProtoConverter {

    /* renamed from: com.google.crypto.tink.internal.KeyStatusTypeProtoConverter$1 */
    public static /* synthetic */ class C04181 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$KeyStatusType;

        /* renamed from: $SwitchMap$com$google$crypto$tink$tinkkey$KeyHandle$KeyStatusType */
        static final /* synthetic */ int[] f3114x12482d20;

        static {
            int[] iArr = new int[KeyHandle.KeyStatusType.m4290values().length];
            f3114x12482d20 = iArr;
            try {
                iArr[KeyHandle.KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3114x12482d20[KeyHandle.KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3114x12482d20[KeyHandle.KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[KeyStatusType.m3793values().length];
            $SwitchMap$com$google$crypto$tink$proto$KeyStatusType = iArr2;
            try {
                iArr2[KeyStatusType.ENABLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DISABLED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$KeyStatusType[KeyStatusType.DESTROYED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private KeyStatusTypeProtoConverter() {
    }

    public static KeyHandle.KeyStatusType fromProto(KeyStatusType keyStatusType) {
        int i = C04181.$SwitchMap$com$google$crypto$tink$proto$KeyStatusType[keyStatusType.ordinal()];
        if (i == 1) {
            return KeyHandle.KeyStatusType.ENABLED;
        }
        if (i == 2) {
            return KeyHandle.KeyStatusType.DISABLED;
        }
        if (i == 3) {
            return KeyHandle.KeyStatusType.DESTROYED;
        }
        throw new IllegalArgumentException("Unknown key status type.");
    }

    /* renamed from: toProto */
    public static KeyStatusType m3487toProto(KeyHandle.KeyStatusType keyStatusType) {
        int i = C04181.f3114x12482d20[keyStatusType.ordinal()];
        if (i == 1) {
            return KeyStatusType.ENABLED;
        }
        if (i == 2) {
            return KeyStatusType.DISABLED;
        }
        if (i == 3) {
            return KeyStatusType.DESTROYED;
        }
        throw new IllegalArgumentException("Unknown key status type.");
    }
}
