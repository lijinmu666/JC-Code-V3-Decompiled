package p131o;

import org.conscrypt.BuildConfig;

/* renamed from: o.ps */
/* loaded from: classes.dex */
public final class C4376ps extends AbstractC1790Cs {

    /* renamed from: mjFkc */
    public static final C4376ps f15983mjFkc = new C4376ps();

    @Override // p131o.AbstractC1790Cs
    /* renamed from: AZxh */
    public final Object mo7937AZxh(Object obj) {
        return BuildConfig.f24315FLAVOR;
    }

    @Override // p131o.AbstractC1790Cs
    /* renamed from: equals */
    public final boolean mo7938equals(Object obj) {
        return obj == this;
    }

    @Override // p131o.AbstractC1790Cs
    public final int hashCode() {
        return 2040732332;
    }

    @Override // p131o.AbstractC1790Cs
    /* renamed from: mjFkc */
    public final Object mo7939mjFkc() {
        throw new IllegalStateException("Optional.get() cannot be called on an absent value");
    }

    public final String toString() {
        return "Optional.absent()";
    }

    @Override // p131o.AbstractC1790Cs
    /* renamed from: wA */
    public final boolean mo7940wA() {
        return false;
    }
}
