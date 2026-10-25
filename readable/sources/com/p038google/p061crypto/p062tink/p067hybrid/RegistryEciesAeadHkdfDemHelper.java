package com.p038google.p061crypto.p062tink.p067hybrid;

import com.p038google.p061crypto.p062tink.DeterministicAead;
import com.p038google.p061crypto.p062tink.InterfaceC0305Aead;
import com.p038google.p061crypto.p062tink.Registry;
import com.p038google.p061crypto.p062tink.p063aead.AeadConfig;
import com.p038google.p061crypto.p062tink.p066daead.DeterministicAeadConfig;
import com.p038google.p061crypto.p062tink.p067hybrid.p068subtle.AeadOrDaead;
import com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacAeadKey;
import com.p038google.p061crypto.p062tink.p073proto.AesCtrHmacAeadKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.AesCtrKey;
import com.p038google.p061crypto.p062tink.p073proto.AesGcmKey;
import com.p038google.p061crypto.p062tink.p073proto.AesGcmKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.AesSivKey;
import com.p038google.p061crypto.p062tink.p073proto.AesSivKeyFormat;
import com.p038google.p061crypto.p062tink.p073proto.C0614HmacKey;
import com.p038google.p061crypto.p062tink.p073proto.KeyTemplate;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ExtensionRegistryLite;
import com.p038google.p061crypto.p062tink.p074shaded.protobuf.InvalidProtocolBufferException;
import com.p038google.p061crypto.p062tink.p075subtle.EciesAeadHkdfDemHelper;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
class RegistryEciesAeadHkdfDemHelper implements EciesAeadHkdfDemHelper {
    private AesCtrHmacAeadKey aesCtrHmacAeadKey;
    private int aesCtrKeySize;
    private AesGcmKey aesGcmKey;
    private AesSivKey aesSivKey;
    private final String demKeyTypeUrl;
    private final int symmetricKeySize;

    public RegistryEciesAeadHkdfDemHelper(KeyTemplate keyTemplate) throws GeneralSecurityException {
        String typeUrl = keyTemplate.getTypeUrl();
        this.demKeyTypeUrl = typeUrl;
        if (typeUrl.equals(AeadConfig.AES_GCM_TYPE_URL)) {
            try {
                AesGcmKeyFormat from = AesGcmKeyFormat.parseFrom(keyTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
                this.aesGcmKey = (AesGcmKey) Registry.m3388newKey(keyTemplate);
                this.symmetricKeySize = from.getKeySize();
                return;
            } catch (InvalidProtocolBufferException e) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e);
            }
        }
        if (typeUrl.equals(AeadConfig.AES_CTR_HMAC_AEAD_TYPE_URL)) {
            try {
                AesCtrHmacAeadKeyFormat from2 = AesCtrHmacAeadKeyFormat.parseFrom(keyTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
                this.aesCtrHmacAeadKey = (AesCtrHmacAeadKey) Registry.m3388newKey(keyTemplate);
                this.aesCtrKeySize = from2.getAesCtrKeyFormat().getKeySize();
                this.symmetricKeySize = this.aesCtrKeySize + from2.getHmacKeyFormat().getKeySize();
                return;
            } catch (InvalidProtocolBufferException e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e2);
            }
        }
        if (!typeUrl.equals(DeterministicAeadConfig.AES_SIV_TYPE_URL)) {
            throw new GeneralSecurityException("unsupported AEAD DEM key type: " + typeUrl);
        }
        try {
            AesSivKeyFormat from3 = AesSivKeyFormat.parseFrom(keyTemplate.getValue(), ExtensionRegistryLite.getEmptyRegistry());
            this.aesSivKey = (AesSivKey) Registry.m3388newKey(keyTemplate);
            this.symmetricKeySize = from3.getKeySize();
        } catch (InvalidProtocolBufferException e3) {
            throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
        }
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.EciesAeadHkdfDemHelper
    public AeadOrDaead getAeadOrDaead(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length != getSymmetricKeySizeInBytes()) {
            throw new GeneralSecurityException("Symmetric key has incorrect length");
        }
        if (this.demKeyTypeUrl.equals(AeadConfig.AES_GCM_TYPE_URL)) {
            return new AeadOrDaead((InterfaceC0305Aead) Registry.getPrimitive(this.demKeyTypeUrl, AesGcmKey.newBuilder().mergeFrom((AesGcmKey.C0554Builder) this.aesGcmKey).setKeyValue(ByteString.copyFrom(bArr, 0, this.symmetricKeySize)).mo3555build(), InterfaceC0305Aead.class));
        }
        if (!this.demKeyTypeUrl.equals(AeadConfig.AES_CTR_HMAC_AEAD_TYPE_URL)) {
            if (!this.demKeyTypeUrl.equals(DeterministicAeadConfig.AES_SIV_TYPE_URL)) {
                throw new GeneralSecurityException("unknown DEM key type");
            }
            return new AeadOrDaead((DeterministicAead) Registry.getPrimitive(this.demKeyTypeUrl, AesSivKey.newBuilder().mergeFrom((AesSivKey.C0563Builder) this.aesSivKey).setKeyValue(ByteString.copyFrom(bArr, 0, this.symmetricKeySize)).mo3555build(), DeterministicAead.class));
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, this.aesCtrKeySize);
        byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArr, this.aesCtrKeySize, this.symmetricKeySize);
        AesCtrKey aesCtrKeyMo3555build = AesCtrKey.newBuilder().mergeFrom((AesCtrKey.C0534Builder) this.aesCtrHmacAeadKey.getAesCtrKey()).setKeyValue(ByteString.copyFrom(bArrCopyOfRange)).mo3555build();
        return new AeadOrDaead((InterfaceC0305Aead) Registry.getPrimitive(this.demKeyTypeUrl, AesCtrHmacAeadKey.newBuilder().setVersion(this.aesCtrHmacAeadKey.getVersion()).setAesCtrKey(aesCtrKeyMo3555build).setHmacKey(C0614HmacKey.newBuilder().mergeFrom((C0614HmacKey.Builder) this.aesCtrHmacAeadKey.getHmacKey()).setKeyValue(ByteString.copyFrom(bArrCopyOfRange2)).mo3555build()).mo3555build(), InterfaceC0305Aead.class));
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.EciesAeadHkdfDemHelper
    public int getSymmetricKeySizeInBytes() {
        return this.symmetricKeySize;
    }
}
