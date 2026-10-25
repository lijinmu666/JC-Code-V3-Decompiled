package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SNTRUPrimeKEMExtractor implements EncapsulatedSecretExtractor {
    private final SNTRUPrimePrivateKeyParameters privateKey;

    public SNTRUPrimeKEMExtractor(SNTRUPrimePrivateKeyParameters sNTRUPrimePrivateKeyParameters) {
        if (sNTRUPrimePrivateKeyParameters == null) {
            throw new NullPointerException("'privateKey' cannot be null");
        }
        this.privateKey = sNTRUPrimePrivateKeyParameters;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        SNTRUPrimeParameters parameters = this.privateKey.getParameters();
        int iM17790getP = parameters.m17790getP();
        int iM17791getQ = parameters.m17791getQ();
        int iM17792getW = parameters.m17792getW();
        int roundedPolynomialBytes = parameters.getRoundedPolynomialBytes();
        byte[] bArr2 = new byte[iM17790getP];
        C6090Utils.getDecodedSmallPolynomial(bArr2, this.privateKey.m17793getF(), iM17790getP);
        byte[] bArr3 = new byte[iM17790getP];
        C6090Utils.getDecodedSmallPolynomial(bArr3, this.privateKey.m17794getGinv(), iM17790getP);
        short[] sArr = new short[iM17790getP];
        C6090Utils.getRoundedDecodedPolynomial(sArr, bArr, iM17790getP, iM17791getQ);
        short[] sArr2 = new short[iM17790getP];
        C6090Utils.multiplicationInRQ(sArr2, sArr, bArr2, iM17790getP, iM17791getQ);
        short[] sArr3 = new short[iM17790getP];
        C6090Utils.scalarMultiplicationInRQ(sArr3, sArr2, 3, iM17791getQ);
        byte[] bArr4 = new byte[iM17790getP];
        C6090Utils.transformRQToR3(bArr4, sArr3);
        byte[] bArr5 = new byte[iM17790getP];
        C6090Utils.multiplicationInR3(bArr5, bArr4, bArr3, iM17790getP);
        byte[] bArr6 = new byte[iM17790getP];
        C6090Utils.checkForSmallPolynomial(bArr6, bArr5, iM17790getP, iM17792getW);
        byte[] bArr7 = new byte[(iM17790getP + 3) / 4];
        C6090Utils.getEncodedSmallPolynomial(bArr7, bArr6, iM17790getP);
        short[] sArr4 = new short[iM17790getP];
        C6090Utils.getDecodedPolynomial(sArr4, this.privateKey.m17796getPk(), iM17790getP, iM17791getQ);
        short[] sArr5 = new short[iM17790getP];
        C6090Utils.multiplicationInRQ(sArr5, sArr4, bArr6, iM17790getP, iM17791getQ);
        short[] sArr6 = new short[iM17790getP];
        C6090Utils.roundPolynomial(sArr6, sArr5);
        byte[] bArr8 = new byte[roundedPolynomialBytes];
        C6090Utils.getRoundedEncodedPolynomial(bArr8, sArr6, iM17790getP, iM17791getQ);
        byte[] hashWithPrefix = C6090Utils.getHashWithPrefix(new byte[]{3}, bArr7);
        byte[] bArr9 = new byte[(hashWithPrefix.length / 2) + this.privateKey.m17795getHash().length];
        System.arraycopy(hashWithPrefix, 0, bArr9, 0, hashWithPrefix.length / 2);
        System.arraycopy(this.privateKey.m17795getHash(), 0, bArr9, hashWithPrefix.length / 2, this.privateKey.m17795getHash().length);
        byte[] hashWithPrefix2 = C6090Utils.getHashWithPrefix(new byte[]{2}, bArr9);
        int length = (hashWithPrefix2.length / 2) + roundedPolynomialBytes;
        byte[] bArr10 = new byte[length];
        System.arraycopy(bArr8, 0, bArr10, 0, roundedPolynomialBytes);
        System.arraycopy(hashWithPrefix2, 0, bArr10, roundedPolynomialBytes, hashWithPrefix2.length / 2);
        int i = C6238Arrays.constantTimeAreEqual(bArr, bArr10) ? 0 : -1;
        C6090Utils.updateDiffMask(bArr7, this.privateKey.m17797getRho(), i);
        byte[] hashWithPrefix3 = C6090Utils.getHashWithPrefix(new byte[]{3}, bArr7);
        byte[] bArr11 = new byte[(hashWithPrefix3.length / 2) + length];
        System.arraycopy(hashWithPrefix3, 0, bArr11, 0, hashWithPrefix3.length / 2);
        System.arraycopy(bArr10, 0, bArr11, hashWithPrefix3.length / 2, length);
        return C6238Arrays.copyOfRange(C6090Utils.getHashWithPrefix(new byte[]{(byte) (i + 1)}, bArr11), 0, parameters.getSessionKeySize() / 8);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.privateKey.getParameters().getRoundedPolynomialBytes() + 32;
    }
}
