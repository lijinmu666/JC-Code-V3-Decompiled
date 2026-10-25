package com.p038google.p039android.libraries.p055vision.visionkit.pipeline.p056alt;

import android.graphics.Bitmap;
import androidx.annotation.InterfaceC0000Keep;
import com.google.android.apps.common.proguard.UsedByNative;
import java.nio.ByteBuffer;
import p131o.C2340Kx;
import p131o.C2782Rm;
import p131o.C3907in;
import p131o.C4315oy;
import p131o.InterfaceC2643Pd;
import p131o.InterfaceC3317Zl;
import p131o.InterfaceC4171mm;
import p131o.InterfaceC4303om;

/* loaded from: classes.dex */
class NativePipelineImpl implements InterfaceC2643Pd {

    /* renamed from: AZxh */
    public InterfaceC3317Zl f2282AZxh;

    /* renamed from: ZfxDd */
    public InterfaceC4171mm f2283ZfxDd;

    /* renamed from: mjFkc */
    public C2340Kx f2284mjFkc;

    /* renamed from: wA */
    public InterfaceC4303om f2285wA;

    public NativePipelineImpl(InterfaceC3317Zl interfaceC3317Zl, InterfaceC4303om interfaceC4303om, InterfaceC4171mm interfaceC4171mm, C2340Kx c2340Kx) {
        this.f2282AZxh = interfaceC3317Zl;
        this.f2285wA = interfaceC4303om;
        this.f2283ZfxDd = interfaceC4171mm;
        this.f2284mjFkc = c2340Kx;
    }

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: close */
    public native void mo2407close(long j, long j2, long j3, long j4, long j5);

    @InterfaceC0000Keep
    @UsedByNative("pipeline_jni.cc")
    public void closeFileDescriptor(int i) {
        this.f2283ZfxDd.mo2418mjFkc(i);
    }

    @Override // p131o.InterfaceC2643Pd
    public native long initialize(byte[] bArr, long j, long j2, long j3, long j4, long j5);

    @Override // p131o.InterfaceC2643Pd
    public native long initializeFrameBufferReleaseCallback(long j);

    @Override // p131o.InterfaceC2643Pd
    public native long initializeFrameManager();

    @Override // p131o.InterfaceC2643Pd
    public native long initializeIsolationCallback();

    @Override // p131o.InterfaceC2643Pd
    public native long initializeResultsCallback();

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: mjFkc */
    public final void mo2408mjFkc() {
        this.f2284mjFkc = null;
        this.f2282AZxh = null;
        this.f2285wA = null;
        this.f2283ZfxDd = null;
    }

    @InterfaceC0000Keep
    @UsedByNative("pipeline_jni.cc")
    public void onReleaseAtTimestampUs(long j) {
        this.f2282AZxh.mo2412AZxh(j);
    }

    @InterfaceC0000Keep
    @UsedByNative("pipeline_jni.cc")
    public void onResult(byte[] bArr) {
        try {
            this.f2285wA.mo2416ZfxDd(C3907in.m12318xrEuO(bArr, this.f2284mjFkc));
        } catch (C4315oy e) {
            C2782Rm.f10471AZxh.m10098mjFkc(e, "Error in result from JNI layer", new Object[0]);
        }
    }

    @InterfaceC0000Keep
    @UsedByNative("pipeline_jni.cc")
    public int openFileDescriptor(String str) {
        this.f2283ZfxDd.mo2420wA(str);
        return -1;
    }

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: process */
    public native byte[] mo2409process(long j, long j2, long j3, byte[] bArr, int i, int i2, int i3, int i4);

    @Override // p131o.InterfaceC2643Pd
    public native byte[] processBitmap(long j, long j2, Bitmap bitmap, int i, int i2, int i3, int i4);

    @Override // p131o.InterfaceC2643Pd
    public native byte[] processYuvFrame(long j, long j2, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6);

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: start */
    public native void mo2410start(long j);

    @Override // p131o.InterfaceC2643Pd
    /* renamed from: stop */
    public native boolean mo2411stop(long j);

    @Override // p131o.InterfaceC2643Pd
    public native void waitUntilIdle(long j);

    public NativePipelineImpl(String str, InterfaceC3317Zl interfaceC3317Zl, InterfaceC4303om interfaceC4303om, InterfaceC4171mm interfaceC4171mm, C2340Kx c2340Kx) {
        this(interfaceC3317Zl, interfaceC4303om, interfaceC4171mm, c2340Kx);
        System.loadLibrary("mlkit_google_ocr_pipeline");
    }
}
