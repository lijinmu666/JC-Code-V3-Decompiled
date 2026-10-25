package p131o;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0112wA;
import androidx.savedstate.C0184mjFkc;
import androidx.savedstate.Recreator;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

/* renamed from: o.m6 */
/* loaded from: classes.dex */
public final class C4127m6 {

    /* renamed from: ZfxDd */
    public static final mjFkc f14872ZfxDd = new mjFkc(null);

    /* renamed from: AZxh */
    public final C0184mjFkc f14873AZxh;

    /* renamed from: mjFkc */
    public final InterfaceC4193n6 f14874mjFkc;

    /* renamed from: wA */
    public boolean f14875wA;

    /* renamed from: o.m6$mjFkc */
    public static final class mjFkc {
        public /* synthetic */ mjFkc(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: mjFkc */
        public final C4127m6 m12748mjFkc(InterfaceC4193n6 owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            return new C4127m6(owner, null);
        }

        public mjFkc() {
        }
    }

    public /* synthetic */ C4127m6(InterfaceC4193n6 interfaceC4193n6, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC4193n6);
    }

    /* renamed from: mjFkc */
    public static final C4127m6 m12743mjFkc(InterfaceC4193n6 interfaceC4193n6) {
        return f14872ZfxDd.m12748mjFkc(interfaceC4193n6);
    }

    /* renamed from: AZxh */
    public final C0184mjFkc m12744AZxh() {
        return this.f14873AZxh;
    }

    /* renamed from: KLFTb */
    public final void m12745KLFTb(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        this.f14873AZxh.m2094JHa(outBundle);
    }

    /* renamed from: ZfxDd */
    public final void m12746ZfxDd(Bundle bundle) {
        if (!this.f14875wA) {
            m12747wA();
        }
        AbstractC0112wA abstractC0112wAMo770JHa = this.f14874mjFkc.mo770JHa();
        if (!abstractC0112wAMo770JHa.mo1035AZxh().m1098lgHUyS(AbstractC0112wA.AZxh.STARTED)) {
            this.f14873AZxh.m2095KLFTb(bundle);
            return;
        }
        throw new IllegalStateException(("performRestore cannot be called when owner is " + abstractC0112wAMo770JHa.mo1035AZxh()).toString());
    }

    /* renamed from: wA */
    public final void m12747wA() {
        AbstractC0112wA abstractC0112wAMo770JHa = this.f14874mjFkc.mo770JHa();
        if (abstractC0112wAMo770JHa.mo1035AZxh() != AbstractC0112wA.AZxh.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        abstractC0112wAMo770JHa.mo1044mjFkc(new Recreator(this.f14874mjFkc));
        this.f14873AZxh.m2096ZfxDd(abstractC0112wAMo770JHa);
        this.f14875wA = true;
    }

    public C4127m6(InterfaceC4193n6 interfaceC4193n6) {
        this.f14874mjFkc = interfaceC4193n6;
        this.f14873AZxh = new C0184mjFkc();
    }
}
