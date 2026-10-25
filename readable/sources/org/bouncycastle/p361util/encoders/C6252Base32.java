package org.bouncycastle.p361util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.bouncycastle.p361util.C6250Strings;

/* renamed from: org.bouncycastle.util.encoders.Base32 */
/* loaded from: classes2.dex */
public class C6252Base32 {

    /* renamed from: encoder */
    private static final InterfaceC6254Encoder f24208encoder = new Base32Encoder();

    /* renamed from: decode */
    public static int m18310decode(String str, OutputStream outputStream) {
        return f24208encoder.mo18320decode(str, outputStream);
    }

    /* renamed from: encode */
    public static int m18314encode(byte[] bArr, int i, int i2, OutputStream outputStream) {
        return f24208encoder.mo18322encode(bArr, i, i2, outputStream);
    }

    public static String toBase32String(byte[] bArr) {
        return toBase32String(bArr, 0, bArr.length);
    }

    /* renamed from: decode */
    public static int m18311decode(byte[] bArr, int i, int i2, OutputStream outputStream) {
        try {
            return f24208encoder.mo18321decode(bArr, i, i2, outputStream);
        } catch (Exception e) {
            throw new DecoderException("unable to decode base32 data: " + e.getMessage(), e);
        }
    }

    /* renamed from: encode */
    public static int m18315encode(byte[] bArr, OutputStream outputStream) {
        return f24208encoder.mo18322encode(bArr, 0, bArr.length, outputStream);
    }

    public static String toBase32String(byte[] bArr, int i, int i2) {
        return C6250Strings.fromByteArray(m18317encode(bArr, i, i2));
    }

    /* renamed from: decode */
    public static byte[] m18312decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((str.length() / 8) * 5);
        try {
            f24208encoder.mo18320decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException("unable to decode base32 string: " + e.getMessage(), e);
        }
    }

    /* renamed from: encode */
    public static byte[] m18316encode(byte[] bArr) {
        return m18317encode(bArr, 0, bArr.length);
    }

    /* renamed from: decode */
    public static byte[] m18313decode(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((bArr.length / 8) * 5);
        try {
            f24208encoder.mo18321decode(bArr, 0, bArr.length, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException("unable to decode base32 data: " + e.getMessage(), e);
        }
    }

    /* renamed from: encode */
    public static byte[] m18317encode(byte[] bArr, int i, int i2) {
        InterfaceC6254Encoder interfaceC6254Encoder = f24208encoder;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(interfaceC6254Encoder.getEncodedLength(i2));
        try {
            interfaceC6254Encoder.mo18322encode(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new EncoderException("exception encoding base32 string: " + e.getMessage(), e);
        }
    }
}
