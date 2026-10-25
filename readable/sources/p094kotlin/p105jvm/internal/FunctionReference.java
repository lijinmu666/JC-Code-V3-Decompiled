package p094kotlin.p105jvm.internal;

import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KFunction;

/* loaded from: classes.dex */
public class FunctionReference extends CallableReference implements FunctionBase, KFunction {

    /* renamed from: arity */
    private final int f5188arity;

    public FunctionReference(int i) {
        this(i, CallableReference.NO_RECEIVER, null, null, null, 0);
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    @SinceKotlin(m5061version = "1.1")
    public KCallable computeReflected() {
        return Reflection.function(this);
    }

    /* renamed from: equals */
    public boolean mo6313equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return mo6292getName().equals(functionReference.mo6292getName()) && getSignature().equals(functionReference.getSignature()) && Intrinsics.areEqual(getBoundReceiver(), functionReference.getBoundReceiver()) && Intrinsics.areEqual(getOwner(), functionReference.getOwner());
        }
        if (obj instanceof KFunction) {
            return obj.equals(mo6291compute());
        }
        return false;
    }

    @Override // p094kotlin.p105jvm.internal.FunctionBase
    public int getArity() {
        return this.f5188arity;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + mo6292getName().hashCode()) * 31) + getSignature().hashCode();
    }

    @Override // p094kotlin.p113reflect.KFunction
    @SinceKotlin(m5061version = "1.1")
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override // p094kotlin.p113reflect.KFunction
    @SinceKotlin(m5061version = "1.1")
    /* renamed from: isInfix */
    public boolean mo6314isInfix() {
        return getReflected().mo6314isInfix();
    }

    @Override // p094kotlin.p113reflect.KFunction
    @SinceKotlin(m5061version = "1.1")
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override // p094kotlin.p113reflect.KFunction
    @SinceKotlin(m5061version = "1.1")
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference, p094kotlin.p113reflect.KCallable
    @SinceKotlin(m5061version = "1.1")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public String toString() {
        KCallable kCallableMo6291compute = mo6291compute();
        if (kCallableMo6291compute != this) {
            return kCallableMo6291compute.toString();
        }
        if ("<init>".equals(mo6292getName())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + mo6292getName() + " (Kotlin reflection is not available)";
    }

    @SinceKotlin(m5061version = "1.1")
    public FunctionReference(int i, Object obj) {
        this(i, obj, null, null, null, 0);
    }

    @Override // p094kotlin.p105jvm.internal.CallableReference
    @SinceKotlin(m5061version = "1.1")
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    @SinceKotlin(m5061version = "1.4")
    public FunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.f5188arity = i;
    }
}
