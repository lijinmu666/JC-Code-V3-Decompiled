package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class Poly1305KeyGenerator extends CipherKeyGenerator {
    private static final byte R_MASK_HIGH_4 = 15;
    private static final byte R_MASK_LOW_2 = -4;

    public static void checkKey(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        checkMask(bArr[3], R_MASK_HIGH_4);
        checkMask(bArr[7], R_MASK_HIGH_4);
        checkMask(bArr[11], R_MASK_HIGH_4);
        checkMask(bArr[15], R_MASK_HIGH_4);
        checkMask(bArr[4], R_MASK_LOW_2);
        checkMask(bArr[8], R_MASK_LOW_2);
        checkMask(bArr[12], R_MASK_LOW_2);
    }

    private static void checkMask(byte b, byte b2) {
        if ((b & (~b2)) != 0) {
            throw new IllegalArgumentException("Invalid format for r portion of Poly1305 key.");
        }
    }

    /* renamed from: clamp */
    public static void m15499clamp(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        bArr[3] = (byte) (bArr[3] & R_MASK_HIGH_4);
        bArr[7] = (byte) (bArr[7] & R_MASK_HIGH_4);
        bArr[11] = (byte) (bArr[11] & R_MASK_HIGH_4);
        bArr[15] = (byte) (bArr[15] & R_MASK_HIGH_4);
        bArr[4] = (byte) (bArr[4] & R_MASK_LOW_2);
        bArr[8] = (byte) (bArr[8] & R_MASK_LOW_2);
        bArr[12] = (byte) (bArr[12] & R_MASK_LOW_2);
    }

    @Override // org.bouncycastle.p194crypto.CipherKeyGenerator
    public byte[] generateKey() {
        byte[] bArrGenerateKey = super.generateKey();
        m15499clamp(bArrGenerateKey);
        return bArrGenerateKey;
    }

    @Override // org.bouncycastle.p194crypto.CipherKeyGenerator
    /* renamed from: init */
    public void mo14956init(KeyGenerationParameters keyGenerationParameters) {
        super.mo14956init(new KeyGenerationParameters(keyGenerationParameters.getRandom(), 256));
    }
}
