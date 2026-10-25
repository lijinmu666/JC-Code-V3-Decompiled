package org.bouncycastle.p194crypto.p213params;

/* loaded from: classes2.dex */
public class GOST3410ValidationParameters {

    /* renamed from: c */
    private int f20760c;

    /* renamed from: cL */
    private long f20761cL;

    /* renamed from: x0 */
    private int f20762x0;

    /* renamed from: x0L */
    private long f20763x0L;

    public GOST3410ValidationParameters(int i, int i2) {
        this.f20762x0 = i;
        this.f20760c = i2;
    }

    /* renamed from: equals */
    public boolean m15755equals(Object obj) {
        if (!(obj instanceof GOST3410ValidationParameters)) {
            return false;
        }
        GOST3410ValidationParameters gOST3410ValidationParameters = (GOST3410ValidationParameters) obj;
        return gOST3410ValidationParameters.f20760c == this.f20760c && gOST3410ValidationParameters.f20762x0 == this.f20762x0 && gOST3410ValidationParameters.f20761cL == this.f20761cL && gOST3410ValidationParameters.f20763x0L == this.f20763x0L;
    }

    /* renamed from: getC */
    public int m15756getC() {
        return this.f20760c;
    }

    /* renamed from: getCL */
    public long m15757getCL() {
        return this.f20761cL;
    }

    /* renamed from: getX0 */
    public int m15758getX0() {
        return this.f20762x0;
    }

    /* renamed from: getX0L */
    public long m15759getX0L() {
        return this.f20763x0L;
    }

    public int hashCode() {
        int i = this.f20762x0 ^ this.f20760c;
        long j = this.f20763x0L;
        int i2 = (i ^ ((int) j)) ^ ((int) (j >> 32));
        long j2 = this.f20761cL;
        return (((int) j2) ^ i2) ^ ((int) (j2 >> 32));
    }

    public GOST3410ValidationParameters(long j, long j2) {
        this.f20763x0L = j;
        this.f20761cL = j2;
    }
}
