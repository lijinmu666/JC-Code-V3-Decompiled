package org.bouncycastle.p314pqc.p316crypto.p325newhope;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.ExchangePair;
import org.bouncycastle.p314pqc.p316crypto.ExchangePairGenerator;

/* loaded from: classes2.dex */
public class NHExchangePairGenerator implements ExchangePairGenerator {

    /* renamed from: random */
    private final SecureRandom f23359random;

    public NHExchangePairGenerator(SecureRandom secureRandom) {
        this.f23359random = secureRandom;
    }

    public ExchangePair GenerateExchange(AsymmetricKeyParameter asymmetricKeyParameter) {
        return generateExchange(asymmetricKeyParameter);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.ExchangePairGenerator
    public ExchangePair generateExchange(AsymmetricKeyParameter asymmetricKeyParameter) {
        byte[] bArr = new byte[32];
        byte[] bArr2 = new byte[2048];
        C6085NewHope.m17749sharedB(this.f23359random, bArr, bArr2, ((NHPublicKeyParameters) asymmetricKeyParameter).f23365pubData);
        return new ExchangePair(new NHPublicKeyParameters(bArr2), bArr);
    }
}
