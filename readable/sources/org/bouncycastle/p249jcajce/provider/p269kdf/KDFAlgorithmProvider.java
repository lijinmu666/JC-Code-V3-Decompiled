package org.bouncycastle.p249jcajce.provider.p269kdf;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider;

/* loaded from: classes2.dex */
abstract class KDFAlgorithmProvider extends AlgorithmProvider {
    public void addKDFAlgorithm(ConfigurableProvider configurableProvider, String str, String str2) {
        addKDFAlgorithm(configurableProvider, str, str2, null);
    }

    public void registerKDFAlias(ConfigurableProvider configurableProvider, String str, String str2) {
        configurableProvider.addAlgorithm("Alg.Alias.KDF." + str, str2);
    }

    public void registerKDFAliasOid(ConfigurableProvider configurableProvider, ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        configurableProvider.addAlgorithm("Alg.Alias.KDF." + aSN1ObjectIdentifier, str);
        configurableProvider.addAlgorithm("Alg.Alias.KDF.OID." + aSN1ObjectIdentifier, str);
    }

    public void addKDFAlgorithm(ConfigurableProvider configurableProvider, String str, String str2, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        configurableProvider.addAlgorithm("KDF." + str, str2);
        if (aSN1ObjectIdentifier != null) {
            registerKDFAliasOid(configurableProvider, aSN1ObjectIdentifier, str);
        }
    }
}
