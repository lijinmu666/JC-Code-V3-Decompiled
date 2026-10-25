package p094kotlin.p105jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.SinceKotlin;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.JvmClassMappingKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.TypeReference;
import p094kotlin.p113reflect.InterfaceC1242KClass;
import p094kotlin.p113reflect.InterfaceC1252KType;
import p094kotlin.p113reflect.KClassifier;
import p094kotlin.p113reflect.KTypeProjection;
import p094kotlin.p113reflect.KVariance;

@SinceKotlin(m5061version = "1.4")
@Metadata(m4987d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B?\bG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u001a\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\n\u0010\u000bB'\bV\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\n\u0010\u0011J\u0014\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0082\u0004J\n\u0010$\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010%\u001a\u00020&H\u0096\u0080\u0004J\u0012\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0010H\u0082\u0080\u0004J\u000e\u0010'\u001a\u00020&*\u00020\u0006H\u0082\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0084\br\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R+\u0010\b\u001a\u00020\t8\u0000X\u0081\u0084\br\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00058VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0015\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010 R\u001d\u0010)\u001a\u00020&*\u0006\u0012\u0002\b\u00030*8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b+\u0010,Ê\u0001\f\b\f\u0012\b\b\r\u0012\u0004\b\b(/¨\u0006."}, m4988d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", BuildConfig.f24315FLAVOR, "Lkotlin/reflect/KTypeProjection;", "platformTypeUpperBound", "flags", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "Lkotlin/SinceKotlin;", "version", "1.6", "isMarkedNullable", BuildConfig.f24315FLAVOR, "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getArguments", "()Ljava/util/List;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "getFlags$kotlin_stdlib$annotations", "getFlags$kotlin_stdlib", "()I", "annotations", BuildConfig.f24315FLAVOR, "getAnnotations", "()Z", "equals", "other", BuildConfig.f24315FLAVOR, "hashCode", "toString", BuildConfig.f24315FLAVOR, "asString", "convertPrimitiveToWrapper", "arrayClassName", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "Companion", "kotlin-stdlib", "1.4"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class TypeReference implements InterfaceC1252KType {
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final int flags;
    private final InterfaceC1252KType platformTypeUpperBound;

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.m6544values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[KVariance.f5272IN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[KVariance.f5273OUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @SinceKotlin(m5061version = "1.6")
    public TypeReference(KClassifier classifier, List<KTypeProjection> arguments, InterfaceC1252KType interfaceC1252KType, int i) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        this.classifier = classifier;
        this.arguments = arguments;
        this.platformTypeUpperBound = interfaceC1252KType;
        this.flags = i;
    }

    private final String asString(boolean convertPrimitiveToWrapper) {
        KClassifier classifier = getClassifier();
        InterfaceC1242KClass interfaceC1242KClass = classifier instanceof InterfaceC1242KClass ? (InterfaceC1242KClass) classifier : null;
        Class<?> javaClass = interfaceC1242KClass != null ? JvmClassMappingKt.getJavaClass(interfaceC1242KClass) : null;
        String string = javaClass == null ? getClassifier().toString() : (this.flags & 4) != 0 ? "kotlin.Nothing" : javaClass.isArray() ? getArrayClassName(javaClass) : (convertPrimitiveToWrapper && javaClass.isPrimitive()) ? JvmClassMappingKt.getJavaObjectType((InterfaceC1242KClass) getClassifier()).getName() : javaClass.getName();
        boolean zIsEmpty = getArguments().isEmpty();
        String str = BuildConfig.f24315FLAVOR;
        String strJoinToString$default = zIsEmpty ? BuildConfig.f24315FLAVOR : CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new Function1() { // from class: o.l9
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return TypeReference.asString$lambda$0(this.f14675mjFkc, (KTypeProjection) obj);
            }
        }, 24, null);
        if (isMarkedNullable()) {
            str = "?";
        }
        String str2 = string + strJoinToString$default + str;
        InterfaceC1252KType interfaceC1252KType = this.platformTypeUpperBound;
        if (!(interfaceC1252KType instanceof TypeReference)) {
            return str2;
        }
        String strAsString = ((TypeReference) interfaceC1252KType).asString(true);
        if (Intrinsics.areEqual(strAsString, str2)) {
            return str2;
        }
        if (Intrinsics.areEqual(strAsString, str2 + '?')) {
            return str2 + '!';
        }
        return '(' + str2 + ".." + strAsString + ')';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CharSequence asString$lambda$0(TypeReference typeReference, KTypeProjection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return typeReference.asString(it);
    }

    private final String getArrayClassName(Class<?> cls) {
        return Intrinsics.areEqual(cls, boolean[].class) ? "kotlin.BooleanArray" : Intrinsics.areEqual(cls, char[].class) ? "kotlin.CharArray" : Intrinsics.areEqual(cls, byte[].class) ? "kotlin.ByteArray" : Intrinsics.areEqual(cls, short[].class) ? "kotlin.ShortArray" : Intrinsics.areEqual(cls, int[].class) ? "kotlin.IntArray" : Intrinsics.areEqual(cls, float[].class) ? "kotlin.FloatArray" : Intrinsics.areEqual(cls, long[].class) ? "kotlin.LongArray" : Intrinsics.areEqual(cls, double[].class) ? "kotlin.DoubleArray" : "kotlin.Array";
    }

    @SinceKotlin(m5061version = "1.6")
    public static /* synthetic */ void getFlags$kotlin_stdlib$annotations() {
    }

    @SinceKotlin(m5061version = "1.6")
    public static /* synthetic */ void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    /* renamed from: equals */
    public boolean m6350equals(Object other) {
        if (other instanceof TypeReference) {
            TypeReference typeReference = (TypeReference) other;
            if (Intrinsics.areEqual(getClassifier(), typeReference.getClassifier()) && Intrinsics.areEqual(getArguments(), typeReference.getArguments()) && Intrinsics.areEqual(this.platformTypeUpperBound, typeReference.platformTypeUpperBound) && this.flags == typeReference.flags) {
                return true;
            }
        }
        return false;
    }

    @Override // p094kotlin.p113reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1252KType
    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // p094kotlin.p113reflect.InterfaceC1252KType
    public KClassifier getClassifier() {
        return this.classifier;
    }

    /* renamed from: getFlags$kotlin_stdlib, reason: from getter */
    public final int getFlags() {
        return this.flags;
    }

    /* renamed from: getPlatformTypeUpperBound$kotlin_stdlib, reason: from getter */
    public final InterfaceC1252KType getPlatformTypeUpperBound() {
        return this.platformTypeUpperBound;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Integer.hashCode(this.flags);
    }

    @Override // p094kotlin.p113reflect.InterfaceC1252KType
    public boolean isMarkedNullable() {
        return (this.flags & 1) != 0;
    }

    public String toString() {
        return asString(false) + " (Kotlin reflection is not available)";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TypeReference(KClassifier classifier, List<KTypeProjection> arguments, boolean z) {
        this(classifier, arguments, null, z ? 1 : 0);
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
    }

    private final String asString(KTypeProjection kTypeProjection) {
        String strValueOf;
        if (kTypeProjection.getVariance() == null) {
            return "*";
        }
        InterfaceC1252KType interfaceC1252KTypeM6540getType = kTypeProjection.m6540getType();
        TypeReference typeReference = interfaceC1252KTypeM6540getType instanceof TypeReference ? (TypeReference) interfaceC1252KTypeM6540getType : null;
        if (typeReference == null || (strValueOf = typeReference.asString(true)) == null) {
            strValueOf = String.valueOf(kTypeProjection.m6540getType());
        }
        int i = WhenMappings.$EnumSwitchMapping$0[kTypeProjection.getVariance().ordinal()];
        if (i == 1) {
            return strValueOf;
        }
        if (i == 2) {
            return "in " + strValueOf;
        }
        if (i == 3) {
            return "out " + strValueOf;
        }
        throw new NoWhenBranchMatchedException();
    }
}
