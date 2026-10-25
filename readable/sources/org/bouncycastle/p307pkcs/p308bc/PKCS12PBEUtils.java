package org.bouncycastle.p307pkcs.p308bc;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PBMAC1Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p201engines.DESedeEngine;
import org.bouncycastle.p194crypto.p201engines.RC2Engine;
import org.bouncycastle.p194crypto.p206io.MacOutputStream;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p213params.DESParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.paddings.PKCS7Padding;
import org.bouncycastle.p194crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
class PKCS12PBEUtils {
    private static Map keySizes = new HashMap();
    private static Set noIvAlgs = new HashSet();

    /* renamed from: desAlgs */
    private static Set f22945desAlgs = new HashSet();

    static {
        Map map = keySizes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4;
        map.put(aSN1ObjectIdentifier, Integers.m18296valueOf(128));
        Map map2 = keySizes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4;
        map2.put(aSN1ObjectIdentifier2, Integers.m18296valueOf(40));
        Map map3 = keySizes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC;
        map3.put(aSN1ObjectIdentifier3, Integers.m18296valueOf(192));
        Map map4 = keySizes;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC;
        map4.put(aSN1ObjectIdentifier4, Integers.m18296valueOf(128));
        keySizes.put(PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC, Integers.m18296valueOf(128));
        keySizes.put(PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC, Integers.m18296valueOf(40));
        noIvAlgs.add(aSN1ObjectIdentifier);
        noIvAlgs.add(aSN1ObjectIdentifier2);
        f22945desAlgs.add(aSN1ObjectIdentifier4);
        f22945desAlgs.add(aSN1ObjectIdentifier3);
    }

    public static CipherParameters createCipherParameters(ASN1ObjectIdentifier aSN1ObjectIdentifier, ExtendedDigest extendedDigest, int i, PKCS12PBEParams pKCS12PBEParams, char[] cArr) {
        PKCS12ParametersGenerator pKCS12ParametersGenerator = new PKCS12ParametersGenerator(extendedDigest);
        pKCS12ParametersGenerator.m14982init(PBEParametersGenerator.PKCS12PasswordToBytes(cArr), pKCS12PBEParams.m14636getIV(), pKCS12PBEParams.getIterations().intValue());
        if (m17419hasNoIv(aSN1ObjectIdentifier)) {
            return pKCS12ParametersGenerator.generateDerivedParameters(getKeySize(aSN1ObjectIdentifier));
        }
        CipherParameters cipherParametersGenerateDerivedParameters = pKCS12ParametersGenerator.generateDerivedParameters(getKeySize(aSN1ObjectIdentifier), i * 8);
        if (isDesAlg(aSN1ObjectIdentifier)) {
            DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) cipherParametersGenerateDerivedParameters).getParameters()).m15773getKey());
        }
        return cipherParametersGenerateDerivedParameters;
    }

    public static MacCalculator createMacCalculator(final ASN1ObjectIdentifier aSN1ObjectIdentifier, ExtendedDigest extendedDigest, final PKCS12PBEParams pKCS12PBEParams, final char[] cArr) {
        PKCS12ParametersGenerator pKCS12ParametersGenerator = new PKCS12ParametersGenerator(extendedDigest);
        pKCS12ParametersGenerator.m14982init(PBEParametersGenerator.PKCS12PasswordToBytes(cArr), pKCS12PBEParams.m14636getIV(), pKCS12PBEParams.getIterations().intValue());
        KeyParameter keyParameter = (KeyParameter) pKCS12ParametersGenerator.generateDerivedMacParameters(extendedDigest.getDigestSize() * 8);
        final C5360HMac c5360HMac = new C5360HMac(extendedDigest);
        c5360HMac.mo14976init(keyParameter);
        return new MacCalculator() { // from class: org.bouncycastle.pkcs.bc.PKCS12PBEUtils.1
            @Override // org.bouncycastle.operator.MacCalculator
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return new AlgorithmIdentifier(aSN1ObjectIdentifier, pKCS12PBEParams);
            }

            @Override // org.bouncycastle.operator.MacCalculator
            /* renamed from: getKey */
            public GenericKey mo14789getKey() {
                return new GenericKey(getAlgorithmIdentifier(), PBEParametersGenerator.PKCS12PasswordToBytes(cArr));
            }

            @Override // org.bouncycastle.operator.MacCalculator
            /* renamed from: getMac */
            public byte[] mo14790getMac() {
                byte[] bArr = new byte[c5360HMac.getMacSize()];
                c5360HMac.mo14975doFinal(bArr, 0);
                return bArr;
            }

            @Override // org.bouncycastle.operator.MacCalculator
            public OutputStream getOutputStream() {
                return new MacOutputStream(c5360HMac);
            }
        };
    }

    public static MacCalculator createPBMac1Calculator(final PBMAC1Params pBMAC1Params, PBKDF2Params pBKDF2Params, final char[] cArr) {
        final C5360HMac c5360HMac = new C5360HMac(m17418getPrf(pBMAC1Params.getMessageAuthScheme().getAlgorithm()));
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(m17418getPrf(pBKDF2Params.m14634getPrf().getAlgorithm()));
        pKCS5S2ParametersGenerator.m14982init(C6250Strings.toUTF8ByteArray(cArr), pBKDF2Params.m14635getSalt(), BigIntegers.intValueExact(pBKDF2Params.getIterationCount()));
        c5360HMac.mo14976init(pKCS5S2ParametersGenerator.generateDerivedParameters(BigIntegers.intValueExact(pBKDF2Params.getKeyLength()) * 8));
        return new MacCalculator() { // from class: org.bouncycastle.pkcs.bc.PKCS12PBEUtils.2
            @Override // org.bouncycastle.operator.MacCalculator
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBMAC1, pBMAC1Params);
            }

            @Override // org.bouncycastle.operator.MacCalculator
            /* renamed from: getKey */
            public GenericKey mo14789getKey() {
                return new GenericKey(getAlgorithmIdentifier(), C6250Strings.toUTF8ByteArray(cArr));
            }

            @Override // org.bouncycastle.operator.MacCalculator
            /* renamed from: getMac */
            public byte[] mo14790getMac() {
                byte[] bArr = new byte[c5360HMac.getMacSize()];
                c5360HMac.mo14975doFinal(bArr, 0);
                return bArr;
            }

            @Override // org.bouncycastle.operator.MacCalculator
            public OutputStream getOutputStream() {
                return new MacOutputStream(c5360HMac);
            }
        };
    }

    public static PaddedBufferedBlockCipher getEngine(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        BlockCipher dESedeEngine;
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC) || aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC)) {
            dESedeEngine = new DESedeEngine();
        } else {
            if (!aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC) && !aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC)) {
                throw new IllegalStateException("unknown algorithm");
            }
            dESedeEngine = new RC2Engine();
        }
        return new PaddedBufferedBlockCipher(new CBCBlockCipher(dESedeEngine), new PKCS7Padding());
    }

    public static int getKeySize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return ((Integer) keySizes.get(aSN1ObjectIdentifier)).intValue();
    }

    /* renamed from: getPrf */
    private static InterfaceC5277Digest m17418getPrf(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (PKCSObjectIdentifiers.id_hmacWithSHA256.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return new SHA256Digest();
        }
        if (PKCSObjectIdentifiers.id_hmacWithSHA512.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return new SHA512Digest();
        }
        throw new IllegalArgumentException("unknown prf id " + aSN1ObjectIdentifier);
    }

    /* renamed from: hasNoIv */
    public static boolean m17419hasNoIv(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return noIvAlgs.contains(aSN1ObjectIdentifier);
    }

    public static boolean isDesAlg(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return f22945desAlgs.contains(aSN1ObjectIdentifier);
    }
}
