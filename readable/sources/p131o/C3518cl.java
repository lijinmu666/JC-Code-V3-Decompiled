package p131o;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* renamed from: o.cl */
/* loaded from: classes.dex */
public final class C3518cl implements InterfaceC2643Pd {
    public C3518cl(InterfaceC3317Zl interfaceC3317Zl) {
    }

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: close */
    public final void mo2407close(long j, long j2, long j3, long j4, long j5) {
    }

    @Override // p131o.InterfaceC2643Pd
    public final long initialize(byte[] bArr, long j, long j2, long j3, long j4, long j5) {
        return 1L;
    }

    @Override // p131o.InterfaceC2643Pd
    public final long initializeFrameBufferReleaseCallback(long j) {
        return 1L;
    }

    @Override // p131o.InterfaceC2643Pd
    public final long initializeFrameManager() {
        return 1L;
    }

    @Override // p131o.InterfaceC2643Pd
    public final long initializeIsolationCallback() {
        return 1L;
    }

    @Override // p131o.InterfaceC2643Pd
    public final long initializeResultsCallback() {
        return 1L;
    }

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: mjFkc */
    public final void mo2408mjFkc() {
    }

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: process */
    public final byte[] mo2409process(long j, long j2, long j3, byte[] bArr, int i, int i2, int i3, int i4) {
        return C3907in.m12316CqaNbM().m11866Dt();
    }

    @Override // p131o.InterfaceC2643Pd
    public final byte[] processBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4) {
        return C3907in.m12316CqaNbM().m11866Dt();
    }

    @Override // p131o.InterfaceC2643Pd
    public final byte[] processYuvFrame(long j, long j2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6) {
        return C3907in.m12316CqaNbM().m11866Dt();
    }

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: start */
    public final void mo2410start(long j) {
    }

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: stop */
    public final boolean mo2411stop(long j) {
        return true;
    }

    @Override // p131o.InterfaceC2643Pd
    public final void waitUntilIdle(long j) {
    }
}
