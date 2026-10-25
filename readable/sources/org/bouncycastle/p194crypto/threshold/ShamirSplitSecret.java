package org.bouncycastle.p194crypto.threshold;

import java.lang.reflect.Array;
import org.bouncycastle.p194crypto.threshold.ShamirSecretSplitter;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class ShamirSplitSecret implements SplitSecret {

    /* renamed from: poly */
    private final Polynomial f21108poly;
    private final ShamirSplitSecretShare[] secretShares;

    public ShamirSplitSecret(Polynomial polynomial, ShamirSplitSecretShare[] shamirSplitSecretShareArr) {
        this.secretShares = shamirSplitSecretShareArr;
        this.f21108poly = polynomial;
    }

    /* renamed from: divide */
    public ShamirSplitSecret m15914divide(int i) {
        int i2 = 0;
        while (true) {
            ShamirSplitSecretShare[] shamirSplitSecretShareArr = this.secretShares;
            if (i2 >= shamirSplitSecretShareArr.length) {
                return this;
            }
            byte[] encoded = shamirSplitSecretShareArr[i2].getEncoded();
            for (int i3 = 0; i3 < encoded.length; i3++) {
                encoded[i3] = this.f21108poly.mo15902gfDiv(encoded[i3] & C1126UByte.MAX_VALUE, i);
            }
            int i4 = i2 + 1;
            this.secretShares[i2] = new ShamirSplitSecretShare(encoded, i4);
            i2 = i4;
        }
    }

    @Override // org.bouncycastle.p194crypto.threshold.SplitSecret
    public byte[] getSecret() {
        ShamirSplitSecretShare[] shamirSplitSecretShareArr = this.secretShares;
        int length = shamirSplitSecretShareArr.length;
        byte[] bArr = new byte[length];
        int i = length - 1;
        byte[] bArr2 = new byte[i];
        byte[][] bArr3 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, length, shamirSplitSecretShareArr[0].getEncoded().length);
        for (int i2 = 0; i2 < length; i2++) {
            bArr3[i2] = this.secretShares[i2].getEncoded();
            byte b = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (i3 != i2) {
                    Polynomial polynomial = this.f21108poly;
                    ShamirSplitSecretShare[] shamirSplitSecretShareArr2 = this.secretShares;
                    int i4 = shamirSplitSecretShareArr2[i3].f21109r;
                    bArr2[b] = polynomial.mo15902gfDiv(i4, shamirSplitSecretShareArr2[i2].f21109r ^ i4);
                    b = (byte) (b + 1);
                }
            }
            byte bMo15903gfMul = 1;
            for (int i5 = 0; i5 != i; i5++) {
                bMo15903gfMul = this.f21108poly.mo15903gfMul(bMo15903gfMul & C1126UByte.MAX_VALUE, bArr2[i5] & C1126UByte.MAX_VALUE);
            }
            bArr[i2] = bMo15903gfMul;
        }
        return this.f21108poly.gfVecMul(bArr, bArr3);
    }

    public ShamirSplitSecret multiple(int i) {
        int i2 = 0;
        while (true) {
            ShamirSplitSecretShare[] shamirSplitSecretShareArr = this.secretShares;
            if (i2 >= shamirSplitSecretShareArr.length) {
                return this;
            }
            byte[] encoded = shamirSplitSecretShareArr[i2].getEncoded();
            for (int i3 = 0; i3 < encoded.length; i3++) {
                encoded[i3] = this.f21108poly.mo15903gfMul(encoded[i3] & C1126UByte.MAX_VALUE, i);
            }
            int i4 = i2 + 1;
            this.secretShares[i2] = new ShamirSplitSecretShare(encoded, i4);
            i2 = i4;
        }
    }

    public ShamirSplitSecret(ShamirSecretSplitter.Algorithm algorithm, ShamirSecretSplitter.EnumC5398Mode enumC5398Mode, ShamirSplitSecretShare[] shamirSplitSecretShareArr) {
        this.secretShares = shamirSplitSecretShareArr;
        this.f21108poly = Polynomial.newInstance(algorithm, enumC5398Mode);
    }

    @Override // org.bouncycastle.p194crypto.threshold.SplitSecret
    public ShamirSplitSecretShare[] getSecretShares() {
        return this.secretShares;
    }
}
