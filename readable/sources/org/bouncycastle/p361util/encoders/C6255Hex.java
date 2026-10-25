package org.bouncycastle.p361util.encoders;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import org.bouncycastle.p361util.C6250Strings;

/* renamed from: org.bouncycastle.util.encoders.Hex */
/* loaded from: classes2.dex */
public class C6255Hex {

    /* renamed from: encoder */
    private static final HexEncoder f24218encoder = new HexEncoder();

    /* renamed from: decode */
    public static int m18337decode(String str, OutputStream outputStream) {
        return f24218encoder.mo18320decode(str, outputStream);
    }

    public static byte[] decodeStrict(String str) {
        try {
            return f24218encoder.decodeStrict(str, 0, str.length());
        } catch (Exception e) {
            throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
        }
    }

    /* renamed from: encode */
    public static int m18341encode(byte[] bArr, int i, int i2, OutputStream outputStream) {
        return f24218encoder.mo18322encode(bArr, i, i2, outputStream);
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    /* renamed from: decode */
    public static byte[] m18338decode(String str) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f24218encoder.mo18320decode(str, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
        }
    }

    public static byte[] decodeStrict(String str, int i, int i2) {
        try {
            return f24218encoder.decodeStrict(str, i, i2);
        } catch (Exception e) {
            throw new DecoderException("exception decoding Hex string: " + e.getMessage(), e);
        }
    }

    /* renamed from: encode */
    public static int m18342encode(byte[] bArr, OutputStream outputStream) {
        return f24218encoder.mo18322encode(bArr, 0, bArr.length, outputStream);
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        return C6250Strings.fromByteArray(m18344encode(bArr, i, i2));
    }

    /* renamed from: decode */
    public static byte[] m18339decode(byte[] bArr) {
        return m18340decode(bArr, 0, bArr.length);
    }

    /* renamed from: encode */
    public static byte[] m18343encode(byte[] bArr) {
        return m18344encode(bArr, 0, bArr.length);
    }

    /* renamed from: decode */
    public static byte[] m18340decode(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 / 2);
        try {
            f24218encoder.mo18321decode(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new DecoderException("exception decoding Hex data: " + e.getMessage(), e);
        }
    }

    /* renamed from: encode */
    public static byte[] m18344encode(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            f24218encoder.mo18322encode(bArr, i, i2, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new EncoderException("exception encoding Hex string: " + e.getMessage(), e);
        }
    }
}
