package org.bouncycastle.p361util.encoders;

/* loaded from: classes2.dex */
public interface Translator {
    /* renamed from: decode */
    int mo18347decode(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    /* renamed from: encode */
    int mo18348encode(byte[] bArr, int i, int i2, byte[] bArr2, int i3);

    int getDecodedBlockSize();

    int getEncodedBlockSize();
}
