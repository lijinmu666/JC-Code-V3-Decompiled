package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;

/* loaded from: classes2.dex */
public class BlockCipherMac implements InterfaceC5278Mac {

    /* renamed from: buf */
    private byte[] f20409buf;

    /* renamed from: bufOff */
    private int f20410bufOff;

    /* renamed from: cipher */
    private BlockCipher f20411cipher;

    /* renamed from: mac */
    private byte[] f20412mac;

    /* renamed from: macSize */
    private int f20413macSize;

    public BlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, (blockCipher.getBlockSize() * 8) / 2);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        int blockSize = this.f20411cipher.getBlockSize();
        while (true) {
            int i2 = this.f20410bufOff;
            if (i2 >= blockSize) {
                this.f20411cipher.processBlock(this.f20409buf, 0, this.f20412mac, 0);
                System.arraycopy(this.f20412mac, 0, bArr, i, this.f20413macSize);
                mo14977reset();
                return this.f20413macSize;
            }
            this.f20409buf[i2] = 0;
            this.f20410bufOff = i2 + 1;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return this.f20411cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.f20413macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        mo14977reset();
        this.f20411cipher.mo14946init(true, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f20409buf;
            if (i >= bArr.length) {
                this.f20410bufOff = 0;
                this.f20411cipher.mo14947reset();
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
        int i = this.f20410bufOff;
        byte[] bArr = this.f20409buf;
        if (i == bArr.length) {
            this.f20411cipher.processBlock(bArr, 0, this.f20412mac, 0);
            this.f20410bufOff = 0;
        }
        byte[] bArr2 = this.f20409buf;
        int i2 = this.f20410bufOff;
        this.f20410bufOff = i2 + 1;
        bArr2[i2] = b;
    }

    public BlockCipherMac(BlockCipher blockCipher, int i) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        this.f20411cipher = new CBCBlockCipher(blockCipher);
        this.f20413macSize = i / 8;
        this.f20412mac = new byte[blockCipher.getBlockSize()];
        this.f20409buf = new byte[blockCipher.getBlockSize()];
        this.f20410bufOff = 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = this.f20411cipher.getBlockSize();
        int i3 = this.f20410bufOff;
        int i4 = blockSize - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.f20409buf, i3, i4);
            this.f20411cipher.processBlock(this.f20409buf, 0, this.f20412mac, 0);
            this.f20410bufOff = 0;
            i2 -= i4;
            i += i4;
            while (i2 > blockSize) {
                this.f20411cipher.processBlock(bArr, i, this.f20412mac, 0);
                i2 -= blockSize;
                i += blockSize;
            }
        }
        System.arraycopy(bArr, i, this.f20409buf, this.f20410bufOff, i2);
        this.f20410bufOff += i2;
    }
}
