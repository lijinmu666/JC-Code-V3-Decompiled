package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.paddings.BlockCipherPadding;

/* loaded from: classes2.dex */
public class CBCBlockCipherMac implements InterfaceC5278Mac {

    /* renamed from: buf */
    private byte[] f20414buf;

    /* renamed from: bufOff */
    private int f20415bufOff;

    /* renamed from: cipher */
    private BlockCipher f20416cipher;

    /* renamed from: mac */
    private byte[] f20417mac;

    /* renamed from: macSize */
    private int f20418macSize;

    /* renamed from: padding */
    private BlockCipherPadding f20419padding;

    public CBCBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, (blockCipher.getBlockSize() * 8) / 2, null);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        int blockSize = this.f20416cipher.getBlockSize();
        if (this.f20419padding == null) {
            while (true) {
                int i2 = this.f20415bufOff;
                if (i2 >= blockSize) {
                    break;
                }
                this.f20414buf[i2] = 0;
                this.f20415bufOff = i2 + 1;
            }
        } else {
            if (this.f20415bufOff == blockSize) {
                this.f20416cipher.processBlock(this.f20414buf, 0, this.f20417mac, 0);
                this.f20415bufOff = 0;
            }
            this.f20419padding.addPadding(this.f20414buf, this.f20415bufOff);
        }
        this.f20416cipher.processBlock(this.f20414buf, 0, this.f20417mac, 0);
        System.arraycopy(this.f20417mac, 0, bArr, i, this.f20418macSize);
        mo14977reset();
        return this.f20418macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return this.f20416cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.f20418macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        mo14977reset();
        this.f20416cipher.mo14946init(true, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f20414buf;
            if (i >= bArr.length) {
                this.f20415bufOff = 0;
                this.f20416cipher.mo14947reset();
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        int i = this.f20415bufOff;
        byte[] bArr = this.f20414buf;
        if (i == bArr.length) {
            this.f20416cipher.processBlock(bArr, 0, this.f20417mac, 0);
            this.f20415bufOff = 0;
        }
        byte[] bArr2 = this.f20414buf;
        int i2 = this.f20415bufOff;
        this.f20415bufOff = i2 + 1;
        bArr2[i2] = b;
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i) {
        this(blockCipher, i, null);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = this.f20416cipher.getBlockSize();
        int i3 = this.f20415bufOff;
        int i4 = blockSize - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.f20414buf, i3, i4);
            this.f20416cipher.processBlock(this.f20414buf, 0, this.f20417mac, 0);
            this.f20415bufOff = 0;
            i2 -= i4;
            i += i4;
            while (i2 > blockSize) {
                this.f20416cipher.processBlock(bArr, i, this.f20417mac, 0);
                i2 -= blockSize;
                i += blockSize;
            }
        }
        System.arraycopy(bArr, i, this.f20414buf, this.f20415bufOff, i2);
        this.f20415bufOff += i2;
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, int i, BlockCipherPadding blockCipherPadding) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        this.f20416cipher = CBCBlockCipher.newInstance(blockCipher);
        this.f20419padding = blockCipherPadding;
        this.f20418macSize = i / 8;
        this.f20417mac = new byte[blockCipher.getBlockSize()];
        this.f20414buf = new byte[blockCipher.getBlockSize()];
        this.f20415bufOff = 0;
    }

    public CBCBlockCipherMac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, (blockCipher.getBlockSize() * 8) / 2, blockCipherPadding);
    }
}
