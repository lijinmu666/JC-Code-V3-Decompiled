package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRUKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: params */
    private NTRUKeyGenerationParameters f23378params;

    /* renamed from: random */
    private SecureRandom f23379random;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        NTRUParameters parameters = this.f23378params.getParameters();
        NTRUParameterSet parameterSet = parameters.getParameterSet();
        byte[] bArr = new byte[parameterSet.sampleFgBytes()];
        this.f23379random.nextBytes(bArr);
        OWCPAKeyPair oWCPAKeyPairM17761keypair = new NTRUOWCPA(parameterSet).m17761keypair(bArr);
        byte[] bArr2 = oWCPAKeyPairM17761keypair.publicKey;
        byte[] bArr3 = new byte[parameterSet.prfKeyBytes()];
        this.f23379random.nextBytes(bArr3);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new NTRUPublicKeyParameters(parameters, bArr2), (AsymmetricKeyParameter) new NTRUPrivateKeyParameters(parameters, C6238Arrays.concatenate(oWCPAKeyPairM17761keypair.privateKey, bArr3)));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23378params = (NTRUKeyGenerationParameters) keyGenerationParameters;
        this.f23379random = keyGenerationParameters.getRandom();
    }
}
