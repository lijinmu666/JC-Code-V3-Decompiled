package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import java.lang.reflect.Array;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class RainbowPublicMap {

    /* renamed from: params */
    private RainbowParameters f24066params;
    private final int num_gf_elements = 256;

    /* renamed from: cf */
    private ComputeInField f24065cf = new ComputeInField();

    public RainbowPublicMap(RainbowParameters rainbowParameters) {
        this.f24066params = rainbowParameters;
    }

    private short[] add_and_reduce(short[][] sArr) {
        int iM18124getM = this.f24066params.m18124getM();
        short[] sArrM18112addVect = new short[iM18124getM];
        for (int i = 0; i < 8; i++) {
            int iPow = (int) Math.pow(2.0d, i);
            short[] sArrM18112addVect2 = new short[iM18124getM];
            for (int i2 = iPow; i2 < 256; i2 += iPow * 2) {
                for (int i3 = 0; i3 < iPow; i3++) {
                    sArrM18112addVect2 = this.f24065cf.m18112addVect(sArrM18112addVect2, sArr[i2 + i3]);
                }
            }
            ComputeInField computeInField = this.f24065cf;
            sArrM18112addVect = computeInField.m18112addVect(sArrM18112addVect, computeInField.multVect((short) iPow, sArrM18112addVect2));
        }
        return sArrM18112addVect;
    }

    private short[][] compute_accumulator(short[] sArr, short[] sArr2, short[][][] sArr3, int i) {
        short[][] sArr4 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 256, i);
        int length = sArr2.length;
        short[][] sArr5 = sArr3[0];
        if (length != sArr5.length || sArr.length != sArr5[0].length || sArr3.length != i) {
            throw new RuntimeException("Accumulator calculation not possible!");
        }
        for (int i2 = 0; i2 < sArr2.length; i2++) {
            short[] sArrMultVect = this.f24065cf.multVect(sArr2[i2], sArr);
            for (int i3 = 0; i3 < sArr.length; i3++) {
                for (int i4 = 0; i4 < sArr3.length; i4++) {
                    short s = sArrMultVect[i3];
                    if (s != 0) {
                        short[] sArr6 = sArr4[s];
                        sArr6[i4] = GF2Field.m18115addElem(sArr6[i4], sArr3[i4][i2][i3]);
                    }
                }
            }
        }
        return sArr4;
    }

    public short[] publicMap(RainbowPublicKeyParameters rainbowPublicKeyParameters, short[] sArr) {
        return add_and_reduce(compute_accumulator(sArr, sArr, rainbowPublicKeyParameters.f24063pk, this.f24066params.m18124getM()));
    }

    public short[] publicMap_cyclic(RainbowPublicKeyParameters rainbowPublicKeyParameters, short[] sArr) {
        int iM18129getV1 = this.f24066params.m18129getV1();
        int iM18127getO1 = this.f24066params.m18127getO1();
        int iM18128getO2 = this.f24066params.m18128getO2();
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) Short.TYPE, 256, iM18127getO1 + iM18128getO2);
        short[] sArrCopyOfRange = C6238Arrays.copyOfRange(sArr, 0, iM18129getV1);
        int i = iM18129getV1 + iM18127getO1;
        short[] sArrCopyOfRange2 = C6238Arrays.copyOfRange(sArr, iM18129getV1, i);
        short[] sArrCopyOfRange3 = C6238Arrays.copyOfRange(sArr, i, sArr.length);
        RainbowDRBG rainbowDRBG = new RainbowDRBG(rainbowPublicKeyParameters.f24064pk_seed, rainbowPublicKeyParameters.getParameters().getHash_algo());
        short[][] sArrAddMatrix = this.f24065cf.addMatrix(this.f24065cf.addMatrix(this.f24065cf.addMatrix(this.f24065cf.addMatrix(this.f24065cf.addMatrix(compute_accumulator(sArrCopyOfRange, sArrCopyOfRange, RainbowUtil.generate_random(rainbowDRBG, iM18127getO1, iM18129getV1, iM18129getV1, true), iM18127getO1), compute_accumulator(sArrCopyOfRange2, sArrCopyOfRange, RainbowUtil.generate_random(rainbowDRBG, iM18127getO1, iM18129getV1, iM18127getO1, false), iM18127getO1)), compute_accumulator(sArrCopyOfRange3, sArrCopyOfRange, rainbowPublicKeyParameters.f24058l1_Q3, iM18127getO1)), compute_accumulator(sArrCopyOfRange2, sArrCopyOfRange2, rainbowPublicKeyParameters.f24059l1_Q5, iM18127getO1)), compute_accumulator(sArrCopyOfRange3, sArrCopyOfRange2, rainbowPublicKeyParameters.f24060l1_Q6, iM18127getO1)), compute_accumulator(sArrCopyOfRange3, sArrCopyOfRange3, rainbowPublicKeyParameters.f24061l1_Q9, iM18127getO1));
        short[][] sArrAddMatrix2 = this.f24065cf.addMatrix(this.f24065cf.addMatrix(this.f24065cf.addMatrix(this.f24065cf.addMatrix(this.f24065cf.addMatrix(compute_accumulator(sArrCopyOfRange, sArrCopyOfRange, RainbowUtil.generate_random(rainbowDRBG, iM18128getO2, iM18129getV1, iM18129getV1, true), iM18128getO2), compute_accumulator(sArrCopyOfRange2, sArrCopyOfRange, RainbowUtil.generate_random(rainbowDRBG, iM18128getO2, iM18129getV1, iM18127getO1, false), iM18128getO2)), compute_accumulator(sArrCopyOfRange3, sArrCopyOfRange, RainbowUtil.generate_random(rainbowDRBG, iM18128getO2, iM18129getV1, iM18128getO2, false), iM18128getO2)), compute_accumulator(sArrCopyOfRange2, sArrCopyOfRange2, RainbowUtil.generate_random(rainbowDRBG, iM18128getO2, iM18127getO1, iM18127getO1, true), iM18128getO2)), compute_accumulator(sArrCopyOfRange3, sArrCopyOfRange2, RainbowUtil.generate_random(rainbowDRBG, iM18128getO2, iM18127getO1, iM18128getO2, false), iM18128getO2)), compute_accumulator(sArrCopyOfRange3, sArrCopyOfRange3, rainbowPublicKeyParameters.f24062l2_Q9, iM18128getO2));
        for (int i2 = 0; i2 < 256; i2++) {
            sArr2[i2] = C6238Arrays.concatenate(sArrAddMatrix[i2], sArrAddMatrix2[i2]);
        }
        return add_and_reduce(sArr2);
    }
}
