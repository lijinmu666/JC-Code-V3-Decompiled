package org.bouncycastle.p194crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Properties;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class PKCS1Encoding implements AsymmetricBlockCipher {
    private static final int HEADER_LENGTH = 10;
    public static final String NOT_STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.not_strict";
    public static final String STRICT_LENGTH_ENABLED_PROPERTY = "org.bouncycastle.pkcs1.strict";
    private byte[] blockBuffer;

    /* renamed from: engine */
    private AsymmetricBlockCipher f19647engine;
    private byte[] fallback;
    private boolean forEncryption;
    private boolean forPrivateKey;

    /* renamed from: pLen */
    private int f19648pLen;

    /* renamed from: random */
    private SecureRandom f19649random;
    private boolean useStrictLength;

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f19648pLen = -1;
        this.fallback = null;
        this.f19647engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
    }

    private static int checkPkcs1Encoding1(byte[] bArr) {
        int i = 0;
        int i2 = -((bArr[0] & C1126UByte.MAX_VALUE) ^ 1);
        int i3 = 0;
        for (int i4 = 1; i4 < bArr.length; i4++) {
            int i5 = bArr[i4] & C1126UByte.MAX_VALUE;
            int i6 = (i5 - 1) >> 31;
            i ^= ((~i3) & i4) & i6;
            i3 |= i6;
            i2 |= ~((((i5 ^ 255) - 1) >> 31) | i3);
        }
        return ((bArr.length - 1) - i) | (((i - 9) | i2) >> 31);
    }

    private static int checkPkcs1Encoding2(byte[] bArr) {
        int i = 0;
        int i2 = -((bArr[0] & C1126UByte.MAX_VALUE) ^ 2);
        int i3 = 0;
        for (int i4 = 1; i4 < bArr.length; i4++) {
            int i5 = ((bArr[i4] & C1126UByte.MAX_VALUE) - 1) >> 31;
            i ^= ((~i3) & i4) & i5;
            i3 |= i5;
        }
        return ((bArr.length - 1) - i) | ((i2 | (i - 9)) >> 31);
    }

    private byte[] decodeBlock(byte[] bArr, int i, int i2) {
        if (this.forPrivateKey && this.f19648pLen != -1) {
            return decodeBlockOrRandom(bArr, i, i2);
        }
        int outputBlockSize = this.f19647engine.getOutputBlockSize();
        byte[] bArrProcessBlock = this.f19647engine.processBlock(bArr, i, i2);
        boolean z = this.useStrictLength & (bArrProcessBlock.length != outputBlockSize);
        byte[] bArr2 = bArrProcessBlock.length < outputBlockSize ? this.blockBuffer : bArrProcessBlock;
        int iCheckPkcs1Encoding2 = this.forPrivateKey ? checkPkcs1Encoding2(bArr2) : checkPkcs1Encoding1(bArr2);
        try {
            if (iCheckPkcs1Encoding2 < 0) {
                throw new InvalidCipherTextException("block incorrect");
            }
            if (z) {
                throw new InvalidCipherTextException("block incorrect size");
            }
            byte[] bArr3 = new byte[iCheckPkcs1Encoding2];
            System.arraycopy(bArr2, bArr2.length - iCheckPkcs1Encoding2, bArr3, 0, iCheckPkcs1Encoding2);
            return bArr3;
        } finally {
            C6238Arrays.m18249fill(bArrProcessBlock, (byte) 0);
            byte[] bArr4 = this.blockBuffer;
            C6238Arrays.m18250fill(bArr4, 0, Math.max(0, bArr4.length - bArrProcessBlock.length), (byte) 0);
        }
    }

    private byte[] decodeBlockOrRandom(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (!this.forPrivateKey) {
            throw new InvalidCipherTextException("sorry, this method is only for decryption, not for signing");
        }
        int i3 = this.f19648pLen;
        byte[] bArr2 = this.fallback;
        if (bArr2 == null) {
            bArr2 = new byte[i3];
            this.f19649random.nextBytes(bArr2);
        }
        int outputBlockSize = this.f19647engine.getOutputBlockSize();
        byte[] bArrProcessBlock = this.f19647engine.processBlock(bArr, i, i2);
        byte[] bArr3 = (bArrProcessBlock.length == outputBlockSize || (!this.useStrictLength && bArrProcessBlock.length >= outputBlockSize)) ? bArrProcessBlock : this.blockBuffer;
        int iCheckPkcs1Encoding2 = checkPkcs1Encoding2(bArr3, i3);
        int length = bArr3.length - i3;
        byte[] bArr4 = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            bArr4[i4] = (byte) ((bArr3[length + i4] & (~iCheckPkcs1Encoding2)) | (bArr2[i4] & iCheckPkcs1Encoding2));
        }
        C6238Arrays.m18249fill(bArrProcessBlock, (byte) 0);
        byte[] bArr5 = this.blockBuffer;
        C6238Arrays.m18250fill(bArr5, 0, Math.max(0, bArr5.length - bArrProcessBlock.length), (byte) 0);
        return bArr4;
    }

    private byte[] encodeBlock(byte[] bArr, int i, int i2) {
        if (i2 > getInputBlockSize()) {
            throw new IllegalArgumentException("input data too large");
        }
        int inputBlockSize = this.f19647engine.getInputBlockSize();
        byte[] bArr2 = new byte[inputBlockSize];
        if (this.forPrivateKey) {
            bArr2[0] = 1;
            for (int i3 = 1; i3 != (inputBlockSize - i2) - 1; i3++) {
                bArr2[i3] = -1;
            }
        } else {
            this.f19649random.nextBytes(bArr2);
            bArr2[0] = 2;
            for (int i4 = 1; i4 != (inputBlockSize - i2) - 1; i4++) {
                while (bArr2[i4] == 0) {
                    bArr2[i4] = (byte) this.f19649random.nextInt();
                }
            }
        }
        int i5 = inputBlockSize - i2;
        bArr2[i5 - 1] = 0;
        System.arraycopy(bArr, i, bArr2, i5, i2);
        return this.f19647engine.processBlock(bArr2, 0, inputBlockSize);
    }

    private boolean useStrict() {
        if (Properties.isOverrideSetTo(NOT_STRICT_LENGTH_ENABLED_PROPERTY, true)) {
            return false;
        }
        return !Properties.isOverrideSetTo(STRICT_LENGTH_ENABLED_PROPERTY, false);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.f19647engine.getInputBlockSize();
        return this.forEncryption ? inputBlockSize - 10 : inputBlockSize;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.f19647engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : outputBlockSize - 10;
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.f19647engine;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    /* renamed from: init */
    public void mo14943init(boolean z, CipherParameters cipherParameters) {
        AsymmetricKeyParameter asymmetricKeyParameter;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f19649random = parametersWithRandom.getRandom();
            asymmetricKeyParameter = (AsymmetricKeyParameter) parametersWithRandom.getParameters();
        } else {
            asymmetricKeyParameter = (AsymmetricKeyParameter) cipherParameters;
            if (!asymmetricKeyParameter.isPrivate() && z) {
                this.f19649random = CryptoServicesRegistrar.getSecureRandom();
            }
        }
        this.f19647engine.mo14943init(z, cipherParameters);
        this.forPrivateKey = asymmetricKeyParameter.isPrivate();
        this.forEncryption = z;
        this.blockBuffer = new byte[this.f19647engine.getOutputBlockSize()];
        if (this.f19648pLen > 0 && this.fallback == null && this.f19649random == null) {
            throw new IllegalArgumentException("encoder requires random");
        }
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        return this.forEncryption ? encodeBlock(bArr, i, i2) : decodeBlock(bArr, i, i2);
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, int i) {
        this.f19648pLen = -1;
        this.fallback = null;
        this.f19647engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.f19648pLen = i;
    }

    private static int checkPkcs1Encoding2(byte[] bArr, int i) {
        int i2 = -((bArr[0] & 255) ^ 2);
        int length = (bArr.length - 1) - i;
        int i3 = (length - 9) | i2;
        for (int i4 = 1; i4 < length; i4++) {
            i3 |= (bArr[i4] & 255) - 1;
        }
        return ((-(bArr[length] & 255)) | i3) >> 31;
    }

    public PKCS1Encoding(AsymmetricBlockCipher asymmetricBlockCipher, byte[] bArr) {
        this.f19648pLen = -1;
        this.fallback = null;
        this.f19647engine = asymmetricBlockCipher;
        this.useStrictLength = useStrict();
        this.fallback = bArr;
        this.f19648pLen = bArr.length;
    }
}
