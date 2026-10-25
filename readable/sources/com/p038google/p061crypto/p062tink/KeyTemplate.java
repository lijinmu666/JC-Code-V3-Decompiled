package com.p038google.p061crypto.p062tink;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;

/* loaded from: classes.dex */
public final class KeyTemplate {

    /* renamed from: kt */
    private final com.p038google.p061crypto.p062tink.p073proto.KeyTemplate f2993kt;

    /* renamed from: com.google.crypto.tink.KeyTemplate$1 */
    public static /* synthetic */ class C03121 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType;
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType;

        static {
            int[] iArr = new int[OutputPrefixType.m3345values().length];
            $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType = iArr;
            try {
                iArr[OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType.m3816values().length];
            $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType = iArr2;
            try {
                iArr2[com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType.TINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType.RAW.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType.CRUNCHY.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public enum OutputPrefixType {
        TINK,
        LEGACY,
        RAW,
        CRUNCHY
    }

    private KeyTemplate(com.p038google.p061crypto.p062tink.p073proto.KeyTemplate keyTemplate) {
        this.f2993kt = keyTemplate;
    }

    /* renamed from: create */
    public static KeyTemplate m3342create(String str, byte[] bArr, OutputPrefixType outputPrefixType) {
        return new KeyTemplate(com.p038google.p061crypto.p062tink.p073proto.KeyTemplate.newBuilder().setTypeUrl(str).setValue(ByteString.copyFrom(bArr)).setOutputPrefixType(m3343toProto(outputPrefixType)).mo3555build());
    }

    public static OutputPrefixType fromProto(com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType outputPrefixType) {
        int i = C03121.$SwitchMap$com$google$crypto$tink$proto$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return OutputPrefixType.TINK;
        }
        if (i == 2) {
            return OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return OutputPrefixType.RAW;
        }
        if (i == 4) {
            return OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    /* renamed from: toProto */
    public static com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType m3343toProto(OutputPrefixType outputPrefixType) {
        int i = C03121.$SwitchMap$com$google$crypto$tink$KeyTemplate$OutputPrefixType[outputPrefixType.ordinal()];
        if (i == 1) {
            return com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType.TINK;
        }
        if (i == 2) {
            return com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType.LEGACY;
        }
        if (i == 3) {
            return com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType.RAW;
        }
        if (i == 4) {
            return com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType.CRUNCHY;
        }
        throw new IllegalArgumentException("Unknown output prefix type");
    }

    public OutputPrefixType getOutputPrefixType() {
        return fromProto(this.f2993kt.getOutputPrefixType());
    }

    public com.p038google.p061crypto.p062tink.p073proto.KeyTemplate getProto() {
        return this.f2993kt;
    }

    public String getTypeUrl() {
        return this.f2993kt.getTypeUrl();
    }

    public byte[] getValue() {
        return this.f2993kt.getValue().toByteArray();
    }
}
