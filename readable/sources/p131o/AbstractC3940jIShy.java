package p131o;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import p094kotlin.C1126UByte;

/* renamed from: o.jIShy */
/* loaded from: classes.dex */
public abstract class AbstractC3940jIShy {
    /* renamed from: AZxh */
    public static byte[] m12409AZxh(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    /* renamed from: Dt */
    public static int m12410Dt(InputStream inputStream) {
        return (int) m12426xJ(inputStream, 1);
    }

    /* renamed from: ETF */
    public static int m12411ETF(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    /* renamed from: IEE */
    public static void m12412IEE(OutputStream outputStream, int i) throws IOException {
        m12424rkYL(outputStream, i, 1);
    }

    /* renamed from: JHa */
    public static String m12413JHa(InputStream inputStream, int i) {
        return new String(m12418ZfxDd(inputStream, i), StandardCharsets.UTF_8);
    }

    /* renamed from: KLFTb */
    public static byte[] m12414KLFTb(InputStream inputStream, int i, int i2) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i2];
            byte[] bArr2 = new byte[2048];
            int i3 = 0;
            int iInflate = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i3 < i) {
                int i4 = inputStream.read(bArr2);
                if (i4 < 0) {
                    throw m12425wA("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i + " bytes");
                }
                inflater.setInput(bArr2, 0, i4);
                try {
                    iInflate += inflater.inflate(bArr, iInflate, i2 - iInflate);
                    i3 += i4;
                } catch (DataFormatException e) {
                    throw m12425wA(e.getMessage());
                }
            }
            if (i3 == i) {
                if (inflater.finished()) {
                    return bArr;
                }
                throw m12425wA("Inflater did not finish");
            }
            throw m12425wA("Didn't read enough bytes during decompression. expected=" + i + " actual=" + i3);
        } finally {
            inflater.end();
        }
    }

    /* renamed from: MiMN */
    public static void m12415MiMN(OutputStream outputStream, byte[] bArr) throws IOException {
        m12419fehf(outputStream, bArr.length);
        byte[] bArrM12409AZxh = m12409AZxh(bArr);
        m12419fehf(outputStream, bArrM12409AZxh.length);
        outputStream.write(bArrM12409AZxh);
    }

    /* renamed from: VA */
    public static void m12416VA(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[512];
        while (true) {
            int i = inputStream.read(bArr);
            if (i <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }

    /* renamed from: YoKzxo */
    public static void m12417YoKzxo(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    /* renamed from: ZfxDd */
    public static byte[] m12418ZfxDd(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 < 0) {
                throw m12425wA("Not enough bytes to read: " + i);
            }
            i2 += i3;
        }
        return bArr;
    }

    /* renamed from: fehf */
    public static void m12419fehf(OutputStream outputStream, long j) throws IOException {
        m12424rkYL(outputStream, j, 4);
    }

    /* renamed from: lgHUyS */
    public static int m12420lgHUyS(InputStream inputStream) {
        return (int) m12426xJ(inputStream, 2);
    }

    /* renamed from: mjFkc */
    public static int m12421mjFkc(int i) {
        return ((i + 7) & (-8)) / 8;
    }

    /* renamed from: qGY */
    public static void m12422qGY(OutputStream outputStream, int i) throws IOException {
        m12424rkYL(outputStream, i, 2);
    }

    /* renamed from: qdMbNW */
    public static long m12423qdMbNW(InputStream inputStream) {
        return m12426xJ(inputStream, 4);
    }

    /* renamed from: rkYL */
    public static void m12424rkYL(OutputStream outputStream, long j, int i) throws IOException {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((j >> (i2 * 8)) & 255);
        }
        outputStream.write(bArr);
    }

    /* renamed from: wA */
    public static RuntimeException m12425wA(String str) {
        return new IllegalStateException(str);
    }

    /* renamed from: xJ */
    public static long m12426xJ(InputStream inputStream, int i) throws IOException {
        byte[] bArrM12418ZfxDd = m12418ZfxDd(inputStream, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j += (bArrM12418ZfxDd[i2] & C1126UByte.MAX_VALUE) << (i2 * 8);
        }
        return j;
    }
}
