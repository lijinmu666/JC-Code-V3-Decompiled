package org.bouncycastle.p194crypto.p200ec;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;

/* loaded from: classes2.dex */
public class ECElGamalEncryptor implements ECEncryptor {

    /* renamed from: key */
    private ECPublicKeyParameters f19625key;

    /* renamed from: random */
    private SecureRandom f19626random;

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.p194crypto.p200ec.ECEncryptor
    /* renamed from: encrypt */
    public C5332ECPair mo15217encrypt(AbstractC5820ECPoint abstractC5820ECPoint) {
        ECPublicKeyParameters eCPublicKeyParameters = this.f19625key;
        if (eCPublicKeyParameters == null) {
            throw new IllegalStateException("ECElGamalEncryptor not initialised");
        }
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        BigInteger bigIntegerGenerateK = C5333ECUtil.generateK(parameters.m15723getN(), this.f19626random);
        AbstractC5820ECPoint[] abstractC5820ECPointArr = {createBasePointMultiplier().multiply(parameters.m15720getG(), bigIntegerGenerateK), this.f19625key.m15728getQ().multiply(bigIntegerGenerateK).mo16330add(ECAlgorithms.cleanPoint(parameters.getCurve(), abstractC5820ECPoint))};
        parameters.getCurve().normalizeAll(abstractC5820ECPointArr);
        return new C5332ECPair(abstractC5820ECPointArr[0], abstractC5820ECPointArr[1]);
    }

    @Override // org.bouncycastle.p194crypto.p200ec.ECEncryptor
    /* renamed from: init */
    public void mo15218init(CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            if (!(parametersWithRandom.getParameters() instanceof ECPublicKeyParameters)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
            }
            this.f19625key = (ECPublicKeyParameters) parametersWithRandom.getParameters();
            secureRandom = parametersWithRandom.getRandom();
        } else {
            if (!(cipherParameters instanceof ECPublicKeyParameters)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for encryption.");
            }
            this.f19625key = (ECPublicKeyParameters) cipherParameters;
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        this.f19626random = secureRandom;
    }
}
