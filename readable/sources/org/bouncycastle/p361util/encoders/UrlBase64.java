package org.bouncycastle.p361util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public class UrlBase64 {

    /* renamed from: encoder */
    private static final InterfaceC6254Encoder f24239encoder = new UrlBase64Encoder();

    /* renamed from: decode */
    public static int m18350decode(String str, OutputStream outputStream) {
        return f24239encoder.mo18320decode(str, outputStream);
    }

    /* renamed from: encode */
    public static int m18354encode(byte[] bArr, OutputStream outputStream) {
        return f24239encoder.mo18322encode(bArr, 0, bArr.length, outputStream);
    }

    /* renamed from: decode */
    public static int m18351decode(byte[] bArr, OutputStream outputStream) {
        return f24239encoder.mo18321decode(bArr, 0, bArr.length, outputStream);
    }

    /* renamed from: encode */
    public static byte[] m18355encode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f24239encoder.mo18322encode(bArr, 0, bArr.length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new EncoderException("exception encoding URL safe base64 data: " + e.getMessage(), e);
        }
    }

    /* renamed from: decode */
    public static byte[] m18352decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f24239encoder.mo18320decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException("exception decoding URL safe base64 string: " + e.getMessage(), e);
        }
    }

    /* renamed from: decode */
    public static byte[] m18353decode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f24239encoder.mo18321decode(bArr, 0, bArr.length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException("exception decoding URL safe base64 string: " + e.getMessage(), e);
        }
    }
}
