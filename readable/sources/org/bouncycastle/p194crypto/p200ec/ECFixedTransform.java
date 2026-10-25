package org.bouncycastle.p194crypto.p200ec;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;

/* loaded from: classes2.dex */
public class ECFixedTransform implements ECPairFactorTransform {

    /* renamed from: k */
    private BigInteger f19627k;

    /* renamed from: key */
    private ECPublicKeyParameters f19628key;

    public ECFixedTransform(BigInteger bigInteger) {
        this.f19627k = bigInteger;
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.p194crypto.p200ec.ECPairFactorTransform
    public BigInteger getTransformValue() {
        return this.f19627k;
    }

    @Override // org.bouncycastle.p194crypto.p200ec.ECPairTransform
    /* renamed from: init */
    public void mo15219init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ECPublicKeyParameters)) {
            throw new IllegalArgumentException("ECPublicKeyParameters are required for fixed transform.");
        }
        this.f19628key = (ECPublicKeyParameters) cipherParameters;
    }

    @Override // org.bouncycastle.p194crypto.p200ec.ECPairTransform
    public C5332ECPair transform(C5332ECPair c5332ECPair) {
        ECPublicKeyParameters eCPublicKeyParameters = this.f19628key;
        if (eCPublicKeyParameters == null) {
            throw new IllegalStateException("ECFixedTransform not initialised");
        }
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        BigInteger bigIntegerM15723getN = parameters.m15723getN();
        ECMultiplier eCMultiplierCreateBasePointMultiplier = createBasePointMultiplier();
        BigInteger bigIntegerMod = this.f19627k.mod(bigIntegerM15723getN);
        AbstractC5820ECPoint[] abstractC5820ECPointArr = {eCMultiplierCreateBasePointMultiplier.multiply(parameters.m15720getG(), bigIntegerMod).mo16330add(ECAlgorithms.cleanPoint(parameters.getCurve(), c5332ECPair.m15222getX())), this.f19628key.m15728getQ().multiply(bigIntegerMod).mo16330add(ECAlgorithms.cleanPoint(parameters.getCurve(), c5332ECPair.m15223getY()))};
        parameters.getCurve().normalizeAll(abstractC5820ECPointArr);
        return new C5332ECPair(abstractC5820ECPointArr[0], abstractC5820ECPointArr[1]);
    }
}
