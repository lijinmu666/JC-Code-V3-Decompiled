package org.bouncycastle.p191cms.p193jcajce;

import java.io.OutputStream;
import java.security.AlgorithmParameters;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.p306jcajce.JceGenericKey;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p249jcajce.p250io.MacOutputStream;

/* loaded from: classes2.dex */
public class JceCMSMacCalculatorBuilder {
    private AlgorithmParameters algorithmParameters;

    /* renamed from: helper */
    private EnvelopedDataHelper f19083helper;

    /* renamed from: keySize */
    private final int f19084keySize;

    /* renamed from: macOID */
    private final ASN1ObjectIdentifier f19085macOID;

    /* renamed from: random */
    private SecureRandom f19086random;

    public class CMSMacCalculator implements MacCalculator {
        private AlgorithmIdentifier algorithmIdentifier;

        /* renamed from: encKey */
        private SecretKey f19087encKey;

        /* renamed from: mac */
        private Mac f19088mac;

        public CMSMacCalculator(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws CMSException {
            KeyGenerator keyGeneratorCreateKeyGenerator = JceCMSMacCalculatorBuilder.this.f19083helper.createKeyGenerator(aSN1ObjectIdentifier);
            secureRandom = secureRandom == null ? new SecureRandom() : secureRandom;
            if (i < 0) {
                keyGeneratorCreateKeyGenerator.init(secureRandom);
            } else {
                keyGeneratorCreateKeyGenerator.init(i, secureRandom);
            }
            this.f19087encKey = keyGeneratorCreateKeyGenerator.generateKey();
            this.algorithmIdentifier = JceCMSMacCalculatorBuilder.this.f19083helper.getAlgorithmIdentifier(aSN1ObjectIdentifier, algorithmParameters == null ? JceCMSMacCalculatorBuilder.this.f19083helper.generateParameters(aSN1ObjectIdentifier, this.f19087encKey, secureRandom) : algorithmParameters);
            this.f19088mac = JceCMSMacCalculatorBuilder.this.f19083helper.createContentMac(this.f19087encKey, this.algorithmIdentifier);
        }

        @Override // org.bouncycastle.operator.MacCalculator
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        @Override // org.bouncycastle.operator.MacCalculator
        /* renamed from: getKey */
        public GenericKey mo14789getKey() {
            return new JceGenericKey(this.algorithmIdentifier, this.f19087encKey);
        }

        @Override // org.bouncycastle.operator.MacCalculator
        /* renamed from: getMac */
        public byte[] mo14790getMac() {
            return this.f19088mac.doFinal();
        }

        @Override // org.bouncycastle.operator.MacCalculator
        public OutputStream getOutputStream() {
            return new MacOutputStream(this.f19088mac);
        }
    }

    public JceCMSMacCalculatorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, -1);
    }

    /* renamed from: build */
    public MacCalculator m14939build() {
        return new CMSMacCalculator(this.f19085macOID, this.f19084keySize, this.algorithmParameters, this.f19086random);
    }

    public JceCMSMacCalculatorBuilder setAlgorithmParameters(AlgorithmParameters algorithmParameters) {
        this.algorithmParameters = algorithmParameters;
        return this;
    }

    public JceCMSMacCalculatorBuilder setProvider(String str) {
        this.f19083helper = new EnvelopedDataHelper(new NamedJcaJceExtHelper(str));
        return this;
    }

    public JceCMSMacCalculatorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.f19086random = secureRandom;
        return this;
    }

    public JceCMSMacCalculatorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        this.f19083helper = new EnvelopedDataHelper(new DefaultJcaJceExtHelper());
        this.f19085macOID = aSN1ObjectIdentifier;
        this.f19084keySize = i;
    }

    public JceCMSMacCalculatorBuilder setProvider(Provider provider) {
        this.f19083helper = new EnvelopedDataHelper(new ProviderJcaJceExtHelper(provider));
        return this;
    }
}
