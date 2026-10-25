package org.bouncycastle.p314pqc.p316crypto.p329snova;

/* loaded from: classes2.dex */
public class SnovaParameters {

    /* renamed from: alpha */
    private final int f23557alpha;

    /* renamed from: l */
    private final int f23558l;

    /* renamed from: lsq */
    private final int f23559lsq;

    /* renamed from: name */
    private final String f23560name;

    /* renamed from: o */
    private final int f23561o;
    private final boolean pkExpandShake;
    private final boolean skIsSeed;

    /* renamed from: v */
    private final int f23562v;
    public static final SnovaParameters SNOVA_24_5_4_SSK = new SnovaParameters("SNOVA_24_5_4_SSK", 24, 5, 4, true, false);
    public static final SnovaParameters SNOVA_24_5_4_ESK = new SnovaParameters("SNOVA_24_5_4_ESK", 24, 5, 4, false, false);
    public static final SnovaParameters SNOVA_24_5_4_SHAKE_SSK = new SnovaParameters("SNOVA_24_5_4_SHAKE_SSK", 24, 5, 4, true, true);
    public static final SnovaParameters SNOVA_24_5_4_SHAKE_ESK = new SnovaParameters("SNOVA_24_5_4_SHAKE_ESK", 24, 5, 4, false, true);
    public static final SnovaParameters SNOVA_24_5_5_SSK = new SnovaParameters("SNOVA_24_5_5_SSK", 24, 5, 5, true, false);
    public static final SnovaParameters SNOVA_24_5_5_ESK = new SnovaParameters("SNOVA_24_5_5_ESK", 24, 5, 5, false, false);
    public static final SnovaParameters SNOVA_24_5_5_SHAKE_SSK = new SnovaParameters("SNOVA_24_5_5_SHAKE_SSK", 24, 5, 5, true, true);
    public static final SnovaParameters SNOVA_24_5_5_SHAKE_ESK = new SnovaParameters("SNOVA_24_5_5_SHAKE_ESK", 24, 5, 5, false, true);
    public static final SnovaParameters SNOVA_25_8_3_SSK = new SnovaParameters("SNOVA_25_8_3_SSK", 25, 8, 3, true, false);
    public static final SnovaParameters SNOVA_25_8_3_ESK = new SnovaParameters("SNOVA_25_8_3_ESK", 25, 8, 3, false, false);
    public static final SnovaParameters SNOVA_25_8_3_SHAKE_SSK = new SnovaParameters("SNOVA_25_8_3_SHAKE_SSK", 25, 8, 3, true, true);
    public static final SnovaParameters SNOVA_25_8_3_SHAKE_ESK = new SnovaParameters("SNOVA_25_8_3_SHAKE_ESK", 25, 8, 3, false, true);
    public static final SnovaParameters SNOVA_29_6_5_SSK = new SnovaParameters("SNOVA_29_6_5_SSK", 29, 6, 5, true, false);
    public static final SnovaParameters SNOVA_29_6_5_ESK = new SnovaParameters("SNOVA_29_6_5_ESK", 29, 6, 5, false, false);
    public static final SnovaParameters SNOVA_29_6_5_SHAKE_SSK = new SnovaParameters("SNOVA_29_6_5_SHAKE_SSK", 29, 6, 5, true, true);
    public static final SnovaParameters SNOVA_29_6_5_SHAKE_ESK = new SnovaParameters("SNOVA_29_6_5_SHAKE_ESK", 29, 6, 5, false, true);
    public static final SnovaParameters SNOVA_37_8_4_SSK = new SnovaParameters("SNOVA_37_8_4_SSK", 37, 8, 4, true, false);
    public static final SnovaParameters SNOVA_37_8_4_ESK = new SnovaParameters("SNOVA_37_8_4_ESK", 37, 8, 4, false, false);
    public static final SnovaParameters SNOVA_37_8_4_SHAKE_SSK = new SnovaParameters("SNOVA_37_8_4_SHAKE_SSK", 37, 8, 4, true, true);
    public static final SnovaParameters SNOVA_37_8_4_SHAKE_ESK = new SnovaParameters("SNOVA_37_8_4_SHAKE_ESK", 37, 8, 4, false, true);
    public static final SnovaParameters SNOVA_37_17_2_SSK = new SnovaParameters("SNOVA_37_17_2_SSK", 37, 17, 2, true, false);
    public static final SnovaParameters SNOVA_37_17_2_ESK = new SnovaParameters("SNOVA_37_17_2_ESK", 37, 17, 2, false, false);
    public static final SnovaParameters SNOVA_37_17_2_SHAKE_SSK = new SnovaParameters("SNOVA_37_17_2_SHAKE_SSK", 37, 17, 2, true, true);
    public static final SnovaParameters SNOVA_37_17_2_SHAKE_ESK = new SnovaParameters("SNOVA_37_17_2_SHAKE_ESK", 37, 17, 2, false, true);
    public static final SnovaParameters SNOVA_49_11_3_SSK = new SnovaParameters("SNOVA_49_11_3_SSK", 49, 11, 3, true, false);
    public static final SnovaParameters SNOVA_49_11_3_ESK = new SnovaParameters("SNOVA_49_11_3_ESK", 49, 11, 3, false, false);
    public static final SnovaParameters SNOVA_49_11_3_SHAKE_SSK = new SnovaParameters("SNOVA_49_11_3_SHAKE_SSK", 49, 11, 3, true, true);
    public static final SnovaParameters SNOVA_49_11_3_SHAKE_ESK = new SnovaParameters("SNOVA_49_11_3_SHAKE_ESK", 49, 11, 3, false, true);
    public static final SnovaParameters SNOVA_56_25_2_SSK = new SnovaParameters("SNOVA_56_25_2_SSK", 56, 25, 2, true, false);
    public static final SnovaParameters SNOVA_56_25_2_ESK = new SnovaParameters("SNOVA_56_25_2_ESK", 56, 25, 2, false, false);
    public static final SnovaParameters SNOVA_56_25_2_SHAKE_SSK = new SnovaParameters("SNOVA_56_25_2_SHAKE_SSK", 56, 25, 2, true, true);
    public static final SnovaParameters SNOVA_56_25_2_SHAKE_ESK = new SnovaParameters("SNOVA_56_25_2_SHAKE_ESK", 56, 25, 2, false, true);
    public static final SnovaParameters SNOVA_60_10_4_SSK = new SnovaParameters("SNOVA_60_10_4_SSK", 60, 10, 4, true, false);
    public static final SnovaParameters SNOVA_60_10_4_ESK = new SnovaParameters("SNOVA_60_10_4_ESK", 60, 10, 4, false, false);
    public static final SnovaParameters SNOVA_60_10_4_SHAKE_SSK = new SnovaParameters("SNOVA_60_10_4_SHAKE_SSK", 60, 10, 4, true, true);
    public static final SnovaParameters SNOVA_60_10_4_SHAKE_ESK = new SnovaParameters("SNOVA_60_10_4_SHAKE_ESK", 60, 10, 4, false, true);
    public static final SnovaParameters SNOVA_66_15_3_SSK = new SnovaParameters("SNOVA_66_15_3_SSK", 66, 15, 3, true, false);
    public static final SnovaParameters SNOVA_66_15_3_ESK = new SnovaParameters("SNOVA_66_15_3_ESK", 66, 15, 3, false, false);
    public static final SnovaParameters SNOVA_66_15_3_SHAKE_SSK = new SnovaParameters("SNOVA_66_15_3_SHAKE_SSK", 66, 15, 3, true, true);
    public static final SnovaParameters SNOVA_66_15_3_SHAKE_ESK = new SnovaParameters("SNOVA_66_15_3_SHAKE_ESK", 66, 15, 3, false, true);
    public static final SnovaParameters SNOVA_75_33_2_SSK = new SnovaParameters("SNOVA_75_33_2_SSK", 75, 33, 2, true, false);
    public static final SnovaParameters SNOVA_75_33_2_ESK = new SnovaParameters("SNOVA_75_33_2_ESK", 75, 33, 2, false, false);
    public static final SnovaParameters SNOVA_75_33_2_SHAKE_SSK = new SnovaParameters("SNOVA_75_33_2_SHAKE_SSK", 75, 33, 2, true, true);
    public static final SnovaParameters SNOVA_75_33_2_SHAKE_ESK = new SnovaParameters("SNOVA_75_33_2_SHAKE_ESK", 75, 33, 2, false, true);

    private SnovaParameters(String str, int i, int i2, int i3, boolean z, boolean z2) {
        this.f23560name = str;
        this.f23562v = i;
        this.f23561o = i2;
        this.f23558l = i3;
        int i4 = i3 * i3;
        this.f23559lsq = i4;
        this.f23557alpha = i4 + i3;
        this.skIsSeed = z;
        this.pkExpandShake = z2;
    }

    public int getAlpha() {
        return this.f23557alpha;
    }

    /* renamed from: getL */
    public int m17864getL() {
        return this.f23558l;
    }

    /* renamed from: getLsq */
    public int m17865getLsq() {
        return this.f23559lsq;
    }

    /* renamed from: getM */
    public int m17866getM() {
        return this.f23561o;
    }

    /* renamed from: getN */
    public int m17867getN() {
        return this.f23562v + this.f23561o;
    }

    /* renamed from: getName */
    public String m17868getName() {
        return this.f23560name;
    }

    /* renamed from: getO */
    public int m17869getO() {
        return this.f23561o;
    }

    public int getPrivateKeyLength() {
        int i = this.f23559lsq;
        int i2 = this.f23561o;
        int i3 = i2 * 4 * this.f23557alpha;
        int i4 = this.f23562v;
        return (((i * ((i3 + ((((i4 * i4) + (i4 * i2)) + (i2 * i4)) * i2)) + (i4 * i2))) + 1) >> 1) + 48;
    }

    public int getPublicKeyLength() {
        int i = this.f23561o;
        return (((((i * i) * i) * this.f23559lsq) + 1) >>> 1) + 16;
    }

    public int getSaltLength() {
        return 16;
    }

    /* renamed from: getV */
    public int m17870getV() {
        return this.f23562v;
    }

    public boolean isPkExpandShake() {
        return this.pkExpandShake;
    }

    public boolean isSkIsSeed() {
        return this.skIsSeed;
    }
}
