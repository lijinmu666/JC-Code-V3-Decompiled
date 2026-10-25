package com.p038google.p039android.libraries.p055vision.visionkit.pipeline.p056alt;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import p131o.AbstractC1790Cs;
import p131o.C2340Kx;
import p131o.C2782Rm;
import p131o.C3518cl;
import p131o.C3907in;
import p131o.C4041km;
import p131o.C4235nl;
import p131o.C4315oy;
import p131o.C4368pl;
import p131o.EnumC4106ln;
import p131o.InterfaceC2643Pd;
import p131o.InterfaceC3317Zl;
import p131o.InterfaceC4171mm;
import p131o.InterfaceC4303om;

/* renamed from: com.google.android.libraries.vision.visionkit.pipeline.alt.mjFkc */
/* loaded from: classes.dex */
public abstract class AbstractC0222mjFkc implements InterfaceC3317Zl, InterfaceC4303om, InterfaceC4171mm {

    /* renamed from: AZxh */
    public final InterfaceC2643Pd f2286AZxh;

    /* renamed from: JHa */
    public final long f2287JHa;

    /* renamed from: KLFTb */
    public final long f2288KLFTb;

    /* renamed from: ZfxDd */
    public final long f2289ZfxDd;

    /* renamed from: lgHUyS */
    public final C2340Kx f2290lgHUyS;

    /* renamed from: mjFkc */
    public final C4368pl f2291mjFkc;

    /* renamed from: wA */
    public long f2292wA;

    /* renamed from: xJ */
    public final long f2293xJ;

    public AbstractC0222mjFkc(C4041km c4041km, String str) {
        C2340Kx c2340KxM9290AZxh = C2340Kx.m9290AZxh();
        C2340Kx c2340KxM9291mjFkc = c2340KxM9290AZxh == null ? C2340Kx.m9291mjFkc() : c2340KxM9290AZxh;
        if (c4041km.m12603cMLeY()) {
            this.f2286AZxh = new C3518cl(this);
        } else if (c4041km.m12605zvd()) {
            this.f2286AZxh = new NativePipelineImpl(this, this, this, c2340KxM9291mjFkc);
        } else {
            this.f2286AZxh = new NativePipelineImpl("mlkit_google_ocr_pipeline", this, this, this, c2340KxM9291mjFkc);
        }
        if (c4041km.m12604rWxwaT()) {
            this.f2291mjFkc = new C4368pl(c4041km.m12602OjSQV());
        } else {
            this.f2291mjFkc = new C4368pl(10);
        }
        this.f2290lgHUyS = c2340KxM9291mjFkc;
        long jInitializeFrameManager = this.f2286AZxh.initializeFrameManager();
        this.f2289ZfxDd = jInitializeFrameManager;
        long jInitializeFrameBufferReleaseCallback = this.f2286AZxh.initializeFrameBufferReleaseCallback(jInitializeFrameManager);
        this.f2288KLFTb = jInitializeFrameBufferReleaseCallback;
        long jInitializeResultsCallback = this.f2286AZxh.initializeResultsCallback();
        this.f2287JHa = jInitializeResultsCallback;
        long jInitializeIsolationCallback = this.f2286AZxh.initializeIsolationCallback();
        this.f2293xJ = jInitializeIsolationCallback;
        this.f2292wA = this.f2286AZxh.initialize(c4041km.m11866Dt(), jInitializeFrameBufferReleaseCallback, jInitializeResultsCallback, jInitializeIsolationCallback, 0L, 0L);
    }

    @Override // p131o.InterfaceC3317Zl
    /* renamed from: AZxh */
    public final void mo2412AZxh(long j) {
        this.f2291mjFkc.m13137mjFkc(j);
    }

    /* renamed from: Dt */
    public final AbstractC1790Cs m2413Dt(long j, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i, int i2, int i3, int i4, int i5, int i6) {
        if (this.f2292wA == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (!byteBuffer.isDirect() || !byteBuffer2.isDirect() || !byteBuffer3.isDirect()) {
            throw new IllegalStateException("Byte buffers are not direct.");
        }
        byte[] bArrProcessYuvFrame = this.f2286AZxh.processYuvFrame(this.f2292wA, j, byteBuffer, byteBuffer2, byteBuffer3, i, i2, i3, i4, i5, i6 - 1);
        if (bArrProcessYuvFrame == null) {
            return AbstractC1790Cs.m7936ZfxDd();
        }
        try {
            return AbstractC1790Cs.m7935KLFTb(C3907in.m12318xrEuO(bArrProcessYuvFrame, this.f2290lgHUyS));
        } catch (C4315oy e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }

    /* renamed from: JHa */
    public final synchronized void m2414JHa() {
        long j = this.f2292wA;
        if (j != 0) {
            this.f2286AZxh.mo2411stop(j);
            this.f2286AZxh.mo2407close(this.f2292wA, this.f2289ZfxDd, this.f2288KLFTb, this.f2287JHa, this.f2293xJ);
            this.f2292wA = 0L;
            this.f2286AZxh.mo2408mjFkc();
        }
    }

    /* renamed from: KLFTb */
    public final AbstractC1790Cs m2415KLFTb(C4235nl c4235nl) {
        byte[] bArrMo2409process;
        if (this.f2292wA == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (!this.f2291mjFkc.m13136AZxh(c4235nl, c4235nl.m12909mjFkc()) || (bArrMo2409process = this.f2286AZxh.mo2409process(this.f2292wA, this.f2289ZfxDd, c4235nl.m12909mjFkc(), c4235nl.m12910wA(), c4235nl.m12906AZxh().m10435AZxh(), c4235nl.m12906AZxh().m10437mjFkc(), c4235nl.m12908ZfxDd() - 1, c4235nl.m12907KLFTb() - 1)) == null) {
            return AbstractC1790Cs.m7936ZfxDd();
        }
        try {
            return AbstractC1790Cs.m7935KLFTb(C3907in.m12318xrEuO(bArrMo2409process, this.f2290lgHUyS));
        } catch (C4315oy e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }

    @Override // p131o.InterfaceC4303om
    /* renamed from: ZfxDd */
    public final void mo2416ZfxDd(C3907in c3907in) {
        C2782Rm.f10471AZxh.m10096AZxh(this, "Pipeline received results: ".concat(String.valueOf(c3907in)), new Object[0]);
    }

    /* renamed from: lgHUyS */
    public final void m2417lgHUyS() {
        long j = this.f2292wA;
        if (j == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (!this.f2286AZxh.mo2411stop(j)) {
            throw new IllegalStateException("Pipeline did not stop successfully.");
        }
    }

    @Override // p131o.InterfaceC4171mm
    /* renamed from: mjFkc */
    public final void mo2418mjFkc(int i) {
        Log.w("VKP", "closeFileDescriptor called but is not available for this pipeline. Ignoring call.");
    }

    /* renamed from: qdMbNW */
    public final AbstractC1790Cs m2419qdMbNW(long j, Bitmap bitmap, int i) {
        if (this.f2292wA == 0) {
            throw new IllegalStateException("Pipeline has been closed or was not initialized");
        }
        if (bitmap.getConfig() != Bitmap.Config.ARGB_8888) {
            throw new IllegalArgumentException("Unsupported bitmap config ".concat(String.valueOf(bitmap.getConfig())));
        }
        byte[] bArrProcessBitmap = this.f2286AZxh.processBitmap(this.f2292wA, j, bitmap, bitmap.getWidth(), bitmap.getHeight(), 0, i - 1);
        if (bArrProcessBitmap == null) {
            return AbstractC1790Cs.m7936ZfxDd();
        }
        try {
            return AbstractC1790Cs.m7935KLFTb(C3907in.m12318xrEuO(bArrProcessBitmap, this.f2290lgHUyS));
        } catch (C4315oy e) {
            throw new IllegalStateException("Could not parse results", e);
        }
    }

    @Override // p131o.InterfaceC4171mm
    /* renamed from: wA */
    public final int mo2420wA(String str) {
        Log.w("VKP", "openFileDescriptor called but is not available for this pipeline. Ignoring call.");
        return -1;
    }

    /* renamed from: xJ */
    public final void m2421xJ() throws PipelineException {
        long j = this.f2292wA;
        if (j == 0) {
            throw new PipelineException(EnumC4106ln.FAILED_PRECONDITION.ordinal(), "Pipeline has been closed or was not initialized");
        }
        try {
            this.f2286AZxh.mo2410start(j);
            this.f2286AZxh.waitUntilIdle(this.f2292wA);
        } catch (PipelineException e) {
            this.f2286AZxh.mo2411stop(this.f2292wA);
            throw e;
        }
    }
}
