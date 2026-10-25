package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import java.lang.reflect.Array;
import org.bouncycastle.p361util.C6238Arrays;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class RainbowPublicKeyParameters extends RainbowKeyParameters {

    /* renamed from: l1_Q3 */
    short[][][] f24058l1_Q3;

    /* renamed from: l1_Q5 */
    short[][][] f24059l1_Q5;

    /* renamed from: l1_Q6 */
    short[][][] f24060l1_Q6;

    /* renamed from: l1_Q9 */
    short[][][] f24061l1_Q9;

    /* renamed from: l2_Q9 */
    short[][][] f24062l2_Q9;

    /* renamed from: pk */
    short[][][] f24063pk;

    /* renamed from: pk_seed */
    byte[] f24064pk_seed;

    public RainbowPublicKeyParameters(RainbowParameters rainbowParameters, byte[] bArr) {
        super(false, rainbowParameters);
        int iM18124getM = rainbowParameters.m18124getM();
        int iM18125getN = rainbowParameters.m18125getN();
        if (getParameters().getVersion() != EnumC6223Version.CLASSIC) {
            this.f24064pk_seed = C6238Arrays.copyOfRange(bArr, 0, rainbowParameters.getLen_pkseed());
            int[] iArr = {rainbowParameters.m18127getO1(), rainbowParameters.m18129getV1(), rainbowParameters.m18128getO2()};
            Class cls = Short.TYPE;
            this.f24058l1_Q3 = (short[][][]) Array.newInstance((Class<?>) cls, iArr);
            this.f24059l1_Q5 = (short[][][]) Array.newInstance((Class<?>) cls, rainbowParameters.m18127getO1(), rainbowParameters.m18127getO1(), rainbowParameters.m18127getO1());
            this.f24060l1_Q6 = (short[][][]) Array.newInstance((Class<?>) cls, rainbowParameters.m18127getO1(), rainbowParameters.m18127getO1(), rainbowParameters.m18128getO2());
            this.f24061l1_Q9 = (short[][][]) Array.newInstance((Class<?>) cls, rainbowParameters.m18127getO1(), rainbowParameters.m18128getO2(), rainbowParameters.m18128getO2());
            this.f24062l2_Q9 = (short[][][]) Array.newInstance((Class<?>) cls, rainbowParameters.m18128getO2(), rainbowParameters.m18128getO2(), rainbowParameters.m18128getO2());
            int len_pkseed = rainbowParameters.getLen_pkseed();
            int iLoadEncoded = len_pkseed + RainbowUtil.loadEncoded(this.f24058l1_Q3, bArr, len_pkseed, false);
            int iLoadEncoded2 = iLoadEncoded + RainbowUtil.loadEncoded(this.f24059l1_Q5, bArr, iLoadEncoded, true);
            int iLoadEncoded3 = iLoadEncoded2 + RainbowUtil.loadEncoded(this.f24060l1_Q6, bArr, iLoadEncoded2, false);
            int iLoadEncoded4 = iLoadEncoded3 + RainbowUtil.loadEncoded(this.f24061l1_Q9, bArr, iLoadEncoded3, true);
            if (iLoadEncoded4 + RainbowUtil.loadEncoded(this.f24062l2_Q9, bArr, iLoadEncoded4, true) != bArr.length) {
                throw new IllegalArgumentException("unparsed data in key encoding");
            }
            return;
        }
        this.f24063pk = (short[][][]) Array.newInstance((Class<?>) Short.TYPE, iM18124getM, iM18125getN, iM18125getN);
        int i = 0;
        for (int i2 = 0; i2 < iM18125getN; i2++) {
            for (int i3 = 0; i3 < iM18125getN; i3++) {
                for (int i4 = 0; i4 < iM18124getM; i4++) {
                    short[][][] sArr = this.f24063pk;
                    if (i2 > i3) {
                        sArr[i4][i2][i3] = 0;
                    } else {
                        sArr[i4][i2][i3] = (short) (bArr[i] & C1126UByte.MAX_VALUE);
                        i++;
                    }
                }
            }
        }
    }

    public byte[] getEncoded() {
        return getParameters().getVersion() != EnumC6223Version.CLASSIC ? C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(this.f24064pk_seed, RainbowUtil.getEncoded(this.f24058l1_Q3, false)), RainbowUtil.getEncoded(this.f24059l1_Q5, true)), RainbowUtil.getEncoded(this.f24060l1_Q6, false)), RainbowUtil.getEncoded(this.f24061l1_Q9, true)), RainbowUtil.getEncoded(this.f24062l2_Q9, true)) : RainbowUtil.getEncoded(this.f24063pk, true);
    }

    /* renamed from: getPk */
    public short[][][] m18135getPk() {
        return RainbowUtil.cloneArray(this.f24063pk);
    }

    public RainbowPublicKeyParameters(RainbowParameters rainbowParameters, byte[] bArr, short[][][] sArr, short[][][] sArr2, short[][][] sArr3, short[][][] sArr4, short[][][] sArr5) {
        super(false, rainbowParameters);
        this.f24064pk_seed = (byte[]) bArr.clone();
        this.f24058l1_Q3 = RainbowUtil.cloneArray(sArr);
        this.f24059l1_Q5 = RainbowUtil.cloneArray(sArr2);
        this.f24060l1_Q6 = RainbowUtil.cloneArray(sArr3);
        this.f24061l1_Q9 = RainbowUtil.cloneArray(sArr4);
        this.f24062l2_Q9 = RainbowUtil.cloneArray(sArr5);
    }

    public RainbowPublicKeyParameters(RainbowParameters rainbowParameters, short[][][] sArr, short[][][] sArr2, short[][][] sArr3, short[][][] sArr4, short[][][] sArr5, short[][][] sArr6, short[][][] sArr7, short[][][] sArr8, short[][][] sArr9, short[][][] sArr10, short[][][] sArr11, short[][][] sArr12) {
        super(false, rainbowParameters);
        int iM18129getV1 = rainbowParameters.m18129getV1();
        int iM18127getO1 = rainbowParameters.m18127getO1();
        int iM18128getO2 = rainbowParameters.m18128getO2();
        this.f24063pk = (short[][][]) Array.newInstance((Class<?>) Short.TYPE, rainbowParameters.m18124getM(), rainbowParameters.m18125getN(), rainbowParameters.m18125getN());
        for (int i = 0; i < iM18127getO1; i++) {
            for (int i2 = 0; i2 < iM18129getV1; i2++) {
                System.arraycopy(sArr[i][i2], 0, this.f24063pk[i][i2], 0, iM18129getV1);
                System.arraycopy(sArr2[i][i2], 0, this.f24063pk[i][i2], iM18129getV1, iM18127getO1);
                System.arraycopy(sArr3[i][i2], 0, this.f24063pk[i][i2], iM18129getV1 + iM18127getO1, iM18128getO2);
            }
            for (int i3 = 0; i3 < iM18127getO1; i3++) {
                int i4 = i3 + iM18129getV1;
                System.arraycopy(sArr4[i][i3], 0, this.f24063pk[i][i4], iM18129getV1, iM18127getO1);
                System.arraycopy(sArr5[i][i3], 0, this.f24063pk[i][i4], iM18129getV1 + iM18127getO1, iM18128getO2);
            }
            for (int i5 = 0; i5 < iM18128getO2; i5++) {
                System.arraycopy(sArr6[i][i5], 0, this.f24063pk[i][i5 + iM18129getV1 + iM18127getO1], iM18129getV1 + iM18127getO1, iM18128getO2);
            }
        }
        for (int i6 = 0; i6 < iM18128getO2; i6++) {
            for (int i7 = 0; i7 < iM18129getV1; i7++) {
                int i8 = i6 + iM18127getO1;
                System.arraycopy(sArr7[i6][i7], 0, this.f24063pk[i8][i7], 0, iM18129getV1);
                System.arraycopy(sArr8[i6][i7], 0, this.f24063pk[i8][i7], iM18129getV1, iM18127getO1);
                System.arraycopy(sArr9[i6][i7], 0, this.f24063pk[i8][i7], iM18129getV1 + iM18127getO1, iM18128getO2);
            }
            for (int i9 = 0; i9 < iM18127getO1; i9++) {
                int i10 = i6 + iM18127getO1;
                int i11 = i9 + iM18129getV1;
                System.arraycopy(sArr10[i6][i9], 0, this.f24063pk[i10][i11], iM18129getV1, iM18127getO1);
                System.arraycopy(sArr11[i6][i9], 0, this.f24063pk[i10][i11], iM18129getV1 + iM18127getO1, iM18128getO2);
            }
            for (int i12 = 0; i12 < iM18128getO2; i12++) {
                System.arraycopy(sArr12[i6][i12], 0, this.f24063pk[i6 + iM18127getO1][i12 + iM18129getV1 + iM18127getO1], iM18129getV1 + iM18127getO1, iM18128getO2);
            }
        }
    }
}
