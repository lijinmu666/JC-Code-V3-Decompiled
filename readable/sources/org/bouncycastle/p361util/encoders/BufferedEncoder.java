package org.bouncycastle.p361util.encoders;

/* loaded from: classes2.dex */
public class BufferedEncoder {

    /* renamed from: buf */
    protected byte[] f24214buf;

    /* renamed from: bufOff */
    protected int f24215bufOff;
    protected Translator translator;

    public BufferedEncoder(Translator translator, int i) {
        this.translator = translator;
        if (i % translator.getEncodedBlockSize() != 0) {
            throw new IllegalArgumentException("buffer size not multiple of input block size");
        }
        this.f24214buf = new byte[i];
        this.f24215bufOff = 0;
    }

    public int processByte(byte b, byte[] bArr, int i) {
        byte[] bArr2 = this.f24214buf;
        int i2 = this.f24215bufOff;
        int i3 = i2 + 1;
        this.f24215bufOff = i3;
        bArr2[i2] = b;
        if (i3 != bArr2.length) {
            return 0;
        }
        int iMo18348encode = this.translator.mo18348encode(bArr2, 0, bArr2.length, bArr, i);
        this.f24215bufOff = 0;
        return iMo18348encode;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        byte[] bArr3 = this.f24214buf;
        int length = bArr3.length;
        int i4 = this.f24215bufOff;
        int i5 = length - i4;
        int iMo18348encode = 0;
        if (i2 > i5) {
            System.arraycopy(bArr, i, bArr3, i4, i5);
            Translator translator = this.translator;
            byte[] bArr4 = this.f24214buf;
            int iMo18348encode2 = translator.mo18348encode(bArr4, 0, bArr4.length, bArr2, i3);
            this.f24215bufOff = 0;
            int i6 = i2 - i5;
            int i7 = i + i5;
            int i8 = i3 + iMo18348encode2;
            int length2 = i6 - (i6 % this.f24214buf.length);
            iMo18348encode = iMo18348encode2 + this.translator.mo18348encode(bArr, i7, length2, bArr2, i8);
            i2 = i6 - length2;
            i = i7 + length2;
        }
        if (i2 != 0) {
            System.arraycopy(bArr, i, this.f24214buf, this.f24215bufOff, i2);
            this.f24215bufOff += i2;
        }
        return iMo18348encode;
    }
}
