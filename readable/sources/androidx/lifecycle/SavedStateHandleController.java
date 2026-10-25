package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import androidx.savedstate.C0184mjFkc;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p131o.InterfaceC3068W0;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, m4988d2 = {"Landroidx/lifecycle/SavedStateHandleController;", "Landroidx/lifecycle/KLFTb;", "Landroidx/savedstate/mjFkc;", "registry", "Landroidx/lifecycle/wA;", "lifecycle", BuildConfig.f24315FLAVOR, "mjFkc", "(Landroidx/savedstate/mjFkc;Landroidx/lifecycle/wA;)V", "Lo/W0;", "source", "Landroidx/lifecycle/wA$mjFkc;", "event", "VA", "(Lo/W0;Landroidx/lifecycle/wA$mjFkc;)V", BuildConfig.f24315FLAVOR, "<set-?>", "Z", "AZxh", "()Z", "isAttached", "lifecycle-viewmodel-savedstate_release"}, m4989k = 1, m4990mv = {1, 8, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nSavedStateHandleController.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SavedStateHandleController.kt\nandroidx/lifecycle/SavedStateHandleController\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,41:1\n1#2:42\n*E\n"})
/* loaded from: classes.dex */
public final class SavedStateHandleController implements InterfaceC0104KLFTb {

    /* renamed from: mjFkc, reason: from kotlin metadata */
    public boolean isAttached;

    /* renamed from: AZxh, reason: from getter */
    public final boolean getIsAttached() {
        return this.isAttached;
    }

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 source, AbstractC0112wA.mjFkc event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == AbstractC0112wA.mjFkc.ON_DESTROY) {
            this.isAttached = false;
            source.mo770JHa().mo1046wA(this);
        }
    }

    /* renamed from: mjFkc */
    public final void m1070mjFkc(C0184mjFkc registry, AbstractC0112wA lifecycle) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        if (this.isAttached) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        this.isAttached = true;
        lifecycle.mo1044mjFkc(this);
        throw null;
    }
}
