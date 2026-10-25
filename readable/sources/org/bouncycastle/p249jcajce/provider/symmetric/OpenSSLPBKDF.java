package org.bouncycastle.p249jcajce.provider.symmetric;

import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p194crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public final class OpenSSLPBKDF {

    public static class Mappings extends AlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21808PREFIX = OpenSSLPBKDF.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("SecretKeyFactory.PBKDF-OPENSSL", f21808PREFIX + "$PBKDF");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.OpenSSLPBKDF$PBKDF */
    public static class C5755PBKDF extends BaseSecretKeyFactory {
        public C5755PBKDF() {
            super("PBKDF-OpenSSL", null);
        }

        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseSecretKeyFactory, javax.crypto.SecretKeyFactorySpi
        public SecretKey engineGenerateSecret(KeySpec keySpec) throws InvalidKeySpecException {
            if (!(keySpec instanceof PBEKeySpec)) {
                throw new InvalidKeySpecException("Invalid KeySpec");
            }
            PBEKeySpec pBEKeySpec = (PBEKeySpec) keySpec;
            if (pBEKeySpec.getSalt() == null) {
                throw new InvalidKeySpecException("missing required salt");
            }
            if (pBEKeySpec.getIterationCount() <= 0) {
                throw new InvalidKeySpecException("positive iteration count required: " + pBEKeySpec.getIterationCount());
            }
            if (pBEKeySpec.getKeyLength() <= 0) {
                throw new InvalidKeySpecException("positive key length required: " + pBEKeySpec.getKeyLength());
            }
            if (pBEKeySpec.getPassword().length == 0) {
                throw new IllegalArgumentException("password empty");
            }
            OpenSSLPBEParametersGenerator openSSLPBEParametersGenerator = new OpenSSLPBEParametersGenerator();
            openSSLPBEParametersGenerator.m15496init(C6250Strings.toUTF8ByteArray(pBEKeySpec.getPassword()), pBEKeySpec.getSalt());
            return new SecretKeySpec(((KeyParameter) openSSLPBEParametersGenerator.generateDerivedParameters(pBEKeySpec.getKeyLength())).m15773getKey(), "OpenSSLPBKDF");
        }
    }

    private OpenSSLPBKDF() {
    }
}
