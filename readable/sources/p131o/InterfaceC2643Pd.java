package p131o;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* renamed from: o.Pd */
/* loaded from: classes.dex */
public interface InterfaceC2643Pd {
    /* renamed from: close */
    void mo2407close(long j, long j2, long j3, long j4, long j5);

    long initialize(byte[] bArr, long j, long j2, long j3, long j4, long j5);

    long initializeFrameBufferReleaseCallback(long j);

    long initializeFrameManager();

    long initializeIsolationCallback();

    long initializeResultsCallback();

    /* renamed from: mjFkc */
    void mo2408mjFkc();

    /* renamed from: process */
    byte[] mo2409process(long j, long j2, long j3, byte[] bArr, int i, int i2, int i3, int i4);

    byte[] processBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4);

    byte[] processYuvFrame(long j, long j2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6);

    /* renamed from: start */
    void mo2410start(long j);

    /* renamed from: stop */
    boolean mo2411stop(long j);

    void waitUntilIdle(long j);
}
