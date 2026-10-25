package org.bouncycastle.p361util.encoders;

/* loaded from: classes2.dex */
public class BufferedDecoder {

    /* renamed from: buf */
    protected byte[] f24212buf;

    /* renamed from: bufOff */
    protected int f24213bufOff;
    protected Translator translator;

    public BufferedDecoder(Translator translator, int i) {
        this.translator = translator;
        if (i % translator.getEncodedBlockSize() != 0) {
            throw new IllegalArgumentException("buffer size not multiple of input block size");
        }
        this.f24212buf = new byte[i];
        this.f24213bufOff = 0;
    }

    public int processByte(byte b, byte[] bArr, int i) {
        byte[] bArr2 = this.f24212buf;
        int i2 = this.f24213bufOff;
        int i3 = i2 + 1;
        this.f24213bufOff = i3;
        bArr2[i2] = b;
        if (i3 != bArr2.length) {
            return 0;
        }
        int iMo18347decode = this.translator.mo18347decode(bArr2, 0, bArr2.length, bArr, i);
        this.f24213bufOff = 0;
        return iMo18347decode;
    }

    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        byte[] bArr3 = this.f24212buf;
        int length = bArr3.length;
        int i4 = this.f24213bufOff;
        int i5 = length - i4;
        int iMo18347decode = 0;
        if (i2 > i5) {
            System.arraycopy(bArr, i, bArr3, i4, i5);
            Translator translator = this.translator;
            byte[] bArr4 = this.f24212buf;
            int iMo18347decode2 = translator.mo18347decode(bArr4, 0, bArr4.length, bArr2, i3);
            this.f24213bufOff = 0;
            int i6 = i2 - i5;
            int i7 = i + i5;
            int i8 = i3 + iMo18347decode2;
            int length2 = i6 - (i6 % this.f24212buf.length);
            iMo18347decode = iMo18347decode2 + this.translator.mo18347decode(bArr, i7, length2, bArr2, i8);
            i2 = i6 - length2;
            i = i7 + length2;
        }
        if (i2 != 0) {
            System.arraycopy(bArr, i, this.f24212buf, this.f24213bufOff, i2);
            this.f24213bufOff += i2;
        }
        return iMo18347decode;
    }
}
