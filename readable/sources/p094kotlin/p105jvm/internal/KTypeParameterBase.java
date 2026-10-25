package p094kotlin.p105jvm.internal;

import java.lang.reflect.GenericDeclaration;
import org.conscrypt.BuildConfig;
import p094kotlin.C1120LazyKt;
import p094kotlin.InterfaceC1119Lazy;
import p094kotlin.LazyThreadSafetyMode;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.KTypeParameterBase;
import p094kotlin.p113reflect.KTypeParameter;

@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\bF\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0096\u0082\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004R\u0019\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8@X\u0080\u0084\n¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m4988d2 = {"Lkotlin/jvm/internal/KTypeParameterBase;", "Lkotlin/reflect/KTypeParameter;", "container", BuildConfig.f24315FLAVOR, "Lkotlin/jvm/internal/TypeParameterContainer;", "<init>", "(Ljava/lang/Object;)V", "getContainer$kotlin_stdlib", "()Ljava/lang/Object;", "javaContainingDeclaration", "Ljava/lang/reflect/GenericDeclaration;", "getJavaContainingDeclaration$kotlin_stdlib", "()Ljava/lang/reflect/GenericDeclaration;", "javaContainingDeclaration$delegate", "Lkotlin/Lazy;", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public abstract class KTypeParameterBase implements KTypeParameter {
    private final Object container;

    /* renamed from: javaContainingDeclaration$delegate, reason: from kotlin metadata */
    private final InterfaceC1119Lazy javaContainingDeclaration;

    public KTypeParameterBase(Object container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
        this.javaContainingDeclaration = C1120LazyKt.m4980lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: o.B0
            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final Object mo4323invoke() {
                return KTypeParameterBase.javaContainingDeclaration_delegate$lambda$0(this.f7421mjFkc);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GenericDeclaration javaContainingDeclaration_delegate$lambda$0(KTypeParameterBase kTypeParameterBase) {
        Object obj = kTypeParameterBase.container;
        KotlinGenericDeclaration kotlinGenericDeclaration = obj instanceof KotlinGenericDeclaration ? (KotlinGenericDeclaration) obj : null;
        if (kotlinGenericDeclaration != null) {
            return kotlinGenericDeclaration.findJavaDeclaration();
        }
        return null;
    }

    /* renamed from: equals */
    public boolean m6322equals(Object other) {
        if (other instanceof KTypeParameterBase) {
            KTypeParameterBase kTypeParameterBase = (KTypeParameterBase) other;
            if (Intrinsics.areEqual(getName(), kTypeParameterBase.getName()) && Intrinsics.areEqual(this.container, kTypeParameterBase.container)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: getContainer$kotlin_stdlib, reason: from getter */
    public final Object getContainer() {
        return this.container;
    }

    public final GenericDeclaration getJavaContainingDeclaration$kotlin_stdlib() {
        return (GenericDeclaration) this.javaContainingDeclaration.getValue();
    }

    public int hashCode() {
        return (this.container.hashCode() * 31) + getName().hashCode();
    }

    public String toString() {
        return TypeParameterReference.INSTANCE.toString(this);
    }
}
