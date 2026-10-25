package org.bouncycastle.p314pqc.p316crypto.p318falcon;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.p105jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
class FalconKeyGen {
    private static final int DEPTH_INT_FG = 4;

    /* renamed from: REV10 */
    private static final short[] f23112REV10 = {0, 512, 256, 768, 128, 640, 384, 896, 64, 576, 320, 832, 192, 704, 448, 960, 32, 544, 288, 800, 160, 672, 416, 928, 96, 608, 352, 864, 224, 736, 480, 992, 16, 528, 272, 784, 144, 656, 400, 912, 80, 592, 336, 848, 208, 720, 464, 976, 48, 560, 304, 816, 176, 688, 432, 944, 112, 624, 368, 880, 240, 752, 496, 1008, 8, 520, 264, 776, 136, 648, 392, 904, 72, 584, 328, 840, 200, 712, 456, 968, 40, 552, 296, 808, 168, 680, 424, 936, 104, 616, 360, 872, 232, 744, 488, 1000, 24, 536, 280, 792, 152, 664, 408, 920, 88, 600, 344, 856, 216, 728, 472, 984, 56, 568, 312, 824, 184, 696, 440, 952, 120, 632, 376, 888, 248, 760, 504, 1016, 4, 516, 260, 772, 132, 644, 388, 900, 68, 580, 324, 836, 196, 708, 452, 964, 36, 548, 292, 804, 164, 676, 420, 932, 100, 612, 356, 868, 228, 740, 484, 996, 20, 532, 276, 788, 148, 660, 404, 916, 84, 596, 340, 852, 212, 724, 468, 980, 52, 564, 308, 820, 180, 692, 436, 948, 116, 628, 372, 884, 244, 756, 500, 1012, 12, 524, 268, 780, 140, 652, 396, 908, 76, 588, 332, 844, 204, 716, 460, 972, 44, 556, 300, 812, 172, 684, 428, 940, 108, 620, 364, 876, 236, 748, 492, 1004, 28, 540, 284, 796, 156, 668, 412, 924, 92, 604, 348, 860, 220, 732, 476, 988, 60, 572, 316, 828, 188, 700, 444, 956, 124, 636, 380, 892, 252, 764, 508, 1020, 2, 514, 258, 770, 130, 642, 386, 898, 66, 578, 322, 834, 194, 706, 450, 962, 34, 546, 290, 802, 162, 674, 418, 930, 98, 610, 354, 866, 226, 738, 482, 994, 18, 530, 274, 786, 146, 658, 402, 914, 82, 594, 338, 850, 210, 722, 466, 978, 50, 562, 306, 818, 178, 690, 434, 946, 114, 626, 370, 882, 242, 754, 498, 1010, 10, 522, 266, 778, 138, 650, 394, 906, 74, 586, 330, 842, 202, 714, 458, 970, 42, 554, 298, 810, 170, 682, 426, 938, 106, 618, 362, 874, 234, 746, 490, 1002, 26, 538, 282, 794, 154, 666, 410, 922, 90, 602, 346, 858, 218, 730, 474, 986, 58, 570, 314, 826, 186, 698, 442, 954, 122, 634, 378, 890, 250, 762, 506, 1018, 6, 518, 262, 774, 134, 646, 390, 902, 70, 582, 326, 838, 198, 710, 454, 966, 38, 550, 294, 806, 166, 678, 422, 934, 102, 614, 358, 870, 230, 742, 486, 998, 22, 534, 278, 790, 150, 662, 406, 918, 86, 598, 342, 854, 214, 726, 470, 982, 54, 566, 310, 822, 182, 694, 438, 950, 118, 630, 374, 886, 246, 758, 502, 1014, 14, 526, 270, 782, 142, 654, 398, 910, 78, 590, 334, 846, 206, 718, 462, 974, 46, 558, 302, 814, 174, 686, 430, 942, 110, 622, 366, 878, 238, 750, 494, 1006, 30, 542, 286, 798, 158, 670, 414, 926, 94, 606, 350, 862, 222, 734, 478, 990, 62, 574, 318, 830, 190, 702, 446, 958, 126, 638, 382, 894, 254, 766, 510, 1022, 1, 513, 257, 769, 129, 641, 385, 897, 65, 577, 321, 833, 193, 705, 449, 961, 33, 545, 289, 801, 161, 673, 417, 929, 97, 609, 353, 865, 225, 737, 481, 993, 17, 529, 273, 785, 145, 657, 401, 913, 81, 593, 337, 849, 209, 721, 465, 977, 49, 561, 305, 817, 177, 689, 433, 945, 113, 625, 369, 881, 241, 753, 497, 1009, 9, 521, 265, 777, 137, 649, 393, 905, 73, 585, 329, 841, 201, 713, 457, 969, 41, 553, 297, 809, 169, 681, 425, 937, 105, 617, 361, 873, 233, 745, 489, 1001, 25, 537, 281, 793, 153, 665, 409, 921, 89, 601, 345, 857, 217, 729, 473, 985, 57, 569, 313, 825, 185, 697, 441, 953, 121, 633, 377, 889, 249, 761, 505, 1017, 5, 517, 261, 773, 133, 645, 389, 901, 69, 581, 325, 837, 197, 709, 453, 965, 37, 549, 293, 805, 165, 677, 421, 933, 101, 613, 357, 869, 229, 741, 485, 997, 21, 533, 277, 789, 149, 661, 405, 917, 85, 597, 341, 853, 213, 725, 469, 981, 53, 565, 309, 821, 181, 693, 437, 949, 117, 629, 373, 885, 245, 757, 501, 1013, 13, 525, 269, 781, 141, 653, 397, 909, 77, 589, 333, 845, 205, 717, 461, 973, 45, 557, 301, 813, 173, 685, 429, 941, 109, 621, 365, 877, 237, 749, 493, 1005, 29, 541, 285, 797, 157, 669, 413, 925, 93, 605, 349, 861, 221, 733, 477, 989, 61, 573, 317, 829, 189, 701, 445, 957, 125, 637, 381, 893, 253, 765, 509, 1021, 3, 515, 259, 771, 131, 643, 387, 899, 67, 579, 323, 835, 195, 707, 451, 963, 35, 547, 291, 803, 163, 675, 419, 931, 99, 611, 355, 867, 227, 739, 483, 995, 19, 531, 275, 787, 147, 659, 403, 915, 83, 595, 339, 851, 211, 723, 467, 979, 51, 563, 307, 819, 179, 691, 435, 947, 115, 627, 371, 883, 243, 755, 499, 1011, 11, 523, 267, 779, 139, 651, 395, 907, 75, 587, 331, 843, 203, 715, 459, 971, 43, 555, 299, 811, 171, 683, 427, 939, 107, 619, 363, 875, 235, 747, 491, 1003, 27, 539, 283, 795, 155, 667, 411, 923, 91, 603, 347, 859, 219, 731, 475, 987, 59, 571, 315, 827, 187, 699, 443, 955, 123, 635, 379, 891, 251, 763, 507, 1019, 7, 519, 263, 775, 135, 647, 391, 903, 71, 583, 327, 839, 199, 711, 455, 967, 39, 551, 295, 807, 167, 679, 423, 935, 103, 615, 359, 871, 231, 743, 487, 999, 23, 535, 279, 791, 151, 663, 407, 919, 87, 599, 343, 855, 215, 727, 471, 983, 55, 567, 311, 823, 183, 695, 439, 951, 119, 631, 375, 887, 247, 759, 503, 1015, 15, 527, 271, 783, 143, 655, 399, 911, 79, 591, 335, 847, 207, 719, 463, 975, 47, 559, 303, 815, 175, 687, 431, 943, 111, 623, 367, 879, 239, 751, 495, 1007, 31, 543, 287, 799, 159, 671, 415, 927, 
    95, 607, 351, 863, 223, 735, 479, 991, 63, 575, 319, 831, 191, 703, 447, 959, 127, 639, 383, 895, 255, 767, 511, 1023};
    private static final long[] gauss_1024_12289 = {1283868770400643928L, 6416574995475331444L, 4078260278032692663L, 2353523259288686585L, 1227179971273316331L, 575931623374121527L, 242543240509105209L, 91437049221049666L, 30799446349977173L, 9255276791179340L, 2478152334826140L, 590642893610164L, 125206034929641L, 23590435911403L, 3948334035941L, 586753615614L, 77391054539L, 9056793210L, 940121950, 86539696, 7062824, 510971, 32764, 1862, 94, 4, 0};
    private static final int[] MAX_BL_SMALL = {1, 1, 2, 2, 4, 7, 14, 27, 53, 106, 209};
    private static final int[] MAX_BL_LARGE = {2, 2, 5, 7, 12, 21, 40, 78, 157, 308};
    private static final int[] bitlength_avg = {4, 11, 24, 50, 102, 202, 401, 794, 1577, 3138, 6308};
    private static final int[] bitlength_std = {0, 1, 1, 1, 1, 2, 4, 5, 8, 13, 25};

    private static long get_rng_u64(SHAKEDigest sHAKEDigest) {
        byte[] bArr = new byte[8];
        sHAKEDigest.doOutput(bArr, 0, 8);
        return AbstractC6245Pack.littleEndianToLong(bArr, 0);
    }

    /* renamed from: keygen */
    public static void m17541keygen(SHAKEDigest sHAKEDigest, byte[] bArr, byte[] bArr2, byte[] bArr3, short[] sArr, int i) {
        int i2;
        int i3;
        byte b;
        int iM17544mkn = m17544mkn(i);
        short[] sArr2 = sArr;
        while (true) {
            double[] dArr = new double[iM17544mkn * 3];
            poly_small_mkgauss(sHAKEDigest, bArr, i);
            poly_small_mkgauss(sHAKEDigest, bArr2, i);
            int i4 = 1 << (FalconCodec.max_fg_bits[i] - 1);
            for (int i5 = 0; i5 < iM17544mkn; i5++) {
                byte b2 = bArr[i5];
                if (b2 >= i4 || b2 <= (i3 = -i4) || (b = bArr2[i5]) >= i4 || b <= i3) {
                    i4 = -1;
                    break;
                }
            }
            if (i4 >= 0) {
                int iPoly_small_sqnorm = poly_small_sqnorm(bArr, i);
                int iPoly_small_sqnorm2 = poly_small_sqnorm(bArr2, i);
                if ((((-((iPoly_small_sqnorm | iPoly_small_sqnorm2) >>> 31)) | (iPoly_small_sqnorm + iPoly_small_sqnorm2)) & BodyPartID.bodyIdMax) >= 16823) {
                    continue;
                } else {
                    int i6 = iM17544mkn + iM17544mkn;
                    poly_small_to_fp(dArr, 0, bArr, i);
                    poly_small_to_fp(dArr, iM17544mkn, bArr2, i);
                    FalconFFT.m17539FFT(dArr, 0, i);
                    FalconFFT.m17539FFT(dArr, iM17544mkn, i);
                    FalconFFT.poly_invnorm2_fft(dArr, i6, dArr, 0, dArr, iM17544mkn, i);
                    FalconFFT.poly_adj_fft(dArr, 0, i);
                    FalconFFT.poly_adj_fft(dArr, iM17544mkn, i);
                    FalconFFT.poly_mulconst(dArr, 0, 12289.0d, i);
                    FalconFFT.poly_mulconst(dArr, iM17544mkn, 12289.0d, i);
                    FalconFFT.poly_mul_autoadj_fft(dArr, 0, dArr, i6, i);
                    FalconFFT.poly_mul_autoadj_fft(dArr, iM17544mkn, dArr, i6, i);
                    FalconFFT.m17540iFFT(dArr, 0, i);
                    FalconFFT.m17540iFFT(dArr, iM17544mkn, i);
                    double d = 0.0d;
                    for (int i7 = 0; i7 < iM17544mkn; i7++) {
                        double d2 = dArr[i7];
                        double d3 = dArr[iM17544mkn + i7];
                        d += (d2 * d2) + (d3 * d3);
                    }
                    if (d >= 16822.4121d) {
                        continue;
                    } else {
                        short[] sArr3 = new short[iM17544mkn * 2];
                        if (sArr2 == null) {
                            sArr2 = sArr3;
                            i2 = iM17544mkn;
                        } else {
                            i2 = 0;
                        }
                        if (FalconVrfy.compute_public(sArr2, 0, bArr, bArr2, i, sArr3, i2) != 0) {
                            if (solve_NTRU(i, bArr3, bArr, bArr2, (1 << (FalconCodec.max_FG_bits[i] - 1)) - 1, new int[i > 2 ? iM17544mkn * 28 : iM17544mkn * 84]) != 0) {
                                return;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: make_fg */
    private static void m17542make_fg(int[] iArr, int i, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        int iM17544mkn = m17544mkn(i2);
        int i5 = i + iM17544mkn;
        int i6 = FalconSmallPrimeList.f23136PRIMES[0].f23134p;
        for (int i7 = 0; i7 < iM17544mkn; i7++) {
            iArr[i + i7] = modp_set(bArr[i7], i6);
            iArr[i5 + i7] = modp_set(bArr2[i7], i6);
        }
        if (i3 != 0 || i4 == 0) {
            int i8 = 0;
            while (i8 < i3) {
                int i9 = i8 + 1;
                make_fg_step(iArr, i, i2 - i8, i8, i8 != 0 ? 1 : 0, (i9 < i3 || i4 != 0) ? 1 : 0);
                i8 = i9;
            }
            return;
        }
        FalconSmallPrime[] falconSmallPrimeArr = FalconSmallPrimeList.f23136PRIMES;
        int i10 = falconSmallPrimeArr[0].f23134p;
        int iModp_ninv31 = modp_ninv31(i10);
        int i11 = i5 + iM17544mkn;
        modp_mkgm2(iArr, i11, iArr, i11 + iM17544mkn, i2, falconSmallPrimeArr[0].f23133g, i10, iModp_ninv31);
        modp_NTT2(iArr, i, iArr, i11, i2, i10, iModp_ninv31);
        modp_NTT2(iArr, i5, iArr, i11, i2, i10, iModp_ninv31);
    }

    private static void make_fg_step(int[] iArr, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11 = 1 << i2;
        int i12 = i11 >> 1;
        int[] iArr2 = MAX_BL_SMALL;
        int i13 = iArr2[i3];
        int i14 = iArr2[i3 + 1];
        int i15 = i12 * i14;
        int i16 = i + i15;
        int i17 = i16 + i15;
        int i18 = i11 * i13;
        int i19 = i17 + i18;
        int i20 = i19 + i18;
        int i21 = i20 + i11;
        int i22 = i21 + i11;
        System.arraycopy(iArr, i, iArr, i17, i11 * 2 * i13);
        int i23 = 0;
        while (i23 < i13) {
            FalconSmallPrime[] falconSmallPrimeArr = FalconSmallPrimeList.f23136PRIMES;
            int i24 = falconSmallPrimeArr[i23].f23134p;
            int iModp_ninv31 = modp_ninv31(i24);
            int iM17546modp_R2 = m17546modp_R2(i24, iModp_ninv31);
            int i25 = i23;
            int i26 = i17;
            modp_mkgm2(iArr, i20, iArr, i21, i2, falconSmallPrimeArr[i23].f23133g, i24, iModp_ninv31);
            int i27 = i26 + i25;
            int i28 = i27;
            int i29 = 0;
            while (i29 < i11) {
                iArr[i22 + i29] = iArr[i28];
                i29++;
                i28 += i13;
            }
            if (i4 == 0) {
                modp_NTT2(iArr, i22, iArr, i20, i2, i24, iModp_ninv31);
            }
            int i30 = i + i25;
            int i31 = 0;
            int i32 = i30;
            while (i31 < i12) {
                int i33 = i22 + (i31 << 1);
                iArr[i32] = modp_montymul(modp_montymul(iArr[i33], iArr[i33 + 1], i24, iModp_ninv31), iM17546modp_R2, i24, iModp_ninv31);
                i31++;
                i32 += i14;
            }
            if (i4 != 0) {
                i7 = iModp_ninv31;
                i8 = i24;
                i6 = iM17546modp_R2;
                modp_iNTT2_ext(iArr, i27, i13, iArr, i21, i2, i24, i7);
            } else {
                i6 = iM17546modp_R2;
                i7 = iModp_ninv31;
                i8 = i24;
            }
            int i34 = i19 + i25;
            int i35 = i34;
            int i36 = 0;
            while (i36 < i11) {
                iArr[i22 + i36] = iArr[i35];
                i36++;
                i35 += i13;
            }
            if (i4 == 0) {
                modp_NTT2(iArr, i22, iArr, i20, i2, i8, i7);
            }
            int i37 = i16 + i25;
            int i38 = 0;
            int i39 = i37;
            while (i38 < i12) {
                int i40 = i22 + (i38 << 1);
                int i41 = i7;
                int i42 = i8;
                iArr[i39] = modp_montymul(modp_montymul(iArr[i40], iArr[i40 + 1], i42, i41), i6, i42, i41);
                i38++;
                i39 += i14;
            }
            int i43 = i7;
            int i44 = i8;
            if (i4 != 0) {
                i9 = i43;
                i10 = i44;
                modp_iNTT2_ext(iArr, i34, i13, iArr, i21, i2, i44, i9);
            } else {
                i9 = i43;
                i10 = i44;
            }
            if (i5 == 0) {
                int i45 = i2 - 1;
                int i46 = i10;
                int i47 = i9;
                modp_iNTT2_ext(iArr, i30, i14, iArr, i21, i45, i46, i47);
                modp_iNTT2_ext(iArr, i37, i14, iArr, i21, i45, i46, i47);
            }
            i23 = i25 + 1;
            i17 = i26;
        }
        int i48 = i17;
        zint_rebuild_CRT(iArr, i48, i13, i13, i11, 1, iArr, i20);
        zint_rebuild_CRT(iArr, i19, i13, i13, i11, 1, iArr, i20);
        int i49 = i13;
        while (i49 < i14) {
            FalconSmallPrime[] falconSmallPrimeArr2 = FalconSmallPrimeList.f23136PRIMES;
            int i50 = falconSmallPrimeArr2[i49].f23134p;
            int iModp_ninv312 = modp_ninv31(i50);
            int iM17546modp_R22 = m17546modp_R2(i50, iModp_ninv312);
            int iM17547modp_Rx = m17547modp_Rx(i13, i50, iModp_ninv312, iM17546modp_R22);
            int i51 = i49;
            modp_mkgm2(iArr, i20, iArr, i21, i2, falconSmallPrimeArr2[i49].f23133g, i50, iModp_ninv312);
            int i52 = 0;
            int i53 = i48;
            while (i52 < i11) {
                iArr[i22 + i52] = zint_mod_small_signed(iArr, i53, i13, i50, iModp_ninv312, iM17546modp_R22, iM17547modp_Rx);
                i52++;
                i53 += i13;
            }
            modp_NTT2(iArr, i22, iArr, i20, i2, i50, iModp_ninv312);
            int i54 = i + i51;
            int i55 = i54;
            int i56 = 0;
            while (i56 < i12) {
                int i57 = i22 + (i56 << 1);
                iArr[i55] = modp_montymul(modp_montymul(iArr[i57], iArr[i57 + 1], i50, iModp_ninv312), iM17546modp_R22, i50, iModp_ninv312);
                i56++;
                i55 += i14;
            }
            int i58 = iM17546modp_R22;
            int i59 = iModp_ninv312;
            int i60 = i50;
            int i61 = i19;
            int i62 = 0;
            while (i62 < i11) {
                int i63 = i58;
                iArr[i22 + i62] = zint_mod_small_signed(iArr, i61, i13, i60, i59, i63, iM17547modp_Rx);
                i62++;
                i61 += i13;
                i58 = i63;
                i59 = i59;
                i60 = i60;
            }
            int i64 = i58;
            int i65 = i59;
            int i66 = i60;
            modp_NTT2(iArr, i22, iArr, i20, i2, i66, i65);
            int i67 = i16 + i51;
            int i68 = 0;
            int i69 = i67;
            while (i68 < i12) {
                int i70 = i22 + (i68 << 1);
                iArr[i69] = modp_montymul(modp_montymul(iArr[i70], iArr[i70 + 1], i66, i65), i64, i66, i65);
                i68++;
                i69 += i14;
            }
            if (i5 == 0) {
                int i71 = i2 - 1;
                modp_iNTT2_ext(iArr, i54, i14, iArr, i21, i71, i66, i65);
                modp_iNTT2_ext(iArr, i67, i14, iArr, i21, i71, i66, i65);
            }
            i49 = i51 + 1;
        }
    }

    /* renamed from: mkgauss */
    private static int m17543mkgauss(SHAKEDigest sHAKEDigest, int i) {
        int i2 = 1 << (10 - i);
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            long j = get_rng_u64(sHAKEDigest);
            int i5 = (int) (j >>> 63);
            int i6 = (int) (((j & LongCompanionObject.MAX_VALUE) - gauss_1024_12289[0]) >>> 63);
            long j2 = LongCompanionObject.MAX_VALUE & get_rng_u64(sHAKEDigest);
            int i7 = 1;
            int i8 = 0;
            while (true) {
                long[] jArr = gauss_1024_12289;
                if (i7 < jArr.length) {
                    int i9 = ((int) ((j2 - jArr[i7]) >>> 63)) ^ 1;
                    i8 |= (-((i6 ^ 1) & i9)) & i7;
                    i6 |= i9;
                    i7++;
                }
            }
            i3 += ((-i5) ^ i8) + i5;
        }
        return i3;
    }

    /* renamed from: mkn */
    private static int m17544mkn(int i) {
        return 1 << i;
    }

    private static void modp_NTT2(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5) {
        modp_NTT2_ext(iArr, i, 1, iArr2, i2, i3, i4, i5);
    }

    private static void modp_NTT2_ext(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6) {
        if (i4 == 0) {
            return;
        }
        int iM17544mkn = m17544mkn(i4);
        int i7 = 1;
        int i8 = iM17544mkn;
        while (i7 < iM17544mkn) {
            int i9 = i8 >> 1;
            int i10 = 0;
            int i11 = 0;
            while (i10 < i7) {
                int i12 = iArr2[i3 + i7 + i10];
                int i13 = i + (i11 * i2);
                int i14 = (i9 * i2) + i13;
                int i15 = 0;
                while (i15 < i9) {
                    int i16 = iArr[i13];
                    int iModp_montymul = modp_montymul(iArr[i14], i12, i5, i6);
                    iArr[i13] = modp_add(i16, iModp_montymul, i5);
                    iArr[i14] = modp_sub(i16, iModp_montymul, i5);
                    i15++;
                    i13 += i2;
                    i14 += i2;
                }
                i10++;
                i11 += i8;
            }
            i7 <<= 1;
            i8 = i9;
        }
    }

    /* renamed from: modp_R */
    private static int m17545modp_R(int i) {
        return Integer.MIN_VALUE - i;
    }

    /* renamed from: modp_R2 */
    private static int m17546modp_R2(int i, int i2) {
        int iM17545modp_R = m17545modp_R(i);
        int iModp_add = modp_add(iM17545modp_R, iM17545modp_R, i);
        int iModp_montymul = modp_montymul(iModp_add, iModp_add, i, i2);
        int iModp_montymul2 = modp_montymul(iModp_montymul, iModp_montymul, i, i2);
        int iModp_montymul3 = modp_montymul(iModp_montymul2, iModp_montymul2, i, i2);
        int iModp_montymul4 = modp_montymul(iModp_montymul3, iModp_montymul3, i, i2);
        int iModp_montymul5 = modp_montymul(iModp_montymul4, iModp_montymul4, i, i2);
        return (iModp_montymul5 + (i & (-(iModp_montymul5 & 1)))) >>> 1;
    }

    /* renamed from: modp_Rx */
    private static int m17547modp_Rx(int i, int i2, int i3, int i4) {
        int i5 = i - 1;
        int iM17545modp_R = m17545modp_R(i2);
        int i6 = 0;
        while (true) {
            int i7 = 1 << i6;
            if (i7 > i5) {
                return iM17545modp_R;
            }
            if ((i7 & i5) != 0) {
                iM17545modp_R = modp_montymul(iM17545modp_R, i4, i2, i3);
            }
            i4 = modp_montymul(i4, i4, i2, i3);
            i6++;
        }
    }

    private static int modp_add(int i, int i2, int i3) {
        int i4 = (i + i2) - i3;
        return i4 + ((-(i4 >>> 31)) & i3);
    }

    private static int modp_div(int i, int i2, int i3, int i4, int i5) {
        int i6 = i3 - 2;
        for (int i7 = 30; i7 >= 0; i7--) {
            int iModp_montymul = modp_montymul(i5, i5, i3, i4);
            i5 = iModp_montymul ^ ((-(1 & (i6 >>> i7))) & (modp_montymul(iModp_montymul, i2, i3, i4) ^ iModp_montymul));
        }
        return modp_montymul(i, modp_montymul(i5, 1, i3, i4), i3, i4);
    }

    private static void modp_iNTT2(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5) {
        modp_iNTT2_ext(iArr, i, 1, iArr2, i2, i3, i4, i5);
    }

    private static void modp_iNTT2_ext(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6) {
        int i7;
        if (i4 == 0) {
            return;
        }
        int iM17544mkn = m17544mkn(i4);
        int i8 = iM17544mkn;
        int i9 = 1;
        while (true) {
            i7 = 0;
            if (i8 <= 1) {
                break;
            }
            i8 >>= 1;
            int i10 = i9 << 1;
            int i11 = 0;
            int i12 = 0;
            while (i11 < i8) {
                int i13 = iArr2[i3 + i8 + i11];
                int i14 = i + (i12 * i2);
                int i15 = (i9 * i2) + i14;
                int i16 = 0;
                while (i16 < i9) {
                    int i17 = iArr[i14];
                    int i18 = iArr[i15];
                    iArr[i14] = modp_add(i17, i18, i5);
                    iArr[i15] = modp_montymul(modp_sub(i17, i18, i5), i13, i5, i6);
                    i16++;
                    i14 += i2;
                    i15 += i2;
                }
                i11++;
                i12 += i10;
            }
            i9 = i10;
        }
        int i19 = 1 << (31 - i4);
        int i20 = i;
        while (i7 < iM17544mkn) {
            iArr[i20] = modp_montymul(iArr[i20], i19, i5, i6);
            i7++;
            i20 += i2;
        }
    }

    private static void modp_mkgm2(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4, int i5, int i6) {
        int iM17544mkn = m17544mkn(i3);
        int iM17546modp_R2 = m17546modp_R2(i5, i6);
        int iModp_montymul = modp_montymul(i4, iM17546modp_R2, i5, i6);
        for (int i7 = i3; i7 < 10; i7++) {
            iModp_montymul = modp_montymul(iModp_montymul, iModp_montymul, i5, i6);
        }
        int iModp_div = modp_div(iM17546modp_R2, iModp_montymul, i5, i6, m17545modp_R(i5));
        int i8 = 10 - i3;
        int iM17545modp_R = m17545modp_R(i5);
        int iModp_montymul2 = iM17545modp_R;
        for (int i9 = 0; i9 < iM17544mkn; i9++) {
            short s = f23112REV10[i9 << i8];
            iArr[i + s] = iM17545modp_R;
            iArr2[s + i2] = iModp_montymul2;
            iM17545modp_R = modp_montymul(iM17545modp_R, iModp_montymul, i5, i6);
            iModp_montymul2 = modp_montymul(iModp_montymul2, iModp_div, i5, i6);
        }
    }

    private static int modp_montymul(int i, int i2, int i3, int i4) {
        long unsignedLong = toUnsignedLong(i) * toUnsignedLong(i2);
        int i5 = ((int) ((unsignedLong + (((i4 * unsignedLong) & 2147483647L) * i3)) >>> 31)) - i3;
        return i5 + ((-(i5 >>> 31)) & i3);
    }

    private static int modp_ninv31(int i) {
        int i2 = 2 - i;
        int i3 = i2 * (2 - (i * i2));
        int i4 = i3 * (2 - (i * i3));
        int i5 = i4 * (2 - (i * i4));
        return Integer.MAX_VALUE & (-(i5 * (2 - (i * i5))));
    }

    private static int modp_norm(int i, int i2) {
        return i - (i2 & (((i - ((i2 + 1) >>> 1)) >>> 31) - 1));
    }

    private static void modp_poly_rec_res(int[] iArr, int i, int i2, int i3, int i4, int i5) {
        int i6 = 1 << (i2 - 1);
        for (int i7 = 0; i7 < i6; i7++) {
            int i8 = (i7 << 1) + i;
            iArr[i + i7] = modp_montymul(modp_montymul(iArr[i8], iArr[i8 + 1], i3, i4), i5, i3, i4);
        }
    }

    private static int modp_set(int i, int i2) {
        return i + (i2 & (-(i >>> 31)));
    }

    private static int modp_sub(int i, int i2, int i3) {
        int i4 = i - i2;
        return i4 + ((-(i4 >>> 31)) & i3);
    }

    private static void poly_big_to_fp(double[] dArr, int[] iArr, int i, int i2, int i3, int i4) {
        int iM17544mkn = m17544mkn(i4);
        double d = 0.0d;
        if (i2 == 0) {
            for (int i5 = 0; i5 < iM17544mkn; i5++) {
                dArr[i5] = 0.0d;
            }
            return;
        }
        int i6 = i;
        int i7 = 0;
        while (i7 < iM17544mkn) {
            int i8 = -(iArr[(i6 + i2) - 1] >>> 30);
            int i9 = i8 >>> 1;
            int i10 = i8 & 1;
            double d2 = 1.0d;
            double d3 = d;
            int i11 = 0;
            while (i11 < i2) {
                int i12 = (iArr[i6 + i11] ^ i9) + i10;
                i10 = i12 >>> 31;
                int i13 = i12 & Integer.MAX_VALUE;
                d3 += (i13 - ((i13 << 1) & i8)) * d2;
                i11++;
                d2 *= 2.147483648E9d;
            }
            dArr[i7] = d3;
            i7++;
            i6 += i3;
            d = 0.0d;
        }
    }

    private static int poly_big_to_small(byte[] bArr, int i, int[] iArr, int i2, int i3, int i4) {
        int iM17544mkn = m17544mkn(i4);
        for (int i5 = 0; i5 < iM17544mkn; i5++) {
            int iZint_one_to_plain = zint_one_to_plain(iArr, i2 + i5);
            if (iZint_one_to_plain < (-i3) || iZint_one_to_plain > i3) {
                return 0;
            }
            bArr[i + i5] = (byte) iZint_one_to_plain;
        }
        return 1;
    }

    private static void poly_small_mkgauss(SHAKEDigest sHAKEDigest, byte[] bArr, int i) {
        int iM17543mkgauss;
        int iM17544mkn = m17544mkn(i);
        int i2 = 0;
        for (int i3 = 0; i3 < iM17544mkn; i3++) {
            while (true) {
                iM17543mkgauss = m17543mkgauss(sHAKEDigest, i);
                if (iM17543mkgauss >= -127 && iM17543mkgauss <= 127) {
                    if (i3 != iM17544mkn - 1) {
                        i2 ^= iM17543mkgauss & 1;
                        break;
                    } else if (((iM17543mkgauss & 1) ^ i2) == 0) {
                    }
                }
            }
            bArr[i3] = (byte) iM17543mkgauss;
        }
    }

    private static int poly_small_sqnorm(byte[] bArr, int i) {
        int iM17544mkn = m17544mkn(i);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < iM17544mkn; i4++) {
            byte b = bArr[i4];
            i2 += b * b;
            i3 |= i2;
        }
        return (-(i3 >>> 31)) | i2;
    }

    private static void poly_small_to_fp(double[] dArr, int i, byte[] bArr, int i2) {
        int iM17544mkn = m17544mkn(i2);
        for (int i3 = 0; i3 < iM17544mkn; i3++) {
            dArr[i + i3] = bArr[i3];
        }
    }

    private static void poly_sub_scaled(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8, int i9) {
        int iM17544mkn = m17544mkn(i9);
        for (int i10 = 0; i10 < iM17544mkn; i10++) {
            int i11 = -iArr3[i10];
            int i12 = i + (i10 * i3);
            int i13 = i4;
            for (int i14 = 0; i14 < iM17544mkn; i14++) {
                zint_add_scaled_mul_small(iArr, i12, i2, iArr2, i13, i5, i11, i7, i8);
                if (i10 + i14 == iM17544mkn - 1) {
                    i11 = -i11;
                    i12 = i;
                } else {
                    i12 += i3;
                }
                i13 += i6;
            }
        }
    }

    private static void poly_sub_scaled_ntt(int[] iArr, int i, int i2, int i3, int[] iArr2, int i4, int i5, int i6, int[] iArr3, int i7, int i8, int i9, int[] iArr4, int i10) {
        int iM17544mkn = m17544mkn(i9);
        int i11 = i5 + 1;
        int iM17544mkn2 = i10 + m17544mkn(i9);
        int iM17544mkn3 = iM17544mkn2 + m17544mkn(i9);
        int i12 = iM17544mkn3 + (iM17544mkn * i11);
        int i13 = 0;
        while (i13 < i11) {
            FalconSmallPrime[] falconSmallPrimeArr = FalconSmallPrimeList.f23136PRIMES;
            int i14 = falconSmallPrimeArr[i13].f23134p;
            int iModp_ninv31 = modp_ninv31(i14);
            int iM17546modp_R2 = m17546modp_R2(i14, iModp_ninv31);
            int iM17547modp_Rx = m17547modp_Rx(i5, i14, iModp_ninv31, iM17546modp_R2);
            modp_mkgm2(iArr4, i10, iArr4, iM17544mkn2, i9, falconSmallPrimeArr[i13].f23133g, i14, iModp_ninv31);
            for (int i15 = 0; i15 < iM17544mkn; i15++) {
                iArr4[i12 + i15] = modp_set(iArr3[i15], i14);
            }
            int i16 = i13;
            int i17 = i11;
            int i18 = iM17544mkn;
            modp_NTT2(iArr4, i12, iArr4, i10, i9, i14, iModp_ninv31);
            int i19 = iM17544mkn3 + i16;
            int i20 = i4;
            int i21 = 0;
            int i22 = i19;
            while (i21 < i18) {
                iArr4[i22] = zint_mod_small_signed(iArr2, i20, i5, i14, iModp_ninv31, iM17546modp_R2, iM17547modp_Rx);
                i21++;
                i20 += i6;
                i22 += i17;
            }
            iM17544mkn = i18;
            modp_NTT2_ext(iArr4, i19, i17, iArr4, i10, i9, i14, iModp_ninv31);
            int i23 = 0;
            int i24 = i19;
            while (i23 < iM17544mkn) {
                iArr4[i24] = modp_montymul(modp_montymul(iArr4[i12 + i23], iArr4[i24], i14, iModp_ninv31), iM17546modp_R2, i14, iModp_ninv31);
                i23++;
                i24 += i17;
            }
            modp_iNTT2_ext(iArr4, i19, i17, iArr4, iM17544mkn2, i9, i14, iModp_ninv31);
            i13 = i16 + 1;
            i11 = i17;
        }
        int i25 = i11;
        int i26 = iM17544mkn;
        zint_rebuild_CRT(iArr4, iM17544mkn3, i25, i25, iM17544mkn, 1, iArr4, i12);
        int i27 = i;
        int i28 = 0;
        while (i28 < i26) {
            zint_sub_scaled(iArr, i27, i2, iArr4, iM17544mkn3, i25, i7, i8);
            i28++;
            i27 += i3;
            iM17544mkn3 += i25;
        }
    }

    private static int solve_NTRU(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int[] iArr) {
        int iM17544mkn = m17544mkn(i);
        if (solve_NTRU_deepest(i, bArr2, bArr3, iArr) == 0) {
            return 0;
        }
        if (i <= 2) {
            int i3 = i;
            while (true) {
                int i4 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                if (solve_NTRU_intermediate(i, bArr2, bArr3, i4, iArr) == 0) {
                    return 0;
                }
                i3 = i4;
            }
        } else {
            int i5 = i;
            while (true) {
                int i6 = i5 - 1;
                if (i5 > 2) {
                    if (solve_NTRU_intermediate(i, bArr2, bArr3, i6, iArr) == 0) {
                        return 0;
                    }
                    i5 = i6;
                } else if (solve_NTRU_binary_depth1(i, bArr2, bArr3, iArr) == 0 || solve_NTRU_binary_depth0(i, bArr2, bArr3, iArr) == 0) {
                    return 0;
                }
            }
        }
        byte[] bArr4 = new byte[iM17544mkn];
        if (poly_big_to_small(bArr, 0, iArr, 0, i2, i) == 0 || poly_big_to_small(bArr4, 0, iArr, iM17544mkn, i2, i) == 0) {
            return 0;
        }
        int i7 = iM17544mkn + iM17544mkn;
        int i8 = i7 + iM17544mkn;
        int i9 = i8 + iM17544mkn;
        FalconSmallPrime[] falconSmallPrimeArr = FalconSmallPrimeList.f23136PRIMES;
        int i10 = falconSmallPrimeArr[0].f23134p;
        int iModp_ninv31 = modp_ninv31(i10);
        modp_mkgm2(iArr, i9, iArr, 0, i, falconSmallPrimeArr[0].f23133g, i10, iModp_ninv31);
        for (int i11 = 0; i11 < iM17544mkn; i11++) {
            iArr[i11] = modp_set(bArr4[i11], i10);
        }
        for (int i12 = 0; i12 < iM17544mkn; i12++) {
            iArr[iM17544mkn + i12] = modp_set(bArr2[i12], i10);
            iArr[i7 + i12] = modp_set(bArr3[i12], i10);
            iArr[i8 + i12] = modp_set(bArr[i12], i10);
        }
        modp_NTT2(iArr, iM17544mkn, iArr, i9, i, i10, iModp_ninv31);
        modp_NTT2(iArr, i7, iArr, i9, i, i10, iModp_ninv31);
        modp_NTT2(iArr, i8, iArr, i9, i, i10, iModp_ninv31);
        modp_NTT2(iArr, 0, iArr, i9, i, i10, iModp_ninv31);
        int iModp_montymul = modp_montymul(12289, 1, i10, iModp_ninv31);
        for (int i13 = 0; i13 < iM17544mkn; i13++) {
            if (modp_sub(modp_montymul(iArr[iM17544mkn + i13], iArr[i13], i10, iModp_ninv31), modp_montymul(iArr[i7 + i13], iArr[i8 + i13], i10, iModp_ninv31), i10) != iModp_montymul) {
                return 0;
            }
        }
        return 1;
    }

    private static int solve_NTRU_binary_depth0(int i, byte[] bArr, byte[] bArr2, int[] iArr) {
        int i2 = 1 << i;
        int i3 = i2 >> 1;
        FalconSmallPrime[] falconSmallPrimeArr = FalconSmallPrimeList.f23136PRIMES;
        int i4 = falconSmallPrimeArr[0].f23134p;
        int iModp_ninv31 = modp_ninv31(i4);
        int iM17546modp_R2 = m17546modp_R2(i4, iModp_ninv31);
        int i5 = i3 + i3;
        int i6 = i5 + i2;
        int i7 = i6 + i2;
        int i8 = i7 + i2;
        modp_mkgm2(iArr, i7, iArr, i8, i, falconSmallPrimeArr[0].f23133g, i4, iModp_ninv31);
        for (int i9 = 0; i9 < i3; i9++) {
            iArr[i9] = modp_set(zint_one_to_plain(iArr, i9), i4);
            int i10 = i3 + i9;
            iArr[i10] = modp_set(zint_one_to_plain(iArr, i10), i4);
        }
        int i11 = i - 1;
        modp_NTT2(iArr, 0, iArr, i7, i11, i4, iModp_ninv31);
        modp_NTT2(iArr, i3, iArr, i7, i11, i4, iModp_ninv31);
        for (int i12 = 0; i12 < i2; i12++) {
            iArr[i5 + i12] = modp_set(bArr[i12], i4);
            iArr[i6 + i12] = modp_set(bArr2[i12], i4);
        }
        modp_NTT2(iArr, i5, iArr, i7, i, i4, iModp_ninv31);
        modp_NTT2(iArr, i6, iArr, i7, i, i4, iModp_ninv31);
        int i13 = 0;
        while (i13 < i2) {
            int i14 = i5 + i13;
            int i15 = iArr[i14];
            int i16 = i14 + 1;
            int i17 = iArr[i16];
            int i18 = i6 + i13;
            int i19 = iArr[i18];
            int i20 = i18 + 1;
            int i21 = iArr[i20];
            int i22 = i13 >> 1;
            int i23 = i2;
            int iModp_montymul = modp_montymul(iArr[i22], iM17546modp_R2, i4, iModp_ninv31);
            int i24 = i3;
            int iModp_montymul2 = modp_montymul(iArr[i3 + i22], iM17546modp_R2, i4, iModp_ninv31);
            iArr[i14] = modp_montymul(i21, iModp_montymul, i4, iModp_ninv31);
            iArr[i16] = modp_montymul(i19, iModp_montymul, i4, iModp_ninv31);
            iArr[i18] = modp_montymul(i17, iModp_montymul2, i4, iModp_ninv31);
            iArr[i20] = modp_montymul(i15, iModp_montymul2, i4, iModp_ninv31);
            i13 += 2;
            i2 = i23;
            i3 = i24;
        }
        int i25 = i2;
        int i26 = i3;
        modp_iNTT2(iArr, i5, iArr, i8, i, i4, iModp_ninv31);
        modp_iNTT2(iArr, i6, iArr, i8, i, i4, iModp_ninv31);
        int i27 = i25 + i25;
        System.arraycopy(iArr, i5, iArr, 0, i25 * 2);
        int i28 = i27 + i25;
        int i29 = i28 + i25;
        int i30 = i29 + i25;
        int i31 = i30 + i25;
        modp_mkgm2(iArr, i27, iArr, i28, i, FalconSmallPrimeList.f23136PRIMES[0].f23133g, i4, iModp_ninv31);
        modp_NTT2(iArr, 0, iArr, i27, i, i4, iModp_ninv31);
        modp_NTT2(iArr, i25, iArr, i27, i, i4, iModp_ninv31);
        int iModp_set = modp_set(bArr[0], i4);
        iArr[i31] = iModp_set;
        iArr[i30] = iModp_set;
        for (int i32 = 1; i32 < i25; i32++) {
            iArr[i30 + i32] = modp_set(bArr[i32], i4);
            iArr[(i31 + i25) - i32] = modp_set(-bArr[i32], i4);
        }
        modp_NTT2(iArr, i30, iArr, i27, i, i4, iModp_ninv31);
        modp_NTT2(iArr, i31, iArr, i27, i, i4, iModp_ninv31);
        for (int i33 = 0; i33 < i25; i33++) {
            int iModp_montymul3 = modp_montymul(iArr[i31 + i33], iM17546modp_R2, i4, iModp_ninv31);
            iArr[i28 + i33] = modp_montymul(iModp_montymul3, iArr[i33], i4, iModp_ninv31);
            iArr[i29 + i33] = modp_montymul(iModp_montymul3, iArr[i30 + i33], i4, iModp_ninv31);
        }
        int iModp_set2 = modp_set(bArr2[0], i4);
        iArr[i31] = iModp_set2;
        iArr[i30] = iModp_set2;
        for (int i34 = 1; i34 < i25; i34++) {
            iArr[i30 + i34] = modp_set(bArr2[i34], i4);
            iArr[(i31 + i25) - i34] = modp_set(-bArr2[i34], i4);
        }
        modp_NTT2(iArr, i30, iArr, i27, i, i4, iModp_ninv31);
        modp_NTT2(iArr, i31, iArr, i27, i, i4, iModp_ninv31);
        for (int i35 = 0; i35 < i25; i35++) {
            int iModp_montymul4 = modp_montymul(iArr[i31 + i35], iM17546modp_R2, i4, iModp_ninv31);
            int i36 = i28 + i35;
            iArr[i36] = modp_add(iArr[i36], modp_montymul(iModp_montymul4, iArr[i25 + i35], i4, iModp_ninv31), i4);
            int i37 = i29 + i35;
            iArr[i37] = modp_add(iArr[i37], modp_montymul(iModp_montymul4, iArr[i30 + i35], i4, iModp_ninv31), i4);
        }
        modp_mkgm2(iArr, i27, iArr, i30, i, FalconSmallPrimeList.f23136PRIMES[0].f23133g, i4, iModp_ninv31);
        modp_iNTT2(iArr, i28, iArr, i30, i, i4, iModp_ninv31);
        modp_iNTT2(iArr, i29, iArr, i30, i, i4, iModp_ninv31);
        for (int i38 = 0; i38 < i25; i38++) {
            int i39 = i28 + i38;
            iArr[i27 + i38] = modp_norm(iArr[i39], i4);
            iArr[i39] = modp_norm(iArr[i29 + i38], i4);
        }
        double[] dArr = new double[i25 * 3];
        for (int i40 = 0; i40 < i25; i40++) {
            dArr[i27 + i40] = iArr[i28 + i40];
        }
        FalconFFT.m17539FFT(dArr, i27, i);
        System.arraycopy(dArr, i27, dArr, i25, i26);
        int i41 = i26 + i25;
        for (int i42 = 0; i42 < i25; i42++) {
            dArr[i41 + i42] = iArr[i27 + i42];
        }
        FalconFFT.m17539FFT(dArr, i41, i);
        FalconFFT.poly_div_autoadj_fft(dArr, i41, dArr, i25, i);
        FalconFFT.m17540iFFT(dArr, i41, i);
        for (int i43 = 0; i43 < i25; i43++) {
            iArr[i27 + i43] = modp_set((int) FPREngine.fpr_rint(dArr[i41 + i43]), i4);
        }
        modp_mkgm2(iArr, i28, iArr, i29, i, FalconSmallPrimeList.f23136PRIMES[0].f23133g, i4, iModp_ninv31);
        for (int i44 = 0; i44 < i25; i44++) {
            iArr[i30 + i44] = modp_set(bArr[i44], i4);
            iArr[i31 + i44] = modp_set(bArr2[i44], i4);
        }
        modp_NTT2(iArr, i27, iArr, i28, i, i4, iModp_ninv31);
        modp_NTT2(iArr, i30, iArr, i28, i, i4, iModp_ninv31);
        modp_NTT2(iArr, i31, iArr, i28, i, i4, iModp_ninv31);
        for (int i45 = 0; i45 < i25; i45++) {
            int iModp_montymul5 = modp_montymul(iArr[i27 + i45], iM17546modp_R2, i4, iModp_ninv31);
            iArr[i45] = modp_sub(iArr[i45], modp_montymul(iModp_montymul5, iArr[i30 + i45], i4, iModp_ninv31), i4);
            int i46 = i25 + i45;
            iArr[i46] = modp_sub(iArr[i46], modp_montymul(iModp_montymul5, iArr[i31 + i45], i4, iModp_ninv31), i4);
        }
        modp_iNTT2(iArr, 0, iArr, i29, i, i4, iModp_ninv31);
        modp_iNTT2(iArr, i25, iArr, i29, i, i4, iModp_ninv31);
        for (int i47 = 0; i47 < i25; i47++) {
            iArr[i47] = modp_norm(iArr[i47], i4);
            int i48 = i25 + i47;
            iArr[i48] = modp_norm(iArr[i48], i4);
        }
        return 1;
    }

    private static int solve_NTRU_binary_depth1(int i, byte[] bArr, byte[] bArr2, int[] iArr) {
        int i2;
        int i3 = 1 << i;
        int i4 = i - 1;
        int i5 = 1 << i4;
        int i6 = i5 >> 1;
        int[] iArr2 = MAX_BL_SMALL;
        int i7 = iArr2[1];
        int i8 = iArr2[2];
        int i9 = MAX_BL_LARGE[1];
        int i10 = i8 * i6;
        int i11 = i10 + i10;
        int i12 = i9 * i5;
        int i13 = i11 + i12;
        int i14 = 0;
        int i15 = 0;
        while (i15 < i9) {
            int i16 = FalconSmallPrimeList.f23136PRIMES[i15].f23134p;
            int iModp_ninv31 = modp_ninv31(i16);
            int iM17546modp_R2 = m17546modp_R2(i16, iModp_ninv31);
            int iM17547modp_Rx = m17547modp_Rx(i8, i16, iModp_ninv31, iM17546modp_R2);
            int i17 = i11 + i15;
            int i18 = i13 + i15;
            int i19 = i14;
            int i20 = i4;
            int i21 = i10;
            int i22 = i19;
            while (i22 < i6) {
                int i23 = iModp_ninv31;
                int i24 = i16;
                iArr[i17] = zint_mod_small_signed(iArr, i19, i8, i24, i23, iM17546modp_R2, iM17547modp_Rx);
                iArr[i18] = zint_mod_small_signed(iArr, i21, i8, i24, i23, iM17546modp_R2, iM17547modp_Rx);
                i22++;
                i19 += i8;
                i21 += i8;
                i17 += i9;
                i18 += i9;
                i12 = i12;
                i11 = i11;
                i14 = i14;
                iModp_ninv31 = i23;
                i16 = i24;
                i15 = i15;
                i6 = i6;
                i13 = i13;
                i3 = i3;
                i5 = i5;
            }
            i15++;
            i4 = i20;
            i6 = i6;
            i3 = i3;
            i5 = i5;
        }
        int i25 = i3;
        int i26 = i4;
        int i27 = i5;
        int i28 = i6;
        int i29 = i14;
        int i30 = i12;
        System.arraycopy(iArr, i11, iArr, i29, i30);
        System.arraycopy(iArr, i13, iArr, i30, i30);
        int i31 = i30 + i30;
        int i32 = i7 * i27;
        int i33 = i31 + i32;
        int i34 = i33 + i32;
        int i35 = i29;
        while (i35 < i9) {
            FalconSmallPrime[] falconSmallPrimeArr = FalconSmallPrimeList.f23136PRIMES;
            int i36 = falconSmallPrimeArr[i35].f23134p;
            int iModp_ninv312 = modp_ninv31(i36);
            int i37 = i34 + i25;
            int i38 = i37 + i27;
            int i39 = i38 + i25;
            int i40 = i32;
            int iM17546modp_R22 = m17546modp_R2(i36, iModp_ninv312);
            int i41 = iModp_ninv312;
            int i42 = i36;
            int i43 = i33;
            int i44 = i35;
            modp_mkgm2(iArr, i34, iArr, i37, i, falconSmallPrimeArr[i35].f23133g, i36, i41);
            int i45 = i25;
            for (int i46 = 0; i46 < i45; i46++) {
                iArr[i38 + i46] = modp_set(bArr[i46], i42);
                iArr[i39 + i46] = modp_set(bArr2[i46], i42);
            }
            modp_NTT2(iArr, i38, iArr, i34, i, i42, i41);
            modp_NTT2(iArr, i39, iArr, i34, i, i42, i41);
            int i47 = i;
            int i48 = i26;
            while (i47 > i48) {
                int i49 = i47;
                modp_poly_rec_res(iArr, i38, i47, i42, i41, iM17546modp_R22);
                modp_poly_rec_res(iArr, i39, i49, i42, i41, iM17546modp_R22);
                i47 = i49 - 1;
            }
            int i50 = i34 + i27;
            int i51 = i27;
            System.arraycopy(iArr, i37, iArr, i50, i51);
            int i52 = i50 + i51;
            System.arraycopy(iArr, i38, iArr, i52, i51);
            int i53 = i52 + i51;
            System.arraycopy(iArr, i39, iArr, i53, i51);
            int i54 = i53 + i51;
            int i55 = i54 + i28;
            int i56 = i30 + i44;
            int i57 = i44;
            int i58 = i56;
            int i59 = i28;
            int i60 = 0;
            while (i60 < i59) {
                iArr[i54 + i60] = iArr[i57];
                iArr[i55 + i60] = iArr[i58];
                i60++;
                i57 += i9;
                i58 += i9;
            }
            int i61 = i - 2;
            int i62 = i30;
            int i63 = i59;
            modp_NTT2(iArr, i54, iArr, i34, i61, i42, i41);
            modp_NTT2(iArr, i55, iArr, i34, i61, i42, i41);
            int i64 = i44;
            int i65 = i56;
            int i66 = 0;
            while (i66 < i63) {
                int i67 = i66 << 1;
                int i68 = i52 + i67;
                int i69 = iArr[i68];
                int i70 = iArr[i68 + 1];
                int i71 = i67 + i53;
                int i72 = i45;
                int i73 = iArr[i71];
                int i74 = iArr[i71 + 1];
                int i75 = iArr[i54 + i66];
                int i76 = i54;
                int i77 = i42;
                int i78 = i63;
                int i79 = i41;
                int i80 = iM17546modp_R22;
                int iModp_montymul = modp_montymul(i75, i80, i77, i79);
                int i81 = i53;
                int iModp_montymul2 = modp_montymul(iArr[i55 + i66], i80, i77, i79);
                iArr[i64] = modp_montymul(i74, iModp_montymul, i77, i79);
                iArr[i64 + i9] = modp_montymul(i73, iModp_montymul, i77, i79);
                iArr[i65] = modp_montymul(i70, iModp_montymul2, i77, i79);
                iArr[i65 + i9] = modp_montymul(i69, iModp_montymul2, i77, i79);
                i66++;
                int i82 = i9 << 1;
                i64 += i82;
                i65 += i82;
                i41 = i79;
                i63 = i78;
                i45 = i72;
                i53 = i81;
                i42 = i77;
                i54 = i76;
                iM17546modp_R22 = i80;
                i31 = i31;
            }
            int i83 = i45;
            int i84 = i31;
            int i85 = i53;
            int i86 = i42;
            int i87 = i63;
            int i88 = i41;
            modp_iNTT2_ext(iArr, i44, i9, iArr, i50, i48, i86, i88);
            modp_iNTT2_ext(iArr, i56, i9, iArr, i50, i48, i86, i88);
            if (i44 < i7) {
                modp_iNTT2(iArr, i52, iArr, i50, i48, i86, i88);
                modp_iNTT2(iArr, i85, iArr, i50, i48, i86, i88);
                int i89 = i84 + i44;
                int i90 = i43 + i44;
                i2 = i51;
                int i91 = 0;
                while (i91 < i2) {
                    iArr[i89] = iArr[i52 + i91];
                    iArr[i90] = iArr[i85 + i91];
                    i91++;
                    i89 += i7;
                    i90 += i7;
                }
            } else {
                i2 = i51;
            }
            i35 = i44 + 1;
            i25 = i83;
            i32 = i40;
            i31 = i84;
            i33 = i43;
            i26 = i48;
            i27 = i2;
            i30 = i62;
            i28 = i87;
        }
        int i92 = i31;
        int i93 = i32;
        int i94 = i28;
        int i95 = i30;
        int i96 = i27;
        int i97 = i26;
        int i98 = i96 << 1;
        zint_rebuild_CRT(iArr, 0, i9, i9, i98, 1, iArr, i34);
        zint_rebuild_CRT(iArr, i92, i7, i7, i98, 1, iArr, i34);
        double[] dArr = new double[i96];
        double[] dArr2 = new double[i96];
        poly_big_to_fp(dArr, iArr, 0, i9, i9, i97);
        poly_big_to_fp(dArr2, iArr, i95, i9, i9, i97);
        System.arraycopy(iArr, i92, iArr, 0, i7 * 2 * i96);
        double[] dArr3 = new double[i96];
        double[] dArr4 = new double[i96];
        poly_big_to_fp(dArr3, iArr, 0, i7, i7, i97);
        poly_big_to_fp(dArr4, iArr, i93, i7, i7, i97);
        FalconFFT.m17539FFT(dArr, 0, i97);
        FalconFFT.m17539FFT(dArr2, 0, i97);
        FalconFFT.m17539FFT(dArr3, 0, i97);
        FalconFFT.m17539FFT(dArr4, 0, i97);
        double[] dArr5 = new double[i96];
        double[] dArr6 = new double[i94];
        FalconFFT.poly_add_muladj_fft(dArr5, dArr, dArr2, dArr3, dArr4, i97);
        FalconFFT.poly_invnorm2_fft(dArr6, 0, dArr3, 0, dArr4, 0, i97);
        FalconFFT.poly_mul_autoadj_fft(dArr5, 0, dArr6, 0, i97);
        FalconFFT.m17540iFFT(dArr5, 0, i97);
        for (int i99 = 0; i99 < i96; i99++) {
            double d = dArr5[i99];
            if (d >= 9.223372036854776E18d || -9.223372036854776E18d >= d) {
                return 0;
            }
            dArr5[i99] = FPREngine.fpr_rint(d);
        }
        FalconFFT.m17539FFT(dArr5, 0, i97);
        FalconFFT.poly_mul_fft(dArr3, 0, dArr5, 0, i97);
        FalconFFT.poly_mul_fft(dArr4, 0, dArr5, 0, i97);
        FalconFFT.poly_sub(dArr, 0, dArr3, 0, i97);
        FalconFFT.poly_sub(dArr2, 0, dArr4, 0, i97);
        FalconFFT.m17540iFFT(dArr, 0, i97);
        FalconFFT.m17540iFFT(dArr2, 0, i97);
        for (int i100 = 0; i100 < i96; i100++) {
            iArr[i100] = (int) FPREngine.fpr_rint(dArr[i100]);
            iArr[i96 + i100] = (int) FPREngine.fpr_rint(dArr2[i100]);
        }
        return 1;
    }

    private static int solve_NTRU_deepest(int i, byte[] bArr, byte[] bArr2, int[] iArr) {
        int i2 = MAX_BL_SMALL[i];
        int i3 = i2 + i2;
        int i4 = i3 + i2;
        int i5 = i4 + i2;
        m17542make_fg(iArr, i3, bArr, bArr2, i, i, 0);
        zint_rebuild_CRT(iArr, i3, i2, i2, 2, 0, iArr, i5);
        return (zint_bezout(iArr, i2, iArr, 0, iArr, i3, iArr, i4, i2, iArr, i5) != 0 && zint_mul_small(iArr, 0, i2, 12289) == 0 && zint_mul_small(iArr, i2, i2, 12289) == 0) ? 1 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0376, code lost:
    
        return r9;
     */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x03fd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int solve_NTRU_intermediate(int i, byte[] bArr, byte[] bArr2, int i2, int[] iArr) {
        double d;
        int i3;
        int[] iArr2;
        double[] dArr;
        double[] dArr2;
        double[] dArr3;
        double[] dArr4;
        double[] dArr5;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr3;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int[] iArr4 = iArr;
        int i19 = i - i2;
        int i20 = 1 << i19;
        int i21 = i20 >> 1;
        int[] iArr5 = MAX_BL_SMALL;
        int i22 = iArr5[i2];
        int i23 = iArr5[i2 + 1];
        int i24 = MAX_BL_LARGE[i2];
        int i25 = i23 * i21;
        int i26 = i25 + i25;
        int i27 = i19;
        m17542make_fg(iArr, i26, bArr, bArr2, i, i2, 1);
        int i28 = i20 * i24;
        int i29 = i28 + i28;
        int i30 = i20 * i22;
        System.arraycopy(iArr4, i26, iArr4, i29, i30 + i30);
        int i31 = i29 + i30;
        int i32 = i31 + i30;
        int i33 = 0;
        System.arraycopy(iArr4, 0, iArr4, i32, i25 + i25);
        int i34 = i25 + i32;
        int i35 = 0;
        while (i35 < i24) {
            int i36 = FalconSmallPrimeList.f23136PRIMES[i35].f23134p;
            int iModp_ninv31 = modp_ninv31(i36);
            int iM17546modp_R2 = m17546modp_R2(i36, iModp_ninv31);
            int iM17547modp_Rx = m17547modp_Rx(i23, i36, iModp_ninv31, iM17546modp_R2);
            int i37 = i28 + i35;
            int i38 = i35;
            int i39 = i33;
            int i40 = i34;
            int i41 = i32;
            while (i39 < i21) {
                int i42 = iM17546modp_R2;
                int i43 = iModp_ninv31;
                iArr4[i38] = zint_mod_small_signed(iArr, i41, i23, i36, i43, i42, iM17547modp_Rx);
                iArr4[i37] = zint_mod_small_signed(iArr, i40, i23, i36, i43, i42, iM17547modp_Rx);
                i39++;
                i41 += i23;
                i40 += i23;
                i38 += i24;
                i37 += i24;
                iM17546modp_R2 = i42;
                iModp_ninv31 = i43;
                i35 = i35;
                i29 = i29;
            }
            i35++;
            i33 = 0;
        }
        int i44 = i29;
        int i45 = 0;
        while (i45 < i24) {
            FalconSmallPrime[] falconSmallPrimeArr = FalconSmallPrimeList.f23136PRIMES;
            int i46 = falconSmallPrimeArr[i45].f23134p;
            int iModp_ninv312 = modp_ninv31(i46);
            int iM17546modp_R22 = m17546modp_R2(i46, iModp_ninv312);
            if (i45 == i22) {
                i6 = i24;
                i7 = i22;
                int i47 = i20;
                i9 = i32;
                i10 = i27;
                i8 = i21;
                iArr3 = iArr4;
                zint_rebuild_CRT(iArr, i44, i22, i22, i20, 1, iArr, i9);
                zint_rebuild_CRT(iArr, i31, i7, i22, i47, 1, iArr, i9);
                i11 = i47;
            } else {
                i6 = i24;
                i7 = i22;
                i8 = i21;
                i9 = i32;
                iArr3 = iArr4;
                i10 = i27;
                i11 = i20;
            }
            int i48 = i9 + i11;
            int i49 = i48 + i11;
            int i50 = i49 + i11;
            int i51 = falconSmallPrimeArr[i45].f23133g;
            int i52 = i11;
            modp_mkgm2(iArr, i9, iArr, i48, i10, i51, i46, iModp_ninv312);
            if (i45 < i7) {
                int i53 = i44 + i45;
                int i54 = i31 + i45;
                int i55 = i53;
                int i56 = i54;
                int i57 = 0;
                while (i57 < i52) {
                    iArr3[i49 + i57] = iArr3[i55];
                    iArr3[i50 + i57] = iArr3[i56];
                    i57++;
                    i55 += i7;
                    i56 += i7;
                }
                int i58 = i7;
                int i59 = i10;
                modp_iNTT2_ext(iArr, i53, i58, iArr, i48, i59, i46, iModp_ninv312);
                modp_iNTT2_ext(iArr, i54, i58, iArr, i48, i59, i46, iModp_ninv312);
                i12 = i52;
                i13 = i10;
                i14 = i7;
                i15 = iM17546modp_R22;
                i16 = iModp_ninv312;
                i17 = i46;
                i18 = i45;
            } else {
                int iM17547modp_Rx2 = m17547modp_Rx(i7, i46, iModp_ninv312, iM17546modp_R22);
                int i60 = i31;
                int i61 = i44;
                int i62 = 0;
                while (i62 < i52) {
                    int i63 = i7;
                    int i64 = iM17546modp_R22;
                    int i65 = i46;
                    iArr3[i49 + i62] = zint_mod_small_signed(iArr, i61, i7, i46, iModp_ninv312, i64, iM17547modp_Rx2);
                    iArr3[i50 + i62] = zint_mod_small_signed(iArr, i60, i7, i65, iModp_ninv312, i64, iM17547modp_Rx2);
                    i62++;
                    i61 += i63;
                    i60 += i63;
                    iM17546modp_R22 = i64;
                    i10 = i10;
                    i52 = i52;
                    i46 = i65;
                    i45 = i45;
                }
                i12 = i52;
                i13 = i10;
                i14 = i7;
                i15 = iM17546modp_R22;
                i16 = iModp_ninv312;
                i17 = i46;
                i18 = i45;
                int i66 = i9;
                modp_NTT2(iArr, i49, iArr, i66, i13, i46, i16);
                modp_NTT2(iArr, i50, iArr, i66, i13, i46, i16);
            }
            int i67 = i50 + i12;
            int i68 = i67 + i8;
            int i69 = i28 + i18;
            int i70 = i8;
            int i71 = i18;
            int i72 = i69;
            int i73 = 0;
            while (i73 < i70) {
                iArr3[i67 + i73] = iArr3[i71];
                iArr3[i68 + i73] = iArr3[i72];
                i73++;
                i71 += i6;
                i72 += i6;
            }
            int i74 = i13 - 1;
            int i75 = i9;
            int i76 = i17;
            int i77 = i16;
            modp_NTT2(iArr, i67, iArr, i75, i74, i76, i77);
            modp_NTT2(iArr, i68, iArr, i75, i74, i76, i77);
            int i78 = i18;
            int i79 = i69;
            int i80 = 0;
            while (i80 < i70) {
                int i81 = i80 << 1;
                int i82 = i49 + i81;
                int i83 = iArr3[i82];
                int i84 = iArr3[i82 + 1];
                int i85 = i50 + i81;
                int i86 = iArr3[i85];
                int i87 = iArr3[i85 + 1];
                int i88 = iArr3[i67 + i80];
                int i89 = i67;
                int i90 = i17;
                int i91 = i15;
                int i92 = i12;
                int i93 = i16;
                int iModp_montymul = modp_montymul(i88, i91, i90, i93);
                int i94 = i70;
                int iModp_montymul2 = modp_montymul(iArr3[i68 + i80], i91, i90, i93);
                iArr3[i78] = modp_montymul(i87, iModp_montymul, i90, i93);
                iArr3[i78 + i6] = modp_montymul(i86, iModp_montymul, i90, i93);
                iArr3[i79] = modp_montymul(i84, iModp_montymul2, i90, i93);
                iArr3[i79 + i6] = modp_montymul(i83, iModp_montymul2, i90, i93);
                i80++;
                int i95 = i6 << 1;
                i78 += i95;
                i79 += i95;
                i17 = i90;
                i70 = i94;
                i12 = i92;
                i15 = i91;
                i67 = i89;
            }
            int i96 = i12;
            int i97 = i17;
            int i98 = i16;
            i24 = i6;
            int i99 = i14;
            int i100 = i13;
            modp_iNTT2_ext(iArr, i18, i24, iArr, i48, i13, i97, i98);
            modp_iNTT2_ext(iArr, i69, i24, iArr, i48, i100, i97, i98);
            i21 = i70;
            i20 = i96;
            i27 = i100;
            i22 = i99;
            iArr4 = iArr3;
            i32 = i9;
            i45 = i18 + 1;
        }
        int i101 = i24;
        int i102 = i22;
        int i103 = i21;
        int i104 = i20;
        int i105 = i32;
        int[] iArr6 = iArr4;
        int i106 = i27;
        int i107 = 0;
        zint_rebuild_CRT(iArr, 0, i24, i101, i104, 1, iArr, i105);
        zint_rebuild_CRT(iArr, i28, i24, i101, i104, 1, iArr, i105);
        double[] dArr6 = new double[i104];
        double[] dArr7 = new double[i104];
        double[] dArr8 = new double[i104];
        double[] dArr9 = new double[i104];
        double[] dArr10 = new double[i103];
        int[] iArr7 = new int[i104];
        int iMin = Math.min(i102, 10);
        int i108 = i104;
        poly_big_to_fp(dArr8, iArr, (i44 + i102) - iMin, iMin, i102, i106);
        poly_big_to_fp(dArr9, iArr, (i31 + i102) - iMin, iMin, i102, i106);
        int i109 = (i102 - iMin) * 31;
        int i110 = i2;
        int i111 = bitlength_avg[i110];
        int i112 = bitlength_std[i110];
        int i113 = i111 - (i112 * 6);
        int i114 = i111 + (i112 * 6);
        FalconFFT.m17539FFT(dArr8, 0, i106);
        FalconFFT.m17539FFT(dArr9, 0, i106);
        int i115 = 0;
        int i116 = i102;
        FalconFFT.poly_invnorm2_fft(dArr10, 0, dArr8, 0, dArr9, 0, i106);
        FalconFFT.poly_adj_fft(dArr8, 0, i106);
        FalconFFT.poly_adj_fft(dArr9, 0, i106);
        int i117 = i101 * 31;
        int i118 = i117;
        int i119 = i117 - i113;
        int i120 = i101;
        int i121 = 10;
        loop7: while (true) {
            int iMin2 = Math.min(i120, i121);
            int i122 = i121;
            int i123 = i120;
            int i124 = i118;
            poly_big_to_fp(dArr6, iArr, i120 - iMin2, iMin2, i101, i106);
            poly_big_to_fp(dArr7, iArr, (i28 + i123) - iMin2, iMin2, i101, i106);
            FalconFFT.m17539FFT(dArr6, i115, i106);
            FalconFFT.m17539FFT(dArr7, i115, i106);
            FalconFFT.poly_mul_fft(dArr6, i115, dArr8, i115, i106);
            FalconFFT.poly_mul_fft(dArr7, i115, dArr9, i115, i106);
            FalconFFT.poly_add(dArr7, i115, dArr6, i115, i106);
            FalconFFT.poly_mul_autoadj_fft(dArr7, i115, dArr10, i115, i106);
            FalconFFT.m17540iFFT(dArr7, i115, i106);
            int i125 = (i119 - ((i120 - iMin2) * 31)) + i109;
            if (i125 < 0) {
                i125 = -i125;
                d = 2.0d;
            } else {
                d = 0.5d;
            }
            double d2 = 1.0d;
            while (i125 != 0) {
                if ((i125 & 1) != 0) {
                    d2 *= d;
                }
                i125 >>= 1;
                d *= d;
            }
            int i126 = i108;
            for (int i127 = i115; i127 < i126; i127++) {
                double d3 = dArr7[i127] * d2;
                if (-2.147483647E9d >= d3 || d3 >= 2.147483647E9d) {
                    break loop7;
                }
                iArr7[i127] = (int) FPREngine.fpr_rint(d3);
            }
            int i128 = i119 / 31;
            int i129 = i119 % 31;
            if (i110 <= 4) {
                i3 = i115;
                i4 = i122;
                iArr2 = iArr7;
                dArr = dArr10;
                dArr2 = dArr9;
                dArr3 = dArr8;
                dArr4 = dArr7;
                int i130 = i116;
                dArr5 = dArr6;
                int i131 = i116;
                poly_sub_scaled_ntt(iArr, 0, i123, i101, iArr, i44, i130, i131, iArr2, i128, i129, i106, iArr, i105);
                poly_sub_scaled_ntt(iArr, i28, i123, i101, iArr, i31, i130, i131, iArr2, i128, i129, i106, iArr, i105);
            } else {
                i3 = i115;
                iArr2 = iArr7;
                dArr = dArr10;
                dArr2 = dArr9;
                dArr3 = dArr8;
                dArr4 = dArr7;
                dArr5 = dArr6;
                i4 = i122;
                int i132 = i116;
                int i133 = i116;
                poly_sub_scaled(iArr, 0, i123, i101, iArr, i44, i132, i133, iArr2, i128, i129, i106);
                poly_sub_scaled(iArr, i28, i123, i101, iArr, i31, i132, i133, iArr2, i128, i129, i106);
            }
            int i134 = i119 + i114;
            int i135 = i134 + 10;
            if (i135 < i124) {
                if (i123 * 31 >= i134 + 41) {
                    i5 = i123 - 1;
                }
                int i136 = i116;
                if (i119 > 0) {
                    if (i5 < i136) {
                        int i137 = i3;
                        while (i137 < i126) {
                            int i138 = (-(iArr6[(i107 + i5) - 1] >>> 30)) >>> 1;
                            for (int i139 = i5; i139 < i136; i139++) {
                                iArr6[i107 + i139] = i138;
                            }
                            int i140 = (-(iArr6[(i28 + i5) - 1] >>> 30)) >>> 1;
                            for (int i141 = i5; i141 < i136; i141++) {
                                iArr6[i28 + i141] = i140;
                            }
                            i137++;
                            i107 += i101;
                            i28 += i101;
                        }
                    }
                    int i142 = i3;
                    int i143 = i142;
                    while (i143 < (i126 << 1)) {
                        System.arraycopy(iArr6, i3, iArr6, i142, i136);
                        i143++;
                        i142 += i136;
                        i3 += i101;
                    }
                    return 1;
                }
                int i144 = i119 - 25;
                i119 = i144 < 0 ? i3 : i144;
                i115 = i3;
                i121 = i4;
                iArr7 = iArr2;
                i116 = i136;
                dArr10 = dArr;
                dArr9 = dArr2;
                dArr8 = dArr3;
                dArr7 = dArr4;
                dArr6 = dArr5;
                i110 = i2;
                i108 = i126;
                i120 = i5;
                i118 = i135;
            } else {
                i135 = i124;
            }
            i5 = i123;
            int i1362 = i116;
            if (i119 > 0) {
            }
        }
    }

    private static long toUnsignedLong(int i) {
        return i & BodyPartID.bodyIdMax;
    }

    private static void zint_add_mul_small(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = i + i6;
            long unsignedLong = (toUnsignedLong(iArr2[i2 + i6]) * toUnsignedLong(i4)) + toUnsignedLong(iArr[i7]) + toUnsignedLong(i5);
            iArr[i7] = ((int) unsignedLong) & Integer.MAX_VALUE;
            i5 = (int) (unsignedLong >>> 31);
        }
        iArr[i + i3] = i5;
    }

    private static void zint_add_scaled_mul_small(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6, int i7) {
        if (i4 == 0) {
            return;
        }
        int i8 = (-(iArr2[(i3 + i4) - 1] >>> 30)) >>> 1;
        int i9 = 0;
        int i10 = i6;
        int i11 = 0;
        while (i10 < i2) {
            int i12 = i10 - i6;
            int i13 = i12 < i4 ? iArr2[i3 + i12] : i8;
            int i14 = i + i10;
            long unsignedLong = (toUnsignedLong(i9 | ((i13 << i7) & Integer.MAX_VALUE)) * i5) + toUnsignedLong(iArr[i14]) + i11;
            iArr[i14] = ((int) unsignedLong) & Integer.MAX_VALUE;
            i11 = (int) (unsignedLong >>> 31);
            i10++;
            i9 = i13 >>> (31 - i7);
        }
    }

    private static int zint_bezout(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3, int[] iArr4, int i4, int i5, int[] iArr5, int i6) {
        int i7 = i5;
        int[] iArr6 = iArr5;
        if (i7 == 0) {
            return 0;
        }
        int i8 = i6 + i7;
        int i9 = i8 + i7;
        int i10 = i9 + i7;
        int iModp_ninv31 = modp_ninv31(iArr3[i3]);
        int iModp_ninv312 = modp_ninv31(iArr4[i4]);
        System.arraycopy(iArr3, i3, iArr6, i9, i7);
        System.arraycopy(iArr4, i4, iArr6, i10, i7);
        iArr[i] = 1;
        iArr2[i2] = 0;
        for (int i11 = 1; i11 < i7; i11++) {
            iArr[i + i11] = 0;
            iArr2[i2 + i11] = 0;
        }
        System.arraycopy(iArr4, i4, iArr6, i6, i7);
        System.arraycopy(iArr3, i3, iArr6, i8, i7);
        iArr6[i8] = iArr6[i8] - 1;
        int i12 = 30;
        int i13 = (i7 * 62) + 30;
        while (true) {
            if (i13 < i12) {
                break;
            }
            int i14 = -1;
            int i15 = -1;
            int i16 = i7;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            while (true) {
                int i21 = i16 - 1;
                if (i16 <= 0) {
                    break;
                }
                int i22 = iArr6[i9 + i21];
                int i23 = iArr6[i10 + i21];
                i18 ^= (i18 ^ i22) & i15;
                i17 ^= (i17 ^ i22) & i14;
                i20 ^= (i20 ^ i23) & i15;
                i19 ^= (i19 ^ i23) & i14;
                int i24 = ((((i22 | i23) + Integer.MAX_VALUE) >>> 31) - 1) & i15;
                i16 = i21;
                int i25 = i15;
                i15 = i24;
                i14 = i25;
            }
            int i26 = ~i14;
            long unsignedLong = (toUnsignedLong(i18 & i26) << 31) + toUnsignedLong(i17 | (i18 & i14));
            long unsignedLong2 = (toUnsignedLong(i20 & i26) << 31) + toUnsignedLong(i19 | (i20 & i14));
            int i27 = iArr6[i9];
            int i28 = iArr6[i10];
            long j = 0;
            long j2 = 0;
            long j3 = 1;
            long j4 = 1;
            int i29 = 0;
            for (int i30 = 31; i29 < i30; i30 = 31) {
                long j5 = unsignedLong2 - unsignedLong;
                int i31 = i8;
                int i32 = (int) ((j5 ^ ((unsignedLong ^ unsignedLong2) & (unsignedLong ^ j5))) >>> 63);
                int i33 = (i27 >> i29) & 1;
                int i34 = i33 & (i28 >> i29) & 1;
                int i35 = i34 & i32;
                int i36 = i34 & (~i32);
                int i37 = (i33 ^ 1) | i35;
                int i38 = i27 - (i28 & (-i35));
                long j6 = unsignedLong - ((-toUnsignedLong(i35)) & unsignedLong2);
                long j7 = -i35;
                long j8 = j3 - (j2 & j7);
                long j9 = j - (j4 & j7);
                int i39 = i28 - ((-i36) & i38);
                long j10 = unsignedLong2 - (j6 & (-toUnsignedLong(i36)));
                long j11 = -i36;
                long j12 = j2 - (j8 & j11);
                long j13 = j4 - (j9 & j11);
                long j14 = i37;
                long j15 = j14 - 1;
                j3 = j8 + (j8 & j15);
                j = j9 + (j9 & j15);
                unsignedLong = j6 ^ ((j6 ^ (j6 >> 1)) & (-toUnsignedLong(i37)));
                i28 = i39 + (i39 & (-i37));
                long j16 = -j14;
                j2 = j12 + (j12 & j16);
                j4 = j13 + (j13 & j16);
                unsignedLong2 = j10 ^ (((j10 >> 1) ^ j10) & (toUnsignedLong(i37) - 1));
                i29++;
                i27 = i38 + ((i37 - 1) & i38);
                i8 = i31;
                i13 = i13;
            }
            int i40 = i8;
            int iZint_co_reduce = zint_co_reduce(iArr5, i9, iArr5, i10, i5, j3, j, j2, j4);
            long j17 = -(iZint_co_reduce & 1);
            long j18 = j3 - ((j3 + j3) & j17);
            long j19 = j - ((j + j) & j17);
            long j20 = -(iZint_co_reduce >>> 1);
            long j21 = j2 - ((j2 + j2) & j20);
            long j22 = j4 - ((j4 + j4) & j20);
            zint_co_reduce_mod(iArr, i, iArr5, i6, iArr4, i4, i5, iModp_ninv312, j18, j19, j21, j22);
            zint_co_reduce_mod(iArr2, i2, iArr5, i40, iArr3, i3, i5, iModp_ninv31, j18, j19, j21, j22);
            i13 -= 30;
            i7 = i5;
            iArr6 = iArr5;
            i12 = 30;
            i10 = i10;
            i9 = i9;
            i8 = i40;
        }
        int i41 = i9;
        int i42 = iArr5[i41] ^ 1;
        for (int i43 = 1; i43 < i5; i43++) {
            i42 |= iArr5[i41 + i43];
        }
        return (1 - ((i42 | (-i42)) >>> 31)) & iArr3[i3] & iArr4[i4];
    }

    private static int zint_co_reduce(int[] iArr, int i, int[] iArr2, int i2, int i3, long j, long j2, long j3, long j4) {
        int i4 = i2;
        int i5 = i3;
        long j5 = 0;
        int i6 = 0;
        long j6 = 0;
        while (i6 < i5) {
            int i7 = i + i6;
            int i8 = i4 + i6;
            long j7 = iArr[i7];
            long j8 = iArr2[i8];
            long j9 = (j7 * j) + (j8 * j2) + j5;
            long j10 = (j7 * j3) + (j8 * j4) + j6;
            if (i6 > 0) {
                iArr[i7 - 1] = ((int) j9) & Integer.MAX_VALUE;
                iArr2[i8 - 1] = ((int) j10) & Integer.MAX_VALUE;
            }
            j5 = j9 >> 31;
            j6 = j10 >> 31;
            i6++;
            i4 = i2;
            i5 = i3;
        }
        int i9 = i5;
        iArr[(i + i9) - 1] = (int) j5;
        iArr2[(i2 + i9) - 1] = (int) j6;
        int i10 = (int) (j5 >>> 63);
        int i11 = (int) (j6 >>> 63);
        zint_negate(iArr, i, i9, i10);
        zint_negate(iArr2, i2, i9, i11);
        return (i11 << 1) | i10;
    }

    private static void zint_co_reduce_mod(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3, int i4, int i5, long j, long j2, long j3, long j4) {
        long j5 = j;
        long j6 = j2;
        int i6 = iArr[i];
        int i7 = iArr2[i2];
        int i8 = (((((int) j5) * i6) + (((int) j6) * i7)) * i5) & Integer.MAX_VALUE;
        int i9 = (((i6 * ((int) j3)) + (i7 * ((int) j4))) * i5) & Integer.MAX_VALUE;
        long j7 = 0;
        int i10 = 0;
        long j8 = 0;
        while (i10 < i4) {
            int i11 = i + i10;
            int i12 = i2 + i10;
            long j9 = iArr[i11];
            long j10 = j9 * j5;
            long j11 = iArr2[i12];
            int i13 = i3 + i10;
            long unsignedLong = j10 + (j11 * j6) + (iArr3[i13] * toUnsignedLong(i8)) + j7;
            long unsignedLong2 = (j9 * j3) + (j11 * j4) + (iArr3[i13] * toUnsignedLong(i9)) + j8;
            if (i10 > 0) {
                iArr[i11 - 1] = ((int) unsignedLong) & Integer.MAX_VALUE;
                iArr2[i12 - 1] = ((int) unsignedLong2) & Integer.MAX_VALUE;
            }
            j7 = unsignedLong >> 31;
            j8 = unsignedLong2 >> 31;
            i10++;
            j5 = j;
            j6 = j2;
        }
        long j12 = j8;
        iArr[(i + i4) - 1] = (int) j7;
        iArr2[(i2 + i4) - 1] = (int) j12;
        zint_finish_mod(iArr, i, i4, iArr3, i3, (int) (j7 >>> 63));
        zint_finish_mod(iArr2, i2, i4, iArr3, i3, (int) (j12 >>> 63));
    }

    private static void zint_finish_mod(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4) {
        int i5 = 0;
        for (int i6 = 0; i6 < i2; i6++) {
            i5 = ((iArr[i + i6] - iArr2[i3 + i6]) - i5) >>> 31;
        }
        int i7 = (-i4) >>> 1;
        int i8 = -((1 - i5) | i4);
        for (int i9 = 0; i9 < i2; i9++) {
            int i10 = i + i9;
            int i11 = (iArr[i10] - ((iArr2[i3 + i9] ^ i7) & i8)) - i4;
            iArr[i10] = Integer.MAX_VALUE & i11;
            i4 = i11 >>> 31;
        }
    }

    private static int zint_mod_small_signed(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        if (i2 == 0) {
            return 0;
        }
        return modp_sub(zint_mod_small_unsigned(iArr, i, i2, i3, i4, i5), (-(iArr[(i + i2) - 1] >>> 30)) & i6, i3);
    }

    private static int zint_mod_small_unsigned(int[] iArr, int i, int i2, int i3, int i4, int i5) {
        int iModp_add = 0;
        while (true) {
            int i6 = i2 - 1;
            if (i2 <= 0) {
                return iModp_add;
            }
            int iModp_montymul = modp_montymul(iModp_add, i5, i3, i4);
            int i7 = iArr[i + i6] - i3;
            iModp_add = modp_add(iModp_montymul, i7 + ((-(i7 >>> 31)) & i3), i3);
            i2 = i6;
        }
    }

    private static int zint_mul_small(int[] iArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i + i5;
            long unsignedLong = (toUnsignedLong(iArr[i6]) * toUnsignedLong(i3)) + i4;
            iArr[i6] = ((int) unsignedLong) & Integer.MAX_VALUE;
            i4 = (int) (unsignedLong >> 31);
        }
        return i4;
    }

    private static void zint_negate(int[] iArr, int i, int i2, int i3) {
        int i4 = (-i3) >>> 1;
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = i + i5;
            int i7 = (iArr[i6] ^ i4) + i3;
            iArr[i6] = Integer.MAX_VALUE & i7;
            i3 = i7 >>> 31;
        }
    }

    private static void zint_norm_zero(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        int i4 = 0;
        int i5 = i3;
        int i6 = 0;
        while (true) {
            int i7 = i5 - 1;
            if (i5 <= 0) {
                zint_sub(iArr, i, iArr2, i2, i3, i4 >>> 31);
                return;
            }
            int i8 = iArr[i + i7];
            int i9 = iArr2[i2 + i7];
            int i10 = ((i6 << 30) | (i9 >>> 1)) - i8;
            i4 |= ((-(i10 >>> 31)) | ((-i10) >>> 31)) & ((i4 & 1) - 1);
            i5 = i7;
            i6 = i9 & 1;
        }
    }

    private static int zint_one_to_plain(int[] iArr, int i) {
        int i2 = iArr[i];
        return i2 | ((1073741824 & i2) << 1);
    }

    private static void zint_rebuild_CRT(int[] iArr, int i, int i2, int i3, int i4, int i5, int[] iArr2, int i6) {
        int i7 = 0;
        iArr2[i6] = FalconSmallPrimeList.f23136PRIMES[0].f23134p;
        int i8 = 1;
        while (i8 < i2) {
            FalconSmallPrime falconSmallPrime = FalconSmallPrimeList.f23136PRIMES[i8];
            int i9 = falconSmallPrime.f23134p;
            int i10 = falconSmallPrime.f23135s;
            int iModp_ninv31 = modp_ninv31(i9);
            int iM17546modp_R2 = m17546modp_R2(i9, iModp_ninv31);
            int i11 = i;
            int i12 = i7;
            while (i12 < i4) {
                int i13 = i11;
                zint_add_mul_small(iArr, i13, iArr2, i6, i8, modp_montymul(i10, modp_sub(iArr[i11 + i8], zint_mod_small_unsigned(iArr, i13, i8, i9, iModp_ninv31, iM17546modp_R2), i9), i9, iModp_ninv31));
                i12++;
                i11 += i3;
            }
            iArr2[i6 + i8] = zint_mul_small(iArr2, i6, i8, i9);
            i8++;
            i7 = 0;
        }
        if (i5 != 0) {
            int i14 = i;
            int i15 = 0;
            while (i15 < i4) {
                zint_norm_zero(iArr, i14, iArr2, i6, i2);
                i15++;
                i14 += i3;
            }
        }
    }

    private static void zint_sub(int[] iArr, int i, int[] iArr2, int i2, int i3, int i4) {
        int i5 = -i4;
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = i + i7;
            int i9 = iArr[i8];
            int i10 = (i9 - iArr2[i2 + i7]) - i6;
            i6 = i10 >>> 31;
            iArr[i8] = i9 ^ (((i10 & Integer.MAX_VALUE) ^ i9) & i5);
        }
    }

    private static void zint_sub_scaled(int[] iArr, int i, int i2, int[] iArr2, int i3, int i4, int i5, int i6) {
        if (i4 == 0) {
            return;
        }
        int i7 = (-(iArr2[(i3 + i4) - 1] >>> 30)) >>> 1;
        int i8 = 0;
        int i9 = i5;
        int i10 = 0;
        while (i9 < i2) {
            int i11 = i9 - i5;
            int i12 = i11 < i4 ? iArr2[i11 + i3] : i7;
            int i13 = i + i9;
            int i14 = (iArr[i13] - (i8 | ((i12 << i6) & Integer.MAX_VALUE))) - i10;
            iArr[i13] = i14 & Integer.MAX_VALUE;
            i10 = i14 >>> 31;
            i9++;
            i8 = i12 >>> (31 - i6);
        }
    }
}
