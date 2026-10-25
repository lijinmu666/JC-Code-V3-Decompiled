package com.p038google.p039android.p042gms.p046common.p047api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.InterfaceC0000Keep;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p131o.AbstractC2138I3;
import p131o.C2084HF;
import p131o.C2799S0;
import p131o.FragmentC3740gD;
import p131o.InterfaceC2929U0;

/* loaded from: classes.dex */
public class LifecycleCallback {

    /* renamed from: mjFkc */
    public final InterfaceC2929U0 f2259mjFkc;

    public LifecycleCallback(InterfaceC2929U0 interfaceC2929U0) {
        this.f2259mjFkc = interfaceC2929U0;
    }

    /* renamed from: ZfxDd */
    public static InterfaceC2929U0 m2381ZfxDd(C2799S0 c2799s0) {
        if (c2799s0.m10126ZfxDd()) {
            c2799s0.m10125AZxh();
            return C2084HF.m8529SKTn(null);
        }
        if (c2799s0.m10128wA()) {
            return FragmentC3740gD.m11984JHa(c2799s0.m10127mjFkc());
        }
        throw new IllegalArgumentException("Can't get fragment for unexpected activity.");
    }

    @InterfaceC0000Keep
    private static InterfaceC2929U0 getChimeraLifecycleFragmentImpl(C2799S0 c2799s0) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    /* renamed from: wA */
    public static InterfaceC2929U0 m2382wA(Activity activity) {
        return m2381ZfxDd(new C2799S0(activity));
    }

    /* renamed from: AZxh */
    public Activity m2383AZxh() {
        Activity activityMo8532KLFTb = this.f2259mjFkc.mo8532KLFTb();
        AbstractC2138I3.m8648xJ(activityMo8532KLFTb);
        return activityMo8532KLFTb;
    }

    /* renamed from: Dt */
    public void mo2384Dt() {
    }

    /* renamed from: ETF */
    public void mo2385ETF() {
    }

    /* renamed from: JHa */
    public void mo2386JHa(Bundle bundle) {
    }

    /* renamed from: KLFTb */
    public void mo2387KLFTb(int i, int i2, Intent intent) {
    }

    /* renamed from: lgHUyS */
    public void mo2388lgHUyS() {
    }

    /* renamed from: mjFkc */
    public void m2389mjFkc(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* renamed from: qdMbNW */
    public void mo2390qdMbNW(Bundle bundle) {
    }

    /* renamed from: xJ */
    public void m2391xJ() {
    }
}
