package org.bouncycastle.p361util.p362io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.util.io.Streams */
/* loaded from: classes2.dex */
public final class C6257Streams {
    private static int BUFFER_SIZE = 4096;

    /* renamed from: drain */
    public static void m18360drain(InputStream inputStream) {
        int i = BUFFER_SIZE;
        while (inputStream.read(new byte[i], 0, i) >= 0) {
        }
    }

    /* renamed from: pipeAll */
    public static void m18361pipeAll(InputStream inputStream, OutputStream outputStream) throws IOException {
        m18362pipeAll(inputStream, outputStream, BUFFER_SIZE);
    }

    public static long pipeAllLimited(InputStream inputStream, long j, OutputStream outputStream) throws IOException {
        int i = BUFFER_SIZE;
        byte[] bArr = new byte[i];
        long j2 = 0;
        while (true) {
            int i2 = inputStream.read(bArr, 0, i);
            if (i2 < 0) {
                return j2;
            }
            long j3 = i2;
            if (j - j2 < j3) {
                throw new StreamOverflowException("Data Overflow");
            }
            j2 += j3;
            outputStream.write(bArr, 0, i2);
        }
    }

    /* renamed from: readAll */
    public static byte[] m18363readAll(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m18361pipeAll(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] readAllLimited(InputStream inputStream, int i) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        pipeAllLimited(inputStream, i, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static int readFully(InputStream inputStream, byte[] bArr) {
        return readFully(inputStream, bArr, 0, bArr.length);
    }

    public static void validateBufferArguments(byte[] bArr, int i, int i2) {
        C6238Arrays.validateSegment(bArr, i, i2);
    }

    public static void writeBufTo(ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream) throws IOException {
        byteArrayOutputStream.writeTo(outputStream);
    }

    /* renamed from: pipeAll */
    public static void m18362pipeAll(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        while (true) {
            int i2 = inputStream.read(bArr, 0, i);
            if (i2 < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i2);
            }
        }
    }

    public static int readFully(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = inputStream.read(bArr, i + i3, i2 - i3);
            if (i4 < 0) {
                break;
            }
            i3 += i4;
        }
        return i3;
    }
}
