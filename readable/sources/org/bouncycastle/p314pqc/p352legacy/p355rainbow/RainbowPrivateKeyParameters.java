package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import java.lang.reflect.Array;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class RainbowPrivateKeyParameters extends RainbowKeyParameters {

    /* renamed from: l1_F1 */
    final short[][][] f24045l1_F1;

    /* renamed from: l1_F2 */
    final short[][][] f24046l1_F2;

    /* renamed from: l2_F1 */
    final short[][][] f24047l2_F1;

    /* renamed from: l2_F2 */
    final short[][][] f24048l2_F2;

    /* renamed from: l2_F3 */
    final short[][][] f24049l2_F3;

    /* renamed from: l2_F5 */
    final short[][][] f24050l2_F5;

    /* renamed from: l2_F6 */
    final short[][][] f24051l2_F6;
    private byte[] pk_encoded;

    /* renamed from: pk_seed */
    private final byte[] f24052pk_seed;

    /* renamed from: s1 */
    final short[][] f24053s1;

    /* renamed from: sk_seed */
    final byte[] f24054sk_seed;

    /* renamed from: t1 */
    final short[][] f24055t1;

    /* renamed from: t3 */
    final short[][] f24056t3;

    /* renamed from: t4 */
    final short[][] f24057t4;

    public RainbowPrivateKeyParameters(RainbowParameters rainbowParameters, byte[] bArr) {
        super(true, rainbowParameters);
        if (rainbowParameters.getVersion() == EnumC6223Version.COMPRESSED) {
            byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, rainbowParameters.getLen_pkseed());
            this.f24052pk_seed = bArrCopyOfRange;
            byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr, rainbowParameters.getLen_pkseed(), rainbowParameters.getLen_pkseed() + rainbowParameters.getLen_skseed());
            this.f24054sk_seed = bArrCopyOfRange2;
            RainbowPrivateKeyParameters rainbowPrivateKeyParametersGeneratePrivateKey = new RainbowKeyComputation(rainbowParameters, bArrCopyOfRange, bArrCopyOfRange2).generatePrivateKey();
            this.pk_encoded = rainbowPrivateKeyParametersGeneratePrivateKey.pk_encoded;
            this.f24053s1 = rainbowPrivateKeyParametersGeneratePrivateKey.f24053s1;
            this.f24055t1 = rainbowPrivateKeyParametersGeneratePrivateKey.f24055t1;
            this.f24056t3 = rainbowPrivateKeyParametersGeneratePrivateKey.f24056t3;
            this.f24057t4 = rainbowPrivateKeyParametersGeneratePrivateKey.f24057t4;
            this.f24045l1_F1 = rainbowPrivateKeyParametersGeneratePrivateKey.f24045l1_F1;
            this.f24046l1_F2 = rainbowPrivateKeyParametersGeneratePrivateKey.f24046l1_F2;
            this.f24047l2_F1 = rainbowPrivateKeyParametersGeneratePrivateKey.f24047l2_F1;
            this.f24048l2_F2 = rainbowPrivateKeyParametersGeneratePrivateKey.f24048l2_F2;
            this.f24049l2_F3 = rainbowPrivateKeyParametersGeneratePrivateKey.f24049l2_F3;
            this.f24050l2_F5 = rainbowPrivateKeyParametersGeneratePrivateKey.f24050l2_F5;
            this.f24051l2_F6 = rainbowPrivateKeyParametersGeneratePrivateKey.f24051l2_F6;
            return;
        }
        int iM18129getV1 = rainbowParameters.m18129getV1();
        int iM18127getO1 = rainbowParameters.m18127getO1();
        int iM18128getO2 = rainbowParameters.m18128getO2();
        Class cls = Short.TYPE;
        short[][] sArr = (short[][]) Array.newInstance((Class<?>) cls, iM18127getO1, iM18128getO2);
        this.f24053s1 = sArr;
        short[][] sArr2 = (short[][]) Array.newInstance((Class<?>) cls, iM18129getV1, iM18127getO1);
        this.f24055t1 = sArr2;
        short[][] sArr3 = (short[][]) Array.newInstance((Class<?>) cls, iM18129getV1, iM18128getO2);
        this.f24057t4 = sArr3;
        short[][] sArr4 = (short[][]) Array.newInstance((Class<?>) cls, iM18127getO1, iM18128getO2);
        this.f24056t3 = sArr4;
        short[][][] sArr5 = (short[][][]) Array.newInstance((Class<?>) cls, iM18127getO1, iM18129getV1, iM18129getV1);
        this.f24045l1_F1 = sArr5;
        short[][][] sArr6 = (short[][][]) Array.newInstance((Class<?>) cls, iM18127getO1, iM18129getV1, iM18127getO1);
        this.f24046l1_F2 = sArr6;
        short[][][] sArr7 = (short[][][]) Array.newInstance((Class<?>) cls, iM18128getO2, iM18129getV1, iM18129getV1);
        this.f24047l2_F1 = sArr7;
        short[][][] sArr8 = (short[][][]) Array.newInstance((Class<?>) cls, iM18128getO2, iM18129getV1, iM18127getO1);
        this.f24048l2_F2 = sArr8;
        short[][][] sArr9 = (short[][][]) Array.newInstance((Class<?>) cls, iM18128getO2, iM18129getV1, iM18128getO2);
        this.f24049l2_F3 = sArr9;
        short[][][] sArr10 = (short[][][]) Array.newInstance((Class<?>) cls, iM18128getO2, iM18127getO1, iM18127getO1);
        this.f24050l2_F5 = sArr10;
        short[][][] sArr11 = (short[][][]) Array.newInstance((Class<?>) cls, iM18128getO2, iM18127getO1, iM18128getO2);
        this.f24051l2_F6 = sArr11;
        this.f24052pk_seed = null;
        byte[] bArrCopyOfRange3 = C6238Arrays.copyOfRange(bArr, 0, rainbowParameters.getLen_skseed());
        this.f24054sk_seed = bArrCopyOfRange3;
        int length = bArrCopyOfRange3.length;
        int iLoadEncoded = length + RainbowUtil.loadEncoded(sArr, bArr, length);
        int iLoadEncoded2 = iLoadEncoded + RainbowUtil.loadEncoded(sArr2, bArr, iLoadEncoded);
        int iLoadEncoded3 = iLoadEncoded2 + RainbowUtil.loadEncoded(sArr3, bArr, iLoadEncoded2);
        int iLoadEncoded4 = iLoadEncoded3 + RainbowUtil.loadEncoded(sArr4, bArr, iLoadEncoded3);
        int iLoadEncoded5 = iLoadEncoded4 + RainbowUtil.loadEncoded(sArr5, bArr, iLoadEncoded4, true);
        int iLoadEncoded6 = iLoadEncoded5 + RainbowUtil.loadEncoded(sArr6, bArr, iLoadEncoded5, false);
        int iLoadEncoded7 = iLoadEncoded6 + RainbowUtil.loadEncoded(sArr7, bArr, iLoadEncoded6, true);
        int iLoadEncoded8 = iLoadEncoded7 + RainbowUtil.loadEncoded(sArr8, bArr, iLoadEncoded7, false);
        int iLoadEncoded9 = iLoadEncoded8 + RainbowUtil.loadEncoded(sArr9, bArr, iLoadEncoded8, false);
        int iLoadEncoded10 = iLoadEncoded9 + RainbowUtil.loadEncoded(sArr10, bArr, iLoadEncoded9, true);
        this.pk_encoded = C6238Arrays.copyOfRange(bArr, iLoadEncoded10 + RainbowUtil.loadEncoded(sArr11, bArr, iLoadEncoded10, false), bArr.length);
    }

    public byte[] getEncoded() {
        return getParameters().getVersion() == EnumC6223Version.COMPRESSED ? C6238Arrays.concatenate(this.f24052pk_seed, this.f24054sk_seed) : C6238Arrays.concatenate(getPrivateKey(), this.pk_encoded);
    }

    public short[][][] getL1_F1() {
        return RainbowUtil.cloneArray(this.f24045l1_F1);
    }

    public short[][][] getL1_F2() {
        return RainbowUtil.cloneArray(this.f24046l1_F2);
    }

    public short[][][] getL2_F1() {
        return RainbowUtil.cloneArray(this.f24047l2_F1);
    }

    public short[][][] getL2_F2() {
        return RainbowUtil.cloneArray(this.f24048l2_F2);
    }

    public short[][][] getL2_F3() {
        return RainbowUtil.cloneArray(this.f24049l2_F3);
    }

    public short[][][] getL2_F5() {
        return RainbowUtil.cloneArray(this.f24050l2_F5);
    }

    public short[][][] getL2_F6() {
        return RainbowUtil.cloneArray(this.f24051l2_F6);
    }

    public byte[] getPrivateKey() {
        return getParameters().getVersion() == EnumC6223Version.COMPRESSED ? C6238Arrays.concatenate(this.f24052pk_seed, this.f24054sk_seed) : C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(C6238Arrays.concatenate(this.f24054sk_seed, RainbowUtil.getEncoded(this.f24053s1)), RainbowUtil.getEncoded(this.f24055t1)), RainbowUtil.getEncoded(this.f24057t4)), RainbowUtil.getEncoded(this.f24056t3)), RainbowUtil.getEncoded(this.f24045l1_F1, true)), RainbowUtil.getEncoded(this.f24046l1_F2, false)), RainbowUtil.getEncoded(this.f24047l2_F1, true)), RainbowUtil.getEncoded(this.f24048l2_F2, false)), RainbowUtil.getEncoded(this.f24049l2_F3, false)), RainbowUtil.getEncoded(this.f24050l2_F5, true)), RainbowUtil.getEncoded(this.f24051l2_F6, false));
    }

    public byte[] getPublicKey() {
        return this.pk_encoded;
    }

    /* renamed from: getS1 */
    public short[][] m18131getS1() {
        return RainbowUtil.cloneArray(this.f24053s1);
    }

    public byte[] getSk_seed() {
        return C6238Arrays.m18231clone(this.f24054sk_seed);
    }

    /* renamed from: getT1 */
    public short[][] m18132getT1() {
        return RainbowUtil.cloneArray(this.f24055t1);
    }

    /* renamed from: getT3 */
    public short[][] m18133getT3() {
        return RainbowUtil.cloneArray(this.f24056t3);
    }

    /* renamed from: getT4 */
    public short[][] m18134getT4() {
        return RainbowUtil.cloneArray(this.f24057t4);
    }

    public RainbowPrivateKeyParameters(RainbowParameters rainbowParameters, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        super(true, rainbowParameters);
        RainbowPrivateKeyParameters rainbowPrivateKeyParametersGeneratePrivateKey = new RainbowKeyComputation(rainbowParameters, bArr, bArr2).generatePrivateKey();
        this.f24052pk_seed = bArr;
        this.pk_encoded = bArr3;
        this.f24054sk_seed = bArr2;
        this.f24053s1 = rainbowPrivateKeyParametersGeneratePrivateKey.f24053s1;
        this.f24055t1 = rainbowPrivateKeyParametersGeneratePrivateKey.f24055t1;
        this.f24056t3 = rainbowPrivateKeyParametersGeneratePrivateKey.f24056t3;
        this.f24057t4 = rainbowPrivateKeyParametersGeneratePrivateKey.f24057t4;
        this.f24045l1_F1 = rainbowPrivateKeyParametersGeneratePrivateKey.f24045l1_F1;
        this.f24046l1_F2 = rainbowPrivateKeyParametersGeneratePrivateKey.f24046l1_F2;
        this.f24047l2_F1 = rainbowPrivateKeyParametersGeneratePrivateKey.f24047l2_F1;
        this.f24048l2_F2 = rainbowPrivateKeyParametersGeneratePrivateKey.f24048l2_F2;
        this.f24049l2_F3 = rainbowPrivateKeyParametersGeneratePrivateKey.f24049l2_F3;
        this.f24050l2_F5 = rainbowPrivateKeyParametersGeneratePrivateKey.f24050l2_F5;
        this.f24051l2_F6 = rainbowPrivateKeyParametersGeneratePrivateKey.f24051l2_F6;
    }

    public RainbowPrivateKeyParameters(RainbowParameters rainbowParameters, byte[] bArr, short[][] sArr, short[][] sArr2, short[][] sArr3, short[][] sArr4, short[][][] sArr5, short[][][] sArr6, short[][][] sArr7, short[][][] sArr8, short[][][] sArr9, short[][][] sArr10, short[][][] sArr11, byte[] bArr2) {
        super(true, rainbowParameters);
        this.f24052pk_seed = null;
        this.pk_encoded = bArr2;
        this.f24054sk_seed = (byte[]) bArr.clone();
        this.f24053s1 = RainbowUtil.cloneArray(sArr);
        this.f24055t1 = RainbowUtil.cloneArray(sArr2);
        this.f24056t3 = RainbowUtil.cloneArray(sArr3);
        this.f24057t4 = RainbowUtil.cloneArray(sArr4);
        this.f24045l1_F1 = RainbowUtil.cloneArray(sArr5);
        this.f24046l1_F2 = RainbowUtil.cloneArray(sArr6);
        this.f24047l2_F1 = RainbowUtil.cloneArray(sArr7);
        this.f24048l2_F2 = RainbowUtil.cloneArray(sArr8);
        this.f24049l2_F3 = RainbowUtil.cloneArray(sArr9);
        this.f24050l2_F5 = RainbowUtil.cloneArray(sArr10);
        this.f24051l2_F6 = RainbowUtil.cloneArray(sArr11);
    }
}
