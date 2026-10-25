package org.bouncycastle.p194crypto.p201engines;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5283Wrapper;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class RFC3211WrapEngine implements InterfaceC5283Wrapper {

    /* renamed from: engine */
    private CBCBlockCipher f20006engine;
    private boolean forWrapping;

    /* renamed from: param */
    private ParametersWithIV f20007param;

    /* renamed from: rand */
    private SecureRandom f20008rand;

    public RFC3211WrapEngine(BlockCipher blockCipher) {
        this.f20006engine = new CBCBlockCipher(blockCipher);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    public String getAlgorithmName() {
        return this.f20006engine.getUnderlyingCipher().getAlgorithmName() + "/RFC3211Wrap";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: init */
    public void mo14995init(boolean z, CipherParameters cipherParameters) {
        this.forWrapping = z;
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f20008rand = parametersWithRandom.getRandom();
            if (!(parametersWithRandom.getParameters() instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("RFC3211Wrap requires an IV");
            }
            this.f20007param = (ParametersWithIV) parametersWithRandom.getParameters();
            return;
        }
        if (z) {
            this.f20008rand = CryptoServicesRegistrar.getSecureRandom();
        }
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("RFC3211Wrap requires an IV");
        }
        this.f20007param = (ParametersWithIV) cipherParameters;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: unwrap */
    public byte[] mo14996unwrap(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        if (this.forWrapping) {
            throw new IllegalStateException("not set for unwrapping");
        }
        int blockSize = this.f20006engine.getBlockSize();
        if (i2 < blockSize * 2) {
            throw new InvalidCipherTextException("input too short");
        }
        byte[] bArr2 = new byte[i2];
        byte[] bArr3 = new byte[blockSize];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        System.arraycopy(bArr, i, bArr3, 0, blockSize);
        this.f20006engine.mo14946init(false, new ParametersWithIV(this.f20007param.getParameters(), bArr3));
        for (int i3 = blockSize; i3 < i2; i3 += blockSize) {
            this.f20006engine.processBlock(bArr2, i3, bArr2, i3);
        }
        System.arraycopy(bArr2, i2 - blockSize, bArr3, 0, blockSize);
        this.f20006engine.mo14946init(false, new ParametersWithIV(this.f20007param.getParameters(), bArr3));
        this.f20006engine.processBlock(bArr2, 0, bArr2, 0);
        this.f20006engine.mo14946init(false, this.f20007param);
        for (int i4 = 0; i4 < i2; i4 += blockSize) {
            this.f20006engine.processBlock(bArr2, i4, bArr2, i4);
        }
        int i5 = bArr2[0];
        int i6 = i2 - 4;
        boolean z = (i5 & 255) > i6;
        byte[] bArr4 = z ? new byte[i6] : new byte[i5 & 255];
        System.arraycopy(bArr2, 4, bArr4, 0, bArr4.length);
        int i7 = 0;
        int i8 = 0;
        while (i7 != 3) {
            int i9 = i7 + 1;
            i8 |= bArr2[i7 + 4] ^ ((byte) (~bArr2[i9]));
            i7 = i9;
        }
        C6238Arrays.m18227clear(bArr2);
        if (!z && !(i8 != 0)) {
            return bArr4;
        }
        throw new InvalidCipherTextException("wrapped key corrupted");
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5283Wrapper
    /* renamed from: wrap */
    public byte[] mo14997wrap(byte[] bArr, int i, int i2) {
        if (!this.forWrapping) {
            throw new IllegalStateException("not set for wrapping");
        }
        if (i2 > 255 || i2 < 0) {
            throw new IllegalArgumentException("input must be from 0 to 255 bytes");
        }
        this.f20006engine.mo14946init(true, this.f20007param);
        int blockSize = this.f20006engine.getBlockSize();
        int i3 = i2 + 4;
        int i4 = blockSize * 2;
        if (i3 >= i4) {
            i4 = i3 % blockSize == 0 ? i3 : ((i3 / blockSize) + 1) * blockSize;
        }
        byte[] bArr2 = new byte[i4];
        bArr2[0] = (byte) i2;
        System.arraycopy(bArr, i, bArr2, 4, i2);
        int length = bArr2.length - i3;
        byte[] bArr3 = new byte[length];
        this.f20008rand.nextBytes(bArr3);
        System.arraycopy(bArr3, 0, bArr2, i3, length);
        bArr2[1] = (byte) (~bArr2[4]);
        bArr2[2] = (byte) (~bArr2[5]);
        bArr2[3] = (byte) (~bArr2[6]);
        for (int i5 = 0; i5 < bArr2.length; i5 += blockSize) {
            this.f20006engine.processBlock(bArr2, i5, bArr2, i5);
        }
        for (int i6 = 0; i6 < bArr2.length; i6 += blockSize) {
            this.f20006engine.processBlock(bArr2, i6, bArr2, i6);
        }
        return bArr2;
    }
}
