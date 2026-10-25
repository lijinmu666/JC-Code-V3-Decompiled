package p094kotlin.p113reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.conscrypt.BuildConfig;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.SinceKotlin;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p094kotlin.p105jvm.JvmClassMappingKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.KTypeBase;
import p094kotlin.p105jvm.internal.KTypeParameterBase;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p094kotlin.sequences.Sequence;
import p094kotlin.sequences.SequencesKt;

@Metadata(m4987d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0083\u0080\u0004b\u0002\b\n\u001a(\u0010\u000f\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0083\u0080\u0004b\u0002\b\n\u001a\u0012\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0082\u0080\u0004\"5\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tr\u0002\b\nr\u0002\b\u000b¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"#\u0010\u0000\u001a\u00020\u0001*\u00020\u00148BX\u0083\u0084\br\u0002\b\n¢\u0006\f\u0012\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016¨\u0006\u001a"}, m4988d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/SinceKotlin;", "version", "1.4", "Lkotlin/ExperimentalStdlibApi;", "Lkotlin/internal/LowPriorityInOverloadResolution;", "computeJavaType", "forceWrapper", BuildConfig.f24315FLAVOR, "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", BuildConfig.f24315FLAVOR, "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "typeToString", BuildConfig.f24315FLAVOR, "type", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,244:1\n1#2:245\n3054#3,12:246\n1739#4:258\n1814#4,3:259\n1739#4:262\n1814#4,3:263\n1739#4:266\n1814#4,3:267\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/TypesJVMKt\n*L\n42#1:246,12\n73#1:258\n73#1:259,3\n75#1:262\n75#1:263,3\n81#1:266\n81#1:267,3\n*E\n"})
/* loaded from: classes.dex */
public final class TypesJVMKt {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.m6544values().length];
            try {
                iArr[KVariance.f5272IN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.f5273OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @ExperimentalStdlibApi
    public static final Type computeJavaType(InterfaceC1252KType interfaceC1252KType, boolean z) {
        KClassifier classifier = interfaceC1252KType.getClassifier();
        TypeVariable<?> typeVariable = null;
        if (classifier instanceof KTypeParameter) {
            if (!(classifier instanceof KTypeParameterBase)) {
                return new ObsoleteFallbackTypeVariableImpl((KTypeParameter) classifier);
            }
            KTypeParameterBase kTypeParameterBase = (KTypeParameterBase) classifier;
            GenericDeclaration javaContainingDeclaration$kotlin_stdlib = kTypeParameterBase.getJavaContainingDeclaration$kotlin_stdlib();
            if (javaContainingDeclaration$kotlin_stdlib == null) {
                throw new UnsupportedOperationException("javaType is not supported for this type: " + interfaceC1252KType);
            }
            TypeVariable<?>[] typeParameters = javaContainingDeclaration$kotlin_stdlib.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            boolean z2 = false;
            for (TypeVariable<?> typeVariable2 : typeParameters) {
                if (Intrinsics.areEqual(typeVariable2.getName(), kTypeParameterBase.mo6348getName())) {
                    if (z2) {
                        throw new IllegalArgumentException("Array contains more than one matching element.");
                    }
                    z2 = true;
                    typeVariable = typeVariable2;
                }
            }
            if (!z2) {
                throw new NoSuchElementException("Array contains no element matching the predicate.");
            }
            Intrinsics.checkNotNullExpressionValue(typeVariable, "single(...)");
            return typeVariable;
        }
        if (!(classifier instanceof InterfaceC1242KClass)) {
            throw new UnsupportedOperationException("Unsupported type classifier: " + interfaceC1252KType);
        }
        InterfaceC1242KClass interfaceC1242KClass = (InterfaceC1242KClass) classifier;
        Class javaObjectType = z ? JvmClassMappingKt.getJavaObjectType(interfaceC1242KClass) : JvmClassMappingKt.getJavaClass(interfaceC1242KClass);
        List<KTypeProjection> arguments = interfaceC1252KType.getArguments();
        if (arguments.isEmpty()) {
            return javaObjectType;
        }
        if (!javaObjectType.isArray()) {
            return createPossiblyInnerType(javaObjectType, arguments);
        }
        if (javaObjectType.getComponentType().isPrimitive()) {
            return javaObjectType;
        }
        KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.singleOrNull((List) arguments);
        if (kTypeProjection == null) {
            throw new IllegalArgumentException("kotlin.Array must have exactly one type argument: " + interfaceC1252KType);
        }
        KVariance variance = kTypeProjection.getVariance();
        InterfaceC1252KType type = kTypeProjection.getType();
        int i = variance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == -1 || i == 1) {
            return javaObjectType;
        }
        if (i != 2 && i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNull(type);
        Type typeComputeJavaType$default = computeJavaType$default(type, false, 1, null);
        return typeComputeJavaType$default instanceof Class ? javaObjectType : new GenericArrayTypeImpl(typeComputeJavaType$default);
    }

    public static /* synthetic */ Type computeJavaType$default(InterfaceC1252KType interfaceC1252KType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return computeJavaType(interfaceC1252KType, z);
    }

    @ExperimentalStdlibApi
    private static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getJavaType((KTypeProjection) it.next()));
            }
            return new ParameterizedTypeImpl(cls, null, arrayList);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList2.add(getJavaType((KTypeProjection) it2.next()));
            }
            return new ParameterizedTypeImpl(cls, declaringClass, arrayList2);
        }
        int length = cls.getTypeParameters().length;
        Type typeCreatePossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(length, list.size()));
        List<KTypeProjection> listSubList = list.subList(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSubList, 10));
        Iterator<T> it3 = listSubList.iterator();
        while (it3.hasNext()) {
            arrayList3.add(getJavaType((KTypeProjection) it3.next()));
        }
        return new ParameterizedTypeImpl(cls, typeCreatePossiblyInnerType, arrayList3);
    }

    public static final Type getJavaType(InterfaceC1252KType interfaceC1252KType) {
        Type javaType;
        Intrinsics.checkNotNullParameter(interfaceC1252KType, "<this>");
        return (!(interfaceC1252KType instanceof KTypeBase) || (javaType = ((KTypeBase) interfaceC1252KType).getJavaType()) == null) ? computeJavaType$default(interfaceC1252KType, false, 1, null) : javaType;
    }

    @LowPriorityInOverloadResolution
    @SinceKotlin(m5061version = "1.4")
    @ExperimentalStdlibApi
    public static /* synthetic */ void getJavaType$annotations(InterfaceC1252KType interfaceC1252KType) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String typeToString(Type type) {
        if (!(type instanceof Class)) {
            return type.toString();
        }
        Class cls = (Class) type;
        if (!cls.isArray()) {
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }
        Sequence sequenceGenerateSequence = SequencesKt.generateSequence(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
        return ((Class) SequencesKt.m6607last(sequenceGenerateSequence)).getName() + StringsKt.m6755repeat("[]", SequencesKt.m6593count(sequenceGenerateSequence));
    }

    @ExperimentalStdlibApi
    private static /* synthetic */ void getJavaType$annotations(KTypeProjection kTypeProjection) {
    }

    private static final Type getJavaType(KTypeProjection kTypeProjection) {
        KVariance variance = kTypeProjection.getVariance();
        if (variance == null) {
            return WildcardTypeImpl.Companion.m6552getSTAR();
        }
        InterfaceC1252KType interfaceC1252KTypeM6540getType = kTypeProjection.m6540getType();
        Intrinsics.checkNotNull(interfaceC1252KTypeM6540getType);
        int i = WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        if (i == 1) {
            return new WildcardTypeImpl(null, computeJavaType(interfaceC1252KTypeM6540getType, true));
        }
        if (i == 2) {
            return computeJavaType(interfaceC1252KTypeM6540getType, true);
        }
        if (i == 3) {
            return new WildcardTypeImpl(computeJavaType(interfaceC1252KTypeM6540getType, true), null);
        }
        throw new NoWhenBranchMatchedException();
    }
}
