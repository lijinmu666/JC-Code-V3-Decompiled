package p094kotlin.p113reflect;

import java.util.Collection;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;

@Metadata(m4987d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\"\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H§\u0080\u0004b\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001eJ\u0014\u0010H\u001a\u00020\u001a2\b\u0010I\u001a\u0004\u0018\u00010\u0002H¦\u0082\u0004J\n\u0010J\u001a\u00020KH¦\u0080\u0004R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001d\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\rX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\rX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\u0016\u001a\u0004\u0018\u00018\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R/\u0010&\u001a\b\u0012\u0004\u0012\u00020'0 8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b(\u0010#\u001a\u0004\b)\u0010%R7\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000 8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(-¢\u0006\f\u0012\u0004\b+\u0010#\u001a\u0004\b,\u0010%R+\u0010.\u001a\u0004\u0018\u00010/8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b0\u0010#\u001a\u0004\b1\u00102R)\u00103\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b4\u0010#\u001a\u0004\b3\u00105R)\u00106\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b7\u0010#\u001a\u0004\b6\u00105R)\u00108\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b9\u0010#\u001a\u0004\b8\u00105R)\u0010:\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b;\u0010#\u001a\u0004\b:\u00105R)\u0010<\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b=\u0010#\u001a\u0004\b<\u00105R)\u0010>\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b?\u0010#\u001a\u0004\b>\u00105R)\u0010@\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\bA\u0010#\u001a\u0004\b@\u00105R)\u0010B\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(D¢\u0006\f\u0012\u0004\bC\u0010#\u001a\u0004\bB\u00105R)\u0010E\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(G¢\u0006\f\u0012\u0004\bF\u0010#\u001a\u0004\bE\u00105¨\u0006L"}, m4988d2 = {"Lkotlin/reflect/KClass;", "T", BuildConfig.f24315FLAVOR, "Lkotlin/reflect/KDeclarationContainer;", "Lkotlin/reflect/KAnnotatedElement;", "Lkotlin/reflect/KClassifier;", "simpleName", BuildConfig.f24315FLAVOR, "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", BuildConfig.f24315FLAVOR, "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", BuildConfig.f24315FLAVOR, "value", "Lkotlin/SinceKotlin;", "version", "1.1", "typeParameters", BuildConfig.f24315FLAVOR, "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "()Ljava/util/List;", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "1.3", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "1.4", "isValue", "isValue$annotations", "1.5", "equals", "other", "hashCode", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* renamed from: kotlin.reflect.KClass */
/* loaded from: classes.dex */
public interface InterfaceC1242KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.reflect.KClass$DefaultImpls */
    public static final class DefaultImpls {
        @SinceKotlin(m5061version = "1.3")
        public static /* synthetic */ void getSealedSubclasses$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void getSupertypes$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void getTypeParameters$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void getVisibility$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isAbstract$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isCompanion$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isData$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isFinal$annotations() {
        }

        @SinceKotlin(m5061version = "1.4")
        public static /* synthetic */ void isFun$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isInner$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isOpen$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isSealed$annotations() {
        }

        @SinceKotlin(m5061version = "1.5")
        public static /* synthetic */ void isValue$annotations() {
        }
    }

    /* renamed from: equals */
    boolean mo6298equals(Object other);

    Collection<KFunction<T>> getConstructors();

    @Override // p094kotlin.p113reflect.KDeclarationContainer
    Collection<KCallable<?>> getMembers();

    Collection<InterfaceC1242KClass<?>> getNestedClasses();

    T getObjectInstance();

    String getQualifiedName();

    List<InterfaceC1242KClass<? extends T>> getSealedSubclasses();

    String getSimpleName();

    List<InterfaceC1252KType> getSupertypes();

    List<KTypeParameter> getTypeParameters();

    KVisibility getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    /* renamed from: isData */
    boolean mo6299isData();

    /* renamed from: isFinal */
    boolean mo6300isFinal();

    /* renamed from: isFun */
    boolean mo6301isFun();

    /* renamed from: isInner */
    boolean mo6302isInner();

    @SinceKotlin(m5061version = "1.1")
    boolean isInstance(Object value);

    /* renamed from: isOpen */
    boolean mo6303isOpen();

    boolean isSealed();

    /* renamed from: isValue */
    boolean mo6304isValue();
}
