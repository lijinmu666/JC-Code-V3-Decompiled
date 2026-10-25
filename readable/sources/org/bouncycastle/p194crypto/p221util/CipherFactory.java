package org.bouncycastle.p194crypto.p221util;

import java.io.OutputStream;
import org.bouncycastle.internal.p231asn1.p233cms.CCMParameters;
import org.bouncycastle.internal.p231asn1.p233cms.GCMParameters;
import org.bouncycastle.internal.p231asn1.p241kisa.KISAObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p242misc.CAST5CBCParameters;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p244ntt.NTTObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.RC2CBCParameter;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p201engines.CAST5Engine;
import org.bouncycastle.p194crypto.p201engines.DESEngine;
import org.bouncycastle.p194crypto.p201engines.DESedeEngine;
import org.bouncycastle.p194crypto.p201engines.RC2Engine;
import org.bouncycastle.p194crypto.p201engines.RC4Engine;
import org.bouncycastle.p194crypto.p206io.CipherOutputStream;
import org.bouncycastle.p194crypto.p210modes.AEADBlockCipher;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p210modes.CCMBlockCipher;
import org.bouncycastle.p194crypto.p210modes.GCMBlockCipher;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.RC2Parameters;
import org.bouncycastle.p194crypto.paddings.PKCS7Padding;
import org.bouncycastle.p194crypto.paddings.PaddedBufferedBlockCipher;

/* loaded from: classes2.dex */
public class CipherFactory {

    /* renamed from: rc2Ekb */
    private static final short[] f21112rc2Ekb = {93, 190, 155, 139, 17, 153, 110, 77, 89, 243, 133, 166, 63, 183, 131, 197, 228, 115, 107, 58, 104, 90, 192, 71, 160, 100, 52, 12, 241, 208, 82, 165, 185, 30, 150, 67, 65, 216, 212, 44, 219, 248, 7, 119, 42, 202, 235, 239, 16, 28, 22, 13, 56, 114, 47, 137, 193, 249, 128, 196, 109, 174, 48, 61, 206, 32, 99, 254, 230, 26, 199, 184, 80, 232, 36, 23, 252, 37, 111, 187, 106, 163, 68, 83, 217, 162, 1, 171, 188, 182, 31, 152, 238, 154, 167, 45, 79, 158, 142, 172, 224, 198, 73, 70, 41, 244, 148, 138, 175, 225, 91, 195, 179, 123, 87, 209, 124, 156, 237, 135, 64, 140, 226, 203, 147, 20, 201, 97, 46, 229, 204, 246, 94, 168, 92, 214, 117, 141, 98, 149, 88, 105, 118, 161, 74, 181, 85, 9, 120, 51, 130, 215, 221, 121, 245, 27, 11, 222, 38, 33, 40, 116, 4, 151, 86, 223, 60, 240, 55, 57, 220, 255, 6, 164, 234, 66, 8, 218, 180, 113, 176, 207, 18, 122, 78, 250, 108, 29, 132, 0, 200, 127, 145, 69, 170, 43, 194, 177, 143, 213, 186, 242, 173, 25, 178, 103, 54, 247, 15, 10, 146, 125, 227, 157, 233, 144, 62, 35, 39, 102, 19, 236, 129, 21, 189, 34, 191, 159, 126, 169, 81, 75, 76, 251, 2, 211, 112, 134, 49, 231, 59, 5, 3, 84, 96, 72, 101, 24, 210, 205, 95, 50, 136, 14, 53, 253};

    private static AEADBlockCipher createAEADCipher(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (NISTObjectIdentifiers.id_aes128_GCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || NISTObjectIdentifiers.id_aes192_GCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || NISTObjectIdentifiers.id_aes256_GCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return GCMBlockCipher.newInstance(AESEngine.newInstance());
        }
        if (NISTObjectIdentifiers.id_aes128_CCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || NISTObjectIdentifiers.id_aes192_CCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || NISTObjectIdentifiers.id_aes256_CCM.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return CCMBlockCipher.newInstance(AESEngine.newInstance());
        }
        throw new IllegalArgumentException("cannot recognise cipher: " + aSN1ObjectIdentifier);
    }

    private static BufferedBlockCipher createCipher(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        BlockCipher blockCipherNewInstance;
        if (NISTObjectIdentifiers.id_aes128_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || NISTObjectIdentifiers.id_aes192_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) || NISTObjectIdentifiers.id_aes256_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            blockCipherNewInstance = AESEngine.newInstance();
        } else if (PKCSObjectIdentifiers.des_EDE3_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            blockCipherNewInstance = new DESedeEngine();
        } else if (OIWObjectIdentifiers.f21277desCBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            blockCipherNewInstance = new DESEngine();
        } else if (PKCSObjectIdentifiers.f18490RC2_CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            blockCipherNewInstance = new RC2Engine();
        } else {
            if (!MiscObjectIdentifiers.cast5CBC.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                throw new IllegalArgumentException("cannot recognise cipher: " + aSN1ObjectIdentifier);
            }
            blockCipherNewInstance = new CAST5Engine();
        }
        return new PaddedBufferedBlockCipher(CBCBlockCipher.newInstance(blockCipherNewInstance), new PKCS7Padding());
    }

    public static Object createContentCipher(boolean z, CipherParameters cipherParameters, AlgorithmIdentifier algorithmIdentifier) {
        AEADBlockCipher aEADBlockCipherCreateAEADCipher;
        AEADParameters aEADParameters;
        ParametersWithIV parametersWithIV;
        ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
        if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18510rc4)) {
            RC4Engine rC4Engine = new RC4Engine();
            rC4Engine.mo14993init(z, cipherParameters);
            return rC4Engine;
        }
        if (algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes128_GCM) || algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes192_GCM) || algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_GCM)) {
            aEADBlockCipherCreateAEADCipher = createAEADCipher(algorithmIdentifier.getAlgorithm());
            GCMParameters gCMParameters = GCMParameters.getInstance(algorithmIdentifier.getParameters());
            if (!(cipherParameters instanceof KeyParameter)) {
                throw new IllegalArgumentException("key data must be accessible for GCM operation");
            }
            aEADParameters = new AEADParameters((KeyParameter) cipherParameters, gCMParameters.getIcvLen() * 8, gCMParameters.getNonce());
        } else {
            if (!algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes128_CCM) && !algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes192_CCM) && !algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_CCM)) {
                BufferedBlockCipher bufferedBlockCipherCreateCipher = createCipher(algorithmIdentifier.getAlgorithm());
                ASN1Primitive aSN1Primitive = algorithmIdentifier.getParameters().toASN1Primitive();
                if (aSN1Primitive != null && !(aSN1Primitive instanceof ASN1Null)) {
                    if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.des_EDE3_CBC) || algorithm.m14446equals((ASN1Primitive) AlgorithmIdentifierFactory.IDEA_CBC) || algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes128_CBC) || algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes192_CBC) || algorithm.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_CBC) || algorithm.m14446equals((ASN1Primitive) NTTObjectIdentifiers.id_camellia128_cbc) || algorithm.m14446equals((ASN1Primitive) NTTObjectIdentifiers.id_camellia192_cbc) || algorithm.m14446equals((ASN1Primitive) NTTObjectIdentifiers.id_camellia256_cbc) || algorithm.m14446equals((ASN1Primitive) KISAObjectIdentifiers.id_seedCBC) || algorithm.m14446equals((ASN1Primitive) OIWObjectIdentifiers.f21277desCBC)) {
                        parametersWithIV = new ParametersWithIV(cipherParameters, ASN1OctetString.getInstance(aSN1Primitive).getOctets());
                    } else if (algorithm.m14446equals((ASN1Primitive) AlgorithmIdentifierFactory.CAST5_CBC)) {
                        parametersWithIV = new ParametersWithIV(cipherParameters, CAST5CBCParameters.getInstance(aSN1Primitive).m15987getIV());
                    } else {
                        if (!algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.f18490RC2_CBC)) {
                            throw new IllegalArgumentException("cannot match parameters");
                        }
                        RC2CBCParameter rC2CBCParameter = RC2CBCParameter.getInstance(aSN1Primitive);
                        cipherParameters = new ParametersWithIV(new RC2Parameters(((KeyParameter) cipherParameters).m15773getKey(), getRC2EffectiveKeyBits(rC2CBCParameter)), rC2CBCParameter.m14637getIV());
                        bufferedBlockCipherCreateCipher.mo14952init(z, cipherParameters);
                    }
                    bufferedBlockCipherCreateCipher.mo14952init(z, parametersWithIV);
                } else if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.des_EDE3_CBC) || algorithm.m14446equals((ASN1Primitive) AlgorithmIdentifierFactory.IDEA_CBC) || algorithm.m14446equals((ASN1Primitive) AlgorithmIdentifierFactory.CAST5_CBC)) {
                    bufferedBlockCipherCreateCipher.mo14952init(z, new ParametersWithIV(cipherParameters, new byte[8]));
                } else {
                    bufferedBlockCipherCreateCipher.mo14952init(z, cipherParameters);
                }
                return bufferedBlockCipherCreateCipher;
            }
            aEADBlockCipherCreateAEADCipher = createAEADCipher(algorithmIdentifier.getAlgorithm());
            CCMParameters cCMParameters = CCMParameters.getInstance(algorithmIdentifier.getParameters());
            if (!(cipherParameters instanceof KeyParameter)) {
                throw new IllegalArgumentException("key data must be accessible for CCM operation");
            }
            aEADParameters = new AEADParameters((KeyParameter) cipherParameters, cCMParameters.getIcvLen() * 8, cCMParameters.getNonce());
        }
        aEADBlockCipherCreateAEADCipher.mo15226init(z, aEADParameters);
        return aEADBlockCipherCreateAEADCipher;
    }

    public static CipherOutputStream createOutputStream(OutputStream outputStream, Object obj) {
        if (obj instanceof BufferedBlockCipher) {
            return new CipherOutputStream(outputStream, (BufferedBlockCipher) obj);
        }
        if (obj instanceof StreamCipher) {
            return new CipherOutputStream(outputStream, (StreamCipher) obj);
        }
        if (obj instanceof AEADBlockCipher) {
            return new CipherOutputStream(outputStream, (AEADBlockCipher) obj);
        }
        throw new IllegalArgumentException("unknown cipher object: " + obj);
    }

    private static int getRC2EffectiveKeyBits(RC2CBCParameter rC2CBCParameter) {
        ASN1Integer rC2ParameterVersionData = rC2CBCParameter.getRC2ParameterVersionData();
        if (rC2ParameterVersionData == null) {
            return 32;
        }
        int iIntPositiveValueExact = rC2ParameterVersionData.intPositiveValueExact();
        return iIntPositiveValueExact >= 256 ? iIntPositiveValueExact : f21112rc2Ekb[iIntPositiveValueExact] & 65535;
    }
}
