package org.bouncycastle.p194crypto.paddings;

import java.security.SecureRandom;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class ZeroBytePadding implements BlockCipherPadding {
    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i) {
        int length = bArr.length - i;
        while (i < bArr.length) {
            bArr[i] = 0;
            i++;
        }
        return length;
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ZeroByte";
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    /* renamed from: init */
    public void mo15663init(SecureRandom secureRandom) {
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = -1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i2 &= ((bArr[length] & C1126UByte.MAX_VALUE) - 1) >> 31;
            i -= i2;
        }
    }
}
