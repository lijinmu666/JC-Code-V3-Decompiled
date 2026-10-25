package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.C3664f2;
import p131o.InterfaceC3068W0;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, m4988d2 = {"Landroidx/lifecycle/CompositeGeneratedAdaptersObserver;", "Landroidx/lifecycle/KLFTb;", BuildConfig.f24315FLAVOR, "Landroidx/lifecycle/AZxh;", "generatedAdapters", "<init>", "([Landroidx/lifecycle/AZxh;)V", "Lo/W0;", "source", "Landroidx/lifecycle/wA$mjFkc;", "event", BuildConfig.f24315FLAVOR, "VA", "(Lo/W0;Landroidx/lifecycle/wA$mjFkc;)V", "mjFkc", "[Landroidx/lifecycle/AZxh;", "lifecycle-common"}, m4989k = 1, m4990mv = {1, 8, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements InterfaceC0104KLFTb {

    /* renamed from: mjFkc, reason: from kotlin metadata */
    public final InterfaceC0100AZxh[] generatedAdapters;

    public CompositeGeneratedAdaptersObserver(InterfaceC0100AZxh[] generatedAdapters) {
        Intrinsics.checkNotNullParameter(generatedAdapters, "generatedAdapters");
        this.generatedAdapters = generatedAdapters;
    }

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 source, AbstractC0112wA.mjFkc event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        new C3664f2();
        InterfaceC0100AZxh[] interfaceC0100AZxhArr = this.generatedAdapters;
        if (interfaceC0100AZxhArr.length > 0) {
            InterfaceC0100AZxh interfaceC0100AZxh = interfaceC0100AZxhArr[0];
            throw null;
        }
        if (interfaceC0100AZxhArr.length <= 0) {
            return;
        }
        InterfaceC0100AZxh interfaceC0100AZxh2 = interfaceC0100AZxhArr[0];
        throw null;
    }
}
