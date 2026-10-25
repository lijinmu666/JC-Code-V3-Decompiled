package org.bouncycastle.p249jcajce.provider.asymmetric.p256edec;

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
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.KeyEncoder;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.agreement.XDHBasicAgreement;
import org.bouncycastle.p194crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.p194crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.p194crypto.generators.X448KeyPairGenerator;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p201engines.DESedeEngine;
import org.bouncycastle.p194crypto.p201engines.IESEngine;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECKeyParameters;
import org.bouncycastle.p194crypto.p213params.IESWithCipherParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PublicKeyParameters;
import org.bouncycastle.p194crypto.p214parsers.XIESPublicKeyParser;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p194crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5485XDHKey;
import org.bouncycastle.p249jcajce.p279spec.XDHParameterSpec;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5619IESUtil;
import org.bouncycastle.p249jcajce.provider.p278util.BadBlockException;
import org.bouncycastle.p281jce.p282spec.IESParameterSpec;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class IESCipher extends BaseCipherSpi {

    /* renamed from: buffer */
    private ByteArrayOutputStream f21536buffer;
    private boolean dhaesMode;

    /* renamed from: engine */
    private IESEngine f21537engine;
    private AlgorithmParameters engineParam;
    private IESParameterSpec engineSpec;

    /* renamed from: helper */
    private final JcaJceHelper f21538helper;
    private int ivLength;

    /* renamed from: key */
    private AsymmetricKeyParameter f21539key;
    private AsymmetricKeyParameter otherKeyParameter;

    /* renamed from: random */
    private SecureRandom f21540random;

    /* renamed from: state */
    private int f21541state;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.IESCipher$XIES */
    public static class C5552XIES extends IESCipher {
        public C5552XIES() {
            this(DigestFactory.createSHA1(), DigestFactory.createSHA1());
        }

        public C5552XIES(InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2) {
            super(new IESEngine(new XDHBasicAgreement(), new KDF2BytesGenerator(interfaceC5277Digest), new C5360HMac(interfaceC5277Digest2)));
        }
    }

    public static class XIESwithAESCBC extends XIESwithCipher {
        public XIESwithAESCBC() {
            super(CBCBlockCipher.newInstance(AESEngine.newInstance()), 16);
        }
    }

    public static class XIESwithCipher extends IESCipher {
        public XIESwithCipher(BlockCipher blockCipher, int i) {
            this(blockCipher, i, DigestFactory.createSHA1(), DigestFactory.createSHA1());
        }

        public XIESwithCipher(BlockCipher blockCipher, int i, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2) {
            super(new IESEngine(new XDHBasicAgreement(), new KDF2BytesGenerator(interfaceC5277Digest), new C5360HMac(interfaceC5277Digest2), new PaddedBufferedBlockCipher(blockCipher)), i);
        }
    }

    public static class XIESwithDESedeCBC extends XIESwithCipher {
        public XIESwithDESedeCBC() {
            super(CBCBlockCipher.newInstance(new DESedeEngine()), 8);
        }
    }

    public static class XIESwithSHA256 extends C5552XIES {
        public XIESwithSHA256() {
            super(DigestFactory.createSHA256(), DigestFactory.createSHA256());
        }
    }

    public static class XIESwithSHA256andAESCBC extends XIESwithCipher {
        public XIESwithSHA256andAESCBC() {
            super(CBCBlockCipher.newInstance(AESEngine.newInstance()), 16, DigestFactory.createSHA256(), DigestFactory.createSHA256());
        }
    }

    public static class XIESwithSHA256andDESedeCBC extends XIESwithCipher {
        public XIESwithSHA256andDESedeCBC() {
            super(CBCBlockCipher.newInstance(new DESedeEngine()), 8, DigestFactory.createSHA256(), DigestFactory.createSHA256());
        }
    }

    public static class XIESwithSHA384 extends C5552XIES {
        public XIESwithSHA384() {
            super(DigestFactory.createSHA384(), DigestFactory.createSHA384());
        }
    }

    public static class XIESwithSHA384andAESCBC extends XIESwithCipher {
        public XIESwithSHA384andAESCBC() {
            super(CBCBlockCipher.newInstance(AESEngine.newInstance()), 16, DigestFactory.createSHA384(), DigestFactory.createSHA384());
        }
    }

    public static class XIESwithSHA384andDESedeCBC extends XIESwithCipher {
        public XIESwithSHA384andDESedeCBC() {
            super(CBCBlockCipher.newInstance(new DESedeEngine()), 8, DigestFactory.createSHA384(), DigestFactory.createSHA384());
        }
    }

    public static class XIESwithSHA512 extends C5552XIES {
        public XIESwithSHA512() {
            super(DigestFactory.createSHA512(), DigestFactory.createSHA512());
        }
    }

    public static class XIESwithSHA512andAESCBC extends XIESwithCipher {
        public XIESwithSHA512andAESCBC() {
            super(CBCBlockCipher.newInstance(AESEngine.newInstance()), 16, DigestFactory.createSHA512(), DigestFactory.createSHA512());
        }
    }

    public static class XIESwithSHA512andDESedeCBC extends XIESwithCipher {
        public XIESwithSHA512andDESedeCBC() {
            super(CBCBlockCipher.newInstance(new DESedeEngine()), 8, DigestFactory.createSHA512(), DigestFactory.createSHA512());
        }
    }

    public IESCipher(IESEngine iESEngine) {
        this.f21538helper = new BCJcaJceHelper();
        this.f21541state = -1;
        this.f21536buffer = new ByteArrayOutputStream();
        this.engineParam = null;
        this.engineSpec = null;
        this.dhaesMode = false;
        this.otherKeyParameter = null;
        this.f21537engine = iESEngine;
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
        BufferedBlockCipher cipher = this.f21537engine.getCipher();
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
        if (!(key instanceof InterfaceC5485XDHKey)) {
            throw new IllegalArgumentException("not an XDH key");
        }
        String algorithm = ((InterfaceC5485XDHKey) key).getAlgorithm();
        if (XDHParameterSpec.f21951X25519.equalsIgnoreCase(algorithm)) {
            return 256;
        }
        if (XDHParameterSpec.f21952X448.equalsIgnoreCase(algorithm)) {
            return 448;
        }
        throw new IllegalArgumentException("unknown XDH key algorithm " + algorithm);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        BufferedBlockCipher cipher;
        if (this.f21539key == null) {
            throw new IllegalStateException("cipher not initialised");
        }
        int macSize = this.f21537engine.m15347getMac().getMacSize();
        int fieldSize = this.otherKeyParameter == null ? ((((ECKeyParameters) this.f21539key).getParameters().getCurve().getFieldSize() + 7) / 8) * 2 : 0;
        int size = this.f21536buffer.size() + i;
        if (this.f21537engine.getCipher() != null) {
            int i2 = this.f21541state;
            if (i2 == 1 || i2 == 3) {
                cipher = this.f21537engine.getCipher();
            } else {
                if (i2 != 2 && i2 != 4) {
                    throw new IllegalStateException("cipher not initialised");
                }
                cipher = this.f21537engine.getCipher();
                size = (size - macSize) - fieldSize;
            }
            size = cipher.getOutputSize(size);
        }
        int i3 = this.f21541state;
        if (i3 == 1 || i3 == 3) {
            return macSize + fieldSize + size;
        }
        if (i3 == 2 || i3 == 4) {
            return size;
        }
        throw new IllegalStateException("cipher not initialised");
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() throws InvalidParameterSpecException {
        if (this.engineParam == null && this.engineSpec != null) {
            try {
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f21538helper.createAlgorithmParameters("IES");
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
        this.f21536buffer.write(bArr, i, i2);
        return 0;
    }

    public IESCipher(IESEngine iESEngine, int i) {
        this.f21538helper = new BCJcaJceHelper();
        this.f21541state = -1;
        this.f21536buffer = new ByteArrayOutputStream();
        this.engineParam = null;
        this.engineSpec = null;
        this.dhaesMode = false;
        this.otherKeyParameter = null;
        this.f21537engine = iESEngine;
        this.ivLength = i;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws BadBlockException {
        if (i2 != 0) {
            this.f21536buffer.write(bArr, i, i2);
        }
        byte[] byteArray = this.f21536buffer.toByteArray();
        this.f21536buffer.reset();
        CipherParameters iESWithCipherParameters = new IESWithCipherParameters(this.engineSpec.getDerivationV(), this.engineSpec.getEncodingV(), this.engineSpec.getMacKeySize(), this.engineSpec.getCipherKeySize());
        byte[] nonce = this.engineSpec.getNonce();
        if (nonce != null) {
            iESWithCipherParameters = new ParametersWithIV(iESWithCipherParameters, nonce);
        }
        AsymmetricKeyParameter asymmetricKeyParameter = this.otherKeyParameter;
        if (asymmetricKeyParameter != null) {
            try {
                int i3 = this.f21541state;
                if (i3 == 1 || i3 == 3) {
                    this.f21537engine.m15350init(true, asymmetricKeyParameter, this.f21539key, iESWithCipherParameters);
                } else {
                    this.f21537engine.m15350init(false, this.f21539key, asymmetricKeyParameter, iESWithCipherParameters);
                }
                return this.f21537engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e) {
                throw new BadBlockException("unable to process block", e);
            }
        }
        AsymmetricKeyParameter asymmetricKeyParameter2 = this.f21539key;
        final boolean z = (asymmetricKeyParameter2 instanceof X25519PublicKeyParameters) || (asymmetricKeyParameter2 instanceof X25519PrivateKeyParameters);
        int i4 = z ? 256 : 448;
        int i5 = this.f21541state;
        if (i5 == 1 || i5 == 3) {
            AsymmetricCipherKeyPairGenerator x25519KeyPairGenerator = z ? new X25519KeyPairGenerator() : new X448KeyPairGenerator();
            x25519KeyPairGenerator.mo14944init(new KeyGenerationParameters(this.f21540random, i4));
            try {
                this.f21537engine.m15349init(this.f21539key, iESWithCipherParameters, new EphemeralKeyPairGenerator(x25519KeyPairGenerator, new KeyEncoder(this) { // from class: org.bouncycastle.jcajce.provider.asymmetric.edec.IESCipher.1

                    /* renamed from: this$0 */
                    final /* synthetic */ IESCipher f21542this$0;

                    {
                        this.f21542this$0 = this;
                    }

                    @Override // org.bouncycastle.p194crypto.KeyEncoder
                    public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter3) {
                        return z ? ((X25519PublicKeyParameters) asymmetricKeyParameter3).getEncoded() : ((X448PublicKeyParameters) asymmetricKeyParameter3).getEncoded();
                    }
                }));
                return this.f21537engine.processBlock(byteArray, 0, byteArray.length);
            } catch (Exception e2) {
                throw new BadBlockException("unable to process block", e2);
            }
        }
        if (i5 != 2 && i5 != 4) {
            throw new IllegalStateException("cipher not initialised");
        }
        try {
            this.f21537engine.m15348init(asymmetricKeyParameter2, iESWithCipherParameters, new XIESPublicKeyParser(z));
            return this.f21537engine.processBlock(byteArray, 0, byteArray.length);
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
        this.f21536buffer.write(bArr, i, i2);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        IESParameterSpec iESParameterSpecGuessParameterSpec;
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePublicKeyParameter;
        this.otherKeyParameter = null;
        if (algorithmParameterSpec == null && this.ivLength == 0) {
            iESParameterSpecGuessParameterSpec = C5619IESUtil.guessParameterSpec(this.f21537engine.getCipher(), null);
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
            if (!(key instanceof PublicKey)) {
                throw new InvalidKeyException("must be passed recipient's public XDH key for encryption");
            }
            asymmetricKeyParameterGeneratePublicKeyParameter = EdECUtil.generatePublicKeyParameter((PublicKey) key);
        } else {
            if (i != 2 && i != 4) {
                throw new InvalidKeyException("must be passed XDH key");
            }
            if (!(key instanceof PrivateKey)) {
                throw new InvalidKeyException("must be passed recipient's private XDH key for decryption");
            }
            asymmetricKeyParameterGeneratePublicKeyParameter = EdECUtil.generatePrivateKeyParameter((PrivateKey) key);
        }
        this.f21539key = asymmetricKeyParameterGeneratePublicKeyParameter;
        this.f21540random = secureRandom;
        this.f21541state = i;
        this.f21536buffer.reset();
    }
}
