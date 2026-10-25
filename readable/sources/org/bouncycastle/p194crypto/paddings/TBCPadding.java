package org.bouncycastle.p194crypto.paddings;

import java.security.SecureRandom;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class TBCPadding implements BlockCipherPadding {
    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i) {
        int length = bArr.length - i;
        int i2 = 0;
        if (i <= 0 ? (bArr[bArr.length - 1] & 1) == 0 : (bArr[i - 1] & 1) == 0) {
            i2 = 255;
        }
        byte b = (byte) i2;
        while (i < bArr.length) {
            bArr[i] = b;
            i++;
        }
        return length;
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "TBC";
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    /* renamed from: init */
    public void mo15663init(SecureRandom secureRandom) {
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) {
        int length = bArr.length - 1;
        int i = bArr[length] & C1126UByte.MAX_VALUE;
        int i2 = -1;
        int i3 = 1;
        while (true) {
            length--;
            if (length < 0) {
                return i3;
            }
            i2 &= (((bArr[length] & C1126UByte.MAX_VALUE) ^ i) - 1) >> 31;
            i3 -= i2;
        }
    }
}
