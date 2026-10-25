package cafe.cryptography.p027subtle;

/* loaded from: classes.dex */
public final class ConstantTime {
    /* renamed from: bit */
    public static int m2144bit(byte[] bArr, int i) {
        return (bArr[i >> 3] >> (i & 7)) & 1;
    }

    /* renamed from: equal */
    public static int m2145equal(int i, int i2) {
        int i3 = i ^ i2;
        int i4 = 0;
        for (int i5 = 0; i5 < 8; i5++) {
            i4 |= i3 >> i5;
        }
        return (i4 ^ 1) & 1;
    }

    public static int isNegative(int i) {
        return (i >> 8) & 1;
    }

    /* renamed from: equal */
    public static int m2146equal(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < bArr.length; i2++) {
            i |= bArr[i2] ^ bArr2[i2];
        }
        return m2145equal(i, 0);
    }
}
