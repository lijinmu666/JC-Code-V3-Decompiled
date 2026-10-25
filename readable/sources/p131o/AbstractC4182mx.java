package p131o;

import org.conscrypt.BuildConfig;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: o.mx */
/* loaded from: classes.dex */
public abstract class AbstractC4182mx {

    /* renamed from: mjFkc */
    public static volatile int f15285mjFkc = 100;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: AZxh */
    public static int m12796AZxh(int i, byte[] bArr, int i2, int i3, AbstractC3330Zx abstractC3330Zx, C3531cy c3531cy, AbstractC3989jz abstractC3989jz, C4117lx c4117lx) throws C4315oy {
        int i4;
        C2664Px c2664Px = abstractC3330Zx.f12261zbb;
        EnumC4784vz enumC4784vz = c3531cy.f13272AZxh.f12837AZxh;
        Object objValueOf = null;
        if (enumC4784vz == EnumC4784vz.f17095qGY) {
            m12798ETF(bArr, i2, c4117lx);
            throw null;
        }
        switch (enumC4784vz.ordinal()) {
            case 0:
                i4 = i2 + 8;
                objValueOf = Double.valueOf(Double.longBitsToDouble(m12799IEE(bArr, i2)));
                i2 = i4;
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 1:
                i4 = i2 + 4;
                objValueOf = Float.valueOf(Float.intBitsToFloat(m12813wA(bArr, i2)));
                i2 = i4;
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 2:
            case 3:
                i2 = m12805YoKzxo(bArr, i2, c4117lx);
                objValueOf = Long.valueOf(c4117lx.f14839AZxh);
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 4:
            case 12:
                i2 = m12798ETF(bArr, i2, c4117lx);
                objValueOf = Integer.valueOf(c4117lx.f14842mjFkc);
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 5:
            case 15:
                i4 = i2 + 8;
                objValueOf = Long.valueOf(m12799IEE(bArr, i2));
                i2 = i4;
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 6:
            case 14:
                i4 = i2 + 4;
                objValueOf = Integer.valueOf(m12813wA(bArr, i2));
                i2 = i4;
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 7:
                i2 = m12805YoKzxo(bArr, i2, c4117lx);
                objValueOf = Boolean.valueOf(c4117lx.f14839AZxh != 0);
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 8:
                i2 = m12808lgHUyS(bArr, i2, c4117lx);
                objValueOf = c4117lx.f14843wA;
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 9:
                int i5 = ((i >>> 3) << 3) | 4;
                InterfaceC2998Uy interfaceC2998UyM10117AZxh = C2796Ry.m10116mjFkc().m10117AZxh(c3531cy.f13273mjFkc.getClass());
                Object objM9979JHa = c2664Px.m9979JHa(c3531cy.f13272AZxh);
                if (objM9979JHa == null) {
                    objM9979JHa = interfaceC2998UyM10117AZxh.mo9751AZxh();
                    c2664Px.m9978Dt(c3531cy.f13272AZxh, objM9979JHa);
                }
                return m12812rkYL(objM9979JHa, interfaceC2998UyM10117AZxh, bArr, i2, i3, i5, c4117lx);
            case 10:
                InterfaceC2998Uy interfaceC2998UyM10117AZxh2 = C2796Ry.m10116mjFkc().m10117AZxh(c3531cy.f13273mjFkc.getClass());
                Object objM9979JHa2 = c2664Px.m9979JHa(c3531cy.f13272AZxh);
                if (objM9979JHa2 == null) {
                    objM9979JHa2 = interfaceC2998UyM10117AZxh2.mo9751AZxh();
                    c2664Px.m9978Dt(c3531cy.f13272AZxh, objM9979JHa2);
                }
                return m12810qGY(objM9979JHa2, interfaceC2998UyM10117AZxh2, bArr, i2, i3, c4117lx);
            case 11:
                i2 = m12809mjFkc(bArr, i2, c4117lx);
                objValueOf = c4117lx.f14843wA;
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 13:
                throw new IllegalStateException("Shouldn't reach here.");
            case 16:
                i2 = m12798ETF(bArr, i2, c4117lx);
                objValueOf = Integer.valueOf(AbstractC1795Cx.m7944mjFkc(c4117lx.f14842mjFkc));
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            case 17:
                i2 = m12805YoKzxo(bArr, i2, c4117lx);
                objValueOf = Long.valueOf(AbstractC1795Cx.m7943AZxh(c4117lx.f14839AZxh));
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
            default:
                c2664Px.m9978Dt(c3531cy.f13272AZxh, objValueOf);
                return i2;
        }
    }

    /* renamed from: Dt */
    public static int m12797Dt(int i, byte[] bArr, int i2, int i3, C4055kz c4055kz, C4117lx c4117lx) throws C4315oy {
        if ((i >>> 3) == 0) {
            throw new C4315oy("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iM12805YoKzxo = m12805YoKzxo(bArr, i2, c4117lx);
            c4055kz.m12637Dt(i, Long.valueOf(c4117lx.f14839AZxh));
            return iM12805YoKzxo;
        }
        if (i4 == 1) {
            c4055kz.m12637Dt(i, Long.valueOf(m12799IEE(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iM12798ETF = m12798ETF(bArr, i2, c4117lx);
            int i5 = c4117lx.f14842mjFkc;
            if (i5 < 0) {
                throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iM12798ETF) {
                throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                c4055kz.m12637Dt(i, AbstractC4981yx.f17599AZxh);
            } else {
                c4055kz.m12637Dt(i, AbstractC4981yx.m14054VA(bArr, iM12798ETF, i5));
            }
            return iM12798ETF + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new C4315oy("Protocol message contained an invalid tag (zero).");
            }
            c4055kz.m12637Dt(i, Integer.valueOf(m12813wA(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        C4055kz c4055kzM12633JHa = C4055kz.m12633JHa();
        int i7 = c4117lx.f14840KLFTb + 1;
        c4117lx.f14840KLFTb = i7;
        m12803Pq(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iM12798ETF2 = m12798ETF(bArr, i2, c4117lx);
            i8 = c4117lx.f14842mjFkc;
            if (i8 == i6) {
                i2 = iM12798ETF2;
                break;
            }
            i2 = m12797Dt(i8, bArr, iM12798ETF2, i3, c4055kzM12633JHa, c4117lx);
        }
        c4117lx.f14840KLFTb--;
        if (i2 > i3 || i8 != i6) {
            throw new C4315oy("Failed to parse the message.");
        }
        c4055kz.m12637Dt(i, c4055kzM12633JHa);
        return i2;
    }

    /* renamed from: ETF */
    public static int m12798ETF(byte[] bArr, int i, C4117lx c4117lx) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return m12804VA(b, bArr, i2, c4117lx);
        }
        c4117lx.f14842mjFkc = b;
        return i2;
    }

    /* renamed from: IEE */
    public static long m12799IEE(byte[] bArr, int i) {
        return (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    /* renamed from: JHa */
    public static int m12800JHa(InterfaceC2998Uy interfaceC2998Uy, int i, byte[] bArr, int i2, int i3, InterfaceC4118ly interfaceC4118ly, C4117lx c4117lx) throws C4315oy {
        int iM12801KLFTb = m12801KLFTb(interfaceC2998Uy, bArr, i2, i3, c4117lx);
        interfaceC4118ly.add(c4117lx.f14843wA);
        while (iM12801KLFTb < i3) {
            int iM12798ETF = m12798ETF(bArr, iM12801KLFTb, c4117lx);
            if (i != c4117lx.f14842mjFkc) {
                break;
            }
            iM12801KLFTb = m12801KLFTb(interfaceC2998Uy, bArr, iM12798ETF, i3, c4117lx);
            interfaceC4118ly.add(c4117lx.f14843wA);
        }
        return iM12801KLFTb;
    }

    /* renamed from: KLFTb */
    public static int m12801KLFTb(InterfaceC2998Uy interfaceC2998Uy, byte[] bArr, int i, int i2, C4117lx c4117lx) throws C4315oy {
        Object objMo9751AZxh = interfaceC2998Uy.mo9751AZxh();
        int iM12810qGY = m12810qGY(objMo9751AZxh, interfaceC2998Uy, bArr, i, i2, c4117lx);
        interfaceC2998Uy.mo9768lgHUyS(objMo9751AZxh);
        c4117lx.f14843wA = objMo9751AZxh;
        return iM12810qGY;
    }

    /* renamed from: MiMN */
    public static int m12802MiMN(int i, byte[] bArr, int i2, int i3, InterfaceC4118ly interfaceC4118ly, C4117lx c4117lx) {
        C3658ey c3658ey = (C3658ey) interfaceC4118ly;
        int iM12798ETF = m12798ETF(bArr, i2, c4117lx);
        c3658ey.m11871xJ(c4117lx.f14842mjFkc);
        while (iM12798ETF < i3) {
            int iM12798ETF2 = m12798ETF(bArr, iM12798ETF, c4117lx);
            if (i != c4117lx.f14842mjFkc) {
                break;
            }
            iM12798ETF = m12798ETF(bArr, iM12798ETF2, c4117lx);
            c3658ey.m11871xJ(c4117lx.f14842mjFkc);
        }
        return iM12798ETF;
    }

    /* renamed from: Pq */
    public static void m12803Pq(int i) throws C4315oy {
        if (i >= f15285mjFkc) {
            throw new C4315oy("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }

    /* renamed from: VA */
    public static int m12804VA(int i, byte[] bArr, int i2, C4117lx c4117lx) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            c4117lx.f14842mjFkc = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            c4117lx.f14842mjFkc = i5 | (b2 << 14);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            c4117lx.f14842mjFkc = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            c4117lx.f14842mjFkc = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                c4117lx.f14842mjFkc = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    /* renamed from: YoKzxo */
    public static int m12805YoKzxo(byte[] bArr, int i, C4117lx c4117lx) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            c4117lx.f14839AZxh = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            i4 += 7;
            j2 |= (r10 & ByteCompanionObject.MAX_VALUE) << i4;
            b = bArr[i3];
            i3 = i5;
        }
        c4117lx.f14839AZxh = j2;
        return i3;
    }

    /* renamed from: ZfxDd */
    public static int m12806ZfxDd(InterfaceC2998Uy interfaceC2998Uy, byte[] bArr, int i, int i2, int i3, C4117lx c4117lx) throws C4315oy {
        Object objMo9751AZxh = interfaceC2998Uy.mo9751AZxh();
        int iM12812rkYL = m12812rkYL(objMo9751AZxh, interfaceC2998Uy, bArr, i, i2, i3, c4117lx);
        interfaceC2998Uy.mo9768lgHUyS(objMo9751AZxh);
        c4117lx.f14843wA = objMo9751AZxh;
        return iM12812rkYL;
    }

    /* renamed from: fehf */
    public static int m12807fehf(int i, byte[] bArr, int i2, int i3, C4117lx c4117lx) throws C4315oy {
        if ((i >>> 3) == 0) {
            throw new C4315oy("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return m12805YoKzxo(bArr, i2, c4117lx);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return m12798ETF(bArr, i2, c4117lx) + c4117lx.f14842mjFkc;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new C4315oy("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = m12798ETF(bArr, i2, c4117lx);
            i6 = c4117lx.f14842mjFkc;
            if (i6 == i5) {
                break;
            }
            i2 = m12807fehf(i6, bArr, i2, i3, c4117lx);
        }
        if (i2 > i3 || i6 != i5) {
            throw new C4315oy("Failed to parse the message.");
        }
        return i2;
    }

    /* renamed from: lgHUyS */
    public static int m12808lgHUyS(byte[] bArr, int i, C4117lx c4117lx) throws C4315oy {
        int iM12798ETF = m12798ETF(bArr, i, c4117lx);
        int i2 = c4117lx.f14842mjFkc;
        if (i2 < 0) {
            throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            c4117lx.f14843wA = BuildConfig.f24315FLAVOR;
            return iM12798ETF;
        }
        c4117lx.f14843wA = new String(bArr, iM12798ETF, i2, AbstractC4183my.f15287mjFkc);
        return iM12798ETF + i2;
    }

    /* renamed from: mjFkc */
    public static int m12809mjFkc(byte[] bArr, int i, C4117lx c4117lx) throws C4315oy {
        int iM12798ETF = m12798ETF(bArr, i, c4117lx);
        int i2 = c4117lx.f14842mjFkc;
        if (i2 < 0) {
            throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iM12798ETF) {
            throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            c4117lx.f14843wA = AbstractC4981yx.f17599AZxh;
            return iM12798ETF;
        }
        c4117lx.f14843wA = AbstractC4981yx.m14054VA(bArr, iM12798ETF, i2);
        return iM12798ETF + i2;
    }

    /* renamed from: qGY */
    public static int m12810qGY(Object obj, InterfaceC2998Uy interfaceC2998Uy, byte[] bArr, int i, int i2, C4117lx c4117lx) throws C4315oy {
        int iM12804VA = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iM12804VA = m12804VA(i3, bArr, iM12804VA, c4117lx);
            i3 = c4117lx.f14842mjFkc;
        }
        int i4 = iM12804VA;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = c4117lx.f14840KLFTb + 1;
        c4117lx.f14840KLFTb = i5;
        m12803Pq(i5);
        int i6 = i3 + i4;
        interfaceC2998Uy.mo9755KLFTb(obj, bArr, i4, i6, c4117lx);
        c4117lx.f14840KLFTb--;
        c4117lx.f14843wA = obj;
        return i6;
    }

    /* renamed from: qdMbNW */
    public static int m12811qdMbNW(byte[] bArr, int i, C4117lx c4117lx) throws C4315oy {
        int i2;
        int iM12798ETF = m12798ETF(bArr, i, c4117lx);
        int i3 = c4117lx.f14842mjFkc;
        if (i3 < 0) {
            throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i3 == 0) {
            c4117lx.f14843wA = BuildConfig.f24315FLAVOR;
            return iM12798ETF;
        }
        int i4 = AbstractC4717uz.f16942mjFkc;
        int length = bArr.length;
        if ((((length - iM12798ETF) - i3) | iM12798ETF | i3) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(iM12798ETF), Integer.valueOf(i3)));
        }
        int i5 = iM12798ETF + i3;
        char[] cArr = new char[i3];
        int i6 = 0;
        while (iM12798ETF < i5) {
            byte b = bArr[iM12798ETF];
            if (!AbstractC4585sz.m13534ZfxDd(b)) {
                break;
            }
            iM12798ETF++;
            cArr[i6] = (char) b;
            i6++;
        }
        int i7 = i6;
        while (iM12798ETF < i5) {
            int i8 = iM12798ETF + 1;
            byte b2 = bArr[iM12798ETF];
            if (AbstractC4585sz.m13534ZfxDd(b2)) {
                cArr[i7] = (char) b2;
                i7++;
                iM12798ETF = i8;
                while (iM12798ETF < i5) {
                    byte b3 = bArr[iM12798ETF];
                    if (AbstractC4585sz.m13534ZfxDd(b3)) {
                        iM12798ETF++;
                        cArr[i7] = (char) b3;
                        i7++;
                    }
                }
            } else {
                if (b2 < -32) {
                    if (i8 >= i5) {
                        throw new C4315oy("Protocol message had invalid UTF-8.");
                    }
                    i2 = i7 + 1;
                    iM12798ETF += 2;
                    AbstractC4585sz.m13536wA(b2, bArr[i8], cArr, i7);
                } else if (b2 < -16) {
                    if (i8 >= i5 - 1) {
                        throw new C4315oy("Protocol message had invalid UTF-8.");
                    }
                    i2 = i7 + 1;
                    int i9 = iM12798ETF + 2;
                    iM12798ETF += 3;
                    AbstractC4585sz.m13532AZxh(b2, bArr[i8], bArr[i9], cArr, i7);
                } else {
                    if (i8 >= i5 - 2) {
                        throw new C4315oy("Protocol message had invalid UTF-8.");
                    }
                    byte b4 = bArr[i8];
                    int i10 = iM12798ETF + 3;
                    byte b5 = bArr[iM12798ETF + 2];
                    iM12798ETF += 4;
                    AbstractC4585sz.m13535mjFkc(b2, b4, b5, bArr[i10], cArr, i7);
                    i7 += 2;
                }
                i7 = i2;
            }
        }
        c4117lx.f14843wA = new String(cArr, 0, i7);
        return i5;
    }

    /* renamed from: rkYL */
    public static int m12812rkYL(Object obj, InterfaceC2998Uy interfaceC2998Uy, byte[] bArr, int i, int i2, int i3, C4117lx c4117lx) throws C4315oy {
        C2538Ny c2538Ny = (C2538Ny) interfaceC2998Uy;
        int i4 = c4117lx.f14840KLFTb + 1;
        c4117lx.f14840KLFTb = i4;
        m12803Pq(i4);
        int iM9774vI = c2538Ny.m9774vI(obj, bArr, i, i2, i3, c4117lx);
        c4117lx.f14840KLFTb--;
        c4117lx.f14843wA = obj;
        return iM9774vI;
    }

    /* renamed from: wA */
    public static int m12813wA(byte[] bArr, int i) {
        int i2 = bArr[i] & C1126UByte.MAX_VALUE;
        int i3 = bArr[i + 1] & C1126UByte.MAX_VALUE;
        int i4 = bArr[i + 2] & C1126UByte.MAX_VALUE;
        return ((bArr[i + 3] & C1126UByte.MAX_VALUE) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    /* renamed from: xJ */
    public static int m12814xJ(byte[] bArr, int i, InterfaceC4118ly interfaceC4118ly, C4117lx c4117lx) throws C4315oy {
        C3658ey c3658ey = (C3658ey) interfaceC4118ly;
        int iM12798ETF = m12798ETF(bArr, i, c4117lx);
        int i2 = c4117lx.f14842mjFkc + iM12798ETF;
        while (iM12798ETF < i2) {
            iM12798ETF = m12798ETF(bArr, iM12798ETF, c4117lx);
            c3658ey.m11871xJ(c4117lx.f14842mjFkc);
        }
        if (iM12798ETF == i2) {
            return iM12798ETF;
        }
        throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
