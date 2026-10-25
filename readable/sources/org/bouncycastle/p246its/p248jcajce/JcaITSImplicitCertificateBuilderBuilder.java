package org.bouncycastle.p246its.p248jcajce;

import java.security.Provider;
import org.bouncycastle.operator.p306jcajce.JcaDigestCalculatorProviderBuilder;
import org.bouncycastle.p246its.ITSCertificate;
import org.bouncycastle.p246its.ITSImplicitCertificateBuilder;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.ToBeSignedCertificate;

/* loaded from: classes2.dex */
public class JcaITSImplicitCertificateBuilderBuilder {
    private final JcaDigestCalculatorProviderBuilder digestCalculatorProviderBuilder = new JcaDigestCalculatorProviderBuilder();

    /* renamed from: build */
    public ITSImplicitCertificateBuilder m16030build(ITSCertificate iTSCertificate, ToBeSignedCertificate.C5938Builder c5938Builder) {
        return new ITSImplicitCertificateBuilder(iTSCertificate, this.digestCalculatorProviderBuilder.m17397build(), c5938Builder);
    }

    public JcaITSImplicitCertificateBuilderBuilder setProvider(String str) {
        this.digestCalculatorProviderBuilder.setProvider(str);
        return this;
    }

    public JcaITSImplicitCertificateBuilderBuilder setProvider(Provider provider) {
        this.digestCalculatorProviderBuilder.setProvider(provider);
        return this;
    }
}
