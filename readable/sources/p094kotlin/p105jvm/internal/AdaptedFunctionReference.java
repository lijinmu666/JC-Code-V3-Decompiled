package p094kotlin.p105jvm.internal;

import java.io.Serializable;
import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.KDeclarationContainer;

@SinceKotlin(m5061version = "1.4")
/* loaded from: classes.dex */
public class AdaptedFunctionReference implements FunctionBase, Serializable {

    /* renamed from: arity */
    private final int f5155arity;

    /* renamed from: flags */
    private final int f5156flags;
    private final boolean isTopLevel;

    /* renamed from: name */
    private final String f5157name;

    /* renamed from: owner */
    private final Class f5158owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int i, Class cls, String str, String str2, int i2) {
        this(i, CallableReference.NO_RECEIVER, cls, str, str2, i2);
    }

    /* renamed from: equals */
    public boolean m6283equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference adaptedFunctionReference = (AdaptedFunctionReference) obj;
        return this.isTopLevel == adaptedFunctionReference.isTopLevel && this.f5155arity == adaptedFunctionReference.f5155arity && this.f5156flags == adaptedFunctionReference.f5156flags && Intrinsics.areEqual(this.receiver, adaptedFunctionReference.receiver) && Intrinsics.areEqual(this.f5158owner, adaptedFunctionReference.f5158owner) && this.f5157name.equals(adaptedFunctionReference.f5157name) && this.signature.equals(adaptedFunctionReference.signature);
    }

    @Override // p094kotlin.p105jvm.internal.FunctionBase
    public int getArity() {
        return this.f5155arity;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.f5158owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? Reflection.getOrCreateKotlinPackage(cls) : Reflection.getOrCreateKotlinClass(cls);
    }

    public int hashCode() {
        Object obj = this.receiver;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Class cls = this.f5158owner;
        return ((((((((((iHashCode + (cls != null ? cls.hashCode() : 0)) * 31) + this.f5157name.hashCode()) * 31) + this.signature.hashCode()) * 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.f5155arity) * 31) + this.f5156flags;
    }

    public String toString() {
        return Reflection.renderLambdaToString(this);
    }

    public AdaptedFunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        this.receiver = obj;
        this.f5158owner = cls;
        this.f5157name = str;
        this.signature = str2;
        this.isTopLevel = (i2 & 1) == 1;
        this.f5155arity = i;
        this.f5156flags = i2 >> 1;
    }
}
