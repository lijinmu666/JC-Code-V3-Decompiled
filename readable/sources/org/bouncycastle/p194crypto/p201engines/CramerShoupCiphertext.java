package org.bouncycastle.p194crypto.p201engines;

import java.math.BigInteger;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CramerShoupCiphertext {

    /* renamed from: e */
    BigInteger f19785e;

    /* renamed from: u1 */
    BigInteger f19786u1;

    /* renamed from: u2 */
    BigInteger f19787u2;

    /* renamed from: v */
    BigInteger f19788v;

    public CramerShoupCiphertext() {
    }

    /* renamed from: getE */
    public BigInteger m15284getE() {
        return this.f19785e;
    }

    /* renamed from: getU1 */
    public BigInteger m15285getU1() {
        return this.f19786u1;
    }

    /* renamed from: getU2 */
    public BigInteger m15286getU2() {
        return this.f19787u2;
    }

    /* renamed from: getV */
    public BigInteger m15287getV() {
        return this.f19788v;
    }

    /* renamed from: setE */
    public void m15288setE(BigInteger bigInteger) {
        this.f19785e = bigInteger;
    }

    /* renamed from: setU1 */
    public void m15289setU1(BigInteger bigInteger) {
        this.f19786u1 = bigInteger;
    }

    /* renamed from: setU2 */
    public void m15290setU2(BigInteger bigInteger) {
        this.f19787u2 = bigInteger;
    }

    /* renamed from: setV */
    public void m15291setV(BigInteger bigInteger) {
        this.f19788v = bigInteger;
    }

    public byte[] toByteArray() {
        byte[] byteArray = this.f19786u1.toByteArray();
        int length = byteArray.length;
        byte[] byteArray2 = this.f19787u2.toByteArray();
        int length2 = byteArray2.length;
        byte[] byteArray3 = this.f19785e.toByteArray();
        int length3 = byteArray3.length;
        byte[] byteArray4 = this.f19788v.toByteArray();
        int length4 = byteArray4.length;
        byte[] bArr = new byte[length + length2 + length3 + length4 + 16];
        AbstractC6245Pack.intToBigEndian(length, bArr, 0);
        System.arraycopy(byteArray, 0, bArr, 4, length);
        AbstractC6245Pack.intToBigEndian(length2, bArr, 4 + length);
        int i = length + 8;
        System.arraycopy(byteArray2, 0, bArr, i, length2);
        int i2 = i + length2;
        AbstractC6245Pack.intToBigEndian(length3, bArr, i2);
        int i3 = i2 + 4;
        System.arraycopy(byteArray3, 0, bArr, i3, length3);
        int i4 = i3 + length3;
        AbstractC6245Pack.intToBigEndian(length4, bArr, i4);
        System.arraycopy(byteArray4, 0, bArr, i4 + 4, length4);
        return bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("u1: " + this.f19786u1.toString());
        sb.append("\nu2: " + this.f19787u2.toString());
        sb.append("\ne: " + this.f19785e.toString());
        sb.append("\nv: " + this.f19788v.toString());
        return sb.toString();
    }

    public CramerShoupCiphertext(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
        this.f19786u1 = bigInteger;
        this.f19787u2 = bigInteger2;
        this.f19785e = bigInteger3;
        this.f19788v = bigInteger4;
    }

    public CramerShoupCiphertext(byte[] bArr) {
        int iBigEndianToInt = AbstractC6245Pack.bigEndianToInt(bArr, 0);
        int i = 4 + iBigEndianToInt;
        this.f19786u1 = new BigInteger(C6238Arrays.copyOfRange(bArr, 4, i));
        int i2 = iBigEndianToInt + 8;
        int iBigEndianToInt2 = AbstractC6245Pack.bigEndianToInt(bArr, i) + i2;
        this.f19787u2 = new BigInteger(C6238Arrays.copyOfRange(bArr, i2, iBigEndianToInt2));
        int iBigEndianToInt3 = AbstractC6245Pack.bigEndianToInt(bArr, iBigEndianToInt2);
        int i3 = iBigEndianToInt2 + 4;
        int i4 = iBigEndianToInt3 + i3;
        this.f19785e = new BigInteger(C6238Arrays.copyOfRange(bArr, i3, i4));
        int iBigEndianToInt4 = AbstractC6245Pack.bigEndianToInt(bArr, i4);
        int i5 = i4 + 4;
        this.f19788v = new BigInteger(C6238Arrays.copyOfRange(bArr, i5, iBigEndianToInt4 + i5));
    }
}
