package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SNTRUPrimeKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: random */
    private final SecureRandom f23430random;

    public SNTRUPrimeKEMGenerator(SecureRandom secureRandom) {
        this.f23430random = CryptoServicesRegistrar.getSecureRandom(secureRandom);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        SNTRUPrimePublicKeyParameters sNTRUPrimePublicKeyParameters = (SNTRUPrimePublicKeyParameters) asymmetricKeyParameter;
        SNTRUPrimeParameters parameters = sNTRUPrimePublicKeyParameters.getParameters();
        int iM17790getP = parameters.m17790getP();
        int iM17791getQ = parameters.m17791getQ();
        int iM17792getW = parameters.m17792getW();
        int roundedPolynomialBytes = parameters.getRoundedPolynomialBytes();
        byte[] hashWithPrefix = C6090Utils.getHashWithPrefix(new byte[]{4}, sNTRUPrimePublicKeyParameters.getEncoded());
        byte[] bArr = new byte[iM17790getP];
        C6090Utils.getRandomShortPolynomial(this.f23430random, bArr, iM17790getP, iM17792getW);
        byte[] bArr2 = new byte[(iM17790getP + 3) / 4];
        C6090Utils.getEncodedSmallPolynomial(bArr2, bArr, iM17790getP);
        short[] sArr = new short[iM17790getP];
        C6090Utils.getDecodedPolynomial(sArr, sNTRUPrimePublicKeyParameters.m17798getEncH(), iM17790getP, iM17791getQ);
        short[] sArr2 = new short[iM17790getP];
        C6090Utils.multiplicationInRQ(sArr2, sArr, bArr, iM17790getP, iM17791getQ);
        short[] sArr3 = new short[iM17790getP];
        C6090Utils.roundPolynomial(sArr3, sArr2);
        byte[] bArr3 = new byte[roundedPolynomialBytes];
        C6090Utils.getRoundedEncodedPolynomial(bArr3, sArr3, iM17790getP, iM17791getQ);
        byte[] hashWithPrefix2 = C6090Utils.getHashWithPrefix(new byte[]{3}, bArr2);
        byte[] bArr4 = new byte[(hashWithPrefix2.length / 2) + (hashWithPrefix.length / 2)];
        System.arraycopy(hashWithPrefix2, 0, bArr4, 0, hashWithPrefix2.length / 2);
        System.arraycopy(hashWithPrefix, 0, bArr4, hashWithPrefix2.length / 2, hashWithPrefix.length / 2);
        byte[] hashWithPrefix3 = C6090Utils.getHashWithPrefix(new byte[]{2}, bArr4);
        int length = (hashWithPrefix3.length / 2) + roundedPolynomialBytes;
        byte[] bArr5 = new byte[length];
        System.arraycopy(bArr3, 0, bArr5, 0, roundedPolynomialBytes);
        System.arraycopy(hashWithPrefix3, 0, bArr5, roundedPolynomialBytes, hashWithPrefix3.length / 2);
        byte[] hashWithPrefix4 = C6090Utils.getHashWithPrefix(new byte[]{3}, bArr2);
        byte[] bArr6 = new byte[(hashWithPrefix4.length / 2) + length];
        System.arraycopy(hashWithPrefix4, 0, bArr6, 0, hashWithPrefix4.length / 2);
        System.arraycopy(bArr5, 0, bArr6, hashWithPrefix4.length / 2, length);
        return new SecretWithEncapsulationImpl(C6238Arrays.copyOfRange(C6090Utils.getHashWithPrefix(new byte[]{1}, bArr6), 0, parameters.getSessionKeySize() / 8), bArr5);
    }
}
