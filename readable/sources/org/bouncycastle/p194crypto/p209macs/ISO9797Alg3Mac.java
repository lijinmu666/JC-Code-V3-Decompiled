package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p201engines.DESEngine;
import org.bouncycastle.p194crypto.p210modes.CBCBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.paddings.BlockCipherPadding;

/* loaded from: classes2.dex */
public class ISO9797Alg3Mac implements InterfaceC5278Mac {

    /* renamed from: buf */
    private byte[] f20454buf;

    /* renamed from: bufOff */
    private int f20455bufOff;

    /* renamed from: cipher */
    private BlockCipher f20456cipher;
    private KeyParameter lastKey2;
    private KeyParameter lastKey3;

    /* renamed from: mac */
    private byte[] f20457mac;

    /* renamed from: macSize */
    private int f20458macSize;

    /* renamed from: padding */
    private BlockCipherPadding f20459padding;

    public ISO9797Alg3Mac(BlockCipher blockCipher) {
        this(blockCipher, blockCipher.getBlockSize() * 8, null);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        int blockSize = this.f20456cipher.getBlockSize();
        if (this.f20459padding == null) {
            while (true) {
                int i2 = this.f20455bufOff;
                if (i2 >= blockSize) {
                    break;
                }
                this.f20454buf[i2] = 0;
                this.f20455bufOff = i2 + 1;
            }
        } else {
            if (this.f20455bufOff == blockSize) {
                this.f20456cipher.processBlock(this.f20454buf, 0, this.f20457mac, 0);
                this.f20455bufOff = 0;
            }
            this.f20459padding.addPadding(this.f20454buf, this.f20455bufOff);
        }
        this.f20456cipher.processBlock(this.f20454buf, 0, this.f20457mac, 0);
        DESEngine dESEngine = new DESEngine();
        dESEngine.mo14946init(false, this.lastKey2);
        byte[] bArr2 = this.f20457mac;
        dESEngine.processBlock(bArr2, 0, bArr2, 0);
        dESEngine.mo14946init(true, this.lastKey3);
        byte[] bArr3 = this.f20457mac;
        dESEngine.processBlock(bArr3, 0, bArr3, 0);
        System.arraycopy(this.f20457mac, 0, bArr, i, this.f20458macSize);
        mo14977reset();
        return this.f20458macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "ISO9797Alg3";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.f20458macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        KeyParameter keyParameter;
        mo14977reset();
        boolean z = cipherParameters instanceof KeyParameter;
        if (!z && !(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("params must be an instance of KeyParameter or ParametersWithIV");
        }
        byte[] bArrM15773getKey = (z ? (KeyParameter) cipherParameters : (KeyParameter) ((ParametersWithIV) cipherParameters).getParameters()).m15773getKey();
        if (bArrM15773getKey.length == 16) {
            keyParameter = new KeyParameter(bArrM15773getKey, 0, 8);
            this.lastKey2 = new KeyParameter(bArrM15773getKey, 8, 8);
            this.lastKey3 = keyParameter;
        } else {
            if (bArrM15773getKey.length != 24) {
                throw new IllegalArgumentException("Key must be either 112 or 168 bit long");
            }
            keyParameter = new KeyParameter(bArrM15773getKey, 0, 8);
            this.lastKey2 = new KeyParameter(bArrM15773getKey, 8, 8);
            this.lastKey3 = new KeyParameter(bArrM15773getKey, 16, 8);
        }
        boolean z2 = cipherParameters instanceof ParametersWithIV;
        BlockCipher blockCipher = this.f20456cipher;
        if (z2) {
            blockCipher.mo14946init(true, new ParametersWithIV(keyParameter, ((ParametersWithIV) cipherParameters).m15801getIV()));
        } else {
            blockCipher.mo14946init(true, keyParameter);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f20454buf;
            if (i >= bArr.length) {
                this.f20455bufOff = 0;
                this.f20456cipher.mo14947reset();
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
        int i = this.f20455bufOff;
        byte[] bArr = this.f20454buf;
        if (i == bArr.length) {
            this.f20456cipher.processBlock(bArr, 0, this.f20457mac, 0);
            this.f20455bufOff = 0;
        }
        byte[] bArr2 = this.f20454buf;
        int i2 = this.f20455bufOff;
        this.f20455bufOff = i2 + 1;
        bArr2[i2] = b;
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, int i) {
        this(blockCipher, i, null);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int blockSize = this.f20456cipher.getBlockSize();
        int i3 = this.f20455bufOff;
        int i4 = blockSize - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.f20454buf, i3, i4);
            this.f20456cipher.processBlock(this.f20454buf, 0, this.f20457mac, 0);
            this.f20455bufOff = 0;
            i2 -= i4;
            i += i4;
            while (i2 > blockSize) {
                this.f20456cipher.processBlock(bArr, i, this.f20457mac, 0);
                i2 -= blockSize;
                i += blockSize;
            }
        }
        System.arraycopy(bArr, i, this.f20454buf, this.f20455bufOff, i2);
        this.f20455bufOff += i2;
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, int i, BlockCipherPadding blockCipherPadding) {
        if (i % 8 != 0) {
            throw new IllegalArgumentException("MAC size must be multiple of 8");
        }
        if (!(blockCipher instanceof DESEngine)) {
            throw new IllegalArgumentException("cipher must be instance of DESEngine");
        }
        this.f20456cipher = CBCBlockCipher.newInstance(blockCipher);
        this.f20459padding = blockCipherPadding;
        this.f20458macSize = i / 8;
        this.f20457mac = new byte[blockCipher.getBlockSize()];
        this.f20454buf = new byte[blockCipher.getBlockSize()];
        this.f20455bufOff = 0;
    }

    public ISO9797Alg3Mac(BlockCipher blockCipher, BlockCipherPadding blockCipherPadding) {
        this(blockCipher, blockCipher.getBlockSize() * 8, blockCipherPadding);
    }
}
