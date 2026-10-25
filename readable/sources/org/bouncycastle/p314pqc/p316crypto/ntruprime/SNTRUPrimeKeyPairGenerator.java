package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SNTRUPrimeKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: params */
    private SNTRUPrimeKeyGenerationParameters f23431params;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        int iM17790getP = this.f23431params.getSntrupParams().m17790getP();
        int iM17791getQ = this.f23431params.getSntrupParams().m17791getQ();
        int iM17792getW = this.f23431params.getSntrupParams().m17792getW();
        byte[] bArr = new byte[iM17790getP];
        byte[] bArr2 = new byte[iM17790getP];
        do {
            C6090Utils.getRandomSmallPolynomial(this.f23431params.getRandom(), bArr);
        } while (!C6090Utils.isInvertiblePolynomialInR3(bArr, bArr2, iM17790getP));
        byte[] bArr3 = new byte[iM17790getP];
        C6090Utils.getRandomShortPolynomial(this.f23431params.getRandom(), bArr3, iM17790getP, iM17792getW);
        short[] sArr = new short[iM17790getP];
        C6090Utils.getOneThirdInverseInRQ(sArr, bArr3, iM17790getP, iM17791getQ);
        short[] sArr2 = new short[iM17790getP];
        C6090Utils.multiplicationInRQ(sArr2, sArr, bArr, iM17790getP, iM17791getQ);
        byte[] bArr4 = new byte[this.f23431params.getSntrupParams().getPublicKeyBytes()];
        C6090Utils.getEncodedPolynomial(bArr4, sArr2, iM17790getP, iM17791getQ);
        SNTRUPrimePublicKeyParameters sNTRUPrimePublicKeyParameters = new SNTRUPrimePublicKeyParameters(this.f23431params.getSntrupParams(), bArr4);
        int i = (iM17790getP + 3) / 4;
        byte[] bArr5 = new byte[i];
        C6090Utils.getEncodedSmallPolynomial(bArr5, bArr3, iM17790getP);
        byte[] bArr6 = new byte[i];
        C6090Utils.getEncodedSmallPolynomial(bArr6, bArr2, iM17790getP);
        byte[] bArr7 = new byte[i];
        this.f23431params.getRandom().nextBytes(bArr7);
        byte[] hashWithPrefix = C6090Utils.getHashWithPrefix(new byte[]{4}, bArr4);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) sNTRUPrimePublicKeyParameters, (AsymmetricKeyParameter) new SNTRUPrimePrivateKeyParameters(this.f23431params.getSntrupParams(), bArr5, bArr6, bArr4, bArr7, C6238Arrays.copyOfRange(hashWithPrefix, 0, hashWithPrefix.length / 2)));
    }

    public SNTRUPrimeKeyGenerationParameters getParams() {
        return this.f23431params;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23431params = (SNTRUPrimeKeyGenerationParameters) keyGenerationParameters;
    }
}
