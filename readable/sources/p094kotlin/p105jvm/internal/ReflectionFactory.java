package p094kotlin.p105jvm.internal;

import java.util.List;
import p094kotlin.SinceKotlin;
import p094kotlin.p113reflect.InterfaceC1242KClass;
import p094kotlin.p113reflect.InterfaceC1252KType;
import p094kotlin.p113reflect.KClassifier;
import p094kotlin.p113reflect.KDeclarationContainer;
import p094kotlin.p113reflect.KFunction;
import p094kotlin.p113reflect.KMutableProperty0;
import p094kotlin.p113reflect.KMutableProperty1;
import p094kotlin.p113reflect.KMutableProperty2;
import p094kotlin.p113reflect.KProperty0;
import p094kotlin.p113reflect.KProperty1;
import p094kotlin.p113reflect.KProperty2;
import p094kotlin.p113reflect.KTypeParameter;
import p094kotlin.p113reflect.KTypeProjection;
import p094kotlin.p113reflect.KVariance;

/* loaded from: classes.dex */
public class ReflectionFactory {
    private static final String KOTLIN_JVM_FUNCTIONS = "kotlin.jvm.functions.";

    public InterfaceC1242KClass createKotlinClass(Class cls) {
        return new ClassReference(cls);
    }

    public KFunction function(FunctionReference functionReference) {
        return functionReference;
    }

    public InterfaceC1242KClass getOrCreateKotlinClass(Class cls) {
        return new ClassReference(cls);
    }

    public KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return new PackageReference(cls, str);
    }

    @SinceKotlin(m5061version = "1.6")
    public InterfaceC1252KType mutableCollectionType(InterfaceC1252KType interfaceC1252KType) {
        TypeReference typeReference = (TypeReference) interfaceC1252KType;
        return new TypeReference(interfaceC1252KType.getClassifier(), interfaceC1252KType.getArguments(), typeReference.getPlatformTypeUpperBound(), typeReference.getFlags() | 2);
    }

    public KMutableProperty0 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return mutablePropertyReference0;
    }

    public KMutableProperty1 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return mutablePropertyReference1;
    }

    public KMutableProperty2 mutableProperty2(MutablePropertyReference2 mutablePropertyReference2) {
        return mutablePropertyReference2;
    }

    @SinceKotlin(m5061version = "1.6")
    public InterfaceC1252KType nothingType(InterfaceC1252KType interfaceC1252KType) {
        TypeReference typeReference = (TypeReference) interfaceC1252KType;
        return new TypeReference(interfaceC1252KType.getClassifier(), interfaceC1252KType.getArguments(), typeReference.getPlatformTypeUpperBound(), typeReference.getFlags() | 4);
    }

    @SinceKotlin(m5061version = "1.6")
    public InterfaceC1252KType platformType(InterfaceC1252KType interfaceC1252KType, InterfaceC1252KType interfaceC1252KType2) {
        return new TypeReference(interfaceC1252KType.getClassifier(), interfaceC1252KType.getArguments(), interfaceC1252KType2, ((TypeReference) interfaceC1252KType).getFlags());
    }

    public KProperty0 property0(PropertyReference0 propertyReference0) {
        return propertyReference0;
    }

    public KProperty1 property1(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public KProperty2 property2(PropertyReference2 propertyReference2) {
        return propertyReference2;
    }

    @SinceKotlin(m5061version = "1.1")
    public String renderLambdaToString(AbstractC1234Lambda abstractC1234Lambda) {
        return renderLambdaToString((FunctionBase) abstractC1234Lambda);
    }

    @SinceKotlin(m5061version = "1.4")
    public void setUpperBounds(KTypeParameter kTypeParameter, List<InterfaceC1252KType> list) {
        ((TypeParameterReference) kTypeParameter).setUpperBounds(list);
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: typeOf */
    public InterfaceC1252KType m6340typeOf(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        return new TypeReference(kClassifier, list, z);
    }

    @SinceKotlin(m5061version = "1.4")
    public KTypeParameter typeParameter(Object obj, String str, KVariance kVariance, boolean z) {
        return new TypeParameterReference(obj, str, kVariance, z);
    }

    public InterfaceC1242KClass createKotlinClass(Class cls, String str) {
        return new ClassReference(cls);
    }

    public InterfaceC1242KClass getOrCreateKotlinClass(Class cls, String str) {
        return new ClassReference(cls);
    }

    @SinceKotlin(m5061version = "1.3")
    public String renderLambdaToString(FunctionBase functionBase) {
        String string = functionBase.getClass().getGenericInterfaces()[0].toString();
        return string.startsWith(KOTLIN_JVM_FUNCTIONS) ? string.substring(21) : string;
    }
}
