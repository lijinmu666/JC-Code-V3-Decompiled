package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.p063aead.AeadKeyTemplates;
import com.p038google.p061crypto.p062tink.p073proto.EcPointFormat;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadDemParams;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.EciesAeadHkdfParams;
import com.p038google.p061crypto.p062tink.p073proto.EciesHkdfKemParams;
import com.p038google.p061crypto.p062tink.p073proto.EllipticCurveType;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;

/* loaded from: classes.dex */
public final class HybridKeyTemplates {
    public static final KeyTemplate ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256;
    public static final KeyTemplate ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM;
    public static final KeyTemplate ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX;
    private static final byte[] EMPTY_SALT;

    static {
        byte[] bArr = new byte[0];
        EMPTY_SALT = bArr;
        EllipticCurveType ellipticCurveType = EllipticCurveType.NIST_P256;
        HashType hashType = HashType.SHA256;
        EcPointFormat ecPointFormat = EcPointFormat.UNCOMPRESSED;
        KeyTemplate keyTemplate = AeadKeyTemplates.AES128_GCM;
        OutputPrefixType outputPrefixType = OutputPrefixType.TINK;
        ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM = createEciesAeadHkdfKeyTemplate(ellipticCurveType, hashType, ecPointFormat, keyTemplate, outputPrefixType, bArr);
        ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX = createEciesAeadHkdfKeyTemplate(ellipticCurveType, hashType, EcPointFormat.COMPRESSED, keyTemplate, OutputPrefixType.RAW, bArr);
        ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256 = createEciesAeadHkdfKeyTemplate(ellipticCurveType, hashType, ecPointFormat, AeadKeyTemplates.AES128_CTR_HMAC_SHA256, outputPrefixType, bArr);
    }

    private HybridKeyTemplates() {
    }

    public static KeyTemplate createEciesAeadHkdfKeyTemplate(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, OutputPrefixType outputPrefixType, byte[] bArr) {
        return KeyTemplate.newBuilder().setTypeUrl(new EciesAeadHkdfPrivateKeyManager().getKeyType()).setOutputPrefixType(outputPrefixType).setValue(EciesAeadHkdfKeyFormat.newBuilder().setParams(createEciesAeadHkdfParams(ellipticCurveType, hashType, ecPointFormat, keyTemplate, bArr)).mo3555build().toByteString()).mo3555build();
    }

    public static EciesAeadHkdfParams createEciesAeadHkdfParams(EllipticCurveType ellipticCurveType, HashType hashType, EcPointFormat ecPointFormat, KeyTemplate keyTemplate, byte[] bArr) {
        EciesHkdfKemParams eciesHkdfKemParamsMo3555build = EciesHkdfKemParams.newBuilder().setCurveType(ellipticCurveType).setHkdfHashType(hashType).setHkdfSalt(ByteString.copyFrom(bArr)).mo3555build();
        return EciesAeadHkdfParams.newBuilder().setKemParams(eciesHkdfKemParamsMo3555build).setDemParams(EciesAeadDemParams.newBuilder().setAeadDem(keyTemplate).mo3555build()).setEcPointFormat(ecPointFormat).mo3555build();
    }
}
