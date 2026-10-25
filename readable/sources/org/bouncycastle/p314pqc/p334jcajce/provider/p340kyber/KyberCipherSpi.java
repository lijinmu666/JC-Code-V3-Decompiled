package org.bouncycastle.p314pqc.p334jcajce.provider.p340kyber;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.DestroyFailedException;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p207kems.MLKEMExtractor;
import org.bouncycastle.p194crypto.p207kems.MLKEMGenerator;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p249jcajce.p279spec.KEMParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.KTSParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.WrapUtil;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
class KyberCipherSpi extends CipherSpi {
    private final String algorithmName;
    private AlgorithmParameters engineParams;

    /* renamed from: kemGen */
    private MLKEMGenerator f23763kemGen;
    private KTSParameterSpec kemParameterSpec;
    private MLKEMParameters kyberParameters;
    private BCKyberPrivateKey unwrapKey;

    /* renamed from: wrapKey */
    private BCKyberPublicKey f23764wrapKey;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.kyber.KyberCipherSpi$Base */
    public static class C6187Base extends KyberCipherSpi {
        public C6187Base() {
            super("KYBER");
        }
    }

    public static class Kyber1024 extends KyberCipherSpi {
        public Kyber1024() {
            super(MLKEMParameters.ml_kem_1024);
        }
    }

    public static class Kyber512 extends KyberCipherSpi {
        public Kyber512() {
            super(MLKEMParameters.ml_kem_512);
        }
    }

    public static class Kyber768 extends KyberCipherSpi {
        public Kyber768() {
            super(MLKEMParameters.ml_kem_768);
        }
    }

    public KyberCipherSpi(String str) {
        this.algorithmName = str;
        this.kyberParameters = null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return 2048;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        return -1;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() throws NoSuchAlgorithmException, InvalidParameterSpecException, NoSuchProviderException {
        if (this.engineParams == null) {
            try {
                AlgorithmParameters algorithmParameters = AlgorithmParameters.getInstance(this.algorithmName, "BCPQC");
                this.engineParams = algorithmParameters;
                algorithmParameters.init(this.kemParameterSpec);
            } catch (Exception e) {
                throw Exceptions.illegalStateException(e.toString(), e);
            }
        }
        return this.engineParams;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidParameterSpecException, InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec parameterSpec;
        if (algorithmParameters != null) {
            try {
                parameterSpec = algorithmParameters.getParameterSpec(KEMParameterSpec.class);
            } catch (Exception unused) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            parameterSpec = null;
        }
        engineInit(i, key, parameterSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("Cannot support mode " + str);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + str + " unknown");
    }

    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException {
        if (i != 3) {
            throw new InvalidKeyException("only SECRET_KEY supported");
        }
        byte[] bArrExtractSecret = null;
        try {
            try {
                MLKEMExtractor mLKEMExtractor = new MLKEMExtractor(this.unwrapKey.getKeyParams());
                bArrExtractSecret = mLKEMExtractor.extractSecret(C6238Arrays.copyOfRange(bArr, 0, mLKEMExtractor.getEncapsulationLength()));
                InterfaceC5283Wrapper keyUnwrapper = WrapUtil.getKeyUnwrapper(this.kemParameterSpec, bArrExtractSecret);
                byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, mLKEMExtractor.getEncapsulationLength(), bArr.length);
                return new SecretKeySpec(keyUnwrapper.mo14996unwrap(bArrCopyOfRange, 0, bArrCopyOfRange.length), str);
            } catch (IllegalArgumentException e) {
                throw new NoSuchAlgorithmException("unable to extract KTS secret: " + e.getMessage());
            } catch (InvalidCipherTextException e2) {
                throw new InvalidKeyException("unable to extract KTS secret: " + e2.getMessage());
            }
        } finally {
            if (bArrExtractSecret != null) {
                C6238Arrays.m18227clear(bArrExtractSecret);
            }
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws DestroyFailedException, IllegalBlockSizeException, InvalidKeyException {
        if (key.getEncoded() == null) {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = null;
        try {
            try {
                secretWithEncapsulationGenerateEncapsulated = this.f23763kemGen.generateEncapsulated(this.f23764wrapKey.getKeyParams());
                InterfaceC5283Wrapper keyWrapper = WrapUtil.getKeyWrapper(this.kemParameterSpec, secretWithEncapsulationGenerateEncapsulated.getSecret());
                byte[] encapsulation = secretWithEncapsulationGenerateEncapsulated.getEncapsulation();
                byte[] encoded = key.getEncoded();
                byte[] bArrConcatenate = C6238Arrays.concatenate(encapsulation, keyWrapper.mo14997wrap(encoded, 0, encoded.length));
                C6238Arrays.m18227clear(encoded);
                try {
                    secretWithEncapsulationGenerateEncapsulated.destroy();
                    return bArrConcatenate;
                } catch (DestroyFailedException e) {
                    throw new IllegalBlockSizeException("unable to destroy interim values: " + e.getMessage());
                }
            } catch (IllegalArgumentException e2) {
                throw new IllegalBlockSizeException("unable to generate KTS secret: " + e2.getMessage());
            }
        } catch (Throwable th) {
            if (secretWithEncapsulationGenerateEncapsulated != null) {
                try {
                    secretWithEncapsulationGenerateEncapsulated.destroy();
                } catch (DestroyFailedException e3) {
                    throw new IllegalBlockSizeException("unable to destroy interim values: " + e3.getMessage());
                }
            }
            throw th;
        }
    }

    public KyberCipherSpi(MLKEMParameters mLKEMParameters) {
        this.kyberParameters = mLKEMParameters;
        this.algorithmName = C6250Strings.toUpperCase(mLKEMParameters.m15790getName());
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw Exceptions.illegalArgumentException(e.getMessage(), e);
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        KTSParameterSpec kEMParameterSpec;
        if (algorithmParameterSpec == null) {
            kEMParameterSpec = new KEMParameterSpec("AES-KWP");
        } else {
            if (!(algorithmParameterSpec instanceof KTSParameterSpec)) {
                throw new InvalidAlgorithmParameterException(this.algorithmName + " can only accept KTSParameterSpec");
            }
            kEMParameterSpec = (KTSParameterSpec) algorithmParameterSpec;
        }
        this.kemParameterSpec = kEMParameterSpec;
        if (i == 3) {
            if (!(key instanceof BCKyberPublicKey)) {
                throw new InvalidKeyException("Only a " + this.algorithmName + " public key can be used for wrapping");
            }
            this.f23764wrapKey = (BCKyberPublicKey) key;
            this.f23763kemGen = new MLKEMGenerator(secureRandom);
        } else {
            if (i != 4) {
                throw new InvalidParameterException("Cipher only valid for wrapping/unwrapping");
            }
            if (!(key instanceof BCKyberPrivateKey)) {
                throw new InvalidKeyException("Only a " + this.algorithmName + " private key can be used for unwrapping");
            }
            this.unwrapKey = (BCKyberPrivateKey) key;
        }
        MLKEMParameters mLKEMParameters = this.kyberParameters;
        if (mLKEMParameters != null) {
            String upperCase = C6250Strings.toUpperCase(mLKEMParameters.m15790getName());
            if (upperCase.equals(key.getAlgorithm())) {
                return;
            }
            throw new InvalidKeyException("cipher locked to " + upperCase);
        }
    }
}
