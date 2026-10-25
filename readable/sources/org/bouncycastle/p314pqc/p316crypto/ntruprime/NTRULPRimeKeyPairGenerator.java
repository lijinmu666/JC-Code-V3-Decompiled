package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRULPRimeKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: params */
    private NTRULPRimeKeyGenerationParameters f23414params;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        int iM17777getP = this.f23414params.getNtrulprParams().m17777getP();
        int iM17778getQ = this.f23414params.getNtrulprParams().m17778getQ();
        int iM17783getW = this.f23414params.getNtrulprParams().m17783getW();
        byte[] bArr = new byte[32];
        this.f23414params.getRandom().nextBytes(bArr);
        short[] sArr = new short[iM17777getP];
        C6090Utils.generatePolynomialInRQFromSeed(sArr, bArr, iM17777getP, iM17778getQ);
        byte[] bArr2 = new byte[iM17777getP];
        C6090Utils.getRandomShortPolynomial(this.f23414params.getRandom(), bArr2, iM17777getP, iM17783getW);
        short[] sArr2 = new short[iM17777getP];
        C6090Utils.multiplicationInRQ(sArr2, sArr, bArr2, iM17777getP, iM17778getQ);
        short[] sArr3 = new short[iM17777getP];
        C6090Utils.roundPolynomial(sArr3, sArr2);
        byte[] bArr3 = new byte[this.f23414params.getNtrulprParams().getPublicKeyBytes() - 32];
        C6090Utils.getRoundedEncodedPolynomial(bArr3, sArr3, iM17777getP, iM17778getQ);
        NTRULPRimePublicKeyParameters nTRULPRimePublicKeyParameters = new NTRULPRimePublicKeyParameters(this.f23414params.getNtrulprParams(), bArr, bArr3);
        byte[] bArr4 = new byte[(iM17777getP + 3) / 4];
        C6090Utils.getEncodedSmallPolynomial(bArr4, bArr2, iM17777getP);
        byte[] bArr5 = new byte[32];
        this.f23414params.getRandom().nextBytes(bArr5);
        byte[] hashWithPrefix = C6090Utils.getHashWithPrefix(new byte[]{4}, nTRULPRimePublicKeyParameters.getEncoded());
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) nTRULPRimePublicKeyParameters, (AsymmetricKeyParameter) new NTRULPRimePrivateKeyParameters(this.f23414params.getNtrulprParams(), bArr4, nTRULPRimePublicKeyParameters.getEncoded(), bArr5, C6238Arrays.copyOfRange(hashWithPrefix, 0, hashWithPrefix.length / 2)));
    }

    public NTRULPRimeKeyGenerationParameters getParams() {
        return this.f23414params;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23414params = (NTRULPRimeKeyGenerationParameters) keyGenerationParameters;
    }
}
