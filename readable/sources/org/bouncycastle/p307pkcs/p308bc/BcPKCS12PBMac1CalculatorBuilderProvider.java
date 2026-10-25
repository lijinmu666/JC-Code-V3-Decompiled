package org.bouncycastle.p307pkcs.p308bc;

import java.io.IOException;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p166pkcs.PBMAC1Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder;
import org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilderProvider;

/* loaded from: classes2.dex */
public class BcPKCS12PBMac1CalculatorBuilderProvider implements PKCS12MacCalculatorBuilderProvider {
    @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilderProvider
    /* renamed from: get */
    public PKCS12MacCalculatorBuilder mo17408get(final AlgorithmIdentifier algorithmIdentifier) {
        return new PKCS12MacCalculatorBuilder(this) { // from class: org.bouncycastle.pkcs.bc.BcPKCS12PBMac1CalculatorBuilderProvider.1

            /* renamed from: this$0 */
            final /* synthetic */ BcPKCS12PBMac1CalculatorBuilderProvider f22944this$0;

            {
                this.f22944this$0 = this;
            }

            @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
            /* renamed from: build */
            public MacCalculator mo17407build(char[] cArr) throws OperatorCreationException {
                if (!PKCSObjectIdentifiers.id_PBMAC1.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                    throw new OperatorCreationException("protection algorithm not PB mac based");
                }
                try {
                    return new BcPKCS12PBMac1CalculatorBuilder(PBMAC1Params.getInstance(algorithmIdentifier.getParameters())).mo17407build(cArr);
                } catch (IOException e) {
                    throw new OperatorCreationException("invalid parameters in protection algorithm: " + e.getMessage());
                }
            }

            @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
            public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
                return new AlgorithmIdentifier(algorithmIdentifier.getAlgorithm(), algorithmIdentifier.getParameters());
            }
        };
    }
}
