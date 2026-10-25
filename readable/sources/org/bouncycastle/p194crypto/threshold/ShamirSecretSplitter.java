package org.bouncycastle.p194crypto.threshold;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ShamirSecretSplitter implements SecretSplitter {

    /* renamed from: l */
    protected int f21099l;

    /* renamed from: poly */
    private final Polynomial f21100poly;

    /* renamed from: random */
    protected SecureRandom f21101random;

    public enum Algorithm {
        AES,
        RSA
    }

    /* renamed from: org.bouncycastle.crypto.threshold.ShamirSecretSplitter$Mode */
    public enum EnumC5398Mode {
        Native,
        Table
    }

    public ShamirSecretSplitter(Algorithm algorithm, EnumC5398Mode enumC5398Mode, int i, SecureRandom secureRandom) {
        if (i < 0 || i > 65534) {
            throw new IllegalArgumentException("Invalid input: l ranges from 0 to 65534 (2^16-2) bytes.");
        }
        this.f21100poly = Polynomial.newInstance(algorithm, enumC5398Mode);
        this.f21099l = i;
        this.f21101random = secureRandom;
    }

    /* renamed from: initP */
    private byte[][] m15907initP(int i, int i2) {
        if (i < 1 || i > 255) {
            throw new IllegalArgumentException("Invalid input: m must be less than 256 and positive.");
        }
        if (i2 < i || i2 > 255) {
            throw new IllegalArgumentException("Invalid input: n must be less than 256 and greater than or equal to n.");
        }
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2, i);
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i; i4++) {
                bArr[i3][i4] = this.f21100poly.m15904gfPow((byte) (i3 + 1), (byte) i4);
            }
        }
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.threshold.SecretSplitter
    /* renamed from: resplit */
    public ShamirSplitSecret mo15905resplit(byte[] bArr, int i, int i2) {
        byte[][] bArrM15907initP = m15907initP(i, i2);
        int i3 = 0;
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i, this.f21099l);
        ShamirSplitSecretShare[] shamirSplitSecretShareArr = new ShamirSplitSecretShare[this.f21099l];
        bArr2[0] = C6238Arrays.m18231clone(bArr);
        for (int i4 = 1; i4 < i; i4++) {
            this.f21101random.nextBytes(bArr2[i4]);
        }
        while (i3 < bArrM15907initP.length) {
            int i5 = i3 + 1;
            shamirSplitSecretShareArr[i3] = new ShamirSplitSecretShare(this.f21100poly.gfVecMul(bArrM15907initP[i3], bArr2), i5);
            i3 = i5;
        }
        return new ShamirSplitSecret(this.f21100poly, shamirSplitSecretShareArr);
    }

    @Override // org.bouncycastle.p194crypto.threshold.SecretSplitter
    /* renamed from: split */
    public ShamirSplitSecret mo15906split(int i, int i2) {
        byte[][] bArrM15907initP = m15907initP(i, i2);
        int i3 = 0;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i, this.f21099l);
        ShamirSplitSecretShare[] shamirSplitSecretShareArr = new ShamirSplitSecretShare[this.f21099l];
        for (int i4 = 0; i4 < i; i4++) {
            this.f21101random.nextBytes(bArr[i4]);
        }
        while (i3 < bArrM15907initP.length) {
            int i5 = i3 + 1;
            shamirSplitSecretShareArr[i3] = new ShamirSplitSecretShare(this.f21100poly.gfVecMul(bArrM15907initP[i3], bArr), i5);
            i3 = i5;
        }
        return new ShamirSplitSecret(this.f21100poly, shamirSplitSecretShareArr);
    }

    @Override // org.bouncycastle.p194crypto.threshold.SecretSplitter
    public ShamirSplitSecret splitAround(SecretShare secretShare, int i, int i2) {
        byte[][] bArrM15907initP = m15907initP(i, i2);
        int i3 = 1;
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i, this.f21099l);
        ShamirSplitSecretShare[] shamirSplitSecretShareArr = new ShamirSplitSecretShare[this.f21099l];
        byte[] encoded = secretShare.getEncoded();
        shamirSplitSecretShareArr[0] = new ShamirSplitSecretShare(encoded, 1);
        for (int i4 = 0; i4 < i; i4++) {
            this.f21101random.nextBytes(bArr[i4]);
        }
        for (int i5 = 0; i5 < this.f21099l; i5++) {
            byte b = bArr[1][i5];
            for (int i6 = 2; i6 < i; i6++) {
                b = (byte) (b ^ bArr[i6][i5]);
            }
            bArr[0][i5] = (byte) (b ^ encoded[i5]);
        }
        while (i3 < bArrM15907initP.length) {
            int i7 = i3 + 1;
            shamirSplitSecretShareArr[i3] = new ShamirSplitSecretShare(this.f21100poly.gfVecMul(bArrM15907initP[i3], bArr), i7);
            i3 = i7;
        }
        return new ShamirSplitSecret(this.f21100poly, shamirSplitSecretShareArr);
    }
}
