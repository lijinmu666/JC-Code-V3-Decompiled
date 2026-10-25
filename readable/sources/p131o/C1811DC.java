package p131o;

import java.util.Arrays;
import java.util.Objects;
import p094kotlin.C1126UByte;

/* renamed from: o.DC */
/* loaded from: classes.dex */
public final class C1811DC extends AbstractC3414bC {

    /* renamed from: xJ */
    public static final AbstractC3414bC f7838xJ = new C1811DC(null, new Object[0], 0);

    /* renamed from: JHa */
    public final transient int f7839JHa;

    /* renamed from: KLFTb */
    public final transient Object[] f7840KLFTb;

    /* renamed from: ZfxDd */
    public final transient Object f7841ZfxDd;

    public C1811DC(Object obj, Object[] objArr, int i) {
        this.f7841ZfxDd = obj;
        this.f7840KLFTb = objArr;
        this.f7839JHa = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r5v2, types: [int[]] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.Object[]] */
    /* renamed from: xJ */
    public static C1811DC m7983xJ(int i, Object[] objArr, C3143XB c3143xb) {
        int iHighestOneBit;
        short[] sArr;
        char c;
        char c2;
        byte[] bArr;
        int i2 = i;
        Object[] objArrCopyOf = objArr;
        if (i2 == 0) {
            return (C1811DC) f7838xJ;
        }
        Object obj = null;
        int i3 = 1;
        if (i2 == 1) {
            Object obj2 = objArrCopyOf[0];
            Objects.requireNonNull(obj2);
            Object obj3 = objArrCopyOf[1];
            Objects.requireNonNull(obj3);
            AbstractC2638PW.m9959mjFkc(obj2, obj3);
            return new C1811DC(null, objArrCopyOf, 1);
        }
        AbstractC4284oV.m12958AZxh(i2, objArrCopyOf.length >> 1, "index");
        int iMax = Math.max(i2, 2);
        if (iMax < 751619276) {
            iHighestOneBit = Integer.highestOneBit(iMax - 1);
            do {
                iHighestOneBit += iHighestOneBit;
            } while (iHighestOneBit * 0.7d < iMax);
        } else {
            iHighestOneBit = 1073741824;
            if (iMax >= 1073741824) {
                throw new IllegalArgumentException("collection too large");
            }
        }
        if (i2 == 1) {
            Object obj4 = objArrCopyOf[0];
            Objects.requireNonNull(obj4);
            Object obj5 = objArrCopyOf[1];
            Objects.requireNonNull(obj5);
            AbstractC2638PW.m9959mjFkc(obj4, obj5);
            i2 = 1;
            c = 1;
            c2 = 2;
        } else {
            int i4 = iHighestOneBit - 1;
            char c3 = 65535;
            if (iHighestOneBit <= 128) {
                byte[] bArr2 = new byte[iHighestOneBit];
                Arrays.fill(bArr2, (byte) -1);
                int i5 = 0;
                int i6 = 0;
                while (i5 < i2) {
                    int i7 = i6 + i6;
                    int i8 = i5 + i5;
                    Object obj6 = objArrCopyOf[i8];
                    Objects.requireNonNull(obj6);
                    Object obj7 = objArrCopyOf[i8 ^ i3];
                    Objects.requireNonNull(obj7);
                    AbstractC2638PW.m9959mjFkc(obj6, obj7);
                    int iM11609mjFkc = AbstractC3505cX.m11609mjFkc(obj6.hashCode());
                    while (true) {
                        int i9 = iM11609mjFkc & i4;
                        int i10 = bArr2[i9] & C1126UByte.MAX_VALUE;
                        if (i10 == 255) {
                            bArr2[i9] = (byte) i7;
                            if (i6 < i5) {
                                objArrCopyOf[i7] = obj6;
                                objArrCopyOf[i7 ^ 1] = obj7;
                            }
                            i6++;
                        } else {
                            if (obj6.equals(objArrCopyOf[i10])) {
                                int i11 = i10 ^ 1;
                                Object obj8 = objArrCopyOf[i11];
                                Objects.requireNonNull(obj8);
                                C3079WB c3079wb = new C3079WB(obj6, obj7, obj8);
                                objArrCopyOf[i11] = obj7;
                                obj = c3079wb;
                                break;
                            }
                            iM11609mjFkc = i9 + 1;
                        }
                    }
                    i5++;
                    i3 = 1;
                }
                if (i6 == i2) {
                    bArr = bArr2;
                } else {
                    bArr = new Object[]{bArr2, Integer.valueOf(i6), obj};
                    c2 = 2;
                    c = 1;
                    obj = bArr;
                }
            } else if (iHighestOneBit <= 32768) {
                sArr = new short[iHighestOneBit];
                Arrays.fill(sArr, (short) -1);
                int i12 = 0;
                for (int i13 = 0; i13 < i2; i13++) {
                    int i14 = i12 + i12;
                    int i15 = i13 + i13;
                    Object obj9 = objArrCopyOf[i15];
                    Objects.requireNonNull(obj9);
                    Object obj10 = objArrCopyOf[i15 ^ 1];
                    Objects.requireNonNull(obj10);
                    AbstractC2638PW.m9959mjFkc(obj9, obj10);
                    int iM11609mjFkc2 = AbstractC3505cX.m11609mjFkc(obj9.hashCode());
                    while (true) {
                        int i16 = iM11609mjFkc2 & i4;
                        char c4 = (char) sArr[i16];
                        if (c4 == 65535) {
                            sArr[i16] = (short) i14;
                            if (i12 < i13) {
                                objArrCopyOf[i14] = obj9;
                                objArrCopyOf[i14 ^ 1] = obj10;
                            }
                            i12++;
                        } else {
                            if (obj9.equals(objArrCopyOf[c4])) {
                                int i17 = c4 ^ 1;
                                Object obj11 = objArrCopyOf[i17];
                                Objects.requireNonNull(obj11);
                                C3079WB c3079wb2 = new C3079WB(obj9, obj10, obj11);
                                objArrCopyOf[i17] = obj10;
                                obj = c3079wb2;
                                break;
                            }
                            iM11609mjFkc2 = i16 + 1;
                        }
                    }
                }
                if (i12 != i2) {
                    c2 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i12), obj};
                    c = 1;
                }
                bArr = sArr;
            } else {
                int i18 = 1;
                sArr = new int[iHighestOneBit];
                Arrays.fill((int[]) sArr, -1);
                int i19 = 0;
                int i20 = 0;
                while (i19 < i2) {
                    int i21 = i20 + i20;
                    int i22 = i19 + i19;
                    Object obj12 = objArrCopyOf[i22];
                    Objects.requireNonNull(obj12);
                    Object obj13 = objArrCopyOf[i22 ^ i18];
                    Objects.requireNonNull(obj13);
                    AbstractC2638PW.m9959mjFkc(obj12, obj13);
                    int iM11609mjFkc3 = AbstractC3505cX.m11609mjFkc(obj12.hashCode());
                    while (true) {
                        int i23 = iM11609mjFkc3 & i4;
                        ?? r15 = sArr[i23];
                        if (r15 == c3) {
                            sArr[i23] = i21;
                            if (i20 < i19) {
                                objArrCopyOf[i21] = obj12;
                                objArrCopyOf[i21 ^ 1] = obj13;
                            }
                            i20++;
                        } else {
                            if (obj12.equals(objArrCopyOf[r15])) {
                                int i24 = r15 ^ 1;
                                Object obj14 = objArrCopyOf[i24];
                                Objects.requireNonNull(obj14);
                                C3079WB c3079wb3 = new C3079WB(obj12, obj13, obj14);
                                objArrCopyOf[i24] = obj13;
                                obj = c3079wb3;
                                break;
                            }
                            iM11609mjFkc3 = i23 + 1;
                            c3 = 65535;
                        }
                    }
                    i19++;
                    i18 = 1;
                    c3 = 65535;
                }
                if (i20 != i2) {
                    c = 1;
                    c2 = 2;
                    obj = new Object[]{sArr, Integer.valueOf(i20), obj};
                }
                bArr = sArr;
            }
            c2 = 2;
            c = 1;
            obj = bArr;
        }
        boolean z = obj instanceof Object[];
        Object obj15 = obj;
        if (z) {
            Object[] objArr2 = (Object[]) obj;
            C3079WB c3079wb4 = (C3079WB) objArr2[c2];
            if (c3143xb == null) {
                throw c3079wb4.m10834mjFkc();
            }
            c3143xb.f11556wA = c3079wb4;
            Object obj16 = objArr2[0];
            int iIntValue = ((Integer) objArr2[c]).intValue();
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, iIntValue + iIntValue);
            obj15 = obj16;
            i2 = iIntValue;
        }
        return new C1811DC(obj15, objArrCopyOf, i2);
    }

    @Override // p131o.AbstractC3414bC
    /* renamed from: KLFTb */
    public final AbstractC3674fC mo7984KLFTb() {
        return new C4866xC(this, new C1610AC(this.f7840KLFTb, 0, this.f7839JHa));
    }

    @Override // p131o.AbstractC3414bC
    /* renamed from: ZfxDd */
    public final AbstractC3674fC mo7985ZfxDd() {
        return new C4667uC(this, this.f7840KLFTb, 0, this.f7839JHa);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0003  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x0003 A[EDGE_INSN: B:44:0x0003->B:4:0x0003 BREAK  A[LOOP:0: B:16:0x0038->B:22:0x004e], EDGE_INSN: B:46:0x0003->B:4:0x0003 BREAK  A[LOOP:1: B:26:0x0063->B:32:0x007a], EDGE_INSN: B:48:0x0003->B:4:0x0003 BREAK  A[LOOP:2: B:34:0x0089->B:43:0x00a0]] */
    @Override // p131o.AbstractC3414bC, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object get(Object obj) {
        Object obj2;
        if (obj == null) {
            obj2 = null;
        } else {
            int i = this.f7839JHa;
            Object[] objArr = this.f7840KLFTb;
            if (i == 1) {
                Object obj3 = objArr[0];
                Objects.requireNonNull(obj3);
                if (obj3.equals(obj)) {
                    obj2 = objArr[1];
                    Objects.requireNonNull(obj2);
                }
            } else {
                Object obj4 = this.f7841ZfxDd;
                if (obj4 != null) {
                    if (obj4 instanceof byte[]) {
                        byte[] bArr = (byte[]) obj4;
                        int length = bArr.length - 1;
                        int iM11609mjFkc = AbstractC3505cX.m11609mjFkc(obj.hashCode());
                        while (true) {
                            int i2 = iM11609mjFkc & length;
                            int i3 = bArr[i2] & C1126UByte.MAX_VALUE;
                            if (i3 == 255) {
                                break;
                            }
                            if (obj.equals(objArr[i3])) {
                                obj2 = objArr[i3 ^ 1];
                                break;
                            }
                            iM11609mjFkc = i2 + 1;
                        }
                    } else if (obj4 instanceof short[]) {
                        short[] sArr = (short[]) obj4;
                        int length2 = sArr.length - 1;
                        int iM11609mjFkc2 = AbstractC3505cX.m11609mjFkc(obj.hashCode());
                        while (true) {
                            int i4 = iM11609mjFkc2 & length2;
                            char c = (char) sArr[i4];
                            if (c == 65535) {
                                break;
                            }
                            if (obj.equals(objArr[c])) {
                                obj2 = objArr[c ^ 1];
                                break;
                            }
                            iM11609mjFkc2 = i4 + 1;
                        }
                    } else {
                        int[] iArr = (int[]) obj4;
                        int length3 = iArr.length - 1;
                        int iM11609mjFkc3 = AbstractC3505cX.m11609mjFkc(obj.hashCode());
                        while (true) {
                            int i5 = iM11609mjFkc3 & length3;
                            int i6 = iArr[i5];
                            if (i6 == -1) {
                                break;
                            }
                            if (obj.equals(objArr[i6])) {
                                obj2 = objArr[i6 ^ 1];
                                break;
                            }
                            iM11609mjFkc3 = i5 + 1;
                        }
                    }
                }
            }
        }
        if (obj2 == null) {
            return null;
        }
        return obj2;
    }

    @Override // p131o.AbstractC3414bC
    /* renamed from: mjFkc */
    public final AbstractC2014GB mo7986mjFkc() {
        return new C1610AC(this.f7840KLFTb, 1, this.f7839JHa);
    }

    @Override // java.util.Map
    public final int size() {
        return this.f7839JHa;
    }
}
