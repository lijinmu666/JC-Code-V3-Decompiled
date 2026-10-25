package org.bouncycastle.p194crypto;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;

/* loaded from: classes2.dex */
public class CipherKeyGenerator {

    /* renamed from: random */
    protected SecureRandom f19121random;
    protected int strength;

    public byte[] generateKey() {
        byte[] bArr = new byte[this.strength];
        this.f19121random.nextBytes(bArr);
        return bArr;
    }

    /* renamed from: init */
    public void mo14956init(KeyGenerationParameters keyGenerationParameters) {
        this.f19121random = keyGenerationParameters.getRandom();
        this.strength = (keyGenerationParameters.getStrength() + 7) / 8;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("SymKeyGen", keyGenerationParameters.getStrength()));
    }
}
