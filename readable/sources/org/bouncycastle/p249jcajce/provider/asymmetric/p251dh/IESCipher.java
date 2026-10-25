package org.bouncycastle.p249jcajce.provider.asymmetric.p251dh;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.interfaces.DHKey;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.interfaces.DHPublicKey;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.KeyEncoder;
import org.bouncycastle.p194crypto.agreement.DHBasicAgreement;
import org.bouncycastle.p194crypto.generators.DHKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p201engines.DESedeEngine;
import org.bouncycastle.p194crypto.p201engines.IESEngine;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DHKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.DHKeyParameters;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.IESWithCipherParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p214parsers.DHIESPublicKeyParser;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p194crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5615DHUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5619IESUtil;
import org.bouncycastle.p249jcajce.provider.p278util.BadBlockException;
import org.bouncycastle.p281jce.interfaces.InterfaceC5810IESKey;
import org.bouncycastle.p281jce.p282spec.IESParameterSpec;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class IESCipher extends BaseCipherSpi {

    /* renamed from: buffer */
    private ByteArrayOutputStream f21426buffer;
    private boolean dhaesMode;

    /* renamed from: engine */
    private IESEngine f21427engine;
    private AlgorithmParameters engineParam;
    private IESParameterSpec engineSpec;

    /* renamed from: helper */
    private final JcaJceHelper f21428helper;
    private final int ivLength;

    /* renamed from: key */
    private AsymmetricKeyParameter f21429key;
    private AsymmetricKeyParameter otherKeyParameter;

    /* renamed from: random */
    private SecureRandom f21430random;

    /* renamed from: state */
    private int f21431state;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher$IES */
    public static class C5508IES extends IESCipher {
        public C5508IES() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new C5360HMac(DigestFactory.createSHA1())));
        }
    }

    public static class IESwithAESCBC extends IESCipher {
        public IESwithAESCBC() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new C5360HMac(DigestFactory.createSHA1()), new PaddedBufferedBlockCipher(CBCBlockCipher.newInstance(AESEngine.newInstance()))), 16);
        }
    }

    public static class IESwithDESedeCBC extends IESCipher {
        public IESwithDESedeCBC() {
            super(new IESEngine(new DHBasicAgreement(), new KDF2BytesGenerator(DigestFactory.createSHA1()), new C5360HMac(DigestFactory.createSHA1()), new PaddedBufferedBlockCipher(CBCBlockCipher.newInstance(new DESedeEngine()))), 8);
        }
    }

    public IESCipher(IESEngine iESEngine) {
        this.f21428helper = new BCJcaJceHelper();
        this.f21431state = -1;
        this.f21426buffer = new ByteArrayOutputStream();
        this.engineParam = null;
        this.engineSpec = null;
        this.dhaesMode = false;
        this.otherKeyParameter = null;
        this.f21427engine = iESEngine;
        this.ivLength = 0;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws BadBlockException {
        byte[] bArrEngineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(bArrEngineDoFinal, 0, bArr2, i3, bArrEngineDoFinal.length);
        return bArrEngineDoFinal.length;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        BufferedBlockCipher cipher = this.f21427engine.getCipher();
        if (cipher == null) {
            return 0;
        }
        return cipher.getBlockSize();
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        IESParameterSpec iESParameterSpec = this.engineSpec;
        if (iESParameterSpec != null) {
            return iESParameterSpec.getNonce();
        }
        return null;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        if (key instanceof DHKey) {
            return ((DHKey) key).getParams().getP().bitLength();
        }
        throw new IllegalArgumentException("not a DH key");
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        int size;
        BufferedBlockCipher cipher;
        if (this.f21429key == null) {
            throw new IllegalStateException("cipher not initialised");
        }
        int macSize = this.f21427engine.m15347getMac().getMacSize();
        int iBitLength = this.otherKeyParameter == null ? (((((DHKeyParameters) this.f21429key).getParameters().m15695getP().bitLength() + 7) * 2) / 8) + 1 : 0;
        if (this.f21427engine.getCipher() != null) {
            int i2 = this.f21431state;
            if (i2 == 1 || i2 == 3) {
                cipher = this.f21427engine.getCipher();
            } else {
                if (i2 != 2 && i2 != 4) {
                    throw new IllegalStateException("cipher not initialised");
                }
                cipher = this.f21427engine.getCipher();
                i = (i - macSize) - iBitLength;
            }
            i = cipher.getOutputSize(i);
        }
        int i3 = this.f21431state;
        if (i3 == 1 || i3 == 3) {
            size = this.f21426buffer.size() + macSize + iBitLength;
        } else {
            if (i3 != 2 && i3 != 4) {
                throw new IllegalStateException("IESCipher not initialised");
            }
            size = (this.f21426buffer.size() - macSize) - iBitLength;
        }
        return size + i;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() throws InvalidParameterSpecException {
        if (this.engineParam == null && this.engineSpec != null) {
            try {
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f21428helper.createAlgorithmParameters("IES");
                this.engineParam = algorithmParametersCreateAlgorithmParameters;
                algorithmParametersCreateAlgorithmParameters.init(this.engineSpec);
            } catch (Exception e) {
                throw new RuntimeException(e.toString());
            }
        }
        return this.engineParam;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidParameterSpecException, InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec parameterSpec;
        if (algorithmParameters != null) {
            try {
                parameterSpec = algorithmParameters.getParameterSpec(IESParameterSpec.class);
            } catch (Exception e) {
                throw new InvalidAlgorithmParameterException("cannot recognise parameters: " + e.toString());
            }
        } else {
            parameterSpec = null;
        }
        this.engineParam = algorithmParameters;
        engineInit(i, key, parameterSpec, secureRandom);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public void engineSetMode(String str) {
        boolean z;
        String upperCase = C6250Strings.toUpperCase(str);
        if (upperCase.equals("NONE")) {
            z = false;
        } else {
            if (!upperCase.equals("DHAES")) {
                throw new IllegalArgumentException("can't support mode " + str);
            }
            z = true;
        }
        this.dhaesMode = z;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        String upperCase = C6250Strings.toUpperCase(str);
        if (!upperCase.equals("NOPADDING") && !upperCase.equals("PKCS5PADDING") && !upperCase.equals("PKCS7PADDING")) {
            throw new NoSuchPaddingException("padding not available with IESCipher");
        }
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f21426buffer.write(bArr, i, i2);
        return 0;
    }

    public IESCipher(IESEngine iESEngine, int i) {
        this.f21428helper = new BCJcaJceHelper();
        this.f21431state = -1;
        this.f21426buffer = new ByteArrayOutputStream();
        this.engineParam = null;
        this.engineSpec = null;
        this.dhaesMode = false;
        this.otherKeyParameter = null;
        this.f21427engine = iESEngine;
        this.ivLength = i;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws BadBlockException {
        if (i2 != 0) {
            this.f21426buffer.write(bArr, i, i2);
        }
        byte[] byteArray = this.f21426buffer.toByteArray();
        this.f21426buffer.reset();
        CipherParameters iESWithCipherParameters = new IESWithCipherParameters(this.engineSpec.getDerivationV(), this.engineSpec.getEncodingV(), this.engineSpec.getMacKeySize(), this.engineSpec.getCipherKeySize());
        byte[] nonce = this.engineSpec.getNonce();
        if (nonce != null) {
            iESWithCipherParameters = new ParametersWithIV(iESWithCipherParameters, nonce);
        }
        DHParameters parameters = ((DHKeyParameters) this.f21429key).getParameters();
        AsymmetricKeyParameter asymmetricKeyParameter = this.otherKeyParameter;
        if (asymmetricKeyParameter != null) {
            try {
                int i3 = this.f21431state;
                if (i3 == 1 || i3 == 3) {
                    this.f21427engine.m15350init(true, asymmetricKeyParameter, this.f21429key, iESWithCipherParameters);
                } else {
                    this.f21427engine.m15350init(false, this.f21429key, asymmetricKeyParameter, iESWithCipherParameters);
                }
                return this.f21427engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e) {
                throw new BadBlockException("unable to process block", e);
            }
        }
        int i4 = this.f21431state;
        if (i4 == 1 || i4 == 3) {
            DHKeyPairGenerator dHKeyPairGenerator = new DHKeyPairGenerator();
            dHKeyPairGenerator.mo14944init(new DHKeyGenerationParameters(this.f21430random, parameters));
            try {
                this.f21427engine.m15349init(this.f21429key, iESWithCipherParameters, new EphemeralKeyPairGenerator(dHKeyPairGenerator, new KeyEncoder() { // from class: org.bouncycastle.jcajce.provider.asymmetric.dh.IESCipher.1
                    @Override // org.bouncycastle.p194crypto.KeyEncoder
                    public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter2) {
                        int iBitLength = (((DHKeyParameters) asymmetricKeyParameter2).getParameters().m15695getP().bitLength() + 7) / 8;
                        byte[] bArr2 = new byte[iBitLength];
                        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(((DHPublicKeyParameters) asymmetricKeyParameter2).m15698getY());
                        if (bArrAsUnsignedByteArray.length > iBitLength) {
                            throw new IllegalArgumentException("Senders's public key longer than expected.");
                        }
                        System.arraycopy(bArrAsUnsignedByteArray, 0, bArr2, iBitLength - bArrAsUnsignedByteArray.length, bArrAsUnsignedByteArray.length);
                        return bArr2;
                    }
                }));
                return this.f21427engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e2) {
                throw new BadBlockException("unable to process block", e2);
            }
        }
        if (i4 != 2 && i4 != 4) {
            throw new IllegalStateException("IESCipher not initialised");
        }
        try {
            IESEngine iESEngine = this.f21427engine;
            AsymmetricKeyParameter asymmetricKeyParameter2 = this.f21429key;
            iESEngine.m15348init(asymmetricKeyParameter2, iESWithCipherParameters, new DHIESPublicKeyParser(((DHKeyParameters) asymmetricKeyParameter2).getParameters()));
            return this.f21427engine.processBlock(byteArray, 0, byteArray.length);
        } catch (InvalidCipherTextException e3) {
            throw new BadBlockException("unable to process block", e3);
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            engineInit(i, key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e) {
            throw new IllegalArgumentException("cannot handle supplied parameter spec: " + e.getMessage());
        }
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineUpdate(byte[] bArr, int i, int i2) {
        this.f21426buffer.write(bArr, i, i2);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        IESParameterSpec iESParameterSpecGuessParameterSpec;
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePublicKeyParameter;
        PrivateKey privateKey;
        if (algorithmParameterSpec == null && this.ivLength == 0) {
            iESParameterSpecGuessParameterSpec = C5619IESUtil.guessParameterSpec(this.f21427engine.getCipher(), null);
        } else {
            if (!(algorithmParameterSpec instanceof IESParameterSpec)) {
                throw new InvalidAlgorithmParameterException("must be passed IES parameters");
            }
            iESParameterSpecGuessParameterSpec = (IESParameterSpec) algorithmParameterSpec;
        }
        this.engineSpec = iESParameterSpecGuessParameterSpec;
        byte[] nonce = this.engineSpec.getNonce();
        int i2 = this.ivLength;
        if (i2 != 0 && (nonce == null || nonce.length != i2)) {
            throw new InvalidAlgorithmParameterException("NONCE in IES Parameters needs to be " + this.ivLength + " bytes long");
        }
        if (i == 1 || i == 3) {
            if (!(key instanceof DHPublicKey)) {
                if (!(key instanceof InterfaceC5810IESKey)) {
                    throw new InvalidKeyException("must be passed recipient's public DH key for encryption");
                }
                InterfaceC5810IESKey interfaceC5810IESKey = (InterfaceC5810IESKey) key;
                this.f21429key = C5615DHUtil.generatePublicKeyParameter(interfaceC5810IESKey.getPublic());
                this.otherKeyParameter = C5615DHUtil.generatePrivateKeyParameter(interfaceC5810IESKey.getPrivate());
                this.f21430random = secureRandom;
                this.f21431state = i;
                this.f21426buffer.reset();
            }
            asymmetricKeyParameterGeneratePublicKeyParameter = C5615DHUtil.generatePublicKeyParameter((PublicKey) key);
        } else {
            if (i != 2 && i != 4) {
                throw new InvalidKeyException("must be passed EC key");
            }
            if (key instanceof DHPrivateKey) {
                privateKey = (PrivateKey) key;
            } else {
                if (!(key instanceof InterfaceC5810IESKey)) {
                    throw new InvalidKeyException("must be passed recipient's private DH key for decryption");
                }
                InterfaceC5810IESKey interfaceC5810IESKey2 = (InterfaceC5810IESKey) key;
                this.otherKeyParameter = C5615DHUtil.generatePublicKeyParameter(interfaceC5810IESKey2.getPublic());
                privateKey = interfaceC5810IESKey2.getPrivate();
            }
            asymmetricKeyParameterGeneratePublicKeyParameter = C5615DHUtil.generatePrivateKeyParameter(privateKey);
        }
        this.f21429key = asymmetricKeyParameterGeneratePublicKeyParameter;
        this.f21430random = secureRandom;
        this.f21431state = i;
        this.f21426buffer.reset();
    }
}
