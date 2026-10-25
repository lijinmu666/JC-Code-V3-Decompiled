package org.bouncycastle.p194crypto.p201engines;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.p194crypto.BasicAgreement;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.EphemeralKeyPair;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.KeyParser;
import org.bouncycastle.p194crypto.generators.EphemeralKeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.IESParameters;
import org.bouncycastle.p194crypto.p213params.IESWithCipherParameters;
import org.bouncycastle.p194crypto.p213params.KDFParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class IESEngine {

    /* renamed from: IV */
    private byte[] f19917IV;

    /* renamed from: V */
    byte[] f19918V;

    /* renamed from: agree */
    BasicAgreement f19919agree;

    /* renamed from: cipher */
    BufferedBlockCipher f19920cipher;
    boolean forEncryption;

    /* renamed from: kdf */
    DerivationFunction f19921kdf;
    private EphemeralKeyPairGenerator keyPairGenerator;
    private KeyParser keyParser;

    /* renamed from: mac */
    InterfaceC5278Mac f19922mac;

    /* renamed from: macBuf */
    byte[] f19923macBuf;

    /* renamed from: param */
    IESParameters f19924param;
    CipherParameters privParam;
    CipherParameters pubParam;

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, InterfaceC5278Mac interfaceC5278Mac) {
        this.f19919agree = basicAgreement;
        this.f19921kdf = derivationFunction;
        this.f19922mac = interfaceC5278Mac;
        this.f19923macBuf = new byte[interfaceC5278Mac.getMacSize()];
        this.f19920cipher = null;
    }

    private byte[] decryptBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte[] bArr2;
        byte[] bArr3;
        int iProcessBytes;
        if (i2 < this.f19918V.length + this.f19922mac.getMacSize()) {
            throw new InvalidCipherTextException("Length of input must be greater than the MAC and V combined");
        }
        if (this.f19920cipher == null) {
            int length = (i2 - this.f19918V.length) - this.f19922mac.getMacSize();
            byte[] bArr4 = new byte[length];
            int macKeySize = this.f19924param.getMacKeySize() / 8;
            bArr2 = new byte[macKeySize];
            int i3 = length + macKeySize;
            byte[] bArr5 = new byte[i3];
            this.f19921kdf.generateBytes(bArr5, 0, i3);
            if (this.f19918V.length != 0) {
                System.arraycopy(bArr5, 0, bArr2, 0, macKeySize);
                System.arraycopy(bArr5, macKeySize, bArr4, 0, length);
            } else {
                System.arraycopy(bArr5, 0, bArr4, 0, length);
                System.arraycopy(bArr5, length, bArr2, 0, macKeySize);
            }
            bArr3 = new byte[length];
            for (int i4 = 0; i4 != length; i4++) {
                bArr3[i4] = (byte) (bArr[(this.f19918V.length + i) + i4] ^ bArr4[i4]);
            }
            iProcessBytes = 0;
        } else {
            int cipherKeySize = ((IESWithCipherParameters) this.f19924param).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.f19924param.getMacKeySize() / 8;
            bArr2 = new byte[macKeySize2];
            int i5 = cipherKeySize + macKeySize2;
            byte[] bArr7 = new byte[i5];
            this.f19921kdf.generateBytes(bArr7, 0, i5);
            System.arraycopy(bArr7, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr7, cipherKeySize, bArr2, 0, macKeySize2);
            CipherParameters keyParameter = new KeyParameter(bArr6);
            byte[] bArr8 = this.f19917IV;
            if (bArr8 != null) {
                keyParameter = new ParametersWithIV(keyParameter, bArr8);
            }
            this.f19920cipher.mo14952init(false, keyParameter);
            bArr3 = new byte[this.f19920cipher.getOutputSize((i2 - this.f19918V.length) - this.f19922mac.getMacSize())];
            BufferedBlockCipher bufferedBlockCipher = this.f19920cipher;
            byte[] bArr9 = this.f19918V;
            iProcessBytes = bufferedBlockCipher.processBytes(bArr, i + bArr9.length, (i2 - bArr9.length) - this.f19922mac.getMacSize(), bArr3, 0);
        }
        byte[] encodingV = this.f19924param.getEncodingV();
        byte[] lengthTag = this.f19918V.length != 0 ? getLengthTag(encodingV) : null;
        int i6 = i + i2;
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, i6 - this.f19922mac.getMacSize(), i6);
        int length2 = bArrCopyOfRange.length;
        byte[] bArr10 = new byte[length2];
        this.f19922mac.mo14976init(new KeyParameter(bArr2));
        InterfaceC5278Mac interfaceC5278Mac = this.f19922mac;
        byte[] bArr11 = this.f19918V;
        interfaceC5278Mac.mo14979update(bArr, i + bArr11.length, (i2 - bArr11.length) - length2);
        if (encodingV != null) {
            this.f19922mac.mo14979update(encodingV, 0, encodingV.length);
        }
        if (this.f19918V.length != 0) {
            this.f19922mac.mo14979update(lengthTag, 0, lengthTag.length);
        }
        this.f19922mac.mo14975doFinal(bArr10, 0);
        if (!C6238Arrays.constantTimeAreEqual(bArrCopyOfRange, bArr10)) {
            throw new InvalidCipherTextException("invalid MAC");
        }
        BufferedBlockCipher bufferedBlockCipher2 = this.f19920cipher;
        return bufferedBlockCipher2 == null ? bArr3 : C6238Arrays.copyOfRange(bArr3, 0, iProcessBytes + bufferedBlockCipher2.mo14951doFinal(bArr3, iProcessBytes));
    }

    private byte[] encryptBlock(byte[] bArr, int i, int i2) {
        BufferedBlockCipher bufferedBlockCipher;
        CipherParameters keyParameter;
        byte[] bArr2;
        byte[] bArr3;
        if (this.f19920cipher == null) {
            byte[] bArr4 = new byte[i2];
            int macKeySize = this.f19924param.getMacKeySize() / 8;
            bArr3 = new byte[macKeySize];
            int i3 = i2 + macKeySize;
            byte[] bArr5 = new byte[i3];
            this.f19921kdf.generateBytes(bArr5, 0, i3);
            if (this.f19918V.length != 0) {
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
            int cipherKeySize = ((IESWithCipherParameters) this.f19924param).getCipherKeySize() / 8;
            byte[] bArr6 = new byte[cipherKeySize];
            int macKeySize2 = this.f19924param.getMacKeySize() / 8;
            byte[] bArr7 = new byte[macKeySize2];
            int i5 = cipherKeySize + macKeySize2;
            byte[] bArr8 = new byte[i5];
            this.f19921kdf.generateBytes(bArr8, 0, i5);
            System.arraycopy(bArr8, 0, bArr6, 0, cipherKeySize);
            System.arraycopy(bArr8, cipherKeySize, bArr7, 0, macKeySize2);
            if (this.f19917IV != null) {
                bufferedBlockCipher = this.f19920cipher;
                keyParameter = new ParametersWithIV(new KeyParameter(bArr6), this.f19917IV);
            } else {
                bufferedBlockCipher = this.f19920cipher;
                keyParameter = new KeyParameter(bArr6);
            }
            bufferedBlockCipher.mo14952init(true, keyParameter);
            bArr2 = new byte[this.f19920cipher.getOutputSize(i2)];
            int iProcessBytes = this.f19920cipher.processBytes(bArr, i, i2, bArr2, 0);
            i2 = iProcessBytes + this.f19920cipher.mo14951doFinal(bArr2, iProcessBytes);
            bArr3 = bArr7;
        }
        byte[] encodingV = this.f19924param.getEncodingV();
        byte[] lengthTag = this.f19918V.length != 0 ? getLengthTag(encodingV) : null;
        int macSize = this.f19922mac.getMacSize();
        byte[] bArr9 = new byte[macSize];
        this.f19922mac.mo14976init(new KeyParameter(bArr3));
        this.f19922mac.mo14979update(bArr2, 0, bArr2.length);
        if (encodingV != null) {
            this.f19922mac.mo14979update(encodingV, 0, encodingV.length);
        }
        if (this.f19918V.length != 0) {
            this.f19922mac.mo14979update(lengthTag, 0, lengthTag.length);
        }
        this.f19922mac.mo14975doFinal(bArr9, 0);
        byte[] bArr10 = this.f19918V;
        byte[] bArr11 = new byte[bArr10.length + i2 + macSize];
        System.arraycopy(bArr10, 0, bArr11, 0, bArr10.length);
        System.arraycopy(bArr2, 0, bArr11, this.f19918V.length, i2);
        System.arraycopy(bArr9, 0, bArr11, this.f19918V.length + i2, macSize);
        return bArr11;
    }

    private void extractParams(CipherParameters cipherParameters) {
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.f19917IV = parametersWithIV.m15801getIV();
            cipherParameters = parametersWithIV.getParameters();
        } else {
            this.f19917IV = null;
        }
        this.f19924param = (IESParameters) cipherParameters;
    }

    public BufferedBlockCipher getCipher() {
        return this.f19920cipher;
    }

    public byte[] getLengthTag(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        if (bArr != null) {
            AbstractC6245Pack.longToBigEndian(bArr.length * 8, bArr2, 0);
        }
        return bArr2;
    }

    /* renamed from: getMac */
    public InterfaceC5278Mac m15347getMac() {
        return this.f19922mac;
    }

    /* renamed from: init */
    public void m15348init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, KeyParser keyParser) {
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
                this.f19918V = ephemeralKeyPairGenerate.getEncodedPublicKey();
            }
        } else if (this.keyParser != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, i, i2);
            try {
                this.pubParam = this.keyParser.mo14974readKey(byteArrayInputStream);
                this.f19918V = C6238Arrays.copyOfRange(bArr, i, (i2 - byteArrayInputStream.available()) + i);
            } catch (IOException e) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e.getMessage(), e);
            } catch (IllegalArgumentException e2) {
                throw new InvalidCipherTextException("unable to recover ephemeral public key: " + e2.getMessage(), e2);
            }
        }
        this.f19919agree.mo14945init(this.privParam);
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.f19919agree.getFieldSize(), this.f19919agree.calculateAgreement(this.pubParam));
        byte[] bArr2 = this.f19918V;
        if (bArr2.length != 0) {
            byte[] bArrConcatenate = C6238Arrays.concatenate(bArr2, bArrAsUnsignedByteArray);
            C6238Arrays.m18249fill(bArrAsUnsignedByteArray, (byte) 0);
            bArrAsUnsignedByteArray = bArrConcatenate;
        }
        try {
            this.f19921kdf.mo14966init(new KDFParameters(bArrAsUnsignedByteArray, this.f19924param.getDerivationV()));
            byte[] bArrEncryptBlock = this.forEncryption ? encryptBlock(bArr, i, i2) : decryptBlock(bArr, i, i2);
            C6238Arrays.m18249fill(bArrAsUnsignedByteArray, (byte) 0);
            return bArrEncryptBlock;
        } catch (Throwable th) {
            C6238Arrays.m18249fill(bArrAsUnsignedByteArray, (byte) 0);
            throw th;
        }
    }

    public IESEngine(BasicAgreement basicAgreement, DerivationFunction derivationFunction, InterfaceC5278Mac interfaceC5278Mac, BufferedBlockCipher bufferedBlockCipher) {
        this.f19919agree = basicAgreement;
        this.f19921kdf = derivationFunction;
        this.f19922mac = interfaceC5278Mac;
        this.f19923macBuf = new byte[interfaceC5278Mac.getMacSize()];
        this.f19920cipher = bufferedBlockCipher;
    }

    /* renamed from: init */
    public void m15349init(AsymmetricKeyParameter asymmetricKeyParameter, CipherParameters cipherParameters, EphemeralKeyPairGenerator ephemeralKeyPairGenerator) {
        this.forEncryption = true;
        this.pubParam = asymmetricKeyParameter;
        this.keyPairGenerator = ephemeralKeyPairGenerator;
        extractParams(cipherParameters);
    }

    /* renamed from: init */
    public void m15350init(boolean z, CipherParameters cipherParameters, CipherParameters cipherParameters2, CipherParameters cipherParameters3) {
        this.forEncryption = z;
        this.privParam = cipherParameters;
        this.pubParam = cipherParameters2;
        this.f19918V = new byte[0];
        extractParams(cipherParameters3);
    }
}
