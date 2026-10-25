package p131o;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.Image;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;

/* renamed from: o.H */
/* loaded from: classes.dex */
public class C2066H {

    /* renamed from: mjFkc */
    public static final C2066H f8471mjFkc = new C2066H();

    /* renamed from: Dt */
    public static byte[] m8478Dt(byte[] bArr, int i, int i2) throws IllegalAccessException, C3993k2, IOException, IllegalArgumentException, InvocationTargetException {
        YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                    } catch (Exception unused) {
                    }
                }
                throw th;
            }
        } catch (IOException e) {
            Log.w("ImageConvertUtils", "Error closing ByteArrayOutputStream");
            throw new C3993k2("Image conversion error from NV21 format", 13, e);
        }
    }

    /* renamed from: ETF */
    public static final void m8479ETF(Image.Plane plane, int i, int i2, byte[] bArr, int i3, int i4) {
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        int iLimit = ((buffer.limit() + plane.getRowStride()) - 1) / plane.getRowStride();
        if (iLimit == 0) {
            return;
        }
        int i5 = i / (i2 / iLimit);
        int rowStride = 0;
        for (int i6 = 0; i6 < iLimit; i6++) {
            int pixelStride = rowStride;
            for (int i7 = 0; i7 < i5; i7++) {
                bArr[i3] = buffer.get(pixelStride);
                i3 += i4;
                pixelStride += plane.getPixelStride();
            }
            rowStride += plane.getRowStride();
        }
    }

    /* renamed from: ZfxDd */
    public static C2066H m8480ZfxDd() {
        return f8471mjFkc;
    }

    /* renamed from: lgHUyS */
    public static ByteBuffer m8481lgHUyS(ByteBuffer byteBuffer, boolean z) {
        int i;
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        int i2 = iLimit / 6;
        ByteBuffer byteBufferAllocate = z ? ByteBuffer.allocate(iLimit) : ByteBuffer.allocateDirect(iLimit);
        int i3 = 0;
        while (true) {
            i = i2 * 4;
            if (i3 >= i) {
                break;
            }
            byteBufferAllocate.put(i3, byteBuffer.get(i3));
            i3++;
        }
        for (int i4 = 0; i4 < i2 + i2; i4++) {
            byteBufferAllocate.put(i + i4, byteBuffer.get(((i4 % 2) * i2) + i + (i4 / 2)));
        }
        return byteBufferAllocate;
    }

    /* renamed from: mjFkc */
    public static ByteBuffer m8482mjFkc(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            return byteBuffer;
        }
        byteBuffer.rewind();
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: qdMbNW */
    public static Bitmap m8483qdMbNW(Bitmap bitmap, int i, int i2, int i3) {
        if (i == 0) {
            return Bitmap.createBitmap(bitmap, 0, 0, i2, i3);
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, i2, i3, matrix, true);
    }

    /* renamed from: xJ */
    public static Bitmap m8484xJ(ByteBuffer byteBuffer, int i, int i2, int i3) throws IllegalAccessException, C3993k2, IOException, IllegalArgumentException, InvocationTargetException {
        byte[] bArrM8478Dt = m8478Dt(m8481lgHUyS(byteBuffer, true).array(), i, i2);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrM8478Dt, 0, bArrM8478Dt.length);
        return m8483qdMbNW(bitmapDecodeByteArray, i3, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    /* renamed from: AZxh */
    public byte[] m8485AZxh(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0) {
            return byteBuffer.array();
        }
        byteBuffer.rewind();
        int iLimit = byteBuffer.limit();
        byte[] bArr = new byte[iLimit];
        byteBuffer.get(bArr, 0, iLimit);
        return bArr;
    }

    /* renamed from: JHa */
    public ByteBuffer m8486JHa(Image.Plane[] planeArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 4;
        byte[] bArr = new byte[i4 + i4 + i3];
        ByteBuffer buffer = planeArr[1].getBuffer();
        ByteBuffer buffer2 = planeArr[2].getBuffer();
        int iPosition = buffer2.position();
        int iLimit = buffer.limit();
        buffer2.position(iPosition + 1);
        buffer.limit(iLimit - 1);
        int i5 = (i3 + i3) / 4;
        boolean z = buffer2.remaining() == i5 + (-2) && buffer2.compareTo(buffer) == 0;
        buffer2.position(iPosition);
        buffer.limit(iLimit);
        if (z) {
            planeArr[0].getBuffer().get(bArr, 0, i3);
            ByteBuffer buffer3 = planeArr[1].getBuffer();
            planeArr[2].getBuffer().get(bArr, i3, 1);
            buffer3.get(bArr, i3 + 1, i5 - 1);
        } else {
            m8479ETF(planeArr[0], i, i2, bArr, 0, 1);
            m8479ETF(planeArr[1], i, i2, bArr, i3 + 1, 2);
            m8479ETF(planeArr[2], i, i2, bArr, i3, 2);
        }
        return ByteBuffer.wrap(bArr);
    }

    /* renamed from: KLFTb */
    public Bitmap m8487KLFTb(ByteBuffer byteBuffer, int i, int i2, int i3) throws IllegalAccessException, C3993k2, IOException, IllegalArgumentException, InvocationTargetException {
        byte[] bArrM8478Dt = m8478Dt(m8485AZxh(byteBuffer), i, i2);
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrM8478Dt, 0, bArrM8478Dt.length);
        return m8483qdMbNW(bitmapDecodeByteArray, i3, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight());
    }

    /* renamed from: wA */
    public Bitmap m8488wA(C2605P c2605p) throws C3993k2 {
        int iM9931KLFTb = c2605p.m9931KLFTb();
        if (iM9931KLFTb == -1) {
            return m8483qdMbNW((Bitmap) AbstractC2138I3.m8648xJ(c2605p.m9928AZxh()), c2605p.m9934qdMbNW(), c2605p.m9929Dt(), c2605p.m9930JHa());
        }
        if (iM9931KLFTb == 17) {
            return m8487KLFTb((ByteBuffer) AbstractC2138I3.m8648xJ(c2605p.m9935wA()), c2605p.m9929Dt(), c2605p.m9930JHa(), c2605p.m9934qdMbNW());
        }
        if (iM9931KLFTb == 35) {
            return m8487KLFTb(m8486JHa((Image.Plane[]) AbstractC2138I3.m8648xJ(c2605p.m9933lgHUyS()), c2605p.m9929Dt(), c2605p.m9930JHa()), c2605p.m9929Dt(), c2605p.m9930JHa(), c2605p.m9934qdMbNW());
        }
        if (iM9931KLFTb == 842094169) {
            return m8484xJ((ByteBuffer) AbstractC2138I3.m8648xJ(c2605p.m9935wA()), c2605p.m9929Dt(), c2605p.m9930JHa(), c2605p.m9934qdMbNW());
        }
        throw new C3993k2("Unsupported image format", 13);
    }
}
