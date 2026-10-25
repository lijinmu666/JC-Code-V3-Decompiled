package org.bouncycastle.p307pkcs.p309jcajce;

import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import javax.crypto.Mac;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.PKCS12Key;
import org.bouncycastle.p249jcajce.p250io.MacOutputStream;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder;
import org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilderProvider;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class JcePKCS12MacCalculatorBuilderProvider implements PKCS12MacCalculatorBuilderProvider {

    /* renamed from: helper */
    private JcaJceHelper f22962helper = new DefaultJcaJceHelper();

    @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilderProvider
    /* renamed from: get */
    public PKCS12MacCalculatorBuilder mo17408get(final AlgorithmIdentifier algorithmIdentifier) {
        return new PKCS12MacCalculatorBuilder(this) { // from class: org.bouncycastle.pkcs.jcajce.JcePKCS12MacCalculatorBuilderProvider.1

            /* renamed from: this$0 */
            final /* synthetic */ JcePKCS12MacCalculatorBuilderProvider f22963this$0;

            {
                this.f22963this$0 = this;
            }

            @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
            /* renamed from: build */
            public MacCalculator mo17407build(char[] cArr) throws OperatorCreationException, InvalidKeyException, InvalidAlgorithmParameterException {
                final PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                try {
                    final ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
                    final Mac macCreateMac = this.f22963this$0.f22962helper.createMac(algorithm.m14433getId());
                    PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(pKCS12PBEParams.m14636getIV(), BigIntegers.intValueExact(pKCS12PBEParams.getIterations()));
                    final PKCS12Key pKCS12Key = new PKCS12Key(cArr);
                    macCreateMac.init(pKCS12Key, pBEParameterSpec);
                    return new MacCalculator(this) { // from class: org.bouncycastle.pkcs.jcajce.JcePKCS12MacCalculatorBuilderProvider.1.1

                        /* renamed from: this$1 */
                        final /* synthetic */ C60371 f22964this$1;

                        {
                            this.f22964this$1 = this;
                        }

                        @Override // org.bouncycastle.operator.MacCalculator
                        public AlgorithmIdentifier getAlgorithmIdentifier() {
                            return new AlgorithmIdentifier(algorithm, pKCS12PBEParams);
                        }

                        @Override // org.bouncycastle.operator.MacCalculator
                        /* renamed from: getKey */
                        public GenericKey mo14789getKey() {
                            return new GenericKey(getAlgorithmIdentifier(), pKCS12Key.getEncoded());
                        }

                        @Override // org.bouncycastle.operator.MacCalculator
                        /* renamed from: getMac */
                        public byte[] mo14790getMac() {
                            return macCreateMac.doFinal();
                        }

                        @Override // org.bouncycastle.operator.MacCalculator
                        public OutputStream getOutputStream() {
                            return new MacOutputStream(macCreateMac);
                        }
                    };
                } catch (Exception e) {
                    throw new OperatorCreationException("unable to create MAC calculator: " + e.getMessage(), e);
                }
            }

            @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
            public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
                return new AlgorithmIdentifier(algorithmIdentifier.getAlgorithm(), C5103DERNull.INSTANCE);
            }
        };
    }

    public JcePKCS12MacCalculatorBuilderProvider setProvider(String str) {
        this.f22962helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePKCS12MacCalculatorBuilderProvider setProvider(Provider provider) {
        this.f22962helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
