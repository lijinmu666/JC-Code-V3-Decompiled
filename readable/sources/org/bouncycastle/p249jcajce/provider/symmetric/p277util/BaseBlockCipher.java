package org.bouncycastle.p249jcajce.provider.symmetric.p277util;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.crypto.spec.RC2ParameterSpec;
import javax.crypto.spec.RC5ParameterSpec;
import org.bouncycastle.internal.p231asn1.p233cms.GCMParameters;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.DefaultBufferedBlockCipher;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p201engines.DSTU7624Engine;
import org.bouncycastle.p194crypto.p202fpe.FPEEngine;
import org.bouncycastle.p194crypto.p202fpe.FPEFF1Engine;
import org.bouncycastle.p194crypto.p202fpe.FPEFF3_1Engine;
import org.bouncycastle.p194crypto.p210modes.AEADBlockCipher;
import org.bouncycastle.p194crypto.p210modes.AEADCipher;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p210modes.CCMBlockCipher;
import org.bouncycastle.p194crypto.p210modes.CFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.CTSBlockCipher;
import org.bouncycastle.p194crypto.p210modes.EAXBlockCipher;
import org.bouncycastle.p194crypto.p210modes.GCFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.GCMBlockCipher;
import org.bouncycastle.p194crypto.p210modes.GCMSIVBlockCipher;
import org.bouncycastle.p194crypto.p210modes.GOFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.KCCMBlockCipher;
import org.bouncycastle.p194crypto.p210modes.KCTRBlockCipher;
import org.bouncycastle.p194crypto.p210modes.KGCMBlockCipher;
import org.bouncycastle.p194crypto.p210modes.OCBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.OFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.OpenPGPCFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.PGPCFBBlockCipher;
import org.bouncycastle.p194crypto.p210modes.SICBlockCipher;
import org.bouncycastle.p194crypto.p213params.AEADParameters;
import org.bouncycastle.p194crypto.p213params.FPEParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.ParametersWithSBox;
import org.bouncycastle.p194crypto.p213params.RC2Parameters;
import org.bouncycastle.p194crypto.p213params.RC5Parameters;
import org.bouncycastle.p194crypto.paddings.BlockCipherPadding;
import org.bouncycastle.p194crypto.paddings.ISO10126d2Padding;
import org.bouncycastle.p194crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.p194crypto.paddings.PKCS7Padding;
import org.bouncycastle.p194crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.p194crypto.paddings.TBCPadding;
import org.bouncycastle.p194crypto.paddings.X923Padding;
import org.bouncycastle.p194crypto.paddings.ZeroBytePadding;
import org.bouncycastle.p249jcajce.PBKDF1Key;
import org.bouncycastle.p249jcajce.PBKDF1KeyWithParameters;
import org.bouncycastle.p249jcajce.PBKDF2Key;
import org.bouncycastle.p249jcajce.PBKDF2KeyWithParameters;
import org.bouncycastle.p249jcajce.PKCS12Key;
import org.bouncycastle.p249jcajce.PKCS12KeyWithParameters;
import org.bouncycastle.p249jcajce.p279spec.AEADParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.FPEParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.GOST28147ParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.RepeatedSecretKeySpec;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher;
import org.bouncycastle.p249jcajce.provider.symmetric.p277util.InterfaceC5795PBE;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BaseBlockCipher extends BaseWrapCipher implements InterfaceC5795PBE {
    private static final int BUF_SIZE = 512;
    private static final Class[] availableSpecs = {RC2ParameterSpec.class, RC5ParameterSpec.class, GcmSpecUtil.gcmSpecClass, GOST28147ParameterSpec.class, IvParameterSpec.class, PBEParameterSpec.class};
    private AEADParameters aeadParams;
    private BlockCipher baseEngine;

    /* renamed from: cipher */
    private GenericBlockCipher f21854cipher;

    /* renamed from: digest */
    private int f21855digest;
    private BlockCipherProvider engineProvider;

    /* renamed from: fixedIv */
    private boolean f21856fixedIv;
    private int ivLength;

    /* renamed from: ivParam */
    private ParametersWithIV f21857ivParam;
    private int keySizeInBits;
    private String modeName;

    /* renamed from: padded */
    private boolean f21858padded;
    private String pbeAlgorithm;

    /* renamed from: pbeSpec */
    private PBEParameterSpec f21859pbeSpec;

    /* renamed from: scheme */
    private int f21860scheme;

    public static class AEADGenericBlockCipher implements GenericBlockCipher {
        private static final Constructor aeadBadTagConstructor;

        /* renamed from: cipher */
        private AEADCipher f21861cipher;

        static {
            Class clsLoadClass = ClassUtil.loadClass(BaseBlockCipher.class, "javax.crypto.AEADBadTagException");
            aeadBadTagConstructor = clsLoadClass != null ? findExceptionConstructor(clsLoadClass) : null;
        }

        public AEADGenericBlockCipher(AEADCipher aEADCipher) {
            this.f21861cipher = aEADCipher;
        }

        private static Constructor findExceptionConstructor(Class cls) {
            try {
                return cls.getConstructor(String.class);
            } catch (Exception unused) {
                return null;
            }
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        /* renamed from: doFinal */
        public int mo16176doFinal(byte[] bArr, int i) throws BadPaddingException {
            BadPaddingException badPaddingException;
            try {
                return this.f21861cipher.mo15224doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                Constructor constructor = aeadBadTagConstructor;
                if (constructor != null) {
                    try {
                        badPaddingException = (BadPaddingException) constructor.newInstance(e.getMessage());
                    } catch (Exception unused) {
                        badPaddingException = null;
                    }
                    if (badPaddingException != null) {
                        throw badPaddingException;
                    }
                }
                throw new BadPaddingException(e.getMessage());
            }
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public String getAlgorithmName() {
            AEADCipher aEADCipher = this.f21861cipher;
            return aEADCipher instanceof AEADBlockCipher ? ((AEADBlockCipher) aEADCipher).getUnderlyingCipher().getAlgorithmName() : aEADCipher.getAlgorithmName();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getOutputSize(int i) {
            return this.f21861cipher.getOutputSize(i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public BlockCipher getUnderlyingCipher() {
            AEADCipher aEADCipher = this.f21861cipher;
            if (aEADCipher instanceof AEADBlockCipher) {
                return ((AEADBlockCipher) aEADCipher).getUnderlyingCipher();
            }
            return null;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getUpdateOutputSize(int i) {
            return this.f21861cipher.getUpdateOutputSize(i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        /* renamed from: init */
        public void mo16177init(boolean z, CipherParameters cipherParameters) {
            this.f21861cipher.mo15226init(z, cipherParameters);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processByte(byte b, byte[] bArr, int i) {
            return this.f21861cipher.processByte(b, bArr, i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            return this.f21861cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void updateAAD(byte[] bArr, int i, int i2) {
            this.f21861cipher.processAADBytes(bArr, i, i2);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public boolean wrapOnNoPadding() {
            return false;
        }
    }

    public static class BufferedFPEBlockCipher implements GenericBlockCipher {

        /* renamed from: cipher */
        private FPEEngine f21862cipher;

        /* renamed from: eOut */
        private BaseWrapCipher.ErasableOutputStream f21863eOut = new BaseWrapCipher.ErasableOutputStream();

        public BufferedFPEBlockCipher(FPEEngine fPEEngine) {
            this.f21862cipher = fPEEngine;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        /* renamed from: doFinal */
        public int mo16176doFinal(byte[] bArr, int i) {
            try {
                return this.f21862cipher.processBlock(this.f21863eOut.m16180getBuf(), 0, this.f21863eOut.size(), bArr, i);
            } finally {
                this.f21863eOut.m16179erase();
            }
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public String getAlgorithmName() {
            return this.f21862cipher.getAlgorithmName();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getOutputSize(int i) {
            return this.f21863eOut.size() + i;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public BlockCipher getUnderlyingCipher() {
            throw new IllegalStateException("not applicable for FPE");
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getUpdateOutputSize(int i) {
            return 0;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        /* renamed from: init */
        public void mo16177init(boolean z, CipherParameters cipherParameters) {
            this.f21862cipher.mo15468init(z, cipherParameters);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processByte(byte b, byte[] bArr, int i) throws IOException {
            this.f21863eOut.write(b);
            return 0;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IOException {
            this.f21863eOut.write(bArr, i, i2);
            return 0;
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void updateAAD(byte[] bArr, int i, int i2) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public boolean wrapOnNoPadding() {
            return false;
        }
    }

    public static class BufferedGenericBlockCipher implements GenericBlockCipher {

        /* renamed from: cipher */
        private BufferedBlockCipher f21864cipher;

        public BufferedGenericBlockCipher(BlockCipher blockCipher) {
            this(blockCipher, new PKCS7Padding());
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        /* renamed from: doFinal */
        public int mo16176doFinal(byte[] bArr, int i) throws BadPaddingException {
            try {
                return this.f21864cipher.mo14951doFinal(bArr, i);
            } catch (InvalidCipherTextException e) {
                throw new BadPaddingException(e.getMessage());
            }
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public String getAlgorithmName() {
            return this.f21864cipher.getUnderlyingCipher().getAlgorithmName();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getOutputSize(int i) {
            return this.f21864cipher.getOutputSize(i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public BlockCipher getUnderlyingCipher() {
            return this.f21864cipher.getUnderlyingCipher();
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int getUpdateOutputSize(int i) {
            return this.f21864cipher.getUpdateOutputSize(i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        /* renamed from: init */
        public void mo16177init(boolean z, CipherParameters cipherParameters) {
            this.f21864cipher.mo14952init(z, cipherParameters);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processByte(byte b, byte[] bArr, int i) {
            return this.f21864cipher.processByte(b, bArr, i);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
            return this.f21864cipher.processBytes(bArr, i, i2, bArr2, i3);
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public void updateAAD(byte[] bArr, int i, int i2) {
            throw new UnsupportedOperationException("AAD is not supported in the current mode.");
        }

        @Override // org.bouncycastle.jcajce.provider.symmetric.util.BaseBlockCipher.GenericBlockCipher
        public boolean wrapOnNoPadding() {
            return !(this.f21864cipher instanceof CTSBlockCipher);
        }

        public BufferedGenericBlockCipher(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
            this.f21864cipher = new PaddedBufferedBlockCipher(blockCipher, blockCipherPadding);
        }

        public BufferedGenericBlockCipher(BufferedBlockCipher bufferedBlockCipher) {
            this.f21864cipher = bufferedBlockCipher;
        }
    }

    public interface GenericBlockCipher {
        /* renamed from: doFinal */
        int mo16176doFinal(byte[] bArr, int i);

        String getAlgorithmName();

        int getOutputSize(int i);

        BlockCipher getUnderlyingCipher();

        int getUpdateOutputSize(int i);

        /* renamed from: init */
        void mo16177init(boolean z, CipherParameters cipherParameters);

        int processByte(byte b, byte[] bArr, int i);

        int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

        void updateAAD(byte[] bArr, int i, int i2);

        boolean wrapOnNoPadding();
    }

    public BaseBlockCipher(int i, BlockCipher blockCipher, int i2) {
        this.f21860scheme = -1;
        this.ivLength = 0;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.keySizeInBits = i;
        this.baseEngine = blockCipher;
        this.f21856fixedIv = true;
        this.f21854cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = i2 / 8;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private CipherParameters adjustParameters(AlgorithmParameterSpec algorithmParameterSpec, CipherParameters cipherParameters) {
        ParametersWithSBox parametersWithSBox;
        ParametersWithIV parametersWithIV;
        if (cipherParameters instanceof ParametersWithIV) {
            CipherParameters parameters = ((ParametersWithIV) cipherParameters).getParameters();
            if (algorithmParameterSpec instanceof IvParameterSpec) {
                parametersWithIV = new ParametersWithIV(parameters, ((IvParameterSpec) algorithmParameterSpec).getIV());
            } else {
                if (!(algorithmParameterSpec instanceof GOST28147ParameterSpec)) {
                    return cipherParameters;
                }
                GOST28147ParameterSpec gOST28147ParameterSpec = (GOST28147ParameterSpec) algorithmParameterSpec;
                ParametersWithSBox parametersWithSBox2 = new ParametersWithSBox(cipherParameters, gOST28147ParameterSpec.m16192getSBox());
                if (gOST28147ParameterSpec.m16191getIV() == null || this.ivLength == 0) {
                    return parametersWithSBox2;
                }
                parametersWithIV = new ParametersWithIV(parameters, gOST28147ParameterSpec.m16191getIV());
            }
            this.f21857ivParam = parametersWithIV;
            return parametersWithIV;
        }
        if (algorithmParameterSpec instanceof IvParameterSpec) {
            ParametersWithIV parametersWithIV2 = new ParametersWithIV(cipherParameters, ((IvParameterSpec) algorithmParameterSpec).getIV());
            this.f21857ivParam = parametersWithIV2;
            parametersWithSBox = parametersWithIV2;
        } else {
            if (!(algorithmParameterSpec instanceof GOST28147ParameterSpec)) {
                return cipherParameters;
            }
            GOST28147ParameterSpec gOST28147ParameterSpec2 = (GOST28147ParameterSpec) algorithmParameterSpec;
            ParametersWithSBox parametersWithSBox3 = new ParametersWithSBox(cipherParameters, gOST28147ParameterSpec2.m16192getSBox());
            parametersWithSBox = parametersWithSBox3;
            if (gOST28147ParameterSpec2.m16191getIV() != null) {
                parametersWithSBox = parametersWithSBox3;
                if (this.ivLength != 0) {
                    return new ParametersWithIV(parametersWithSBox3, gOST28147ParameterSpec2.m16191getIV());
                }
            }
        }
        return parametersWithSBox;
    }

    private boolean isAEADModeName(String str) {
        return "CCM".equals(str) || "EAX".equals(str) || "GCM".equals(str) || "GCM-SIV".equals(str) || "OCB".equals(str);
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws IllegalBlockSizeException, ShortBufferException {
        int iProcessBytes;
        if (engineGetOutputSize(i2) + i3 > bArr2.length) {
            throw new ShortBufferException("output buffer too short for input.");
        }
        if (i2 != 0) {
            try {
                iProcessBytes = this.f21854cipher.processBytes(bArr, i, i2, bArr2, i3);
            } catch (OutputLengthException e) {
                throw new IllegalBlockSizeException(e.getMessage());
            } catch (DataLengthException e2) {
                throw new IllegalBlockSizeException(e2.getMessage());
            }
        } else {
            iProcessBytes = 0;
        }
        return iProcessBytes + this.f21854cipher.mo16176doFinal(bArr2, i3 + iProcessBytes);
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        BlockCipher blockCipher = this.baseEngine;
        if (blockCipher == null) {
            return -1;
        }
        return blockCipher.getBlockSize();
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        AEADParameters aEADParameters = this.aeadParams;
        if (aEADParameters != null) {
            return aEADParameters.getNonce();
        }
        ParametersWithIV parametersWithIV = this.f21857ivParam;
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
        return this.f21854cipher.getOutputSize(i);
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public AlgorithmParameters engineGetParameters() throws InvalidParameterSpecException, IOException {
        if (this.engineParams == null) {
            if (this.f21859pbeSpec != null) {
                try {
                    AlgorithmParameters algorithmParametersCreateParametersInstance = createParametersInstance(this.pbeAlgorithm);
                    this.engineParams = algorithmParametersCreateParametersInstance;
                    algorithmParametersCreateParametersInstance.init(this.f21859pbeSpec);
                } catch (Exception unused) {
                    return null;
                }
            } else if (this.aeadParams != null) {
                if (this.baseEngine == null) {
                    try {
                        AlgorithmParameters algorithmParametersCreateParametersInstance2 = createParametersInstance(PKCSObjectIdentifiers.id_alg_AEADChaCha20Poly1305.m14433getId());
                        this.engineParams = algorithmParametersCreateParametersInstance2;
                        algorithmParametersCreateParametersInstance2.init(new DEROctetString(this.aeadParams.getNonce()).getEncoded());
                    } catch (Exception e) {
                        throw new RuntimeException(e.toString());
                    }
                } else {
                    try {
                        AlgorithmParameters algorithmParametersCreateParametersInstance3 = createParametersInstance("GCM");
                        this.engineParams = algorithmParametersCreateParametersInstance3;
                        algorithmParametersCreateParametersInstance3.init(new GCMParameters(this.aeadParams.getNonce(), this.aeadParams.getMacSize() / 8).getEncoded());
                    } catch (Exception e2) {
                        throw new RuntimeException(e2.toString());
                    }
                }
            } else if (this.f21857ivParam != null) {
                String algorithmName = this.f21854cipher.getUnderlyingCipher().getAlgorithmName();
                if (algorithmName.indexOf(47) >= 0) {
                    algorithmName = algorithmName.substring(0, algorithmName.indexOf(47));
                }
                try {
                    AlgorithmParameters algorithmParametersCreateParametersInstance4 = createParametersInstance(algorithmName);
                    this.engineParams = algorithmParametersCreateParametersInstance4;
                    algorithmParametersCreateParametersInstance4.init(new IvParameterSpec(this.f21857ivParam.m15801getIV()));
                } catch (Exception e3) {
                    throw new RuntimeException(e3.toString());
                }
            }
        }
        return this.engineParams;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameters algorithmParameters, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        AlgorithmParameterSpec algorithmParameterSpecExtractSpec;
        if (algorithmParameters != null) {
            algorithmParameterSpecExtractSpec = SpecUtil.extractSpec(algorithmParameters, availableSpecs);
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
        GenericBlockCipher aEADGenericBlockCipher;
        BufferedGenericBlockCipher bufferedGenericBlockCipher;
        if (this.baseEngine == null) {
            throw new NoSuchAlgorithmException("no mode supported for this algorithm");
        }
        String upperCase = C6250Strings.toUpperCase(str);
        this.modeName = upperCase;
        if (upperCase.equals("ECB")) {
            this.ivLength = 0;
            aEADGenericBlockCipher = new BufferedGenericBlockCipher(this.baseEngine);
        } else if (this.modeName.equals("CBC")) {
            this.ivLength = this.baseEngine.getBlockSize();
            aEADGenericBlockCipher = new BufferedGenericBlockCipher(CBCBlockCipher.newInstance(this.baseEngine));
        } else if (this.modeName.startsWith("OFB")) {
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new OFBBlockCipher(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                this.f21854cipher = bufferedGenericBlockCipher;
                return;
            } else {
                BlockCipher blockCipher = this.baseEngine;
                aEADGenericBlockCipher = new BufferedGenericBlockCipher(new OFBBlockCipher(blockCipher, blockCipher.getBlockSize() * 8));
            }
        } else {
            if (!this.modeName.startsWith("CFB")) {
                if (this.modeName.startsWith("PGPCFB")) {
                    boolean zEquals = this.modeName.equals("PGPCFBWITHIV");
                    if (!zEquals && this.modeName.length() != 6) {
                        throw new NoSuchAlgorithmException("no mode support for " + this.modeName);
                    }
                    this.ivLength = this.baseEngine.getBlockSize();
                    bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new PGPCFBBlockCipher(this.baseEngine, zEquals));
                } else if (this.modeName.equals("OPENPGPCFB")) {
                    this.ivLength = 0;
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher(new OpenPGPCFBBlockCipher(this.baseEngine));
                } else if (this.modeName.equals("FF1")) {
                    this.ivLength = 0;
                    aEADGenericBlockCipher = new BufferedFPEBlockCipher(new FPEFF1Engine(this.baseEngine));
                } else if (this.modeName.equals("FF3-1")) {
                    this.ivLength = 0;
                    aEADGenericBlockCipher = new BufferedFPEBlockCipher(new FPEFF3_1Engine(this.baseEngine));
                } else if (this.modeName.equals("SIC")) {
                    int blockSize = this.baseEngine.getBlockSize();
                    this.ivLength = blockSize;
                    if (blockSize < 16) {
                        throw new IllegalArgumentException("Warning: SIC-Mode can become a twotime-pad if the blocksize of the cipher is too small. Use a cipher with a block size of at least 128 bits (e.g. AES)");
                    }
                    this.f21856fixedIv = false;
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher(new DefaultBufferedBlockCipher(SICBlockCipher.newInstance(this.baseEngine)));
                } else if (this.modeName.equals("CTR")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    this.f21856fixedIv = false;
                    BlockCipher blockCipher2 = this.baseEngine;
                    bufferedGenericBlockCipher = blockCipher2 instanceof DSTU7624Engine ? new BufferedGenericBlockCipher(new DefaultBufferedBlockCipher(new KCTRBlockCipher(blockCipher2))) : new BufferedGenericBlockCipher(new DefaultBufferedBlockCipher(SICBlockCipher.newInstance(blockCipher2)));
                } else if (this.modeName.equals("GOFB")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher(new DefaultBufferedBlockCipher(new GOFBBlockCipher(this.baseEngine)));
                } else if (this.modeName.equals("GCFB")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher(new DefaultBufferedBlockCipher(new GCFBBlockCipher(this.baseEngine)));
                } else if (this.modeName.equals("CTS")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    aEADGenericBlockCipher = new BufferedGenericBlockCipher(new CTSBlockCipher(CBCBlockCipher.newInstance(this.baseEngine)));
                } else if (this.modeName.equals("CCM")) {
                    this.ivLength = 12;
                    aEADGenericBlockCipher = this.baseEngine instanceof DSTU7624Engine ? new AEADGenericBlockCipher(new KCCMBlockCipher(this.baseEngine)) : new AEADGenericBlockCipher(CCMBlockCipher.newInstance(this.baseEngine));
                } else if (this.modeName.equals("OCB")) {
                    if (this.engineProvider == null) {
                        throw new NoSuchAlgorithmException("can't support mode " + str);
                    }
                    this.ivLength = 15;
                    aEADGenericBlockCipher = new AEADGenericBlockCipher(new OCBBlockCipher(this.baseEngine, this.engineProvider.mo16172get()));
                } else if (this.modeName.equals("EAX")) {
                    this.ivLength = this.baseEngine.getBlockSize();
                    aEADGenericBlockCipher = new AEADGenericBlockCipher(new EAXBlockCipher(this.baseEngine));
                } else if (this.modeName.equals("GCM-SIV")) {
                    this.ivLength = 12;
                    aEADGenericBlockCipher = new AEADGenericBlockCipher(new GCMSIVBlockCipher(this.baseEngine));
                } else {
                    if (!this.modeName.equals("GCM")) {
                        throw new NoSuchAlgorithmException("can't support mode " + str);
                    }
                    BlockCipher blockCipher3 = this.baseEngine;
                    if (blockCipher3 instanceof DSTU7624Engine) {
                        this.ivLength = blockCipher3.getBlockSize();
                        aEADGenericBlockCipher = new AEADGenericBlockCipher(new KGCMBlockCipher(this.baseEngine));
                    } else {
                        this.ivLength = 12;
                        aEADGenericBlockCipher = new AEADGenericBlockCipher(GCMBlockCipher.newInstance(this.baseEngine));
                    }
                }
                this.f21854cipher = bufferedGenericBlockCipher;
                return;
            }
            this.ivLength = this.baseEngine.getBlockSize();
            if (this.modeName.length() != 3) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(CFBBlockCipher.newInstance(this.baseEngine, Integer.parseInt(this.modeName.substring(3))));
                this.f21854cipher = bufferedGenericBlockCipher;
                return;
            } else {
                BlockCipher blockCipher4 = this.baseEngine;
                aEADGenericBlockCipher = new BufferedGenericBlockCipher(CFBBlockCipher.newInstance(blockCipher4, blockCipher4.getBlockSize() * 8));
            }
        }
        this.f21854cipher = aEADGenericBlockCipher;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        BufferedGenericBlockCipher bufferedGenericBlockCipher;
        if (this.baseEngine == null) {
            throw new NoSuchPaddingException("no padding supported for this algorithm");
        }
        String upperCase = C6250Strings.toUpperCase(str);
        if (upperCase.equals("NOPADDING")) {
            if (!this.f21854cipher.wrapOnNoPadding()) {
                return;
            } else {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new DefaultBufferedBlockCipher(this.f21854cipher.getUnderlyingCipher()));
            }
        } else if (upperCase.equals("WITHCTS") || upperCase.equals("CTSPADDING") || upperCase.equals("CS3PADDING")) {
            bufferedGenericBlockCipher = new BufferedGenericBlockCipher(new CTSBlockCipher(this.f21854cipher.getUnderlyingCipher()));
        } else {
            this.f21858padded = true;
            if (isAEADModeName(this.modeName)) {
                throw new NoSuchPaddingException("Only NoPadding can be used with AEAD modes.");
            }
            if (upperCase.equals("PKCS5PADDING") || upperCase.equals("PKCS7PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.f21854cipher.getUnderlyingCipher());
            } else if (upperCase.equals("ZEROBYTEPADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.f21854cipher.getUnderlyingCipher(), new ZeroBytePadding());
            } else if (upperCase.equals("ISO10126PADDING") || upperCase.equals("ISO10126-2PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.f21854cipher.getUnderlyingCipher(), new ISO10126d2Padding());
            } else if (upperCase.equals("X9.23PADDING") || upperCase.equals("X923PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.f21854cipher.getUnderlyingCipher(), new X923Padding());
            } else if (upperCase.equals("ISO7816-4PADDING") || upperCase.equals("ISO9797-1PADDING")) {
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.f21854cipher.getUnderlyingCipher(), new ISO7816d4Padding());
            } else {
                if (!upperCase.equals("TBCPADDING")) {
                    throw new NoSuchPaddingException("Padding " + str + " unknown.");
                }
                bufferedGenericBlockCipher = new BufferedGenericBlockCipher(this.f21854cipher.getUnderlyingCipher(), new TBCPadding());
            }
        }
        this.f21854cipher = bufferedGenericBlockCipher;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws ShortBufferException {
        if (this.f21854cipher.getUpdateOutputSize(i2) + i3 > bArr2.length) {
            throw new ShortBufferException("output buffer too short for input.");
        }
        try {
            return this.f21854cipher.processBytes(bArr, i, i2, bArr2, i3);
        } catch (DataLengthException e) {
            throw new IllegalStateException(e.toString());
        }
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        if (iRemaining < 1) {
            return;
        }
        if (byteBuffer.hasArray()) {
            engineUpdateAAD(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), iRemaining);
            byteBuffer.position(byteBuffer.limit());
            return;
        }
        if (iRemaining <= 512) {
            byte[] bArr = new byte[iRemaining];
            byteBuffer.get(bArr);
            engineUpdateAAD(bArr, 0, iRemaining);
            C6238Arrays.m18249fill(bArr, (byte) 0);
            return;
        }
        byte[] bArr2 = new byte[512];
        do {
            int iMin = Math.min(512, iRemaining);
            byteBuffer.get(bArr2, 0, iMin);
            engineUpdateAAD(bArr2, 0, iMin);
            iRemaining -= iMin;
        } while (iRemaining > 0);
        C6238Arrays.m18249fill(bArr2, (byte) 0);
    }

    public BaseBlockCipher(int i, BufferedBlockCipher bufferedBlockCipher, int i2) {
        this.f21860scheme = -1;
        this.ivLength = 0;
        this.f21856fixedIv = true;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.keySizeInBits = i;
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.f21854cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.f21856fixedIv = true;
        this.ivLength = i2 / 8;
    }

    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws IllegalBlockSizeException {
        int iEngineGetOutputSize = engineGetOutputSize(i2);
        byte[] bArr2 = new byte[iEngineGetOutputSize];
        int iProcessBytes = i2 != 0 ? this.f21854cipher.processBytes(bArr, i, i2, bArr2, 0) : 0;
        try {
            int iMo16176doFinal = iProcessBytes + this.f21854cipher.mo16176doFinal(bArr2, iProcessBytes);
            if (iMo16176doFinal == iEngineGetOutputSize) {
                return bArr2;
            }
            if (iMo16176doFinal > iEngineGetOutputSize) {
                throw new IllegalBlockSizeException("internal buffer overflow");
            }
            byte[] bArr3 = new byte[iMo16176doFinal];
            System.arraycopy(bArr2, 0, bArr3, 0, iMo16176doFinal);
            return bArr3;
        } catch (DataLengthException e) {
            throw new IllegalBlockSizeException(e.getMessage());
        }
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
        int updateOutputSize = this.f21854cipher.getUpdateOutputSize(i2);
        if (updateOutputSize <= 0) {
            this.f21854cipher.processBytes(bArr, i, i2, null, 0);
            return null;
        }
        byte[] bArr2 = new byte[updateOutputSize];
        int iProcessBytes = this.f21854cipher.processBytes(bArr, i, i2, bArr2, 0);
        if (iProcessBytes == 0) {
            return null;
        }
        if (iProcessBytes == updateOutputSize) {
            return bArr2;
        }
        byte[] bArr3 = new byte[iProcessBytes];
        System.arraycopy(bArr2, 0, bArr3, 0, iProcessBytes);
        return bArr3;
    }

    @Override // javax.crypto.CipherSpi
    public void engineUpdateAAD(byte[] bArr, int i, int i2) {
        this.f21854cipher.updateAAD(bArr, i, i2);
    }

    public BaseBlockCipher(int i, AEADBlockCipher aEADBlockCipher) {
        this.f21860scheme = -1;
        this.ivLength = 0;
        this.f21856fixedIv = true;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.keySizeInBits = i;
        this.baseEngine = aEADBlockCipher.getUnderlyingCipher();
        this.ivLength = aEADBlockCipher.getAlgorithmName().indexOf("GCM") >= 0 ? 12 : this.baseEngine.getBlockSize();
        this.f21854cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x04fe A[Catch: Exception -> 0x04f3, IllegalArgumentException -> 0x04f5, TryCatch #3 {IllegalArgumentException -> 0x04f5, Exception -> 0x04f3, blocks: (B:259:0x04d7, B:260:0x04f2, B:265:0x04f7, B:267:0x0503, B:269:0x0509, B:271:0x050d, B:266:0x04fe), top: B:281:0x04ce }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ae A[PHI: r5
      0x00ae: PHI (r5v29 org.bouncycastle.crypto.CipherParameters) = 
      (r5v53 org.bouncycastle.crypto.CipherParameters)
      (r5v54 org.bouncycastle.crypto.CipherParameters)
      (r5v55 org.bouncycastle.crypto.CipherParameters)
      (r5v56 org.bouncycastle.crypto.CipherParameters)
      (r5v57 org.bouncycastle.crypto.CipherParameters)
     binds: [B:117:0x024d, B:74:0x0191, B:63:0x0144, B:47:0x00fc, B:34:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // org.bouncycastle.p249jcajce.provider.symmetric.p277util.BaseWrapCipher, javax.crypto.CipherSpi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        CipherParameters cipherParametersMakePBEParameters;
        FPEParameters fPEParameters;
        CipherParameters cipherParameters;
        ParametersWithIV parametersWithIV;
        CipherParameters parametersWithRandom;
        GenericBlockCipher genericBlockCipher;
        AEADParameters aEADParametersExtractAeadParameters;
        CipherParameters cipherParameters2;
        CipherParameters cipherParametersMakePBEParameters2;
        BlockCipher blockCipher;
        AlgorithmParameterSpec algorithmParameterSpec2 = algorithmParameterSpec;
        CipherParameters keyParameter = null;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.engineParams = null;
        this.aeadParams = null;
        if (!(key instanceof SecretKey)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Key for algorithm ");
            sb.append(key != null ? key.getAlgorithm() : null);
            sb.append(" not suitable for symmetric enryption.");
            throw new InvalidKeyException(sb.toString());
        }
        if (algorithmParameterSpec2 == null && (blockCipher = this.baseEngine) != null && blockCipher.getAlgorithmName().startsWith("RC5-64")) {
            throw new InvalidAlgorithmParameterException("RC5 requires an RC5ParametersSpec to be passed in.");
        }
        int i2 = this.f21860scheme;
        if (i2 == 2 || (key instanceof PKCS12Key)) {
            try {
                SecretKey secretKey = (SecretKey) key;
                if (algorithmParameterSpec2 instanceof PBEParameterSpec) {
                    this.f21859pbeSpec = (PBEParameterSpec) algorithmParameterSpec2;
                }
                boolean z = secretKey instanceof PBEKey;
                if (z && this.f21859pbeSpec == null) {
                    PBEKey pBEKey = (PBEKey) secretKey;
                    if (pBEKey.getSalt() == null) {
                        throw new InvalidAlgorithmParameterException("PBEKey requires parameters to specify salt");
                    }
                    this.f21859pbeSpec = new PBEParameterSpec(pBEKey.getSalt(), pBEKey.getIterationCount());
                }
                if (this.f21859pbeSpec == null && !z) {
                    throw new InvalidKeyException("Algorithm requires a PBE key");
                }
                this.pbeAlgorithm = "PKCS12PBE";
                if (key instanceof BCPBEKey) {
                    CipherParameters param = ((BCPBEKey) key).getParam();
                    if (!(param instanceof ParametersWithIV)) {
                        if (param != null) {
                            throw new InvalidKeyException("Algorithm requires a PBE key suitable for PKCS12");
                        }
                        param = InterfaceC5795PBE.Util.makePBEParameters(secretKey.getEncoded(), 2, this.f21855digest, this.keySizeInBits, this.ivLength * 8, this.f21859pbeSpec, this.f21854cipher.getAlgorithmName());
                    }
                    cipherParametersMakePBEParameters = param;
                } else {
                    cipherParametersMakePBEParameters = InterfaceC5795PBE.Util.makePBEParameters(secretKey.getEncoded(), 2, this.f21855digest, this.keySizeInBits, this.ivLength * 8, this.f21859pbeSpec, this.f21854cipher.getAlgorithmName());
                }
                boolean z2 = cipherParametersMakePBEParameters instanceof ParametersWithIV;
                cipherParameters2 = cipherParametersMakePBEParameters;
                keyParameter = cipherParametersMakePBEParameters;
                if (z2) {
                    this.f21857ivParam = (ParametersWithIV) cipherParameters2;
                    keyParameter = cipherParameters2;
                }
            } catch (Exception unused) {
                throw new InvalidKeyException("PKCS12 requires a SecretKey/PBEKey");
            }
        } else if (key instanceof PBKDF1Key) {
            PBKDF1Key pBKDF1Key = (PBKDF1Key) key;
            if (algorithmParameterSpec2 instanceof PBEParameterSpec) {
                this.f21859pbeSpec = (PBEParameterSpec) algorithmParameterSpec2;
            }
            if ((pBKDF1Key instanceof PBKDF1KeyWithParameters) && this.f21859pbeSpec == null) {
                PBKDF1KeyWithParameters pBKDF1KeyWithParameters = (PBKDF1KeyWithParameters) pBKDF1Key;
                this.f21859pbeSpec = new PBEParameterSpec(pBKDF1KeyWithParameters.getSalt(), pBKDF1KeyWithParameters.getIterationCount());
            }
            CipherParameters cipherParametersMakePBEParameters3 = InterfaceC5795PBE.Util.makePBEParameters(pBKDF1Key.getEncoded(), 0, this.f21855digest, this.keySizeInBits, this.ivLength * 8, this.f21859pbeSpec, this.f21854cipher.getAlgorithmName());
            boolean z3 = cipherParametersMakePBEParameters3 instanceof ParametersWithIV;
            cipherParameters2 = cipherParametersMakePBEParameters3;
            keyParameter = cipherParametersMakePBEParameters3;
            if (z3) {
            }
        } else if (key instanceof PBKDF2Key) {
            PBKDF2Key pBKDF2Key = (PBKDF2Key) key;
            if (algorithmParameterSpec2 instanceof PBEParameterSpec) {
                this.f21859pbeSpec = (PBEParameterSpec) algorithmParameterSpec2;
            }
            if ((pBKDF2Key instanceof PBKDF2KeyWithParameters) && this.f21859pbeSpec == null) {
                PBKDF2KeyWithParameters pBKDF2KeyWithParameters = (PBKDF2KeyWithParameters) pBKDF2Key;
                this.f21859pbeSpec = new PBEParameterSpec(pBKDF2KeyWithParameters.getSalt(), pBKDF2KeyWithParameters.getIterationCount());
            }
            CipherParameters cipherParametersMakePBEParameters4 = InterfaceC5795PBE.Util.makePBEParameters(pBKDF2Key.getEncoded(), 1, 9, this.keySizeInBits, 0, this.f21859pbeSpec, this.f21854cipher.getAlgorithmName());
            boolean z4 = cipherParametersMakePBEParameters4 instanceof ParametersWithIV;
            cipherParameters2 = cipherParametersMakePBEParameters4;
            keyParameter = cipherParametersMakePBEParameters4;
            if (z4) {
            }
        } else if (key instanceof BCPBEKey) {
            BCPBEKey bCPBEKey = (BCPBEKey) key;
            this.pbeAlgorithm = bCPBEKey.m16174getOID() != null ? bCPBEKey.m16174getOID().m14433getId() : bCPBEKey.getAlgorithm();
            if (bCPBEKey.getParam() != null) {
                cipherParametersMakePBEParameters2 = adjustParameters(algorithmParameterSpec2, bCPBEKey.getParam());
            } else {
                if (!(algorithmParameterSpec2 instanceof PBEParameterSpec)) {
                    throw new InvalidAlgorithmParameterException("PBE requires PBE parameters to be set.");
                }
                this.f21859pbeSpec = (PBEParameterSpec) algorithmParameterSpec2;
                cipherParametersMakePBEParameters2 = InterfaceC5795PBE.Util.makePBEParameters(bCPBEKey, algorithmParameterSpec2, this.f21854cipher.getUnderlyingCipher().getAlgorithmName());
            }
            boolean z5 = cipherParametersMakePBEParameters2 instanceof ParametersWithIV;
            cipherParameters2 = cipherParametersMakePBEParameters2;
            keyParameter = cipherParametersMakePBEParameters2;
            if (z5) {
            }
        } else if (key instanceof PBEKey) {
            PBEKey pBEKey2 = (PBEKey) key;
            PBEParameterSpec pBEParameterSpec = (PBEParameterSpec) algorithmParameterSpec2;
            this.f21859pbeSpec = pBEParameterSpec;
            if ((pBEKey2 instanceof PKCS12KeyWithParameters) && pBEParameterSpec == null) {
                this.f21859pbeSpec = new PBEParameterSpec(pBEKey2.getSalt(), pBEKey2.getIterationCount());
            }
            CipherParameters cipherParametersMakePBEParameters5 = InterfaceC5795PBE.Util.makePBEParameters(pBEKey2.getEncoded(), this.f21860scheme, this.f21855digest, this.keySizeInBits, this.ivLength * 8, this.f21859pbeSpec, this.f21854cipher.getAlgorithmName());
            boolean z6 = cipherParametersMakePBEParameters5 instanceof ParametersWithIV;
            cipherParameters2 = cipherParametersMakePBEParameters5;
            keyParameter = cipherParametersMakePBEParameters5;
            if (z6) {
            }
        } else if (!(key instanceof RepeatedSecretKeySpec)) {
            if (i2 == 0 || i2 == 4 || i2 == 1 || i2 == 5) {
                throw new InvalidKeyException("Algorithm requires a PBE key");
            }
            keyParameter = new KeyParameter(key.getEncoded());
        }
        if (algorithmParameterSpec2 instanceof PBEParameterSpec) {
            AlgorithmParameterSpec parameterSpec = ((PBEParameterSpec) algorithmParameterSpec2).getParameterSpec();
            if (!(parameterSpec instanceof IvParameterSpec) || ((IvParameterSpec) parameterSpec).getIV().length != 0) {
                algorithmParameterSpec2 = parameterSpec;
            }
        }
        try {
            if (algorithmParameterSpec2 instanceof AEADParameterSpec) {
                if (!isAEADModeName(this.modeName) && !(this.f21854cipher instanceof AEADGenericBlockCipher)) {
                    throw new InvalidAlgorithmParameterException("AEADParameterSpec can only be used with AEAD modes.");
                }
                AEADParameterSpec aEADParameterSpec = (AEADParameterSpec) algorithmParameterSpec2;
                aEADParametersExtractAeadParameters = new AEADParameters(keyParameter instanceof ParametersWithIV ? (KeyParameter) ((ParametersWithIV) keyParameter).getParameters() : (KeyParameter) keyParameter, aEADParameterSpec.getMacSizeInBits(), aEADParameterSpec.getNonce(), aEADParameterSpec.getAssociatedData());
            } else {
                if (!(algorithmParameterSpec2 instanceof IvParameterSpec)) {
                    if (algorithmParameterSpec2 instanceof GOST28147ParameterSpec) {
                        GOST28147ParameterSpec gOST28147ParameterSpec = (GOST28147ParameterSpec) algorithmParameterSpec2;
                        ParametersWithSBox parametersWithSBox = new ParametersWithSBox(new KeyParameter(key.getEncoded()), gOST28147ParameterSpec.m16192getSBox());
                        cipherParameters = parametersWithSBox;
                        if (gOST28147ParameterSpec.m16191getIV() != null) {
                            cipherParameters = parametersWithSBox;
                            if (this.ivLength != 0) {
                                parametersWithIV = new ParametersWithIV(parametersWithSBox, gOST28147ParameterSpec.m16191getIV());
                                this.f21857ivParam = parametersWithIV;
                                fPEParameters = parametersWithIV;
                            }
                        }
                    } else if (algorithmParameterSpec2 instanceof RC2ParameterSpec) {
                        RC2ParameterSpec rC2ParameterSpec = (RC2ParameterSpec) algorithmParameterSpec2;
                        RC2Parameters rC2Parameters = new RC2Parameters(key.getEncoded(), rC2ParameterSpec.getEffectiveKeyBits());
                        cipherParameters = rC2Parameters;
                        if (rC2ParameterSpec.getIV() != null) {
                            cipherParameters = rC2Parameters;
                            if (this.ivLength != 0) {
                                parametersWithIV = new ParametersWithIV(rC2Parameters, rC2ParameterSpec.getIV());
                                this.f21857ivParam = parametersWithIV;
                                fPEParameters = parametersWithIV;
                            }
                        }
                    } else if (algorithmParameterSpec2 instanceof RC5ParameterSpec) {
                        RC5ParameterSpec rC5ParameterSpec = (RC5ParameterSpec) algorithmParameterSpec2;
                        RC5Parameters rC5Parameters = new RC5Parameters(key.getEncoded(), rC5ParameterSpec.getRounds());
                        if (!this.baseEngine.getAlgorithmName().startsWith("RC5")) {
                            throw new InvalidAlgorithmParameterException("RC5 parameters passed to a cipher that is not RC5.");
                        }
                        if (this.baseEngine.getAlgorithmName().equals("RC5-32")) {
                            if (rC5ParameterSpec.getWordSize() != 32) {
                                throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 32 not " + rC5ParameterSpec.getWordSize() + ".");
                            }
                        } else if (this.baseEngine.getAlgorithmName().equals("RC5-64") && rC5ParameterSpec.getWordSize() != 64) {
                            throw new InvalidAlgorithmParameterException("RC5 already set up for a word size of 64 not " + rC5ParameterSpec.getWordSize() + ".");
                        }
                        cipherParameters = rC5Parameters;
                        if (rC5ParameterSpec.getIV() != null) {
                            cipherParameters = rC5Parameters;
                            if (this.ivLength != 0) {
                                parametersWithIV = new ParametersWithIV(rC5Parameters, rC5ParameterSpec.getIV());
                                this.f21857ivParam = parametersWithIV;
                                fPEParameters = parametersWithIV;
                            }
                        }
                    } else if (algorithmParameterSpec2 instanceof FPEParameterSpec) {
                        FPEParameterSpec fPEParameterSpec = (FPEParameterSpec) algorithmParameterSpec2;
                        fPEParameters = new FPEParameters((KeyParameter) keyParameter, fPEParameterSpec.getRadixConverter(), fPEParameterSpec.getTweak(), fPEParameterSpec.isUsingInverseFunction());
                    } else {
                        cipherParameters = keyParameter;
                        if (GcmSpecUtil.isGcmSpec(algorithmParameterSpec2)) {
                            if (!isAEADModeName(this.modeName) && !(this.f21854cipher instanceof AEADGenericBlockCipher)) {
                                throw new InvalidAlgorithmParameterException("GCMParameterSpec can only be used with AEAD modes.");
                            }
                            aEADParametersExtractAeadParameters = GcmSpecUtil.extractAeadParameters(keyParameter instanceof ParametersWithIV ? (KeyParameter) ((ParametersWithIV) keyParameter).getParameters() : (KeyParameter) keyParameter, algorithmParameterSpec2);
                        } else if (algorithmParameterSpec2 != null) {
                            cipherParameters = keyParameter;
                            if (!(algorithmParameterSpec2 instanceof PBEParameterSpec)) {
                                throw new InvalidAlgorithmParameterException("unknown parameter type.");
                            }
                        }
                    }
                    cipherParameters = fPEParameters;
                } else if (this.ivLength != 0) {
                    IvParameterSpec ivParameterSpec = (IvParameterSpec) algorithmParameterSpec2;
                    if (ivParameterSpec.getIV().length == this.ivLength || (this.f21854cipher instanceof AEADGenericBlockCipher) || !this.f21856fixedIv) {
                        ParametersWithIV parametersWithIV2 = keyParameter instanceof ParametersWithIV ? new ParametersWithIV(((ParametersWithIV) keyParameter).getParameters(), ivParameterSpec.getIV()) : new ParametersWithIV(keyParameter, ivParameterSpec.getIV());
                        this.f21857ivParam = parametersWithIV2;
                        cipherParameters = parametersWithIV2;
                    } else {
                        throw new InvalidAlgorithmParameterException("IV must be " + this.ivLength + " bytes long.");
                    }
                } else {
                    String str = this.modeName;
                    cipherParameters = keyParameter;
                    if (str != null) {
                        cipherParameters = keyParameter;
                        if (str.equals("ECB")) {
                            throw new InvalidAlgorithmParameterException("ECB mode does not use an IV");
                        }
                    }
                }
                parametersWithRandom = cipherParameters;
                if (this.ivLength != 0) {
                    boolean z7 = cipherParameters instanceof ParametersWithIV;
                    parametersWithRandom = cipherParameters;
                    if (!z7) {
                        boolean z8 = cipherParameters instanceof AEADParameters;
                        parametersWithRandom = cipherParameters;
                        if (!z8) {
                            SecureRandom secureRandom2 = secureRandom == null ? CryptoServicesRegistrar.getSecureRandom() : secureRandom;
                            if (i == 1 || i == 3) {
                                byte[] bArr = new byte[this.ivLength];
                                secureRandom2.nextBytes(bArr);
                                ParametersWithIV parametersWithIV3 = new ParametersWithIV(cipherParameters, bArr);
                                this.f21857ivParam = parametersWithIV3;
                                parametersWithRandom = parametersWithIV3;
                            } else {
                                parametersWithRandom = cipherParameters;
                                if (this.f21854cipher.getUnderlyingCipher().getAlgorithmName().indexOf("PGPCFB") < 0) {
                                    throw new InvalidAlgorithmParameterException("no IV set when one expected");
                                }
                            }
                        }
                    }
                }
                if (secureRandom != null && this.f21858padded) {
                    parametersWithRandom = new ParametersWithRandom(parametersWithRandom, secureRandom);
                }
                if (i == 1) {
                    this.f21854cipher.mo16177init(true, parametersWithRandom);
                } else {
                    if (i != 2) {
                        if (i != 3) {
                            if (i != 4) {
                                throw new InvalidParameterException("unknown opmode " + i + " passed");
                            }
                        }
                        this.f21854cipher.mo16177init(true, parametersWithRandom);
                    }
                    this.f21854cipher.mo16177init(false, parametersWithRandom);
                }
                genericBlockCipher = this.f21854cipher;
                if ((genericBlockCipher instanceof AEADGenericBlockCipher) || this.aeadParams != null) {
                    return;
                }
                this.aeadParams = new AEADParameters((KeyParameter) this.f21857ivParam.getParameters(), ((AEADGenericBlockCipher) genericBlockCipher).f21861cipher.mo15225getMac().length * 8, this.f21857ivParam.m15801getIV());
                return;
            }
            if (i == 1) {
            }
            genericBlockCipher = this.f21854cipher;
            if (genericBlockCipher instanceof AEADGenericBlockCipher) {
                return;
            } else {
                return;
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidAlgorithmParameterException(e.getMessage(), e);
        } catch (Exception e2) {
            throw new BaseWrapCipher.InvalidKeyOrParametersException(e2.getMessage(), e2);
        }
        this.aeadParams = aEADParametersExtractAeadParameters;
        cipherParameters = aEADParametersExtractAeadParameters;
        parametersWithRandom = cipherParameters;
        if (this.ivLength != 0) {
        }
        if (secureRandom != null) {
            parametersWithRandom = new ParametersWithRandom(parametersWithRandom, secureRandom);
        }
    }

    public BaseBlockCipher(int i, AEADBlockCipher aEADBlockCipher, boolean z, int i2) {
        this.f21860scheme = -1;
        this.ivLength = 0;
        this.f21856fixedIv = true;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.keySizeInBits = i;
        this.baseEngine = aEADBlockCipher.getUnderlyingCipher();
        this.f21856fixedIv = z;
        this.ivLength = i2;
        this.f21854cipher = new AEADGenericBlockCipher(aEADBlockCipher);
    }

    public BaseBlockCipher(int i, BlockCipherProvider blockCipherProvider) {
        this.f21860scheme = -1;
        this.ivLength = 0;
        this.f21856fixedIv = true;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipherProvider.mo16172get();
        this.engineProvider = blockCipherProvider;
        this.keySizeInBits = i;
        this.f21854cipher = new BufferedGenericBlockCipher(blockCipherProvider.mo16172get());
    }

    public BaseBlockCipher(BlockCipher blockCipher) {
        this.f21860scheme = -1;
        this.ivLength = 0;
        this.f21856fixedIv = true;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.f21854cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    public BaseBlockCipher(BlockCipher blockCipher, int i) {
        this(blockCipher, true, i);
    }

    public BaseBlockCipher(BlockCipher blockCipher, int i, int i2, int i3, int i4) {
        this.f21856fixedIv = true;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.f21860scheme = i;
        this.f21855digest = i2;
        this.keySizeInBits = i3;
        this.ivLength = i4;
        this.f21854cipher = new BufferedGenericBlockCipher(blockCipher);
    }

    public BaseBlockCipher(BlockCipher blockCipher, boolean z, int i) {
        this.f21860scheme = -1;
        this.ivLength = 0;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipher;
        this.f21856fixedIv = z;
        this.f21854cipher = new BufferedGenericBlockCipher(blockCipher);
        this.ivLength = i / 8;
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, int i) {
        this(bufferedBlockCipher, true, i);
    }

    public BaseBlockCipher(BufferedBlockCipher bufferedBlockCipher, boolean z, int i) {
        this.f21860scheme = -1;
        this.ivLength = 0;
        this.f21856fixedIv = true;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = bufferedBlockCipher.getUnderlyingCipher();
        this.f21854cipher = new BufferedGenericBlockCipher(bufferedBlockCipher);
        this.f21856fixedIv = z;
        this.ivLength = i / 8;
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher) {
        this(0, aEADBlockCipher);
    }

    public BaseBlockCipher(AEADBlockCipher aEADBlockCipher, boolean z, int i) {
        this(0, aEADBlockCipher, z, i);
    }

    public BaseBlockCipher(AEADCipher aEADCipher, boolean z, int i) {
        this.f21860scheme = -1;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = null;
        this.f21856fixedIv = z;
        this.ivLength = i;
        this.f21854cipher = new AEADGenericBlockCipher(aEADCipher);
    }

    public BaseBlockCipher(BlockCipherProvider blockCipherProvider) {
        this.f21860scheme = -1;
        this.ivLength = 0;
        this.f21856fixedIv = true;
        this.f21859pbeSpec = null;
        this.pbeAlgorithm = null;
        this.modeName = null;
        this.baseEngine = blockCipherProvider.mo16172get();
        this.engineProvider = blockCipherProvider;
        this.f21854cipher = new BufferedGenericBlockCipher(blockCipherProvider.mo16172get());
    }
}
