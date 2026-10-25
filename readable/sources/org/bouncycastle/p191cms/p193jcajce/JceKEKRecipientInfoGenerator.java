package org.bouncycastle.p191cms.p193jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.p306jcajce.JceSymmetricKeyWrapper;
import org.bouncycastle.p133asn1.p139cms.KEKIdentifier;
import org.bouncycastle.p191cms.KEKRecipientInfoGenerator;

/* loaded from: classes2.dex */
public class JceKEKRecipientInfoGenerator extends KEKRecipientInfoGenerator {
    public JceKEKRecipientInfoGenerator(KEKIdentifier kEKIdentifier, SecretKey secretKey) {
        super(kEKIdentifier, new JceSymmetricKeyWrapper(secretKey));
    }

    public JceKEKRecipientInfoGenerator setProvider(String str) {
        ((JceSymmetricKeyWrapper) this.f19017wrapper).setProvider(str);
        return this;
    }

    public JceKEKRecipientInfoGenerator setSecureRandom(SecureRandom secureRandom) {
        ((JceSymmetricKeyWrapper) this.f19017wrapper).setSecureRandom(secureRandom);
        return this;
    }

    public JceKEKRecipientInfoGenerator(byte[] bArr, SecretKey secretKey) {
        this(new KEKIdentifier(bArr, null, null), secretKey);
    }

    public JceKEKRecipientInfoGenerator setProvider(Provider provider) {
        ((JceSymmetricKeyWrapper) this.f19017wrapper).setProvider(provider);
        return this;
    }
}
