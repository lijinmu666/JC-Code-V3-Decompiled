package org.bouncycastle.p314pqc.p334jcajce.provider.p343newhope;

import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi;
import org.bouncycastle.p314pqc.p316crypto.ExchangePair;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHAgreement;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHExchangePairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHPublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class KeyAgreementSpi extends BaseAgreementSpi {
    private NHAgreement agreement;
    private NHExchangePairGenerator exchangePairGenerator;
    private BCNHPublicKey otherPartyKey;

    /* renamed from: shared */
    private byte[] f23789shared;

    public KeyAgreementSpi() {
        super("NH", null);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi
    public byte[] doCalcSecret() {
        return engineGenerateSecret();
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi
    public void doInitFromKey(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        throw new InvalidAlgorithmParameterException("NewHope does not require parameters");
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) {
        if (!z) {
            throw new IllegalStateException("NewHope can only be between two parties.");
        }
        BCNHPublicKey bCNHPublicKey = (BCNHPublicKey) key;
        this.otherPartyKey = bCNHPublicKey;
        NHExchangePairGenerator nHExchangePairGenerator = this.exchangePairGenerator;
        if (nHExchangePairGenerator == null) {
            this.f23789shared = this.agreement.calculateAgreement(bCNHPublicKey.getKeyParams());
            return null;
        }
        ExchangePair exchangePairGenerateExchange = nHExchangePairGenerator.generateExchange((AsymmetricKeyParameter) bCNHPublicKey.getKeyParams());
        this.f23789shared = exchangePairGenerateExchange.getSharedValue();
        return new BCNHPublicKey((NHPublicKeyParameters) exchangePairGenerateExchange.getPublicKey());
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public int engineGenerateSecret(byte[] bArr, int i) {
        byte[] bArr2 = this.f23789shared;
        System.arraycopy(bArr2, 0, bArr, i, bArr2.length);
        C6238Arrays.m18249fill(this.f23789shared, (byte) 0);
        return this.f23789shared.length;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public void engineInit(Key key, SecureRandom secureRandom) {
        if (key == null) {
            this.exchangePairGenerator = new NHExchangePairGenerator(secureRandom);
            return;
        }
        NHAgreement nHAgreement = new NHAgreement();
        this.agreement = nHAgreement;
        nHAgreement.m17737init(((BCNHPrivateKey) key).getKeyParams());
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi, javax.crypto.KeyAgreementSpi
    public byte[] engineGenerateSecret() {
        byte[] bArrM18231clone = C6238Arrays.m18231clone(this.f23789shared);
        C6238Arrays.m18249fill(this.f23789shared, (byte) 0);
        return bArrM18231clone;
    }
}
