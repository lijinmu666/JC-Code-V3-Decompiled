package org.bouncycastle.p249jcajce.provider.asymmetric;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures.CompositeIndex;
import org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures.KeyFactorySpi;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricAlgorithmProvider;

/* loaded from: classes2.dex */
public class CompositeSignatures {

    /* renamed from: PREFIX */
    private static final String f21383PREFIX = "org.bouncycastle.jcajce.provider.asymmetric.compositesignatures.";
    private static final Map<String, String> compositesAttributes;

    public static class Mappings extends AsymmetricAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            configurableProvider.addAlgorithm("Signature.COMPOSITE", "org.bouncycastle.jcajce.provider.asymmetric.compositesignatures.SignatureSpi$COMPOSITE");
            for (ASN1ObjectIdentifier aSN1ObjectIdentifier : CompositeIndex.getSupportedIdentifiers()) {
                String algorithmName = CompositeIndex.getAlgorithmName(aSN1ObjectIdentifier);
                String strReplace = algorithmName.replace('-', '_');
                configurableProvider.addAlgorithm("Alg.Alias.KeyFactory", aSN1ObjectIdentifier, "COMPOSITE");
                configurableProvider.addAlgorithm("Alg.Alias.KeyFactory." + algorithmName, "COMPOSITE");
                configurableProvider.addAlgorithm("KeyPairGenerator." + algorithmName, "org.bouncycastle.jcajce.provider.asymmetric.compositesignatures.KeyPairGeneratorSpi$" + strReplace);
                configurableProvider.addAlgorithm("Alg.Alias.KeyPairGenerator", aSN1ObjectIdentifier, algorithmName);
                configurableProvider.addAlgorithm("Signature." + algorithmName, "org.bouncycastle.jcajce.provider.asymmetric.compositesignatures.SignatureSpi$" + strReplace);
                configurableProvider.addAlgorithm("Alg.Alias.Signature", aSN1ObjectIdentifier, algorithmName);
                configurableProvider.addAlgorithm("Signature." + algorithmName + "-PREHASH", "org.bouncycastle.jcajce.provider.asymmetric.compositesignatures.SignatureSpi$" + strReplace + "_PREHASH");
                configurableProvider.addKeyInfoConverter(aSN1ObjectIdentifier, new KeyFactorySpi());
            }
        }
    }

    static {
        HashMap map = new HashMap();
        compositesAttributes = map;
        map.put("SupportedKeyClasses", "org.bouncycastle.jcajce.CompositePublicKey|org.bouncycastle.jcajce.CompositePrivateKey");
        map.put("SupportedKeyFormats", "PKCS#8|X.509");
    }
}
