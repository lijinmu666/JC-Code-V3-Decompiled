package com.p038google.p061crypto.p062tink.p063aead;

import com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacAeadKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.AesCtrKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.AesCtrParams;
import com.p038google.p061crypto.p062tink.p073proto.AesEaxKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.AesEaxParams;
import com.p038google.p061crypto.p062tink.p073proto.AesGcmKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.HashType;
import com.p038google.p061crypto.p062tink.p073proto.HmacKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.HmacParams;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p073proto.KmsAeadKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.KmsEnvelopeAeadKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.OutputPrefixType;

/* loaded from: classes.dex */
public final class AeadKeyTemplates {
    public static final KeyTemplate AES128_CTR_HMAC_SHA256;
    public static final KeyTemplate AES256_CTR_HMAC_SHA256;
    public static final KeyTemplate CHACHA20_POLY1305;
    public static final KeyTemplate XCHACHA20_POLY1305;
    public static final KeyTemplate AES128_GCM = createAesGcmKeyTemplate(16);
    public static final KeyTemplate AES256_GCM = createAesGcmKeyTemplate(32);
    public static final KeyTemplate AES128_EAX = createAesEaxKeyTemplate(16, 16);
    public static final KeyTemplate AES256_EAX = createAesEaxKeyTemplate(32, 16);

    static {
        HashType hashType = HashType.SHA256;
        AES128_CTR_HMAC_SHA256 = createAesCtrHmacAeadKeyTemplate(16, 16, 32, 16, hashType);
        AES256_CTR_HMAC_SHA256 = createAesCtrHmacAeadKeyTemplate(32, 16, 32, 32, hashType);
        KeyTemplate.C0672Builder typeUrl = KeyTemplate.newBuilder().setTypeUrl(new ChaCha20Poly1305KeyManager().getKeyType());
        OutputPrefixType outputPrefixType = OutputPrefixType.TINK;
        CHACHA20_POLY1305 = typeUrl.setOutputPrefixType(outputPrefixType).mo3555build();
        XCHACHA20_POLY1305 = KeyTemplate.newBuilder().setTypeUrl(new XChaCha20Poly1305KeyManager().getKeyType()).setOutputPrefixType(outputPrefixType).mo3555build();
    }

    private AeadKeyTemplates() {
    }

    public static KeyTemplate createAesCtrHmacAeadKeyTemplate(int i, int i2, int i3, int i4, HashType hashType) {
        AesCtrKeyFormat aesCtrKeyFormatMo3555build = AesCtrKeyFormat.newBuilder().setParams(AesCtrParams.newBuilder().setIvSize(i2).mo3555build()).setKeySize(i).mo3555build();
        return KeyTemplate.newBuilder().setValue(AesCtrHmacAeadKeyFormat.newBuilder().setAesCtrKeyFormat(aesCtrKeyFormatMo3555build).setHmacKeyFormat(HmacKeyFormat.newBuilder().setParams(HmacParams.newBuilder().m3645setHash(hashType).setTagSize(i4).mo3555build()).setKeySize(i3).mo3555build()).mo3555build().toByteString()).setTypeUrl(new AesCtrHmacAeadKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).mo3555build();
    }

    public static KeyTemplate createAesEaxKeyTemplate(int i, int i2) {
        return KeyTemplate.newBuilder().setValue(AesEaxKeyFormat.newBuilder().setKeySize(i).setParams(AesEaxParams.newBuilder().setIvSize(i2).mo3555build()).mo3555build().toByteString()).setTypeUrl(new AesEaxKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).mo3555build();
    }

    public static KeyTemplate createAesGcmKeyTemplate(int i) {
        return KeyTemplate.newBuilder().setValue(AesGcmKeyFormat.newBuilder().setKeySize(i).mo3555build().toByteString()).setTypeUrl(new AesGcmKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).mo3555build();
    }

    public static KeyTemplate createKmsAeadKeyTemplate(String str) {
        return KeyTemplate.newBuilder().setValue(KmsAeadKeyFormat.newBuilder().setKeyUri(str).mo3555build().toByteString()).setTypeUrl(new KmsAeadKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.TINK).mo3555build();
    }

    public static KeyTemplate createKmsEnvelopeAeadKeyTemplate(String str, KeyTemplate keyTemplate) {
        return KeyTemplate.newBuilder().setValue(KmsEnvelopeAeadKeyFormat.newBuilder().setDekTemplate(keyTemplate).setKekUri(str).mo3555build().toByteString()).setTypeUrl(new KmsEnvelopeAeadKeyManager().getKeyType()).setOutputPrefixType(OutputPrefixType.RAW).mo3555build();
    }
}
