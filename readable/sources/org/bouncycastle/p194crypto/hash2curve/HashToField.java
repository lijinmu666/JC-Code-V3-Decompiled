package org.bouncycastle.p194crypto.hash2curve;

import java.lang.reflect.Array;
import java.math.BigInteger;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HashToField {

    /* renamed from: L */
    protected int f20294L;

    /* renamed from: curve */
    protected final AbstractC5817ECCurve f20295curve;

    /* renamed from: dst */
    protected final byte[] f20296dst;

    /* renamed from: m */
    protected int f20297m;
    protected final MessageExpansion messageExpansion;

    /* renamed from: p */
    protected BigInteger f20298p;

    public HashToField(byte[] bArr, AbstractC5817ECCurve abstractC5817ECCurve, MessageExpansion messageExpansion, int i) {
        this.f20296dst = bArr;
        this.f20295curve = abstractC5817ECCurve;
        this.f20294L = i;
        this.messageExpansion = messageExpansion;
        this.f20298p = abstractC5817ECCurve.getField().getCharacteristic();
        this.f20297m = abstractC5817ECCurve.getField().getDimension();
    }

    /* renamed from: process */
    public BigInteger[][] m15523process(byte[] bArr, int i) {
        byte[] bArrExpandMessage = this.messageExpansion.expandMessage(bArr, this.f20296dst, this.f20297m * i * this.f20294L);
        BigInteger[][] bigIntegerArr = (BigInteger[][]) Array.newInstance((Class<?>) BigInteger.class, i, this.f20297m);
        for (int i2 = 0; i2 < i; i2++) {
            BigInteger[] bigIntegerArr2 = new BigInteger[this.f20297m];
            int i3 = 0;
            while (true) {
                int i4 = this.f20297m;
                if (i3 < i4) {
                    int i5 = this.f20294L;
                    int i6 = ((i4 * i2) + i3) * i5;
                    bigIntegerArr2[i3] = H2cUtils.m15510os2ip(C6238Arrays.copyOfRange(bArrExpandMessage, i6, i5 + i6)).mod(this.f20298p);
                    i3++;
                }
            }
            bigIntegerArr[i2] = bigIntegerArr2;
        }
        return bigIntegerArr;
    }
}
