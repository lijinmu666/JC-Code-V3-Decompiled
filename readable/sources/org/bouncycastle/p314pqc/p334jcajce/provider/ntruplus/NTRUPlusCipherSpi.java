package org.bouncycastle.p314pqc.p334jcajce.provider.ntruplus;

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
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p249jcajce.p279spec.KEMParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.KTSParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.WrapUtil;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusKEMExtractor;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusKEMGenerator;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusParameters;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
class NTRUPlusCipherSpi extends CipherSpi {
    private final String algorithmName;
    private AlgorithmParameters engineParams;

    /* renamed from: kemGen */
    private NTRUPlusKEMGenerator f23804kemGen;
    private KTSParameterSpec kemParameterSpec;
    private NTRUPlusParameters ntruplusParameters;
    private BCNTRUPlusPrivateKey unwrapKey;

    /* renamed from: wrapKey */
    private BCNTRUPlusPublicKey f23805wrapKey;

    /* renamed from: org.bouncycastle.pqc.jcajce.provider.ntruplus.NTRUPlusCipherSpi$Base */
    public static class C6203Base extends NTRUPlusCipherSpi {
        public C6203Base() {
            super("NTRU+");
        }
    }

    public static class NTRUPlus1152 extends NTRUPlusCipherSpi {
        public NTRUPlus1152() {
            super(NTRUPlusParameters.ntruplus_kem_1152);
        }
    }

    public static class NTRUPlus768 extends NTRUPlusCipherSpi {
        public NTRUPlus768() {
            super(NTRUPlusParameters.ntruplus_kem_864);
        }
    }

    public static class NTRUPlus864 extends NTRUPlusCipherSpi {
        public NTRUPlus864() {
            super(NTRUPlusParameters.ntruplus_kem_864);
        }
    }

    public NTRUPlusCipherSpi(String str) {
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
    public Key engineUnwrap(byte[] bArr, String str, int i) throws NoSuchAlgorithmException, InvalidKeyException {
        if (i != 3) {
            throw new InvalidKeyException("only SECRET_KEY supported");
        }
        try {
            NTRUPlusKEMExtractor nTRUPlusKEMExtractor = new NTRUPlusKEMExtractor(this.unwrapKey.getKeyParams());
            byte[] bArrExtractSecret = nTRUPlusKEMExtractor.extractSecret(C6238Arrays.copyOfRange(bArr, 0, nTRUPlusKEMExtractor.getEncapsulationLength()));
            InterfaceC5283Wrapper wrapper = WrapUtil.getWrapper(this.kemParameterSpec.getKeyAlgorithmName());
            KeyParameter keyParameter = new KeyParameter(WrapUtil.trimSecret(this.kemParameterSpec.getKeyAlgorithmName(), bArrExtractSecret));
            C6238Arrays.m18227clear(bArrExtractSecret);
            wrapper.mo14995init(false, keyParameter);
            byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, nTRUPlusKEMExtractor.getEncapsulationLength(), bArr.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(wrapper.mo14996unwrap(bArrCopyOfRange, 0, bArrCopyOfRange.length), str);
            C6238Arrays.m18227clear(keyParameter.m15773getKey());
            return secretKeySpec;
        } catch (IllegalArgumentException e) {
            throw new NoSuchAlgorithmException("unable to extract KTS secret: " + e.getMessage());
        } catch (InvalidCipherTextException e2) {
            throw new InvalidKeyException("unable to extract KTS secret: " + e2.getMessage());
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
        try {
            SecretWithEncapsulation secretWithEncapsulationGenerateEncapsulated = this.f23804kemGen.generateEncapsulated(this.f23805wrapKey.getKeyParams());
            InterfaceC5283Wrapper wrapper = WrapUtil.getWrapper(this.kemParameterSpec.getKeyAlgorithmName());
            wrapper.mo14995init(true, new KeyParameter(WrapUtil.trimSecret(this.kemParameterSpec.getKeyAlgorithmName(), secretWithEncapsulationGenerateEncapsulated.getSecret())));
            byte[] encapsulation = secretWithEncapsulationGenerateEncapsulated.getEncapsulation();
            secretWithEncapsulationGenerateEncapsulated.destroy();
            byte[] encoded = key.getEncoded();
            byte[] bArrConcatenate = C6238Arrays.concatenate(encapsulation, wrapper.mo14997wrap(encoded, 0, encoded.length));
            C6238Arrays.m18227clear(encoded);
            return bArrConcatenate;
        } catch (IllegalArgumentException e) {
            throw new IllegalBlockSizeException("unable to generate KTS secret: " + e.getMessage());
        } catch (DestroyFailedException e2) {
            throw new IllegalBlockSizeException("unable to destroy interim values: " + e2.getMessage());
        }
    }

    public NTRUPlusCipherSpi(NTRUPlusParameters nTRUPlusParameters) {
        this.ntruplusParameters = nTRUPlusParameters;
        this.algorithmName = C6250Strings.toUpperCase(nTRUPlusParameters.m17775getName());
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
            if (!(key instanceof BCNTRUPlusPublicKey)) {
                throw new InvalidKeyException("Only a " + this.algorithmName + " public key can be used for wrapping");
            }
            this.f23805wrapKey = (BCNTRUPlusPublicKey) key;
            this.f23804kemGen = new NTRUPlusKEMGenerator(CryptoServicesRegistrar.getSecureRandom(secureRandom));
        } else {
            if (i != 4) {
                throw new InvalidParameterException("Cipher only valid for wrapping/unwrapping");
            }
            if (!(key instanceof BCNTRUPlusPrivateKey)) {
                throw new InvalidKeyException("Only a " + this.algorithmName + " private key can be used for unwrapping");
            }
            this.unwrapKey = (BCNTRUPlusPrivateKey) key;
        }
        NTRUPlusParameters nTRUPlusParameters = this.ntruplusParameters;
        if (nTRUPlusParameters != null) {
            String upperCase = C6250Strings.toUpperCase(nTRUPlusParameters.m17775getName());
            if (upperCase.equals(key.getAlgorithm())) {
                return;
            }
            throw new InvalidKeyException("cipher locked to " + upperCase);
        }
    }
}
