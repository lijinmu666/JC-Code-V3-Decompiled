package org.bouncycastle.p249jcajce.provider.p269kdf;

import org.bouncycastle.p249jcajce.p280util.AbstractC5806SpiUtil;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;

/* renamed from: org.bouncycastle.jcajce.provider.kdf.SCRYPT */
/* loaded from: classes2.dex */
public class C5662SCRYPT {

    /* renamed from: PREFIX */
    private static final String f21716PREFIX = "org.bouncycastle.jcajce.provider.kdf.scrypt.";

    /* renamed from: org.bouncycastle.jcajce.provider.kdf.SCRYPT$Mappings */
    public static class Mappings extends KDFAlgorithmProvider {
        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            if (AbstractC5806SpiUtil.m16225hasKDF()) {
                addKDFAlgorithm(configurableProvider, "SCRYPT", "org.bouncycastle.jcajce.provider.kdf.scrypt.ScryptSpi$ScryptWithUTF8");
            }
        }
    }
}
