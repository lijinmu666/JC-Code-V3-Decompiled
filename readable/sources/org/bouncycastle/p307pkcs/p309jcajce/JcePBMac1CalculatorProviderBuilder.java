package org.bouncycastle.p307pkcs.p309jcajce;

import java.security.Provider;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.PBEMacCalculatorProvider;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p166pkcs.PBMAC1Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JcePBMac1CalculatorProviderBuilder {

    /* renamed from: helper */
    private JcaJceHelper f22955helper = new DefaultJcaJceHelper();

    /* renamed from: build */
    public PBEMacCalculatorProvider m17424build() {
        return new PBEMacCalculatorProvider() { // from class: org.bouncycastle.pkcs.jcajce.JcePBMac1CalculatorProviderBuilder.1
            @Override // org.bouncycastle.operator.PBEMacCalculatorProvider
            /* renamed from: get */
            public MacCalculator mo14788get(AlgorithmIdentifier algorithmIdentifier, char[] cArr) throws OperatorCreationException {
                if (PKCSObjectIdentifiers.id_PBMAC1.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                    return new JcePBMac1CalculatorBuilder(PBMAC1Params.getInstance(algorithmIdentifier.getParameters())).setHelper(JcePBMac1CalculatorProviderBuilder.this.f22955helper).m17421build(cArr);
                }
                throw new OperatorCreationException("protection algorithm not PB mac based");
            }
        };
    }

    public JcePBMac1CalculatorProviderBuilder setProvider(String str) {
        this.f22955helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePBMac1CalculatorProviderBuilder setProvider(Provider provider) {
        this.f22955helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
