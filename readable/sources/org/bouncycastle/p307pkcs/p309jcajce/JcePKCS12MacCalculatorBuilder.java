package org.bouncycastle.p307pkcs.p309jcajce;

import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Mac;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.PKCS12Key;
import org.bouncycastle.p249jcajce.p250io.MacOutputStream;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder;

/* loaded from: classes2.dex */
public class JcePKCS12MacCalculatorBuilder implements PKCS12MacCalculatorBuilder {
    private ASN1ObjectIdentifier algorithm;

    /* renamed from: helper */
    private JcaJceHelper f22957helper;
    private int iterationCount;

    /* renamed from: random */
    private SecureRandom f22958random;
    private int saltLength;

    public JcePKCS12MacCalculatorBuilder() {
        this(OIWObjectIdentifiers.f18459idSHA1);
    }

    @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
    /* renamed from: build */
    public MacCalculator mo17407build(char[] cArr) throws OperatorCreationException, InvalidKeyException, InvalidAlgorithmParameterException {
        if (this.f22958random == null) {
            this.f22958random = new SecureRandom();
        }
        try {
            final Mac macCreateMac = this.f22957helper.createMac(this.algorithm.m14433getId());
            int macLength = macCreateMac.getMacLength();
            this.saltLength = macLength;
            final byte[] bArr = new byte[macLength];
            this.f22958random.nextBytes(bArr);
            PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, this.iterationCount);
            final PKCS12Key pKCS12Key = new PKCS12Key(cArr);
            macCreateMac.init(pKCS12Key, pBEParameterSpec);
            return new MacCalculator(this) { // from class: org.bouncycastle.pkcs.jcajce.JcePKCS12MacCalculatorBuilder.1

                /* renamed from: this$0 */
                final /* synthetic */ JcePKCS12MacCalculatorBuilder f22959this$0;

                {
                    this.f22959this$0 = this;
                }

                @Override // org.bouncycastle.operator.MacCalculator
                public AlgorithmIdentifier getAlgorithmIdentifier() {
                    return new AlgorithmIdentifier(this.f22959this$0.algorithm, new PKCS12PBEParams(bArr, this.f22959this$0.iterationCount));
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
        return new AlgorithmIdentifier(this.algorithm, C5103DERNull.INSTANCE);
    }

    public JcePKCS12MacCalculatorBuilder setIterationCount(int i) {
        this.iterationCount = i;
        return this;
    }

    public JcePKCS12MacCalculatorBuilder setProvider(String str) {
        this.f22957helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePKCS12MacCalculatorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.f22957helper = new DefaultJcaJceHelper();
        this.iterationCount = 1024;
        this.algorithm = aSN1ObjectIdentifier;
    }

    public JcePKCS12MacCalculatorBuilder setProvider(Provider provider) {
        this.f22957helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
