package org.bouncycastle.p249jcajce.provider.symmetric.p277util;

import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p249jcajce.PKCS12Key;
import org.bouncycastle.p249jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.InterfaceC5795PBE;

/* loaded from: classes2.dex */
public class BaseStreamCipher extends BaseWrapCipher implements InterfaceC5795PBE {
    private Class[] availableSpecs;

    /* renamed from: cipher */
    private StreamCipher f21873cipher;

    /* renamed from: digest */
    private int f21874digest;
    private int ivLength;

    /* renamed from: ivParam */
    private ParametersWithIV f21875ivParam;
    private int keySizeInBits;
    private String pbeAlgorithm;

    /* renamed from: pbeSpec */
    private PBEParameterSpec f21876pbeSpec;

    public BaseStreamCipher(StreamCipher streamCipher, int i) {
        this(streamCipher, i, -1, -1);
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (i3 + i2 > bArr2.length) {
            throw new ShortBufferException("output buffer too short for input.");
        }
        if (i2 != 0) {
            this.f21873cipher.processBytes(bArr, i, i2, bArr2, i3);
        }
        this.f21873cipher.mo14994reset();
        return i2;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        ParametersWithIV parametersWithIV = this.f21875ivParam;
        if (parametersWithIV != null) {
            return parametersWithIV.m15801getIV();
        }
        return null;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        return i;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() throws InvalidParameterSpecException {
        if (this.engineParams == null) {
            if (this.f21876pbeSpec != null) {
                try {
                    AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance(this.pbeAlgorithm);
                    algorithmParametersCreateParametersInstance.init(this.f21876pbeSpec);
                    return algorithmParametersCreateParametersInstance;
                } catch (Exception unused) {
                    return null;
                }
            }
            if (this.f21875ivParam != null) {
                String algorithmName = this.f21873cipher.getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                if (algorithmName.startsWith("ChaCha7539")) {
                    algorithmName = "ChaCha7539";
                } else if (algorithmName.startsWith("Grain")) {
                    algorithmName = "Grainv1";
                } else if (algorithmName.startsWith("HC")) {
                    int iIndexOf = algorithmName.indexOf(45);
                    algorithmName = algorithmName.substring(0, iIndexOf) + algorithmName.substring(iIndexOf + 1);
                }
                try {
                    AlgorithmParameters algorithmParametersCreateParametersInstance2 = createParametersInstance(algorithmName);
                    this.engineParams = algorithmParametersCreateParametersInstance2;
                    algorithmParametersCreateParametersInstance2.init(new IvParameterSpec(this.f21875ivParam.m15801getIV()));
                } catch (Exception e) {
                    throw new RuntimeException(e.toString());
                }
            }
        }
        return this.engineParams;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpecExtractSpec;
        if (algorithmParameters != null) {
            algorithmParameterSpecExtractSpec = SpecUtil.extractSpec(algorithmParameters, this.availableSpecs);
            if (algorithmParameterSpecExtractSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpecExtractSpec = null;
        }
        engineInit(i, key, algorithmParameterSpecExtractSpec, secureRandom);
        this.engineParams = algorithmParameters;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        if (str.equalsIgnoreCase("ECB") || str.equals("NONE")) {
            return;
        }
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        if (str.equalsIgnoreCase("NoPadding")) {
            return;
        }
        throw new NoSuchPaddingException("Padding " + str + " unknown.");
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (i3 + i2 > bArr2.length) {
            throw new ShortBufferException("output buffer too short for input.");
        }
        try {
            this.f21873cipher.processBytes(bArr, i, i2, bArr2, i3);
            return i2;
        } catch (DataLengthException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public BaseStreamCipher(StreamCipher streamCipher, int i, int i2) {
        this(streamCipher, i, i2, -1);
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            this.f21873cipher.mo14994reset();
            return new byte[0];
        }
        byte[] bArrEngineUpdate = engineUpdate(bArr, i, i2);
        this.f21873cipher.mo14994reset();
        return bArrEngineUpdate;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.f21873cipher.processBytes(bArr, i, i2, bArr2, 0);
        return bArr2;
    }

    public BaseStreamCipher(StreamCipher streamCipher, int i, int i2, int i3) {
        this.availableSpecs = new Class[]{RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
        this.f21876pbeSpec = null;
        this.pbeAlgorithm = null;
        this.f21873cipher = streamCipher;
        this.ivLength = i;
        this.keySizeInBits = i2;
        this.f21874digest = i3;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParametersMakePBEParameters;
        CipherParameters keyParameter;
        this.f21876pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        if (!(key instanceof SecretKey)) {
            throw new InvalidKeyException("Key for algorithm " + key.getAlgorithm() + " not suitable for symmetric enryption.");
        }
        if (key instanceof PKCS12Key) {
            PKCS12Key pKCS12Key = (PKCS12Key) key;
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec;
            this.f21876pbeSpec = pBEParameterSpec;
            if ((pKCS12Key instanceof PKCS12KeyWithParameters) && pBEParameterSpec == null) {
                PKCS12KeyWithParameters pKCS12KeyWithParameters = (PKCS12KeyWithParameters) pKCS12Key;
                this.f21876pbeSpec = new PBEParameterSpec(pKCS12KeyWithParameters.getSalt(), pKCS12KeyWithParameters.getIterationCount());
            }
            cipherParametersMakePBEParameters = InterfaceC5795PBE.Util.makePBEParameters(pKCS12Key.getEncoded(), 2, this.f21874digest, this.keySizeInBits, this.ivLength * 8, this.f21876pbeSpec, this.f21873cipher.getAlgorithmName());
        } else {
            if (key instanceof BCPBEKey) {
                BCPBEKey bCPBEKey = (BCPBEKey) key;
                this.pbeAlgorithm = bCPBEKey.m16174getOID() != null ? bCPBEKey.m16174getOID().m14433getId() : bCPBEKey.getAlgorithm();
                if (bCPBEKey.getParam() != null) {
                    keyParameter = bCPBEKey.getParam();
                    this.f21876pbeSpec = new PBEParameterSpec(bCPBEKey.getSalt(), bCPBEKey.getIterationCount());
                } else {
                    if (!(algorithmParameterSpec instanceof PBEParameterSpec)) {
                        throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                    }
                    CipherParameters cipherParametersMakePBEParameters2 = InterfaceC5795PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec, this.f21873cipher.getAlgorithmName());
                    this.f21876pbeSpec = (PBEParameterSpec) algorithmParameterSpec;
                    keyParameter = cipherParametersMakePBEParameters2;
                }
                if (bCPBEKey.getIvSize() != 0) {
                    this.f21875ivParam = (ParametersWithIV) keyParameter;
                }
            } else if (algorithmParameterSpec == null) {
                if (this.f21874digest > 0) {
                    throw new InvalidKeyException("Algorithm requires a PBE key");
                }
                keyParameter = new KeyParameter(key.getEncoded());
            } else {
                if (!(algorithmParameterSpec instanceof IvParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("unknown parameter type.");
                }
                ParametersWithIV parametersWithIV = new ParametersWithIV(new KeyParameter(key.getEncoded()), ((IvParameterSpec) algorithmParameterSpec).getIV());
                this.f21875ivParam = parametersWithIV;
                cipherParametersMakePBEParameters = parametersWithIV;
            }
            cipherParametersMakePBEParameters = keyParameter;
        }
        if (this.ivLength != 0 && !(cipherParametersMakePBEParameters instanceof ParametersWithIV)) {
            if (secureRandom == null) {
                secureRandom = CryptoServicesRegistrar.getSecureRandom();
            }
            if (i != 1 && i != 3) {
                throw new InvalidAlgorithmParameterException("no IV set when one expected");
            }
            byte[] bArr = new byte[this.ivLength];
            secureRandom.nextBytes(bArr);
            ParametersWithIV parametersWithIV2 = new ParametersWithIV(cipherParametersMakePBEParameters, bArr);
            this.f21875ivParam = parametersWithIV2;
            cipherParametersMakePBEParameters = parametersWithIV2;
        }
        try {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new InvalidParameterException("unknown opmode " + i + " passed");
                        }
                    }
                }
                this.f21873cipher.mo14993init(false, cipherParametersMakePBEParameters);
                return;
            }
            this.f21873cipher.mo14993init(true, cipherParametersMakePBEParameters);
        } catch (Exception e) {
            throw new InvalidKeyException(e.getMessage());
        }
    }
}
