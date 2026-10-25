package org.conscrypt;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.conscrypt.OpenSSLCipher;

/* loaded from: classes2.dex */
public abstract class OpenSSLAeadCipherAES extends OpenSSLAeadCipher {
    private static final int AES_BLOCK_SIZE = 16;

    /* renamed from: org.conscrypt.OpenSSLAeadCipherAES$GCM */
    public static class C6302GCM extends OpenSSLAeadCipherAES {

        /* renamed from: org.conscrypt.OpenSSLAeadCipherAES$GCM$AES_128 */
        public static class AES_128 extends C6302GCM {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            public void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i == 16) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 16)");
            }
        }

        /* renamed from: org.conscrypt.OpenSSLAeadCipherAES$GCM$AES_256 */
        public static class AES_256 extends C6302GCM {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            public void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i == 32) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 32)");
            }
        }

        public C6302GCM() {
            super(OpenSSLCipher.EnumC6304Mode.GCM);
        }

        @Override // org.conscrypt.OpenSSLCipher
        public void checkSupportedMode(OpenSSLCipher.EnumC6304Mode enumC6304Mode) throws NoSuchAlgorithmException {
            if (enumC6304Mode != OpenSSLCipher.EnumC6304Mode.GCM) {
                throw new NoSuchAlgorithmException("Mode must be GCM");
            }
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        public long getEVP_AEAD(int i) {
            if (i == 16) {
                return NativeCrypto.EVP_aead_aes_128_gcm();
            }
            if (i == 32) {
                return NativeCrypto.EVP_aead_aes_256_gcm();
            }
            throw new RuntimeException("Unexpected key length: " + i);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLAeadCipherAES$GCM_SIV */
    public static class C6303GCM_SIV extends OpenSSLAeadCipherAES {

        /* renamed from: org.conscrypt.OpenSSLAeadCipherAES$GCM_SIV$AES_128 */
        public static class AES_128 extends C6303GCM_SIV {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            public void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i == 16) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 16)");
            }
        }

        /* renamed from: org.conscrypt.OpenSSLAeadCipherAES$GCM_SIV$AES_256 */
        public static class AES_256 extends C6303GCM_SIV {
            @Override // org.conscrypt.OpenSSLAeadCipherAES, org.conscrypt.OpenSSLCipher
            public void checkSupportedKeySize(int i) throws InvalidKeyException {
                if (i == 32) {
                    return;
                }
                throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 32)");
            }
        }

        public C6303GCM_SIV() {
            super(OpenSSLCipher.EnumC6304Mode.GCM_SIV);
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        public boolean allowsNonceReuse() {
            return true;
        }

        @Override // org.conscrypt.OpenSSLCipher
        public void checkSupportedMode(OpenSSLCipher.EnumC6304Mode enumC6304Mode) throws NoSuchAlgorithmException {
            if (enumC6304Mode != OpenSSLCipher.EnumC6304Mode.GCM_SIV) {
                throw new NoSuchAlgorithmException("Mode must be GCM-SIV");
            }
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        public void checkSupportedTagLength(int i) throws InvalidAlgorithmParameterException {
            if (i != 128) {
                throw new InvalidAlgorithmParameterException("Tag length must be 128 bits");
            }
        }

        @Override // org.conscrypt.OpenSSLAeadCipher
        public long getEVP_AEAD(int i) {
            if (i == 16) {
                return NativeCrypto.EVP_aead_aes_128_gcm_siv();
            }
            if (i == 32) {
                return NativeCrypto.EVP_aead_aes_256_gcm_siv();
            }
            throw new RuntimeException("Unexpected key length: " + i);
        }
    }

    public OpenSSLAeadCipherAES(OpenSSLCipher.EnumC6304Mode enumC6304Mode) {
        super(enumC6304Mode);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public void checkSupportedKeySize(int i) throws InvalidKeyException {
        if (i == 16 || i == 32) {
            return;
        }
        throw new InvalidKeyException("Unsupported key size: " + i + " bytes (must be 16 or 32)");
    }

    @Override // org.conscrypt.OpenSSLCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException, ClassNotFoundException {
        byte[] bArr = this.f24399iv;
        if (bArr == null) {
            return null;
        }
        AlgorithmParameterSpec gCMParameterSpec = Platform.toGCMParameterSpec(this.tagLengthInBytes * 8, bArr);
        if (gCMParameterSpec == null) {
            return super.engineGetParameters();
        }
        try {
            AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("GCM");
            algorithmParameters.init(gCMParameterSpec);
            return algorithmParameters;
        } catch (NoSuchAlgorithmException e) {
            throw ((Error) new AssertionError("GCM not supported").initCause(e));
        } catch (InvalidParameterSpecException unused) {
            return null;
        }
    }

    @Override // org.conscrypt.OpenSSLCipher
    public String getBaseCipherName() {
        return "AES";
    }

    @Override // org.conscrypt.OpenSSLCipher
    public int getCipherBlockSize() {
        return 16;
    }

    @Override // org.conscrypt.OpenSSLAeadCipher, org.conscrypt.OpenSSLCipher
    public int getOutputSizeForFinal(int i) {
        return isEncrypting() ? this.bufCount + i + this.tagLengthInBytes : Math.max(0, (this.bufCount + i) - this.tagLengthInBytes);
    }

    @Override // org.conscrypt.OpenSSLCipher
    public AlgorithmParameterSpec getParameterSpec(AlgorithmParameters algorithmParameters) throws ClassNotFoundException {
        if (algorithmParameters == null) {
            return null;
        }
        AlgorithmParameterSpec algorithmParameterSpecFromGCMParameters = Platform.fromGCMParameters(algorithmParameters);
        return algorithmParameterSpecFromGCMParameters != null ? algorithmParameterSpecFromGCMParameters : super.getParameterSpec(algorithmParameters);
    }
}
