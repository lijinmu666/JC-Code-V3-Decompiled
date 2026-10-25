package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;

/* loaded from: classes2.dex */
public class DSTU4145KeyPairGenerator extends ECKeyPairGenerator {
    @Override // org.bouncycastle.p194crypto.generators.ECKeyPairGenerator, org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) super.generateKeyPair().getPublic();
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ECPublicKeyParameters(eCPublicKeyParameters.m15728getQ().mo16335negate(), eCPublicKeyParameters.getParameters()), r3.getPrivate());
    }
}
