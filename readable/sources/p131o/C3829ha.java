package p131o;

import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p131o.AbstractC1991FrS;

/* renamed from: o.ha */
/* loaded from: classes.dex */
public class C3829ha {

    /* renamed from: AZxh */
    public final mjFkc f14027AZxh;

    /* renamed from: mjFkc */
    public final C3893ia f14028mjFkc;

    /* renamed from: wA */
    public final AbstractC1991FrS f14029wA;

    /* renamed from: o.ha$AZxh */
    public static class AZxh implements mjFkc {

        /* renamed from: AZxh */
        public static final mjFkc f14030AZxh = new mjFkc(null);

        /* renamed from: wA */
        public static final AbstractC1991FrS.AZxh f14031wA = mjFkc.C6365mjFkc.f14032mjFkc;

        /* renamed from: o.ha$AZxh$mjFkc */
        public static final class mjFkc {

            /* renamed from: o.ha$AZxh$mjFkc$mjFkc, reason: collision with other inner class name */
            public static final class C6365mjFkc implements AbstractC1991FrS.AZxh {

                /* renamed from: mjFkc */
                public static final C6365mjFkc f14032mjFkc = new C6365mjFkc();
            }

            public /* synthetic */ mjFkc(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public mjFkc() {
            }
        }
    }

    /* renamed from: o.ha$mjFkc */
    public interface mjFkc {

        /* renamed from: mjFkc */
        public static final C6366mjFkc f14033mjFkc = C6366mjFkc.f14034mjFkc;

        /* renamed from: o.ha$mjFkc$mjFkc, reason: collision with other inner class name */
        public static final class C6366mjFkc {

            /* renamed from: mjFkc */
            public static final /* synthetic */ C6366mjFkc f14034mjFkc = new C6366mjFkc();
        }

        /* renamed from: AZxh */
        default AbstractC3764ga m12228AZxh(Class modelClass, AbstractC1991FrS extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return mo11588mjFkc(modelClass);
        }

        /* renamed from: mjFkc */
        AbstractC3764ga mo11588mjFkc(Class cls);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C3829ha(C3893ia store, mjFkc factory) {
        this(store, factory, null, 4, null);
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    /* renamed from: AZxh */
    public AbstractC3764ga m12226AZxh(String key, Class modelClass) {
        AbstractC3764ga abstractC3764gaMo11588mjFkc;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        AbstractC3764ga abstractC3764gaM12301mjFkc = this.f14028mjFkc.m12301mjFkc(key);
        if (modelClass.isInstance(abstractC3764gaM12301mjFkc)) {
            Intrinsics.checkNotNull(abstractC3764gaM12301mjFkc, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return abstractC3764gaM12301mjFkc;
        }
        C4987z2 c4987z2 = new C4987z2(this.f14029wA);
        c4987z2.m14085AZxh(AZxh.f14031wA, key);
        try {
            abstractC3764gaMo11588mjFkc = this.f14027AZxh.m12228AZxh(modelClass, c4987z2);
        } catch (AbstractMethodError unused) {
            abstractC3764gaMo11588mjFkc = this.f14027AZxh.mo11588mjFkc(modelClass);
        }
        this.f14028mjFkc.m12302wA(key, abstractC3764gaMo11588mjFkc);
        return abstractC3764gaMo11588mjFkc;
    }

    /* renamed from: mjFkc */
    public AbstractC3764ga m12227mjFkc(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return m12226AZxh("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    public C3829ha(C3893ia store, mjFkc factory, AbstractC1991FrS defaultCreationExtras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        this.f14028mjFkc = store;
        this.f14027AZxh = factory;
        this.f14029wA = defaultCreationExtras;
    }

    public /* synthetic */ C3829ha(C3893ia c3893ia, mjFkc mjfkc, AbstractC1991FrS abstractC1991FrS, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c3893ia, mjfkc, (i & 4) != 0 ? AbstractC1991FrS.mjFkc.f8267AZxh : abstractC1991FrS);
    }
}
