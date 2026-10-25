package org.bouncycastle.p194crypto.encodings;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class OAEPEncoding implements AsymmetricBlockCipher {

    /* renamed from: defHash */
    private final byte[] f19644defHash;

    /* renamed from: engine */
    private final AsymmetricBlockCipher f19645engine;
    private boolean forEncryption;
    private final InterfaceC5277Digest mgf1Hash;
    private final int mgf1NoMemoLimit;

    /* renamed from: random */
    private SecureRandom f19646random;

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher) {
        this(asymmetricBlockCipher, DigestFactory.createSHA1(), null);
    }

    private static int getMGF1NoMemoLimit(InterfaceC5277Digest interfaceC5277Digest) {
        if ((interfaceC5277Digest instanceof Memoable) && (interfaceC5277Digest instanceof ExtendedDigest)) {
            return ((ExtendedDigest) interfaceC5277Digest).getByteLength() - 1;
        }
        return Integer.MAX_VALUE;
    }

    private void maskGeneratorFunction1(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        int i5;
        int digestSize = this.mgf1Hash.getDigestSize();
        byte[] bArr3 = new byte[digestSize];
        byte[] bArr4 = new byte[4];
        int i6 = i4 + i3;
        int i7 = i6 - digestSize;
        this.mgf1Hash.mo14970update(bArr, i, i2);
        if (i2 > this.mgf1NoMemoLimit) {
            Memoable memoable = (Memoable) this.mgf1Hash;
            Memoable memoableMo14823copy = memoable.mo14823copy();
            i5 = 0;
            while (i3 < i7) {
                AbstractC6245Pack.intToBigEndian(i5, bArr4, 0);
                this.mgf1Hash.mo14970update(bArr4, 0, 4);
                this.mgf1Hash.mo14967doFinal(bArr3, 0);
                memoable.mo14824reset(memoableMo14823copy);
                C6240Bytes.m18280xorTo(digestSize, bArr3, 0, bArr2, i3);
                i3 += digestSize;
                i5++;
            }
        } else {
            int i8 = i3;
            int i9 = 0;
            while (i8 < i7) {
                AbstractC6245Pack.intToBigEndian(i9, bArr4, 0);
                this.mgf1Hash.mo14970update(bArr4, 0, 4);
                this.mgf1Hash.mo14967doFinal(bArr3, 0);
                this.mgf1Hash.mo14970update(bArr, i, i2);
                C6240Bytes.m18280xorTo(digestSize, bArr3, 0, bArr2, i8);
                i8 += digestSize;
                i9++;
            }
            i5 = i9;
            i3 = i8;
        }
        AbstractC6245Pack.intToBigEndian(i5, bArr4, 0);
        this.mgf1Hash.mo14970update(bArr4, 0, 4);
        this.mgf1Hash.mo14967doFinal(bArr3, 0);
        C6240Bytes.m18280xorTo(i6 - i3, bArr3, 0, bArr2, i3);
    }

    public byte[] decodeBlock(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        byte[] bArr2;
        int outputBlockSize = getOutputBlockSize();
        int outputBlockSize2 = this.f19645engine.getOutputBlockSize();
        byte[] bArr3 = new byte[outputBlockSize2];
        byte[] bArrProcessBlock = this.f19645engine.processBlock(bArr, i, i2);
        int length = ((outputBlockSize2 - bArrProcessBlock.length) | outputBlockSize) >> 31;
        int iMin = Math.min(outputBlockSize2, bArrProcessBlock.length);
        System.arraycopy(bArrProcessBlock, 0, bArr3, outputBlockSize2 - iMin, iMin);
        C6238Arrays.m18249fill(bArrProcessBlock, (byte) 0);
        this.mgf1Hash.mo14968reset();
        byte[] bArr4 = this.f19644defHash;
        maskGeneratorFunction1(bArr3, bArr4.length, outputBlockSize2 - bArr4.length, bArr3, 0, bArr4.length);
        byte[] bArr5 = this.f19644defHash;
        maskGeneratorFunction1(bArr3, 0, bArr5.length, bArr3, bArr5.length, outputBlockSize2 - bArr5.length);
        int i3 = 0;
        while (true) {
            bArr2 = this.f19644defHash;
            if (i3 == bArr2.length) {
                break;
            }
            length |= bArr3[bArr2.length + i3] ^ bArr2[i3];
            i3++;
        }
        int i4 = -1;
        for (int length2 = bArr2.length * 2; length2 != outputBlockSize2; length2++) {
            i4 += (((-(bArr3[length2] & 255)) & i4) >> 31) & length2;
        }
        if (((i4 >> 31) | length | (bArr3[i4 + 1] ^ 1)) != 0) {
            C6238Arrays.m18249fill(bArr3, (byte) 0);
            throw new InvalidCipherTextException("data wrong");
        }
        int i5 = i4 + 2;
        int i6 = outputBlockSize2 - i5;
        byte[] bArr6 = new byte[i6];
        System.arraycopy(bArr3, i5, bArr6, 0, i6);
        C6238Arrays.m18249fill(bArr3, (byte) 0);
        return bArr6;
    }

    public byte[] encodeBlock(byte[] bArr, int i, int i2) {
        int inputBlockSize = getInputBlockSize();
        if (i2 > inputBlockSize) {
            throw new DataLengthException("input data too long");
        }
        int length = inputBlockSize + 1 + (this.f19644defHash.length * 2);
        byte[] bArr2 = new byte[length];
        int i3 = length - i2;
        System.arraycopy(bArr, i, bArr2, i3, i2);
        bArr2[i3 - 1] = 1;
        byte[] bArr3 = this.f19644defHash;
        System.arraycopy(bArr3, 0, bArr2, bArr3.length, bArr3.length);
        int length2 = this.f19644defHash.length;
        byte[] bArr4 = new byte[length2];
        this.f19646random.nextBytes(bArr4);
        System.arraycopy(bArr4, 0, bArr2, 0, this.f19644defHash.length);
        this.mgf1Hash.mo14968reset();
        byte[] bArr5 = this.f19644defHash;
        maskGeneratorFunction1(bArr4, 0, length2, bArr2, bArr5.length, length - bArr5.length);
        byte[] bArr6 = this.f19644defHash;
        maskGeneratorFunction1(bArr2, bArr6.length, length - bArr6.length, bArr2, 0, bArr6.length);
        return this.f19645engine.processBlock(bArr2, 0, length);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        int inputBlockSize = this.f19645engine.getInputBlockSize();
        return this.forEncryption ? (inputBlockSize - 1) - (this.f19644defHash.length * 2) : inputBlockSize;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        int outputBlockSize = this.f19645engine.getOutputBlockSize();
        return this.forEncryption ? outputBlockSize : (outputBlockSize - 1) - (this.f19644defHash.length * 2);
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.f19645engine;
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    /* renamed from: init */
    public void mo14943init(boolean z, CipherParameters cipherParameters) {
        this.f19646random = z ? CryptoServicesRegistrar.getSecureRandom(cipherParameters instanceof ParametersWithRandom ? ((ParametersWithRandom) cipherParameters).getRandom() : null) : null;
        this.forEncryption = z;
        this.f19645engine.mo14943init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i, int i2) {
        return this.forEncryption ? encodeBlock(bArr, i, i2) : decodeBlock(bArr, i, i2);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest) {
        this(asymmetricBlockCipher, interfaceC5277Digest, null);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, InterfaceC5277Digest interfaceC5277Digest2, byte[] bArr) {
        this.f19645engine = asymmetricBlockCipher;
        this.mgf1Hash = interfaceC5277Digest2;
        this.mgf1NoMemoLimit = getMGF1NoMemoLimit(interfaceC5277Digest2);
        byte[] bArr2 = new byte[interfaceC5277Digest.getDigestSize()];
        this.f19644defHash = bArr2;
        interfaceC5277Digest.mo14968reset();
        if (bArr != null) {
            interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
        }
        interfaceC5277Digest.mo14967doFinal(bArr2, 0);
    }

    public OAEPEncoding(AsymmetricBlockCipher asymmetricBlockCipher, InterfaceC5277Digest interfaceC5277Digest, byte[] bArr) {
        this(asymmetricBlockCipher, interfaceC5277Digest, interfaceC5277Digest, bArr);
    }
}
