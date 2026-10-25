package com.p038google.p061crypto.p062tink.p071mac;

import com.p038google.p061crypto.p062tink.p073proto.AesCmacKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.AesCmacParams;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.HmacKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.HmacParams;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;

/* loaded from: classes.dex */
public final class MacKeyTemplates {
    public static final KeyTemplate AES_CMAC;
    public static final KeyTemplate HMAC_SHA256_128BITTAG;
    public static final KeyTemplate HMAC_SHA256_256BITTAG;
    public static final KeyTemplate HMAC_SHA512_256BITTAG;
    public static final KeyTemplate HMAC_SHA512_512BITTAG;

    static {
        HashType hashType = HashType.SHA256;
        HMAC_SHA256_128BITTAG = createHmacKeyTemplate(32, 16, hashType);
        HMAC_SHA256_256BITTAG = createHmacKeyTemplate(32, 32, hashType);
        HashType hashType2 = HashType.SHA512;
        HMAC_SHA512_256BITTAG = createHmacKeyTemplate(64, 32, hashType2);
        HMAC_SHA512_512BITTAG = createHmacKeyTemplate(64, 64, hashType2);
        AES_CMAC = KeyTemplate.newBuilder().setValue(AesCmacKeyFormat.newBuilder().setKeySize(32).setParams(AesCmacParams.newBuilder().setTagSize(16).mo3555build()).mo3555build().toByteString()).setTypeUrl(new AesCmacKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).mo3555build();
    }

    private MacKeyTemplates() {
    }

    public static KeyTemplate createHmacKeyTemplate(int i, int i2, HashType hashType) {
        return KeyTemplate.newBuilder().setValue(HmacKeyFormat.newBuilder().setParams(HmacParams.newBuilder().m3645setHash(hashType).setTagSize(i2).mo3555build()).setKeySize(i).mo3555build().toByteString()).setTypeUrl(new HmacKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).mo3555build();
    }
}
