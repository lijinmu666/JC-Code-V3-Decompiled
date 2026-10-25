package cafe.cryptography.curve25519;

import cafe.cryptography.curve25519.AffineNielsPoint;

/* loaded from: classes.dex */
public class EdwardsBasepointTable {

    /* renamed from: tables */
    final AffineNielsPoint.LookupTable[] f1971tables = new AffineNielsPoint.LookupTable[32];

    public EdwardsBasepointTable(EdwardsPoint edwardsPoint) {
        for (int i = 0; i < 32; i++) {
            this.f1971tables[i] = AffineNielsPoint.buildLookupTable(edwardsPoint);
            edwardsPoint = edwardsPoint.multiplyByPow2(8);
        }
    }

    public EdwardsPoint multiply(C0186Scalar c0186Scalar) {
        byte[] radix16 = c0186Scalar.toRadix16();
        EdwardsPoint extended = EdwardsPoint.IDENTITY;
        for (int i = 1; i < 64; i += 2) {
            extended = extended.m2106add(this.f1971tables[i / 2].m2102select(radix16[i])).toExtended();
        }
        EdwardsPoint edwardsPointMultiplyByPow2 = extended.multiplyByPow2(4);
        for (int i2 = 0; i2 < 64; i2 += 2) {
            edwardsPointMultiplyByPow2 = edwardsPointMultiplyByPow2.m2106add(this.f1971tables[i2 / 2].m2102select(radix16[i2])).toExtended();
        }
        return edwardsPointMultiplyByPow2;
    }
}
