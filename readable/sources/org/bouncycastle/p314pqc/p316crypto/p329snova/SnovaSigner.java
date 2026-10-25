package org.bouncycastle.p314pqc.p316crypto.p329snova;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6242GF16;

/* loaded from: classes2.dex */
public class SnovaSigner implements MessageSigner {

    /* renamed from: engine */
    private SnovaEngine f23563engine;

    /* renamed from: params */
    private SnovaParameters f23564params;

    /* renamed from: privKey */
    private SnovaPrivateKeyParameters f23565privKey;

    /* renamed from: pubKey */
    private SnovaPublicKeyParameters f23566pubKey;

    /* renamed from: random */
    private SecureRandom f23567random;

    /* renamed from: shake */
    private final SHAKEDigest f23568shake = new SHAKEDigest(256);

    private void evaluation(byte[] bArr, MapGroup1 mapGroup1, byte[][][][] bArr2, byte[] bArr3) {
        int iM17866getM = this.f23564params.m17866getM();
        int alpha = this.f23564params.getAlpha();
        int iM17867getN = this.f23564params.m17867getN();
        int iM17864getL = this.f23564params.m17864getL();
        int iM17865getLsq = this.f23564params.m17865getLsq();
        int iM17869getO = this.f23564params.m17869getO();
        Class cls = Byte.TYPE;
        byte[][][] bArr4 = (byte[][][]) Array.newInstance((Class<?>) cls, alpha, iM17867getN, iM17865getLsq);
        byte[][][] bArr5 = (byte[][][]) Array.newInstance((Class<?>) cls, alpha, iM17867getN, iM17865getLsq);
        byte[] bArr6 = new byte[iM17865getLsq];
        int i = 0;
        int i2 = 0;
        while (i2 < iM17866getM) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < iM17867getN) {
                int i5 = 0;
                while (i5 < alpha) {
                    GF16Utils.gf16mTranMulMul(bArr3, i4, mapGroup1.f23528aAlpha[i2][i5], mapGroup1.f23529bAlpha[i2][i5], mapGroup1.f23533qAlpha1[i2][i5], mapGroup1.f23534qAlpha2[i2][i5], bArr6, bArr4[i5][i3], bArr5[i5][i3], iM17864getL);
                    i5++;
                    i3 = i3;
                }
                i3++;
                i4 += iM17865getLsq;
            }
            int i6 = i2;
            int i7 = 0;
            while (i7 < alpha) {
                if (i6 >= iM17869getO) {
                    i6 -= iM17869getO;
                }
                int i8 = 0;
                while (i8 < iM17867getN) {
                    int i9 = i;
                    int i10 = i2;
                    byte[] bArr7 = bArr6;
                    int i11 = iM17869getO;
                    int i12 = iM17865getLsq;
                    int i13 = iM17864getL;
                    GF16Utils.gf16mMul(getPMatrix(mapGroup1, bArr2, i6, i8, 0), bArr5[i7][0], bArr7, i13);
                    int i14 = 1;
                    while (i14 < iM17867getN) {
                        int i15 = i14;
                        GF16Utils.gf16mMulTo(getPMatrix(mapGroup1, bArr2, i6, i8, i14), bArr5[i7][i15], bArr7, i13);
                        i14 = i15 + 1;
                    }
                    GF16Utils.gf16mMulTo(bArr4[i7][i8], bArr7, bArr, i9, i13);
                    i8++;
                    iM17864getL = i13;
                    bArr6 = bArr7;
                    i = i9;
                    i2 = i10;
                    iM17869getO = i11;
                    iM17865getLsq = i12;
                }
                i7++;
                i6++;
                i2 = i2;
            }
            i2++;
            i += iM17865getLsq;
            bArr6 = bArr6;
        }
    }

    private byte[] getMessageHash(byte[] bArr) {
        byte[] bArr2 = new byte[this.f23568shake.getDigestSize()];
        this.f23568shake.mo14970update(bArr, 0, bArr.length);
        this.f23568shake.mo14967doFinal(bArr2, 0);
        return bArr2;
    }

    private byte[] getPMatrix(MapGroup1 mapGroup1, byte[][][][] bArr, int i, int i2, int i3) {
        int iM17870getV = this.f23564params.m17870getV();
        return i2 < iM17870getV ? i3 < iM17870getV ? mapGroup1.f23530p11[i][i2][i3] : mapGroup1.f23531p12[i][i2][i3 - iM17870getV] : i3 < iM17870getV ? mapGroup1.f23532p21[i][i2 - iM17870getV][i3] : bArr[i][i2 - iM17870getV][i3 - iM17870getV];
    }

    private int performGaussianElimination(byte[][] bArr, byte[] bArr2, int i) {
        int i2 = i + 1;
        int i3 = 0;
        while (i3 < i) {
            int i4 = i3;
            while (i4 < i && bArr[i4][i3] == 0) {
                i4++;
            }
            if (i4 >= i) {
                return 1;
            }
            if (i4 != i3) {
                byte[] bArr3 = bArr[i3];
                bArr[i3] = bArr[i4];
                bArr[i4] = bArr3;
            }
            byte bM18289inv = C6242GF16.m18289inv(bArr[i3][i3]);
            for (int i5 = i3; i5 < i2; i5++) {
                byte[] bArr4 = bArr[i3];
                bArr4[i5] = C6242GF16.m18291mul(bArr4[i5], bM18289inv);
            }
            int i6 = i3 + 1;
            for (int i7 = i6; i7 < i; i7++) {
                byte b = bArr[i7][i3];
                if (b != 0) {
                    for (int i8 = i3; i8 < i2; i8++) {
                        byte[] bArr5 = bArr[i7];
                        bArr5[i8] = (byte) (bArr5[i8] ^ C6242GF16.m18291mul(bArr[i3][i8], b));
                    }
                }
            }
            i3 = i6;
        }
        for (int i9 = i - 1; i9 >= 0; i9--) {
            byte bM18291mul = bArr[i9][i];
            for (int i10 = i9 + 1; i10 < i; i10++) {
                bM18291mul = (byte) (bM18291mul ^ C6242GF16.m18291mul(bArr[i9][i10], bArr2[i10]));
            }
            bArr2[i9] = bM18291mul;
        }
        return 0;
    }

    public void createSignedHash(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, byte[] bArr4, int i5) {
        this.f23568shake.mo14970update(bArr, 0, i);
        this.f23568shake.mo14970update(bArr2, 0, i2);
        this.f23568shake.mo14970update(bArr3, i3, i4);
        this.f23568shake.mo14998doFinal(bArr4, 0, i5);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        byte[] bArrCopyOfRange;
        byte[] bArrCopyOfRange2;
        byte[] messageHash = getMessageHash(bArr);
        byte[] bArr2 = new byte[this.f23564params.getSaltLength()];
        this.f23567random.nextBytes(bArr2);
        byte[] bArr3 = new byte[(((this.f23564params.m17867getN() * this.f23564params.m17865getLsq()) + 1) >>> 1) + this.f23564params.getSaltLength()];
        SnovaKeyElements snovaKeyElements = new SnovaKeyElements(this.f23564params);
        if (this.f23564params.isSkIsSeed()) {
            byte[] privateKey = this.f23565privKey.getPrivateKey();
            bArrCopyOfRange = C6238Arrays.copyOfRange(privateKey, 0, 16);
            bArrCopyOfRange2 = C6238Arrays.copyOfRange(privateKey, 16, privateKey.length);
            this.f23563engine.genMap1T12Map2(snovaKeyElements, bArrCopyOfRange, bArrCopyOfRange2);
        } else {
            byte[] privateKey2 = this.f23565privKey.getPrivateKey();
            int length = (privateKey2.length - 48) << 1;
            byte[] bArr4 = new byte[length];
            GF16Utils.decodeMergeInHalf(privateKey2, bArr4, length);
            SnovaKeyElements.m17862copy4d(bArr4, SnovaKeyElements.m17862copy4d(bArr4, SnovaKeyElements.m17862copy4d(bArr4, SnovaKeyElements.m17860copy3d(bArr4, SnovaKeyElements.m17860copy3d(bArr4, SnovaKeyElements.m17860copy3d(bArr4, SnovaKeyElements.m17860copy3d(bArr4, SnovaKeyElements.m17860copy3d(bArr4, 0, snovaKeyElements.f23551map1.f23528aAlpha), snovaKeyElements.f23551map1.f23529bAlpha), snovaKeyElements.f23551map1.f23533qAlpha1), snovaKeyElements.f23551map1.f23534qAlpha2), snovaKeyElements.f23550T12), snovaKeyElements.f23552map2.f23535f11), snovaKeyElements.f23552map2.f23536f12), snovaKeyElements.f23552map2.f23537f21);
            bArrCopyOfRange = C6238Arrays.copyOfRange(privateKey2, privateKey2.length - 48, privateKey2.length - 32);
            bArrCopyOfRange2 = C6238Arrays.copyOfRange(privateKey2, privateKey2.length - 32, privateKey2.length);
        }
        byte[] bArr5 = bArrCopyOfRange2;
        byte[] bArr6 = bArrCopyOfRange;
        MapGroup1 mapGroup1 = snovaKeyElements.f23551map1;
        byte[][][] bArr7 = mapGroup1.f23528aAlpha;
        byte[][][] bArr8 = mapGroup1.f23529bAlpha;
        byte[][][] bArr9 = mapGroup1.f23533qAlpha1;
        byte[][][] bArr10 = mapGroup1.f23534qAlpha2;
        byte[][][] bArr11 = snovaKeyElements.f23550T12;
        MapGroup2 mapGroup2 = snovaKeyElements.f23552map2;
        signDigestCore(bArr3, messageHash, bArr2, bArr7, bArr8, bArr9, bArr10, bArr11, mapGroup2.f23535f11, mapGroup2.f23536f12, mapGroup2.f23537f21, bArr6, bArr5);
        return C6238Arrays.concatenate(bArr3, bArr);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (z) {
            this.f23566pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f23565privKey = (SnovaPrivateKeyParameters) parametersWithRandom.getParameters();
                secureRandom = parametersWithRandom.getRandom();
            } else {
                this.f23565privKey = (SnovaPrivateKeyParameters) cipherParameters;
                secureRandom = CryptoServicesRegistrar.getSecureRandom();
            }
            this.f23567random = secureRandom;
            this.f23564params = this.f23565privKey.getParameters();
        } else {
            SnovaPublicKeyParameters snovaPublicKeyParameters = (SnovaPublicKeyParameters) cipherParameters;
            this.f23566pubKey = snovaPublicKeyParameters;
            this.f23564params = snovaPublicKeyParameters.getParameters();
            this.f23565privKey = null;
            this.f23567random = null;
        }
        this.f23563engine = new SnovaEngine(this.f23564params);
    }

    public void signDigestCore(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[][][] bArr4, byte[][][] bArr5, byte[][][] bArr6, byte[][][] bArr7, byte[][][] bArr8, byte[][][][] bArr9, byte[][][][] bArr10, byte[][][][] bArr11, byte[] bArr12, byte[] bArr13) {
        int i;
        int i2;
        byte[] bArr14;
        int i3;
        int i4;
        int i5;
        int i6;
        byte b;
        byte b2;
        byte[] bArr15 = bArr2;
        byte[] bArr16 = bArr13;
        int iM17866getM = this.f23564params.m17866getM();
        int iM17864getL = this.f23564params.m17864getL();
        int iM17865getLsq = this.f23564params.m17865getLsq();
        int alpha = this.f23564params.getAlpha();
        int iM17870getV = this.f23564params.m17870getV();
        int iM17869getO = this.f23564params.m17869getO();
        int iM17867getN = this.f23564params.m17867getN();
        int i7 = iM17866getM * iM17865getLsq;
        int i8 = iM17869getO * iM17865getLsq;
        int i9 = iM17870getV * iM17865getLsq;
        int i10 = (i8 + 1) >>> 1;
        Class cls = Byte.TYPE;
        byte[][] bArr17 = (byte[][]) Array.newInstance((Class<?>) cls, i7, i7 + 1);
        byte[][] bArr18 = (byte[][]) Array.newInstance((Class<?>) cls, iM17865getLsq, iM17865getLsq);
        byte[][][] bArr19 = (byte[][][]) Array.newInstance((Class<?>) cls, alpha, iM17870getV, iM17865getLsq);
        byte[][][] bArr20 = (byte[][][]) Array.newInstance((Class<?>) cls, alpha, iM17870getV, iM17865getLsq);
        byte[] bArr21 = new byte[iM17865getLsq];
        byte[] bArr22 = new byte[iM17865getLsq];
        int i11 = iM17867getN * iM17865getLsq;
        byte[] bArr23 = new byte[i10];
        int i12 = (i9 + 1) >>> 1;
        byte[] bArr24 = new byte[i12];
        byte[] bArr25 = new byte[iM17864getL];
        int i13 = iM17866getM;
        int i14 = iM17869getO;
        byte[] bArr26 = new byte[i7];
        int i15 = iM17870getV;
        byte[] bArr27 = new byte[iM17865getLsq];
        byte[] bArr28 = new byte[i11];
        int i16 = i12;
        byte[] bArr29 = bArr24;
        byte[] bArr30 = new byte[i7];
        int i17 = alpha;
        int i18 = iM17865getLsq;
        int i19 = iM17864getL;
        createSignedHash(bArr12, bArr12.length, bArr2, bArr15.length, bArr3, 0, bArr3.length, bArr23, i10);
        byte b3 = 0;
        C6242GF16.m18285decode(bArr23, 0, bArr30, 0, i7);
        byte b4 = 0;
        while (true) {
            for (int i20 = b3; i20 < bArr17.length; i20++) {
                C6238Arrays.m18249fill(bArr17[i20], b3);
            }
            byte b5 = (byte) (b4 + 1);
            for (int i21 = b3; i21 < i7; i21++) {
                bArr17[i21][i7] = bArr30[i21];
            }
            this.f23568shake.mo14970update(bArr16, b3, bArr16.length);
            this.f23568shake.mo14970update(bArr15, b3, bArr15.length);
            this.f23568shake.mo14970update(bArr3, b3, bArr3.length);
            this.f23568shake.mo14969update(b5);
            byte[] bArr31 = bArr29;
            int i22 = i16;
            this.f23568shake.mo14998doFinal(bArr31, b3, i22);
            byte[] bArr32 = bArr28;
            C6242GF16.m18286decode(bArr31, bArr32, i22 << 1);
            int i23 = b3;
            int i24 = i23;
            int i25 = i13;
            while (i23 < i25) {
                C6238Arrays.m18249fill(bArr27, b3);
                int i26 = i23;
                int i27 = b3;
                int i28 = i17;
                while (i27 < i28) {
                    byte b6 = b5;
                    int i29 = i14;
                    if (i26 >= i29) {
                        i26 -= i29;
                    }
                    int i30 = i26;
                    int i31 = i22;
                    int i32 = i15;
                    int i33 = 0;
                    int i34 = 0;
                    while (i33 < i32) {
                        GF16Utils.gf16mTranMulMul(bArr32, i34, bArr4[i23][i27], bArr5[i23][i27], bArr6[i23][i27], bArr7[i23][i27], bArr25, bArr19[i27][i33], bArr20[i27][i33], i19);
                        i33++;
                        i34 += i18;
                        bArr30 = bArr30;
                    }
                    byte[] bArr33 = bArr30;
                    int i35 = i18;
                    int i36 = 0;
                    while (i36 < i32) {
                        int i37 = 0;
                        while (i37 < i32) {
                            GF16Utils.gf16mMulMulTo(bArr19[i27][i36], bArr9[i30][i36][i37], bArr20[i27][i37], bArr25, bArr27, i19);
                            i37++;
                            i25 = i25;
                            i23 = i23;
                            i27 = i27;
                            i36 = i36;
                            bArr31 = bArr31;
                            bArr32 = bArr32;
                        }
                        i36++;
                    }
                    i27++;
                    i26 = i30 + 1;
                    i14 = i29;
                    i15 = i32;
                    i18 = i35;
                    bArr30 = bArr33;
                    b5 = b6;
                    i22 = i31;
                }
                int i38 = i25;
                int i39 = i23;
                byte[] bArr34 = bArr32;
                byte[] bArr35 = bArr31;
                byte b7 = b5;
                int i40 = i22;
                byte[] bArr36 = bArr30;
                int i41 = i14;
                int i42 = i15;
                byte[] bArr37 = bArr27;
                int i43 = i18;
                int i44 = i19;
                int i45 = 0;
                for (int i46 = 0; i46 < i44; i46++) {
                    int i47 = 0;
                    while (i47 < i44) {
                        byte[] bArr38 = bArr17[i24 + i45];
                        bArr38[i7] = (byte) (bArr37[i45] ^ bArr38[i7]);
                        i47++;
                        i45++;
                    }
                }
                int i48 = 0;
                int i49 = 0;
                while (i48 < i41) {
                    int i50 = i39;
                    int i51 = 0;
                    while (i51 < i28) {
                        if (i50 >= i41) {
                            i50 -= i41;
                        }
                        int i52 = i50;
                        for (int i53 = 0; i53 < i43; i53++) {
                            C6238Arrays.m18249fill(bArr18[i53], (byte) 0);
                        }
                        int i54 = 0;
                        while (i54 < i42) {
                            int i55 = i54;
                            int i56 = i51;
                            int i57 = i48;
                            GF16Utils.gf16mMulMul(bArr19[i51][i54], bArr10[i52][i54][i48], bArr7[i39][i51], bArr25, bArr21, i44);
                            GF16Utils.gf16mMulMul(bArr6[i39][i56], bArr11[i52][i57][i55], bArr20[i56][i55], bArr25, bArr22, i44);
                            int i58 = 0;
                            int i59 = 0;
                            int i60 = 0;
                            while (i60 < i43) {
                                if (i58 == i44) {
                                    i59 += i44;
                                    i58 = 0;
                                }
                                byte b8 = bArr21[i59];
                                byte b9 = bArr22[i58];
                                int i61 = 0;
                                int i62 = 0;
                                int i63 = 0;
                                int i64 = 0;
                                int i65 = 0;
                                while (i61 < i43) {
                                    if (i62 == i44) {
                                        int i66 = i63 + 1;
                                        i64 += i44;
                                        byte b10 = bArr21[i59 + i66];
                                        i5 = i66;
                                        i6 = i28;
                                        b2 = bArr22[i64 + i58];
                                        i65 = 0;
                                        b = b10;
                                        i62 = 0;
                                    } else {
                                        i5 = i63;
                                        i6 = i28;
                                        b = b8;
                                        b2 = b9;
                                    }
                                    byte b11 = bArr5[i39][i56][i65 + i58];
                                    int i67 = i59;
                                    byte b12 = bArr4[i39][i56][i59 + i62];
                                    byte[] bArr39 = bArr18[i60];
                                    bArr39[i61] = (byte) (bArr39[i61] ^ (C6242GF16.m18291mul(b12, b2) ^ C6242GF16.m18291mul(b, b11)));
                                    i61++;
                                    i62++;
                                    i65 += i44;
                                    b8 = b;
                                    b9 = b2;
                                    i59 = i67;
                                    i28 = i6;
                                    i63 = i5;
                                }
                                i60++;
                                i58++;
                            }
                            i54 = i55 + 1;
                            i51 = i56;
                            i48 = i57;
                        }
                        int i68 = i51;
                        int i69 = i48;
                        int i70 = i28;
                        for (int i71 = 0; i71 < i43; i71++) {
                            for (int i72 = 0; i72 < i43; i72++) {
                                byte[] bArr40 = bArr17[i24 + i71];
                                int i73 = i49 + i72;
                                bArr40[i73] = (byte) (bArr40[i73] ^ bArr18[i71][i72]);
                            }
                        }
                        i51 = i68 + 1;
                        i50 = i52 + 1;
                        i48 = i69;
                        i28 = i70;
                    }
                    i48++;
                    i49 += i43;
                }
                i17 = i28;
                i23 = i39 + 1;
                i24 += i43;
                i14 = i41;
                i15 = i42;
                i18 = i43;
                i19 = i44;
                bArr27 = bArr37;
                i25 = i38;
                bArr31 = bArr35;
                bArr30 = bArr36;
                b5 = b7;
                bArr32 = bArr34;
                i22 = i40;
                b3 = 0;
            }
            int i74 = i25;
            bArr28 = bArr32;
            byte[] bArr41 = bArr31;
            byte b13 = b5;
            i16 = i22;
            byte[] bArr42 = bArr30;
            i = i19;
            i2 = i14;
            bArr14 = bArr26;
            i3 = i15;
            byte[] bArr43 = bArr27;
            i4 = i18;
            if (performGaussianElimination(bArr17, bArr14, i7) == 0) {
                break;
            }
            bArr16 = bArr13;
            bArr26 = bArr14;
            i14 = i2;
            i15 = i3;
            i18 = i4;
            i19 = i;
            bArr27 = bArr43;
            i13 = i74;
            bArr29 = bArr41;
            bArr30 = bArr42;
            b4 = b13;
            b3 = 0;
            bArr15 = bArr2;
        }
        int i75 = 0;
        int i76 = 0;
        while (i75 < i3) {
            int i77 = 0;
            int i78 = 0;
            while (i77 < i2) {
                GF16Utils.gf16mMulTo(bArr8[i75][i77], bArr14, i78, bArr28, i76, i);
                i77++;
                i78 += i4;
            }
            i75++;
            i76 += i4;
        }
        System.arraycopy(bArr14, 0, bArr28, i9, i8);
        C6242GF16.m18287encode(bArr28, bArr, i11);
        System.arraycopy(bArr3, 0, bArr, bArr.length - 16, 16);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        byte[] messageHash = getMessageHash(bArr);
        MapGroup1 mapGroup1 = new MapGroup1(this.f23564params);
        byte[] encoded = this.f23566pubKey.getEncoded();
        byte[] bArrM18242copyOf = C6238Arrays.m18242copyOf(encoded, 16);
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(encoded, 16, encoded.length);
        this.f23563engine.m17858genABQP(mapGroup1, bArrM18242copyOf);
        byte[][][][] bArr3 = (byte[][][][]) Array.newInstance((Class<?>) Byte.TYPE, this.f23564params.m17866getM(), this.f23564params.m17869getO(), this.f23564params.m17869getO(), this.f23564params.m17865getLsq());
        if ((this.f23564params.m17865getLsq() & 1) == 0) {
            MapGroup1.m17850decodeP(bArrCopyOfRange, 0, bArr3, bArrCopyOfRange.length << 1);
        } else {
            int length = bArrCopyOfRange.length << 1;
            byte[] bArr4 = new byte[length];
            C6242GF16.m18286decode(bArrCopyOfRange, bArr4, length);
            MapGroup1.m17851fillP(bArr4, 0, bArr3, length);
        }
        return verifySignatureCore(messageHash, bArr2, bArrM18242copyOf, mapGroup1, bArr3);
    }

    public boolean verifySignatureCore(byte[] bArr, byte[] bArr2, byte[] bArr3, MapGroup1 mapGroup1, byte[][][][] bArr4) {
        int iM17865getLsq = this.f23564params.m17865getLsq();
        int iM17869getO = this.f23564params.m17869getO() * iM17865getLsq;
        int i = (iM17869getO + 1) >>> 1;
        int saltLength = this.f23564params.getSaltLength();
        int iM17866getM = this.f23564params.m17866getM();
        int iM17867getN = this.f23564params.m17867getN() * iM17865getLsq;
        byte[] bArr5 = new byte[i];
        createSignedHash(bArr3, bArr3.length, bArr, bArr.length, bArr2, (iM17867getN + 1) >>> 1, saltLength, bArr5, i);
        if ((iM17869getO & 1) != 0) {
            int i2 = i - 1;
            bArr5[i2] = (byte) (bArr5[i2] & 15);
        }
        byte[] bArr6 = new byte[iM17867getN];
        C6242GF16.m18285decode(bArr2, 0, bArr6, 0, iM17867getN);
        int i3 = iM17866getM * iM17865getLsq;
        byte[] bArr7 = new byte[i3];
        evaluation(bArr7, mapGroup1, bArr4, bArr6);
        byte[] bArr8 = new byte[i];
        C6242GF16.m18287encode(bArr7, bArr8, i3);
        return C6238Arrays.areEqual(bArr5, bArr8);
    }
}
