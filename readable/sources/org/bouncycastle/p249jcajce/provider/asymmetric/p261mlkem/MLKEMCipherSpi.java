package org.bouncycastle.p249jcajce.provider.asymmetric.p261mlkem;

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
import javax.security.auth.Destroyable;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p207kems.MLKEMExtractor;
import org.bouncycastle.p194crypto.p207kems.MLKEMGenerator;
import org.bouncycastle.p194crypto.p213params.MLKEMParameters;
import org.bouncycastle.p249jcajce.p279spec.KTSParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.MLKEMParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.WrapUtil;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class MLKEMCipherSpi extends CipherSpi {
    private final String algorithmName;
    private AlgorithmParameters engineParams;

    /* renamed from: kemGen */
    private MLKEMGenerator f21583kemGen;
    private KTSParameterSpec kemParameterSpec;
    private final MLKEMParameters mlkemParameters;
    private BCMLKEMPrivateKey unwrapKey;

    /* renamed from: wrapKey */
    private BCMLKEMPublicKey f21584wrapKey;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.mlkem.MLKEMCipherSpi$Base */
    public static class C5591Base extends MLKEMCipherSpi {
        public C5591Base() {
            super("MLKEM");
        }
    }

    public static class MLKEM1024 extends MLKEMCipherSpi {
        public MLKEM1024() {
            super(MLKEMParameters.ml_kem_1024);
        }
    }

    public static class MLKEM512 extends MLKEMCipherSpi {
        public MLKEM512() {
            super(MLKEMParameters.ml_kem_512);
        }
    }

    public static class MLKEM768 extends MLKEMCipherSpi {
        public MLKEM768() {
            super(MLKEMParameters.ml_kem_768);
        }
    }

    public MLKEMCipherSpi(String str) {
        this.mlkemParameters = null;
        this.algorithmName = str;
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
                parameterSpec = algorithmParameters.getParameterSpec(KTSParameterSpec.class);
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
            C6238Arrays.m18227clear(bArrExtractSecret);
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        throw new IllegalStateException("Not supported in a wrapping mode");
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws DestroyFailedException, InvalidKeyException {
        if (key.getEncoded() == null) {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        Destroyable destroyable = null;
        try {
            try {
                SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = this.f21583kemGen.generateEncapsulated(this.f21584wrapKey.getKeyParams());
                InterfaceC5283Wrapper keyWrapper = WrapUtil.getKeyWrapper(this.kemParameterSpec, secretWithEncapsulationGenerateEncapsulated.getSecret());
                byte[] encapsulation = secretWithEncapsulationGenerateEncapsulated.getEncapsulation();
                byte[] encoded = key.getEncoded();
                try {
                    byte[] bArrConcatenate = C6238Arrays.concatenate(encapsulation, keyWrapper.mo14997wrap(encoded, 0, encoded.length));
                    try {
                        secretWithEncapsulationGenerateEncapsulated.destroy();
                    } catch (DestroyFailedException unused) {
                    }
                    return bArrConcatenate;
                } finally {
                    C6238Arrays.m18227clear(encoded);
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        destroyable.destroy();
                    } catch (DestroyFailedException unused2) {
                    }
                }
                throw th;
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalBlockSizeException("unable to generate KTS secret: " + e.getMessage());
        }
    }

    public MLKEMCipherSpi(MLKEMParameters mLKEMParameters) {
        this.mlkemParameters = mLKEMParameters;
        this.algorithmName = mLKEMParameters.m15790getName();
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
        KTSParameterSpec kTSParameterSpecM16204build;
        if (algorithmParameterSpec == null) {
            kTSParameterSpecM16204build = new KTSParameterSpec.C5801Builder("AES-KWP", 256).m16204build();
        } else {
            if (!(algorithmParameterSpec instanceof KTSParameterSpec)) {
                throw new InvalidAlgorithmParameterException(this.algorithmName + " can only accept KTSParameterSpec");
            }
            kTSParameterSpecM16204build = (KTSParameterSpec) algorithmParameterSpec;
        }
        this.kemParameterSpec = kTSParameterSpecM16204build;
        if (i == 3) {
            if (!(key instanceof BCMLKEMPublicKey)) {
                throw new InvalidKeyException("Only a " + this.algorithmName + " public key can be used for wrapping");
            }
            this.f21584wrapKey = (BCMLKEMPublicKey) key;
            this.f21583kemGen = new MLKEMGenerator(secureRandom);
        } else {
            if (i != 4) {
                throw new InvalidParameterException("Cipher only valid for wrapping/unwrapping");
            }
            if (!(key instanceof BCMLKEMPrivateKey)) {
                throw new InvalidKeyException("Only a " + this.algorithmName + " private key can be used for unwrapping");
            }
            this.unwrapKey = (BCMLKEMPrivateKey) key;
        }
        MLKEMParameters mLKEMParameters = this.mlkemParameters;
        if (mLKEMParameters != null) {
            String strM16208getName = MLKEMParameterSpec.fromName(mLKEMParameters.m15790getName()).m16208getName();
            if (strM16208getName.equals(key.getAlgorithm())) {
                return;
            }
            throw new InvalidKeyException("cipher locked to " + strM16208getName);
        }
    }
}
