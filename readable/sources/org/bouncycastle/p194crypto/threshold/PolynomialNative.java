package org.bouncycastle.p194crypto.threshold;

import org.bouncycastle.p194crypto.threshold.ShamirSecretSplitter;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class PolynomialNative extends Polynomial {
    private final int IRREDUCIBLE;

    /* renamed from: org.bouncycastle.crypto.threshold.PolynomialNative$1 */
    public static /* synthetic */ class C53961 {

        /* renamed from: $SwitchMap$org$bouncycastle$crypto$threshold$ShamirSecretSplitter$Algorithm */
        static final /* synthetic */ int[] f21091xc314a858;

        static {
            int[] iArr = new int[ShamirSecretSplitter.Algorithm.m15910values().length];
            f21091xc314a858 = iArr;
            try {
                iArr[ShamirSecretSplitter.Algorithm.AES.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21091xc314a858[ShamirSecretSplitter.Algorithm.RSA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public PolynomialNative(ShamirSecretSplitter.Algorithm algorithm) {
        int i;
        int i2 = C53961.f21091xc314a858[algorithm.ordinal()];
        if (i2 == 1) {
            i = 283;
        } else {
            if (i2 != 2) {
                throw new IllegalArgumentException("The algorithm is not correct");
            }
            i = 285;
        }
        this.IRREDUCIBLE = i;
    }

    @Override // org.bouncycastle.p194crypto.threshold.Polynomial
    /* renamed from: gfDiv */
    public byte mo15902gfDiv(int i, int i2) {
        return mo15903gfMul(i, m15904gfPow((byte) i2, (byte) -2) & C1126UByte.MAX_VALUE);
    }

    @Override // org.bouncycastle.p194crypto.threshold.Polynomial
    /* renamed from: gfMul */
    public byte mo15903gfMul(int i, int i2) {
        int i3 = 0;
        while (i2 > 0) {
            if ((i2 & 1) != 0) {
                i3 ^= i;
            }
            i <<= 1;
            if ((i & 256) != 0) {
                i ^= this.IRREDUCIBLE;
            }
            i2 >>= 1;
        }
        while (i3 >= 256) {
            if ((i3 & 256) != 0) {
                i3 ^= this.IRREDUCIBLE;
            }
            i3 <<= 1;
        }
        return (byte) (i3 & 255);
    }
}
