package p094kotlin.p105jvm;

import java.lang.annotation.Annotation;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.ClassBasedDeclarationContainer;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.Reflection;
import p094kotlin.p113reflect.InterfaceC1242KClass;

@Metadata(m4987d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010!\u001a\u00020\"\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u000b*\u0006\u0012\u0002\b\u00030#H\u0086\u0080\u0004¢\u0006\u0002\u0010$\"?\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038GX\u0086\u0084\bz\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0006¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"1\u0010\n\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007\"/\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007\"=\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00020\u00018GX\u0086\u0084\bz\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\"*\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000b*\u0002H\u00028Æ\u0002X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0013\"\u0082\u0001\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u000b*\b\u0012\u0004\u0012\u0002H\u00020\u00038Ç\u0002X\u0087\u0084\br6\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u001c\b\u0019\u0012\u0018\b\u000bB\u0014\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0006\b\u001d\u0012\u0002\b\f\u0012\n\b\u001e\u0012\u0006\b\n0\u001f8 z\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015¢\u0006\f\u0012\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"+\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020&*\u0002H\u00028FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b'\u0010(\"N\u0010)\u001a\b\u0012\u0004\u0012\u0002H*0\u0001\"\u000e\b\u0000\u0010**\b\u0012\u0004\u0012\u0002H*0+*\b\u0012\u0004\u0012\u0002H*0+8Æ\u0002X\u0087\u0084\br\f\b0\u0012\b\b1\u0012\u0004\b\b(2r\u0002\b3¢\u0006\f\u0012\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00064"}, m4988d2 = {"java", "Ljava/lang/Class;", "T", "Lkotlin/reflect/KClass;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "Lkotlin/jvm/JvmName;", "name", "javaPrimitiveType", BuildConfig.f24315FLAVOR, "getJavaPrimitiveType", "javaObjectType", "getJavaObjectType", "kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "javaClass", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "Lkotlin/Deprecated;", "message", "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", "replaceWith", "Lkotlin/ReplaceWith;", "expression", "(this as Any).javaClass", "imports", "level", "Lkotlin/DeprecationLevel;", "ERROR", "isArrayOf", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "([Ljava/lang/Object;)Z", "annotationClass", BuildConfig.f24315FLAVOR, "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "E", BuildConfig.f24315FLAVOR, "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "Lkotlin/SinceKotlin;", "version", "1.7", "Lkotlin/internal/InlineOnly;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "JvmClassMappingKt")
/* loaded from: classes.dex */
public final class JvmClassMappingKt {
    public static final <T extends Annotation> InterfaceC1242KClass<? extends T> getAnnotationClass(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Class<? extends Annotation> clsAnnotationType = t.annotationType();
        Intrinsics.checkNotNullExpressionValue(clsAnnotationType, "annotationType(...)");
        InterfaceC1242KClass<? extends T> kotlinClass = getKotlinClass(clsAnnotationType);
        Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return kotlinClass;
    }

    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(Enum<E> r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Class<E> declaringClass = r1.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        return declaringClass;
    }

    @SinceKotlin(m5061version = "1.7")
    @InlineOnly
    public static /* synthetic */ void getDeclaringJavaClass$annotations(Enum r0) {
    }

    @InterfaceC1231JvmName(m6260name = "getJavaClass")
    public static final <T> Class<T> getJavaClass(InterfaceC1242KClass<T> interfaceC1242KClass) {
        Intrinsics.checkNotNullParameter(interfaceC1242KClass, "<this>");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) interfaceC1242KClass).getJClass();
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    public static /* synthetic */ void getJavaClass$annotations(InterfaceC1242KClass interfaceC1242KClass) {
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public static final <T> Class<T> getJavaObjectType(InterfaceC1242KClass<T> interfaceC1242KClass) {
        Intrinsics.checkNotNullParameter(interfaceC1242KClass, "<this>");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) interfaceC1242KClass).getJClass();
        if (!cls.isPrimitive()) {
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (name.equals("double")) {
                    cls = (Class<T>) Double.class;
                    break;
                }
                break;
            case 104431:
                if (name.equals("int")) {
                    cls = (Class<T>) Integer.class;
                    break;
                }
                break;
            case 3039496:
                if (name.equals("byte")) {
                    cls = (Class<T>) Byte.class;
                    break;
                }
                break;
            case 3052374:
                if (name.equals("char")) {
                    cls = (Class<T>) Character.class;
                    break;
                }
                break;
            case 3327612:
                if (name.equals("long")) {
                    cls = (Class<T>) Long.class;
                    break;
                }
                break;
            case 3625364:
                if (name.equals("void")) {
                    cls = (Class<T>) Void.class;
                    break;
                }
                break;
            case 64711720:
                if (name.equals("boolean")) {
                    cls = (Class<T>) Boolean.class;
                    break;
                }
                break;
            case 97526364:
                if (name.equals("float")) {
                    cls = (Class<T>) Float.class;
                    break;
                }
                break;
            case 109413500:
                if (name.equals("short")) {
                    cls = (Class<T>) Short.class;
                    break;
                }
                break;
        }
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final <T> Class<T> getJavaPrimitiveType(InterfaceC1242KClass<T> interfaceC1242KClass) {
        Intrinsics.checkNotNullParameter(interfaceC1242KClass, "<this>");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) interfaceC1242KClass).getJClass();
        if (cls.isPrimitive()) {
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -2056817302:
                if (name.equals("java.lang.Integer")) {
                    return Integer.TYPE;
                }
                return null;
            case -527879800:
                if (name.equals("java.lang.Float")) {
                    return Float.TYPE;
                }
                return null;
            case -515992664:
                if (name.equals("java.lang.Short")) {
                    return Short.TYPE;
                }
                return null;
            case 155276373:
                if (name.equals("java.lang.Character")) {
                    return Character.TYPE;
                }
                return null;
            case 344809556:
                if (name.equals("java.lang.Boolean")) {
                    return Boolean.TYPE;
                }
                return null;
            case 398507100:
                if (name.equals("java.lang.Byte")) {
                    return Byte.TYPE;
                }
                return null;
            case 398795216:
                if (name.equals("java.lang.Long")) {
                    return Long.TYPE;
                }
                return null;
            case 399092968:
                if (name.equals("java.lang.Void")) {
                    return Void.TYPE;
                }
                return null;
            case 761287205:
                if (name.equals("java.lang.Double")) {
                    return Double.TYPE;
                }
                return null;
            default:
                return null;
        }
    }

    @InterfaceC1231JvmName(m6260name = "getKotlinClass")
    public static final <T> InterfaceC1242KClass<T> getKotlinClass(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Reflection.getOrCreateKotlinClass(cls);
    }

    @InterfaceC1231JvmName(m6260name = "getRuntimeClassOfKClassInstance")
    public static final <T> Class<InterfaceC1242KClass<T>> getRuntimeClassOfKClassInstance(InterfaceC1242KClass<T> interfaceC1242KClass) {
        Intrinsics.checkNotNullParameter(interfaceC1242KClass, "<this>");
        Class<InterfaceC1242KClass<T>> cls = (Class<InterfaceC1242KClass<T>>) interfaceC1242KClass.getClass();
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", m5048imports = {}))
    public static /* synthetic */ void getRuntimeClassOfKClassInstance$annotations(InterfaceC1242KClass interfaceC1242KClass) {
    }

    public static final /* synthetic */ boolean isArrayOf(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return Object.class.isAssignableFrom(objArr.getClass().getComponentType());
    }

    public static final <T> Class<T> getJavaClass(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Class<T> cls = (Class<T>) t.getClass();
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }
}
