package org.bouncycastle.p194crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class ISO7816d4Padding implements BlockCipherPadding {
    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i) {
        int length = bArr.length - i;
        bArr[i] = ByteCompanionObject.MIN_VALUE;
        while (true) {
            i++;
            if (i >= bArr.length) {
                return length;
            }
            bArr[i] = 0;
        }
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ISO7816-4";
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    /* renamed from: init */
    public void mo15663init(SecureRandom secureRandom) {
    }

    @Override // org.bouncycastle.p194crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        int length = bArr.length;
        int i = -1;
        int i2 = -1;
        while (true) {
            length--;
            if (length < 0) {
                break;
            }
            i ^= ((((r3 ^ 128) - 1) >> 31) & i2) & (length ^ i);
            i2 &= ((bArr[length] & C1126UByte.MAX_VALUE) - 1) >> 31;
        }
        if (i >= 0) {
            return bArr.length - i;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
