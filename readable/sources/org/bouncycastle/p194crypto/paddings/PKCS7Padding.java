package org.bouncycastle.p194crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p302openssl.PEMParser;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class PKCS7Padding implements BlockCipherPadding {
    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i) {
        byte length = (byte) (bArr.length - i);
        while (i < bArr.length) {
            bArr[i] = length;
            i++;
        }
        return length;
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return PEMParser.TYPE_PKCS7;
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    /* renamed from: init */
    public void mo15663init(SecureRandom secureRandom) {
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        byte b = bArr[bArr.length - 1];
        int i = b & C1126UByte.MAX_VALUE;
        int length = bArr.length - i;
        int i2 = ((i - 1) | length) >> 31;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i2 |= (bArr[i3] ^ b) & (~((i3 - length) >> 31));
        }
        if (i2 == 0) {
            return i;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
