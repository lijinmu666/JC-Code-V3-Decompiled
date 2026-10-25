package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.LegacySavedStateHandleController;
import androidx.savedstate.C0184mjFkc;
import java.util.Iterator;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.AbstractC3764ga;
import p131o.C3893ia;
import p131o.InterfaceC3068W0;
import p131o.InterfaceC3958ja;
import p131o.InterfaceC4193n6;

/* loaded from: classes.dex */
public final class LegacySavedStateHandleController {

    /* renamed from: mjFkc */
    public static final LegacySavedStateHandleController f1354mjFkc = new LegacySavedStateHandleController();

    /* renamed from: androidx.lifecycle.LegacySavedStateHandleController$mjFkc */
    public static final class C0105mjFkc implements C0184mjFkc.mjFkc {
        @Override // androidx.savedstate.C0184mjFkc.mjFkc
        /* renamed from: mjFkc */
        public void mo1053mjFkc(InterfaceC4193n6 owner) throws NoSuchMethodException, SecurityException {
            Intrinsics.checkNotNullParameter(owner, "owner");
            if (!(owner instanceof InterfaceC3958ja)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner");
            }
            C3893ia c3893iaMo841wA = ((InterfaceC3958ja) owner).mo841wA();
            C0184mjFkc c0184mjFkcMo825mjFkc = owner.mo825mjFkc();
            Iterator it = c3893iaMo841wA.m12300AZxh().iterator();
            while (it.hasNext()) {
                AbstractC3764ga abstractC3764gaM12301mjFkc = c3893iaMo841wA.m12301mjFkc((String) it.next());
                Intrinsics.checkNotNull(abstractC3764gaM12301mjFkc);
                LegacySavedStateHandleController.m1051mjFkc(abstractC3764gaM12301mjFkc, c0184mjFkcMo825mjFkc, owner.mo770JHa());
            }
            if (c3893iaMo841wA.m12300AZxh().isEmpty()) {
                return;
            }
            c0184mjFkcMo825mjFkc.m2097lgHUyS(C0105mjFkc.class);
        }
    }

    /* renamed from: mjFkc */
    public static final void m1051mjFkc(AbstractC3764ga viewModel, C0184mjFkc registry, AbstractC0112wA lifecycle) throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) viewModel.m12013mjFkc("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || savedStateHandleController.getIsAttached()) {
            return;
        }
        savedStateHandleController.m1070mjFkc(registry, lifecycle);
        f1354mjFkc.m1052AZxh(registry, lifecycle);
    }

    /* renamed from: AZxh */
    public final void m1052AZxh(final C0184mjFkc c0184mjFkc, final AbstractC0112wA abstractC0112wA) throws NoSuchMethodException, SecurityException {
        AbstractC0112wA.AZxh aZxhMo1035AZxh = abstractC0112wA.mo1035AZxh();
        if (aZxhMo1035AZxh == AbstractC0112wA.AZxh.INITIALIZED || aZxhMo1035AZxh.m1098lgHUyS(AbstractC0112wA.AZxh.STARTED)) {
            c0184mjFkc.m2097lgHUyS(C0105mjFkc.class);
        } else {
            abstractC0112wA.mo1044mjFkc(new InterfaceC0104KLFTb() { // from class: androidx.lifecycle.LegacySavedStateHandleController$tryToAddRecreator$1
                @Override // androidx.lifecycle.InterfaceC0104KLFTb
                /* renamed from: VA */
                public void mo4VA(InterfaceC3068W0 source, AbstractC0112wA.mjFkc event) throws NoSuchMethodException, SecurityException {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(event, "event");
                    if (event == AbstractC0112wA.mjFkc.ON_START) {
                        abstractC0112wA.mo1046wA(this);
                        c0184mjFkc.m2097lgHUyS(LegacySavedStateHandleController.C0105mjFkc.class);
                    }
                }
            });
        }
    }
}
