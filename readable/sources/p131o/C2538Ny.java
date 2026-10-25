package p131o;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import sun.misc.Unsafe;

/* renamed from: o.Ny */
/* loaded from: classes.dex */
public final class C2538Ny implements InterfaceC2998Uy {

    /* renamed from: AZxh */
    public final Object[] f9837AZxh;

    /* renamed from: Dt */
    public final AbstractC3989jz f9838Dt;

    /* renamed from: ETF */
    public final AbstractC2403Lx f9839ETF;

    /* renamed from: JHa */
    public final boolean f9840JHa;

    /* renamed from: KLFTb */
    public final InterfaceC2341Ky f9841KLFTb;

    /* renamed from: ZfxDd */
    public final int f9842ZfxDd;

    /* renamed from: lgHUyS */
    public final int f9843lgHUyS;

    /* renamed from: mjFkc */
    public final int[] f9844mjFkc;

    /* renamed from: qdMbNW */
    public final int f9845qdMbNW;

    /* renamed from: wA */
    public final int f9846wA;

    /* renamed from: xJ */
    public final int[] f9847xJ;

    /* renamed from: VA */
    public static final int[] f9836VA = new int[0];

    /* renamed from: MiMN */
    public static final Unsafe f9835MiMN = AbstractC4518rz.m13414VA();

    public C2538Ny(int[] iArr, Object[] objArr, int i, int i2, InterfaceC2341Ky interfaceC2341Ky, boolean z, int[] iArr2, int i3, int i4, C2665Py c2665Py, C4716uy c4716uy, AbstractC3989jz abstractC3989jz, AbstractC2403Lx abstractC2403Lx, C1999Fy c1999Fy) {
        this.f9844mjFkc = iArr;
        this.f9837AZxh = objArr;
        this.f9846wA = i;
        this.f9842ZfxDd = i2;
        boolean z2 = false;
        if (abstractC2403Lx != null && (interfaceC2341Ky instanceof AbstractC3330Zx)) {
            z2 = true;
        }
        this.f9840JHa = z2;
        this.f9847xJ = iArr2;
        this.f9843lgHUyS = i3;
        this.f9845qdMbNW = i4;
        this.f9838Dt = abstractC3989jz;
        this.f9839ETF = abstractC2403Lx;
        this.f9841KLFTb = interfaceC2341Ky;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0396  */
    /* renamed from: BAnRFn */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C2538Ny m9737BAnRFn(Class cls, InterfaceC2132Hy interfaceC2132Hy, C2665Py c2665Py, C4716uy c4716uy, AbstractC3989jz abstractC3989jz, AbstractC2403Lx abstractC2403Lx, C1999Fy c1999Fy) {
        int i;
        int iCharAt;
        int iCharAt2;
        int i2;
        int i3;
        int i4;
        int[] iArr;
        int i5;
        int i6;
        int i7;
        char cCharAt;
        int i8;
        char cCharAt2;
        int i9;
        char cCharAt3;
        int i10;
        char cCharAt4;
        int i11;
        char cCharAt5;
        int i12;
        char cCharAt6;
        int i13;
        char cCharAt7;
        int i14;
        char cCharAt8;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        C2926Ty c2926Ty;
        String str;
        int iObjectFieldOffset;
        int iObjectFieldOffset2;
        int i20;
        int i21;
        int i22;
        int i23;
        Field fieldM9749vadzgd;
        int i24;
        char cCharAt9;
        int i25;
        int i26;
        int i27;
        int i28;
        Object obj;
        Field fieldM9749vadzgd2;
        Object obj2;
        Field fieldM9749vadzgd3;
        int i29;
        char cCharAt10;
        int i30;
        char cCharAt11;
        int i31;
        char cCharAt12;
        int i32;
        char cCharAt13;
        if (!(interfaceC2132Hy instanceof C2926Ty)) {
            AbstractC4793w7.m13819mjFkc(interfaceC2132Hy);
            throw null;
        }
        C2926Ty c2926Ty2 = (C2926Ty) interfaceC2132Hy;
        String strM10449ZfxDd = c2926Ty2.m10449ZfxDd();
        int length = strM10449ZfxDd.length();
        char c = 55296;
        if (strM10449ZfxDd.charAt(0) >= 55296) {
            int i33 = 1;
            while (true) {
                i = i33 + 1;
                if (strM10449ZfxDd.charAt(i33) < 55296) {
                    break;
                }
                i33 = i;
            }
        } else {
            i = 1;
        }
        int i34 = i + 1;
        int iCharAt3 = strM10449ZfxDd.charAt(i);
        if (iCharAt3 >= 55296) {
            int i35 = iCharAt3 & 8191;
            int i36 = 13;
            while (true) {
                i32 = i34 + 1;
                cCharAt13 = strM10449ZfxDd.charAt(i34);
                if (cCharAt13 < 55296) {
                    break;
                }
                i35 |= (cCharAt13 & 8191) << i36;
                i36 += 13;
                i34 = i32;
            }
            iCharAt3 = i35 | (cCharAt13 << i36);
            i34 = i32;
        }
        if (iCharAt3 == 0) {
            i4 = 0;
            iCharAt = 0;
            iCharAt2 = 0;
            i2 = 0;
            i5 = 0;
            i3 = 0;
            iArr = f9836VA;
            i6 = 0;
        } else {
            int i37 = i34 + 1;
            int iCharAt4 = strM10449ZfxDd.charAt(i34);
            if (iCharAt4 >= 55296) {
                int i38 = iCharAt4 & 8191;
                int i39 = 13;
                while (true) {
                    i14 = i37 + 1;
                    cCharAt8 = strM10449ZfxDd.charAt(i37);
                    if (cCharAt8 < 55296) {
                        break;
                    }
                    i38 |= (cCharAt8 & 8191) << i39;
                    i39 += 13;
                    i37 = i14;
                }
                iCharAt4 = i38 | (cCharAt8 << i39);
                i37 = i14;
            }
            int i40 = i37 + 1;
            int iCharAt5 = strM10449ZfxDd.charAt(i37);
            if (iCharAt5 >= 55296) {
                int i41 = iCharAt5 & 8191;
                int i42 = 13;
                while (true) {
                    i13 = i40 + 1;
                    cCharAt7 = strM10449ZfxDd.charAt(i40);
                    if (cCharAt7 < 55296) {
                        break;
                    }
                    i41 |= (cCharAt7 & 8191) << i42;
                    i42 += 13;
                    i40 = i13;
                }
                iCharAt5 = i41 | (cCharAt7 << i42);
                i40 = i13;
            }
            int i43 = i40 + 1;
            int iCharAt6 = strM10449ZfxDd.charAt(i40);
            if (iCharAt6 >= 55296) {
                int i44 = iCharAt6 & 8191;
                int i45 = 13;
                while (true) {
                    i12 = i43 + 1;
                    cCharAt6 = strM10449ZfxDd.charAt(i43);
                    if (cCharAt6 < 55296) {
                        break;
                    }
                    i44 |= (cCharAt6 & 8191) << i45;
                    i45 += 13;
                    i43 = i12;
                }
                iCharAt6 = i44 | (cCharAt6 << i45);
                i43 = i12;
            }
            int i46 = i43 + 1;
            int iCharAt7 = strM10449ZfxDd.charAt(i43);
            if (iCharAt7 >= 55296) {
                int i47 = iCharAt7 & 8191;
                int i48 = 13;
                while (true) {
                    i11 = i46 + 1;
                    cCharAt5 = strM10449ZfxDd.charAt(i46);
                    if (cCharAt5 < 55296) {
                        break;
                    }
                    i47 |= (cCharAt5 & 8191) << i48;
                    i48 += 13;
                    i46 = i11;
                }
                iCharAt7 = i47 | (cCharAt5 << i48);
                i46 = i11;
            }
            int i49 = i46 + 1;
            iCharAt = strM10449ZfxDd.charAt(i46);
            if (iCharAt >= 55296) {
                int i50 = iCharAt & 8191;
                int i51 = 13;
                while (true) {
                    i10 = i49 + 1;
                    cCharAt4 = strM10449ZfxDd.charAt(i49);
                    if (cCharAt4 < 55296) {
                        break;
                    }
                    i50 |= (cCharAt4 & 8191) << i51;
                    i51 += 13;
                    i49 = i10;
                }
                iCharAt = i50 | (cCharAt4 << i51);
                i49 = i10;
            }
            int i52 = i49 + 1;
            iCharAt2 = strM10449ZfxDd.charAt(i49);
            if (iCharAt2 >= 55296) {
                int i53 = iCharAt2 & 8191;
                int i54 = 13;
                while (true) {
                    i9 = i52 + 1;
                    cCharAt3 = strM10449ZfxDd.charAt(i52);
                    if (cCharAt3 < 55296) {
                        break;
                    }
                    i53 |= (cCharAt3 & 8191) << i54;
                    i54 += 13;
                    i52 = i9;
                }
                iCharAt2 = i53 | (cCharAt3 << i54);
                i52 = i9;
            }
            int i55 = i52 + 1;
            int iCharAt8 = strM10449ZfxDd.charAt(i52);
            if (iCharAt8 >= 55296) {
                int i56 = iCharAt8 & 8191;
                int i57 = 13;
                while (true) {
                    i8 = i55 + 1;
                    cCharAt2 = strM10449ZfxDd.charAt(i55);
                    if (cCharAt2 < 55296) {
                        break;
                    }
                    i56 |= (cCharAt2 & 8191) << i57;
                    i57 += 13;
                    i55 = i8;
                }
                iCharAt8 = i56 | (cCharAt2 << i57);
                i55 = i8;
            }
            int i58 = i55 + 1;
            int iCharAt9 = strM10449ZfxDd.charAt(i55);
            if (iCharAt9 >= 55296) {
                int i59 = iCharAt9 & 8191;
                int i60 = 13;
                while (true) {
                    i7 = i58 + 1;
                    cCharAt = strM10449ZfxDd.charAt(i58);
                    if (cCharAt < 55296) {
                        break;
                    }
                    i59 |= (cCharAt & 8191) << i60;
                    i60 += 13;
                    i58 = i7;
                }
                iCharAt9 = i59 | (cCharAt << i60);
                i58 = i7;
            }
            int i61 = iCharAt4 + iCharAt4 + iCharAt5;
            int[] iArr2 = new int[iCharAt9 + iCharAt2 + iCharAt8];
            i2 = iCharAt6;
            i3 = iCharAt9;
            i4 = i61;
            iArr = iArr2;
            i5 = iCharAt7;
            i6 = iCharAt4;
            i34 = i58;
        }
        Unsafe unsafe = f9835MiMN;
        Object[] objArrM10448KLFTb = c2926Ty2.m10448KLFTb();
        Class<?> cls2 = c2926Ty2.mo8632mjFkc().getClass();
        int i62 = i3 + iCharAt2;
        int i63 = iCharAt + iCharAt;
        int[] iArr3 = new int[iCharAt * 3];
        Object[] objArr = new Object[i63];
        int i64 = i3;
        int i65 = i62;
        int i66 = 0;
        int i67 = 0;
        while (i34 < length) {
            int i68 = i34 + 1;
            int iCharAt10 = strM10449ZfxDd.charAt(i34);
            if (iCharAt10 >= c) {
                int i69 = iCharAt10 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i31 = i70 + 1;
                    cCharAt12 = strM10449ZfxDd.charAt(i70);
                    if (cCharAt12 < c) {
                        break;
                    }
                    i69 |= (cCharAt12 & 8191) << i71;
                    i71 += 13;
                    i70 = i31;
                }
                iCharAt10 = i69 | (cCharAt12 << i71);
                i15 = i31;
            } else {
                i15 = i68;
            }
            int i72 = i15 + 1;
            int iCharAt11 = strM10449ZfxDd.charAt(i15);
            if (iCharAt11 >= c) {
                int i73 = iCharAt11 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i30 = i74 + 1;
                    cCharAt11 = strM10449ZfxDd.charAt(i74);
                    if (cCharAt11 < c) {
                        break;
                    }
                    i73 |= (cCharAt11 & 8191) << i75;
                    i75 += 13;
                    i74 = i30;
                }
                iCharAt11 = i73 | (cCharAt11 << i75);
                i16 = i30;
            } else {
                i16 = i72;
            }
            if ((iCharAt11 & 1024) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i76 = iCharAt11 & 255;
            int i77 = length;
            int i78 = iCharAt11 & 2048;
            int i79 = i5;
            if (i76 >= 51) {
                int i80 = i16 + 1;
                int iCharAt12 = strM10449ZfxDd.charAt(i16);
                if (iCharAt12 >= 55296) {
                    int i81 = iCharAt12 & 8191;
                    int i82 = i80;
                    int i83 = 13;
                    while (true) {
                        i29 = i82 + 1;
                        cCharAt10 = strM10449ZfxDd.charAt(i82);
                        i17 = i2;
                        if (cCharAt10 < 55296) {
                            break;
                        }
                        i81 |= (cCharAt10 & 8191) << i83;
                        i83 += 13;
                        i82 = i29;
                        i2 = i17;
                    }
                    iCharAt12 = i81 | (cCharAt10 << i83);
                    i27 = i29;
                } else {
                    i17 = i2;
                    i27 = i80;
                }
                int i84 = i76 - 51;
                int i85 = i27;
                if (i84 == 9 || i84 == 17) {
                    i28 = i4 + 1;
                    int i86 = i67 / 3;
                    objArr[i86 + i86 + 1] = objArrM10448KLFTb[i4];
                } else {
                    if (i84 == 12) {
                        if (c2926Ty2.mo8631AZxh() == 1 || i78 != 0) {
                            i28 = i4 + 1;
                            int i87 = i67 / 3;
                            objArr[i87 + i87 + 1] = objArrM10448KLFTb[i4];
                        } else {
                            i78 = 0;
                        }
                    }
                    int i88 = iCharAt12 + iCharAt12;
                    obj = objArrM10448KLFTb[i88];
                    if (obj instanceof Field) {
                        fieldM9749vadzgd2 = m9749vadzgd(cls2, (String) obj);
                        objArrM10448KLFTb[i88] = fieldM9749vadzgd2;
                    } else {
                        fieldM9749vadzgd2 = (Field) obj;
                    }
                    int iObjectFieldOffset3 = (int) unsafe.objectFieldOffset(fieldM9749vadzgd2);
                    int i89 = i88 + 1;
                    obj2 = objArrM10448KLFTb[i89];
                    int i90 = i78;
                    if (obj2 instanceof Field) {
                        fieldM9749vadzgd3 = m9749vadzgd(cls2, (String) obj2);
                        objArrM10448KLFTb[i89] = fieldM9749vadzgd3;
                    } else {
                        fieldM9749vadzgd3 = (Field) obj2;
                    }
                    i18 = i4;
                    i21 = i85;
                    i19 = iCharAt10;
                    iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldM9749vadzgd3);
                    i22 = 0;
                    str = strM10449ZfxDd;
                    c2926Ty = c2926Ty2;
                    iObjectFieldOffset = iObjectFieldOffset3;
                    i23 = i90;
                }
                i4 = i28;
                int i882 = iCharAt12 + iCharAt12;
                obj = objArrM10448KLFTb[i882];
                if (obj instanceof Field) {
                }
                int iObjectFieldOffset32 = (int) unsafe.objectFieldOffset(fieldM9749vadzgd2);
                int i892 = i882 + 1;
                obj2 = objArrM10448KLFTb[i892];
                int i902 = i78;
                if (obj2 instanceof Field) {
                }
                i18 = i4;
                i21 = i85;
                i19 = iCharAt10;
                iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldM9749vadzgd3);
                i22 = 0;
                str = strM10449ZfxDd;
                c2926Ty = c2926Ty2;
                iObjectFieldOffset = iObjectFieldOffset32;
                i23 = i902;
            } else {
                i17 = i2;
                i18 = i4 + 1;
                Field fieldM9749vadzgd4 = m9749vadzgd(cls2, (String) objArrM10448KLFTb[i4]);
                i19 = iCharAt10;
                if (i76 == 9 || i76 == 17) {
                    c2926Ty = c2926Ty2;
                    int i91 = i67 / 3;
                    objArr[i91 + i91 + 1] = fieldM9749vadzgd4.getType();
                } else {
                    if (i76 == 27) {
                        c2926Ty = c2926Ty2;
                        i25 = 1;
                        i26 = i4 + 2;
                    } else if (i76 == 49) {
                        i26 = i4 + 2;
                        c2926Ty = c2926Ty2;
                        i25 = 1;
                    } else {
                        if (i76 == 12 || i76 == 30 || i76 == 44) {
                            c2926Ty = c2926Ty2;
                            if (c2926Ty2.mo8631AZxh() == 1 || i78 != 0) {
                                i26 = i4 + 2;
                                int i92 = i67 / 3;
                                objArr[i92 + i92 + 1] = objArrM10448KLFTb[i18];
                                str = strM10449ZfxDd;
                                i18 = i26;
                            } else {
                                str = strM10449ZfxDd;
                                i78 = 0;
                            }
                        } else if (i76 == 50) {
                            int i93 = i4 + 2;
                            int i94 = i64 + 1;
                            iArr[i64] = i67;
                            int i95 = i67 / 3;
                            int i96 = i95 + i95;
                            objArr[i96] = objArrM10448KLFTb[i18];
                            if (i78 != 0) {
                                i18 = i4 + 3;
                                objArr[i96 + 1] = objArrM10448KLFTb[i93];
                                str = strM10449ZfxDd;
                                i64 = i94;
                                c2926Ty = c2926Ty2;
                            } else {
                                i18 = i93;
                                i64 = i94;
                                i78 = 0;
                                c2926Ty = c2926Ty2;
                            }
                        } else {
                            c2926Ty = c2926Ty2;
                        }
                        iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldM9749vadzgd4);
                        iObjectFieldOffset2 = 1048575;
                        if ((iCharAt11 & 4096) == 0 || i76 > 17) {
                            i20 = i78;
                            i21 = i16;
                            i22 = 0;
                        } else {
                            int i97 = i16 + 1;
                            int iCharAt13 = str.charAt(i16);
                            if (iCharAt13 >= 55296) {
                                int i98 = iCharAt13 & 8191;
                                int i99 = 13;
                                while (true) {
                                    i24 = i97 + 1;
                                    cCharAt9 = str.charAt(i97);
                                    if (cCharAt9 < 55296) {
                                        break;
                                    }
                                    i98 |= (cCharAt9 & 8191) << i99;
                                    i99 += 13;
                                    i97 = i24;
                                }
                                iCharAt13 = i98 | (cCharAt9 << i99);
                                i97 = i24;
                            }
                            int i100 = i6 + i6 + (iCharAt13 / 32);
                            Object obj3 = objArrM10448KLFTb[i100];
                            i21 = i97;
                            if (obj3 instanceof Field) {
                                fieldM9749vadzgd = (Field) obj3;
                            } else {
                                fieldM9749vadzgd = m9749vadzgd(cls2, (String) obj3);
                                objArrM10448KLFTb[i100] = fieldM9749vadzgd;
                            }
                            i20 = i78;
                            i22 = iCharAt13 % 32;
                            iObjectFieldOffset2 = (int) unsafe.objectFieldOffset(fieldM9749vadzgd);
                        }
                        if (i76 >= 18 && i76 <= 49) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i23 = i20;
                    }
                    int i101 = i67 / 3;
                    objArr[i101 + i101 + i25] = objArrM10448KLFTb[i18];
                    str = strM10449ZfxDd;
                    i18 = i26;
                    iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldM9749vadzgd4);
                    iObjectFieldOffset2 = 1048575;
                    if ((iCharAt11 & 4096) == 0) {
                        i20 = i78;
                        i21 = i16;
                        i22 = 0;
                        if (i76 >= 18) {
                            iArr[i65] = iObjectFieldOffset;
                            i65++;
                        }
                        i23 = i20;
                    }
                }
                str = strM10449ZfxDd;
                iObjectFieldOffset = (int) unsafe.objectFieldOffset(fieldM9749vadzgd4);
                iObjectFieldOffset2 = 1048575;
                if ((iCharAt11 & 4096) == 0) {
                }
            }
            int i102 = i67 + 1;
            iArr3[i67] = i19;
            int i103 = i67 + 2;
            Class<?> cls3 = cls2;
            iArr3[i102] = iObjectFieldOffset | (i23 != 0 ? Integer.MIN_VALUE : 0) | ((iCharAt11 & 512) != 0 ? PKIFailureInfo.duplicateCertReq : 0) | ((iCharAt11 & 256) != 0 ? 268435456 : 0) | (i76 << 20);
            i67 += 3;
            iArr3[i103] = (i22 << 20) | iObjectFieldOffset2;
            strM10449ZfxDd = str;
            i4 = i18;
            length = i77;
            i5 = i79;
            cls2 = cls3;
            c2926Ty2 = c2926Ty;
            i34 = i21;
            i2 = i17;
            c = 55296;
        }
        return new C2538Ny(iArr3, objArr, i2, i5, c2926Ty2.mo8632mjFkc(), false, iArr, i3, i62, c2665Py, c4716uy, abstractC3989jz, abstractC2403Lx, c1999Fy);
    }

    /* renamed from: CqaNbM */
    public static int m9738CqaNbM(int i) {
        return (i >>> 20) & 255;
    }

    /* renamed from: Dt */
    public static void m9739Dt(Object obj) {
        if (!m9745eyqo(obj)) {
            throw new IllegalArgumentException("Mutating immutable message: ".concat(String.valueOf(obj)));
        }
    }

    /* renamed from: Gd */
    public static final int m9740Gd(byte[] bArr, int i, int i2, EnumC4784vz enumC4784vz, Class cls, C4117lx c4117lx) {
        int i3;
        EnumC4784vz enumC4784vz2 = EnumC4784vz.f17098wA;
        switch (enumC4784vz.ordinal()) {
            case 0:
                i3 = i + 8;
                c4117lx.f14843wA = Double.valueOf(Double.longBitsToDouble(AbstractC4182mx.m12799IEE(bArr, i)));
                break;
            case 1:
                i3 = i + 4;
                c4117lx.f14843wA = Float.valueOf(Float.intBitsToFloat(AbstractC4182mx.m12813wA(bArr, i)));
                break;
            case 2:
            case 3:
                int iM12805YoKzxo = AbstractC4182mx.m12805YoKzxo(bArr, i, c4117lx);
                c4117lx.f14843wA = Long.valueOf(c4117lx.f14839AZxh);
                return iM12805YoKzxo;
            case 4:
            case 12:
            case 13:
                int iM12798ETF = AbstractC4182mx.m12798ETF(bArr, i, c4117lx);
                c4117lx.f14843wA = Integer.valueOf(c4117lx.f14842mjFkc);
                return iM12798ETF;
            case 5:
            case 15:
                i3 = i + 8;
                c4117lx.f14843wA = Long.valueOf(AbstractC4182mx.m12799IEE(bArr, i));
                break;
            case 6:
            case 14:
                i3 = i + 4;
                c4117lx.f14843wA = Integer.valueOf(AbstractC4182mx.m12813wA(bArr, i));
                break;
            case 7:
                int iM12805YoKzxo2 = AbstractC4182mx.m12805YoKzxo(bArr, i, c4117lx);
                c4117lx.f14843wA = Boolean.valueOf(c4117lx.f14839AZxh != 0);
                return iM12805YoKzxo2;
            case 8:
                return AbstractC4182mx.m12811qdMbNW(bArr, i, c4117lx);
            case 9:
            default:
                throw new RuntimeException("unsupported field type.");
            case 10:
                return AbstractC4182mx.m12801KLFTb(C2796Ry.m10116mjFkc().m10117AZxh(cls), bArr, i, i2, c4117lx);
            case 11:
                return AbstractC4182mx.m12809mjFkc(bArr, i, c4117lx);
            case 16:
                int iM12798ETF2 = AbstractC4182mx.m12798ETF(bArr, i, c4117lx);
                c4117lx.f14843wA = Integer.valueOf(AbstractC1795Cx.m7944mjFkc(c4117lx.f14842mjFkc));
                return iM12798ETF2;
            case 17:
                int iM12805YoKzxo3 = AbstractC4182mx.m12805YoKzxo(bArr, i, c4117lx);
                c4117lx.f14843wA = Long.valueOf(AbstractC1795Cx.m7943AZxh(c4117lx.f14839AZxh));
                return iM12805YoKzxo3;
        }
        return i3;
    }

    /* renamed from: HGpJ */
    public static final void m9741HGpJ(int i, Object obj, InterfaceC4919xz interfaceC4919xz) {
        if (obj instanceof String) {
            interfaceC4919xz.mo8596Dt(i, (String) obj);
        } else {
            interfaceC4919xz.mo8595CqaNbM(i, (AbstractC4981yx) obj);
        }
    }

    /* renamed from: KLMXS */
    public static long m9742KLMXS(Object obj, long j) {
        return ((Long) AbstractC4518rz.m13405ETF(obj, j)).longValue();
    }

    /* renamed from: VocHEe */
    public static C4055kz m9743VocHEe(Object obj) {
        AbstractC3595dy abstractC3595dy = (AbstractC3595dy) obj;
        C4055kz c4055kz = abstractC3595dy.f13418zbc;
        if (c4055kz != C4055kz.m12635wA()) {
            return c4055kz;
        }
        C4055kz c4055kzM12633JHa = C4055kz.m12633JHa();
        abstractC3595dy.f13418zbc = c4055kzM12633JHa;
        return c4055kzM12633JHa;
    }

    /* renamed from: diqgf */
    public static boolean m9744diqgf(Object obj, int i, InterfaceC2998Uy interfaceC2998Uy) {
        return interfaceC2998Uy.mo9765ZfxDd(AbstractC4518rz.m13405ETF(obj, i & 1048575));
    }

    /* renamed from: eyqo */
    public static boolean m9745eyqo(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof AbstractC3595dy) {
            return ((AbstractC3595dy) obj).m11768fehf();
        }
        return true;
    }

    /* renamed from: huTpC */
    public static boolean m9746huTpC(Object obj, long j) {
        return ((Boolean) AbstractC4518rz.m13405ETF(obj, j)).booleanValue();
    }

    /* renamed from: lB */
    public static double m9747lB(Object obj, long j) {
        return ((Double) AbstractC4518rz.m13405ETF(obj, j)).doubleValue();
    }

    /* renamed from: mByQ */
    public static int m9748mByQ(Object obj, long j) {
        return ((Integer) AbstractC4518rz.m13405ETF(obj, j)).intValue();
    }

    /* renamed from: vadzgd */
    public static Field m9749vadzgd(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    /* renamed from: wJVbdd */
    public static float m9750wJVbdd(Object obj, long j) {
        return ((Float) AbstractC4518rz.m13405ETF(obj, j)).floatValue();
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: AZxh */
    public final Object mo9751AZxh() {
        return ((AbstractC3595dy) this.f9841KLFTb).m11761HGpJ();
    }

    /* renamed from: ETF */
    public final void m9752ETF(Object obj, Object obj2, int i) {
        if (m9753IEE(obj2, i)) {
            int iM9777xrEuO = m9777xrEuO(i) & 1048575;
            Unsafe unsafe = f9835MiMN;
            long j = iM9777xrEuO;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f9844mjFkc[i] + " is present but null: " + obj2.toString());
            }
            InterfaceC2998Uy interfaceC2998UyM9766cMLeY = m9766cMLeY(i);
            if (!m9753IEE(obj, i)) {
                if (m9745eyqo(object)) {
                    Object objMo9751AZxh = interfaceC2998UyM9766cMLeY.mo9751AZxh();
                    interfaceC2998UyM9766cMLeY.mo9776xJ(objMo9751AZxh, object);
                    unsafe.putObject(obj, j, objMo9751AZxh);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                m9756MiMN(obj, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!m9745eyqo(object2)) {
                Object objMo9751AZxh2 = interfaceC2998UyM9766cMLeY.mo9751AZxh();
                interfaceC2998UyM9766cMLeY.mo9776xJ(objMo9751AZxh2, object2);
                unsafe.putObject(obj, j, objMo9751AZxh2);
                object2 = objMo9751AZxh2;
            }
            interfaceC2998UyM9766cMLeY.mo9776xJ(object2, object);
        }
    }

    /* renamed from: IEE */
    public final boolean m9753IEE(Object obj, int i) {
        int iM9759OjSQV = m9759OjSQV(i);
        long j = iM9759OjSQV & 1048575;
        if (j != 1048575) {
            return ((1 << (iM9759OjSQV >>> 20)) & AbstractC4518rz.m13423lgHUyS(obj, j)) != 0;
        }
        int iM9777xrEuO = m9777xrEuO(i);
        long j2 = iM9777xrEuO & 1048575;
        switch (m9738CqaNbM(iM9777xrEuO)) {
            case 0:
                return Double.doubleToRawLongBits(AbstractC4518rz.m13409JHa(obj, j2)) != 0;
            case 1:
                return Float.floatToRawIntBits(AbstractC4518rz.m13432xJ(obj, j2)) != 0;
            case 2:
                return AbstractC4518rz.m13427qdMbNW(obj, j2) != 0;
            case 3:
                return AbstractC4518rz.m13427qdMbNW(obj, j2) != 0;
            case 4:
                return AbstractC4518rz.m13423lgHUyS(obj, j2) != 0;
            case 5:
                return AbstractC4518rz.m13427qdMbNW(obj, j2) != 0;
            case 6:
                return AbstractC4518rz.m13423lgHUyS(obj, j2) != 0;
            case 7:
                return AbstractC4518rz.m13403BAnRFn(obj, j2);
            case 8:
                Object objM13405ETF = AbstractC4518rz.m13405ETF(obj, j2);
                if (objM13405ETF instanceof String) {
                    return !((String) objM13405ETF).isEmpty();
                }
                if (objM13405ETF instanceof AbstractC4981yx) {
                    return !AbstractC4981yx.f17599AZxh.mo13973equals(objM13405ETF);
                }
                throw new IllegalArgumentException();
            case 9:
                return AbstractC4518rz.m13405ETF(obj, j2) != null;
            case 10:
                return !AbstractC4981yx.f17599AZxh.mo13973equals(AbstractC4518rz.m13405ETF(obj, j2));
            case 11:
                return AbstractC4518rz.m13423lgHUyS(obj, j2) != 0;
            case 12:
                return AbstractC4518rz.m13423lgHUyS(obj, j2) != 0;
            case 13:
                return AbstractC4518rz.m13423lgHUyS(obj, j2) != 0;
            case 14:
                return AbstractC4518rz.m13427qdMbNW(obj, j2) != 0;
            case 15:
                return AbstractC4518rz.m13423lgHUyS(obj, j2) != 0;
            case 16:
                return AbstractC4518rz.m13427qdMbNW(obj, j2) != 0;
            case 17:
                return AbstractC4518rz.m13405ETF(obj, j2) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: JHa */
    public final int mo9754JHa(Object obj) {
        int i;
        long jDoubleToLongBits;
        int iFloatToIntBits;
        int i2;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f9844mjFkc.length; i4 += 3) {
            int iM9777xrEuO = m9777xrEuO(i4);
            int[] iArr = this.f9844mjFkc;
            int i5 = 1048575 & iM9777xrEuO;
            int iM9738CqaNbM = m9738CqaNbM(iM9777xrEuO);
            int i6 = iArr[i4];
            long j = i5;
            int iHashCode = 37;
            switch (iM9738CqaNbM) {
                case 0:
                    i = i3 * 53;
                    jDoubleToLongBits = Double.doubleToLongBits(AbstractC4518rz.m13409JHa(obj, j));
                    Charset charset = AbstractC4183my.f15287mjFkc;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 1:
                    i = i3 * 53;
                    iFloatToIntBits = Float.floatToIntBits(AbstractC4518rz.m13432xJ(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 2:
                    i = i3 * 53;
                    jDoubleToLongBits = AbstractC4518rz.m13427qdMbNW(obj, j);
                    Charset charset2 = AbstractC4183my.f15287mjFkc;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 3:
                    i = i3 * 53;
                    jDoubleToLongBits = AbstractC4518rz.m13427qdMbNW(obj, j);
                    Charset charset3 = AbstractC4183my.f15287mjFkc;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 4:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4518rz.m13423lgHUyS(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 5:
                    i = i3 * 53;
                    jDoubleToLongBits = AbstractC4518rz.m13427qdMbNW(obj, j);
                    Charset charset4 = AbstractC4183my.f15287mjFkc;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 6:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4518rz.m13423lgHUyS(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 7:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4183my.m12817mjFkc(AbstractC4518rz.m13403BAnRFn(obj, j));
                    i3 = i + iFloatToIntBits;
                    break;
                case 8:
                    i = i3 * 53;
                    iFloatToIntBits = ((String) AbstractC4518rz.m13405ETF(obj, j)).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 9:
                    i2 = i3 * 53;
                    Object objM13405ETF = AbstractC4518rz.m13405ETF(obj, j);
                    if (objM13405ETF != null) {
                        iHashCode = objM13405ETF.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 10:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4518rz.m13405ETF(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 11:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4518rz.m13423lgHUyS(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 12:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4518rz.m13423lgHUyS(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 13:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4518rz.m13423lgHUyS(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 14:
                    i = i3 * 53;
                    jDoubleToLongBits = AbstractC4518rz.m13427qdMbNW(obj, j);
                    Charset charset5 = AbstractC4183my.f15287mjFkc;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 15:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4518rz.m13423lgHUyS(obj, j);
                    i3 = i + iFloatToIntBits;
                    break;
                case 16:
                    i = i3 * 53;
                    jDoubleToLongBits = AbstractC4518rz.m13427qdMbNW(obj, j);
                    Charset charset6 = AbstractC4183my.f15287mjFkc;
                    iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                    i3 = i + iFloatToIntBits;
                    break;
                case 17:
                    i2 = i3 * 53;
                    Object objM13405ETF2 = AbstractC4518rz.m13405ETF(obj, j);
                    if (objM13405ETF2 != null) {
                        iHashCode = objM13405ETF2.hashCode();
                    }
                    i3 = i2 + iHashCode;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                case 40:
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                case 46:
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                case 48:
                case 49:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4518rz.m13405ETF(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case 50:
                    i = i3 * 53;
                    iFloatToIntBits = AbstractC4518rz.m13405ETF(obj, j).hashCode();
                    i3 = i + iFloatToIntBits;
                    break;
                case C5125EACTags.TRANSACTION_DATE /* 51 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = Double.doubleToLongBits(m9747lB(obj, j));
                        Charset charset7 = AbstractC4183my.f15287mjFkc;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = Float.floatToIntBits(m9750wJVbdd(obj, j));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18346SEX /* 53 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = m9742KLMXS(obj, j);
                        Charset charset8 = AbstractC4183my.f15287mjFkc;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = m9742KLMXS(obj, j);
                        Charset charset9 = AbstractC4183my.f15287mjFkc;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = m9748mByQ(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = m9742KLMXS(obj, j);
                        Charset charset10 = AbstractC4183my.f15287mjFkc;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = m9748mByQ(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = AbstractC4183my.m12817mjFkc(m9746huTpC(obj, j));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = ((String) AbstractC4518rz.m13405ETF(obj, j)).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = AbstractC4518rz.m13405ETF(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = AbstractC4518rz.m13405ETF(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = m9748mByQ(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = m9748mByQ(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = m9748mByQ(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = m9742KLMXS(obj, j);
                        Charset charset11 = AbstractC4183my.f15287mjFkc;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = m9748mByQ(obj, j);
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        jDoubleToLongBits = m9742KLMXS(obj, j);
                        Charset charset12 = AbstractC4183my.f15287mjFkc;
                        iFloatToIntBits = (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    if (m9761Ucbh(obj, i6, i4)) {
                        i = i3 * 53;
                        iFloatToIntBits = AbstractC4518rz.m13405ETF(obj, j).hashCode();
                        i3 = i + iFloatToIntBits;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int iHashCode2 = (i3 * 53) + ((AbstractC3595dy) obj).f13418zbc.hashCode();
        return this.f9840JHa ? (iHashCode2 * 53) + ((AbstractC3330Zx) obj).f12261zbb.f10131mjFkc.hashCode() : iHashCode2;
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: KLFTb */
    public final void mo9755KLFTb(Object obj, byte[] bArr, int i, int i2, C4117lx c4117lx) {
        m9774vI(obj, bArr, i, i2, 0, c4117lx);
    }

    /* renamed from: MiMN */
    public final void m9756MiMN(Object obj, int i) {
        int iM9759OjSQV = m9759OjSQV(i);
        long j = 1048575 & iM9759OjSQV;
        if (j == 1048575) {
            return;
        }
        AbstractC4518rz.m13413Ucbh(obj, j, (1 << (iM9759OjSQV >>> 20)) | AbstractC4518rz.m13423lgHUyS(obj, j));
    }

    /* renamed from: NPj */
    public final Object m9757NPj(Object obj, int i, int i2) {
        InterfaceC2998Uy interfaceC2998UyM9766cMLeY = m9766cMLeY(i2);
        if (!m9761Ucbh(obj, i, i2)) {
            return interfaceC2998UyM9766cMLeY.mo9751AZxh();
        }
        Object object = f9835MiMN.getObject(obj, m9777xrEuO(i2) & 1048575);
        if (m9745eyqo(object)) {
            return object;
        }
        Object objMo9751AZxh = interfaceC2998UyM9766cMLeY.mo9751AZxh();
        if (object != null) {
            interfaceC2998UyM9766cMLeY.mo9776xJ(objMo9751AZxh, object);
        }
        return objMo9751AZxh;
    }

    /* renamed from: Ne */
    public final int m9758Ne(int i, int i2) {
        int length = (this.f9844mjFkc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.f9844mjFkc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }

    /* renamed from: OjSQV */
    public final int m9759OjSQV(int i) {
        return this.f9844mjFkc[i + 2];
    }

    /* renamed from: Pq */
    public final boolean m9760Pq(Object obj, int i, int i2, int i3, int i4) {
        return i2 == 1048575 ? m9753IEE(obj, i) : (i3 & i4) != 0;
    }

    /* renamed from: Ucbh */
    public final boolean m9761Ucbh(Object obj, int i, int i2) {
        return AbstractC4518rz.m13423lgHUyS(obj, (long) (m9759OjSQV(i2) & 1048575)) == i;
    }

    /* renamed from: VA */
    public final void m9762VA(Object obj, Object obj2, int i) {
        int i2 = this.f9844mjFkc[i];
        if (m9761Ucbh(obj2, i2, i)) {
            int iM9777xrEuO = m9777xrEuO(i) & 1048575;
            Unsafe unsafe = f9835MiMN;
            long j = iM9777xrEuO;
            Object object = unsafe.getObject(obj2, j);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + this.f9844mjFkc[i] + " is present but null: " + obj2.toString());
            }
            InterfaceC2998Uy interfaceC2998UyM9766cMLeY = m9766cMLeY(i);
            if (!m9761Ucbh(obj, i2, i)) {
                if (m9745eyqo(object)) {
                    Object objMo9751AZxh = interfaceC2998UyM9766cMLeY.mo9751AZxh();
                    interfaceC2998UyM9766cMLeY.mo9776xJ(objMo9751AZxh, object);
                    unsafe.putObject(obj, j, objMo9751AZxh);
                } else {
                    unsafe.putObject(obj, j, object);
                }
                m9764YoKzxo(obj, i2, i);
                return;
            }
            Object object2 = unsafe.getObject(obj, j);
            if (!m9745eyqo(object2)) {
                Object objMo9751AZxh2 = interfaceC2998UyM9766cMLeY.mo9751AZxh();
                interfaceC2998UyM9766cMLeY.mo9776xJ(objMo9751AZxh2, object2);
                unsafe.putObject(obj, j, objMo9751AZxh2);
                object2 = objMo9751AZxh2;
            }
            interfaceC2998UyM9766cMLeY.mo9776xJ(object2, object);
        }
    }

    /* renamed from: Vnb */
    public final Object m9763Vnb(Object obj, int i) {
        InterfaceC2998Uy interfaceC2998UyM9766cMLeY = m9766cMLeY(i);
        int iM9777xrEuO = m9777xrEuO(i) & 1048575;
        if (!m9753IEE(obj, i)) {
            return interfaceC2998UyM9766cMLeY.mo9751AZxh();
        }
        Object object = f9835MiMN.getObject(obj, iM9777xrEuO);
        if (m9745eyqo(object)) {
            return object;
        }
        Object objMo9751AZxh = interfaceC2998UyM9766cMLeY.mo9751AZxh();
        if (object != null) {
            interfaceC2998UyM9766cMLeY.mo9776xJ(objMo9751AZxh, object);
        }
        return objMo9751AZxh;
    }

    /* renamed from: YoKzxo */
    public final void m9764YoKzxo(Object obj, int i, int i2) {
        AbstractC4518rz.m13413Ucbh(obj, m9759OjSQV(i2) & 1048575, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00ce  */
    @Override // p131o.InterfaceC2998Uy
    /* renamed from: ZfxDd */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean mo9765ZfxDd(Object obj) {
        int i;
        int i2;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1048575;
        while (i4 < this.f9843lgHUyS) {
            int[] iArr = this.f9847xJ;
            int[] iArr2 = this.f9844mjFkc;
            int i6 = iArr[i4];
            int i7 = iArr2[i6];
            int iM9777xrEuO = m9777xrEuO(i6);
            int i8 = this.f9844mjFkc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i5) {
                if (i9 != 1048575) {
                    i3 = f9835MiMN.getInt(obj, i9);
                }
                i2 = i3;
                i = i9;
            } else {
                i = i5;
                i2 = i3;
            }
            if ((268435456 & iM9777xrEuO) != 0 && !m9760Pq(obj, i6, i, i2, i10)) {
                return false;
            }
            int iM9738CqaNbM = m9738CqaNbM(iM9777xrEuO);
            if (iM9738CqaNbM == 9 || iM9738CqaNbM == 17) {
                if (m9760Pq(obj, i6, i, i2, i10) && !m9744diqgf(obj, iM9777xrEuO, m9766cMLeY(i6))) {
                    return false;
                }
            } else if (iM9738CqaNbM == 27) {
                List list = (List) AbstractC4518rz.m13405ETF(obj, iM9777xrEuO & 1048575);
                if (list.isEmpty()) {
                    continue;
                } else {
                    InterfaceC2998Uy interfaceC2998UyM9766cMLeY = m9766cMLeY(i6);
                    for (int i11 = 0; i11 < list.size(); i11++) {
                        if (!interfaceC2998UyM9766cMLeY.mo9765ZfxDd(list.get(i11))) {
                            return false;
                        }
                    }
                }
            } else if (iM9738CqaNbM == 60 || iM9738CqaNbM == 68) {
                if (m9761Ucbh(obj, i7, i6) && !m9744diqgf(obj, iM9777xrEuO, m9766cMLeY(i6))) {
                    return false;
                }
            } else if (iM9738CqaNbM != 49) {
                if (iM9738CqaNbM != 50) {
                    continue;
                } else {
                    C1927Ey c1927Ey = (C1927Ey) AbstractC4518rz.m13405ETF(obj, iM9777xrEuO & 1048575);
                    if (!c1927Ey.isEmpty() && ((C1858Dy) m9772rWxwaT(i6)).m8099wA().f7770wA.m13803KLFTb() == EnumC4851wz.MESSAGE) {
                        InterfaceC2998Uy interfaceC2998UyM10117AZxh = null;
                        for (Object obj2 : c1927Ey.values()) {
                            if (interfaceC2998UyM10117AZxh == null) {
                                interfaceC2998UyM10117AZxh = C2796Ry.m10116mjFkc().m10117AZxh(obj2.getClass());
                            }
                            if (!interfaceC2998UyM10117AZxh.mo9765ZfxDd(obj2)) {
                                return false;
                            }
                        }
                    }
                }
            }
            i4++;
            i5 = i;
            i3 = i2;
        }
        return !this.f9840JHa || ((AbstractC3330Zx) obj).f12261zbb.m9980MiMN();
    }

    /* renamed from: cMLeY */
    public final InterfaceC2998Uy m9766cMLeY(int i) {
        Object[] objArr = this.f9837AZxh;
        int i2 = i / 3;
        int i3 = i2 + i2;
        InterfaceC2998Uy interfaceC2998Uy = (InterfaceC2998Uy) objArr[i3];
        if (interfaceC2998Uy != null) {
            return interfaceC2998Uy;
        }
        InterfaceC2998Uy interfaceC2998UyM10117AZxh = C2796Ry.m10116mjFkc().m10117AZxh((Class) objArr[i3 + 1]);
        this.f9837AZxh[i3] = interfaceC2998UyM10117AZxh;
        return interfaceC2998UyM10117AZxh;
    }

    /* renamed from: fehf */
    public final boolean m9767fehf(Object obj, Object obj2, int i) {
        return m9753IEE(obj, i) == m9753IEE(obj2, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0071  */
    @Override // p131o.InterfaceC2998Uy
    /* renamed from: lgHUyS */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo9768lgHUyS(Object obj) {
        if (m9745eyqo(obj)) {
            if (obj instanceof AbstractC3595dy) {
                AbstractC3595dy abstractC3595dy = (AbstractC3595dy) obj;
                abstractC3595dy.m11770rkYL(Integer.MAX_VALUE);
                abstractC3595dy.f13508zba = 0;
                abstractC3595dy.m11762MiMN();
            }
            int[] iArr = this.f9844mjFkc;
            for (int i = 0; i < iArr.length; i += 3) {
                int iM9777xrEuO = m9777xrEuO(i);
                int i2 = 1048575 & iM9777xrEuO;
                int iM9738CqaNbM = m9738CqaNbM(iM9777xrEuO);
                long j = i2;
                if (iM9738CqaNbM != 9) {
                    if (iM9738CqaNbM != 60 && iM9738CqaNbM != 68) {
                        switch (iM9738CqaNbM) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case InterfaceC5102BERTags.f17975DATE /* 31 */:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                            case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                            case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                            case 40:
                            case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                            case C5125EACTags.CURRENCY_CODE /* 42 */:
                            case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                            case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                            case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                            case 46:
                            case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                            case 48:
                            case 49:
                                ((InterfaceC4118ly) AbstractC4518rz.m13405ETF(obj, j)).mo11970wA();
                                break;
                            case 50:
                                Unsafe unsafe = f9835MiMN;
                                Object object = unsafe.getObject(obj, j);
                                if (object != null) {
                                    ((C1927Ey) object).m8241wA();
                                    unsafe.putObject(obj, j, object);
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (m9761Ucbh(obj, this.f9844mjFkc[i], i)) {
                        m9766cMLeY(i).mo9768lgHUyS(f9835MiMN.getObject(obj, j));
                    }
                } else if (m9753IEE(obj, i)) {
                    m9766cMLeY(i).mo9768lgHUyS(f9835MiMN.getObject(obj, j));
                }
            }
            this.f9838Dt.mo12454AZxh(obj);
            if (this.f9840JHa) {
                this.f9839ETF.mo9398mjFkc(obj);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e9  */
    @Override // p131o.InterfaceC2998Uy
    /* renamed from: mjFkc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int mo9769mjFkc(Object obj) {
        int i;
        int i2;
        int i3;
        int iM8470ZfxDd;
        int iM8470ZfxDd2;
        int iM8470ZfxDd3;
        int iM8468KLFTb;
        int iM8470ZfxDd4;
        int iM8470ZfxDd5;
        int iMo13326JHa;
        int iM8470ZfxDd6;
        int iM10862MiMN;
        int size;
        int iM8470ZfxDd7;
        int iM8470ZfxDd8;
        int iM8470ZfxDd9;
        int iM8470ZfxDd10;
        int iM10855Dt;
        int iM8470ZfxDd11;
        int iM8470ZfxDd12;
        int iM8469Ne;
        Unsafe unsafe = f9835MiMN;
        boolean z = 0;
        int i4 = 1048575;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 1048575;
        while (i6 < this.f9844mjFkc.length) {
            int iM9777xrEuO = m9777xrEuO(i6);
            int iM9738CqaNbM = m9738CqaNbM(iM9777xrEuO);
            int[] iArr = this.f9844mjFkc;
            int i9 = iArr[i6];
            int i10 = iArr[i6 + 2];
            int i11 = i10 & i4;
            if (iM9738CqaNbM <= 17) {
                if (i11 != i8) {
                    i5 = i11 == i4 ? z : unsafe.getInt(obj, i11);
                    i8 = i11;
                }
                i = i8;
                i2 = i5;
                i3 = 1 << (i10 >>> 20);
            } else {
                i = i8;
                i2 = i5;
                i3 = z;
            }
            int i12 = iM9777xrEuO & i4;
            if (iM9738CqaNbM >= EnumC2728Qx.f10351zvd.m10030mjFkc()) {
                EnumC2728Qx.f10309JYgkl.m10030mjFkc();
            }
            long j = i12;
            switch (iM9738CqaNbM) {
                case 0:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd + 8;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd2 + 4;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        long j2 = unsafe.getLong(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(j2);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        long j3 = unsafe.getLong(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(j3);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        long j4 = unsafe.getInt(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(j4);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd + 8;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd2 + 4;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        iM8470ZfxDd4 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd4 + 1;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (!m9760Pq(obj, i6, i, i2, i3)) {
                        break;
                    } else {
                        int i13 = i9 << 3;
                        Object object = unsafe.getObject(obj, j);
                        if (object instanceof AbstractC4981yx) {
                            iM8470ZfxDd5 = AbstractC2063Gx.m8470ZfxDd(i13);
                            iMo13326JHa = ((AbstractC4981yx) object).mo13326JHa();
                            iM8470ZfxDd6 = AbstractC2063Gx.m8470ZfxDd(iMo13326JHa);
                            iM10862MiMN = iM8470ZfxDd5 + iM8470ZfxDd6 + iMo13326JHa;
                            i7 += iM10862MiMN;
                            break;
                        } else {
                            iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i13);
                            iM8468KLFTb = AbstractC2063Gx.m8473wA((String) object);
                            iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                            i7 += iM10862MiMN;
                        }
                    }
                case 9:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        iM10862MiMN = AbstractC3129Wy.m10862MiMN(i9, unsafe.getObject(obj, j), m9766cMLeY(i6));
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 10:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        AbstractC4981yx abstractC4981yx = (AbstractC4981yx) unsafe.getObject(obj, j);
                        iM8470ZfxDd5 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iMo13326JHa = abstractC4981yx.mo13326JHa();
                        iM8470ZfxDd6 = AbstractC2063Gx.m8470ZfxDd(iMo13326JHa);
                        iM10862MiMN = iM8470ZfxDd5 + iM8470ZfxDd6 + iMo13326JHa;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        int i14 = unsafe.getInt(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8470ZfxDd(i14);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        long j5 = unsafe.getInt(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(j5);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd2 + 4;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd + 8;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        int i15 = unsafe.getInt(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8470ZfxDd((i15 >> 31) ^ (i15 + i15));
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        long j6 = unsafe.getLong(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb((j6 >> 63) ^ (j6 + j6));
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 17:
                    if (m9760Pq(obj, i6, i, i2, i3)) {
                        iM10862MiMN = AbstractC2063Gx.m8469Ne(i9, (InterfaceC2341Ky) unsafe.getObject(obj, j), m9766cMLeY(i6));
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 18:
                    iM10862MiMN = AbstractC3129Wy.m10878qdMbNW(i9, (List) unsafe.getObject(obj, j), z);
                    i7 += iM10862MiMN;
                    break;
                case 19:
                    iM10862MiMN = AbstractC3129Wy.m10883xJ(i9, (List) unsafe.getObject(obj, j), z);
                    i7 += iM10862MiMN;
                    break;
                case 20:
                    List list = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz = AbstractC3129Wy.f11513mjFkc;
                    iM8470ZfxDd8 = list.size() == 0 ? z : AbstractC3129Wy.m10865VA(list) + (list.size() * AbstractC2063Gx.m8470ZfxDd(i9 << 3));
                    i7 += iM8470ZfxDd8;
                    break;
                case 21:
                    List list2 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz2 = AbstractC3129Wy.f11513mjFkc;
                    size = list2.size();
                    if (size != 0) {
                        iM8470ZfxDd3 = AbstractC3129Wy.m10871fehf(list2);
                        iM8470ZfxDd7 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = size * iM8470ZfxDd7;
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    }
                    i7 += iM10862MiMN;
                case 22:
                    List list3 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz3 = AbstractC3129Wy.f11513mjFkc;
                    size = list3.size();
                    if (size != 0) {
                        iM8470ZfxDd3 = AbstractC3129Wy.m10856ETF(list3);
                        iM8470ZfxDd7 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = size * iM8470ZfxDd7;
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    }
                    i7 += iM10862MiMN;
                case 23:
                    iM10862MiMN = AbstractC3129Wy.m10878qdMbNW(i9, (List) unsafe.getObject(obj, j), z);
                    i7 += iM10862MiMN;
                    break;
                case 24:
                    iM10862MiMN = AbstractC3129Wy.m10883xJ(i9, (List) unsafe.getObject(obj, j), z);
                    i7 += iM10862MiMN;
                    break;
                case 25:
                    List list4 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz4 = AbstractC3129Wy.f11513mjFkc;
                    int size2 = list4.size();
                    iM10862MiMN = size2 == 0 ? z : size2 * (AbstractC2063Gx.m8470ZfxDd(i9 << 3) + 1);
                    i7 += iM10862MiMN;
                    break;
                case 26:
                    List list5 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz5 = AbstractC3129Wy.f11513mjFkc;
                    int size3 = list5.size();
                    if (size3 != 0) {
                        iM8470ZfxDd8 = AbstractC2063Gx.m8470ZfxDd(i9 << 3) * size3;
                        for (int i16 = z; i16 < size3; i16++) {
                            Object obj2 = list5.get(i16);
                            if (obj2 instanceof AbstractC4981yx) {
                                int iMo13326JHa2 = ((AbstractC4981yx) obj2).mo13326JHa();
                                iM8470ZfxDd8 += AbstractC2063Gx.m8470ZfxDd(iMo13326JHa2) + iMo13326JHa2;
                            } else {
                                iM8470ZfxDd8 += AbstractC2063Gx.m8473wA((String) obj2);
                            }
                        }
                    }
                    i7 += iM8470ZfxDd8;
                    break;
                case 27:
                    List list6 = (List) unsafe.getObject(obj, j);
                    InterfaceC2998Uy interfaceC2998UyM9766cMLeY = m9766cMLeY(i6);
                    AbstractC3989jz abstractC3989jz6 = AbstractC3129Wy.f11513mjFkc;
                    int size4 = list6.size();
                    if (size4 == 0) {
                        iM8470ZfxDd9 = z;
                    } else {
                        iM8470ZfxDd9 = AbstractC2063Gx.m8470ZfxDd(i9 << 3) * size4;
                        for (int i17 = z; i17 < size4; i17++) {
                            iM8470ZfxDd9 += AbstractC2063Gx.m8467AZxh((InterfaceC2341Ky) list6.get(i17), interfaceC2998UyM9766cMLeY);
                        }
                    }
                    i7 += iM8470ZfxDd9;
                    break;
                case 28:
                    List list7 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz7 = AbstractC3129Wy.f11513mjFkc;
                    int size5 = list7.size();
                    if (size5 == 0) {
                        iM8470ZfxDd10 = z;
                    } else {
                        iM8470ZfxDd10 = size5 * AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        for (int i18 = z; i18 < list7.size(); i18++) {
                            int iMo13326JHa3 = ((AbstractC4981yx) list7.get(i18)).mo13326JHa();
                            iM8470ZfxDd10 += AbstractC2063Gx.m8470ZfxDd(iMo13326JHa3) + iMo13326JHa3;
                        }
                    }
                    i7 += iM8470ZfxDd10;
                    break;
                case 29:
                    List list8 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz8 = AbstractC3129Wy.f11513mjFkc;
                    size = list8.size();
                    if (size != 0) {
                        iM8470ZfxDd3 = AbstractC3129Wy.m10877qGY(list8);
                        iM8470ZfxDd7 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = size * iM8470ZfxDd7;
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    }
                    i7 += iM10862MiMN;
                case 30:
                    List list9 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz9 = AbstractC3129Wy.f11513mjFkc;
                    size = list9.size();
                    if (size != 0) {
                        iM8470ZfxDd3 = AbstractC3129Wy.m10860JHa(list9);
                        iM8470ZfxDd7 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = size * iM8470ZfxDd7;
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    }
                    i7 += iM10862MiMN;
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                    iM10862MiMN = AbstractC3129Wy.m10883xJ(i9, (List) unsafe.getObject(obj, j), z);
                    i7 += iM10862MiMN;
                    break;
                case 32:
                    iM10862MiMN = AbstractC3129Wy.m10878qdMbNW(i9, (List) unsafe.getObject(obj, j), z);
                    i7 += iM10862MiMN;
                    break;
                case 33:
                    List list10 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz10 = AbstractC3129Wy.f11513mjFkc;
                    size = list10.size();
                    if (size != 0) {
                        iM8470ZfxDd3 = AbstractC3129Wy.m10867YoKzxo(list10);
                        iM8470ZfxDd7 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = size * iM8470ZfxDd7;
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    }
                    i7 += iM10862MiMN;
                case 34:
                    List list11 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz11 = AbstractC3129Wy.f11513mjFkc;
                    size = list11.size();
                    if (size != 0) {
                        iM8470ZfxDd3 = AbstractC3129Wy.m10879rkYL(list11);
                        iM8470ZfxDd7 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = size * iM8470ZfxDd7;
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    }
                    i7 += iM10862MiMN;
                case 35:
                    iM10855Dt = AbstractC3129Wy.m10855Dt((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case 36:
                    iM10855Dt = AbstractC3129Wy.m10874lgHUyS((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                    iM10855Dt = AbstractC3129Wy.m10865VA((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                    iM10855Dt = AbstractC3129Wy.m10871fehf((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                    iM10855Dt = AbstractC3129Wy.m10856ETF((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case 40:
                    iM10855Dt = AbstractC3129Wy.m10855Dt((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                    iM10855Dt = AbstractC3129Wy.m10874lgHUyS((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                    List list12 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz12 = AbstractC3129Wy.f11513mjFkc;
                    iM10855Dt = list12.size();
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                    iM10855Dt = AbstractC3129Wy.m10877qGY((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                    iM10855Dt = AbstractC3129Wy.m10860JHa((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                    iM10855Dt = AbstractC3129Wy.m10874lgHUyS((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case 46:
                    iM10855Dt = AbstractC3129Wy.m10855Dt((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                    iM10855Dt = AbstractC3129Wy.m10867YoKzxo((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case 48:
                    iM10855Dt = AbstractC3129Wy.m10879rkYL((List) unsafe.getObject(obj, j));
                    if (iM10855Dt > 0) {
                        iM8470ZfxDd11 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8470ZfxDd12 = AbstractC2063Gx.m8470ZfxDd(iM10855Dt);
                        iM8470ZfxDd10 = iM8470ZfxDd11 + iM8470ZfxDd12 + iM10855Dt;
                        i7 += iM8470ZfxDd10;
                        break;
                    } else {
                        break;
                    }
                case 49:
                    List list13 = (List) unsafe.getObject(obj, j);
                    InterfaceC2998Uy interfaceC2998UyM9766cMLeY2 = m9766cMLeY(i6);
                    AbstractC3989jz abstractC3989jz13 = AbstractC3129Wy.f11513mjFkc;
                    int size6 = list13.size();
                    if (size6 == 0) {
                        iM8469Ne = z;
                    } else {
                        int i19 = z;
                        iM8469Ne = i19;
                        while (i19 < size6) {
                            iM8469Ne += AbstractC2063Gx.m8469Ne(i9, (InterfaceC2341Ky) list13.get(i19), interfaceC2998UyM9766cMLeY2);
                            i19++;
                        }
                    }
                    i7 += iM8469Ne;
                    break;
                case 50:
                    C1927Ey c1927Ey = (C1927Ey) unsafe.getObject(obj, j);
                    C1858Dy c1858Dy = (C1858Dy) m9772rWxwaT(i6);
                    if (!c1927Ey.isEmpty()) {
                        iM8470ZfxDd8 = z;
                        for (Map.Entry entry : c1927Ey.entrySet()) {
                            iM8470ZfxDd8 += c1858Dy.m8098mjFkc(i9, entry.getKey(), entry.getValue());
                        }
                    }
                    i7 += iM8470ZfxDd8;
                    break;
                case C5125EACTags.TRANSACTION_DATE /* 51 */:
                    if (m9761Ucbh(obj, i9, i6)) {
                        iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd + 8;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    if (m9761Ucbh(obj, i9, i6)) {
                        iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd2 + 4;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18346SEX /* 53 */:
                    if (m9761Ucbh(obj, i9, i6)) {
                        long jM9742KLMXS = m9742KLMXS(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(jM9742KLMXS);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (m9761Ucbh(obj, i9, i6)) {
                        long jM9742KLMXS2 = m9742KLMXS(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(jM9742KLMXS2);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (m9761Ucbh(obj, i9, i6)) {
                        long jM9748mByQ = m9748mByQ(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(jM9748mByQ);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (m9761Ucbh(obj, i9, i6)) {
                        iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd + 8;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (m9761Ucbh(obj, i9, i6)) {
                        iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd2 + 4;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    if (m9761Ucbh(obj, i9, i6)) {
                        iM8470ZfxDd4 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd4 + 1;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (!m9761Ucbh(obj, i9, i6)) {
                        break;
                    } else {
                        int i20 = i9 << 3;
                        Object object2 = unsafe.getObject(obj, j);
                        if (object2 instanceof AbstractC4981yx) {
                            iM8470ZfxDd5 = AbstractC2063Gx.m8470ZfxDd(i20);
                            iMo13326JHa = ((AbstractC4981yx) object2).mo13326JHa();
                            iM8470ZfxDd6 = AbstractC2063Gx.m8470ZfxDd(iMo13326JHa);
                            iM10862MiMN = iM8470ZfxDd5 + iM8470ZfxDd6 + iMo13326JHa;
                            i7 += iM10862MiMN;
                            break;
                        } else {
                            iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i20);
                            iM8468KLFTb = AbstractC2063Gx.m8473wA((String) object2);
                            iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                            i7 += iM10862MiMN;
                        }
                    }
                case 60:
                    if (m9761Ucbh(obj, i9, i6)) {
                        iM10862MiMN = AbstractC3129Wy.m10862MiMN(i9, unsafe.getObject(obj, j), m9766cMLeY(i6));
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (m9761Ucbh(obj, i9, i6)) {
                        AbstractC4981yx abstractC4981yx2 = (AbstractC4981yx) unsafe.getObject(obj, j);
                        iM8470ZfxDd5 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iMo13326JHa = abstractC4981yx2.mo13326JHa();
                        iM8470ZfxDd6 = AbstractC2063Gx.m8470ZfxDd(iMo13326JHa);
                        iM10862MiMN = iM8470ZfxDd5 + iM8470ZfxDd6 + iMo13326JHa;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (m9761Ucbh(obj, i9, i6)) {
                        int iM9748mByQ = m9748mByQ(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8470ZfxDd(iM9748mByQ);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (m9761Ucbh(obj, i9, i6)) {
                        long jM9748mByQ2 = m9748mByQ(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(jM9748mByQ2);
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (m9761Ucbh(obj, i9, i6)) {
                        iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd2 + 4;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (m9761Ucbh(obj, i9, i6)) {
                        iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM10862MiMN = iM8470ZfxDd + 8;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    if (m9761Ucbh(obj, i9, i6)) {
                        int iM9748mByQ2 = m9748mByQ(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8470ZfxDd((iM9748mByQ2 >> 31) ^ (iM9748mByQ2 + iM9748mByQ2));
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (m9761Ucbh(obj, i9, i6)) {
                        long jM9742KLMXS3 = m9742KLMXS(obj, j);
                        iM8470ZfxDd3 = AbstractC2063Gx.m8470ZfxDd(i9 << 3);
                        iM8468KLFTb = AbstractC2063Gx.m8468KLFTb((jM9742KLMXS3 >> 63) ^ (jM9742KLMXS3 + jM9742KLMXS3));
                        iM10862MiMN = iM8470ZfxDd3 + iM8468KLFTb;
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    if (m9761Ucbh(obj, i9, i6)) {
                        iM10862MiMN = AbstractC2063Gx.m8469Ne(i9, (InterfaceC2341Ky) unsafe.getObject(obj, j), m9766cMLeY(i6));
                        i7 += iM10862MiMN;
                        break;
                    } else {
                        break;
                    }
            }
            i6 += 3;
            i8 = i;
            i5 = i2;
            z = 0;
            i4 = 1048575;
        }
        int iM12644mjFkc = i7 + ((AbstractC3595dy) obj).f13418zbc.m12644mjFkc();
        if (!this.f9840JHa) {
            return iM12644mjFkc;
        }
        C2664Px c2664Px = ((AbstractC3330Zx) obj).f12261zbb;
        int iM12129wA = c2664Px.f10131mjFkc.m12129wA();
        int iM9971AZxh = 0;
        for (int i21 = 0; i21 < iM12129wA; i21++) {
            Map.Entry entryM12130xJ = c2664Px.f10131mjFkc.m12130xJ(i21);
            iM9971AZxh += C2664Px.m9971AZxh((InterfaceC2601Ox) ((C3400az) entryM12130xJ).m11437KLFTb(), entryM12130xJ.getValue());
        }
        for (Map.Entry entry2 : c2664Px.f10131mjFkc.m12127ZfxDd()) {
            iM9971AZxh += C2664Px.m9971AZxh((InterfaceC2601Ox) entry2.getKey(), entry2.getValue());
        }
        return iM12644mjFkc + iM9971AZxh;
    }

    /* renamed from: qGY */
    public final void m9770qGY(Object obj, int i, int i2, Object obj2) {
        f9835MiMN.putObject(obj, m9777xrEuO(i2) & 1048575, obj2);
        m9764YoKzxo(obj, i, i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0023  */
    @Override // p131o.InterfaceC2998Uy
    /* renamed from: qdMbNW */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void mo9771qdMbNW(Object obj, InterfaceC4919xz interfaceC4919xz) {
        Map.Entry entry;
        Iterator it;
        int i;
        int i2;
        Map.Entry entry2;
        int i3;
        int i4;
        int i5;
        Iterator it2;
        int[] iArr;
        Map.Entry entry3;
        int i6;
        boolean z;
        if (this.f9840JHa) {
            C2664Px c2664Px = ((AbstractC3330Zx) obj).f12261zbb;
            if (c2664Px.f10131mjFkc.isEmpty()) {
                entry = null;
                it = null;
            } else {
                Iterator itM9989xJ = c2664Px.m9989xJ();
                entry = (Map.Entry) itM9989xJ.next();
                it = itM9989xJ;
            }
        }
        int[] iArr2 = this.f9844mjFkc;
        Unsafe unsafe = f9835MiMN;
        int i7 = 1048575;
        int i8 = 1048575;
        int i9 = 0;
        int i10 = 0;
        while (i10 < iArr2.length) {
            int iM9777xrEuO = m9777xrEuO(i10);
            int[] iArr3 = this.f9844mjFkc;
            int iM9738CqaNbM = m9738CqaNbM(iM9777xrEuO);
            int i11 = iArr3[i10];
            if (iM9738CqaNbM <= 17) {
                int i12 = iArr3[i10 + 2];
                int i13 = i12 & i7;
                if (i13 != i8) {
                    if (i13 == i7) {
                        i = i11;
                        i9 = 0;
                    } else {
                        i = i11;
                        i9 = unsafe.getInt(obj, i13);
                    }
                    i8 = i13;
                } else {
                    i = i11;
                }
                i2 = i8;
                entry2 = entry;
                i3 = i9;
                i4 = 1 << (i12 >>> 20);
            } else {
                i = i11;
                i2 = i8;
                entry2 = entry;
                i3 = i9;
                i4 = 0;
            }
            while (true) {
                if (entry2 != null) {
                    i5 = i;
                    if (i5 >= 32149011) {
                        this.f9839ETF.mo9397AZxh(interfaceC4919xz, entry2);
                        if (it.hasNext()) {
                            entry2 = (Map.Entry) it.next();
                            i = i5;
                        } else {
                            i = i5;
                            entry2 = null;
                        }
                    }
                } else {
                    i5 = i;
                }
            }
            long j = iM9777xrEuO & 1048575;
            switch (iM9738CqaNbM) {
                case 0:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i14 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8614diqgf(i14, AbstractC4518rz.m13409JHa(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 1:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i15 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8617huTpC(i15, AbstractC4518rz.m13432xJ(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 2:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i16 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8603KLMXS(i16, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 3:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i17 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8615eyqo(i17, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 4:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i18 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8622qGY(i18, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 5:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i19 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8619lgHUyS(i19, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 6:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i20 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8618lB(i20, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 7:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i21 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8594BAnRFn(i21, AbstractC4518rz.m13403BAnRFn(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 8:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i22 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        m9741HGpJ(i22, unsafe.getObject(obj, j), interfaceC4919xz);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i23 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8597ETF(i23, unsafe.getObject(obj, j), m9766cMLeY(i6));
                        break;
                    } else {
                        break;
                    }
                case 10:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i24 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8595CqaNbM(i24, (AbstractC4981yx) unsafe.getObject(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 11:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i25 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8626wA(i25, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 12:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i26 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8609VA(i26, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 13:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i27 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8621mjFkc(i27, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 14:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i28 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8629xrEuO(i28, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 15:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i29 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8600IEE(i29, unsafe.getInt(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 16:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    int i30 = i5;
                    i6 = i10;
                    if (m9760Pq(obj, i6, i2, i3, i4)) {
                        interfaceC4919xz.mo8620mByQ(i30, unsafe.getLong(obj, j));
                        break;
                    } else {
                        break;
                    }
                case 17:
                    it2 = it;
                    iArr = iArr2;
                    int i31 = i5;
                    entry3 = entry2;
                    i6 = i10;
                    if (m9760Pq(obj, i10, i2, i3, i4)) {
                        interfaceC4919xz.mo8605Ne(i31, unsafe.getObject(obj, j), m9766cMLeY(i6));
                        break;
                    } else {
                        break;
                    }
                case 18:
                    z = false;
                    AbstractC3129Wy.m10872huTpC(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 19:
                    z = false;
                    AbstractC3129Wy.m10866VocHEe(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 20:
                    z = false;
                    AbstractC3129Wy.m10873lB(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 21:
                    z = false;
                    AbstractC3129Wy.m10868ZfxDd(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 22:
                    z = false;
                    AbstractC3129Wy.m10854BAnRFn(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 23:
                    z = false;
                    AbstractC3129Wy.m10880vI(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 24:
                    z = false;
                    AbstractC3129Wy.m10858HGpJ(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 25:
                    z = false;
                    AbstractC3129Wy.m10864Ucbh(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 26:
                    int i32 = this.f9844mjFkc[i10];
                    List list = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz = AbstractC3129Wy.f11513mjFkc;
                    if (list != null && !list.isEmpty()) {
                        interfaceC4919xz.mo8623qdMbNW(i32, list);
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 27:
                    int i33 = this.f9844mjFkc[i10];
                    List list2 = (List) unsafe.getObject(obj, j);
                    InterfaceC2998Uy interfaceC2998UyM9766cMLeY = m9766cMLeY(i10);
                    AbstractC3989jz abstractC3989jz2 = AbstractC3129Wy.f11513mjFkc;
                    if (list2 != null && !list2.isEmpty()) {
                        for (int i34 = 0; i34 < list2.size(); i34++) {
                            ((C2131Hx) interfaceC4919xz).mo8597ETF(i33, list2.get(i34), interfaceC2998UyM9766cMLeY);
                        }
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 28:
                    int i35 = this.f9844mjFkc[i10];
                    List list3 = (List) unsafe.getObject(obj, j);
                    AbstractC3989jz abstractC3989jz3 = AbstractC3129Wy.f11513mjFkc;
                    if (list3 != null && !list3.isEmpty()) {
                        interfaceC4919xz.mo8608Ucbh(i35, list3);
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 29:
                    z = false;
                    AbstractC3129Wy.m10881wA(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 30:
                    z = false;
                    AbstractC3129Wy.m10857Gd(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                    z = false;
                    AbstractC3129Wy.m10882wJVbdd(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 32:
                    z = false;
                    AbstractC3129Wy.m10875mByQ(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 33:
                    z = false;
                    AbstractC3129Wy.m10876mjFkc(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 34:
                    z = false;
                    AbstractC3129Wy.m10853AZxh(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, false);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 35:
                    AbstractC3129Wy.m10872huTpC(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 36:
                    AbstractC3129Wy.m10866VocHEe(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                    AbstractC3129Wy.m10873lB(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                    AbstractC3129Wy.m10868ZfxDd(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                    AbstractC3129Wy.m10854BAnRFn(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 40:
                    AbstractC3129Wy.m10880vI(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                    AbstractC3129Wy.m10858HGpJ(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                    AbstractC3129Wy.m10864Ucbh(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                    AbstractC3129Wy.m10881wA(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                    AbstractC3129Wy.m10857Gd(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                    AbstractC3129Wy.m10882wJVbdd(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 46:
                    AbstractC3129Wy.m10875mByQ(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                    AbstractC3129Wy.m10876mjFkc(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 48:
                    AbstractC3129Wy.m10853AZxh(this.f9844mjFkc[i10], (List) unsafe.getObject(obj, j), interfaceC4919xz, true);
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 49:
                    int i36 = this.f9844mjFkc[i10];
                    List list4 = (List) unsafe.getObject(obj, j);
                    InterfaceC2998Uy interfaceC2998UyM9766cMLeY2 = m9766cMLeY(i10);
                    AbstractC3989jz abstractC3989jz4 = AbstractC3129Wy.f11513mjFkc;
                    if (list4 != null && !list4.isEmpty()) {
                        for (int i37 = 0; i37 < list4.size(); i37++) {
                            ((C2131Hx) interfaceC4919xz).mo8605Ne(i36, list4.get(i37), interfaceC2998UyM9766cMLeY2);
                        }
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 50:
                    Object object = unsafe.getObject(obj, j);
                    if (object != null) {
                        interfaceC4919xz.mo8602KLFTb(i5, ((C1858Dy) m9772rWxwaT(i10)).m8099wA(), (C1927Ey) object);
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.TRANSACTION_DATE /* 51 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8614diqgf(i5, m9747lB(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8617huTpC(i5, m9750wJVbdd(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.f18346SEX /* 53 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8603KLMXS(i5, m9742KLMXS(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8615eyqo(i5, m9742KLMXS(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 55:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8622qGY(i5, m9748mByQ(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 56:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8619lgHUyS(i5, m9742KLMXS(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 57:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8618lB(i5, m9748mByQ(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8594BAnRFn(i5, m9746huTpC(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        m9741HGpJ(i5, unsafe.getObject(obj, j), interfaceC4919xz);
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 60:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8597ETF(i5, unsafe.getObject(obj, j), m9766cMLeY(i10));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 61:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8595CqaNbM(i5, (AbstractC4981yx) unsafe.getObject(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 62:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8626wA(i5, m9748mByQ(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 63:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8609VA(i5, m9748mByQ(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case 64:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8621mjFkc(i5, m9748mByQ(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8629xrEuO(i5, m9742KLMXS(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.f18344ADDRESS /* 66 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8600IEE(i5, m9748mByQ(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8620mByQ(i5, m9742KLMXS(obj, j));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    if (m9761Ucbh(obj, i5, i10)) {
                        interfaceC4919xz.mo8605Ne(i5, unsafe.getObject(obj, j), m9766cMLeY(i10));
                    }
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
                default:
                    it2 = it;
                    iArr = iArr2;
                    entry3 = entry2;
                    i6 = i10;
                    break;
            }
            i10 = i6 + 3;
            i8 = i2;
            i9 = i3;
            it = it2;
            i7 = 1048575;
            iArr2 = iArr;
            entry = entry3;
        }
        Iterator it3 = it;
        while (entry != null) {
            this.f9839ETF.mo9397AZxh(interfaceC4919xz, entry);
            entry = it3.hasNext() ? (Map.Entry) it3.next() : null;
        }
        ((AbstractC3595dy) obj).f13418zbc.m12640VA(interfaceC4919xz);
    }

    /* renamed from: rWxwaT */
    public final Object m9772rWxwaT(int i) {
        int i2 = i / 3;
        return this.f9837AZxh[i2 + i2];
    }

    /* renamed from: rkYL */
    public final void m9773rkYL(Object obj, int i, Object obj2) {
        f9835MiMN.putObject(obj, m9777xrEuO(i) & 1048575, obj2);
        m9756MiMN(obj, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:444:0x0b73, code lost:
    
        throw new p131o.C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:531:0x0e8e  */
    /* JADX WARN: Removed duplicated region for block: B:538:0x0ee2  */
    /* JADX WARN: Removed duplicated region for block: B:619:0x09e6 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:625:0x0e51 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:627:0x005c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:662:0x09fd A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:667:0x0e6d A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v194 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [o.kz] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r3v109, types: [int] */
    /* renamed from: vI */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m9774vI(Object obj, byte[] bArr, int i, int i2, int i3, C4117lx c4117lx) {
        C2538Ny c2538Ny;
        String str;
        int i4;
        Object obj2;
        Unsafe unsafe;
        int i5;
        int i6;
        int i7;
        int i8;
        InterfaceC3855hy interfaceC3855hyM9778zvd;
        int i9;
        int iM9758Ne;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        Object obj3;
        int i16;
        C4117lx c4117lx2;
        int i17;
        int i18;
        int i19;
        Object obj4;
        C2538Ny c2538Ny2;
        int iM12797Dt;
        int i20;
        Unsafe unsafe2;
        int i21;
        int i22;
        C4117lx c4117lx3;
        Unsafe unsafe3;
        Unsafe unsafe4;
        Unsafe unsafe5;
        int i23;
        byte[] bArr2;
        String str2;
        int i24;
        int i25;
        C4117lx c4117lx4;
        int i26;
        Object obj5;
        byte[] bArr3;
        int i27;
        int i28;
        int i29;
        int i30;
        int iM12798ETF;
        int iM12805YoKzxo;
        int i31;
        boolean z;
        byte[] bArr4;
        int iM12814xJ;
        int iM12798ETF2;
        int i32;
        Object obj6;
        int i33;
        int iM12802MiMN;
        int i34;
        int i35;
        boolean z2;
        int i36;
        int iM12798ETF3;
        Object obj7;
        int i37;
        int i38;
        Object obj8;
        int i39;
        int i40;
        Object obj9;
        int i41;
        byte[] bArr5;
        int i42;
        int iM12805YoKzxo2;
        int i43;
        int i44;
        C2538Ny c2538Ny3 = this;
        Object obj10 = obj;
        byte[] bArr6 = bArr;
        int i45 = i2;
        int i46 = i3;
        C4117lx c4117lx5 = c4117lx;
        int i47 = 3;
        m9739Dt(obj);
        Unsafe unsafe6 = f9835MiMN;
        int i48 = 0;
        int i49 = -1;
        int iM12796AZxh = i;
        int i50 = -1;
        int i51 = 0;
        int i52 = 0;
        int i53 = 0;
        int i54 = 1048575;
        while (true) {
            if (iM12796AZxh < i45) {
                int iM12804VA = iM12796AZxh + 1;
                int i55 = bArr6[iM12796AZxh];
                if (i55 < 0) {
                    iM12804VA = AbstractC4182mx.m12804VA(i55, bArr6, iM12804VA, c4117lx5);
                    i55 = c4117lx5.f14842mjFkc;
                }
                int i56 = i55 >>> 3;
                if (i56 > i50) {
                    iM9758Ne = (i56 < c2538Ny3.f9846wA || i56 > c2538Ny3.f9842ZfxDd) ? i49 : c2538Ny3.m9758Ne(i56, i51 / i47);
                } else if (i56 < c2538Ny3.f9846wA || i56 > c2538Ny3.f9842ZfxDd) {
                    i9 = i49;
                    if (i9 == i49) {
                        int i57 = i55 & 7;
                        int[] iArr = c2538Ny3.f9844mjFkc;
                        int i58 = iArr[i9 + 1];
                        int iM9738CqaNbM = m9738CqaNbM(i58);
                        long j = i58 & 1048575;
                        int i59 = i55;
                        if (iM9738CqaNbM > 17) {
                            int i60 = i56;
                            Unsafe unsafe7 = unsafe6;
                            int i61 = i54;
                            int i62 = i52;
                            i10 = -1;
                            int i63 = i9;
                            C4117lx c4117lx6 = c4117lx5;
                            if (iM9738CqaNbM != 27) {
                                i23 = i61;
                                c4117lx4 = c4117lx6;
                                i51 = i63;
                                if (iM9738CqaNbM > 49) {
                                    bArr2 = bArr;
                                    str = "Failed to parse the message.";
                                    unsafe = unsafe7;
                                    int i64 = i59;
                                    int i65 = i51;
                                    i26 = iM12804VA;
                                    int i66 = i60;
                                    if (iM9738CqaNbM != 50) {
                                        int i67 = i65 + 2;
                                        Unsafe unsafe8 = f9835MiMN;
                                        long j2 = iArr[i67] & 1048575;
                                        switch (iM9738CqaNbM) {
                                            case C5125EACTags.TRANSACTION_DATE /* 51 */:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i11 = i65;
                                                i13 = i66;
                                                i16 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 1) {
                                                    i42 = i41 + 8;
                                                    unsafe8.putObject(obj3, j, Double.valueOf(Double.longBitsToDouble(AbstractC4182mx.m12799IEE(bArr5, i41))));
                                                    unsafe8.putInt(obj3, j2, i13);
                                                    iM12796AZxh = i42;
                                                    if (iM12796AZxh != i41) {
                                                        i15 = i3;
                                                        i17 = iM12796AZxh;
                                                        i12 = i62;
                                                        i54 = i23;
                                                        break;
                                                    } else {
                                                        c2538Ny3 = this;
                                                        i45 = i2;
                                                        i46 = i3;
                                                        i53 = i16;
                                                        c4117lx5 = c4117lx2;
                                                        i50 = i13;
                                                        i51 = i11;
                                                        unsafe6 = unsafe;
                                                        i48 = 0;
                                                        obj10 = obj3;
                                                        bArr6 = bArr5;
                                                        i47 = i14;
                                                        i49 = -1;
                                                        i52 = i62;
                                                        i54 = i23;
                                                        break;
                                                    }
                                                }
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                            case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i11 = i65;
                                                i13 = i66;
                                                i16 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 5) {
                                                    i42 = i41 + 4;
                                                    unsafe8.putObject(obj3, j, Float.valueOf(Float.intBitsToFloat(AbstractC4182mx.m12813wA(bArr5, i41))));
                                                    unsafe8.putInt(obj3, j2, i13);
                                                    iM12796AZxh = i42;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case C5125EACTags.f18346SEX /* 53 */:
                                            case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i11 = i65;
                                                i13 = i66;
                                                i16 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 0) {
                                                    iM12805YoKzxo2 = AbstractC4182mx.m12805YoKzxo(bArr5, i41, c4117lx2);
                                                    unsafe8.putObject(obj3, j, Long.valueOf(c4117lx2.f14839AZxh));
                                                    unsafe8.putInt(obj3, j2, i13);
                                                    iM12796AZxh = iM12805YoKzxo2;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case 55:
                                            case 62:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i11 = i65;
                                                i13 = i66;
                                                i16 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 0) {
                                                    iM12805YoKzxo2 = AbstractC4182mx.m12798ETF(bArr5, i41, c4117lx2);
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(c4117lx2.f14842mjFkc));
                                                    unsafe8.putInt(obj3, j2, i13);
                                                    iM12796AZxh = iM12805YoKzxo2;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case 56:
                                            case C5125EACTags.ELEMENT_LIST /* 65 */:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i11 = i65;
                                                i13 = i66;
                                                i16 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 1) {
                                                    i42 = i41 + 8;
                                                    unsafe8.putObject(obj3, j, Long.valueOf(AbstractC4182mx.m12799IEE(bArr5, i41)));
                                                    unsafe8.putInt(obj3, j2, i13);
                                                    iM12796AZxh = i42;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case 57:
                                            case 64:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i11 = i65;
                                                i13 = i66;
                                                i16 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 5) {
                                                    i42 = i41 + 4;
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(AbstractC4182mx.m12813wA(bArr5, i41)));
                                                    unsafe8.putInt(obj3, j2, i13);
                                                    iM12796AZxh = i42;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i11 = i65;
                                                i13 = i66;
                                                i16 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 0) {
                                                    iM12805YoKzxo2 = AbstractC4182mx.m12805YoKzxo(bArr5, i41, c4117lx2);
                                                    unsafe8.putObject(obj3, j, Boolean.valueOf(c4117lx2.f14839AZxh != 0));
                                                    unsafe8.putInt(obj3, j2, i13);
                                                    iM12796AZxh = iM12805YoKzxo2;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i11 = i65;
                                                i13 = i66;
                                                i16 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 2) {
                                                    int iM12798ETF4 = AbstractC4182mx.m12798ETF(bArr5, i41, c4117lx2);
                                                    int i68 = c4117lx2.f14842mjFkc;
                                                    if (i68 == 0) {
                                                        unsafe8.putObject(obj3, j, BuildConfig.f24315FLAVOR);
                                                    } else {
                                                        int i69 = iM12798ETF4 + i68;
                                                        if ((i58 & PKIFailureInfo.duplicateCertReq) != 0 && !AbstractC4717uz.m13738ZfxDd(bArr5, iM12798ETF4, i69)) {
                                                            throw new C4315oy("Protocol message had invalid UTF-8.");
                                                        }
                                                        unsafe8.putObject(obj3, j, new String(bArr5, iM12798ETF4, i68, AbstractC4183my.f15287mjFkc));
                                                        iM12798ETF4 = i69;
                                                    }
                                                    unsafe8.putInt(obj3, j2, i13);
                                                    iM12796AZxh = iM12798ETF4;
                                                } else {
                                                    iM12796AZxh = i41;
                                                }
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case 60:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i43 = i66;
                                                i44 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 2) {
                                                    Object objM9757NPj = m9757NPj(obj3, i43, i65);
                                                    int iM12810qGY = AbstractC4182mx.m12810qGY(objM9757NPj, m9766cMLeY(i65), bArr, i41, i2, c4117lx);
                                                    m9770qGY(obj3, i43, i65, objM9757NPj);
                                                    iM12796AZxh = iM12810qGY;
                                                    i16 = i44;
                                                    obj3 = obj3;
                                                    i11 = i65;
                                                    i13 = i43;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                } else {
                                                    i11 = i65;
                                                    i13 = i43;
                                                    i16 = i44;
                                                    iM12796AZxh = i41;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                break;
                                            case 61:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i43 = i66;
                                                i44 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 2) {
                                                    iM12796AZxh = AbstractC4182mx.m12809mjFkc(bArr5, i41, c4117lx2);
                                                    unsafe8.putObject(obj3, j, c4117lx2.f14843wA);
                                                    unsafe8.putInt(obj3, j2, i43);
                                                    i11 = i65;
                                                    i13 = i43;
                                                    i16 = i44;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                i11 = i65;
                                                i13 = i43;
                                                i16 = i44;
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case 63:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i43 = i66;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 0) {
                                                    iM12796AZxh = AbstractC4182mx.m12798ETF(bArr5, i41, c4117lx2);
                                                    int i70 = c4117lx2.f14842mjFkc;
                                                    InterfaceC3855hy interfaceC3855hyM9778zvd2 = m9778zvd(i65);
                                                    if (interfaceC3855hyM9778zvd2 == null || interfaceC3855hyM9778zvd2.mo7629mjFkc(i70)) {
                                                        i44 = i64;
                                                        unsafe8.putObject(obj3, j, Integer.valueOf(i70));
                                                        unsafe8.putInt(obj3, j2, i43);
                                                    } else {
                                                        i44 = i64;
                                                        m9743VocHEe(obj).m12637Dt(i44, Long.valueOf(i70));
                                                    }
                                                    i11 = i65;
                                                    i13 = i43;
                                                    i16 = i44;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                i11 = i65;
                                                i13 = i43;
                                                i16 = i64;
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case C5125EACTags.f18344ADDRESS /* 66 */:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i43 = i66;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 0) {
                                                    iM12796AZxh = AbstractC4182mx.m12798ETF(bArr5, i41, c4117lx2);
                                                    unsafe8.putObject(obj3, j, Integer.valueOf(AbstractC1795Cx.m7944mjFkc(c4117lx2.f14842mjFkc)));
                                                    unsafe8.putInt(obj3, j2, i43);
                                                    i11 = i65;
                                                    i13 = i43;
                                                    i16 = i64;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                i11 = i65;
                                                i13 = i43;
                                                i16 = i64;
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i43 = i66;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                if (i57 == 0) {
                                                    iM12796AZxh = AbstractC4182mx.m12805YoKzxo(bArr5, i41, c4117lx2);
                                                    unsafe8.putObject(obj3, j, Long.valueOf(AbstractC1795Cx.m7943AZxh(c4117lx2.f14839AZxh)));
                                                    unsafe8.putInt(obj3, j2, i43);
                                                    i11 = i65;
                                                    i13 = i43;
                                                    i16 = i64;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                i11 = i65;
                                                i13 = i43;
                                                i16 = i64;
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                            case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                                                if (i57 == 3) {
                                                    obj3 = obj;
                                                    i14 = 3;
                                                    i43 = i66;
                                                    Object objM9757NPj2 = m9757NPj(obj3, i43, i65);
                                                    str = str;
                                                    c4117lx2 = c4117lx;
                                                    i41 = i26;
                                                    iM12796AZxh = AbstractC4182mx.m12812rkYL(objM9757NPj2, m9766cMLeY(i65), bArr, i26, i2, (i64 & (-8)) | 4, c4117lx);
                                                    m9770qGY(obj3, i43, i65, objM9757NPj2);
                                                    bArr5 = bArr2;
                                                    i11 = i65;
                                                    i13 = i43;
                                                    i16 = i64;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                } else {
                                                    i14 = 3;
                                                    str = str;
                                                    i41 = i26;
                                                    c4117lx2 = c4117lx;
                                                    obj3 = obj;
                                                    bArr5 = bArr2;
                                                    i11 = i65;
                                                    i13 = i66;
                                                    i16 = i64;
                                                    iM12796AZxh = i41;
                                                    if (iM12796AZxh != i41) {
                                                    }
                                                }
                                                break;
                                            default:
                                                obj3 = obj;
                                                str = str;
                                                i41 = i26;
                                                i11 = i65;
                                                i13 = i66;
                                                i16 = i64;
                                                i14 = 3;
                                                c4117lx2 = c4117lx;
                                                bArr5 = bArr2;
                                                iM12796AZxh = i41;
                                                if (iM12796AZxh != i41) {
                                                }
                                                break;
                                        }
                                    } else if (i57 == 2) {
                                        Unsafe unsafe9 = f9835MiMN;
                                        Object objM9772rWxwaT = m9772rWxwaT(i65);
                                        Object object = unsafe9.getObject(obj10, j);
                                        if (!((C1927Ey) object).m8238JHa()) {
                                            C1927Ey c1927EyM8237AZxh = C1927Ey.m8236mjFkc().m8237AZxh();
                                            C1999Fy.m8336mjFkc(c1927EyM8237AZxh, object);
                                            unsafe9.putObject(obj10, j, c1927EyM8237AZxh);
                                            object = c1927EyM8237AZxh;
                                        }
                                        C1796Cy c1796CyM8099wA = ((C1858Dy) objM9772rWxwaT).m8099wA();
                                        C1927Ey c1927Ey = (C1927Ey) object;
                                        int iM12798ETF5 = AbstractC4182mx.m12798ETF(bArr2, i26, c4117lx4);
                                        int i71 = c4117lx4.f14842mjFkc;
                                        if (i71 >= 0 && i71 <= i2 - iM12798ETF5) {
                                            int i72 = iM12798ETF5 + i71;
                                            Object obj11 = c1796CyM8099wA.f7767AZxh;
                                            Object obj12 = c1796CyM8099wA.f7768ZfxDd;
                                            Object obj13 = obj11;
                                            while (iM12798ETF5 < i72) {
                                                Object obj14 = obj12;
                                                int iM12804VA2 = iM12798ETF5 + 1;
                                                byte b = bArr2[iM12798ETF5];
                                                if (b < 0) {
                                                    obj7 = obj13;
                                                    iM12804VA2 = AbstractC4182mx.m12804VA(b, bArr2, iM12804VA2, c4117lx4);
                                                    b = c4117lx4.f14842mjFkc;
                                                } else {
                                                    obj7 = obj13;
                                                }
                                                int i73 = b >>> 3;
                                                int i74 = b & 7;
                                                int i75 = i72;
                                                if (i73 == 1) {
                                                    i37 = i66;
                                                    i38 = i64;
                                                    obj8 = obj7;
                                                    i39 = i75;
                                                    i40 = i65;
                                                    if (i74 == c1796CyM8099wA.f7769mjFkc.m13804mjFkc()) {
                                                        iM12798ETF5 = m9740Gd(bArr, iM12804VA2, i2, c1796CyM8099wA.f7769mjFkc, null, c4117lx);
                                                        obj13 = c4117lx4.f14843wA;
                                                        obj12 = obj14;
                                                        i72 = i39;
                                                        i65 = i40;
                                                        i66 = i37;
                                                        i64 = i38;
                                                    }
                                                } else if (i73 != 2) {
                                                    obj9 = obj14;
                                                    i37 = i66;
                                                    i38 = i64;
                                                    obj8 = obj7;
                                                    i39 = i75;
                                                    i40 = i65;
                                                    iM12798ETF5 = AbstractC4182mx.m12807fehf(b, bArr2, iM12804VA2, i2, c4117lx4);
                                                    obj12 = obj9;
                                                    obj13 = obj8;
                                                    i72 = i39;
                                                    i65 = i40;
                                                    i66 = i37;
                                                    i64 = i38;
                                                } else if (i74 == c1796CyM8099wA.f7770wA.m13804mjFkc()) {
                                                    obj8 = obj7;
                                                    i37 = i66;
                                                    i39 = i75;
                                                    i38 = i64;
                                                    i40 = i65;
                                                    iM12798ETF5 = m9740Gd(bArr, iM12804VA2, i2, c1796CyM8099wA.f7770wA, c1796CyM8099wA.f7768ZfxDd.getClass(), c4117lx);
                                                    obj12 = c4117lx4.f14843wA;
                                                    obj13 = obj8;
                                                    i72 = i39;
                                                    i65 = i40;
                                                    i66 = i37;
                                                    i64 = i38;
                                                } else {
                                                    i37 = i66;
                                                    i38 = i64;
                                                    obj8 = obj7;
                                                    i39 = i75;
                                                    i40 = i65;
                                                }
                                                obj9 = obj14;
                                                iM12798ETF5 = AbstractC4182mx.m12807fehf(b, bArr2, iM12804VA2, i2, c4117lx4);
                                                obj12 = obj9;
                                                obj13 = obj8;
                                                i72 = i39;
                                                i65 = i40;
                                                i66 = i37;
                                                i64 = i38;
                                            }
                                            Object obj15 = obj12;
                                            Object obj16 = obj13;
                                            int i76 = i72;
                                            int i77 = i66;
                                            int i78 = i64;
                                            int i79 = i65;
                                            if (iM12798ETF5 != i76) {
                                                throw new C4315oy(str);
                                            }
                                            c1927Ey.put(obj16, obj15);
                                            if (i76 != i26) {
                                                obj10 = obj;
                                                i46 = i3;
                                                i45 = i2;
                                                c4117lx5 = c4117lx4;
                                                i51 = i79;
                                                i52 = i62;
                                                i54 = i23;
                                                i49 = -1;
                                                unsafe6 = unsafe;
                                                i53 = i78;
                                                i47 = 3;
                                                i48 = 0;
                                                c2538Ny3 = this;
                                                bArr6 = bArr2;
                                                iM12796AZxh = i76;
                                                i50 = i77;
                                            } else {
                                                obj3 = obj;
                                                i17 = i76;
                                                c4117lx2 = c4117lx4;
                                                i11 = i79;
                                                i12 = i62;
                                                i54 = i23;
                                                i13 = i77;
                                                i16 = i78;
                                                i14 = 3;
                                                i15 = i3;
                                            }
                                        }
                                    } else {
                                        i60 = i66;
                                        i24 = i64;
                                        str2 = str;
                                        i25 = i65;
                                        obj3 = obj;
                                        str = str2;
                                        i17 = i26;
                                        c4117lx2 = c4117lx4;
                                        i11 = i25;
                                        i12 = i62;
                                        i54 = i23;
                                        i13 = i60;
                                        i16 = i24;
                                        i14 = 3;
                                        i15 = i3;
                                    }
                                } else {
                                    int i80 = i60;
                                    long j3 = i58;
                                    Unsafe unsafe10 = f9835MiMN;
                                    InterfaceC4118ly interfaceC4118ly = (InterfaceC4118ly) unsafe10.getObject(obj10, j);
                                    if (interfaceC4118ly.mo11968AZxh()) {
                                        obj5 = BuildConfig.f24315FLAVOR;
                                    } else {
                                        int size = interfaceC4118ly.size();
                                        int i81 = size != 0 ? size + size : 10;
                                        obj5 = BuildConfig.f24315FLAVOR;
                                        InterfaceC4118ly interfaceC4118lyMo10111KLFTb = interfaceC4118ly.mo10111KLFTb(i81);
                                        unsafe10.putObject(obj10, j, interfaceC4118lyMo10111KLFTb);
                                        interfaceC4118ly = interfaceC4118lyMo10111KLFTb;
                                    }
                                    switch (iM9738CqaNbM) {
                                        case 18:
                                        case 35:
                                            bArr3 = bArr;
                                            str = "Failed to parse the message.";
                                            i27 = i2;
                                            i28 = i59;
                                            i29 = iM12804VA;
                                            unsafe = unsafe7;
                                            i30 = i80;
                                            if (i57 == 2) {
                                                int i82 = AbstractC4182mx.f15285mjFkc;
                                                AbstractC4793w7.m13819mjFkc(interfaceC4118ly);
                                                iM12798ETF = AbstractC4182mx.m12798ETF(bArr3, i29, c4117lx4);
                                                int i83 = c4117lx4.f14842mjFkc + iM12798ETF;
                                                if (iM12798ETF < i83) {
                                                    Double.longBitsToDouble(AbstractC4182mx.m12799IEE(bArr3, iM12798ETF));
                                                    throw null;
                                                }
                                                if (iM12798ETF != i83) {
                                                    throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (iM12798ETF != i29) {
                                                    i17 = iM12798ETF;
                                                    obj3 = obj10;
                                                    i11 = i51;
                                                    i13 = i30;
                                                    i16 = i28;
                                                    c4117lx2 = c4117lx4;
                                                    i12 = i62;
                                                    i54 = i23;
                                                    i14 = 3;
                                                    i15 = i3;
                                                    break;
                                                } else {
                                                    i46 = i3;
                                                    i45 = i27;
                                                    bArr6 = bArr3;
                                                    i50 = i30;
                                                    i53 = i28;
                                                    c4117lx5 = c4117lx4;
                                                    i52 = i62;
                                                    i54 = i23;
                                                    i49 = -1;
                                                    unsafe6 = unsafe;
                                                    i48 = 0;
                                                    c2538Ny3 = this;
                                                    iM12796AZxh = iM12798ETF;
                                                    i47 = 3;
                                                }
                                            } else {
                                                if (i57 == 1) {
                                                    int i84 = AbstractC4182mx.f15285mjFkc;
                                                    AbstractC4793w7.m13819mjFkc(interfaceC4118ly);
                                                    Double.longBitsToDouble(AbstractC4182mx.m12799IEE(bArr3, i29));
                                                    throw null;
                                                }
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                        case 19:
                                        case 36:
                                            bArr3 = bArr;
                                            str = "Failed to parse the message.";
                                            i27 = i2;
                                            i28 = i59;
                                            i29 = iM12804VA;
                                            unsafe = unsafe7;
                                            i30 = i80;
                                            if (i57 == 2) {
                                                int i85 = AbstractC4182mx.f15285mjFkc;
                                                C2795Rx c2795Rx = (C2795Rx) interfaceC4118ly;
                                                iM12798ETF = AbstractC4182mx.m12798ETF(bArr3, i29, c4117lx4);
                                                int i86 = c4117lx4.f14842mjFkc + iM12798ETF;
                                                while (iM12798ETF < i86) {
                                                    c2795Rx.m10115xJ(Float.intBitsToFloat(AbstractC4182mx.m12813wA(bArr3, iM12798ETF)));
                                                    iM12798ETF += 4;
                                                }
                                                if (iM12798ETF != i86) {
                                                    throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                if (i57 == 5) {
                                                    iM12805YoKzxo = i29 + 4;
                                                    int i87 = AbstractC4182mx.f15285mjFkc;
                                                    C2795Rx c2795Rx2 = (C2795Rx) interfaceC4118ly;
                                                    c2795Rx2.m10115xJ(Float.intBitsToFloat(AbstractC4182mx.m12813wA(bArr3, i29)));
                                                    while (iM12805YoKzxo < i27) {
                                                        int iM12798ETF6 = AbstractC4182mx.m12798ETF(bArr3, iM12805YoKzxo, c4117lx4);
                                                        if (i28 == c4117lx4.f14842mjFkc) {
                                                            c2795Rx2.m10115xJ(Float.intBitsToFloat(AbstractC4182mx.m12813wA(bArr3, iM12798ETF6)));
                                                            iM12805YoKzxo = iM12798ETF6 + 4;
                                                        } else {
                                                            iM12798ETF = iM12805YoKzxo;
                                                            if (iM12798ETF != i29) {
                                                            }
                                                        }
                                                    }
                                                    iM12798ETF = iM12805YoKzxo;
                                                    if (iM12798ETF != i29) {
                                                    }
                                                }
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        case 20:
                                        case 21:
                                        case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                                        case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                                            bArr3 = bArr;
                                            str = "Failed to parse the message.";
                                            i28 = i59;
                                            i29 = iM12804VA;
                                            unsafe = unsafe7;
                                            i30 = i80;
                                            i27 = i2;
                                            if (i57 == 2) {
                                                int i88 = AbstractC4182mx.f15285mjFkc;
                                                C4982yy c4982yy = (C4982yy) interfaceC4118ly;
                                                iM12798ETF = AbstractC4182mx.m12798ETF(bArr3, i29, c4117lx4);
                                                int i89 = c4117lx4.f14842mjFkc + iM12798ETF;
                                                while (iM12798ETF < i89) {
                                                    iM12798ETF = AbstractC4182mx.m12805YoKzxo(bArr3, iM12798ETF, c4117lx4);
                                                    c4982yy.m14060xJ(c4117lx4.f14839AZxh);
                                                }
                                                if (iM12798ETF != i89) {
                                                    throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                if (i57 == 0) {
                                                    int i90 = AbstractC4182mx.f15285mjFkc;
                                                    C4982yy c4982yy2 = (C4982yy) interfaceC4118ly;
                                                    iM12805YoKzxo = AbstractC4182mx.m12805YoKzxo(bArr3, i29, c4117lx4);
                                                    c4982yy2.m14060xJ(c4117lx4.f14839AZxh);
                                                    while (iM12805YoKzxo < i27) {
                                                        int iM12798ETF7 = AbstractC4182mx.m12798ETF(bArr3, iM12805YoKzxo, c4117lx4);
                                                        if (i28 == c4117lx4.f14842mjFkc) {
                                                            iM12805YoKzxo = AbstractC4182mx.m12805YoKzxo(bArr3, iM12798ETF7, c4117lx4);
                                                            c4982yy2.m14060xJ(c4117lx4.f14839AZxh);
                                                        } else {
                                                            iM12798ETF = iM12805YoKzxo;
                                                            if (iM12798ETF != i29) {
                                                            }
                                                        }
                                                    }
                                                    iM12798ETF = iM12805YoKzxo;
                                                    if (iM12798ETF != i29) {
                                                    }
                                                }
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        case 22:
                                        case 29:
                                        case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                                        case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                                            str = "Failed to parse the message.";
                                            i28 = i59;
                                            i31 = i51;
                                            i29 = iM12804VA;
                                            unsafe = unsafe7;
                                            i30 = i80;
                                            z = true;
                                            bArr4 = bArr;
                                            i27 = i2;
                                            if (i57 == 2) {
                                                iM12814xJ = AbstractC4182mx.m12814xJ(bArr4, i29, interfaceC4118ly, c4117lx4);
                                                i51 = i31;
                                                iM12798ETF = iM12814xJ;
                                                bArr3 = bArr4;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else if (i57 == 0) {
                                                i51 = i31;
                                                bArr3 = bArr4;
                                                iM12805YoKzxo = AbstractC4182mx.m12802MiMN(i28, bArr, i29, i2, interfaceC4118ly, c4117lx);
                                                iM12798ETF = iM12805YoKzxo;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                i51 = i31;
                                                bArr3 = bArr4;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        case 23:
                                        case 32:
                                        case 40:
                                        case 46:
                                            str = "Failed to parse the message.";
                                            i28 = i59;
                                            i31 = i51;
                                            i29 = iM12804VA;
                                            unsafe = unsafe7;
                                            i30 = i80;
                                            bArr4 = bArr;
                                            i27 = i2;
                                            if (i57 == 2) {
                                                int i91 = AbstractC4182mx.f15285mjFkc;
                                                C4982yy c4982yy3 = (C4982yy) interfaceC4118ly;
                                                iM12798ETF2 = AbstractC4182mx.m12798ETF(bArr4, i29, c4117lx4);
                                                int i92 = c4117lx4.f14842mjFkc + iM12798ETF2;
                                                while (iM12798ETF2 < i92) {
                                                    c4982yy3.m14060xJ(AbstractC4182mx.m12799IEE(bArr4, iM12798ETF2));
                                                    iM12798ETF2 += 8;
                                                }
                                                if (iM12798ETF2 != i92) {
                                                    throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i51 = i31;
                                                iM12798ETF = iM12798ETF2;
                                                bArr3 = bArr4;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                z = true;
                                                if (i57 == 1) {
                                                    iM12814xJ = i29 + 8;
                                                    int i93 = AbstractC4182mx.f15285mjFkc;
                                                    C4982yy c4982yy4 = (C4982yy) interfaceC4118ly;
                                                    c4982yy4.m14060xJ(AbstractC4182mx.m12799IEE(bArr4, i29));
                                                    while (iM12814xJ < i27) {
                                                        int iM12798ETF8 = AbstractC4182mx.m12798ETF(bArr4, iM12814xJ, c4117lx4);
                                                        if (i28 == c4117lx4.f14842mjFkc) {
                                                            c4982yy4.m14060xJ(AbstractC4182mx.m12799IEE(bArr4, iM12798ETF8));
                                                            iM12814xJ = iM12798ETF8 + 8;
                                                        } else {
                                                            i51 = i31;
                                                            iM12798ETF = iM12814xJ;
                                                            bArr3 = bArr4;
                                                            if (iM12798ETF != i29) {
                                                            }
                                                        }
                                                    }
                                                    i51 = i31;
                                                    iM12798ETF = iM12814xJ;
                                                    bArr3 = bArr4;
                                                    if (iM12798ETF != i29) {
                                                    }
                                                } else {
                                                    i51 = i31;
                                                    bArr3 = bArr4;
                                                    iM12798ETF = i29;
                                                    if (iM12798ETF != i29) {
                                                    }
                                                }
                                            }
                                            break;
                                        case 24:
                                        case InterfaceC5102BERTags.f17975DATE /* 31 */:
                                        case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                                        case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                                            str = "Failed to parse the message.";
                                            i28 = i59;
                                            i31 = i51;
                                            i29 = iM12804VA;
                                            unsafe = unsafe7;
                                            i30 = i80;
                                            bArr4 = bArr;
                                            i27 = i2;
                                            if (i57 == 2) {
                                                int i94 = AbstractC4182mx.f15285mjFkc;
                                                C3658ey c3658ey = (C3658ey) interfaceC4118ly;
                                                iM12798ETF2 = AbstractC4182mx.m12798ETF(bArr4, i29, c4117lx4);
                                                int i95 = c4117lx4.f14842mjFkc + iM12798ETF2;
                                                while (iM12798ETF2 < i95) {
                                                    c3658ey.m11871xJ(AbstractC4182mx.m12813wA(bArr4, iM12798ETF2));
                                                    iM12798ETF2 += 4;
                                                }
                                                if (iM12798ETF2 != i95) {
                                                    throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i51 = i31;
                                                iM12798ETF = iM12798ETF2;
                                                bArr3 = bArr4;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                if (i57 == 5) {
                                                    iM12805YoKzxo = i29 + 4;
                                                    int i96 = AbstractC4182mx.f15285mjFkc;
                                                    C3658ey c3658ey2 = (C3658ey) interfaceC4118ly;
                                                    c3658ey2.m11871xJ(AbstractC4182mx.m12813wA(bArr4, i29));
                                                    while (iM12805YoKzxo < i27) {
                                                        int iM12798ETF9 = AbstractC4182mx.m12798ETF(bArr4, iM12805YoKzxo, c4117lx4);
                                                        if (i28 == c4117lx4.f14842mjFkc) {
                                                            c3658ey2.m11871xJ(AbstractC4182mx.m12813wA(bArr4, iM12798ETF9));
                                                            iM12805YoKzxo = iM12798ETF9 + 4;
                                                        } else {
                                                            i51 = i31;
                                                            bArr3 = bArr4;
                                                            iM12798ETF = iM12805YoKzxo;
                                                            if (iM12798ETF != i29) {
                                                            }
                                                        }
                                                    }
                                                    i51 = i31;
                                                    bArr3 = bArr4;
                                                    iM12798ETF = iM12805YoKzxo;
                                                    if (iM12798ETF != i29) {
                                                    }
                                                }
                                                i51 = i31;
                                                bArr3 = bArr4;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        case 25:
                                        case C5125EACTags.CURRENCY_CODE /* 42 */:
                                            str = "Failed to parse the message.";
                                            i28 = i59;
                                            i31 = i51;
                                            i29 = iM12804VA;
                                            unsafe = unsafe7;
                                            i30 = i80;
                                            bArr4 = bArr;
                                            i27 = i2;
                                            if (i57 == 2) {
                                                int i97 = AbstractC4182mx.f15285mjFkc;
                                                AbstractC4793w7.m13819mjFkc(interfaceC4118ly);
                                                iM12798ETF2 = AbstractC4182mx.m12798ETF(bArr4, i29, c4117lx4);
                                                int i98 = c4117lx4.f14842mjFkc + iM12798ETF2;
                                                if (iM12798ETF2 < i98) {
                                                    AbstractC4182mx.m12805YoKzxo(bArr4, iM12798ETF2, c4117lx4);
                                                    throw null;
                                                }
                                                if (iM12798ETF2 != i98) {
                                                    throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                i51 = i31;
                                                iM12798ETF = iM12798ETF2;
                                                bArr3 = bArr4;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                if (i57 == 0) {
                                                    int i99 = AbstractC4182mx.f15285mjFkc;
                                                    AbstractC4793w7.m13819mjFkc(interfaceC4118ly);
                                                    AbstractC4182mx.m12805YoKzxo(bArr4, i29, c4117lx4);
                                                    long j4 = c4117lx4.f14839AZxh;
                                                    throw null;
                                                }
                                                i51 = i31;
                                                bArr3 = bArr4;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        case 26:
                                            str = "Failed to parse the message.";
                                            int i100 = i59;
                                            i31 = i51;
                                            int i101 = iM12804VA;
                                            unsafe = unsafe7;
                                            i30 = i80;
                                            bArr4 = bArr;
                                            i27 = i2;
                                            if (i57 != 2) {
                                                i28 = i100;
                                                i29 = i101;
                                                i51 = i31;
                                                bArr3 = bArr4;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else if ((536870912 & j3) == 0) {
                                                int iM12798ETF10 = AbstractC4182mx.m12798ETF(bArr4, i101, c4117lx4);
                                                int i102 = c4117lx4.f14842mjFkc;
                                                if (i102 < 0) {
                                                    throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i102 == 0) {
                                                    obj6 = obj5;
                                                    interfaceC4118ly.add(obj6);
                                                } else {
                                                    obj6 = obj5;
                                                    interfaceC4118ly.add(new String(bArr4, iM12798ETF10, i102, AbstractC4183my.f15287mjFkc));
                                                    iM12798ETF10 += i102;
                                                }
                                                while (true) {
                                                    if (iM12798ETF10 < i27) {
                                                        int iM12798ETF11 = AbstractC4182mx.m12798ETF(bArr4, iM12798ETF10, c4117lx4);
                                                        i28 = i100;
                                                        if (i28 == c4117lx4.f14842mjFkc) {
                                                            iM12798ETF10 = AbstractC4182mx.m12798ETF(bArr4, iM12798ETF11, c4117lx4);
                                                            int i103 = c4117lx4.f14842mjFkc;
                                                            if (i103 < 0) {
                                                                throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if (i103 == 0) {
                                                                interfaceC4118ly.add(obj6);
                                                                i100 = i28;
                                                            } else {
                                                                interfaceC4118ly.add(new String(bArr4, iM12798ETF10, i103, AbstractC4183my.f15287mjFkc));
                                                                iM12798ETF10 += i103;
                                                                i100 = i28;
                                                            }
                                                        }
                                                    } else {
                                                        i28 = i100;
                                                    }
                                                }
                                                i29 = i101;
                                                i51 = i31;
                                                iM12798ETF = iM12798ETF10;
                                                bArr3 = bArr4;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                Object obj17 = obj5;
                                                i28 = i100;
                                                int iM12798ETF12 = AbstractC4182mx.m12798ETF(bArr4, i101, c4117lx4);
                                                int i104 = c4117lx4.f14842mjFkc;
                                                if (i104 < 0) {
                                                    throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i104 == 0) {
                                                    interfaceC4118ly.add(obj17);
                                                    i32 = i101;
                                                } else {
                                                    int i105 = iM12798ETF12 + i104;
                                                    if (!AbstractC4717uz.m13738ZfxDd(bArr4, iM12798ETF12, i105)) {
                                                        throw new C4315oy("Protocol message had invalid UTF-8.");
                                                    }
                                                    i32 = i101;
                                                    interfaceC4118ly.add(new String(bArr4, iM12798ETF12, i104, AbstractC4183my.f15287mjFkc));
                                                    iM12798ETF12 = i105;
                                                }
                                                while (iM12798ETF12 < i27) {
                                                    int iM12798ETF13 = AbstractC4182mx.m12798ETF(bArr4, iM12798ETF12, c4117lx4);
                                                    if (i28 == c4117lx4.f14842mjFkc) {
                                                        iM12798ETF12 = AbstractC4182mx.m12798ETF(bArr4, iM12798ETF13, c4117lx4);
                                                        int i106 = c4117lx4.f14842mjFkc;
                                                        if (i106 < 0) {
                                                            throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i106 == 0) {
                                                            interfaceC4118ly.add(obj17);
                                                        } else {
                                                            int i107 = iM12798ETF12 + i106;
                                                            if (!AbstractC4717uz.m13738ZfxDd(bArr4, iM12798ETF12, i107)) {
                                                                throw new C4315oy("Protocol message had invalid UTF-8.");
                                                            }
                                                            interfaceC4118ly.add(new String(bArr4, iM12798ETF12, i106, AbstractC4183my.f15287mjFkc));
                                                            iM12798ETF12 = i107;
                                                        }
                                                    } else {
                                                        i29 = i32;
                                                        i51 = i31;
                                                        iM12798ETF = iM12798ETF12;
                                                        bArr3 = bArr4;
                                                        if (iM12798ETF != i29) {
                                                        }
                                                    }
                                                }
                                                i29 = i32;
                                                i51 = i31;
                                                iM12798ETF = iM12798ETF12;
                                                bArr3 = bArr4;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        case 27:
                                            bArr3 = bArr;
                                            i28 = i59;
                                            unsafe = unsafe7;
                                            if (i57 == 2) {
                                                bArr4 = bArr3;
                                                i27 = i2;
                                                str = "Failed to parse the message.";
                                                int iM12800JHa = AbstractC4182mx.m12800JHa(m9766cMLeY(i51), i28, bArr, iM12804VA, i2, interfaceC4118ly, c4117lx);
                                                i29 = iM12804VA;
                                                i51 = i51;
                                                i30 = i80;
                                                iM12798ETF = iM12800JHa;
                                                c4117lx4 = c4117lx4;
                                                i28 = i28;
                                                bArr3 = bArr4;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                str = "Failed to parse the message.";
                                                i27 = i2;
                                                i29 = iM12804VA;
                                                i30 = i80;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        case 28:
                                            bArr3 = bArr;
                                            i28 = i59;
                                            unsafe = unsafe7;
                                            if (i57 == 2) {
                                                iM12798ETF = AbstractC4182mx.m12798ETF(bArr3, iM12804VA, c4117lx4);
                                                int i108 = c4117lx4.f14842mjFkc;
                                                if (i108 < 0) {
                                                    throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if (i108 > bArr3.length - iM12798ETF) {
                                                    throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                if (i108 == 0) {
                                                    interfaceC4118ly.add(AbstractC4981yx.f17599AZxh);
                                                } else {
                                                    interfaceC4118ly.add(AbstractC4981yx.m14054VA(bArr3, iM12798ETF, i108));
                                                    iM12798ETF += i108;
                                                }
                                                while (iM12798ETF < i2) {
                                                    int iM12798ETF14 = AbstractC4182mx.m12798ETF(bArr3, iM12798ETF, c4117lx4);
                                                    if (i28 == c4117lx4.f14842mjFkc) {
                                                        iM12798ETF = AbstractC4182mx.m12798ETF(bArr3, iM12798ETF14, c4117lx4);
                                                        int i109 = c4117lx4.f14842mjFkc;
                                                        if (i109 < 0) {
                                                            throw new C4315oy("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if (i109 > bArr3.length - iM12798ETF) {
                                                            throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                        }
                                                        if (i109 == 0) {
                                                            interfaceC4118ly.add(AbstractC4981yx.f17599AZxh);
                                                        } else {
                                                            interfaceC4118ly.add(AbstractC4981yx.m14054VA(bArr3, iM12798ETF, i109));
                                                            iM12798ETF += i109;
                                                        }
                                                    } else {
                                                        str = "Failed to parse the message.";
                                                        int i110 = iM12804VA;
                                                        i30 = i80;
                                                        i27 = i2;
                                                        i29 = i110;
                                                        if (iM12798ETF != i29) {
                                                        }
                                                    }
                                                }
                                                str = "Failed to parse the message.";
                                                int i1102 = iM12804VA;
                                                i30 = i80;
                                                i27 = i2;
                                                i29 = i1102;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                str = "Failed to parse the message.";
                                                int i111 = iM12804VA;
                                                i30 = i80;
                                                i27 = i2;
                                                i29 = i111;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        case 30:
                                        case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                                            bArr3 = bArr;
                                            i33 = i2;
                                            i28 = i59;
                                            unsafe = unsafe7;
                                            if (i57 == 2) {
                                                iM12802MiMN = AbstractC4182mx.m12814xJ(bArr3, iM12804VA, interfaceC4118ly, c4117lx4);
                                            } else {
                                                if (i57 == 0) {
                                                    iM12802MiMN = AbstractC4182mx.m12802MiMN(i28, bArr, iM12804VA, i2, interfaceC4118ly, c4117lx);
                                                }
                                                str = "Failed to parse the message.";
                                                i27 = i33;
                                                i29 = iM12804VA;
                                                i30 = i80;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            InterfaceC3855hy interfaceC3855hyM9778zvd3 = c2538Ny3.m9778zvd(i51);
                                            AbstractC3989jz abstractC3989jz = c2538Ny3.f9838Dt;
                                            AbstractC3989jz abstractC3989jz2 = AbstractC3129Wy.f11513mjFkc;
                                            if (interfaceC3855hyM9778zvd3 == null) {
                                                i34 = iM12802MiMN;
                                                i35 = i80;
                                                z2 = true;
                                            } else if (interfaceC4118ly != null) {
                                                int size2 = interfaceC4118ly.size();
                                                Object objM10863Pq = null;
                                                int i112 = 0;
                                                int i113 = 0;
                                                while (i112 < size2) {
                                                    int i114 = iM12802MiMN;
                                                    Integer num = (Integer) interfaceC4118ly.get(i112);
                                                    int iIntValue = num.intValue();
                                                    if (interfaceC3855hyM9778zvd3.mo7629mjFkc(iIntValue)) {
                                                        if (i112 != i113) {
                                                            interfaceC4118ly.set(i113, num);
                                                        }
                                                        i113++;
                                                        i36 = i80;
                                                    } else {
                                                        i36 = i80;
                                                        objM10863Pq = AbstractC3129Wy.m10863Pq(obj10, i36, iIntValue, objM10863Pq, abstractC3989jz);
                                                    }
                                                    i112++;
                                                    i80 = i36;
                                                    iM12802MiMN = i114;
                                                }
                                                i34 = iM12802MiMN;
                                                i35 = i80;
                                                z2 = true;
                                                if (i113 != size2) {
                                                    interfaceC4118ly.subList(i113, size2).clear();
                                                }
                                            } else {
                                                i34 = iM12802MiMN;
                                                i35 = i80;
                                                z2 = true;
                                                Iterator it = interfaceC4118ly.iterator();
                                                Object objM10863Pq2 = null;
                                                while (it.hasNext()) {
                                                    int iIntValue2 = ((Integer) it.next()).intValue();
                                                    if (!interfaceC3855hyM9778zvd3.mo7629mjFkc(iIntValue2)) {
                                                        objM10863Pq2 = AbstractC3129Wy.m10863Pq(obj10, i35, iIntValue2, objM10863Pq2, abstractC3989jz);
                                                        it.remove();
                                                    }
                                                }
                                            }
                                            str = "Failed to parse the message.";
                                            i27 = i33;
                                            iM12798ETF = i34;
                                            i29 = iM12804VA;
                                            i30 = i35;
                                            if (iM12798ETF != i29) {
                                            }
                                            break;
                                        case 33:
                                        case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                                            bArr3 = bArr;
                                            i33 = i2;
                                            i28 = i59;
                                            unsafe = unsafe7;
                                            if (i57 == 2) {
                                                int i115 = AbstractC4182mx.f15285mjFkc;
                                                C3658ey c3658ey3 = (C3658ey) interfaceC4118ly;
                                                iM12798ETF = AbstractC4182mx.m12798ETF(bArr3, iM12804VA, c4117lx4);
                                                int i116 = c4117lx4.f14842mjFkc + iM12798ETF;
                                                while (iM12798ETF < i116) {
                                                    iM12798ETF = AbstractC4182mx.m12798ETF(bArr3, iM12798ETF, c4117lx4);
                                                    c3658ey3.m11871xJ(AbstractC1795Cx.m7944mjFkc(c4117lx4.f14842mjFkc));
                                                }
                                                if (iM12798ETF != i116) {
                                                    throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                str = "Failed to parse the message.";
                                                i27 = i33;
                                                i29 = iM12804VA;
                                                i30 = i80;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                if (i57 == 0) {
                                                    int i117 = AbstractC4182mx.f15285mjFkc;
                                                    C3658ey c3658ey4 = (C3658ey) interfaceC4118ly;
                                                    iM12798ETF3 = AbstractC4182mx.m12798ETF(bArr3, iM12804VA, c4117lx4);
                                                    c3658ey4.m11871xJ(AbstractC1795Cx.m7944mjFkc(c4117lx4.f14842mjFkc));
                                                    while (iM12798ETF3 < i33) {
                                                        int iM12798ETF15 = AbstractC4182mx.m12798ETF(bArr3, iM12798ETF3, c4117lx4);
                                                        if (i28 == c4117lx4.f14842mjFkc) {
                                                            iM12798ETF3 = AbstractC4182mx.m12798ETF(bArr3, iM12798ETF15, c4117lx4);
                                                            c3658ey4.m11871xJ(AbstractC1795Cx.m7944mjFkc(c4117lx4.f14842mjFkc));
                                                        } else {
                                                            str = "Failed to parse the message.";
                                                            iM12798ETF = iM12798ETF3;
                                                            i27 = i33;
                                                            i29 = iM12804VA;
                                                            i30 = i80;
                                                            if (iM12798ETF != i29) {
                                                            }
                                                        }
                                                    }
                                                    str = "Failed to parse the message.";
                                                    iM12798ETF = iM12798ETF3;
                                                    i27 = i33;
                                                    i29 = iM12804VA;
                                                    i30 = i80;
                                                    if (iM12798ETF != i29) {
                                                    }
                                                }
                                                str = "Failed to parse the message.";
                                                i27 = i33;
                                                i29 = iM12804VA;
                                                i30 = i80;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        case 34:
                                        case 48:
                                            bArr3 = bArr;
                                            i33 = i2;
                                            i28 = i59;
                                            unsafe = unsafe7;
                                            if (i57 == 2) {
                                                int i118 = AbstractC4182mx.f15285mjFkc;
                                                C4982yy c4982yy5 = (C4982yy) interfaceC4118ly;
                                                iM12798ETF = AbstractC4182mx.m12798ETF(bArr3, iM12804VA, c4117lx4);
                                                int i119 = c4117lx4.f14842mjFkc + iM12798ETF;
                                                while (iM12798ETF < i119) {
                                                    iM12798ETF = AbstractC4182mx.m12805YoKzxo(bArr3, iM12798ETF, c4117lx4);
                                                    c4982yy5.m14060xJ(AbstractC1795Cx.m7943AZxh(c4117lx4.f14839AZxh));
                                                }
                                                if (iM12798ETF != i119) {
                                                    throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                                }
                                                str = "Failed to parse the message.";
                                                i27 = i33;
                                                i29 = iM12804VA;
                                                i30 = i80;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                if (i57 == 0) {
                                                    int i120 = AbstractC4182mx.f15285mjFkc;
                                                    C4982yy c4982yy6 = (C4982yy) interfaceC4118ly;
                                                    iM12798ETF3 = AbstractC4182mx.m12805YoKzxo(bArr3, iM12804VA, c4117lx4);
                                                    c4982yy6.m14060xJ(AbstractC1795Cx.m7943AZxh(c4117lx4.f14839AZxh));
                                                    while (iM12798ETF3 < i33) {
                                                        int iM12798ETF16 = AbstractC4182mx.m12798ETF(bArr3, iM12798ETF3, c4117lx4);
                                                        if (i28 == c4117lx4.f14842mjFkc) {
                                                            iM12798ETF3 = AbstractC4182mx.m12805YoKzxo(bArr3, iM12798ETF16, c4117lx4);
                                                            c4982yy6.m14060xJ(AbstractC1795Cx.m7943AZxh(c4117lx4.f14839AZxh));
                                                        } else {
                                                            str = "Failed to parse the message.";
                                                            iM12798ETF = iM12798ETF3;
                                                            i27 = i33;
                                                            i29 = iM12804VA;
                                                            i30 = i80;
                                                            if (iM12798ETF != i29) {
                                                            }
                                                        }
                                                    }
                                                    str = "Failed to parse the message.";
                                                    iM12798ETF = iM12798ETF3;
                                                    i27 = i33;
                                                    i29 = iM12804VA;
                                                    i30 = i80;
                                                    if (iM12798ETF != i29) {
                                                    }
                                                }
                                                str = "Failed to parse the message.";
                                                i27 = i33;
                                                i29 = iM12804VA;
                                                i30 = i80;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                        default:
                                            char c = 3;
                                            if (i57 == 3) {
                                                int i121 = (i59 & (-8)) | 4;
                                                InterfaceC2998Uy interfaceC2998UyM9766cMLeY = c2538Ny3.m9766cMLeY(i51);
                                                i28 = i59;
                                                unsafe = unsafe7;
                                                iM12798ETF3 = AbstractC4182mx.m12806ZfxDd(interfaceC2998UyM9766cMLeY, bArr, iM12804VA, i2, i121, c4117lx);
                                                interfaceC4118ly.add(c4117lx4.f14843wA);
                                                int i122 = i2;
                                                while (true) {
                                                    if (iM12798ETF3 < i122) {
                                                        bArr3 = bArr;
                                                        int iM12798ETF17 = AbstractC4182mx.m12798ETF(bArr3, iM12798ETF3, c4117lx4);
                                                        if (i28 == c4117lx4.f14842mjFkc) {
                                                            iM12798ETF3 = AbstractC4182mx.m12806ZfxDd(interfaceC2998UyM9766cMLeY, bArr, iM12798ETF17, i2, i121, c4117lx);
                                                            interfaceC4118ly.add(c4117lx4.f14843wA);
                                                            i122 = i122;
                                                            interfaceC2998UyM9766cMLeY = interfaceC2998UyM9766cMLeY;
                                                            c = 3;
                                                        }
                                                    } else {
                                                        bArr3 = bArr;
                                                    }
                                                }
                                                i33 = i122;
                                                str = "Failed to parse the message.";
                                                iM12798ETF = iM12798ETF3;
                                                i27 = i33;
                                                i29 = iM12804VA;
                                                i30 = i80;
                                                if (iM12798ETF != i29) {
                                                }
                                            } else {
                                                unsafe = unsafe7;
                                                bArr3 = bArr;
                                                str = "Failed to parse the message.";
                                                i27 = i2;
                                                i28 = i59;
                                                i29 = iM12804VA;
                                                i30 = i80;
                                                iM12798ETF = i29;
                                                if (iM12798ETF != i29) {
                                                }
                                            }
                                            break;
                                    }
                                }
                            } else if (i57 == 2) {
                                InterfaceC4118ly interfaceC4118lyMo10111KLFTb2 = (InterfaceC4118ly) unsafe7.getObject(obj10, j);
                                if (!interfaceC4118lyMo10111KLFTb2.mo11968AZxh()) {
                                    int size3 = interfaceC4118lyMo10111KLFTb2.size();
                                    interfaceC4118lyMo10111KLFTb2 = interfaceC4118lyMo10111KLFTb2.mo10111KLFTb(size3 != 0 ? size3 + size3 : 10);
                                    unsafe7.putObject(obj10, j, interfaceC4118lyMo10111KLFTb2);
                                }
                                iM12796AZxh = AbstractC4182mx.m12800JHa(c2538Ny3.m9766cMLeY(i63), i59, bArr, iM12804VA, i2, interfaceC4118lyMo10111KLFTb2, c4117lx);
                                i50 = i60;
                                i51 = i63;
                                i53 = i59;
                                unsafe6 = unsafe7;
                                i47 = 3;
                                i52 = i62;
                                i54 = i61;
                                i49 = -1;
                                i48 = 0;
                                bArr6 = bArr;
                                i45 = i2;
                                i46 = i3;
                                c4117lx5 = c4117lx6;
                            } else {
                                i23 = i61;
                                bArr2 = bArr;
                                str2 = "Failed to parse the message.";
                                unsafe = unsafe7;
                                i24 = i59;
                                i25 = i63;
                                c4117lx4 = c4117lx6;
                                i26 = iM12804VA;
                                obj3 = obj;
                                str = str2;
                                i17 = i26;
                                c4117lx2 = c4117lx4;
                                i11 = i25;
                                i12 = i62;
                                i54 = i23;
                                i13 = i60;
                                i16 = i24;
                                i14 = 3;
                                i15 = i3;
                            }
                        } else {
                            int i123 = iArr[i9 + 2];
                            int i124 = 1 << (i123 >>> 20);
                            int i125 = i123 & 1048575;
                            int i126 = i54;
                            if (i125 != i126) {
                                if (i126 != 1048575) {
                                    unsafe6.putInt(obj10, i126, i52);
                                }
                                i52 = i125 == 1048575 ? 0 : unsafe6.getInt(obj10, i125);
                                i54 = i125;
                            } else {
                                i54 = i126;
                            }
                            switch (iM9738CqaNbM) {
                                case 0:
                                    i20 = i56;
                                    unsafe3 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 1) {
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        iM12796AZxh = iM12804VA + 8;
                                        i52 |= i124;
                                        AbstractC4518rz.m13418diqgf(obj10, j, Double.longBitsToDouble(AbstractC4182mx.m12799IEE(bArr6, iM12804VA)));
                                        i45 = i2;
                                        i46 = i3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = -1;
                                        i50 = i20;
                                        i47 = 3;
                                        unsafe6 = unsafe3;
                                        i48 = 0;
                                    }
                                case 1:
                                    i20 = i56;
                                    unsafe3 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 5) {
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        iM12796AZxh = iM12804VA + 4;
                                        i52 |= i124;
                                        AbstractC4518rz.m13419eyqo(obj10, j, Float.intBitsToFloat(AbstractC4182mx.m12813wA(bArr6, iM12804VA)));
                                        i45 = i2;
                                        i46 = i3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = i10;
                                        i50 = i20;
                                        i47 = 3;
                                        unsafe6 = unsafe3;
                                        i48 = 0;
                                    }
                                case 2:
                                case 3:
                                    i20 = i56;
                                    unsafe3 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 0) {
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        i52 |= i124;
                                        iM12796AZxh = AbstractC4182mx.m12805YoKzxo(bArr6, iM12804VA, c4117lx3);
                                        unsafe3.putLong(obj, j, c4117lx3.f14839AZxh);
                                        i45 = i2;
                                        i46 = i3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = i10;
                                        i50 = i20;
                                        i47 = 3;
                                        unsafe6 = unsafe3;
                                        i48 = 0;
                                    }
                                case 4:
                                case 11:
                                    i20 = i56;
                                    unsafe3 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 0) {
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        i52 |= i124;
                                        iM12796AZxh = AbstractC4182mx.m12798ETF(bArr6, iM12804VA, c4117lx3);
                                        unsafe3.putInt(obj10, j, c4117lx3.f14842mjFkc);
                                        i45 = i2;
                                        i46 = i3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = i10;
                                        i50 = i20;
                                        i47 = 3;
                                        unsafe6 = unsafe3;
                                        i48 = 0;
                                    }
                                case 5:
                                case 14:
                                    i20 = i56;
                                    Unsafe unsafe11 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 1) {
                                        unsafe3 = unsafe11;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        iM12796AZxh = iM12804VA + 8;
                                        i52 |= i124;
                                        unsafe3 = unsafe11;
                                        unsafe11.putLong(obj, j, AbstractC4182mx.m12799IEE(bArr6, iM12804VA));
                                        i45 = i2;
                                        i46 = i3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = i10;
                                        i50 = i20;
                                        i47 = 3;
                                        unsafe6 = unsafe3;
                                        i48 = 0;
                                    }
                                case 6:
                                case 13:
                                    i20 = i56;
                                    unsafe2 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 5) {
                                        unsafe3 = unsafe2;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        iM12796AZxh = iM12804VA + 4;
                                        i52 |= i124;
                                        unsafe2.putInt(obj10, j, AbstractC4182mx.m12813wA(bArr6, iM12804VA));
                                        i46 = i3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = i10;
                                        i50 = i20;
                                        i47 = 3;
                                        i48 = 0;
                                        unsafe6 = unsafe2;
                                        i45 = i2;
                                    }
                                case 7:
                                    i20 = i56;
                                    unsafe2 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 0) {
                                        unsafe3 = unsafe2;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        i52 |= i124;
                                        int iM12805YoKzxo3 = AbstractC4182mx.m12805YoKzxo(bArr6, iM12804VA, c4117lx3);
                                        AbstractC4518rz.m13408IEE(obj10, j, c4117lx3.f14839AZxh != 0);
                                        i46 = i3;
                                        iM12796AZxh = iM12805YoKzxo3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = i10;
                                        i50 = i20;
                                        i47 = 3;
                                        i48 = 0;
                                        unsafe6 = unsafe2;
                                        i45 = i2;
                                    }
                                case 8:
                                    i20 = i56;
                                    unsafe2 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 2) {
                                        unsafe3 = unsafe2;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        i52 |= i124;
                                        int iM12811qdMbNW = (i58 & PKIFailureInfo.duplicateCertReq) != 0 ? AbstractC4182mx.m12811qdMbNW(bArr6, iM12804VA, c4117lx3) : AbstractC4182mx.m12808lgHUyS(bArr6, iM12804VA, c4117lx3);
                                        unsafe2.putObject(obj10, j, c4117lx3.f14843wA);
                                        i46 = i3;
                                        i47 = 3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = -1;
                                        i50 = i20;
                                        i48 = 0;
                                        iM12796AZxh = iM12811qdMbNW;
                                        unsafe6 = unsafe2;
                                        i45 = i2;
                                    }
                                case 9:
                                    i20 = i56;
                                    unsafe4 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 2) {
                                        unsafe3 = unsafe4;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        i52 |= i124;
                                        Object objM9763Vnb = c2538Ny3.m9763Vnb(obj10, i22);
                                        i45 = i2;
                                        int iM12810qGY2 = AbstractC4182mx.m12810qGY(objM9763Vnb, c2538Ny3.m9766cMLeY(i22), bArr, iM12804VA, i45, c4117lx);
                                        c2538Ny3.m9773rkYL(obj10, i22, objM9763Vnb);
                                        i46 = i3;
                                        i47 = 3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = -1;
                                        i50 = i20;
                                        iM12796AZxh = iM12810qGY2;
                                        unsafe6 = unsafe4;
                                        i48 = 0;
                                    }
                                case 10:
                                    i20 = i56;
                                    unsafe4 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 2) {
                                        unsafe3 = unsafe4;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        i52 |= i124;
                                        int iM12809mjFkc = AbstractC4182mx.m12809mjFkc(bArr6, iM12804VA, c4117lx3);
                                        unsafe4.putObject(obj10, j, c4117lx3.f14843wA);
                                        i45 = i2;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = -1;
                                        i50 = i20;
                                        i48 = 0;
                                        unsafe6 = unsafe4;
                                        i46 = i3;
                                        iM12796AZxh = iM12809mjFkc;
                                        i47 = 3;
                                    }
                                case 12:
                                    i20 = i56;
                                    unsafe4 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 0) {
                                        unsafe3 = unsafe4;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        int iM12798ETF18 = AbstractC4182mx.m12798ETF(bArr6, iM12804VA, c4117lx3);
                                        int i127 = c4117lx3.f14842mjFkc;
                                        InterfaceC3855hy interfaceC3855hyM9778zvd4 = c2538Ny3.m9778zvd(i22);
                                        if ((Integer.MIN_VALUE & i58) == 0 || interfaceC3855hyM9778zvd4 == null || interfaceC3855hyM9778zvd4.mo7629mjFkc(i127)) {
                                            i52 |= i124;
                                            unsafe4.putInt(obj10, j, i127);
                                        } else {
                                            m9743VocHEe(obj).m12637Dt(i21, Long.valueOf(i127));
                                        }
                                        i45 = i2;
                                        i47 = 3;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i51 = i22;
                                        i49 = -1;
                                        i50 = i20;
                                        i48 = 0;
                                        iM12796AZxh = iM12798ETF18;
                                        unsafe6 = unsafe4;
                                        i46 = i3;
                                    }
                                case 15:
                                    i20 = i56;
                                    unsafe5 = unsafe6;
                                    i21 = i59;
                                    i10 = -1;
                                    i22 = i9;
                                    c4117lx3 = c4117lx5;
                                    if (i57 != 0) {
                                        unsafe3 = unsafe5;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        i52 |= i124;
                                        iM12796AZxh = AbstractC4182mx.m12798ETF(bArr6, iM12804VA, c4117lx3);
                                        unsafe5.putInt(obj10, j, AbstractC1795Cx.m7944mjFkc(c4117lx3.f14842mjFkc));
                                        i45 = i2;
                                        c4117lx5 = c4117lx3;
                                        i53 = i21;
                                        i47 = 3;
                                        i51 = i22;
                                        i49 = -1;
                                        i50 = i20;
                                        i48 = 0;
                                        unsafe6 = unsafe5;
                                        i46 = i3;
                                    }
                                case 16:
                                    int i128 = i9;
                                    unsafe5 = unsafe6;
                                    i10 = -1;
                                    if (i57 != 0) {
                                        i20 = i56;
                                        c4117lx3 = c4117lx5;
                                        i22 = i128;
                                        i21 = i59;
                                        unsafe3 = unsafe5;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        i52 |= i124;
                                        iM12796AZxh = AbstractC4182mx.m12805YoKzxo(bArr6, iM12804VA, c4117lx5);
                                        unsafe5.putLong(obj, j, AbstractC1795Cx.m7943AZxh(c4117lx5.f14839AZxh));
                                        i45 = i2;
                                        i46 = i3;
                                        c4117lx5 = c4117lx5;
                                        i53 = i59;
                                        i47 = 3;
                                        i51 = i128;
                                        i49 = -1;
                                        unsafe6 = unsafe5;
                                        i50 = i56;
                                        i48 = 0;
                                    }
                                default:
                                    i47 = 3;
                                    if (i57 != 3) {
                                        i10 = -1;
                                        i20 = i56;
                                        unsafe3 = unsafe6;
                                        i21 = i59;
                                        i22 = i9;
                                        c4117lx3 = c4117lx5;
                                        str = "Failed to parse the message.";
                                        obj3 = obj10;
                                        c4117lx2 = c4117lx3;
                                        i17 = iM12804VA;
                                        i16 = i21;
                                        unsafe = unsafe3;
                                        i11 = i22;
                                        i12 = i52;
                                        i13 = i20;
                                        i14 = 3;
                                        i15 = i3;
                                        break;
                                    } else {
                                        i52 |= i124;
                                        Object objM9763Vnb2 = c2538Ny3.m9763Vnb(obj10, i9);
                                        int i129 = i9;
                                        iM12796AZxh = AbstractC4182mx.m12812rkYL(objM9763Vnb2, c2538Ny3.m9766cMLeY(i9), bArr, iM12804VA, i2, (i56 << 3) | 4, c4117lx);
                                        c2538Ny3.m9773rkYL(obj10, i129, objM9763Vnb2);
                                        i46 = i3;
                                        i50 = i56;
                                        i51 = i129;
                                        i49 = -1;
                                        unsafe6 = unsafe6;
                                        i53 = i59;
                                        i48 = 0;
                                        i45 = i2;
                                    }
                            }
                        }
                    } else {
                        str = "Failed to parse the message.";
                        i10 = i49;
                        i11 = i48;
                        unsafe = unsafe6;
                        i12 = i52;
                        i13 = i56;
                        i14 = i47;
                        i15 = i46;
                        obj3 = obj10;
                        i16 = i55;
                        c4117lx2 = c4117lx5;
                        i17 = iM12804VA;
                    }
                    if (i16 != i15 && i15 != 0) {
                        c2538Ny = this;
                        obj2 = obj3;
                        iM12796AZxh = i17;
                        i4 = i15;
                        i8 = 1048575;
                        i6 = i16;
                        i5 = i12;
                        i7 = i54;
                    } else if (!this.f9840JHa) {
                        C2340Kx c2340Kx = c4117lx2.f14841ZfxDd;
                        C2340Kx c2340Kx2 = C2340Kx.f9288AZxh;
                        C2796Ry c2796Ry = C2796Ry.f10501wA;
                        if (c2340Kx != C2340Kx.f9289wA) {
                            InterfaceC2341Ky interfaceC2341Ky = this.f9841KLFTb;
                            AbstractC3989jz abstractC3989jz3 = this.f9838Dt;
                            int i130 = AbstractC4182mx.f15285mjFkc;
                            C3531cy c3531cyM9292wA = c2340Kx.m9292wA(interfaceC2341Ky, i13);
                            if (c3531cyM9292wA == null) {
                                i53 = i16;
                                iM12797Dt = AbstractC4182mx.m12797Dt(i16, bArr, i17, i2, m9743VocHEe(obj), c4117lx);
                                obj4 = obj3;
                                i19 = i15;
                                i18 = i13;
                                c2538Ny2 = this;
                            } else {
                                i53 = i16;
                                Object obj18 = obj3;
                                AbstractC3330Zx abstractC3330Zx = (AbstractC3330Zx) obj18;
                                abstractC3330Zx.m11232OjSQV();
                                i18 = i13;
                                iM12796AZxh = AbstractC4182mx.m12796AZxh(i53, bArr, i17, i2, abstractC3330Zx, c3531cyM9292wA, abstractC3989jz3, c4117lx);
                                i19 = i15;
                                obj4 = obj18;
                                c2538Ny2 = this;
                                bArr6 = bArr;
                                i45 = i2;
                                c4117lx5 = c4117lx2;
                                i46 = i19;
                                obj10 = obj4;
                                i47 = i14;
                                i50 = i18;
                                i49 = i10;
                                i51 = i11;
                                unsafe6 = unsafe;
                                i48 = 0;
                                i52 = i12;
                                c2538Ny3 = c2538Ny2;
                            }
                        } else {
                            i53 = i16;
                            i18 = i13;
                            i19 = i15;
                            obj4 = obj3;
                            c2538Ny2 = this;
                            iM12797Dt = AbstractC4182mx.m12797Dt(i53, bArr, i17, i2, m9743VocHEe(obj), c4117lx);
                        }
                        iM12796AZxh = iM12797Dt;
                        bArr6 = bArr;
                        i45 = i2;
                        c4117lx5 = c4117lx2;
                        i46 = i19;
                        obj10 = obj4;
                        i47 = i14;
                        i50 = i18;
                        i49 = i10;
                        i51 = i11;
                        unsafe6 = unsafe;
                        i48 = 0;
                        i52 = i12;
                        c2538Ny3 = c2538Ny2;
                    }
                } else {
                    iM9758Ne = c2538Ny3.m9758Ne(i56, i48);
                }
                i9 = iM9758Ne;
                if (i9 == i49) {
                }
                if (i16 != i15) {
                }
                if (!this.f9840JHa) {
                }
            } else {
                c2538Ny = c2538Ny3;
                str = "Failed to parse the message.";
                i4 = i46;
                obj2 = obj10;
                unsafe = unsafe6;
                i5 = i52;
                i6 = i53;
                i7 = i54;
                i8 = 1048575;
            }
        }
        if (i7 != i8) {
            unsafe.putInt(obj2, i7, i5);
        }
        int i131 = c2538Ny.f9843lgHUyS;
        C4055kz c4055kzMo12455mjFkc = 0;
        while (i131 < c2538Ny.f9845qdMbNW) {
            int[] iArr2 = c2538Ny.f9847xJ;
            AbstractC3989jz abstractC3989jz4 = c2538Ny.f9838Dt;
            int[] iArr3 = c2538Ny.f9844mjFkc;
            int i132 = iArr2[i131];
            int i133 = iArr3[i132];
            Object objM13405ETF = AbstractC4518rz.m13405ETF(obj2, c2538Ny.m9777xrEuO(i132) & 1048575);
            if (objM13405ETF != null && (interfaceC3855hyM9778zvd = c2538Ny.m9778zvd(i132)) != null) {
                C1796Cy c1796CyM8099wA2 = ((C1858Dy) c2538Ny.m9772rWxwaT(i132)).m8099wA();
                Iterator it2 = ((C1927Ey) objM13405ETF).entrySet().iterator();
                while (it2.hasNext()) {
                    Map.Entry entry = (Map.Entry) it2.next();
                    if (!interfaceC3855hyM9778zvd.mo7629mjFkc(((Integer) entry.getValue()).intValue())) {
                        if (c4055kzMo12455mjFkc == 0) {
                            c4055kzMo12455mjFkc = abstractC3989jz4.mo12455mjFkc(obj2);
                        }
                        int iM8095AZxh = C1858Dy.m8095AZxh(c1796CyM8099wA2, entry.getKey(), entry.getValue());
                        AbstractC4981yx abstractC4981yx = AbstractC4981yx.f17599AZxh;
                        byte[] bArr7 = new byte[iM8095AZxh];
                        AbstractC3989jz abstractC3989jz5 = abstractC3989jz4;
                        C1856Dx c1856Dx = new C1856Dx(bArr7, 0, iM8095AZxh);
                        try {
                            C1858Dy.m8096KLFTb(c1856Dx, c1796CyM8099wA2, entry.getKey(), entry.getValue());
                            c4055kzMo12455mjFkc.m12637Dt((i133 << 3) | 2, AbstractC4583sx.m13531mjFkc(c1856Dx, bArr7));
                            it2.remove();
                            abstractC3989jz4 = abstractC3989jz5;
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
            i131++;
            c4055kzMo12455mjFkc = (C4055kz) c4055kzMo12455mjFkc;
        }
        if (c4055kzMo12455mjFkc != 0) {
            ((AbstractC3595dy) obj2).f13418zbc = c4055kzMo12455mjFkc;
        }
        if (i4 != 0) {
            String str3 = str;
            if (iM12796AZxh > i2 || i6 != i4) {
                throw new C4315oy(str3);
            }
        } else if (iM12796AZxh != i2) {
            throw new C4315oy(str);
        }
        return iM12796AZxh;
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: wA */
    public final boolean mo9775wA(Object obj, Object obj2) {
        boolean zM10861KLFTb;
        for (int i = 0; i < this.f9844mjFkc.length; i += 3) {
            int iM9777xrEuO = m9777xrEuO(i);
            long j = iM9777xrEuO & 1048575;
            switch (m9738CqaNbM(iM9777xrEuO)) {
                case 0:
                    if (!m9767fehf(obj, obj2, i) || Double.doubleToLongBits(AbstractC4518rz.m13409JHa(obj, j)) != Double.doubleToLongBits(AbstractC4518rz.m13409JHa(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 1:
                    if (!m9767fehf(obj, obj2, i) || Float.floatToIntBits(AbstractC4518rz.m13432xJ(obj, j)) != Float.floatToIntBits(AbstractC4518rz.m13432xJ(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 2:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13427qdMbNW(obj, j) != AbstractC4518rz.m13427qdMbNW(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 3:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13427qdMbNW(obj, j) != AbstractC4518rz.m13427qdMbNW(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 4:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13423lgHUyS(obj, j) != AbstractC4518rz.m13423lgHUyS(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 5:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13427qdMbNW(obj, j) != AbstractC4518rz.m13427qdMbNW(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 6:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13423lgHUyS(obj, j) != AbstractC4518rz.m13423lgHUyS(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 7:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13403BAnRFn(obj, j) != AbstractC4518rz.m13403BAnRFn(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 8:
                    if (!m9767fehf(obj, obj2, i) || !AbstractC3129Wy.m10861KLFTb(AbstractC4518rz.m13405ETF(obj, j), AbstractC4518rz.m13405ETF(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 9:
                    if (!m9767fehf(obj, obj2, i) || !AbstractC3129Wy.m10861KLFTb(AbstractC4518rz.m13405ETF(obj, j), AbstractC4518rz.m13405ETF(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 10:
                    if (!m9767fehf(obj, obj2, i) || !AbstractC3129Wy.m10861KLFTb(AbstractC4518rz.m13405ETF(obj, j), AbstractC4518rz.m13405ETF(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 11:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13423lgHUyS(obj, j) != AbstractC4518rz.m13423lgHUyS(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 12:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13423lgHUyS(obj, j) != AbstractC4518rz.m13423lgHUyS(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 13:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13423lgHUyS(obj, j) != AbstractC4518rz.m13423lgHUyS(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 14:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13427qdMbNW(obj, j) != AbstractC4518rz.m13427qdMbNW(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 15:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13423lgHUyS(obj, j) != AbstractC4518rz.m13423lgHUyS(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 16:
                    if (!m9767fehf(obj, obj2, i) || AbstractC4518rz.m13427qdMbNW(obj, j) != AbstractC4518rz.m13427qdMbNW(obj2, j)) {
                        return false;
                    }
                    continue;
                    break;
                case 17:
                    if (!m9767fehf(obj, obj2, i) || !AbstractC3129Wy.m10861KLFTb(AbstractC4518rz.m13405ETF(obj, j), AbstractC4518rz.m13405ETF(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                case 40:
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                case 46:
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                case 48:
                case 49:
                    zM10861KLFTb = AbstractC3129Wy.m10861KLFTb(AbstractC4518rz.m13405ETF(obj, j), AbstractC4518rz.m13405ETF(obj2, j));
                    break;
                case 50:
                    zM10861KLFTb = AbstractC3129Wy.m10861KLFTb(AbstractC4518rz.m13405ETF(obj, j), AbstractC4518rz.m13405ETF(obj2, j));
                    break;
                case C5125EACTags.TRANSACTION_DATE /* 51 */:
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                case C5125EACTags.f18346SEX /* 53 */:
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                case 55:
                case 56:
                case 57:
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                case C5125EACTags.f18344ADDRESS /* 66 */:
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    long jM9759OjSQV = m9759OjSQV(i) & 1048575;
                    if (AbstractC4518rz.m13423lgHUyS(obj, jM9759OjSQV) != AbstractC4518rz.m13423lgHUyS(obj2, jM9759OjSQV) || !AbstractC3129Wy.m10861KLFTb(AbstractC4518rz.m13405ETF(obj, j), AbstractC4518rz.m13405ETF(obj2, j))) {
                        return false;
                    }
                    continue;
                    break;
                default:
            }
            if (!zM10861KLFTb) {
                return false;
            }
        }
        if (!((AbstractC3595dy) obj).f13418zbc.equals(((AbstractC3595dy) obj2).f13418zbc)) {
            return false;
        }
        if (this.f9840JHa) {
            return ((AbstractC3330Zx) obj).f12261zbb.m9984equals(((AbstractC3330Zx) obj2).f12261zbb);
        }
        return true;
    }

    @Override // p131o.InterfaceC2998Uy
    /* renamed from: xJ */
    public final void mo9776xJ(Object obj, Object obj2) {
        m9739Dt(obj);
        obj2.getClass();
        for (int i = 0; i < this.f9844mjFkc.length; i += 3) {
            int iM9777xrEuO = m9777xrEuO(i);
            int i2 = 1048575 & iM9777xrEuO;
            int[] iArr = this.f9844mjFkc;
            int iM9738CqaNbM = m9738CqaNbM(iM9777xrEuO);
            int i3 = iArr[i];
            long j = i2;
            switch (iM9738CqaNbM) {
                case 0:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13418diqgf(obj, j, AbstractC4518rz.m13409JHa(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 1:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13419eyqo(obj, j, AbstractC4518rz.m13432xJ(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 2:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13421huTpC(obj, j, AbstractC4518rz.m13427qdMbNW(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13421huTpC(obj, j, AbstractC4518rz.m13427qdMbNW(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 4:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13413Ucbh(obj, j, AbstractC4518rz.m13423lgHUyS(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 5:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13421huTpC(obj, j, AbstractC4518rz.m13427qdMbNW(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 6:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13413Ucbh(obj, j, AbstractC4518rz.m13423lgHUyS(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 7:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13408IEE(obj, j, AbstractC4518rz.m13403BAnRFn(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 8:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13406Gd(obj, j, AbstractC4518rz.m13405ETF(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    m9752ETF(obj, obj2, i);
                    break;
                case 10:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13406Gd(obj, j, AbstractC4518rz.m13405ETF(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13413Ucbh(obj, j, AbstractC4518rz.m13423lgHUyS(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 12:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13413Ucbh(obj, j, AbstractC4518rz.m13423lgHUyS(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 13:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13413Ucbh(obj, j, AbstractC4518rz.m13423lgHUyS(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 14:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13421huTpC(obj, j, AbstractC4518rz.m13427qdMbNW(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13413Ucbh(obj, j, AbstractC4518rz.m13423lgHUyS(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    if (m9753IEE(obj2, i)) {
                        AbstractC4518rz.m13421huTpC(obj, j, AbstractC4518rz.m13427qdMbNW(obj2, j));
                        m9756MiMN(obj, i);
                        break;
                    } else {
                        break;
                    }
                case 17:
                    m9752ETF(obj, obj2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case InterfaceC5102BERTags.f17975DATE /* 31 */:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case C5125EACTags.APPLICATION_EFFECTIVE_DATE /* 37 */:
                case C5125EACTags.CARD_EFFECTIVE_DATE /* 38 */:
                case C5125EACTags.INTERCHANGE_CONTROL /* 39 */:
                case 40:
                case C5125EACTags.INTERCHANGE_PROFILE /* 41 */:
                case C5125EACTags.CURRENCY_CODE /* 42 */:
                case C5125EACTags.DATE_OF_BIRTH /* 43 */:
                case C5125EACTags.CARDHOLDER_NATIONALITY /* 44 */:
                case C5125EACTags.LANGUAGE_PREFERENCES /* 45 */:
                case 46:
                case C5125EACTags.PIN_USAGE_POLICY /* 47 */:
                case 48:
                case 49:
                    InterfaceC4118ly interfaceC4118lyMo10111KLFTb = (InterfaceC4118ly) AbstractC4518rz.m13405ETF(obj, j);
                    InterfaceC4118ly interfaceC4118ly = (InterfaceC4118ly) AbstractC4518rz.m13405ETF(obj2, j);
                    int size = interfaceC4118lyMo10111KLFTb.size();
                    int size2 = interfaceC4118ly.size();
                    if (size > 0 && size2 > 0) {
                        if (!interfaceC4118lyMo10111KLFTb.mo11968AZxh()) {
                            interfaceC4118lyMo10111KLFTb = interfaceC4118lyMo10111KLFTb.mo10111KLFTb(size2 + size);
                        }
                        interfaceC4118lyMo10111KLFTb.addAll(interfaceC4118ly);
                    }
                    if (size > 0) {
                        interfaceC4118ly = interfaceC4118lyMo10111KLFTb;
                    }
                    AbstractC4518rz.m13406Gd(obj, j, interfaceC4118ly);
                    break;
                case 50:
                    AbstractC3989jz abstractC3989jz = AbstractC3129Wy.f11513mjFkc;
                    AbstractC4518rz.m13406Gd(obj, j, C1999Fy.m8336mjFkc(AbstractC4518rz.m13405ETF(obj, j), AbstractC4518rz.m13405ETF(obj2, j)));
                    break;
                case C5125EACTags.TRANSACTION_DATE /* 51 */:
                case C5125EACTags.CARD_SEQUENCE_NUMBER /* 52 */:
                case C5125EACTags.f18346SEX /* 53 */:
                case C5125EACTags.CURRENCY_EXPONENT /* 54 */:
                case 55:
                case 56:
                case 57:
                case C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION /* 58 */:
                case C5125EACTags.DYNAMIC_EXTERNAL_AUTHENTIFICATION /* 59 */:
                    if (m9761Ucbh(obj2, i3, i)) {
                        AbstractC4518rz.m13406Gd(obj, j, AbstractC4518rz.m13405ETF(obj2, j));
                        m9764YoKzxo(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case 60:
                    m9762VA(obj, obj2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case C5125EACTags.ELEMENT_LIST /* 65 */:
                case C5125EACTags.f18344ADDRESS /* 66 */:
                case C5125EACTags.CARDHOLDER_HANDWRITTEN_SIGNATURE /* 67 */:
                    if (m9761Ucbh(obj2, i3, i)) {
                        AbstractC4518rz.m13406Gd(obj, j, AbstractC4518rz.m13405ETF(obj2, j));
                        m9764YoKzxo(obj, i3, i);
                        break;
                    } else {
                        break;
                    }
                case C5125EACTags.APPLICATION_IMAGE /* 68 */:
                    m9762VA(obj, obj2, i);
                    break;
            }
        }
        AbstractC3129Wy.m10870eyqo(this.f9838Dt, obj, obj2);
        if (this.f9840JHa) {
            AbstractC3129Wy.m10869diqgf(this.f9839ETF, obj, obj2);
        }
    }

    /* renamed from: xrEuO */
    public final int m9777xrEuO(int i) {
        return this.f9844mjFkc[i + 1];
    }

    /* renamed from: zvd */
    public final InterfaceC3855hy m9778zvd(int i) {
        int i2 = i / 3;
        return (InterfaceC3855hy) this.f9837AZxh[i2 + i2 + 1];
    }
}
