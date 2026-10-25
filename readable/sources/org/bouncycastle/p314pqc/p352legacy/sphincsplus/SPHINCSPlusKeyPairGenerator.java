package org.bouncycastle.p314pqc.p352legacy.sphincsplus;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusEngine;

/* loaded from: classes2.dex */
public class SPHINCSPlusKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private SPHINCSPlusParameters parameters;

    /* renamed from: random */
    private SecureRandom f24109random;

    private byte[] sec_rand(int i) {
        byte[] bArr = new byte[i];
        this.f24109random.nextBytes(bArr);
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        C6229SK c6229sk;
        byte[] bArrSec_rand;
        SPHINCSPlusEngine engine = this.parameters.getEngine();
        if (engine instanceof SPHINCSPlusEngine.HarakaSEngine) {
            byte[] bArrSec_rand2 = sec_rand(engine.f24100N * 3);
            int i = engine.f24100N;
            byte[] bArr = new byte[i];
            byte[] bArr2 = new byte[i];
            bArrSec_rand = new byte[i];
            System.arraycopy(bArrSec_rand2, 0, bArr, 0, i);
            int i2 = engine.f24100N;
            System.arraycopy(bArrSec_rand2, i2, bArr2, 0, i2);
            int i3 = engine.f24100N;
            System.arraycopy(bArrSec_rand2, i3 << 1, bArrSec_rand, 0, i3);
            c6229sk = new C6229SK(bArr, bArr2);
        } else {
            c6229sk = new C6229SK(sec_rand(engine.f24100N), sec_rand(engine.f24100N));
            bArrSec_rand = sec_rand(engine.f24100N);
        }
        engine.mo18163init(bArrSec_rand);
        C6227PK c6227pk = new C6227PK(bArrSec_rand, new C6226HT(engine, c6229sk.f24094seed, bArrSec_rand).htPubKey);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new SPHINCSPlusPublicKeyParameters(this.parameters, c6227pk), (AsymmetricKeyParameter) new SPHINCSPlusPrivateKeyParameters(this.parameters, c6229sk, c6227pk));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f24109random = keyGenerationParameters.getRandom();
        this.parameters = ((SPHINCSPlusKeyGenerationParameters) keyGenerationParameters).getParameters();
    }
}
