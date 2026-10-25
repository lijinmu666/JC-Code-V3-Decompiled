package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.AbstractC0112wA;
import androidx.lifecycle.InterfaceC0104KLFTb;
import androidx.savedstate.C0184mjFkc;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.InterfaceC3068W0;
import p131o.InterfaceC4193n6;

@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0002\u000f\u0012B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0011¨\u0006\u0013"}, m4988d2 = {"Landroidx/savedstate/Recreator;", "Landroidx/lifecycle/KLFTb;", "Lo/n6;", "owner", "<init>", "(Lo/n6;)V", "Lo/W0;", "source", "Landroidx/lifecycle/wA$mjFkc;", "event", BuildConfig.f24315FLAVOR, "VA", "(Lo/W0;Landroidx/lifecycle/wA$mjFkc;)V", BuildConfig.f24315FLAVOR, "className", "mjFkc", "(Ljava/lang/String;)V", "Lo/n6;", "AZxh", "savedstate_release"}, m4989k = 1, m4990mv = {1, 8, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class Recreator implements InterfaceC0104KLFTb {

    /* renamed from: mjFkc, reason: from kotlin metadata */
    public final InterfaceC4193n6 owner;

    /* renamed from: androidx.savedstate.Recreator$AZxh */
    public static final class C0182AZxh implements C0184mjFkc.wA {

        /* renamed from: mjFkc */
        public final Set f1943mjFkc;

        public C0182AZxh(C0184mjFkc registry) {
            Intrinsics.checkNotNullParameter(registry, "registry");
            this.f1943mjFkc = new LinkedHashSet();
            registry.m2098xJ("androidx.savedstate.Restarter", this);
        }

        /* renamed from: AZxh */
        public final void m2089AZxh(String className) {
            Intrinsics.checkNotNullParameter(className, "className");
            this.f1943mjFkc.add(className);
        }

        @Override // androidx.savedstate.C0184mjFkc.wA
        /* renamed from: mjFkc */
        public Bundle mo2090mjFkc() {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("classes_to_restore", new ArrayList<>(this.f1943mjFkc));
            return bundle;
        }
    }

    public Recreator(InterfaceC4193n6 owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
    }

    @Override // androidx.lifecycle.InterfaceC0104KLFTb
    /* renamed from: VA */
    public void mo4VA(InterfaceC3068W0 source, AbstractC0112wA.mjFkc event) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event != AbstractC0112wA.mjFkc.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        source.mo770JHa().mo1046wA(this);
        Bundle bundleM2093AZxh = this.owner.mo825mjFkc().m2093AZxh("androidx.savedstate.Restarter");
        if (bundleM2093AZxh == null) {
            return;
        }
        ArrayList<String> stringArrayList = bundleM2093AZxh.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            m2088mjFkc(it.next());
        }
    }

    /* renamed from: mjFkc */
    public final void m2088mjFkc(String className) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            Class<? extends U> clsAsSubclass = Class.forName(className, false, Recreator.class.getClassLoader()).asSubclass(C0184mjFkc.mjFkc.class);
            Intrinsics.checkNotNullExpressionValue(clsAsSubclass, "{\n                Class.…class.java)\n            }");
            try {
                Constructor declaredConstructor = clsAsSubclass.getDeclaredConstructor(null);
                declaredConstructor.setAccessible(true);
                try {
                    Object objNewInstance = declaredConstructor.newInstance(null);
                    Intrinsics.checkNotNullExpressionValue(objNewInstance, "{\n                constr…wInstance()\n            }");
                    ((C0184mjFkc.mjFkc) objNewInstance).mo1053mjFkc(this.owner);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate " + className, e);
                }
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException("Class " + clsAsSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e2);
            }
        } catch (ClassNotFoundException e3) {
            throw new RuntimeException("Class " + className + " wasn't found", e3);
        }
    }
}
