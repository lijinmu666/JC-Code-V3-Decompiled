package org.bouncycastle.p361util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.bouncycastle.p361util.C6250Strings;

/* renamed from: org.bouncycastle.util.encoders.Base64 */
/* loaded from: classes2.dex */
public class C6253Base64 {

    /* renamed from: encoder */
    private static final InterfaceC6254Encoder f24210encoder = new Base64Encoder();

    /* renamed from: decode */
    public static int m18324decode(String str, OutputStream outputStream) {
        return f24210encoder.mo18320decode(str, outputStream);
    }

    /* renamed from: encode */
    public static int m18329encode(byte[] bArr, int i, int i2, OutputStream outputStream) {
        return f24210encoder.mo18322encode(bArr, i, i2, outputStream);
    }

    public static String toBase64String(byte[] bArr) {
        return toBase64String(bArr, 0, bArr.length);
    }

    /* renamed from: decode */
    public static int m18325decode(byte[] bArr, int i, int i2, OutputStream outputStream) {
        try {
            return f24210encoder.mo18321decode(bArr, i, i2, outputStream);
        } catch (Exception e) {
            throw new DecoderException("unable to decode base64 data: " + e.getMessage(), e);
        }
    }

    /* renamed from: encode */
    public static int m18330encode(byte[] bArr, OutputStream outputStream) {
        return f24210encoder.mo18322encode(bArr, 0, bArr.length, outputStream);
    }

    public static String toBase64String(byte[] bArr, int i, int i2) {
        return C6250Strings.fromByteArray(m18332encode(bArr, i, i2));
    }

    /* renamed from: decode */
    public static byte[] m18326decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() / 4) * 3);
        try {
            f24210encoder.mo18320decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException("unable to decode base64 string: " + e.getMessage(), e);
        }
    }

    /* renamed from: encode */
    public static byte[] m18331encode(byte[] bArr) {
        return m18332encode(bArr, 0, bArr.length);
    }

    /* renamed from: decode */
    public static byte[] m18327decode(byte[] bArr) {
        return m18328decode(bArr, 0, bArr.length);
    }

    /* renamed from: encode */
    public static byte[] m18332encode(byte[] bArr, int i, int i2) {
        InterfaceC6254Encoder interfaceC6254Encoder = f24210encoder;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(interfaceC6254Encoder.getEncodedLength(i2));
        try {
            interfaceC6254Encoder.mo18322encode(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new EncoderException("exception encoding base64 string: " + e.getMessage(), e);
        }
    }

    /* renamed from: decode */
    public static byte[] m18328decode(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((i2 / 4) * 3);
        try {
            f24210encoder.mo18321decode(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException("unable to decode base64 data: " + e.getMessage(), e);
        }
    }
}
