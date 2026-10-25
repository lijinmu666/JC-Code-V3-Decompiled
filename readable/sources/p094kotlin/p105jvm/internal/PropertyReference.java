package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KProperty;

/* loaded from: classes.dex */
public abstract class PropertyReference extends CallableReference implements KProperty {
    private final boolean syntheticJavaProperty;

    public PropertyReference() {
        this.syntheticJavaProperty = false;
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    /* renamed from: compute */
    public KCallable mo6291compute() {
        return this.syntheticJavaProperty ? this : super.mo6291compute();
    }

    /* renamed from: equals */
    public boolean m6333equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return getOwner().equals(propertyReference.getOwner()) && mo6292getName().equals(propertyReference.mo6292getName()) && getSignature().equals(propertyReference.getSignature()) && Intrinsics.areEqual(getBoundReceiver(), propertyReference.getBoundReceiver());
        }
        if (obj instanceof KProperty) {
            return obj.equals(mo6291compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + mo6292getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // p094kotlin.p113reflect.KProperty
    @SinceKotlin(m5061version = "1.1")
    /* renamed from: isConst */
    public boolean mo6334isConst() {
        return getReflected().mo6334isConst();
    }

    @Override // p094kotlin.p113reflect.KProperty
    @SinceKotlin(m5061version = "1.1")
    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        KCallable kCallableMo6291compute = mo6291compute();
        if (kCallableMo6291compute != this) {
            return kCallableMo6291compute.toString();
        }
        return "property " + mo6292getName() + " (Kotlin reflection is not available)";
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    @SinceKotlin(m5061version = "1.1")
    public KProperty getReflected() {
        if (this.syntheticJavaProperty) {
            throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
        }
        return (KProperty) super.getReflected();
    }

    @SinceKotlin(m5061version = "1.1")
    public PropertyReference(Object obj) {
        super(obj);
        this.syntheticJavaProperty = false;
    }

    @SinceKotlin(m5061version = "1.4")
    public PropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.syntheticJavaProperty = (i & 2) == 2;
    }
}
