package org.bouncycastle.p194crypto.p201engines;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DESedeWrapEngine implements InterfaceC5283Wrapper {

    /* renamed from: IV2 */
    private static final byte[] f19819IV2 = {74, -35, -94, 44, 121, -24, 33, 5};

    /* renamed from: engine */
    private CBCBlockCipher f19821engine;
    private boolean forWrapping;

    /* renamed from: iv */
    private byte[] f19822iv;

    /* renamed from: param */
    private KeyParameter f19823param;
    private ParametersWithIV paramPlusIV;

    /* renamed from: sha1 */
    InterfaceC5277Digest f19824sha1 = DigestFactory.createSHA1();

    /* renamed from: digest */
    byte[] f19820digest = new byte[20];

    private byte[] calculateCMSKeyChecksum(byte[] bArr) {
        byte[] bArr2 = new byte[8];
        this.f19824sha1.mo14970update(bArr, 0, bArr.length);
        this.f19824sha1.mo14967doFinal(this.f19820digest, 0);
        System.arraycopy(this.f19820digest, 0, bArr2, 0, 8);
        return bArr2;
    }

    private boolean checkCMSKeyChecksum(byte[] bArr, byte[] bArr2) {
        return C6238Arrays.constantTimeAreEqual(calculateCMSKeyChecksum(bArr), bArr2);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    public String getAlgorithmName() {
        return "DESede";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: init */
    public void mo14995init(boolean z, CipherParameters cipherParameters) {
        SecureRandom secureRandom;
        this.forWrapping = z;
        this.f19821engine = new CBCBlockCipher(new DESedeEngine());
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            CipherParameters parameters = parametersWithRandom.getParameters();
            SecureRandom random = parametersWithRandom.getRandom();
            cipherParameters = parameters;
            secureRandom = random;
        } else {
            secureRandom = CryptoServicesRegistrar.getSecureRandom();
        }
        if (cipherParameters instanceof KeyParameter) {
            this.f19823param = (KeyParameter) cipherParameters;
            if (this.forWrapping) {
                byte[] bArr = new byte[8];
                this.f19822iv = bArr;
                secureRandom.nextBytes(bArr);
                this.paramPlusIV = new ParametersWithIV(this.f19823param, this.f19822iv);
                return;
            }
            return;
        }
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            this.paramPlusIV = parametersWithIV;
            this.f19822iv = parametersWithIV.m15801getIV();
            this.f19823param = (KeyParameter) this.paramPlusIV.getParameters();
            if (!this.forWrapping) {
                throw new IllegalArgumentException("You should not supply an IV for unwrapping");
            }
            byte[] bArr2 = this.f19822iv;
            if (bArr2 == null || bArr2.length != 8) {
                throw new IllegalArgumentException("IV is not 8 octets");
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: unwrap */
    public byte[] mo14996unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forWrapping) {
            throw new IllegalStateException("Not set for unwrapping");
        }
        if (bArr == null) {
            throw new InvalidCipherTextException("Null pointer as ciphertext");
        }
        int blockSize = this.f19821engine.getBlockSize();
        if (i2 % blockSize != 0) {
            throw new InvalidCipherTextException("Ciphertext not multiple of " + blockSize);
        }
        this.f19821engine.mo14946init(false, new ParametersWithIV(this.f19823param, f19819IV2));
        byte[] bArr2 = new byte[i2];
        for (int i3 = 0; i3 != i2; i3 += blockSize) {
            this.f19821engine.processBlock(bArr, i + i3, bArr2, i3);
        }
        C6238Arrays.reverseInPlace(bArr2);
        byte[] bArr3 = new byte[8];
        this.f19822iv = bArr3;
        int i4 = i2 - 8;
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr2, 0, bArr3, 0, 8);
        System.arraycopy(bArr2, 8, bArr4, 0, i4);
        ParametersWithIV parametersWithIV = new ParametersWithIV(this.f19823param, this.f19822iv);
        this.paramPlusIV = parametersWithIV;
        this.f19821engine.mo14946init(false, parametersWithIV);
        byte[] bArr5 = new byte[i4];
        for (int i5 = 0; i5 != i4; i5 += blockSize) {
            this.f19821engine.processBlock(bArr4, i5, bArr5, i5);
        }
        int i6 = i2 - 16;
        byte[] bArr6 = new byte[i6];
        byte[] bArr7 = new byte[8];
        System.arraycopy(bArr5, 0, bArr6, 0, i6);
        System.arraycopy(bArr5, i6, bArr7, 0, 8);
        if (checkCMSKeyChecksum(bArr6, bArr7)) {
            return bArr6;
        }
        throw new InvalidCipherTextException("Checksum inside ciphertext is corrupted");
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: wrap */
    public byte[] mo14997wrap(byte[] bArr, int i, int i2) {
        if (!this.forWrapping) {
            throw new IllegalStateException("Not initialized for wrapping");
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        byte[] bArrCalculateCMSKeyChecksum = calculateCMSKeyChecksum(bArr2);
        int length = bArrCalculateCMSKeyChecksum.length + i2;
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr2, 0, bArr3, 0, i2);
        System.arraycopy(bArrCalculateCMSKeyChecksum, 0, bArr3, i2, bArrCalculateCMSKeyChecksum.length);
        int blockSize = this.f19821engine.getBlockSize();
        if (length % blockSize != 0) {
            throw new IllegalStateException("Not multiple of block length");
        }
        this.f19821engine.mo14946init(true, this.paramPlusIV);
        byte[] bArr4 = new byte[length];
        for (int i3 = 0; i3 != length; i3 += blockSize) {
            this.f19821engine.processBlock(bArr3, i3, bArr4, i3);
        }
        byte[] bArr5 = this.f19822iv;
        int length2 = bArr5.length + length;
        byte[] bArr6 = new byte[length2];
        System.arraycopy(bArr5, 0, bArr6, 0, bArr5.length);
        System.arraycopy(bArr4, 0, bArr6, this.f19822iv.length, length);
        C6238Arrays.reverseInPlace(bArr6);
        this.f19821engine.mo14946init(true, new ParametersWithIV(this.f19823param, f19819IV2));
        for (int i4 = 0; i4 != length2; i4 += blockSize) {
            this.f19821engine.processBlock(bArr6, i4, bArr6, i4);
        }
        return bArr6;
    }
}
