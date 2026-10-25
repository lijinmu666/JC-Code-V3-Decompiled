package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRULPRimeKEMExtractor implements EncapsulatedSecretExtractor {
    private final NTRULPRimePrivateKeyParameters privateKey;

    public NTRULPRimeKEMExtractor(NTRULPRimePrivateKeyParameters nTRULPRimePrivateKeyParameters) {
        this.privateKey = nTRULPRimePrivateKeyParameters;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        NTRULPRimeParameters parameters = this.privateKey.getParameters();
        int iM17777getP = parameters.m17777getP();
        int iM17778getQ = parameters.m17778getQ();
        int iM17783getW = parameters.m17783getW();
        int roundedPolynomialBytes = parameters.getRoundedPolynomialBytes();
        int iM17779getTau0 = parameters.m17779getTau0();
        int iM17780getTau1 = parameters.m17780getTau1();
        int iM17781getTau2 = parameters.m17781getTau2();
        int iM17782getTau3 = parameters.m17782getTau3();
        byte[] bArr2 = new byte[iM17777getP];
        C6090Utils.getDecodedSmallPolynomial(bArr2, this.privateKey.getEncoded(), iM17777getP);
        byte[] bArr3 = new byte[roundedPolynomialBytes];
        System.arraycopy(bArr, 0, bArr3, 0, roundedPolynomialBytes);
        short[] sArr = new short[iM17777getP];
        C6090Utils.getRoundedDecodedPolynomial(sArr, bArr3, iM17777getP, iM17778getQ);
        byte[] bArr4 = new byte[128];
        System.arraycopy(bArr, roundedPolynomialBytes, bArr4, 0, 128);
        byte[] bArr5 = new byte[256];
        C6090Utils.getTopDecodedPolynomial(bArr5, bArr4);
        short[] sArr2 = new short[iM17777getP];
        C6090Utils.multiplicationInRQ(sArr2, sArr, bArr2, iM17777getP, iM17778getQ);
        byte[] bArr6 = new byte[256];
        C6090Utils.m17803right(bArr6, sArr2, bArr5, iM17778getQ, iM17783getW, iM17781getTau2, iM17782getTau3);
        byte[] bArr7 = new byte[32];
        C6090Utils.getEncodedInputs(bArr7, bArr6);
        int publicKeyBytes = parameters.getPublicKeyBytes() - 32;
        byte[] bArr8 = new byte[publicKeyBytes];
        System.arraycopy(this.privateKey.m17786getPk(), 32, bArr8, 0, publicKeyBytes);
        short[] sArr3 = new short[iM17777getP];
        C6090Utils.getRoundedDecodedPolynomial(sArr3, bArr8, iM17777getP, iM17778getQ);
        byte[] bArr9 = new byte[32];
        System.arraycopy(this.privateKey.m17786getPk(), 0, bArr9, 0, 32);
        short[] sArr4 = new short[iM17777getP];
        C6090Utils.generatePolynomialInRQFromSeed(sArr4, bArr9, iM17777getP, iM17778getQ);
        byte[] hashWithPrefix = C6090Utils.getHashWithPrefix(new byte[]{5}, bArr7);
        int[] iArr = new int[iM17777getP];
        C6090Utils.m17801expand(iArr, C6238Arrays.copyOfRange(hashWithPrefix, 0, hashWithPrefix.length / 2));
        byte[] bArr10 = new byte[iM17777getP];
        C6090Utils.sortGenerateShortPolynomial(bArr10, iArr, iM17777getP, iM17783getW);
        short[] sArr5 = new short[iM17777getP];
        C6090Utils.multiplicationInRQ(sArr5, sArr4, bArr10, iM17777getP, iM17778getQ);
        short[] sArr6 = new short[iM17777getP];
        C6090Utils.roundPolynomial(sArr6, sArr5);
        C6090Utils.getRoundedEncodedPolynomial(new byte[roundedPolynomialBytes], sArr6, iM17777getP, iM17778getQ);
        short[] sArr7 = new short[iM17777getP];
        C6090Utils.multiplicationInRQ(sArr7, sArr3, bArr10, iM17777getP, iM17778getQ);
        C6090Utils.m17804top(new byte[256], sArr7, bArr6, iM17778getQ, iM17779getTau0, iM17780getTau1);
        C6090Utils.getTopEncodedPolynomial(new byte[128], bArr5);
        byte[] bArr11 = new byte[this.privateKey.m17785getHash().length + 32];
        System.arraycopy(bArr7, 0, bArr11, 0, 32);
        System.arraycopy(this.privateKey.m17785getHash(), 0, bArr11, 32, this.privateKey.m17785getHash().length);
        byte[] hashWithPrefix2 = C6090Utils.getHashWithPrefix(new byte[]{2}, bArr11);
        int i = roundedPolynomialBytes + 128;
        int length = (hashWithPrefix2.length / 2) + i;
        byte[] bArr12 = new byte[length];
        System.arraycopy(bArr3, 0, bArr12, 0, roundedPolynomialBytes);
        System.arraycopy(bArr4, 0, bArr12, roundedPolynomialBytes, 128);
        System.arraycopy(hashWithPrefix2, 0, bArr12, i, hashWithPrefix2.length / 2);
        C6090Utils.updateDiffMask(bArr7, this.privateKey.m17787getRho(), C6238Arrays.constantTimeAreEqual(bArr, bArr12) ? 0 : -1);
        byte[] bArr13 = new byte[32 + length];
        System.arraycopy(bArr7, 0, bArr13, 0, 32);
        System.arraycopy(bArr12, 0, bArr13, 32, length);
        return C6238Arrays.copyOfRange(C6090Utils.getHashWithPrefix(new byte[]{1}, bArr13), 0, parameters.getSessionKeySize() / 8);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.privateKey.getParameters().getRoundedPolynomialBytes() + 160;
    }
}
