package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class RainbowSigner implements MessageSigner {

    /* renamed from: MAXITS */
    private static final int f24067MAXITS = 65536;

    /* renamed from: cf */
    private ComputeInField f24068cf = new ComputeInField();
    private InterfaceC5277Digest hashAlgo;

    /* renamed from: key */
    private RainbowKeyParameters f24069key;

    /* renamed from: random */
    private SecureRandom f24070random;
    int signableDocumentLength;

    /* renamed from: version */
    private EnumC6223Version f24071version;

    /* renamed from: org.bouncycastle.pqc.legacy.rainbow.RainbowSigner$1 */
    public static /* synthetic */ class C62221 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version;

        static {
            int[] iArr = new int[EnumC6223Version.m18143values().length];
            $SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version = iArr;
            try {
                iArr[EnumC6223Version.CLASSIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version[EnumC6223Version.CIRCUMZENITHAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version[EnumC6223Version.COMPRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private byte[] genSignature(byte[] bArr) {
        short[][] sArr;
        byte[] bArr2;
        byte[] bArr3 = new byte[this.hashAlgo.getDigestSize()];
        this.hashAlgo.mo14970update(bArr, 0, bArr.length);
        this.hashAlgo.mo14967doFinal(bArr3, 0);
        int iM18129getV1 = this.f24069key.getParameters().m18129getV1();
        int iM18127getO1 = this.f24069key.getParameters().m18127getO1();
        int iM18128getO2 = this.f24069key.getParameters().m18128getO2();
        int iM18124getM = this.f24069key.getParameters().m18124getM();
        int iM18125getN = this.f24069key.getParameters().m18125getN();
        RainbowPrivateKeyParameters rainbowPrivateKeyParameters = (RainbowPrivateKeyParameters) this.f24069key;
        InterfaceC5277Digest interfaceC5277Digest = this.hashAlgo;
        this.f24070random = new RainbowDRBG(RainbowUtil.m18140hash(interfaceC5277Digest, rainbowPrivateKeyParameters.f24054sk_seed, bArr3, new byte[interfaceC5277Digest.getDigestSize()]), rainbowPrivateKeyParameters.getParameters().getHash_algo());
        short[] sArr2 = new short[iM18129getV1];
        short[] sArr3 = new short[iM18127getO1];
        short[] sArr4 = new short[iM18128getO2];
        Class cls = Short.TYPE;
        short[][] sArr5 = (short[][]) Array.newInstance((Class<?>) cls, iM18128getO2, iM18127getO1);
        short[][] sArr6 = (short[][]) Array.newInstance((Class<?>) cls, iM18128getO2, iM18128getO2);
        byte[] bArr4 = new byte[rainbowPrivateKeyParameters.getParameters().getLen_salt()];
        short[] sArr7 = new short[iM18127getO1];
        short[] sArr8 = null;
        short[] sArr9 = new short[iM18128getO2];
        short[] sArr10 = new short[iM18124getM];
        short[][] sArrM18113inverse = null;
        int i = 0;
        while (sArrM18113inverse == null && i < 65536) {
            byte[] bArr5 = new byte[iM18129getV1];
            this.f24070random.nextBytes(bArr5);
            int i2 = 0;
            while (true) {
                bArr2 = bArr3;
                if (i2 >= iM18129getV1) {
                    break;
                }
                sArr2[i2] = (short) (bArr5[i2] & C1126UByte.MAX_VALUE);
                i2++;
                bArr3 = bArr2;
            }
            short[][] sArr11 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, iM18127getO1, iM18127getO1);
            for (int i3 = 0; i3 < iM18129getV1; i3++) {
                int i4 = 0;
                while (i4 < iM18127getO1) {
                    byte[] bArr6 = bArr4;
                    int i5 = 0;
                    while (i5 < iM18127getO1) {
                        int i6 = iM18124getM;
                        short[][] sArr12 = sArr6;
                        short sMultElem = GF2Field.multElem(rainbowPrivateKeyParameters.f24046l1_F2[i4][i3][i5], sArr2[i3]);
                        short[] sArr13 = sArr11[i4];
                        sArr13[i5] = GF2Field.m18115addElem(sArr13[i5], sMultElem);
                        i5++;
                        iM18124getM = i6;
                        sArr6 = sArr12;
                        sArr5 = sArr5;
                    }
                    i4++;
                    bArr4 = bArr6;
                }
            }
            sArrM18113inverse = this.f24068cf.m18113inverse(sArr11);
            i++;
            bArr3 = bArr2;
            sArr6 = sArr6;
        }
        byte[] bArr7 = bArr3;
        short[][] sArr14 = sArr6;
        int i7 = iM18124getM;
        byte[] bArr8 = bArr4;
        short[][] sArr15 = sArr5;
        for (int i8 = 0; i8 < iM18127getO1; i8++) {
            sArr3[i8] = this.f24068cf.multiplyMatrix_quad(rainbowPrivateKeyParameters.f24045l1_F1[i8], sArr2);
        }
        for (int i9 = 0; i9 < iM18129getV1; i9++) {
            for (int i10 = 0; i10 < iM18128getO2; i10++) {
                sArr4[i10] = this.f24068cf.multiplyMatrix_quad(rainbowPrivateKeyParameters.f24047l2_F1[i10], sArr2);
                for (int i11 = 0; i11 < iM18127getO1; i11++) {
                    short sMultElem2 = GF2Field.multElem(rainbowPrivateKeyParameters.f24048l2_F2[i10][i9][i11], sArr2[i9]);
                    short[] sArr16 = sArr15[i10];
                    sArr16[i11] = GF2Field.m18115addElem(sArr16[i11], sMultElem2);
                }
                for (int i12 = 0; i12 < iM18128getO2; i12++) {
                    short sMultElem3 = GF2Field.multElem(rainbowPrivateKeyParameters.f24049l2_F3[i10][i9][i12], sArr2[i9]);
                    short[] sArr17 = sArr14[i10];
                    sArr17[i12] = GF2Field.m18115addElem(sArr17[i12], sMultElem3);
                }
            }
        }
        int i13 = i7;
        byte[] bArr9 = new byte[i13];
        short[] sArr18 = sArr7;
        while (sArr8 == null && i < 65536) {
            short[][] sArr19 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, iM18128getO2, iM18128getO2);
            this.f24070random.nextBytes(bArr8);
            short[] sArrMakeMessageRepresentative = makeMessageRepresentative(RainbowUtil.m18140hash(this.hashAlgo, bArr7, bArr8, bArr9));
            byte[] bArr10 = bArr9;
            short[] sArr20 = sArr10;
            System.arraycopy(this.f24068cf.m18112addVect(C6238Arrays.m18247copyOf(sArrMakeMessageRepresentative, iM18127getO1), this.f24068cf.multiplyMatrix(rainbowPrivateKeyParameters.f24053s1, C6238Arrays.copyOfRange(sArrMakeMessageRepresentative, iM18127getO1, i13))), 0, sArr20, 0, iM18127getO1);
            System.arraycopy(sArrMakeMessageRepresentative, iM18127getO1, sArr20, iM18127getO1, iM18128getO2);
            short[] sArrMultiplyMatrix = this.f24068cf.multiplyMatrix(sArrM18113inverse, this.f24068cf.m18112addVect(sArr3, C6238Arrays.m18247copyOf(sArr20, iM18127getO1)));
            short[][] sArr21 = sArr15;
            short[] sArrMultiplyMatrix2 = this.f24068cf.multiplyMatrix(sArr21, sArrMultiplyMatrix);
            short[] sArr22 = sArr3;
            int i14 = 0;
            while (true) {
                sArr = sArrM18113inverse;
                if (i14 >= iM18128getO2) {
                    break;
                }
                sArr9[i14] = this.f24068cf.multiplyMatrix_quad(rainbowPrivateKeyParameters.f24050l2_F5[i14], sArrMultiplyMatrix);
                i14++;
                sArrM18113inverse = sArr;
                sArr21 = sArr21;
            }
            sArr15 = sArr21;
            short[] sArr23 = sArr9;
            short[] sArrM18112addVect = this.f24068cf.m18112addVect(this.f24068cf.m18112addVect(this.f24068cf.m18112addVect(sArrMultiplyMatrix2, sArr23), sArr4), C6238Arrays.copyOfRange(sArr20, iM18127getO1, i13));
            for (int i15 = 0; i15 < iM18127getO1; i15++) {
                int i16 = 0;
                while (true) {
                    int i17 = i13;
                    if (i16 < iM18128getO2) {
                        int i18 = 0;
                        while (i18 < iM18128getO2) {
                            short[] sArr24 = sArr4;
                            short[] sArr25 = sArr23;
                            short sMultElem4 = GF2Field.multElem(rainbowPrivateKeyParameters.f24051l2_F6[i16][i15][i18], sArrMultiplyMatrix[i15]);
                            short[] sArr26 = sArr19[i16];
                            sArr26[i18] = GF2Field.m18115addElem(sArr26[i18], sMultElem4);
                            i18++;
                            sArrMultiplyMatrix = sArrMultiplyMatrix;
                            sArr4 = sArr24;
                            sArr23 = sArr25;
                        }
                        i16++;
                        i13 = i17;
                    }
                }
            }
            int i19 = i13;
            short[] sArr27 = sArr23;
            short[] sArrSolveEquation = this.f24068cf.solveEquation(this.f24068cf.addMatrix(sArr19, sArr14), sArrM18112addVect);
            i++;
            sArr18 = sArrMultiplyMatrix;
            bArr9 = bArr10;
            sArr3 = sArr22;
            sArrM18113inverse = sArr;
            sArr8 = sArrSolveEquation;
            sArr10 = sArr20;
            i13 = i19;
            sArr9 = sArr27;
        }
        short[] sArr28 = sArr8 == null ? new short[iM18128getO2] : sArr8;
        short[] sArrM18112addVect2 = this.f24068cf.m18112addVect(this.f24068cf.m18112addVect(sArr2, this.f24068cf.multiplyMatrix(rainbowPrivateKeyParameters.f24055t1, sArr18)), this.f24068cf.multiplyMatrix(rainbowPrivateKeyParameters.f24057t4, sArr28));
        short[] sArrM18112addVect3 = this.f24068cf.m18112addVect(sArr18, this.f24068cf.multiplyMatrix(rainbowPrivateKeyParameters.f24056t3, sArr28));
        short[] sArrM18247copyOf = C6238Arrays.m18247copyOf(sArrM18112addVect2, iM18125getN);
        System.arraycopy(sArrM18112addVect3, 0, sArrM18247copyOf, iM18129getV1, iM18127getO1);
        System.arraycopy(sArr28, 0, sArrM18247copyOf, iM18127getO1 + iM18129getV1, iM18128getO2);
        if (i != 65536) {
            return C6238Arrays.concatenate(RainbowUtil.convertArray(sArrM18247copyOf), bArr8);
        }
        throw new IllegalStateException("unable to generate signature - LES not solvable");
    }

    private short[] makeMessageRepresentative(byte[] bArr) {
        int i = this.signableDocumentLength;
        short[] sArr = new short[i];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            sArr[i2] = (short) (bArr[i3] & C1126UByte.MAX_VALUE);
            i3++;
            i2++;
            if (i2 >= i) {
                break;
            }
        }
        return sArr;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        return genSignature(bArr);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        RainbowKeyParameters rainbowKeyParameters;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f24070random = parametersWithRandom.getRandom();
                rainbowKeyParameters = (RainbowKeyParameters) parametersWithRandom.getParameters();
            } else {
                rainbowKeyParameters = (RainbowKeyParameters) cipherParameters;
                SecureRandom secureRandom = CryptoServicesRegistrar.getSecureRandom();
                byte[] bArr = new byte[rainbowKeyParameters.getParameters().getLen_skseed()];
                secureRandom.nextBytes(bArr);
                this.f24070random = new RainbowDRBG(bArr, rainbowKeyParameters.getParameters().getHash_algo());
            }
            this.f24071version = rainbowKeyParameters.getParameters().getVersion();
            this.f24069key = rainbowKeyParameters;
        } else {
            RainbowKeyParameters rainbowKeyParameters2 = (RainbowKeyParameters) cipherParameters;
            this.f24069key = rainbowKeyParameters2;
            this.f24071version = rainbowKeyParameters2.getParameters().getVersion();
        }
        this.signableDocumentLength = this.f24069key.getDocLength();
        this.hashAlgo = this.f24069key.getParameters().getHash_algo();
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        short[] sArrPublicMap;
        byte[] bArr3 = new byte[this.hashAlgo.getDigestSize()];
        this.hashAlgo.mo14970update(bArr, 0, bArr.length);
        this.hashAlgo.mo14967doFinal(bArr3, 0);
        int iM18124getM = this.f24069key.getParameters().m18124getM();
        int iM18125getN = this.f24069key.getParameters().m18125getN();
        RainbowPublicMap rainbowPublicMap = new RainbowPublicMap(this.f24069key.getParameters());
        short[] sArrMakeMessageRepresentative = makeMessageRepresentative(RainbowUtil.m18140hash(this.hashAlgo, bArr3, C6238Arrays.copyOfRange(bArr2, iM18125getN, bArr2.length), new byte[iM18124getM]));
        short[] sArrConvertArray = RainbowUtil.convertArray(C6238Arrays.copyOfRange(bArr2, 0, iM18125getN));
        int i = C62221.$SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version[this.f24071version.ordinal()];
        if (i == 1) {
            sArrPublicMap = rainbowPublicMap.publicMap((RainbowPublicKeyParameters) this.f24069key, sArrConvertArray);
        } else {
            if (i != 2 && i != 3) {
                throw new IllegalArgumentException("No valid version. Please choose one of the following: classic, circumzenithal, compressed");
            }
            sArrPublicMap = rainbowPublicMap.publicMap_cyclic((RainbowPublicKeyParameters) this.f24069key, sArrConvertArray);
        }
        return RainbowUtil.m18136equals(sArrMakeMessageRepresentative, sArrPublicMap);
    }
}
