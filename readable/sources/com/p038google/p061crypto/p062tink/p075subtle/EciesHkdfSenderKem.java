package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes.dex */
public final class EciesHkdfSenderKem {
    private final ECPublicKey recipientPublicKey;

    /* renamed from: com.google.crypto.tink.subtle.EciesHkdfSenderKem$KemKey */
    public static final class C0854KemKey {
        private final C0878Bytes kemBytes;
        private final C0878Bytes symmetricKey;

        public C0854KemKey(byte[] bArr, byte[] bArr2) {
            if (bArr == null) {
                throw new NullPointerException("KemBytes must be non-null");
            }
            if (bArr2 == null) {
                throw new NullPointerException("symmetricKey must be non-null");
            }
            this.kemBytes = C0878Bytes.copyFrom(bArr);
            this.symmetricKey = C0878Bytes.copyFrom(bArr2);
        }

        public byte[] getKemBytes() {
            return this.kemBytes.toByteArray();
        }

        public byte[] getSymmetricKey() {
            return this.symmetricKey.toByteArray();
        }
    }

    public EciesHkdfSenderKem(ECPublicKey eCPublicKey) {
        this.recipientPublicKey = eCPublicKey;
    }

    public C0854KemKey generateKey(String str, byte[] bArr, byte[] bArr2, int i, EllipticCurves.PointFormatType pointFormatType) throws GeneralSecurityException {
        KeyPair keyPairGenerateKeyPair = EllipticCurves.generateKeyPair(this.recipientPublicKey.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
        byte[] bArrComputeSharedSecret = EllipticCurves.computeSharedSecret((ECPrivateKey) keyPairGenerateKeyPair.getPrivate(), this.recipientPublicKey);
        byte[] bArrPointEncode = EllipticCurves.pointEncode(eCPublicKey.getParams().getCurve(), pointFormatType, eCPublicKey.getW());
        return new C0854KemKey(bArrPointEncode, C0866Hkdf.computeEciesHkdfSymmetricKey(bArrPointEncode, bArrComputeSharedSecret, str, bArr, bArr2, i));
    }
}
