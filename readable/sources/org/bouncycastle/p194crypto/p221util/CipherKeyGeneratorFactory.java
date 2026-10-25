package org.bouncycastle.p194crypto.p221util;

import java.security.SecureRandom;
import org.bouncycastle.internal.p231asn1.p241kisa.KISAObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p244ntt.NTTObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.CipherKeyGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.generators.DESKeyGenerator;
import org.bouncycastle.p194crypto.generators.DESedeKeyGenerator;

/* loaded from: classes2.dex */
public class CipherKeyGeneratorFactory {
    private CipherKeyGeneratorFactory() {
    }

    private static CipherKeyGenerator createCipherKeyGenerator(SecureRandom secureRandom, int i) {
        CipherKeyGenerator cipherKeyGenerator = new CipherKeyGenerator();
        cipherKeyGenerator.mo14956init(new KeyGenerationParameters(secureRandom, i));
        return cipherKeyGenerator;
    }

    public static CipherKeyGenerator createKeyGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, SecureRandom secureRandom) {
        if (NISTObjectIdentifiers.id_aes128_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 128);
        }
        if (NISTObjectIdentifiers.id_aes192_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 192);
        }
        if (NISTObjectIdentifiers.id_aes256_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 256);
        }
        if (NISTObjectIdentifiers.id_aes128_GCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 128);
        }
        if (NISTObjectIdentifiers.id_aes192_GCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 192);
        }
        if (NISTObjectIdentifiers.id_aes256_GCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 256);
        }
        if (NISTObjectIdentifiers.id_aes128_CCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 128);
        }
        if (NISTObjectIdentifiers.id_aes192_CCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 192);
        }
        if (NISTObjectIdentifiers.id_aes256_CCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 256);
        }
        if (PKCSObjectIdentifiers.des_EDE3_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            DESedeKeyGenerator dESedeKeyGenerator = new DESedeKeyGenerator();
            dESedeKeyGenerator.mo14956init(new KeyGenerationParameters(secureRandom, 192));
            return dESedeKeyGenerator;
        }
        if (NTTObjectIdentifiers.id_camellia128_cbc.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 128);
        }
        if (NTTObjectIdentifiers.id_camellia192_cbc.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 192);
        }
        if (NTTObjectIdentifiers.id_camellia256_cbc.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return createCipherKeyGenerator(secureRandom, 256);
        }
        if (!KISAObjectIdentifiers.id_seedCBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !AlgorithmIdentifierFactory.CAST5_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            if (OIWObjectIdentifiers.f21277desCBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                DESKeyGenerator dESKeyGenerator = new DESKeyGenerator();
                dESKeyGenerator.mo14956init(new KeyGenerationParameters(secureRandom, 64));
                return dESKeyGenerator;
            }
            if (!PKCSObjectIdentifiers.f18510rc4.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !PKCSObjectIdentifiers.f18490RC2_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                throw new IllegalArgumentException("cannot recognise cipher: " + aSN1ObjectIdentifier);
            }
            return createCipherKeyGenerator(secureRandom, 128);
        }
        return createCipherKeyGenerator(secureRandom, 128);
    }
}
