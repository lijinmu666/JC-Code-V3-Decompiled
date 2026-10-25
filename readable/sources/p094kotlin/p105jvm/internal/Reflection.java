package p094kotlin.p105jvm.internal;

import java.util.Arrays;
import java.util.Collections;
import org.conscrypt.BuildConfig;
import p094kotlin.SinceKotlin;
import p094kotlin.collections.ArraysKt;
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
public class Reflection {
    private static final InterfaceC1242KClass[] EMPTY_K_CLASS_ARRAY;
    static final String REFLECTION_NOT_AVAILABLE = " (Kotlin reflection is not available)";

    /* renamed from: factory */
    private static final ReflectionFactory f5204factory;

    static {
        ReflectionFactory reflectionFactory = null;
        try {
            reflectionFactory = (ReflectionFactory) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (reflectionFactory == null) {
            reflectionFactory = new ReflectionFactory();
        }
        f5204factory = reflectionFactory;
        EMPTY_K_CLASS_ARRAY = new InterfaceC1242KClass[0];
    }

    public static InterfaceC1242KClass createKotlinClass(Class cls) {
        return f5204factory.createKotlinClass(cls);
    }

    public static KFunction function(FunctionReference functionReference) {
        return f5204factory.function(functionReference);
    }

    public static InterfaceC1242KClass getOrCreateKotlinClass(Class cls) {
        return f5204factory.getOrCreateKotlinClass(cls);
    }

    public static InterfaceC1242KClass[] getOrCreateKotlinClasses(Class[] clsArr) {
        int length = clsArr.length;
        if (length == 0) {
            return EMPTY_K_CLASS_ARRAY;
        }
        InterfaceC1242KClass[] interfaceC1242KClassArr = new InterfaceC1242KClass[length];
        for (int i = 0; i < length; i++) {
            interfaceC1242KClassArr[i] = getOrCreateKotlinClass(clsArr[i]);
        }
        return interfaceC1242KClassArr;
    }

    @SinceKotlin(m5061version = "1.4")
    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls) {
        return f5204factory.getOrCreateKotlinPackage(cls, BuildConfig.f24315FLAVOR);
    }

    @SinceKotlin(m5061version = "1.6")
    public static InterfaceC1252KType mutableCollectionType(InterfaceC1252KType interfaceC1252KType) {
        return f5204factory.mutableCollectionType(interfaceC1252KType);
    }

    public static KMutableProperty0 mutableProperty0(MutablePropertyReference0 mutablePropertyReference0) {
        return f5204factory.mutableProperty0(mutablePropertyReference0);
    }

    public static KMutableProperty1 mutableProperty1(MutablePropertyReference1 mutablePropertyReference1) {
        return f5204factory.mutableProperty1(mutablePropertyReference1);
    }

    public static KMutableProperty2 mutableProperty2(MutablePropertyReference2 mutablePropertyReference2) {
        return f5204factory.mutableProperty2(mutablePropertyReference2);
    }

    @SinceKotlin(m5061version = "1.6")
    public static InterfaceC1252KType nothingType(InterfaceC1252KType interfaceC1252KType) {
        return f5204factory.nothingType(interfaceC1252KType);
    }

    @SinceKotlin(m5061version = "1.4")
    public static InterfaceC1252KType nullableTypeOf(KClassifier kClassifier) {
        return f5204factory.m6340typeOf(kClassifier, Collections.emptyList(), true);
    }

    @SinceKotlin(m5061version = "1.6")
    public static InterfaceC1252KType platformType(InterfaceC1252KType interfaceC1252KType, InterfaceC1252KType interfaceC1252KType2) {
        return f5204factory.platformType(interfaceC1252KType, interfaceC1252KType2);
    }

    public static KProperty0 property0(PropertyReference0 propertyReference0) {
        return f5204factory.property0(propertyReference0);
    }

    public static KProperty1 property1(PropertyReference1 propertyReference1) {
        return f5204factory.property1(propertyReference1);
    }

    public static KProperty2 property2(PropertyReference2 propertyReference2) {
        return f5204factory.property2(propertyReference2);
    }

    @SinceKotlin(m5061version = "1.1")
    public static String renderLambdaToString(AbstractC1234Lambda abstractC1234Lambda) {
        return f5204factory.renderLambdaToString(abstractC1234Lambda);
    }

    @SinceKotlin(m5061version = "1.4")
    public static void setUpperBounds(KTypeParameter kTypeParameter, InterfaceC1252KType interfaceC1252KType) {
        f5204factory.setUpperBounds(kTypeParameter, Collections.singletonList(interfaceC1252KType));
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: typeOf */
    public static InterfaceC1252KType m6339typeOf(KClassifier kClassifier) {
        return f5204factory.m6340typeOf(kClassifier, Collections.emptyList(), false);
    }

    @SinceKotlin(m5061version = "1.4")
    public static KTypeParameter typeParameter(Object obj, String str, KVariance kVariance, boolean z) {
        return f5204factory.typeParameter(obj, str, kVariance, z);
    }

    public static InterfaceC1242KClass createKotlinClass(Class cls, String str) {
        return f5204factory.createKotlinClass(cls, str);
    }

    public static InterfaceC1242KClass getOrCreateKotlinClass(Class cls, String str) {
        return f5204factory.getOrCreateKotlinClass(cls, str);
    }

    public static KDeclarationContainer getOrCreateKotlinPackage(Class cls, String str) {
        return f5204factory.getOrCreateKotlinPackage(cls, str);
    }

    @SinceKotlin(m5061version = "1.4")
    public static InterfaceC1252KType nullableTypeOf(Class cls) {
        return f5204factory.m6340typeOf(getOrCreateKotlinClass(cls), Collections.emptyList(), true);
    }

    @SinceKotlin(m5061version = "1.3")
    public static String renderLambdaToString(FunctionBase functionBase) {
        return f5204factory.renderLambdaToString(functionBase);
    }

    @SinceKotlin(m5061version = "1.4")
    public static void setUpperBounds(KTypeParameter kTypeParameter, InterfaceC1252KType... interfaceC1252KTypeArr) {
        f5204factory.setUpperBounds(kTypeParameter, ArraysKt.m5723toList(interfaceC1252KTypeArr));
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: typeOf */
    public static InterfaceC1252KType m6335typeOf(Class cls) {
        return f5204factory.m6340typeOf(getOrCreateKotlinClass(cls), Collections.emptyList(), false);
    }

    @SinceKotlin(m5061version = "1.4")
    public static InterfaceC1252KType nullableTypeOf(Class cls, KTypeProjection kTypeProjection) {
        return f5204factory.m6340typeOf(getOrCreateKotlinClass(cls), Collections.singletonList(kTypeProjection), true);
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: typeOf */
    public static InterfaceC1252KType m6336typeOf(Class cls, KTypeProjection kTypeProjection) {
        return f5204factory.m6340typeOf(getOrCreateKotlinClass(cls), Collections.singletonList(kTypeProjection), false);
    }

    @SinceKotlin(m5061version = "1.4")
    public static InterfaceC1252KType nullableTypeOf(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f5204factory.m6340typeOf(getOrCreateKotlinClass(cls), Arrays.asList(kTypeProjection, kTypeProjection2), true);
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: typeOf */
    public static InterfaceC1252KType m6337typeOf(Class cls, KTypeProjection kTypeProjection, KTypeProjection kTypeProjection2) {
        return f5204factory.m6340typeOf(getOrCreateKotlinClass(cls), Arrays.asList(kTypeProjection, kTypeProjection2), false);
    }

    @SinceKotlin(m5061version = "1.4")
    public static InterfaceC1252KType nullableTypeOf(Class cls, KTypeProjection... kTypeProjectionArr) {
        return f5204factory.m6340typeOf(getOrCreateKotlinClass(cls), ArraysKt.m5723toList(kTypeProjectionArr), true);
    }

    @SinceKotlin(m5061version = "1.4")
    /* renamed from: typeOf */
    public static InterfaceC1252KType m6338typeOf(Class cls, KTypeProjection... kTypeProjectionArr) {
        return f5204factory.m6340typeOf(getOrCreateKotlinClass(cls), ArraysKt.m5723toList(kTypeProjectionArr), false);
    }
}
