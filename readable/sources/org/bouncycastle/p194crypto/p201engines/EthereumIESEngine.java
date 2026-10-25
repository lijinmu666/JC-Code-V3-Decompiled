package org.bouncycastle.p194crypto.p201engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.BasicAgreement;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.DerivationParameters;
import org.bouncycastle.p194crypto.DigestDerivationFunction;
import org.bouncycastle.p194crypto.EphemeralKeyPair;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.KeyParser;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.SavableDigest;
import org.bouncycastle.p194crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.IESParameters;
import org.bouncycastle.p194crypto.p213params.IESWithCipherParameters;
import org.bouncycastle.p194crypto.p213params.ISO18033KDFParameters;
import org.bouncycastle.p194crypto.p213params.KDFParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class EthereumIESEngine {

    /* renamed from: IV */
    private byte[] f19857IV;

    /* renamed from: V */
    byte[] f19858V;

    /* renamed from: agree */
    BasicAgreement f19859agree;

    /* renamed from: cipher */
    BufferedBlockCipher f19860cipher;
    byte[] commonMac;
    boolean forEncryption;

    /* renamed from: kdf */
    DerivationFunction f19861kdf;
    private EphemeralKeyPairGenerator keyPairGenerator;
    private KeyParser keyParser;

    /* renamed from: mac */
    InterfaceC5278Mac f19862mac;

    /* renamed from: macBuf */
    byte[] f19863macBuf;

    /* renamed from: param */
    IESParameters f19864param;
    CipherParameters privParam;
    CipherParameters pubParam;

    public static class HandshakeKDFFunction implements DigestDerivationFunction {
        private int counterStart;

        /* renamed from: digest */
        private InterfaceC5277Digest f19865digest;

        /* renamed from: iv */
        private byte[] f19866iv;

        /* renamed from: shared */
        private byte[] f19867shared;

        public HandshakeKDFFunction(int i, InterfaceC5277Digest interfaceC5277Digest) {
            this.counterStart = i;
            this.f19865digest = interfaceC5277Digest;
        }

        @Override // org.bouncycastle.p194crypto.DerivationFunction
        public int generateBytes(byte[] bArr, int i, int i2) {
            int i3 = i2;
            int i4 = i;
            if (bArr.length - i3 < i4) {
                throw new OutputLengthException("output buffer too small");
            }
            long j = i3;
            int digestSize = this.f19865digest.getDigestSize();
            long j2 = digestSize;
            if (j > BodyPartID.bodyIdMax * j2) {
                throw new IllegalArgumentException("output length too large");
            }
            int i5 = (int) (((j + j2) - 1) / j2);
            byte[] bArr2 = new byte[this.f19865digest.getDigestSize()];
            int i6 = 4;
            byte[] bArr3 = new byte[4];
            AbstractC6245Pack.intToBigEndian(this.counterStart, bArr3, 0);
            int i7 = this.counterStart & (-256);
            int i8 = 0;
            while (i8 < i5) {
                this.f19865digest.mo14970update(bArr3, 0, i6);
                InterfaceC5277Digest interfaceC5277Digest = this.f19865digest;
                byte[] bArr4 = this.f19867shared;
                interfaceC5277Digest.mo14970update(bArr4, 0, bArr4.length);
                byte[] bArr5 = this.f19866iv;
                if (bArr5 != null) {
                    this.f19865digest.mo14970update(bArr5, 0, bArr5.length);
                }
                this.f19865digest.mo14967doFinal(bArr2, 0);
                if (i3 > digestSize) {
                    System.arraycopy(bArr2, 0, bArr, i4, digestSize);
                    i4 += digestSize;
                    i3 -= digestSize;
                } else {
                    System.arraycopy(bArr2, 0, bArr, i4, i3);
                }
                byte b = (byte) (bArr3[3] + 1);
                bArr3[3] = b;
                if (b == 0) {
                    i7 += 256;
                    AbstractC6245Pack.intToBigEndian(i7, bArr3, 0);
                }
                i8++;
                i6 = 4;
            }
            this.f19865digest.mo14968reset();
            return (int) j;
        }

        @Override // org.bouncycastle.p194crypto.DigestDerivationFunction
        public InterfaceC5277Digest getDigest() {
            return this.f19865digest;
        }

        @Override // org.bouncycastle.p194crypto.DerivationFunction
        /* renamed from: init */
        public void mo14966init(DerivationParameters derivationParameters) {
            if (derivationParameters instanceof KDFParameters) {
                KDFParameters kDFParameters = (KDFParameters) derivationParameters;
                this.f19867shared = kDFParameters.getSharedSecret();
                this.f19866iv = kDFParameters.m15771getIV();
            } else {
                if (!(derivationParameters instanceof ISO18033KDFParameters)) {
                    throw new IllegalArgumentException("KDF parameters required for generator");
                }
                this.f19867shared = ((ISO18033KDFParameters) derivationParameters).m15763getSeed();
                this.f19866iv = null;
            }
        }
    }

    public EthereumIESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, InterfaceC5278Mac interfaceC5278Mac, byte[] bArr) {
        this.f19859agree = basicAgreement;
        this.f19861kdf = derivationFunction;
        this.f19862mac = interfaceC5278Mac;
        this.f19863macBuf = new byte[interfaceC5278Mac.getMacSize()];
        this.commonMac = bArr;
        this.f19860cipher = null;
    }

    private byte[] decryptBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        int iProcessBytes;
        if (i2 < this.f19858V.length + this.f19862mac.getMacSize()) {
            throw new InvalidCipherTextException("length of input must be greater than the MAC and V combined");
        }
        if (this.f19860cipher == null) {
            int length = (i2 - this.f19858V.length) - this.f19862mac.getMacSize();
            byte[] bArr4 = new byte[length];
            int macKeySize = this.f19864param.getMacKeySize() / 8;
            bArr2 = new byte[macKeySize];
            int i3 = length + macKeySize;
            byte[] bArr5 = new byte[i3];
            this.f19861kdf.generateBytes(bArr5, 0, i3);
            if (this.f19858V.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                System.arraycopy(bArr5, macKeySize, bArr4, 0, length);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, length);
                System.arraycopy(bArr5, length, bArr2, 0, macKeySize);
            }
            bArr3 = new byte[length];
            for (int i4 = 0; i4 != length; i4++) {
                bArr3[i4] = (byte) (bArr[(this.f19858V.length + i) + i4] ^ bArr4[i4]);
            }
            iProcessBytes = 0;
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.f19864param).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.f19864param.getMacKeySize() / 8;
            bArr2 = new byte[macKeySize2];
            int i5 = cipherKeySize + macKeySize2;
            byte[] bArr7 = new byte[i5];
            this.f19861kdf.generateBytes(bArr7, 0, i5);
            System.arraycopy(bArr7, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr7, cipherKeySize, bArr2, 0, macKeySize2);
            CipherParameters keyParameter = new KeyParameter(bArr6);
            byte[] bArr8 = this.f19857IV;
            if (bArr8 != null) {
                keyParameter = new ParametersWithIV(keyParameter, bArr8);
            }
            this.f19860cipher.mo14952init(false, keyParameter);
            bArr3 = new byte[this.f19860cipher.getOutputSize((i2 - this.f19858V.length) - this.f19862mac.getMacSize())];
            BufferedBlockCipher bufferedBlockCipher = this.f19860cipher;
            byte[] bArr9 = this.f19858V;
            iProcessBytes = bufferedBlockCipher.processBytes(bArr, i + bArr9.length, (i2 - bArr9.length) - this.f19862mac.getMacSize(), bArr3, 0);
        }
        byte[] encodingV = this.f19864param.getEncodingV();
        byte[] lengthTag = this.f19858V.length != 0 ? getLengthTag(encodingV) : null;
        int i6 = i + i2;
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, i6 - this.f19862mac.getMacSize(), i6);
        int length2 = bArrCopyOfRange.length;
        byte[] bArr10 = new byte[length2];
        SavableDigest savableDigestNewInstance = SHA256Digest.newInstance();
        byte[] bArr11 = new byte[savableDigestNewInstance.getDigestSize()];
        savableDigestNewInstance.mo14968reset();
        savableDigestNewInstance.mo14970update(bArr2, 0, bArr2.length);
        savableDigestNewInstance.mo14967doFinal(bArr11, 0);
        this.f19862mac.mo14976init(new KeyParameter(bArr11));
        InterfaceC5278Mac interfaceC5278Mac = this.f19862mac;
        byte[] bArr12 = this.f19857IV;
        interfaceC5278Mac.mo14979update(bArr12, 0, bArr12.length);
        InterfaceC5278Mac interfaceC5278Mac2 = this.f19862mac;
        byte[] bArr13 = this.f19858V;
        interfaceC5278Mac2.mo14979update(bArr, i + bArr13.length, (i2 - bArr13.length) - length2);
        if (encodingV != null) {
            this.f19862mac.mo14979update(encodingV, 0, encodingV.length);
        }
        if (this.f19858V.length != 0) {
            this.f19862mac.mo14979update(lengthTag, 0, lengthTag.length);
        }
        InterfaceC5278Mac interfaceC5278Mac3 = this.f19862mac;
        byte[] bArr14 = this.commonMac;
        interfaceC5278Mac3.mo14979update(bArr14, 0, bArr14.length);
        this.f19862mac.mo14975doFinal(bArr10, 0);
        if (!C6238Arrays.constantTimeAreEqual(bArrCopyOfRange, bArr10)) {
            throw new InvalidCipherTextException("invalid MAC");
        }
        BufferedBlockCipher bufferedBlockCipher2 = this.f19860cipher;
        return bufferedBlockCipher2 == null ? bArr3 : C6238Arrays.copyOfRange(bArr3, 0, iProcessBytes + bufferedBlockCipher2.mo14951doFinal(bArr3, iProcessBytes));
    }

    private byte[] encryptBlock(byte[] bArr, int i, int i2) {
        BufferedBlockCipher bufferedBlockCipher;
        CipherParameters keyParameter;
        byte[] bArr2;
        byte[] bArr3;
        if (this.f19860cipher == null) {
            byte[] bArr4 = new byte[i2];
            int macKeySize = this.f19864param.getMacKeySize() / 8;
            bArr3 = new byte[macKeySize];
            int i3 = i2 + macKeySize;
            byte[] bArr5 = new byte[i3];
            this.f19861kdf.generateBytes(bArr5, 0, i3);
            if (this.f19858V.length != 0) {
                System.arraycopy(bArr5, 0, bArr3, 0, macKeySize);
                System.arraycopy(bArr5, macKeySize, bArr4, 0, i2);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, i2);
                System.arraycopy(bArr5, i2, bArr3, 0, macKeySize);
            }
            bArr2 = new byte[i2];
            for (int i4 = 0; i4 != i2; i4++) {
                bArr2[i4] = (byte) (bArr[i + i4] ^ bArr4[i4]);
            }
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.f19864param).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.f19864param.getMacKeySize() / 8;
            byte[] bArr7 = new byte[macKeySize2];
            int i5 = cipherKeySize + macKeySize2;
            byte[] bArr8 = new byte[i5];
            this.f19861kdf.generateBytes(bArr8, 0, i5);
            System.arraycopy(bArr8, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr8, cipherKeySize, bArr7, 0, macKeySize2);
            if (this.f19857IV != null) {
                bufferedBlockCipher = this.f19860cipher;
                keyParameter = new ParametersWithIV(new KeyParameter(bArr6), this.f19857IV);
            } else {
                bufferedBlockCipher = this.f19860cipher;
                keyParameter = new KeyParameter(bArr6);
            }
            bufferedBlockCipher.mo14952init(true, keyParameter);
            bArr2 = new byte[this.f19860cipher.getOutputSize(i2)];
            int iProcessBytes = this.f19860cipher.processBytes(bArr, i, i2, bArr2, 0);
            i2 = iProcessBytes + this.f19860cipher.mo14951doFinal(bArr2, iProcessBytes);
            bArr3 = bArr7;
        }
        byte[] encodingV = this.f19864param.getEncodingV();
        byte[] lengthTag = this.f19858V.length != 0 ? getLengthTag(encodingV) : null;
        int macSize = this.f19862mac.getMacSize();
        byte[] bArr9 = new byte[macSize];
        SavableDigest savableDigestNewInstance = SHA256Digest.newInstance();
        byte[] bArr10 = new byte[savableDigestNewInstance.getDigestSize()];
        savableDigestNewInstance.mo14968reset();
        savableDigestNewInstance.mo14970update(bArr3, 0, bArr3.length);
        savableDigestNewInstance.mo14967doFinal(bArr10, 0);
        this.f19862mac.mo14976init(new KeyParameter(bArr10));
        InterfaceC5278Mac interfaceC5278Mac = this.f19862mac;
        byte[] bArr11 = this.f19857IV;
        interfaceC5278Mac.mo14979update(bArr11, 0, bArr11.length);
        this.f19862mac.mo14979update(bArr2, 0, bArr2.length);
        if (encodingV != null) {
            this.f19862mac.mo14979update(encodingV, 0, encodingV.length);
        }
        if (this.f19858V.length != 0) {
            this.f19862mac.mo14979update(lengthTag, 0, lengthTag.length);
        }
        InterfaceC5278Mac interfaceC5278Mac2 = this.f19862mac;
        byte[] bArr12 = this.commonMac;
        interfaceC5278Mac2.mo14979update(bArr12, 0, bArr12.length);
        this.f19862mac.mo14975doFinal(bArr9, 0);
        byte[] bArr13 = this.f19858V;
        byte[] bArr14 = new byte[bArr13.length + i2 + macSize];
        System.arraycopy(bArr13, 0, bArr14, 0, bArr13.length);
        System.arraycopy(bArr2, 0, bArr14, this.f19858V.length, i2);
        System.arraycopy(bArr9, 0, bArr14, this.f19858V.length + i2, macSize);
        return bArr14;
    }

    private void extractParams(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f19857IV = parametersWithIV.m15801getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            this.f19857IV = null;
        }
        this.f19864param = (IESParameters) cipherParameters;
    }

    public BufferedBlockCipher getCipher() {
        return this.f19860cipher;
    }

    public byte[] getLengthTag(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            AbstractC6245Pack.longToBigEndian(bArr.length * 8, bArr2, 0);
        }
        return bArr2;
    }

    /* renamed from: getMac */
    public InterfaceC5278Mac m15306getMac() {
        return this.f19862mac;
    }

    /* renamed from: init */
    public void m15307init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, KeyParser keyParser) {
        this.forEncryption = false;
        this.privParam = asymmetricKeyParameter;
        this.keyParser = keyParser;
        extractParams(cipherParameters);
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forEncryption) {
            EphemeralKeyPairGenerator ephemeralKeyPairGenerator = this.keyPairGenerator;
            if (ephemeralKeyPairGenerator != null) {
                EphemeralKeyPair ephemeralKeyPairGenerate = ephemeralKeyPairGenerator.generate();
                this.privParam = ephemeralKeyPairGenerate.getKeyPair().getPrivate();
                this.f19858V = ephemeralKeyPairGenerate.getEncodedPublicKey();
            }
        } else if (this.keyParser != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                this.pubParam = this.keyParser.mo14974readKey(byteArrayInputStream);
                this.f19858V = C6238Arrays.copyOfRange(bArr, i, (i2 - byteArrayInputStream.available()) + i);
            } catch (IOException e) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e.getMessage(), e);
            } catch (IllegalArgumentException e2) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e2.getMessage(), e2);
            }
        }
        this.f19859agree.mo14945init(this.privParam);
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.f19859agree.getFieldSize(), this.f19859agree.calculateAgreement(this.pubParam));
        byte[] bArr2 = this.f19858V;
        if (bArr2.length != 0) {
            byte[] bArrConcatenate = C6238Arrays.concatenate(bArr2, bArrAsUnsignedByteArray);
            C6238Arrays.m18249fill(bArrAsUnsignedByteArray, (byte) 0);
            bArrAsUnsignedByteArray = bArrConcatenate;
        }
        try {
            this.f19861kdf.mo14966init(new KDFParameters(bArrAsUnsignedByteArray, this.f19864param.getDerivationV()));
            byte[] bArrEncryptBlock = this.forEncryption ? encryptBlock(bArr, i, i2) : decryptBlock(bArr, i, i2);
            C6238Arrays.m18249fill(bArrAsUnsignedByteArray, (byte) 0);
            return bArrEncryptBlock;
        } catch (Throwable th) {
            C6238Arrays.m18249fill(bArrAsUnsignedByteArray, (byte) 0);
            throw th;
        }
    }

    public EthereumIESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, InterfaceC5278Mac interfaceC5278Mac, byte[] bArr, BufferedBlockCipher bufferedBlockCipher) {
        this.f19859agree = basicAgreement;
        this.f19861kdf = derivationFunction;
        this.f19862mac = interfaceC5278Mac;
        this.f19863macBuf = new byte[interfaceC5278Mac.getMacSize()];
        this.commonMac = bArr;
        this.f19860cipher = bufferedBlockCipher;
    }

    /* renamed from: init */
    public void m15308init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, EphemeralKeyPairGenerator ephemeralKeyPairGenerator) {
        this.forEncryption = true;
        this.pubParam = asymmetricKeyParameter;
        this.keyPairGenerator = ephemeralKeyPairGenerator;
        extractParams(cipherParameters);
    }

    /* renamed from: init */
    public void m15309init(boolean z, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = z;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.f19858V = new byte[0];
        extractParams(cipherParameters3);
    }
}
