package p094kotlin.p105jvm.internal;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.util.List;
import java.util.Map;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.KotlinReflectionNotSupportedError;
import p094kotlin.p113reflect.InterfaceC1252KType;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KDeclarationContainer;
import p094kotlin.p113reflect.KParameter;
import p094kotlin.p113reflect.KTypeParameter;
import p094kotlin.p113reflect.KVisibility;

/* loaded from: classes.dex */
public abstract class CallableReference implements KCallable, Serializable, KotlinGenericDeclaration {

    @SinceKotlin(m5061version = "1.1")
    public static final Object NO_RECEIVER = NoReceiver.INSTANCE;

    @SinceKotlin(m5061version = "1.4")
    private final boolean isTopLevel;

    /* renamed from: name */
    @SinceKotlin(m5061version = "1.4")
    private final String f5179name;

    /* renamed from: owner */
    @SinceKotlin(m5061version = "1.4")
    private final Class f5180owner;

    @SinceKotlin(m5061version = "1.1")
    protected final Object receiver;
    private transient KCallable reflected;

    @SinceKotlin(m5061version = "1.4")
    private final String signature;

    @SinceKotlin(m5061version = "1.2")
    public static class NoReceiver implements Serializable {
        private static final NoReceiver INSTANCE = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // p094kotlin.p113reflect.KCallable
    /* renamed from: call */
    public Object mo6289call(Object... objArr) {
        return getReflected().mo6289call(objArr);
    }

    @Override // p094kotlin.p113reflect.KCallable
    /* renamed from: callBy */
    public Object mo6290callBy(Map map) {
        return getReflected().mo6290callBy(map);
    }

    @SinceKotlin(m5061version = "1.1")
    /* renamed from: compute */
    public KCallable mo6291compute() {
        KCallable kCallable = this.reflected;
        if (kCallable != null) {
            return kCallable;
        }
        KCallable kCallableComputeReflected = computeReflected();
        this.reflected = kCallableComputeReflected;
        return kCallableComputeReflected;
    }

    public abstract KCallable computeReflected();

    @Override // p094kotlin.p105jvm.internal.KotlinGenericDeclaration
    public GenericDeclaration findJavaDeclaration() {
        return KotlinGenericDeclarationKt.findMethodBySignature(getOwner(), getSignature());
    }

    @Override // p094kotlin.p113reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @SinceKotlin(m5061version = "1.1")
    public Object getBoundReceiver() {
        return this.receiver;
    }

    @Override // p094kotlin.p113reflect.KCallable
    /* renamed from: getName */
    public String mo6292getName() {
        return this.f5179name;
    }

    public KDeclarationContainer getOwner() {
        Class cls = this.f5180owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? Reflection.getOrCreateKotlinPackage(cls) : Reflection.getOrCreateKotlinClass(cls);
    }

    @Override // p094kotlin.p113reflect.KCallable
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @SinceKotlin(m5061version = "1.1")
    public KCallable getReflected() {
        KCallable kCallableMo6291compute = mo6291compute();
        if (kCallableMo6291compute != this) {
            return kCallableMo6291compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // p094kotlin.p113reflect.KCallable
    public InterfaceC1252KType getReturnType() {
        return getReflected().getReturnType();
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // p094kotlin.p113reflect.KCallable
    @SinceKotlin(m5061version = "1.1")
    public List<KTypeParameter> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // p094kotlin.p113reflect.KCallable
    @SinceKotlin(m5061version = "1.1")
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // p094kotlin.p113reflect.KCallable
    @SinceKotlin(m5061version = "1.1")
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // p094kotlin.p113reflect.KCallable
    @SinceKotlin(m5061version = "1.1")
    /* renamed from: isFinal */
    public boolean mo6293isFinal() {
        return getReflected().mo6293isFinal();
    }

    @Override // p094kotlin.p113reflect.KCallable
    @SinceKotlin(m5061version = "1.1")
    /* renamed from: isOpen */
    public boolean mo6294isOpen() {
        return getReflected().mo6294isOpen();
    }

    @Override // p094kotlin.p113reflect.KCallable
    @SinceKotlin(m5061version = "1.3")
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    @SinceKotlin(m5061version = "1.1")
    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    @SinceKotlin(m5061version = "1.4")
    public CallableReference(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.f5180owner = cls;
        this.f5179name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }
}
