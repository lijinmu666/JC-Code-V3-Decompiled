package com.p038google.p061crypto.p062tink.p072prf;

import com.p038google.p061crypto.p062tink.p073proto.AesCmacPrfKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.HkdfPrfKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.HkdfPrfParams;
import com.p038google.p061crypto.p062tink.p073proto.HmacPrfKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.HmacPrfParams;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;

/* loaded from: classes.dex */
public final class PrfKeyTemplates {
    public static final KeyTemplate HKDF_SHA256 = createHkdfKeyTemplate();
    public static final KeyTemplate HMAC_SHA256_PRF = createHmacTemplate(32, HashType.SHA256);
    public static final KeyTemplate HMAC_SHA512_PRF = createHmacTemplate(64, HashType.SHA512);
    public static final KeyTemplate AES_CMAC_PRF = createAes256CmacTemplate();

    private PrfKeyTemplates() {
    }

    private static KeyTemplate createAes256CmacTemplate() {
        return KeyTemplate.newBuilder().setTypeUrl(new AesCmacPrfKeyManager().getKeyType()).setValue(AesCmacPrfKeyFormat.newBuilder().setKeySize(32).mo3555build().toByteString()).setOutputPrefixType(OutputPrefixType.RAW).mo3555build();
    }

    private static KeyTemplate createHkdfKeyTemplate() {
        return KeyTemplate.newBuilder().setValue(HkdfPrfKeyFormat.newBuilder().setKeySize(32).setParams(HkdfPrfParams.newBuilder().m3638setHash(HashType.SHA256)).mo3555build().toByteString()).setTypeUrl(HkdfPrfKeyManager.staticKeyType()).setOutputPrefixType(OutputPrefixType.RAW).mo3555build();
    }

    private static KeyTemplate createHmacTemplate(int i, HashType hashType) {
        return KeyTemplate.newBuilder().setTypeUrl(new HmacPrfKeyManager().getKeyType()).setValue(HmacPrfKeyFormat.newBuilder().setParams(HmacPrfParams.newBuilder().m3651setHash(hashType).mo3555build()).setKeySize(i).mo3555build().toByteString()).setOutputPrefixType(OutputPrefixType.RAW).mo3555build();
    }
}
