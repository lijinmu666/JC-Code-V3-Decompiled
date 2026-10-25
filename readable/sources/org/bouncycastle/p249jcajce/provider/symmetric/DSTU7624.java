package org.bouncycastle.p249jcajce.provider.symmetric;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p170ua.UAObjectIdentifiers;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p201engines.DSTU7624Engine;
import org.bouncycastle.p194crypto.p201engines.DSTU7624WrapEngine;
import org.bouncycastle.p194crypto.p209macs.C5361KGMac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p210modes.CFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.KCCMBlockCipher;
import org.bouncycastle.p194crypto.p210modes.KCTRBlockCipher;
import org.bouncycastle.p194crypto.p210modes.KGCMBlockCipher;
import org.bouncycastle.p194crypto.p210modes.OFBBlockCipher;
import org.bouncycastle.p249jcajce.provider.p266config.ConfigurableProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseAlgorithmParameterGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseBlockCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseKeyGenerator;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.C5789BaseMac;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters;

/* loaded from: classes2.dex */
public class DSTU7624 {

    public static class AlgParamGen extends BaseAlgorithmParameterGenerator {
        private final int ivLength;

        public AlgParamGen(int i) {
            this.ivLength = i / 8;
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public AlgorithmParameters engineGenerateParameters() throws InvalidParameterSpecException {
            byte[] bArr = new byte[this.ivLength];
            if (this.f21853random == null) {
                this.f21853random = CryptoServicesRegistrar.getSecureRandom();
            }
            this.f21853random.nextBytes(bArr);
            try {
                AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance("DSTU7624");
                algorithmParametersCreateParametersInstance.init(new IvParameterSpec(bArr));
                return algorithmParametersCreateParametersInstance;
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        @Override // java.security.AlgorithmParameterGeneratorSpi
        public void engineInit(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
            throw new InvalidAlgorithmParameterException("No supported AlgorithmParameterSpec for DSTU7624 parameter generation.");
        }
    }

    public static class AlgParamGen128 extends AlgParamGen {
        public AlgParamGen128() {
            super(128);
        }
    }

    public static class AlgParamGen256 extends AlgParamGen {
        public AlgParamGen256() {
            super(256);
        }
    }

    public static class AlgParamGen512 extends AlgParamGen {
        public AlgParamGen512() {
            super(512);
        }
    }

    public static class AlgParams extends IvAlgorithmParameters {
        @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.IvAlgorithmParameters, java.security.AlgorithmParametersSpi
        public String engineToString() {
            return "DSTU7624 IV";
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CBC128 */
    public static class C5700CBC128 extends BaseBlockCipher {
        public C5700CBC128() {
            super(new CBCBlockCipher(new DSTU7624Engine(128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CBC256 */
    public static class C5701CBC256 extends BaseBlockCipher {
        public C5701CBC256() {
            super(new CBCBlockCipher(new DSTU7624Engine(256)), 256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CBC512 */
    public static class C5702CBC512 extends BaseBlockCipher {
        public C5702CBC512() {
            super(new CBCBlockCipher(new DSTU7624Engine(512)), 512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CCM128 */
    public static class C5703CCM128 extends BaseBlockCipher {
        public C5703CCM128() {
            super(new KCCMBlockCipher(new DSTU7624Engine(128)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CCM256 */
    public static class C5704CCM256 extends BaseBlockCipher {
        public C5704CCM256() {
            super(new KCCMBlockCipher(new DSTU7624Engine(256)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CCM512 */
    public static class C5705CCM512 extends BaseBlockCipher {
        public C5705CCM512() {
            super(new KCCMBlockCipher(new DSTU7624Engine(512)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CFB128 */
    public static class C5706CFB128 extends BaseBlockCipher {
        public C5706CFB128() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new DSTU7624Engine(128), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CFB256 */
    public static class C5707CFB256 extends BaseBlockCipher {
        public C5707CFB256() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new DSTU7624Engine(256), 256)), 256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CFB512 */
    public static class C5708CFB512 extends BaseBlockCipher {
        public C5708CFB512() {
            super(new BufferedBlockCipher(new CFBBlockCipher(new DSTU7624Engine(512), 512)), 512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CTR128 */
    public static class C5709CTR128 extends BaseBlockCipher {
        public C5709CTR128() {
            super(new BufferedBlockCipher(new KCTRBlockCipher(new DSTU7624Engine(128))), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CTR256 */
    public static class C5710CTR256 extends BaseBlockCipher {
        public C5710CTR256() {
            super(new BufferedBlockCipher(new KCTRBlockCipher(new DSTU7624Engine(256))), 256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$CTR512 */
    public static class C5711CTR512 extends BaseBlockCipher {
        public C5711CTR512() {
            super(new BufferedBlockCipher(new KCTRBlockCipher(new DSTU7624Engine(512))), 512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB */
    public static class C5712ECB extends BaseBlockCipher {
        public C5712ECB() {
            super(new BlockCipherProvider() { // from class: org.bouncycastle.jcajce.provider.symmetric.DSTU7624.ECB.1
                @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BlockCipherProvider
                /* renamed from: get */
                public BlockCipher mo16172get() {
                    return new DSTU7624Engine(128);
                }
            });
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB128 */
    public static class C5713ECB128 extends BaseBlockCipher {
        public C5713ECB128() {
            super(new DSTU7624Engine(128));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB256 */
    public static class C5714ECB256 extends BaseBlockCipher {
        public C5714ECB256() {
            super(new DSTU7624Engine(256));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB512 */
    public static class C5715ECB512 extends BaseBlockCipher {
        public C5715ECB512() {
            super(new DSTU7624Engine(512));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB_128 */
    public static class C5716ECB_128 extends BaseBlockCipher {
        public C5716ECB_128() {
            super(new DSTU7624Engine(128));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB_256 */
    public static class C5717ECB_256 extends BaseBlockCipher {
        public C5717ECB_256() {
            super(new DSTU7624Engine(256));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$ECB_512 */
    public static class C5718ECB_512 extends BaseBlockCipher {
        public C5718ECB_512() {
            super(new DSTU7624Engine(512));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GCM128 */
    public static class C5719GCM128 extends BaseBlockCipher {
        public C5719GCM128() {
            super(new KGCMBlockCipher(new DSTU7624Engine(128)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GCM256 */
    public static class C5720GCM256 extends BaseBlockCipher {
        public C5720GCM256() {
            super(new KGCMBlockCipher(new DSTU7624Engine(256)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GCM512 */
    public static class C5721GCM512 extends BaseBlockCipher {
        public C5721GCM512() {
            super(new KGCMBlockCipher(new DSTU7624Engine(512)));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GMAC */
    public static class C5722GMAC extends C5789BaseMac {
        public C5722GMAC() {
            super(new C5361KGMac(new KGCMBlockCipher(new DSTU7624Engine(128)), 128));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GMAC128 */
    public static class C5723GMAC128 extends C5789BaseMac {
        public C5723GMAC128() {
            super(new C5361KGMac(new KGCMBlockCipher(new DSTU7624Engine(128)), 128));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GMAC256 */
    public static class C5724GMAC256 extends C5789BaseMac {
        public C5724GMAC256() {
            super(new C5361KGMac(new KGCMBlockCipher(new DSTU7624Engine(256)), 256));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$GMAC512 */
    public static class C5725GMAC512 extends C5789BaseMac {
        public C5725GMAC512() {
            super(new C5361KGMac(new KGCMBlockCipher(new DSTU7624Engine(512)), 512));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$KeyGen */
    public static class C5726KeyGen extends BaseKeyGenerator {
        public C5726KeyGen() {
            this(256);
        }

        public C5726KeyGen(int i) {
            super("DSTU7624", i, new CipherKeyGenerator());
        }
    }

    public static class KeyGen128 extends C5726KeyGen {
        public KeyGen128() {
            super(128);
        }
    }

    public static class KeyGen256 extends C5726KeyGen {
        public KeyGen256() {
            super(256);
        }
    }

    public static class KeyGen512 extends C5726KeyGen {
        public KeyGen512() {
            super(512);
        }
    }

    public static class Mappings extends SymmetricAlgorithmProvider {

        /* renamed from: PREFIX */
        private static final String f21789PREFIX = DSTU7624.class.getName();

        @Override // org.bouncycastle.p249jcajce.provider.p278util.AlgorithmProvider
        public void configure(ConfigurableProvider configurableProvider) {
            StringBuilder sb = new StringBuilder();
            String str = f21789PREFIX;
            sb.append(str);
            sb.append("$AlgParams");
            configurableProvider.addAlgorithm("AlgorithmParameters.DSTU7624", sb.toString());
            ASN1ObjectIdentifier aSN1ObjectIdentifier = UAObjectIdentifiers.dstu7624cbc_128;
            configurableProvider.addAlgorithm("AlgorithmParameters", aSN1ObjectIdentifier, str + "$AlgParams");
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = UAObjectIdentifiers.dstu7624cbc_256;
            configurableProvider.addAlgorithm("AlgorithmParameters", aSN1ObjectIdentifier2, str + "$AlgParams");
            ASN1ObjectIdentifier aSN1ObjectIdentifier3 = UAObjectIdentifiers.dstu7624cbc_512;
            configurableProvider.addAlgorithm("AlgorithmParameters", aSN1ObjectIdentifier3, str + "$AlgParams");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator.DSTU7624", str + "$AlgParamGen128");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator", aSN1ObjectIdentifier, str + "$AlgParamGen128");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator", aSN1ObjectIdentifier2, str + "$AlgParamGen256");
            configurableProvider.addAlgorithm("AlgorithmParameterGenerator", aSN1ObjectIdentifier3, str + "$AlgParamGen512");
            configurableProvider.addAlgorithm("Cipher.DSTU7624", str + "$ECB_128");
            configurableProvider.addAlgorithm("Cipher.DSTU7624-128", str + "$ECB_128");
            configurableProvider.addAlgorithm("Cipher.DSTU7624-256", str + "$ECB_256");
            configurableProvider.addAlgorithm("Cipher.DSTU7624-512", str + "$ECB_512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier4 = UAObjectIdentifiers.dstu7624ecb_128;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier4, str + "$ECB128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier5 = UAObjectIdentifiers.dstu7624ecb_256;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier5, str + "$ECB256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier6 = UAObjectIdentifiers.dstu7624ecb_512;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier6, str + "$ECB512");
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier, str + "$CBC128");
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier2, str + "$CBC256");
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier3, str + "$CBC512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier7 = UAObjectIdentifiers.dstu7624ofb_128;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier7, str + "$OFB128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier8 = UAObjectIdentifiers.dstu7624ofb_256;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier8, str + "$OFB256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier9 = UAObjectIdentifiers.dstu7624ofb_512;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier9, str + "$OFB512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier10 = UAObjectIdentifiers.dstu7624cfb_128;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier10, str + "$CFB128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier11 = UAObjectIdentifiers.dstu7624cfb_256;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier11, str + "$CFB256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier12 = UAObjectIdentifiers.dstu7624cfb_512;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier12, str + "$CFB512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier13 = UAObjectIdentifiers.dstu7624ctr_128;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier13, str + "$CTR128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier14 = UAObjectIdentifiers.dstu7624ctr_256;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier14, str + "$CTR256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier15 = UAObjectIdentifiers.dstu7624ctr_512;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier15, str + "$CTR512");
            ASN1ObjectIdentifier aSN1ObjectIdentifier16 = UAObjectIdentifiers.dstu7624ccm_128;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier16, str + "$CCM128");
            ASN1ObjectIdentifier aSN1ObjectIdentifier17 = UAObjectIdentifiers.dstu7624ccm_256;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier17, str + "$CCM256");
            ASN1ObjectIdentifier aSN1ObjectIdentifier18 = UAObjectIdentifiers.dstu7624ccm_512;
            configurableProvider.addAlgorithm("Cipher", aSN1ObjectIdentifier18, str + "$CCM512");
            configurableProvider.addAlgorithm("Cipher.DSTU7624KW", str + "$Wrap");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.DSTU7624WRAP", "DSTU7624KW");
            configurableProvider.addAlgorithm("Cipher.DSTU7624-128KW", str + "$Wrap128");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier19 = UAObjectIdentifiers.dstu7624kw_128;
            sb2.append(aSN1ObjectIdentifier19.m14433getId());
            configurableProvider.addAlgorithm(sb2.toString(), "DSTU7624-128KW");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.DSTU7624-128WRAP", "DSTU7624-128KW");
            configurableProvider.addAlgorithm("Cipher.DSTU7624-256KW", str + "$Wrap256");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier20 = UAObjectIdentifiers.dstu7624kw_256;
            sb3.append(aSN1ObjectIdentifier20.m14433getId());
            configurableProvider.addAlgorithm(sb3.toString(), "DSTU7624-256KW");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.DSTU7624-256WRAP", "DSTU7624-256KW");
            configurableProvider.addAlgorithm("Cipher.DSTU7624-512KW", str + "$Wrap512");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Alg.Alias.Cipher.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier21 = UAObjectIdentifiers.dstu7624kw_512;
            sb4.append(aSN1ObjectIdentifier21.m14433getId());
            configurableProvider.addAlgorithm(sb4.toString(), "DSTU7624-512KW");
            configurableProvider.addAlgorithm("Alg.Alias.Cipher.DSTU7624-512WRAP", "DSTU7624-512KW");
            configurableProvider.addAlgorithm("Mac.DSTU7624GMAC", str + "$GMAC");
            configurableProvider.addAlgorithm("Mac.DSTU7624-128GMAC", str + "$GMAC128");
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Alg.Alias.Mac.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier22 = UAObjectIdentifiers.dstu7624gmac_128;
            sb5.append(aSN1ObjectIdentifier22.m14433getId());
            configurableProvider.addAlgorithm(sb5.toString(), "DSTU7624-128GMAC");
            configurableProvider.addAlgorithm("Mac.DSTU7624-256GMAC", str + "$GMAC256");
            StringBuilder sb6 = new StringBuilder();
            sb6.append("Alg.Alias.Mac.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier23 = UAObjectIdentifiers.dstu7624gmac_256;
            sb6.append(aSN1ObjectIdentifier23.m14433getId());
            configurableProvider.addAlgorithm(sb6.toString(), "DSTU7624-256GMAC");
            configurableProvider.addAlgorithm("Mac.DSTU7624-512GMAC", str + "$GMAC512");
            StringBuilder sb7 = new StringBuilder();
            sb7.append("Alg.Alias.Mac.");
            ASN1ObjectIdentifier aSN1ObjectIdentifier24 = UAObjectIdentifiers.dstu7624gmac_512;
            sb7.append(aSN1ObjectIdentifier24.m14433getId());
            configurableProvider.addAlgorithm(sb7.toString(), "DSTU7624-512GMAC");
            configurableProvider.addAlgorithm("KeyGenerator.DSTU7624", str + "$KeyGen");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier19, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier20, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier21, str + "$KeyGen512");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier4, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier5, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier6, str + "$KeyGen512");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier2, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier3, str + "$KeyGen512");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier7, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier8, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier9, str + "$KeyGen512");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier10, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier11, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier12, str + "$KeyGen512");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier13, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier14, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier15, str + "$KeyGen512");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier16, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier17, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier18, str + "$KeyGen512");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier22, str + "$KeyGen128");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier23, str + "$KeyGen256");
            configurableProvider.addAlgorithm("KeyGenerator", aSN1ObjectIdentifier24, str + "$KeyGen512");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$OFB128 */
    public static class C5727OFB128 extends BaseBlockCipher {
        public C5727OFB128() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new DSTU7624Engine(128), 128)), 128);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$OFB256 */
    public static class C5728OFB256 extends BaseBlockCipher {
        public C5728OFB256() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new DSTU7624Engine(256), 256)), 256);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$OFB512 */
    public static class C5729OFB512 extends BaseBlockCipher {
        public C5729OFB512() {
            super(new BufferedBlockCipher(new OFBBlockCipher(new DSTU7624Engine(512), 512)), 512);
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$Wrap */
    public static class C5730Wrap extends BaseWrapCipher {
        public C5730Wrap() {
            super(new DSTU7624WrapEngine(128));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$Wrap128 */
    public static class C5731Wrap128 extends BaseWrapCipher {
        public C5731Wrap128() {
            super(new DSTU7624WrapEngine(128));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$Wrap256 */
    public static class C5732Wrap256 extends BaseWrapCipher {
        public C5732Wrap256() {
            super(new DSTU7624WrapEngine(256));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.DSTU7624$Wrap512 */
    public static class C5733Wrap512 extends BaseWrapCipher {
        public C5733Wrap512() {
            super(new DSTU7624WrapEngine(512));
        }
    }

    private DSTU7624() {
    }
}
