package org.bouncycastle.p194crypto;

/* loaded from: classes2.dex */
public class BufferedAsymmetricBlockCipher {

    /* renamed from: buf */
    protected byte[] f19114buf;

    /* renamed from: bufOff */
    protected int f19115bufOff;

    /* renamed from: cipher */
    private final AsymmetricBlockCipher f19116cipher;

    public BufferedAsymmetricBlockCipher(AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f19116cipher = asymmetricBlockCipher;
    }

    /* renamed from: doFinal */
    public byte[] m14948doFinal() {
        byte[] bArrProcessBlock = this.f19116cipher.processBlock(this.f19114buf, 0, this.f19115bufOff);
        m14950reset();
        return bArrProcessBlock;
    }

    public int getBufferPosition() {
        return this.f19115bufOff;
    }

    public int getInputBlockSize() {
        return this.f19116cipher.getInputBlockSize();
    }

    public int getOutputBlockSize() {
        return this.f19116cipher.getOutputBlockSize();
    }

    public AsymmetricBlockCipher getUnderlyingCipher() {
        return this.f19116cipher;
    }

    /* renamed from: init */
    public void m14949init(boolean z, CipherParameters cipherParameters) {
        m14950reset();
        this.f19116cipher.mo14943init(z, cipherParameters);
        this.f19114buf = new byte[this.f19116cipher.getInputBlockSize() + (z ? 1 : 0)];
        this.f19115bufOff = 0;
    }

    public void processByte(byte b) {
        int i = this.f19115bufOff;
        byte[] bArr = this.f19114buf;
        if (i >= bArr.length) {
            throw new DataLengthException("attempt to process message too long for cipher");
        }
        this.f19115bufOff = i + 1;
        bArr[i] = b;
    }

    public void processBytes(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i3 = this.f19115bufOff;
        int i4 = i3 + i2;
        byte[] bArr2 = this.f19114buf;
        if (i4 > bArr2.length) {
            throw new DataLengthException("attempt to process message too long for cipher");
        }
        System.arraycopy(bArr, i, bArr2, i3, i2);
        this.f19115bufOff += i2;
    }

    /* renamed from: reset */
    public void m14950reset() {
        if (this.f19114buf != null) {
            int i = 0;
            while (true) {
                byte[] bArr = this.f19114buf;
                if (i >= bArr.length) {
                    break;
                }
                bArr[i] = 0;
                i++;
            }
        }
        this.f19115bufOff = 0;
    }
}
