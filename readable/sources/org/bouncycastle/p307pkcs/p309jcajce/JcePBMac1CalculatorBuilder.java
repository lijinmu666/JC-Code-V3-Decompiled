package org.bouncycastle.p307pkcs.p309jcajce;

import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import org.bouncycastle.operator.DefaultMacAlgorithmIdentifierFinder;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacAlgorithmIdentifierFinder;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PBMAC1Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p250io.MacOutputStream;
import org.bouncycastle.p249jcajce.p279spec.PBKDF2KeySpec;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class JcePBMac1CalculatorBuilder {
    public static final AlgorithmIdentifier PRF_SHA224;
    public static final AlgorithmIdentifier PRF_SHA256;
    public static final AlgorithmIdentifier PRF_SHA384;
    public static final AlgorithmIdentifier PRF_SHA3_224;
    public static final AlgorithmIdentifier PRF_SHA3_256;
    public static final AlgorithmIdentifier PRF_SHA3_384;
    public static final AlgorithmIdentifier PRF_SHA3_512;
    public static final AlgorithmIdentifier PRF_SHA512;
    private static final DefaultMacAlgorithmIdentifierFinder defaultFinder;

    /* renamed from: helper */
    private JcaJceHelper f22947helper;
    private int iterationCount;

    /* renamed from: keySize */
    private int f22948keySize;
    private AlgorithmIdentifier macAlgorithm;
    private PBKDF2Params pbeParams;

    /* renamed from: prf */
    private AlgorithmIdentifier f22949prf;

    /* renamed from: random */
    private SecureRandom f22950random;

    /* renamed from: salt */
    private byte[] f22951salt;
    private int saltLength;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_hmacWithSHA224;
        C5103DERNull c5103DERNull = C5103DERNull.INSTANCE;
        PRF_SHA224 = new AlgorithmIdentifier(aSN1ObjectIdentifier, c5103DERNull);
        PRF_SHA256 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256, c5103DERNull);
        PRF_SHA384 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA384, c5103DERNull);
        PRF_SHA512 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, c5103DERNull);
        PRF_SHA3_224 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_224);
        PRF_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_256);
        PRF_SHA3_384 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_384);
        PRF_SHA3_512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512);
        defaultFinder = new DefaultMacAlgorithmIdentifierFinder();
    }

    public JcePBMac1CalculatorBuilder(String str, int i) {
        this(str, i, defaultFinder);
    }

    /* renamed from: build */
    public MacCalculator m17421build(char[] cArr) throws InvalidKeySpecException, OperatorCreationException, InvalidKeyException {
        if (this.f22950random == null) {
            this.f22950random = new SecureRandom();
        }
        try {
            final Mac macCreateMac = this.f22947helper.createMac(this.macAlgorithm.getAlgorithm().m14433getId());
            PBKDF2Params pBKDF2Params = this.pbeParams;
            if (pBKDF2Params != null) {
                this.f22951salt = pBKDF2Params.m14635getSalt();
                this.iterationCount = BigIntegers.intValueExact(this.pbeParams.getIterationCount());
                this.f22948keySize = BigIntegers.intValueExact(this.pbeParams.getKeyLength()) * 8;
                this.f22949prf = this.pbeParams.m14634getPrf();
            } else if (this.f22951salt == null) {
                if (this.saltLength < 0) {
                    this.saltLength = macCreateMac.getMacLength();
                }
                byte[] bArr = new byte[this.saltLength];
                this.f22951salt = bArr;
                this.f22950random.nextBytes(bArr);
            }
            final SecretKey secretKeyGenerateSecret = this.f22947helper.createSecretKeyFactory("PBKDF2").generateSecret(new PBKDF2KeySpec(cArr, this.f22951salt, this.iterationCount, this.f22948keySize, this.f22949prf));
            macCreateMac.init(secretKeyGenerateSecret);
            return new MacCalculator(this) { // from class: org.bouncycastle.pkcs.jcajce.JcePBMac1CalculatorBuilder.1

                /* renamed from: this$0 */
                final /* synthetic */ JcePBMac1CalculatorBuilder f22952this$0;

                {
                    this.f22952this$0 = this;
                }

                @Override // org.bouncycastle.operator.MacCalculator
                public AlgorithmIdentifier getAlgorithmIdentifier() {
                    return new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBMAC1, new PBMAC1Params(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBKDF2Params(this.f22952this$0.f22951salt, this.f22952this$0.iterationCount, (this.f22952this$0.f22948keySize + 7) / 8, this.f22952this$0.f22949prf)), this.f22952this$0.macAlgorithm));
                }

                @Override // org.bouncycastle.operator.MacCalculator
                /* renamed from: getKey */
                public GenericKey mo14789getKey() {
                    return new GenericKey(getAlgorithmIdentifier(), secretKeyGenerateSecret.getEncoded());
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

    public JcePBMac1CalculatorBuilder setHelper(JcaJceHelper jcaJceHelper) {
        this.f22947helper = jcaJceHelper;
        return this;
    }

    public JcePBMac1CalculatorBuilder setIterationCount(int i) {
        this.iterationCount = i;
        return this;
    }

    /* renamed from: setPrf */
    public JcePBMac1CalculatorBuilder m17422setPrf(AlgorithmIdentifier algorithmIdentifier) {
        this.f22949prf = algorithmIdentifier;
        return this;
    }

    public JcePBMac1CalculatorBuilder setProvider(String str) {
        this.f22947helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePBMac1CalculatorBuilder setRandom(SecureRandom secureRandom) {
        this.f22950random = secureRandom;
        return this;
    }

    /* renamed from: setSalt */
    public JcePBMac1CalculatorBuilder m17423setSalt(byte[] bArr) {
        this.f22951salt = bArr;
        return this;
    }

    public JcePBMac1CalculatorBuilder setSaltLength(int i) {
        this.saltLength = i;
        return this;
    }

    public JcePBMac1CalculatorBuilder(String str, int i, MacAlgorithmIdentifierFinder macAlgorithmIdentifierFinder) {
        this.f22947helper = new DefaultJcaJceHelper();
        this.saltLength = -1;
        this.iterationCount = 8192;
        this.pbeParams = null;
        this.f22949prf = PRF_SHA256;
        this.f22951salt = null;
        this.macAlgorithm = macAlgorithmIdentifierFinder.mo17383find(str);
        this.f22948keySize = i;
    }

    public JcePBMac1CalculatorBuilder setProvider(Provider provider) {
        this.f22947helper = new ProviderJcaJceHelper(provider);
        return this;
    }

    public JcePBMac1CalculatorBuilder(PBMAC1Params pBMAC1Params) {
        this.f22947helper = new DefaultJcaJceHelper();
        this.saltLength = -1;
        this.iterationCount = 8192;
        this.pbeParams = null;
        this.f22949prf = PRF_SHA256;
        this.f22951salt = null;
        this.macAlgorithm = pBMAC1Params.getMessageAuthScheme();
        this.pbeParams = PBKDF2Params.getInstance(pBMAC1Params.getKeyDerivationFunc().getParameters());
    }
}
