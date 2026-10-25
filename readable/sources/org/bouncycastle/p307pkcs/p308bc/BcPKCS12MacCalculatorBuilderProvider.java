package org.bouncycastle.p307pkcs.p308bc;

import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.p305bc.BcDigestProvider;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder;
import org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilderProvider;

/* loaded from: classes2.dex */
public class BcPKCS12MacCalculatorBuilderProvider implements PKCS12MacCalculatorBuilderProvider {
    private BcDigestProvider digestProvider;

    public BcPKCS12MacCalculatorBuilderProvider(BcDigestProvider bcDigestProvider) {
        this.digestProvider = bcDigestProvider;
    }

    @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilderProvider
    /* renamed from: get */
    public PKCS12MacCalculatorBuilder mo17408get(final AlgorithmIdentifier algorithmIdentifier) {
        return new PKCS12MacCalculatorBuilder(this) { // from class: org.bouncycastle.pkcs.bc.BcPKCS12MacCalculatorBuilderProvider.1

            /* renamed from: this$0 */
            final /* synthetic */ BcPKCS12MacCalculatorBuilderProvider f22936this$0;

            {
                this.f22936this$0 = this;
            }

            @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
            /* renamed from: build */
            public MacCalculator mo17407build(char[] cArr) {
                return PKCS12PBEUtils.createMacCalculator(algorithmIdentifier.getAlgorithm(), this.f22936this$0.digestProvider.mo14916get(algorithmIdentifier), PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters()), cArr);
            }

            @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
            public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
                return new AlgorithmIdentifier(algorithmIdentifier.getAlgorithm(), C5103DERNull.INSTANCE);
            }
        };
    }
}
