package org.bouncycastle.p281jce.provider;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS12ParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS5S1ParametersGenerator;
import org.bouncycastle.p194crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.MD5Digest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD160Digest;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BCPBEKey;

/* loaded from: classes2.dex */
public interface BrokenPBE {

    /* renamed from: MD5 */
    public static final int f21986MD5 = 0;
    public static final int OLD_PKCS12 = 3;

    /* renamed from: PKCS12 */
    public static final int f21987PKCS12 = 2;

    /* renamed from: PKCS5S1 */
    public static final int f21988PKCS5S1 = 0;

    /* renamed from: PKCS5S2 */
    public static final int f21989PKCS5S2 = 1;
    public static final int RIPEMD160 = 2;

    /* renamed from: SHA1 */
    public static final int f21990SHA1 = 1;

    /* renamed from: org.bouncycastle.jce.provider.BrokenPBE$Util */
    public static class C5813Util {
        private static PBEParametersGenerator makePBEGenerator(int i, int i2) {
            if (i == 0) {
                if (i2 == 0) {
                    return new PKCS5S1ParametersGenerator(new MD5Digest());
                }
                if (i2 == 1) {
                    return new PKCS5S1ParametersGenerator(new SHA1Digest());
                }
                throw new IllegalStateException("PKCS5 scheme 1 only supports only MD5 and SHA1.");
            }
            if (i == 1) {
                return new PKCS5S2ParametersGenerator();
            }
            if (i == 3) {
                if (i2 == 0) {
                    return new OldPKCS12ParametersGenerator(new MD5Digest());
                }
                if (i2 == 1) {
                    return new OldPKCS12ParametersGenerator(new SHA1Digest());
                }
                if (i2 == 2) {
                    return new OldPKCS12ParametersGenerator(new RIPEMD160Digest());
                }
                throw new IllegalStateException("unknown digest scheme for PBE encryption.");
            }
            if (i2 == 0) {
                return new PKCS12ParametersGenerator(new MD5Digest());
            }
            if (i2 == 1) {
                return new PKCS12ParametersGenerator(new SHA1Digest());
            }
            if (i2 == 2) {
                return new PKCS12ParametersGenerator(new RIPEMD160Digest());
            }
            throw new IllegalStateException("unknown digest scheme for PBE encryption.");
        }

        public static CipherParameters makePBEMacParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, int i, int i2, int i3) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(i, i2);
            byte[] encoded = bCPBEKey.getEncoded();
            pBEParametersGeneratorMakePBEGenerator.m14982init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedMacParameters = pBEParametersGeneratorMakePBEGenerator.generateDerivedMacParameters(i3);
            for (int i4 = 0; i4 != encoded.length; i4++) {
                encoded[i4] = 0;
            }
            return cipherParametersGenerateDerivedMacParameters;
        }

        public static CipherParameters makePBEParameters(BCPBEKey bCPBEKey, AlgorithmParameterSpec algorithmParameterSpec, int i, int i2, String str, int i3, int i4) {
            if (algorithmParameterSpec == null || !(algorithmParameterSpec instanceof PBEParameterSpec)) {
                throw new IllegalArgumentException("Need a PBEParameter spec with a PBE key.");
            }
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            PBEParametersGenerator pBEParametersGeneratorMakePBEGenerator = makePBEGenerator(i, i2);
            byte[] encoded = bCPBEKey.getEncoded();
            pBEParametersGeneratorMakePBEGenerator.m14982init(encoded, pBEParameterSpec.getSalt(), pBEParameterSpec.getIterationCount());
            CipherParameters cipherParametersGenerateDerivedParameters = i4 != 0 ? pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(i3, i4) : pBEParametersGeneratorMakePBEGenerator.generateDerivedParameters(i3);
            if (str.startsWith("DES")) {
                if (cipherParametersGenerateDerivedParameters instanceof ParametersWithIV) {
                    setOddParity(((KeyParameter) ((ParametersWithIV) cipherParametersGenerateDerivedParameters).getParameters()).m15773getKey());
                } else {
                    setOddParity(((KeyParameter) cipherParametersGenerateDerivedParameters).m15773getKey());
                }
            }
            for (int i5 = 0; i5 != encoded.length; i5++) {
                encoded[i5] = 0;
            }
            return cipherParametersGenerateDerivedParameters;
        }

        private static void setOddParity(byte[] bArr) {
            for (int i = 0; i < bArr.length; i++) {
                byte b = bArr[i];
                bArr[i] = (byte) ((((b >> 7) ^ ((((((b >> 1) ^ (b >> 2)) ^ (b >> 3)) ^ (b >> 4)) ^ (b >> 5)) ^ (b >> 6))) ^ 1) | (b & 254));
            }
        }
    }
}
