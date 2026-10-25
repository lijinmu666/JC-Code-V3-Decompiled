package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.paddings.BlockCipherPadding;

/* loaded from: classes2.dex */
public class CFBBlockCipherMac implements InterfaceC5278Mac {

    /* renamed from: buf */
    private byte[] f20420buf;

    /* renamed from: bufOff */
    private int f20421bufOff;

    /* renamed from: cipher */
    private MacCFBBlockCipher f20422cipher;

    /* renamed from: mac */
    private byte[] f20423mac;

    /* renamed from: macSize */
    private int f20424macSize;

    /* renamed from: padding */
    private BlockCipherPadding f20425padding;

    public CFBBlockCipherMac(BlockCipher blockCipher) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, null);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        int blockSize = this.f20422cipher.getBlockSize();
        BlockCipherPadding blockCipherPadding = this.f20425padding;
        if (blockCipherPadding == null) {
            while (true) {
                int i2 = this.f20421bufOff;
                if (i2 >= blockSize) {
                    break;
                }
                this.f20420buf[i2] = 0;
                this.f20421bufOff = i2 + 1;
            }
        } else {
            blockCipherPadding.addPadding(this.f20420buf, this.f20421bufOff);
        }
        this.f20422cipher.processBlock(this.f20420buf, 0, this.f20423mac, 0);
        this.f20422cipher.getMacBlock(this.f20423mac);
        System.arraycopy(this.f20423mac, 0, bArr, i, this.f20424macSize);
        mo14977reset();
        return this.f20424macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return this.f20422cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.f20424macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        mo14977reset();
        this.f20422cipher.m15589init(cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f20420buf;
            if (i >= bArr.length) {
                this.f20421bufOff = 0;
                this.f20422cipher.m15590reset();
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
        int i = this.f20421bufOff;
        byte[] bArr = this.f20420buf;
        if (i == bArr.length) {
            this.f20422cipher.processBlock(bArr, 0, this.f20423mac, 0);
            this.f20421bufOff = 0;
        }
        byte[] bArr2 = this.f20420buf;
        int i2 = this.f20421bufOff;
        this.f20421bufOff = i2 + 1;
        bArr2[i2] = b;
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i, int i2) {
        this(blockCipher, i, i2, null);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = this.f20422cipher.getBlockSize();
        int i3 = this.f20421bufOff;
        int i4 = blockSize - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.f20420buf, i3, i4);
            this.f20422cipher.processBlock(this.f20420buf, 0, this.f20423mac, 0);
            this.f20421bufOff = 0;
            i2 -= i4;
            i += i4;
            while (i2 > blockSize) {
                this.f20422cipher.processBlock(bArr, i, this.f20423mac, 0);
                i2 -= blockSize;
                i += blockSize;
            }
        }
        System.arraycopy(bArr, i, this.f20420buf, this.f20421bufOff, i2);
        this.f20421bufOff += i2;
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, int i, int i2, BlockCipherPadding blockCipherPadding) {
        this.f20425padding = null;
        if (i2 % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        this.f20423mac = new byte[blockCipher.getBlockSize()];
        MacCFBBlockCipher macCFBBlockCipher = new MacCFBBlockCipher(blockCipher, i);
        this.f20422cipher = macCFBBlockCipher;
        this.f20425padding = blockCipherPadding;
        this.f20424macSize = i2 / 8;
        this.f20420buf = new byte[macCFBBlockCipher.getBlockSize()];
        this.f20421bufOff = 0;
    }

    public CFBBlockCipherMac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, 8, (blockCipher.getBlockSize() * 8) / 2, blockCipherPadding);
    }
}
