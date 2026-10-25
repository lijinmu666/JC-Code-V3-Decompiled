package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.p073proto.C0669KeyData;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.security.GeneralSecurityException;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class ProtoKeySerialization implements Serialization {

    @Nullable
    private final Integer idRequirement;
    private final C0669KeyData.KeyMaterialType keyMaterialType;
    private final C0878Bytes objectIdentifier;
    private final OutputPrefixType outputPrefixType;

    /* renamed from: typeUrl */
    private final String f3119typeUrl;

    /* renamed from: value */
    private final ByteString f3120value;

    private ProtoKeySerialization(String str, ByteString byteString, C0669KeyData.KeyMaterialType keyMaterialType, OutputPrefixType outputPrefixType, @Nullable Integer num) {
        this.f3119typeUrl = str;
        this.objectIdentifier = C0431Util.toBytesFromPrintableAscii(str);
        this.f3120value = byteString;
        this.keyMaterialType = keyMaterialType;
        this.outputPrefixType = outputPrefixType;
        this.idRequirement = num;
    }

    /* renamed from: create */
    public static ProtoKeySerialization m3499create(String str, ByteString byteString, C0669KeyData.KeyMaterialType keyMaterialType, OutputPrefixType outputPrefixType, @Nullable Integer num) throws GeneralSecurityException {
        if (outputPrefixType == OutputPrefixType.RAW) {
            if (num != null) {
                throw new GeneralSecurityException("Keys with output prefix type raw should not have an id requirement.");
            }
        } else if (num == null) {
            throw new GeneralSecurityException("Keys with output prefix type different from raw should have an id requirement.");
        }
        return new ProtoKeySerialization(str, byteString, keyMaterialType, outputPrefixType, num);
    }

    @Nullable
    public Integer getIdRequirementOrNull() {
        return this.idRequirement;
    }

    public C0669KeyData.KeyMaterialType getKeyMaterialType() {
        return this.keyMaterialType;
    }

    @Override // com.p038google.p061crypto.p062tink.internal.Serialization
    public C0878Bytes getObjectIdentifier() {
        return this.objectIdentifier;
    }

    public OutputPrefixType getOutputPrefixType() {
        return this.outputPrefixType;
    }

    public String getTypeUrl() {
        return this.f3119typeUrl;
    }

    public ByteString getValue() {
        return this.f3120value;
    }
}
