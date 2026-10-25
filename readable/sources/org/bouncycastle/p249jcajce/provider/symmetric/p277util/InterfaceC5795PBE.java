package org.bouncycastle.p249jcajce.provider.symmetric.p277util;

import java.security.InvalidAlgorithmParameterException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.SecretKey;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.generators.OpenSSLPBEParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.GOST3411Digest;
import org.bouncycastle.p194crypto.p199digests.MD2Digest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD160Digest;
import org.bouncycastle.p194crypto.p199digests.SM3Digest;
import org.bouncycastle.p194crypto.p199digests.TigerDigest;
import org.bouncycastle.p194crypto.p213params.DESParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p221util.DigestFactory;

/* renamed from: org.bouncycastle.jcajce.provider.symmetric.util.PBE */
/* loaded from: classes2.dex */
public interface InterfaceC5795PBE {
    public static final int GOST3411 = 6;

    /* renamed from: MD2 */
    public static final int f21886MD2 = 5;

    /* renamed from: MD5 */
    public static final int f21887MD5 = 0;

    /* renamed from: OPENSSL */
    public static final int f21888OPENSSL = 3;

    /* renamed from: PKCS12 */
    public static final int f21889PKCS12 = 2;

    /* renamed from: PKCS5S1 */
    public static final int f21890PKCS5S1 = 0;
    public static final int PKCS5S1_UTF8 = 4;

    /* renamed from: PKCS5S2 */
    public static final int f21891PKCS5S2 = 1;
    public static final int PKCS5S2_UTF8 = 5;
    public static final int RIPEMD160 = 2;

    /* renamed from: SHA1 */
    public static final int f21892SHA1 = 1;

    /* renamed from: SHA224 */
    public static final int f21893SHA224 = 7;

    /* renamed from: SHA256 */
    public static final int f21894SHA256 = 4;

    /* renamed from: SHA384 */
    public static final int f21895SHA384 = 8;
    public static final int SHA3_224 = 10;
    public static final int SHA3_256 = 11;
    public static final int SHA3_384 = 12;
    public static final int SHA3_512 = 13;

    /* renamed from: SHA512 */
    public static final int f21896SHA512 = 9;
    public static final int SHA512_224 = 15;
    public static final int SHA512_256 = 16;

    /* renamed from: SM3 */
    public static final int f21897SM3 = 14;

    /* renamed from: TIGER */
    public static final int f21898TIGER = 3;

    /* renamed from: org.bouncycastle.jcajce.provider.symmetric.util.PBE$Util */
    public static class Util {
        private static byte[] convertPassword(int i, PBEKeySpec pBEKeySpec) {
            return i == 2 ? PBEParametersGenerator.PKCS12PasswordToBytes(pBEKeySpec.getPassword()) : (i == 5 || i == 4) ? PBEParametersGenerator.PKCS5PasswordToUTF8Bytes(pBEKeySpec.getPassword()) : PBEParametersGenerator.PKCS5PasswordToBytes(pBEKeySpec.getPassword());
        }

        private static PBEParametersGenerator makePBEGenerator(int i, int i2) {
            if (i == 0 || i == 4) {
                if (i2 == 0) {
                    return new PKCS5S1ParametersGenerator(DigestFactory.createMD5());
                }
                if (i2 == 1) {
                    return new PKCS5S1ParametersGenerator(DigestFactory.createSHA1());
                }
                if (i2 == 5) {
                    return new PKCS5S1ParametersGenerator(new MD2Digest());
                }
                throw new IllegalStateException("PKCS5 scheme 1 only supports MD2, MD5 and SHA1.");
            }
            if (i != 1 && i != 5) {
                if (i != 2) {
                    return new OpenSSLPBEParametersGenerator();
                }
                switch (i2) {
                    case 0:
                        return new PKCS12ParametersGenerator(DigestFactory.createMD5PRF());
                    case 1:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA1PRF());
                    case 2:
                        return new PKCS12ParametersGenerator(new RIPEMD160Digest(CryptoServicePurpose.PRF));
                    case 3:
                        return new PKCS12ParametersGenerator(new TigerDigest(CryptoServicePurpose.PRF));
                    case 4:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA256PRF());
                    case 5:
                        return new PKCS12ParametersGenerator(new MD2Digest(CryptoServicePurpose.PRF));
                    case 6:
                        return new PKCS12ParametersGenerator(new GOST3411Digest(CryptoServicePurpose.PRF));
                    case 7:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA224PRF());
                    case 8:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA384PRF());
                    case 9:
                        return new PKCS12ParametersGenerator(DigestFactory.createSHA512PRF());
                    default:
                        throw new IllegalStateException("unknown digest scheme for PBE encryption.");
                }
            }
            switch (i2) {
                case 0:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createMD5PRF());
                case 1:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA1PRF());
                case 2:
                    return new PKCS5S2ParametersGenerator(new RIPEMD160Digest(CryptoServicePurpose.PRF));
                case 3:
                    return new PKCS5S2ParametersGenerator(new TigerDigest(CryptoServicePurpose.PRF));
                case 4:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA256PRF());
                case 5:
                    return new PKCS5S2ParametersGenerator(new MD2Digest(CryptoServicePurpose.PRF));
                case 6:
                    return new PKCS5S2ParametersGenerator(new GOST3411Digest(CryptoServicePurpose.PRF));
                case 7:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA224PRF());
                case 8:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA384PRF());
                case 9:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA512PRF());
                case 10:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_224PRF());
                case 11:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_256PRF());
                case 12:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_384PRF());
                case 13:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA3_512PRF());
                case 14:
                    return new PKCS5S2ParametersGenerator(new SM3Digest(CryptoServicePurpose.PRF));
                case 15:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA512_224PRF());
                case 16:
                    return new PKCS5S2ParametersGenerator(DigestFactory.createSHA512_256PRF());
                default:
                    throw new IllegalStateException("unknown digest scheme for PBE PKCS5S2 encryption.");
            }
        }

        public static CipherParameters makePBEMacParameters(SecretKey secretKey, int i, int i2, int i3, PBEParameterSpec pBEParameterSpec) {
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(i, i2);
            byte[] encoded = secretKey.getEncoded();
            pBEParametersGeneratorMakePBEGenerator.m14982init(secretKey.getEncoded(), pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedMacParameters = pBEParametersGeneratorMakePBEGenerator.generateDerivedMacParameters(i3);
            for (int i4 = 0; i4 != encoded.length; i4++) {
                encoded[i4] = 0;
            }
            return cipherParametersGenerateDerivedMacParameters;
        }

        public static CipherParameters makePBEParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3, int i4) {
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(i, i2);
            byte[] bArrConvertPassword = convertPassword(i, pBEKeySpec);
            pBEParametersGeneratorMakePBEGenerator.m14982init(bArrConvertPassword, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedParameters = i4 != 0 ? pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(i3, i4) : pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(i3);
            for (int i5 = 0; i5 != bArrConvertPassword.length; i5++) {
                bArrConvertPassword[i5] = 0;
            }
            return cipherParametersGenerateDerivedParameters;
        }

        public static CipherParameters makePBEMacParameters(PBEKeySpec pBEKeySpec, int i, int i2, int i3) {
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(i, i2);
            byte[] bArrConvertPassword = convertPassword(i, pBEKeySpec);
            pBEParametersGeneratorMakePBEGenerator.m14982init(bArrConvertPassword, pBEKeySpec.getSalt(), pBEKeySpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedMacParameters = pBEParametersGeneratorMakePBEGenerator.generateDerivedMacParameters(i3);
            for (int i4 = 0; i4 != bArrConvertPassword.length; i4++) {
                bArrConvertPassword[i4] = 0;
            }
            return cipherParametersGenerateDerivedMacParameters;
        }

        public static CipherParameters makePBEParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, String str) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(bCPBEKey.m16175getType(), bCPBEKey.getDigest());
            byte[] encoded = bCPBEKey.getEncoded();
            if (bCPBEKey.shouldTryWrongPKCS12()) {
                encoded = new byte[2];
            }
            pBEParametersGeneratorMakePBEGenerator.m14982init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedParameters = bCPBEKey.getIvSize() != 0 ? pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(bCPBEKey.getKeySize(), bCPBEKey.getIvSize()) : pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(bCPBEKey.getKeySize());
            if (str.startsWith("DES")) {
                if (cipherParametersGenerateDerivedParameters instanceof ParametersWithIV) {
                    DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) cipherParametersGenerateDerivedParameters).getParameters()).m15773getKey());
                } else {
                    DESParameters.setOddParity(((KeyParameter) cipherParametersGenerateDerivedParameters).m15773getKey());
                }
            }
            return cipherParametersGenerateDerivedParameters;
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(bCPBEKey.m16175getType(), bCPBEKey.getDigest());
            pBEParametersGeneratorMakePBEGenerator.m14982init(bCPBEKey.getEncoded(), pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            return pBEParametersGeneratorMakePBEGenerator.generateDerivedMacParameters(bCPBEKey.getKeySize());
        }

        public static CipherParameters makePBEParameters(byte[] bArr, int i, int i2, int i3, int i4, AlgorithmParameterSpec algorithmParameterSpec, String str) throws InvalidAlgorithmParameterException {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(i, i2);
            pBEParametersGeneratorMakePBEGenerator.m14982init(bArr, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedParameters = i4 != 0 ? pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(i3, i4) : pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(i3);
            if (str.startsWith("DES")) {
                if (cipherParametersGenerateDerivedParameters instanceof ParametersWithIV) {
                    DESParameters.setOddParity(((KeyParameter) ((ParametersWithIV) cipherParametersGenerateDerivedParameters).getParameters()).m15773getKey());
                } else {
                    DESParameters.setOddParity(((KeyParameter) cipherParametersGenerateDerivedParameters).m15773getKey());
                }
            }
            return cipherParametersGenerateDerivedParameters;
        }
    }
}
