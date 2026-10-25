package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.HybridEncrypt;
import com.p038google.p061crypto.p062tink.p075subtle.EciesHkdfSenderKem;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes.dex */
public final class EciesAeadHkdfHybridEncrypt implements HybridEncrypt {
    private static final byte[] EMPTY_AAD = new byte[0];
    private final EciesAeadHkdfDemHelper demHelper;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final EciesHkdfSenderKem senderKem;

    public EciesAeadHkdfHybridEncrypt(ECPublicKey eCPublicKey, byte[] bArr, String str, EllipticCurves.PointFormatType pointFormatType, EciesAeadHkdfDemHelper eciesAeadHkdfDemHelper) throws GeneralSecurityException {
        EllipticCurves.checkPublicKey(eCPublicKey);
        this.senderKem = new EciesHkdfSenderKem(eCPublicKey);
        this.hkdfSalt = bArr;
        this.hkdfHmacAlgo = str;
        this.ecPointFormat = pointFormatType;
        this.demHelper = eciesAeadHkdfDemHelper;
    }

    @Override // com.p038google.p061crypto.p062tink.HybridEncrypt
    /* renamed from: encrypt */
    public byte[] mo3331encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        EciesHkdfSenderKem.C0854KemKey c0854KemKeyGenerateKey = this.senderKem.generateKey(this.hkdfHmacAlgo, this.hkdfSalt, bArr2, this.demHelper.getSymmetricKeySizeInBytes(), this.ecPointFormat);
        byte[] bArrM3467encrypt = this.demHelper.getAeadOrDaead(c0854KemKeyGenerateKey.getSymmetricKey()).m3467encrypt(bArr, EMPTY_AAD);
        byte[] kemBytes = c0854KemKeyGenerateKey.getKemBytes();
        return ByteBuffer.allocate(kemBytes.length + bArrM3467encrypt.length).put(kemBytes).put(bArrM3467encrypt).array();
    }
}
