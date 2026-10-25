package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class RainbowKeyComputation {

    /* renamed from: cf */
    ComputeInField f24001cf;

    /* renamed from: l1_F1 */
    private short[][][] f24002l1_F1;

    /* renamed from: l1_F2 */
    private short[][][] f24003l1_F2;

    /* renamed from: l1_Q1 */
    private short[][][] f24004l1_Q1;

    /* renamed from: l1_Q2 */
    private short[][][] f24005l1_Q2;

    /* renamed from: l1_Q3 */
    private short[][][] f24006l1_Q3;

    /* renamed from: l1_Q5 */
    private short[][][] f24007l1_Q5;

    /* renamed from: l1_Q6 */
    private short[][][] f24008l1_Q6;

    /* renamed from: l1_Q9 */
    private short[][][] f24009l1_Q9;

    /* renamed from: l2_F1 */
    private short[][][] f24010l2_F1;

    /* renamed from: l2_F2 */
    private short[][][] f24011l2_F2;

    /* renamed from: l2_F3 */
    private short[][][] f24012l2_F3;

    /* renamed from: l2_F5 */
    private short[][][] f24013l2_F5;

    /* renamed from: l2_F6 */
    private short[][][] f24014l2_F6;

    /* renamed from: l2_Q1 */
    private short[][][] f24015l2_Q1;

    /* renamed from: l2_Q2 */
    private short[][][] f24016l2_Q2;

    /* renamed from: l2_Q3 */
    private short[][][] f24017l2_Q3;

    /* renamed from: l2_Q5 */
    private short[][][] f24018l2_Q5;

    /* renamed from: l2_Q6 */
    private short[][][] f24019l2_Q6;

    /* renamed from: l2_Q9 */
    private short[][][] f24020l2_Q9;

    /* renamed from: o1 */
    private int f24021o1;

    /* renamed from: o2 */
    private int f24022o2;

    /* renamed from: pk_seed */
    private byte[] f24023pk_seed;
    private RainbowParameters rainbowParams;

    /* renamed from: random */
    private SecureRandom f24024random;

    /* renamed from: s1 */
    private short[][] f24025s1;

    /* renamed from: sk_seed */
    private byte[] f24026sk_seed;

    /* renamed from: t1 */
    private short[][] f24027t1;

    /* renamed from: t2 */
    private short[][] f24028t2;

    /* renamed from: t3 */
    private short[][] f24029t3;

    /* renamed from: t4 */
    private short[][] f24030t4;

    /* renamed from: v1 */
    private int f24031v1;

    /* renamed from: version */
    private EnumC6223Version f24032version;

    public RainbowKeyComputation(RainbowParameters rainbowParameters, SecureRandom secureRandom) {
        this.f24001cf = new ComputeInField();
        this.rainbowParams = rainbowParameters;
        this.f24024random = secureRandom;
        this.f24032version = rainbowParameters.getVersion();
        this.f24031v1 = this.rainbowParams.m18129getV1();
        this.f24021o1 = this.rainbowParams.m18127getO1();
        this.f24022o2 = this.rainbowParams.m18128getO2();
    }

    private void calculate_F_from_Q() {
        this.f24002l1_F1 = RainbowUtil.cloneArray(this.f24004l1_Q1);
        this.f24003l1_F2 = new short[this.f24021o1][][];
        for (int i = 0; i < this.f24021o1; i++) {
            this.f24003l1_F2[i] = this.f24001cf.addMatrixTranspose(this.f24004l1_Q1[i]);
            short[][][] sArr = this.f24003l1_F2;
            sArr[i] = this.f24001cf.multiplyMatrix(sArr[i], this.f24027t1);
            short[][][] sArr2 = this.f24003l1_F2;
            sArr2[i] = this.f24001cf.addMatrix(sArr2[i], this.f24005l1_Q2[i]);
        }
        int i2 = this.f24022o2;
        this.f24011l2_F2 = new short[i2][][];
        this.f24012l2_F3 = new short[i2][][];
        this.f24013l2_F5 = new short[i2][][];
        this.f24014l2_F6 = new short[i2][][];
        this.f24010l2_F1 = RainbowUtil.cloneArray(this.f24015l2_Q1);
        for (int i3 = 0; i3 < this.f24022o2; i3++) {
            short[][] sArrAddMatrixTranspose = this.f24001cf.addMatrixTranspose(this.f24015l2_Q1[i3]);
            this.f24011l2_F2[i3] = this.f24001cf.multiplyMatrix(sArrAddMatrixTranspose, this.f24027t1);
            short[][][] sArr3 = this.f24011l2_F2;
            sArr3[i3] = this.f24001cf.addMatrix(sArr3[i3], this.f24016l2_Q2[i3]);
            this.f24012l2_F3[i3] = this.f24001cf.multiplyMatrix(sArrAddMatrixTranspose, this.f24030t4);
            short[][] sArrMultiplyMatrix = this.f24001cf.multiplyMatrix(this.f24016l2_Q2[i3], this.f24029t3);
            short[][][] sArr4 = this.f24012l2_F3;
            sArr4[i3] = this.f24001cf.addMatrix(sArr4[i3], sArrMultiplyMatrix);
            short[][][] sArr5 = this.f24012l2_F3;
            sArr5[i3] = this.f24001cf.addMatrix(sArr5[i3], this.f24017l2_Q3[i3]);
            short[][] sArrAddMatrix = this.f24001cf.addMatrix(this.f24001cf.multiplyMatrix(this.f24015l2_Q1[i3], this.f24027t1), this.f24016l2_Q2[i3]);
            short[][] sArrTranspose = this.f24001cf.transpose(this.f24027t1);
            this.f24013l2_F5[i3] = this.f24001cf.multiplyMatrix(sArrTranspose, sArrAddMatrix);
            short[][][] sArr6 = this.f24013l2_F5;
            sArr6[i3] = this.f24001cf.addMatrix(sArr6[i3], this.f24018l2_Q5[i3]);
            short[][][] sArr7 = this.f24013l2_F5;
            sArr7[i3] = this.f24001cf.m18114to_UT(sArr7[i3]);
            this.f24014l2_F6[i3] = this.f24001cf.multiplyMatrix(sArrTranspose, this.f24012l2_F3[i3]);
            ComputeInField computeInField = this.f24001cf;
            short[][] sArrMultiplyMatrix2 = computeInField.multiplyMatrix(computeInField.transpose(this.f24016l2_Q2[i3]), this.f24030t4);
            short[][][] sArr8 = this.f24014l2_F6;
            sArr8[i3] = this.f24001cf.addMatrix(sArr8[i3], sArrMultiplyMatrix2);
            short[][] sArrMultiplyMatrix3 = this.f24001cf.multiplyMatrix(this.f24001cf.addMatrixTranspose(this.f24018l2_Q5[i3]), this.f24029t3);
            short[][][] sArr9 = this.f24014l2_F6;
            sArr9[i3] = this.f24001cf.addMatrix(sArr9[i3], sArrMultiplyMatrix3);
            short[][][] sArr10 = this.f24014l2_F6;
            sArr10[i3] = this.f24001cf.addMatrix(sArr10[i3], this.f24019l2_Q6[i3]);
        }
    }

    private void calculate_Q_from_F() {
        short[][] sArrTranspose = this.f24001cf.transpose(this.f24027t1);
        short[][] sArrTranspose2 = this.f24001cf.transpose(this.f24028t2);
        this.f24004l1_Q1 = RainbowUtil.cloneArray(this.f24002l1_F1);
        this.f24005l1_Q2 = new short[this.f24021o1][][];
        for (int i = 0; i < this.f24021o1; i++) {
            this.f24005l1_Q2[i] = this.f24001cf.addMatrixTranspose(this.f24002l1_F1[i]);
            short[][][] sArr = this.f24005l1_Q2;
            sArr[i] = this.f24001cf.multiplyMatrix(sArr[i], this.f24027t1);
            short[][][] sArr2 = this.f24005l1_Q2;
            sArr2[i] = this.f24001cf.addMatrix(sArr2[i], this.f24003l1_F2[i]);
        }
        calculate_l1_Q3569(sArrTranspose, sArrTranspose2);
        int i2 = this.f24022o2;
        this.f24016l2_Q2 = new short[i2][][];
        this.f24017l2_Q3 = new short[i2][][];
        this.f24018l2_Q5 = new short[i2][][];
        this.f24019l2_Q6 = new short[i2][][];
        this.f24015l2_Q1 = RainbowUtil.cloneArray(this.f24010l2_F1);
        for (int i3 = 0; i3 < this.f24022o2; i3++) {
            short[][] sArrAddMatrixTranspose = this.f24001cf.addMatrixTranspose(this.f24010l2_F1[i3]);
            this.f24016l2_Q2[i3] = this.f24001cf.multiplyMatrix(sArrAddMatrixTranspose, this.f24027t1);
            short[][][] sArr3 = this.f24016l2_Q2;
            sArr3[i3] = this.f24001cf.addMatrix(sArr3[i3], this.f24011l2_F2[i3]);
            this.f24017l2_Q3[i3] = this.f24001cf.multiplyMatrix(sArrAddMatrixTranspose, this.f24028t2);
            short[][] sArrMultiplyMatrix = this.f24001cf.multiplyMatrix(this.f24011l2_F2[i3], this.f24029t3);
            short[][][] sArr4 = this.f24017l2_Q3;
            sArr4[i3] = this.f24001cf.addMatrix(sArr4[i3], sArrMultiplyMatrix);
            short[][][] sArr5 = this.f24017l2_Q3;
            sArr5[i3] = this.f24001cf.addMatrix(sArr5[i3], this.f24012l2_F3[i3]);
            this.f24018l2_Q5[i3] = this.f24001cf.multiplyMatrix(sArrTranspose, this.f24001cf.addMatrix(this.f24001cf.multiplyMatrix(this.f24010l2_F1[i3], this.f24027t1), this.f24011l2_F2[i3]));
            short[][][] sArr6 = this.f24018l2_Q5;
            sArr6[i3] = this.f24001cf.addMatrix(sArr6[i3], this.f24013l2_F5[i3]);
            short[][][] sArr7 = this.f24018l2_Q5;
            sArr7[i3] = this.f24001cf.m18114to_UT(sArr7[i3]);
            this.f24019l2_Q6[i3] = this.f24001cf.multiplyMatrix(sArrTranspose, this.f24017l2_Q3[i3]);
            ComputeInField computeInField = this.f24001cf;
            short[][] sArrMultiplyMatrix2 = computeInField.multiplyMatrix(computeInField.transpose(this.f24011l2_F2[i3]), this.f24028t2);
            short[][][] sArr8 = this.f24019l2_Q6;
            sArr8[i3] = this.f24001cf.addMatrix(sArr8[i3], sArrMultiplyMatrix2);
            short[][] sArrMultiplyMatrix3 = this.f24001cf.multiplyMatrix(this.f24001cf.addMatrixTranspose(this.f24013l2_F5[i3]), this.f24029t3);
            short[][][] sArr9 = this.f24019l2_Q6;
            sArr9[i3] = this.f24001cf.addMatrix(sArr9[i3], sArrMultiplyMatrix3);
            short[][][] sArr10 = this.f24019l2_Q6;
            sArr10[i3] = this.f24001cf.addMatrix(sArr10[i3], this.f24014l2_F6[i3]);
        }
        calculate_l2_Q9(sArrTranspose2);
    }

    private void calculate_Q_from_F_cyclic() {
        short[][] sArrTranspose = this.f24001cf.transpose(this.f24027t1);
        short[][] sArrTranspose2 = this.f24001cf.transpose(this.f24028t2);
        calculate_l1_Q3569(sArrTranspose, sArrTranspose2);
        calculate_l2_Q9(sArrTranspose2);
    }

    private void calculate_l1_Q3569(short[][] sArr, short[][] sArr2) {
        int i = this.f24021o1;
        this.f24006l1_Q3 = new short[i][][];
        this.f24007l1_Q5 = new short[i][][];
        this.f24008l1_Q6 = new short[i][][];
        this.f24009l1_Q9 = new short[i][][];
        for (int i2 = 0; i2 < this.f24021o1; i2++) {
            short[][] sArrMultiplyMatrix = this.f24001cf.multiplyMatrix(this.f24003l1_F2[i2], this.f24029t3);
            this.f24006l1_Q3[i2] = this.f24001cf.addMatrixTranspose(this.f24002l1_F1[i2]);
            short[][][] sArr3 = this.f24006l1_Q3;
            sArr3[i2] = this.f24001cf.multiplyMatrix(sArr3[i2], this.f24028t2);
            short[][][] sArr4 = this.f24006l1_Q3;
            sArr4[i2] = this.f24001cf.addMatrix(sArr4[i2], sArrMultiplyMatrix);
            this.f24007l1_Q5[i2] = this.f24001cf.multiplyMatrix(this.f24002l1_F1[i2], this.f24027t1);
            short[][][] sArr5 = this.f24007l1_Q5;
            sArr5[i2] = this.f24001cf.addMatrix(sArr5[i2], this.f24003l1_F2[i2]);
            short[][][] sArr6 = this.f24007l1_Q5;
            sArr6[i2] = this.f24001cf.multiplyMatrix(sArr, sArr6[i2]);
            short[][][] sArr7 = this.f24007l1_Q5;
            sArr7[i2] = this.f24001cf.m18114to_UT(sArr7[i2]);
            ComputeInField computeInField = this.f24001cf;
            short[][] sArrMultiplyMatrix2 = computeInField.multiplyMatrix(computeInField.transpose(this.f24003l1_F2[i2]), this.f24028t2);
            this.f24008l1_Q6[i2] = this.f24001cf.multiplyMatrix(sArr, this.f24006l1_Q3[i2]);
            short[][][] sArr8 = this.f24008l1_Q6;
            sArr8[i2] = this.f24001cf.addMatrix(sArr8[i2], sArrMultiplyMatrix2);
            this.f24009l1_Q9[i2] = this.f24001cf.addMatrix(this.f24001cf.multiplyMatrix(this.f24002l1_F1[i2], this.f24028t2), sArrMultiplyMatrix);
            short[][][] sArr9 = this.f24009l1_Q9;
            sArr9[i2] = this.f24001cf.multiplyMatrix(sArr2, sArr9[i2]);
            short[][][] sArr10 = this.f24009l1_Q9;
            sArr10[i2] = this.f24001cf.m18114to_UT(sArr10[i2]);
        }
    }

    private void calculate_l2_Q9(short[][] sArr) {
        this.f24020l2_Q9 = new short[this.f24022o2][][];
        for (int i = 0; i < this.f24022o2; i++) {
            this.f24020l2_Q9[i] = this.f24001cf.multiplyMatrix(this.f24010l2_F1[i], this.f24028t2);
            short[][] sArrMultiplyMatrix = this.f24001cf.multiplyMatrix(this.f24011l2_F2[i], this.f24029t3);
            short[][][] sArr2 = this.f24020l2_Q9;
            sArr2[i] = this.f24001cf.addMatrix(sArr2[i], sArrMultiplyMatrix);
            short[][][] sArr3 = this.f24020l2_Q9;
            sArr3[i] = this.f24001cf.addMatrix(sArr3[i], this.f24012l2_F3[i]);
            short[][][] sArr4 = this.f24020l2_Q9;
            sArr4[i] = this.f24001cf.multiplyMatrix(sArr, sArr4[i]);
            short[][] sArrAddMatrix = this.f24001cf.addMatrix(this.f24001cf.multiplyMatrix(this.f24013l2_F5[i], this.f24029t3), this.f24014l2_F6[i]);
            ComputeInField computeInField = this.f24001cf;
            short[][] sArrMultiplyMatrix2 = computeInField.multiplyMatrix(computeInField.transpose(this.f24029t3), sArrAddMatrix);
            short[][][] sArr5 = this.f24020l2_Q9;
            sArr5[i] = this.f24001cf.addMatrix(sArr5[i], sArrMultiplyMatrix2);
            short[][][] sArr6 = this.f24020l2_Q9;
            sArr6[i] = this.f24001cf.m18114to_UT(sArr6[i]);
        }
    }

    private void calculate_t4() {
        this.f24030t4 = this.f24001cf.addMatrix(this.f24001cf.multiplyMatrix(this.f24027t1, this.f24029t3), this.f24028t2);
    }

    private void genKeyMaterial() {
        byte[] bArr = new byte[this.rainbowParams.getLen_skseed()];
        this.f24026sk_seed = bArr;
        this.f24024random.nextBytes(bArr);
        RainbowDRBG rainbowDRBG = new RainbowDRBG(this.f24026sk_seed, this.rainbowParams.getHash_algo());
        generate_S_and_T(rainbowDRBG);
        int i = this.f24021o1;
        int i2 = this.f24031v1;
        this.f24002l1_F1 = RainbowUtil.generate_random(rainbowDRBG, i, i2, i2, true);
        int i3 = this.f24021o1;
        this.f24003l1_F2 = RainbowUtil.generate_random(rainbowDRBG, i3, this.f24031v1, i3, false);
        int i4 = this.f24022o2;
        int i5 = this.f24031v1;
        this.f24010l2_F1 = RainbowUtil.generate_random(rainbowDRBG, i4, i5, i5, true);
        this.f24011l2_F2 = RainbowUtil.generate_random(rainbowDRBG, this.f24022o2, this.f24031v1, this.f24021o1, false);
        int i6 = this.f24022o2;
        this.f24012l2_F3 = RainbowUtil.generate_random(rainbowDRBG, i6, this.f24031v1, i6, false);
        int i7 = this.f24022o2;
        int i8 = this.f24021o1;
        this.f24013l2_F5 = RainbowUtil.generate_random(rainbowDRBG, i7, i8, i8, true);
        int i9 = this.f24022o2;
        this.f24014l2_F6 = RainbowUtil.generate_random(rainbowDRBG, i9, this.f24021o1, i9, false);
        calculate_Q_from_F();
        calculate_t4();
        this.f24004l1_Q1 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24015l2_Q1, this.f24004l1_Q1);
        this.f24005l1_Q2 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24016l2_Q2, this.f24005l1_Q2);
        this.f24006l1_Q3 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24017l2_Q3, this.f24006l1_Q3);
        this.f24007l1_Q5 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24018l2_Q5, this.f24007l1_Q5);
        this.f24008l1_Q6 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24019l2_Q6, this.f24008l1_Q6);
        this.f24009l1_Q9 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24020l2_Q9, this.f24009l1_Q9);
    }

    private void genKeyMaterial_cyclic() {
        byte[] bArr = new byte[this.rainbowParams.getLen_skseed()];
        this.f24026sk_seed = bArr;
        this.f24024random.nextBytes(bArr);
        byte[] bArr2 = new byte[this.rainbowParams.getLen_pkseed()];
        this.f24023pk_seed = bArr2;
        this.f24024random.nextBytes(bArr2);
        genPrivateKeyMaterial_cyclic();
        calculate_Q_from_F_cyclic();
        this.f24006l1_Q3 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24017l2_Q3, this.f24006l1_Q3);
        this.f24007l1_Q5 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24018l2_Q5, this.f24007l1_Q5);
        this.f24008l1_Q6 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24019l2_Q6, this.f24008l1_Q6);
        this.f24009l1_Q9 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24020l2_Q9, this.f24009l1_Q9);
    }

    private void genPrivateKeyMaterial_cyclic() {
        RainbowDRBG rainbowDRBG = new RainbowDRBG(this.f24026sk_seed, this.rainbowParams.getHash_algo());
        RainbowDRBG rainbowDRBG2 = new RainbowDRBG(this.f24023pk_seed, this.rainbowParams.getHash_algo());
        generate_S_and_T(rainbowDRBG);
        calculate_t4();
        generate_B1_and_B2(rainbowDRBG2);
        this.f24004l1_Q1 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24015l2_Q1, this.f24004l1_Q1);
        this.f24005l1_Q2 = this.f24001cf.obfuscate_l1_polys(this.f24025s1, this.f24016l2_Q2, this.f24005l1_Q2);
        calculate_F_from_Q();
    }

    private void generate_B1_and_B2(SecureRandom secureRandom) {
        int i = this.f24021o1;
        int i2 = this.f24031v1;
        this.f24004l1_Q1 = RainbowUtil.generate_random(secureRandom, i, i2, i2, true);
        int i3 = this.f24021o1;
        this.f24005l1_Q2 = RainbowUtil.generate_random(secureRandom, i3, this.f24031v1, i3, false);
        int i4 = this.f24022o2;
        int i5 = this.f24031v1;
        this.f24015l2_Q1 = RainbowUtil.generate_random(secureRandom, i4, i5, i5, true);
        this.f24016l2_Q2 = RainbowUtil.generate_random(secureRandom, this.f24022o2, this.f24031v1, this.f24021o1, false);
        int i6 = this.f24022o2;
        this.f24017l2_Q3 = RainbowUtil.generate_random(secureRandom, i6, this.f24031v1, i6, false);
        int i7 = this.f24022o2;
        int i8 = this.f24021o1;
        this.f24018l2_Q5 = RainbowUtil.generate_random(secureRandom, i7, i8, i8, true);
        int i9 = this.f24022o2;
        this.f24019l2_Q6 = RainbowUtil.generate_random(secureRandom, i9, this.f24021o1, i9, false);
    }

    private void generate_S_and_T(SecureRandom secureRandom) {
        this.f24025s1 = RainbowUtil.generate_random_2d(secureRandom, this.f24021o1, this.f24022o2);
        this.f24027t1 = RainbowUtil.generate_random_2d(secureRandom, this.f24031v1, this.f24021o1);
        this.f24028t2 = RainbowUtil.generate_random_2d(secureRandom, this.f24031v1, this.f24022o2);
        this.f24029t3 = RainbowUtil.generate_random_2d(secureRandom, this.f24021o1, this.f24022o2);
    }

    public AsymmetricCipherKeyPair genKeyPairCircumzenithal() {
        genKeyMaterial_cyclic();
        RainbowPublicKeyParameters rainbowPublicKeyParameters = new RainbowPublicKeyParameters(this.rainbowParams, this.f24023pk_seed, this.f24006l1_Q3, this.f24007l1_Q5, this.f24008l1_Q6, this.f24009l1_Q9, this.f24020l2_Q9);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) rainbowPublicKeyParameters, (AsymmetricKeyParameter) new RainbowPrivateKeyParameters(this.rainbowParams, this.f24026sk_seed, this.f24025s1, this.f24027t1, this.f24029t3, this.f24030t4, this.f24002l1_F1, this.f24003l1_F2, this.f24010l2_F1, this.f24011l2_F2, this.f24012l2_F3, this.f24013l2_F5, this.f24014l2_F6, rainbowPublicKeyParameters.getEncoded()));
    }

    public AsymmetricCipherKeyPair genKeyPairClassical() {
        genKeyMaterial();
        RainbowPublicKeyParameters rainbowPublicKeyParameters = new RainbowPublicKeyParameters(this.rainbowParams, this.f24004l1_Q1, this.f24005l1_Q2, this.f24006l1_Q3, this.f24007l1_Q5, this.f24008l1_Q6, this.f24009l1_Q9, this.f24015l2_Q1, this.f24016l2_Q2, this.f24017l2_Q3, this.f24018l2_Q5, this.f24019l2_Q6, this.f24020l2_Q9);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) rainbowPublicKeyParameters, (AsymmetricKeyParameter) new RainbowPrivateKeyParameters(this.rainbowParams, this.f24026sk_seed, this.f24025s1, this.f24027t1, this.f24029t3, this.f24030t4, this.f24002l1_F1, this.f24003l1_F2, this.f24010l2_F1, this.f24011l2_F2, this.f24012l2_F3, this.f24013l2_F5, this.f24014l2_F6, rainbowPublicKeyParameters.getEncoded()));
    }

    public AsymmetricCipherKeyPair genKeyPairCompressed() {
        genKeyMaterial_cyclic();
        RainbowPublicKeyParameters rainbowPublicKeyParameters = new RainbowPublicKeyParameters(this.rainbowParams, this.f24023pk_seed, this.f24006l1_Q3, this.f24007l1_Q5, this.f24008l1_Q6, this.f24009l1_Q9, this.f24020l2_Q9);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) rainbowPublicKeyParameters, (AsymmetricKeyParameter) new RainbowPrivateKeyParameters(this.rainbowParams, this.f24023pk_seed, this.f24026sk_seed, rainbowPublicKeyParameters.getEncoded()));
    }

    public RainbowPrivateKeyParameters generatePrivateKey() {
        this.f24026sk_seed = C6238Arrays.m18231clone(this.f24026sk_seed);
        this.f24023pk_seed = C6238Arrays.m18231clone(this.f24023pk_seed);
        genPrivateKeyMaterial_cyclic();
        return new RainbowPrivateKeyParameters(this.rainbowParams, this.f24026sk_seed, this.f24025s1, this.f24027t1, this.f24029t3, this.f24030t4, this.f24002l1_F1, this.f24003l1_F2, this.f24010l2_F1, this.f24011l2_F2, this.f24012l2_F3, this.f24013l2_F5, this.f24014l2_F6, null);
    }

    public RainbowKeyComputation(RainbowParameters rainbowParameters, byte[] bArr, byte[] bArr2) {
        this.f24001cf = new ComputeInField();
        this.rainbowParams = rainbowParameters;
        this.f24024random = null;
        this.f24032version = rainbowParameters.getVersion();
        this.f24023pk_seed = bArr;
        this.f24026sk_seed = bArr2;
        this.f24031v1 = this.rainbowParams.m18129getV1();
        this.f24021o1 = this.rainbowParams.m18127getO1();
        this.f24022o2 = this.rainbowParams.m18128getO2();
    }
}
