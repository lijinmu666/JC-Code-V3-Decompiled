package org.bouncycastle.p314pqc.p316crypto.p324mlkem;

import org.bouncycastle.p361util.AbstractC6245Pack;

/* renamed from: org.bouncycastle.pqc.crypto.mlkem.CBD */
/* loaded from: classes2.dex */
class C6076CBD {
    /* renamed from: eta2 */
    public static void m17702eta2(C6078Poly c6078Poly, byte[] bArr) {
        for (int i = 0; i < 32; i++) {
            int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, i * 4);
            int i2 = (iLittleEndianToInt & 1431655765) + ((iLittleEndianToInt >>> 1) & 1431655765);
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = i3 * 4;
                c6078Poly.setCoeffIndex((i * 8) + i3, (short) (((short) ((i2 >>> i4) & 3)) - ((short) ((i2 >>> (i4 + 2)) & 3))));
            }
        }
    }

    /* renamed from: eta3 */
    public static void m17703eta3(C6078Poly c6078Poly, byte[] bArr) {
        for (int i = 0; i < 64; i++) {
            int iLittleEndianToInt24 = AbstractC6245Pack.littleEndianToInt24(bArr, i * 3);
            int i2 = (iLittleEndianToInt24 & 2396745) + ((iLittleEndianToInt24 >>> 1) & 2396745) + ((iLittleEndianToInt24 >>> 2) & 2396745);
            for (int i3 = 0; i3 < 4; i3++) {
                int i4 = i3 * 6;
                c6078Poly.setCoeffIndex((i * 4) + i3, (short) (((short) ((i2 >>> i4) & 7)) - ((short) ((i2 >>> (i4 + 3)) & 7))));
            }
        }
    }
}
