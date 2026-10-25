package p094kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.conscrypt.BuildConfig;
import p094kotlin.annotation.AnnotationTarget;
import p094kotlin.annotation.InterfaceC1134Target;
import p094kotlin.annotation.MustBeDocumented;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@MustBeDocumented
@Metadata(m4987d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B@\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\b\u0002\u0010\u0004\u001a\u00020\u0005B\u0018\b\u000bB\u0014\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\b\b\u0012\u0002\b\f\u0012\u0010\b\u0002\u0010\t\u001a\u00020\nB\u0006\b\n0\n8\u000bR\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\t\u001a\u00020\nX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\u000eÊ\u0001J\b\u0010\u0012F\b\u0011\u0012B\b\fJ\u0006\b\n0\u00128\u0013J\u0006\b\n0\u00128\u0014J\u0006\b\n0\u00128\u0015J\u0006\b\n0\u00128\u0016J\u0006\b\n0\u00128\u0017J\u0006\b\n0\u00128\u0018J\u0006\b\n0\u00128\u0019J\u0006\b\n0\u00128\u001aÊ\u0001\u0002\b\u001b¨\u0006\u000f"}, m4988d2 = {"Lkotlin/Deprecated;", BuildConfig.f24315FLAVOR, "message", BuildConfig.f24315FLAVOR, "replaceWith", "Lkotlin/ReplaceWith;", "expression", BuildConfig.f24315FLAVOR, "imports", "level", "Lkotlin/DeprecationLevel;", "WARNING", "()Ljava/lang/String;", "()Lkotlin/ReplaceWith;", "()Lkotlin/DeprecationLevel;", "kotlin-stdlib", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "CLASS", "FUNCTION", "PROPERTY", "ANNOTATION_CLASS", "CONSTRUCTOR", "PROPERTY_SETTER", "PROPERTY_GETTER", "TYPEALIAS", "Lkotlin/annotation/MustBeDocumented;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.f4927CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface Deprecated {
    /* renamed from: level */
    DeprecationLevel m4971level() default DeprecationLevel.f4882WARNING;

    /* renamed from: message */
    String m4972message();

    ReplaceWith replaceWith() default @ReplaceWith(expression = "", m5048imports = {});
}
