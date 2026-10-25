package org.bouncycastle.p284math.p285ec.p290endo;

import java.math.BigInteger;

/* loaded from: classes2.dex */
public class ScalarSplitParameters {

    /* renamed from: bits */
    protected final int f22368bits;

    /* renamed from: g1 */
    protected final BigInteger f22369g1;

    /* renamed from: g2 */
    protected final BigInteger f22370g2;

    /* renamed from: v1A */
    protected final BigInteger f22371v1A;

    /* renamed from: v1B */
    protected final BigInteger f22372v1B;

    /* renamed from: v2A */
    protected final BigInteger f22373v2A;

    /* renamed from: v2B */
    protected final BigInteger f22374v2B;

    public ScalarSplitParameters(BigInteger[] bigIntegerArr, BigInteger[] bigIntegerArr2, BigInteger bigInteger, BigInteger bigInteger2, int i) {
        checkVector(bigIntegerArr, "v1");
        checkVector(bigIntegerArr2, "v2");
        this.f22371v1A = bigIntegerArr[0];
        this.f22372v1B = bigIntegerArr[1];
        this.f22373v2A = bigIntegerArr2[0];
        this.f22374v2B = bigIntegerArr2[1];
        this.f22369g1 = bigInteger;
        this.f22370g2 = bigInteger2;
        this.f22368bits = i;
    }

    private static void checkVector(BigInteger[] bigIntegerArr, String str) {
        if (bigIntegerArr == null || bigIntegerArr.length != 2 || bigIntegerArr[0] == null || bigIntegerArr[1] == null) {
            throw new IllegalArgumentException("'" + str + "' must consist of exactly 2 (non-null) values");
        }
    }

    /* renamed from: getBits */
    public int m16779getBits() {
        return this.f22368bits;
    }

    /* renamed from: getG1 */
    public BigInteger m16780getG1() {
        return this.f22369g1;
    }

    /* renamed from: getG2 */
    public BigInteger m16781getG2() {
        return this.f22370g2;
    }

    /* renamed from: getV1A */
    public BigInteger m16782getV1A() {
        return this.f22371v1A;
    }

    /* renamed from: getV1B */
    public BigInteger m16783getV1B() {
        return this.f22372v1B;
    }

    /* renamed from: getV2A */
    public BigInteger m16784getV2A() {
        return this.f22373v2A;
    }

    /* renamed from: getV2B */
    public BigInteger m16785getV2B() {
        return this.f22374v2B;
    }
}
