package org.bouncycastle.p314pqc.p316crypto.p322mayo;

/* loaded from: classes2.dex */
public class MayoParameters {

    /* renamed from: mayo1 */
    public static final MayoParameters f23275mayo1 = new MayoParameters("MAYO_1", 86, 78, 5, 8, 78, 81, 10, 39, 312, 39, 40, 120159, 24336, 24, 1420, 454, new int[]{8, 1, 1, 0}, 24, 32, 24);

    /* renamed from: mayo2 */
    public static final MayoParameters f23276mayo2 = new MayoParameters("MAYO_2", 81, 64, 4, 17, 64, 69, 4, 32, 544, 32, 34, 66560, 34816, 24, 4912, 186, new int[]{8, 0, 2, 8}, 24, 32, 24);

    /* renamed from: mayo3 */
    public static final MayoParameters f23277mayo3 = new MayoParameters("MAYO_3", 118, 108, 7, 10, 108, 111, 11, 54, 540, 54, 55, 317844, 58320, 32, 2986, 681, new int[]{8, 0, 1, 7}, 32, 48, 32);

    /* renamed from: mayo5 */
    public static final MayoParameters f23278mayo5 = new MayoParameters("MAYO_5", 154, 142, 9, 12, 142, 145, 12, 71, 852, 71, 72, 720863, 120984, 40, 5554, 964, new int[]{4, 0, 8, 1}, 40, 64, 40);
    private static final int pkSeedBytes = 16;

    /* renamed from: ACols */
    private final int f23279ACols;

    /* renamed from: OBytes */
    private final int f23280OBytes;

    /* renamed from: P1Bytes */
    private final int f23281P1Bytes;

    /* renamed from: P2Bytes */
    private final int f23282P2Bytes;
    private final int cpkBytes;
    private final int cskBytes;
    private final int digestBytes;

    /* renamed from: fTail */
    private final int[] f23283fTail;

    /* renamed from: k */
    private final int f23284k;

    /* renamed from: m */
    private final int f23285m;

    /* renamed from: mBytes */
    private final int f23286mBytes;
    private final int mVecLimbs;

    /* renamed from: n */
    private final int f23287n;

    /* renamed from: name */
    private final String f23288name;

    /* renamed from: o */
    private final int f23289o;

    /* renamed from: rBytes */
    private final int f23290rBytes;
    private final int saltBytes;
    private final int sigBytes;
    private final int skSeedBytes;

    /* renamed from: v */
    private final int f23291v;

    /* renamed from: vBytes */
    private final int f23292vBytes;

    private MayoParameters(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int[] iArr, int i17, int i18, int i19) {
        this.f23288name = str;
        this.f23287n = i;
        this.f23285m = i2;
        this.mVecLimbs = i3;
        this.f23289o = i4;
        this.f23291v = i5;
        this.f23279ACols = i6;
        this.f23284k = i7;
        this.f23286mBytes = i8;
        this.f23280OBytes = i9;
        this.f23292vBytes = i10;
        this.f23290rBytes = i11;
        this.f23281P1Bytes = i12;
        this.f23282P2Bytes = i13;
        this.cskBytes = i14;
        this.cpkBytes = i15;
        this.sigBytes = i16;
        this.f23283fTail = iArr;
        this.saltBytes = i17;
        this.digestBytes = i18;
        this.skSeedBytes = i19;
    }

    public int getACols() {
        return this.f23279ACols;
    }

    public int getCpkBytes() {
        return this.cpkBytes;
    }

    public int getCskBytes() {
        return this.cskBytes;
    }

    public int getDigestBytes() {
        return this.digestBytes;
    }

    public int[] getFTail() {
        return this.f23283fTail;
    }

    /* renamed from: getK */
    public int m17667getK() {
        return this.f23284k;
    }

    /* renamed from: getM */
    public int m17668getM() {
        return this.f23285m;
    }

    public int getMBytes() {
        return this.f23286mBytes;
    }

    public int getMVecLimbs() {
        return this.mVecLimbs;
    }

    /* renamed from: getN */
    public int m17669getN() {
        return this.f23287n;
    }

    /* renamed from: getName */
    public String m17670getName() {
        return this.f23288name;
    }

    /* renamed from: getO */
    public int m17671getO() {
        return this.f23289o;
    }

    public int getOBytes() {
        return this.f23280OBytes;
    }

    public int getP1Bytes() {
        return this.f23281P1Bytes;
    }

    public int getP1Limbs() {
        int i = this.f23291v;
        return ((i * (i + 1)) >> 1) * this.mVecLimbs;
    }

    public int getP2Bytes() {
        return this.f23282P2Bytes;
    }

    public int getP2Limbs() {
        return this.f23291v * this.f23289o * this.mVecLimbs;
    }

    public int getP3Limbs() {
        int i = this.f23289o;
        return ((i * (i + 1)) >> 1) * this.mVecLimbs;
    }

    public int getPkSeedBytes() {
        return 16;
    }

    public int getRBytes() {
        return this.f23290rBytes;
    }

    public int getSaltBytes() {
        return this.saltBytes;
    }

    public int getSigBytes() {
        return this.sigBytes;
    }

    public int getSkSeedBytes() {
        return this.skSeedBytes;
    }

    /* renamed from: getV */
    public int m17672getV() {
        return this.f23291v;
    }

    public int getVBytes() {
        return this.f23292vBytes;
    }
}
