package org.bouncycastle.p249jcajce.provider.symmetric.p277util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.CipherSpi;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.ParametersWithSBox;
import org.bouncycastle.p194crypto.p213params.ParametersWithUKM;
import org.bouncycastle.p249jcajce.p279spec.GOST28147WrapParameterSpec;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.InterfaceC5795PBE;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p361util.C6238Arrays;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public abstract class BaseWrapCipher extends CipherSpi implements InterfaceC5795PBE {
    private Class[] availableSpecs;
    protected AlgorithmParameters engineParams;
    private boolean forWrapping;

    /* renamed from: helper */
    private final JcaJceHelper f21877helper;

    /* renamed from: iv */
    private byte[] f21878iv;

    /* renamed from: ivSize */
    private int f21879ivSize;

    /* renamed from: pbeHash */
    protected int f21880pbeHash;
    protected int pbeIvSize;
    protected int pbeKeySize;

    /* renamed from: pbeType */
    protected int f21881pbeType;
    protected InterfaceC5283Wrapper wrapEngine;
    private ErasableOutputStream wrapStream;

    public static final class ErasableOutputStream extends ByteArrayOutputStream {
        /* renamed from: erase */
        public void m16179erase() {
            C6238Arrays.m18249fill(((ByteArrayOutputStream) this).buf, (byte) 0);
            reset();
        }

        /* renamed from: getBuf */
        public byte[] m16180getBuf() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    public static class InvalidKeyOrParametersException extends InvalidKeyException {

        /* renamed from: cause */
        private final Throwable f21882cause;

        public InvalidKeyOrParametersException(String str, Throwable th) {
            super(str);
            this.f21882cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f21882cause;
        }
    }

    public BaseWrapCipher() {
        this.availableSpecs = new Class[]{GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.f21881pbeType = 2;
        this.f21880pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.f21877helper = new BCJcaJceHelper();
    }

    public final AlgorithmParameters createParametersInstance(String str) {
        return this.f21877helper.createAlgorithmParameters(str);
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        byte[] bArrMo14997wrap;
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        erasableOutputStream.write(bArr, i, i2);
        try {
            if (this.forWrapping) {
                try {
                    bArrMo14997wrap = this.wrapEngine.mo14997wrap(this.wrapStream.m16180getBuf(), 0, this.wrapStream.size());
                } catch (Exception e) {
                    throw new IllegalBlockSizeException(e.getMessage());
                }
            } else {
                try {
                    bArrMo14997wrap = this.wrapEngine.mo14996unwrap(this.wrapStream.m16180getBuf(), 0, this.wrapStream.size());
                } catch (InvalidCipherTextException e2) {
                    throw new BadPaddingException(e2.getMessage());
                }
            }
            if (bArrMo14997wrap.length + i3 > bArr2.length) {
                throw new ShortBufferException("output buffer too short for input.");
            }
            System.arraycopy(bArrMo14997wrap, 0, bArr2, i3, bArrMo14997wrap.length);
            return bArrMo14997wrap.length;
        } finally {
            this.wrapStream.m16179erase();
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return C6238Arrays.m18231clone(this.f21878iv);
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        return key.getEncoded().length * 8;
    }

    @Override // javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        return -1;
    }

    @Override // javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() throws InvalidParameterSpecException {
        if (this.engineParams == null && this.f21878iv != null) {
            String algorithmName = this.wrapEngine.getAlgorithmName();
            if (algorithmName.indexOf(47) >= 0) {
                algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
            }
            try {
                AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance(algorithmName);
                this.engineParams = algorithmParametersCreateParametersInstance;
                algorithmParametersCreateParametersInstance.init(new IvParameterSpec(this.f21878iv));
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParams;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyOrParametersException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpecExtractSpec;
        if (algorithmParameters != null) {
            algorithmParameterSpecExtractSpec = SpecUtil.extractSpec(algorithmParameters, this.availableSpecs);
            if (algorithmParameterSpecExtractSpec == null) {
                throw new InvalidAlgorithmParameterException("can't handle parameter " + algorithmParameters.toString());
            }
        } else {
            algorithmParameterSpecExtractSpec = null;
        }
        this.engineParams = algorithmParameters;
        engineInit(i, key, algorithmParameterSpecExtractSpec, secureRandom);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    @Override // javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("Padding " + str + " unknown.");
    }

    @Override // javax.crypto.CipherSpi
    public Key engineUnwrap(byte[] bArr, String str, int i) throws InvalidKeyException {
        try {
            InterfaceC5283Wrapper interfaceC5283Wrapper = this.wrapEngine;
            byte[] bArrEngineDoFinal = interfaceC5283Wrapper == null ? engineDoFinal(bArr, 0, bArr.length) : interfaceC5283Wrapper.mo14996unwrap(bArr, 0, bArr.length);
            if (i == 3) {
                return new SecretKeySpec(bArrEngineDoFinal, str);
            }
            if (str.equals(BuildConfig.f24315FLAVOR) && i == 2) {
                try {
                    PrivateKeyInfo privateKeyInfo = PrivateKeyInfo.getInstance(bArrEngineDoFinal);
                    PrivateKey privateKey = BouncyCastleProvider.getPrivateKey(privateKeyInfo);
                    if (privateKey != null) {
                        return privateKey;
                    }
                    throw new InvalidKeyException("algorithm " + privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm() + " not supported");
                } catch (Exception unused) {
                    throw new InvalidKeyException("Invalid key encoding.");
                }
            }
            try {
                KeyFactory keyFactoryCreateKeyFactory = this.f21877helper.createKeyFactory(str);
                if (i == 1) {
                    return keyFactoryCreateKeyFactory.generatePublic(new X509EncodedKeySpec(bArrEngineDoFinal));
                }
                if (i == 2) {
                    return keyFactoryCreateKeyFactory.generatePrivate(new PKCS8EncodedKeySpec(bArrEngineDoFinal));
                }
                throw new InvalidKeyException("Unknown key type " + i);
            } catch (NoSuchProviderException e) {
                throw new InvalidKeyException("Unknown key type " + e.getMessage());
            } catch (InvalidKeySpecException e2) {
                throw new InvalidKeyException("Unknown key type " + e2.getMessage());
            }
        } catch (BadPaddingException e3) {
            throw new InvalidKeyException(e3.getMessage());
        } catch (IllegalBlockSizeException e4) {
            throw new InvalidKeyException(e4.getMessage());
        } catch (InvalidCipherTextException e5) {
            throw new InvalidKeyException(e5.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        erasableOutputStream.write(bArr, i, i2);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineWrap(Key key) throws IllegalBlockSizeException, InvalidKeyException {
        byte[] encoded = key.getEncoded();
        if (encoded == null) {
            throw new InvalidKeyException("Cannot wrap key, null encoding.");
        }
        try {
            InterfaceC5283Wrapper interfaceC5283Wrapper = this.wrapEngine;
            return interfaceC5283Wrapper == null ? engineDoFinal(encoded, 0, encoded.length) : interfaceC5283Wrapper.mo14997wrap(encoded, 0, encoded.length);
        } catch (BadPaddingException e) {
            throw new IllegalBlockSizeException(e.getMessage());
        }
    }

    public BaseWrapCipher(int i, InterfaceC5283Wrapper interfaceC5283Wrapper) {
        this(i, interfaceC5283Wrapper, 0);
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IOException {
        byte[] bArrMo14996unwrap;
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        if (bArr != null) {
            erasableOutputStream.write(bArr, i, i2);
        }
        try {
            if (this.forWrapping) {
                try {
                    bArrMo14996unwrap = this.wrapEngine.mo14997wrap(this.wrapStream.m16180getBuf(), 0, this.wrapStream.size());
                } catch (Exception e) {
                    throw new IllegalBlockSizeException(e.getMessage());
                }
            } else {
                try {
                    bArrMo14996unwrap = this.wrapEngine.mo14996unwrap(this.wrapStream.m16180getBuf(), 0, this.wrapStream.size());
                } catch (InvalidCipherTextException e2) {
                    throw new BadPaddingException(e2.getMessage());
                }
            }
            return bArrMo14996unwrap;
        } finally {
            this.wrapStream.m16179erase();
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyOrParametersException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new InvalidKeyOrParametersException(e.getMessage(), e);
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) throws IOException {
        ErasableOutputStream erasableOutputStream = this.wrapStream;
        if (erasableOutputStream == null) {
            throw new IllegalStateException("not supported in a wrapping mode");
        }
        erasableOutputStream.write(bArr, i, i2);
        return null;
    }

    public BaseWrapCipher(int i, InterfaceC5283Wrapper interfaceC5283Wrapper, int i2) {
        this.availableSpecs = new Class[]{GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.f21881pbeType = 2;
        this.f21880pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.f21877helper = new BCJcaJceHelper();
        this.pbeKeySize = i;
        this.wrapEngine = interfaceC5283Wrapper;
        this.f21879ivSize = i2;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyOrParametersException, InvalidAlgorithmParameterException {
        CipherParameters keyParameter;
        int i2;
        if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            if (algorithmParameterSpec instanceof PBEParameterSpec) {
                keyParameter = InterfaceC5795PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec, this.wrapEngine.getAlgorithmName());
            } else {
                if (bCPBEKey.getParam() == null) {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
                keyParameter = bCPBEKey.getParam();
            }
        } else {
            keyParameter = new KeyParameter(key.getEncoded());
        }
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            byte[] iv = ((IvParameterSpec) algorithmParameterSpec).getIV();
            this.f21878iv = iv;
            keyParameter = new ParametersWithIV(keyParameter, iv);
        }
        if (algorithmParameterSpec instanceof GOST28147WrapParameterSpec) {
            GOST28147WrapParameterSpec gOST28147WrapParameterSpec = (GOST28147WrapParameterSpec) algorithmParameterSpec;
            byte[] bArrM16195getSBox = gOST28147WrapParameterSpec.m16195getSBox();
            if (bArrM16195getSBox != null) {
                keyParameter = new ParametersWithSBox(keyParameter, bArrM16195getSBox);
            }
            keyParameter = new ParametersWithUKM(keyParameter, gOST28147WrapParameterSpec.m16196getUKM());
        }
        if ((keyParameter instanceof KeyParameter) && (i2 = this.f21879ivSize) != 0 && (i == 3 || i == 1)) {
            byte[] bArr = new byte[i2];
            this.f21878iv = bArr;
            secureRandom.nextBytes(bArr);
            keyParameter = new ParametersWithIV(keyParameter, this.f21878iv);
        }
        if (secureRandom != null) {
            keyParameter = new ParametersWithRandom(keyParameter, secureRandom);
        }
        try {
            if (i != 1) {
                if (i == 2) {
                    this.wrapEngine.mo14995init(false, keyParameter);
                    this.wrapStream = new ErasableOutputStream();
                } else if (i == 3) {
                    this.wrapEngine.mo14995init(true, keyParameter);
                    this.wrapStream = null;
                } else {
                    if (i != 4) {
                        throw new InvalidParameterException("Unknown mode parameter passed to init.");
                    }
                    this.wrapEngine.mo14995init(false, keyParameter);
                    this.wrapStream = null;
                }
                this.forWrapping = false;
                return;
            }
            this.wrapEngine.mo14995init(true, keyParameter);
            this.wrapStream = new ErasableOutputStream();
            this.forWrapping = true;
        } catch (Exception e) {
            throw new InvalidKeyOrParametersException(e.getMessage(), e);
        }
    }

    public BaseWrapCipher(InterfaceC5283Wrapper interfaceC5283Wrapper) {
        this(interfaceC5283Wrapper, 0);
    }

    public BaseWrapCipher(InterfaceC5283Wrapper interfaceC5283Wrapper, int i) {
        this.availableSpecs = new Class[]{GOST28147WrapParameterSpec.class, PBEParameterSpec.class, RC2ParameterSpec.class, RC5ParameterSpec.class, IvParameterSpec.class};
        this.f21881pbeType = 2;
        this.f21880pbeHash = 1;
        this.engineParams = null;
        this.wrapEngine = null;
        this.wrapStream = null;
        this.f21877helper = new BCJcaJceHelper();
        this.wrapEngine = interfaceC5283Wrapper;
        this.f21879ivSize = i;
    }
}
