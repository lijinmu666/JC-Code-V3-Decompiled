package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.InterfaceC0104KLFTb;
import androidx.savedstate.C0184mjFkc;
import androidx.savedstate.Recreator;
import java.util.Map;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.C3802h6;
import p131o.InterfaceC3068W0;
import p131o.InterfaceC4193n6;

/* renamed from: androidx.savedstate.mjFkc */
/* loaded from: classes.dex */
public final class C0184mjFkc {

    /* renamed from: xJ */
    public static final AZxh f1944xJ = new AZxh(null);

    /* renamed from: AZxh */
    public boolean f1945AZxh;

    /* renamed from: KLFTb */
    public Recreator.C0182AZxh f1947KLFTb;

    /* renamed from: ZfxDd */
    public boolean f1948ZfxDd;

    /* renamed from: wA */
    public Bundle f1950wA;

    /* renamed from: mjFkc */
    public final C3802h6 f1949mjFkc = new C3802h6();

    /* renamed from: JHa */
    public boolean f1946JHa = true;

    /* renamed from: androidx.savedstate.mjFkc$AZxh */
    public static final class AZxh {
        public /* synthetic */ AZxh(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public AZxh() {
        }
    }

    /* renamed from: androidx.savedstate.mjFkc$mjFkc */
    public interface mjFkc {
        /* renamed from: mjFkc */
        void mo1053mjFkc(InterfaceC4193n6 interfaceC4193n6);
    }

    /* renamed from: androidx.savedstate.mjFkc$wA */
    public interface wA {
        /* renamed from: mjFkc */
        Bundle mo2090mjFkc();
    }

    /* renamed from: wA */
    public static final void m2092wA(C0184mjFkc this$0, InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc event) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(interfaceC3068W0, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == AbstractC0112wA.mjFkc.ON_START) {
            this$0.f1946JHa = true;
        } else if (event == AbstractC0112wA.mjFkc.ON_STOP) {
            this$0.f1946JHa = false;
        }
    }

    /* renamed from: AZxh */
    public final Bundle m2093AZxh(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (!this.f1948ZfxDd) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f1950wA;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f1950wA;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f1950wA;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.f1950wA = null;
        }
        return bundle2;
    }

    /* renamed from: JHa */
    public final void m2094JHa(Bundle outBundle) {
        Intrinsics.checkNotNullParameter(outBundle, "outBundle");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f1950wA;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        C3802h6.ZfxDd zfxDdM12176xJ = this.f1949mjFkc.m12176xJ();
        Intrinsics.checkNotNullExpressionValue(zfxDdM12176xJ, "this.components.iteratorWithAdditions()");
        while (zfxDdM12176xJ.hasNext()) {
            Map.Entry entry = (Map.Entry) zfxDdM12176xJ.next();
            bundle.putBundle((String) entry.getKey(), ((wA) entry.getValue()).mo2090mjFkc());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }

    /* renamed from: KLFTb */
    public final void m2095KLFTb(Bundle bundle) {
        if (!this.f1945AZxh) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (this.f1948ZfxDd) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        this.f1950wA = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        this.f1948ZfxDd = true;
    }

    /* renamed from: ZfxDd */
    public final void m2096ZfxDd(AbstractC0112wA lifecycle) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (this.f1945AZxh) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.mo1044mjFkc(new InterfaceC0104KLFTb() { // from class: o.l6
            @Override // androidx.lifecycle.InterfaceC0104KLFTb
            /* renamed from: VA */
            public final void mo4VA(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc) {
                C0184mjFkc.m2092wA(this.f14674mjFkc, interfaceC3068W0, mjfkc);
            }
        });
        this.f1945AZxh = true;
    }

    /* renamed from: lgHUyS */
    public final void m2097lgHUyS(Class clazz) throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (!this.f1946JHa) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Recreator.C0182AZxh c0182AZxh = this.f1947KLFTb;
        if (c0182AZxh == null) {
            c0182AZxh = new Recreator.C0182AZxh(this);
        }
        this.f1947KLFTb = c0182AZxh;
        try {
            clazz.getDeclaredConstructor(null);
            Recreator.C0182AZxh c0182AZxh2 = this.f1947KLFTb;
            if (c0182AZxh2 != null) {
                String name = clazz.getName();
                Intrinsics.checkNotNullExpressionValue(name, "clazz.name");
                c0182AZxh2.m2089AZxh(name);
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + clazz.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }

    /* renamed from: xJ */
    public final void m2098xJ(String key, wA provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (((wA) this.f1949mjFkc.mo12167Dt(key, provider)) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }
}
