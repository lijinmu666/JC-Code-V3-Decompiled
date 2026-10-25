package org.bouncycastle.p194crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class X923Padding implements BlockCipherPadding {

    /* renamed from: random */
    SecureRandom f20661random = null;

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i) {
        byte length = (byte) (bArr.length - i);
        while (i < bArr.length - 1) {
            SecureRandom secureRandom = this.f20661random;
            if (secureRandom == null) {
                bArr[i] = 0;
            } else {
                bArr[i] = (byte) secureRandom.nextInt();
            }
            i++;
        }
        bArr[i] = length;
        return length;
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "X9.23";
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    /* renamed from: init */
    public void mo15663init(SecureRandom secureRandom) {
        this.f20661random = secureRandom;
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        int i = bArr[bArr.length - 1] & C1126UByte.MAX_VALUE;
        if ((((bArr.length - i) | (i - 1)) >> 31) == 0) {
            return i;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
