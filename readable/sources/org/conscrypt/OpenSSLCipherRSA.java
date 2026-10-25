package org.conscrypt;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;
import javax.crypto.spec.SecretKeySpec;
import org.conscrypt.EvpMdRef;
import org.conscrypt.NativeRef;

/* loaded from: classes2.dex */
public abstract class OpenSSLCipherRSA extends CipherSpi {

    /* renamed from: buffer */
    private byte[] f24410buffer;
    private int bufferOffset;
    boolean encrypting;
    private boolean inputTooLarge;

    /* renamed from: key */
    OpenSSLKey f24411key;

    /* renamed from: padding */
    int f24412padding;
    boolean usingPrivateKey;

    public static abstract class DirectRSA extends OpenSSLCipherRSA {
        public DirectRSA(int i) {
            super(i);
        }

        @Override // org.conscrypt.OpenSSLCipherRSA
        public int doCryptoOperation(byte[] bArr, byte[] bArr2) throws IllegalBlockSizeException {
            if (this.encrypting) {
                return this.usingPrivateKey ? NativeCrypto.RSA_private_encrypt(bArr.length, bArr, bArr2, this.f24411key.getNativeRef(), this.f24412padding) : NativeCrypto.RSA_public_encrypt(bArr.length, bArr, bArr2, this.f24411key.getNativeRef(), this.f24412padding);
            }
            try {
                return this.usingPrivateKey ? NativeCrypto.RSA_private_decrypt(bArr.length, bArr, bArr2, this.f24411key.getNativeRef(), this.f24412padding) : NativeCrypto.RSA_public_decrypt(bArr.length, bArr, bArr2, this.f24411key.getNativeRef(), this.f24412padding);
            } catch (SignatureException e) {
                IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
                illegalBlockSizeException.initCause(e);
                throw illegalBlockSizeException;
            }
        }
    }

    /* renamed from: org.conscrypt.OpenSSLCipherRSA$PKCS1 */
    public static final class C6307PKCS1 extends DirectRSA {
        public C6307PKCS1() {
            super(1);
        }
    }

    /* renamed from: org.conscrypt.OpenSSLCipherRSA$Raw */
    public static final class C6308Raw extends DirectRSA {
        public C6308Raw() {
            super(3);
        }
    }

    public OpenSSLCipherRSA(int i) {
        this.f24412padding = i;
    }

    public void doCryptoInit(AlgorithmParameterSpec algorithmParameterSpec) {
    }

    public abstract int doCryptoOperation(byte[] bArr, byte[] bArr2);

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException {
        if (bArr != null) {
            engineUpdate(bArr, i, i2);
        }
        if (this.inputTooLarge) {
            throw new IllegalBlockSizeException("input must be under " + this.f24410buffer.length + " bytes");
        }
        int i3 = this.bufferOffset;
        byte[] bArrCopyOf = this.f24410buffer;
        if (i3 != bArrCopyOf.length) {
            if (this.f24412padding == 3) {
                byte[] bArr2 = new byte[bArrCopyOf.length];
                System.arraycopy(bArrCopyOf, 0, bArr2, bArrCopyOf.length - i3, i3);
                bArrCopyOf = bArr2;
            } else {
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i3);
            }
        }
        int length = this.f24410buffer.length;
        byte[] bArrCopyOf2 = new byte[length];
        int iDoCryptoOperation = doCryptoOperation(bArrCopyOf, bArrCopyOf2);
        if (!this.encrypting && iDoCryptoOperation != length) {
            bArrCopyOf2 = Arrays.copyOf(bArrCopyOf2, iDoCryptoOperation);
        }
        this.bufferOffset = 0;
        return bArrCopyOf2;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return this.encrypting ? paddedBlockSizeBytes() : keySizeBytes();
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) throws InvalidKeyException {
        if (key instanceof OpenSSLRSAPrivateKey) {
            return ((OpenSSLRSAPrivateKey) key).getModulus().bitLength();
        }
        if (key instanceof RSAPrivateCrtKey) {
            return ((RSAPrivateCrtKey) key).getModulus().bitLength();
        }
        if (key instanceof RSAPrivateKey) {
            return ((RSAPrivateKey) key).getModulus().bitLength();
        }
        if (key instanceof OpenSSLRSAPublicKey) {
            return ((OpenSSLRSAPublicKey) key).getModulus().bitLength();
        }
        if (key instanceof RSAPublicKey) {
            return ((RSAPublicKey) key).getModulus().bitLength();
        }
        if (key == null) {
            throw new InvalidKeyException("RSA private or public key is null");
        }
        throw new InvalidKeyException("Need RSA private or public key");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        return this.encrypting ? keySizeBytes() : paddedBlockSizeBytes();
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInitInternal(i, key, null);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException("Algorithm parameters rejected when none supplied", e);
        }
    }

    public void engineInitInternal(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException {
        if (i == 1 || i == 3) {
            this.encrypting = true;
        } else {
            if (i != 2 && i != 4) {
                throw new InvalidParameterException("Unsupported opmode " + i);
            }
            this.encrypting = false;
        }
        if (key instanceof OpenSSLRSAPrivateKey) {
            this.usingPrivateKey = true;
            this.f24411key = ((OpenSSLRSAPrivateKey) key).getOpenSSLKey();
        } else if (key instanceof RSAPrivateCrtKey) {
            this.usingPrivateKey = true;
            this.f24411key = OpenSSLRSAPrivateCrtKey.getInstance((RSAPrivateCrtKey) key);
        } else if (key instanceof RSAPrivateKey) {
            this.usingPrivateKey = true;
            this.f24411key = OpenSSLRSAPrivateKey.getInstance((RSAPrivateKey) key);
        } else if (key instanceof OpenSSLRSAPublicKey) {
            this.usingPrivateKey = false;
            this.f24411key = ((OpenSSLRSAPublicKey) key).getOpenSSLKey();
        } else {
            if (!(key instanceof RSAPublicKey)) {
                if (key != null) {
                    throw new InvalidKeyException("Need RSA private or public key");
                }
                throw new InvalidKeyException("RSA private or public key is null");
            }
            this.usingPrivateKey = false;
            this.f24411key = OpenSSLRSAPublicKey.getInstance((RSAPublicKey) key);
        }
        this.f24410buffer = new byte[NativeCrypto.RSA_size(this.f24411key.getNativeRef())];
        this.bufferOffset = 0;
        this.inputTooLarge = false;
        doCryptoInit(algorithmParameterSpec);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        String upperCase = str.toUpperCase(Locale.ROOT);
        if ("NONE".equals(upperCase) || "ECB".equals(upperCase)) {
            return;
        }
        throw new NoSuchAlgorithmException("mode not supported: " + str);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = str.toUpperCase(Locale.ROOT);
        if ("PKCS1PADDING".equals(upperCase)) {
            this.f24412padding = 1;
        } else {
            if ("NOPADDING".equals(upperCase)) {
                this.f24412padding = 3;
                return;
            }
            throw new NoSuchPaddingException("padding not supported: " + str);
        }
    }

    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException {
        try {
            byte[] bArrEngineDoFinal = engineDoFinal(bArr, 0, bArr.length);
            if (i == 1) {
                return KeyFactory.getInstance(str).generatePublic(new X509EncodedKeySpec(bArrEngineDoFinal));
            }
            if (i == 2) {
                return KeyFactory.getInstance(str).generatePrivate(new PKCS8EncodedKeySpec(bArrEngineDoFinal));
            }
            if (i == 3) {
                return new SecretKeySpec(bArrEngineDoFinal, str);
            }
            throw new UnsupportedOperationException("wrappedKeyType == " + i);
        } catch (InvalidKeySpecException e) {
            throw new InvalidKeyException(e);
        } catch (BadPaddingException e2) {
            throw new InvalidKeyException(e2);
        } catch (IllegalBlockSizeException e3) {
            throw new InvalidKeyException(e3);
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        int i3 = this.bufferOffset;
        int i4 = i3 + i2;
        byte[] bArr2 = this.f24410buffer;
        if (i4 > bArr2.length) {
            this.inputTooLarge = true;
            return EmptyArray.f24348BYTE;
        }
        System.arraycopy(bArr, i, bArr2, i3, i2);
        this.bufferOffset += i2;
        return EmptyArray.f24348BYTE;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException {
        try {
            byte[] encoded = key.getEncoded();
            return engineDoFinal(encoded, 0, encoded.length);
        } catch (BadPaddingException e) {
            IllegalBlockSizeException illegalBlockSizeException = new IllegalBlockSizeException();
            illegalBlockSizeException.initCause(e);
            throw illegalBlockSizeException;
        }
    }

    public boolean isInitialized() {
        return this.f24411key != null;
    }

    public int keySizeBytes() {
        if (isInitialized()) {
            return NativeCrypto.RSA_size(this.f24411key.getNativeRef());
        }
        throw new IllegalStateException("cipher is not initialized");
    }

    public int paddedBlockSizeBytes() {
        int iKeySizeBytes = keySizeBytes();
        return this.f24412padding == 1 ? iKeySizeBytes - 11 : iKeySizeBytes;
    }

    /* renamed from: org.conscrypt.OpenSSLCipherRSA$OAEP */
    public static class C6306OAEP extends OpenSSLCipherRSA {

        /* renamed from: label */
        private byte[] f24413label;

        /* renamed from: mgf1Md */
        private long f24414mgf1Md;

        /* renamed from: oaepMd */
        private long f24415oaepMd;
        private int oaepMdSizeBytes;

        /* renamed from: pkeyCtx */
        private NativeRef.EVP_PKEY_CTX f24416pkeyCtx;

        /* renamed from: org.conscrypt.OpenSSLCipherRSA$OAEP$SHA1 */
        public static final class SHA1 extends C6306OAEP {
            public SHA1() {
                super(EvpMdRef.C6281SHA1.f24357EVP_MD, EvpMdRef.C6281SHA1.SIZE_BYTES);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLCipherRSA$OAEP$SHA224 */
        public static final class SHA224 extends C6306OAEP {
            public SHA224() {
                super(EvpMdRef.C6282SHA224.f24359EVP_MD, EvpMdRef.C6282SHA224.SIZE_BYTES);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLCipherRSA$OAEP$SHA256 */
        public static final class SHA256 extends C6306OAEP {
            public SHA256() {
                super(EvpMdRef.C6283SHA256.f24361EVP_MD, EvpMdRef.C6283SHA256.SIZE_BYTES);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLCipherRSA$OAEP$SHA384 */
        public static final class SHA384 extends C6306OAEP {
            public SHA384() {
                super(EvpMdRef.C6284SHA384.f24363EVP_MD, EvpMdRef.C6284SHA384.SIZE_BYTES);
            }
        }

        /* renamed from: org.conscrypt.OpenSSLCipherRSA$OAEP$SHA512 */
        public static final class SHA512 extends C6306OAEP {
            public SHA512() {
                super(EvpMdRef.C6285SHA512.f24365EVP_MD, EvpMdRef.C6285SHA512.SIZE_BYTES);
            }
        }

        public C6306OAEP(long j, int i) {
            super(4);
            this.f24414mgf1Md = j;
            this.f24415oaepMd = j;
            this.oaepMdSizeBytes = i;
        }

        private void readOAEPParameters(OAEPParameterSpec oAEPParameterSpec) throws InvalidAlgorithmParameterException {
            String mGFAlgorithm = oAEPParameterSpec.getMGFAlgorithm();
            Locale locale = Locale.US;
            String upperCase = mGFAlgorithm.toUpperCase(locale);
            AlgorithmParameterSpec mGFParameters = oAEPParameterSpec.getMGFParameters();
            if ((!"MGF1".equals(upperCase) && !"1.2.840.113549.1.1.8".equals(upperCase)) || !(mGFParameters instanceof MGF1ParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Only MGF1 supported as mask generation function");
            }
            MGF1ParameterSpec mGF1ParameterSpec = (MGF1ParameterSpec) mGFParameters;
            String upperCase2 = oAEPParameterSpec.getDigestAlgorithm().toUpperCase(locale);
            try {
                this.f24415oaepMd = EvpMdRef.getEVP_MDByJcaDigestAlgorithmStandardName(upperCase2);
                this.oaepMdSizeBytes = EvpMdRef.getDigestSizeBytesByJcaDigestAlgorithmStandardName(upperCase2);
                this.f24414mgf1Md = EvpMdRef.getEVP_MDByJcaDigestAlgorithmStandardName(mGF1ParameterSpec.getDigestAlgorithm());
                PSource pSource = oAEPParameterSpec.getPSource();
                if (!"PSpecified".equals(pSource.getAlgorithm()) || !(pSource instanceof PSource.PSpecified)) {
                    throw new InvalidAlgorithmParameterException("Only PSpecified accepted for PSource");
                }
                this.f24413label = ((PSource.PSpecified) pSource).getValue();
            } catch (NoSuchAlgorithmException e) {
                throw new InvalidAlgorithmParameterException(e);
            }
        }

        @Override // org.conscrypt.OpenSSLCipherRSA
        public void doCryptoInit(AlgorithmParameterSpec algorithmParameterSpec) throws InvalidAlgorithmParameterException {
            this.f24416pkeyCtx = new NativeRef.EVP_PKEY_CTX(this.encrypting ? NativeCrypto.EVP_PKEY_encrypt_init(this.f24411key.getNativeRef()) : NativeCrypto.EVP_PKEY_decrypt_init(this.f24411key.getNativeRef()));
            if (algorithmParameterSpec instanceof OAEPParameterSpec) {
                readOAEPParameters((OAEPParameterSpec) algorithmParameterSpec);
            }
            NativeCrypto.EVP_PKEY_CTX_set_rsa_padding(this.f24416pkeyCtx.f24379address, 4);
            NativeCrypto.EVP_PKEY_CTX_set_rsa_oaep_md(this.f24416pkeyCtx.f24379address, this.f24415oaepMd);
            NativeCrypto.EVP_PKEY_CTX_set_rsa_mgf1_md(this.f24416pkeyCtx.f24379address, this.f24414mgf1Md);
            byte[] bArr = this.f24413label;
            if (bArr == null || bArr.length <= 0) {
                return;
            }
            NativeCrypto.EVP_PKEY_CTX_set_rsa_oaep_label(this.f24416pkeyCtx.f24379address, bArr);
        }

        @Override // org.conscrypt.OpenSSLCipherRSA
        public int doCryptoOperation(byte[] bArr, byte[] bArr2) {
            return this.encrypting ? NativeCrypto.EVP_PKEY_encrypt(this.f24416pkeyCtx, bArr2, 0, bArr, 0, bArr.length) : NativeCrypto.EVP_PKEY_decrypt(this.f24416pkeyCtx, bArr2, 0, bArr, 0, bArr.length);
        }

        @Override // org.conscrypt.OpenSSLCipherRSA, javax.crypto.CipherSpi
        public AlgorithmParameters engineGetParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException {
            if (!isInitialized()) {
                return null;
            }
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance("OAEP");
                algorithmParameters.init(new OAEPParameterSpec(EvpMdRef.getJcaDigestAlgorithmStandardNameFromEVP_MD(this.f24415oaepMd), "MGF1", new MGF1ParameterSpec(EvpMdRef.getJcaDigestAlgorithmStandardNameFromEVP_MD(this.f24414mgf1Md)), this.f24413label == null ? PSource.PSpecified.DEFAULT : new PSource.PSpecified(this.f24413label)));
                return algorithmParameters;
            } catch (NoSuchAlgorithmException e) {
                throw ((Error) new AssertionError("OAEP not supported").initCause(e));
            } catch (InvalidParameterSpecException unused) {
                throw new RuntimeException("No providers of AlgorithmParameters.OAEP available");
            }
        }

        @Override // org.conscrypt.OpenSSLCipherRSA, javax.crypto.CipherSpi
        public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
            if (algorithmParameterSpec != null && !(algorithmParameterSpec instanceof OAEPParameterSpec)) {
                throw new InvalidAlgorithmParameterException("Only OAEPParameterSpec accepted in OAEP mode");
            }
            engineInitInternal(i, key, algorithmParameterSpec);
        }

        @Override // org.conscrypt.OpenSSLCipherRSA
        public void engineInitInternal(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec) throws InvalidKeyException {
            if (i == 1 || i == 3) {
                if (!(key instanceof PublicKey)) {
                    throw new InvalidKeyException("Only public keys may be used to encrypt");
                }
            } else if ((i == 2 || i == 4) && !(key instanceof PrivateKey)) {
                throw new InvalidKeyException("Only private keys may be used to decrypt");
            }
            super.engineInitInternal(i, key, algorithmParameterSpec);
        }

        @Override // org.conscrypt.OpenSSLCipherRSA, javax.crypto.CipherSpi
        public void engineSetPadding(String str) throws NoSuchPaddingException {
            if (!str.toUpperCase(Locale.US).equals("OAEPPADDING")) {
                throw new NoSuchPaddingException("Only OAEP padding is supported");
            }
            this.f24412padding = 4;
        }

        @Override // org.conscrypt.OpenSSLCipherRSA
        public int paddedBlockSizeBytes() {
            return keySizeBytes() - ((this.oaepMdSizeBytes * 2) + 2);
        }

        @Override // org.conscrypt.OpenSSLCipherRSA, javax.crypto.CipherSpi
        public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
            OAEPParameterSpec oAEPParameterSpec;
            if (algorithmParameters != null) {
                try {
                    oAEPParameterSpec = (OAEPParameterSpec) algorithmParameters.getParameterSpec(OAEPParameterSpec.class);
                } catch (InvalidParameterSpecException e) {
                    throw new InvalidAlgorithmParameterException("Only OAEP parameters are supported", e);
                }
            } else {
                oAEPParameterSpec = null;
            }
            engineInitInternal(i, key, oAEPParameterSpec);
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec == null) {
            engineInitInternal(i, key, algorithmParameterSpec);
            return;
        }
        throw new InvalidAlgorithmParameterException("unknown param type: " + algorithmParameterSpec.getClass().getName());
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameters == null) {
            engineInitInternal(i, key, null);
            return;
        }
        throw new InvalidAlgorithmParameterException("unknown param type: " + algorithmParameters.getClass().getName());
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        engineUpdate(bArr, i, i2);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, ShortBufferWithoutStackTraceException {
        byte[] bArrEngineDoFinal = engineDoFinal(bArr, i, i2);
        int length = bArrEngineDoFinal.length + i3;
        if (length <= bArr2.length) {
            System.arraycopy(bArrEngineDoFinal, 0, bArr2, i3, bArrEngineDoFinal.length);
            return bArrEngineDoFinal.length;
        }
        throw new ShortBufferWithoutStackTraceException("output buffer is too small " + bArr2.length + " < " + length);
    }
}
