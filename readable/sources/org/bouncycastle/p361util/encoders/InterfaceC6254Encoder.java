package org.bouncycastle.p361util.encoders;

import java.io.OutputStream;

/* renamed from: org.bouncycastle.util.encoders.Encoder */
/* loaded from: classes2.dex */
public interface InterfaceC6254Encoder {
    /* renamed from: decode */
    int mo18320decode(String str, OutputStream outputStream);

    /* renamed from: decode */
    int mo18321decode(byte[] bArr, int i, int i2, OutputStream outputStream);

    /* renamed from: encode */
    int mo18322encode(byte[] bArr, int i, int i2, OutputStream outputStream);

    int getEncodedLength(int i);

    int getMaxDecodedLength(int i);
}
