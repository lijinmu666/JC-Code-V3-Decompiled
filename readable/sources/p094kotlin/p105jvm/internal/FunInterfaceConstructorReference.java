package p094kotlin.p105jvm.internal;

import java.io.Serializable;
import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KFunction;

@SinceKotlin(m5061version = "1.7")
/* loaded from: classes.dex */
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class funInterface;

    public FunInterfaceConstructorReference(Class cls) {
        super(1);
        this.funInterface = cls;
    }

    @Override // p094kotlin.p105jvm.internal.FunctionReference
    /* renamed from: equals */
    public boolean mo6313equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FunInterfaceConstructorReference) {
            return this.funInterface.equals(((FunInterfaceConstructorReference) obj).funInterface);
        }
        return false;
    }

    @Override // p094kotlin.p105jvm.internal.FunctionReference
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    @Override // p094kotlin.p105jvm.internal.FunctionReference
    public String toString() {
        return "fun interface " + this.funInterface.getName();
    }

    @Override // p094kotlin.p105jvm.internal.FunctionReference, p094kotlin.p105jvm.internal.CallableReference
    public KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }
}
