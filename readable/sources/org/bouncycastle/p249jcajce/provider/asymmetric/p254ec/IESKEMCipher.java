package org.bouncycastle.p249jcajce.provider.asymmetric.p254ec;

import java.io.ByteArrayOutputStream;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.NoSuchPaddingException;
import org.bouncycastle.p133asn1.p176x9.X9IntegerConverter;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.EphemeralKeyPair;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.KeyEncoder;
import org.bouncycastle.p194crypto.agreement.ECDHCBasicAgreement;
import org.bouncycastle.p194crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.p194crypto.p201engines.IESEngine;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.KDFParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p249jcajce.p279spec.IESKEMParameterSpec;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi;
import org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey;
import org.bouncycastle.p281jce.p282spec.IESParameterSpec;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class IESKEMCipher extends BaseCipherSpi {
    private static final X9IntegerConverter converter = new X9IntegerConverter();
    private final ECDHCBasicAgreement agreement;

    /* renamed from: engine */
    private IESEngine f21496engine;

    /* renamed from: hMac */
    private final InterfaceC5278Mac f21497hMac;
    private int ivLength;

    /* renamed from: kdf */
    private final KDF2BytesGenerator f21499kdf;

    /* renamed from: key */
    private AsymmetricKeyParameter f21500key;
    private final int macKeyLength;
    private final int macLength;

    /* renamed from: random */
    private SecureRandom f21501random;

    /* renamed from: helper */
    private final JcaJceHelper f21498helper = new BCJcaJceHelper();

    /* renamed from: state */
    private int f21502state = -1;

    /* renamed from: buffer */
    private ByteArrayOutputStream f21495buffer = new ByteArrayOutputStream();
    private AlgorithmParameters engineParam = null;
    private IESKEMParameterSpec engineSpec = null;
    private boolean dhaesMode = false;
    private AsymmetricKeyParameter otherKeyParameter = null;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.ec.IESKEMCipher$KEM */
    public static class C5526KEM extends IESKEMCipher {
        public C5526KEM(InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, int i, int i2) {
            super(new ECDHCBasicAgreement(), new KDF2BytesGenerator(interfaceC5277Digest), new C5360HMac(interfaceC5277Digest2), i, i2);
        }
    }

    public static class KEMwithSHA256 extends C5526KEM {
        public KEMwithSHA256() {
            super(DigestFactory.createSHA256(), DigestFactory.createSHA256(), 32, 16);
        }
    }

    public IESKEMCipher(ECDHCBasicAgreement eCDHCBasicAgreement, KDF2BytesGenerator kDF2BytesGenerator, InterfaceC5278Mac interfaceC5278Mac, int i, int i2) {
        this.agreement = eCDHCBasicAgreement;
        this.f21499kdf = kDF2BytesGenerator;
        this.f21497hMac = interfaceC5278Mac;
        this.macKeyLength = i;
        this.macLength = i2;
    }

    @Override // javax.crypto.CipherSpi
    public int engineDoFinal(byte[] bArr, int i, int i2, byte[] bArr2, int i3) throws BadPaddingException {
        byte[] bArrEngineDoFinal = engineDoFinal(bArr, i, i2);
        System.arraycopy(bArrEngineDoFinal, 0, bArr2, i3, bArrEngineDoFinal.length);
        return bArrEngineDoFinal.length;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetBlockSize() {
        return 0;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public byte[] engineGetIV() {
        return null;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetKeySize(Key key) {
        if (key instanceof InterfaceC5809ECKey) {
            return ((InterfaceC5809ECKey) key).getParameters().getCurve().getFieldSize();
        }
        throw new IllegalArgumentException("not an EC key");
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public int engineGetOutputSize(int i) {
        BufferedBlockCipher cipher;
        if (this.f21500key == null) {
            throw new IllegalStateException("cipher not initialised");
        }
        int macSize = this.f21496engine.m15347getMac().getMacSize();
        int fieldSize = this.otherKeyParameter == null ? ((((ECKeyParameters) this.f21500key).getParameters().getCurve().getFieldSize() + 7) / 8) * 2 : 0;
        int size = this.f21495buffer.size() + i;
        if (this.f21496engine.getCipher() != null) {
            int i2 = this.f21502state;
            if (i2 == 1 || i2 == 3) {
                cipher = this.f21496engine.getCipher();
            } else {
                if (i2 != 2 && i2 != 4) {
                    throw new IllegalStateException("cipher not initialised");
                }
                cipher = this.f21496engine.getCipher();
                size = (size - macSize) - fieldSize;
            }
            size = cipher.getOutputSize(size);
        }
        int i3 = this.f21502state;
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
                AlgorithmParameters algorithmParametersCreateAlgorithmParameters = this.f21498helper.createAlgorithmParameters("IES");
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
    public void engineSetMode(String str) throws NoSuchAlgorithmException {
        throw new NoSuchAlgorithmException("can't support mode " + str);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseCipherSpi, javax.crypto.CipherSpi
    public void engineSetPadding(String str) throws NoSuchPaddingException {
        throw new NoSuchPaddingException("padding not available with IESCipher");
    }

    @Override // javax.crypto.CipherSpi
    public int engineUpdate(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        this.f21495buffer.write(bArr, i, i2);
        return 0;
    }

    @Override // javax.crypto.CipherSpi
    public byte[] engineDoFinal(byte[] bArr, int i, int i2) throws BadPaddingException {
        if (i2 != 0) {
            this.f21495buffer.write(bArr, i, i2);
        }
        this.f21495buffer.toByteArray();
        this.f21495buffer.reset();
        ECDomainParameters parameters = ((ECKeyParameters) this.f21500key).getParameters();
        int i3 = this.f21502state;
        if (i3 == 1 || i3 == 3) {
            ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
            eCKeyPairGenerator.mo14944init(new ECKeyGenerationParameters(parameters, this.f21501random));
            final boolean zHasUsePointCompression = this.engineSpec.hasUsePointCompression();
            EphemeralKeyPair ephemeralKeyPairGenerate = new EphemeralKeyPairGenerator(eCKeyPairGenerator, new KeyEncoder(this) { // from class: org.bouncycastle.jcajce.provider.asymmetric.ec.IESKEMCipher.1

                /* renamed from: this$0 */
                final /* synthetic */ IESKEMCipher f21503this$0;

                {
                    this.f21503this$0 = this;
                }

                @Override // org.bouncycastle.p194crypto.KeyEncoder
                public byte[] getEncoded(AsymmetricKeyParameter asymmetricKeyParameter) {
                    return ((ECPublicKeyParameters) asymmetricKeyParameter).m15728getQ().getEncoded(zHasUsePointCompression);
                }
            }).generate();
            this.agreement.mo14945init(ephemeralKeyPairGenerate.getKeyPair().getPrivate());
            X9IntegerConverter x9IntegerConverter = converter;
            byte[] bArrIntegerToBytes = x9IntegerConverter.integerToBytes(this.agreement.calculateAgreement(this.f21500key), x9IntegerConverter.getByteLength(parameters.getCurve()));
            int i4 = this.macKeyLength + i2;
            byte[] bArr2 = new byte[i4];
            this.f21499kdf.mo14966init(new KDFParameters(bArrIntegerToBytes, this.engineSpec.getRecipientInfo()));
            this.f21499kdf.generateBytes(bArr2, 0, i4);
            byte[] bArr3 = new byte[this.macLength + i2];
            for (int i5 = 0; i5 != i2; i5++) {
                bArr3[i5] = (byte) (bArr[i + i5] ^ bArr2[i5]);
            }
            KeyParameter keyParameter = new KeyParameter(bArr2, i2, i4 - i2);
            this.f21497hMac.mo14976init(keyParameter);
            this.f21497hMac.mo14979update(bArr3, 0, i2);
            byte[] bArr4 = new byte[this.f21497hMac.getMacSize()];
            this.f21497hMac.mo14975doFinal(bArr4, 0);
            C6238Arrays.m18227clear(keyParameter.m15773getKey());
            C6238Arrays.m18227clear(bArr2);
            System.arraycopy(bArr4, 0, bArr3, i2, this.macLength);
            return C6238Arrays.concatenate(ephemeralKeyPairGenerate.getEncodedPublicKey(), bArr3);
        }
        if (i3 != 2 && i3 != 4) {
            throw new IllegalStateException("cipher not initialised");
        }
        ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.f21500key;
        AbstractC5817ECCurve curve = eCPrivateKeyParameters.getParameters().getCurve();
        int fieldSize = (curve.getFieldSize() + 7) / 8;
        if (bArr[i] == 4) {
            fieldSize *= 2;
        }
        int i6 = fieldSize + 1;
        int i7 = i2 - (this.macLength + i6);
        int i8 = i6 + i;
        AbstractC5820ECPoint abstractC5820ECPointDecodePoint = curve.decodePoint(C6238Arrays.copyOfRange(bArr, i, i8));
        this.agreement.mo14945init(this.f21500key);
        X9IntegerConverter x9IntegerConverter2 = converter;
        byte[] bArrIntegerToBytes2 = x9IntegerConverter2.integerToBytes(this.agreement.calculateAgreement(new ECPublicKeyParameters(abstractC5820ECPointDecodePoint, eCPrivateKeyParameters.getParameters())), x9IntegerConverter2.getByteLength(parameters.getCurve()));
        int i9 = this.macKeyLength + i7;
        byte[] bArr5 = new byte[i9];
        this.f21499kdf.mo14966init(new KDFParameters(bArrIntegerToBytes2, this.engineSpec.getRecipientInfo()));
        this.f21499kdf.generateBytes(bArr5, 0, i9);
        byte[] bArr6 = new byte[i7];
        for (int i10 = 0; i10 != i7; i10++) {
            bArr6[i10] = (byte) (bArr[i8 + i10] ^ bArr5[i10]);
        }
        KeyParameter keyParameter2 = new KeyParameter(bArr5, i7, i9 - i7);
        this.f21497hMac.mo14976init(keyParameter2);
        this.f21497hMac.mo14979update(bArr, i8, i7);
        byte[] bArr7 = new byte[this.f21497hMac.getMacSize()];
        this.f21497hMac.mo14975doFinal(bArr7, 0);
        C6238Arrays.m18227clear(keyParameter2.m15773getKey());
        C6238Arrays.m18227clear(bArr5);
        int i11 = this.macLength;
        if (C6238Arrays.constantTimeAreEqual(i11, bArr7, 0, bArr, i + (i2 - i11))) {
            return bArr6;
        }
        throw new BadPaddingException("mac field");
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
        this.f21495buffer.write(bArr, i, i2);
        return null;
    }

    @Override // javax.crypto.CipherSpi
    public void engineInit(int i, Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException {
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePublicKeyParameter;
        this.otherKeyParameter = null;
        this.engineSpec = (IESKEMParameterSpec) algorithmParameterSpec;
        if (i == 1 || i == 3) {
            if (!(key instanceof PublicKey)) {
                throw new InvalidKeyException("must be passed recipient's public EC key for encryption");
            }
            asymmetricKeyParameterGeneratePublicKeyParameter = C5518ECUtils.generatePublicKeyParameter((PublicKey) key);
        } else {
            if (i != 2 && i != 4) {
                throw new InvalidKeyException("must be passed EC key");
            }
            if (!(key instanceof PrivateKey)) {
                throw new InvalidKeyException("must be passed recipient's private EC key for decryption");
            }
            asymmetricKeyParameterGeneratePublicKeyParameter = C5518ECUtils.generatePrivateKeyParameter((PrivateKey) key);
        }
        this.f21500key = asymmetricKeyParameterGeneratePublicKeyParameter;
        this.f21501random = secureRandom;
        this.f21502state = i;
        this.f21495buffer.reset();
    }
}
