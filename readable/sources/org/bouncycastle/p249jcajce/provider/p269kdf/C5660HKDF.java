package org.bouncycastle.p249jcajce.provider.p269kdf;

import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p249jcajce.p280util.AbstractC5806SpiUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;

/* renamed from: org.bouncycastle.jcajce.provider.kdf.HKDF */
/* loaded from: classes2.dex */
public class C5660HKDF {

    /* renamed from: PREFIX */
    private static final String f21714PREFIX = "org.bouncycastle.jcajce.provider.kdf.hkdf.";

    /* renamed from: org.bouncycastle.jcajce.provider.kdf.HKDF$Mappings */
    public static class Mappings extends KDFAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            if (AbstractC5806SpiUtil.m16225hasKDF()) {
                addKDFAlgorithm(configurableProvider, "HKDF-SHA256", "org.bouncycastle.jcajce.provider.kdf.hkdf.HKDFSpi$HKDFwithSHA256", PKCSObjectIdentifiers.id_alg_hkdf_with_sha256);
                addKDFAlgorithm(configurableProvider, "HKDF-SHA384", "org.bouncycastle.jcajce.provider.kdf.hkdf.HKDFSpi$HKDFwithSHA384", PKCSObjectIdentifiers.id_alg_hkdf_with_sha384);
                addKDFAlgorithm(configurableProvider, "HKDF-SHA512", "org.bouncycastle.jcajce.provider.kdf.hkdf.HKDFSpi$HKDFwithSHA512", PKCSObjectIdentifiers.id_alg_hkdf_with_sha512);
            }
        }
    }
}
