package org.bouncycastle.p249jcajce.provider.p269kdf;

import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p249jcajce.p280util.AbstractC5806SpiUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;

/* renamed from: org.bouncycastle.jcajce.provider.kdf.PBKDF2 */
/* loaded from: classes2.dex */
public class C5661PBKDF2 {

    /* renamed from: PREFIX */
    private static final String f21715PREFIX = "org.bouncycastle.jcajce.provider.kdf.pbkdf2.";

    /* renamed from: org.bouncycastle.jcajce.provider.kdf.PBKDF2$Mappings */
    public static class Mappings extends AlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            if (AbstractC5806SpiUtil.m16225hasKDF()) {
                configurableProvider.addAlgorithm("KDF.PBKDF2", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withUTF8");
                configurableProvider.addAlgorithm("Alg.Alias.KDF.PBKDF2WITHHMACSHA1", "PBKDF2");
                configurableProvider.addAlgorithm("Alg.Alias.KDF.PBKDF2WITHHMACSHA1ANDUTF8", "PBKDF2");
                configurableProvider.addAlgorithm("KDF", PKCSObjectIdentifiers.id_PBKDF2, "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withUTF8");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHASCII", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2with8BIT");
                configurableProvider.addAlgorithm("Alg.Alias.KDF.PBKDF2WITH8BIT", "PBKDF2WITHASCII");
                configurableProvider.addAlgorithm("Alg.Alias.KDF.PBKDF2WITHHMACSHA1AND8BIT", "PBKDF2WITHASCII");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA224", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA224");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA256", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA256");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA384", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA384");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA512", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA512");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA512-224", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA512_224");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA512-256", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA512_256");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA3-224", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA3_224");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA3-256", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA3_256");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA3-384", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA3_384");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSHA3-512", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSHA3_512");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACGOST3411", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withGOST3411");
                configurableProvider.addAlgorithm("KDF.PBKDF2WITHHMACSM3", "org.bouncycastle.jcajce.provider.kdf.pbkdf2.PBKDF2Spi$PBKDF2withSM3");
            }
        }
    }
}
