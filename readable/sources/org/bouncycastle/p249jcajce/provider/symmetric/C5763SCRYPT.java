package org.bouncycastle.p249jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.p194crypto.PasswordConverter;
import org.bouncycastle.p194crypto.generators.C5346SCrypt;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p249jcajce.p279spec.ScryptKeySpec;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BCPBEKey;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.SCRYPT */
/* loaded from: classes2.dex */
public class C5763SCRYPT {

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SCRYPT$BasePBKDF2 */
    public static class BasePBKDF2 extends BaseSecretKeyFactory {

        /* renamed from: scheme */
        private int f21825scheme;

        public BasePBKDF2(String str, int i) {
            super(str, MiscObjectIdentifiers.id_scrypt);
            this.f21825scheme = i;
        }

        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (!(keySpec instanceof ScryptKeySpec)) {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
            ScryptKeySpec scryptKeySpec = (ScryptKeySpec) keySpec;
            if (scryptKeySpec.m16216getSalt() == null) {
                throw new IllegalArgumentException("Salt S must be provided.");
            }
            if (scryptKeySpec.getCostParameter() <= 1) {
                throw new IllegalArgumentException("Cost parameter N must be > 1.");
            }
            if (scryptKeySpec.getKeyLength() > 0) {
                if (scryptKeySpec.getPassword().length == 0) {
                    throw new IllegalArgumentException("password empty");
                }
                return new BCPBEKey(this.f21871algName, new KeyParameter(C5346SCrypt.generate(PasswordConverter.UTF8.mo14954convert(scryptKeySpec.getPassword()), scryptKeySpec.m16216getSalt(), scryptKeySpec.getCostParameter(), scryptKeySpec.getBlockSize(), scryptKeySpec.getParallelizationParameter(), scryptKeySpec.getKeyLength() / 8)));
            }
            throw new InvalidKeySpecException("positive key length required: " + scryptKeySpec.getKeyLength());
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SCRYPT$Mappings */
    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21826PREFIX = C5763SCRYPT.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21826PREFIX;
            sb.append(str);
            sb.append("$ScryptWithUTF8");
            configurableProvider.addAlgorithm("SecretKeyFactory.SCRYPT", sb.toString());
            configurableProvider.addAlgorithm("SecretKeyFactory", MiscObjectIdentifiers.id_scrypt, str + "$ScryptWithUTF8");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.SCRYPT$ScryptWithUTF8 */
    public static class ScryptWithUTF8 extends BasePBKDF2 {
        public ScryptWithUTF8() {
            super("SCRYPT", 5);
        }
    }

    private C5763SCRYPT() {
    }
}
