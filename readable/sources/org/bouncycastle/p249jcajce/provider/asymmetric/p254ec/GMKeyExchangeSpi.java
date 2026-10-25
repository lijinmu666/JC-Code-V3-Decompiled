package org.bouncycastle.p249jcajce.provider.asymmetric.p254ec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.agreement.SM2KeyExchange;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithID;
import org.bouncycastle.p194crypto.p213params.SM2KeyExchangePrivateParameters;
import org.bouncycastle.p194crypto.p213params.SM2KeyExchangePublicParameters;
import org.bouncycastle.p249jcajce.p279spec.SM2KeyExchangeSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class GMKeyExchangeSpi extends BaseAgreementSpi {

    /* renamed from: engine */
    private final SM2KeyExchange f21480engine;
    private final String kaAlgorithm;

    /* renamed from: result */
    private byte[] f21481result;

    /* renamed from: spec */
    private SM2KeyExchangeSpec f21482spec;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.GMKeyExchangeSpi$SM2 */
    public static class C5520SM2 extends GMKeyExchangeSpi {
        public C5520SM2() {
            super("SM2");
        }
    }

    public GMKeyExchangeSpi(String str) {
        super(str, null);
        this.kaAlgorithm = str;
        this.f21480engine = new SM2KeyExchange();
    }

    private static String getSimpleName(Class cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi
    public byte[] doCalcSecret() {
        return C6238Arrays.m18231clone(this.f21481result);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi
    public void doInitFromKey(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec != null && !(algorithmParameterSpec instanceof SM2KeyExchangeSpec)) {
            throw new InvalidAlgorithmParameterException("No algorithm parameters supported");
        }
        if (key instanceof PrivateKey) {
            this.f21482spec = (SM2KeyExchangeSpec) algorithmParameterSpec;
            this.f21480engine.m15009init(new ParametersWithID(new SM2KeyExchangePrivateParameters(this.f21482spec.isInitiator(), (ECPrivateKeyParameters) C5518ECUtils.generatePrivateKeyParameter((PrivateKey) key), (ECPrivateKeyParameters) C5518ECUtils.generatePrivateKeyParameter(this.f21482spec.getEphemeralPrivateKey())), this.f21482spec.m16214getId()));
            return;
        }
        throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(BCECPrivateKey.class) + " for initialisation");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException {
        if (this.f21482spec == null) {
            throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
        }
        if (!z) {
            throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
        }
        if (key instanceof BCECPublicKey) {
            this.f21481result = this.f21480engine.calculateKey(128, new ParametersWithID(new SM2KeyExchangePublicParameters((ECPublicKeyParameters) C5518ECUtils.generatePublicKeyParameter((PublicKey) key), (ECPublicKeyParameters) C5518ECUtils.generatePublicKeyParameter(this.f21482spec.getOtherPartyEphemeralKey())), this.f21482spec.getOtherPartyId()));
            return null;
        }
        throw new InvalidKeyException(this.kaAlgorithm + " key agreement requires " + getSimpleName(BCECPublicKey.class) + " for doPhase");
    }
}
