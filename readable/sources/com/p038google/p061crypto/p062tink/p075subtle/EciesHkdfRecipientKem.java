package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import java.security.interfaces.ECPrivateKey;

/* loaded from: classes.dex */
public final class EciesHkdfRecipientKem {
    private ECPrivateKey recipientPrivateKey;

    public EciesHkdfRecipientKem(ECPrivateKey eCPrivateKey) {
        this.recipientPrivateKey = eCPrivateKey;
    }

    public byte[] generateKey(byte[] bArr, String str, byte[] bArr2, byte[] bArr3, int i, EllipticCurves.PointFormatType pointFormatType) {
        return C0866Hkdf.computeEciesHkdfSymmetricKey(bArr, EllipticCurves.computeSharedSecret(this.recipientPrivateKey, EllipticCurves.getEcPublicKey(this.recipientPrivateKey.getParams(), pointFormatType, bArr)), str, bArr2, bArr3, i);
    }
}
