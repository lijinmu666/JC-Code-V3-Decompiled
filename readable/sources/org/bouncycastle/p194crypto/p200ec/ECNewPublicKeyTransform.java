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
public class ECNewPublicKeyTransform implements ECPairTransform {

    /* renamed from: key */
    private ECPublicKeyParameters f19629key;

    /* renamed from: random */
    private SecureRandom f19630random;

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.p194crypto.p200ec.ECPairTransform
    /* renamed from: init */
    public void mo15219init(CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            if (!(parametersWithRandom.getParameters() instanceof ECPublicKeyParameters)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for new public key transform.");
            }
            this.f19629key = (ECPublicKeyParameters) parametersWithRandom.getParameters();
            secureRandom = parametersWithRandom.getRandom();
        } else {
            if (!(cipherParameters instanceof ECPublicKeyParameters)) {
                throw new IllegalArgumentException("ECPublicKeyParameters are required for new public key transform.");
            }
            this.f19629key = (ECPublicKeyParameters) cipherParameters;
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        this.f19630random = secureRandom;
    }

    @Override // org.bouncycastle.p194crypto.p200ec.ECPairTransform
    public C5332ECPair transform(C5332ECPair c5332ECPair) {
        ECPublicKeyParameters eCPublicKeyParameters = this.f19629key;
        if (eCPublicKeyParameters == null) {
            throw new IllegalStateException("ECNewPublicKeyTransform not initialised");
        }
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        BigInteger bigIntegerM15723getN = parameters.m15723getN();
        ECMultiplier eCMultiplierCreateBasePointMultiplier = createBasePointMultiplier();
        BigInteger bigIntegerGenerateK = C5333ECUtil.generateK(bigIntegerM15723getN, this.f19630random);
        AbstractC5820ECPoint[] abstractC5820ECPointArr = {eCMultiplierCreateBasePointMultiplier.multiply(parameters.m15720getG(), bigIntegerGenerateK), this.f19629key.m15728getQ().multiply(bigIntegerGenerateK).mo16330add(ECAlgorithms.cleanPoint(parameters.getCurve(), c5332ECPair.m15223getY()))};
        parameters.getCurve().normalizeAll(abstractC5820ECPointArr);
        return new C5332ECPair(abstractC5820ECPointArr[0], abstractC5820ECPointArr[1]);
    }
}
