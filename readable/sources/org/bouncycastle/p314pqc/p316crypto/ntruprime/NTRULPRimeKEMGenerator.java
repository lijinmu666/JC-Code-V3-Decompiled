package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRULPRimeKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: random */
    private final SecureRandom f23413random;

    public NTRULPRimeKEMGenerator(SecureRandom secureRandom) {
        this.f23413random = secureRandom;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        NTRULPRimePublicKeyParameters nTRULPRimePublicKeyParameters = (NTRULPRimePublicKeyParameters) asymmetricKeyParameter;
        NTRULPRimeParameters parameters = nTRULPRimePublicKeyParameters.getParameters();
        int iM17777getP = parameters.m17777getP();
        int iM17778getQ = parameters.m17778getQ();
        int iM17783getW = parameters.m17783getW();
        int roundedPolynomialBytes = parameters.getRoundedPolynomialBytes();
        int iM17779getTau0 = parameters.m17779getTau0();
        int iM17780getTau1 = parameters.m17780getTau1();
        byte[] hashWithPrefix = C6090Utils.getHashWithPrefix(new byte[]{4}, nTRULPRimePublicKeyParameters.getEncoded());
        byte[] bArr = new byte[256];
        C6090Utils.getRandomInputs(this.f23413random, bArr);
        byte[] bArr2 = new byte[32];
        C6090Utils.getEncodedInputs(bArr2, bArr);
        short[] sArr = new short[iM17777getP];
        C6090Utils.getRoundedDecodedPolynomial(sArr, nTRULPRimePublicKeyParameters.getRoundEncA(), iM17777getP, iM17778getQ);
        short[] sArr2 = new short[iM17777getP];
        C6090Utils.generatePolynomialInRQFromSeed(sArr2, nTRULPRimePublicKeyParameters.m17788getSeed(), iM17777getP, iM17778getQ);
        byte[] hashWithPrefix2 = C6090Utils.getHashWithPrefix(new byte[]{5}, bArr2);
        int[] iArr = new int[iM17777getP];
        C6090Utils.m17801expand(iArr, C6238Arrays.copyOfRange(hashWithPrefix2, 0, hashWithPrefix2.length / 2));
        byte[] bArr3 = new byte[iM17777getP];
        C6090Utils.sortGenerateShortPolynomial(bArr3, iArr, iM17777getP, iM17783getW);
        short[] sArr3 = new short[iM17777getP];
        C6090Utils.multiplicationInRQ(sArr3, sArr2, bArr3, iM17777getP, iM17778getQ);
        short[] sArr4 = new short[iM17777getP];
        C6090Utils.roundPolynomial(sArr4, sArr3);
        byte[] bArr4 = new byte[roundedPolynomialBytes];
        C6090Utils.getRoundedEncodedPolynomial(bArr4, sArr4, iM17777getP, iM17778getQ);
        short[] sArr5 = new short[iM17777getP];
        C6090Utils.multiplicationInRQ(sArr5, sArr, bArr3, iM17777getP, iM17778getQ);
        byte[] bArr5 = new byte[256];
        C6090Utils.m17804top(bArr5, sArr5, bArr, iM17778getQ, iM17779getTau0, iM17780getTau1);
        byte[] bArr6 = new byte[128];
        C6090Utils.getTopEncodedPolynomial(bArr6, bArr5);
        byte[] bArr7 = new byte[(hashWithPrefix.length / 2) + 32];
        System.arraycopy(bArr2, 0, bArr7, 0, 32);
        System.arraycopy(hashWithPrefix, 0, bArr7, 32, hashWithPrefix.length / 2);
        byte[] hashWithPrefix3 = C6090Utils.getHashWithPrefix(new byte[]{2}, bArr7);
        int i = roundedPolynomialBytes + 128;
        int length = (hashWithPrefix3.length / 2) + i;
        byte[] bArr8 = new byte[length];
        System.arraycopy(bArr4, 0, bArr8, 0, roundedPolynomialBytes);
        System.arraycopy(bArr6, 0, bArr8, roundedPolynomialBytes, 128);
        System.arraycopy(hashWithPrefix3, 0, bArr8, i, hashWithPrefix3.length / 2);
        byte[] bArr9 = new byte[32 + length];
        System.arraycopy(bArr2, 0, bArr9, 0, 32);
        System.arraycopy(bArr8, 0, bArr9, 32, length);
        return new SecretWithEncapsulationImpl(C6238Arrays.copyOfRange(C6090Utils.getHashWithPrefix(new byte[]{1}, bArr9), 0, parameters.getSessionKeySize() / 8), bArr8);
    }
}
