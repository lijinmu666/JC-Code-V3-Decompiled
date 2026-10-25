package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.InterfaceC3068W0;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, m4988d2 = {"Landroidx/lifecycle/SavedStateHandleAttacher;", "Landroidx/lifecycle/KLFTb;", "Lo/W0;", "source", "Landroidx/lifecycle/wA$mjFkc;", "event", BuildConfig.f24315FLAVOR, "VA", "(Lo/W0;Landroidx/lifecycle/wA$mjFkc;)V", "lifecycle-viewmodel-savedstate_release"}, m4989k = 1, m4990mv = {1, 8, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements InterfaceC0104KLFTb {
    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 source, AbstractC0112wA.mjFkc event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == AbstractC0112wA.mjFkc.ON_CREATE) {
            source.mo770JHa().mo1046wA(this);
            throw null;
        }
        throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
    }
}
