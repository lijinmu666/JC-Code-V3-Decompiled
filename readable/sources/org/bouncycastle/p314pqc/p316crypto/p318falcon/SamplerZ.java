package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
class SamplerZ {
    /* renamed from: BerExp */
    private static int m17557BerExp(FalconRNG falconRNG, double d, double d2) {
        int iPrng_get_u8;
        int i = (int) (1.4426950408889634d * d);
        long jFpr_expm_p63 = ((FPREngine.fpr_expm_p63(d - (i * 0.6931471805599453d), d2) << 1) - 1) >>> (i ^ ((i ^ 63) & (-((63 - i) >>> 31))));
        int i2 = 64;
        do {
            i2 -= 8;
            iPrng_get_u8 = (falconRNG.prng_get_u8() & C1126UByte.MAX_VALUE) - (((int) (jFpr_expm_p63 >>> i2)) & 255);
            if (iPrng_get_u8 != 0) {
                break;
            }
        } while (i2 > 0);
        return iPrng_get_u8 >>> 31;
    }

    public static int gaussian0_sampler(FalconRNG falconRNG) {
        int[] iArr = {10745844, 3068844, 3741698, 5559083, 1580863, 8248194, 2260429, 13669192, 2736639, 708981, 4421575, 10046180, 169348, 7122675, 4136815, 30538, 13063405, 7650655, 4132, 14505003, 7826148, 417, 16768101, 11363290, 31, 8444042, 8086568, 1, 12844466, 265321, 0, 1232676, 13644283, 0, 38047, 9111839, 0, 870, 6138264, 0, 14, 12545723, 0, 0, 3104126, 0, 0, 28824, 0, 0, 198, 0, 0, 1};
        long jPrng_get_u64 = falconRNG.prng_get_u64();
        int i = ((int) jPrng_get_u64) & 16777215;
        int i2 = 16777215 & ((int) (jPrng_get_u64 >>> 24));
        int iPrng_get_u8 = ((falconRNG.prng_get_u8() & C1126UByte.MAX_VALUE) << 16) | ((int) (jPrng_get_u64 >>> 48));
        int i3 = 0;
        for (int i4 = 0; i4 < 54; i4 += 3) {
            i3 += ((iPrng_get_u8 - iArr[i4]) - (((i2 - iArr[i4 + 1]) - ((i - iArr[i4 + 2]) >>> 31)) >>> 31)) >>> 31;
        }
        return i3;
    }

    /* renamed from: sample */
    public static int m17558sample(SamplerCtx samplerCtx, double d, double d2) {
        return m17559sampler(samplerCtx, d, d2);
    }

    /* renamed from: sampler */
    private static int m17559sampler(SamplerCtx samplerCtx, double d, double d2) {
        int iGaussian0_sampler;
        int iPrng_get_u8;
        double d3;
        int iFpr_floor = (int) FPREngine.fpr_floor(d);
        double d4 = d - iFpr_floor;
        double d5 = d2 * d2 * 0.5d;
        double d6 = d2 * samplerCtx.sigma_min;
        do {
            iGaussian0_sampler = gaussian0_sampler(samplerCtx.f23143p);
            iPrng_get_u8 = (samplerCtx.f23143p.prng_get_u8() & 1) + (((r4 << 1) - 1) * iGaussian0_sampler);
            d3 = iPrng_get_u8 - d4;
        } while (m17557BerExp(samplerCtx.f23143p, ((d3 * d3) * d5) - ((iGaussian0_sampler * iGaussian0_sampler) * 0.15086504887537272d), d6) == 0);
        return iFpr_floor + iPrng_get_u8;
    }
}
