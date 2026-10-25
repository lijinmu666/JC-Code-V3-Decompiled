package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p201engines.DSTU7624Engine;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DSTU7624Mac implements InterfaceC5278Mac {
    private static final int BITS_IN_BYTE = 8;
    private int blockSize;

    /* renamed from: buf */
    private byte[] f20437buf;

    /* renamed from: bufOff */
    private int f20438bufOff;

    /* renamed from: c */
    private byte[] f20439c;

    /* renamed from: cTemp */
    private byte[] f20440cTemp;

    /* renamed from: engine */
    private DSTU7624Engine f20441engine;
    private boolean initCalled = false;

    /* renamed from: kDelta */
    private byte[] f20442kDelta;

    /* renamed from: macSize */
    private int f20443macSize;

    public DSTU7624Mac(int i, int i2) {
        this.f20441engine = new DSTU7624Engine(i);
        int i3 = i / 8;
        this.blockSize = i3;
        this.f20443macSize = i2 / 8;
        this.f20439c = new byte[i3];
        this.f20442kDelta = new byte[i3];
        this.f20440cTemp = new byte[i3];
        this.f20437buf = new byte[i3];
    }

    private void processBlock(byte[] bArr, int i) {
        m15583xor(this.f20439c, 0, bArr, i, this.f20440cTemp);
        this.f20441engine.processBlock(this.f20440cTemp, 0, this.f20439c, 0);
    }

    /* renamed from: xor */
    private void m15583xor(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3) {
        int length = bArr.length - i;
        int i3 = this.blockSize;
        if (length < i3 || bArr2.length - i2 < i3 || bArr3.length < i3) {
            throw new IllegalArgumentException("some of input buffers too short");
        }
        for (int i4 = 0; i4 < this.blockSize; i4++) {
            bArr3[i4] = (byte) (bArr[i4 + i] ^ bArr2[i4 + i2]);
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        int i2 = this.f20438bufOff;
        byte[] bArr2 = this.f20437buf;
        if (i2 % bArr2.length != 0) {
            throw new DataLengthException("input must be a multiple of blocksize");
        }
        m15583xor(this.f20439c, 0, bArr2, 0, this.f20440cTemp);
        m15583xor(this.f20440cTemp, 0, this.f20442kDelta, 0, this.f20439c);
        DSTU7624Engine dSTU7624Engine = this.f20441engine;
        byte[] bArr3 = this.f20439c;
        dSTU7624Engine.processBlock(bArr3, 0, bArr3, 0);
        int i3 = this.f20443macSize;
        if (i3 + i > bArr.length) {
            throw new OutputLengthException("output buffer too short");
        }
        System.arraycopy(this.f20439c, 0, bArr, i, i3);
        mo14977reset();
        return this.f20443macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "DSTU7624Mac";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.f20443macSize;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("Invalid parameter passed to DSTU7624Mac");
        }
        this.f20441engine.mo14946init(true, cipherParameters);
        this.initCalled = true;
        mo14977reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        C6238Arrays.m18249fill(this.f20439c, (byte) 0);
        C6238Arrays.m18249fill(this.f20440cTemp, (byte) 0);
        C6238Arrays.m18249fill(this.f20442kDelta, (byte) 0);
        C6238Arrays.m18249fill(this.f20437buf, (byte) 0);
        this.f20441engine.mo14947reset();
        if (this.initCalled) {
            DSTU7624Engine dSTU7624Engine = this.f20441engine;
            byte[] bArr = this.f20442kDelta;
            dSTU7624Engine.processBlock(bArr, 0, bArr, 0);
        }
        this.f20438bufOff = 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        int i = this.f20438bufOff;
        byte[] bArr = this.f20437buf;
        if (i == bArr.length) {
            processBlock(bArr, 0);
            this.f20438bufOff = 0;
        }
        byte[] bArr2 = this.f20437buf;
        int i2 = this.f20438bufOff;
        this.f20438bufOff = i2 + 1;
        bArr2[i2] = b;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("can't have a negative input length!");
        }
        int blockSize = this.f20441engine.getBlockSize();
        int i3 = this.f20438bufOff;
        int i4 = blockSize - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.f20437buf, i3, i4);
            processBlock(this.f20437buf, 0);
            this.f20438bufOff = 0;
            i2 -= i4;
            i += i4;
            while (i2 > blockSize) {
                processBlock(bArr, i);
                i2 -= blockSize;
                i += blockSize;
            }
        }
        System.arraycopy(bArr, i, this.f20437buf, this.f20438bufOff, i2);
        this.f20438bufOff += i2;
    }
}
