package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.HybridDecrypt;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class EciesAeadHkdfHybridDecrypt implements HybridDecrypt {
    private static final byte[] EMPTY_AAD = new byte[0];
    private final EciesAeadHkdfDemHelper demHelper;
    private final EllipticCurves.PointFormatType ecPointFormat;
    private final String hkdfHmacAlgo;
    private final byte[] hkdfSalt;
    private final EciesHkdfRecipientKem recipientKem;
    private final ECPrivateKey recipientPrivateKey;

    public EciesAeadHkdfHybridDecrypt(ECPrivateKey eCPrivateKey, byte[] bArr, String str, EllipticCurves.PointFormatType pointFormatType, EciesAeadHkdfDemHelper eciesAeadHkdfDemHelper) {
        this.recipientPrivateKey = eCPrivateKey;
        this.recipientKem = new EciesHkdfRecipientKem(eCPrivateKey);
        this.hkdfSalt = bArr;
        this.hkdfHmacAlgo = str;
        this.ecPointFormat = pointFormatType;
        this.demHelper = eciesAeadHkdfDemHelper;
    }

    @Override // com.p038google.p061crypto.p062tink.HybridDecrypt
    /* renamed from: decrypt */
    public byte[] mo3330decrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int iEncodingSizeInBytes = EllipticCurves.encodingSizeInBytes(this.recipientPrivateKey.getParams().getCurve(), this.ecPointFormat);
        if (bArr.length < iEncodingSizeInBytes) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        return this.demHelper.getAeadOrDaead(this.recipientKem.generateKey(Arrays.copyOfRange(bArr, 0, iEncodingSizeInBytes), this.hkdfHmacAlgo, this.hkdfSalt, bArr2, this.demHelper.getSymmetricKeySizeInBytes(), this.ecPointFormat)).m3466decrypt(Arrays.copyOfRange(bArr, iEncodingSizeInBytes, bArr.length), EMPTY_AAD);
    }
}
