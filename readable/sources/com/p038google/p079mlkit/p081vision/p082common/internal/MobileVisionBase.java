package com.p038google.p079mlkit.p081vision.p082common.internal;

import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.InterfaceC0109lgHUyS;
import com.p038google.p079mlkit.p081vision.p082common.internal.MobileVisionBase;
import java.io.Closeable;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.conscrypt.BuildConfig;
import p131o.AbstractC1670B7;
import p131o.AbstractC2138I3;
import p131o.AbstractC2142I7;
import p131o.AbstractC4455r1;
import p131o.C2605P;
import p131o.C2731QyqF;
import p131o.C2758RP;
import p131o.C3401b;
import p131o.C3993k2;
import p131o.InterfaceC3001V0;
import p131o.InterfaceC3405b3;

/* loaded from: classes.dex */
public class MobileVisionBase<DetectionResultT> implements Closeable, InterfaceC3001V0 {

    /* renamed from: JHa */
    public static final C3401b f4027JHa = new C3401b("MobileVisionBase", BuildConfig.f24315FLAVOR);

    /* renamed from: AZxh */
    public final AbstractC4455r1 f4028AZxh;

    /* renamed from: KLFTb */
    public final AbstractC1670B7 f4029KLFTb;

    /* renamed from: ZfxDd */
    public final Executor f4030ZfxDd;

    /* renamed from: mjFkc */
    public final AtomicBoolean f4031mjFkc = new AtomicBoolean(false);

    /* renamed from: wA */
    public final C2731QyqF f4032wA;

    public MobileVisionBase(AbstractC4455r1 abstractC4455r1, Executor executor) {
        this.f4028AZxh = abstractC4455r1;
        C2731QyqF c2731QyqF = new C2731QyqF();
        this.f4032wA = c2731QyqF;
        this.f4030ZfxDd = executor;
        abstractC4455r1.m12843wA();
        this.f4029KLFTb = abstractC4455r1.m12842mjFkc(executor, new Callable() { // from class: o.dD
            @Override // java.util.concurrent.Callable
            public final Object call() {
                C3401b c3401b = MobileVisionBase.f4027JHa;
                return null;
            }
        }, c2731QyqF.m10033AZxh()).mo7670wA(new InterfaceC3405b3() { // from class: o.wE
            @Override // p131o.InterfaceC3405b3
            /* renamed from: mjFkc */
            public final void mo4877mjFkc(Exception exc) {
                MobileVisionBase.f4027JHa.m11441ZfxDd("MobileVisionBase", "Error preloading model resource", exc);
            }
        });
    }

    /* renamed from: Pq */
    public synchronized AbstractC1670B7 m4299Pq(final C2605P c2605p) {
        AbstractC2138I3.m8644lgHUyS(c2605p, "InputImage can not be null");
        if (this.f4031mjFkc.get()) {
            return AbstractC2142I7.m8714AZxh(new C3993k2("This detector is already closed!", 14));
        }
        if (c2605p.m9929Dt() < 32 || c2605p.m9930JHa() < 32) {
            return AbstractC2142I7.m8714AZxh(new C3993k2("InputImage width and height should be at least 32!", 3));
        }
        return this.f4028AZxh.m12842mjFkc(this.f4030ZfxDd, new Callable() { // from class: o.mB
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f14884mjFkc.m4300diqgf(c2605p);
            }
        }, this.f4032wA.m10033AZxh());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @InterfaceC0109lgHUyS(m1072value = AbstractC0112wA.mjFkc.ON_DESTROY)
    public synchronized void close() {
        if (this.f4031mjFkc.getAndSet(true)) {
            return;
        }
        this.f4032wA.m10034mjFkc();
        this.f4028AZxh.m12840KLFTb(this.f4030ZfxDd);
    }

    /* renamed from: diqgf */
    public final /* synthetic */ Object m4300diqgf(C2605P c2605p) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        C2758RP c2758rpM10060qdMbNW = C2758RP.m10060qdMbNW("detectorTaskWithResource#run");
        c2758rpM10060qdMbNW.mo9503KLFTb();
        try {
            Object objMo12286qdMbNW = this.f4028AZxh.mo12286qdMbNW(c2605p);
            c2758rpM10060qdMbNW.close();
            return objMo12286qdMbNW;
        } catch (Throwable th) {
            try {
                c2758rpM10060qdMbNW.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }
}
